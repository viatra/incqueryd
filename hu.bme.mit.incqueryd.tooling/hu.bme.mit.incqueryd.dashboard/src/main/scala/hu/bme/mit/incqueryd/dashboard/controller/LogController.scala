package hu.bme.mit.incqueryd.dashboard.controller

import java.util.concurrent.Executors

import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet

import hu.bme.mit.incqueryd.dashboard.fsa.LogFileListener
import hu.bme.mit.incqueryd.dashboard.fsa.LogFileMonitor
import hu.bme.mit.incqueryd.dashboard.fsa.LogFileMonitor

object LogController {
   
  var HDFS_LOG_MOUNT_POINT : String = "/mnt/iqdhdfs/logs"
  
  trait LogUpdateListener {
    def logUpdateReceived(update : String)
  }
  
  val executorService = Executors.newCachedThreadPool()
  
  val logListeners : HashMap[String, HashSet[LogUpdateListener]] = new HashMap[String, HashSet[LogUpdateListener]]()
  
  val logFileContents : HashMap[String, StringBuilder] = new HashMap[String, StringBuilder]()
  
  val logFileMonitors : HashMap[String, LogFileMonitor] = new HashMap[String, LogFileMonitor]();
  
  def registerLogUpdateListener(logFilePath : String, listener: LogUpdateListener) {
    this.synchronized {
      logListeners.getOrElseUpdate(logFilePath, new HashSet[LogUpdateListener]()).add(listener)
      val logMonitor = logFileMonitors.get(logFilePath)
      if(logMonitor.isEmpty) {
        val logFileListener =  new LogFileListener(logFilePath)
        val fileContentBuilder = logFileContents.getOrElseUpdate(logFilePath, new StringBuilder)
        fileContentBuilder.append(logFileListener.init())
        logFileMonitors.put(logFilePath, new LogFileMonitor(logFilePath, logFileListener))
      }
    }
  }
  
  def removeListener(logFilePath : String, listener: LogUpdateListener) {
    this.synchronized {
      logListeners.getOrElseUpdate(logFilePath, new HashSet[LogUpdateListener]()).remove(listener)
    }
  }
  
  def broadcastLogUpdate(logFilePath : String, update : String) {
    this.synchronized {
      logFileContents.getOrElseUpdate(logFilePath, new StringBuilder()).append(update)
      logListeners.getOrElseUpdate(logFilePath, new HashSet[LogUpdateListener]()).foreach { 
        _.logUpdateReceived(update)
      }
    }
  }
  
  def getLogFileContent(logFilePath : String) : String = {
    logFileContents.getOrElse(logFilePath, new StringBuilder()).toString()
  }
  
}
