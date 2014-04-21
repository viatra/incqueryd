package hu.bme.mit.incqueryd.osmonitoringagent.metrics;

public class MemoryUsage {

	private double totalMemory;
	private double usedMemory;
	private double freeMemory;
	private double usedMemoryPercent;
	private double freeMemoryPercent;
	
	public MemoryUsage(){
		totalMemory = 0;
		usedMemory = 0;
		freeMemory = 0;
		usedMemoryPercent = 0;
		freeMemoryPercent = 0;
	}
	
	public double getTotalMemory() {
		return totalMemory;
	}
	
	public void setTotalMemory(double totalMemory) {
		this.totalMemory = totalMemory;
	}
	
	public double getUsedMemory() {
		return usedMemory;
	}
	
	public void setUsedMemory(double usedMemory) {
		this.usedMemory = usedMemory;
	}
	
	public double getFreeMemory() {
		return freeMemory;
	}
	
	public void setFreeMemory(double freeMemory) {
		this.freeMemory = freeMemory;
	}
	
	public double getUsedMemoryPercent() {
		return usedMemoryPercent;
	}
	
	public void setUsedMemoryPercent(double usedMemoryPercent) {
		this.usedMemoryPercent = usedMemoryPercent;
	}
	
	public double getFreeMemoryPercent() {
		return freeMemoryPercent;
	}
	
	public void setFreeMemoryPercent(double freeMemoryPercent) {
		this.freeMemoryPercent = freeMemoryPercent;
	}
	
}
