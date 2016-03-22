package com.fourstars.prodbox.model

import reactivemongo.bson.BSONObjectID


/**
  * Created by orwolfstein on 20/03/2016.
  */
case class TrackingItem (_id: Option[BSONObjectID], url: String)
