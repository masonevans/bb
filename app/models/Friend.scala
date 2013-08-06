package models

import play.api.libs.json._

case class Friend()

object Friend {
	/*def get(id : BigDecimal) : String = Json.stringify(Json.obj(
		"id" -> id,
		"name" -> "Mason"
	))*/
	//def all : List[User] = User(1234) :: User(1235) :: Nil
	
	def getAllJson() = Json.stringify(Json.arr(new User(1235).getJson, new User(1236).getJson))
}