package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.BetaActorConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;

/**
 * 
 * @author szarnyasg
 *
 */
public class AntiJoinActor extends BetaActor {

    private AntiJoinNode getAntiJoinNode() {
        return (AntiJoinNode) reteNode;
    }

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final BetaActorConfiguration configuration = (BetaActorConfiguration) incQueryDConfiguration;        
        reteNode = new AntiJoinNode(configuration.getPrimaryMask(), configuration.getSecondaryMask());

        super.configure(configuration);
    }

}
