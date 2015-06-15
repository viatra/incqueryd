package hu.bme.mit.incqueryd.engine

import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.actorservice.ActorId
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.apache.commons.codec.digest.DigestUtils
import hu.bme.mit.incqueryd.engine.rete.actors.RecipeUtils
import hu.bme.mit.incqueryd.actorservice.ActorId

object RemoteReteActor {
  final val port = 2553
  final val actorSystemName = "rete"
  final val defaultActorName = "rete"

  def actorId(recipe: ReteNodeRecipe, instance: MachineInstance): ActorId = {
    val name = DigestUtils.md5Hex(RecipeUtils.getName(recipe))
    ActorId(actorSystemName, instance.ip, port, name)
  }
  
  def defaultActorId(ip: String): ActorId = {
    ActorId(actorSystemName, ip, port, defaultActorName)    
  }
  
}