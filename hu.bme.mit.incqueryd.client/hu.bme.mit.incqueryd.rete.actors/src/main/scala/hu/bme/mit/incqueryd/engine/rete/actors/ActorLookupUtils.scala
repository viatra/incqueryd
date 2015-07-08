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
import akka.actor.ActorPath

object ActorLookupUtils {

  def findActorUsingZooKeeper(zkActorPath : String): Option[ActorPath] = {
    val actorPathString = IncQueryDZooKeeper.getStringData(zkActorPath)
    Some(ActorPath.fromString(actorPathString))
  }
  
  def getZKActorPath(recipe : ReteNodeRecipe) : String = {
    recipe match {
       case recipe: TypeInputRecipe => s"${IncQueryDZooKeeper.inputNodesPath}/${ReteActorKey(recipe).internalId}"
       case _ => s"${IncQueryDZooKeeper.reteNodesPath}/${ReteActorKey(recipe).internalId}"
    }
  }

  def findActor(recipe: ReteNodeRecipe): Option[ActorPath] = {
    val zkActorPath = getZKActorPath(recipe)
    findActorUsingZooKeeper(zkActorPath)
  }
  
  def findInputActor(inputTypeId : String) : Option[ActorPath] = {
    val zkActorPath = s"${IncQueryDZooKeeper.inputNodesPath}/$inputTypeId"
    findActorUsingZooKeeper(zkActorPath)
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
      parentActor <- findActor(parentRecipe).toSet[ActorPath];
      childActor <- findActor(childRecipe).toSet[ActorPath]
    ) yield ReteActorConnection(parentActor, slot, childActor)
  }

  def getChildrenConnections(parent: ActorPath, recipe: ReteRecipe): Set[ReteActorConnection] = {
    for (
      childRecipe <- recipe.getRecipeNodes.toSet[ReteNodeRecipe];
      connection <- getParentConnections(childRecipe) if connection.parent == parent
    ) yield connection
  }

}