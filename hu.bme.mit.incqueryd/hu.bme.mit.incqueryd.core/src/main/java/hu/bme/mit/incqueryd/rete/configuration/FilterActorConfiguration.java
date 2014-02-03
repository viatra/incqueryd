package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 * 
 */
public class FilterActorConfiguration extends ReteActorConfiguration {

    private static final long serialVersionUID = 1L;

    protected TupleMask mask;

    public FilterActorConfiguration(final ActorRef coordinator, final ActorRef targetActorRef, final ReteNodeSlot targetNodeSlot, final TupleMask mask) {
        super(coordinator, targetActorRef, targetNodeSlot);
        this.mask = mask;
    }

    public TupleMask getMask() {
        return mask;
    }

}
