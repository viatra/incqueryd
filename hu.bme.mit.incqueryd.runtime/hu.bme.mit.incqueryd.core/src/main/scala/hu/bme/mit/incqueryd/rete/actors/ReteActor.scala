package hu.bme.mit.incqueryd.rete.actors

import java.util.ArrayList
import java.util.HashMap
import scala.collection.JavaConversions._
import scala.collection.immutable.Stack
import scala.concurrent.ops._
import org.apache.commons.lang.NotImplementedException
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
import akka.actor.Actor
import akka.actor.ActorRef
import hu.bme.mit.incqueryd.arch.util.ArchUtil
import hu.bme.mit.incqueryd.monitoring.HostNameService
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.rete.messages.ActorReply
import hu.bme.mit.incqueryd.rete.messages.CoordinatorMessage
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage
import hu.bme.mit.incqueryd.rete.messages.TerminationMessage
import hu.bme.mit.incqueryd.rete.messages.Transformation
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage
import hu.bme.mit.incqueryd.rete.messages.YellowPages
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode
import hu.bme.mit.incqueryd.rete.nodes.BetaNode
import hu.bme.mit.incqueryd.rete.nodes.InputNode
import hu.bme.mit.incqueryd.rete.nodes.ProductionNode
import hu.bme.mit.incqueryd.rete.nodes.ReteNode
import hu.bme.mit.incqueryd.rete.nodes.ReteNodeFactory
import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.InputNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage
import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteSubscriber
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration
import hu.bme.mit.incqueryd.rete.messages.ReteCommunicationMessage
import hu.bme.mit.incqueryd.retemonitoring.metrics.MemoryNodeMetrics

class ReteActor extends Actor {

  protected var recipe: ReteNodeRecipe = null
  protected var reteNode: ReteNode = null
  protected var subscribers = new HashMap[ActorRef, ReteNodeSlot]
  protected var pendingTerminationMessages = 0
  protected var coordinatorRef: ActorRef = null

  protected var updateMessageCount = 0 // To count how many update messages this actor sent
  protected var changesCount = 0 // To count how many tuple changes it sent

  protected var monitoringServerActor: ActorRef = null

  println("[ReteActor] Rete actor instantiated.")

  private def configure(conf: ReteNodeConfiguration) = {
    recipe = conf.getReteNodeRecipe()
    reteNode = ReteNodeFactory.createNode(conf)

    println("[ReteActor] " + reteNode.getClass().getName() + " configuration received.")

    sender ! ActorReply.CONFIGURATION_RECEIVED
  }

  private def subscribe(yellowPages: YellowPages) = {

    monitoringServerActor = yellowPages.getMonitoringServerAddress

    val emfUriToActorRef = yellowPages.getEmfUriToActorRef()

    println();
    println("[ReteActor] " + self + ", " + reteNode.getClass().getName() + ": "
      + recipe.toString())

    recipe match {
      case alphaRecipe: AlphaRecipe => {
        val parent = alphaRecipe.getParent
        val parentUri = ArchUtil.getJsonEObjectUri(parent)
        val parentActorRef = emfUriToActorRef.get(parentUri)

        println("[ReteActor] - parent: " + parentUri + " -> " + parentActorRef)

        subscribeToActor(parentActorRef, ReteNodeSlot.SINGLE)
      }
      case betaRecipe: BetaRecipe => {
        val primaryParent = betaRecipe.getLeftParent.getParent
        val secondaryParent = betaRecipe.getRightParent.getParent

        val primaryParentUri = ArchUtil.getJsonEObjectUri(primaryParent)
        val primaryParentActorRef = emfUriToActorRef.get(primaryParentUri)

        println("[ReteActor] - primary parent URI: " + primaryParentUri + " -> " + primaryParentActorRef)

        val secondaryParentUri = ArchUtil.getJsonEObjectUri(secondaryParent)
        val secondaryParentActorRef = emfUriToActorRef.get(secondaryParentUri)

        println("[ReteActor] - secondary parent URI: " + secondaryParentUri + " -> "
          + secondaryParentActorRef)

        subscribeToActor(primaryParentActorRef, ReteNodeSlot.PRIMARY)
        subscribeToActor(secondaryParentActorRef, ReteNodeSlot.SECONDARY)
      }
      case productionRecipe: ProductionRecipe => {
        val parents = productionRecipe.getParents

        parents.foreach(parent => {
          val parentUri = ArchUtil.getJsonEObjectUri(parent)
          val parentActorRef = emfUriToActorRef.get(parentUri)

          println("[ReteActor] - parent URI: " + parentUri + " -> " + parentActorRef)

          subscribeToActor(parentActorRef, ReteNodeSlot.SINGLE)
        })

      }
      case _ => {}
    }

  }

  protected def subscribeToActor(actorRef: ActorRef, slot: ReteNodeSlot) = {

    val message = slot match {
      case ReteNodeSlot.PRIMARY => SubscriptionMessage.SUBSCRIBE_PRIMARY
      case ReteNodeSlot.SECONDARY => SubscriptionMessage.SUBSCRIBE_SECONDARY
      case ReteNodeSlot.SINGLE => SubscriptionMessage.SUBSCRIBE_SINGLE
      case _ => null
    }

    actorRef ! message

    try {
      Thread.sleep(200)
    } catch {
      case e: InterruptedException => e.printStackTrace()
    }
  }

