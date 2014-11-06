package hu.bme.mit.incqueryd.monitoringserver.core

import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics
import java.util.HashMap

import scala.collection.JavaConversions._


object ReteMetricsStore {
  
  private val reteMetrics : HashMap[String, ReteNodeMetrics] = new HashMap
  
  def putMetric(metric : ReteNodeMetrics) = {
    reteMetrics.synchronized({
      reteMetrics.put(metric.getReteNode, metric)
    })
  }
  
  def getMetrics = {
    reteMetrics.synchronized({
      asJavaList((for {metric <- reteMetrics.values} yield metric) toList)
    })
  }

}