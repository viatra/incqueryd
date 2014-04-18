package clustergraphloader.messages;

import java.io.Serializable;

import clustergraphloader.graphml.XmlSegment;

/**
 * Load message, containing the fileName and the {@link XmlSegment}s to load.
 * @author szarnyasg
 *
 */
public class LoadMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private XmlSegment[] xmlSegments;
	private String fileName;

	public LoadMessage(String fileName, XmlSegment[] xmlSegments) {
		this.fileName = fileName;
		this.xmlSegments = xmlSegments;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public XmlSegment[] getXmlSegments() {
		return xmlSegments;
	}
	
}
