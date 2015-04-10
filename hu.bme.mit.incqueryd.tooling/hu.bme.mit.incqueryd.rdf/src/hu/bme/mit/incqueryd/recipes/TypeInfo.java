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
package hu.bme.mit.incqueryd.recipes;

public class TypeInfo {
	protected String ontologyIri;
	protected String typeNameSuffix;

	public TypeInfo(String ontologyIri, String typeNameSuffix) {
		super();
		this.ontologyIri = ontologyIri;
		this.typeNameSuffix = typeNameSuffix;
	}

	public String getOntologyIri() {
		return ontologyIri;
	}

	public String getTypeNameSuffix() {
		return typeNameSuffix;
	}
}