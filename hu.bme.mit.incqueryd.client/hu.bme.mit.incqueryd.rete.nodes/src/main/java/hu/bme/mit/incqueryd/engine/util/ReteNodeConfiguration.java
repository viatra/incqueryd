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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

public class ReteNodeConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;
	protected final String networkRecipeString;
	protected final String nodeRecipeUriFragment;
	
	public ReteNodeConfiguration(final ReteNodeRecipe recipe) throws IOException {
		super();
		this.networkRecipeString = EObjectSerializer.serializeToString(EcoreUtil.getRootContainer(recipe));
		this.nodeRecipeUriFragment = recipe.eResource().getURIFragment(recipe);
	}
	
	public ReteNodeRecipe getReteNodeRecipe() throws IOException {
		Resource resource = RecipeDeserializer.deserializeFromString(networkRecipeString).eResource();
		return (ReteNodeRecipe)resource.getEObject(nodeRecipeUriFragment); 
	}

}
