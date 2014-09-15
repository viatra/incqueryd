package hu.bme.mit.incqueryd.core.test.util;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.filefilter.WildcardFileFilter;

public class TestCaseFinder {

	public static File[] getTestCases(final String wildcard) {
		final File dir = new File(TestConstants.TEST_CASES_DIRECTORY);
		final FileFilter fileFilter = new WildcardFileFilter(wildcard);
		final File[] files = dir.listFiles(fileFilter);
		return files;
	}
	
}
