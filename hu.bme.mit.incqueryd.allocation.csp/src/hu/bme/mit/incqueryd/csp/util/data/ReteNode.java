package hu.bme.mit.incqueryd.csp.util.data;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;


public abstract class ReteNode {
	
	protected int tupleNumber;
	protected int tupleArity;
	protected boolean valid;
	
	protected int processId;
	
	protected ReteNodeRecipe reteNode;
	
	public ReteNode(ReteNodeRecipe reteNode) {
		valid = false;
		this.reteNode = reteNode;
	}
	
	public ReteNodeRecipe getReteNode() {
		return reteNode;
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
	
	public int getProcessId() {
		return processId;
	}
	
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
	public boolean isYourProcess(ReteProcess process) {
		return false;
	}
	
	abstract public boolean calculateHeuristics();
	
	abstract public void print();

}
