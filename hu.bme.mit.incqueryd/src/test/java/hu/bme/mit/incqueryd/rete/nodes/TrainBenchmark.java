package hu.bme.mit.incqueryd.rete.nodes;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.io.GraphSonFormat;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

/**
 * Test cases for the TrainBenchmark queries. The queries are evaluated on an instance model serialized in Faunus GraphSON format. For details, see the
 * TrainBenchmark website: http://incquery.net/publications/trainbenchmark
 * 
 * See the private wiki for reference output values: https://trac.inf.mit.bme.hu/Ontology/wiki/TrainBenchmark/TBResultFormat
 * 
 * @author szarnyasg
 * 
 */
public class TrainBenchmark {

	// vertex types
	protected final String Switch = "Switch";
	protected final String Segment = "Segment";

	// edge labels
	protected final String Route_routeDefinition = "Route_routeDefinition";
	protected final String Route_switchPosition = "Route_switchPosition";
	protected final String SwitchPosition_switch = "SwitchPosition_switch";
	protected final String TrackElement_sensor = "TrackElement_sensor";

	protected final int size = 1;
	protected final String pathName = "src/test/resources/testBig_User_" + size + ".faunus-graphson";

	protected final boolean logResults = false;
	protected final boolean logMessages = false;

	final Map<String, Collection<Tuple>> vertexTuplesMap = new HashMap<>();
	final Map<String, Collection<Tuple>> edgeTuplesMap = new HashMap<>();

	private void load(final Collection<String> vertexTypes, final Collection<String> edgeLabels) throws IOException {
		final Multimap<String, Object> vertexTypeVertexIdsMap = ArrayListMultimap.create();
		final Map<Object, Map<String, Object>> vertexIdVertexPropertiesMap = new HashMap<>();
		final Map<String, Multimap<Object, Object>> edgeLabelVertexPairsMap = new HashMap<>();

		logMessage("Loading...");

		// collect the edges from the Faunus GraphSON file in one run
		startTimer();
		GraphSonFormat.indexGraph(pathName, vertexTypes, vertexTypeVertexIdsMap, vertexIdVertexPropertiesMap, edgeLabels, edgeLabelVertexPairsMap);

		// converting the vertices to tuples
		for (final String vertexType : vertexTypeVertexIdsMap.keySet()) {
			final Collection<Object> verticesId = vertexTypeVertexIdsMap.get(vertexType);
			final Collection<Tuple> tuples = new HashSet<>();

			for (final Object vertexId : verticesId) {
				final Tuple tuple = new TupleImpl(vertexId);
				tuples.add(tuple);
			}
			vertexTuplesMap.put(vertexType, tuples);
		}

		// converting the edges to tuples
		for (final Entry<String, Multimap<Object, Object>> entry : edgeLabelVertexPairsMap.entrySet()) {
			final String edgeLabel = entry.getKey();
			final Multimap<Object, Object> edges = entry.getValue();

			final Collection<Tuple> tuples = new HashSet<>();
			edgeTuplesMap.put(edgeLabel, tuples);

			for (final Object v1 : edges.keySet()) {
				final Collection<Object> v2s = edges.get(v1);

				logResult(v1 + ": " + v2s);
				for (final Object v2 : v2s) {
					final Tuple tuple = new TupleImpl(v1, v2);
					tuples.add(tuple);
					logResult(tuple.toString());
				}
			}
		}

		System.out.print("loaded, ");
		restartTimer();
	}

	@Test
	public void posLength() throws IOException {
		
	}

	@Test
	public void routeSensor() throws IOException {
		logMessage("RouteSensor query");
		final Collection<String> vertexTypes = ImmutableList.of();
		final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_switchPosition, SwitchPosition_switch, TrackElement_sensor);
		load(vertexTypes, edgeLabels);

		final Collection<Tuple> route_routeDefinitionTuples = edgeTuplesMap.get(Route_routeDefinition); // Route, Sensor
		final Collection<Tuple> route_switchPositionTuples = edgeTuplesMap.get(Route_switchPosition); // Route, SwitchPosition
		final Collection<Tuple> switchPosition_switchTuples = edgeTuplesMap.get(SwitchPosition_switch); // SwitchPosition, Switch
		final Collection<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch, Sensor

