package hu.bme.mit.incqueryd.rete.trainbenchmark;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.io.GraphSonFormat;
import hu.bme.mit.incqueryd.rete.comparison.ComparisonOperator;
import hu.bme.mit.incqueryd.rete.comparison.ConditionExpression;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.Algorithms;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;
import hu.bme.mit.incqueryd.rete.nodes.TermEvaluatorNode;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

	// property names
	protected final String Segment_length = "Segment_length";

	// edge labels
	protected final String Route_routeDefinition = "Route_routeDefinition";
	protected final String Route_switchPosition = "Route_switchPosition";
	protected final String SwitchPosition_switch = "SwitchPosition_switch";
	protected final String TrackElement_sensor = "TrackElement_sensor";
	protected final String TrackElement_connectsTo = "TrackElement_connectsTo";
	protected final String Route_entry = "Route_entry";
	protected final String Route_exit = "Route_exit";

	// file path
	protected final int size = 1;
	protected final String pathName = "src/test/resources/testBig_User_" + size + ".faunus-graphson";

	// logging constants
	protected final boolean logResults = true;
	protected final boolean logMessages = true;

	final Map<String, Set<Tuple>> vertexTuplesMap = new HashMap<>();
	final Map<String, Set<Tuple>> edgeTuplesMap = new HashMap<>();

	private void load(final Map<String, Collection<String>> vertexTypesAndProperties, final Collection<String> edgeLabels) throws IOException {
		final Multimap<String, Object> vertexTypeVertexIdsMap = ArrayListMultimap.create();
		final Map<Object, Map<String, Object>> vertexIdVertexPropertiesMap = new HashMap<>();
		final Map<String, Multimap<Object, Object>> edgeLabelVertexPairsMap = new HashMap<>();

		logMessage("Loading...");

		// collect the edges from the Faunus GraphSON file in one run
		startTimer();
		GraphSonFormat.indexGraph(pathName, vertexTypesAndProperties, vertexTypeVertexIdsMap, vertexIdVertexPropertiesMap, edgeLabels, edgeLabelVertexPairsMap);

		// converting the vertices to tuples
		// e.g. <id, Segment_length>
		for (final String vertexType : vertexTypeVertexIdsMap.keySet()) {
			final Collection<Object> verticesId = vertexTypeVertexIdsMap.get(vertexType);
			final Set<Tuple> tuples = new HashSet<>();

			for (final Object vertexId : verticesId) {
				final List<Object> tupleItems = new LinkedList<>();
				tupleItems.add(vertexId);

				final Collection<String> propertiesToExtract = vertexTypesAndProperties.get(vertexType);
				for (final String propertyName : propertiesToExtract) {
					final Object propertyValue = vertexIdVertexPropertiesMap.get(vertexId).get(propertyName);
					tupleItems.add(propertyValue);
				}

				final Tuple tuple = new TupleImpl(tupleItems.toArray());
				tuples.add(tuple);
			}

			vertexTuplesMap.put(vertexType, tuples);
		}

		// converting the edges to tuples
		for (final Entry<String, Multimap<Object, Object>> entry : edgeLabelVertexPairsMap.entrySet()) {
			final String edgeLabel = entry.getKey();
			final Multimap<Object, Object> edges = entry.getValue();

			final Set<Tuple> tuples = new HashSet<>();
			edgeTuplesMap.put(edgeLabel, tuples);

			System.out.println(edgeLabel);

			for (final Object v1 : edges.keySet()) {
				final Collection<Object> v2s = edges.get(v1);

				// logResult(v1 + ": " + v2s);
				for (final Object v2 : v2s) {
					final Tuple tuple = new TupleImpl(v1, v2);
					tuples.add(tuple);
					// logResult(tuple.toString());
					System.out.println(tuple.toString() + ", ");
				}
			}

			System.out.println();
		}

		System.out.print("loaded, ");
		restartTimer();
	}

	@Test
	public void posLength() throws IOException {
		System.out.println("PosLength query");
		final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
		vertexTypesAndProperties.put(Segment, ImmutableList.of(Segment_length));

		load(vertexTypesAndProperties, ImmutableList.<String> of());

		final Set<Tuple> switchTuples = vertexTuplesMap.get(Segment);

		final ChangeSet switchChangeSet = new ChangeSet(switchTuples, ChangeType.POSITIVE);

		logMessage("Segment.segment_length <= 0");
		logMessage("<Segment>");

		final Collection<ConditionExpression> conditionExpressions = new HashSet<>();
		// t[1] <= 0
		conditionExpressions.add(new ConditionExpression(1, ComparisonOperator.LESS_THAN_OR_EQUAL, 0));

		final TermEvaluatorNode termEvaluatorNode = new TermEvaluatorNode(conditionExpressions);
		final ChangeSet resultChangeSet = termEvaluatorNode.update(switchChangeSet);
		logResult(resultChangeSet.getTuples().toString());
		logBenchmark(resultChangeSet.getTuples().size() + " tuples");

		assertEquals(98, resultChangeSet.getTuples().size());
	}

	@Test
	public void routeSensor() throws IOException {
		System.out.println("RouteSensor query");
		final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();

		final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_switchPosition, SwitchPosition_switch, TrackElement_sensor);
		load(vertexTypesAndProperties, edgeLabels);

		final Set<Tuple> route_routeDefinitionTuples = edgeTuplesMap.get(Route_routeDefinition); // Route, Sensor
		final Set<Tuple> route_switchPositionTuples = edgeTuplesMap.get(Route_switchPosition); // Route, SwitchPosition
		final Set<Tuple> switchPosition_switchTuples = edgeTuplesMap.get(SwitchPosition_switch); // SwitchPosition, Switch
		final Set<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch, Sensor
		final ChangeSet route_routeDefinitionChangeSet = new ChangeSet(route_routeDefinitionTuples, ChangeType.POSITIVE);
		final ChangeSet route_switchPositionChangeSet = new ChangeSet(route_switchPositionTuples, ChangeType.POSITIVE);
		final ChangeSet switchPosition_switchChangeSet = new ChangeSet(switchPosition_switchTuples, ChangeType.POSITIVE);
		final ChangeSet trackElement_sensorChangeSet = new ChangeSet(trackElement_sensorTuples, ChangeType.POSITIVE);

		logMessage("Route_switchPosition JOIN SwitchPosition_switch");
		logMessage("<Route, SwitchPosition, Switch>");
		final TupleMask leftMask1 = new TupleMask(ImmutableList.of(1));
		final TupleMask rightMask1 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode1 = new JoinNode(leftMask1, rightMask1);
		final ChangeSet resultChangeSet1 = Algorithms.join(joinNode1, route_switchPositionChangeSet, switchPosition_switchChangeSet);
		logResult(resultChangeSet1.getTuples().toString());
		logMessage(resultChangeSet1.getTuples().size() + " tuples");

		logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor");
		logMessage("<Route, SwitchPosition, Switch, Sensor>");
		final TupleMask leftMask2 = new TupleMask(ImmutableList.of(2));
		final TupleMask rightMask2 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode2 = new JoinNode(leftMask2, rightMask2);
		final ChangeSet resultChangeSet2 = Algorithms.join(joinNode2, resultChangeSet1, trackElement_sensorChangeSet);
		logResult(resultChangeSet2.getTuples().toString());
		logMessage(resultChangeSet2.getTuples().size() + " tuples");

		logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor ANTIJOIN Route_routeDefinition");
		logMessage("<Route, SwitchPosition, Switch, Sensor>");
		final TupleMask leftMask3 = new TupleMask(ImmutableList.of(3));
		final TupleMask rightMask3 = new TupleMask(ImmutableList.of(1));
		final AntiJoinNode joinNode3 = new AntiJoinNode(leftMask3, rightMask3);
		final ChangeSet resultChangeSet3 = Algorithms.join(joinNode3, resultChangeSet2, route_routeDefinitionChangeSet);
		logResult(resultChangeSet3.getTuples().toString());
		logMessage(resultChangeSet3.getTuples().size() + " tuples");
		logBenchmark(resultChangeSet3.getTuples().size() + " tuples");

		assertEquals(19, resultChangeSet3.getTuples().size());
	}

	@Test
	public void signalNeighbor() throws IOException {
		System.out.println("SignalNeighbor query");

		// base:Route_routeDefinition
		// base:Route_exit
		// base:Route_entry
		// base:TrackElement_sensor
		// base:TrackElement_connectsTo

		// ?xRoute1 rdf:type base:Route .
		// ?xSen1 rdf:type base:Sensor .
		// ?xRoute1 base:Route_routeDefinition ?xSen1 .
		// ?xTE1 rdf:type base:Trackelement .
		// ?xTE1 base:TrackElement_sensor ?xSen1 .
		// ?xTE2 rdf:type base:Trackelement .
		// ?xTE1 base:TrackElement_connectsTo ?xTE2 .
		// ?xSen2 rdf:type base:Sensor .
		// ?xTE2 base:TrackElement_sensor ?xSen2 .
		// ?xSig rdf:type base:Signal .
		// ?xRoute1 base:Route_exit ?xSig .
		//
		// ?xRouteX rdf:type base:Route .
		// ?xRouteX base:Route_routeDefinition ?xSen2 .
		// FILTER ( ?xRouteX != ?xRoute1 )
		//
		// OPTIONAL {
		// ?xRoute2 rdf:type base:Route .
		// ?xRoute2 base:Route_routeDefinition ?xSen2 .
		// ?xRoute2 base:Route_entry ?xSig .
		// } .
		// FILTER (!bound(?xRoute2))

		final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();

		final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_entry, Route_exit, TrackElement_sensor, TrackElement_connectsTo);
		load(vertexTypesAndProperties, edgeLabels);

		final Set<Tuple> route_routeDefinitionTuples = edgeTuplesMap.get(Route_routeDefinition); // Route, Sensor
		final Set<Tuple> route_entryTuples = edgeTuplesMap.get(Route_entry); // Route, Signal
		final Set<Tuple> route_exitTuples = edgeTuplesMap.get(Route_exit); // Route, Signal
		final Set<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch, Sensor
		final Set<Tuple> trackElement_connectsToTuples = edgeTuplesMap.get(TrackElement_connectsTo); // TrackElement, TrackElement

		final ChangeSet route_routeDefinitionChangeSet = new ChangeSet(route_routeDefinitionTuples, ChangeType.POSITIVE);
		final ChangeSet route_entryChangeSet = new ChangeSet(route_entryTuples, ChangeType.POSITIVE);
		final ChangeSet route_exitChangeSet = new ChangeSet(route_exitTuples, ChangeType.POSITIVE);
		final ChangeSet trackElement_sensorChangeSet = new ChangeSet(trackElement_sensorTuples, ChangeType.POSITIVE);
		final ChangeSet trackElement_connectsToChangeSet = new ChangeSet(trackElement_connectsToTuples, ChangeType.POSITIVE);

		// System.out.println("rrd: " + route_routeDefinitionChangeSet.getTuples().size());
		// System.out.println("ren: " + route_entryChangeSet.getTuples().size());
		// System.out.println("rex: " + route_exitChangeSet.getTuples().size());
		// System.out.println("tEs: " + trackElement_sensorChangeSet.getTuples().size());
		// System.out.println("tEc: " + trackElement_connectsToChangeSet.getTuples().size());

		logMessage("Route_entry JOIN Route_routeDefinition");
		logMessage("<Route, Signal, Sensor>");
		final TupleMask leftMask1 = new TupleMask(ImmutableList.of(0));
		final TupleMask rightMask1 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode1 = new JoinNode(leftMask1, rightMask1);
		final ChangeSet resultChangeSet1 = Algorithms.join(joinNode1, route_entryChangeSet, route_routeDefinitionChangeSet);
		logResult(resultChangeSet1.getTuples().toString());
		logMessage(resultChangeSet1.getTuples().size() + " tuples");

		logMessage("Route_exit JOIN Route_routeDefinition");
		logMessage("<Route, Signal, Sensor>");
		final TupleMask leftMask2 = new TupleMask(ImmutableList.of(0));
		final TupleMask rightMask2 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode2 = new JoinNode(leftMask2, rightMask2);
		final ChangeSet resultChangeSet2 = Algorithms.join(joinNode2, route_exitChangeSet, route_routeDefinitionChangeSet);
		logResult(resultChangeSet2.getTuples().toString());
		logMessage(resultChangeSet2.getTuples().size() + " tuples");

		logMessage("trackElement_sensor JOIN trackElement_connectsTo");
		logMessage("<TrackElement, Sensor, TrackElement>");
		final TupleMask leftMask3 = new TupleMask(ImmutableList.of(0));
		final TupleMask rightMask3 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode3 = new JoinNode(leftMask3, rightMask3);
		final ChangeSet resultChangeSet3 = Algorithms.join(joinNode3, trackElement_sensorChangeSet, trackElement_connectsToChangeSet);
		logResult(resultChangeSet3.getTuples().toString());
		logMessage(resultChangeSet3.getTuples().size() + " tuples");

		logMessage("trackElement_sensor JOIN trackElement_connectsTo JOIN trackElement_sensor");
		logMessage("<TrackElement, Sensor, TrackElement, Sensor>");
		final TupleMask leftMask4 = new TupleMask(ImmutableList.of(2));
		final TupleMask rightMask4 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode4 = new JoinNode(leftMask4, rightMask4);
		final ChangeSet resultChangeSet4 = Algorithms.join(joinNode4, resultChangeSet3, trackElement_sensorChangeSet);
		logResult(resultChangeSet4.getTuples().toString());
		logMessage(resultChangeSet4.getTuples().size() + " tuples");

		// logBenchmark(resultChangeSetXX.getTuples().size() + " tuples");

		// assertEquals(20, resultChangeSet3.getTuples().size());
	}

	@Test
	public void switchSensor() throws IOException {
		System.out.println("SwitchSensor query");

		// vertex type and properties
		final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
		vertexTypesAndProperties.put(Switch, ImmutableList.<String> of());

		// edge labels
		final Collection<String> edgeLabels = ImmutableList.of(TrackElement_sensor);

		load(vertexTypesAndProperties, edgeLabels);

		final Set<Tuple> switchTuples = vertexTuplesMap.get(Switch);
		final Set<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch, Sensor vertex pairs
		final ChangeSet switchChangeSet = new ChangeSet(switchTuples, ChangeType.POSITIVE);
		final ChangeSet trackElement_sensorChangeSet = new ChangeSet(trackElement_sensorTuples, ChangeType.POSITIVE);

		logMessage("Switch ANTIJOIN Sensor");
		logMessage("<Switch>");
		final TupleMask leftMask = new TupleMask(ImmutableList.of(0));
		final TupleMask rightMask = new TupleMask(ImmutableList.of(0));
		final AntiJoinNode antiJoinNode = new AntiJoinNode(leftMask, rightMask);
		final ChangeSet resultChangeSet = Algorithms.join(antiJoinNode, switchChangeSet, trackElement_sensorChangeSet);
		logResult(resultChangeSet.getTuples().toString());
		logBenchmark(resultChangeSet.getTuples().size() + " tuples");

		assertEquals(26, resultChangeSet.getTuples().size());
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
