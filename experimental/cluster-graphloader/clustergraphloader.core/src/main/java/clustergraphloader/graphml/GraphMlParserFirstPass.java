package clustergraphloader.graphml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class GraphMlParserFirstPass extends GraphMlParser {

	// count of the databases
	protected int dbCount;

	// storing the offset while parsing the GraphML
	protected List<Integer> nodeOffsets = new ArrayList<>();
	protected List<Integer> edgeOffsets = new ArrayList<>();

	// variables for counting the nodes and edges
	protected int nodeCount;
	protected int edgeCount;

	// determining the segments after the GraphML is parsed
	protected List<XmlSegment> nodeSegments = new ArrayList<>();
	protected List<XmlSegment> edgeSegments = new ArrayList<>();

	public GraphMlParserFirstPass(String fileName, int dbCount) {
		super();
		this.dbCount = dbCount;

		initializeFileSystem(fileName);
	}

	/**
	 * Determines the segments in the GraphML file based on the number of
	 * database nodes availabe.
	 */
	public void parseSegments() {
		initializeInputStream();

		try {
			// First create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			XMLEventReader eventReader = inputFactory.createXMLEventReader(graphMlStream);

			parseGraphML(eventReader);

			System.out.println(nodeCount + " nodes");
			System.out.println(edgeCount + " edges");

			// dividing nodes for the databases
			System.out.print("dividing the nodes: ");
			int[] nodeDistribution = Divider.divide(nodeCount, dbCount);
			for (int i : nodeDistribution) {
				System.out.print(i + " ");
			}
			System.out.println();

			// dividing edges for the databases
			System.out.print("dividing the edges: ");
			int[] edgeDistribution = Divider.divide(edgeCount, dbCount);
			for (int i : edgeDistribution) {
				System.out.print(i + " ");
			}
			System.out.println();

			System.out.println("node start offsets: " + nodeOffsets.get(0) + ", ...");
			System.out.println("edge start offsets: " + edgeOffsets.get(0) + ", ...");

			// node's distribution
			int n = 0;
			for (int segmentSize : nodeDistribution) {
				XmlSegment nodeSegment = new XmlSegment(nodeOffsets.get(n), segmentSize);
				n += segmentSize;
				nodeSegments.add(nodeSegment);

			}

			// edge's distribution
			int e = 0;
			for (int segmentSize : edgeDistribution) {
				XmlSegment edgeSegment = new XmlSegment(edgeOffsets.get(e), segmentSize);
				e += segmentSize;
				edgeSegments.add(edgeSegment);
			}

		} catch (XMLStreamException e) {
			e.printStackTrace();
		}

		try {
			fileSystem.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void parseGraphML(XMLEventReader eventReader) throws XMLStreamException {
		while (eventReader.hasNext()) {
			XMLEvent event = eventReader.nextEvent();

			if (event.isStartElement()) {
				event = processStartElement(eventReader, event);
			}

			if (event.isEndElement()) {
				// if we are using the WoodStox XML library, we don't need to
				// process the end elements to keep track of the start offsets:
				// do nothing
			}
		}
	}

	protected XMLEvent processStartElement(XMLEventReader eventReader, XMLEvent event) throws XMLStreamException {
		StartElement startElement = event.asStartElement();
		switch (startElement.getName().getLocalPart()) {
		case GRAPH:
			break;
		case NODE:
			nodeOffsets.add(event.getLocation().getCharacterOffset());
			nodeCount++;
			break;
		case EDGE:
			edgeOffsets.add(event.getLocation().getCharacterOffset());
			edgeCount++;
			break;
		case DATA:
			break;
		}
		return event;
	}

	public List<XmlSegment> getNodeSegments() {
		return nodeSegments;
	}

	public List<XmlSegment> getEdgeSegments() {
		return edgeSegments;
	}

}