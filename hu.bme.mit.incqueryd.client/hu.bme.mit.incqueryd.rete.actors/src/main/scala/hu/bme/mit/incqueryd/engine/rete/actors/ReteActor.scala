package hu.bme.mit.incqueryd.engine.rete.actors

import java.util.HashMap
import scala.collection.JavaConversions._
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.actorRef2Scala
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.engine.rete.messages.ActorReply
import hu.bme.mit.incqueryd.engine.rete.messages.CoordinatorMessage
import hu.bme.mit.incqueryd.engine.rete.messages.SubscriptionMessage
import hu.bme.mit.incqueryd.engine.rete.messages.TerminationMessage
import hu.bme.mit.incqueryd.engine.rete.messages.UpdateMessage
import hu.bme.mit.incqueryd.engine.rete.nodes.AlphaNode
import hu.bme.mit.incqueryd.engine.rete.nodes.BetaNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ProductionNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ReteNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ReteNodeFactory
import hu.bme.mit.incqueryd.engine.rete.nodes.TypeInputNode
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration
import java.util.Stack
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import scala.collection.JavaConversions
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe

class ReteActor extends Actor {

  var logPrefix = "[ReteActor       ] "

  // throttle termination protocol
  val throttle = false

  var recipe: ReteNodeRecipe = null
  var reteNode: ReteNode = null
  var subscribers = scala.collection.mutable.Map[ActorRef, ReteNodeSlot]()
  var coordinatorRef: ActorRef = null

  var updateMessageCount = 0 // To count how many update messages this actor sent
  var changesCount = 0 // To count how many tuple changes it sent

  var monitoringServerActor: ActorRef = null

  var nodeType: String = ""

  def configure(conf: ReteNodeConfiguration) = {
    recipe = conf.getReteNodeRecipe
    reteNode = ReteNodeFactory.createNode(conf)
    nodeType = reteNode.getClass.getSimpleName

    logPrefix = logPrefix + "(" + nodeType + ", " + recipe.getTraceInfo + ") "

    println(logPrefix + self + " Configuration received.")

    sender ! ActorReply.CONFIGURATION_RECEIVED
  }

  def subscribe(yellowPages: YellowPages) = {
    println(logPrefix + self + " Subscribing to parent(s)")
    recipe match {
      case alphaRecipe: AlphaRecipe => {
        val parent = alphaRecipe.getParent
        subscribeToActor(parent, ReteNodeSlot.SINGLE, yellowPages)
      }
      case betaRecipe: BetaRecipe => {
        val primaryParent = betaRecipe.getLeftParent.getParent
        val secondaryParent = betaRecipe.getRightParent.getParent
        subscribeToActor(primaryParent, ReteNodeSlot.PRIMARY, yellowPages)
        subscribeToActor(secondaryParent, ReteNodeSlot.SECONDARY, yellowPages)
      }
      case multiParentNodeRecipe: MultiParentNodeRecipe => {
        val parents = multiParentNodeRecipe.getParents
        parents.foreach(parent => {
          subscribeToActor(parent, ReteNodeSlot.SINGLE, yellowPages)
        })
      }
      case _ => {}
    }
  }

  def subscribeToActor(recipe: ReteNodeRecipe, slot: ReteNodeSlot, yellowPages: YellowPages) = {
    val actorRef = recipe match {
	  case recipe: TypeInputRecipe => {
	    val rdfType = RecipeUtils.findType(yellowPages.inputActorsByType.keySet, recipe)
	    rdfType.flatMap(yellowPages.inputActorsByType.get(_))
	  }
	  case _ => yellowPages.otherActorsByEmfId.get(RecipeUtils.getEmfId(recipe))
	}
    val message = slot match {
      case ReteNodeSlot.PRIMARY => SubscriptionMessage.SUBSCRIBE_PRIMARY
      case ReteNodeSlot.SECONDARY => SubscriptionMessage.SUBSCRIBE_SECONDARY
      case ReteNodeSlot.SINGLE => SubscriptionMessage.SUBSCRIBE_SINGLE
      case _ => null
    }
    actorRef.get ! message // XXX Option.get
    // TODO wait for reply?
  }

  def subscribeSender(slot: ReteNodeSlot) = {

    subscribers.put(sender, slot)

    sender ! ActorReply.SUBSCRIBED

    println(logPrefix + self + " Subscribed: " + sender + " on slot " + slot)

  }