  protected def subscribeSender(slot: ReteNodeSlot) = {

    subscribers.put(sender, slot)

    sender ! ActorReply.SUBSCRIBED

    println("[ReteActor] " + self + ": Subscribed: " + sender + " on slot " + slot)

  }

  private def update(updateMessage: UpdateMessage) = {
    println("[ReteActor] " + self + ", " + reteNode.getClass().getName()
      + ": update message received, " + updateMessage.getChangeSet().getChangeType() + " "
      + updateMessage.getNodeSlot() + " " + updateMessage.getChangeSet().getTuples().size())

    var changeSet: ChangeSet = null

    updateMessage.getNodeSlot match {
      case ReteNodeSlot.SINGLE => {
        changeSet = reteNode.asInstanceOf[AlphaNode].update(updateMessage.getChangeSet)
      }
      case ReteNodeSlot.PRIMARY | ReteNodeSlot.SECONDARY => {
        changeSet = reteNode.asInstanceOf[BetaNode].update(updateMessage.getChangeSet, updateMessage.getNodeSlot)
      }
      case _ => {
        throw new NotImplementedException(updateMessage.getNodeSlot() + " slot is not supported.")
      }
    }

    sendToSubscribers(changeSet, updateMessage.getRoute)

    if (monitoringServerActor != null) monitoringServerActor ! monitor // send the monitoring server the updated metrics

    reteNode match {
      case node: ProductionNode => terminationProtocol(new TerminationMessage(updateMessage.getRoute))
      case _ => {}
    }
  }

  protected def sendToSubscribers(changeSet: ChangeSet, senderStack: Stack[ActorRef]) = {
    if (changeSet != null) {
      updateMessageCount += 1
    }

    subscribers.entrySet.foreach(entry => {
      val subscriber = entry.getKey
      val slot = entry.getValue

      val propagatedRoute = senderStack.push(self)
      val updateMessage = new UpdateMessage(changeSet, slot, propagatedRoute)

      // @formatter:off
      println("[ReteActor] " + self + ", " + reteNode.getClass().getName() + "\n"
        + "            - Sending to " + subscriber + "\n"
        + "            - " + changeSet.getChangeType() + " changeset, " + changeSet.getTuples().size() + " tuples\n"
        + "            - " + "with sender stack: " + propagatedRoute + "\n"
        + "            - " + pendingTerminationMessages + " pending\n")
      // @formatter:on

      subscriber ! updateMessage
    })

    if (changeSet != null) changesCount += changeSet.getTuples.size // In case it's not a production node

  }

  private def initialize = {
    coordinatorRef = sender

    if (monitoringServerActor != null) monitoringServerActor ! monitor // send the monitoring server the updated metrics    
  }

  private def terminationProtocol(terminationMessage: TerminationMessage): Unit = {
    val route = terminationMessage.getRoute

    val pair = route.pop2
    val terminationMessageTarget = pair._1
    val terminationMessageRoute = pair._2

    val propagatedTerminationMessage = new TerminationMessage(terminationMessageRoute)
    terminationMessageTarget ! propagatedTerminationMessage

    println("[ReteActor] Termination protocol sending: " + terminationMessageRoute + " to "
      + terminationMessageTarget)

    return
  }

  private def monitor: ReteNodeMetrics = {
    val clazz = reteNode.getClass.getName.split("\\.")
    val nodeType = clazz(clazz.length - 1)

    val subscriberNodes: java.util.List[ReteSubscriber] = new ArrayList
    subscribers.keySet().foreach(subscriber => {
      subscriberNodes.add(new ReteSubscriber(subscriber.path.name, subscribers.get(subscriber).toString))
    })

    reteNode match {
      case inputNode: InputNode => new InputNodeMetrics(self.path.name, HostNameService.hostName, HostNameService.processName, nodeType, "Input", self.path.toString, updateMessageCount, changesCount, inputNode.tuples, inputNode.getMemoryConsumption, subscriberNodes)
      case productionNode: ProductionNode => new MemoryNodeMetrics(self.path.name, HostNameService.hostName, HostNameService.processName, nodeType, "Production", self.path.toString, updateMessageCount, changesCount, productionNode.getMemoryConsumption, subscriberNodes)
      case alphaNode: AlphaNode => new AlphaNodeMetrics(self.path.name, HostNameService.hostName, HostNameService.processName, nodeType, "Alpha", self.path.toString, updateMessageCount, changesCount, subscriberNodes)
      case betaNode: BetaNode => new BetaNodeMetrics(self.path.name, HostNameService.hostName, HostNameService.processName, nodeType, "Beta", self.path.toString, updateMessageCount, changesCount, betaNode.leftIndexerSize, betaNode.rightIndexerSize, betaNode.getMemoryConsumption, subscriberNodes)
    }
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
    case CoordinatorMessage.GETQUERYRESULTS => {
      val productionNode = reteNode.asInstanceOf[ProductionNode]
      sender ! productionNode.getDeltaResults
    }
    case _ => {}
  }

}