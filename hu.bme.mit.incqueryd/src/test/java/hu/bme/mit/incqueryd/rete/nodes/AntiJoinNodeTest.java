package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.JoinNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.JoinNodeTestHelper;

import org.junit.Test;

/**
 * Test cases for the {@link AntiJoinNode} class.
 * 
 * @author szarnyasg
 *
 */
public class AntiJoinNodeTest {

	public void test(final JoinNodeTestData data) {
		final AntiJoinNode joinNode = new AntiJoinNode(data.getPrimaryMask(), data.getSecondaryMask());
		final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryChangeSet(), data.getSecondaryChangeSet());				
		assertTrue(resultChangeSet.equals(data.getAntiJoinExpectedResults()));
	}

	@Test
	public void test1() {
		test(JoinNodeTestHelper.data1());
	}

	@Test
	public void test2() {
		test(JoinNodeTestHelper.data2());
	}
	
//	@Test
//	public void test1() {
//		final Set<Tuple> leftTuples = new HashSet<>();
//		leftTuples.add(new TupleImpl(5, 6, 7));
//		leftTuples.add(new TupleImpl(10, 11, 7));
//
//		final Set<Tuple> rightTuples = new HashSet<>();
//		rightTuples.add(new TupleImpl(7, 8));
//
//		final TupleMask leftMask = new TupleMask(ImmutableList.of(2));
//		final TupleMask rightMask = new TupleMask(ImmutableList.of(0));
//		final AntiJoinNode joinNode = new AntiJoinNode(leftMask, rightMask);
//		final ChangeSet resultChangeSet = Algorithms.join(joinNode, leftTuples, rightTuples);
//		
//		final Set<Tuple> tuples = resultChangeSet.getTuples();
//		assertEquals(tuples.size(), 0);
//	}
//	
//	@Test
//	public void test2() {
//		final Set<Tuple> leftTuples = new HashSet<>();
//		leftTuples.add(new TupleImpl(1, 5));
//		leftTuples.add(new TupleImpl(2, 6));
//
//		final Set<Tuple> rightTuples = new HashSet<>();
//		rightTuples.add(new TupleImpl(5, 10));
//
//		final TupleMask leftMask = new TupleMask(ImmutableList.of(1));
//		final TupleMask rightMask = new TupleMask(ImmutableList.of(0));
//		final AntiJoinNode joinNode = new AntiJoinNode(leftMask, rightMask);
//		final ChangeSet resultChangeSet = Algorithms.join(joinNode, leftTuples, rightTuples);
//		
//		final Set<Tuple> tuples = resultChangeSet.getTuples();
//		assertEquals(tuples.size(), 1);
//		assertTrue(tuples.contains(new TupleImpl(2, 6)));
//	}

}
