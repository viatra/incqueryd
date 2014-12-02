package hu.bme.mit.incqueryd.agent

import java.net.InetAddress
import inventory.MachineInstance
import infrastructure.Machine

object NetworkUtils {

  def getLocalIpAddress: String = InetAddress.getLocalHost.getHostAddress

  def thisMachineIs(machine: MachineInstance): Boolean = machine.getIp == getLocalIpAddress
  
  def thisMachineIs(machine: Machine): Boolean = machine.getIp == getLocalIpAddress

}
