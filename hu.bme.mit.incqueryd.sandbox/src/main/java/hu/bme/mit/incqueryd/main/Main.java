package hu.bme.mit.incqueryd.main;

import hu.bme.mit.incqueryd.io.GraphSonFormat;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.JoinSide;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

public class Main {

	static final String Route_routeDefinition = "Route_routeDefinition";
	static final String Route_switchPosition = "Route_switchPosition";
	static final String SwitchPosition_switch = "SwitchPosition_switch";
	static final String TrackElement_sensor = "TrackElement_sensor";

	public static void main(final String[] args) throws IOException {
		System.out.println("IncQuery-D main");

		final String pathName = "/home/szarnyasg/hdd/models/faunus-graphson/testBig_User_1.faunus-graphson";
		final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_switchPosition, SwitchPosition_switch, TrackElement_sensor);
		final Map<String, Collection<Tuple>> tuplesMap = new HashMap<>();

		for (final String edgeLabel : edgeLabels) {
			final Collection<Tuple> tuples = new ArrayList<>();
			tuplesMap.put(edgeLabel, tuples);

			System.out.println(edgeLabel);
			final Multimap<Object, Object> edges = GraphSonFormat.collectEdges(pathName, edgeLabel);

			for (final Object v1 : edges.keySet()) {
				final Collection<Object> v2s = edges.get(v1);

				System.out.println(v1 + ": " + v2s);
				for (final Object v2 : v2s) {
					final Tuple tuple = new TupleImpl(v1, v2);
					tuples.add(tuple);

					System.out.println(tuple);
				}
			}
		}

		final Collection<Tuple> route_switchPositionTuples = tuplesMap.get(Route_switchPosition);   // Route, SwitchPosition
		final Collection<Tuple> switchPosition_switchTuples = tuplesMap.get(SwitchPosition_switch); // SwitchPosition, Switch
		final Collection<Tuple> trackElement_sensorTuples = tuplesMap.get(TrackElement_sensor);     // Switch, Sensor
		final Collection<Tuple> route_routeDefinitionTuples = tuplesMap.get(Route_routeDefinition); // Route, Sensor

		System.out.println("Route_switchPosition JOIN SwitchPosition_switch");
		final TupleMask leftMask1 = new TupleMask(ImmutableList.of(1));
		final TupleMask rightMask1 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode1 = new JoinNode(leftMask1, rightMask1);
		final ChangeSet resultChangeSet1 = join(joinNode1, route_switchPositionTuples, switchPosition_switchTuples);
		System.out.println("<Route, SwitchPosition, Switch>");
		System.out.println(resultChangeSet1.getTuples());

		System.out.println("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor");
		final TupleMask leftMask2 = new TupleMask(ImmutableList.of(2));
		final TupleMask rightMask2 = new TupleMask(ImmutableList.of(0));
		final JoinNode joinNode2 = new JoinNode(leftMask2, rightMask2);
		final ChangeSet resultChangeSet2 = join(joinNode2, resultChangeSet1.getTuples(), trackElement_sensorTuples);
		System.out.println("<Route, SwitchPosition, Switch, Sensor>");
		System.out.println(resultChangeSet2.getTuples());

		System.out.println("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor JOIN Route_routeDefinition");
		final TupleMask leftMask3 = new TupleMask(ImmutableList.of(3));
		final TupleMask rightMask3 = new TupleMask(ImmutableList.of(1));
		final JoinNode joinNode3 = new JoinNode(leftMask3, rightMask3);
		final ChangeSet resultChangeSet3 = join(joinNode3, resultChangeSet2.getTuples(), route_routeDefinitionTuples);
		System.out.println("<Route, SwitchPosition, Switch, Sensor, Route>");
		System.out.println(resultChangeSet3.getTuples());

		
		// final Collection<Tuple> leftTuples = new ArrayList<>();
		// leftTuples.add(new TupleImpl(5, 6, 7));
		// leftTuples.add(new TupleImpl(10, 11, 7));
		//
		// final Collection<Tuple> rightTuples = new ArrayList<>();
		// rightTuples.add(new TupleImpl(7, 8));
		//

	}

	private static ChangeSet join(final JoinNode joinNode, final Collection<Tuple> leftTuples, final Collection<Tuple> rightTuples) {
		final ChangeSet leftChangeSet = new ChangeSet(leftTuples, ChangeType.POSITIVE);
		final ChangeSet rightChangeSet = new ChangeSet(rightTuples, ChangeType.POSITIVE);

		// new tuples from the left
		joinNode.update(leftChangeSet, JoinSide.PRIMARY);
		// new tuples from the right
		final ChangeSet joinedTuples = joinNode.update(rightChangeSet, JoinSide.SECONDARY);
		return joinedTuples;
	}
}
