package ru.max314.gatling.tele2

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import scala.concurrent.duration._

/** *
  * Симуляция
  * 4) Профиль нагрузки: в течение 3 минут каждую секунду нагрузочный сценарий начинают выполнять 2 пользователя.
  */

class MainSimulation extends Simulation {

  // http config
  val httpConf: HttpProtocolBuilder = http
    .baseUrl("https://msk.tele2.ru/");


  // нагрузка

  val power = constantUsersPerSec(2) during (20 seconds);
  // 4) Профиль нагрузки: в течение 3 минут каждую секунду нагрузочный сценарий начинают выполнять 2 пользователя.
  val power3min = constantUsersPerSec(2) during (3 minutes);

  setUp(
    MainScenarion
      .scn2
      .inject(power)
      .protocols(httpConf))

}
