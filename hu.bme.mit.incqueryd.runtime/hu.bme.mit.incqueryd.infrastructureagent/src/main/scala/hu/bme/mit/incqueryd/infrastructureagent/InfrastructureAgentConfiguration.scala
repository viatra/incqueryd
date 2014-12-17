package hu.bme.mit.incqueryd.infrastructureagent

import io.dropwizard.Configuration
import io.dropwizard.server.DefaultServerFactory
import io.dropwizard.jetty.HttpConnectorFactory
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent

class InfrastructureAgentConfiguration extends Configuration {
  getServerFactory().asInstanceOf[DefaultServerFactory].getApplicationConnectors().get(0).asInstanceOf[HttpConnectorFactory].setPort(InfrastructureAgent.port)
}