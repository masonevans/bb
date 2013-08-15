package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models._
import views._

object User extends Controller with Secured {
  def index(userId: String) = Action { implicit request =>
    Ok(views.html.user("BB:Me", models.User.findOneByUserId(userId)))
  }
}