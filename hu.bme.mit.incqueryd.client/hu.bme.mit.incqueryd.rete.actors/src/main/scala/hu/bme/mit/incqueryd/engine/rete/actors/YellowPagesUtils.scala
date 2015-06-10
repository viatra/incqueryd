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

object YellowPagesUtils {

  def findActorUsingZooKeeper(recipe: ReteNodeRecipe): Option[ActorRef] = {
    var zkRecipePath = "/"
    recipe match {
       case recipe: TypeInputRecipe => zkRecipePath = IncQueryDZooKeeper.inputNodesPath + "/" + ReteActorKey(recipe).internalId
       case _ => zkRecipePath = IncQueryDZooKeeper.reteNodesPath + "/" + ReteActorKey(recipe).internalId
    }
    val actorPath = IncQueryDZooKeeper.getStringData(zkRecipePath)
    Some(AkkaUtils.findActor(actorPath))
  }

  def findActor(recipe: ReteNodeRecipe, yellowPages: YellowPages): Option[ActorRef] = {
    findActorUsingZooKeeper(recipe)
//    recipe match {
//      case recipe: TypeInputRecipe => {
//        val rdfType = RecipeUtils.findType(yellowPages.inputActorsByType.keySet, recipe)
//        rdfType.flatMap(yellowPages.inputActorsByType.get(_))
//      }
//      case _ => yellowPages.otherActorsByKey.get(ReteActorKey(recipe))
//    }
  }

  def getParentConnections(childRecipe: ReteNodeRecipe, yellowPages: YellowPages): Set[ReteActorConnection] = { // TODO remove parameter
    childRecipe match {
      case alphaRecipe: AlphaRecipe =>
        getActorConnection(alphaRecipe.getParent, ReteNodeSlot.SINGLE, childRecipe, yellowPages)
      case betaRecipe: BetaRecipe =>
        getActorConnection(betaRecipe.getLeftParent.getParent, ReteNodeSlot.PRIMARY, childRecipe, yellowPages) ++
          getActorConnection(betaRecipe.getRightParent.getParent, ReteNodeSlot.SECONDARY, childRecipe, yellowPages)
      case multiParentNodeRecipe: MultiParentNodeRecipe =>
        multiParentNodeRecipe.getParents.toSet[ReteNodeRecipe].flatMap(getActorConnection(_, ReteNodeSlot.SINGLE, childRecipe, yellowPages))
      case _ => Set()
    }
  }

  private def getActorConnection(parentRecipe: ReteNodeRecipe, slot: ReteNodeSlot, childRecipe: ReteNodeRecipe, yellowPages: YellowPages): Set[ReteActorConnection] = {
    for (
      parentActor <- findActor(parentRecipe, yellowPages).toSet[ActorRef];
      childActor <- findActor(childRecipe, yellowPages).toSet[ActorRef]
    ) yield ReteActorConnection(parentActor, slot, childActor)
  }

  def getChildrenConnections(parent: ActorRef, recipe: ReteRecipe, yellowPages: YellowPages): Set[ReteActorConnection] = { // TODO remove parameter
    for (
      childRecipe <- recipe.getRecipeNodes.toSet[ReteNodeRecipe];
      connection <- getParentConnections(childRecipe, yellowPages) if connection.parent == parent
    ) yield connection
  }

}