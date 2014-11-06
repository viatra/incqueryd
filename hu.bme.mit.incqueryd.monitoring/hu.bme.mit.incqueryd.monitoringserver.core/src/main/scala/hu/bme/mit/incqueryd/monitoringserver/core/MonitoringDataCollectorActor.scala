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
import hu.bme.mit.incqueryd.monitoringserver.core.data.StringTuple
import hu.bme.mit.incqueryd.monitoringserver.core.data.MonitoringChangeSet
import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.HostData

class MonitoringDataCollectorActor extends Actor {

  def receive = {

    case actorRefs: MonitoredActorCollection => {
      MonitoringAddressStore.putActors(actorRefs.getActorRefs)
      MonitoringAddressStore.putJvmActors(actorRefs.getJvmActorRefs)
      MonitoringAddressStore.addCoordinatorActor(sender)
    }
    
    case reteNodeMetrics: ReteNodeMetrics => ReteMetricsStore putMetric reteNodeMetrics
    
    case hostData : HostData => MachineMonitoringDataStore addData hostData
    
    case str: String => {
      str charAt 0 match {
        case '+' | '-' => QueryResultStore addChangeSet( MonitoringChangeSet from str )
        case _ =>
      }
    }
    
    case _ => {}

  }

}