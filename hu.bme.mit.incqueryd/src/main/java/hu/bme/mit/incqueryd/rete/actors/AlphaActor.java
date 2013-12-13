package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;

public class AlphaActor extends ReteActor {

    private AlphaNode getAlphaNode() {
        return (AlphaNode) reteNode;
    }
    
    
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        
    }

}
