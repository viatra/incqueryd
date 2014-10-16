package hu.bme.mit.incqueryd.csp.util.data;

import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;

public class AlphaReteNode extends ReteNode {
	
	protected ReteEdge parentEdge;
	
	public void createParentEdge(ReteNode par) {
		parentEdge = new ReteEdge(par);
	}

	public AlphaReteNode(ReteNodeRecipe reteNode) {
		super(reteNode);
	}

	@Override
	public boolean calculateHeuristics() {
		ReteNode parentNode = parentEdge.getTarget();
		if(parentNode.isValid()) {
			int arity = parentNode.getTupleArity();
			int tuples = parentNode.getTupleNumber();
			
			parentEdge.setTupleArity(arity);
			parentEdge.setTupleNumber(tuples);
			
			if(reteNode instanceof TrimmerRecipe) {
				TrimmerRecipe trimmer = (TrimmerRecipe) reteNode;
				int remains = trimmer.getMask().getSourceIndices().size();
				
				this.tupleArity = remains;
				this.tupleNumber = tuples;
			}
			else if (reteNode instanceof CheckRecipe) {
				this.tupleArity = arity;
				this.tupleNumber = (int) Math.floor(tuples * 0.1);
			}
			
			this.valid = true;
		}
		return false;
	}

}
