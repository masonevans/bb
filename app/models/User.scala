package models

import play.api.libs.json._

class User(id : Int) {
	
	def name = id match {
		case 1234 => "Mason"
		case 1235 => "Tom"
		case 1236 => "Albert"
		case _ => "Unknown"
	}
	
	def email = id match {
		case 1234 => "mason@gmail.com"
		case 1235 => "tom@gmail.com"
		case 1236 => "albert@gmail.com"
		case _ => "Unknown"
	}
	
	def userImage = id match {
		case 1234 => "img1.jpg"
		case 1235 => "img2.jpg"
		case 1236 => "img3.jpg"
		case _ => "Unknown"
	}
	
	def getJson() = Json.obj(
		"id" -> id,
		"name" -> name,
		"email" -> email
	)

	override def toString() : String = Json.stringify(getJson())
}