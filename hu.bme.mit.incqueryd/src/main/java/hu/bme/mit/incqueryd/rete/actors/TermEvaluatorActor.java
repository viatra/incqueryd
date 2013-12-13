package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.nodes.TermEvaluatorNode;

public class TermEvaluatorActor extends AlphaActor {

    private TermEvaluatorNode getTermEvaluatorNode() {
        return (TermEvaluatorNode) reteNode;
    }
}
