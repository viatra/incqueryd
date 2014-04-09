package hu.bme.mit.incqueryd.osmonitoragent;

import java.util.List;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

public class IncQueryDOS implements IncQueryDOSMBean {

	private static Sigar sigar = new Sigar();

	private OSMonitor monitor;

	int toGig;

	public IncQueryDOS(OSMonitor mon) throws SigarException {
		
		monitor = mon;

		toGig = 1024 * 1024 * 1024;
	}

	public double getTotalMemory() {
		try {
			return (double) sigar.getMem().getTotal() / toGig;
		} catch (SigarException e) {
			return 0;
		}
	}

	public double getUsedMemory() {
		try {
			return (double) sigar.getMem().getUsed() / toGig;
		} catch (SigarException e) {
			return 0;
		}
	}

	public double getFreeMemory() {
		try {
			return (double) sigar.getMem().getFree() / toGig;
		} catch (SigarException e) {
			return 0;
		}
	}

	public double getUsedMemoryPercent() {
		try {
			return sigar.getMem().getUsedPercent();
		} catch (SigarException e) {
			return 0;
		}
	}

	public double getFreeMemoryPercent() {
		try {
			return sigar.getMem().getFreePercent();
		} catch (SigarException e) {
			return 0;
		}
	}

	public double getUsedCPUPercent() {
		try {
			return (sigar.getCpuPerc().getCombined()) * 100;
		} catch (SigarException e) {
			return 0;
		}
	}

	public List<DiskUsage> getDisks() {

		return monitor.getDisks();

	}
	
	public List<NetworkUsage> getNetInterfaces(){
		return monitor.getNetUsages();
	}

}
