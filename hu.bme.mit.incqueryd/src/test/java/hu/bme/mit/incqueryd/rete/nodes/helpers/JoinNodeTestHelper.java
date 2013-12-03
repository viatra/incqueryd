package hu.bme.mit.incqueryd.rete.nodes.helpers;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.data.JoinNodeTestData;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableList;

/**
 * 
 * @author szarnyasg
 *
 */
public class JoinNodeTestHelper {

	public static JoinNodeTestData data1() {

		final Set<Tuple> primaryTuples = new HashSet<>();
		primaryTuples.add(new TupleImpl(5, 6, 7));
		primaryTuples.add(new TupleImpl(10, 11, 7));

		final Set<Tuple> secondaryTuples = new HashSet<>();
		secondaryTuples.add(new TupleImpl(7, 8));

		final TupleMask primaryMask = new TupleMask(ImmutableList.of(2));
		final TupleMask secondaryMask = new TupleMask(ImmutableList.of(0));

		final Set<Tuple> joinResultTuples = new HashSet<>();
		joinResultTuples.add(new TupleImpl(5, 6, 7, 8));
		joinResultTuples.add(new TupleImpl(10, 11, 7, 8));
		final ChangeSet joinExpectedChangeSet = new ChangeSet(joinResultTuples, ChangeType.POSITIVE);

		final Set<Tuple> antiJoinResultTuples = new HashSet<>();
		final ChangeSet antiJoinExpectedChangeSet = new ChangeSet(antiJoinResultTuples, ChangeType.POSITIVE);

		final JoinNodeTestData data1 = new JoinNodeTestData(primaryTuples, secondaryTuples, primaryMask, secondaryMask, joinExpectedChangeSet,
				antiJoinExpectedChangeSet);
		return data1;

	}

	public static JoinNodeTestData data2() {
		final Set<Tuple> leftTuples = new HashSet<>();
		leftTuples.add(new TupleImpl(1, 5));
		leftTuples.add(new TupleImpl(2, 6));

		final Set<Tuple> rightTuples = new HashSet<>();
		rightTuples.add(new TupleImpl(5, 10));

		final TupleMask leftMask = new TupleMask(ImmutableList.of(1));
		final TupleMask rightMask = new TupleMask(ImmutableList.of(0));

		final Set<Tuple> joinResultTuples = new HashSet<>();
		joinResultTuples.add(new TupleImpl(1, 5, 10));
		final ChangeSet joinExpectedChangeSet = new ChangeSet(joinResultTuples, ChangeType.POSITIVE);

		final Set<Tuple> antiJoinResultTuples = new HashSet<>();
		antiJoinResultTuples.add(new TupleImpl(2, 6));
		final ChangeSet antiJoinExpectedChangeSet = new ChangeSet(antiJoinResultTuples, ChangeType.POSITIVE);

		final JoinNodeTestData data2 = new JoinNodeTestData(leftTuples, rightTuples, leftMask, rightMask, joinExpectedChangeSet, antiJoinExpectedChangeSet);
		return data2;
	}

}
