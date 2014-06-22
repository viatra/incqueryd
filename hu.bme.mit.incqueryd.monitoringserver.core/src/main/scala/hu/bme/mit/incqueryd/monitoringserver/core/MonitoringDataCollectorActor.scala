package hu.bme.mit.incqueryd.monitoringserver.core

import akka.actor.Actor
import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import scala.concurrent.ops._
import hu.bme.mit.incqueryd.retemonitoring.metrics.InputNodeMetrics
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage
import java.util.ArrayList
import akka.actor.ActorRef
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoredActorCollection
import scala.collection.JavaConversions._

class MonitoringDataCollectorActor extends Actor {

  def receive = {

    case beta: BetaNodeMetrics => println("beta")

    case input: InputNodeMetrics => println("input")

    case alpha: AlphaNodeMetrics => println("alpha")

    case actorRefs: MonitoredActorCollection => ReteActorHandler.putActors(actorRefs.getActorRefs)
    
    case _ => {}

  }

}