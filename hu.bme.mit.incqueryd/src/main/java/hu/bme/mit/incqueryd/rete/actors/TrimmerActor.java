package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerActorConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;

/**
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerActor extends AlphaActor {

    private TrimmerNode getTrimmerNode() {
        return (TrimmerNode) reteNode;
    }

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final TrimmerActorConfiguration configuration = (TrimmerActorConfiguration) incQueryDConfiguration;

        reteNode = new TrimmerNode(configuration.getProjectionMask());
        
        super.configure(configuration);
    }

}
