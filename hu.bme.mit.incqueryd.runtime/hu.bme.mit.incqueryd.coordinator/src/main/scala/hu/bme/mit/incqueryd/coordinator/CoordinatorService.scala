package hu.bme.mit.incqueryd.coordinator

import spray.routing.HttpService
import spray.httpx.SprayJsonSupport._
import spray.json.DefaultJsonProtocol._
import hu.bme.mit.incqueryd.coordinator.client.ChangeSet
import hu.bme.mit.incqueryd.coordinator.client.Coordinator
import spray.httpx.marshalling._
import spray.http.HttpHeaders._
import spray.http.ContentTypes._

trait CoordinatorService extends HttpService {

  def start = path(Coordinator.Start.path) {
    get { complete("started") }
  }

  def check = path(Coordinator.Check.path) {
    get {
      respondWithHeader(`Content-Type`(`application/json`)) {
        complete {
          import Coordinator.JsonProtocol._
          marshal(Coordinator.Check.sampleResult).right.get // TODO error handling
        }
      }
    }
  }

  def stop = path(Coordinator.Stop.path) {
    get { complete("stopped") }
  }

  def route = start ~
    check ~
    stop

}