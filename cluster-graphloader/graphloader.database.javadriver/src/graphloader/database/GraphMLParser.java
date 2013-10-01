package graphloader.database;

import graphloader.propertygraph.PropertyGraphEdge;
import graphloader.propertygraph.PropertyGraphElement;
import graphloader.propertygraph.PropertyGraphVertex;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.log4j.Logger;

public class GraphMLParser {
	// for the complete definition of the GraphML format, look here:
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

	// current graphElement (vertex/edge)
	protected PropertyGraphElement graphElement;
	protected PropertyGraphVertex graphVertex;
	protected PropertyGraphEdge graphEdge;
	protected ClientFacade clientFacade;
	protected final Collection<PropertyGraphVertex> vertices = new LinkedList<>();
	protected final Collection<PropertyGraphEdge> edges = new LinkedList<>();
	protected final Logger logger = Logger.getLogger(GraphMLParser.class);

	public GraphMLParser(ClientFacade clientFacade) {
		this.clientFacade = clientFacade;
	}

	public void loadGraphML(String graphMLFile) throws IOException {
		try {
			// First create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream fileInputStream = new FileInputStream(graphMLFile);

			// SequenceInputStream sequenceInputStream = new
			// SequenceInputStream(Collections.enumeration(Arrays.asList(new
			// InputStream[] {
			// new ByteArrayInputStream("<root>".getBytes()), fileInputStream,
			// new ByteArrayInputStream("</root>".getBytes()), })));

			// fileInputStream.skip(start);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(fileInputStream);

			// start database connection
			parseGraphML(eventReader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	public void loadGraphML(String graphMLFile, int start, int end) throws IOException {
		try {
			// First create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream fileInputStream = new FileInputStream(graphMLFile);

			SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(Arrays.asList(new InputStream[] {
					new ByteArrayInputStream("<root>".getBytes()), fileInputStream, new ByteArrayInputStream("</root>".getBytes()), })));

			fileInputStream.skip(start);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(sequenceInputStream);

			// start database connection
			parseGraphML(eventReader, end);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

	protected void parseGraphML(XMLEventReader eventReader) throws XMLStreamException {
		parseGraphML(eventReader, Integer.MAX_VALUE);
	}

	protected void parseGraphML(XMLEventReader eventReader, int end) throws XMLStreamException {
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();
			// System.out.println(event.getLocation().getCharacterOffset());
			if (event.getLocation().getCharacterOffset() >= end) {
				break;
			}

			if (event.isStartElement()) {
				event = processStartElement(eventReader, event);
			}

			if (event.isEndElement()) {
				processEndElement(event);
			}
		}
	}

	protected XMLEvent processStartElement(XMLEventReader eventReader, XMLEvent event) throws XMLStreamException {
		StartElement startElement = event.asStartElement();

		// <graph>
		switch (startElement.getName().getLocalPart()) {
		case GRAPH:
			parseGraphElement(startElement);
			break;
		case NODE:
			event = parseVertexElement(eventReader, startElement);
			break;
		case EDGE:
			parseEdgeElement(startElement);
			break;
		case DATA:
			event = parseDataElement(eventReader, startElement);
			break;
		}
		return event;
	}

	protected void processEndElement(XMLEvent event) {
		EndElement endElement = event.asEndElement();
		switch (endElement.getName().getLocalPart()) {
		case GRAPH:
			logger.info("</graph>");
			break;
		case NODE:
			// System.out.println(graphVertex);
			clientFacade.insertVertex(graphVertex);
			vertices.add(graphVertex);
			logger.info("</node>");
			break;
		case EDGE:
			// System.out.println(graphEdge);
			clientFacade.insertEdge(graphEdge);
			edges.add(graphEdge);
			logger.info("</edge>");
			break;
		case DATA:
			logger.info("</data>");
			break;
		}
	}

	protected XMLEvent parseDataElement(XMLEventReader eventReader, StartElement startElement) throws XMLStreamException {
		XMLEvent event;
		event = eventReader.nextEvent();
		String key = parseData(startElement);
		String value = event.asCharacters().getData();
		graphElement.setProperty(key, value);
		return event;
	}

	protected void parseEdgeElement(StartElement startElement) {
		graphEdge = new PropertyGraphEdge();
		graphElement = graphEdge;
		getEdgeAttributes("edge", startElement);
	}

	protected XMLEvent parseVertexElement(XMLEventReader eventReader, StartElement startElement) throws XMLStreamException {
		XMLEvent event;
		graphVertex = new PropertyGraphVertex();
		graphElement = graphVertex;
		event = eventReader.nextEvent();
		getVertexAttributes("node", startElement);
		return event;
	}

	protected void parseGraphElement(StartElement startElement) {
		logger.info("<graph");

		@SuppressWarnings("unchecked")
		Iterator<Attribute> attributes = startElement.getAttributes();

		// <graph> attributes
		String graphId = null;
		String graphEdgeDefault = null;
		while (attributes.hasNext()) {
			Attribute graphAttribute = attributes.next();
			switch (graphAttribute.getName().toString()) { // JDK 7
			case ID:
				graphId = graphAttribute.getValue();
				break;
			case EDGEDEFAULT:
				graphEdgeDefault = graphAttribute.getValue();
				break;
			default:
				break;
			}
		}
		logger.info(" id=\"" + graphId + "\"");
		logger.info(" edgedefault=\"" + graphEdgeDefault + "\"");
		logger.info(">");
	}

	@SuppressWarnings("unchecked")
	protected String parseData(StartElement startElement) {
		Iterator<Attribute> edgeAttributes = startElement.getAttributes();
		while (edgeAttributes.hasNext()) {
			Attribute attribute = edgeAttributes.next();
			if (attribute.getName().getLocalPart().equals("key")) {
				return attribute.getValue();
			}
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	protected void getVertexAttributes(String element, StartElement startElement) {
		String string = "<" + element;

		Iterator<Attribute> nodeAttributes = startElement.getAttributes();
		while (nodeAttributes.hasNext()) {
			Attribute attribute = nodeAttributes.next();
			string += " " + attribute.getName() + "=\"" + attribute.getValue() + "\"";

			switch (attribute.getName().getLocalPart()) {
			case ID:
				graphVertex.setId(Integer.parseInt(attribute.getValue()));
			}
		}

		string += ">";
		logger.info(string);
	}

	@SuppressWarnings("unchecked")
	protected void getEdgeAttributes(String element, StartElement startElement) {
		String string = "<" + element;

		Iterator<Attribute> nodeAttributes = startElement.getAttributes();
		while (nodeAttributes.hasNext()) {
			Attribute attribute = nodeAttributes.next();
			string += " " + attribute.getName() + "=\"" + attribute.getValue() + "\"";

			switch (attribute.getName().getLocalPart()) {
			case ID:
				graphEdge.setId(Integer.parseInt(attribute.getValue()));
			case SOURCE:
				graphEdge.setSourceVertexId(Integer.parseInt(attribute.getValue()));
			case TARGET:
				graphEdge.setTargetVertexId(Integer.parseInt(attribute.getValue()));
			case LABEL:
				graphEdge.setLabel(attribute.getValue());
			}
		}

		string += ">";
		logger.info(string);
	}

	public void prejoin() {
		for (PropertyGraphVertex vertex : vertices) {
			for (PropertyGraphEdge edge : edges) {
				//System.out.println(vertex + " " + edge);
				clientFacade.insertVertexWithEdge(vertex, edge);
			}
		}
	}

	public void select() {
		String q = "SELECT vertex_id " +
				"FROM vertex_edges " +
				"WHERE vertex_type = 'god' AND edge_label = 'lives' " +
				"ALLOW FILTERING";
		
		clientFacade.runQuerySync(q);
	}
}