package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.TermEvaluatorNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.TermEvaluatorNodeTestHelper;

import org.junit.Test;

/**
 * Test cases for the {@link TermEvaluatorNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class TermEvaluatorNodeTest {
  
    public void test(final TermEvaluatorNodeTestData data) {
        final TermEvaluatorNode termEvaluatorNode = new TermEvaluatorNode(data.getConditionExpressions());
        final ChangeSet resultChangeSet = termEvaluatorNode.update(data.getChangeSet());

        assertTrue(resultChangeSet.equals(data.getExpectedResults()));
    }

    @Test
    public void test1() {
        test(TermEvaluatorNodeTestHelper.data1());
    }
  
}
