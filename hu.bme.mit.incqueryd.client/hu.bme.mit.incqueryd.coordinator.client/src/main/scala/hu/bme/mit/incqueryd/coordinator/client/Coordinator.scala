package hu.bme.mit.incqueryd.coordinator.client

import hu.bme.mit.incqueryd.inventory.MachineInstance
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import scala.collection.JavaConversions._
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.HttpStatus
import eu.mondo.utils.WebServiceUtils

object Coordinator {
  final val port = 9090
  object Start {
    final val path = "/start"
  }
  object Check {
    final val path = "/check"
    final val sampleResult = List(new ChangeSet(Set(new Tuple(new Integer(42))), ChangeType.POSITIVE))
  }
  object Stop {
    final val path = "/stop" 
  }
}

class Coordinator(val instance: MachineInstance) {

  def startQuery(recipe: ReteRecipe) {
    println(s"Starting query on ${instance.getIp}")
    callWebService(Coordinator.Start.path)
  }

  def check: List[ChangeSet] = {
    callWebService(Coordinator.Check.path) // TODO response
    Coordinator.Check.sampleResult
  }

  def stopQuery() {
    callWebService(Coordinator.Stop.path)
  }

  private def callWebService(path: String) = WebServiceUtils.call(instance.getIp, Coordinator.port, path)

}