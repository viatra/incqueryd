package hu.bme.mit.incqueryd.core.rete.nodes;

import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.core.rete.dataunits.Tuple;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe;

public class ConstantNode implements AlphaNode {

	protected ChangeSet changeSet;
	public ConstantNode(ConstantRecipe recipe) {
		Set<Tuple> tuples = new HashSet<>();
		for (Object value : recipe.getConstantValues()) {
			Tuple tuple = new Tuple(value);
			tuples.add(tuple);		
		}
		changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
	}

	@Override
	public ChangeSet update(ChangeSet incomingChangeSet) {	
		return changeSet;
	}

}
