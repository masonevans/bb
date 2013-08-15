import play.api._

import models._
import com.mongodb.casbah.Imports._

object Global extends GlobalSettings {
  
  override def onStart(app: Application) {
    InitialData.insert()
  }
  
}

/**
 * Initial set of data to be imported 
 * in the sample application.
 */
object InitialData {
  
  def date(str: String) = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str)
  
  def insert() = {
    
    if(User.findAll.isEmpty) {
      Seq(
        User(userId = "1234", name = "Mason", email = "mason@gmail.com", userImage = "1.jpg", password = "mason", posts = Nil, friends = List("1235", "1236")),
        User(userId = "1235", name = "Albert", email = "albert@gmail.com", userImage = "2.jpg", password = "albert", posts = Nil, friends = List("1234", "1236")),
        User(userId = "1236", name = "Tom", email = "tom@gmail.com", userImage = "3.jpg", password = "tom", posts = Nil, friends = List("1234", "1235"))
      ).foreach(User.create)
      
      Seq(
        NewsItem(message = "Mason News 1"),
        NewsItem(message = "Mason News 2"),
        NewsItem(message = "Mason News 3")
      ).map( NewsItem.create(_, Some("1234")) )
      
      Seq(
        NewsItem(message = "Al News 1"),
        NewsItem(message = "Al News 2"),
        NewsItem(message = "Al News 3")
      ).map( NewsItem.create(_, Some("1235")) )
      
      Seq(
        NewsItem(message = "Tom News 1"),
        NewsItem(message = "Tom News 2"),
        NewsItem(message = "Tom News 3")
      ).map( NewsItem.create(_, Some("1236")) )
      
      Seq(
        NewsItem(message = "Al News 5"),
        NewsItem(message = "Al News 6"),
        NewsItem(message = "Al News 7")
      ).map( NewsItem.create(_, Some("1235")) )
    }
  }
}