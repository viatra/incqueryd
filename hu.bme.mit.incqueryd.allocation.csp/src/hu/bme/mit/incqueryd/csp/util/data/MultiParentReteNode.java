package hu.bme.mit.incqueryd.csp.util.data;

import hu.bme.mit.incqueryd.arch.util.ArchUtil;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class MultiParentReteNode extends ReteNode {
	
	protected List<ReteEdge> parentEdges;

	public MultiParentReteNode(ReteNodeRecipe reteNode) {
		super(reteNode);
		
		parentEdges = new ArrayList<>();
	}
	public ReteEdge createParentEdge(ReteNode par) {
		ReteEdge parentEdge = new ReteEdge(par, this);
		parentEdges.add(parentEdge);
		return parentEdge;
	}

	@Override
	public boolean calculateHeuristics() {
		
		boolean parentsReady = true;
		for (ReteEdge parentEdge : parentEdges) {
			ReteNode parent = parentEdge.getParent();
			if (!parent.isValid()) {
				parentsReady = false;
				break;
			}
			else
			{
				if(!parentEdge.isValid()) {
					int tupleNumber = parent.getTupleNumber();
					int arity = parent.getTupleArity();
					parentEdge.setTupleNumber(tupleNumber);
					parentEdge.setTupleArity(arity);
					parentEdge.valid();
				}
			}
		}
		
		if(parentsReady) {
			//TODO better heuristics later
			int tupleNumber = 0;
			int arity = 0;
			for (ReteEdge parentEdge : parentEdges) {
				ReteNode parent = parentEdge.getParent();
				tupleNumber += parent.getTupleNumber();
				arity = parent.getTupleArity();
			}
			
			this.tupleNumber = tupleNumber;
			this.tupleArity = arity;
			
			this.valid = true;
		}
		
		return parentsReady;
	}
	
	@Override
	public boolean isYourProcess(ReteProcess process) {
		boolean containsParent = process.contains(parentEdges.get(0).getParent());
		
		if(containsParent) process.addNode(this);
		
		return containsParent;
	}
	
	@Override
	public void print() {
		System.out.println("ReteNode: " + this.reteNode.getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(this.reteNode));
		
		for (ReteEdge parentEdge : parentEdges) {
			ReteNode parent = parentEdge.getParent();
			int tupels = parentEdge.getTupleNumber();
			int arity = parentEdge.getTupleArity();
			String parentID = parent.getReteNode().getClass().getSimpleName() + " " + ArchUtil.getJsonEObjectUri(parent.getReteNode());
			
			System.out.println("parent: " + parentID + ", tuples: " + tupels + ",arity: " + arity);
		}
	}

}
