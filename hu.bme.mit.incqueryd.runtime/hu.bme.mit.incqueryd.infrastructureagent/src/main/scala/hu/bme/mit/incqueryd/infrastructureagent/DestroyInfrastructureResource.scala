package hu.bme.mit.incqueryd.infrastructureagent

import com.codahale.metrics.annotation.Timed
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType
import hu.bme.mit.incqueryd.infrastructureagent.client.InfrastructureAgent
import eu.mondo.utils.UnixUtils
import scala.collection.JavaConversions._

@Path(InfrastructureAgent.DestroyInfrastructure.path)
@Produces(Array(MediaType.APPLICATION_JSON))
class DestroyInfrastructureResource {

  @GET
  @Timed
  def execute: Response = {
    UnixUtils.exec("./stop-actor-system.sh", Map[String, String](), System.out)
    Response.ok.build 
  }

}
