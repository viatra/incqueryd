package main

import akka.actor.ActorSystem
import akka.actor.Props
import hu.bme.mit.incqueryd.monitoringserver.core.MonitoringDataCollectorActor
import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import scala.collection.JavaConversions._
import akka.actor.ScalaActorRef
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import com.typesafe.config.ConfigFactory
import scala.concurrent.ops._
import akka.actor.Actor
import akka.util.Timeout
import scala.concurrent.duration.Duration
import akka.pattern.Patterns.ask
import hu.bme.mit.incqueryd.retemonitoring.metrics.MonitoringMessage
import scala.concurrent.Future
import hu.bme.mit.incqueryd.retemonitoring.metrics.ReteNodeMetrics
import scala.concurrent.Await

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

    //val system = ActorSystem.create("monitoringserver", ConfigFactory.load(customConf))
    //val collector = system.actorOf(Props[MonitoringDataCollectorActor], name = "collector")

//    Thread.sleep(10000)
//    
//    val timeout: Timeout = new Timeout(Duration.create(14400, "seconds"))
//
//    ReteActorHandler.getActors.foreach(actorRef => {
//      val future = ask(actorRef, MonitoringMessage.MONITOR, timeout)
//      val result = Await.result(future, timeout.duration)
//      println(result)
//    })
    
val system = ActorSystem.create("monitoringserver")
    val dummy = system.actorOf(Props[DummyActor], name = "dummy")
    
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    dummy ! "work"
    
    Thread.sleep(100)
    dummy ! "monitor"
    

    system.shutdown


  }

}