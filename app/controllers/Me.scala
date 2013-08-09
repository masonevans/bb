package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models._
import views._

object Me extends Controller with Secured {
  def index() = Action { implicit request =>
    Ok(views.html.me("BB:Me", User.findOneByUserId(request.session.get("userId").getOrElse(""))))
  }
}