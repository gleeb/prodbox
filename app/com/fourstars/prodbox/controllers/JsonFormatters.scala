package com.fourstars.prodbox.controllers

import com.fourstars.prodbox.model.TrackingItem
import play.api.libs.json._
import reactivemongo.bson.BSONObjectID

import scala.util.Try

/**
  * Created by orwolfstein on 22/03/2016.
  */
trait JsonFormatters {

  implicit object BSONObjectIDFormat extends Format[BSONObjectID] {
    def writes(objectId: BSONObjectID): JsValue = JsString(objectId.stringify)
    def reads(json: JsValue): JsResult[BSONObjectID] = json match {
      case JsString(x) => {
        val maybeOID: Try[BSONObjectID] = BSONObjectID.parse(x)
        if(maybeOID.isSuccess) JsSuccess(maybeOID.get) else {
          JsError("Expected BSONObjectID as JsString")
        }
      }
      case _ => JsError("Expected BSONObjectID as JsString")
    }
  }

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val TrackingItemFormat = Json.format[TrackingItem]

}
