package models

import play.api.libs.json._

case class FriendList()

object FriendList {
	def getJson() = Json.stringify(Json.arr(User.findOneByUserId(1235), User.findOneByUserId(1236)))
}