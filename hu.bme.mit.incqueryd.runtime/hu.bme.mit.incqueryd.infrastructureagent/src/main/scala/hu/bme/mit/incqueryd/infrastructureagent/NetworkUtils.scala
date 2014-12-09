package hu.bme.mit.incqueryd.infrastructureagent

import java.net.InetAddress
import hu.bme.mit.incqueryd.inventory.MachineInstance
import hu.bme.mit.incqueryd.infrastructure.Machine

object NetworkUtils {

  def getLocalIpAddress: String = InetAddress.getLocalHost.getHostAddress

  def thisMachineIs(instance: MachineInstance): Boolean = instance.getIp == getLocalIpAddress
  
  def thisMachineIs(machine: Machine): Boolean = machine.getIp == getLocalIpAddress

}
