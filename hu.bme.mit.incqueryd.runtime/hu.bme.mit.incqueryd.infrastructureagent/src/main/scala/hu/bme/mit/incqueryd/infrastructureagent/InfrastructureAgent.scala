package hu.bme.mit.incqueryd.infrastructureagent

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

object InfrastructureAgent {

  def main(args: Array[String]) {
    new InfrastructureAgent().run(args)
  }

}

class InfrastructureAgent extends Application[Configuration] {

  override def initialize(bootstrap: Bootstrap[Configuration]) {
  }

  override def run(configuration: Configuration, environment: Environment) {
    List(new PrepareInfrastructureResource,
      new DestroyInfrastructureResource,
      new StartMicrokernelsResource,
      new StopMicrokernelsResource).foreach(environment.jersey.register(_))
  }

}
