package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.FilterActorConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.EqualityNode;

public class EqualityActor extends FilterActor {

    private EqualityNode getEqualityNode() {
        return (EqualityNode) reteNode;
    }
    
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        super.configure(incQueryDConfiguration);

        final FilterActorConfiguration configuration = (FilterActorConfiguration) incQueryDConfiguration;

        // instantiating a new EqualityNode with the appropriate mask
        reteNode = new EqualityNode(configuration.getMask());
    }

}
