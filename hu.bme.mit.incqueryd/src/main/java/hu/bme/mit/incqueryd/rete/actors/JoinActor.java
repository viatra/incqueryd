package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.nodes.JoinNode;

public class JoinActor extends BetaActor {

    private JoinNode getJoinNode() {
        return (JoinNode) reteNode;
    }
    
}
