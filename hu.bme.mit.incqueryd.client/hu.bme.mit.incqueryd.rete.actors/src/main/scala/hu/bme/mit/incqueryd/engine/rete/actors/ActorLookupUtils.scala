package hu.bme.mit.incqueryd.engine.rete.actors

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import akka.actor.ActorRef
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import scala.collection.JavaConversions._
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper
import hu.bme.mit.incqueryd.actorservice.AkkaUtils

object ActorLookupUtils {

  def findActorUsingZooKeeper(recipe: ReteNodeRecipe): Option[ActorRef] = {
    val zkActorPath = getZKActorPath(recipe)
    val actorPath = IncQueryDZooKeeper.getStringData(zkActorPath)
    Some(AkkaUtils.findActor(actorPath))
  }
  
  def getZKActorPath(recipe : ReteNodeRecipe) : String = {
    recipe match {
       case recipe: TypeInputRecipe => s"${IncQueryDZooKeeper.inputNodesPath}/${ReteActorKey(recipe).internalId}"
       case _ => s"${IncQueryDZooKeeper.reteNodesPath}/${ReteActorKey(recipe).internalId}"
    }
  }
  
  def findActor(recipe: ReteNodeRecipe): Option[ActorRef] = {
    findActorUsingZooKeeper(recipe)
  }

  def getParentConnections(childRecipe: ReteNodeRecipe): Set[ReteActorConnection] = { // TODO remove parameter
    childRecipe match {
      case alphaRecipe: AlphaRecipe =>
        getActorConnection(alphaRecipe.getParent, ReteNodeSlot.SINGLE, childRecipe)
      case betaRecipe: BetaRecipe =>
        getActorConnection(betaRecipe.getLeftParent.getParent, ReteNodeSlot.PRIMARY, childRecipe) ++
          getActorConnection(betaRecipe.getRightParent.getParent, ReteNodeSlot.SECONDARY, childRecipe)
      case multiParentNodeRecipe: MultiParentNodeRecipe =>
        multiParentNodeRecipe.getParents.toSet[ReteNodeRecipe].flatMap(getActorConnection(_, ReteNodeSlot.SINGLE, childRecipe))
      case _ => Set()
    }
  }

  private def getActorConnection(parentRecipe: ReteNodeRecipe, slot: ReteNodeSlot, childRecipe: ReteNodeRecipe): Set[ReteActorConnection] = {
    for (
      parentActor <- findActor(parentRecipe).toSet[ActorRef];
      childActor <- findActor(childRecipe).toSet[ActorRef]
    ) yield ReteActorConnection(parentActor, slot, childActor)
  }

  def getChildrenConnections(parent: ActorRef, recipe: ReteRecipe): Set[ReteActorConnection] = {
    for (
      childRecipe <- recipe.getRecipeNodes.toSet[ReteNodeRecipe];
      connection <- getParentConnections(childRecipe) if connection.parent == parent
    ) yield connection
  }

}