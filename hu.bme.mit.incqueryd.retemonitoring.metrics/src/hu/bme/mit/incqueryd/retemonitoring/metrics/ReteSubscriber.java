package hu.bme.mit.incqueryd.retemonitoring.metrics;

public class ReteSubscriber {
	
	private String reteNode;
	private String slot;
	
	public ReteSubscriber(String reteNode, String slot) {
		this.reteNode = reteNode;
		this.slot = slot;
	}
	
	public String getReteNode() {
		return reteNode;
	}
	
	public String getSlot() {
		return slot;
	}
}
