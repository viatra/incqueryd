package hu.bme.mit.incqueryd.csp.util.data;

import hu.bme.mit.incqueryd.csp.util.heuristics.HeuristicsHelper;

import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;

public class BetaReteNode extends MemoryReteNode {
	
	protected ReteEdge leftParent;
	protected ReteEdge rightParent;
	
	public BetaReteNode(BetaRecipe recipe) {
		super(recipe);
	}
	
	public void createLeftParentEdge(ReteNode left) {
		leftParent = new ReteEdge(left);
	}
	
	public void createRightParentEdge(ReteNode right) {
		rightParent = new ReteEdge(right);
	}

	
	@Override
	public boolean calculateHeuristics() {
		ReteNode left = leftParent.getTarget();
		ReteNode right = rightParent.getTarget();
		if(left.isValid() && right.isValid()) {
			
			int leftArity = left.getTupleArity();
			int leftTuples = left.getTupleNumber();
			
			int rightArity = right.getTupleArity();
			int rightTuples = right.getTupleNumber();
			
			leftParent.setTupleArity(leftArity);
			leftParent.setTupleNumber(leftTuples);
			rightParent.setTupleArity(rightArity);
			rightParent.setTupleNumber(rightTuples);
			leftParent.valid();
			rightParent.valid();
			
			long size = leftArity * leftTuples + rightArity + rightTuples;
			memory = HeuristicsHelper.getEstimatedMemoryUsage(size);
			
			if(reteNode instanceof JoinRecipe) {
				JoinRecipe join = (JoinRecipe) reteNode;
				int jointAttributes = join.getRightParentComplementaryMask().getSourceIndices().size();
				
				this.tupleArity = leftArity + rightArity - jointAttributes;
				this.tupleNumber = Math.max(leftTuples, rightTuples);
			}
			else if(reteNode instanceof AntiJoinRecipe) {
				this.tupleArity = leftArity;
				
				this.tupleNumber = (int) Math.floor(leftTuples * 0.1);
			}
			
			this.valid();
			return true;
		}
		
		return false;
	}
}
