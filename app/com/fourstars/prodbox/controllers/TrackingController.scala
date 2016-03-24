package com.fourstars.prodbox.controllers

import javax.inject.Inject

import com.fourstars.prodbox.repositories.TrackingDao
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.json._
import play.api.mvc.{Action, Controller}

/**
  * Created by lielran on 19/03/2016.
  */
class TrackingController @Inject()(trackingDao: TrackingDao) extends Controller with JsonFormatters {



  def trackNewUrl(url:String) = Action.async { implicit request =>
    trackingDao.create(url).map { trackingItem =>
      Created(Json.toJson(trackingItem))
    }
  }

  def count = Action.async { implicit request =>
    trackingDao.count().map { r => Ok(Json.toJson(r)) }
  }
}



