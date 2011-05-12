import be.cytomine.security.User
import be.cytomine.security.SecRole
import be.cytomine.security.SecUserSecRole
import be.cytomine.image.Image
import be.cytomine.image.Mime
import be.cytomine.image.acquisition.Scanner
import be.cytomine.image.server.ImageServer
import be.cytomine.image.server.MimeImageServer
import be.cytomine.security.Group
import be.cytomine.security.UserGroup
import be.cytomine.project.Project
import be.cytomine.project.ProjectGroup
import be.cytomine.project.Slide
import be.cytomine.project.ProjectSlide
import be.cytomine.ontology.Annotation
import com.vividsolutions.jts.geom.Point
import com.vividsolutions.jts.geom.GeometryFactory
import com.vividsolutions.jts.io.WKTReader
import com.vividsolutions.jts.geom.Polygon
import be.cytomine.image.server.RetrievalServer
import be.cytomine.ontology.Term
import be.cytomine.ontology.AnnotationTerm
import be.cytomine.ontology.Ontology
import java.lang.management.ManagementFactory
import be.cytomine.ontology.Relation
import be.cytomine.ontology.RelationTerm
import grails.util.GrailsUtil
import be.cytomine.image.Mime
import be.cytomine.ontology.Term
import be.cytomine.ontology.RelationTerm
import be.cytomine.ontology.Relation
import be.cytomine.ontology.Ontology
import be.cytomine.ontology.AnnotationTerm
import be.cytomine.ontology.Annotation

class BootStrap {
    def springSecurityService
    def sequenceService
    def marshallersService
    def grailsApplication
    def messageSource

