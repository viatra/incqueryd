package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.FilterTestHelper;

import org.junit.Test;

/**
 * Test cases for the {@link EqualityNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class EqualityNodeTest {

    public void test(final FilterNodeTestData data) {
        final FilterNode filterNode = new EqualityNode(data.getTupleMask());
        final ChangeSet resultChangeSet = filterNode.update(data.getChangeSet());

        assertTrue(resultChangeSet.equals(data.getEqualityExpectedResults()));
    }

    @Test
    public void test1() {
        test(FilterTestHelper.data1());
    }
}
