package hu.bme.mit.incqueryd.rete.actors.temp;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.TermEvaluatorNode;

public class TermEvaluatorActor extends AlphaActor {

    private TermEvaluatorNode getTermEvaluatorNode() {
        return (TermEvaluatorNode) reteNode;
    }
    
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        
        super.configure(incQueryDConfiguration);
    }
    
}
