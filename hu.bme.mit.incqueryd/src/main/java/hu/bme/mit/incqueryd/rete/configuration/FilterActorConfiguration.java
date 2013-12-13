package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

public class FilterActorConfiguration extends IncQueryDConfiguration {

    private static final long serialVersionUID = 1L;

    protected TupleMask mask;
    
    public TupleMask getMask() {
        return mask;
    }
    
}
