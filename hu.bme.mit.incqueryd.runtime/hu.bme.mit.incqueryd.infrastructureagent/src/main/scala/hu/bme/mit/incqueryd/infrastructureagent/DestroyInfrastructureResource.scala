package hu.bme.mit.incqueryd.infrastructureagent

import com.codahale.metrics.annotation.Timed
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType

@Path("/destroy")
@Produces(Array(MediaType.APPLICATION_JSON))
class DestroyInfrastructureResource {

  @GET
  @Timed
  def execute: Response = {
    // TODO
    Response.ok.build 
  }

}
