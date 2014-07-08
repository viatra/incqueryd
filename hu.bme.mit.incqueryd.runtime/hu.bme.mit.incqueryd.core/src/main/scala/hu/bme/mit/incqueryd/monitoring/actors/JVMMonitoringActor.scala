package hu.bme.mit.incqueryd.monitoring.actors

import akka.actor.Actor
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage
import java.lang.management.ManagementFactory
import hu.bme.mit.incqueryd.jvmmonitoring.metrics.JVMMetrics

import scala.collection.JavaConversions._

class JVMMonitoringActor extends Actor{
  
  val toMega = 1024*1024
  
  def receive = {
    case MonitoringMessage.MONITOR => {
      sender ! getJVMMetrics
    }
    
    case _ => {}
  }
  
  private def getJVMMetrics: JVMMetrics = {
    val jvmMetrics = new JVMMetrics
    
    val memory = ManagementFactory.getMemoryMXBean
    
    jvmMetrics.setMaxHeap(memory.getHeapMemoryUsage.getMax / toMega)
    jvmMetrics.setUsedHeap(memory.getHeapMemoryUsage.getUsed / toMega)
    
    jvmMetrics.setMaxNonHeap(memory.getNonHeapMemoryUsage.getMax / toMega)
    jvmMetrics.setUsedNonHeap(memory.getNonHeapMemoryUsage.getUsed / toMega)
    
    var gcCollectionCount: Long = 0
    var gcCollectionTime: Long = 0
    
    ManagementFactory.getGarbageCollectorMXBeans.foreach(gc => {
      gcCollectionCount += gc.getCollectionCount
      gcCollectionTime += gc.getCollectionTime
    })
    
    jvmMetrics.setGcCollectionCount(gcCollectionCount)
    jvmMetrics.setGcCollectionTime(gcCollectionTime)
    
    jvmMetrics.setName(ManagementFactory.getRuntimeMXBean.getName)
    
    jvmMetrics.setCpuUtilization(0)
    
    val v = ManagementFactory.getOperatingSystemMXBean().asInstanceOf[com.sun.management.OperatingSystemMXBean]
    
    jvmMetrics
  }
  
}