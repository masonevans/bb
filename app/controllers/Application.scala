package controllers

import play.api._
import play.api.mvc._
import models.User

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def me = Action {
	Ok(views.html.me("BB:Me", new User(1234)))
  }
  
  def about = Action {
	Ok(new User(1234).getJson())
  }
  
  def friends = TODO /*Action {
    Ok(Friend.all())
  }*/
  
}