    def CERVIXScans = [
                //CERVIX
                //[filename:'/home/maree/data/PAP/Slides/R215.mrxs',name:'R215.mrxs', extension:"mrxs",order:0,study:'CERVIX'],
                //[filename:'/home/maree/data/PAP/Slides/09-032099.mrxs', name :'09-032099.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
/*[filename:'/home/maree/data/PAP/Slides/09-082544.mrxs', name :'09-082544.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-083151.mrxs', name :'09-083151.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-083782.mrxs', name :'09-083782.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-083903.mrxs', name :'09-083903.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-086380.mrxs', name :'09-086380.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-086562.mrxs', name :'09-086562.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-086566.mrxs', name :'09-086566.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-087214.mrxs', name :'09-087214.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-087496.mrxs', name :'09-087496.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-088022.mrxs', name :'09-088022.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-088135.mrxs', name :'09-088135.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-088456.mrxs', name :'09-088456.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-089901.mrxs', name :'09-089901.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-090210.mrxs', name :'09-090210.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-090362.mrxs', name :'09-090362.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-091034.mrxs', name :'09-091034.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-091152.mrxs', name :'09-091152.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-091511.mrxs', name :'09-091511.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-091669.mrxs', name :'09-091669.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-092517.mrxs', name :'09-092517.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-092970.mrxs', name :'09-092970.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-092974.mrxs', name :'09-092974.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-093881.mrxs', name :'09-093881.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-093911.mrxs', name :'09-093911.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094116.mrxs', name :'09-094116.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094158.mrxs', name :'09-094158.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094406.mrxs', name :'09-094406.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094465.mrxs', name :'09-094465.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094475.mrxs', name :'09-094475.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094476.mrxs', name :'09-094476.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094494.mrxs', name :'09-094494.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094594.mrxs', name :'09-094594.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094626.mrxs', name :'09-094626.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094705.mrxs', name :'09-094705.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-094990.mrxs', name :'09-094990.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-095364.mrxs', name :'09-095364.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-095763.mrxs', name :'09-095763.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-095813.mrxs', name :'09-095813.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-096330.mrxs', name :'09-096330.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-096556.mrxs', name :'09-096556.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-096615.mrxs', name :'09-096615.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-096682.mrxs', name :'09-096682.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-096696.mrxs', name :'09-096696.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-096886.mrxs', name :'09-096886.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-096935.mrxs', name :'09-096935.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097003.mrxs', name :'09-097003.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097060.mrxs', name :'09-097060.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097065.mrxs', name :'09-097065.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097182.mrxs', name :'09-097182.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097217.mrxs', name :'09-097217.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097219.mrxs', name :'09-097219.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097222.mrxs', name :'09-097222.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097233.mrxs', name :'09-097233.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097237.mrxs', name :'09-097237.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097407.mrxs', name :'09-097407.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097650.mrxs', name :'09-097650.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097662.mrxs', name :'09-097662.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097712.mrxs', name :'09-097712.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097861.mrxs', name :'09-097861.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-097873.mrxs', name :'09-097873.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098226.mrxs', name :'09-098226.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098231.mrxs', name :'09-098231.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098383.mrxs', name :'09-098383.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098437.mrxs', name :'09-098437.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098438.mrxs', name :'09-098438.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098447.mrxs', name :'09-098447.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098449.mrxs', name :'09-098449.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098452.mrxs', name :'09-098452.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098455.mrxs', name :'09-098455.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098456.mrxs', name :'09-098456.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098457.mrxs', name :'09-098457.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098458.mrxs', name :'09-098458.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098459.mrxs', name :'09-098459.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098462.mrxs', name :'09-098462.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098463.mrxs', name :'09-098463.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098464.mrxs', name :'09-098464.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098466_21.05.2009_15.34.20.mrxs', name :'09-098466_21.05.2009_15.34.20.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098466.mrxs', name :'09-098466.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098467.mrxs', name :'09-098467.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098472.mrxs', name :'09-098472.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098474.mrxs', name :'09-098474.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098476.mrxs', name :'09-098476.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098478.mrxs', name :'09-098478.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098482.mrxs', name :'09-098482.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098483.mrxs', name :'09-098483.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098486.mrxs', name :'09-098486.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098488.mrxs', name :'09-098488.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098489.mrxs', name :'09-098489.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098491.mrxs', name :'09-098491.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098493.mrxs', name :'09-098493.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098494.mrxs', name :'09-098494.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098495.mrxs', name :'09-098495.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-098496.mrxs', name :'09-098496.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099259.mrxs', name :'09-099259.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099263.mrxs', name :'09-099263.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099290.mrxs', name :'09-099290.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099362.mrxs', name :'09-099362.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099382.mrxs', name :'09-099382.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099537.mrxs', name :'09-099537.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099550.mrxs', name :'09-099550.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099551.mrxs', name :'09-099551.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099553.mrxs', name :'09-099553.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099555.mrxs', name :'09-099555.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099556.mrxs', name :'09-099556.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099557.mrxs', name :'09-099557.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099558.mrxs', name :'09-099558.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099559.mrxs', name :'09-099559.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099560.mrxs', name :'09-099560.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099561.mrxs', name :'09-099561.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099562.mrxs', name :'09-099562.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099563.mrxs', name :'09-099563.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099565.mrxs', name :'09-099565.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099566.mrxs', name :'09-099566.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099568.mrxs', name :'09-099568.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099570.mrxs', name :'09-099570.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099571.mrxs', name :'09-099571.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099572.mrxs', name :'09-099572.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099573.mrxs', name :'09-099573.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099574.mrxs', name :'09-099574.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099575.mrxs', name :'09-099575.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099576.mrxs', name :'09-099576.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099577.mrxs', name :'09-099577.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099579.mrxs', name :'09-099579.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099580.mrxs', name :'09-099580.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099582.mrxs', name :'09-099582.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099583.mrxs', name :'09-099583.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099584.mrxs', name :'09-099584.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099585.mrxs', name :'09-099585.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099586.mrxs', name :'09-099586.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099587.mrxs', name :'09-099587.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099588.mrxs', name :'09-099588.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099589.mrxs', name :'09-099589.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099645.mrxs', name :'09-099645.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099818.mrxs', name :'09-099818.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099846.mrxs', name :'09-099846.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099898.mrxs', name :'09-099898.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-099950.mrxs', name :'09-099950.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-100149.mrxs', name :'09-100149.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-100923.mrxs', name :'09-100923.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101077.mrxs', name :'09-101077.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101078.mrxs', name :'09-101078.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101079.mrxs', name :'09-101079.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101080.mrxs', name :'09-101080.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101081.mrxs', name :'09-101081.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101082.mrxs', name :'09-101082.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101083.mrxs', name :'09-101083.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101084.mrxs', name :'09-101084.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101085.mrxs', name :'09-101085.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101086.mrxs', name :'09-101086.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101088.mrxs', name :'09-101088.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101089.mrxs', name :'09-101089.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101090.mrxs', name :'09-101090.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101091.mrxs', name :'09-101091.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101092.mrxs', name :'09-101092.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101093.mrxs', name :'09-101093.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101184.mrxs', name :'09-101184.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101195.mrxs', name :'09-101195.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101235.mrxs', name :'09-101235.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101247.mrxs', name :'09-101247.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101284.mrxs', name :'09-101284.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-101460.mrxs', name :'09-101460.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102486.mrxs', name :'09-102486.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102488.mrxs', name :'09-102488.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102490.mrxs', name :'09-102490.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102491.mrxs', name :'09-102491.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102493.mrxs', name :'09-102493.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102494.mrxs', name :'09-102494.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102495.mrxs', name :'09-102495.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102496.mrxs', name :'09-102496.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102498.mrxs', name :'09-102498.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102499.mrxs', name :'09-102499.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102500.mrxs', name :'09-102500.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102501.mrxs', name :'09-102501.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102502.mrxs', name :'09-102502.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102503.mrxs', name :'09-102503.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102508.mrxs', name :'09-102508.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102509.mrxs', name :'09-102509.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102510.mrxs', name :'09-102510.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102512.mrxs', name :'09-102512.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102513.mrxs', name :'09-102513.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102514.mrxs', name :'09-102514.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102517.mrxs', name :'09-102517.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102518.mrxs', name :'09-102518.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102519.mrxs', name :'09-102519.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102520.mrxs', name :'09-102520.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102522.mrxs', name :'09-102522.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102523.mrxs', name :'09-102523.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102524.mrxs', name :'09-102524.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102528.mrxs', name :'09-102528.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102529.mrxs', name :'09-102529.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102530.mrxs', name :'09-102530.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102531.mrxs', name :'09-102531.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102532.mrxs', name :'09-102532.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102534.mrxs', name :'09-102534.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102535.mrxs', name :'09-102535.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102536.mrxs', name :'09-102536.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102537.mrxs', name :'09-102537.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102538.mrxs', name :'09-102538.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102542.mrxs', name :'09-102542.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102543.mrxs', name :'09-102543.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102544.mrxs', name :'09-102544.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102545.mrxs', name :'09-102545.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102606.mrxs', name :'09-102606.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102607.mrxs', name :'09-102607.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102608.mrxs', name :'09-102608.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102610.mrxs', name :'09-102610.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102611.mrxs', name :'09-102611.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102612.mrxs', name :'09-102612.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102613.mrxs', name :'09-102613.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102614.mrxs', name :'09-102614.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102615.mrxs', name :'09-102615.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102616.mrxs', name :'09-102616.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102617.mrxs', name :'09-102617.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102618.mrxs', name :'09-102618.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102619.mrxs', name :'09-102619.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102621.mrxs', name :'09-102621.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102622.mrxs', name :'09-102622.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102625.mrxs', name :'09-102625.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102666.mrxs', name :'09-102666.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102667.mrxs', name :'09-102667.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102668.mrxs', name :'09-102668.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102669.mrxs', name :'09-102669.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102670.mrxs', name :'09-102670.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102671.mrxs', name :'09-102671.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102672.mrxs', name :'09-102672.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102673.mrxs', name :'09-102673.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102674.mrxs', name :'09-102674.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102675.mrxs', name :'09-102675.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102676.mrxs', name :'09-102676.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102677.mrxs', name :'09-102677.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102678.mrxs', name :'09-102678.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102679.mrxs', name :'09-102679.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102680.mrxs', name :'09-102680.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102682.mrxs', name :'09-102682.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102683.mrxs', name :'09-102683.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102685.mrxs', name :'09-102685.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102686.mrxs', name :'09-102686.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102687.mrxs', name :'09-102687.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102688.mrxs', name :'09-102688.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102689.mrxs', name :'09-102689.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102691.mrxs', name :'09-102691.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102693.mrxs', name :'09-102693.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102694.mrxs', name :'09-102694.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102695.mrxs', name :'09-102695.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102696.mrxs', name :'09-102696.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102697.mrxs', name :'09-102697.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102698.mrxs', name :'09-102698.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102699.mrxs', name :'09-102699.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102700.mrxs', name :'09-102700.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102701.mrxs', name :'09-102701.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102703.mrxs', name :'09-102703.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102704.mrxs', name :'09-102704.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102706.mrxs', name :'09-102706.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102707.mrxs', name :'09-102707.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102709.mrxs', name :'09-102709.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102710.mrxs', name :'09-102710.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102711.mrxs', name :'09-102711.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102712.mrxs', name :'09-102712.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102713.mrxs', name :'09-102713.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102714.mrxs', name :'09-102714.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102715.mrxs', name :'09-102715.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102716.mrxs', name :'09-102716.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102717.mrxs', name :'09-102717.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102718.mrxs', name :'09-102718.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102719.mrxs', name :'09-102719.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102720.mrxs', name :'09-102720.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102723.mrxs', name :'09-102723.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102725.mrxs', name :'09-102725.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102726.mrxs', name :'09-102726.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102727.mrxs', name :'09-102727.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102728.mrxs', name :'09-102728.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102729.mrxs', name :'09-102729.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102730.mrxs', name :'09-102730.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102732.mrxs', name :'09-102732.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102735.mrxs', name :'09-102735.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102736.mrxs', name :'09-102736.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102737.mrxs', name :'09-102737.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102738.mrxs', name :'09-102738.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102739.mrxs', name :'09-102739.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102740.mrxs', name :'09-102740.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102741.mrxs', name :'09-102741.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102742.mrxs', name :'09-102742.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102744.mrxs', name :'09-102744.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102745.mrxs', name :'09-102745.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102883.mrxs', name :'09-102883.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102884.mrxs', name :'09-102884.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102887.mrxs', name :'09-102887.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-102888.mrxs', name :'09-102888.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-104192.mrxs', name :'09-104192.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-104468.mrxs', name :'09-104468.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-105057.mrxs', name :'09-105057.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-105059.mrxs', name :'09-105059.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-105060.mrxs', name :'09-105060.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-105061_15.05.2009_23.05.43.mrxs', name :'09-105061_15.05.2009_23.05.43.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-105061.mrxs', name :'09-105061.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-105158.mrxs', name :'09-105158.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-105159.mrxs', name :'09-105159.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-106417.mrxs', name :'09-106417.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-106464.mrxs', name :'09-106464.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-107596.mrxs', name :'09-107596.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-107619.mrxs', name :'09-107619.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-107660.mrxs', name :'09-107660.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-107840.mrxs', name :'09-107840.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-107843.mrxs', name :'09-107843.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-107857.mrxs', name :'09-107857.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-107872.mrxs', name :'09-107872.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108108.mrxs', name :'09-108108.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108145.mrxs', name :'09-108145.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108173.mrxs', name :'09-108173.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108265.mrxs', name :'09-108265.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108279.mrxs', name :'09-108279.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108288.mrxs', name :'09-108288.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108294.mrxs', name :'09-108294.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108421.mrxs', name :'09-108421.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108456.mrxs', name :'09-108456.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108460.mrxs', name :'09-108460.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108474.mrxs', name :'09-108474.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108573.mrxs', name :'09-108573.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108762.mrxs', name :'09-108762.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108769.mrxs', name :'09-108769.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108791.mrxs', name :'09-108791.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108849.mrxs', name :'09-108849.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-108950.mrxs', name :'09-108950.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109071.mrxs', name :'09-109071.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109115.mrxs', name :'09-109115.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109137.mrxs', name :'09-109137.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109293.mrxs', name :'09-109293.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109311.mrxs', name :'09-109311.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109371.mrxs', name :'09-109371.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109389.mrxs', name :'09-109389.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109429.mrxs', name :'09-109429.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109527.mrxs', name :'09-109527.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109605.mrxs', name :'09-109605.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109678.mrxs', name :'09-109678.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109687.mrxs', name :'09-109687.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109718.mrxs', name :'09-109718.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-109722.mrxs', name :'09-109722.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110149.mrxs', name :'09-110149.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110319.mrxs', name :'09-110319.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110466.mrxs', name :'09-110466.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110502_20.05.2009_09.59.15.mrxs', name :'09-110502_20.05.2009_09.59.15.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110502.mrxs', name :'09-110502.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110531.mrxs', name :'09-110531.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110756.mrxs', name :'09-110756.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110914.mrxs', name :'09-110914.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110919.mrxs', name :'09-110919.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-110958.mrxs', name :'09-110958.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111028.mrxs', name :'09-111028.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111158.mrxs', name :'09-111158.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111159.mrxs', name :'09-111159.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111299.mrxs', name :'09-111299.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111421.mrxs', name :'09-111421.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111484.mrxs', name :'09-111484.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111490.mrxs', name :'09-111490.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111515.mrxs', name :'09-111515.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111624.mrxs', name :'09-111624.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111706.mrxs', name :'09-111706.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111882.mrxs', name :'09-111882.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111897.mrxs', name :'09-111897.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111930.mrxs', name :'09-111930.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-111942.mrxs', name :'09-111942.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112054.mrxs', name :'09-112054.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112096.mrxs', name :'09-112096.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112119.mrxs', name :'09-112119.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112307.mrxs', name :'09-112307.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112362.mrxs', name :'09-112362.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112392.mrxs', name :'09-112392.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112438.mrxs', name :'09-112438.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112446.mrxs', name :'09-112446.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112576.mrxs', name :'09-112576.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112615.mrxs', name :'09-112615.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-112705.mrxs', name :'09-112705.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-113277.mrxs', name :'09-113277.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-113292.mrxs', name :'09-113292.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-113354.mrxs', name :'09-113354.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-113365.mrxs', name :'09-113365.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-113549.mrxs', name :'09-113549.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-113590.mrxs', name :'09-113590.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-113682.mrxs', name :'09-113682.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-113683.mrxs', name :'09-113683.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-114094.mrxs', name :'09-114094.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-114157.mrxs', name :'09-114157.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-114182.mrxs', name :'09-114182.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-114358.mrxs', name :'09-114358.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-114574.mrxs', name :'09-114574.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-114589.mrxs', name :'09-114589.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115072.mrxs', name :'09-115072.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115253.mrxs', name :'09-115253.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115331.mrxs', name :'09-115331.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115354.mrxs', name :'09-115354.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115524.mrxs', name :'09-115524.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115527.mrxs', name :'09-115527.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115560.mrxs', name :'09-115560.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115658.mrxs', name :'09-115658.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115706.mrxs', name :'09-115706.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115738.mrxs', name :'09-115738.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-115966.mrxs', name :'09-115966.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-116931.mrxs', name :'09-116931.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117078.mrxs', name :'09-117078.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117103.mrxs', name :'09-117103.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117106.mrxs', name :'09-117106.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117109.mrxs', name :'09-117109.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117219.mrxs', name :'09-117219.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117237.mrxs', name :'09-117237.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117299.mrxs', name :'09-117299.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117375.mrxs', name :'09-117375.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117381.mrxs', name :'09-117381.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-117859.mrxs', name :'09-117859.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-118088.mrxs', name :'09-118088.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-118112.mrxs', name :'09-118112.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-118533.mrxs', name :'09-118533.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-118854.mrxs', name :'09-118854.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-118855.mrxs', name :'09-118855.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-119486.mrxs', name :'09-119486.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-119497.mrxs', name :'09-119497.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-120159.mrxs', name :'09-120159.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-120166.mrxs', name :'09-120166.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-123134.mrxs', name :'09-123134.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-125354.mrxs', name :'09-125354.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/09-125358.mrxs', name :'09-125358.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/10HSIL101309.mrxs', name :'10HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/11HSIL101309.mrxs', name :'11HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1HSIL101309.mrxs', name :'1HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M03_20.05.2009_10.22.27.mrxs', name :'1M03_20.05.2009_10.22.27.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M03_20.05.2009_13.38.20.mrxs', name :'1M03_20.05.2009_13.38.20.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M03.mrxs', name :'1M03.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M05.mrxs', name :'1M05.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M11_21.05.2009_19.17.13.mrxs', name :'1M11_21.05.2009_19.17.13.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M11.mrxs', name :'1M11.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M13.mrxs', name :'1M13.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M15.mrxs', name :'1M15.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M16.mrxs', name :'1M16.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M21.mrxs', name :'1M21.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M24.mrxs', name :'1M24.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M25.mrxs', name :'1M25.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M38.mrxs', name :'1M38.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1M41.mrxs', name :'1M41.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1SCC101309.mrxs', name :'1SCC101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/1SMALL101309.mrxs', name :'1SMALL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/2HSIL101309.mrxs', name :'2HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/2M01.mrxs', name :'2M01.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/2SCC101309.mrxs', name :'2SCC101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/3HSIL101309.mrxs', name :'3HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/3SCC101309.mrxs', name :'3SCC101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4-105.mrxs', name :'4-105.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4-127.mrxs', name :'4-127.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
//[filename:'/home/maree/data/PAP/Slides/4-152.mrxs', name :'4-152.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4-1681.mrxs', name :'4-1681.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4-1860.mrxs', name :'4-1860.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4-1895.mrxs', name :'4-1895.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4-3914.mrxs', name :'4-3914.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4-3985.mrxs', name :'4-3985.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4-4478.mrxs', name :'4-4478.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4HSIL101309.mrxs', name :'4HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/4SCC101309.mrxs', name :'4SCC101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/5HSIL101309.mrxs', name :'5HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/6HSIL101309.mrxs', name :'6HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/7HSIL101309.mrxs', name :'7HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/8HSIL101309.mrxs', name :'8HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/9HSIL101309.mrxs', name :'9HSIL101309.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H10 AIS.mrxs', name :'H10 AIS.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H11 AIS.mrxs', name :'H11 AIS.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H12 AIS.mrxs', name :'H12 AIS.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H13.mrxs', name :'H13.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H14.mrxs', name :'H14.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H15 SCC.mrxs', name :'H15 SCC.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H16 Endcx Adeno.mrxs', name :'H16 Endcx Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H17 Adeno.mrxs', name :'H17 Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H18.mrxs', name :'H18.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H19.mrxs', name :'H19.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H1 Enmtl Adeno.mrxs', name :'H1 Enmtl Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H20.mrxs', name :'H20.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H21.mrxs', name :'H21.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H22.mrxs', name :'H22.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H23.mrxs', name :'H23.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H24.mrxs', name :'H24.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H25 AIS.mrxs', name :'H25 AIS.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H26 SCC.mrxs', name :'H26 SCC.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H27 SCC.mrxs', name :'H27 SCC.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H28.mrxs', name :'H28.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H29.mrxs', name :'H29.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H2 Adeno.mrxs', name :'H2 Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H30.mrxs', name :'H30.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H31 AdenoSq.mrxs', name :'H31 AdenoSq.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H32 AdenoSq.mrxs', name :'H32 AdenoSq.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H33 AdenoSq.mrxs', name :'H33 AdenoSq.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H34 Small Cell.mrxs', name :'H34 Small Cell.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H35 SCC.mrxs', name :'H35 SCC.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H36 CIS.mrxs', name :'H36 CIS.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H37.mrxs', name :'H37.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H38.mrxs', name :'H38.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H39.mrxs', name :'H39.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H3 Adeno.mrxs', name :'H3 Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H40.mrxs', name :'H40.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H41.mrxs', name :'H41.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H42.mrxs', name :'H42.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H43.mrxs', name :'H43.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H44.mrxs', name :'H44.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H45.mrxs', name :'H45.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H46 SCC.mrxs', name :'H46 SCC.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H47 HSIL.mrxs', name :'H47 HSIL.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H48 Adeno_18.08.2009_15.42.04.mrxs', name :'H48 Adeno_18.08.2009_15.42.04.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
//[filename:'/home/maree/data/PAP/Slides/H48 Adeno.mrxs', name :'H48 Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H49.mrxs', name :'H49.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H4 Adeno.mrxs', name :'H4 Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H50.mrxs', name :'H50.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H51 small cell.mrxs', name :'H51 small cell.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H52 Adeno.mrxs', name :'H52 Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H53.mrxs', name :'H53.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H54.mrxs', name :'H54.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H55.mrxs', name :'H55.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H56 Adeno.mrxs', name :'H56 Adeno.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H57 Adenosq.mrxs', name :'H57 Adenosq.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H58 Adenosq.mrxs', name :'H58 Adenosq.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H5.mrxs', name :'H5.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H6 AIS.mrxs', name :'H6 AIS.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H7.mrxs', name :'H7.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H8 AIS.mrxs', name :'H8 AIS.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/H9 AIS.mrxs', name :'H9 AIS.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/Herpes 1.mrxs', name :'Herpes 1.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/Herpes 2.mrxs', name :'Herpes 2.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/Herpes 3.mrxs', name :'Herpes 3.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/HPVm.mrxs', name :'HPVm.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/HSILm.mrxs', name :'HSILm.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L01.mrxs', name :'L01.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L02.mrxs', name :'L02.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L03.mrxs', name :'L03.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L04.mrxs', name :'L04.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L05.mrxs', name :'L05.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L06.mrxs', name :'L06.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L07.mrxs', name :'L07.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L08.mrxs', name :'L08.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L09.mrxs', name :'L09.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L10.mrxs', name :'L10.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L11.mrxs', name :'L11.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L12.mrxs', name :'L12.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L13.mrxs', name :'L13.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L14.mrxs', name :'L14.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L15.mrxs', name :'L15.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L16.mrxs', name :'L16.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L17.mrxs', name :'L17.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L18.mrxs', name :'L18.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L19.mrxs', name :'L19.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L20.mrxs', name :'L20.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L21.mrxs', name :'L21.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L22.mrxs', name :'L22.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L23.mrxs', name :'L23.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L24.mrxs', name :'L24.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/L25.mrxs', name :'L25.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-001_25.06.2009_11.24.00.mrxs', name :'M-001_25.06.2009_11.24.00.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-001.mrxs', name :'M-001.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-002_25.06.2009_11.30.22.mrxs', name :'M-002_25.06.2009_11.30.22.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-002.mrxs', name :'M-002.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-003_25.06.2009_11.35.43.mrxs', name :'M-003_25.06.2009_11.35.43.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-003.mrxs', name :'M-003.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-004_25.06.2009_11.41.32.mrxs', name :'M-004_25.06.2009_11.41.32.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-004.mrxs', name :'M-004.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-005_25.06.2009_11.47.24.mrxs', name :'M-005_25.06.2009_11.47.24.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-005.mrxs', name :'M-005.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-006_25.06.2009_11.54.41.mrxs', name :'M-006_25.06.2009_11.54.41.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-006.mrxs', name :'M-006.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-007_25.06.2009_12.01.40.mrxs', name :'M-007_25.06.2009_12.01.40.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-007.mrxs', name :'M-007.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-008_25.06.2009_12.08.35.mrxs', name :'M-008_25.06.2009_12.08.35.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-008.mrxs', name :'M-008.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-009_25.06.2009_12.15.04.mrxs', name :'M-009_25.06.2009_12.15.04.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-009.mrxs', name :'M-009.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-010_25.06.2009_12.21.18.mrxs', name :'M-010_25.06.2009_12.21.18.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-010.mrxs', name :'M-010.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-011_25.06.2009_12.28.06.mrxs', name :'M-011_25.06.2009_12.28.06.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-011.mrxs', name :'M-011.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-012_25.06.2009_12.33.13.mrxs', name :'M-012_25.06.2009_12.33.13.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-012.mrxs', name :'M-012.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-013_25.06.2009_12.38.45.mrxs', name :'M-013_25.06.2009_12.38.45.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-013.mrxs', name :'M-013.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-014_25.06.2009_12.44.33.mrxs', name :'M-014_25.06.2009_12.44.33.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-014.mrxs', name :'M-014.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-015_25.06.2009_12.49.52.mrxs', name :'M-015_25.06.2009_12.49.52.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-015.mrxs', name :'M-015.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-016_25.06.2009_12.54.48.mrxs', name :'M-016_25.06.2009_12.54.48.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-016.mrxs', name :'M-016.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-017_25.06.2009_12.59.57.mrxs', name :'M-017_25.06.2009_12.59.57.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-017.mrxs', name :'M-017.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-018_25.06.2009_13.05.07.mrxs', name :'M-018_25.06.2009_13.05.07.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-018.mrxs', name :'M-018.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-019.mrxs', name :'M-019.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-020_25.06.2009_13.10.56.mrxs', name :'M-020_25.06.2009_13.10.56.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-020.mrxs', name :'M-020.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-021_25.06.2009_13.16.10.mrxs', name :'M-021_25.06.2009_13.16.10.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-021.mrxs', name :'M-021.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-022_25.06.2009_13.21.40.mrxs', name :'M-022_25.06.2009_13.21.40.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-022.mrxs', name :'M-022.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-023_25.06.2009_13.27.40.mrxs', name :'M-023_25.06.2009_13.27.40.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-023.mrxs', name :'M-023.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-024_25.06.2009_13.33.21.mrxs', name :'M-024_25.06.2009_13.33.21.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-024.mrxs', name :'M-024.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-025_25.06.2009_13.39.28.mrxs', name :'M-025_25.06.2009_13.39.28.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-025.mrxs', name :'M-025.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-026_25.06.2009_13.45.05.mrxs', name :'M-026_25.06.2009_13.45.05.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-026.mrxs', name :'M-026.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-027_25.06.2009_13.51.32.mrxs', name :'M-027_25.06.2009_13.51.32.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-027.mrxs', name :'M-027.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-028_25.06.2009_13.57.49.mrxs', name :'M-028_25.06.2009_13.57.49.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-028.mrxs', name :'M-028.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-029_25.06.2009_14.03.26.mrxs', name :'M-029_25.06.2009_14.03.26.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-029.mrxs', name :'M-029.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-030_25.06.2009_14.10.31.mrxs', name :'M-030_25.06.2009_14.10.31.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-030.mrxs', name :'M-030.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-031_25.06.2009_14.16.46.mrxs', name :'M-031_25.06.2009_14.16.46.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-031.mrxs', name :'M-031.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-032_25.06.2009_14.22.48.mrxs', name :'M-032_25.06.2009_14.22.48.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-032.mrxs', name :'M-032.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-033_25.06.2009_14.27.55.mrxs', name :'M-033_25.06.2009_14.27.55.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-033.mrxs', name :'M-033.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-034_25.06.2009_14.33.06.mrxs', name :'M-034_25.06.2009_14.33.06.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-034.mrxs', name :'M-034.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-035_25.06.2009_14.38.04.mrxs', name :'M-035_25.06.2009_14.38.04.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-035.mrxs', name :'M-035.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-036_25.06.2009_14.42.51.mrxs', name :'M-036_25.06.2009_14.42.51.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-036.mrxs', name :'M-036.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-037_25.06.2009_14.48.00.mrxs', name :'M-037_25.06.2009_14.48.00.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],*/
[filename:'/home/maree/data/PAP/Slides/M-037.mrxs', name :'M-037.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-038_25.06.2009_14.54.03.mrxs', name :'M-038_25.06.2009_14.54.03.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-038.mrxs', name :'M-038.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-039_25.06.2009_15.00.47.mrxs', name :'M-039_25.06.2009_15.00.47.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-039.mrxs', name :'M-039.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-040_25.06.2009_15.06.07.mrxs', name :'M-040_25.06.2009_15.06.07.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-040.mrxs', name :'M-040.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-041_25.06.2009_15.10.51.mrxs', name :'M-041_25.06.2009_15.10.51.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-041.mrxs', name :'M-041.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-042_25.06.2009_15.17.47.mrxs', name :'M-042_25.06.2009_15.17.47.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-042.mrxs', name :'M-042.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-043_25.06.2009_15.22.55.mrxs', name :'M-043_25.06.2009_15.22.55.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-043.mrxs', name :'M-043.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-044_25.06.2009_15.27.22.mrxs', name :'M-044_25.06.2009_15.27.22.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-044.mrxs', name :'M-044.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-045_25.06.2009_15.33.37.mrxs', name :'M-045_25.06.2009_15.33.37.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-045.mrxs', name :'M-045.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-046_25.06.2009_15.38.32.mrxs', name :'M-046_25.06.2009_15.38.32.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-046.mrxs', name :'M-046.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-047_25.06.2009_15.44.48.mrxs', name :'M-047_25.06.2009_15.44.48.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-047.mrxs', name :'M-047.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-048_25.06.2009_15.52.23.mrxs', name :'M-048_25.06.2009_15.52.23.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-048.mrxs', name :'M-048.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-049_25.06.2009_15.57.34.mrxs', name :'M-049_25.06.2009_15.57.34.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-049.mrxs', name :'M-049.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-050_25.06.2009_16.04.21.mrxs', name :'M-050_25.06.2009_16.04.21.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-050.mrxs', name :'M-050.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-051.mrxs', name :'M-051.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-052.mrxs', name :'M-052.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/M-053.mrxs', name :'M-053.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R201.mrxs', name :'R201.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R212.mrxs', name :'R212.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R214.mrxs', name :'R214.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R215.mrxs', name :'R215.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R224.mrxs', name :'R224.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R235.mrxs', name :'R235.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R236.mrxs', name :'R236.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R237.mrxs', name :'R237.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R238.mrxs', name :'R238.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R240.mrxs', name :'R240.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R241.mrxs', name :'R241.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R243.mrxs', name :'R243.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R246.mrxs', name :'R246.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R247.mrxs', name :'R247.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R248.mrxs', name :'R248.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R249.mrxs', name :'R249.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R250.mrxs', name :'R250.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R253.mrxs', name :'R253.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R259.mrxs', name :'R259.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R260.mrxs', name :'R260.mrxs', extension :'mrxs', order : 0,study : 'CERVIX'],
[filename:'/home/maree/data/PAP/Slides/R261.mrxs', name :'R261.mrxs', extension :'mrxs', order : 0,study : 'CERVIX']
        ]

