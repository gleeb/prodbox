package com.fourstars.prodbox.repositories

import de.flapdoodle.embed.mongo.{MongodExecutable, MongodStarter}
import de.flapdoodle.embed.mongo.config.{Net, MongodConfigBuilder, IMongodConfig}
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.process.runtime.Network
import org.scalatest._
import org.scalatestplus.play.OneAppPerSuite
import play.api.libs.iteratee.Input.Empty
import play.api.test.{DefaultAwaitTimeout, FutureAwaits}
import play.libs.F.Some
import play.modules.reactivemongo.ReactiveMongoApi


/**
  * Created by lielran on 23/03/2016.
  */
class TrackingDaoTest extends FlatSpec with Matchers with BeforeAndAfter with  OneAppPerSuite with
  FutureAwaits with ShouldMatchers  with DefaultAwaitTimeout with BeforeAndAfterAll {

  var mongodExecutable: MongodExecutable = null
  override def beforeAll() {
    val starter: MongodStarter = MongodStarter.getDefaultInstance()
    val port: Integer = 27018
    val mongodConfig: IMongodConfig = new MongodConfigBuilder()
      .version(Version.Main.PRODUCTION)
      .net(new Net(port, Network.localhostIsIPv6()))
      .build()
    mongodExecutable = starter.prepare(mongodConfig)
    mongodExecutable.start()
  }


  "A Tracking Dao" should "save Tacking TrackingItem" in {
    val trackingDao = new TrackingDao(app.injector.instanceOf[ReactiveMongoApi])
    val result =await(trackingDao.create("google"))
    await(trackingDao.find(result._id.get.stringify))  should not be empty

  }

  override def afterAll() = {
    mongodExecutable.stop()
  }

}