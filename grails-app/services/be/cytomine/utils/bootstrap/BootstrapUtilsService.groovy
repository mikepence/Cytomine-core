package be.cytomine.utils.bootstrap

/*
* Copyright (c) 2009-2017. Authors: see NOTICE file.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

import be.cytomine.Exception.InvalidRequestException
import be.cytomine.Exception.WrongArgumentException
import be.cytomine.image.AbstractImage
import be.cytomine.image.ImageInstance
import be.cytomine.image.Mime
import be.cytomine.image.UploadedFile
import be.cytomine.image.server.*
import be.cytomine.middleware.AmqpQueue
import be.cytomine.middleware.MessageBrokerServer
import be.cytomine.ontology.Property
import be.cytomine.ontology.Relation
import be.cytomine.ontology.RelationTerm
import be.cytomine.processing.Software
import be.cytomine.security.*
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.util.Environment
import groovy.json.JsonBuilder

/**
 * Cytomine @ GIGA-ULG
 * User: stevben
 * Date: 13/03/13
 * Time: 11:59
 */
class BootstrapUtilsService {

    def cytomineService
    def sessionFactory
    def propertyInstanceMap = org.codehaus.groovy.grails.plugins.DomainClassGrailsPlugin.PROPERTY_INSTANCE_MAP
    def grailsApplication
    def dataSource
    def amqpQueueService
    def amqpQueueConfigService
    def rabbitConnectionService
    def storageService


    public def createUsers(def usersSamples) {

        SecRole.findByAuthority("ROLE_USER") ?: new SecRole(authority: "ROLE_USER").save(flush: true)
        SecRole.findByAuthority("ROLE_ADMIN") ?: new SecRole(authority: "ROLE_ADMIN").save(flush: true)
        SecRole.findByAuthority("ROLE_SUPER_ADMIN") ?: new SecRole(authority: "ROLE_SUPER_ADMIN").save(flush: true)
        SecRole.findByAuthority("ROLE_GUEST") ?: new SecRole(authority: "ROLE_GUEST").save(flush: true)

        def usersCreated = []
        usersSamples.each { item ->
            User user = User.findByUsername(item.username)
            if (user)  return
            user = new User(
                    username: item.username,
                    firstname: item.firstname,
                    lastname: item.lastname,
                    email: item.email,
                    color: item.color,
                    password: item.password,
                    enabled: true)
            user.generateKeys()


            log.info "Before validating ${user.username}..."
            if (user.validate()) {
                log.info "Creating user ${user.username}..."

                try {
                    user.save(flush: true)
                } catch(Exception e) {
                    log.info e
                }
                log.info "Save ${user.username}..."

                usersCreated << user

                /* Add Roles */
                item.roles.each { authority ->
                    log.info "Add SecRole " + authority + " for user " + user.username
                    SecRole secRole = SecRole.findByAuthority(authority)
                    if (secRole) SecUserSecRole.create(user, secRole)
                }
            } else {
                log.info("\n\n\n Errors in account boostrap for ${item.username}!\n\n\n")
                user.errors.each {
                    err -> log.info(err)
                }
            }
        }

        SpringSecurityUtils.reauthenticate "admin", null

        usersCreated.each { user ->
            /*Create Storage*/
            storageService.initUserStorage(user)
        }
        return usersCreated
    }

    public def createGroups(groupsSamples) {
        groupsSamples.each { item ->
            if (Group.findByName(item.name)) return
            def group = new Group(name: item.name)
            if (group.validate()) {
                log.info("Creating group ${group.name}...")
                group.save(flush: true)
                log.info("Creating group ${group.name}... OK")
            }
            else {
                log.info("\n\n\n Errors in group boostrap for ${item.name}!\n\n\n")
                group.errors.each {
                    err -> log.info err
                }
            }
        }
    }

    public def createRelation() {
        def relationSamples = [
                [name: RelationTerm.names.PARENT],
                [name: RelationTerm.names.SYNONYM]
        ]

        log.info("createRelation")
        relationSamples.each { item ->
            if (Relation.findByName(item.name)) return
            def relation = new Relation(name: item.name)
            log.info("create relation=" + relation.name)

            if (relation.validate()) {
                log.info("Creating relation : ${relation.name}...")
                relation.save(flush: true)

            } else {
                log.info("\n\n\n Errors in account boostrap for ${item.name}!\n\n\n")
                relation.errors.each {
                    err -> log.info err
                }

            }
        }
    }

