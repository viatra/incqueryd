package distributed.rete.actors;

import java.util.Stack;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import distributed.rete.actors.messages.ReadyMessage;
import distributed.rete.actors.messages.UpdateMessage;

public abstract class ReteActor extends UntypedActor {

	//protected static final Logger logger = Logger.getLogger(Coordinator.class);		
	protected LoggingAdapter logger = Logging.getLogger(getContext().system(), this);
	
	protected String targetActorPath;
	protected ActorRef targetActor;
	protected ActorRef coordinator;

	// sentUpdates is a <target, source route> map
	// protected Map<ActorRef, Stack<ActorRef>> sentUpdates = new HashMap<>();

	public ReteActor() {
		super();
		
		logger.info(actorString() + " " + this.getClass().getSimpleName() + " constructor called.");
	}

	protected String actorString() {
		return "[" + getSelf().path() + "]";
	}

	@Override
	public void onReceive(Object message) throws Exception {
		logger.info(actorString() + " onreceive " + message);

		if (message instanceof ReadyMessage) {
			ReadyMessage readyMessage = (ReadyMessage) message;
			readyByMessage(readyMessage);
		}
	}

	protected void unhandledMessage(Object message) {
		unhandled(message);
		logger.info(actorString() + " Unhandled message " + message);
	}

	protected void sendUpdateMessage(Stack<ActorRef> source, UpdateMessage message) {
		logger.info("source stack is: " + source);

		Stack<ActorRef> senderStack = new Stack<>();
		senderStack.addAll(source);
		senderStack.push(getSelf());

		logger.info(actorString() + " sending tuples to: " + targetActorPath);
		logger.info(actorString() + " sending " + message.getTuples().size() + " tuples to " + targetActorPath + ", joinSide = " + message.getJoinSide()
				+ ", propagated update type = " + message.getUpdateType() + ", sender stack = >>>>>" + senderStack);

		// we're setting the message's sender stack just here
		message.setSender(senderStack);

		// sentUpdates.put(targetActor, senderStack);
		targetActor.tell(message, getSelf());
	}

	protected void readyImmediately(UpdateMessage receivedUpdateMessage) {
		Stack<ActorRef> route = receivedUpdateMessage.getSender();
		ActorRef sender = route.pop();

		logger.info(actorString() + " ready immediately, telling ReadyMessage to " + sender + " with route = <<<<<" + route);
		sender.tell(new ReadyMessage(route), getSelf());
	}

	protected void readyByMessage(ReadyMessage readyMessage) {
		Stack<ActorRef> route = readyMessage.getRoute();
		ActorRef sender = route.pop();

		logger.info(actorString() + " ready by message, telling ReadyMessage to " + sender + " with route = <<<<<" + route);
		sender.tell(new ReadyMessage(route), getSelf());
	}

}
