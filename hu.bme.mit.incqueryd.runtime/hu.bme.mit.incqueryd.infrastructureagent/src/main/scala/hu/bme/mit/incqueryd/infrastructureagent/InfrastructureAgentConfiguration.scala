package hu.bme.mit.incqueryd.infrastructureagent

import io.dropwizard.Configuration
import io.dropwizard.server.DefaultServerFactory
import io.dropwizard.jetty.HttpConnectorFactory
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import eu.mondo.utils.NetworkUtils

class InfrastructureAgentConfiguration extends Configuration {
  val serverFactory = getServerFactory().asInstanceOf[DefaultServerFactory]
  val connectorFactory = serverFactory.getApplicationConnectors().get(0).asInstanceOf[HttpConnectorFactory]
  connectorFactory.setPort(InfrastructureAgent.port)
  connectorFactory.setBindHost(NetworkUtils.getLocalIpAddress)
  serverFactory.getAdminConnectors().get(0).asInstanceOf[HttpConnectorFactory].setPort(InfrastructureAgent.adminPort)
}