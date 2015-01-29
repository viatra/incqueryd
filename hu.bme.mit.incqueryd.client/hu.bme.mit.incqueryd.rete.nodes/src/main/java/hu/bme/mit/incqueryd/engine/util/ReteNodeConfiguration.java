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
package hu.bme.mit.incqueryd.engine.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class ReteNodeConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String recipeString;
	protected List<String> cacheMachineIps;
	protected final String connectionString;
	
	public ReteNodeConfiguration(final String recipeString, final List<String> cacheMachineIps, final String connectionString) {
		super();
		this.recipeString = recipeString;
		this.cacheMachineIps = cacheMachineIps;
		this.connectionString = connectionString;
	}

	public String getRecipeString() {
		return recipeString;
	}
	
	public List<String> getCacheMachineIps() {
		return cacheMachineIps;
	}
	
	public ReteNodeRecipe getReteNodeRecipe() throws IOException {
		return (ReteNodeRecipe) RecipeDeserializer.deserializeFromString(getRecipeString());	
	}
	
	public String getConnectionString() {
		return connectionString;
	}
}