  def update(updateMessage: UpdateMessage) = {
    println(logPrefix + self + " "
      + "Update message received, " + updateMessage.getChangeSet.getChangeType + ", "
      + updateMessage.getNodeSlot + ", " + updateMessage.getChangeSet.getTuples.size)

    var changeSet: ChangeSet = null

    updateMessage.getNodeSlot match {
      case ReteNodeSlot.SINGLE => {
        changeSet = reteNode.asInstanceOf[AlphaNode].update(updateMessage.getChangeSet)
      }
      case ReteNodeSlot.PRIMARY | ReteNodeSlot.SECONDARY => {
        changeSet = reteNode.asInstanceOf[BetaNode].update(updateMessage.getChangeSet, updateMessage.getNodeSlot)
      }
      case _ => {
        throw new UnsupportedOperationException(updateMessage.getNodeSlot + " slot is not supported.")
      }
    }

    sendToSubscribers(changeSet, updateMessage.getRoute)

    reteNode match {
      case node: ProductionNode => {
        if (subscribers.isEmpty) terminationProtocol(new TerminationMessage(updateMessage.getRoute))
      }
      case _ => {}
    }
  }

  def sendToSubscribers(changeSet: ChangeSet, senderStack: Stack[ActorRef]) = {
    if (changeSet != null) {
      updateMessageCount += 1
    }

    for ((subscriber, slot) <- subscribers) {

      val propagatedRoute = senderStack.clone.asInstanceOf[Stack[ActorRef]]
      propagatedRoute.push(self)
      val updateMessage = new UpdateMessage(changeSet, slot, propagatedRoute)

      // @formatter:off
      println(logPrefix + self + "\n"
        + logPrefix + "  " + "Sending to " + subscriber + "\n"
        + logPrefix + "  " + changeSet.getChangeType + " changeset, " + changeSet.getTuples.size + " tuples\n"
        + logPrefix + "  " + "Propagated route: " + propagatedRoute + "\n")
      // @formatter:on

      subscriber ! updateMessage
    }

    if (changeSet != null) changesCount += changeSet.getTuples.size // In case it's not a production node
  }

  def initialize = {
    coordinatorRef = sender
  }

  def initializeInput = {
    println(logPrefix + " Initializing input node")
    val inputNode = reteNode.asInstanceOf[TypeInputNode]
    inputNode.load
    val changeSet = inputNode.getChangeSet
    val senderStack = new Stack[ActorRef]
    senderStack.push(self)
    senderStack.push(sender)
    val updateMessage = new UpdateMessage(changeSet, ReteNodeSlot.SINGLE, senderStack)
    self.tell(updateMessage, self)
  }

  def terminationProtocol(terminationMessage: TerminationMessage): Unit = {
    val route = terminationMessage.getRoute

    val terminationMessageRoute = route.clone.asInstanceOf[Stack[ActorRef]]
    val terminationMessageTarget = terminationMessageRoute.pop
    
    val propagatedTerminationMessage = new TerminationMessage(terminationMessageRoute)

    println(logPrefix + "(" + reteNode.getClass.getSimpleName + ") Termination protocol sending: " + terminationMessageRoute + " to "
      + terminationMessageTarget)
    if (throttle) Thread.sleep(1000)

    terminationMessageTarget ! propagatedTerminationMessage
  }

  def receive = {
    case conf: ReteNodeConfiguration => configure(conf)
    case updateMessage: UpdateMessage => update(updateMessage)
    case yellowPages: YellowPages => {
      subscribe(yellowPages)
      sender ! ActorReply.YELLOWPAGES_RECEIVED
    }
    case terminationMessage: TerminationMessage => terminationProtocol(terminationMessage)
    case SubscriptionMessage.SUBSCRIBE_SINGLE => subscribeSender(ReteNodeSlot.SINGLE)
    case SubscriptionMessage.SUBSCRIBE_PRIMARY => subscribeSender(ReteNodeSlot.PRIMARY)
    case SubscriptionMessage.SUBSCRIBE_SECONDARY => subscribeSender(ReteNodeSlot.SECONDARY)
    case CoordinatorMessage.INITIALIZE => initialize
    case CoordinatorMessage.INITIALIZE_INPUT => initializeInput
    case CoordinatorMessage.GETQUERYRESULTS => {
      val productionNode = reteNode.asInstanceOf[ProductionNode]
      sender ! productionNode.getDeltaResults
    }
//    case QueryMessage.ALL => {
//      val inputNode = reteNode.asInstanceOf[InputNode];
//      val tuples = inputNode.tuples
//      sender ! tuples
//    }
    case _ => {}
  }

}