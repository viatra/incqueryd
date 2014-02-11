package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;
import hu.bme.mit.incqueryd.rete.nodes.data.TrimmerNodeTestData;
import hu.bme.mit.incqueryd.test.util.GsonParser;
import hu.bme.mit.incqueryd.test.util.TestCaseFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorSystem;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Test cases for the {@link TrimmerActor} class.
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerActorTest {

	static ActorSystem system;

	@BeforeClass
	public static void setup() {
		system = ActorSystem.create();
	}

	@AfterClass
	public static void teardown() {
		system.shutdown();
	}

	/** @formatter:off
	 *                                        (testKit)
	 *                                            ^
	 *                                            |
	 *                                            | (5) V
	 *                                            | (8) ^
	 *                                            |
	 *                                            |
	 *                                            V
	 *  (coordinatorActor) <--------------> (trimmerActor)
	 *                           (1) >            ^
	 *                           (2) <            |
	 *                                            | (3) ^
	 *                                            | (4) V
	 *                                            |
	 *                                            | (6) V  
	 *                                            | (7) ^
	 *                                            |
	 *                                            V
	 *                                       (targetActor) 
	 * 
	 * 
	 * (1) ! TrimmerNodeConfiguration
	 * (2) ? CONFIGURATION_RECEIVED
	 * (3) ! SUBSCRIBE_SINGLE
	 * (4) ? SUBSCRIBED
	 * (5) ! UpdateMessage, stack: [testKit] 
	 * (6) ? UpdateMessage, stack: [testKit, trimmerActor]
	 * (7) ! ReadyMessage, stack: [testKit]
	 * (8) ? ReadyMessage, stack: []
	 * 
	 * Legend:
	 *  - [!] sent by the test framework, [?] expected by the test framework
	 *  - the stack is represented according to the immutable.Stack Scala class' toString() method: 
	 *    the top item in the stack is the _first_ in the list (unlike the java.util.Stack class' toString()) 
	 * 
	 * @param data
	 */
	@Test
	public void trimmerNodeTest() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		final File[] files = TestCaseFinder.getTestCases("" + "trimmernode-*.json");

		for (final File file : files) {
			System.out.println(file);
			final Gson gson = GsonParser.getGsonParser();
			final TrimmerNodeTestData data = gson.fromJson(new FileReader(file), TrimmerNodeTestData.class);

//			new AlphaActorTestKit(system, data);
		}
	}

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		final File[] files = TestCaseFinder.getTestCases("filternode-*.json");

		for (final File file : files) {
			System.out.println(file);
			final Gson gson = GsonParser.getGsonParser();
			final FilterNodeTestData data = gson.fromJson(new FileReader(file), FilterNodeTestData.class);

			//			filterEquality(data);
			new AlphaActorTestKit(system, data);
		}
	}

}