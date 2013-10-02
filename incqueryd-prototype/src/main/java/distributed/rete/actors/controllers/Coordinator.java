package distributed.rete.actors.controllers;

import hu.bme.mit.train.util.BenchmarkResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import akka.actor.ActorPath;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.remote.RemoteScope;
import distributed.rete.actors.ExistenceNode;
import distributed.rete.actors.InputNode;
import distributed.rete.actors.NaturalJoinNode;
import distributed.rete.actors.ProductionNode;
import distributed.rete.actors.ReteActor;
import distributed.rete.actors.messages.CoordinatorMessage;
import distributed.rete.actors.messages.EditMessage;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.configuration.JoinNodeConfiguration;
import distributed.rete.configuration.ProductionNodeConfiguration;
import distributed.rete.configuration.ReteNodeConfiguration;
import distributed.rete.configuration.UniquenessEnforcerNodeConfiguration;
import distributed.rete.database.DatabaseClientType;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.Tuple;
import distributed.rete.datastructure.TupleMask;

public class Coordinator extends ReteActor {

	// constants
	protected final int editCountTotal = 5;

	// variables
	protected Map<String, ActorContainer> actors = new HashMap<>();
	protected ActorContainer route_routeDefinitionActor;
	protected ActorContainer productionNode;
	protected boolean edited = false;
	protected int editCountRemaining = editCountTotal;

	// constants
	protected final DatabaseClientType type = DatabaseClientType.FOURSTORE;
	protected final String filename = "/home/szarnyasg/hdd/models/owl/testBig_User_1";

	/**
	 * Coordinator constructor. Instantiates the different actors.
	 */
	public Coordinator() {
		super();

		coordinator = getSelf();
		routeSensor();
	}

	@Override
	public void onReceive(final Object message) throws Exception {
		if (message == NodeMessage.INITIALIZED) {
			initialized(getSender().path());
		}

		else if (message == NodeMessage.DONE) {
			done(getSender().path());
		}

		else if (message instanceof UpdateMessage) {
			final UpdateMessage u = (UpdateMessage) message;
			processResult(u.getTuples());
		}

		else {
			unhandledMessage(message);
		}
	}

	protected void done(final ActorPath actorPath) {
		logger.info("Actor done: " + actorPath);

		for (final ActorContainer actorContainer : actors.values()) {
			if (actorContainer.actorRef.path().equals(actorPath)) {
				actorContainer.todo = false;
			}
		}

		boolean todo = false;
		for (final ActorContainer actorContainer : actors.values()) {
			todo |= actorContainer.todo;
		}

		if (!todo) {
			if (edited) {
				logger.info("All actors done, edit propagation completed.");
				BenchmarkResult.INSTANCE.addEditTime();
				BenchmarkResult.INSTANCE.startStopper();
				edited = false;
			} else {
				logger.info("All actors done, initialization completed.");
			}

			logger.info("Retrieving result...");
			productionNode.actorRef.tell(NodeMessage.GETRESULT, getSelf());
		}
	}

