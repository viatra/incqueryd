package hu.bme.mit.incqueryd.infrastructureagent

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

object InfrastructureAgentApplication {

  def main(args: Array[String]) {
    new InfrastructureAgentApplication().run(args)
  }

}

class InfrastructureAgentApplication extends Application[InfrastructureAgentConfiguration] {

  override def initialize(bootstrap: Bootstrap[InfrastructureAgentConfiguration]) {
  }

  override def run(configuration: InfrastructureAgentConfiguration, environment: Environment) {
    List(new PrepareInfrastructureResource,
      new DestroyInfrastructureResource).foreach(environment.jersey.register(_))
  }

}
