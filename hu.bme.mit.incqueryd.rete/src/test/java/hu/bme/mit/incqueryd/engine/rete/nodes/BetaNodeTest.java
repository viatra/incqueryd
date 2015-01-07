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
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.engine.rete.nodes.BetaNode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public abstract class BetaNodeTest {

	protected String filePrefix;

	public BetaNodeTest(final String nodeType) {
		filePrefix = nodeType.toLowerCase();
	}

	@Test
	public void test() throws JsonSyntaxException, JsonIOException, IOException {
		final File[] files = TestCaseFinder.getTestCases(filePrefix + "-new-test-*.json");

		for (final File testFile : files) {
			final Gson gson = GsonParser.getGsonParser();
			
			final TestData data = gson.fromJson(new FileReader(testFile), TestData.class);
			
			if(data.getChanges().size() != data.getExpectedChangeSets().size()){
				throw new RuntimeException("You have to provide expected change sets for all the test change sets!");
			}
			
			final String recipeFile = testFile.getPath().replace("-new-test-", "-new-recipe-");
			final BetaNode node = createBetaNode(recipeFile);
			
			final Set<Tuple> p = data.getPrimarySet();
			update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);
			
			final Set<Tuple> s = data.getSecondarySet();
			update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

			for(int i = 0; i < data.getChanges().size(); i++){
				
				final Change change = data.getChanges().get(i);
				final ChangeSet actualChangeSet = update(node, change.getChangeSet().getTuples(), change.getChangeSet().getChangeType(), change.getChangeSlot());
				final ChangeSet expectedChangeSet = data.getExpectedChangeSets().get(i);
				assertEquals(expectedChangeSet, actualChangeSet);
			}
			
		}
	}

	protected abstract BetaNode createBetaNode(String recipeFile) throws IOException;

	protected ProjectionIndexerRecipe createProjectionIndexer(final Collection<? extends Integer> mask) {
		final Mask leftMask = RecipesFactory.eINSTANCE.createMask();
		leftMask.setSourceArity(mask.size());
		leftMask.getSourceIndices().addAll(mask);
		final ProjectionIndexerRecipe leftParent = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		leftParent.setMask(leftMask);
		return leftParent;
	}

	private ChangeSet update(final BetaNode node, final Set<Tuple> tuples, final ChangeType changeType,
			final ReteNodeSlot reteNodeSlot) {
		final ChangeSet incomingChangeSet1 = new ChangeSet(tuples, changeType);
		final ChangeSet propagatedChangeSet = node.update(incomingChangeSet1, reteNodeSlot);

		System.out.println(propagatedChangeSet);
		return propagatedChangeSet;
	}

}
