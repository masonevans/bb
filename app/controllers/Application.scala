package controllers

import play.api._
import play.api.mvc._
import models._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  def me = Action {
	Ok(views.html.me("BB:Me", new User(1234)))
  }
  
  def about = TODO /*Action {
	Ok(User.get(User(1235)))
  }*/
  
  def friends = Action {
    Ok(Friend.getAllJson())
  }  
}