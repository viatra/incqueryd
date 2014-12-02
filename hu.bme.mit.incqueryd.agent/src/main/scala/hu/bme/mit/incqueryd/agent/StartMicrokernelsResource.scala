package hu.bme.mit.incqueryd.agent

import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.mapAsJavaMap
import org.mondo.eu.utils.UnixUtils
import com.codahale.metrics.annotation.Timed
import com.google.common.collect.ImmutableSet
import Paths.AKKA_SCRIPTS
import arch.ArchPackage
import arch.Configuration
import hu.bme.mit.incqueryd.engine.util.EObjectDeserializer
import infrastructure.Process
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/start")
@Produces(Array(MediaType.APPLICATION_JSON))
class StartMicrokernelsResource {

  @GET
  @Timed
  def execute(@QueryParam("architecture") architectureJson: String): Response = {
    val configuration = parseArchitecture(architectureJson)
    val processes = getLocalProcesses(configuration)
    generateConfigs(processes)
    processes.foreach(startMicrokernel(_))
    Response.ok.build
  }

  private def parseArchitecture(architectureJson: String): Configuration = {
    EObjectDeserializer.deserializeFromString(architectureJson, ImmutableSet.of(ArchPackage.eINSTANCE)).asInstanceOf[Configuration]
  }

  private def getLocalProcesses(configuration: Configuration): Iterable[Process] = {
    configuration.getMappings.map(_.getProcess).filter(process => NetworkUtils.thisMachineIs(process.getMachine))
  }

  private def generateConfigs(processes: Iterable[Process]) = {
    UnixUtils.exec(AKKA_SCRIPTS + "generate-configs.sh " + processes.map(_.getPort).mkString(" "), Map[String, String]())
  }

  private def startMicrokernel(process: Process) {
    UnixUtils.exec(AKKA_SCRIPTS + "start-akka.sh " + process.getPort + " " + process.getMemory, Map[String, String]())
  }

}
