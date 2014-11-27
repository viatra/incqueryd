package hu.bme.mit.incqueryd.engine.main

import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple

import java.util.HashSet

import akka.actor.ActorSystem
import akka.actor.Props
import hu.bme.mit.incqueryd.engine.rete.actors.HttpCoordinatorActorFactory
import akka.util.Timeout
import scala.concurrent.duration._
import akka.io.IO
import spray.can.Http
import akka.pattern.ask

import org.apache.commons.cli.Options
import org.apache.commons.cli.PosixParser
import org.apache.commons.cli.Option

import hu.bme.mit.incqueryd.engine.rete.messages.CoordinatorCommand
import hu.bme.mit.incqueryd.engine.main.IncQueryDEngine;
import scala.concurrent.Await

object IncQueryDMain {

  def main(args: Array[String]) {
    val options = new Options;
    val parser = new PosixParser;
    
    val ARG_ARCHITECTUREFILE = "architectureFile"
    val ARG_INTERFACE = "interface"
    val ARG_DEBUG = "debug"
    val ARG_START = "start"

    val architectureFileOption = new Option(ARG_ARCHITECTUREFILE, true, "The path to the architecture file.");
    architectureFileOption.setRequired(true)
    options.addOption(architectureFileOption)
    
    options.addOption(new Option(ARG_INTERFACE, true, "The address to the HTTP interface, the default value is 127.0.0.1."))
    options.addOption(new Option(ARG_DEBUG, false, "Run IQD in debug mode (using a single JVM)."))
    options.addOption(new Option(ARG_START, false, "Starts query processing immediately."))

    val cmd = parser.parse(options, args);

    val architectureFile = cmd.getOptionValue(ARG_ARCHITECTUREFILE)
    val interface = if (cmd.hasOption(ARG_INTERFACE)) cmd.getOptionValue(ARG_INTERFACE) else "127.0.0.1"
    val debug = cmd.hasOption(ARG_DEBUG)
    val start = cmd.hasOption(ARG_START)

    val engine = new IncQueryDEngine(interface)
    val coordinator = engine initialize (architectureFile, debug)

    implicit val httpActorSystem = ActorSystem("http")
    val coordinatorService = httpActorSystem.actorOf(Props(new HttpCoordinatorActorFactory(coordinator)), "coordinator-service")
    implicit val timeout = Timeout(1000000 seconds)

    if (start) {
      val startFuture = coordinator ? CoordinatorCommand.START
      Await.ready(startFuture, timeout.duration)
    } else {
      IO(Http) ? Http.Bind(coordinatorService, interface = interface, port = 9090)
    }
    
    val resultFuture = coordinator ? CoordinatorCommand.CHECK
    val result = Await.result(resultFuture, timeout.duration)
    println("[IncQueryDMain   ] " + result)
    
    engine.shutdown
    httpActorSystem.shutdown
  }
}