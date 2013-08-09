package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.json._

import models._
import views._

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  
  // -- Authentication

  val loginForm = Form(
    mapping(
      "email" -> text,
	  "password" -> text
    )((email, password) => User(email = email, password = password, userId = User.findIdForEmail(email)))
     ((user: User) => Some(user.email, user.password))
     
   verifying ("Invalid email or password", result => result match {
      case result: User => User.authenticate(result.email, result.password).isDefined
    })
  )

  /**
   * Login page.
   */
  def login = Action { implicit request =>
    Ok(html.login(loginForm))
  }

  /**
   * Handle login form submission.
   */
  def authenticate = Action { implicit request =>
    loginForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.login(formWithErrors)),
      user => Redirect(routes.Me.index).withSession("userId" -> user.userId)
    )
  }
  
    /**
   * Logout and clean the session.
   */
  def logout = Action {
    Redirect(routes.Application.login).withNewSession.flashing(
      "success" -> "You've been logged out"
    )
  }
  
  def friends(userId: String) = Action {
    Ok(Json.toJson(User.findUsersByIds(User.findOneByUserId(userId).friends)))
  }  
  
  def news(userId: String) = Action {
    Ok(Json.toJson(NewsItem.findNewsItemsByIds(User.findOneByUserId(userId).posts)))
  }
}

trait Secured {
}