package hu.bme.mit.incqueryd.rete.configuration;

import akka.actor.ActorRef;

public class ProductionNodeConfiguration extends ReteNodeConfiguration {

    private static final long serialVersionUID = 1L;

    public ProductionNodeConfiguration(final ActorRef coordinator) {
        super(coordinator, "");
    }

}
