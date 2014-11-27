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
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.engine.rete.nodes.AntiJoinNode;
import hu.bme.mit.incqueryd.engine.rete.nodes.BetaNode;
import hu.bme.mit.incqueryd.engine.util.RecipeDeserializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Test;


/**
 * Test cases for the {@link AntiJoinNode} class.
 * 
 * @author szarnyasg
 * 
 */
public class AntiJoinNodeTest extends BetaNodeTest {

	public AntiJoinNodeTest() {
		super("AntiJoin");
	}

	@Override
	protected BetaNode createBetaNode(final String recipeFile) throws IOException {
		final AntiJoinRecipe recipe = (AntiJoinRecipe) (RecipeDeserializer.deserializeFromFile(recipeFile));
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());
		return node;
	}

	@Test
	public void antiJoinDeltaTest1() {
		System.out.println("Test 1");
		final AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		final ProjectionIndexerRecipe leftParent = createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexerRecipe rightParent = createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());

		final Set<Tuple> p = new HashSet<>();
		p.add(new Tuple(1, 2));
		p.add(new Tuple(1, 3));
		update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);

		final Set<Tuple> s = new HashSet<>();
		s.add(new Tuple(2, 5));
		update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

		
		final Set<Tuple> deltaP = new HashSet<>();
		deltaP.add(new Tuple(6, 2));
		final ChangeSet actualChangeSet = update(node, deltaP, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);
		
		final HashSet<Tuple> expectedTuples = new HashSet<>();
		final ChangeSet expectedChangeSet = new ChangeSet(expectedTuples, ChangeType.POSITIVE);
		assertEquals(expectedChangeSet, actualChangeSet);
		
		System.out.println();
	}
	
	@Test
	public void antiJoinDeltaTest2() {
		System.out.println("Test 2");
		final AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		final ProjectionIndexerRecipe leftParent = createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexerRecipe rightParent = createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());

		final Set<Tuple> p = new HashSet<>();
		p.add(new Tuple(1, 2));
		p.add(new Tuple(1, 3));
		update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);

		final Set<Tuple> s = new HashSet<>();
		s.add(new Tuple(2, 5));
		update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

		
		final Set<Tuple> deltaP = new HashSet<>();
		deltaP.add(new Tuple(6, 3));
		final ChangeSet actualChangeSet = update(node, deltaP, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);
		
		final HashSet<Tuple> expectedTuples = new HashSet<>();
		expectedTuples.add(new Tuple(6, 3));
		final ChangeSet expectedChangeSet = new ChangeSet(expectedTuples, ChangeType.POSITIVE);
		assertEquals(expectedChangeSet, actualChangeSet);
		
		System.out.println();
	}
	
	@Test
	public void antiJoinDeltaTest3() {
		System.out.println("Test 3");
		final AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		final ProjectionIndexerRecipe leftParent = createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexerRecipe rightParent = createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());

		final Set<Tuple> p = new HashSet<>();
		p.add(new Tuple(1, 2));
		p.add(new Tuple(3, 4));
		update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);


		final Set<Tuple> s = new HashSet<>();
		s.add(new Tuple(2, 3));
		s.add(new Tuple(2, 4));
		s.add(new Tuple(4, 5));
		update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

		
		final Set<Tuple> deltaS = new HashSet<>();
		s.add(new Tuple(2, 3));
		update(node, deltaS, ChangeType.NEGATIVE, ReteNodeSlot.SECONDARY);
		
		System.out.println();

	}
	

	@Test
	public void antiJoinDeltaTest4() {
		System.out.println("Test 4");
		final AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		final ProjectionIndexerRecipe leftParent = createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexerRecipe rightParent = createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());

		final Set<Tuple> p = new HashSet<>();
		p.add(new Tuple(1, 2));
		p.add(new Tuple(1, 3));
		update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);

		final Set<Tuple> s = new HashSet<>();
		s.add(new Tuple(2, 5));
		update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

		
		final Set<Tuple> deltaP = new HashSet<>();
		deltaP.add(new Tuple(1, 3));
		final ChangeSet actualChangeSet = update(node, deltaP, ChangeType.NEGATIVE, ReteNodeSlot.PRIMARY);
		
		final HashSet<Tuple> expectedTuples = new HashSet<>();
		expectedTuples.add(new Tuple(1, 3));
		final ChangeSet expectedChangeSet = new ChangeSet(expectedTuples, ChangeType.NEGATIVE);
		assertEquals(expectedChangeSet, actualChangeSet);
		
		System.out.println();
	}
	


	@Test
	public void antiJoinDeltaTest5() {
		System.out.println("Test 5");
		final AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		final ProjectionIndexerRecipe leftParent = createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexerRecipe rightParent = createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());

		final Set<Tuple> p = new HashSet<>();
		p.add(new Tuple(1, 2));
		p.add(new Tuple(1, 3));
		update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);

		final Set<Tuple> s = new HashSet<>();
		s.add(new Tuple(2, 5));
		update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

		
		final Set<Tuple> deltaP = new HashSet<>();
		deltaP.add(new Tuple(1, 2));
		final ChangeSet actualChangeSet = update(node, deltaP, ChangeType.NEGATIVE, ReteNodeSlot.PRIMARY);
		
		final HashSet<Tuple> expectedTuples = new HashSet<>();
		final ChangeSet expectedChangeSet = new ChangeSet(expectedTuples, ChangeType.NEGATIVE);
		assertEquals(expectedChangeSet, actualChangeSet);
		
		System.out.println();
	}
	

	@Test
	public void antiJoinDeltaTest6() {
		System.out.println("Test 6");
		final AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		final ProjectionIndexerRecipe leftParent = createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexerRecipe rightParent = createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());

		final Set<Tuple> p = new HashSet<>();
		p.add(new Tuple(1, 2));
		p.add(new Tuple(6, 2));
		update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);

		final Set<Tuple> s = new HashSet<>();
		update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

		
		final Set<Tuple> deltaP = new HashSet<>();
		deltaP.add(new Tuple(2, 9));
		final ChangeSet actualChangeSet = update(node, deltaP, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);
		
		final HashSet<Tuple> expectedTuples = new HashSet<>();
		expectedTuples.add(new Tuple(1, 2));
		expectedTuples.add(new Tuple(6, 2));
		final ChangeSet expectedChangeSet = new ChangeSet(expectedTuples, ChangeType.NEGATIVE);
		
		assertEquals(expectedChangeSet, actualChangeSet);
		
		System.out.println();
	}
	

	@Test
	public void antiJoinDeltaTest7() {
		System.out.println("Test 7");
		final AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		final ProjectionIndexerRecipe leftParent = createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexerRecipe rightParent = createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());

		final Set<Tuple> p = new HashSet<>();
		p.add(new Tuple(1, 2));
		p.add(new Tuple(3, 4));
		update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);

		final Set<Tuple> s = new HashSet<>();
		s.add(new Tuple(2, 3));
		s.add(new Tuple(2, 4));
		s.add(new Tuple(4, 5));
		update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

		
		final Set<Tuple> deltaP = new HashSet<>();
		deltaP.add(new Tuple(2, 3));
		final ChangeSet actualChangeSet = update(node, deltaP, ChangeType.NEGATIVE, ReteNodeSlot.SECONDARY);
		
		final HashSet<Tuple> expectedTuples = new HashSet<>();
		final ChangeSet expectedChangeSet = new ChangeSet(expectedTuples, ChangeType.POSITIVE);
		
		assertEquals(expectedChangeSet, actualChangeSet);
		
		System.out.println();
	}
	

	@Test
	public void antiJoinDeltaTest8() {
		System.out.println("Test 8");
		final AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		final ProjectionIndexerRecipe leftParent = createProjectionIndexer(Arrays.asList(1));
		recipe.setLeftParent(leftParent);
		final ProjectionIndexerRecipe rightParent = createProjectionIndexer(Arrays.asList(0));
		recipe.setRightParent(rightParent);
		final AntiJoinNode node = new AntiJoinNode(recipe, Collections.<String>emptyList());

		final Set<Tuple> p = new HashSet<>();
		p.add(new Tuple(1, 2));
		p.add(new Tuple(3, 4));
		update(node, p, ChangeType.POSITIVE, ReteNodeSlot.PRIMARY);

		final Set<Tuple> s = new HashSet<>();
		s.add(new Tuple(2, 3));
		s.add(new Tuple(2, 4));
		s.add(new Tuple(4, 5));
		update(node, s, ChangeType.POSITIVE, ReteNodeSlot.SECONDARY);

		
		final Set<Tuple> deltaP = new HashSet<>();
		deltaP.add(new Tuple(4, 5));
		final ChangeSet actualChangeSet = update(node, deltaP, ChangeType.NEGATIVE, ReteNodeSlot.SECONDARY);
		
		final HashSet<Tuple> expectedTuples = new HashSet<>();
		expectedTuples.add(new Tuple(3, 4));
		final ChangeSet expectedChangeSet = new ChangeSet(expectedTuples, ChangeType.POSITIVE);
		
		assertEquals(expectedChangeSet, actualChangeSet);
		
		System.out.println();
	}
	
	
	private ChangeSet update(final AntiJoinNode node, final Set<Tuple> tuples, final ChangeType changeType,
			final ReteNodeSlot reteNodeSlot) {
		final ChangeSet incomingChangeSet1 = new ChangeSet(tuples, changeType);
		final ChangeSet propagatedChangeSet = node.update(incomingChangeSet1, reteNodeSlot);

		System.out.println(propagatedChangeSet);
		return propagatedChangeSet;
	}

}
