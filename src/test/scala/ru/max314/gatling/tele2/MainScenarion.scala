package ru.max314.gatling.tele2

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import scala.concurrent.duration._

/***
  *  Синглтон-объект (Object), в котором будут описаны сценарии тестирования
  *
  */
object MainScenarion {


  /**
    * Собственно сценарий
    * @return
    */
  def scn() = scenario("main tele 2")
    .exec(
      Action.root_3_1,
      Action.tarrif_3_2,
      Action.card_3_3,
      Action.roaming_3_4,
    )
}
