package examples.basic;

import graphloader.propertygraph.PropertyGraphEdge;
import graphloader.propertygraph.PropertyGraphVertex;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class Parser {
	// for the complete definition of the graphml format, look here:
	// http://graphml.graphdrawing.org/specification/schema_element.xsd.htm

	// elements
	static final String GRAPH = "graph";
	static final String NODE = "node";
	static final String EDGE = "edge";
	static final String DATA = "data";

	// attributes
	static final String ID = "id";
	static final String EDGEDEFAULT = "edgedefault";
	static final String KEY = "key";
	static final String SOURCE = "source";
	static final String TARGET = "target";
	static final String LABEL = "label";

	private PropertyGraphVertex vertex;
	private PropertyGraphEdge edge;

	public void printEvent(XMLStreamReader xmlStreamReader) {
		System.out.print("EVENT:[" + xmlStreamReader.getLocation().getLineNumber() + "][" + xmlStreamReader.getLocation().getColumnNumber() + "] ");
		System.out.print(" [");
		switch (xmlStreamReader.getEventType()) {
		case XMLStreamConstants.START_ELEMENT:
			System.out.print("<");
			System.out.print(xmlStreamReader.getLocalName());
			switch (xmlStreamReader.getLocalName()) {
			case NODE:
				vertex = new PropertyGraphVertex();
				break;
			case EDGE:
				edge = new PropertyGraphEdge();
				break;
			default:
				break;
			}
			printAttributes(xmlStreamReader);
			System.out.print(">");
			break;
		case XMLStreamConstants.END_ELEMENT:
			System.out.print("</");
			System.out.print(xmlStreamReader.getLocalName());
			System.out.print(">");
			
			switch (xmlStreamReader.getLocalName()) {
			case NODE:
				vertex = new PropertyGraphVertex();
				break;
			case EDGE:
				edge = new PropertyGraphEdge();
				break;
			default:
				break;
			}
			
			break;
		case XMLStreamConstants.SPACE:
		case XMLStreamConstants.CHARACTERS:
			System.out.print("content: ");
			int start = xmlStreamReader.getTextStart();
			int length = xmlStreamReader.getTextLength();
			System.out.print(new String(xmlStreamReader.getTextCharacters(), start, length));
			break;
		case XMLStreamConstants.PROCESSING_INSTRUCTION:
			System.out.print("<?");
			if (xmlStreamReader.hasText())
				System.out.print(xmlStreamReader.getText());
			System.out.print("?>");
			break;
		case XMLStreamConstants.CDATA:
			System.out.print("<![CDATA[");
			start = xmlStreamReader.getTextStart();
			length = xmlStreamReader.getTextLength();
			System.out.print(new String(xmlStreamReader.getTextCharacters(), start, length));
			System.out.print("]]>");
			break;
		case XMLStreamConstants.COMMENT:
			System.out.print("<!--");
			if (xmlStreamReader.hasText())
				System.out.print(xmlStreamReader.getText());
			System.out.print("-->");
			break;
		case XMLStreamConstants.ENTITY_REFERENCE:
			System.out.print(xmlStreamReader.getLocalName() + "=");
			if (xmlStreamReader.hasText())
				System.out.print("[" + xmlStreamReader.getText() + "]");
			break;
		case XMLStreamConstants.START_DOCUMENT:
			System.out.print("<?xml");
			System.out.print(" version='" + xmlStreamReader.getVersion() + "'");
			System.out.print(" encoding='" + xmlStreamReader.getCharacterEncodingScheme() + "'");
			if (xmlStreamReader.isStandalone())
				System.out.print(" standalone='yes'");
			else
				System.out.print(" standalone='no'");
			System.out.print("?>");
			break;
		}
		System.out.println("]");
	}

	private void printAttributes(XMLStreamReader xmlStreamReader) {
		for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
			printAttribute(xmlStreamReader, i);
		}
	}

	private void printAttribute(XMLStreamReader xmlStreamReader, int index) {
		String prefix = xmlStreamReader.getAttributePrefix(index);
		String namespace = xmlStreamReader.getAttributeNamespace(index);
		String localName = xmlStreamReader.getAttributeLocalName(index);
		String value = xmlStreamReader.getAttributeValue(index);
		System.out.print(" ");
		//printName(prefix, namespace, localName);
		System.out.print("='" + value + "'");
	}

	private void printNamespaces(XMLStreamReader xmlStreamReader) {
		for (int i = 0; i < xmlStreamReader.getNamespaceCount(); i++) {
			printNamespace(xmlStreamReader, i);
		}
	}

	private void printNamespace(XMLStreamReader xmlStreamReader, int index) {
		String prefix = xmlStreamReader.getNamespacePrefix(index);
		String uri = xmlStreamReader.getNamespaceURI(index);
		System.out.print(" ");
		if (prefix == null)
			System.out.print("xmlns='" + uri + "'");
		else
			System.out.print("xmlns:" + prefix + "='" + uri + "'");
	}
}
