package hu.bme.mit.incqueryd.monitoringserver.core.model;

import java.util.ArrayList;
import java.util.List;

public class AggregatedMonitoringData {

	private List<OSMonitoringData> os;
	
	private List<AkkaNodeMonitoringData> akka;
	
	public AggregatedMonitoringData(){
		os = new ArrayList<OSMonitoringData>();
		akka = new ArrayList<AkkaNodeMonitoringData>();
	}
	
	public List<OSMonitoringData> getOs() {
		return os;
	}
	
	public void addOS(OSMonitoringData osData){
		os.add(osData);
	}
	
	public List<AkkaNodeMonitoringData> getAkka() {
		return akka;
	}
	
	public void setAkka(List<AkkaNodeMonitoringData> akka) {
		this.akka.addAll(akka);
	}
}
