package distributed.rete.actors.controllers;

import hu.bme.mit.train.util.BenchmarkResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import akka.actor.ActorPath;
import distributed.constants.RouteSensorConfiguration;
import distributed.rete.actors.ReteActor;
import distributed.rete.actors.messages.CoordinatorMessage;
import distributed.rete.actors.messages.EditMessage;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.datastructure.Tuple;

public class Coordinator extends ReteActor {

	// constants
	protected final int editCountTotal = 5;
	
	// variables
	protected List<ActorContainer> actorContainers = new ArrayList<>();
	protected ActorContainer route_routeDefinitionActor;
	protected ActorContainer productionNode;
	protected boolean edited = false;
	protected int editCountRemaining = editCountTotal;

	/**
	 * Coordinator constructor. Instantiates the different actors.
	 */
	public Coordinator() {
		super();
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

		for (final ActorContainer actorContainer : actorContainers) {
			if (actorContainer.actorRef.path().equals(actorPath)) {
				actorContainer.todo = false;
			}
		}

		boolean todo = false;
		for (final ActorContainer actorContainer : actorContainers) {
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
		
		for (final ActorContainer actorContainer : actorContainers) {
			final String path2 = actorContainer.actorRef.path().name();
			final String[] splitted2 = path2.split("/");
			final String actorName2 = splitted2[splitted2.length - 1];

			//System.out.println();
			//if (actorContainer.actorRef.path().equals(actorPath)) {
			if (actorName1.equals(actorName2)) {
				actorContainer.initialized = true;
			}
		}

		boolean allInitialized = true;
		for (final ActorContainer actorContainer : actorContainers) {
			allInitialized &= actorContainer.initialized;
		}

		if (allInitialized) {
			logger.info("All initialized.");

			for (final ActorContainer actorContainer : actorContainers) {
				if (actorContainer.startSignal) {
					logger.info("Starting actor: " + actorContainer.actorRef);
					actorContainer.todo = true;
					actorContainer.actorRef.tell(CoordinatorMessage.START, getSelf());
				}
			}
		}
	}

	protected void routeSensor() {
		// putting actors to ActorContainers
		createActorContainer("SwitchPosition_switchActor", true);
		createActorContainer("Route_switchPositionActor", true);
		createActorContainer("TrackElement_sensorActor", true);
		route_routeDefinitionActor = createActorContainer("Route_routeDefinitionActor", true);
		createActorContainer("JoinNode1", false);
		createActorContainer("JoinNode2", false);
		createActorContainer("AntiJoinNode", false);
		productionNode = createActorContainer("ProductionNode", false);
	}

	protected ActorContainer createActorContainer(final String actorName, final boolean startSignal) {
		final ActorContainer actorContainer = new ActorContainer(startSignal);
		actorContainer.actorRef = getContext().actorFor(RouteSensorConfiguration.getActorPath(actorName, "127.0.0.1"));
		actorContainers.add(actorContainer);
		return actorContainer;
	}
}
