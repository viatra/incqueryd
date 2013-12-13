package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.databases.DatabaseClientType;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import akka.actor.ActorRef;

/**
 * 
 * @author szarnyasg
 *
 */
public class UniquenessEnforcerNodeConfiguration extends ReteNodeConfiguration {

    public UniquenessEnforcerNodeConfiguration(final ActorRef coordinator, final String targetActorPath,
            final String edgeLabel, final ReteNodeSlot targetNodeSlot, final DatabaseClientType databaseClientType,
            final String filename) {
        super(coordinator, targetActorPath);

        this.edgeLabel = edgeLabel;
        this.targetNodeSlot = targetNodeSlot;
        this.databaseClientType = databaseClientType;
        this.filename = filename;
    }

    protected static final long serialVersionUID = 1L;

    public final String edgeLabel;
    public final ReteNodeSlot targetNodeSlot;
    public final DatabaseClientType databaseClientType;
    public final String filename;
}
