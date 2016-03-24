package com.fourstars.prodbox.repositories

import org.scalatest._
import org.scalatestplus.play.OneAppPerSuite
import play.api.libs.iteratee.Input.Empty
import play.api.test.{DefaultAwaitTimeout, FutureAwaits}
import play.libs.F.Some
import play.modules.reactivemongo.ReactiveMongoApi


/**
  * Created by lielran on 23/03/2016.
  */
class TrackingDaoTest extends FlatSpec with Matchers with BeforeAndAfter with  OneAppPerSuite with  FutureAwaits with ShouldMatchers  with DefaultAwaitTimeout{

  "A Tracking Dao" should "save Tacking TrackingItem" in {
    val trackingDao = new TrackingDao(app.injector.instanceOf[ReactiveMongoApi])
    val result =await(trackingDao.create("google"))
    await(trackingDao.find(result._id.get.stringify))  should not be empty

  }

}