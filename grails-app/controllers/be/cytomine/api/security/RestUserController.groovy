package be.cytomine.api.security

import be.cytomine.api.RestController
import be.cytomine.project.Project
import be.cytomine.security.User
import grails.converters.JSON
import grails.plugins.springsecurity.Secured

import be.cytomine.security.UserJob
import be.cytomine.processing.Job
import be.cytomine.processing.Software
import be.cytomine.security.SecUserSecRole
import be.cytomine.security.SecUser
import org.codehaus.groovy.grails.plugins.springsecurity.acl.AclObjectIdentity
import org.codehaus.groovy.grails.plugins.springsecurity.acl.AclEntry

/**
 * Handle HTTP Requests for CRUD operations on the User domain class.
 */
class RestUserController extends RestController {

    def springSecurityService
    def transactionService

    def userService
    def projectService

    /**
     * Render and returns all Users into the specified format given in the request
     * @return all Users into the specified format
     */
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def list = {
        if(params.publicKey!=null) {
             responseSuccess(userService.getByPublicKey(params.publicKey))
        } else responseSuccess(userService.list())
    }

    def showUserJob = {
        UserJob userJob = UserJob.read(params.long('id'))
        if(userJob) responseSuccess(userJob)
        else responseNotFound("UserJob", params.id)

    }

    /**
     * Render and return an User into the specified format given in the request
     * @param id the user identifier
     * @return user an User into the specified format
     */
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show = {
        User user = userService.read(params.long('id'))
        if (user) responseSuccess(user)
        else responseNotFound("User", params.id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def showCurrent = {
        responseSuccess(userService.readCurrentUser())
    }

//    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
//    def showByProject = {
//        Project project = projectService.read(params.long('id'))
//        if (project) responseSuccess(project.users())
//        else responseNotFound("User", "Project", params.id)
//    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def showByProject = {
        Project project = projectService.read(params.long('id'),new Project())
        if (project) {
            responseSuccess(project.users())
        }
        else responseNotFound("User", "Project", params.id)
    }

    @Secured(['ROLE_ADMIN'])
    def add = {
        add(userService, request.JSON)
    }
    @Secured(['ROLE_ADMIN'])
    def update = {
        update(userService, request.JSON)
    }
    @Secured(['ROLE_ADMIN'])
    def delete = {
        delete(userService, JSON.parse("{id : $params.id}"))
    }

    @Secured(['ROLE_ADMIN'])
    def addChild = {
        def json = request.JSON
        User user = User.read(springSecurityService.principal.id)

        Job job = new Job()
        job.software = Software.read(json.software)
        job = job.save(flush : true)

        String username = json.username
        UserJob userJob = new UserJob()
        userJob.job = job
        userJob.username = "JOB[" + user.username + "], " + new Date().toString()
        userJob.password = user.password
        userJob.generateKeys()
        userJob.enabled = user.enabled
        userJob.accountExpired = user.accountExpired
        userJob.accountLocked = user.accountLocked
        userJob.passwordExpired = user.passwordExpired
        userJob.user = user
        userJob = userJob.save(flush:true)

        user.getAuthorities().each { secRole ->
            SecUserSecRole.create(userJob, secRole)
        }

//        projectService.list().each {
//            userService.addUserFromProject(userJob,it,true)
//        }

        //def ret = [data: [user: newUser], status: 200]
        response([userJob: userJob],200)

    }

    def deleteUser = {
        Project project = Project.get(params.id)
        SecUser user = SecUser.get(params.idUser)
        boolean admin = false
        userService.deleteUserFromProject(user,project,admin)
        response.status = 200
        def ret = [data: [message: "OK"], status: 200]
        response(ret)
    }

    def addUser = {
        Project project = Project.get(params.id)
        SecUser user = SecUser.get(params.idUser)
        boolean admin = false
        log.debug "addUser project="+project+" user="+user+" admin="+admin
        userService.addUserFromProject(user,project,admin)
        response.status = 200
        def ret = [data: [message: "OK"], status: 200]
        response(ret)

    }

    @Secured(['ROLE_ADMIN'])
    def deleteUserAdmin = {
        Project project = Project.get(params.id)
        SecUser user = SecUser.get(params.idUser)
        boolean admin = true
        userService.deleteUserFromProject(user,project,admin)
        response.status = 200
        def ret = [data: [message: "OK"], status: 200]
        response(ret)
    }

    @Secured(['ROLE_ADMIN'])
    def addUserAdmin = {
        Project project = Project.get(params.id)
        User user = User.get(params.idUser)
        boolean admin = true
        log.debug "addUser project="+project+" user="+user+" admin="+admin
        userService.addUserFromProject(user,project,admin)
        response.status = 200
        def ret = [data: [message: "OK"], status: 200]
        response(ret)

    }

    @Secured(['ROLE_ADMIN'])
    def grid = {
        def sortIndex = params.sidx ?: 'id'
        def sortOrder = params.sord ?: 'asc'
        def maxRows = 50//params.row ? Integer.valueOf(params.rows) : 20
        def currentPage = params.page ? Integer.valueOf(params.page) : 1

        def users = userService.list(currentPage, maxRows, sortIndex, sortOrder, params.firstName, params.lastName, params.email)

        def totalRows = users.totalCount
        def numberOfPages = Math.ceil(totalRows / maxRows)
        def jsonData = [rows: users, page: currentPage, records: totalRows, total: numberOfPages]
        render jsonData as JSON
    }


}
