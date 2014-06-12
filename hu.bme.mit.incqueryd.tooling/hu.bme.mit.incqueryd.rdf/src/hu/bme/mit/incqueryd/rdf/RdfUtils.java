package hu.bme.mit.incqueryd.rdf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;

import org.openrdf.model.Model;
import org.openrdf.model.Resource;
import org.openrdf.model.impl.LinkedHashModel;
import org.openrdf.model.vocabulary.OWL;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;
import org.openrdf.rio.RDFFormat;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;
import org.openrdf.rio.RDFParser;
import org.openrdf.rio.Rio;
import org.openrdf.rio.helpers.StatementCollector;

public class RdfUtils {

	public static Model load(Set<URL> documentUrls) throws IOException, RDFParseException, RDFHandlerException {
		LinkedHashModel result = new LinkedHashModel();
		for (URL documentUrl : documentUrls) {
			String urlString = documentUrl.toString();
			RDFFormat format = Rio.getParserFormatForFileName(urlString);
			RDFParser parser = Rio.createParser(format);
			parser.setRDFHandler(new StatementCollector(result));
			InputStream inputStream = documentUrl.openStream();
			parser.parse(inputStream, urlString);
		}
		return result;
	}

	public static boolean isClass(Resource resource, Model vocabulary) {
		return vocabulary.contains(resource, RDF.TYPE, RDFS.CLASS) ||
				vocabulary.contains(resource, RDF.TYPE, OWL.CLASS);
	}

	public static boolean isDatatype(Resource resource, Model vocabulary) {
		return vocabulary.contains(resource, RDF.TYPE, RDFS.DATATYPE) ||
				resource.stringValue().startsWith("http://www.w3.org/2001/XMLSchema#"); // XXX
	}

	public static boolean isProperty(Resource resource, Model vocabulary) {
		return vocabulary.contains(resource, RDF.TYPE, RDF.PROPERTY) ||
				vocabulary.contains(resource, RDF.TYPE, OWL.OBJECTPROPERTY) ||
				vocabulary.contains(resource, RDF.TYPE, OWL.DATATYPEPROPERTY);
	}

}
