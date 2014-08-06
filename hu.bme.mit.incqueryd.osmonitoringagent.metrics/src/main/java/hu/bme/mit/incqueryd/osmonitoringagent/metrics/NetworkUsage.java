package hu.bme.mit.incqueryd.osmonitoringagent.metrics;

import java.io.Serializable;

public class NetworkUsage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String address;
	private double rxTraffic;
	private long rxPackets;
	private double txTraffic;
	private long txPackets;

	public NetworkUsage(String name, String address) {
		this.name = name;
		this.address = address;
		rxTraffic = 0;
		rxPackets = 0;
		txTraffic = 0;
		txPackets = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public double getRxTraffic() {
		return rxTraffic;
	}
	
	public void setRxTraffic(double rxTraffic) {
		this.rxTraffic = rxTraffic;
	}
	
	public long getRxPackets() {
		return rxPackets;
	}
	
	public void setRxPackets(long rxPackets) {
		this.rxPackets = rxPackets;
	}
	
	public double getTxTraffic() {
		return txTraffic;
	}
	
	public void setTxTraffic(double txTraffic) {
		this.txTraffic = txTraffic;
	}
	
	public long getTxPackets() {
		return txPackets;
	}
	
	public void setTxPackets(long txPackets) {
		this.txPackets = txPackets;
	}
}
