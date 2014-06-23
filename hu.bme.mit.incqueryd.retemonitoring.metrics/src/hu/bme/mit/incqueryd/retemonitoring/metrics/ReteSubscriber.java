package hu.bme.mit.incqueryd.retemonitoring.metrics;

import java.io.Serializable;

public class ReteSubscriber implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
