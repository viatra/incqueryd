package hu.bme.mit.incqueryd.agent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.codahale.metrics.annotation.Timed;

@Path("/destroy")
public class DestroyInfrastructureResource {

	@GET
	@Timed
	public String execute() {
		return "Hello!";
	}

}
