package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.TermEvaluatorNodeTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link TermEvaluatorNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class TermEvaluatorNodeTest {
  
	@Test
	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		File[] files = TestCaseFinder.getTestCases("termevaluatornode-*.json");

		for (File file : files) {
			System.out.println(file);
			Gson gson = GsonParser.getGsonParser();
			TermEvaluatorNodeTestData data = gson.fromJson(new FileReader(file), TermEvaluatorNodeTestData.class);
			
			evaluate(data);
		}
	}
	
    public void evaluate(final TermEvaluatorNodeTestData data) {
        final TermEvaluatorNode termEvaluatorNode = new TermEvaluatorNode(data.getConditionExpressions());
        final ChangeSet resultChangeSet = termEvaluatorNode.update(data.getChangeSet());

        assertTrue(resultChangeSet.equals(data.getExpectedResults()));
    }
  
}
