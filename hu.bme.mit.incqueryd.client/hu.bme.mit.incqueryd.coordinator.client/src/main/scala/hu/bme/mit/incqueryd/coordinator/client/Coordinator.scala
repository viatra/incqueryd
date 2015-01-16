package hu.bme.mit.incqueryd.coordinator.client

import akka.pattern.ask
import akka.util.Timeout
import hu.bme.mit.incqueryd.engine._
import hu.bme.mit.incqueryd.inventory.MachineInstance
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe

import scala.concurrent.Await
import scala.concurrent.duration._

object Coordinator {
  final val port = 9090
  final val actorSystemName = "coordinator"
  final val actorName = "coordinator"
}

class Coordinator(instance: MachineInstance) {

  def startQuery(recipe: ReteRecipe): ReteNetwork = {
    println(s"Starting query")
    askCoordinator[ReteNetwork](StartQuery(recipe))
  }

  def checkResults(pattern: PatternDescriptor): List[ChangeSet] = {
    askCoordinator[List[ChangeSet]](CheckResults(pattern))
  }

  def stopQuery(network: ReteNetwork) {
    println(s"Stopping query")
    askCoordinator[String](StopQuery(network))
  }

  private def askCoordinator[T](message: CoordinatorCommand): T = {
    val coordinatorActor = AkkaUtils.findActor(Coordinator.actorSystemName, instance.getIp, Coordinator.port, Coordinator.actorName)
    implicit val timeout = Timeout(5 seconds)
    val future = coordinatorActor ? message
    Await.result(future, timeout.duration).asInstanceOf[T]
  }

}