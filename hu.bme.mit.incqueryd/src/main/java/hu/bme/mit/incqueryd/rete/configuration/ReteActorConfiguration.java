package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class ReteActorConfiguration extends IncQueryDConfiguration {

    private static final long serialVersionUID = 1L;

    protected ActorRef coordinator;
    protected ActorRef targetActorRef;
    protected ReteNodeSlot targetNodeSlot;

    public ReteActorConfiguration(final ActorRef coordinator, final ActorRef targetActorRef, final ReteNodeSlot targetNodeSlot) {
        super();
        this.coordinator = coordinator;
        this.targetActorRef = targetActorRef;
        this.targetNodeSlot = targetNodeSlot;
    }
    
    public ActorRef getCoordinator() {
        return coordinator;
    }
    
    public ActorRef getTargetActorRef() {
        return targetActorRef;
    }
    
}
