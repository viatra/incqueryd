package hu.bme.mit.incqueryd.actorservice.server

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

object ActorServiceApplication {

  def main(args: Array[String]) {
    new ActorServiceApplication().run(args)
  }

}

class ActorServiceApplication extends Application[ActorServiceConfiguration] {

  override def initialize(bootstrap: Bootstrap[ActorServiceConfiguration]) {
  }

  override def run(configuration: ActorServiceConfiguration, environment: Environment) {
    List(new StartResource,
      new StopResource).foreach(environment.jersey.register(_))
  }

}
