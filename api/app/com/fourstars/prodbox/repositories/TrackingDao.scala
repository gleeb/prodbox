package com.fourstars.prodbox.repositories

import com.fourstars.prodbox.model.TrackingItem
import com.google.inject.{Inject, Singleton}
import com.typesafe.scalalogging.LazyLogging
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc.Action
import play.modules.reactivemongo.json.ImplicitBSONHandlers._
import play.modules.reactivemongo.json._
import play.modules.reactivemongo.{MongoController, ReactiveMongoApi, ReactiveMongoComponents}
import reactivemongo.api.collections.bson.BSONCollection
import reactivemongo.bson.{BSONDocument, BSONObjectID}

import scala.concurrent.Future

/**
  * Created by orwolfstein on 20/03/2016.
  */

@Singleton
class TrackingDao @Inject()(val reactiveMongoApi: ReactiveMongoApi) extends MongoController with ReactiveMongoComponents with LazyLogging with BsonFormatters {

  def collection: BSONCollection = db.collection[BSONCollection]("persons")

  def index = Action {
    Ok("works")
  }

  def create(url: String): Future[TrackingItem] = {
    val trackingItem = new TrackingItem(Some(BSONObjectID.generate), url)
    val futureResult = collection.insert(trackingItem)
    futureResult.map {
      response =>
        logger.debug(s"response is $response")
        logger.debug(s"t is now $trackingItem")
        trackingItem
    }
  }

  def find(id: String): Future[Option[TrackingItem]] = {
    collection.find((BSONDocument("_id" -> BSONObjectID(id)))).one[TrackingItem]
  }

  def count(): Future[Int] = {
    collection.count()
  }
}


