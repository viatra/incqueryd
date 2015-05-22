package hu.bme.mit.incqueryd.actorservice.server

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import java.net.URL
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory

object ActorServiceApplication {

  def main(args: Array[String]) {
    new ActorServiceApplication().run(args)
  }

}

class ActorServiceApplication extends Application[ActorServiceConfiguration] {

  override def initialize(bootstrap: Bootstrap[ActorServiceConfiguration]) {
  }

  override def run(configuration: ActorServiceConfiguration, environment: Environment) {
    List(new StartResource).foreach(environment.jersey.register(_))
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)
  }

}
