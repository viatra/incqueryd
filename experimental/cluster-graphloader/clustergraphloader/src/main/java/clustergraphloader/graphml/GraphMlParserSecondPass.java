package clustergraphloader.graphml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
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

import clustergraphloader.data.Status;
import clustergraphloader.database.ClientFacade;
import clustergraphloader.propertygraph.PropertyGraphEdge;
import clustergraphloader.propertygraph.PropertyGraphElement;
import clustergraphloader.propertygraph.PropertyGraphVertex;

public class GraphMlParserSecondPass extends GraphMlParser {
	// for the complete definition of the GraphML format, look here:
	// http://graphml.graphdrawing.org/specification/schema_element.xsd.htm

	// current graphElement, also accessible as a vertex/edge
	protected PropertyGraphElement graphElement;
	protected PropertyGraphVertex graphVertex;
	protected PropertyGraphEdge graphEdge;
	// constants set from the constructor
	protected final ClientFacade client;
	protected final XmlSegment[] xmlSegments;
	// variable for storing the number of parsed elements
	protected int parsedElements;
	protected int totalParsed;
	protected int totalElements;

	/**
	 * Constructor.
	 * 
	 * @param graphMlStream
	 */
	public GraphMlParserSecondPass(String fileName, XmlSegment[] xmlSegments) {
		super();
		this.xmlSegments = xmlSegments;
		this.client = new ClientFacade("localhost");
		
		// use our keyspace (instead of the default system)
		client.useKeyspace();

		initializeFileSystem(fileName);
		for (XmlSegment xmlSegment : xmlSegments) {
			totalElements += xmlSegment.getCount();
		}
		
	}

	/**
	 * Load a specific segment from the GraphML file.
	 * 
	 * @throws IOException
	 * @throws XMLStreamException
	 */
	public void loadSegments() {
		for (XmlSegment xmlSegment : xmlSegments) {
			System.out.println("loading: " + xmlSegment);
			loadSegment(xmlSegment);
			
			// waiting for futures
			client.waitForFutures();
			
			System.out.println("loaded");
		}
	}

	public void close() {
		// closing the connection to the client
		client.close();
	}