    def init = { servletContext ->

        marshallersService.initMarshallers()
        sequenceService.initSequences()

        grailsApplication.domainClasses.each {domainClass ->//iterate over the domainClasses
            if (domainClass.clazz.name.contains("be.cytomine")) {//only add it to the domains in my plugin

                domainClass.metaClass.retrieveErrors = {
                    def list = delegate?.errors?.allErrors?.collect{messageSource.getMessage(it,null)}
                    return list?.join('\n')
                }
            }
        }

        List inputArgs = ManagementFactory.getRuntimeMXBean().getInputArguments();
        for(int i =0;i<inputArgs.size();i++)
        {
            println inputArgs.get(i)
        }



        log.info "add data"
        println """add Data"""
        /* Groups */
        def groupsSamples = [
                [name : "GIGA"],
                [name : "LBTD"] ,
                [name : "ANAPATH"]
        ]
        createGroups(groupsSamples)


        /* Users */
        def usersSamples = [
                [username : 'rmaree', firstname : 'Raphaël', lastname : 'Marée', email : 'rmaree@ulg.ac.be', group : [[ name :"GIGA"]], password : 'password'],
                [username : 'lrollus', firstname : 'Loic', lastname : 'Rollus', email : 'lrollus@ulg.ac.be', group : [[ name :"GIGA"]], password : 'password'],
                [username : 'stevben', firstname : 'Benjamin', lastname : 'Stévens', email : 'bstevens@ulg.ac.be', group : [[ name :"GIGA"], [name : "ANAPATH"]], password : 'password'] ,
                [username : 'demo', firstname : 'Jean', lastname : 'Dupont', email : 'mymail@ulg.ac.be', group : [[ name :"GIGA"], [name : "ANAPATH"]], password : 'demodemo']
        ]
        createUsers(usersSamples)


        /* Scanners */
        def scannersSamples = [
                [brand : "gigascan", model : "MODEL1"]
        ]
        createScanners(scannersSamples)


        /* MIME Types */
        def mimeSamples = [
                [extension : "jp2", mimeType : "image/jp2"],
                [extension : "tif", mimeType : "image/tiff"],
                [extension : "gdal", mimeType : "gdalType"],
                [extension : "vms", mimeType : "openslide/vms"],
                [extension : "mrxs", mimeType : "openslide/mrxs"]
        ]
        createMimes(mimeSamples)


        /* Image Server */
        def imageServerSamples =  [
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is1.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is2.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is3.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is4.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is5.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is6.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is7.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is8.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is9.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'Adore-Djatoka',
                        'url' : 'http://is10.cytomine.be:38',
                        'service' : '/adore-djatoka/resolver',
                        'className' : 'DjatokaResolver',
                        'extension' : 'jp2'
                ],
                [
                        'name' : 'GDAL',
                        'url' : 'http://localhost/~stevben',
                        'service' : '/gdal',
                        'className' : 'GDALResolver',
                        'extension' : 'gdal'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is1.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is2.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is3.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is4.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is5.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is6.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is7.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is8.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is9.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is10.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'vms'
                ],
                [
                        'name' : 'IIP-Openslide',
                        'url' : 'http://is10.cytomine.be:48',
                        'service' : '/fcgi-bin/iipsrv.fcgi',
                        'className' : 'IPPResolver',
                        'extension' : 'mrxs'
                ]

        ]
        createImageServers(imageServerSamples)

        def retrievalServerSamples = [
                [
                        'url' : '139.165.108.28',
                        'port' : 1230,
                        'description' : 'marée'
                ]
        ]
        createRetrievalServers(retrievalServerSamples)

        def ontologySamples = [
                /* ANAPATH */
                [name: "LBA"],
                [name: "ASP"],
                [name: "Frottis"],
                /* LBTD */
                [name : "Tissus"],
                [name : "Cellules"]

        ]
        createOntology(ontologySamples)

        /* Projects */
        def projectSamples = [
                [name : "LBTD NEO4",  groups : [[ name :"GIGA"]],ontology: "Tissus"],
                //[name : "LBTD NEO13",  groups : [[ name :"GIGA"]],ontology: "Tissus"],
                //[name : "LBTD",  groups : [[ name :"GIGA"]],ontology: "Tissus"],
                [name : "ANAPATH",  groups : [[ name :"GIGA"]],ontology: "LBA"],
                [name : "OTHER",  groups : [[ name :"GIGA"]],ontology: "Cellules"] ,
                [name : "CERVIX",  groups : [[ name :"GIGA"]],ontology: "Cellules"]
                // [name : "NEO13", groups : [[ name :"GIGA"]]],
                // [name : "NEO4",  groups : [[ name :"GIGA"]]]

        ]

        createProjects(projectSamples)

        /* Slides */
        def slideSamples = [
                /*[name : "testslide", order : 8, projects : [[name : "GIGA-DEV"]]],
    [name : "testslide2", order : 8, projects : [[name : "GIGA-DEV"]]],
    [name : "testslide3", order : 8, projects : [[name : "GIGA-DEV"]]],
    [name : "testslide4", order : 8, projects : [[name : "GIGA-DEV2"]]],
    [name : "testslide5", order : 8, projects : [[name : "GIGA-DEV"]]],
    [name : "testslide6", order : 8, projects : [[name : "ANAPATH"]]]  */
        ]
        def slides = createSlides(slideSamples)



        createLBTDScans(CERVIXScans)

