package hu.bme.mit.incqueryd.monitoringserver.core

import hu.bme.mit.incqueryd.monitoringserver.core.model.MachineMonitoringData
import java.util.HashMap
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.HostData

import scala.collection.JavaConversions._

object MachineMonitoringDataStore {
  
  private val machineData : HashMap[String, MachineMonitoringData] = new HashMap
  
  def addData (hostData: HostData) = {
    machineData.synchronized(machineData.put(hostData.getHostName, new MachineMonitoringData(hostData.getHostName, hostData.getOs)))
  }
  
  def getData () = {
    machineData.synchronized({
      asJavaList((for {data <- machineData.values} yield new MachineMonitoringData(data.getHost, data.getOs)) toList)
    })
  }
  
}