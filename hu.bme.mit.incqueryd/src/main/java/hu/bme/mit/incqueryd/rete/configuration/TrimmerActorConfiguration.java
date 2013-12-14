package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class TrimmerActorConfiguration extends ReteActorConfiguration {

    private static final long serialVersionUID = 1L;
    
    protected TupleMask projectionMask;

    public TrimmerActorConfiguration(final ActorRef coordinator, final ActorRef targetActorRef, final ReteNodeSlot targetNodeSlot, final TupleMask projectionMask) {
        super(coordinator, targetActorRef, targetNodeSlot);
        this.projectionMask = projectionMask;
    }
    
    public TupleMask getProjectionMask() {
        return projectionMask;
    }
}
