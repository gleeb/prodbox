package com.fourstars.prodbox.controllers

import java.io.{File, FileInputStream}
import java.nio.file.{Files, StandardCopyOption}
import javax.activation.MimeType
import javax.inject.Inject

import _root_.com.github.tototoshi.play2.json4s.jackson.Json4s
import _root_.com.typesafe.scalalogging.LazyLogging
import com.vatbox.imaginary.models.{UploadedImage, MimeType, ImaginaryFormaters, ImageAction}
import com.vatbox.imaginary.services.ImageService
import models._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods
import org.json4s.{Extraction, _}
import play.api.Application
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}

import scala.concurrent.Future
import scala.util.Try

/**
  * Created by orwolfstein on 15/02/2016.
  */
trait SomeController extends Controller with Json4s with LazyLogging {

  def app: Application

  implicit val exec = app.actorSystem.dispatcher

  def getSomething() = Action.async { implicit request => Future {
    Ok("this is some response")
  }

  }
}

class SomeControllerImpl @Inject()(override val app: Application) extends SomeController {}
