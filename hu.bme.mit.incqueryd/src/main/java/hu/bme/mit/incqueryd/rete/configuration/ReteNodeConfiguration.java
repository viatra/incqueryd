package hu.bme.mit.incqueryd.rete.configuration;

import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class ReteNodeConfiguration extends IncQueryDConfiguration {

    private static final long serialVersionUID = 1L;

    protected ActorRef coordinator;
    protected ActorRef targetActorRef;

    public ReteNodeConfiguration(final ActorRef coordinator, final ActorRef targetActorRef) {
        super();
        this.coordinator = coordinator;
        this.targetActorRef = targetActorRef;
    }
    
    public ActorRef getCoordinator() {
        return coordinator;
    }
    
    public ActorRef getTargetActorRef() {
        return targetActorRef;
    }
    
}
