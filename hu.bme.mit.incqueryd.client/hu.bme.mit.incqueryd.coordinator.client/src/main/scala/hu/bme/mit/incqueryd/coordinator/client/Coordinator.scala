package hu.bme.mit.incqueryd.coordinator.client

import scala.collection.JavaConversions._
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.duration._
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import akka.actor.ActorSystem
import akka.actor.ActorSystem
import hu.bme.mit.incqueryd.inventory.MachineInstance
import spray.client.pipelining._
import spray.http.HttpRequest
import spray.http.HttpRequest
import spray.http.HttpResponse
import spray.httpx.SprayJsonSupport._
import spray.json._
import spray.httpx.unmarshalling._
import spray.httpx.marshalling._
import spray.http.Uri
import scala.util.Left

object Coordinator {
  final val port = 9090
  object Start {
    final val path = "start"
  }
  object Check {
    final val path = "check"
    final val sampleResult = List(ChangeSet(Set(Tuple(List(42))), true))
  }
  object Stop {
    final val path = "stop"
  }
  object JsonProtocol extends DefaultJsonProtocol {
    implicit val tupleFormat = jsonFormat1(Tuple)
    implicit val changeSetFormat = jsonFormat2(ChangeSet)
  }
}

class Coordinator(val instance: MachineInstance) {

  def startQuery(recipe: ReteRecipe) {
    println(s"Starting query on ${instance.getIp}")
    callWebService(Coordinator.Start.path)
  }

  def check: List[ChangeSet] = {
  	import Coordinator.JsonProtocol._
    val response = callWebService(Coordinator.Check.path)
    val result = response.as[List[ChangeSet]]
    result match {
  	  case Left(error) => throw new RuntimeException(s"Can't unmarshal response, error: $error")
  	  case Right(value) => value
  	}
  }

  def stopQuery() {
    callWebService(Coordinator.Stop.path)
  }

  private def callWebService(path: String): HttpResponse = {
    implicit val system = ActorSystem()
    import system.dispatcher // execution context for futures
    val pipeline: HttpRequest => Future[HttpResponse] = sendReceive
    val future = pipeline(Get(Uri.from(scheme = "http", host = instance.getIp, port = Coordinator.port, path = s"/$path")))
    val timeout = 10 seconds;
    Await.result(future, timeout)
  }

}