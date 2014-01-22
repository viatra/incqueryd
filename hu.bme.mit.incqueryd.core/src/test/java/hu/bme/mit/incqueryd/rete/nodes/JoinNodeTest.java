package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.helpers.GsonParser;
import hu.bme.mit.incqueryd.rete.nodes.helpers.TestCaseFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link JoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class JoinNodeTest {

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		File[] files = TestCaseFinder.getTestCases("betanode-*.json");

		for (File file : files) {
			System.out.println(file);
			Gson gson = GsonParser.getGsonParser();
			BetaNodeTestData data = gson.fromJson(new FileReader(file), BetaNodeTestData.class);			
			join(data);
		}
	}

	public void join(final BetaNodeTestData data) {
		final JoinNode joinNode = new JoinNode(data.getPrimaryMask(), data.getSecondaryMask());
		final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryChangeSet(),
				data.getSecondaryChangeSet());
		assertTrue(resultChangeSet.equals(data.getJoinExpectedResults()));		
	}

	// @Test
	// public void test1() throws JsonParseException, JsonMappingException, IOException {
	// BetaNodeTestData data = BetaTestHelper.data1();
	//
	// @Test
	// public void test2() {
	// test(BetaTestHelper.data2());
	// }
	//
	// @Test
	// public void test3() {
	// test(BetaTestHelper.data3());
	// }

}
