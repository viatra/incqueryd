package hu.bme.mit.incqueryd.osmonitoringagent.metrics;

public class NetworkUsage {
	
	private String name;
	private String address;
	private double RxTraffic;
	private long RxPackets;
	private double TxTraffic;
	private long TxPackets;

	public NetworkUsage(String name, String address) {
		this.name = name;
		this.address = address;
		RxTraffic = 0;
		RxPackets = 0;
		TxTraffic = 0;
		TxPackets = 0;
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
		return RxTraffic;
	}
	
	public void setRxTraffic(double rxTraffic) {
		RxTraffic = rxTraffic;
	}
	
	public long getRxPackets() {
		return RxPackets;
	}
	
	public void setRxPackets(long rxPackets) {
		RxPackets = rxPackets;
	}
	
	public double getTxTraffic() {
		return TxTraffic;
	}
	
	public void setTxTraffic(double txTraffic) {
		TxTraffic = txTraffic;
	}
	
	public long getTxPackets() {
		return TxPackets;
	}
	
	public void setTxPackets(long txPackets) {
		TxPackets = txPackets;
	}
}
