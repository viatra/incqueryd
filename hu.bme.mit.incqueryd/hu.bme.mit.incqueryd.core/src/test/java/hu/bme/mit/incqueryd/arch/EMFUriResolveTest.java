package hu.bme.mit.incqueryd.arch;

import static org.junit.Assert.assertEquals;

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
