package distributed.rete.actors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import akka.actor.ActorRef;
import distributed.benchmark.RouteSensorBenchmark;
import distributed.constants.Constants;
import distributed.control.Delete;
import distributed.control.Edit;
import distributed.rete.actors.messages.CoordinatorMessage;
import distributed.rete.actors.messages.EditMessage;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.ReadyMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.actors.messages.UpdateType;
import distributed.rete.configuration.UniquenessEnforcerNodeConfiguration;
import distributed.rete.database.AsyncBulkInsertListener;
import distributed.rete.database.Neo4jClient;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.Tuple;
import distributed.rete.datastructure.TupleImpl;

/**
 * Implementation for the UniquenessEnforcerNode. "UniquenessEnforcerNode has a memory that works like a multi-set (also
 * known as bag) and enforces the uniqueness principle." [Bergmann's MSc thesis, p.40]
 * 
 * @author szarnyasg
 * 
 */
public class UniquenessEnforcerNode extends ReteActor {

	protected List<Tuple> tuples = new ArrayList<>();
	protected List<Neo4jClient> clients = new ArrayList<>();
	protected JoinSide joinSide;
	protected int updateMessageCount = 0;
	protected ActorRef coordinator;
	private long start;

	/**
	 * Default no-arg constructor for Akka.
	 */
	public UniquenessEnforcerNode() {
		super();
	}

	@Override
	public void onReceive(Object message) throws Exception {
		// super.onReceive(message);

		if (message instanceof ReadyMessage) {
			System.out.println(actorString() + " ready message received.");
			updateMessageCount--;
			System.out.println(updateMessageCount + " update messages pending.");
			if (updateMessageCount == 0) {
				System.out.println(actorString() + " ready");
				coordinator.tell(NodeMessage.DONE, getSelf());
			}
		}

		else if (message == CoordinatorMessage.START) {
			System.out.println("[" + getSelf().path() + "] start received.");
			targetActor = getContext().actorFor(targetActorPath);
			sendTuples(UpdateType.POSITIVE, joinSide, tuples);
		}

		else if (message instanceof UniquenessEnforcerNodeConfiguration) {
			UniquenessEnforcerNodeConfiguration configurationMessage = (UniquenessEnforcerNodeConfiguration) message;
			ActorRef coordinator = (ActorRef) configurationMessage.coordinator;
			String query = (String) configurationMessage.query;
			String[] columns = (String[]) configurationMessage.columns;
			String targetActorPath = (String) configurationMessage.targetActorPath;
			JoinSide targetJoinSide = (JoinSide) configurationMessage.targetJoinSide;

			configure(coordinator, query, columns, targetActorPath, targetJoinSide);
		}

		else if (message instanceof EditMessage) {
			System.out.println("editMessage received");
			edit();
		}

		else {
			unhandledMessage(message);
		}
	}

	protected int idToPartitionId(long x) {
		return (int) Math.floor(x / Math.pow(10, Math.floor(Math.log10(x)))) - 1;
	}

	private void edit() {
		// listing all (route)-[:ROUTE_ROUTEDEFINITION]->(sensor) relationships
		Collection<Tuple> negTuples = new Vector<>(); // n.b. Vector is synchronized

		// Collections.sort(tuples);
		Multimap<Long, Long> routeAndSensorIds = ArrayListMultimap.create();
		for (Tuple tuple : tuples) {
			Long routeId = (Long) tuple.get(0);
			Long sensorId = (Long) tuple.get(1);
			routeAndSensorIds.put(routeId, sensorId);
		}
		// System.out.println("routeAndSensorIds: " + routeAndSensorIds);

		// swift move: get the set of the routeAndSensorIds multimap and create an ArrayList from them
		ArrayList<Long> routeIds = new ArrayList<>(routeAndSensorIds.keys().elementSet());
		Collections.sort(routeIds);

		// System.out.println("routeIds:" + routeIds);

		int partitionCount = clients.size();
		// divide routeIds to four different parts
		List<List<Long>> routeIdPartitions = new ArrayList<>();
		for (int i = 0; i < partitionCount; i++) {
			routeIdPartitions.add(new ArrayList<Long>());
		}

		for (Long routeId : routeIds) {
			int partitionId = idToPartitionId(routeId);
			routeIdPartitions.get(partitionId).add(routeId);
		}
		
		CountDownLatch countDownLatch = new CountDownLatch(4);			
		for (int j = 0; j < partitionCount; j++) {
			List<Long> partitionRouteIds = routeIdPartitions.get(j);
			Neo4jClient client = clients.get(j);
			
			// randomly choosing some Routes to modify
			List<Long> routesToModify = new ArrayList<>();

			Random random = new Random(0);
			final int nElemToModify = 10;
			// choose nElemToModify elements to modify
			for (int i = 0; i < nElemToModify; i++) {
				int rndTargetPosition = random.nextInt(partitionRouteIds.size());
				Long routeToModify = partitionRouteIds.get(rndTargetPosition);
				routesToModify.add(routeToModify);

				// small modification over the original TrainBenchmark: we always choose nElemToModify different Routes
				partitionRouteIds.remove(routeToModify);
			}

			
			Thread thread = new Thread(new Delete(client, countDownLatch, routeAndSensorIds, routesToModify, negTuples));			
			thread.start();
		}
		
		long initTime = System.nanoTime();
		System.out.println("waiting");
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long finishTime = System.nanoTime();
		long delta = (finishTime - initTime) / 1000000;
		System.out.println("waiting over " + delta + " ms");
		
		System.out.println(negTuples.size() + " tuples in the negative update to " + targetActorPath);
		sendTuples(UpdateType.NEGATIVE, joinSide, negTuples);
	}

	private void deleteEdgeFromDatabase(Long routeId, Long sensorId) {
		System.out.println("delete edge: " + routeId + "-[ROUTE_ROUTEDEFINITION]->" + sensorId);
		Neo4jClient client = clients.get(idToPartitionId(routeId));
		client.deleteRouteRouteDefinitionEdge(routeId, sensorId);		
	}

	protected void configure(ActorRef coordinator, String query, String[] columns, String targetActorPath, JoinSide targetJoinSide) {
		this.coordinator = coordinator;
		this.targetActorPath = targetActorPath;
		this.joinSide = targetJoinSide;

		for (String vm : Constants.INSTANCE.VMs) {
			clients.add(new Neo4jClient(vm));
		}

		for (Neo4jClient client : clients) {
			Collection<Map<String, Object>> result = client.runCyperQuery(query);

			for (Map<String, Object> row : result) {
				Object tupleItems[] = new Object[columns.length];

				for (int i = 0; i < columns.length; i++) {
					Object o = row.get(columns[i]);
					tupleItems[i] = RouteSensorBenchmark.objectToLong(o);
				}

				Tuple tuple = new TupleImpl(tupleItems);
				tuples.add(tuple);

				// System.out.println("[" + getSelf().path() + "]: " + tuple);
			}

		}

		System.out.println(actorString() + " " + tuples.size() + " tuples");
		System.out.println(actorString() + " telling INITIALIZED to " + getSender());

		// do not close the clients to allow quick modifications
		// client.close();

		getSender().tell(NodeMessage.INITIALIZED, getSelf());
	}

	protected void sendTuples(UpdateType updateType, JoinSide joinSide, Collection<Tuple> tuples) {
		updateMessageCount++;

		UpdateMessage updateMessage = new UpdateMessage(updateType, joinSide, tuples);
		// start with an empty senderStack

		Stack<ActorRef> senderStack = new Stack<>();
		sendUpdateMessage(senderStack, updateMessage);
	}

}
