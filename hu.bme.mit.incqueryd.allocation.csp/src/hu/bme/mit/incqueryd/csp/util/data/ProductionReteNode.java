package hu.bme.mit.incqueryd.csp.util.data;

import hu.bme.mit.incqueryd.csp.util.heuristics.HeuristicsHelper;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class ProductionReteNode extends MultiParentReteNode {
	
	protected int memory;
	
	public ProductionReteNode(ReteNodeRecipe node) {
		super(node);
	}
	
	public int getMemory() {
		return memory;
	}

	@Override
	public boolean calculateHeuristics() {
		boolean ready = super.calculateHeuristics();
		
		if(ready) {
			memory = HeuristicsHelper.getEstimatedMemoryUsage(this.tupleArity * this.tupleNumber, this.tupleArity * this.tupleNumber);
		}
		
		return ready;
	}

}
