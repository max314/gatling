package ru.max314.gatling.tele2

import com.typesafe.config.ConfigFactory

/**
	* Конфиг из файлв
	*/
object Conf {

	private val conf = ConfigFactory.load()

	val baseUrl: String = {
		if (conf.hasPath("base-url")){
			conf.getString("base-url")
		}
		else {
			"https://msk.tele2.ru/"
		}
	}
}
