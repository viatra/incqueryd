package clustergraphloader.actors;

/**
 * Coordinator actor.
 * @author szarnyasg
 *
 */
import java.util.List;

import org.apache.log4j.Logger;

import akka.actor.ActorRef;
import akka.actor.PoisonPill;
import clustergraphloader.data.Status;
import clustergraphloader.database.ClientFacade;
import clustergraphloader.graphml.GraphMlParserFirstPass;
import clustergraphloader.graphml.XmlSegment;
import clustergraphloader.helper.Timer;
import clustergraphloader.messages.ActorMessage;
import clustergraphloader.messages.CoordinatorConfig;
import clustergraphloader.messages.LoadMessage;

public class Coordinator extends ClusterGraphLoaderActor {

	protected int todos;
	protected int databaseCount;
	protected int percent = 10;
	protected List<ActorRef> actors; 
	protected final Logger logger = Logger.getLogger(Coordinator.class);
	
	public Coordinator() {
		super();
	}

	@Override
	public void onReceive(Object message) throws Exception {
		super.onReceive(message);

		if (message instanceof CoordinatorConfig) {
			CoordinatorConfig config = (CoordinatorConfig) message;
			load(config);
		}

		else if (message == ActorMessage.READY) {
			todos--;
			percent = 50 + (databaseCount - todos) * (50 / databaseCount);

			if (todos == 0) {
				percent = 100;
				System.out.println("done");
				
				// poison the db loader actors
				for (ActorRef actorRef : actors) {
					actorRef.tell(PoisonPill.getInstance(), null);
				}

				Timer.instance.stopTimer();
			}
		}

		else if (message == ActorMessage.STATUS) {
			returnStatus();
		}

		else {
			unhandledMessage(message);
		}
	}

	private void returnStatus() {
		Status status = new Status(percent);
		getSender().tell(status, getSelf());
	}

	protected void load(CoordinatorConfig config) {
		actors = config.getActors();
		databaseCount = actors.size();
		String fileName = config.getFileName();

		String cassandraIp = config.getCassandraIp();
		ClientFacade client = new ClientFacade(cassandraIp);
		client.resetDatabase();
		client.close();

		// running the first pass on the Coordinator itself
		GraphMlParserFirstPass graphMlParser1 = new GraphMlParserFirstPass(fileName, databaseCount);
		graphMlParser1.parseSegments();


		// setting the number of todos
		// WARNING: we are relying on "exactly once" semantics here which won't
		// work in the real work (i.e. WAN)
		todos = databaseCount;

		// retrieving the results from the first pass
		List<XmlSegment> nodeSegments = graphMlParser1.getNodeSegments();
		List<XmlSegment> edgeSegments = graphMlParser1.getEdgeSegments();

		// running the second pass on the remote nodes
		for (int i = 0; i < nodeSegments.size(); i++) {
			System.out.println(nodeSegments.get(i));
			System.out.println(edgeSegments.get(i));

			ActorRef dbLoader = actors.get(i);
			XmlSegment[] xmlSegments = { nodeSegments.get(i), edgeSegments.get(i) };
			LoadMessage loadMessage = new LoadMessage(fileName, xmlSegments);
			dbLoader.tell(loadMessage, getSelf());
		}

		percent = 50;

	}

}
