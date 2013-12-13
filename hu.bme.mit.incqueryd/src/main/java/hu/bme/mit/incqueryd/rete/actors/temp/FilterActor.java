package hu.bme.mit.incqueryd.rete.actors.temp;

import hu.bme.mit.incqueryd.rete.configuration.FilterActorConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.FilterNode;

/**
 * 
 * @author szarnyasg
 *
 */
public class FilterActor extends AlphaActor {

    private FilterNode getFilterNode() {
        return (FilterNode) reteNode;
    }
    
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final FilterActorConfiguration configuration = (FilterActorConfiguration) incQueryDConfiguration;

        super.configure(configuration);
    }

}
