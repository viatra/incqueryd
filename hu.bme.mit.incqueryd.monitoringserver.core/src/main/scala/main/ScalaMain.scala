package main

import akka.actor.ActorSystem
import akka.actor.Props
import hu.bme.mit.incqueryd.monitoringserver.core.MonitoringDataCollectorActor
import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import hu.bme.mit.incqueryd.monitoringserver.core.ReteActorHandler
import scala.collection.JavaConversions._
import akka.actor.ScalaActorRef
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import com.typesafe.config.ConfigFactory
import scala.concurrent.ops._
import akka.actor.Actor

object ScalaMain {

  def main(args: Array[String]): Unit = {

    val customConf = ConfigFactory.parseString("""
    akka {
    actor {
    provider = "akka.remote.RemoteActorRefProvider"
    }
    remote {
    transport = "akka.remote.netty.NettyRemoteTransport"
    netty {
    hostname = "192.168.1.103"
    port = 2552
    }
    }
    }
""")

    val system = ActorSystem.create("monitoringserver", ConfigFactory.load(customConf))
    val collector = system.actorOf(Props[MonitoringDataCollectorActor], name = "collector")

    

    //system.shutdown


  }

}