package hu.bme.mit.incqueryd.engine.rete.actors.testkits

import akka.actor.ActorSystem
import akka.testkit.JavaTestKit
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.engine.rete.nodes.data.AlphaTestData

class AlphaActorTestKit(system: ActorSystem, recipeFile: String) extends ReteActorTestKit(system, recipeFile) {

  protected val parentActor = new JavaTestKit(system)

  def test(data: AlphaTestData) {
    configure(coordinatorActor, reteActor, conf)
    subscribe(targetActor, reteActor)
    testComputation(parentActor, reteActor, targetActor, data.getIncomingChangeSet, data.getExpectedChangeSet,
      ReteNodeSlot.SINGLE)
  }
}
