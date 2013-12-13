package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class BetaNodeConfiguration extends ReteNodeConfiguration {

    private static final long serialVersionUID = 1L;

    protected TupleMask primaryMask;
    protected TupleMask secondaryMask;
    protected ReteNodeSlot targetNodeSlot;

    public BetaNodeConfiguration(final ActorRef coordinator, final TupleMask primaryMask,
            final TupleMask secondaryMask, final String targetActorPath, final ReteNodeSlot targetNodeSlot) {
        super(coordinator, targetActorPath);
        this.primaryMask = primaryMask;
        this.secondaryMask = secondaryMask;
        this.targetNodeSlot = targetNodeSlot;
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
