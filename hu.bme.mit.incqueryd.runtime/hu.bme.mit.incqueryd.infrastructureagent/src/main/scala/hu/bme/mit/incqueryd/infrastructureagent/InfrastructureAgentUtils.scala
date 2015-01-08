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
import scala.util.Try
import scala.util.Failure
import scala.util.Success

object InfrastructureAgentUtils {

  @annotation.tailrec
  def retry[T](n: Int)(delayMillis: Long)(fn: => T): T = {
    Try { fn } match {
      case Success(x) => x
      case _ if n > 1 => { Thread.sleep(delayMillis); retry(n - 1)(delayMillis)(fn) }
      case Failure(e) => throw e
    }
  }

  def thisMachineIs(machine: Machine): Boolean = machine.getIp == NetworkUtils.getLocalIpAddress

}
