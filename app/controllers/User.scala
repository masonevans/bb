package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models._
import views._

object User extends Controller with Secured {
  def index(userId: String) = Action { implicit request => 
   if(request.session.get("userId").getOrElse("").equals(userId)) {
     Redirect(routes.Me.index) 
   }
   else {
     val user = models.User.findOneByUserId(userId)
     Ok(views.html.user("BB:" + user.name, user))
   }
  }
}