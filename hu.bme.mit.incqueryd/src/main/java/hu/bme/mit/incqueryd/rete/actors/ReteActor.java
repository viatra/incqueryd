package hu.bme.mit.incqueryd.rete.actors;

import hu.bme.mit.incqueryd.rete.configuration.IncQueryDConfiguration;
import hu.bme.mit.incqueryd.rete.configuration.ReteNodeConfiguration;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
import hu.bme.mit.incqueryd.rete.nodes.FilterNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;

public abstract class ReteActor extends IncQueryDActor {

    /**
     * Each Rete actor incorporates a Rete node, which is responsible for the appropriate operation, e.g. an
     * {@link AntiJoinActor} contains an {@link AntiJoinNode}, a {@link FilterActor} contains a {@link FilterNode}, etc.
     * These nodes can be accessed by typesafe private getters in the descendants, e.g. an {@link AntiJoinActor} has a
     * getAntiJoinNode(), a {@link FilterActor} has a getFilterNode() method.
     */
    protected ReteNode reteNode;

    @Override
    protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
        final ReteNodeConfiguration configuration = (ReteNodeConfiguration) incQueryDConfiguration;

        this.targetActorPath = configuration.getTargetActorPath();
        this.coordinator = configuration.getCoordinator();
    };

}
