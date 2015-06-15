package hu.bme.mit.incqueryd.actorservice.server

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import java.net.URL
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory
import org.eclipse.jetty.server.AbstractNetworkConnector
import hu.bme.mit.incqueryd.yarn.IncQueryDZooKeeper

object ActorServiceApplication {

  def main(args: Array[String]) {
    val zkApplicationPath = args(0)
    val application = new ActorServiceApplication()
    application.run(args.drop(1))
    Thread.sleep(1000)
    IncQueryDZooKeeper.setData(IncQueryDZooKeeper.yarnNodesPath + zkApplicationPath, application.getHostAndPort().getBytes)
  }

}

class ActorServiceApplication extends Application[ActorServiceConfiguration] {
  
  override def initialize(bootstrap: Bootstrap[ActorServiceConfiguration]) {}
  
  var environment : Environment = null
  
  override def run(configuration: ActorServiceConfiguration, environment: Environment) {
    List(new StartResource).foreach(environment.jersey.register(_))
    URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory)
    this.environment = environment
  }
  
  def getHostAndPort() : String = {
    val connector = environment.getApplicationContext.getServer.getConnectors.reverse.last.asInstanceOf[AbstractNetworkConnector]
    connector.getHost + ":" + connector.getLocalPort
  }

}