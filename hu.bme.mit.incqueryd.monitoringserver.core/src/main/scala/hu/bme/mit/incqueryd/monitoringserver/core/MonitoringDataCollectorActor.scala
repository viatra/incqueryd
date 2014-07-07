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
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoredMachines

class MonitoringDataCollectorActor extends Actor {

  def receive = {

    case beta: BetaNodeMetrics => 

    case input: InputNodeMetrics => 

    case alpha: AlphaNodeMetrics => 

    case actorRefs: MonitoredActorCollection => ReteActorHandler.putActors(actorRefs.getActorRefs)
    
    case machines: MonitoredMachines => {
      machines.getMachineIPs().foreach(m => println(m))
    }
    
    case _ => {}

  }

}