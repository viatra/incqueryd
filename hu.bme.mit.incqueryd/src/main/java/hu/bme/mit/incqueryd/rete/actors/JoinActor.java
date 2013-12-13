package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.BetaNodeConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;

/**
 * 
 * @author szarnyasg
 *
 */
public class JoinActor extends BetaActor {

    private JoinNode getJoinNode() {
        return (JoinNode) reteNode;
    }
        
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final BetaNodeConfiguration configuration = (BetaNodeConfiguration) incQueryDConfiguration;        
        reteNode = new JoinNode(configuration.getPrimaryMask(), configuration.getSecondaryMask());
        
        super.configure(configuration);
    }
}
