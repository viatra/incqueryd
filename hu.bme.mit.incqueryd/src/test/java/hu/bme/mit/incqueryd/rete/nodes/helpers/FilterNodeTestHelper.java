package hu.bme.mit.incqueryd.rete.nodes.helpers;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableList;

/**
 * 
 * @author szarnyasg
 *
 */
public class FilterNodeTestHelper {

    public static FilterNodeTestData data1() {
        final Set<Tuple> tuples = new HashSet<>();
        // -------------reference|---v1|v2|--
        // ----------------------V-----V--V--
        tuples.add(new TupleImpl(1, 2, 1, 1));
        tuples.add(new TupleImpl(1, 2, 1, 3));
        tuples.add(new TupleImpl(1, 2, 3, 1));
        tuples.add(new TupleImpl(1, 2, 3, 3));
        tuples.add(new TupleImpl(1, 2, 3, 4));
        final ChangeSet changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);

        final TupleMask tupleMask = new TupleMask(ImmutableList.of(0, 2, 3));

        final Set<Tuple> equalityExpectedTuples = new HashSet<>();
        equalityExpectedTuples.add(new TupleImpl(1, 2, 1, 1));
        final ChangeSet equalityExpectedResults = new ChangeSet(equalityExpectedTuples, ChangeType.POSITIVE);

        final Set<Tuple> inequalityExpectedTuples = new HashSet<>();
        inequalityExpectedTuples.add(new TupleImpl(1, 2, 3, 3));
        inequalityExpectedTuples.add(new TupleImpl(1, 2, 3, 4));
        final ChangeSet inequalityExpectedResults = new ChangeSet(inequalityExpectedTuples, ChangeType.POSITIVE);

        final FilterNodeTestData data1 = new FilterNodeTestData(changeSet, tupleMask, equalityExpectedResults,
                inequalityExpectedResults);
        return data1;
    }

}
