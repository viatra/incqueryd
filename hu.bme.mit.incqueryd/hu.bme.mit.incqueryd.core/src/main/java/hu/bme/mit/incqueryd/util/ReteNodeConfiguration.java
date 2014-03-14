package hu.bme.mit.incqueryd.util;

import java.io.Serializable;

public class ReteNodeConfiguration implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String recipeString;

	public ReteNodeConfiguration(final String recipeString) {
		super();
		this.recipeString = recipeString;
	}

	public String getRecipeString() {
		return recipeString;
	}
}
