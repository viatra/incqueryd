package hu.bme.mit.incqueryd.agent

import com.codahale.metrics.annotation.Timed

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.Response

@Path("/destroy")
class DestroyInfrastructureResource {

  @GET
  @Timed
  def execute: Response = {
    // TODO
    Response.ok.build 
  }

}
