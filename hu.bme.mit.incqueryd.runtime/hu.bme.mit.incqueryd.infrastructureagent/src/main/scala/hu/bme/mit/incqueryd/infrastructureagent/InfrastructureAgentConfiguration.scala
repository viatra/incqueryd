package hu.bme.mit.incqueryd.infrastructureagent

import eu.mondo.utils.NetworkUtils
import hu.bme.mit.incqueryd.infrastructureagent.client.DefaultInfrastructureAgent
import io.dropwizard.Configuration
import io.dropwizard.jetty.HttpConnectorFactory
import io.dropwizard.server.DefaultServerFactory

class InfrastructureAgentConfiguration extends Configuration {
  val serverFactory = getServerFactory().asInstanceOf[DefaultServerFactory]
  val connectorFactory = serverFactory.getApplicationConnectors().get(0).asInstanceOf[HttpConnectorFactory]
  connectorFactory.setPort(DefaultInfrastructureAgent.port)
  connectorFactory.setBindHost(NetworkUtils.getLocalIpAddress)
  serverFactory.getAdminConnectors().get(0).asInstanceOf[HttpConnectorFactory].setPort(DefaultInfrastructureAgent.adminPort)
}