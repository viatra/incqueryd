package hu.bme.mit.incqueryd.rete.dataunits;

import java.util.List;

/**
 *
 * @author szarnyasg
 *
 */
public class TupleMask {

    protected List<Integer> mask;

    public TupleMask(final List<Integer> mask) {
        this.mask = mask;
    }

    public Tuple extract(final Tuple tuple) {
        final Object[] result = new Object[mask.size()];
        for (int i = 0; i < mask.size(); i++) {
            result[i] = tuple.get(mask.get(i));
        }
        return new Tuple(result);
    }

    public List<Integer> getMask() {
        return mask;
    }
}
