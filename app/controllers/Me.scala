package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.json._

import models._
import views._

object Me extends Controller with Secured {
  val postForm = Form(
      mapping (
          "message" -> text
      ) ((message) => NewsItem(message = message))
      ((newsItem : NewsItem) => Some(newsItem.message))
  )
  

  
  def index() = Action { implicit request =>
    Ok(views.html.me("BB:Me", models.User.findOneByUserId(request.session.get("userId").getOrElse(""))))
  }
  
  def newPost = Action { implicit request =>
    postForm.bindFromRequest.fold(
      formWithErrors => Forbidden,
      newPost => { 
        NewsItem.create(NewsItem(message = newPost.message), request.session.get("userId"))
        Redirect(routes.Me.index)
      }
	)
  }
  
  def newsFeed = Action { implicit request =>
    Ok(Json.toJson(NewsItem.findNewsItemsByIds(models.User.findOneByUserId(request.session.get("userId").getOrElse("")).newsFeed)))
  }
}