	protected void processResult(final Collection<Tuple> collection) {
		final int result = collection.size();
		logger.info("Result size is " + result + ".");

		if (editCountRemaining == 0) {
			logger.info("Edits done.");
			logger.info("Benchmark result is:");
			logger.info(BenchmarkResult.INSTANCE.toString());
			logger.info("Benchmark finished, exiting.");
			try {
				Thread.sleep(500);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}

		// initiate edit phase
		BenchmarkResult.INSTANCE.addCheckTime();
		BenchmarkResult.INSTANCE.addInvalid(result);
		BenchmarkResult.INSTANCE.startStopper();

		final EditMessage editMessage = new EditMessage();
		editCountRemaining--;
		logger.info(editCountRemaining + " edits left.");
		route_routeDefinitionActor.todo = true;
		route_routeDefinitionActor.actorRef.tell(editMessage, getSelf());
		edited = true;
	}

	protected void initialized(final ActorPath actorPath) {
		logger.info("Received initialized from " + actorPath);

		final String path1 = actorPath.name();
		final String[] splitted1 = path1.split("/");
		final String actorName1 = splitted1[splitted1.length - 1];

		for (final ActorContainer actorContainer : actors.values()) {
			final String path2 = actorContainer.actorRef.path().name();
			final String[] splitted2 = path2.split("/");
			final String actorName2 = splitted2[splitted2.length - 1];

			// System.out.println();
			// if (actorContainer.actorRef.path().equals(actorPath)) {
			if (actorName1.equals(actorName2)) {
				actorContainer.initialized = true;
			}
		}

		boolean allInitialized = true;
		for (final ActorContainer actorContainer : actors.values()) {
			allInitialized &= actorContainer.initialized;
		}

		if (allInitialized) {
			logger.info("All initialized.");

			for (final ActorContainer actorContainer : actors.values()) {
				if (actorContainer.startSignal) {
					logger.info("Starting actor: " + actorContainer.actorRef);
					actorContainer.todo = true;
					actorContainer.actorRef.tell(CoordinatorMessage.START, getSelf());
				}
			}
		}
	}

	protected void routeSensor() {
		final String switchPosition_switchActorName = "SwitchPosition_switchActor";
		final String route_switchPositionActorName = "Route_switchPositionActor";
		final String trackElement_sensorActorName = "TrackElement_sensorActor";
		final String route_routeDefinitionActorName = "Route_routeDefinitionActor";
		final String joinNode1Name = "JoinNode1";
		final String joinNode2Name = "JoinNode2";
		final String antiJoinNodeName = "AntiJoinNode";
		final String productionNodeName = "ProductionNode";


//		final String ip = "10.6.21.191";
		final String ip = "127.0.0.1";
		//final String coordinatorPath = ip;
		
		// putting actors to ActorContainers
		
		actors.put(switchPosition_switchActorName, new ActorContainer(true,  ip, InputNode.class));
		actors.put(route_switchPositionActorName, new ActorContainer(true, ip, InputNode.class));
		actors.put(trackElement_sensorActorName, new ActorContainer(true, ip, InputNode.class));
		actors.put(route_routeDefinitionActorName, new ActorContainer(true, ip, InputNode.class));
		actors.put(joinNode1Name, new ActorContainer(false, ip, NaturalJoinNode.class));
		actors.put(joinNode2Name, new ActorContainer(false, ip, NaturalJoinNode.class));
		actors.put(antiJoinNodeName, new ActorContainer(false, ip, ExistenceNode.class));
		actors.put(productionNodeName, new ActorContainer(false, ip, ProductionNode.class));

		route_routeDefinitionActor = actors.get(route_routeDefinitionActorName);
		productionNode = actors.get(productionNodeName);
		
		// iterating through the hosts map to get all actors
		deployActors();
		
		// UniquenessEnforcerNodes' data
		// UniquenessEnforcerNode: SwitchPosition_switchActor
		final String switchPosition_switchLabel = "SwitchPosition_switch";
		final UniquenessEnforcerNodeConfiguration switchPosition_switchConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, actors.get(joinNode1Name).actorRef.path().toString(),
				switchPosition_switchLabel, JoinSide.PRIMARY, type, filename);
		actors.get(switchPosition_switchActorName).configuration = switchPosition_switchConf;

		// UniquenessEnforcerNode: Route_switchPositionActor
		final String route_switchPositionLabel = "Route_switchPosition";
		final UniquenessEnforcerNodeConfiguration route_switchPositionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, actors.get(joinNode1Name).actorRef.path().toString(),
				route_switchPositionLabel, JoinSide.SECONDARY, type, filename);
		actors.get(route_switchPositionActorName).configuration = route_switchPositionConf;
		
