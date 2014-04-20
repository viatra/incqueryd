package hu.bme.mit.incqueryd.osmonitoragent;

import hu.bme.mit.incqueryd.osmonitoringagent.metrics.CPUUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.DiskUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.MemoryUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.NetworkUsage;

import java.util.List;

public interface IncQueryDOSMBean {
	
	public MemoryUsage getMemory();
	public CPUUsage getCpu();
	
	public List<DiskUsage> getDisks();
	public List<NetworkUsage> getNetInterfaces();
	
}
