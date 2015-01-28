package hu.bme.mit.incqueryd.actorservice.server

import com.codahale.metrics.annotation.Timed
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response
import javax.ws.rs.core.MediaType
import hu.bme.mit.incqueryd.actorservice.RemoteActorService

@Path(RemoteActorService.Stop.path)
@Produces(Array(MediaType.APPLICATION_JSON))
class StopResource {

  @GET
  @Timed
  def execute: Response = {
    Response.ok.build 
  }

}
