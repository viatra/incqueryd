package hu.bme.mit.incqueryd.dashboard.fsa

import org.apache.commons.vfs2.FileChangeEvent
import org.apache.commons.vfs2.FileListener
import hu.bme.mit.incqueryd.dashboard.controller.LogController

class LogFileListener(logFilePath : String) extends FileListener {
  
  var logFileReader = new LogFileReader(logFilePath)
  
  def init() : String = {
    logFileReader.readAppended()
  }
  
  override def fileCreated(fileChangeEvent : FileChangeEvent) {
    logFileReader = new LogFileReader(logFilePath)
  }
	
	override def fileDeleted(fileChangeEvent : FileChangeEvent) {
	  logFileReader.close()
	};
  
  override def fileChanged(fileChangeEvent : FileChangeEvent) {
   LogController.broadcastLogUpdate(logFileReader.getFilePath(), logFileReader.readAppended())
  }
  
}
