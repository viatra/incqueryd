package hu.bme.mit.incqueryd.jvmmonitoring.metrics;

public class JVMMetrics {
	
	private double maxHeap;
	
	private double usedHeap;
	
	private double usedHeapPercent;
	
	private double maxNonHeap;
	
	private double usedNonHeap;
	
	private double usedNonHeapPercent;
	
	private double gcCollectionCount;
	
	private double gcCollectionTime;
	
	private String name;
	
	private double upTime;
	
	private double cpuUtilization;

	
	public double getCpuUtilization() {
		return cpuUtilization;
	}
	
	public void setCpuUtilization(double cpuUtilization) {
		this.cpuUtilization = cpuUtilization;
	}
	
	public double getGcCollectionCount() {
		return gcCollectionCount;
	}
	
	public void setGcCollectionCount(double gcCollectionCount) {
		this.gcCollectionCount = gcCollectionCount;
	}
	
	public double getGcCollectionTime() {
		return gcCollectionTime;
	}
	
	public void setGcCollectionTime(double gcCollectionTime) {
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
	
	public double getUpTime() {
		return upTime;
	}
	
	public void setUpTime(double upTime) {
		this.upTime = upTime;
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
	
	
}
