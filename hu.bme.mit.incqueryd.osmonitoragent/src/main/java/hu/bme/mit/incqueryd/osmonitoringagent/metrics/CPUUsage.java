package hu.bme.mit.incqueryd.osmonitoringagent.metrics;

public class CPUUsage {

	private double usedCPUPercent;
	
	public CPUUsage(){
		usedCPUPercent = 0;
	}
	
	public double getUsedCPUPercent() {
		return usedCPUPercent;
	}
	
	public void setUsedCPUPercent(double usedCPUPercent) {
		this.usedCPUPercent = usedCPUPercent;
	}
	
}
