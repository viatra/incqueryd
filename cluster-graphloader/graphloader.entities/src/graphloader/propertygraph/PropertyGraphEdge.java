package graphloader.propertygraph;


public class PropertyGraphEdge extends PropertyGraphElement {

	private String label;
	private int sourceVertexId;
	private int targetVertexId;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getSourceVertexId() {
		return sourceVertexId;
	}

	public void setSourceVertexId(int sourceVertexId) {
		this.sourceVertexId = sourceVertexId;
	}

	public int getTargetVertexId() {
		return targetVertexId;
	}

	public void setTargetVertexId(int targetVertexId) {
		this.targetVertexId = targetVertexId;
	}

	public String toString() {
		return "PropertyGraphEdge [id=" + id + ", label=" + label + ", sourceVertexId=" + sourceVertexId + ", targetVertexId=" + targetVertexId
				+ ", properties=" + properties + "]";
	}

	public static PropertyGraphEdge getFakeEdge() {
		PropertyGraphEdge fakeEdge = new PropertyGraphEdge();
		fakeEdge.setId(-1);
		fakeEdge.setLabel("fake");
		fakeEdge.setSourceVertexId(-1);
		fakeEdge.setTargetVertexId(-1);
		return fakeEdge;
	}

}
