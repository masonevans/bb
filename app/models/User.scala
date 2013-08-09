package models

import play.api.Play.current
import java.util.Date
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import mongoContext._
import play.api.libs.json._

case class User(
	id: ObjectId = new ObjectId,
	userId: String = "-1",
	name: String = "",
	email: String = "",
	userImage: String = "",
	password: String = "",
	posts: List[Int] = Nil,
	friends: List[String] = Nil
)

object User extends UserDAO with UserJson

trait UserDAO extends ModelCompanion[User, ObjectId] {
  val dao = new SalatDAO[User, ObjectId](collection = mongoCollection("users")) {}

  def findOneByUserId(userId:String) : User = dao.findOne(MongoDBObject("userId" -> userId)).getOrElse(User())
  def findUsersByIds(userIdList:List[String]) : List[User] = dao.find(MongoDBObject("userId" -> MongoDBObject("$in" -> userIdList))).toList
  def findOneById(id: String) : User = dao.findOne(MongoDBObject("_id" -> id)).getOrElse(User())
  def findIdForEmail(email: String) : String = dao.findOne(DBObject("email" -> email)).getOrElse(User()).userId
  
  def authenticate(email: String, password: String): Option[User] = dao.findOne(DBObject("email" -> email, "password" -> password))
  def create(user: User) = dao.insert(user)
}

trait UserJson {
  implicit val getJson = new Writes[User] {
    def writes(u: User): JsValue = {
      Json.obj(
		"userId" -> u.userId,
		"name" -> u.name,
		"email" -> u.email,
		"userImage" -> u.userImage
      )
    }
  } 
}