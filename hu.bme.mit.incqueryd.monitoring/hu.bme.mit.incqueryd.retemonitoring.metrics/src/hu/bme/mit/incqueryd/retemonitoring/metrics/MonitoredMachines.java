package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MonitoredMachines implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Set<String> machineIPs;

	public MonitoredMachines() {
		machineIPs = new HashSet<>();
	}
	
	public Collection<String> getMachineIPs() {
		return machineIPs;
	}
	
	public void addMachineIP(String ip) {
		machineIPs.add(ip);
	}
}
