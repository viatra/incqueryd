package distributed.rete.actors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

import akka.actor.ActorRef;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import distributed.rete.actors.messages.CoordinatorMessage;
import distributed.rete.actors.messages.EditMessage;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.ReadyMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.actors.messages.UpdateType;
import distributed.rete.configuration.UniquenessEnforcerNodeConfiguration;
import distributed.rete.database.DatabaseClient;
import distributed.rete.database.DatabaseClientFactory;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.Tuple;
import distributed.rete.datastructure.TupleImpl;
import distributed.rete.exceptions.DatabaseClientException;

/**
 * Implementation for the UniquenessEnforcerNode. "UniquenessEnforcerNode has a memory that works like a multi-set (also
 * known as bag) and enforces the uniqueness principle." [Bergmann's MSc thesis, p.40]
 * 
 * @author szarnyasg
 * 
 */
public class InputNode extends ReteActor {

	protected List<Tuple> tuples = new ArrayList<>();
	protected List<DatabaseClient> clients = new ArrayList<>();
	protected JoinSide joinSide;
	protected int updateMessageCount = 0;
	protected DatabaseClient databaseClient;
	protected String edgeLabel;

	public InputNode() {
		super();
	}

	protected void configure(UniquenessEnforcerNodeConfiguration configuration) {
		this.coordinator = configuration.coordinator;
		this.targetActorPath = configuration.targetActorPath;
		this.joinSide = configuration.targetJoinSide;

		logger.info("YYYY: " + coordinator);

		databaseClient = DatabaseClientFactory.createDatabaseClient(configuration.databaseClientType, "localhost",
				configuration.filename);

		try {
			Multimap<Object, Object> vertexPairs;
			edgeLabel = configuration.edgeLabel;
			vertexPairs = databaseClient.collectEdges(edgeLabel);

			for (Object key : vertexPairs.keySet()) {
				Collection<?> values = vertexPairs.get(key);

				for (Object value : values) {
					Tuple tuple = new TupleImpl(key, value);
					tuples.add(tuple);
				}
			}
		} catch (DatabaseClientException e) {
			e.printStackTrace();
		}
		// logger.info("multimap received: " + vertexPairs);

		logger.info(actorString() + " " + tuples.size() + " tuples");
		logger.info(actorString() + " telling INITIALIZED to " + coordinator);

		coordinator.tell(NodeMessage.INITIALIZED, getSelf());
	}

	@Override
	public void onReceive(Object message) throws Exception {
		// super.onReceive(message);

		if (message instanceof ReadyMessage) {
			logger.info(actorString() + " ready message received.");
			updateMessageCount--;
			logger.info(updateMessageCount + " update messages pending.");
			if (updateMessageCount == 0) {
				logger.info(actorString() + " ready");
				coordinator.tell(NodeMessage.DONE, getSelf());
			}
		}

		else if (message == CoordinatorMessage.START) {
			logger.info("[" + getSelf().path() + "] start received.");
			targetActor = getContext().actorFor(targetActorPath);
			sendTuples(UpdateType.POSITIVE, joinSide, tuples);
		}

		else if (message instanceof EditMessage) {
			logger.info("editMessage received");
			edit();
		}

		else if (message instanceof UniquenessEnforcerNodeConfiguration) {
			UniquenessEnforcerNodeConfiguration configurationMessage = (UniquenessEnforcerNodeConfiguration) message;
			configure(configurationMessage);
		}

		else {
			unhandledMessage(message);
		}
	}

	private void edit() {
		Collection<Tuple> negTuples = new Vector<>(); // n.b. Vector is synchronized

		// Collections.sort(tuples);
		Multimap<Object, Object> routeAndSensorIds = ArrayListMultimap.create();
		for (Tuple tuple : tuples) {
			Object routeId = (Object) tuple.get(0);
			Object sensorId = (Object) tuple.get(1);
			routeAndSensorIds.put(routeId, sensorId);
		}

		logger.info("routeAndSensorIds: ");
		// logger.info(routeAndSensorIds);

		// swift move: get the set of the routeAndSensorIds multimap and create an ArrayList from them
		ArrayList<Object> routeIds = new ArrayList<>(routeAndSensorIds.keys().elementSet());
		// TODO
		// Collections.sort(routeIds);

		// logger.info("routeIds:" + routeIds);

		// randomly choosing some Routes to modify
		List<Object> routesToModify = new ArrayList<>();

		//logger.info("#routeAndSensorIds: " + routeAndSensorIds.size());
		//logger.info("#routeIds: " + routeIds.size());

		Random random = new Random(0);
		final int nElemToModify = 10;
		// choose nElemToModify elements to modify
		for (int i = 0; i < nElemToModify; i++) {
			int rndTargetPosition = random.nextInt(routeIds.size());
			Object routeId = routeIds.get(rndTargetPosition);
			routesToModify.add(routeId);

			// small modification over the original TrainBenchmark: we always choose nElemToModify different Routes
			routeIds.remove(routeId);
		}

		for (Map.Entry<Object, Object> row : routeAndSensorIds.entries()) {
			Object routeId = row.getKey();
			Object sensorId = row.getValue();

			if (routesToModify.contains(routeId)) {
				// removing the Route from the routesToModify list
				routesToModify.remove(routeId);
				// deleteCandidates.put(routeId, sensorId);

				// creating a tuple from the result row
				Tuple tuple = new TupleImpl(routeId, sensorId);

				// deleting from indexer
				tuples.remove(tuple);

				// deleting from database
				try {
					databaseClient.deleteEdge(routeId, sensorId, edgeLabel);
				} catch (DatabaseClientException e) {
					e.printStackTrace();
				}

				// adding the tuple to the negative update's tuples
				negTuples.add(tuple);
			}
		}

		logger.info("negative tuples: " + negTuples);
		logger.info(actorString() + " " + tuples.size() + " tuples remaining");

		Long initTime = System.nanoTime();
		logger.info("waiting");

		Long finishTime = System.nanoTime();
		Long delta = (finishTime - initTime) / 1000000;
		logger.info("waiting over " + delta + " ms");

		logger.info(negTuples.size() + " tuples in the negative update to " + targetActorPath);
		sendTuples(UpdateType.NEGATIVE, joinSide, negTuples);
	}

	protected void sendTuples(UpdateType updateType, JoinSide joinSide, Collection<Tuple> tuples) {
		updateMessageCount++;

		UpdateMessage updateMessage = new UpdateMessage(updateType, joinSide, tuples);
		// start with an empty senderStack

		Stack<ActorRef> senderStack = new Stack<>();
		sendUpdateMessage(senderStack, updateMessage);
	}

}
