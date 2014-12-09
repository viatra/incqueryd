package hu.bme.mit.incqueryd.infrastructureagent

import com.codahale.metrics.annotation.Timed
import com.google.common.collect.ImmutableSet
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.core.Response
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import hu.bme.mit.incqueryd.arch.Configuration
import hu.bme.mit.incqueryd.arch.ArchFactory
import scala.collection.JavaConversions._
import hu.bme.mit.incqueryd.infrastructure.Process

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
    ArchFactory.eINSTANCE.createConfiguration // TODO
  }

  private def getLocalProcesses(configuration: Configuration): Iterable[Process] = {
    configuration.getMappings.map(_.getProcess).filter(process => NetworkUtils.thisMachineIs(process.getMachine))
  }

  private def generateConfigs(processes: Iterable[Process]) {
    // TODO
  }

  private def startMicrokernel(process: Process) {
    // TODO
  }

}
