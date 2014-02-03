package hu.bme.mit.incqueryd.rete.messages;

import java.io.Serializable;
import java.util.Stack;

import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class ReadyMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    protected Stack<ActorRef> route;

    public ReadyMessage(final Stack<ActorRef> route) {
        super();
        this.route = route;
    }

    public Stack<ActorRef> getRoute() {
        return route;
    }

}
