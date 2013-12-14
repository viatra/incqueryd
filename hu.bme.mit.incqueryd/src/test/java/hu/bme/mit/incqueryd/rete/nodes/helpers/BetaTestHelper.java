package hu.bme.mit.incqueryd.rete.nodes.helpers;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableList;

/**
 * 
 * @author szarnyasg
 * 
 */
public class BetaTestHelper {

    /**
     * Simple case: one common attribute.
     * 
     * @return
     */
    public static BetaNodeTestData data1() {

        final Set<Tuple> primaryTuples = new HashSet<>();
        primaryTuples.add(new TupleImpl(5, 6, 7));
        primaryTuples.add(new TupleImpl(10, 11, 7));
        final ChangeSet primaryChangeSet = new ChangeSet(primaryTuples, ChangeType.POSITIVE);

        final Set<Tuple> secondaryTuples = new HashSet<>();
        secondaryTuples.add(new TupleImpl(7, 8));
        final ChangeSet secondaryChangeSet = new ChangeSet(secondaryTuples, ChangeType.POSITIVE);

        final TupleMask primaryMask = new TupleMask(ImmutableList.of(2));
        final TupleMask secondaryMask = new TupleMask(ImmutableList.of(0));

        final Set<Tuple> joinResultTuples = new HashSet<>();
        joinResultTuples.add(new TupleImpl(5, 6, 7, 8));
        joinResultTuples.add(new TupleImpl(10, 11, 7, 8));
        final ChangeSet joinExpectedChangeSet = new ChangeSet(joinResultTuples, ChangeType.POSITIVE);

        final Set<Tuple> antiJoinResultTuples = new HashSet<>();
        final ChangeSet antiJoinExpectedChangeSet = new ChangeSet(antiJoinResultTuples, ChangeType.POSITIVE);

        final BetaNodeTestData data = new BetaNodeTestData(primaryChangeSet, secondaryChangeSet, primaryMask,
                secondaryMask, joinExpectedChangeSet, antiJoinExpectedChangeSet);
        return data;
    }

    /**
     * Simple case: one common attribute.
     * 
     * @return
     */
    public static BetaNodeTestData data2() {
        final Set<Tuple> primaryTuples = new HashSet<>();
        primaryTuples.add(new TupleImpl(1, 5));
        primaryTuples.add(new TupleImpl(2, 6));
        final ChangeSet primaryChangeSet = new ChangeSet(primaryTuples, ChangeType.POSITIVE);

        final Set<Tuple> secondaryTuples = new HashSet<>();
        secondaryTuples.add(new TupleImpl(5, 10));
        final ChangeSet secondaryChangeSet = new ChangeSet(secondaryTuples, ChangeType.POSITIVE);

        final TupleMask primaryMask = new TupleMask(ImmutableList.of(1));
        final TupleMask secondaryMask = new TupleMask(ImmutableList.of(0));

        final Set<Tuple> joinResultTuples = new HashSet<>();
        joinResultTuples.add(new TupleImpl(1, 5, 10));
        final ChangeSet joinExpectedChangeSet = new ChangeSet(joinResultTuples, ChangeType.POSITIVE);

        final Set<Tuple> antiJoinResultTuples = new HashSet<>();
        antiJoinResultTuples.add(new TupleImpl(2, 6));
        final ChangeSet antiJoinExpectedChangeSet = new ChangeSet(antiJoinResultTuples, ChangeType.POSITIVE);

        final BetaNodeTestData data = new BetaNodeTestData(primaryChangeSet, secondaryChangeSet, primaryMask,
                secondaryMask, joinExpectedChangeSet, antiJoinExpectedChangeSet);
        return data;
    }

    /**
     * No common attributes (empty tuple masks).
     * 
     * Note that in the absence of common attribute names (i.e. empty tuple masks), "R natural join S" is equal to
     * "R × S", while "R antijoin S" returns (1) R if S is empty, (2) an empty relation is S is not empty.
     * 
     * @return
     */
    public static BetaNodeTestData data3() {
        final Set<Tuple> primaryTuples = new HashSet<>();
        primaryTuples.add(new TupleImpl(1, 5));
        primaryTuples.add(new TupleImpl(2, 6));
        final ChangeSet primaryChangeSet = new ChangeSet(primaryTuples, ChangeType.POSITIVE);

        final Set<Tuple> secondaryTuples = new HashSet<>();
        secondaryTuples.add(new TupleImpl(5, 10));
        final ChangeSet secondaryChangeSet = new ChangeSet(secondaryTuples, ChangeType.POSITIVE);

        final TupleMask primaryMask = new TupleMask(ImmutableList.<Integer> of());
        final TupleMask secondaryMask = new TupleMask(ImmutableList.<Integer> of());

        final Set<Tuple> joinResultTuples = new HashSet<>();
        joinResultTuples.add(new TupleImpl(1, 5, 5, 10));
        joinResultTuples.add(new TupleImpl(2, 6, 5, 10));
        final ChangeSet joinExpectedChangeSet = new ChangeSet(joinResultTuples, ChangeType.POSITIVE);

        final Set<Tuple> antiJoinResultTuples = new HashSet<>();
        // the expected changeset is empty
        final ChangeSet antiJoinExpectedChangeSet = new ChangeSet(antiJoinResultTuples, ChangeType.POSITIVE);

        final BetaNodeTestData data = new BetaNodeTestData(primaryChangeSet, secondaryChangeSet, primaryMask,
                secondaryMask, joinExpectedChangeSet, antiJoinExpectedChangeSet);
        return data;
    }

}
