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
    tuple(
      "email" -> text,
      "password" -> text
    ) verifying ("Invalid email or password", result => result match {
      case (email, password) => User.authenticate(email, password).isDefined
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
      user => Redirect(routes.Application.me(1234)).withSession("email" -> user._1)
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
  
  def me(userId: Int) = Action {
    Ok(views.html.me("BB:Me", User.findOneByUserId(userId)))
  }
  
  def friends(userId: Int) = Action {
    Ok(Json.toJson(User.findUsersByIds(User.findOneByUserId(userId).friends)))
  }  
  
  def news(userId: Int) = Action {
    Ok(Json.toJson(NewsItem.findNewsItemsByIds(User.findOneByUserId(userId).posts)))
  }
}