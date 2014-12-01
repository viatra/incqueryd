package hu.bme.mit.incqueryd.engine.rete.actors

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
import hu.bme.mit.incqueryd.engine.monitoring.HostNameService
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot
import hu.bme.mit.incqueryd.engine.rete.messages.ActorReply
import hu.bme.mit.incqueryd.engine.rete.messages.CoordinatorMessage
import hu.bme.mit.incqueryd.engine.rete.messages.SubscriptionMessage
import hu.bme.mit.incqueryd.engine.rete.messages.TerminationMessage
import hu.bme.mit.incqueryd.engine.rete.messages.Transformation
import hu.bme.mit.incqueryd.engine.rete.messages.UpdateMessage
import hu.bme.mit.incqueryd.engine.rete.messages.YellowPages
import hu.bme.mit.incqueryd.engine.rete.nodes.AlphaNode
import hu.bme.mit.incqueryd.engine.rete.nodes.BetaNode
import hu.bme.mit.incqueryd.engine.rete.nodes.InputNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ProductionNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ReteNode
import hu.bme.mit.incqueryd.engine.rete.nodes.ReteNodeFactory
import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.InputNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage
import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteSubscriber
import hu.bme.mit.incqueryd.retemonitoring.metrics.MemoryNodeMetrics
import hu.bme.mit.incqueryd.engine.util.ReteNodeConfiguration
import hu.bme.mit.incqueryd.engine.rete.messages.ReteCommunicationMessage
import java.nio.channels.NotYetBoundException
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe
import org.apache.velocity.runtime.directive.Foreach
import org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe
import hu.bme.mit.incqueryd.engine.rete.messages.QueryMessage

class ReteActor extends Actor {

  var logPrefix = "[ReteActor       ] "

  // throttle termination protocol
  val throttle = false
    
  var recipe: ReteNodeRecipe = null
  var reteNode: ReteNode = null
  var subscribers = new HashMap[ActorRef, ReteNodeSlot]
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

    monitoringServerActor = yellowPages.getMonitoringServerAddress

    val emfUriToActorRef = yellowPages.getEmfUriToActorRef

    println(logPrefix + self + ", Recipe: " + recipe.toString)

