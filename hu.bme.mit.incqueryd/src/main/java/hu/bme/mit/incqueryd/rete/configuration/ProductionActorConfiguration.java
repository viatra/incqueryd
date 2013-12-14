package hu.bme.mit.incqueryd.rete.configuration;

import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class ProductionActorConfiguration extends ReteActorConfiguration {

    private static final long serialVersionUID = 1L;

    public ProductionActorConfiguration(final ActorRef coordinator) {
        super(coordinator, null, null);
    }

}
