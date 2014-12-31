package hu.bme.mit.incqueryd.infrastructureagent

import java.net.InetAddress
import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.infrastructure.Machine
import scala.concurrent.duration.Duration
import java.net.Socket
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import eu.mondo.utils.NetworkUtils

object InfrastructureAgentUtils {

  def isServerListening(host: String, port: Int): Boolean = {
    var s: Socket = null
    try {
      s = new Socket(host, port)
      true
    } catch {
      case e: Exception => false
    } finally {
      if (s != null) try {
        s.close()
      } catch {
        case e: Exception => 
      }
    }
  }

  def waitForServer(host: String, port: Int, timeout: Duration) {
    Await.ready(future {
      while (!isServerListening(host, port)) {
        Thread.sleep(1000)
      }
    }, timeout)
    Thread.sleep(1000) // XXX
  }

  def thisMachineIs(instance: MachineInstance): Boolean = instance.getIp == NetworkUtils.getLocalIpAddress
  
  def thisMachineIs(machine: Machine): Boolean = machine.getIp == NetworkUtils.getLocalIpAddress

}
