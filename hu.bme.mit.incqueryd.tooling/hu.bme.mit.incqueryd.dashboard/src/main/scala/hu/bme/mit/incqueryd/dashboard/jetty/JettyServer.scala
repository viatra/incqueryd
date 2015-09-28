package hu.bme.mit.incqueryd.dashboard.jetty

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.util.thread.QueuedThreadPool


/**
 * @author pappi
 */
class JettyServer(ip : Int) {
  
  private var server : Server = new Server(ip)
  
  def startServer() {
    server.setHandler(ServerContextBuilder.buildHandlers())
    server.start()
  }
  
  def stopServer() {
    server.stop()
  }
  
  def isStarted() : Boolean = {
    server.isStarted()
  }
  
}