    public def createImageServers(def imageServersSamples) {
        imageServersSamples.each {
            ImageServer imageServer = new ImageServer(
                    className: it.className,
                    name: it.name,
                    service : it.service,
                    url : it.url,
                    available : it.available
            )

            if (imageServer.validate()) {
                imageServer.save()
            } else {
                imageServer.errors?.each {
                    log.info it
                }
            }

        }

    }

    public def createMimes(def mimeSamples) {
        mimeSamples.each {
            if(!Mime.findByMimeType(it.mimeType)) {
                Mime mime = new Mime(extension : it.extension, mimeType: it.mimeType)
                if (mime.validate()) {
                    mime.save(flush:true)
                } else {
                    mime.errors?.each {
                        log.info it
                    }
                }
            }

        }
    }

    public def createMimeImageServers(def imageServerCollection, def mimeCollection) {
        log.info imageServerCollection
        log.info ImageServer.list().collect {it.url}
        imageServerCollection.each {
            ImageServer imageServer = ImageServer.findByName(it.name)
            if (imageServer) {
                mimeCollection.each {
                    Mime mime = Mime.findByMimeType(it.mimeType)
                    if (mime) {
                        new MimeImageServer(
                                mime : mime,
                                imageServer: imageServer
                        ).save()
                    }
                }
            }
        }
    }

    def saveDomain(def newObject, boolean flush = true) {
        if (!newObject.validate()) {
            log.error newObject.errors
            log.error newObject.retrieveErrors().toString()
            throw new WrongArgumentException(newObject.retrieveErrors().toString())
        }
        if (!newObject.save(flush: flush)) {
            throw new InvalidRequestException(newObject.retrieveErrors().toString())
        }
    }

    def addMimePyrTiff() {
        def mimeSamples = [
                [extension : 'tif', mimeType : 'image/pyrtiff']
        ]
        createMimes(mimeSamples)
        createMimeImageServers(ImageServer.findAll(), mimeSamples)
    }

    def addMimeVentanaTiff() {
        def mimeSamples = [
                [extension : 'tif', mimeType : 'openslide/ventana']
        ]
        createMimes(mimeSamples)
        createMimeImageServers(ImageServer.findAll(), mimeSamples)
    }

    def addMimePhilipsTiff() {
        def mimeSamples = [
                [extension : 'tif', mimeType : 'philips/tif']
        ]
        createMimes(mimeSamples)
        createMimeImageServers(ImageServer.findAll(), mimeSamples)
    }

    def createMultipleRetrieval() {
        RetrievalServer.list().each { server ->
            if(!grailsApplication.config.grails.retrievalServerURL.contains(server.url)) {
                log.info server.url + " is not in config, drop it"
                log.info "delete Retrieval $server"
                server.delete()
            }

        }
        grailsApplication.config.grails.retrievalServerURL.eachWithIndex { it, index ->

            if(!RetrievalServer.findByUrl(it)) {
                RetrievalServer server =
                        new RetrievalServer(
                                description:"retrieval $index",
                                url:"${it}",
                                path:'/retrieval-web/api/resource.json',
                                username: grailsApplication.config.grails.retrievalUsername,
                                password: grailsApplication.config.grails.retrievalPassword
                        )
                if (server.validate()) {
                    server.save()
                } else {
                    server.errors?.each {
                        log.info it
                    }
                }
            }

        }
    }

    def createMessageBrokerServer() {
        MessageBrokerServer.list().each { messageBroker ->
            if(!grailsApplication.config.grails.messageBrokerServerURL.contains(messageBroker.host)) {
                log.info messageBroker.host + "is not in config, drop it"
                log.info "delete Message Broker Server " + messageBroker
                messageBroker.delete()
            }
        }

        String messageBrokerURL = grailsApplication.config.grails.messageBrokerServerURL
        def splittedURL = messageBrokerURL.split(':')

        if(!MessageBrokerServer.findByHost(splittedURL[0])) {
            MessageBrokerServer mbs = new MessageBrokerServer(name: "MessageBrokerServer", host: splittedURL[0], port: splittedURL[1].toInteger())
            if (mbs.validate()) {
                mbs.save()
            } else {
                mbs.errors?.each {
                    log.info it
                }
            }
        }
        MessageBrokerServer.findByHost(splittedURL[0])
    }

