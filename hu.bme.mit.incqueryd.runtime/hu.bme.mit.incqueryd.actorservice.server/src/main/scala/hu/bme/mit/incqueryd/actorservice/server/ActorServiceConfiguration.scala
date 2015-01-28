package hu.bme.mit.incqueryd.actorservice.server

import io.dropwizard.Configuration
import io.dropwizard.server.DefaultServerFactory
import io.dropwizard.jetty.HttpConnectorFactory
import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.actorservice.RemoteActorService

class ActorServiceConfiguration extends Configuration {
  val serverFactory = getServerFactory().asInstanceOf[DefaultServerFactory]
  val connectorFactory = serverFactory.getApplicationConnectors().get(0).asInstanceOf[HttpConnectorFactory]
  connectorFactory.setPort(RemoteActorService.port)
  connectorFactory.setBindHost(NetworkUtils.getLocalIpAddress)
  serverFactory.getAdminConnectors().get(0).asInstanceOf[HttpConnectorFactory].setPort(RemoteActorService.adminPort)
}