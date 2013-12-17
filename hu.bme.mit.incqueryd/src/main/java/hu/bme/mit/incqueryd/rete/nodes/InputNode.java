package hu.bme.mit.incqueryd.rete.nodes;

import hu.bme.mit.incqueryd.rete.dataunits.GraphElement;

public class InputNode extends ReteNode {

    protected String type;
    protected GraphElement graphElement;

    public InputNode(final String type, final GraphElement graphElement) {
        super();
        this.type = type;
        this.graphElement = graphElement;
    }

    public String getType() {
        return type;
    }

    public GraphElement getGraphElement() {
        return graphElement;
    }

}
