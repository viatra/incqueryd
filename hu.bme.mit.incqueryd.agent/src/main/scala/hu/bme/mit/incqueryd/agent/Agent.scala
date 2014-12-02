package hu.bme.mit.incqueryd.agent

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

object Agent {

  def main(args: Array[String]) {
    new Agent().run(args)
  }

}

class Agent extends Application[Configuration] {

  override def initialize(bootstrap: Bootstrap[Configuration]) {
  }

  override def run(configuration: Configuration, environment: Environment) {
    List(new PrepareInfrastructureResource,
      new DestroyInfrastructureResource,
      new StartMicrokernelsResource).foreach(environment.jersey.register(_))
  }

}
