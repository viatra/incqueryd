package hu.bme.mit.incqueryd.engine.rete.actors

import scala.collection.JavaConversions.asScalaBuffer
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.actorRef2Scala
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.engine.rete.messages.ActorReply
import hu.bme.mit.incqueryd.engine.rete.messages.CoordinatorMessage
import hu.bme.mit.incqueryd.engine.rete.messages.SubscriptionMessage
import hu.bme.mit.incqueryd.engine.rete.messages.UpdateMessage
import hu.bme.mit.incqueryd.engine.rete.nodes.AlphaNode
import hu.bme.mit.incqueryd.engine.rete.nodes.BetaNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ProductionNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ReteNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ReteNodeFactory
import hu.bme.mit.incqueryd.engine.rete.nodes.TypeInputNode
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration
import scala.collection.immutable.Stack
import hu.bme.mit.incqueryd.engine.rete.messages.TerminationMessage

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
    sender ! ActorReply.YELLOWPAGES_RECEIVED
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
      + "Update message received, " + updateMessage.changeSet.getChangeType + ", "
      + updateMessage.nodeSlot + ", " + updateMessage.changeSet.getTuples.size)

    var changeSet: ChangeSet = null

    updateMessage.nodeSlot match {
      case ReteNodeSlot.SINGLE => {
        changeSet = reteNode.asInstanceOf[AlphaNode].update(updateMessage.changeSet)
      }
      case ReteNodeSlot.PRIMARY | ReteNodeSlot.SECONDARY => {
        changeSet = reteNode.asInstanceOf[BetaNode].update(updateMessage.changeSet, updateMessage.nodeSlot)
      }
      case _ => {
        throw new UnsupportedOperationException(updateMessage.nodeSlot + " slot is not supported.")
      }
    }

    sendToSubscribers(changeSet, updateMessage.route)

    reteNode match {
      case node: ProductionNode => {
        if (subscribers.isEmpty) terminationProtocol(new TerminationMessage(updateMessage.route))
      }
      case _ => {}
    }
  }

  def sendToSubscribers(changeSet: ChangeSet, senderStack: List[ActorRef]) = {
    if (changeSet != null) {
      updateMessageCount += 1
    }

    for ((subscriber, slot) <- subscribers) {

      val propagatedRoute = self :: senderStack
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
    val inputNode = reteNode.asInstanceOf[TypeInputNode]
    println(logPrefix + s" Initializing input node ${inputNode.getRecipe.getTypeName}")
    inputNode.load
    val changeSet = inputNode.getChangeSet
    val senderStack = List(sender, self)
    sendToSubscribers(changeSet, senderStack)
  }

  def terminationProtocol(terminationMessage: TerminationMessage): Unit = {
    val route = terminationMessage.route

    val terminationMessageTarget = route.head
    val terminationMessageRoute = route.tail
    
    val propagatedTerminationMessage = new TerminationMessage(terminationMessageRoute)

    println(logPrefix + "(" + reteNode.getClass.getSimpleName + ") Termination protocol sending: " + terminationMessageRoute + " to "
      + terminationMessageTarget)
    if (throttle) Thread.sleep(1000)

    terminationMessageTarget ! propagatedTerminationMessage
  }

  def receive = {
    case conf: ReteNodeConfiguration => configure(conf)
    case updateMessage: UpdateMessage => update(updateMessage)
    case yellowPages: YellowPages => subscribe(yellowPages)
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
    case _ => {}
  }

}