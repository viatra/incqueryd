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
package hu.bme.mit.incqueryd.engine.arch;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.arch.util.ArchUtil;

import org.junit.Test;

public class EMFUriResolveTest {

	@Test
	public void test() {
		final String traceInfo = "UniquenessEnforcerNode : TrackElement_sensor :  [0]";
		assertEquals("TrackElement_sensor", ArchUtil.extractType(traceInfo));
	}

	@Test
	public void testRelativeResolve() {
		final String emfUri = 
				"/tmp/recipe-2598314555665286111.json#../hu.bme.mit.incqueryd.recipeinstances/src/test/resources/arch/routeSensor.arch#//@reteRecipes.0/@recipeNodes.5";
		assertEquals(
				"../hu.bme.mit.incqueryd.recipeinstances/src/test/resources/arch/routeSensor.arch#//@reteRecipes.0/@recipeNodes.5",
				ArchUtil.cutProxyName(emfUri));
	}
}
