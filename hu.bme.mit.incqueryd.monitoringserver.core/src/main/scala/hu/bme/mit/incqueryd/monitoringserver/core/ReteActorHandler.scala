package hu.bme.mit.incqueryd.monitoringserver.core

import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import java.util.HashMap
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import java.util.Collection
import java.util.ArrayList
import akka.actor.ActorRef

object ReteActorHandler {
  
  protected val alphaMetrics:HashMap[String, AlphaNodeMetrics] = new HashMap[String, AlphaNodeMetrics]
  
  protected val betaMetrics:HashMap[String, BetaNodeMetrics] = new HashMap[String, BetaNodeMetrics]
  
  private val actorRefs: ArrayList[ActorRef] = new ArrayList[ActorRef]
  
  def putAlphaMetrics(node: String, metrics: AlphaNodeMetrics) = {
    alphaMetrics.synchronized {
      alphaMetrics.put(node, metrics)
    }
  }
  
  def putBetaMetrics(node: String, metrics: BetaNodeMetrics) = {
    betaMetrics.synchronized {
      betaMetrics.put(node, metrics)
    }
  }
  
  def getAlphaMetrics(): Collection[AlphaNodeMetrics] = {
    alphaMetrics.synchronized {
      return alphaMetrics.values
    }
  }
  
  def getBetaMetrics(): Collection[BetaNodeMetrics] = {
    betaMetrics.synchronized {
      return betaMetrics.values
    }
  }
  
  def putActors(actors: Collection[ActorRef]) = {
    actorRefs.addAll(actors)
  }
  
  def getActors(): java.util.List[ActorRef] = actorRefs
  
}