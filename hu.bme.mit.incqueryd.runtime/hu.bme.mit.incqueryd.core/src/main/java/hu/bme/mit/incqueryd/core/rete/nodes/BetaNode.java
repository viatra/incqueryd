package hu.bme.mit.incqueryd.core.rete.nodes;

import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.core.rete.dataunits.ReteNodeSlot;

import java.util.List;

import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;

/**
 * The key components are the beta nodes, that have two separate input slots, each connected to a node in the network.
 * [Bergmann's MSc thesis, p.27]
 * 
 * @author szarnyasg
 * 
 */
public abstract class BetaNode implements ReteNode {

    protected Indexer primaryIndexer;
    protected Indexer secondaryIndexer;
    
    protected double memoryConsumption;

    BetaNode(final BetaRecipe recipe, final List<String> cacheMachineIps) {
    	super();
        this.primaryIndexer = new Indexer(recipe.getLeftParent().getMask().getSourceIndices(), cacheMachineIps);
        this.secondaryIndexer = new Indexer(recipe.getRightParent().getMask().getSourceIndices(), cacheMachineIps);
    }

    abstract public ChangeSet update(final ChangeSet incomingChangeSet, final ReteNodeSlot slot);
    
    public int leftIndexerSize() {
    	return primaryIndexer.getSize();
    }
    
    public int rightIndexerSize() {
    	return secondaryIndexer.getSize();
    }
    
    protected void updateMemoryConsumption() {
    	memoryConsumption = primaryIndexer.getMemoryConsumption() + secondaryIndexer.getMemoryConsumption();
    }
    
    public double getMemoryConsumption() {
    	return memoryConsumption;
    }

}
