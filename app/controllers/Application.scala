package controllers

import play.api._
import play.api.mvc._
import models._
import play.api.libs.json._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def me(userId: Int) = Action {
    val mongoUser = User.findOneByUserId(userId)
    Ok(views.html.me("BB:Me", mongoUser))
  }
  
  def about = TODO /*Action {
	Ok(User.get(User(1235)))
  }*/
  
  def friends = Action {
    //Ok(FriendList.getJson())
    Ok(Json.toJson(User.findUsersByIds(User.findOneByUserId(1234).friends)))
  }  
  
  def news(userId: Int) = Action {
    val userNews = User.findOneByUserId(userId)
    val newsItems = NewsItem.findNewsItemsByIds(userNews.posts)
    Ok(Json.toJson(newsItems))
  }
}