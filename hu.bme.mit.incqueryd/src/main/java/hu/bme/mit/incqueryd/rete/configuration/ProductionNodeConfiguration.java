package hu.bme.mit.incqueryd.rete.configuration;

import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class ProductionNodeConfiguration extends ReteNodeConfiguration {

    private static final long serialVersionUID = 1L;

    public ProductionNodeConfiguration(final ActorRef coordinator) {
        super(coordinator, "");
    }

}