    def createMultipleIS() {

        ImageServer.list().each { server ->
            if(!grailsApplication.config.grails.imageServerURL.contains(server.url)) {
                log.info server.url + " is not in config, drop it"
                MimeImageServer.findAllByImageServer(server).each {
                    log.info "delete $it"
                    it.delete()
                }

                ImageServerStorage.findAllByImageServer(server).each {
                    log.info "delete $it"
                    it.delete()
                }
                log.info "delete IS $server"
                server.delete()
            }

        }



        grailsApplication.config.grails.imageServerURL.eachWithIndex { it, index ->
            createNewIS(index+"",it)
        }
    }


    def createNewIS(String name = "", String url) {

        if(!ImageServer.findByUrl(url)) {
            log.info "Create new IMS: $url"
            def IIPImageServer = [className : 'IIPResolver', name : 'IIP'+name, service : '/image/tile', url : url, available : true]
            ImageServer imageServer = new ImageServer(
                    className: IIPImageServer.className,
                    name: IIPImageServer.name,
                    service : IIPImageServer.service,
                    url : IIPImageServer.url,
                    available : IIPImageServer.available
            )

            if (imageServer.validate()) {
                imageServer.save()
            } else {
                imageServer.errors?.each {
                    log.info it
                }
            }

            Storage.list().each {
                new ImageServerStorage(
                        storage : it,
                        imageServer: imageServer
                ).save()
            }

            Mime.list().each {
                new MimeImageServer(
                        mime : it,
                        imageServer: imageServer
                ).save()
            }
        }
    }

    def transfertProperty() {
        SpringSecurityUtils.doWithAuth("admin", {
            def ips = ImageProperty.list()
            ips.eachWithIndex { ip,index ->
                ip.attach()
                Property property = new Property(domainIdent: ip.image.id, domainClassName: AbstractImage.class.name,key:ip.key,value:ip.value)
                property.save(failOnError: true)
                ip.delete()
                if(index%500==0) {
                    log.info "Image property ${(index/ips.size())*100}"
                    cleanUpGorm()
                }
            }
        })
    }

    def checkImages2() {
        SpringSecurityUtils.doWithAuth("admin", {
            def uploadedFiles = UploadedFile.findAllByPathLike("notfound").plus(UploadedFile.findAllByPathLike("/tmp/cytomine_buffer/")).plus(UploadedFile.findAllByPathLike("/tmp/imageserver_buffer"))

            uploadedFiles.eachWithIndex { uploadedFile,index->
                if(index%1==0) {
                    log.info "Check ${(index/uploadedFiles.size())*100}"
                    cleanUpGorm()
                }

                uploadedFile.attach()
                AbstractImage abstractImage = uploadedFile.image
                if (!abstractImage) { //
                    UploadedFile parentUploadedFile = uploadedFile
                    int max = 10
                    while (parentUploadedFile.parent && !abstractImage && max <10) {
                        parentUploadedFile.attach()
                        parentUploadedFile.parent.attach()
                        parentUploadedFile = parentUploadedFile.parent
                        abstractImage = parentUploadedFile.image
                        max++
                    }
                }
                if (abstractImage) {
                    def data = StorageAbstractImage.findByAbstractImage(abstractImage)
                    if(data) {
                        Storage storage = data.storage
                        uploadedFile.path = storage.getBasePath()
                        uploadedFile = uploadedFile.save()
                    }
                } else {
                    log.error "DID NOT FIND AN ABSTRACT_IMAGE for uploadedFile $uploadedFile"
                }
            }
        })

    }

