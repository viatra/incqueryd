package distributed.rete.main;

import hu.bme.mit.train.util.BenchmarkResult;

import java.util.ArrayList;
import java.util.Arrays;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import distributed.constants.RouteSensorConfiguration;
import distributed.rete.actors.ExistenceNode;
import distributed.rete.actors.NaturalJoinNode;
import distributed.rete.actors.ProductionNode;
import distributed.rete.actors.UniquenessEnforcerNode;
import distributed.rete.actors.controllers.Coordinator;
import distributed.rete.configuration.JoinNodeConfiguration;
import distributed.rete.configuration.ProductionNodeConfiguration;
import distributed.rete.configuration.UniquenessEnforcerNodeConfiguration;
import distributed.rete.database.DatabaseClient;
import distributed.rete.database.DatabaseClientFactory;
import distributed.rete.database.DatabaseClientType;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.TupleMask;

/**
 * Main benchmark class.
 * 
 * @author szarnyasg
 * 
 */
public class Benchmark {

	protected final DatabaseClientType type;
	protected final String filename;
	protected final String serverAddress = "localhost";
	protected final boolean loadDatabase;

	public Benchmark(final DatabaseClientType type, final String filename, final boolean loadDatabase) {
		this.type = type;
		this.filename = filename;
		this.loadDatabase = loadDatabase;
	}

	public void run() {
		BenchmarkResult.INSTANCE.startStopper();
		BenchmarkResult.INSTANCE.setId("TestCaseRouteSensor_Rete");

		// reset the database
		if (loadDatabase) {
			loadDatabase();
		}

		Config remoteCreationConfig = ConfigFactory.load().getConfig("RemoteDeployment");
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

	protected void loadDatabase() {
		System.out.println("Connecting to server: " + serverAddress + ", loading: " + filename);

		DatabaseClient client = DatabaseClientFactory.createDatabaseClient(type, serverAddress, filename);
		client.load();

		System.out.println("databased loaded.");
	}

	protected void initRouteSensorNodes(ActorSystem system, ActorRef coordinator) {
		// UniquenessEnforcerNodes' data
		// UniquenessEnforcerNode: SwitchPosition_switchActor
		final String switchPosition_switchLabel = "SwitchPosition_switch";
		ActorRef switchPosition_switchActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"SwitchPosition_switchActor");
		UniquenessEnforcerNodeConfiguration switchPosition_switchConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode1"),
				switchPosition_switchLabel, JoinSide.PRIMARY, type, filename);

		switchPosition_switchActor.tell(switchPosition_switchConf, coordinator);

		// UniquenessEnforcerNode: Route_switchPositionActor
		final String route_switchPositionLabel = "Route_switchPosition";
		ActorRef route_switchPositionActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"Route_switchPositionActor");
		UniquenessEnforcerNodeConfiguration route_switchPositionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode1"),
				route_switchPositionLabel, JoinSide.SECONDARY, type, filename);
		route_switchPositionActor.tell(route_switchPositionConf, coordinator);

		// UniquenessEnforcerNode: TrackElement_sensorActor
		final String trackElement_sensorLabel = "TrackElement_sensor";
		ActorRef trackElement_sensorActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"TrackElement_sensorActor");
		UniquenessEnforcerNodeConfiguration trackElement_sensorConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode2"),
				trackElement_sensorLabel, JoinSide.SECONDARY, type, filename);
		trackElement_sensorActor.tell(trackElement_sensorConf, coordinator);

		// UniquenessEnforcerNode: Route_routeDefinitionActor
		final String route_routeDefinitionLabel = "Route_routeDefinition";
		ActorRef route_routeDefinitionActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"Route_routeDefinitionActor");
		UniquenessEnforcerNodeConfiguration route_routeDefinitionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("AntiJoinNode"),
				route_routeDefinitionLabel, JoinSide.SECONDARY, type, filename);
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

		ActorRef antiJoinNode = system.actorOf(new Props(ExistenceNode.class), "AntiJoinNode");
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
