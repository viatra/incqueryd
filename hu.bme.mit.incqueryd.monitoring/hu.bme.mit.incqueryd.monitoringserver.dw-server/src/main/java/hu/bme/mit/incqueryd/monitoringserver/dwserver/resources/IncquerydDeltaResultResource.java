package hu.bme.mit.incqueryd.monitoringserver.dwserver.resources;

import hu.bme.mit.incqueryd.monitoringserver.core.QueryResultStore;
import hu.bme.mit.incqueryd.monitoringserver.core.data.MonitoringChangeSet;
import hu.bme.mit.incqueryd.monitoringserver.core.data.StringTuple;
import hu.bme.mit.incqueryd.monitoringserver.core.model.QueryDeltaData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/deltas")
@Produces(MediaType.APPLICATION_JSON)
public class IncquerydDeltaResultResource {
	
	@GET
	public List<QueryDeltaData> getDeltas(@QueryParam("from") int from) {
		List<MonitoringChangeSet> changeDeltas = QueryResultStore.getDeltas(from);
		
		List<QueryDeltaData> changes = new ArrayList<QueryDeltaData>();
		
		if(changeDeltas == null) return changes;
		
		for (MonitoringChangeSet monitoringChangeSet : changeDeltas) {
			Set<StringTuple> posChanges = monitoringChangeSet.posChanges();
			if(posChanges.size() > 0) {
				for (StringTuple stringTuple : posChanges) {
					changes.add(new QueryDeltaData('+', stringTuple));
				}
			}
			
			Set<StringTuple> negChanges = monitoringChangeSet.negChanges();
			if(negChanges.size() > 0) {
				for (StringTuple stringTuple : negChanges) {
					changes.add(new QueryDeltaData('-', stringTuple));
				}
			}
		}
		
		return changes;
	}
	
}
