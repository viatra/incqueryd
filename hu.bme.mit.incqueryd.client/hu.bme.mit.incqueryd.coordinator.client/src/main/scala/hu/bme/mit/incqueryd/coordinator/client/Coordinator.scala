package hu.bme.mit.incqueryd.coordinator.client

import hu.bme.mit.incqueryd.inventory.MachineInstance
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple
import scala.collection.JavaConversions._

object Coordinator {
  val sampleResult = List(new ChangeSet(Set(new Tuple(new Integer(42))), ChangeType.POSITIVE))
}

class Coordinator(val instance: MachineInstance) {
  
  def startQuery(recipe: ReteRecipe) {
    println(s"Starting query on ${instance.getIp}")
  }

  def check: List[ChangeSet] = {
    Coordinator.sampleResult
  }
  
  def stopQuery() {
  }

}