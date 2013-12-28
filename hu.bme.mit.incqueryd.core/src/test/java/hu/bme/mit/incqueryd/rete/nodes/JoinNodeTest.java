package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.BetaTestHelper;

import org.junit.Test;

/**
 * Test cases for the {@link JoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class JoinNodeTest {

    public void test(final BetaNodeTestData data) {
        final JoinNode joinNode = new JoinNode(data.getPrimaryMask(), data.getSecondaryMask());
        final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryChangeSet(),
                data.getSecondaryChangeSet());
        assertTrue(resultChangeSet.equals(data.getJoinExpectedResults()));
    }

    @Test
    public void test1() {
        test(BetaTestHelper.data1());
    }

    @Test
    public void test2() {
        test(BetaTestHelper.data2());
    }

    @Test
    public void test3() {
        test(BetaTestHelper.data3());
    }

}
