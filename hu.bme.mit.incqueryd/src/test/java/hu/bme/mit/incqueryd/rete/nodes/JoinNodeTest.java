package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * Test cases for the {@link JoinNode} class.
 * @author szarnyasg
 *
 */
public class JoinNodeTest {

	@Test
	public void test1() {
		final Collection<Tuple> leftTuples = new HashSet<>();
		leftTuples.add(new TupleImpl(5, 6, 7));
		leftTuples.add(new TupleImpl(10, 11, 7));

		final Collection<Tuple> rightTuples = new HashSet<>();
		rightTuples.add(new TupleImpl(7, 8));

		final TupleMask leftMask = new TupleMask(ImmutableList.of(2));
		final TupleMask rightMask = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode = new JoinNode(leftMask, rightMask);
		final ChangeSet resultChangeSet = Algorithms.join(joinNode, leftTuples, rightTuples);
		
		final Collection<Tuple> tuples = resultChangeSet.getTuples();
		assertEquals(tuples.size(), 2);
		assertTrue(tuples.contains(new TupleImpl(5, 6, 7, 8)));
		assertTrue(tuples.contains(new TupleImpl(10, 11, 7, 8)));		
	}
	
	@Test
	public void test2() {
		final Collection<Tuple> leftTuples = new HashSet<>();
		leftTuples.add(new TupleImpl(1, 5));
		leftTuples.add(new TupleImpl(2, 6));

		final Collection<Tuple> rightTuples = new HashSet<>();
		rightTuples.add(new TupleImpl(5, 10));

		final TupleMask leftMask = new TupleMask(ImmutableList.of(1));
		final TupleMask rightMask = new TupleMask(ImmutableList.of(0));
		final AntiJoinNode joinNode = new AntiJoinNode(leftMask, rightMask);
		final ChangeSet resultChangeSet = Algorithms.join(joinNode, leftTuples, rightTuples);
		
		final Collection<Tuple> tuples = resultChangeSet.getTuples();
		assertEquals(tuples.size(), 1);
		assertTrue(tuples.contains(new TupleImpl(2, 6)));
	}

}
