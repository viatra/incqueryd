//package hu.bme.mit.incqueryd.rete.trainbenchmark;
//
//import hu.bme.mit.incqueryd.io.GraphSonLoader;
//import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
//import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
//import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
//import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
//import hu.bme.mit.incqueryd.rete.nodes.Algorithms;
//import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;
//import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
//import hu.bme.mit.incqueryd.rete.nodes.InequalityNode;
//import hu.bme.mit.incqueryd.rete.nodes.JoinNode;
//import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;
//
//import java.io.IOException;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import com.google.common.collect.ImmutableList;
//
//public class SignalNeighbor {
//	public void signalNeighbor() throws IOException {
//		System.out.println("SignalNeighbor query");
//
//		final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
//		final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_entry, Route_exit,
//				TrackElement_sensor, TrackElement_connectsTo);
//
//		final GraphSonLoader graphSonLoader = new GraphSonLoader(pathName, vertexTypesAndProperties, edgeLabels);
//		final Map<String, Set<Tuple>> edgeTuplesMap = graphSonLoader.getEdgeTuplesMap();
//
//		final Set<Tuple> route_routeDefinitionTuples = edgeTuplesMap.get(Route_routeDefinition); // Route, Sensor
//		final Set<Tuple> route_entryTuples = edgeTuplesMap.get(Route_entry); // Route, Signal
//		final Set<Tuple> route_exitTuples = edgeTuplesMap.get(Route_exit); // Route, Signal
//		final Set<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch, Sensor
//		final Set<Tuple> trackElement_connectsToTuples = edgeTuplesMap.get(TrackElement_connectsTo); // TrackElement,
//																										// TrackElement
//
//		final ChangeSet route_routeDefinitionChangeSet = new ChangeSet(route_routeDefinitionTuples, ChangeType.POSITIVE);
//		final ChangeSet route_entryChangeSet = new ChangeSet(route_entryTuples, ChangeType.POSITIVE);
//		final ChangeSet route_exitChangeSet = new ChangeSet(route_exitTuples, ChangeType.POSITIVE);
//		final ChangeSet trackElement_sensorChangeSet = new ChangeSet(trackElement_sensorTuples, ChangeType.POSITIVE);
//		final ChangeSet trackElement_connectsToChangeSet = new ChangeSet(trackElement_connectsToTuples,
//				ChangeType.POSITIVE);
//
//		logMessage("Route_exit JOIN Route_routeDefinition");
//		logMessage("<Route1, Signal, Sensor1>");
//		final TupleMask leftMask1 = new TupleMask(ImmutableList.of(0));
//		final TupleMask rightMask1 = new TupleMask(ImmutableList.of(0));
//		final JoinNode joinNode1 = new JoinNode(leftMask1, rightMask1);
//		final ChangeSet resultChangeSet1 = Algorithms.join(joinNode1, route_exitChangeSet,
//				route_routeDefinitionChangeSet);
//		logResult(resultChangeSet1.getTuples().toString());
//		logMessage(resultChangeSet1.getTuples().size() + " tuples");
//
//		// for the NAC
//		logMessage("Route_entry JOIN Route_routeDefinition");
//		logMessage("<RouteX, Signal, Sensor2>");
//		final TupleMask leftMask2 = new TupleMask(ImmutableList.of(0));
//		final TupleMask rightMask2 = new TupleMask(ImmutableList.of(0));
//		final JoinNode joinNode2 = new JoinNode(leftMask2, rightMask2);
//		final ChangeSet resultChangeSet2 = Algorithms.join(joinNode2, route_entryChangeSet,
//				route_routeDefinitionChangeSet);
//		logResult(resultChangeSet2.getTuples().toString());
//		logMessage(resultChangeSet2.getTuples().size() + " tuples");
//		// /NAC
//
//		logMessage("TrackElement_sensor JOIN TrackElement_connectsTo");
//		logMessage("<TrackElement1, Sensor1, TrackElement2>");
//		final TupleMask leftMask3 = new TupleMask(ImmutableList.of(0));
//		final TupleMask rightMask3 = new TupleMask(ImmutableList.of(0));
//		final JoinNode joinNode3 = new JoinNode(leftMask3, rightMask3);
//		final ChangeSet resultChangeSet3 = Algorithms.join(joinNode3, trackElement_sensorChangeSet,
//				trackElement_connectsToChangeSet);
//		logResult(resultChangeSet3.getTuples().toString());
//		logMessage(resultChangeSet3.getTuples().size() + " tuples");
//
//		logMessage("TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor");
//		logMessage("<TrackElement1, Sensor1, TrackElement2, Sensor2>");
//		final TupleMask leftMask4 = new TupleMask(ImmutableList.of(2));
//		final TupleMask rightMask4 = new TupleMask(ImmutableList.of(0));
//		final JoinNode joinNode4 = new JoinNode(leftMask4, rightMask4);
//		final ChangeSet resultChangeSet4 = Algorithms.join(joinNode4, resultChangeSet3, trackElement_sensorChangeSet);
//		logResult(resultChangeSet4.getTuples().toString());
//		logMessage(resultChangeSet4.getTuples().size() + " tuples");
//
//		logMessage("PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
//		logMessage("<Sensor1, Sensor2>");
//		final TupleMask projectionMask1 = new TupleMask(ImmutableList.of(1, 3));
//		final TrimmerNodeConfiguration trimmerNodeConf1 = new TrimmerNodeConfiguration(projectionMask1);
//		final TrimmerNode trimmerNode1 = new TrimmerNode(trimmerNodeConf1);
//		final ChangeSet resultChangeSet5 = trimmerNode1.update(resultChangeSet4);
//		logResult(resultChangeSet5.getTuples().toString());
//		logMessage(resultChangeSet5.getTuples().size() + " tuples");
//
//		logMessage("Route_exit JOIN Route_routeDefinition JOIN ");
//		logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
//		logMessage("<Route1, Signal, Sensor1, Sensor2>");
//		final TupleMask leftMask5 = new TupleMask(ImmutableList.of(2));
//		final TupleMask rightMask5 = new TupleMask(ImmutableList.of(0));
//		final JoinNode joinNode5 = new JoinNode(leftMask5, rightMask5);
//		final ChangeSet resultChangeSet6 = Algorithms.join(joinNode5, resultChangeSet1, resultChangeSet5);
//		logResult(resultChangeSet6.getTuples().toString());
//		logMessage(resultChangeSet6.getTuples().size() + " tuples");
//
//		logMessage("Route_exit JOIN Route_routeDefinition JOIN ");
//		logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
//		logMessage("  JOIN Route_routeDefinition");
//		logMessage("<Route1, Signal, Sensor1, Sensor2, Route3>");
//		final TupleMask leftMask6 = new TupleMask(ImmutableList.of(3));
//		final TupleMask rightMask6 = new TupleMask(ImmutableList.of(1));
//		final JoinNode joinNode6 = new JoinNode(leftMask6, rightMask6);
//		final ChangeSet resultChangeSet7 = Algorithms.join(joinNode6, resultChangeSet6, route_routeDefinitionChangeSet);
//		logResult(resultChangeSet7.getTuples().toString());
//		logMessage(resultChangeSet7.getTuples().size() + " tuples");
//
//		logMessage("SELECTION_{t[0] != t[4]}");
//		logMessage("Route_exit JOIN Route_routeDefinition JOIN ");
//		logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
//		logMessage("  JOIN Route_routeDefinition");
//		logMessage("<Route1, Signal, Sensor1, Sensor2, Route3>");
//		final TupleMask inequalityMask = new TupleMask(ImmutableList.of(0, 4));
//		final AlphaNode inequalityNode = new InequalityNode(inequalityMask);
//		final ChangeSet resultChangeSet8 = inequalityNode.update(resultChangeSet7);
//		logResult(resultChangeSet8.getTuples().toString());
//		logMessage(resultChangeSet8.getTuples().size() + " tuples");
//
//		logMessage("SELECTION_{t[0] != t[4]} (");
//		logMessage("  Route_exit JOIN Route_routeDefinition JOIN ");
//		logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
//		logMessage("  JOIN Route_routeDefinition");
//		logMessage(")");
//		logMessage("ANTIJOIN ");
//		logMessage("  (Route_entry JOIN Route_routeDefinition)");
//		logMessage("<Route1, Signal, Sensor1, Sensor2, Route3>)");
//		final TupleMask leftMask7 = new TupleMask(ImmutableList.of(1, 3));
//		final TupleMask rightMask7 = new TupleMask(ImmutableList.of(1, 2));
//		final AntiJoinNode joinNode7 = new AntiJoinNode(leftMask7, rightMask7);
//		final ChangeSet resultChangeSet9 = Algorithms.join(joinNode7, resultChangeSet8, resultChangeSet2);
//		logResult(resultChangeSet9.getTuples().toString());
//		logMessage(resultChangeSet9.getTuples().size() + " tuples");
//
//		logMessage("PROJECTION_{0} (");
//		logMessage("SELECTION_{t[0] != t[4]} (");
//		logMessage("  Route_exit JOIN Route_routeDefinition JOIN ");
//		logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
//		logMessage("  JOIN Route_routeDefinition");
//		logMessage(")");
//		logMessage("ANTIJOIN ");
//		logMessage("  (Route_entry JOIN Route_routeDefinition)");
//		logMessage(")");
//		logMessage("<Route1>");
//		final TupleMask projectionMask2 = new TupleMask(ImmutableList.of(0));
//		final TrimmerNodeConfiguration trimmerNodeConf2 = new TrimmerNodeConfiguration(projectionMask2);
//		final TrimmerNode trimmerNode2 = new TrimmerNode(trimmerNodeConf2);
//		final ChangeSet resultChangeSet10 = trimmerNode2.update(resultChangeSet9);
//		logResult(resultChangeSet10.getTuples().toString());
//		logMessage(resultChangeSet10.getTuples().size() + " tuples");
//
//		logBenchmark(resultChangeSet10.getTuples().size() + " tuples");
//		assertEquals(2, resultChangeSet10.getTuples().size());
//	}
//}
