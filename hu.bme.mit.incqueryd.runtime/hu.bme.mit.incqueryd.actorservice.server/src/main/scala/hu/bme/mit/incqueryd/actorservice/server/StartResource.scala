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

@Path(RemoteActorService.Start.start)
@Produces(Array(MediaType.APPLICATION_JSON))
class StartResource {

  @GET
  @Timed
  @Path(RemoteActorService.Start.actor)
  @Produces(Array(MediaType.APPLICATION_JSON))
  def startActor(@QueryParam(idJsonParameter) idJson: String, @QueryParam(classNameParameter) className: String): Response = {
    val id = read[ActorId](idJson)
    LocalActorService.startActor(id, Class.forName(className).asSubclass(classOf[Actor]))
    Response.ok.build
  }
  
  @GET
  @Timed
  @Path(RemoteActorService.Start.system)
  @Produces(Array(MediaType.APPLICATION_JSON))
  def startActorSystem(@QueryParam(idJsonParameter) idJson: String, @QueryParam(classNameParameter) className: String): Response = {
    val id = read[ActorId](idJson)
    LocalActorService.startActorSystem(id, Class.forName(className).asSubclass(classOf[Actor]))
    Response.ok.build
  }
  
}
