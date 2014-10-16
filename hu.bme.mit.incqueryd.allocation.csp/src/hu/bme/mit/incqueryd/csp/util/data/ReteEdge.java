package hu.bme.mit.incqueryd.csp.util.data;

public class ReteEdge {
	
	protected ReteNode parent;
	
	protected int tupleNumber;
	protected int tupleArity;
	
	protected boolean valid;

	public ReteEdge(ReteNode target) {
		this.parent = target;
		valid = false;
	}
	
	public ReteNode getTarget() {
		return parent;
	}
	
	public int getTupleNumber() {
		return tupleNumber;
	}
	
	public int getTupleArity() {
		return tupleArity;
	}
	
	public void setTupleNumber(int tupleNumber) {
		this.tupleNumber = tupleNumber;
	}
	
	public void setTupleArity(int tupleArity) {
		this.tupleArity = tupleArity;
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public void valid() {
		valid = true;
	}

}
