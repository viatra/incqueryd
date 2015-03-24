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
import hu.bme.mit.incqueryd.engine.rete.nodes.AlphaNode
import hu.bme.mit.incqueryd.engine.rete.nodes.BetaNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ProductionNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ReteNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ReteNodeFactory
import hu.bme.mit.incqueryd.engine.rete.nodes.TypeInputNode
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration
import scala.concurrent.duration._
import java.util.concurrent.CountDownLatch
import scala.concurrent._
import ExecutionContext.Implicits.global

class ReteActor extends Actor {

  def receive = {
    case Configure(configuration) => configure(configuration)
    case EstablishSubscriptions(yellowPages) => establishSubscriptions(yellowPages)
    case RegisterSubscriber(slot) => registerSubscriber(slot)
    case PropagateState(children) => propagateState(children)
    case updateMessage: UpdateMessage => update(updateMessage)
    case terminationMessage: TerminationMessage => terminationProtocol(terminationMessage)
    case GetQueryResults => getQueryResults
  }

  def configure(configuration: ReteNodeConfiguration) = {
    recipe = configuration.getReteNodeRecipe
    reteNode = ReteNodeFactory.createNode(configuration)
    reteNode match {
      case inputNode: TypeInputNode => {
        log(s"Loading input node of type ${inputNode.getRecipe.getTypeName}")
        inputNode.load
      }
      case _ => {}
    }
    log("Configuration finished")
    sender ! ConfigurationFinished
  }

  var recipe: ReteNodeRecipe = _
  var reteNode: ReteNode = _

  def establishSubscriptions(yellowPages: YellowPages) = {
    log("Subscribing to parent(s)")
    for (ReteActorConnection(parent, slot, _) <- YellowPagesUtils.getParentConnections(recipe, yellowPages)) {
      parent ! RegisterSubscriber(slot)
    }
    sender ! SubscriptionFinished
  }

  def registerSubscriber(slot: ReteNodeSlot) = {
    subscribers.put(sender, slot)
    sender ! SubscriberRegistered
    log("Subscriber " + sender + " registered on slot " + slot)
  }

  val subscribers = scala.collection.mutable.Map[ActorRef, ReteNodeSlot]()

  def propagateState(children: Set[ReteActorConnection]) = {
    if (children.isEmpty) {
      sender ! StatePropagated
    } else {
      log(s"Propagating state to ${children.size} children")
      for (ReteActorConnection(_, slot, child) <- children) {
        val changeSet = reteNode.asInstanceOf[TypeInputNode].getChangeSetFromCurrentState
        val route = List()
        sendToSubscriber(changeSet, route, child, slot)
      }
      val originalSender = sender
      pending = new CountDownLatch(children.size)
      future {
        pending.await
      } onSuccess {
        case _ =>
          originalSender ! StatePropagated
      } // TODO timeout?
    }
  }

  var pending: CountDownLatch = _

  def update(updateMessage: UpdateMessage) = {
    log("Update message received, " + updateMessage.changeSet.getChangeType + ", "
      + updateMessage.slot + ", " + updateMessage.changeSet.getTuples.size)
    reteNode match {
      case alphaNode: AlphaNode => {
        val changeSet = alphaNode.update(updateMessage.changeSet)
        for ((subscriber, slot) <- subscribers) {
	      sendToSubscriber(changeSet, updateMessage.route, subscriber, slot)
	    }
      }
      case betaNode: BetaNode => {
        val changeSet = betaNode.update(updateMessage.changeSet, updateMessage.slot)
        for ((subscriber, slot) <- subscribers) {
	      sendToSubscriber(changeSet, updateMessage.route, subscriber, slot)
	    }
      }
      case _ => {}
    }
    reteNode match {
      case _: ProductionNode => {
        if (subscribers.isEmpty) {
          terminationProtocol(new TerminationMessage(updateMessage.route))
        }
      }
      case _ => {}
    }
  }

  def sendToSubscriber(changeSet: ChangeSet, route: List[ActorRef], subscriber: ActorRef, slot: ReteNodeSlot) = {
    val propagatedRoute = self :: route
    val updateMessage = new UpdateMessage(changeSet, slot, propagatedRoute)

    log(" Sending to " + subscriber)
    log(" " + changeSet.getChangeType + " changeset, " + changeSet.getTuples.size + " tuples")
    log(" Propagated route: " + propagatedRoute)

    subscriber ! updateMessage
  }

  def terminationProtocol(terminationMessage: TerminationMessage): Unit = {
    val route = terminationMessage.route
    if (route.isEmpty) {
      pending.countDown
      log(s"Termination protocol finished from $sender, ${pending.getCount} updates pending")
    } else {
      val target = route.head
      val newRoute = route.tail
      val propagatedTerminationMessage = new TerminationMessage(newRoute)
      log("Termination protocol sending: " + newRoute + " to " + target)
      if (throttle) Thread.sleep(1000)
      target ! propagatedTerminationMessage
    }
  }

  val throttle = false // throttle termination protocol

  def getQueryResults = {
    val productionNode = reteNode.asInstanceOf[ProductionNode]
	sender ! productionNode.getResults
  }

  def log(message: String) {
    println("(" + reteNode.getClass.getSimpleName + ", " + recipe.getTraceInfo + ") " + self + " " + message)
  }

}