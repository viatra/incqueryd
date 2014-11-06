package hu.bme.mit.incqueryd.osmonitoringagent.metrics;

import java.io.Serializable;

public class CPUUsage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
