package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.messages.ReadyMessage;
import hu.bme.mit.incqueryd.rete.messages.UpdateMessage;

import java.util.Stack;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public abstract class IncQueryDActor extends UntypedActor {

    protected LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    protected String targetActorPath;
    protected ActorRef targetActor;
    protected ActorRef coordinator;

    // sentUpdates is a <target, source route> map
    // protected Map<ActorRef, Stack<ActorRef>> sentUpdates = new HashMap<>();

    public IncQueryDActor() {
        super();

        logger.info(actorString() + " " + this.getClass().getSimpleName() + " constructor called.");
    }

    protected String actorString() {
        return "[" + getSelf().path() + "]";
    }

    @Override
    public void onReceive(final Object message) throws Exception {
        logger.info(actorString() + " Onreceive " + message);

        if (message instanceof ReadyMessage) {
            final ReadyMessage readyMessage = (ReadyMessage) message;
            readyByMessage(readyMessage);
        }

        else if (message instanceof IncQueryDConfiguration) {
            final IncQueryDConfiguration configuration = (IncQueryDConfiguration) message;
            configure(configuration);
        }
    }

    protected abstract void configure(final IncQueryDConfiguration incQueryDConfiguration);

    protected void sendUpdateMessage(final Stack<ActorRef> source, final UpdateMessage message) {
        logger.info("source stack is: " + source);

        final Stack<ActorRef> senderStack = new Stack<>();
        senderStack.addAll(source);
        senderStack.push(getSelf());

        logger.info(actorString() + " sending " + message.getTuples().size() + " tuples to " + targetActorPath
                + ", nodeSlot = " + message.getNodeSlot() + ", propagated update type = " + message.getUpdateType()
                + ", sender stack is: " + senderStack);

        // we're setting the message's sender stack just here
        message.setSender(senderStack);

        // sentUpdates.put(targetActor, senderStack);
        targetActor.tell(message, getSelf());
    }

    protected void readyImmediately(final UpdateMessage receivedUpdateMessage) {
        final Stack<ActorRef> route = receivedUpdateMessage.getSender();
        final ActorRef sender = route.pop();

        logger.info(actorString() + " ready immediately, telling ReadyMessage to " + sender
                + " with the following route: " + route);
        sender.tell(new ReadyMessage(route), getSelf());
    }

    protected void readyByMessage(final ReadyMessage readyMessage) {
        final Stack<ActorRef> route = readyMessage.getRoute();
        final ActorRef sender = route.pop();

        logger.info(actorString() + " ready by message, telling ReadyMessage to " + sender
                + " with the following route: " + route);
        sender.tell(new ReadyMessage(route), getSelf());
    }

}
