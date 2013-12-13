package hu.bme.mit.incqueryd.rete.actors.temp;

import hu.bme.mit.incqueryd.rete.actors.BetaActor;
import hu.bme.mit.incqueryd.rete.configuration.BetaNodeConfiguration;
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
        final BetaNodeConfiguration configuration = (BetaNodeConfiguration) incQueryDConfiguration;        
        reteNode = new AntiJoinNode(configuration.getPrimaryMask(), configuration.getSecondaryMask());

        super.configure(configuration);
    }

}
