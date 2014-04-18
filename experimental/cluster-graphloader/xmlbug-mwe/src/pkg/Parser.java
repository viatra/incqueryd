package pkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class Parser {
	private InputStream stream;

	public Parser(String fileName) throws FileNotFoundException {
		System.out.println("parser for: " + fileName);
		this.stream = new FileInputStream(fileName);
	}

	public void parse() {
		try {
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = inputFactory.createXMLEventReader(stream);
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					System.out.println(startElement.getLocation().getCharacterOffset());
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

}
