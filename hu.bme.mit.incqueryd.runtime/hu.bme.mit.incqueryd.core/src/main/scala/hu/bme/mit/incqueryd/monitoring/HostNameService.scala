package hu.bme.mit.incqueryd.monitoring

import java.net.InetAddress

object HostNameService {
  
  val hostName = InetAddress.getLocalHost.getHostName
  
}