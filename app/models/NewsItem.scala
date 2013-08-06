package models

import play.api.libs.json._
import java.text._

class NewsItem(id : Int) {

	val createdDate = new java.util.Date
	
	def message = id match {
		case 12345 => "News1"
		case 12346 => "News2"
		case 12347 => "News3"
		case _ => "Unknown"
	}
	
	def getJson() = Json.obj(
		"id" -> id,
		"message" -> message,
		"createdDate" -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS").format(createdDate)
	)

	override def toString() : String = Json.stringify(getJson())
}