        def LBTDScans = [



                /* [filename: 'Boyden - essai _10x_02',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/Boyden/essai_10x_02.one.jp2',slide : 0],
           [filename: 'Aperio - 003',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/Aperio/003.jp2',slide : 0 ],
           [filename: 'Aperio - 2005900969-2', path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/Aperio/2005900969-2.jp2',slide : 0 ],
           [filename: 'bottom-nocompression', path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/bottom-nocompression-crop-8levels-256.jp2',slide : 0 ],
           [filename: '70pc_cropnew', path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/PhDelvenne/2_02_JPEG_70pc_cropnew.jp2',slide : 0 ],
           [filename: 'Agar seul 1',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Agar-seul-1.jp2',slide : 0 ],
           [filename: 'Agar seul 2',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Agar-seul-2.jp2',slide : 0 ],
           [filename: 'Curcu 1',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-1.jp2',slide : 1 ],
           [filename: 'Curcu 2',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-2.jp2',slide : 1 ],
           [filename: 'Curcu 3',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-3.jp2',slide : 1 ],
           [filename: 'Curcu 4',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-4.jp2',slide : 1 ],
           [filename: 'Curcu 5',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-5.jp2',slide : 1 ],
           [filename: 'Curcu 6',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-6.jp2',slide : 1 ],
           [filename: 'Curcu 7',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-7.jp2',slide : 1 ],
           [filename: 'Curcu non soluble 1',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-non-soluble-1.jp2',slide : 2 ],
           [filename: 'Curcu non soluble 2',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-non-soluble-2.jp2',slide : 2 ],
           [filename: 'Curcu non soluble 3',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-non-soluble-3.jp2',slide : 2 ],
           [filename: 'Curcu non soluble 4',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-non-soluble-4.jp2',slide : 2 ],
           [filename: 'Curcu non soluble 5',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Curcu-non-soluble-5.jp2',slide : 2 ],
           [filename: 'Gemzar 1',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-1.jp2',slide : 3 ],
           [filename: 'Gemzar 2',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-2.jp2',slide : 3 ],
           [filename: 'Gemzar 3',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-3.jp2',slide : 3 ],
           [filename: 'Gemzar 4',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-4.jp2',slide : 3 ],
           [filename: 'Gemzar 5',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-5.jp2',slide : 3 ],
           [filename: 'Gemzar 6',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-6.jp2',slide : 3 ],
           [filename: 'Gemzar 7',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-7.jp2',slide : 3 ],
           [filename: 'Gemzar 8', path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-8.jp2',slide : 3 ],
           [filename: 'Gemzar + Curcu 1',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-Curcu-1.jp2',slide : 4 ],
           [filename: 'Gemzar + Curcu 2',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-Curcu-2.jp2',slide : 4 ],
           [filename: 'Gemzar + Curcu 3',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-Curcu-3.jp2',slide : 4 ],
           [filename: 'Gemzar + Curcu 4',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-Curcu-4.jp2',slide : 4 ],
           [filename: 'Gemzar + Curcu 5',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-Curcu-5.jp2',slide : 4 ],
           [filename: 'Gemzar + Curcu 6',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-Curcu-6.jp2',slide : 4 ],
           [filename: 'Gemzar + Curcu 7',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/Gemzar-Curcu-7.jp2',slide : 4 ],
           [filename: 'HPg 1',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/HPg-1.jp2',slide :5 ],
           [filename: 'HPg 3',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/HPg-3.jp2',slide :5 ],
           [filename: 'HPg 4',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/HPg-4.jp2',slide :5 ],
           [filename: 'HPg 5',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/HPg-5.jp2',slide :5 ],
           [filename: 'HPg 6',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/HPg-6.jp2',slide :5 ],
           [filename: 'HPg 7',path:'file:///media/datafast/tfeweb2010/BDs/WholeSlides/DCataldo/20090805-20090810/HPg-7.jp2',slide :5 ] */


                //ANAPATH
                [filename: '/media/datalvm/anapath/upload/vms/01c02157_lba-2011-01-2523.21.42_clip.vms',name: '01c02157_lba-2011-01-2523.21.42_clip.vms',study:'ANAPATH', extension:"vms"],
                [filename: '/media/datalvm/anapath/upload/vms/10C12080-LBAPap-2010-12-0912.18.51_clip.vms', name: '10C12080-LBAPap-2010-12-0912.18.51_clip.vms',study:'ANAPATH', extension:"vms"],
                [filename: '/media/datalvm/anapath/upload/vms/OVA17cyto-2010-11-1513.09.42_clip.vms', name : 'OVA17cyto-2010-11-1513.09.42_clip.vms',study:'ANAPATH', extension:"vms"],


                //OTHER
                [filename: 'file:///media/datafast/tfeweb2010/BDs/WholeSlides/Boyden/essai_10x_02.one.jp2', name: 'Boyden - essai _10x_02', study:'OTHER'],
                [filename: 'file:///media/datafast/tfeweb2010/BDs/WholeSlides/Aperio/003.jp2',name:'Aperio - 003',study:'OTHER'],
                [filename: 'file:///media/datafast/tfeweb2010/BDs/WholeSlides/Aperio/2005900969-2.jp2', name: 'Aperio - 2005900969-2', study:'OTHER'],
                [filename: 'file:///media/datafast/tfeweb2010/BDs/WholeSlides/PhDelvenne/2_02_JPEG_70pc_cropnew.jp2', name:'70pc_cropnew', study:'OTHER' ],


                //NEO13
                /*[filename:'file:///home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/ImageNEO13_CNS_5.10_5_4_01.tif.jp2',name:'ImageNEO13_CNS_5.10_5_4_01.tif.jp2',study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/ImageNEO13_CNS_5.1_5_3_01.tif.jp2',name:'ImageNEO13_CNS_5.1_5_3_01.tif.jp2',study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/ImageNEO13_CNS_5.20_5_5_01.tif.jp2',name:'ImageNEO13_CNS_5.20_5_5_01.tif.jp2',study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_1.10_5_1_01.tif.jp2',name:'NEO13_CNS_1.10_5_1_01.tif.jp2',slidename:'NEO13_CNS_1',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_1.1_4_10_01.tif.jp2',name:'NEO13_CNS_1.1_4_10_01.tif.jp2',slidename:'NEO13_CNS_1',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_1.20_5_2_01.tif.jp2',name:'NEO13_CNS_1.20_5_2_01.tif.jp2',slidename:'NEO13_CNS_1',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_1.30_5_3_01.tif.jp2',name:'NEO13_CNS_1.30_5_3_01.tif.jp2',slidename:'NEO13_CNS_1',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_1.40_5_4_01.tif.jp2',name:'NEO13_CNS_1.40_5_4_01.tif.jp2',slidename:'NEO13_CNS_1',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_1.50_5_5_01.tif.jp2',name:'NEO13_CNS_1.50_5_5_01.tif.jp2',slidename:'NEO13_CNS_1',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_1.60_5_6_01.tif.jp2',name:'NEO13_CNS_1.60_5_6_01.tif.jp2',slidename:'NEO13_CNS_1',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_1.70_5_7_01.tif.jp2',name:'NEO13_CNS_1.70_5_7_01.tif.jp2',slidename:'NEO13_CNS_1',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_2.10_4_3_01.tif.jp2',name:'NEO13_CNS_2.10_4_3_01.tif.jp2',slidename:'NEO13_CNS_2',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_2.1_4_2_01.tif.jp2',name:'NEO13_CNS_2.1_4_2_01.tif.jp2',slidename:'NEO13_CNS_2',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_2.20_4_4_01.tif.jp2',name:'NEO13_CNS_2.20_4_4_01.tif.jp2',slidename:'NEO13_CNS_2',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_2.30_4_5_01.tif.jp2',name:'NEO13_CNS_2.30_4_5_01.tif.jp2',slidename:'NEO13_CNS_2',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_2.40_4_6_01.tif.jp2',name:'NEO13_CNS_2.40_4_6_01.tif.jp2',slidename:'NEO13_CNS_2',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_2.50_4_7_01.tif.jp2',name:'NEO13_CNS_2.50_4_7_01.tif.jp2',slidename:'NEO13_CNS_2',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_2.60_4_8_01.tif.jp2',name:'NEO13_CNS_2.60_4_8_01.tif.jp2',slidename:'NEO13_CNS_2',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_2.70_4_9_01.tif.jp2',name:'NEO13_CNS_2.70_4_9_01.tif.jp2',slidename:'NEO13_CNS_2',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_3.10_3_5_01.tif.jp2',name:'NEO13_CNS_3.10_3_5_01.tif.jp2',slidename:'NEO13_CNS_3',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_3.1_3_4_01.tif.jp2',name:'NEO13_CNS_3.1_3_4_01.tif.jp2',slidename:'NEO13_CNS_3',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_3.20_3_6_01.tif.jp2',name:'NEO13_CNS_3.20_3_6_01.tif.jp2',slidename:'NEO13_CNS_3',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_3.30_3_7_01.tif.jp2',name:'NEO13_CNS_3.30_3_7_01.tif.jp2',slidename:'NEO13_CNS_3',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_3.40_3_8_01.tif.jp2',name:'NEO13_CNS_3.40_3_8_01.tif.jp2',slidename:'NEO13_CNS_3',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_3.50_3_9_01.tif.jp2',name:'NEO13_CNS_3.50_3_9_01.tif.jp2',slidename:'NEO13_CNS_3',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_3.60_3_10_01.tif.jp2',name:'NEO13_CNS_3.60_3_10_01.tif.jp2',slidename:'NEO13_CNS_3',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_3.70_4_1_01.tif.jp2',name:'NEO13_CNS_3.70_4_1_01.tif.jp2',slidename:'NEO13_CNS_3',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_4.10_2_7_01.tif.jp2',name:'NEO13_CNS_4.10_2_7_01.tif.jp2',slidename:'NEO13_CNS_4',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_4.1_2_6_01.tif.jp2',name:'NEO13_CNS_4.1_2_6_01.tif.jp2',slidename:'NEO13_CNS_4',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_4.20_2_8_01.tif.jp2',name:'NEO13_CNS_4.20_2_8_01.tif.jp2',slidename:'NEO13_CNS_4',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_4.30_2_9_01.tif.jp2',name:'NEO13_CNS_4.30_2_9_01.tif.jp2',slidename:'NEO13_CNS_4',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_4.40_2_10_01.tif.jp2',name:'NEO13_CNS_4.40_2_10_01.tif.jp2',slidename:'NEO13_CNS_4',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_4.50_3_1_01.tif.jp2',name:'NEO13_CNS_4.50_3_1_01.tif.jp2',slidename:'NEO13_CNS_4',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_4.60_3_2_01.tif.jp2',name:'NEO13_CNS_4.60_3_2_01.tif.jp2',slidename:'NEO13_CNS_4',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_4.70_3_3_01.tif.jp2',name:'NEO13_CNS_4.70_3_3_01.tif.jp2',slidename:'NEO13_CNS_4',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_5.30_1_3_01.tif.jp2',name:'NEO13_CNS_5.30_1_3_01.tif.jp2',slidename:'NEO13_CNS_5',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_5.40_1_4_01.tif.jp2',name:'NEO13_CNS_5.40_1_4_01.tif.jp2',slidename:'NEO13_CNS_5',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_5.50_1_5_01.tif.jp2',name:'NEO13_CNS_5.50_1_5_01.tif.jp2',slidename:'NEO13_CNS_5',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_5.60_1_6_01.tif.jp2',name:'NEO13_CNS_5.60_1_6_01.tif.jp2',slidename:'NEO13_CNS_5',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_5.70_1_7_01.tif.jp2',name:'NEO13_CNS_5.70_1_7_01.tif.jp2',slidename:'NEO13_CNS_5',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_6.10_1_9_01.tif.jp2',name:'NEO13_CNS_6.10_1_9_01.tif.jp2',slidename:'NEO13_CNS_6',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_6.1_1_8_01.tif.jp2',name:'NEO13_CNS_6.1_1_8_01.tif.jp2',slidename:'NEO13_CNS_6',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_6.20_1_10_01.tif.jp2',name:'NEO13_CNS_6.20_1_10_01.tif.jp2',slidename:'NEO13_CNS_6',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_6.30_2_1_01.tif.jp2',name:'NEO13_CNS_6.30_2_1_01.tif.jp2',slidename:'NEO13_CNS_6',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_6.40_2_2_01.tif.jp2',name:'NEO13_CNS_6.40_2_2_01.tif.jp2',slidename:'NEO13_CNS_6',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_6.50_2_3_01.tif.jp2',name:'NEO13_CNS_6.50_2_3_01.tif.jp2',slidename:'NEO13_CNS_6',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_6.60_2_4_01.tif.jp2',name:'NEO13_CNS_6.60_2_4_01.tif.jp2',slidename:'NEO13_CNS_6',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_CNS/converti/jpg/NEO13_CNS_6.70_2_5_01.tif.jp2',name:'NEO13_CNS_6.70_2_5_01.tif.jp2',slidename:'NEO13_CNS_6',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_1.10_01.tif.jp2',name:'NEO_13_Curcu_90pc_1.10_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_1',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_1.1_01.tif.jp2',name:'NEO_13_Curcu_90pc_1.1_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_1',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_1.20_01.tif.jp2',name:'NEO_13_Curcu_90pc_1.20_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_1',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_1.30_01.tif.jp2',name:'NEO_13_Curcu_90pc_1.30_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_1',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_1.40_01.tif.jp2',name:'NEO_13_Curcu_90pc_1.40_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_1',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_1.50_01.tif.jp2',name:'NEO_13_Curcu_90pc_1.50_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_1',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_1.60_01.tif.jp2',name:'NEO_13_Curcu_90pc_1.60_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_1',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_1.70_01.tif.jp2',name:'NEO_13_Curcu_90pc_1.70_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_1',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_2.10_01.tif.jp2',name:'NEO_13_Curcu_90pc_2.10_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_2',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_2.1_01.tif.jp2',name:'NEO_13_Curcu_90pc_2.1_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_2',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_2.20_01.tif.jp2',name:'NEO_13_Curcu_90pc_2.20_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_2',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_2.30_01.tif.jp2',name:'NEO_13_Curcu_90pc_2.30_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_2',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_2.40_01.tif.jp2',name:'NEO_13_Curcu_90pc_2.40_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_2',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_2.50_01.tif.jp2',name:'NEO_13_Curcu_90pc_2.50_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_2',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_2.60_01.tif.jp2',name:'NEO_13_Curcu_90pc_2.60_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_2',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_2.70_01.tif.jp2',name:'NEO_13_Curcu_90pc_2.70_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_2',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_3.10_01.tif.jp2',name:'NEO_13_Curcu_90pc_3.10_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_3',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_3.1_01.tif.jp2',name:'NEO_13_Curcu_90pc_3.1_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_3',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_3.20_01.tif.jp2',name:'NEO_13_Curcu_90pc_3.20_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_3',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_3.30_01.tif.jp2',name:'NEO_13_Curcu_90pc_3.30_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_3',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_3.40_01.tif.jp2',name:'NEO_13_Curcu_90pc_3.40_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_3',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_3.50_01.tif.jp2',name:'NEO_13_Curcu_90pc_3.50_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_3',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_3.60_01.tif.jp2',name:'NEO_13_Curcu_90pc_3.60_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_3',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_3.70_01.tif.jp2',name:'NEO_13_Curcu_90pc_3.70_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_3',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_4.10_01.tif.jp2',name:'NEO_13_Curcu_90pc_4.10_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_4',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_4.1_01.tif.jp2',name:'NEO_13_Curcu_90pc_4.1_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_4',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_4.20_01.tif.jp2',name:'NEO_13_Curcu_90pc_4.20_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_4',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_4.30_01.tif.jp2',name:'NEO_13_Curcu_90pc_4.30_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_4',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_4.40_01.tif.jp2',name:'NEO_13_Curcu_90pc_4.40_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_4',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_4.50_01.tif.jp2',name:'NEO_13_Curcu_90pc_4.50_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_4',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_4.60_01.tif.jp2',name:'NEO_13_Curcu_90pc_4.60_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_4',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_4.70_01.tif.jp2',name:'NEO_13_Curcu_90pc_4.70_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_4',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_5.10_01.tif.jp2',name:'NEO_13_Curcu_90pc_5.10_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_5',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_5.1_01.tif.jp2',name:'NEO_13_Curcu_90pc_5.1_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_5',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_5.20_01.tif.jp2',name:'NEO_13_Curcu_90pc_5.20_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_5',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_5.30_01.tif.jp2',name:'NEO_13_Curcu_90pc_5.30_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_5',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_5.40_01.tif.jp2',name:'NEO_13_Curcu_90pc_5.40_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_5',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_5.50_01.tif.jp2',name:'NEO_13_Curcu_90pc_5.50_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_5',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_5.60_01.tif.jp2',name:'NEO_13_Curcu_90pc_5.60_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_5',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_5.70_01.tif.jp2',name:'NEO_13_Curcu_90pc_5.70_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_5',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_6.10_01.tif.jp2',name:'NEO_13_Curcu_90pc_6.10_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_6',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_6.1_01.tif.jp2',name:'NEO_13_Curcu_90pc_6.1_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_6',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_6.20_01.tif.jp2',name:'NEO_13_Curcu_90pc_6.20_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_6',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_6.30_01.tif.jp2',name:'NEO_13_Curcu_90pc_6.30_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_6',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_6.40_01.tif.jp2',name:'NEO_13_Curcu_90pc_6.40_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_6',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_6.50_01.tif.jp2',name:'NEO_13_Curcu_90pc_6.50_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_6',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_6.60_01.tif.jp2',name:'NEO_13_Curcu_90pc_6.60_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_6',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_90/converti/jpg/NEO_13_Curcu_90pc_6.70_01.tif.jp2',name:'NEO_13_Curcu_90pc_6.70_01.tif.jp2',slidename:'NEO_13_Curcu_90pc_6',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_1.10_2_01.tif.jp2',name:'NEO_13_Curcu_93pc_1.10_2_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_1',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_1.1_1_01.tif.jp2',name:'NEO_13_Curcu_93pc_1.1_1_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_1',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_1.20_3_01.tif.jp2',name:'NEO_13_Curcu_93pc_1.20_3_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_1',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_1.30_4_01.tif.jp2',name:'NEO_13_Curcu_93pc_1.30_4_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_1',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_1.40_5_01.tif.jp2',name:'NEO_13_Curcu_93pc_1.40_5_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_1',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_1.50_6_01.tif.jp2',name:'NEO_13_Curcu_93pc_1.50_6_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_1',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_1.60_7_01.tif.jp2',name:'NEO_13_Curcu_93pc_1.60_7_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_1',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_1.70_8_01.tif.jp2',name:'NEO_13_Curcu_93pc_1.70_8_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_1',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_2.10_10_01.tif.jp2',name:'NEO_13_Curcu_93pc_2.10_10_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_2',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_2.1_9_01.tif.jp2',name:'NEO_13_Curcu_93pc_2.1_9_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_2',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_2.20_1_01.tif.jp2',name:'NEO_13_Curcu_93pc_2.20_1_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_2',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_2.30_2_01.tif.jp2',name:'NEO_13_Curcu_93pc_2.30_2_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_2',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_2.40_3_01.tif.jp2',name:'NEO_13_Curcu_93pc_2.40_3_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_2',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_2.50_4_01.tif.jp2',name:'NEO_13_Curcu_93pc_2.50_4_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_2',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_2.60_5_01.tif.jp2',name:'NEO_13_Curcu_93pc_2.60_5_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_2',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_2.70_6_01.tif.jp2',name:'NEO_13_Curcu_93pc_2.70_6_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_2',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_3.10_8_01.tif.jp2',name:'NEO_13_Curcu_93pc_3.10_8_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_3',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_3.1_7_01.tif.jp2',name:'NEO_13_Curcu_93pc_3.1_7_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_3',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_3.20_9_01.tif.jp2',name:'NEO_13_Curcu_93pc_3.20_9_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_3',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_3.30_10_01.tif.jp2',name:'NEO_13_Curcu_93pc_3.30_10_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_3',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_3.40_1_01.tif.jp2',name:'NEO_13_Curcu_93pc_3.40_1_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_3',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO13_CURCU_93pc_3.50_1_1_01.tif.jp2',name:'NEO13_CURCU_93pc_3.50_1_1_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_3',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_3.60_3_01.tif.jp2',name:'NEO_13_Curcu_93pc_3.60_3_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_3',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO13_CURCU_93pc_3.70_1_2_01.tif.jp2',name:'NEO13_CURCU_93pc_3.70_1_2_01.tif.jp2',slidename:'NEO_13_Curcu_93pc_3',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_4.10.tif.jp2',name:'NEO_13_Curcu_93pc_4.10.tif.jp2',slidename:'NEO_13_Curcu_93pc_4',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_4.1.tif.jp2',name:'NEO_13_Curcu_93pc_4.1.tif.jp2',slidename:'NEO_13_Curcu_93pc_4',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_4.20.tif.jp2',name:'NEO_13_Curcu_93pc_4.20.tif.jp2',slidename:'NEO_13_Curcu_93pc_4',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_4.30.tif.jp2',name:'NEO_13_Curcu_93pc_4.30.tif.jp2',slidename:'NEO_13_Curcu_93pc_4',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_4.40.tif.jp2',name:'NEO_13_Curcu_93pc_4.40.tif.jp2',slidename:'NEO_13_Curcu_93pc_4',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_4.50.tif.jp2',name:'NEO_13_Curcu_93pc_4.50.tif.jp2',slidename:'NEO_13_Curcu_93pc_4',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_4.60.tif.jp2',name:'NEO_13_Curcu_93pc_4.60.tif.jp2',slidename:'NEO_13_Curcu_93pc_4',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_4.70.tif.jp2',name:'NEO_13_Curcu_93pc_4.70.tif.jp2',slidename:'NEO_13_Curcu_93pc_4',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_5.10.tif.jp2',name:'NEO_13_Curcu_93pc_5.10.tif.jp2',slidename:'NEO_13_Curcu_93pc_5',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_5.1.tif.jp2',name:'NEO_13_Curcu_93pc_5.1.tif.jp2',slidename:'NEO_13_Curcu_93pc_5',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_5.20.tif.jp2',name:'NEO_13_Curcu_93pc_5.20.tif.jp2',slidename:'NEO_13_Curcu_93pc_5',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_5.30.tif.jp2',name:'NEO_13_Curcu_93pc_5.30.tif.jp2',slidename:'NEO_13_Curcu_93pc_5',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_5.40.tif.jp2',name:'NEO_13_Curcu_93pc_5.40.tif.jp2',slidename:'NEO_13_Curcu_93pc_5',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_5.50.tif.jp2',name:'NEO_13_Curcu_93pc_5.50.tif.jp2',slidename:'NEO_13_Curcu_93pc_5',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_5.60.tif.jp2',name:'NEO_13_Curcu_93pc_5.60.tif.jp2',slidename:'NEO_13_Curcu_93pc_5',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_5.70.tif.jp2',name:'NEO_13_Curcu_93pc_5.70.tif.jp2',slidename:'NEO_13_Curcu_93pc_5',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_6.10.tif.jp2',name:'NEO_13_Curcu_93pc_6.10.tif.jp2',slidename:'NEO_13_Curcu_93pc_6',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_6.1.tif.jp2',name:'NEO_13_Curcu_93pc_6.1.tif.jp2',slidename:'NEO_13_Curcu_93pc_6',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_6.20.tif.jp2',name:'NEO_13_Curcu_93pc_6.20.tif.jp2',slidename:'NEO_13_Curcu_93pc_6',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_6.30.tif.jp2',name:'NEO_13_Curcu_93pc_6.30.tif.jp2',slidename:'NEO_13_Curcu_93pc_6',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_6.40.tif.jp2',name:'NEO_13_Curcu_93pc_6.40.tif.jp2',slidename:'NEO_13_Curcu_93pc_6',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_6.50.tif.jp2',name:'NEO_13_Curcu_93pc_6.50.tif.jp2',slidename:'NEO_13_Curcu_93pc_6',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_6.60.tif.jp2',name:'NEO_13_Curcu_93pc_6.60.tif.jp2',slidename:'NEO_13_Curcu_93pc_6',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_93/converti/jpg/NEO_13_Curcu_93pc_6.70.tif.jp2',name:'NEO_13_Curcu_93pc_6.70.tif.jp2',slidename:'NEO_13_Curcu_93pc_6',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_2.20_1_1_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_2.20_1_1_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_2',order:20,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_2.30_1_2_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_2.30_1_2_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_2',order:30,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_2.40_1_3_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_2.40_1_3_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_2',order:40,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_2.50_1_4_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_2.50_1_4_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_2',order:50,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_2.60_1_5_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_2.60_1_5_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_2',order:60,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_2.70_1_6_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_2.70_1_6_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_2',order:70,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_3.10_1_8_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_3.10_1_8_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_3',order:10,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_3.1_1_7_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_3.1_1_7_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_3',order:1,study:'LBTD NEO13'		],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_3.20_1_9_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_3.20_1_9_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_3',order:20,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_3.30_1_10_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_3.30_1_10_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_3',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_3.40_2_1_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_3.40_2_1_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_3',order:40,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_3.50_2_2_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_3.50_2_2_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_3',order:50,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_3.60_2_3_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_3.60_2_3_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_3',order:60,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_3.70_2_4_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_3.70_2_4_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_3',order:70,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_4.10_2_6_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_4.10_2_6_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_4',order:10,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_4.1_2_5_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_4.1_2_5_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_4'  ,order:1,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_4.20_2_7_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_4.20_2_7_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_4',order:20,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_4.30_2_8_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_4.30_2_8_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_4',order:30,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_4.40_2_9_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_4.40_2_9_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_4',order:40,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_4.50_2_10_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_4.50_2_10_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_4',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_4.60_3_1_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_4.60_3_1_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_4',order:60,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_4.70_3_2_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_4.70_3_2_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_4',order:70,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_5.10_3_4_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_5.10_3_4_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_5',order:10,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_5.1_3_3_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_5.1_3_3_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_5'  ,order:1,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_5.20_3_5_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_5.20_3_5_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_5',order:20,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_5.30_3_6_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_5.30_3_6_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_5',order:30,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_5.40_3_7_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_5.40_3_7_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_5',order:40,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_5.50_3_8_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_5.50_3_8_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_5',order:50,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_5.70_3_10_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_5.70_3_10_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_5',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_6.10_4_2_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_6.10_4_2_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_6,',order:10,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_6.1_4_1_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_6.1_4_1_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_6',order:1,study:'LBTD NEO13'		],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_6.20_4_3_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_6.20_4_3_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_6',order:20,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_6.30_4_4_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_6.30_4_4_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_6',order:30,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_6.40_4_5_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_6.40_4_5_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_6',order:40,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_6.50_4_6_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_6.50_4_6_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_6',order:50,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_6.60_4_7_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_6.60_4_7_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_6',order:60,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/ImageNEO_13_Curcu_99pc_6.70_4_8_01.tif.jp2',name:'ImageNEO_13_Curcu_99pc_6.70_4_8_01.tif.jp2',slidename:'ImageNEO_13_Curcu_99pc_6',order:70,study:'LBTD NEO13'	],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/NEO_13_Curcu_99pc_2.10.tif.jp2',name:'NEO_13_Curcu_99pc_2.10.tif.jp2',slidename:'NEO_13_Curcu_99pc_2',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_curcu_99/converti/jpg/NEO_13_Curcu_99pc_2.1.tif.jp2',name:'NEO_13_Curcu_99pc_2.1.tif.jp2',slidename:'NEO_13_Curcu_99pc_2',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO13_HPg_1.10_5_9_01.tif.jp2',name:'NEO13_HPg_1.10_5_9_01.tif.jp2',slidename:'NEO13_HPg_1',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO13_HPg_1.1_5_8_01.tif.jp2',name:'NEO13_HPg_1.1_5_8_01.tif.jp2',slidename:'NEO13_HPg_1',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO13_HPg_1.20_5_10_01.tif.jp2',name:'NEO13_HPg_1.20_5_10_01.tif.jp2',slidename:'NEO13_HPg_1',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_1.30__HE01.tif.jp2',name:'NEO_13_HPg_Gav_1.30__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_1',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_1.40__HE01.tif.jp2',name:'NEO_13_HPg_Gav_1.40__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_1',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_1.50__HE01.tif.jp2',name:'NEO_13_HPg_Gav_1.50__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_1',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_1.60__HE01.tif.jp2',name:'NEO_13_HPg_Gav_1.60__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_1',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_1.70__HE01.tif.jp2',name:'NEO_13_HPg_Gav_1.70__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_1',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_2.10__HE01.tif.jp2',name:'NEO_13_HPg_Gav_2.10__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_2',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_2.1__HE01.tif.jp2',name:'NEO_13_HPg_Gav_2.1__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_2',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_2.20__HE01.tif.jp2',name:'NEO_13_HPg_Gav_2.20__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_2',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_2.30__HE01.tif.jp2',name:'NEO_13_HPg_Gav_2.30__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_2',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_2.40__HE01.tif.jp2',name:'NEO_13_HPg_Gav_2.40__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_2',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_2.50__HE01.tif.jp2',name:'NEO_13_HPg_Gav_2.50__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_2',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_2.60__HE01.tif.jp2',name:'NEO_13_HPg_Gav_2.60__HE01.tif.jp2',slidename:'NEO_13_HPg_Gav_2',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_2.70__01.tif.jp2',name:'NEO_13_HPg_Gav_2.70__01.tif.jp2',slidename:'NEO_13_HPg_Gav_2',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_3.10__01.tif.jp2',name:'NEO_13_HPg_Gav_3.10__01.tif.jp2',slidename:'NEO_13_HPg_Gav_3',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_3.1__01.tif.jp2',name:'NEO_13_HPg_Gav_3.1__01.tif.jp2',slidename:'NEO_13_HPg_Gav_3',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_3.20__01.tif.jp2',name:'NEO_13_HPg_Gav_3.20__01.tif.jp2',slidename:'NEO_13_HPg_Gav_3',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_3.30__01.tif.jp2',name:'NEO_13_HPg_Gav_3.30__01.tif.jp2',slidename:'NEO_13_HPg_Gav_3',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_3.40__01.tif.jp2',name:'NEO_13_HPg_Gav_3.40__01.tif.jp2',slidename:'NEO_13_HPg_Gav_3',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_3.50__01.tif.jp2',name:'NEO_13_HPg_Gav_3.50__01.tif.jp2',slidename:'NEO_13_HPg_Gav_3',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_3.60__01.tif.jp2',name:'NEO_13_HPg_Gav_3.60__01.tif.jp2',slidename:'NEO_13_HPg_Gav_3',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_3.70__01.tif.jp2',name:'NEO_13_HPg_Gav_3.70__01.tif.jp2',slidename:'NEO_13_HPg_Gav_3',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_4.10__01.tif.jp2',name:'NEO_13_HPg_Gav_4.10__01.tif.jp2',slidename:'NEO_13_HPg_Gav_4',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_4.1__01.tif.jp2',name:'NEO_13_HPg_Gav_4.1__01.tif.jp2',slidename:'NEO_13_HPg_Gav_4',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_4.20__01.tif.jp2',name:'NEO_13_HPg_Gav_4.20__01.tif.jp2',slidename:'NEO_13_HPg_Gav_4',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_4.30__01.tif.jp2',name:'NEO_13_HPg_Gav_4.30__01.tif.jp2',slidename:'NEO_13_HPg_Gav_4',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_4.40__01.tif.jp2',name:'NEO_13_HPg_Gav_4.40__01.tif.jp2',slidename:'NEO_13_HPg_Gav_4',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_4.50__01.tif.jp2',name:'NEO_13_HPg_Gav_4.50__01.tif.jp2',slidename:'NEO_13_HPg_Gav_4',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_4.60__01.tif.jp2',name:'NEO_13_HPg_Gav_4.60__01.tif.jp2',slidename:'NEO_13_HPg_Gav_4',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_4.70__01.tif.jp2',name:'NEO_13_HPg_Gav_4.70__01.tif.jp2',slidename:'NEO_13_HPg_Gav_4',order:70,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_5.10__01.tif.jp2',name:'NEO_13_HPg_Gav_5.10__01.tif.jp2',slidename:'NEO_13_HPg_Gav_5',order:10,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_5.1__01.tif.jp2',name:'NEO_13_HPg_Gav_5.1__01.tif.jp2',slidename:'NEO_13_HPg_Gav_5',order:1,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_5.20__01.tif.jp2',name:'NEO_13_HPg_Gav_5.20__01.tif.jp2',slidename:'NEO_13_HPg_Gav_5',order:20,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_5.30__01.tif.jp2',name:'NEO_13_HPg_Gav_5.30__01.tif.jp2',slidename:'NEO_13_HPg_Gav_5',order:30,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_5.40__01.tif.jp2',name:'NEO_13_HPg_Gav_5.40__01.tif.jp2',slidename:'NEO_13_HPg_Gav_5',order:40,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_5.50__01.tif.jp2',name:'NEO_13_HPg_Gav_5.50__01.tif.jp2',slidename:'NEO_13_HPg_Gav_5',order:50,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_5.60__01.tif.jp2',name:'NEO_13_HPg_Gav_5.60__01.tif.jp2',slidename:'NEO_13_HPg_Gav_5',order:60,study:'LBTD NEO13'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO13/grp_HPg/converti/jpg/NEO_13_HPg_Gav_5.70__01.tif.jp2',name:'NEO_13_HPg_Gav_5.70__01.tif.jp2',slidename:'NEO_13_HPg_Gav_5',order:70,study:'LBTD NEO13'],*/

                //NEO4
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_1.10_3_2_01.tif.jp2',name:'NEO_4_Curcu_INH_1.10_3_2_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_1.1_3_1_01.tif.jp2',name:'NEO_4_Curcu_INH_1.1_3_1_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_1.20_3_3_01.tif.jp2',name:'NEO_4_Curcu_INH_1.20_3_3_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_1.30_3_4_01.tif.jp2',name:'NEO_4_Curcu_INH_1.30_3_4_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_1.40_3_5_01.tif.jp2',name:'NEO_4_Curcu_INH_1.40_3_5_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_1.50_3_6_01.tif.jp2',name:'NEO_4_Curcu_INH_1.50_3_6_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_1.60_3_7_01.tif.jp2',name:'NEO_4_Curcu_INH_1.60_3_7_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_1.70_3_8_01.tif.jp2',name:'NEO_4_Curcu_INH_1.70_3_8_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_2.10_3_10_01.tif.jp2',name:'NEO_4_Curcu_INH_2.10_3_10_01.tif.jp2',slidename:'NEO_4_Curcu_INH_2',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_2.1_3_9_01.tif.jp2',name:'NEO_4_Curcu_INH_2.1_3_9_01.tif.jp2',slidename:'NEO_4_Curcu_INH_2',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_2.20_4_1_01.tif.jp2',name:'NEO_4_Curcu_INH_2.20_4_1_01.tif.jp2',slidename:'NEO_4_Curcu_INH_2',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_2.30_4_2_01.tif.jp2',name:'NEO_4_Curcu_INH_2.30_4_2_01.tif.jp2',slidename:'NEO_4_Curcu_INH_2',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO_4_Curcu_INH_2.40_1_1_01HE.tif.jp2',name:'NEO_4_Curcu_INH_2.40_1_1_01HE.tif.jp2',slidename:'NEO_4_Curcu_INH_2',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_2.50_01.tif.jp2',name:'NEO4_CURCU_INH_2.50_01.tif.jp2',slidename:'NEO_4_Curcu_INH_2',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_2.60_01.tif.jp2',name:'NEO4_CURCU_INH_2.60_01.tif.jp2',slidename:'NEO_4_Curcu_INH_2',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_2.70_01.tif.jp2',name:'NEO4_CURCU_INH_2.70_01.tif.jp2',slidename:'NEO_4_Curcu_INH_2',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_3.10_01.tif.jp2',name:'NEO4_CURCU_INH_3.10_01.tif.jp2',slidename:'NEO_4_Curcu_INH_3',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_3.1_01.tif.jp2',name:'NEO4_CURCU_INH_3.1_01.tif.jp2',slidename:'NEO_4_Curcu_INH_3',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_3.20_01.tif.jp2',name:'NEO4_CURCU_INH_3.20_01.tif.jp2',slidename:'NEO_4_Curcu_INH_3',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_3.30_01.tif.jp2',name:'NEO4_CURCU_INH_3.30_01.tif.jp2',slidename:'NEO_4_Curcu_INH_3',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_3.40_01.tif.jp2',name:'NEO4_CURCU_INH_3.40_01.tif.jp2',slidename:'NEO_4_Curcu_INH_3',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_3.50_01.tif.jp2',name:'NEO4_CURCU_INH_3.50_01.tif.jp2',slidename:'NEO_4_Curcu_INH_3',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_3.60_01.tif.jp2',name:'NEO4_CURCU_INH_3.60_01.tif.jp2',slidename:'NEO_4_Curcu_INH_3',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_3.70_01.tif.jp2',name:'NEO4_CURCU_INH_3.70_01.tif.jp2',slidename:'NEO_4_Curcu_INH_3',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_4.10_01.tif.jp2',name:'NEO4_CURCU_INH_4.10_01.tif.jp2',slidename:'NEO_4_Curcu_INH_4',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_4.1_01.tif.jp2',name:'NEO4_CURCU_INH_4.1_01.tif.jp2',slidename:'NEO_4_Curcu_INH_4',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_4.20_01.tif.jp2',name:'NEO4_CURCU_INH_4.20_01.tif.jp2',slidename:'NEO_4_Curcu_INH_4',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_4.30_01.tif.jp2',name:'NEO4_CURCU_INH_4.30_01.tif.jp2',slidename:'NEO_4_Curcu_INH_4',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_4.40_01.tif.jp2',name:'NEO4_CURCU_INH_4.40_01.tif.jp2',slidename:'NEO_4_Curcu_INH_4',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_4.50_01.tif.jp2',name:'NEO4_CURCU_INH_4.50_01.tif.jp2',slidename:'NEO_4_Curcu_INH_4',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_4.60_01.tif.jp2',name:'NEO4_CURCU_INH_4.60_01.tif.jp2',slidename:'NEO_4_Curcu_INH_4',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_4.70_01.tif.jp2',name:'NEO4_CURCU_INH_4.70_01.tif.jp2',slidename:'NEO_4_Curcu_INH_4',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_5.10_01.tif.jp2',name:'NEO4_CURCU_INH_5.10_01.tif.jp2',slidename:'NEO_4_Curcu_INH_5',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_5.1_01.tif.jp2',name:'NEO4_CURCU_INH_5.1_01.tif.jp2',slidename:'NEO_4_Curcu_INH_5',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_5.20_01.tif.jp2',name:'NEO4_CURCU_INH_5.20_01.tif.jp2',slidename:'NEO_4_Curcu_INH_5',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_5.30_01.tif.jp2',name:'NEO4_CURCU_INH_5.30_01.tif.jp2',slidename:'NEO_4_Curcu_INH_5',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_5.40_01.tif.jp2',name:'NEO4_CURCU_INH_5.40_01.tif.jp2',slidename:'NEO_4_Curcu_INH_5',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_5.50_01.tif.jp2',name:'NEO4_CURCU_INH_5.50_01.tif.jp2',slidename:'NEO_4_Curcu_INH_5',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_5.60_01.tif.jp2',name:'NEO4_CURCU_INH_5.60_01.tif.jp2',slidename:'NEO_4_Curcu_INH_5',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_5.70_01.tif.jp2',name:'NEO4_CURCU_INH_5.70_01.tif.jp2',slidename:'NEO_4_Curcu_INH_5',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_6.10_01.tif.jp2',name:'NEO4_CURCU_INH_6.10_01.tif.jp2',slidename:'NEO_4_Curcu_INH_6',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_6.1_01.tif.jp2',name:'NEO4_CURCU_INH_6.1_01.tif.jp2',slidename:'NEO_4_Curcu_INH_6',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_6.20_01.tif.jp2',name:'NEO4_CURCU_INH_6.20_01.tif.jp2',slidename:'NEO_4_Curcu_INH_6',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_6.30_01.tif.jp2',name:'NEO4_CURCU_INH_6.30_01.tif.jp2',slidename:'NEO_4_Curcu_INH_6',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_6.40_01.tif.jp2',name:'NEO4_CURCU_INH_6.40_01.tif.jp2',slidename:'NEO_4_Curcu_INH_6',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_6.50_01.tif.jp2',name:'NEO4_CURCU_INH_6.50_01.tif.jp2',slidename:'NEO_4_Curcu_INH_6',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_6.60_01.tif.jp2',name:'NEO4_CURCU_INH_6.60_01.tif.jp2',slidename:'NEO_4_Curcu_INH_6',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_6.70_01.tif.jp2',name:'NEO4_CURCU_INH_6.70_01.tif.jp2',slidename:'NEO_4_Curcu_INH_6',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_7.10_01.tif.jp2',name:'NEO4_CURCU_INH_7.10_01.tif.jp2',slidename:'NEO_4_Curcu_INH_7',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_7.1_01.tif.jp2',name:'NEO4_CURCU_INH_7.1_01.tif.jp2',slidename:'NEO_4_Curcu_INH_7',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_7.20_01.tif.jp2',name:'NEO4_CURCU_INH_7.20_01.tif.jp2',slidename:'NEO_4_Curcu_INH_7',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_7.30_01.tif.jp2',name:'NEO4_CURCU_INH_7.30_01.tif.jp2',slidename:'NEO_4_Curcu_INH_7',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_7.40_01.tif.jp2',name:'NEO4_CURCU_INH_7.40_01.tif.jp2',slidename:'NEO_4_Curcu_INH_7',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_7.50_01.tif.jp2',name:'NEO4_CURCU_INH_7.50_01.tif.jp2',slidename:'NEO_4_Curcu_INH_7',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_7.60_01.tif.jp2',name:'NEO4_CURCU_INH_7.60_01.tif.jp2',slidename:'NEO_4_Curcu_INH_7',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_7.70_01.tif.jp2',name:'NEO4_CURCU_INH_7.70_01.tif.jp2',slidename:'NEO_4_Curcu_INH_7',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_8.10_01.tif.jp2',name:'NEO4_CURCU_INH_8.10_01.tif.jp2',slidename:'NEO_4_Curcu_INH_8',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_8.1_01.tif.jp2',name:'NEO4_CURCU_INH_8.1_01.tif.jp2',slidename:'NEO_4_Curcu_INH_8',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_8.20_01.tif.jp2',name:'NEO4_CURCU_INH_8.20_01.tif.jp2',slidename:'NEO_4_Curcu_INH_8',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_8.30_01.tif.jp2',name:'NEO4_CURCU_INH_8.30_01.tif.jp2',slidename:'NEO_4_Curcu_INH_8',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/NEO4_CURCU_INH_8.4001.tif.jp2',name:'NEO4_CURCU_INH_8.4001.tif.jp2',slidename:'NEO_4_Curcu_INH_8',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/_NEO4_CURCU_INH_8.5001.tif.jp2',name:'_NEO4_CURCU_INH_8.5001.tif.jp2',slidename:'NEO_4_Curcu_INH_8',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/_NEO4_CURCU_INH_8.6001.tif.jp2',name:'_NEO4_CURCU_INH_8.6001.tif.jp2',slidename:'NEO_4_Curcu_INH_8',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_Curcu_INH/converti/jpg/_NEO4_CURCU_INH_8.7001.tif.jp2',name:'_NEO4_CURCU_INH_8.7001.tif.jp2',slidename:'NEO_4_Curcu_INH_8',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_1.10__01.tif.jp2',name:'NEO4_HPg_INH_1.10__01.tif.jp2',slidename:'NEO4_HPg_INH_1',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_1.1__01.tif.jp2',name:'NEO4_HPg_INH_1.1__01.tif.jp2',slidename:'NEO4_HPg_INH_1',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_1.20__01.tif.jp2',name:'NEO4_HPg_INH_1.20__01.tif.jp2',slidename:'NEO4_HPg_INH_1',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_1.40__01.tif.jp2',name:'NEO4_HPg_INH_1.40__01.tif.jp2',slidename:'NEO4_HPg_INH_1',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_1.50__01.tif.jp2',name:'NEO4_HPg_INH_1.50__01.tif.jp2',slidename:'NEO4_HPg_INH_1',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_1.60__01.tif.jp2',name:'NEO4_HPg_INH_1.60__01.tif.jp2',slidename:'NEO4_HPg_INH_1',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_1.70__01.tif.jp2',name:'NEO4_HPg_INH_1.70__01.tif.jp2',slidename:'NEO4_HPg_INH_1',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_2.10__01.tif.jp2',name:'NEO4_HPg_INH_2.10__01.tif.jp2',slidename:'NEO4_HPg_INH_2',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_2.1__01.tif.jp2',name:'NEO4_HPg_INH_2.1__01.tif.jp2',slidename:'NEO4_HPg_INH_2',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_2.20__01.tif.jp2',name:'NEO4_HPg_INH_2.20__01.tif.jp2',slidename:'NEO4_HPg_INH_2',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_2.30__01.tif.jp2',name:'NEO4_HPg_INH_2.30__01.tif.jp2',slidename:'NEO4_HPg_INH_2',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_2.40__01.tif.jp2',name:'NEO4_HPg_INH_2.40__01.tif.jp2',slidename:'NEO4_HPg_INH_2',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_2.50__01.tif.jp2',name:'NEO4_HPg_INH_2.50__01.tif.jp2',slidename:'NEO4_HPg_INH_2',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_2.60__01.tif.jp2',name:'NEO4_HPg_INH_2.60__01.tif.jp2',slidename:'NEO4_HPg_INH_2',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_2.70__01.tif.jp2',name:'NEO4_HPg_INH_2.70__01.tif.jp2',slidename:'NEO4_HPg_INH_2',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_3.10__01.tif.jp2',name:'NEO4_HPg_INH_3.10__01.tif.jp2',slidename:'NEO4_HPg_INH_3',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_3.1__01.tif.jp2',name:'NEO4_HPg_INH_3.1__01.tif.jp2',slidename:'NEO4_HPg_INH_3',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_3.20__01.tif.jp2',name:'NEO4_HPg_INH_3.20__01.tif.jp2',slidename:'NEO4_HPg_INH_3',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_3.30__01.tif.jp2',name:'NEO4_HPg_INH_3.30__01.tif.jp2',slidename:'NEO4_HPg_INH_3',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_3.40__01.tif.jp2',name:'NEO4_HPg_INH_3.40__01.tif.jp2',slidename:'NEO4_HPg_INH_3',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_3.50__01.tif.jp2',name:'NEO4_HPg_INH_3.50__01.tif.jp2',slidename:'NEO4_HPg_INH_3',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_3.60__01.tif.jp2',name:'NEO4_HPg_INH_3.60__01.tif.jp2',slidename:'NEO4_HPg_INH_3',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_3.70__01.tif.jp2',name:'NEO4_HPg_INH_3.70__01.tif.jp2',slidename:'NEO4_HPg_INH_3',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_4.10__01.tif.jp2',name:'NEO4_HPg_INH_4.10__01.tif.jp2',slidename:'NEO4_HPg_INH_4',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_4.1__01.tif.jp2',name:'NEO4_HPg_INH_4.1__01.tif.jp2',slidename:'NEO4_HPg_INH_4',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_4.20__01.tif.jp2',name:'NEO4_HPg_INH_4.20__01.tif.jp2',slidename:'NEO4_HPg_INH_4',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_4.30__01.tif.jp2',name:'NEO4_HPg_INH_4.30__01.tif.jp2',slidename:'NEO4_HPg_INH_4',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_4.50__01.tif.jp2',name:'NEO4_HPg_INH_4.50__01.tif.jp2',slidename:'NEO4_HPg_INH_4',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_4.60__01.tif.jp2',name:'NEO4_HPg_INH_4.60__01.tif.jp2',slidename:'NEO4_HPg_INH_4',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_4.70__01.tif.jp2',name:'NEO4_HPg_INH_4.70__01.tif.jp2',slidename:'NEO4_HPg_INH_4',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_5.10__01.tif.jp2',name:'NEO4_HPg_INH_5.10__01.tif.jp2',slidename:'NEO4_HPg_INH_5',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_5.1__01.tif.jp2',name:'NEO4_HPg_INH_5.1__01.tif.jp2',slidename:'NEO4_HPg_INH_5',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_5.20__01.tif.jp2',name:'NEO4_HPg_INH_5.20__01.tif.jp2',slidename:'NEO4_HPg_INH_5',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_5.30__01.tif.jp2',name:'NEO4_HPg_INH_5.30__01.tif.jp2',slidename:'NEO4_HPg_INH_5',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_5.40__01.tif.jp2',name:'NEO4_HPg_INH_5.40__01.tif.jp2',slidename:'NEO4_HPg_INH_5',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_5.50__01.tif.jp2',name:'NEO4_HPg_INH_5.50__01.tif.jp2',slidename:'NEO4_HPg_INH_5',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_5.60__01.tif.jp2',name:'NEO4_HPg_INH_5.60__01.tif.jp2',slidename:'NEO4_HPg_INH_5',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_5.70__01.tif.jp2',name:'NEO4_HPg_INH_5.70__01.tif.jp2',slidename:'NEO4_HPg_INH_5',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_6.10__01.tif.jp2',name:'NEO4_HPg_INH_6.10__01.tif.jp2',slidename:'NEO4_HPg_INH_6',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_6.1__01.tif.jp2',name:'NEO4_HPg_INH_6.1__01.tif.jp2',slidename:'NEO4_HPg_INH_6',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_6.20__01.tif.jp2',name:'NEO4_HPg_INH_6.20__01.tif.jp2',slidename:'NEO4_HPg_INH_6',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_6.30__01.tif.jp2',name:'NEO4_HPg_INH_6.30__01.tif.jp2',slidename:'NEO4_HPg_INH_6',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_6.40__01.tif.jp2',name:'NEO4_HPg_INH_6.40__01.tif.jp2',slidename:'NEO4_HPg_INH_6',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_6.50__01.tif.jp2',name:'NEO4_HPg_INH_6.50__01.tif.jp2',slidename:'NEO4_HPg_INH_6',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_6.60__01.tif.jp2',name:'NEO4_HPg_INH_6.60__01.tif.jp2',slidename:'NEO4_HPg_INH_6',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_6.70__01.tif.jp2',name:'NEO4_HPg_INH_6.70__01.tif.jp2',slidename:'NEO4_HPg_INH_6',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_7.10__01.tif.jp2',name:'NEO4_HPg_INH_7.10__01.tif.jp2',slidename:'NEO4_HPg_INH_7',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/NEO4_HPg_INH_7.1__01.tif.jp2',name:'NEO4_HPg_INH_7.1__01.tif.jp2',slidename:'NEO4_HPg_INH_7',order:1,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_7.2001.tif.jp2',name:'_NEO4_HPg_INH_7.2001.tif.jp2',slidename:'NEO4_HPg_INH_7',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_7.3001.tif.jp2',name:'_NEO4_HPg_INH_7.3001.tif.jp2',slidename:'NEO4_HPg_INH_7',order:30,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_7.4001.tif.jp2',name:'_NEO4_HPg_INH_7.4001.tif.jp2',slidename:'NEO4_HPg_INH_7',order:40,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_7.5001.tif.jp2',name:'_NEO4_HPg_INH_7.5001.tif.jp2',slidename:'NEO4_HPg_INH_7',order:50,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_7.6001.tif.jp2',name:'_NEO4_HPg_INH_7.6001.tif.jp2',slidename:'NEO4_HPg_INH_7',order:60,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_7.7001.tif.jp2',name:'_NEO4_HPg_INH_7.7001.tif.jp2',slidename:'NEO4_HPg_INH_7',order:70,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_8.1001.tif.jp2',name:'_NEO4_HPg_INH_8.1001.tif.jp2',slidename:'NEO4_HPg_INH_8',order:10,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_8.101.tif.jp2',name:'_NEO4_HPg_INH_8.101.tif.jp2',slidename:'NEO4_HPg_INH_8',order:11,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_8.2001.tif.jp2',name:'_NEO4_HPg_INH_8.2001.tif.jp2',slidename:'NEO4_HPg_INH_8',order:20,study:'LBTD NEO4'],
                [filename:'file:////home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_8.3001.tif.jp2',name:'_NEO4_HPg_INH_8.3001.tif.jp2',slidename:'NEO4_HPg_INH_8',order:30,study:'LBTD NEO4'],
                [filename:'file:///home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_8.4001.tif.jp2',name:'_NEO4_HPg_INH_8.4001.tif.jp2',slidename:'NEO4_HPg_INH_8',order:40,study:'LBTD NEO4'],
                [filename:'file:///home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_8.5001.tif.jp2',name:'_NEO4_HPg_INH_8.5001.tif.jp2',slidename:'NEO4_HPg_INH_8',order:50,study:'LBTD NEO4'],
                [filename:'file:///home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_8.6001.tif.jp2',name:'_NEO4_HPg_INH_8.6001.tif.jp2',slidename:'NEO4_HPg_INH_8',order:60,study:'LBTD NEO4'],
                [filename:'file:///home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_NEO4/grp_HPg_INH/converti/jpg/_NEO4_HPg_INH_8.7001.tif.jp2',name:'_NEO4_HPg_INH_8.7001.tif.jp2',slidename:'NEO4_HPg_INH_8',order:70,study:'LBTD NEO4'],
                //[filename:'file:///home/maree/data/CYTOMINE/LBTD/Slides/Olympus/study_test/grp/converti/jpg/NEO_4_Curcu_INH_1.10_3_2_01.tif.jp2',name:'NEO_4_Curcu_INH_1.10_3_2_01.tif.jp2',slidename:'NEO_4_Curcu_INH_1',order:10,study:'LBTD NEO4']
        ]
        createLBTDScans(LBTDScans)



