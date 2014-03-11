package hu.bme.mit.incqueryd.arch;

import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.messages.SubscriptionMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ArchUtil {

	/**
	 * Extract the type name from the trace info.
	 * 
	 * @param traceInfo
	 * @return
	 */
	public static String extractType(final String traceInfo) {
		final Pattern pattern = Pattern.compile(".*: (.*?) :.*");
		final Matcher matcher = pattern.matcher(traceInfo);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "";
		}
	}

	public static boolean hasAttribute(final String traceInfo) {
		final Pattern pattern = Pattern.compile(".* \\[(.*?)\\].*");
		final Matcher matcher = pattern.matcher(traceInfo);
		return matcher.find();
	}

	public static String extractAttribute(final String traceInfo) {
		final Pattern pattern = Pattern.compile(".* \\[(.*?)\\].*");
		final Matcher matcher = pattern.matcher(traceInfo);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "";
		}
	}

	/**
	 * Cut the proxy's name from the EMF URI.
	 * 
	 * @param emfUri
	 * @return
	 */
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

	public static SubscriptionMessage slotToMessage(final ReteNodeSlot slot) {
		switch (slot) {
		case PRIMARY:
			return SubscriptionMessage.SUBSCRIBE_PRIMARY;
		case SECONDARY:
			return SubscriptionMessage.SUBSCRIBE_SECONDARY;
		case SINGLE:
			return SubscriptionMessage.SUBSCRIBE_SINGLE;
		default:
			return null;
		}
	}

	/**
	 * Returns just the first line of a string.
	 * 
	 * @param string
	 * @return
	 */
	public static String justFirstLine(final String string) {
		// final int newLinePosition = string.indexOf("\n");
		// if (newLinePosition < 0) {
		// return string;
		// } else {
		// return string.substring(0, newLinePosition);
		// }
		return string.replaceAll("\n", "");
	}

}
