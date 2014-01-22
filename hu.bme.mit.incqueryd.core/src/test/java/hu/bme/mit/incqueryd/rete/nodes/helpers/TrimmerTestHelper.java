package hu.bme.mit.incqueryd.rete.nodes.helpers;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.data.TrimmerNodeTestData;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.ImmutableList;

/**
 * 
 * @author szarnyasg
 *
 */
public class TrimmerTestHelper {

    public static TrimmerNodeTestData data1() {
        final Set<Tuple> tuples = new HashSet<>();
        tuples.add(new Tuple(1, 2, 3, 4));
        tuples.add(new Tuple(5, 6, 7, 8));
        final ChangeSet changeSet = new ChangeSet(tuples, ChangeType.POSITIVE);

        final TupleMask projectionMask = new TupleMask(ImmutableList.of(2, 0));
        final Set<Tuple> expectedTuples = new HashSet<>();
        expectedTuples.add(new Tuple(3, 1));
        expectedTuples.add(new Tuple(7, 5));
        final ChangeSet expectedResults = new ChangeSet(expectedTuples, ChangeType.POSITIVE);
      
        final TrimmerNodeTestData data1 = new TrimmerNodeTestData(changeSet, projectionMask, expectedResults);;
        return data1;
    }
    
}
