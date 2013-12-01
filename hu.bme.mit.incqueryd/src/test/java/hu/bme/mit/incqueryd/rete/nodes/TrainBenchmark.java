package hu.bme.mit.incqueryd.rete.nodes;

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

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

/**
 * Test cases for the TrainBenchmark queries.
 * The queries are evaluated on an instance model serialized in Faunus GraphSON format.
 * For details, see the TrainBenchmark website: http://incquery.net/publications/trainbenchmark
 * @author szarnyasg
 *
 */
public class TrainBenchmark {

	protected final String Route_routeDefinition = "Route_routeDefinition";
	protected final String Route_switchPosition = "Route_switchPosition";
	protected final String SwitchPosition_switch = "SwitchPosition_switch";
	protected final String TrackElement_sensor = "TrackElement_sensor";

	protected final int size = 1;
	protected final String pathName = "src/test/resources/testBig_User_" + size + ".faunus-graphson";

	protected final boolean logResults = false;
	protected final boolean logMessages = false;
	
	final Map<String, Collection<Tuple>> tuplesMap = new HashMap<>();

	@Before
	public void load() throws IOException {
		final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_switchPosition, SwitchPosition_switch, TrackElement_sensor);

		logMessage();
		logMessage("Loading");
		logMessage("-------");

		// collect the edges from the Faunus GraphSON file in one run
		startTimer();
		final Map<String, Multimap<Object, Object>> edgeLabelVertexPairsMap = GraphSonFormat.collectDifferentEdges(pathName, edgeLabels);

		for (final Entry<String, Multimap<Object, Object>> entry : edgeLabelVertexPairsMap.entrySet()) {
			final String edgeLabel = entry.getKey();
			final Multimap<Object, Object> edges = entry.getValue();

			final Collection<Tuple> tuples = new HashSet<>();
			tuplesMap.put(edgeLabel, tuples);

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
	public void routeSensor() {
		logMessage("Results");
		logMessage("-------");
		final Collection<Tuple> route_switchPositionTuples = tuplesMap.get(Route_switchPosition); // Route, SwitchPosition
		final Collection<Tuple> switchPosition_switchTuples = tuplesMap.get(SwitchPosition_switch); // SwitchPosition, Switch
		final Collection<Tuple> trackElement_sensorTuples = tuplesMap.get(TrackElement_sensor); // Switch, Sensor
		final Collection<Tuple> route_routeDefinitionTuples = tuplesMap.get(Route_routeDefinition); // Route, Sensor

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
		//final JoinNode joinNode3 = new JoinNode(leftMask3, rightMask3);
		final AntiJoinNode joinNode3 = new AntiJoinNode(leftMask3, rightMask3);
		final ChangeSet resultChangeSet3 = Algorithms.join(joinNode3, resultChangeSet2.getTuples(), route_routeDefinitionTuples);
		logResult(resultChangeSet3.getTuples().toString());
		logMessage(resultChangeSet3.getTuples().size() + " tuples");
		// logBenchmark(resultChangeSet3.getTuples().size() + "");
		System.out.print(resultChangeSet3.getTuples().size() + ", ");

		// finishing microbenchmark
		restartTimer();
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
