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
	protected final Map<String, ReteNodeConfiguration> configurations = new HashMap<>();
	protected final Map<String, String> hosts = new HashMap<>();
	protected final Map<String, Class> actorClasses = new HashMap<>();

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

		final String switchPosition_switchActorName = "SwitchPosition_switchActor";
		final String route_switchPositionActorName = "Route_switchPositionActor";
		final String trackElement_sensorActorName = "TrackElement_sensorActor";
		final String route_routeDefinitionActorName = "Route_routeDefinitionActor";
		final String joinNode1Name = "JoinNode1";
		final String joinNode2Name = "JoinNode2"; 
		final String antiJoinNodeName = "AntiJoinNode";
		final String productionNodeName = "ProductionNode"; 
		
		hosts.put(switchPosition_switchActorName, "127.0.0.1");
		hosts.put(route_switchPositionActorName, "127.0.0.1");
		hosts.put(trackElement_sensorActorName, "127.0.0.1");
		hosts.put(route_routeDefinitionActorName, "127.0.0.1");
		hosts.put(joinNode1Name, "127.0.0.1");
		hosts.put(joinNode2Name, "127.0.0.1");
		hosts.put(antiJoinNodeName, "127.0.0.1");
		hosts.put(productionNodeName, "127.0.0.1");
		
		actorClasses.put(switchPosition_switchActorName, UniquenessEnforcerNode.class);
		actorClasses.put(route_switchPositionActorName, UniquenessEnforcerNode.class);
		actorClasses.put(trackElement_sensorActorName, UniquenessEnforcerNode.class);
		actorClasses.put(route_routeDefinitionActorName, UniquenessEnforcerNode.class);
		actorClasses.put(joinNode1Name, NaturalJoinNode.class);
		actorClasses.put(joinNode2Name, NaturalJoinNode.class);
		actorClasses.put(antiJoinNodeName, ExistenceNode.class);
		actorClasses.put(productionNodeName, ProductionNode.class);
				
		// UniquenessEnforcerNodes' data
		// UniquenessEnforcerNode: SwitchPosition_switchActor
		final String switchPosition_switchLabel = "SwitchPosition_switch";
		final UniquenessEnforcerNodeConfiguration switchPosition_switchConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath(joinNode1Name),
				switchPosition_switchLabel, JoinSide.PRIMARY, type, filename);
		configurations.put(switchPosition_switchActorName, switchPosition_switchConf);

		// UniquenessEnforcerNode: Route_switchPositionActor
		final String route_switchPositionLabel = "Route_switchPosition";
		final UniquenessEnforcerNodeConfiguration route_switchPositionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath(joinNode1Name),
				route_switchPositionLabel, JoinSide.SECONDARY, type, filename);
		configurations.put(route_switchPositionActorName, route_switchPositionConf);

		// UniquenessEnforcerNode: TrackElement_sensorActor
		final String trackElement_sensorLabel = "TrackElement_sensor";
		final UniquenessEnforcerNodeConfiguration trackElement_sensorConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath(joinNode2Name),
				trackElement_sensorLabel, JoinSide.SECONDARY, type, filename);
		configurations.put(trackElement_sensorActorName, trackElement_sensorConf);

		// UniquenessEnforcerNode: Route_routeDefinitionActor
		final String route_routeDefinitionLabel = "Route_routeDefinition";
		final UniquenessEnforcerNodeConfiguration route_routeDefinitionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, RouteSensorConfiguration.getActorPath(antiJoinNodeName),
				route_routeDefinitionLabel, JoinSide.SECONDARY, type, filename);
		configurations.put(route_routeDefinitionActorName, route_routeDefinitionConf);
		
		// JoinNode: JoinNode1
		final TupleMask join1LeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0)), null); // [Sp], Sw
		final TupleMask join1RightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(1)), null); // R, [Sp]
		final JoinNodeConfiguration joinNode1Configuration = new JoinNodeConfiguration(coordinator, join1LeftMask,
				join1RightMask,
				RouteSensorConfiguration.getActorPath(joinNode2Name),
				JoinSide.PRIMARY);
		configurations.put(joinNode1Name, joinNode1Configuration);
		
		// JoinNode: JoinNode2
		final TupleMask join2LeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(1)), null); // Sp, [Sw], R
		final TupleMask join2RightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0)), null); // [Te], S
		final JoinNodeConfiguration joinNode2Configuration = new JoinNodeConfiguration(coordinator, join2LeftMask,
				join2RightMask, RouteSensorConfiguration.getActorPath(antiJoinNodeName),
				JoinSide.PRIMARY);
		configurations.put(joinNode2Name, joinNode2Configuration);
		
		// AntiJoinNode: AntiJoinNode
		final TupleMask antiJoinLeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(2, 3)), null); // Sp, Sw, [R], [Sen]
		final TupleMask antiJoinRightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0, 1)), null); // [R], [Sen]
		final JoinNodeConfiguration antiJoinNodeConfiguration = new JoinNodeConfiguration(coordinator, antiJoinLeftMask,
				antiJoinRightMask, RouteSensorConfiguration.getActorPath(productionNodeName),
				JoinSide.NULL);
		configurations.put(antiJoinNodeName, antiJoinNodeConfiguration);

		// ProductionNode: ProductionNode
		final ProductionNodeConfiguration productionNodeConfiguration = new ProductionNodeConfiguration(coordinator);
		configurations.put(productionNodeName, productionNodeConfiguration);
		
		// iterating through the hosts map
		for (final Map.Entry<String, String> actor : hosts.entrySet()) {
			deployActor(actor.getKey());
		}
		
	}
	
	private void deployActor(final String name) {
		final String host = hosts.get(name);
		final ReteNodeConfiguration configuration = configurations.get(name);
		final Class actorClass = actorClasses.get(name); 
		
		final Address addr = new Address("akka", actorSystemName, host, 2552);
		final Deploy deploy = new Deploy(new RemoteScope(addr));
		final ActorRef actor = system.actorOf(new Props(actorClass).withDeploy(deploy), name);
		actor.tell(configuration, null);
	}

}