    recipe match {
      case alphaRecipe: AlphaRecipe => {
        val parent = alphaRecipe.getParent
        val parentUri = ArchUtil.getJsonEObjectUri(parent)
        val parentActorRef = emfUriToActorRef.get(parentUri)

        println(logPrefix + "Parent: " + parentUri + " -> " + parentActorRef)

        subscribeToActor(parentActorRef, ReteNodeSlot.SINGLE)
      }
      case betaRecipe: BetaRecipe => {
        val primaryParent = betaRecipe.getLeftParent.getParent
        val secondaryParent = betaRecipe.getRightParent.getParent

        val primaryParentUri = ArchUtil.getJsonEObjectUri(primaryParent)
        val primaryParentActorRef = emfUriToActorRef.get(primaryParentUri)

        println(logPrefix + "Primary parent URI: " + primaryParentUri + " -> " + primaryParentActorRef)

        val secondaryParentUri = ArchUtil.getJsonEObjectUri(secondaryParent)
        val secondaryParentActorRef = emfUriToActorRef.get(secondaryParentUri)

        println(logPrefix + "Secondary parent URI: " + secondaryParentUri + " -> "
          + secondaryParentActorRef)

        subscribeToActor(primaryParentActorRef, ReteNodeSlot.PRIMARY)
        subscribeToActor(secondaryParentActorRef, ReteNodeSlot.SECONDARY)
      }
      case productionRecipe: ProductionRecipe => {
        val parents = productionRecipe.getParents

        parents.foreach(parent => {
          val parentUri = ArchUtil.getJsonEObjectUri(parent)
          val parentActorRef = emfUriToActorRef.get(parentUri)

          println(logPrefix + "Parent URI: " + parentUri + " -> " + parentActorRef)

          subscribeToActor(parentActorRef, ReteNodeSlot.SINGLE)
        })

      }
      case multiParentNodeRecipe: MultiParentNodeRecipe => {
        val parents = multiParentNodeRecipe.getParents
        parents.foreach(parent => {
          val parentUri = ArchUtil.getJsonEObjectUri(parent)
          val parentActorRef = emfUriToActorRef.get(parentUri)

          println(logPrefix + "Parent: " + parentUri + " -> " + parentActorRef)

          subscribeToActor(parentActorRef, ReteNodeSlot.SINGLE)
        })
      }
      case _ => {}
    }

  }

  def subscribeToActor(actorRef: ActorRef, slot: ReteNodeSlot) = {

    val message = slot match {
      case ReteNodeSlot.PRIMARY => SubscriptionMessage.SUBSCRIBE_PRIMARY
      case ReteNodeSlot.SECONDARY => SubscriptionMessage.SUBSCRIBE_SECONDARY
      case ReteNodeSlot.SINGLE => SubscriptionMessage.SUBSCRIBE_SINGLE
      case _ => null
    }

    actorRef ! message

    try {
      Thread.sleep(100)
    } catch {
      case e: InterruptedException => e.printStackTrace
    }
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
        throw new NotImplementedException(updateMessage.getNodeSlot + " slot is not supported.")
      }
    }

    sendToSubscribers(changeSet, updateMessage.getRoute)

    if (monitoringServerActor != null) monitoringServerActor ! monitor // send the monitoring server the updated metrics

    reteNode match {
      case node: ProductionNode => {
        if (subscribers.isEmpty()) terminationProtocol(new TerminationMessage(updateMessage.getRoute))
      }
      case _ => {}
    }
  }

  def sendToSubscribers(changeSet: ChangeSet, senderStack: Stack[ActorRef]) = {
    if (changeSet != null) {
      updateMessageCount += 1
    }

    subscribers.entrySet.foreach(entry => {
      val subscriber = entry.getKey
      val slot = entry.getValue

      val propagatedRoute = senderStack.push(self)
      val updateMessage = new UpdateMessage(changeSet, slot, propagatedRoute)

      // @formatter:off
      println(logPrefix + self + "\n"
        + logPrefix + "  " + "Sending to " + subscriber + "\n"
        + logPrefix + "  " + changeSet.getChangeType + " changeset, " + changeSet.getTuples.size + " tuples\n"
        + logPrefix + "  " + "Propagated route: " + propagatedRoute + "\n")
      // @formatter:on

      subscriber ! updateMessage
    })

    if (changeSet != null) changesCount += changeSet.getTuples.size // In case it's not a production node
  }

  def initialize = {
    coordinatorRef = sender

    if (monitoringServerActor != null) monitoringServerActor ! monitor // send the monitoring server the updated metrics    
  }
  
  def initializeInput = {
	println(logPrefix + " Initializing input node")
    val inputNode = reteNode.asInstanceOf[InputNode]
    val changeSet = inputNode.initialize
    val senderStack = Stack(sender, self)
    val updateMessage = new UpdateMessage(changeSet, ReteNodeSlot.SINGLE, senderStack)
	self.tell(updateMessage)
  }

  def terminationProtocol(terminationMessage: TerminationMessage): Unit = {
    val route = terminationMessage.getRoute

    val pair = route.pop2
    val terminationMessageTarget = pair._1
    val terminationMessageRoute = pair._2

    val propagatedTerminationMessage = new TerminationMessage(terminationMessageRoute)

    println(logPrefix + "(" + reteNode.getClass.getSimpleName + ") Termination protocol sending: " + terminationMessageRoute + " to "
      + terminationMessageTarget)
    if (throttle) Thread.sleep(1000)

    terminationMessageTarget ! propagatedTerminationMessage
  }

  def monitor: ReteNodeMetrics = {
    val subscriberNodes: java.util.List[ReteSubscriber] = new ArrayList
    subscribers.keySet.foreach(subscriber => {
      subscriberNodes.add(new ReteSubscriber(subscriber.path.name, subscribers.get(subscriber).toString))
    })

    reteNode match {
      case inputNode: InputNode => new InputNodeMetrics(self.path.name, HostNameService.hostName, HostNameService.processName, nodeType, "Input", self.path.toString, updateMessageCount, changesCount, inputNode.tuples.size, inputNode.getMemoryConsumption, subscriberNodes, inputNode.typeName)
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
    case CoordinatorMessage.INITIALIZE_INPUT => initializeInput
    case CoordinatorMessage.GETQUERYRESULTS => {
      val productionNode = reteNode.asInstanceOf[ProductionNode]
      sender ! productionNode.getDeltaResults
    }
    case QueryMessage.ALL => {
      val inputNode = reteNode.asInstanceOf[InputNode];
      val tuples = inputNode.tuples
      sender ! tuples
    }
    case _ => {}
  }

}