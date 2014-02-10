package hu.bme.mit.incqueryd.rete.configuration;

import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;

/**
 * 
 * @author szarnyasg
 *
 */
public class TrimmerNodeConfiguration extends ReteNodeConfiguration {
   
	private static final long serialVersionUID = 1L;
	
	protected TupleMask projectionMask;

    public TrimmerNodeConfiguration(final TupleMask projectionMask) {
    	super();
        this.projectionMask = projectionMask;
    }
    
    public TupleMask getProjectionMask() {
        return projectionMask;
    }
}
