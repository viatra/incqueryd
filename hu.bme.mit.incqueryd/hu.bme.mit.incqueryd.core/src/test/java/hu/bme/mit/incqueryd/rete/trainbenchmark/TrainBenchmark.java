package hu.bme.mit.incqueryd.rete.trainbenchmark;

import static org.junit.Assert.assertEquals;
import hu.bme.mit.incqueryd.io.GraphSonLoader;
import hu.bme.mit.incqueryd.rete.comparison.ComparisonOperator;
import hu.bme.mit.incqueryd.rete.comparison.ConditionExpression;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.Algorithms;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
import hu.bme.mit.incqueryd.rete.nodes.InequalityNode;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;
import hu.bme.mit.incqueryd.rete.nodes.TermEvaluatorNode;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

/**
 * Test cases for the TrainBenchmark queries. The queries are evaluated on an instance model serialized in Faunus
 * GraphSON format. For details, see the TrainBenchmark website: http://incquery.net/publications/trainbenchmark
 * 
 * See the private wiki for reference output values:
 * https://trac.inf.mit.bme.hu/Ontology/wiki/TrainBenchmark/TBResultFormat
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

    @Test
    public void posLength() throws IOException {
        System.out.println("PosLength query");
        final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
        vertexTypesAndProperties.put(Segment, ImmutableList.of(Segment_length));

        final GraphSonLoader graphSonLoader = new GraphSonLoader(pathName, vertexTypesAndProperties,
                ImmutableList.<String> of());
        final Map<String, Set<Tuple>> vertexTuplesMap = graphSonLoader.getVertexTuplesMap();

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

        final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_switchPosition,
                SwitchPosition_switch, TrackElement_sensor);

        final GraphSonLoader graphSonLoader = new GraphSonLoader(pathName, vertexTypesAndProperties, edgeLabels);
        final Map<String, Set<Tuple>> edgeTuplesMap = graphSonLoader.getEdgeTuplesMap();

        final Set<Tuple> route_routeDefinitionTuples = edgeTuplesMap.get(Route_routeDefinition); // Route, Sensor
        final Set<Tuple> route_switchPositionTuples = edgeTuplesMap.get(Route_switchPosition); // Route, SwitchPosition
        final Set<Tuple> switchPosition_switchTuples = edgeTuplesMap.get(SwitchPosition_switch); // SwitchPosition,
                                                                                                 // Switch
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
        final ChangeSet resultChangeSet1 = Algorithms.join(joinNode1, route_switchPositionChangeSet,
                switchPosition_switchChangeSet);
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

        logMessage("PROJECTION_{0} (");
        logMessage("Route_switchPosition JOIN SwitchPosition_switch JOIN TrackElement_sensor ANTIJOIN Route_routeDefinition");
        logMessage("<Route>");
        final TupleMask projectionMask = new TupleMask(ImmutableList.of(0));
        final TrimmerNode trimmerNode = new TrimmerNode(projectionMask);
        final ChangeSet resultChangeSet4 = trimmerNode.update(resultChangeSet3);
        logResult(resultChangeSet4.getTuples().toString());
        logMessage(resultChangeSet4.getTuples().size() + " tuples");

        assertEquals(12, resultChangeSet4.getTuples().size());
    }

    // pattern signalNeighbor(R1) =
    // {
    // Route.Route_exit(Route1, Signal);
    // Route.Route_routeDefinition(Route1, Sensor1);
    // Sensor.Sensor_trackElement(Sensor1, Te1);
    // Sensor.Sensor_trackElement(Sensor2, Te2);
    // Trackelement.TrackElement_connectsTo(Te1, Te2);
    // Route.Route_routeDefinition(Route3, Sensor2);
    //
    // Route1 != Route3;
    //
    // neg find
    // {
    // Route.Route_entry(_Route2, Signal);
    // Route.Route_routeDefinition(_Route2, Sensor2);
    // }
    // }
    @Test
    public void signalNeighbor() throws IOException {
        System.out.println("SignalNeighbor query");

        final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
        final Collection<String> edgeLabels = ImmutableList.of(Route_routeDefinition, Route_entry, Route_exit,
                TrackElement_sensor, TrackElement_connectsTo);

        final GraphSonLoader graphSonLoader = new GraphSonLoader(pathName, vertexTypesAndProperties,
                edgeLabels);
        final Map<String, Set<Tuple>> edgeTuplesMap = graphSonLoader.getEdgeTuplesMap();

        final Set<Tuple> route_routeDefinitionTuples = edgeTuplesMap.get(Route_routeDefinition); // Route, Sensor
        final Set<Tuple> route_entryTuples = edgeTuplesMap.get(Route_entry); // Route, Signal
        final Set<Tuple> route_exitTuples = edgeTuplesMap.get(Route_exit); // Route, Signal
        final Set<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch, Sensor
        final Set<Tuple> trackElement_connectsToTuples = edgeTuplesMap.get(TrackElement_connectsTo); // TrackElement,
                                                                                                     // TrackElement

        final ChangeSet route_routeDefinitionChangeSet = new ChangeSet(route_routeDefinitionTuples, ChangeType.POSITIVE);
        final ChangeSet route_entryChangeSet = new ChangeSet(route_entryTuples, ChangeType.POSITIVE);
        final ChangeSet route_exitChangeSet = new ChangeSet(route_exitTuples, ChangeType.POSITIVE);
        final ChangeSet trackElement_sensorChangeSet = new ChangeSet(trackElement_sensorTuples, ChangeType.POSITIVE);
        final ChangeSet trackElement_connectsToChangeSet = new ChangeSet(trackElement_connectsToTuples,
                ChangeType.POSITIVE);

        logMessage("Route_exit JOIN Route_routeDefinition");
        logMessage("<Route1, Signal, Sensor1>");
        final TupleMask leftMask1 = new TupleMask(ImmutableList.of(0));
        final TupleMask rightMask1 = new TupleMask(ImmutableList.of(0));
        final JoinNode joinNode1 = new JoinNode(leftMask1, rightMask1);
        final ChangeSet resultChangeSet1 = Algorithms.join(joinNode1, route_exitChangeSet,
                route_routeDefinitionChangeSet);
        logResult(resultChangeSet1.getTuples().toString());
        logMessage(resultChangeSet1.getTuples().size() + " tuples");

        // for the NAC
        logMessage("Route_entry JOIN Route_routeDefinition");
        logMessage("<RouteX, Signal, Sensor2>");
        final TupleMask leftMask2 = new TupleMask(ImmutableList.of(0));
        final TupleMask rightMask2 = new TupleMask(ImmutableList.of(0));
        final JoinNode joinNode2 = new JoinNode(leftMask2, rightMask2);
        final ChangeSet resultChangeSet2 = Algorithms.join(joinNode2, route_entryChangeSet,
                route_routeDefinitionChangeSet);
        logResult(resultChangeSet2.getTuples().toString());
        logMessage(resultChangeSet2.getTuples().size() + " tuples");
        // /NAC

        logMessage("TrackElement_sensor JOIN TrackElement_connectsTo");
        logMessage("<TrackElement1, Sensor1, TrackElement2>");
        final TupleMask leftMask3 = new TupleMask(ImmutableList.of(0));
        final TupleMask rightMask3 = new TupleMask(ImmutableList.of(0));
        final JoinNode joinNode3 = new JoinNode(leftMask3, rightMask3);
        final ChangeSet resultChangeSet3 = Algorithms.join(joinNode3, trackElement_sensorChangeSet,
                trackElement_connectsToChangeSet);
        logResult(resultChangeSet3.getTuples().toString());
        logMessage(resultChangeSet3.getTuples().size() + " tuples");

        logMessage("TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor");
        logMessage("<TrackElement1, Sensor1, TrackElement2, Sensor2>");
        final TupleMask leftMask4 = new TupleMask(ImmutableList.of(2));
        final TupleMask rightMask4 = new TupleMask(ImmutableList.of(0));
        final JoinNode joinNode4 = new JoinNode(leftMask4, rightMask4);
        final ChangeSet resultChangeSet4 = Algorithms.join(joinNode4, resultChangeSet3, trackElement_sensorChangeSet);
        logResult(resultChangeSet4.getTuples().toString());
        logMessage(resultChangeSet4.getTuples().size() + " tuples");

        logMessage("PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
        logMessage("<Sensor1, Sensor2>");
        final TupleMask projectionMask1 = new TupleMask(ImmutableList.of(1, 3));
        final TrimmerNode trimmerNode1 = new TrimmerNode(projectionMask1);
        final ChangeSet resultChangeSet5 = trimmerNode1.update(resultChangeSet4);
        logResult(resultChangeSet5.getTuples().toString());
        logMessage(resultChangeSet5.getTuples().size() + " tuples");

        logMessage("Route_exit JOIN Route_routeDefinition JOIN ");
        logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
        logMessage("<Route1, Signal, Sensor1, Sensor2>");
        final TupleMask leftMask5 = new TupleMask(ImmutableList.of(2));
        final TupleMask rightMask5 = new TupleMask(ImmutableList.of(0));
        final JoinNode joinNode5 = new JoinNode(leftMask5, rightMask5);
        final ChangeSet resultChangeSet6 = Algorithms.join(joinNode5, resultChangeSet1, resultChangeSet5);
        logResult(resultChangeSet6.getTuples().toString());
        logMessage(resultChangeSet6.getTuples().size() + " tuples");

        logMessage("Route_exit JOIN Route_routeDefinition JOIN ");
        logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
        logMessage("  JOIN Route_routeDefinition");
        logMessage("<Route1, Signal, Sensor1, Sensor2, Route3>");
        final TupleMask leftMask6 = new TupleMask(ImmutableList.of(3));
        final TupleMask rightMask6 = new TupleMask(ImmutableList.of(1));
        final JoinNode joinNode6 = new JoinNode(leftMask6, rightMask6);
        final ChangeSet resultChangeSet7 = Algorithms.join(joinNode6, resultChangeSet6, route_routeDefinitionChangeSet);
        logResult(resultChangeSet7.getTuples().toString());
        logMessage(resultChangeSet7.getTuples().size() + " tuples");

        logMessage("SELECTION_{t[0] != t[4]}");
        logMessage("Route_exit JOIN Route_routeDefinition JOIN ");
        logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
        logMessage("  JOIN Route_routeDefinition");
        logMessage("<Route1, Signal, Sensor1, Sensor2, Route3>");
        final TupleMask inequalityMask = new TupleMask(ImmutableList.of(0, 4));
        final AlphaNode inequalityNode = new InequalityNode(inequalityMask);
        final ChangeSet resultChangeSet8 = inequalityNode.update(resultChangeSet7);
        logResult(resultChangeSet8.getTuples().toString());
        logMessage(resultChangeSet8.getTuples().size() + " tuples");

        logMessage("SELECTION_{t[0] != t[4]} (");
        logMessage("  Route_exit JOIN Route_routeDefinition JOIN ");
        logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
        logMessage("  JOIN Route_routeDefinition");
        logMessage(")");
        logMessage("ANTIJOIN ");
        logMessage("  (Route_entry JOIN Route_routeDefinition)");
        logMessage("<Route1, Signal, Sensor1, Sensor2, Route3>)");
        final TupleMask leftMask7 = new TupleMask(ImmutableList.of(1, 3));
        final TupleMask rightMask7 = new TupleMask(ImmutableList.of(1, 2));
        final AntiJoinNode joinNode7 = new AntiJoinNode(leftMask7, rightMask7);
        final ChangeSet resultChangeSet9 = Algorithms.join(joinNode7, resultChangeSet8, resultChangeSet2);
        logResult(resultChangeSet9.getTuples().toString());
        logMessage(resultChangeSet9.getTuples().size() + " tuples");

        logMessage("PROJECTION_{0} (");
        logMessage("SELECTION_{t[0] != t[4]} (");
        logMessage("  Route_exit JOIN Route_routeDefinition JOIN ");
        logMessage("  PROJECTION_{1, 3} (TrackElement_sensor JOIN TrackElement_connectsTo JOIN TrackElement_sensor)");
        logMessage("  JOIN Route_routeDefinition");
        logMessage(")");
        logMessage("ANTIJOIN ");
        logMessage("  (Route_entry JOIN Route_routeDefinition)");
        logMessage(")");
        logMessage("<Route1>");
        final TupleMask projectionMask2 = new TupleMask(ImmutableList.of(0));
        final TrimmerNode trimmerNode2 = new TrimmerNode(projectionMask2);
        final ChangeSet resultChangeSet10 = trimmerNode2.update(resultChangeSet9);
        logResult(resultChangeSet10.getTuples().toString());
        logMessage(resultChangeSet10.getTuples().size() + " tuples");

        logBenchmark(resultChangeSet10.getTuples().size() + " tuples");
        assertEquals(2, resultChangeSet10.getTuples().size());
    }

    @Test
    public void switchSensor() throws IOException {
        System.out.println("SwitchSensor query");

        // vertex type and properties
        final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
        vertexTypesAndProperties.put(Switch, ImmutableList.<String> of());

        // edge labels
        final Collection<String> edgeLabels = ImmutableList.of(TrackElement_sensor);
        
        final GraphSonLoader graphSonLoader = new GraphSonLoader(pathName, vertexTypesAndProperties, edgeLabels);
        final Map<String, Set<Tuple>> vertexTuplesMap = graphSonLoader.getVertexTuplesMap();
        final Map<String, Set<Tuple>> edgeTuplesMap = graphSonLoader.getEdgeTuplesMap();

        final Set<Tuple> switchTuples = vertexTuplesMap.get(Switch);
        final Set<Tuple> trackElement_sensorTuples = edgeTuplesMap.get(TrackElement_sensor); // Switch, Sensor vertex
                                                                                             // pairs
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
