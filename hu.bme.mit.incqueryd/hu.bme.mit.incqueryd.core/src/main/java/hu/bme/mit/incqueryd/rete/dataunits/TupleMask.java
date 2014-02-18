package hu.bme.mit.incqueryd.rete.dataunits;

import java.util.List;


/**
 *
 * @author szarnyasg
 *
 */
public class TupleMask {

    public static Tuple project(final Tuple tuple, final List<Integer> mask) {
        final Object[] result = new Object[mask.size()];
        for (int i = 0; i < mask.size(); i++) {
            result[i] = tuple.get(mask.get(i));
        }
        return new Tuple(result);
    }

}
