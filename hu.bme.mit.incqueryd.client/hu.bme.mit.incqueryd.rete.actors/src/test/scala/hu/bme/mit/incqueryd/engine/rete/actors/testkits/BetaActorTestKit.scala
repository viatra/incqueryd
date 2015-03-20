package hu.bme.mit.incqueryd.engine.rete.actors.testkits

import akka.actor.ActorSystem
import akka.testkit.JavaTestKit
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.engine.rete.nodes.data.BetaTestData

class BetaActorTestKit(system: ActorSystem, recipeFile: String) extends ReteActorTestKit(system, recipeFile) {

  protected val primaryParentActor = new JavaTestKit(system)

  protected val secondaryParentActor = new JavaTestKit(system)

  def test(data: BetaTestData) {
    configure(coordinatorActor, reteActor, conf)
    subscribe(targetActor, reteActor)
    testComputation(primaryParentActor, reteActor, targetActor, data.getPrimaryChangeSet, data.getExpectedFirstChangeSet, 
      ReteNodeSlot.PRIMARY)
    testComputation(secondaryParentActor, reteActor, targetActor, data.getSecondaryChangeSet, data.getExpectedSecondChangeSet, 
      ReteNodeSlot.SECONDARY)
  }
}
