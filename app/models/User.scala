package models

import play.api.libs.json._

class User(idc : BigDecimal) {

	var id: BigDecimal = idc
	
	def getJson() : String = Json.stringify(Json.obj(
		"id" -> id,
		"name" -> "Mason"
	))

	override def toString() : String = "( " + id + " )"
}