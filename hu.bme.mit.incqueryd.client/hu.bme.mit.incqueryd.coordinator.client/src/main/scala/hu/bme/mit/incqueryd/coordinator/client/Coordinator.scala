package hu.bme.mit.incqueryd.coordinator.client

import hu.bme.mit.incqueryd.inventory.MachineInstance
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe

class Coordinator(val instance: MachineInstance) {
  
  def startQuery(recipe: ReteRecipe) {
    println(s"Starting query on ${instance.getIp}")
  }

}