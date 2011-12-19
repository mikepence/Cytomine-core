package be.cytomine.test.http

import be.cytomine.ontology.Annotation
import be.cytomine.security.User
import be.cytomine.test.BasicInstance
import be.cytomine.test.HttpClient
import be.cytomine.test.Infos
import com.vividsolutions.jts.io.WKTReader
import grails.converters.JSON
import org.apache.commons.logging.LogFactory
import be.cytomine.ontology.AnnotationTerm
import be.cytomine.project.Project
import be.cytomine.image.ImageInstance

/**
 * User: lrollus
 * Date: 6/12/11
 * GIGA-ULg
 *
 */
class AnnotationTermAPI extends DomainAPI {

    private static final log = LogFactory.getLog(this)


    static def buildBasicAnnotation(String username, String password) {
        //Create project with user 1
        def result = ProjectAPI.createProject(BasicInstance.getBasicProjectNotExist(), username, password)
        assert 200==result.code
        Project project = result.data

        //Add image with user 1
        ImageInstance image = BasicInstance.getBasicImageInstanceNotExist()
        image.project = project
        result = ImageInstanceAPI.createImageInstance(image, username, password)
        assert 200==result.code
        image = result.data

        //Add annotation 1 with cytomine admin
        Annotation annotation = BasicInstance.getBasicAnnotationNotExist()
        annotation.image = image
        annotation.project = image.project
        result = AnnotationAPI.createAnnotation(annotation, username, password)
        assert 200==result.code
        annotation = result.data
        return annotation
    }

    static def showAnnotationTerm(Long idAnnotation,Long idTerm, Long idUser,String username, String password) {
        String URL = Infos.CYTOMINEURL + "api/annotation/" + idAnnotation + "/term/"+ idTerm +"/user/"+idUser+".json"
        HttpClient client = new HttpClient();
        client.connect(URL, username, password);
        client.get()
        int code = client.getResponseCode()
        String response = client.getResponseData()
        client.disconnect();
        return [data: response, code: code]
    }

    static def listAnnotationTermByAnnotation(Long idAnnotation,String username, String password) {
        log.info("list annotation-term")
        String URL = Infos.CYTOMINEURL+"api/annotation/"+idAnnotation+"/term.json"
        HttpClient client = new HttpClient();
        client.connect(URL, username, password);
        client.get()
        int code = client.getResponseCode()
        String response = client.getResponseData()
        client.disconnect();
        return [data: response, code: code]
    }

    static def listAnnotationTermByTerm(Long idTerm, String username, String password) {
        log.info("list annotation-term")
        String URL = Infos.CYTOMINEURL+"api/term/"+idTerm+"/annotation.json"
        HttpClient client = new HttpClient();
        client.connect(URL, username, password);
        client.get()
        int code = client.getResponseCode()
        String response = client.getResponseData()
        client.disconnect();
        return [data: response, code: code]
    }

    static def createAnnotationTerm(AnnotationTerm annotationTermToAdd, User user) {
       createAnnotationTerm(annotationTermToAdd.encodeAsJSON(),user.username,user.password)
    }

    static def createAnnotationTerm(AnnotationTerm annotationTermToAdd, String username, String password) {
        return createAnnotationTerm(annotationTermToAdd.encodeAsJSON(), username, password)
    }

    static def createAnnotationTerm(String jsonAnnotationTerm, User user) {
        createAnnotationTerm(jsonAnnotationTerm,user.username,user.password)
    }

    static def createAnnotationTerm(String jsonAnnotationTerm, String username, String password) {
        log.info("post Annotation:" + jsonAnnotationTerm.replace("\n", ""))
        def json = JSON.parse(jsonAnnotationTerm);
        String URL = Infos.CYTOMINEURL+"api/annotation/"+ json.annotation +"/term/"+ json.term +".json"
        HttpClient client = new HttpClient()
        client.connect(URL, username, password)
        client.post(jsonAnnotationTerm)
        int code = client.getResponseCode()
        String response = client.getResponseData()
        println response
        client.disconnect();
        log.info("check response")
        json = JSON.parse(response)
        int idAnnotationTerm
        try {idAnnotationTerm= json?.annotationterm?.id } catch(Exception e) {log.error e}
        return [data: AnnotationTerm.get(idAnnotationTerm), code: code]
    }

    static def deleteAnnotationTerm(def idAnnotation, def idTerm, def idUser, String username, String password) {
        log.info("delete annotation")
        String URL = Infos.CYTOMINEURL + "api/annotation/" + idAnnotation + "/term/"+ idTerm +"/user/"+idUser+".json"
        HttpClient client = new HttpClient()
        client.connect(URL, username, password)
        client.delete()
        int code = client.getResponseCode()
        String response = client.getResponseData()
        client.disconnect();
        return [data: response, code: code]
    }
}