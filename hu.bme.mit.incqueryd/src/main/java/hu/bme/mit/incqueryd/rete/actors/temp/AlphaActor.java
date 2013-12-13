package hu.bme.mit.incqueryd.rete.actors.temp;

import hu.bme.mit.incqueryd.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;

/**
 * 
 * @author szarnyasg
 *
 */
public class AlphaActor extends ReteActor {

    private AlphaNode getAlphaNode() {
        return (AlphaNode) reteNode;
    }
    
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        super.configure(incQueryDConfiguration);
    }

}
