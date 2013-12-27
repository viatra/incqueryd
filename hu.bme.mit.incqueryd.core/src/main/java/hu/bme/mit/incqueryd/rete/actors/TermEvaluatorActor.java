package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.TermEvaluatorActorConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.TermEvaluatorNode;

/**
 * 
 * @author szarnyasg
 *
 */
public class TermEvaluatorActor extends AlphaActor {

    private TermEvaluatorNode getTermEvaluatorNode() {
        return (TermEvaluatorNode) reteNode;
    }
    
    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final TermEvaluatorActorConfiguration configuration = (TermEvaluatorActorConfiguration) incQueryDConfiguration;
        
        // instantiating a TermEvaluatorNode
        reteNode = new TermEvaluatorNode(configuration.getConditionExpressions());
        
        super.configure(configuration);
    }
    
}
