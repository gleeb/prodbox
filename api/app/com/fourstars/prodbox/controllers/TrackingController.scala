package com.fourstars.prodbox.controllers

import javax.inject.Inject

import com.fourstars.prodbox.repositories.mongodb.TrackingRepository
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json._
import play.api.mvc.{Action, Controller}

/**
  * Created by lielran on 19/03/2016.
  */
trait TrackingController extends Controller with JsonFormatters {

  def trackingRepository: TrackingRepository



  def trackNewUrl = Action.async { implicit request =>
    //Json.fromJson[TrackingItem](request.body).map{ trackingItem =>


    //}

    trackingRepository.create("http://www.google.com").map{ trackingItem =>
      Created(Json.toJson(trackingItem))
    }
  }

}

class TrackingControllerImpl @Inject()(override val trackingRepository: TrackingRepository) extends TrackingController{
}

