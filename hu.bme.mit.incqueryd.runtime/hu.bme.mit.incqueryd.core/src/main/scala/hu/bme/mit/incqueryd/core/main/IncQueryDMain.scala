package hu.bme.mit.incqueryd.core.main

import hu.bme.mit.incqueryd.core.rete.dataunits.Tuple

import java.util.HashSet

import akka.actor.ActorSystem
import akka.actor.Props
import hu.bme.mit.incqueryd.core.rete.actors.HttpCoordinatorActorFactory
import akka.util.Timeout
import scala.concurrent.duration._
import akka.io.IO
import spray.can.Http
import akka.pattern.ask

import org.apache.commons.cli.Options
import org.apache.commons.cli.PosixParser
import org.apache.commons.cli.Option

import hu.bme.mit.incqueryd.core.rete.messages.CoordinatorCommand
import scala.concurrent.Await

object IncQueryDMain {

  def main(args: Array[String]) {
    val options = new Options;
    val parser = new PosixParser;

    val architectureFileOption = new Option("architectureFile", true, "The path to the architecture file.");
    architectureFileOption.setRequired(true)
    options.addOption(architectureFileOption)

    options.addOption(new Option("interface", true, "The address to the HTTP interface, the default value is 127.0.0.1."))
    options.addOption(new Option("debug", false, "Run IQD in debug mode (using a single JVM)."))
    options.addOption(new Option("start", false, "Starts query processing immediately."))

    val cmd = parser.parse(options, args);

    val architectureFile = cmd.getOptionValue("architectureFile")
    val interface = if (cmd.hasOption("interface")) cmd.getOptionValue("interface") else "127.0.0.1"
    val debug = cmd.hasOption("debug")
    val start = cmd.hasOption("start")

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