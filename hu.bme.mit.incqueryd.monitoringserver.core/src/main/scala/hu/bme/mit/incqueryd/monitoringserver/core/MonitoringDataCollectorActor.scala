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

class MonitoringDataCollectorActor extends Actor {

  def receive = {

    case beta: BetaNodeMetrics => ReteMetricsCollector.putBetaMetrics(beta.getReteNode(), beta)

    case input: InputNodeMetrics => 

    case alpha: AlphaNodeMetrics => ReteMetricsCollector.putAlphaMetrics(alpha.getReteNode(), alpha)

    case actorRefs: MonitoredActorCollection => 
    
    case _ => {}

  }

}