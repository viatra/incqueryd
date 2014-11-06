package hu.bme.mit.incqueryd.monitoringserver.dwserver.resources;

import hu.bme.mit.incqueryd.monitoringserver.core.model.AggregatedMonitoringData;
import hu.bme.mit.incqueryd.monitoringserver.core.processing.MonitoringWorker;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/monitoring")
@Produces(MediaType.APPLICATION_JSON)
public class IncquerydMonitoringResource {

	private MonitoringWorker worker;

	public IncquerydMonitoringResource(MonitoringWorker worker) {
		this.worker = worker;
	}
	
	@GET
    public AggregatedMonitoringData getMonitoringData() {
		return worker.getMonitoredData();
	}
	
}
