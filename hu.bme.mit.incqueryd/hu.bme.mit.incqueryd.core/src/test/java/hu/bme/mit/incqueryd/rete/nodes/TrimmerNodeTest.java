package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.TrimmerNodeTestData;
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
 * Test cases for the {@link TrimmerNode} class.
 * 
 * @author szarnyasg
 *
 */
public class TrimmerNodeTest {

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		final File[] files = TestCaseFinder.getTestCases("trimmernode-*.json");

		for (final File file : files) {
			System.out.println(file);
			final Gson gson = GsonParser.getGsonParser();
			final TrimmerNodeTestData data = gson.fromJson(new FileReader(file), TrimmerNodeTestData.class);
			
			trim(data);
		}
	}
	
    public void trim(final TrimmerNodeTestData data) {
    	final TrimmerNodeConfiguration configuration = new TrimmerNodeConfiguration(data.getProjectionMask());
    	
        final TrimmerNode trimmerNode = new TrimmerNode(configuration);
        final ChangeSet resultChangeSet = trimmerNode.update(data.getChangeSet());
        assertTrue(resultChangeSet.equals(data.getExpectedResults()));
    }

}
