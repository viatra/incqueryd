package hu.bme.mit.incqueryd.rete.actors.temp;

import hu.bme.mit.incqueryd.databases.DatabaseClient;
import hu.bme.mit.incqueryd.databases.DatabaseClientFactory;
import hu.bme.mit.incqueryd.exceptions.DatabaseClientException;
import hu.bme.mit.incqueryd.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.UniquenessEnforcerNodeConfiguration;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleImpl;
import hu.bme.mit.incqueryd.rete.messages.ActorMessage;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorMessage;
import hu.bme.mit.incqueryd.rete.messages.EditMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

import org.apache.cassandra.transport.messages.ReadyMessage;

import akka.actor.ActorRef;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class InputActor extends ReteActor {

    protected Set<Tuple> tuples = new HashSet<>();
    protected List<DatabaseClient> clients = new ArrayList<>();
    protected ReteNodeSlot nodeSlot;
    protected int updateMessageCount = 0;
    protected DatabaseClient databaseClient;
    protected String edgeLabel;

    public InputActor() {
        super();
    }

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final UniquenessEnforcerNodeConfiguration configuration = (UniquenessEnforcerNodeConfiguration) incQueryDConfiguration;

        this.coordinator = configuration.getCoordinator();
        this.targetActorRef = configuration.getTargetActorRef();
        this.nodeSlot = configuration.targetNodeSlot;

        // databaseClient = DatabaseClientFactory.createDatabaseClient(configuration.databaseClientType, "localhost",
        // configuration.filename);
        databaseClient = DatabaseClientFactory.createDatabaseClient(configuration.databaseClientType, "vcl0",
                configuration.filename);

        try {
            Multimap<Object, Object> vertexPairs;
            edgeLabel = configuration.edgeLabel;
            vertexPairs = databaseClient.collectEdges(edgeLabel);

            for (final Object key : vertexPairs.keySet()) {
                final Collection<?> values = vertexPairs.get(key);

                for (final Object value : values) {
                    final Tuple tuple = new TupleImpl(key, value);
                    tuples.add(tuple);
                }
            }
        } catch (final DatabaseClientException e) {
            e.printStackTrace();
        }
        // logger.info("multimap received: " + vertexPairs);


        coordinator.tell(ActorMessage.INITIALIZED, getSelf());
    }

    @Override
    public void onReceive(final Object message) throws Exception {
        // super.onReceive(message);

        if (message instanceof ReadyMessage) {
            logger.info(actorString() + " ready message received.");
            updateMessageCount--;
            logger.info(updateMessageCount + " update messages pending.");
            if (updateMessageCount == 0) {
                logger.info(actorString() + " ready");
                coordinator.tell(ActorMessage.DONE, getSelf());
            }
        }

        else if (message == CoordinatorMessage.START) {
            logger.info("[" + getSelf().path() + "] start received.");
            sendTuples(UpdateType.POSITIVE, nodeSlot, tuples);
        }

        else if (message instanceof EditMessage) {
            logger.info("editMessage received");
            edit();
        }

        else if (message instanceof UniquenessEnforcerNodeConfiguration) {
            final UniquenessEnforcerNodeConfiguration configurationMessage = (UniquenessEnforcerNodeConfiguration) message;
            configure(configurationMessage);
        }
    }

    private void edit() {
        final Set<Tuple> negTuples = new HashSet<>(); // n.b. Vector is synchronized
        // TODO
        // - do we need synchronization?
        // - if we do, is HashSet synchronized?

        // Collections.sort(tuples);
        final Multimap<Object, Object> routeAndSensorIds = ArrayListMultimap.create();
        for (final Tuple tuple : tuples) {
            final Object routeId = tuple.get(0);
            final Object sensorId = tuple.get(1);
            routeAndSensorIds.put(routeId, sensorId);
        }

        logger.info("routeAndSensorIds: ");
        // logger.info(routeAndSensorIds);

        // swift move: get the set of the routeAndSensorIds multimap and create an ArrayList from them
        final ArrayList<Object> routeIds = new ArrayList<>(routeAndSensorIds.keys().elementSet());
        // TODO
        // Collections.sort(routeIds);

        // logger.info("routeIds:" + routeIds);

        // randomly choosing some Routes to modify
        final List<Object> routesToModify = new ArrayList<>();

        // logger.info("#routeAndSensorIds: " + routeAndSensorIds.size());
        // logger.info("#routeIds: " + routeIds.size());

        final Random random = new Random(0);
        final int nElemToModify = 10;
        // choose nElemToModify elements to modify
        for (int i = 0; i < nElemToModify; i++) {
            final int rndTargetPosition = random.nextInt(routeIds.size());
            final Object routeId = routeIds.get(rndTargetPosition);
            routesToModify.add(routeId);

            // small modification over the original TrainBenchmark: we always choose nElemToModify different Routes
            routeIds.remove(routeId);
        }

        for (final Map.Entry<Object, Object> row : routeAndSensorIds.entries()) {
            final Object routeId = row.getKey();
            final Object sensorId = row.getValue();

            if (routesToModify.contains(routeId)) {
                // removing the Route from the routesToModify list
                routesToModify.remove(routeId);
                // deleteCandidates.put(routeId, sensorId);

                // creating a tuple from the result row
                final Tuple tuple = new TupleImpl(routeId, sensorId);

                // deleting from indexer
                tuples.remove(tuple);

                // deleting from database
                try {
                    databaseClient.deleteEdge(routeId, sensorId, edgeLabel);
                } catch (final DatabaseClientException e) {
                    e.printStackTrace();
                }

                // adding the tuple to the negative update's tuples
                negTuples.add(tuple);
            }
        }

        logger.info("negative tuples: " + negTuples);
        logger.info(actorString() + " " + tuples.size() + " tuples remaining");

        final Long initTime = System.nanoTime();
        logger.info("waiting");

        final Long finishTime = System.nanoTime();
        final Long delta = (finishTime - initTime) / 1000000;
        logger.info("waiting over " + delta + " ms");

        logger.info(negTuples.size() + " tuples in the negative update to " + targetActorRef);
        sendTuples(UpdateType.NEGATIVE, nodeSlot, negTuples);
    }

    protected void sendTuples(final UpdateType updateType, final ReteNodeSlot nodeSlot, final Set<Tuple> tuples) {
        updateMessageCount++;

        // final UpdateMessage updateMessage = new UpdateMessage(updateType, nodeSlot, tuples);
        // start with an empty senderStack

        final Stack<ActorRef> senderStack = new Stack<>();
        // sendUpdateMessage(senderStack, updateMessage);
    }

}
