package hu.bme.mit.incqueryd.engine.monitoring

import java.net.InetAddress
import java.lang.management.ManagementFactory

object HostNameService {
  
  val hostName = InetAddress.getLocalHost.getHostName
  
  val processName = ManagementFactory.getRuntimeMXBean.getName
  
}