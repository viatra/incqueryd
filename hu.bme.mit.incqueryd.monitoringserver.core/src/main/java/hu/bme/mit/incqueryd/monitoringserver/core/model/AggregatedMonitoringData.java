package hu.bme.mit.incqueryd.monitoringserver.core.model;

import java.util.ArrayList;
import java.util.List;

public class AggregatedMonitoringData {

	private List<OSMonitoringData> os;
	
	public AggregatedMonitoringData(){
		os = new ArrayList<>();
	}
	
	public List<OSMonitoringData> getOs() {
		return os;
	}
	
	public void addOS(OSMonitoringData osData){
		os.add(osData);
	}
	
}
