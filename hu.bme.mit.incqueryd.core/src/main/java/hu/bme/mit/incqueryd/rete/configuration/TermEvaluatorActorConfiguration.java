package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.rete.comparison.ConditionExpression;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;

import java.util.Collection;

import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class TermEvaluatorActorConfiguration extends ReteActorConfiguration {

    private static final long serialVersionUID = 1L;

    protected Collection<ConditionExpression> conditionExpressions;

    public TermEvaluatorActorConfiguration(final ActorRef coordinator, final ActorRef targetActorRef, final ReteNodeSlot targetNodeSlot,
            final Collection<ConditionExpression> conditionExpressions) {
        super(coordinator, targetActorRef, targetNodeSlot);
        this.conditionExpressions = conditionExpressions;
    }
    
    public Collection<ConditionExpression> getConditionExpressions() {
        return conditionExpressions;
    }
    
}
