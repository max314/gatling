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
    .baseUrl("https://msk.tele2.ru/")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3")
    .userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:47.0) Gecko/20100101 Firefox/47.0")
    .check(status is 200);


  // нагрузка

  val power = constantUsersPerSec(1) during (20 seconds);
  // 4) Профиль нагрузки: в течение 3 минут каждую секунду нагрузочный сценарий начинают выполнять 2 пользователя.
  val power3min = constantUsersPerSec(2) during (3 minutes);

  setUp(
    MainScenarion
      .scn
      .inject(power)
      .protocols(httpConf))

}
