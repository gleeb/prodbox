package com.fourstars.prodbox.model

import play.api.libs.json.Json
import reactivemongo.bson.{BSONDocumentReader, BSONDocumentWriter, BSONObjectID, Macros}


/**
  * Created by orwolfstein on 20/03/2016.
  */
case class TrackingItem (_id: Option[BSONObjectID], url: String)


object TrackingItem{
  implicit  val trackingItemBsonReader: BSONDocumentReader[TrackingItem] =Macros.reader[TrackingItem]
  implicit  val trackingItemBsonWriter :BSONDocumentWriter[TrackingItem] =Macros.writer[TrackingItem]
}