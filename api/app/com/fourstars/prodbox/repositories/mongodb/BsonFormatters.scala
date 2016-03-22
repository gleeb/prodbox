package com.fourstars.prodbox.repositories.mongodb

import com.fourstars.prodbox.model.TrackingItem

/**
  * Created by orwolfstein on 20/03/2016.
  */
trait BsonFormatters {
  import play.api.libs.json.Json
  import reactivemongo.play.json.BSONFormats._

  // Generates Writes and Reads for Feed and User thanks to Json Macros
  implicit val TrackingItemFormat = Json.format[TrackingItem]

}