        def termSamples = [
                /* Ontology 1 */
                [name: "Cell in vivo",comment:"",ontology:[name:"Ontology1"],color:"4b5de4"],
                [name: "Cell ex vivo",comment:"",ontology:[name:"Ontology1"],color:"d8b83f"],
                [name: "Cell",comment:"A comment for cell",ontology:[name:"Ontology1"],color:"ff5800"],
                [name: "Cell within a living organism",comment:"",ontology:[name:"Ontology1"],color:"0085cc"],
                /* LBA */
                [name: "Macrophage",comment:"",ontology:[name:"LBA"],color:"c747a3"],
                [name: "Polynucléaire neutrophile",comment:"",ontology:[name:"LBA"],color:"cddf54"],
                [name: "Lymphocytes",comment:"",ontology:[name:"LBA"],color:"fbd178"],
                [name: "Cellules bronchiques ciliées",comment:"",ontology:[name:"LBA"],color:"26b4e3"],
                [name: "Cellules malpighiennes",comment:"",ontology:[name:"LBA"],color:"bd70c7"],
                [name: "Autre",comment:"",ontology:[name:"LBA"],color:"4bb2c5"],
                [name: "Bactérie",comment:"",ontology:[name:"LBA"],color:"eaa228"],
                [name: "Champignon",comment:"",ontology:[name:"LBA"],color:"0085cc"],
                [name: "Mucus",comment:"",ontology:[name:"LBA"],color:"4b5de4"],
                [name: "Artéfact",comment:"",ontology:[name:"LBA"],color:"ff5800"],
                /* ASP */
                [name: "Cellules bronchiques ciliées",comment:"",ontology:[name:"ASP"],color:"fbd178"],
                [name: "Cellules muco-sécréantes",comment:"",ontology:[name:"ASP"],color:"26b4e3"],
                [name: "Cellules tumorales",comment:"",ontology:[name:"ASP"],color:"bd70c7"],
                [name: "Carcinome épidermoïde",comment:"",ontology:[name:"ASP"],color:"cddf54"],
                [name: "Adénocarcinome glandulaire",comment:"",ontology:[name:"ASP"],color:"eaa228"],
                [name: "Small cell carcinoma",comment:"",ontology:[name:"ASP"],color:"c5b47f"],
                [name: "Cellules malpighiennes",comment:"",ontology:[name:"ASP"],color:"579575"],
                [name: "Autre",comment:"",ontology:[name:"ASP"],color:"839557"],
                [name: "Bactérie",comment:"",ontology:[name:"ASP"],color:"958c12"],
                [name: "Champignon",comment:"",ontology:[name:"ASP"],color:"953579"],
                [name: "Mucus",comment:"",ontology:[name:"ASP"],color:"4b5de4"],
                [name: "Artéfact",comment:"",ontology:[name:"ASP"],color:"d8b83f"],
                /* Frottis */
                [name: "Cellules tumorales",comment:"",ontology:[name:"Frottis"],color:"ff5800"],
                [name: "Carcinome épidermoïde",comment:"",ontology:[name:"Frottis"],color:"0085cc"],
                [name: "Adénocarcinome glandulaire",comment:"",ontology:[name:"Frottis"],color:"c747a3"],
                [name: "Small cell carcinoma",comment:"",ontology:[name:"Frottis"],color:"cddf54"],
                [name: "Cellules bronchiques ciliées",comment:"",ontology:[name:"Frottis"],color:"fbd178"],
                [name: "Cellules muco-sécréantes",comment:"",ontology:[name:"Frottis"],color:"26b4e3"],
                [name: "Cellules malpighiennes",comment:"",ontology:[name:"Frottis"],color:"bd70c7"],
                [name: "Autre",comment:"",ontology:[name:"Frottis"],color:"4bb2c5"],
                [name: "Bactérie",comment:"",ontology:[name:"Frottis"],color:"eaa228"],
                [name: "Champignon",comment:"",ontology:[name:"Frottis"],color:"c5b47f"],
                [name: "Mucus",comment:"",ontology:[name:"Frottis"],color:"579575"],
                [name: "Artéfact",comment:"",ontology:[name:"Frottis"],color:"839557"],
                /* Tissus */
                [name: "Tumeurs",comment:"",ontology:[name:"Tissus"],color:"958c12"],
                [name: "Adénocarcinomes",comment:"",ontology:[name:"Tissus"],color:"953579"],
                [name: "Tumeurs épidermoïdes",comment:"",ontology:[name:"Tissus"],color:"4b5de4"],
                [name: "Vaisseaux",comment:"",ontology:[name:"Tissus"],color:"d8b83f"],
                [name: "Vaisseau sanguin",comment:"",ontology:[name:"Tissus"],color:"ff5800"],
                [name: "Vaisseau lymphatique",comment:"",ontology:[name:"Tissus"],color:"0085cc"],
                [name: "Bronche",comment:"",ontology:[name:"Tissus"],color:"c747a3"],
                [name: "Foyer d'inflammation",comment:"",ontology:[name:"Tissus"],color:"cddf54"],
                [name: "Marquage",comment:"",ontology:[name:"Tissus"],color:"fbd178"],
                [name: "Collagen",comment:"",ontology:[name:"Tissus"],color:"26b4e3"],
                [name: "Cellule en prolifération",comment:"",ontology:[name:"Tissus"],color:"bd70c7"],
                [name: "Alpha-smooth muscle actin",comment:"",ontology:[name:"Tissus"],color:"4bb2c5"],
                [name: "Muscle",comment:"",ontology:[name:"Tissus"],color:"eaa228"],
                [name: "Globule rouge",comment:"",ontology:[name:"Tissus"],color:"eaa228"],
                [name: "Cartilage",comment:"",ontology:[name:"Tissus"],color:"c5b47f"],
                [name: "Artefact",comment:"",ontology:[name:"Tissus"],color:"579575"],
                [name: "Unknown",comment:"",ontology:[name:"Tissus"],color:"839557"],
                /* Cellules */
                [name: "Macrophages",comment:"",ontology:[name:"Cellules"],color:"958c12"],
                [name: "Eosinophiles",comment:"",ontology:[name:"Cellules"],color:"953579"],
                [name: "Neutrophiles",comment:"",ontology:[name:"Cellules"],color:"4b5de4"],
                [name: "Cellules épithéliales",comment:"",ontology:[name:"Cellules"],color:"d8b83f"],
                [name: "Lymphocytes",comment:"",ontology:[name:"Cellules"],color:"ff5800"],
                [name: "Red Blood Cells",comment:"",ontology:[name:"Cellules"],color:"0085cc"],
                [name: "Artefacts",comment:"",ontology:[name:"Cellules"],color:"cddf54"],
        ]

