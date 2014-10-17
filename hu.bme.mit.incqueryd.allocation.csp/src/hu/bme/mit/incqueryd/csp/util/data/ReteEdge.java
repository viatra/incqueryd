package hu.bme.mit.incqueryd.csp.util.data;

public class ReteEdge {
	
	protected ReteNode parent;
	protected ReteNode child;
	
	protected int tupleNumber;
	protected int tupleArity;
	
	protected boolean valid;

	public ReteEdge(ReteNode target, ReteNode child) {
		this.parent = target;
		this.child = child;
		valid = false;
	}
	
	public ReteNode getParent() {
		return parent;
	}
	
	public ReteNode getChild() {
		return child;
	}
	
	public int getTupleNumber() {
		return tupleNumber;
	}
	
	public int getTupleArity() {
		return tupleArity;
	}
	
	public int getWeight() {
		return tupleNumber * tupleArity;
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
	
	public boolean isInterProcess() {
		int parentPID = parent.getProcessId();
		int childPID = child.getProcessId();
		
		return (parentPID != childPID);
	}
	
	public int getParentPID() {
		return parent.getProcessId();
	}
	
	public int getChildPID() {
		return child.getProcessId();
	}

}
