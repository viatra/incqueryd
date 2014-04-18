package examples.basic;

import java.io.FileReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

/**
 * This is a simple parsing example that illustrates the XMLStreamReader class.
 * 
 * @author Copyright (c) 2003 by BEA Systems. All Rights Reserved.
 */
public class Parse {
	private static String filename = null;

	private static void printUsage() {
		System.out.println("usage: java examples.basic.Parse <xmlfile>");
	}

	public static void main(String[] args) throws Exception {
		try {
			filename = args[0];
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			printUsage();
			System.exit(0);
		}

		Parser parser = new Parser();
				
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileReader(filename));
		while (xmlStreamReader.hasNext()) {			
			parser.printEvent(xmlStreamReader);
			xmlStreamReader.next();
		}
		xmlStreamReader.close();
	}

}