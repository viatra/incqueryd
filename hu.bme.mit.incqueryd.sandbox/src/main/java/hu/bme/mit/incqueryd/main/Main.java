package hu.bme.mit.incqueryd.main;

import hu.bme.mit.incqueryd.io.GraphSonFormat;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.AbstractJoinNode;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

public class Main {

	static final String Route_routeDefinition = "Route_routeDefinition";
	static final String Route_switchPosition = "Route_switchPosition";
	static final String SwitchPosition_switch = "SwitchPosition_switch";
	static final String TrackElement_sensor = "TrackElement_sensor";

	private static final boolean logResults = true;
	private static final boolean logMessages = true;
	private static int numberOfRuns = 1;

	public static void main(final String[] args) throws IOException {
		final int size = 1;
		final String pathName = "/home/szarnyasg/hdd/models/faunus-graphson/testBig_User_" + size + ".faunus-graphson";

		System.out.println("IncQuery-D main");
		System.out.println("===============");

		logBenchmark("Model size: " + size);

		final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_switchPosition, SwitchPosition_switch, TrackElement_sensor);
		final Map<String, Collection<Tuple>> tuplesMap = new HashMap<>();

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

		// starting microbenchmarks
		for (int i = 1; i <= numberOfRuns; i++) {
			benchmark(tuplesMap);
		}
	}

	private static void benchmark(final Map<String, Collection<Tuple>> tuplesMap) {

		logMessage();
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
		final ChangeSet resultChangeSet1 = join(joinNode1, route_switchPositionTuples, switchPosition_switchTuples);
		logResult(resultChangeSet1.getTuples().toString());
		logMessage(resultChangeSet1.getTuples().size() + " tuples");

		logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor");
		logMessage("<Route, SwitchPosition, Switch, Sensor>");
		final TupleMask leftMask2 = new TupleMask(ImmutableList.of(2));
		final TupleMask rightMask2 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode2 = new JoinNode(leftMask2, rightMask2);
		final ChangeSet resultChangeSet2 = join(joinNode2, resultChangeSet1.getTuples(), trackElement_sensorTuples);
		logResult(resultChangeSet2.getTuples().toString());
		logMessage(resultChangeSet2.getTuples().size() + " tuples");

		logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor JOIN Route_routeDefinition");
		logMessage("<Route, SwitchPosition, Switch, Sensor, Route>");
		final TupleMask leftMask3 = new TupleMask(ImmutableList.of(3));
		final TupleMask rightMask3 = new TupleMask(ImmutableList.of(1));
		//final JoinNode joinNode3 = new JoinNode(leftMask3, rightMask3);
		final AntiJoinNode joinNode3 = new AntiJoinNode(leftMask3, rightMask3);
		final ChangeSet resultChangeSet3 = join(joinNode3, resultChangeSet2.getTuples(), route_routeDefinitionTuples);
		logResult(resultChangeSet3.getTuples().toString());
		logMessage(resultChangeSet3.getTuples().size() + " tuples");
		// logBenchmark(resultChangeSet3.getTuples().size() + "");
		System.out.print(resultChangeSet3.getTuples().size() + ", ");

		// finishing microbenchmark
		restartTimer();

		// little JUnit test igredients
		// final Collection<Tuple> leftTuples = new ArrayList<>();
		// leftTuples.add(new TupleImpl(5, 6, 7));
		// leftTuples.add(new TupleImpl(10, 11, 7));
		//
		// final Collection<Tuple> rightTuples = new ArrayList<>();
		// rightTuples.add(new TupleImpl(7, 8));
	}

	private static long startTime;

	private static void startTimer() {
		logMessage("(Re)starting timer");
		startTime = System.nanoTime();
	}

	private static void restartTimer() {
		final long stopTime = System.nanoTime();
		final long deltaTime = stopTime - startTime;
		final long deltaTimeMs = deltaTime / 1000000;
		// logBenchmark("Time elapsed: ");
		logBenchmark("time [ms]: " + deltaTimeMs);
		startTimer();
	}

	private static void logMessage() {
		logMessage("");
	}

	private static void logMessage(final String message) {
		if (logMessages) {
			System.out.println(message);
		}
	}

	private static void logResult(final String message) {
		if (logResults) {
			System.out.println(message);
		}
	}

	private static void logBenchmark(final String message) {
		System.out.println(message);
	}

	private static ChangeSet join(final AbstractJoinNode joinNode, final Collection<Tuple> leftTuples, final Collection<Tuple> rightTuples) {
		final ChangeSet leftChangeSet = new ChangeSet(leftTuples, ChangeType.POSITIVE);
		final ChangeSet rightChangeSet = new ChangeSet(rightTuples, ChangeType.POSITIVE);

		// this is the correct order for the antijoin operations
		// new tuples from the secondary slot
		final ChangeSet joinedTuples1 = joinNode.update(rightChangeSet, ReteNodeSlot.SECONDARY);		
		// new tuples from the primary slot
		final ChangeSet joinedTuples2 = joinNode.update(leftChangeSet, ReteNodeSlot.PRIMARY);
		
		return joinedTuples2;
	}

}