		logMessage("Route_switchPosition JOIN SwitchPosition_switch");
		logMessage("<Route, SwitchPosition, Switch>");
		final TupleMask leftMask1 = new TupleMask(ImmutableList.of(1));
		final TupleMask rightMask1 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode1 = new JoinNode(leftMask1, rightMask1);
		final ChangeSet resultChangeSet1 = Algorithms.join(joinNode1, route_switchPositionTuples, switchPosition_switchTuples);
		logResult(resultChangeSet1.getTuples().toString());
		logMessage(resultChangeSet1.getTuples().size() + " tuples");

		logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor");
		logMessage("<Route, SwitchPosition, Switch, Sensor>");
		final TupleMask leftMask2 = new TupleMask(ImmutableList.of(2));
		final TupleMask rightMask2 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode2 = new JoinNode(leftMask2, rightMask2);
		final ChangeSet resultChangeSet2 = Algorithms.join(joinNode2, resultChangeSet1.getTuples(), trackElement_sensorTuples);
		logResult(resultChangeSet2.getTuples().toString());
		logMessage(resultChangeSet2.getTuples().size() + " tuples");

		logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor JOIN Route_routeDefinition");
		logMessage("<Route, SwitchPosition, Switch, Sensor, Route>");
		final TupleMask leftMask3 = new TupleMask(ImmutableList.of(3));
		final TupleMask rightMask3 = new TupleMask(ImmutableList.of(1));
		final AntiJoinNode joinNode3 = new AntiJoinNode(leftMask3, rightMask3);
		final ChangeSet resultChangeSet3 = Algorithms.join(joinNode3, resultChangeSet2.getTuples(), route_routeDefinitionTuples);
		logResult(resultChangeSet3.getTuples().toString());
		logMessage(resultChangeSet3.getTuples().size() + " tuples");
		logBenchmark(resultChangeSet3.getTuples().size() + " tuples");

		assertEquals(resultChangeSet3.getTuples().size(), 19);
	}

	@Test
	public void signalNeighbor() throws IOException {
	}
	
	@Test
	public void switchSensor() throws IOException {
		logMessage("SwitchSensor query");
		final Collection<String> vertexTypes = ImmutableList.of(Switch);
		final Collection<String> edgeLabels = ImmutableList.of(TrackElement_sensor);
		load(vertexTypes, edgeLabels);

		final Collection<Tuple> switchTuples = vertexTuplesMap.get(Switch);
		final Collection<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch, Sensor

		logMessage("Route_switchPosition JOIN SwitchPosition_switch");
		logMessage("<Route, SwitchPosition, Switch>");
		final TupleMask leftMask = new TupleMask(ImmutableList.of(0));
		final TupleMask rightMask = new TupleMask(ImmutableList.of(0));
		final AntiJoinNode anitJoinNode = new AntiJoinNode(leftMask, rightMask);
		final ChangeSet resultChangeSet = Algorithms.join(anitJoinNode, switchTuples, trackElement_sensorTuples);
		logResult(resultChangeSet.getTuples().toString());
		logBenchmark(resultChangeSet.getTuples().size() + " tuples");

		assertEquals(resultChangeSet.getTuples().size(), 26);
	}

	private long startTime;

	private void startTimer() {
		logMessage("(Re)starting timer");
		startTime = System.nanoTime();
	}

	private void restartTimer() {
		final long stopTime = System.nanoTime();
		final long deltaTime = stopTime - startTime;
		final long deltaTimeMs = deltaTime / 1000000;
		// logBenchmark("Time elapsed: ");
		logBenchmark("time [ms]: " + deltaTimeMs);
		startTimer();
	}

	private void logMessage() {
		logMessage("");
	}

	private void logMessage(final String message) {
		if (logMessages) {
			System.out.println(message);
		}
	}

	private void logResult(final String message) {
		if (logResults) {
			System.out.println(message);
		}
	}

	private void logBenchmark(final String message) {
		System.out.println(message);
	}

}