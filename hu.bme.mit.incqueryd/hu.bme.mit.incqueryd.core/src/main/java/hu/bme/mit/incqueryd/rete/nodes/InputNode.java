package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.GraphElement;

import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

public class InputNode extends ReteNode {

    protected String type;
    protected GraphElement graphElement;

    InputNode(final UniquenessEnforcerRecipe recipe) {
        super();
    }

    public String getType() {
        return type;
    }

}
