package main

import akka.actor.ActorSystem
import akka.actor.Props
import hu.bme.mit.incqueryd.monitoringserver.core.MonitoringDataCollectorActor
import hu.bme.mit.incqueryd.retemonitoring.metrics.AlphaNodeMetrics
import hu.bme.mit.incqueryd.monitoringserver.core.ReteMetricsCollector
import scala.collection.JavaConversions._
import akka.actor.ScalaActorRef
import hu.bme.mit.incqueryd.retemonitoring.metrics.BetaNodeMetrics
import com.typesafe.config.ConfigFactory

import scala.concurrent.ops._

object ScalaMain {

  def main(args: Array[String]): Unit = {

//        val system = ActorSystem("demo")
//        val collector = system.actorOf(Props[MonitoringDataCollectorActor], name = "swapper")
//        
//        collector ! new BetaNodeMetrics("Node1", "jozsilx", 500, 12,13)
//        //Thread.sleep(200)
//        collector ! new AlphaNodeMetrics("Node2", "jozsilx2", 500)
//        
//        
//        Thread.sleep(1000)
//        
//        ReteMetricsCollector.getAlphaMetrics.foreach(metrics => {
//          println(metrics.getHostName() + " " + metrics.getReteNode() + " " + metrics.getUpdateMessagesSent())
//        })
//        
//        system.shutdown

    println("Hello")
    
    
  }

}