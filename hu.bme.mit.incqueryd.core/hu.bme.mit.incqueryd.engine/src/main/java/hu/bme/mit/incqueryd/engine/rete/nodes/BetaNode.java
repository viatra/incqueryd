/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.rete.nodes;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
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
    
    public double getMemoryConsumption() {
    	MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    	return memoryMXBean.getHeapMemoryUsage().getUsed() / (1024*1024);
    }

}
