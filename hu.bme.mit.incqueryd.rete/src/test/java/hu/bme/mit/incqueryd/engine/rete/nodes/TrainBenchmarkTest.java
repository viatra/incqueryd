package hu.bme.mit.incqueryd.engine.rete.nodes;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import javax.swing.text.html.CSS;

import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class TrainBenchmarkTest {

	protected ProjectionIndexerRecipe createProjectionIndexer(final Collection<? extends Integer> mask) {
		final Mask eMask = RecipesFactory.eINSTANCE.createMask();
		eMask.setSourceArity(mask.size());
		eMask.getSourceIndices().addAll(mask);
		final ProjectionIndexerRecipe indexer = RecipesFactory.eINSTANCE.createProjectionIndexerRecipe();
		indexer.setMask(eMask);
		return indexer;
	}

	@Test
	public void routeSensorTest() throws IOException {
		// input nodes
		ChangeSet switchPositionChangeSet = createEdgeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.SWITCHPOSITION_SWITCH);
		ChangeSet routeSwitchPositionChangeSet = createEdgeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.ROUTE_SWITCHPOSITION);
		ChangeSet trackElementSensorChangeSet = createEdgeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.TRACKELEMENT_SENSOR);
		ChangeSet routeRouteDefinitionChangeSet = createEdgeInputNode(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.ROUTE_ROUTEDEFINITION);

		// join node: <SwP, Sw, R>
		JoinRecipe joinRecipe1 = RecipesFactory.eINSTANCE.createJoinRecipe();
		joinRecipe1.setLeftParent(createProjectionIndexer(ImmutableList.of(0)));
		joinRecipe1.setRightParent(createProjectionIndexer(ImmutableList.of(1)));
		JoinNode joinNode1 = new JoinNode(joinRecipe1);

		// join node: <SwP, Sw, R, Sen>
		JoinRecipe joinRecipe2 = RecipesFactory.eINSTANCE.createJoinRecipe();
		joinRecipe2.setLeftParent(createProjectionIndexer(ImmutableList.of(1)));
		joinRecipe2.setRightParent(createProjectionIndexer(ImmutableList.of(0)));
		JoinNode joinNode2 = new JoinNode(joinRecipe2);

		// antijoin node: <SwP, Sw, R, Sen>
		AntiJoinRecipe antiJoinRecipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		antiJoinRecipe.setLeftParent(createProjectionIndexer(ImmutableList.of(2, 3)));
		antiJoinRecipe.setRightParent(createProjectionIndexer(ImmutableList.of(0, 1)));
		AntiJoinNode antiJoinNode = new AntiJoinNode(antiJoinRecipe);

		// trimmer node: <R>
		TrimmerRecipe trimmerRecipe = RecipesFactory.eINSTANCE.createTrimmerRecipe();
		Mask mask = RecipesFactory.eINSTANCE.createMask();
		mask.getSourceIndices().addAll(ImmutableList.of(3));
		trimmerRecipe.setMask(mask);
		TrimmerNode trimmerNode = new TrimmerNode(trimmerRecipe);
		
		// sending the changesets
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
		System.out.println(cs7);
		
		Assert.assertEquals(94, cs7.size());
	}

	@Test
	public void switchSensorTest() throws IOException {
		// input node for switch vertices
		UnaryInputRecipe switchRecipe = RecipesFactory.eINSTANCE.createUnaryInputRecipe();
		switchRecipe.setTypeName(TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.SWITCH);
		TypeInputNode switchInputNode = new TypeInputNode(switchRecipe);
		switchInputNode.load();
		ChangeSet switchChangeSet = switchInputNode.getChangeSet();
		
		// input node for trackElement_sensor edges
		String type = TrainBenchmarkConstants.TRAINBENCHMARK_BASE + TrainBenchmarkConstants.TRACKELEMENT_SENSOR;
		ChangeSet trackElementSensorChangeSet = createEdgeInputNode(type);

		// antijoin node
		AntiJoinRecipe antiJoinRecipe = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
		ProjectionIndexerRecipe leftProjectionIndexer = createProjectionIndexer(ImmutableList.of(0));
		ProjectionIndexerRecipe rightProjectionIndexer = createProjectionIndexer(ImmutableList.of(0));
		antiJoinRecipe.setLeftParent(leftProjectionIndexer);
		antiJoinRecipe.setRightParent(rightProjectionIndexer);
		AntiJoinNode antiJoinNode = new AntiJoinNode(antiJoinRecipe);

		// sending the changesets
		// secondary changeset
		ChangeSet cs1 = antiJoinNode.update(trackElementSensorChangeSet, ReteNodeSlot.SECONDARY);

		// primary changeset
		ChangeSet cs2 = antiJoinNode.update(switchChangeSet, ReteNodeSlot.PRIMARY);

		Assert.assertEquals(19, cs2.size());
	}

	private ChangeSet createEdgeInputNode(String type) throws IOException {
		BinaryInputRecipe trackElementSensorRecipe = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
		trackElementSensorRecipe.setTypeName(type);
		trackElementSensorRecipe.setTraceInfo("edge");
		TypeInputNode trackElementSensorInputNode = new TypeInputNode(trackElementSensorRecipe);
		trackElementSensorInputNode.load();
		ChangeSet trackElementSensorChangeSet = trackElementSensorInputNode.getChangeSet();
		return trackElementSensorChangeSet;
	}

}
