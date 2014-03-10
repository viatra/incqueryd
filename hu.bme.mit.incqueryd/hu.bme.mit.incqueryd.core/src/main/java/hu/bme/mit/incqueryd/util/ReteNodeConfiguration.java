package hu.bme.mit.incqueryd.util;

public class ReteNodeConfiguration {
	protected ReteNodeType type;
	protected String jsonRecipe;

	public ReteNodeConfiguration(final ReteNodeType type, final String jsonRecipe) {
		super();
		this.type = type;
		this.jsonRecipe = jsonRecipe;
	}

//	public ReteNodeType getType() {
//		return type;
//	}

	public String getJsonRecipe() {
		return jsonRecipe;
	}
}