		// UniquenessEnforcerNode: TrackElement_sensorActor
		final String trackElement_sensorLabel = "TrackElement_sensor";
		final UniquenessEnforcerNodeConfiguration trackElement_sensorConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, actors.get(joinNode2Name).actorRef.path().toString(),
				trackElement_sensorLabel, JoinSide.SECONDARY, type, filename);
		actors.get(trackElement_sensorActorName).configuration = trackElement_sensorConf;

		// UniquenessEnforcerNode: Route_routeDefinitionActor
		final String route_routeDefinitionLabel = "Route_routeDefinition";
		final UniquenessEnforcerNodeConfiguration route_routeDefinitionConf = new UniquenessEnforcerNodeConfiguration(
				coordinator, actors.get(antiJoinNodeName).actorRef.path().toString(),
				route_routeDefinitionLabel, JoinSide.SECONDARY, type, filename);
		actors.get(route_routeDefinitionActorName).configuration = route_routeDefinitionConf;

		// JoinNode: JoinNode1
		final TupleMask join1LeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0)), null); // [Sp], Sw
		final TupleMask join1RightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(1)), null); // R, [Sp]
		final JoinNodeConfiguration joinNode1Configuration = new JoinNodeConfiguration(coordinator, join1LeftMask,
				join1RightMask, actors.get(joinNode2Name).actorRef.path().toString(), JoinSide.PRIMARY);
		actors.get(joinNode1Name).configuration = joinNode1Configuration;

		// JoinNode: JoinNode2
		final TupleMask join2LeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(1)), null); // Sp, [Sw], R
		final TupleMask join2RightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0)), null); // [Te], S
		final JoinNodeConfiguration joinNode2Configuration = new JoinNodeConfiguration(coordinator, join2LeftMask,
				join2RightMask, actors.get(antiJoinNodeName).actorRef.path().toString(), JoinSide.PRIMARY);
		actors.get(joinNode2Name).configuration = joinNode2Configuration;

		// AntiJoinNode: AntiJoinNode
		final TupleMask antiJoinLeftMask =
				new TupleMask(new ArrayList<>(Arrays.asList(2, 3)), null); // Sp, Sw, [R], [Sen]
		final TupleMask antiJoinRightMask =
				new TupleMask(new ArrayList<>(Arrays.asList(0, 1)), null); // [R], [Sen]
		final JoinNodeConfiguration antiJoinNodeConfiguration = new JoinNodeConfiguration(coordinator, antiJoinLeftMask,
				antiJoinRightMask, actors.get(productionNodeName).actorRef.path().toString(), JoinSide.NULL);
		actors.get(antiJoinNodeName).configuration = antiJoinNodeConfiguration;

		// ProductionNode: ProductionNode
		final ProductionNodeConfiguration productionNodeConfiguration = new ProductionNodeConfiguration(coordinator);
		actors.get(productionNodeName).configuration = productionNodeConfiguration;

		// iterating through the hosts map to get all actors
		configureActors();
	}

	protected void deployActors() {
		for (final Map.Entry<String, ActorContainer> actorContainerPair : actors.entrySet()) {
			
			final String name = actorContainerPair.getKey();
			final ActorContainer actor = actorContainerPair.getValue();
			
			final String host = actor.host;
			final Class actorClass = actor.actorClass;
			final Address addr = new Address("akka", "ReteNet", host, 2552);
			final Deploy deploy = new Deploy(new RemoteScope(addr));
			System.out.println("deploying " + actor + " to " + host);
			// final ActorRef actor = system.actorOf(new Props(actorClass).withDeploy(deploy), name);
			
			// saving the reference for later use
			actor.actorRef = getContext().actorOf(new Props(actorClass).withDeploy(deploy), name);			
		}		
	}

	private void configureActors() {
		// telling the configuration object to each actor
		for (final ActorContainer actor: actors.values()) {
			actor.actorRef.tell(actor.configuration, null);
		}
	}

	@Override
	protected void configure(final ReteNodeConfiguration reteNodeConfiguration) {
		// TODO Auto-generated method stub
		// TODO refactor so this won't have to be here
		
	}

}
