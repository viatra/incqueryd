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

	protected List<ActorContainer> actorContainers = new ArrayList<>();
	protected ActorContainer route_routeDefinitionActor;
	protected ActorContainer productionNode;
	protected boolean edited = false;
	protected int editCount = 50;

	/**
	 * Coordinator constructor. Instantiates the different actors.
	 */
	public Coordinator() {
		super();

		// posLength();
		routeSensor();
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message == NodeMessage.INITIALIZED) {
			initialized(getSender().path());
		}

		else if (message == NodeMessage.DONE) {
			done(getSender().path());
		}

		else if (message instanceof UpdateMessage) {
			UpdateMessage u = (UpdateMessage) message;
			processResult(u.getTuples());
		}

		else {
			unhandledMessage(message);
		}
	}

	protected void done(ActorPath actorPath) {
		System.out.println("done: " + actorPath);

		for (ActorContainer actorContainer : actorContainers) {
			if (actorContainer.actorRef.path().equals(actorPath)) {
				actorContainer.todo = false;
			}
		}

		boolean todo = false;
		for (ActorContainer actorContainer : actorContainers) {
			todo |= actorContainer.todo;
		}

		if (!todo) {
			System.out.println("Propagation done...");

			if (edited) {
				System.out.println("Edit done!");
				BenchmarkResult.INSTANCE.addEditTime();
				BenchmarkResult.INSTANCE.startStopper();
				edited = false;
			}

			System.out.println("Retrieving result...");
			productionNode.actorRef.tell(NodeMessage.GETRESULT, getSelf());
		}
	}

	private void processResult(Collection<Tuple> collection) {
		int result = collection.size();
		System.out.println("Result size is -------------> " + result);
		
		if (editCount == 0) {
			System.out.println("edits done");
			System.out.println(BenchmarkResult.INSTANCE.toString());
			System.exit(0);
		}

		// initiate edit phase
		BenchmarkResult.INSTANCE.addCheckTime();
		BenchmarkResult.INSTANCE.addInvalid(result);
		BenchmarkResult.INSTANCE.startStopper();

		EditMessage editMessage = new EditMessage();
		editCount--;
		System.out.println(editCount + " edits left");
		route_routeDefinitionActor.todo = true;
		route_routeDefinitionActor.actorRef.tell(editMessage, getSelf());
		edited = true;

		// } else {
		// BenchmarkResult.INSTANCE.addCheckTime();
		// System.exit(0);
	}

	private void initialized(ActorPath actorPath) {
		for (ActorContainer actorContainer : actorContainers) {
			if (actorContainer.actorRef.path().equals(actorPath)) {
				actorContainer.initialized = true;
			}
		}

		boolean allInitialized = true;
		for (ActorContainer actorContainer : actorContainers) {
			allInitialized &= actorContainer.initialized;
		}

		if (allInitialized) {
			System.out.println("All initialized.");

			for (ActorContainer actorContainer : actorContainers) {
				if (actorContainer.startSignal) {
					System.out.println("starting: " + actorContainer.actorRef);
					actorContainer.todo = true;
					actorContainer.actorRef.tell(CoordinatorMessage.START, getSelf());
				}
			}
		}
	}

	// @SuppressWarnings("serial")
	protected void posLength() {
		// // UniquenessEnforcerNode's data
		// final String segmentsQuery =
		// "START n = node:node_auto_index(type = \"Segment\") " +
		// "RETURN n.idx AS nodeId, n.Segment_length AS segmentLength";
		// final String[] segmentsColumns = new String[] { "nodeId",
		// "segmentLength" };
		//
		// // TrimmerNode's data
		// List<Integer> mask = new ArrayList<>(Arrays.asList(0, 1));
		// ConditionExpression conditionExpression = new ConditionExpression(1,
		// ComparisonOperator.LESS_THAN_OR_EQUAL, 0);
		// List<ConditionExpression> conditionExpressions = new ArrayList<>();
		// conditionExpressions.add(conditionExpression);
		// final TupleMask tupleMask = new TupleMask(mask,
		// conditionExpressions);
		//
		// // instantiating
		// ActorContainer uniquenessEnforcerNodeActor = new
		// ActorContainer(true);
		// actorContainers.add(uniquenessEnforcerNodeActor);
		// uniquenessEnforcerNodeActor.actorRef = getContext().actorOf(new
		// Props(new UntypedActorFactory() {
		// public UntypedActor create() {
		// return null; // new UniquenessEnforcerNode(getSelf(),
		// // segmentsQuery, segmentsColumns,
		// // "akka://ReteNet/user/Coordinator/TrimmerNodeActor",
		// // JoinSide.NULL);
		// }
		// }), "UniquenessEnforcerActor");
		//
		// ActorContainer trimmerNodeActor = new ActorContainer(false);
		// actorContainers.add(trimmerNodeActor);
		// trimmerNodeActor.actorRef = getContext().actorOf(new Props(new
		// UntypedActorFactory() {
		// public UntypedActor create() {
		// return new TrimmerNode(getSelf(), tupleMask,
		// "akka://ReteNet/user/Coordinator/ProductionNodeActor",
		// JoinSide.NULL);
		// }
		// }), "TrimmerNodeActor");
		//
		// ActorContainer productionNodeActor = new ActorContainer(false);
		// actorContainers.add(productionNodeActor);
		// productionNodeActor.actorRef = getContext().actorOf(new Props(new
		// UntypedActorFactory() {
		// public UntypedActor create() {
		// return new ProductionNode();
		// }
		// }), "ProductionNodeActor");
	}

	private void routeSensor() {
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

	protected ActorContainer createActorContainer(String actorName, boolean startSignal) {
		ActorContainer actorContainer = new ActorContainer(startSignal);
		actorContainer.actorRef = getContext().actorFor(RouteSensorConfiguration.getActorPath(actorName));
		actorContainers.add(actorContainer);
		return actorContainer;
	}
}
