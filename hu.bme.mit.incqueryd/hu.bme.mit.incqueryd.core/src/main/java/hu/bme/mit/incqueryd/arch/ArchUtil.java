package hu.bme.mit.incqueryd.arch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ArchUtil {
	
	public static String extractType(final String traceInfo) {
		final Pattern pattern = Pattern.compile("UniquenessEnforcerNode : (.*?) :.*");
		final Matcher matcher = pattern.matcher(traceInfo);
		String type = "";
		if (matcher.find()) {
			type = matcher.group(1);
		}
		return type;
	}
	
	public static String cutProxyName(final String emfUri) {
		final Pattern pattern = Pattern.compile(".*json#(.*)");
		final Matcher matcher = pattern.matcher(emfUri);
		if (matcher.matches()) {
			return matcher.group(1);
		} else {
			return null;
		}
	}
	
	public static String getJsonEObjectUri(final EObject eObject) {
		final URI uri = EcoreUtil.getURI(eObject);
		return cutProxyName(uri.toString());
	}
	
}
