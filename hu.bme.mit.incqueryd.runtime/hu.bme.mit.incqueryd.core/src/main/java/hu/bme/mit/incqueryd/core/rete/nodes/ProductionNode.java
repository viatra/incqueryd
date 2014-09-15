package hu.bme.mit.incqueryd.core.rete.nodes;

import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.core.rete.dataunits.Tuple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;

import com.carrotsearch.sizeof.RamUsageEstimator;

/**
 * Implements a production node.
 * 
 * @author szarnyasg
 * 
 */
public class ProductionNode implements AlphaNode {

	protected final ProductionRecipe recipe;
	protected final Set<Tuple> memory = new HashSet<>();
	protected List<ChangeSet> lastChangeSets = new ArrayList<>();
	
	ProductionNode(final ProductionRecipe recipe) {
        super();
        this.recipe = recipe;
	}
	
    @Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {
    	if (incomingChangeSet.getTuples().size() > 0) {
			synchronized (lastChangeSets) {
				lastChangeSets.add(incomingChangeSet);
			}
		}
    	
		switch (incomingChangeSet.getChangeType()) {
        case POSITIVE:
            memory.addAll(incomingChangeSet.getTuples());        	
        	break;
        case NEGATIVE:
        	memory.removeAll(incomingChangeSet.getTuples());
        	break;
        default:
        	break;
        }

		System.out.println("[ReteActor       ] (ProductionNode, " + recipe.getTraceInfo() + ") Production memory size: " + memory.size());
		return incomingChangeSet;
    }
    
    public Set<Tuple> getResults() {
		return memory;
	}
    
    public List<ChangeSet> getDeltaResults() {
    	synchronized (lastChangeSets) {
    		final List<ChangeSet> copyList = new ArrayList<>();
			for (final ChangeSet changeSet : lastChangeSets) {
				copyList.add(changeSet);
			}
			lastChangeSets.clear();
			return copyList;
		}
    }
    
    public double getMemoryConsumption() {
		 double memorySize = memory.size() > 0 ? (double) RamUsageEstimator.sizeOf(memory) / RamUsageEstimator.ONE_MB : 0;
		 double deltaSize = lastChangeSets.size() > 0 ? (double) RamUsageEstimator.sizeOf(lastChangeSets) / RamUsageEstimator.ONE_MB : 0;
		 return memorySize + deltaSize;
	}

}
