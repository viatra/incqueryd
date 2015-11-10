package hu.bme.mit.incqueryd.dashboard.fsa

import org.apache.commons.vfs2.impl.DefaultFileMonitor
import org.apache.commons.vfs2.VFS

class LogFileMonitor(logFilePath : String, logFileListener : LogFileListener) extends DefaultFileMonitor(logFileListener) {
    
  	val fsManager = VFS.getManager();
 		val file = fsManager.resolveFile(logFilePath);
		addFile(file)
		setDelay(1)
		start
		
}
