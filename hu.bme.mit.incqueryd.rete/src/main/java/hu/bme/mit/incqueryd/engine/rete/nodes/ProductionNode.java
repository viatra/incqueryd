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
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
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
    	MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    	return memoryMXBean.getHeapMemoryUsage().getUsed() / (1024*1024);
	}

}
