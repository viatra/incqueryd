package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.arch.ArchUtil;

import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

public class InputNode extends ReteNode {

    protected String type;

    InputNode(final UniquenessEnforcerRecipe recipe) {
        super();
        type = ArchUtil.extractType(recipe.getTraceInfo());
    }

    public String getType() {
        return type;
    }

}
