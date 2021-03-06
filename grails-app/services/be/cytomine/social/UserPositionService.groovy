package be.cytomine.social

import be.cytomine.image.ImageInstance
import be.cytomine.security.SecUser
import be.cytomine.security.User
import be.cytomine.utils.JSONUtils
import be.cytomine.utils.ModelService
import grails.transaction.Transactional
import org.joda.time.DateTime

import static org.springframework.security.acls.domain.BasePermission.READ
import static org.springframework.security.acls.domain.BasePermission.WRITE

@Transactional
class UserPositionService extends ModelService {

    def securityACLService
    def dataSource
    def mongo
    def noSQLCollectionService

    def add(def json){

        SecUser user = cytomineService.getCurrentUser()
        ImageInstance image = ImageInstance.read(JSONUtils.getJSONAttrLong(json,"image",0))
        PersistentUserPosition position = new PersistentUserPosition()
        position.user = user
        position.image = image
        position.project = image.project
        def polygon = [
                [JSONUtils.getJSONAttrDouble(json,"topLeftX",-1),JSONUtils.getJSONAttrDouble(json,"topLeftY",-1)],
                [JSONUtils.getJSONAttrDouble(json,"topRightX",-1),JSONUtils.getJSONAttrDouble(json,"topRightY",-1)],
                [JSONUtils.getJSONAttrDouble(json,"bottomRightX",-1),JSONUtils.getJSONAttrDouble(json,"bottomRightY",-1)],
                [JSONUtils.getJSONAttrDouble(json,"bottomLeftX",-1),JSONUtils.getJSONAttrDouble(json,"bottomLeftY",-1)]
        ]
        position.location = polygon
        position.zoom = JSONUtils.getJSONAttrInteger(json,"zoom",-1)
        position.created = new Date()
        position.updated = position.created
        position.imageName = image.getFileName()
        position.insert(flush:true) //don't use save (stateless collection)

        LastUserPosition lastUserPosition = new LastUserPosition()
        UserPosition.copyProperties(position,lastUserPosition)
        lastUserPosition.insert(flush:true)
        return lastUserPosition
    }

    def lastPositionByUser(ImageInstance image, SecUser user){
        securityACLService.check(image,READ)
        def userPositions = LastUserPosition.createCriteria().list(sort: "created", order: "desc", max: 1) {
            eq("user", user)
            eq("image", image)
        }
        def result = (userPositions.size() > 0) ? userPositions[0] : []
        return result
    }

    def listOnlineUsersByImage(ImageInstance image){
        securityACLService.check(image,READ)
        DateTime thirtySecondsAgo = new DateTime().minusSeconds(30)

        def db = mongo.getDB(noSQLCollectionService.getDatabaseName())
        def userPositions = db.lastUserPosition.aggregate(
                [$match: [image: image.id, created: [$gte: thirtySecondsAgo.toDate()]]],
                [$project: [user: '$user']],
                [$group : [_id : '$user']]
        );

        def result= userPositions.results().collect{it["_id"]}
        return ["users": result.join(",")]
    }

    def list(ImageInstance image, User user, Long afterThan = null){
        securityACLService.check(image,WRITE)
        return PersistentUserPosition.createCriteria().list(sort: "created", order: "asc") {
            if(user) eq("user", user)
            eq("image", image)
            if(afterThan) gte("created", new Date(afterThan))
        }
    }

    def summarize(ImageInstance image, User user, Long afterThan = null){
        securityACLService.check(image,WRITE)

        def db = mongo.getDB(noSQLCollectionService.getDatabaseName())
        def userPositions

        def match = [image: image.id]
        if(afterThan) match.created = [$gte: new Date(afterThan)];
        if(user) match.user = user.id

        userPositions = db.persistentUserPosition.aggregate(
                [$match: match],
                [$group : [_id : [location : '$location', zoom : '$zoom'], frequency : [$sum : 1], image : [$first: '$image']]]
        );

        def results = []
        userPositions.results().each{
            results << [location : it["_id"].location, zoom : it["_id"].zoom, frequency : it.frequency, image : it.image]
        }
        return results
    }
}
