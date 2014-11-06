package hu.bme.mit.incqueryd.osmonitoringagent.metrics;

import java.io.Serializable;
import java.util.List;

public class OSMonitoringData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MemoryUsage memory;
	private CPUUsage cpu;
	private List<DiskUsage> disks;
	private List<NetworkUsage> netInterfaces;
	

	public OSMonitoringData(MemoryUsage memory, CPUUsage cpu,
			List<DiskUsage> disks, List<NetworkUsage> netInterfaces) {
		super();
		this.memory = memory;
		this.cpu = cpu;
		this.disks = disks;
		this.netInterfaces = netInterfaces;
	}


	public MemoryUsage getMemoryUsage() {
		return memory;
	}
	
	public CPUUsage getCpuUsage() {
		return cpu;
	}
	
	public List<DiskUsage> getDiskUsages() {
		return disks;
	}
	
	public List<NetworkUsage> getNetUsages() {
		return netInterfaces;
	}
	
}
