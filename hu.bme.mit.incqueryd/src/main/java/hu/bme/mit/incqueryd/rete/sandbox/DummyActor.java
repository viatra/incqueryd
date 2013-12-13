package hu.bme.mit.incqueryd.rete.sandbox;

import akka.actor.UntypedActor;

/**
 * Dummy actor for tinkering with the Akka test framework.
 * 
 * @author szarnyasg
 * 
 */
public class DummyActor extends UntypedActor {

    @Override
    public void onReceive(final Object msg) throws Exception {
        if (msg instanceof DummyMessage) {
            final DummyMessage receivedDummyMessage = (DummyMessage) msg;
            getSender().tell(new DummyMessage(receivedDummyMessage.getX() + 1), getSelf());
        }
    }

}
