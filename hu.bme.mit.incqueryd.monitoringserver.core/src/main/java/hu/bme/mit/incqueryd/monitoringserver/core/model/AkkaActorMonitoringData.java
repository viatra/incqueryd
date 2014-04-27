package hu.bme.mit.incqueryd.monitoringserver.core.model;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class AkkaActorMonitoringData {
	
	@SerializedName("scope")
	private Map<String, String> scope;
	
	private int processedMessagesCount;
	
	private double meanMailboxSize;
	
	private int maxMailboxSize;
	
	private double meanTimeInMailbox;
	
	private String meanTimeInMailboxUnit;
	
	private double maxTimeInMailbox;
	
	private String maxTimeInMailboxUnit;
	
	private String rateUnit;
	
	private double totalMessageRate;
	
	private double receiveRate;
	
	private String node;
	
	public String getActor() {
		return scope.get("actorPath");
	}
	
	public int getMaxMailboxSize() {
		return maxMailboxSize;
	}
	
	public double getMaxTimeInMailbox() {
		return maxTimeInMailbox;
	}
	
	public String getMaxTimeInMailboxUnit() {
		return maxTimeInMailboxUnit;
	}
	
	public double getMeanMailboxSize() {
		return meanMailboxSize;
	}
	
	public double getMeanTimeInMailbox() {
		return meanTimeInMailbox;
	}
	
	public String getMeanTimeInMailboxUnit() {
		return meanTimeInMailboxUnit;
	}
	
	public int getProcessedMessageCount() {
		return processedMessagesCount;
	}
	
	public String getRateUnit() {
		return rateUnit;
	}
	
	public double getReceiveRate() {
		return receiveRate;
	}
	
	public double getTotalMessageRate() {
		return totalMessageRate;
	}
	
	public String getNode() {
		return node;
	}
	
	public void setNode(String node) {
		this.node = node;
	}
	
}
