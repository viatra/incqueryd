package hu.bme.mit.incqueryd.monitoringserver.dwserver.resources;

import hu.bme.mit.incqueryd.monitoringserver.core.QueryResultStore;
import hu.bme.mit.incqueryd.monitoringserver.core.data.MonitoringChangeSet;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/deltas")
@Produces(MediaType.APPLICATION_JSON)
public class IncquerydDeltaResultResource {
	
	@GET
	public List<MonitoringChangeSet> getDeltas(@QueryParam("from") int from) {
		List<MonitoringChangeSet> deltas = QueryResultStore.getDeltas(from);
		return deltas;
	}
	
}
