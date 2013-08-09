import play.api._

import models._

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
        User(userId = "1234", name = "Mason", email = "mason@gmail.com", userImage = "1.jpg", password = "mason", posts = List(12345, 12346, 12347), friends = List("1235", "1236")),
        User(userId = "1235", name = "Albert", email = "albert@gmail.com", userImage = "2.jpg", password = "albert", posts = Nil, friends = List("1234", "1236")),
        User(userId = "1236", name = "Tom", email = "tom@gmail.com", userImage = "3.jpg", password = "tom", posts = Nil, friends = List("1234", "1235"))
      ).foreach(User.create)
      
      Seq(
        NewsItem(newsId = 12345, message = "News 1"),
        NewsItem(newsId = 12346, message = "News 2"),
        NewsItem(newsId = 12347, message = "News 3")
      ).foreach(NewsItem.create)
    }
  }
}