package be.cytomine.image

import be.cytomine.image.server.ImageServer
import be.cytomine.image.server.MimeImageServer

class Mime {

  String extension
  String mimeType

  static belongsTo = ImageServer
  static hasMany = [mis:MimeImageServer]

  static constraints = {
    extension (maxSize : 5, blank : false)
    mimeType (blank : false, unique : true)
  }

  def imageServers() {
    if(mis!=null)
      return mis.collect{it.imageServer}
    else
      return []
  }

  String toString() {
    extension
  }

}