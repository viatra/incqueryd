package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;

/**
 * Implements a production node.
 * 
 * @author szarnyasg
 * 
 */
public class ProductionNode extends AlphaNode {

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

		System.err.println("Production memory size: " + memory.size());
    	return null;
    }
    
    public Set<Tuple> getResults() {
		return memory;
	}
    
    public List<ChangeSet> getDeltaResults() {
    	synchronized (lastChangeSets) {
			List<ChangeSet> copyList = new ArrayList<>();
			for (ChangeSet changeSet : lastChangeSets) {
				copyList.add(changeSet);
			}
			lastChangeSets.clear();
			return copyList;
		}
    }

}
