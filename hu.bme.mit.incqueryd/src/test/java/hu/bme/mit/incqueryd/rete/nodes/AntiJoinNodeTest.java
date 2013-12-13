package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.BetaNodeTestHelper;

import org.junit.Test;

/**
 * Test cases for the {@link AntiJoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class AntiJoinNodeTest {

    public void test(final BetaNodeTestData data) {
        final AntiJoinNode joinNode = new AntiJoinNode(data.getPrimaryMask(), data.getSecondaryMask());
        final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryChangeSet(),
                data.getSecondaryChangeSet());
        
        System.out.println(resultChangeSet.getTuples());
        assertTrue(resultChangeSet.equals(data.getAntiJoinExpectedResults()));
    }

    @Test
    public void test1() {
        test(BetaNodeTestHelper.data1());
    }

    @Test
    public void test2() {
        test(BetaNodeTestHelper.data2());
    }
    
    @Test
    public void test3() {
        test(BetaNodeTestHelper.data3());
    }

}
