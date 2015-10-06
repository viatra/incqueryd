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

import org.eclipse.incquery.runtime.rete.recipes.InputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.junit.Assert;
import org.junit.Test;

import eu.mondo.driver.file.FileGraphDriverRead;
import eu.mondo.driver.graph.RDFGraphDriverRead;

public class InputNodeTest {

	static final String DATABASE_URL = InputNodeTest.class.getClassLoader().getResource("models/railway-xform-1.ttl").toString();

	private final RDFGraphDriverRead driver = new FileGraphDriverRead(InputNodeTest.DATABASE_URL);
	
	@Test
	public void testEdge() throws IOException {
		InputRecipe recipe = RecipesFactory.eINSTANCE.createInputRecipe();
		recipe.setKeyArity(2);
		recipe.setKeyID(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.TRACKELEMENT_SENSOR);
		recipe.setTraceInfo("edge");

		InputNode typeInputNode = new InputNode(recipe);
		typeInputNode.load(driver);
		Set<Tuple> tuples = typeInputNode.getTuples();
		
		Assert.assertEquals(5772, tuples.size());
	}

	@Test
	public void testVertex() throws IOException {
		InputRecipe recipe = RecipesFactory.eINSTANCE.createInputRecipe();
		recipe.setKeyArity(1);
		recipe.setKeyID(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.SWITCH);

		InputNode typeInputNode = new InputNode(recipe);
		typeInputNode.load(driver);
		Set<Tuple> tuples = typeInputNode.getTuples();
	
		Assert.assertEquals(217, tuples.size());
	}

	@Test
	public void testProperty() throws IOException {
		InputRecipe recipe = RecipesFactory.eINSTANCE.createInputRecipe();
		recipe.setKeyArity(2);
		recipe.setKeyID(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.SEGMENT_LENGTH);
		recipe.setTraceInfo("attribute");

		InputNode typeInputNode = new InputNode(recipe);
		typeInputNode.load(driver);
		Set<Tuple> tuples = typeInputNode.getTuples();
		
		Assert.assertEquals(4835, tuples.size());
	}

}
