package hu.bme.mit.incqueryd.monitoringserver.core

import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import java.util.HashMap
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import java.util.Collection
import java.util.ArrayList
import akka.actor.ActorRef
import java.util.HashSet

import scala.collection.JavaConversions._

object MonitoringAddressStore {
  
  private val actorRefs: ArrayList[ActorRef] = new ArrayList[ActorRef]
  
  private val monitoredMachinesIPs: HashSet[String] = new HashSet[String]
  
  def putActors(actors: Collection[ActorRef]) = {
    actorRefs.synchronized({
      actorRefs.clear();
      actorRefs.addAll(actors)
    })
    
  }
  
  def getActors : java.util.List[ActorRef] = {
    actorRefs.synchronized(for {actor <- actorRefs} yield actor)
  }
  
  def putMachines(machines: Collection[String]) = {
    monitoredMachinesIPs.addAll(machines)
  }
  
  def getMachines : java.util.Set[String] = monitoredMachinesIPs
  
}