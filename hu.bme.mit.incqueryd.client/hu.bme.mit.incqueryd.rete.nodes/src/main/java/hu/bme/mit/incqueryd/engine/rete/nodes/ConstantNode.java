package hu.bme.mit.incqueryd.engine.rete.nodes;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe;

import com.google.common.base.Splitter;

public class ConstantNode implements AlphaNode {

	protected final ChangeSet changeSet;

	public ConstantNode(ConstantRecipe recipe) {
		Set<Tuple> tuples = new HashSet<>();
		Iterable<String> constantValues = Splitter.on(SEPARATOR).split(recipe.getTraceInfo());
		for (Object value : constantValues) {
			Tuple tuple = new Tuple(value);
			tuples.add(tuple);		
		}
		changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
	}

	private static final String SEPARATOR = " ";

	@Override
	public ChangeSet update(ChangeSet incomingChangeSet) {	
		return changeSet;
	}

}
