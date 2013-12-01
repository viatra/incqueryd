package hu.bme.mit.incqueryd.sandbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.main.Main;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class JoinNodeTest {

	
	
	@Test
	public void joinTest1() {
		final Collection<Tuple> leftTuples = new HashSet<>();
		leftTuples.add(new TupleImpl(5, 6, 7));
		leftTuples.add(new TupleImpl(10, 11, 7));

		final Collection<Tuple> rightTuples = new HashSet<>();
		rightTuples.add(new TupleImpl(7, 8));

		final TupleMask leftMask = new TupleMask(ImmutableList.of(2));
		final TupleMask rightMask = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode = new JoinNode(leftMask, rightMask);
		final ChangeSet resultChangeSet = Main.join(joinNode, leftTuples, rightTuples);
		
//		System.out.println(resultChangeSet.getTuples());
		
		final Collection<Tuple> tuples = resultChangeSet.getTuples();
		assertEquals(tuples.size(), 2);
		assertTrue(tuples.contains(new TupleImpl(5, 6, 7, 8)));
		assertTrue(tuples.contains(new TupleImpl(10, 11, 7, 8)));		
	}

}
