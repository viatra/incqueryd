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
        final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryChangeSet(),
                data.getSecondaryChangeSet());
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

}
