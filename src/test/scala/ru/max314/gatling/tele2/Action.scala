package ru.max314.gatling.tele2

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

/**
  *
  * 2.2) Object, в котором будут описаны действия, из которых состоит сценарий (открытие страниц, вызовы api)
  *
  *
3.1) Перейти на страницу https://msk.tele2.ru/
3.2) Перейти в каталог тарифов - https://msk.tele2.ru/tariffs
3.3) Открыть любую карточку тарифа (например https://msk.tele2.ru/tariff/my-tele2)
3.4) Перейти на страницу роуминга https://msk.tele2.ru/mobile/roaming
  */
object Action {

  /**
    * ерейти на страницу https://msk.tele2.ru/
    */
  val root_3_1: ChainBuilder = exec(
    http("root_3_1")
      .get("/")
  )

  /**
    * Перейти в каталог тарифов - https://msk.tele2.ru/tariffs
    */
  val tarrif_3_2: ChainBuilder = exec(
    http("tarrif_3_2")
      .get("/tariffs")
  )
  /***
    * Открыть любую карточку тарифа (например https://msk.tele2.ru/tariff/my-tele2)
    */
  val card_3_3: ChainBuilder = exec(
    http("card_3_3")
      .get("/tariff/my-tele2")
  )

  /**
    * Перейти на страницу роуминга https://msk.tele2.ru/mobile/roaming
    */
  val roaming_3_4: ChainBuilder = exec(
    http("roaming_3_4")
      .get("/mobile/roaming")
  )


}
