package hu.bme.mit.incqueryd.rete.actors.temp;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;

public class TrimmerActor extends AlphaActor {

    private TrimmerNode getTrimmerNode() {
        return (TrimmerNode) reteNode;
    }
    
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        
        super.configure(incQueryDConfiguration);
    }
    
}
