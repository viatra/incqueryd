package hu.bme.mit.incqueryd.arch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
}
