package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

/**
 * The EqualityNode and InequalityNode are types of alpha node. They check whether certain elements in the tuple,
 * selected by a pattern mask associated with the node, are all equal (EqualityNode) or all different from a subject
 * element specified by its index (InequalityNode). These nodes propagate updates that match these criteria and ignore
 * those that does not. They have no internal memory; the pull operation is performed by pulling the contents of parent
 * nodes and filtering them. [Bergmann's MSc thesis, p.39]
 * 
 * @author szarnyasg
 * 
 */
public class InequalityNode extends FilterNode {

    public InequalityNode(final TupleMask tupleMask) {
        super(tupleMask);
    }

    @Override
    protected boolean compare(final Object o1, final Object o2) {
        return !o1.equals(o2);
    }

}
