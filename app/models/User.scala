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
	userId: Int,
	name: String,
	email: String,
	userImage: String,
	posts: List[Int] = Nil
)

object User extends UserDAO with UserJson

trait UserDAO extends ModelCompanion[User, ObjectId] {
  val dao = new SalatDAO[User, ObjectId](collection = mongoCollection("users")) {}

  def findOneByUserId(userId:Int) : Option[User] = dao.findOne(MongoDBObject("userId" -> userId));
}

trait UserJson {
  implicit val getJson = new Writes[User] {
    def writes(u: User): JsValue = {
      Json.obj(
		"userId" -> u.userId,
		"name" -> u.name,
		"email" -> u.email
      )
    }
  } 
}