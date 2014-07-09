package hu.bme.mit.incqueryd.jvmmonitoring.metrics;

import java.io.Serializable;

public class JVMMetrics implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double maxHeap;
	
	private double usedHeap;
	
	private double usedHeapPercent;
	
	private double maxNonHeap;
	
	private double usedNonHeap;
	
	private double usedNonHeapPercent;
	
	private long gcCollectionCount;
	
	private long gcCollectionTime;
	
	private String name;
	
	private double cpuUtilization;

	
	public double getCpuUtilization() {
		return cpuUtilization;
	}
	
	public void setCpuUtilization(double cpuUtilization) {
		this.cpuUtilization = cpuUtilization;
	}
	
	public long getGcCollectionCount() {
		return gcCollectionCount;
	}
	
	public void setGcCollectionCount(long gcCollectionCount) {
		this.gcCollectionCount = gcCollectionCount;
	}
	
	public long getGcCollectionTime() {
		return gcCollectionTime;
	}
	
	public void setGcCollectionTime(long gcCollectionTime) {
		this.gcCollectionTime = gcCollectionTime;
	}
	
	public double getMaxHeap() {
		return maxHeap;
	}
	
	public void setMaxHeap(double maxHeap) {
		this.maxHeap = maxHeap;
	}
	
	public double getMaxNonHeap() {
		return maxNonHeap;
	}
	
	public void setMaxNonHeap(double maxNonHeap) {
		this.maxNonHeap = maxNonHeap;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getUsedHeap() {
		return usedHeap;
	}
	
	public void setUsedHeap(double usedHeap) {
		this.usedHeap = usedHeap;
	}
	
	public double getUsedHeapPercent() {
		return usedHeapPercent;
	}
	
	public void setUsedHeapPercent(double usedHeapPercent) {
		this.usedHeapPercent = usedHeapPercent;
	}
	
	public double getUsedNonHeap() {
		return usedNonHeap;
	}
	
	public void setUsedNonHeap(double usedNonHeap) {
		this.usedNonHeap = usedNonHeap;
	}
	
	public double getUsedNonHeapPercent() {
		return usedNonHeapPercent;
	}
	
	public void setUsedNonHeapPercent(double usedNonHeapPercent) {
		this.usedNonHeapPercent = usedNonHeapPercent;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + " , MaxHeap: " + maxHeap + " , UsedHeap: " + usedHeap + " , MaxNonHeap: " + maxNonHeap + " , UsedNonHeap: " + usedNonHeap + " , CPU: " + cpuUtilization;
	}
}
