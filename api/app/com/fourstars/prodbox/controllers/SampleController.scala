package com.fourstars.prodbox.controllers

import play.api.mvc.{Action, Controller}


/**
  * Created by lielran on 19/03/2016.
  */
class SampleController extends Controller {

  def index = Action {
    Ok("It works!")
  }

}

