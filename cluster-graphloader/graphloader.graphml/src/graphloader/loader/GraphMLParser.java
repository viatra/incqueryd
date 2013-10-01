package graphloader.loader;

import graphloader.database.ClientFacade;
import graphloader.propertygraph.PropertyGraphEdge;
import graphloader.propertygraph.PropertyGraphElement;
import graphloader.propertygraph.PropertyGraphVertex;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.cassandra.thrift.SchemaDisagreementException;
import org.apache.cassandra.thrift.TimedOutException;
import org.apache.cassandra.thrift.UnavailableException;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;

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
	PropertyGraphElement graphElement;
	PropertyGraphVertex graphVertex;
	PropertyGraphEdge graphEdge;

	private final Logger logger = Logger.getLogger(GraphMLParser.class);
	private ClientFacade thriftFacade;
	
	public void loadGraphML(String graphMLFile, int start, int end) throws IOException, InvalidRequestException, TException, UnavailableException, TimedOutException, SchemaDisagreementException {		
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
			thriftFacade = new ClientFacade("localhost", 9160);
			thriftFacade.dropKeyspace();
			thriftFacade.createKeyspace();
			thriftFacade.useKeyspace();
			thriftFacade.createColumnFamilyForVertices();
			thriftFacade.createColumnFamilyForEdges();
			parseGraphML(eventReader, end);
			thriftFacade.thrift_executeCql3QueryWithResults();
			thriftFacade.stopClient();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

	}

	private void parseGraphML(XMLEventReader eventReader, int end) throws XMLStreamException, UnsupportedEncodingException, InvalidRequestException, UnavailableException, TimedOutException, TException, SchemaDisagreementException {
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

	private XMLEvent processStartElement(XMLEventReader eventReader, XMLEvent event) throws XMLStreamException {
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

	private void processEndElement(XMLEvent event) throws UnsupportedEncodingException, InvalidRequestException, UnavailableException, TimedOutException, TException, SchemaDisagreementException {
		EndElement endElement = event.asEndElement();
		switch (endElement.getName().getLocalPart()) {
		case GRAPH:			
			logger.info("</graph>");
			break;
		case NODE:
			System.out.println(graphVertex);
			thriftFacade.insertVertex(graphVertex);
			logger.info("</node>");
			break;
		case EDGE:
			System.out.println(graphEdge);
			thriftFacade.insertEdge(graphEdge);
			logger.info("</edge>");
			break;
		case DATA:
			logger.info("</data>");
			break;
		}
	}

	private XMLEvent parseDataElement(XMLEventReader eventReader, StartElement startElement) throws XMLStreamException {
		XMLEvent event;
		event = eventReader.nextEvent();
		String key = parseData(startElement);
		String value = event.asCharacters().getData();
		graphElement.setProperty(key, value);
		return event;
	}

	private void parseEdgeElement(StartElement startElement) {
		graphEdge = new PropertyGraphEdge();
		graphElement = graphEdge;
		getEdgeAttributes("edge", startElement);
	}

	private XMLEvent parseVertexElement(XMLEventReader eventReader, StartElement startElement) throws XMLStreamException {
		XMLEvent event;
		graphVertex = new PropertyGraphVertex();
		graphElement = graphVertex;
		event = eventReader.nextEvent();
		getVertexAttributes("node", startElement);
		return event;
	}

	private void parseGraphElement(StartElement startElement) {
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
	private String parseData(StartElement startElement) {
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
	private void getVertexAttributes(String element, StartElement startElement) {
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
	private void getEdgeAttributes(String element, StartElement startElement) {
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

}