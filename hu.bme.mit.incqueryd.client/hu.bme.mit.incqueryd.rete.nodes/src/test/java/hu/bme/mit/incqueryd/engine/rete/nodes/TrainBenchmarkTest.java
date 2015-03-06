package hu.bme.mit.incqueryd.engine.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExpressionDefinition;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class TrainBenchmarkTest {

	@Test
	public void posLengthTest() throws IOException {
		// arrange
		// input nodes
		TypeInputNode segmentLengthInputNode = createAttributeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE
				+ TrainBenchmarkConstants.SEGMENT_LENGTH);

		CheckRecipe recipe = createCheckNode("SegmentLength <= 0", ImmutableMap.of("SegmentLength", 1));
		CheckNode node = new CheckNode(recipe);

		// act
		segmentLengthInputNode.load();
		ChangeSet segmentLengthChangeSet = segmentLengthInputNode.getChangeSet();
		ChangeSet cs = node.update(segmentLengthChangeSet);

		// assert
		assertEquals(470, cs.size());
	}

	@Test
	public void routeSensorTest() throws IOException {
		// arrange
		// input nodes
		TypeInputNode switchPositionNode = createEdgeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE
				+ TrainBenchmarkConstants.SWITCHPOSITION_SWITCH);
		TypeInputNode routeSwitchPositionNode = createEdgeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE
				+ TrainBenchmarkConstants.ROUTE_SWITCHPOSITION);
		TypeInputNode trackElementSensorNode = createEdgeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE
				+ TrainBenchmarkConstants.TRACKELEMENT_SENSOR);
		TypeInputNode routeRouteDefinitionNode = createEdgeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE
				+ TrainBenchmarkConstants.ROUTE_ROUTEDEFINITION);

		// join node: <SwP, Sw, R>
		JoinNode joinNode1 = createJoinNode(ImmutableList.of(0), ImmutableList.of(1));

		// antijoin node: <SwP, Sw, R, Sen>
		JoinNode joinNode2 = createJoinNode(ImmutableList.of(1), ImmutableList.of(0));

		// antijoin node: <SwP, Sw, R, Sen>
		AntiJoinNode antiJoinNode = createAntiJoinNode(ImmutableList.of(2, 3), ImmutableList.of(0, 1));

		// trimmer node: <R>
		TrimmerNode trimmerNode = createTrimmerNode(ImmutableList.of(3));

		// act
		switchPositionNode.load();
		routeSwitchPositionNode.load();
		trackElementSensorNode.load();
		routeRouteDefinitionNode.load();

		ChangeSet switchPositionChangeSet = switchPositionNode.getChangeSet();
		ChangeSet routeSwitchPositionChangeSet = routeSwitchPositionNode.getChangeSet();
		ChangeSet trackElementSensorChangeSet = trackElementSensorNode.getChangeSet();
		ChangeSet routeRouteDefinitionChangeSet = routeRouteDefinitionNode.getChangeSet();

		// joinNode1
		ChangeSet cs1 = joinNode1.update(switchPositionChangeSet, ReteNodeSlot.PRIMARY); // empty
		ChangeSet cs2 = joinNode1.update(routeSwitchPositionChangeSet, ReteNodeSlot.SECONDARY);

		// joinNode2
		ChangeSet cs3 = joinNode2.update(cs2, ReteNodeSlot.PRIMARY); // empty
		ChangeSet cs4 = joinNode2.update(trackElementSensorChangeSet, ReteNodeSlot.SECONDARY);

		// antiJoin
		ChangeSet cs5 = antiJoinNode.update(routeRouteDefinitionChangeSet, ReteNodeSlot.SECONDARY); // empty
		ChangeSet cs6 = antiJoinNode.update(cs4, ReteNodeSlot.PRIMARY);

		// trimmer
		ChangeSet cs7 = trimmerNode.update(cs6);

		// assert
		assertEquals(94, cs7.size());
	}

	@Test
	public void switchSensorTest() throws IOException {
		// arrange
		// input node for switch vertices
		TypeInputNode switchInputNode = createVertexInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.SWITCH);

		// input node for trackElement_sensor edges
		String type = TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.TRACKELEMENT_SENSOR;
		TypeInputNode trackElementSensorNode = createEdgeInputNode(type);

		// antijoin node
		AntiJoinRecipe antiJoinRecipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		ProjectionIndexerRecipe leftProjectionIndexer = createProjectionIndexer(ImmutableList.of(0));
		ProjectionIndexerRecipe rightProjectionIndexer = createProjectionIndexer(ImmutableList.of(0));
		antiJoinRecipe.setLeftParent(leftProjectionIndexer);
		antiJoinRecipe.setRightParent(rightProjectionIndexer);
		AntiJoinNode antiJoinNode = new AntiJoinNode(antiJoinRecipe);

		// act
		switchInputNode.load();
		ChangeSet switchChangeSet = switchInputNode.getChangeSet();
		trackElementSensorNode.load();
		ChangeSet trackElementSensorChangeSet = trackElementSensorNode.getChangeSet();

		// secondary changeset
		ChangeSet cs1 = antiJoinNode.update(trackElementSensorChangeSet, ReteNodeSlot.SECONDARY);

		// primary changeset
		ChangeSet cs2 = antiJoinNode.update(switchChangeSet, ReteNodeSlot.PRIMARY);

		// assert
		assertEquals(19, cs2.size());
	}

	private TypeInputNode createVertexInputNode(String typeName) {
		UnaryInputRecipe recipe = RecipesFactory.eINSTANCE.createUnaryInputRecipe();
		recipe.setTypeName(typeName);
		TypeInputNode node = new TypeInputNode(recipe, TypeInputNodeTest.DATABASE_URL);
		return node;
	}

	private TrimmerNode createTrimmerNode(ImmutableList<Integer> mask) {
		TrimmerRecipe recipe = RecipesFactory.eINSTANCE.createTrimmerRecipe();
		Mask eMask = RecipesFactory.eINSTANCE.createMask();
		eMask.getSourceIndices().addAll(mask);
		recipe.setMask(eMask);
		TrimmerNode node = new TrimmerNode(recipe);
		return node;
	}

	protected ProjectionIndexerRecipe createProjectionIndexer(final Collection<? extends Integer> mask) {
		final Mask eMask = RecipesFactory.eINSTANCE.createMask();
		eMask.setSourceArity(mask.size());
		eMask.getSourceIndices().addAll(mask);
		final ProjectionIndexerRecipe indexer = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		indexer.setMask(eMask);
		return indexer;
	}

	private AntiJoinNode createAntiJoinNode(ImmutableList<Integer> primaryMask, ImmutableList<Integer> secondaryMask) {
		AntiJoinRecipe recipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		recipe.setLeftParent(createProjectionIndexer(primaryMask));
		recipe.setRightParent(createProjectionIndexer(secondaryMask));
		AntiJoinNode node = new AntiJoinNode(recipe);
		return node;
	}

	private JoinNode createJoinNode(ImmutableList<Integer> primaryMask, ImmutableList<Integer> secondaryMask) {
		JoinRecipe recipe = RecipesFactory.eINSTANCE.createJoinRecipe();
		recipe.setLeftParent(createProjectionIndexer(primaryMask));
		recipe.setRightParent(createProjectionIndexer(secondaryMask));
		JoinNode node = new JoinNode(recipe);
		return node;
	}

	private TypeInputNode createEdgeInputNode(String type) throws IOException {
		BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		recipe.setTypeName(type);
		recipe.setTraceInfo("edge");
		TypeInputNode node = new TypeInputNode(recipe, TypeInputNodeTest.DATABASE_URL);
		return node;
	}

	private CheckRecipe createCheckNode(String conditionExpression, Map<String, Integer> mappedIndices) {
		CheckRecipe recipe = RecipesFactory.eINSTANCE.createCheckRecipe();
		// expression definition
		ExpressionDefinition expression = RecipesFactory.eINSTANCE.createExpressionDefinition();
		Object[] evaluator = { conditionExpression };
		expression.setEvaluator(evaluator);
		recipe.setExpression(expression);
		// mapped indices
		recipe.getMappedIndices().putAll(mappedIndices);
		
		return recipe;
	}

	private TypeInputNode createAttributeInputNode(String type) {
		BinaryInputRecipe recipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		recipe.setTypeName(type);
		recipe.setTraceInfo("attribute");
		TypeInputNode node = new TypeInputNode(recipe, TypeInputNodeTest.DATABASE_URL);
		return node;
	}

}
