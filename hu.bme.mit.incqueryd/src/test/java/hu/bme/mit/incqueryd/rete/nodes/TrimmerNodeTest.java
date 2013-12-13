package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.TrimmerNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.TrimmerNodeTestHelper;

import org.junit.Test;

/**
 * 
 * @author szarnyasg
 *
 */
public class TrimmerNodeTest {

    public void test(final TrimmerNodeTestData data) {
        final TrimmerNode trimmerNode = new TrimmerNode(data.getProjectionMask());
        final ChangeSet resultChangeSet = trimmerNode.update(data.getChangeSet());
        assertTrue(resultChangeSet.equals(data.getExpectedResults()));
    }
    
    @Test
    public void test1() {
        test(TrimmerNodeTestHelper.data1());
    }

}
