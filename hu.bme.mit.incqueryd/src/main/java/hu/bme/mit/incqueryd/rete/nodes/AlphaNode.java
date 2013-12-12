package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

/**
 * [...] alpha nodes are connected with an edge to a parent node (usually the input node or another alpha node); they
 * filter the contents of the parent node according to some constant criteria (e.g. type). [Bergmann's MSc thesis, p.27]
 * 
 * @author szarnyasg
 * 
 */
public abstract class AlphaNode extends ReteNode {

    abstract public ChangeSet update(final ChangeSet incomingChangeSet);

}
