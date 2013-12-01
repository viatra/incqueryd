package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;

/**
 * The TrimmerNode has a pattern mask and outputs the contents of its parent transformed by the mask. On receiving an update, it uses the mask to transform the
 * tuple contained in the update and propagate the result as an update. It does not have an internal memory; the pull operation is performed by pulling the
 * parents and transforming their contents again. It is important to note that several tuples can have the same signature, so even when receiving updates
 * containing different tuples, the updates sent by this node can contain the same tuple, thus violating the uniqueness principle. [Bergmann's MSc thesis,
 * p.39-40]
 * 
 * @author szarnyasg
 * 
 */
public class TrimmerNode extends AlphaNode {

	@Override
	public ChangeSet update(final ChangeSet incomingChangeSet) {

		return null;
	}

}
