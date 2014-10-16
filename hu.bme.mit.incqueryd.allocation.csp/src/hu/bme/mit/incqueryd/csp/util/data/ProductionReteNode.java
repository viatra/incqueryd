package hu.bme.mit.incqueryd.csp.util.data;

import hu.bme.mit.incqueryd.csp.util.heuristics.HeuristicsHelper;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class ProductionReteNode extends MemoryReteNode {
	
	protected ReteEdge parentEdge;
	
	public void createParentEdge(ReteNode par) {
		parentEdge = new ReteEdge(par);
	}

	public ProductionReteNode(ReteNodeRecipe node) {
		super(node);
	}

	@Override
	public boolean calculateHeuristics() {
		ReteNode parentNode = parentEdge.getTarget();
		if(parentNode.isValid()) {
			int arity = parentNode.getTupleArity();
			int tuples = parentNode.getTupleNumber();
			
			parentEdge.setTupleArity(arity);
			parentEdge.setTupleNumber(tuples);
			
			this.tupleArity = arity;
			this.tupleNumber = tuples;
			
			memory = HeuristicsHelper.getEstimatedMemoryUsage(arity * tuples);
			
			this.valid = true;
		}
		
		return false;
	}

}
