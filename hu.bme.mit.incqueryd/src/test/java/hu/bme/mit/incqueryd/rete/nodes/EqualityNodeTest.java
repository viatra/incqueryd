package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;

import org.junit.Test;

/**
 * 
 * @author szarnyasg
 *
 */
public class EqualityNodeTest {

	@Test
	public void test1(final FilterNodeTestData data) {
		final FilterNode filterNode = new EqualityNode(data.getTupleMask());
		//final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryTuples(), data.getSecondaryTuples());
		final ChangeSet resultChangeSet = filterNode.update(data.getChangeSet());
		assertTrue(resultChangeSet.equals(data.getEqualityExpectedResults()));		
	}
	
}
