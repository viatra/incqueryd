package distributed.rete.main;


import hu.bme.mit.train.util.BenchmarkResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import distributed.constants.Constants;
import distributed.constants.RouteSensorConfiguration;
import distributed.control.Read;
import distributed.rete.actors.AntiJoinNode;
import distributed.rete.actors.NaturalJoinNode;
import distributed.rete.actors.ProductionNode;
import distributed.rete.actors.UniquenessEnforcerNode;
import distributed.rete.actors.controllers.Coordinator;
import distributed.rete.configuration.JoinNodeConfiguration;
import distributed.rete.configuration.ProductionNodeConfiguration;
import distributed.rete.configuration.UniquenessEnforcerNodeConfiguration;
import distributed.rete.database.Neo4jClient;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.TupleMask;

/**
 * Main benchmark class.
 * 
 * @author szarnyasg
 * 
 */
public enum Benchmark {
	INSTANCE;

	public void run() {
		BenchmarkResult.INSTANCE.startStopper();
		BenchmarkResult.INSTANCE.setId("TestCaseRouteSensor_Rete");

		// reset the database
		resetDatabase();
		
		Config remoteCreationConfig = ConfigFactory.load().getConfig("remotecreation");
		ActorSystem remoteCreationReteNet = ActorSystem.create("ReteNet", remoteCreationConfig);
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "SwitchPosition_switchActor");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "Route_switchPositionActor");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "TrackElement_sensorActor");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "Route_routeDefinitionActor");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "JoinNode1");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "JoinNode2");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "AntiJoinNode");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "ProductionNode");

		// instantiating the Coordinator actor and let it do the work
		ActorRef coordinator = remoteCreationReteNet.actorOf(new Props(Coordinator.class), "Coordinator");
		initRouteSensorNodes(remoteCreationReteNet, coordinator);
		
		BenchmarkResult.INSTANCE.setReadTime();
		BenchmarkResult.INSTANCE.startStopper();
	}

	protected void resetDatabase() {
		int n = Constants.INSTANCE.VMs.size();

		CountDownLatch countDownLatch = new CountDownLatch(n);
		for (int i = 0; i < n; i++) {
			String serverUrl = Constants.INSTANCE.VMs.get(i);		
			String graphMlPath = Constants.INSTANCE.GRAPHMLs.get(i);
			
			System.out.println("Loading graphml: " + graphMlPath);
			System.out.println("Connecting to " + serverUrl);
			Neo4jClient client = new Neo4jClient(serverUrl);
			
			Thread thread = new Thread(new Read(client, graphMlPath, countDownLatch));
			thread.start();
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("databases loaded.");
	}
	
	protected void initRouteSensorNodes(ActorSystem system, ActorRef coordinator) {
		// UniquenessEnforcerNodes' data
		// UniquenessEnforcerNode: SwitchPosition_switchActor
		final String switchPosition_switchQuery = "START switchPosition=node:node_auto_index(type='SwitchPosition'), switch=node:node_auto_index(type='Switch') "
				+ "MATCH (switchPosition)-[:SWITCHPOSITION_SWITCH]->(switch) "
				+ "RETURN switchPosition.idx AS switchPositionId, switch.idx AS switchId";
		final String[] switchPosition_switchColumns = { "switchPositionId", "switchId" };
		ActorRef switchPosition_switchActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"SwitchPosition_switchActor");
		UniquenessEnforcerNodeConfiguration switchPosition_switchConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode1"),
				switchPosition_switchQuery, switchPosition_switchColumns, JoinSide.PRIMARY);
		switchPosition_switchActor.tell(switchPosition_switchConf, coordinator);

		// UniquenessEnforcerNode: Route_switchPositionActor
		final String route_switchPositionQuery = "START route=node:node_auto_index(type='Route'), switchPosition=node:node_auto_index(type='SwitchPosition') "
				+ "MATCH (route)-[:ROUTE_SWITCHPOSITION]->(switchPosition) "
				+ "RETURN route.idx AS routeId, switchPosition.idx AS switchPositionId";
		final String[] route_switchPositionColumns = { "routeId", "switchPositionId" };
		ActorRef route_switchPositionActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"Route_switchPositionActor");
		UniquenessEnforcerNodeConfiguration route_switchPositionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode1"),
				route_switchPositionQuery, route_switchPositionColumns, JoinSide.SECONDARY);
		route_switchPositionActor.tell(route_switchPositionConf, coordinator);

		// UniquenessEnforcerNode: TrackElement_sensorActor
		// we did not specify the type of the trackelement on purpose: it is
		// either a Switch or a Segment
		final String trackElement_sensorQuery = "START sensor=node:node_auto_index(type='Sensor') "
				+ "MATCH (trackelement)-[:TRACKELEMENT_SENSOR]->(sensor) "
				+ "RETURN trackelement.idx AS trackelementId, sensor.idx AS sensorId";
		final String[] trackElement_sensorColumns = { "trackelementId", "sensorId" };
		ActorRef trackElement_sensorActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"TrackElement_sensorActor");
		UniquenessEnforcerNodeConfiguration trackElement_sensorConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode2"),
				trackElement_sensorQuery, trackElement_sensorColumns, JoinSide.SECONDARY);
		trackElement_sensorActor.tell(trackElement_sensorConf, coordinator);

		// UniquenessEnforcerNode: Route_routeDefinitionActor
		final String route_routeDefinitionQuery = "START route=node:node_auto_index(type='Route'), sensor=node:node_auto_index(type='Sensor') "
				+ "MATCH (route)-[:ROUTE_ROUTEDEFINITION]->(sensor) "
				+ "RETURN route.idx AS routeId, sensor.idx AS sensorId";
		final String[] route_routeDefinitionColumns = { "routeId", "sensorId" };
		ActorRef route_routeDefinitionActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"Route_routeDefinitionActor");
		UniquenessEnforcerNodeConfiguration route_routeDefinitionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("AntiJoinNode"),
				route_routeDefinitionQuery, route_routeDefinitionColumns, JoinSide.SECONDARY);
		route_routeDefinitionActor.tell(route_routeDefinitionConf, coordinator);

		// JoinNode: JoinNode1
		// [Sp], Sw
		final TupleMask join1LeftMask = new TupleMask(new ArrayList<>(Arrays.asList(0)), null);
		// R, [Sp]
		final TupleMask join1RightMask = new TupleMask(new ArrayList<>(Arrays.asList(1)), null);

		ActorRef joinNode1 = system.actorOf(new Props(NaturalJoinNode.class), "JoinNode1");
		JoinNodeConfiguration joinNode1Configuration = new JoinNodeConfiguration(coordinator, join1LeftMask,
				join1RightMask, 
				RouteSensorConfiguration.getActorPath("JoinNode2"),
				JoinSide.PRIMARY);
		joinNode1.tell(joinNode1Configuration, null);

		// JoinNode: JoinNode2
		// Sp, [Sw], R
		final TupleMask join2LeftMask = new TupleMask(new ArrayList<>(Arrays.asList(1)), null);
		// [Te], S
		final TupleMask join2RightMask = new TupleMask(new ArrayList<>(Arrays.asList(0)), null);

		ActorRef joinNode2 = system.actorOf(new Props(NaturalJoinNode.class), "JoinNode2");
		JoinNodeConfiguration joinNode2Configuration = new JoinNodeConfiguration(coordinator, join2LeftMask,
				join2RightMask, RouteSensorConfiguration.getActorPath("AntiJoinNode"),
				JoinSide.PRIMARY);
		joinNode2.tell(joinNode2Configuration, null);

		// AntiJoinNode: AntiJoinNode
		// Sp, Sw, [R], [Sen]
		final TupleMask antiJoinLeftMask = new TupleMask(new ArrayList<>(Arrays.asList(2, 3)), null);
		// [R], [Sen]
		final TupleMask antiJoinRightMask = new TupleMask(new ArrayList<>(Arrays.asList(0, 1)), null);

		ActorRef antiJoinNode = system.actorOf(new Props(AntiJoinNode.class), "AntiJoinNode");
		JoinNodeConfiguration antiJoinNodeConfiguration = new JoinNodeConfiguration(coordinator, antiJoinLeftMask,
				antiJoinRightMask, RouteSensorConfiguration.getActorPath("ProductionNode"),
				JoinSide.NULL);
		antiJoinNode.tell(antiJoinNodeConfiguration, null);

		// ProductionNode: ProductionNode
		ActorRef productionNode = system.actorOf(new Props(ProductionNode.class), "ProductionNode");
		ProductionNodeConfiguration productionNodeConfiguration = new ProductionNodeConfiguration(coordinator, "");
		productionNode.tell(productionNodeConfiguration, null);
	}

}
