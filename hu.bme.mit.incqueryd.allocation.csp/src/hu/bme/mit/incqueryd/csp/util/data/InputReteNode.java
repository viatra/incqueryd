package hu.bme.mit.incqueryd.csp.util.data;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;
import hu.bme.mit.incqueryd.csp.util.heuristics.HeuristicsHelper;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class InputReteNode extends MemoryReteNode {
	
	
	public InputReteNode(ReteNodeRecipe node, int tupleNumber, int tupleArity) {
		super(node);
		this.tupleNumber = tupleNumber;
		this.tupleArity = tupleArity;
		memory = HeuristicsHelper.getEstimatedMemoryUsage(tupleNumber * tupleArity, tupleNumber * tupleArity);
		this.valid = true;
	}
	
	@Override
	public boolean calculateHeuristics() {
		return true;
	}

	@Override
	public void print() {
		System.out.println("ReteNode: " + this.reteNode.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(this.reteNode) + " ,memory: " + memory);
	}

}
