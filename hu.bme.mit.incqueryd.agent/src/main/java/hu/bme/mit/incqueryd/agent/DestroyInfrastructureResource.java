package hu.bme.mit.incqueryd.agent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;

@Path("/destroy")
public class DestroyInfrastructureResource {

	@GET
	@Timed
	public Response execute() {
		// TODO kill processes
		return Response.ok().build();
	}

}
