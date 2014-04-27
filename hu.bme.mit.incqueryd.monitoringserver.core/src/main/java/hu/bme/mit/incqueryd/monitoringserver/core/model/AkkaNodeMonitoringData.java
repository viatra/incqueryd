package hu.bme.mit.incqueryd.monitoringserver.core.model;


public class AkkaNodeMonitoringData {

	private int upTime;
	
	private String upTimeUnit;
	
	private int threadCount;
	
	private double maxHeap;
	
	private double usedHeap;
	
	private double maxNonHeap;
	
	private double usedNonHeap; 
	
	private String heapMemoryUnit;
	
	private double gcCountPerMinute;
	
	private double gcTimePercent;
	
	private double memUsage;
	
	private int tcpCurrEstab;
	
	private int netRxBytesRate;
	
	private String netRxBytesRateUnit;
	
	private int netTxBytesRate;
	
	private String netTxBytesRateUnit;
	
	private double cpuCombined;
	
	private String name;
	
	private AkkaActorsOnNodeData actorsData;
	
	public AkkaActorsOnNodeData getActorsData() {
		return actorsData;
	}
	
	public void setActorsData(AkkaActorsOnNodeData actorsData) {
		this.actorsData = actorsData;
	}
	
	public double getCpuCombined() {
		return cpuCombined * 100;
	}
	
	public double getGcCountPerMinute() {
		return gcCountPerMinute;
	}
	
	public double getGcTimePercent() {
		return gcTimePercent;
	}
	
	public String getHeapMemoryUnit() {
		return heapMemoryUnit;
	}
	
	public double getMaxHeap() {
		return maxHeap;
	}
	
	public double getMaxNonHeap() {
		return maxNonHeap;
	}
	
	public double getMemUsage() {
		return memUsage;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNetRxBytesRate() {
		return netRxBytesRate;
	}
	
	public String getNetRxBytesRateUnit() {
		return netRxBytesRateUnit;
	}
	
	public int getNetTxBytesRate() {
		return netTxBytesRate;
	}
	
	public String getNetTxBytesRateUnit() {
		return netTxBytesRateUnit;
	}
	
	public int getTcpCurrEstab() {
		return tcpCurrEstab;
	}
	
	public int getThreadCount() {
		return threadCount;
	}
	
	public int getUpTime() {
		return upTime;
	}
	
	public String getUpTimeUnit() {
		return upTimeUnit;
	}
	
	public double getUsedHeap() {
		return usedHeap;
	}
	
	public double getUsedNonHeap() {
		return usedNonHeap;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