    def checkImages() {
        SpringSecurityUtils.doWithAuth("admin", {
            def currentUser = cytomineService.getCurrentUser()

            List<AbstractImage> ok = []
            List<AbstractImage> notok = []
            def list = AbstractImage.findAll()
            list.eachWithIndex { abstractImage,index->
                if(index%500==0) {
                    log.info "Check ${(index/list.size())*100}"
                    cleanUpGorm()
                }

                if (UploadedFile.findByImage(abstractImage)) {
                    ok << abstractImage
                } else {
                    notok << abstractImage
                }
            }

            notok.eachWithIndex { abstractImage, index ->
                abstractImage.attach()
                UploadedFile uploadedFile = UploadedFile.findByFilename(abstractImage.filename)
                SecUser user = abstractImage.user ? abstractImage.user : currentUser
                if (!uploadedFile) {
                    def imageServerStorage = abstractImage.imageServersStorage
                    uploadedFile = new UploadedFile(
                            user : user,
                            filename : abstractImage.getPath(),
                            projects: ImageInstance.findAllByBaseImage(abstractImage).collect { it.project.id}.unique(),
                            storages : abstractImage.getImageServersStorage().collect { it.storage.id},
                            originalFilename: abstractImage.getOriginalFilename(),
                            ext: abstractImage.mime.extension,
                            size : 0,
                            path : (imageServerStorage.isEmpty()? "notfound" : imageServerStorage.first().storage.getBasePath()),
                            contentType: abstractImage.mimeType)

                    if (uploadedFile.validate()) {
                        uploadedFile = uploadedFile.save()
                    } else {
                        uploadedFile.errors.each {
                            log.info it
                        }
                    }

                }

                uploadedFile.image = abstractImage
                uploadedFile.save()
                if(index%100==0) {
                    log.info "Create upload ${(index/notok.size())*100}"
                    cleanUpGorm()
                }
            }

        })
    }

    void convertMimeTypes(){
        SpringSecurityUtils.doWithAuth("admin", {

            Mime oldTif = Mime.findByMimeType("image/tif");
            Mime oldTiff = Mime.findByMimeType("image/tiff");
            Mime newTiff = Mime.findByMimeType("image/pyrtiff");

            List<AbstractImage> abstractImages = AbstractImage.findAllByMimeInList([oldTif, oldTiff]);
            log.info "images to convert : "+abstractImages.size()

            abstractImages.each {
                it.mime = newTiff;
                it.save();
            }
        })
    }

    void initRabbitMq() {
        log.info "init amqp service..."
        amqpQueueService.initialize()

        log.info "init RabbitMQ connection..."
        MessageBrokerServer mbs = createMessageBrokerServer()
        // Initialize default configurations for amqp queues
        amqpQueueConfigService.initAmqpQueueConfigDefaultValues()
        // Initialize RabbitMQ queue to communicate software added

        if(!AmqpQueue.findByName("queueCommunication")) {
            AmqpQueue queueCommunication = new AmqpQueue(name: "queueCommunication", host: mbs.host, exchange: "exchangeCommunication")
            queueCommunication.save(failOnError: true, flush: true)
            amqpQueueService.createAmqpQueueDefault(queueCommunication)
        }
        else if(!amqpQueueService.checkRabbitQueueExists("queueCommunication",mbs)) {
            AmqpQueue queueCommunication = amqpQueueService.read("queueCommunication")
            amqpQueueService.createAmqpQueueDefault(queueCommunication)
        }
        Software.list().each {
            String queueName = amqpQueueService.queuePrefixSoftware + ((it as Software).name).capitalize()
            if(!amqpQueueService.checkAmqpQueueDomainExists(queueName)) {
                String exchangeName = amqpQueueService.exchangePrefixSoftware + ((it as Software).name).capitalize()
                String brokerServerURL = (MessageBrokerServer.findByName("MessageBrokerServer")).host
                AmqpQueue aq = new AmqpQueue(name: queueName, host: brokerServerURL, exchange: exchangeName)
                aq.save(failOnError: true)
            }
            if(!amqpQueueService.checkRabbitQueueExists(queueName,mbs)) {
                AmqpQueue aq = amqpQueueService.read(queueName)

                // Creates the queue on the rabbit server
                amqpQueueService.createAmqpQueueDefault(aq)

                // Notify the queueCommunication that a software has been added
                def mapInfosQueue = [name: aq.name, host: aq.host, exchange: aq.exchange]
                JsonBuilder builder = new JsonBuilder()
                builder(mapInfosQueue)
                amqpQueueService.publishMessage(AmqpQueue.findByName("queueCommunication"), builder.toString())
            }
        }

        //Inserting a MessageBrokerServer for testing purpose
        if (Environment.getCurrent() == Environment.TEST) {
            rabbitConnectionService.getRabbitConnection(mbs)
        }
    }

    public void cleanUpGorm() {
        def session = sessionFactory.currentSession
        session.flush()
        session.clear()
        propertyInstanceMap.get().clear()
    }
}
