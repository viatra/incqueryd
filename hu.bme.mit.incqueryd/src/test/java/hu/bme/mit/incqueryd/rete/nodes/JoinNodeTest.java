package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.JoinNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.JoinNodeTestHelper;

import org.junit.Test;

/**
 * Test cases for the {@link JoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class JoinNodeTest {

	public void test(final JoinNodeTestData data) {
		final JoinNode joinNode = new JoinNode(data.getPrimaryMask(), data.getSecondaryMask());
		final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryTuples(), data.getSecondaryTuples());
		System.out.println(resultChangeSet.getTuples());

	}

	@Test
	public void test1() {
		test(JoinNodeTestHelper.data1());
	}

	@Test
	public void test2() {
		test(JoinNodeTestHelper.data2());
	}

}
