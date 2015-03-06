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

import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.io.IOException;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.junit.Assert;
import org.junit.Test;

public class TypeInputNodeTest {

	static final String DATABASE_URL = TypeInputNodeTest.class.getClassLoader().getResource("models/railway-xform-1.ttl").toString();

	@Test
	public void testEdge() throws IOException {
		BinaryInputRecipe recipe = RecipesFactory.eINSTANCE
				.createBinaryInputRecipe();
		recipe.setTypeName(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.TRACKELEMENT_SENSOR);
		recipe.setTraceInfo("edge");

		TypeInputNode typeInputNode = new TypeInputNode(recipe, DATABASE_URL);
		typeInputNode.load();
		Set<Tuple> tuples = typeInputNode.getTuples();
		
		Assert.assertEquals(5772, tuples.size());
	}

	@Test
	public void testVertex() throws IOException {
		UnaryInputRecipe recipe = RecipesFactory.eINSTANCE
				.createUnaryInputRecipe();
		recipe.setTypeName(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.SWITCH);

		TypeInputNode typeInputNode = new TypeInputNode(recipe, DATABASE_URL);
		typeInputNode.load();
		Set<Tuple> tuples = typeInputNode.getTuples();
	
		Assert.assertEquals(217, tuples.size());
	}

	@Test
	public void testProperty() throws IOException {
		BinaryInputRecipe recipe = RecipesFactory.eINSTANCE
				.createBinaryInputRecipe();
		recipe.setTypeName(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.SEGMENT_LENGTH);
		recipe.setTraceInfo("attribute");

		TypeInputNode typeInputNode = new TypeInputNode(recipe, DATABASE_URL);
		typeInputNode.load();
		Set<Tuple> tuples = typeInputNode.getTuples();
		
		Assert.assertEquals(4835, tuples.size());
	}

}
