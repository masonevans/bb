package models

import play.api.libs.json._

case class FriendList()

object FriendList {
	def getJson() = Json.stringify(Json.arr(new User(1235).getJson, new User(1236).getJson))
}