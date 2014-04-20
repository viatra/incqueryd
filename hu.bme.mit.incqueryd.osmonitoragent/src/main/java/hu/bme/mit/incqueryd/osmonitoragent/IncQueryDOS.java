package hu.bme.mit.incqueryd.osmonitoragent;

import hu.bme.mit.incqueryd.osmonitoringagent.metrics.CPUUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.DiskUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.MemoryUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.NetworkUsage;

import java.util.List;


public class IncQueryDOS implements IncQueryDOSMBean {

	private OSMonitor monitor;


	public IncQueryDOS(OSMonitor mon) {
		
		monitor = mon;

	}

	public MemoryUsage getMemory() {

		return monitor.getMemoryUsage();
		
	}

	public CPUUsage getCpu() {

		return monitor.getCPUUsage();
		
	}
	public List<DiskUsage> getDisks() {

		return monitor.getDisks();

	}
	
	public List<NetworkUsage> getNetInterfaces(){
		return monitor.getNetUsages();
	}

}
