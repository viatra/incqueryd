package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 * 
 */
public class BetaActorConfiguration extends ReteActorConfiguration {

    private static final long serialVersionUID = 1L;

    protected TupleMask primaryMask;
    protected TupleMask secondaryMask;

    public BetaActorConfiguration(final ActorRef coordinator, final ActorRef targetActorRef,
            final ReteNodeSlot targetNodeSlot, final TupleMask primaryMask, final TupleMask secondaryMask) {
        super(coordinator, targetActorRef, targetNodeSlot);
        this.primaryMask = primaryMask;
        this.secondaryMask = secondaryMask;
    }

    public TupleMask getPrimaryMask() {
        return primaryMask;
    }

    public TupleMask getSecondaryMask() {
        return secondaryMask;
    }

    public ReteNodeSlot getTargetNodeSlot() {
        return targetNodeSlot;
    }

}
