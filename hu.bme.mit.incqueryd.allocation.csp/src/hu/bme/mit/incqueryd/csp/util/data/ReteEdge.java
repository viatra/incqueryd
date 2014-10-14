package hu.bme.mit.incqueryd.csp.util.data;

public class ReteEdge {
	
	protected ReteNode parent;
	
	protected int weight;

	public ReteEdge(ReteNode target, int weight) {
		this.parent = target;
		this.weight = weight;
	}
	
	public ReteNode getTarget() {
		return parent;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
