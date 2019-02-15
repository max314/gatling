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


  def scn = scenario("main tele 2 parallel")
    .exec(
      Action.root_3_1,
      Action.tarrif_3_2,
      Action.card_3_3,
      Action.roaming_3_4,
    )

  def scn2 = scenario("main tele 2-1 seq")
    .exec(
      Action.root_3_1
    )
    .exec(
      Action.tarrif_3_2
    )
    .exec(
      Action.card_3_3
    )
    .exec(
      Action.roaming_3_4
    )

  def scn3 = scenario("main tele 2-1 seq")
    .exec(
      Action.a_root
    )
    .pause(1 seconds)
    .exec(
      Action.a_tarif
    )


}
