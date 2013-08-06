package models

import play.api.libs.json._

class User(idc : Int) {

	var id: Int = idc
	
	def name = id match {
		case 1234 => "Mason"
		case 1235 => "Tom"
		case 1236 => "Albert"
		case _ => "Unknown"
	}
	
	def getJson() = Json.obj(
		"id" -> id,
		"name" -> name
	)

	override def toString() : String = Json.stringify(getJson())
}