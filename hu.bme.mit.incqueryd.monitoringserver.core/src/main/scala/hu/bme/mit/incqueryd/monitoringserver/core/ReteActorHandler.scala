package hu.bme.mit.incqueryd.monitoringserver.core

import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import java.util.HashMap
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import java.util.Collection
import java.util.ArrayList
import akka.actor.ActorRef

object ReteActorHandler {
  
  private val actorRefs: ArrayList[ActorRef] = new ArrayList[ActorRef]
  
  def putActors(actors: Collection[ActorRef]) = {
    actorRefs.synchronized({
      actorRefs.clear();
      actorRefs.addAll(actors)
    })
    
  }
  
  def getActors(): java.util.List[ActorRef] = actorRefs.synchronized(actorRefs)
  
}