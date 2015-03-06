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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class ReteNodeConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;
	protected final String networkRecipeString;
	protected final String nodeRecipeUriFragment;
	protected final List<String> cacheMachineIps;
	private final String databaseUrl;
	
	public ReteNodeConfiguration(final ReteNodeRecipe recipe, final List<String> cacheMachineIps, String databaseUrl) throws IOException {
		super();
		this.networkRecipeString = EObjectSerializer.serializeToString(EcoreUtil.getRootContainer(recipe));
		this.nodeRecipeUriFragment = recipe.eResource().getURIFragment(recipe);
		this.cacheMachineIps = cacheMachineIps;
		this.databaseUrl = databaseUrl;
	}

	public List<String> getCacheMachineIps() {
		return cacheMachineIps;
	}
	
	public ReteNodeRecipe getReteNodeRecipe() throws IOException {
		Resource resource = RecipeDeserializer.deserializeFromString(networkRecipeString).eResource();
		return (ReteNodeRecipe)resource.getEObject(nodeRecipeUriFragment); 
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}
}
