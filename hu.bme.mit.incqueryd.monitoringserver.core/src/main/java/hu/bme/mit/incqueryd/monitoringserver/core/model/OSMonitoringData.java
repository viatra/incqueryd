package hu.bme.mit.incqueryd.monitoringserver.core.model;

import hu.bme.mit.incqueryd.osmonitoringagent.metrics.CPUUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.DiskUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.MemoryUsage;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.NetworkUsage;

import java.util.ArrayList;
import java.util.List;

public class OSMonitoringData {

	private MemoryUsage Memory;
	private CPUUsage Cpu;
	private List<DiskUsage> Disks;
	private List<NetworkUsage> NetInterfaces;
	private String Host;
	
	
	
	public OSMonitoringData() {
		super();
		this.Memory = new MemoryUsage();
		this.Cpu = new CPUUsage();
		this.Disks = new ArrayList<>();
		this.NetInterfaces = new ArrayList<>();
	}

	public MemoryUsage getMemoryUsage() {
		return Memory;
	}
	
	public CPUUsage getCpuUsage() {
		return Cpu;
	}
	
	public List<DiskUsage> getDiskUsages() {
		return Disks;
	}
	
	public List<NetworkUsage> getNetUsages() {
		return NetInterfaces;
	}
	
	public String getHostName() {
		return Host;
	}
	
	public void setHostName(String hostName) {
		this.Host = hostName;
	}
}
