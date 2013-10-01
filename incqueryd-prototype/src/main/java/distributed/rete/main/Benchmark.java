package distributed.rete.main;

import hu.bme.mit.train.util.BenchmarkResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.remote.RemoteScope;

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
import distributed.rete.configuration.ReteNodeConfiguration;
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
	protected final String databaseServerAddress = "localhost";
	protected final boolean loadDatabase;
	protected final String actorSystemName;
	protected ActorSystem system;

	public Benchmark(final DatabaseClientType type, final String filename, final boolean loadDatabase) {
		this.type = type;
		this.filename = filename;
		this.loadDatabase = loadDatabase;
		this.actorSystemName = "ReteNet";
	}

	public void run() {
		BenchmarkResult.INSTANCE.startStopper();
		BenchmarkResult.INSTANCE.setId("TestCaseRouteSensor_Rete");

		// reset the database
		if (loadDatabase) {
			loadDatabase();
		}

		final Config remoteCreationConfig = ConfigFactory.load().getConfig("RemoteDeployment");
		system = ActorSystem.create("ReteNet", remoteCreationConfig);
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "SwitchPosition_switchActor", "127.0.0.1");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "Route_switchPositionActor", "127.0.0.1");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "TrackElement_sensorActor", "127.0.0.1");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "Route_routeDefinitionActor", "127.0.0.1");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "JoinNode1", "127.0.0.1");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "JoinNode2", "127.0.0.1");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "AntiJoinNode", "127.0.0.1");
		RouteSensorConfiguration.setActorIp(remoteCreationConfig, "ProductionNode", "127.0.0.1");

		System.out.println(RouteSensorConfiguration.ips);

		// instantiating the Coordinator actor and let it do the work
		final ActorRef coordinator = system.actorOf(new Props(Coordinator.class), "Coordinator");
		initRouteSensorNodes(system, coordinator);

		BenchmarkResult.INSTANCE.setReadTime();
		BenchmarkResult.INSTANCE.startStopper();
	}

	protected void loadDatabase() {
		System.out.println("Connecting to server: " + databaseServerAddress + ", loading: " + filename);

		final DatabaseClient client = DatabaseClientFactory.createDatabaseClient(type, databaseServerAddress, filename);
		client.load();

		System.out.println("Databased loaded.");
	}

	protected void initRouteSensorNodes(final ActorSystem system, final ActorRef coordinator) {
		final Map<String, ReteNodeConfiguration> configurations = new HashMap<>();
		final Map<String, String> addresses = new HashMap<>();
		
		// TODO use maps
		configurations.put("", null);
		
		// UniquenessEnforcerNodes' data
		// UniquenessEnforcerNode: SwitchPosition_switchActor
		final String switchPosition_switchLabel = "SwitchPosition_switch";
		final UniquenessEnforcerNodeConfiguration switchPosition_switchConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode1"),
				switchPosition_switchLabel, JoinSide.PRIMARY, type, filename);
		final ActorRef switchPosition_switchActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"SwitchPosition_switchActor");
		
		switchPosition_switchActor.tell(switchPosition_switchConf, coordinator);

		// UniquenessEnforcerNode: Route_switchPositionActor
		final String route_switchPositionLabel = "Route_switchPosition";
		final UniquenessEnforcerNodeConfiguration route_switchPositionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode1"),
				route_switchPositionLabel, JoinSide.SECONDARY, type, filename);
		final ActorRef route_switchPositionActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"Route_switchPositionActor");
		route_switchPositionActor.tell(route_switchPositionConf, coordinator);

		// UniquenessEnforcerNode: TrackElement_sensorActor
		final String trackElement_sensorLabel = "TrackElement_sensor";
		final UniquenessEnforcerNodeConfiguration trackElement_sensorConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("JoinNode2"),
				trackElement_sensorLabel, JoinSide.SECONDARY, type, filename);
		final ActorRef trackElement_sensorActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"TrackElement_sensorActor");
		trackElement_sensorActor.tell(trackElement_sensorConf, coordinator);

		// UniquenessEnforcerNode: Route_routeDefinitionActor
		final String route_routeDefinitionLabel = "Route_routeDefinition";
		final UniquenessEnforcerNodeConfiguration route_routeDefinitionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath("AntiJoinNode"),
				route_routeDefinitionLabel, JoinSide.SECONDARY, type, filename);
		final ActorRef route_routeDefinitionActor = system.actorOf(new Props(UniquenessEnforcerNode.class),
				"Route_routeDefinitionActor");
		route_routeDefinitionActor.tell(route_routeDefinitionConf, coordinator);

		// JoinNode: JoinNode1
		final TupleMask join1LeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0)), null); // [Sp], Sw
		final TupleMask join1RightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(1)), null); // R, [Sp]
		final JoinNodeConfiguration joinNode1Configuration = new JoinNodeConfiguration(coordinator, join1LeftMask,
				join1RightMask,
				RouteSensorConfiguration.getActorPath("JoinNode2"),
				JoinSide.PRIMARY);
		final ActorRef joinNode1 = system.actorOf(new Props(NaturalJoinNode.class), "JoinNode1");
		joinNode1.tell(joinNode1Configuration, null);

		// JoinNode: JoinNode2
		final TupleMask join2LeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(1)), null); // Sp, [Sw], R
		final TupleMask join2RightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0)), null); // [Te], S
		final JoinNodeConfiguration joinNode2Configuration = new JoinNodeConfiguration(coordinator, join2LeftMask,
				join2RightMask, RouteSensorConfiguration.getActorPath("AntiJoinNode"),
				JoinSide.PRIMARY);
		final ActorRef joinNode2 = system.actorOf(new Props(NaturalJoinNode.class), "JoinNode2");
		joinNode2.tell(joinNode2Configuration, null);
		

		// AntiJoinNode: AntiJoinNode
		final TupleMask antiJoinLeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(2, 3)), null); // Sp, Sw, [R], [Sen]
		final TupleMask antiJoinRightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0, 1)), null); // [R], [Sen]
		final JoinNodeConfiguration antiJoinNodeConfiguration = new JoinNodeConfiguration(coordinator, antiJoinLeftMask,
				antiJoinRightMask, RouteSensorConfiguration.getActorPath("ProductionNode"),
				JoinSide.NULL);
		final String antiJoinNodeHost = "127.0.0.1";

		// ProductionNode: ProductionNode
		final ProductionNodeConfiguration productionNodeConfiguration = new ProductionNodeConfiguration(coordinator);
		final String productionNodeHost = "127.0.0.1";
		
		deployActor(antiJoinNodeHost, antiJoinNodeConfiguration, "AntiJoinNode", ExistenceNode.class);
		deployActor(productionNodeHost, productionNodeConfiguration, "ProductionNode", ProductionNode.class);
	}
	
	private void deployActor(final String host, final ReteNodeConfiguration productionNodeConfiguration, final String name, final Class actorClass) {
		final Address addr = new Address("akka", actorSystemName, host, 2552);
		final Deploy deploy = new Deploy(new RemoteScope(addr));
		final ActorRef productionNode = system.actorOf(new Props(actorClass).withDeploy(deploy), name);
		productionNode.tell(productionNodeConfiguration, null);
	}

}
