/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.rete.actors.testkits;

import hu.bme.mit.incqueryd.engine.rete.nodes.data.AlphaTestData;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;

import java.io.IOException;

import akka.actor.ActorSystem;
import akka.testkit.JavaTestKit;

// @formatter:off
/**
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
// @formatter:on
public class AlphaActorTestKit extends ReteActorTestKit {
	
	protected final JavaTestKit parentActor;
	
	public AlphaActorTestKit(final ActorSystem system, final String recipeFile) throws IOException {
		super(system, recipeFile);
		
		// alpha nodes have one parent
		parentActor = new JavaTestKit(system);
	}
	
	public void test(final AlphaTestData data) throws IOException {
		// Act and Assert		
		configure(coordinatorActor, reteActor, conf);
		subscribe(targetActor, reteActor);
		testComputation(parentActor, reteActor, targetActor, data.getIncomingChangeSet(), data.getExpectedChangeSet(), ReteNodeSlot.SINGLE);
	}

}
