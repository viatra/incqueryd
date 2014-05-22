package hu.bme.mit.incqueryd.rdf;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;

import org.openrdf.model.Model;
import org.openrdf.model.impl.LinkedHashModel;
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

}
