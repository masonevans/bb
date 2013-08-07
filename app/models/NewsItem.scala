package models

import play.api.Play.current
import play.api.libs.json._
import java.text._
import java.util.Date
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import mongoContext._
import play.api.libs.json._

case class NewsItem(
    id : ObjectId = new ObjectId,
    newsId : Int,
    message: String,
    createdDate: Date = new Date) 

object NewsItem extends NewsItemDAO with NewsItemJson

trait NewsItemDAO extends ModelCompanion[NewsItem, ObjectId] {
  val dao = new SalatDAO[NewsItem, ObjectId](collection = mongoCollection("news")) {}

  def findOneByNewsItemId(newsItemId:Int) : Option[NewsItem] = dao.findOne(MongoDBObject("newsId" -> newsItemId));
  def findNewsItemsByIds(newsItemIdList:List[Int]) : List[NewsItem] = dao.find(MongoDBObject("newsId" -> MongoDBObject("$in" -> newsItemIdList))).toList
}

trait NewsItemJson {
  implicit val getJson = new Writes[NewsItem] {
    def writes(u: NewsItem): JsValue = {
      Json.obj(
		"newsId" -> u.newsId,
		"message" -> u.message,
		"createdDate" -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSS").format(u.createdDate)
      )
    }
  } 
}