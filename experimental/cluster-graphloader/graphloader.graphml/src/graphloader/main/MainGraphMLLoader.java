package graphloader.main;

import examples.basic.ConfigParser;
import examples.basic.Item;
import graphloader.loader.GraphMLParser;

import java.io.IOException;
import java.util.List;

import javax.management.modelmbean.XMLParseException;
import javax.xml.stream.XMLStreamException;

import org.apache.cassandra.thrift.InvalidRequestException;
import org.apache.cassandra.thrift.SchemaDisagreementException;
import org.apache.cassandra.thrift.TimedOutException;
import org.apache.cassandra.thrift.UnavailableException;
import org.apache.thrift.TException;

public class MainGraphMLLoader {

	public static void main(String args[]) throws XMLParseException, XMLStreamException, IOException, InvalidRequestException, TException, UnavailableException, TimedOutException, SchemaDisagreementException {
		if (args.length < 1) {
			System.out.println("not enough arguments, defaulting to \"graphml\"");
			args = new String[] { "graphml" };
		}

		switch (args[0]) {
		case "graphml":
			GraphMLParser graphMLParser = new GraphMLParser();
			graphMLParser.loadGraphML("graph-of-the-gods.xml", 337, 2789);
			break;
		case "config":
			loadConfig();
			break;
		}
	}

	private static List<Item> loadConfig() {
		ConfigParser read = new ConfigParser();
		List<Item> readConfig = read.readConfig("config.xml");
		return readConfig;
	}

}