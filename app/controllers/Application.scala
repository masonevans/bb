package controllers

import play.api._
import play.api.mvc._
import models._
import play.api.libs.json._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def me(userId: Int) = Action { request => {
	    val mongoUser = User.findOneByUserId(userId)
	    mongoUser match {
	      case Some(user) => Ok(views.html.me("BB:Me", user))     
	      case None => BadRequest
	    }
    }
  }
  
  def about = TODO /*Action {
	Ok(User.get(User(1235)))
  }*/
  
  def friends = Action {
    Ok(FriendList.getJson())
  }  
  
  def news(userId: Int) = Action {
	    val userNews = User.findOneByUserId(userId)
	    userNews match {
	      case Some(user) => {
	        val newsItems = NewsItem.findNewsItemsByIds(user.posts)
	        
	        Ok(Json.toJson(newsItems))
	      }
	      case None => BadRequest
	    }
  }
}