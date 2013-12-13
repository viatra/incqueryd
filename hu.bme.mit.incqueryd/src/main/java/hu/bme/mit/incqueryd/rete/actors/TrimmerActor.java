package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;

public class TrimmerActor extends AlphaActor {

    private TrimmerNode getTrimmerNode() {
        return (TrimmerNode) reteNode;
    }
    
}
