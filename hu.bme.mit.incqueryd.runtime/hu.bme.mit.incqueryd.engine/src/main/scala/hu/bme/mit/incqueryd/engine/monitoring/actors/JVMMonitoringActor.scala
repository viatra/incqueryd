package hu.bme.mit.incqueryd.engine.monitoring.actors

import akka.actor.Actor
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage
import java.lang.management.ManagementFactory
import hu.bme.mit.incqueryd.jvmmonitoring.metrics.JVMMetrics

import scala.collection.JavaConversions._

class JVMMonitoringActor extends Actor{
  
  val toMega = 1024*1024
  
  var prevProcessCpuTime: Long = 0
  var prevUpTime: Long = 0
  var prevGcCollectionCount: Long = 0
  var prevGcCollectionTime: Long = 0
  
  def receive = {
    case MonitoringMessage.MONITOR => {
      sender ! getJVMMetrics
    }
    
    case _ => {}
  }
  
  def getJVMMetrics: JVMMetrics = {
    val jvmMetrics = new JVMMetrics
    
    val memory = ManagementFactory.getMemoryMXBean
    
    val usedHeap: Double = memory.getHeapMemoryUsage.getUsed / toMega
    val maxHeap: Double = memory.getHeapMemoryUsage.getMax / toMega
    
    jvmMetrics.setMaxHeap( maxHeap )
    jvmMetrics.setUsedHeap( usedHeap )
    jvmMetrics.setUsedHeapPercent( (usedHeap / maxHeap) * 100 )
    
    val usedNonHeap: Double = memory.getNonHeapMemoryUsage.getUsed / toMega
    val maxNonHeap: Double = memory.getNonHeapMemoryUsage.getMax / toMega
    
    jvmMetrics.setMaxNonHeap( maxNonHeap )
    jvmMetrics.setUsedNonHeap( usedNonHeap )
    jvmMetrics.setUsedNonHeapPercent( (usedNonHeap / maxNonHeap) * 100 )
    
    var gcCollectionCount: Long = 0
    var gcCollectionTime: Long = 0
    
    ManagementFactory.getGarbageCollectorMXBeans.foreach(gc => {
      gcCollectionCount += gc.getCollectionCount
      gcCollectionTime += gc.getCollectionTime
    })
    
    jvmMetrics.setGcCollectionCount(gcCollectionCount - prevGcCollectionCount)
    jvmMetrics.setGcCollectionTime(gcCollectionTime - prevGcCollectionTime)
    
    prevGcCollectionCount = gcCollectionCount
    prevGcCollectionTime = gcCollectionTime
    
    jvmMetrics.setName(ManagementFactory.getRuntimeMXBean.getName)
    
    jvmMetrics.setCpuUtilization(calculateCPUUsage)
    
    jvmMetrics
  }
  
  def calculateCPUUsage : Double = {
    val runtimeMXBean = ManagementFactory.getRuntimeMXBean
    val operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean.asInstanceOf[com.sun.management.OperatingSystemMXBean]
    
    val availableProcessors = operatingSystemMXBean.getAvailableProcessors
    val upTime: Long = runtimeMXBean.getUptime
    val processCpuTime: Long  = operatingSystemMXBean.getProcessCpuTime
    val elapsedCpu: Long = processCpuTime - prevProcessCpuTime
    val elapsedTime: Long = upTime - prevUpTime
    
    prevProcessCpuTime = processCpuTime
    prevUpTime = upTime
    
    val cpuUsage: Double = if (elapsedTime == 0) 0 else elapsedCpu / (elapsedTime * 10000 * availableProcessors)
    
    cpuUsage
  }
  
}