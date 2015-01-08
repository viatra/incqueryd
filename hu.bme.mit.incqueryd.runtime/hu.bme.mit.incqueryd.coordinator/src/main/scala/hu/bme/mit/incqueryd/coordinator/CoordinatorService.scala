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

  def isWebServiceReady = path(Coordinator.IsWebServiceReady.path) {
    get { complete("ready") }
  }

  def start = path(Coordinator.StartQuery.path) {
    get { complete("started") }
  }

  def check = path(Coordinator.CheckResults.path) {
    get {
      respondWithHeader(`Content-Type`(`application/json`)) {
        complete {
          import Coordinator.JsonProtocol._
          marshal(Coordinator.CheckResults.sampleResult).right.get // TODO error handling
        }
      }
    }
  }

  def stop = path(Coordinator.StopQuery.path) {
    get { complete("stopped") }
  }

  def route =
    isWebServiceReady ~
    start ~
    check ~
    stop

}