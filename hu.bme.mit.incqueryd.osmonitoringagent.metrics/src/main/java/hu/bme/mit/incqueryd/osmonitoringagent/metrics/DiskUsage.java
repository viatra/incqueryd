package hu.bme.mit.incqueryd.osmonitoringagent.metrics;

public class DiskUsage {

	private String name;
	private double diskQueue;
	private long diskReads;
	private double diskReadBytes;
	private long diskWrites;
	private double diskWriteBytes;
	
	public DiskUsage(String name) {
		this.name = name;
		diskQueue = 0;
		diskReads = 0;
		diskReadBytes = 0;
		diskWrites = 0;
		diskWriteBytes = 0;
	}

	public double getDiskQueue() {
		return diskQueue;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDiskQueue(double diskQueue) {
		this.diskQueue = diskQueue;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getDiskReadBytes() {
		return diskReadBytes;
	}
	
	public long getDiskReads() {
		return diskReads;
	}
	
	public void setDiskReadBytes(double diskReadBytes) {
		this.diskReadBytes = diskReadBytes;
	}
	
	public void setDiskReads(long diskReads) {
		this.diskReads = diskReads;
	}
	
	public long getDiskWrites() {
		return diskWrites;
	}
	
	public double getDiskWriteBytes() {
		return diskWriteBytes;
	}
	
	public void setDiskWrites(long diskWrites) {
		this.diskWrites = diskWrites;
	}
	
	public void setDiskWriteBytes(double diskWriteBytes) {
		this.diskWriteBytes = diskWriteBytes;
	}
	
}
