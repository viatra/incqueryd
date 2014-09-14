package hu.bme.mit.incqueryd.main

import hu.bme.mit.incqueryd.rete.dataunits.ScalaChangeSet
import hu.bme.mit.incqueryd.rete.dataunits.Tuple
import java.util.HashSet
import akka.actor.ActorSystem
import akka.actor.Props
import hu.bme.mit.incqueryd.rete.actors.HttpCoordinatorActorFactory
import akka.util.Timeout
import scala.concurrent.duration._
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import org.apache.commons.cli.Options
import org.apache.commons.cli.PosixParser
import org.apache.commons.cli.Option
import hu.bme.mit.incqueryd.rete.messages.CoordinatorCommand

object IncQueryDMain {

  def main(args: Array[String]) {
    val options = new Options;
    val parser = new PosixParser;

    val architectureFileOption = new Option("architectureFile", true, "The path to the architecture file.");
    architectureFileOption.setRequired(true)
    options.addOption(architectureFileOption)

    options.addOption(new Option("httpAddress", true, "The address to the HTTP interface, the default value is 127.0.0.1."))
    options.addOption(new Option("local", false, "Run IQD in local mode."))
    options.addOption(new Option("start", false, "Starts query processing immediately."))

    val cmd = parser.parse(options, args);

    val architectureFile = cmd.getOptionValue("architectureFile")
    val interface = if (cmd.hasOption("interface")) cmd.getOptionValue("interface") else "127.0.0.1"
    val remoting = !cmd.hasOption("local")
    val start = cmd.hasOption("start")

    val engine = new IncQueryDEngine(interface)
    val coordinator = engine initialize (architectureFile, remoting)

    implicit val httpActorSystem = ActorSystem("http")
    val coordinatorService = httpActorSystem.actorOf(Props(new HttpCoordinatorActorFactory(coordinator)), "coordinator-service")
    implicit val timeout = Timeout(1000000 seconds)

    if (start) {
      Thread.sleep(1000)
      coordinator ! CoordinatorCommand.START
    } else {
      IO(Http) ? Http.Bind(coordinatorService, interface = interface, port = 9090)
    }
    
    Thread.sleep(20000);
    engine.shutdown
    httpActorSystem.shutdown
  }
}