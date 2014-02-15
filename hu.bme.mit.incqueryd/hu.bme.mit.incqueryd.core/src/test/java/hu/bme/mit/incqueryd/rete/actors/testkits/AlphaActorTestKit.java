package hu.bme.mit.incqueryd.rete.actors.testkits;

import hu.bme.mit.incqueryd.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.rete.nodes.data.AlphaTestData;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;
import hu.bme.mit.incqueryd.util.ReteNodeType;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;

/** @formatter:off
 * 
 * Test plan
 * ---------
 * 
 *                                      (parentActor)
 *                                            ^
 *                                            |
 *                                            | (5) V
 *                                            | (8) ^
 *                                            |
 *                                            V
 *  (coordinatorActor) <--------------> (alphaActor)
 *                           (1) >            ^
 *                           (2) <            |
 *                                            | (3) ^   (6) V
 *                                            | (4) V   (7) ^
 *                                            |
 *                                            V
 *                                      (targetActor) 
 * 
 * 
 *  (1) ! ReteNodeConfiguration
 *  (2) ? CONFIGURATION_RECEIVED
 *  
 *  (3) ! SUBSCRIBE_SINGLE
 *  (4) ? SUBSCRIBED
 *  
 *  (5) ! UpdateMessage, stack: [testKit] 
 *  (6) ? UpdateMessage, stack: [testKit, alphaActor]
 *  (7) ! ReadyMessage, stack: [testKit]
 *  (8) ? ReadyMessage, stack: []
 * 
 * Legend:
 *  - [!] sent by the test framework, [?] expected by the test framework
 *  - the stack is represented according to the immutable.Stack Scala class' toString() method: 
 *    the top item in the stack is the _first_ in the list (unlike the java.util.Stack class' toString()) 
 *
 */
public class AlphaActorTestKit extends ReteActorTestKit {
	
	protected final ActorSystem system;
	
	public AlphaActorTestKit(final ActorSystem system) throws IOException {
		super(system);
		this.system = system;
	}
	
	public void test(final ReteNodeType type, final String recipeFile, final AlphaTestData data) throws IOException {
		// Arrange
		final Props props = new Props(ReteActor.class);
		final ActorRef alphaActor = system.actorOf(props);
		final JavaTestKit coordinatorActor = new JavaTestKit(system);
		final JavaTestKit parentActor = new JavaTestKit(system);
		final JavaTestKit targetActor = new JavaTestKit(system);
		final String jsonRecipe = FileUtils.readFileToString(new File(recipeFile));
		final ReteNodeConfiguration conf = new ReteNodeConfiguration(type, jsonRecipe);		

		// Act and Assert		
		configure(coordinatorActor, alphaActor, conf);
		subscribe(targetActor, alphaActor);
		testComputation(parentActor, alphaActor, targetActor, data.getIncomingChangeSet(), data.getExpectedChangeSet());
	}

}
