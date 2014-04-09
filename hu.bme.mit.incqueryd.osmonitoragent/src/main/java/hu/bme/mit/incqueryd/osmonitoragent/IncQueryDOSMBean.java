package hu.bme.mit.incqueryd.osmonitoragent;

import java.util.List;

public interface IncQueryDOSMBean {
	
	public double getTotalMemory();
	public double getUsedMemory();
	public double getFreeMemory();
	public double getUsedMemoryPercent();
	public double getFreeMemoryPercent();
	
	public double getUsedCPUPercent();
	
	public List<DiskUsage> getDisks();
	public List<NetworkUsage> getNetInterfaces();
	
}
