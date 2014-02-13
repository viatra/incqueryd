//package hu.bme.mit.incqueryd.rete.actors;
//
//import hu.bme.mit.incqueryd.rete.nodes.data.FilterNodeTestData;
//import hu.bme.mit.incqueryd.rete.nodes.data.TrimmerNodeTestData;
//import hu.bme.mit.incqueryd.test.util.GsonParser;
//import hu.bme.mit.incqueryd.test.util.TestCaseFinder;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.List;
//
//import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
//import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
//import org.eclipse.incquery.runtime.rete.recipes.Mask;
//import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
//import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import akka.actor.ActorSystem;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonIOException;
//import com.google.gson.JsonSyntaxException;
//
///**
// * Test cases for the {@link TrimmerActor} class.
// * 
// * @author szarnyasg
// * 
// */
//public class TrimmerActorTest {
//
//	static ActorSystem system;
//
//	@BeforeClass
//	public static void setup() {
//		system = ActorSystem.create();
//	}
//
//	@AfterClass
//	public static void teardown() {
//		system.shutdown();
//	}
//
//	@Test
//	public void trimmerNodeTest() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
//		final File[] files = TestCaseFinder.getTestCases("" + "trimmernode-*.json");
//
//		for (final File file : files) {
//			System.out.println(file);
//			final Gson gson = GsonParser.getGsonParser();
//			final TrimmerNodeTestData data = gson.fromJson(new FileReader(file), TrimmerNodeTestData.class);
//
//			final List<Integer> sourceIndices = data.getSourceIndices();
//			final TrimmerRecipe recipe = RecipesFactory.eINSTANCE.createTrimmerRecipe();
//			final Mask mask = RecipesFactory.eINSTANCE.createMask();
//			mask.getSourceIndices().addAll(sourceIndices);
//			recipe.setMask(mask);
//
//			final AlphaActorTestKit testKit = new AlphaActorTestKit(system, recipe);
//			testKit.compute(data);
//		}
//	}
//
//	@Test
//	public void filterNodeTest() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
//		final File[] files = TestCaseFinder.getTestCases("filternode-*.json");
//
//		for (final File file : files) {
//			System.out.println(file);
//			final Gson gson = GsonParser.getGsonParser();
//			final FilterNodeTestData data = gson.fromJson(new FileReader(file), FilterNodeTestData.class);
//
//			// filterEquality(data);
//			// new AlphaActorTestKit(system);
//
//			final EqualityFilterRecipe equalityFilterRecipe = RecipesFactory.eINSTANCE.createEqualityFilterRecipe();
//			equalityFilterRecipe.getIndices().addAll(data.getTupleMask());
//
//			final InequalityFilterRecipe inequalityFilterRecipe = RecipesFactory.eINSTANCE.createInequalityFilterRecipe();
//			// set the subject
//			inequalityFilterRecipe.setSubject(data.getTupleMask().get(0));
//			// remove the head
//			data.getTupleMask().remove(0);
//			// get tha tail as inequals
//			inequalityFilterRecipe.getInequals().addAll(data.getTupleMask());
//		}
//	}
//
//}