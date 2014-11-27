package hu.bme.mit.incqueryd.agent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.codahale.metrics.annotation.Timed;

@Path("/deploy")
public class DeployResource {

	@GET
	@Timed
	public String execute() {
		return "Hello!";
	}

}
