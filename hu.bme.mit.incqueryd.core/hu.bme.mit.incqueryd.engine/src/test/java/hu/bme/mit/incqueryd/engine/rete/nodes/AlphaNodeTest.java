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
package hu.bme.mit.incqueryd.engine.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.engine.rete.nodes.data.Change;
import hu.bme.mit.incqueryd.engine.rete.nodes.data.TestData;
import hu.bme.mit.incqueryd.engine.test.util.GsonParser;
import hu.bme.mit.incqueryd.engine.test.util.TestCaseFinder;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.engine.rete.nodes.AlphaNode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Superclass for testing Rete Alpha nodes
 * 
 * @author makaij
 *
 */

public abstract class AlphaNodeTest {

	protected String filePrefix;

	public AlphaNodeTest(final String nodeType) {
		filePrefix = nodeType.toLowerCase();
	}
	
	@Test
	public void test() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases(filePrefix + "-new-test-*.json");

		for (final File testFile : files) {
			final String recipeFile = testFile.getPath().replace("-new-test-", "-recipe-");
			
			final Gson gson = GsonParser.getGsonParser();
			final TestData data = gson.fromJson(new FileReader(testFile), TestData.class);
			
			final AlphaNode node = createAlphaNode(recipeFile);
			
			if(data.getChanges().size() != data.getExpectedChangeSets().size()){
				throw new RuntimeException("You have to provide expected change sets for all the test change sets!");
			}
			
			final Set<Tuple> r = data.getPrimarySet();
			update(node, r, ChangeType.POSITIVE);
			
			for(int i = 0; i < data.getChanges().size(); i++){
				
				Change change = data.getChanges().get(i);
				final ChangeSet actualChangeSet = update(node, change.getChangeSet().getTuples(), change.getChangeSet().getChangeType());
				final ChangeSet expectedChangeSet = data.getExpectedChangeSets().get(i);
				assertEquals(expectedChangeSet, actualChangeSet);
			}
		}
	}
	
	protected abstract AlphaNode createAlphaNode(String recipeFile) throws IOException;
	
	private ChangeSet update(final AlphaNode node, final Set<Tuple> tuples, final ChangeType changeType) {
		final ChangeSet incomingChangeSet1 = new ChangeSet(tuples, changeType);
		final ChangeSet propagatedChangeSet = node.update(incomingChangeSet1);

		System.out.println(propagatedChangeSet);
		return propagatedChangeSet;
	}
}
