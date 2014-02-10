package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.TrimmerNodeConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;

/**
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerActor extends AlphaActor {

//    protected TrimmerNode getTrimmerNode() {
//        return (TrimmerNode) reteNode;
//    }

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final TrimmerNodeConfiguration configuration = (TrimmerNodeConfiguration) incQueryDConfiguration;

        reteNode = new TrimmerNode(configuration);        
        super.configure(configuration);
    }

}
