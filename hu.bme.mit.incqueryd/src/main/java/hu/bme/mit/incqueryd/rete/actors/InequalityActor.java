package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.FilterActorConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.InequalityNode;

public class InequalityActor extends FilterActor {

//    private void setInequalityNode() {
//        
//    }
    
    private InequalityNode getInequalityNode() {
        return (InequalityNode) reteNode;
    }
    
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        super.configure(incQueryDConfiguration);

        final FilterActorConfiguration configuration = (FilterActorConfiguration) incQueryDConfiguration;

        // instantiating a new InequalityNode with the appropriate mask
        reteNode = new InequalityNode(configuration.getMask());        
    }
    
}
