package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertTrue;
import hu.bme.mit.incqueryd.cache.DistributedCache;
import hu.bme.mit.incqueryd.cache.local.LocalCache;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.nodes.data.BetaNodeTestData;
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
 * Test cases for the {@link AntiJoinNode} class.
 *
 * @author szarnyasg
 *
 */
public class AntiJoinNodeTest {

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		File[] files = TestCaseFinder.getTestCases("betanode-*.json");

		for (File file : files) {
			System.out.println(file);
			Gson gson = GsonParser.getGsonParser();
			BetaNodeTestData data = gson.fromJson(new FileReader(file), BetaNodeTestData.class);
			antiJoin(data);
		}
	}

	public void antiJoin(final BetaNodeTestData data) {
		DistributedCache cache = new LocalCache();
		final AntiJoinNode joinNode = new AntiJoinNode(data.getPrimaryMask(), data.getSecondaryMask(), cache);
		final ChangeSet resultChangeSet = Algorithms.join(joinNode, data.getPrimaryChangeSet(),
				data.getSecondaryChangeSet());
		assertTrue(resultChangeSet.equals(data.getAntiJoinExpectedResults()));
	}

}
