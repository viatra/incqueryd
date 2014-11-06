package hu.bme.mit.incqueryd.monitoringserver.dwserver.resources;

import hu.bme.mit.incqueryd.monitoringserver.core.QueryResultStore;
import hu.bme.mit.incqueryd.monitoringserver.core.data.StringTuple;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/results")
@Produces(MediaType.APPLICATION_JSON)
public class IncquerydQueryResultResource {

	@GET
	public Set<StringTuple> getResults(){
		return QueryResultStore.getResults();
	}
	
}