        createTerms(termSamples)

        def relationSamples = [
                [name: RelationTerm.names.PARENT],
                [name: RelationTerm.names.SYNONYM],
        ]
        createRelation(relationSamples)


        def relationTermSamples = [
                /* Ontology 1 */
                //[relation: RelationTerm.names.SYNONYM, term1:"Cell within a living organism", term2: "Cell in vivo", ontology : "Ontology1"],
                /* LBA */
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Bactérie", ontology : "LBA"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Champignon", ontology : "LBA"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Mucus", ontology : "LBA"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Artéfact", ontology : "LBA"],
                /* ASP */
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Bactérie", ontology : "ASP"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Champignon", ontology : "ASP"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Mucus", ontology : "ASP"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Artéfact", ontology : "ASP"],
                [relation: RelationTerm.names.PARENT,term1:"Cellules tumorales", term2: "Carcinome épidermoïde", ontology : "ASP"],
                [relation: RelationTerm.names.PARENT,term1:"Cellules tumorales", term2: "Adénocarcinome glandulaire", ontology : "ASP"],
                [relation: RelationTerm.names.PARENT,term1:"Cellules tumorales", term2: "Small cell carcinoma", ontology : "ASP"],
                /* Frottis */
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Bactérie", ontology : "Frottis"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Champignon", ontology : "Frottis"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Mucus", ontology : "Frottis"],
                [relation: RelationTerm.names.PARENT,term1:"Autre", term2: "Artéfact", ontology : "Frottis"],
                [relation: RelationTerm.names.PARENT,term1:"Cellules tumorales", term2: "Carcinome épidermoïde", ontology : "Frottis"],
                [relation: RelationTerm.names.PARENT,term1:"Cellules tumorales", term2: "Adénocarcinome glandulaire", ontology : "Frottis"],
                [relation: RelationTerm.names.PARENT,term1:"Cellules tumorales", term2: "Small cell carcinoma", ontology : "Frottis"],
                /* Tissus */
                [relation: RelationTerm.names.PARENT,term1:"Tumeurs", term2: "Adénocarcinomes", ontology : "Tissus"],
                [relation: RelationTerm.names.PARENT,term1:"Tumeurs", term2: "Tumeurs épidermoïdes", ontology : "Tissus"],
                [relation: RelationTerm.names.PARENT,term1:"Vaisseaux", term2: "Vaisseau sanguin", ontology : "Tissus"],
                [relation: RelationTerm.names.PARENT,term1:"Vaisseaux", term2: "Vaisseau lymphatique", ontology : "Tissus"],
                [relation: RelationTerm.names.PARENT,term1:"Marquage", term2: "Collagen", ontology : "Tissus"],
                [relation: RelationTerm.names.PARENT,term1:"Marquage", term2: "Cellule en prolifération", ontology : "Tissus"],
                [relation: RelationTerm.names.PARENT,term1:"Marquage", term2: "Alpha-smooth muscle actin", ontology : "Tissus"]
        ]
        createRelationTerm(relationTermSamples)



        /* Annotations */
        def annotationSamples = [
                //[name : "annot3", location : ["POLYGON((2000 1000, 30 0, 40 10, 30 20, 2000 1000))","POLYGON((20 10, 30 0, 40 10, 30 20, 20 10))"], image: [filename: "Boyden - essai _10x_02"]],
                //[name : "annot2", location : ["POLYGON((20 10, 30 50, 40 10, 30 20, 20 10))"],image: [filename: "Boyden - essai _10x_02"]]
                // [name : "annot3", location : ["POINT(10000 10000)"], scan: [filename: "Aperio - 003"],term:["Bactérie","Champignon"], user:"lrollus"],
                // [name : "", location : ["POINT(5000 5000)"],scan: [filename: "Aperio - 003"],user:"lrollus",term:["Champignon"]],
                [name : "Annotation test 1", location : ["POLYGON ((13020.5 25292, 13172.5 25360, 13320.5 25364, 13428.5 25376, 13500.5 25256, 13524.5 25200, 13368.5 25156, 13264.5 25152, 13156.5 25120, 13068.5 25084, 12968.5 25092, 12908.5 25140, 12832.5 25232, 12836.5 25284, 13020.5 25292))"],scan: [filename: "ImageNEO13_CNS_5.20_5_5_01.tif.jp2"],term:["Lymphocytes","Cellules malpighiennes"],user:"lrollus"],
                [name : "Annotation test 2", location : ["POLYGON ((14600.5 24448, 14692.5 24612, 14724.5 24872, 14996.5 24544, 15012.5 24412, 15112.5 24284, 15496.5 24372, 16292.5 24352, 16632.5 24332, 16808.5 23692, 16696.5 23584, 15564.5 23516, 15412.5 23540, 14784.5 23632, 14540.5 23872, 14464.5 24140, 14348.5 24308, 14344.5 24320, 14600.5 24448))"],term:["Cellules malpighiennes"],scan: [filename: "ImageNEO13_CNS_5.20_5_5_01.tif.jp2"],user:"lrollus"]

        ]
        createAnnotations(annotationSamples)



        def destroy = {
        }
        //end of init
    }

    /* Methods */

    def createLBTDScans(LBTDScans) {
        LBTDScans.each { item ->
            println "createLBTDScans"
            def slide
            if(item.slidename!=null)
                slide = Slide.findByName(item.slidename)
            println "slide=" + slide
            if(!slide)
            {
                String slideName;
                if(item.slidename==null)
                {
                    println "item.slidename==null"
                    slideName = "SLIDE "  + item.name
                }
                else
                {
                    println "item.slidename!=null"
                    slideName = item.slidename
                }
                println "slideName=" + slideName + " item.order=" + item.order
                //create one with slidename name
                slide = new Slide(name : slideName, order : item.order?:1)

                if (slide.validate()) {
                    println "Creating slide  ${slideName}..."

                    slide.save(flush : true)

                    /* Link to projects */
                    println "item.study=" + item.study

                    Project project = Project.findByName(item.study)
                    println "project=" + project
                    ProjectSlide.link(project, slide)
                }

            }
            println "create slide OK"
            def extension = item.extension ?: "jp2"
            def mime = Mime.findByExtension(extension)

            def scanner = Scanner.findByBrand("gigascan")

            println "image OK"

            def image = new Image(
                    filename: item.name,
                    scanner : scanner,
                    slide : slide,
                    path : item.filename,
                    mime : mime
            )

            if (image.validate()) {
                println "Creating image : ${image.filename}..."

                image.save(flush : true)
            } else {
                println("\n\n\n Errors in image boostrap for ${item.filename}!\n\n\n")
                image.errors.each {
                    err -> println err
                }

            }


        }
    }


    def createGroups(groupsSamples) {
        def groups = Group.list() ?: []
        //if (!groups) {
        groupsSamples.each { item->
            def group = new Group(name : item.name)
            if (group.validate()) {
                println "Creating group ${group.name}..."

                group.save(flush : true)

                groups << group
            }
            else {
                println("\n\n\n Errors in group boostrap for ${item.name}!\n\n\n")
                group.errors.each {
                    err -> println err
                }
            }
        }
        //}
    }


    def createUsers(usersSamples) {
        def userRole = SecRole.findByAuthority("ROLE_USER") ?: new SecRole(authority : "ROLE_USER").save(flush : true)
        def adminRole = SecRole.findByAuthority("ROLE_ADMIN") ?: new SecRole(authority : "ROLE_ADMIN").save(flush : true)

        def users = User.list() ?: []
        if (!users) {
            usersSamples.each { item ->
                User user = new User(
                        username : item.username,
                        firstname : item.firstname,
                        lastname : item.lastname,
                        email : item.email,
                        password : springSecurityService.encodePassword(item.password),
                        enabled : true)
                if (user.validate()) {
                    println "Creating user ${user.username}..."
                    // user.addToTransactions(new Transaction())
                    user.save(flush : true)

                    /* Create a special group the user */
                    def userGroupName = item.username
                    def userGroup = [
                            [name : userGroupName]
                    ]
                    createGroups(userGroup)
                    Group group = Group.findByName(userGroupName)
                    UserGroup.link(user, group)

                    /* Handle groups */
                    item.group.each { elem ->
                        group = Group.findByName(elem.name)
                        UserGroup.link(user, group)
                    }

                    /* Add Roles */
                    SecUserSecRole.create(user, userRole)
                    SecUserSecRole.create(user, adminRole)

                    users << user
                } else {
                    println("\n\n\n Errors in account boostrap for ${item.username}!\n\n\n")
                    user.errors.each {
                        err -> println err
                    }
                }
            }
        }
    }

    def createScanners(scannersSamples) {
        def scanners = Scanner.list() ?: []
        if (!scanners) {
            scannersSamples.each { item ->
                Scanner scanner = new Scanner(brand : item.brand, model : item.model)

                if (scanner.validate()) {
                    println "Creating scanner ${scanner.brand} - ${scanner.model}..."

                    scanner.save(flush : true)

                    scanners << scanner
                } else {
                    println("\n\n\n Errors in account boostrap for ${item.username}!\n\n\n")
                    scanner.errors.each {
                        err -> println err
                    }
                }
            }
        }
    }

    def createMimes(mimeSamples) {
        def mimes = Mime.list() ?: []
        if (!mimes) {
            mimeSamples.each { item ->
                Mime mime = new Mime(extension : item.extension,
                        mimeType : item.mimeType)
                if (mime.validate()) {
                    println "Creating mime ${mime.extension} : ${mime.mimeType}..."

                    mime.save(flush : true)


                    mimes << mime
                } else {
                    println("\n\n\n Errors in account boostrap for ${mime.extension} : ${mime.mimeType}!\n\n\n")
                    mime.errors.each {
                        err -> println err
                    }
                }
            }
        }
    }

    def createRetrievalServers(retrievalServerSamples) {
        def retrievalServers = RetrievalServer.list() ?: []
        if (!retrievalServers) {
            retrievalServerSamples.each { item->
                RetrievalServer retrievalServer = new RetrievalServer( url : item.url, port : item.port, description : item.description)
                if (retrievalServer.validate()) {
                    println "Creating retrieval server ${item.description}... "

                    retrievalServer.save(flush:true)

                    retrievalServers <<  retrievalServer
                } else {
                    println("\n\n\n Errors in retrieval server boostrap for ${item.description} !\n\n\n")
                    item.errors.each {
                        err -> println err
                    }
                }
            }
        }
    }

    def createImageServers(imageServerSamples) {
        def imageServers = ImageServer.list() ?: []
        if (!imageServers) {
            imageServerSamples.each { item ->
                ImageServer imageServer = new ImageServer(
                        name : item.name,
                        url : item.url,
                        service : item.service,
                        className : item.className)

                if (imageServer.validate()) {
                    println "Creating image server ${imageServer.name}... : ${imageServer.url}"

                    imageServer.save(flush : true)

                    imageServers << imageServer

                    /* Link with MIME JP2 */
                    Mime mime = Mime.findByExtension(item.extension)
                    MimeImageServer.link(imageServer, mime)

                } else {
                    println("\n\n\n Errors in account boostrap for ${item.username}!\n\n\n")
                    imageServer.errors.each {
                        err -> println err
                    }
                }
            }
        }
    }

    def createProjects(projectSamples) {
        def projects = Project.list() ?: []
        if (!projects) {
            projectSamples.each { item->
                def ontology = Ontology.findByName(item.ontology)
                def project = new Project(
                        name : item.name,
                        ontology : ontology,
                        created : new Date(),
                        updated : item.updated,
                        deleted : item.deleted
                )
                if (project.validate()){
                    println "Creating project  ${project.name}..."

                    project.save(flush : true)

                    /* Handle groups */
                    item.groups.each { elem ->
                        Group group = Group.findByName(elem.name)
                        ProjectGroup.link(project, group)
                    }

                    projects << project

                } else {
                    println("\n\n\n Errors in project boostrap for ${item.name}!\n\n\n")
                    project.errors.each {
                        err -> println err
                    }
                }
            }
        }
    }

    def createSlides(slideSamples) {
        def slides = Slide.list() ?: []
        if (!slides) {
            slideSamples.each {item->
                def slide = new Slide(name : item.name, order : item.order)

                if (slide.validate()) {
                    println "Creating slide  ${item.name}..."

                    slide.save(flush : true)

                    /* Link to projects */
                    item.projects.each { elem ->
                        Project project = Project.findByName(elem.name)
                        ProjectSlide.link(project, slide)
                    }

                    slides << slide

                } else {
                    println("\n\n\n Errors in slide boostrap for ${item.name}!\n\n\n")
                    slide.errors.each {
                        err -> println err
                    }
                }
            }
        }
        return slides
    }

    def createScans(scanSamples, slides) {
        def images = Image.list() ?: []
        if (!images) {
            scanSamples.each { item ->
                def extension = item.extension ?: "jp2"
                def mime = Mime.findByExtension(extension)

                def scanner = Scanner.findByBrand("gigascan")
                def user = User.findByUsername("lrollus")
                //  String path
                //Mime mime
                def image = new Image(
                        filename: item.filename,
                        path : item.path,
                        mime : mime,
                        scanner : scanner,
                        slide : slides[item.slide],
                        user:user
                )

                if (image.validate()) {
                    println "Creating image : ${image.filename}..."

                    image.save(flush : true)
/*
            *//* Link to projects *//*
            item.annotations.each { elem ->
              Annotation annotation = Annotation.findByName(elem.name)
              println 'ScanAnnotation:' + image.filename + " " + annotation.name
              ScanAnnotation.link(image, annotation)
              println 'ScanAnnotation: OK'
            }*/



                    images << image
                } else {
                    println("\n\n\n Errors in account boostrap for ${item.filename}!\n\n\n")
                    image.errors.each {
                        err -> println err
                    }

                }
            }
        }
    }

    def createAnnotations(annotationSamples) {
        def annotations = Annotation.list() ?: []
        if (!annotations) {
            def annotation = null
            GeometryFactory geometryFactory = new GeometryFactory()
            annotationSamples.each { item ->
                /* Read spatial data an create annotation*/
                def geom
                if(item.location[0].startsWith('POINT'))
                {
                    //point
                    geom = new WKTReader().read(item.location[0]);
                }
                else
                {
                    //multipolygon
                    Polygon[] polygons = new Polygon[(item.location).size()];
                    int i=0
                    (item.location).each {itemPoly ->
                        polygons[i] =  new WKTReader().read(itemPoly);
                        i++;
                    }
                    geom = geometryFactory.createMultiPolygon(polygons)
                }
                def scanParent = Image.findByFilename(item.scan.filename)
                def user = User.findByUsername(item.user)
                println "user " + item.user +"=" + user.username
                annotation = new Annotation(name: item.name, location:geom, image:scanParent,user:user)


                /* Save annotation */
                if (annotation.validate()) {
                    println "Creating annotation : ${annotation.name}..."

                    annotation.save(flush : true)

                    item.term.each {  term ->
                        println "add Term " + term
                        //annotation.addToTerm(Term.findByName(term))
                        AnnotationTerm.link(annotation, Term.findByName(term))
                    }

                    annotations << annotation
                } else {
                    println("\n\n\n Errors in account boostrap for ${item.name}!\n\n\n")
                    annotation.errors.each {
                        err -> println err
                    }

                }
            }
        }
    }

    def createOntology(ontologySamples) {
        println "createOntology"
        def ontologies =   Ontology.list()?:[]
        if(!ontologies) {
            def ontology = null
            ontologySamples.each { item ->
                ontology = new Ontology(name:item.name)
                println "create ontology="+ ontology.name

                if(ontology.validate()) {
                    println "Creating ontology : ${ontology.name}..."
                    ontology.save(flush : true)

                    ontologies << ontology
                } else {
                    println("\n\n\n Errors in account boostrap for ${item.name}!\n\n\n")
                    ontology.errors.each {
                        err -> println err
                    }

                }
            }
        }
    }

    def createTerms(termSamples) {
        println "createTerms"
        def terms =   Term.list()?:[]
        if(!terms) {
            def term = null
            termSamples.each { item ->
                term = new Term(name:item.name,comment:item.comment,ontology:Ontology.findByName(item.ontology.name),color:item.color)
                println "create term="+ term.name

                if(term.validate()) {
                    println "Creating term : ${term.name}..."
                    term.save(flush : true)


                    /*  item.ontology.each {  ontology ->
                      println "add Ontology " + ontology.name
                      //annotation.addToTerm(Term.findByName(term))
                      TermOntology.link(term, Ontology.findByName(ontology.name),ontology.color)
                    }*/

                    terms << term
                } else {
                    println("\n\n\n Errors in account boostrap for ${item.name}!\n\n\n")
                    term.errors.each {
                        err -> println err
                    }

                }
            }
        }
    }

    def createRelation(relationsSamples) {
        println "createRelation"
        def relations =   Relation.list()?:[]
        if(!relations) {
            def relation = null
            relationsSamples.each { item ->
                relation = new Relation(name:item.name)
                println "create relation="+ relation.name

                if(relation.validate()) {
                    println "Creating relation : ${relation.name}..."
                    relation.save(flush : true)

                    relations << relation
                } else {
                    println("\n\n\n Errors in account boostrap for ${item.name}!\n\n\n")
                    relation.errors.each {
                        err -> println err
                    }

                }
            }
        }
    }

    def createRelationTerm(relationTermSamples) {
        def relationTerm = RelationTerm.list() ?: []

        if (!relationTerm) {
            relationTermSamples.each {item->
                def ontology = Ontology.findByName(item.ontology);
                def relation = Relation.findByName(item.relation)
                def term1 = Term.findByNameAndOntology(item.term1, ontology)
                def term2 = Term.findByNameAndOntology(item.term2, ontology)

                println "Creating term/relation  ${relation.name}:${item.term1}/${item.term2}..."
                RelationTerm.link(relation, term1, term2)

            }
        }
    }

}
