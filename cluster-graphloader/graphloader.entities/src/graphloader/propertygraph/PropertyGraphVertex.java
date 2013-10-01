package graphloader.propertygraph;


/*
	XML example:
	<node id="3">
	    <data key="name">pluto</data>
	    <data key="type">god</data>
	</node>
*/

public class PropertyGraphVertex extends PropertyGraphElement {

	public String toString() {
		return "PropertyGraphVertex [id=" + id + ", properties=" + properties + "]";
	}
	
}
