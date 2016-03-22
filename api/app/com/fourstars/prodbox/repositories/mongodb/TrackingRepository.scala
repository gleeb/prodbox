package com.fourstars.prodbox.repositories.mongodb


import com.fourstars.prodbox.model.TrackingItem
import com.google.inject.{ImplementedBy, Inject}
import com.typesafe.scalalogging.LazyLogging
import play.api.libs.concurrent.Execution.Implicits._
import play.api.mvc.Action
import play.modules.reactivemongo.{MongoController, ReactiveMongoComponents, ReactiveMongoApi}
import reactivemongo.bson.BSONObjectID
import reactivemongo.play.json.collection.JSONCollection

import scala.concurrent.{ExecutionContextExecutor, Future}
/**
  * Created by orwolfstein on 20/03/2016.
  */


@ImplementedBy(classOf[TrackingRepositoryImpl])
trait TrackingRepository extends MongoController with ReactiveMongoComponents with LazyLogging with BsonFormatters{

  def reactiveMongoApi: ReactiveMongoApi

  def collection: JSONCollection = db.collection[JSONCollection]("persons")

  def index = Action { Ok("works") }

  def create(url: String) : Future[TrackingItem] = {
    val trackingItem = new TrackingItem(Some(BSONObjectID.generate), url)
    val futureResult = collection.insert(trackingItem)
    futureResult.map {
      response =>
        logger.debug(s"response is $response")
        logger.debug(s"t is now $trackingItem")
        trackingItem
    }
  }
}


class TrackingRepositoryImpl @Inject() (val reactiveMongoApi: ReactiveMongoApi) extends TrackingRepository { }