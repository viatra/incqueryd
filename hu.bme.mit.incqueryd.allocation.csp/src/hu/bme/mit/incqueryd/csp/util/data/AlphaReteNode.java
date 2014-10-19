package hu.bme.mit.incqueryd.csp.util.data;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;

import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;

public class AlphaReteNode extends ReteNode {
	
	protected ReteEdge parentEdge;
	
	public ReteEdge createParentEdge(ReteNode par) {
		parentEdge = new ReteEdge(par, this);
		return parentEdge;
	}

	public AlphaReteNode(ReteNodeRecipe reteNode) {
		super(reteNode);
	}

	@Override
	public boolean calculateHeuristics() {
		ReteNode parentNode = parentEdge.getParent();
		if(parentNode.isValid()) {
			int arity = parentNode.getTupleArity();
			int tuples = parentNode.getTupleNumber();
			
			parentEdge.setTupleArity(arity);
			parentEdge.setTupleNumber(tuples);
			
			if(reteNode instanceof TrimmerRecipe) {
				TrimmerRecipe trimmer = (TrimmerRecipe) reteNode;
				int remains = trimmer.getMask().getSourceIndices().size();
				
				this.tupleArity = remains;
				this.tupleNumber = (int) Math.floor(tuples * 0.9);
			}
			else if (reteNode instanceof CheckRecipe) {
				this.tupleArity = arity;
				this.tupleNumber = (int) Math.floor(tuples * 0.1);
			}
			
			this.valid = true;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isYourProcess(ReteProcess process) {
		boolean containsParent = process.contains(parentEdge.getParent());
		
		if(containsParent) process.addNode(this);
		
		return containsParent;
	}

	@Override
	public void print() {
		System.out.println("ReteNode: " + this.reteNode.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(this.reteNode));
		
		ReteNode parent = parentEdge.getParent();
		int tupels = parentEdge.getTupleNumber();
		int arity = parentEdge.getTupleArity();
		String parentID = parent.getReteNode().getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(parent.getReteNode());
		
		System.out.println("parent: " + parentID + ", tuples: " + tupels + ",arity: " + arity);
		
	}

}
