/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.rete.messages;

import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.io.Serializable;
import java.util.Set;

public class Transformation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected final Set<Tuple> invalids;
	protected final String testCase; 
	
	public Transformation(final Set<Tuple> invalids, final String testCase) {
		super();
		
		this.invalids = invalids;	
		this.testCase = testCase;
	}
	
	public Set<Tuple> getInvalids() {
		return invalids;
	}
	
	public String getTestCase() {
		return testCase;
	}
	
}