	private void loadSegment(XmlSegment xmlSegment) {
		System.out.println(xmlSegment);
		
		// reset the number of parsed elements
		parsedElements = 0;

		// first create a new XMLInputFactory
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();

		// seek to the offset defined in the xmlSegment file
		try {
			initializeInputStream();
			graphMlStream.skip(xmlSegment.getOffset());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// setup a new eventReader
		// creating fake <root> and </root> tags around the elements
		SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(Arrays
				.asList(new InputStream[] { new ByteArrayInputStream("<root>".getBytes()), graphMlStream,
						new ByteArrayInputStream("</root>".getBytes()), })));

		XMLEventReader eventReader;
		try {
			eventReader = inputFactory.createXMLEventReader(sequenceInputStream);
			parseGraphML(eventReader, xmlSegment);
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		try {
			graphMlStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PropertyGraphVertex v = new PropertyGraphVertex();
		v.setId(1);
		client.deleteVertex(v);
	}

	/**
	 * Parses the GraphML and stops when all graph elements in the segments are
	 * parsed.
	 * 
	 * @param eventReader
	 * @param xmlSegment
	 * @throws XMLStreamException
	 */
	protected void parseGraphML(XMLEventReader eventReader, XmlSegment xmlSegment) throws XMLStreamException {
		while (eventReader.hasNext()) {
			// break if all graph elements in the segments are parsed
			if (xmlSegment.getCount() == parsedElements) {
				break;
			}

			XMLEvent event = eventReader.nextEvent();
			if (event.isStartElement()) {
				event = processStartElement(eventReader, event);
			}
			if (event.isEndElement()) {
				processEndElement(event);
			}
		}
	}

	/**
	 * Processes a start element ({@code <...>}) in the GraphML file.
	 * 
	 * @param eventReader
	 * @param event
	 * @return
	 * @throws XMLStreamException
	 */
	protected XMLEvent processStartElement(XMLEventReader eventReader, XMLEvent event) throws XMLStreamException {
		StartElement startElement = event.asStartElement();

		// <graph>
		switch (startElement.getName().getLocalPart()) {
		case GRAPH:
			parseGraphElement(startElement);
			break;
		case NODE:
			parseVertexElement(eventReader, startElement);
			break;
		case EDGE:
			parseEdgeElement(startElement);
			break;
		case DATA:
			parseDataElement(eventReader, startElement);
			break;
		}
		return event;
	}

	/**
	 * Processes an end element ({@code </...>}) in the GraphML file.
	 * 
	 * @param event
	 */
	private void processEndElement(XMLEvent event) {
		EndElement endElement = event.asEndElement();
		switch (endElement.getName().getLocalPart()) {
		case GRAPH:
			break;
		case NODE:
			System.out.println(graphVertex);
			insertVertex(graphVertex);
			parsedElements++;
			totalParsed++;
			break;
		case EDGE:
			System.out.println(graphEdge);
			insertEdge(graphEdge);
			parsedElements++;
			totalParsed++;
			break;
		case DATA:
			break;
		}
	}

	/**
	 * Parses a <data> XML element for both vertexes and edges.
	 * 
	 * @param eventReader
	 * @param startElement
	 * @return
	 * @throws XMLStreamException
	 */
	protected void parseDataElement(XMLEventReader eventReader, StartElement startElement)
			throws XMLStreamException {
		XMLEvent event = eventReader.nextEvent();
		String key = parseData(startElement);
		String value = event.asCharacters().getData();
		graphElement.setProperty(key, value);
	}

	/**
	 * Parses an {@code <edge>} XML element.
	 * 
	 * @param startElement
	 */
	protected void parseEdgeElement(StartElement startElement) {
		graphEdge = new PropertyGraphEdge();
		graphElement = graphEdge;
		getEdgeAttributes("edge", startElement);
	}

	/**
	 * Parses a {@code <vertex>} XML element.
	 * 
	 * @param eventReader
	 * @param startElement
	 * @throws XMLStreamException
	 */
	protected void parseVertexElement(XMLEventReader eventReader, StartElement startElement) throws XMLStreamException {
		graphVertex = new PropertyGraphVertex();
		graphElement = graphVertex;
		getVertexAttributes("node", startElement);
	}

	/**
	 * Parses a {@code <graph>} XML element.
	 * 
	 * @param startElement
	 */
	private void parseGraphElement(StartElement startElement) {
		// logger.info("<graph");

		@SuppressWarnings("unchecked")
		Iterator<Attribute> attributes = startElement.getAttributes();

		// <graph> attributes
		String graphId = null;
		String graphEdgeDefault = null;
		while (attributes.hasNext()) {
			Attribute graphAttribute = attributes.next();
			switch (graphAttribute.getName().toString()) { // JDK 7 feature
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

		// don't use the graphId and graphEdgeDefault fields

		// logger.info(" id=\"" + graphId + "\" edgedefault=\"" +
		// graphEdgeDefault + "\">");
	}

	/**
	 * Parses a {@code <data>} element in the XML file, see the {@code <data>}
	 * data elements here:
	 * 
	 * <pre>
	 * {@code
	 * <node id="0">
	 *    <data key="name">saturn</data>
	 *    <data key="type">titan</data>
	 * </node>
	 * }
	 * </pre>
	 * 
	 * @param startElement
	 * @return
	 */
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

	/**
	 * Parses the attributes of a {@code <vertex>} XML element.
	 * 
	 * @param element
	 * @param startElement
	 */
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
		// logger.info(string);
	}

	/**
	 * Parses the attributes of an {@code <edge>} XML element.
	 * 
	 * @param element
	 * @param startElement
	 */
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
		// logger.info(string);
	}

	/**
	 * Issues the insertion of an edge to the database.
	 * 
	 * @param edge
	 */
	protected void insertEdge(PropertyGraphEdge edge) {
		client.insertEdge(edge);
	}

	/**
	 * Issues the insertion of a vertex to the database.
	 * 
	 * @param vertex
	 */
	protected void insertVertex(PropertyGraphVertex vertex) {
		client.insertVertex(vertex);
	}

	/**
	 * Return the percentage of parsed elements.
	 * @return
	 */
	public Status getPercentage() {
		return new Status(totalParsed * 100 / totalElements); 
	}
	
}