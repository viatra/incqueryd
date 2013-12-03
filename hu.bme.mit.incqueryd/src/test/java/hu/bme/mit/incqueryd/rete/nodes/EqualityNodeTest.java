package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class EqualityNodeTest {

	@Test
	public void test1() {
		final Collection<Tuple> tuples = new HashSet<>();
		tuples.add(new TupleImpl(1, 2, 3));
		tuples.add(new TupleImpl(1, 2, 1));

		final TupleMask tupleMask = new TupleMask(ImmutableList.of(0, 2));
		final EqualityNode filterNode = new EqualityNode(tupleMask);
		final ChangeSet incomingChangeSet = new ChangeSet(tuples, ChangeType.POSITIVE);
		
		final ChangeSet resultChangeSet = filterNode.update(incomingChangeSet);			
		final Collection<Tuple> resultTuples = resultChangeSet.getTuples();

		assertEquals(resultTuples.size(), 1);
		assertTrue(resultTuples.contains(new TupleImpl(1, 2, 1)));		
	}
	
}