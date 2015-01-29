package hu.bme.mit.incqueryd.actorservice.server

import com.codahale.metrics.annotation.Timed
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.Response
import hu.bme.mit.incqueryd.actorservice.RemoteActorService
import hu.bme.mit.incqueryd.actorservice.RemoteActorService._
import javax.ws.rs.core.MediaType
import hu.bme.mit.incqueryd.actorservice.LocalActorService
import javax.ws.rs.QueryParam
import upickle._
import hu.bme.mit.incqueryd.actorservice.ActorId
import akka.actor.Actor

@Path(RemoteActorService.Start.path)
@Produces(Array(MediaType.APPLICATION_JSON))
class StartResource {

  @GET
  @Timed
  def execute(@QueryParam(idJsonParameter) idJson: String, @QueryParam(classNameParameter) className: String): Response = {
    val id = read[ActorId](idJson)
    LocalActorService.start(id, Class.forName(className).asSubclass(classOf[Actor]))
    Response.ok.build
  }

}
