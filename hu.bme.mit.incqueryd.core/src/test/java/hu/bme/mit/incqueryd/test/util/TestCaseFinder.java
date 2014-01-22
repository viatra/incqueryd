package hu.bme.mit.incqueryd.test.util;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.filefilter.WildcardFileFilter;

public class TestCaseFinder {

	public static File[] getTestCases(String wildcard) {
		File dir = new File(TestConstants.TEST_CASES_DIRECTORY);
		FileFilter fileFilter = new WildcardFileFilter(wildcard);
		File[] files = dir.listFiles(fileFilter);
		return files;
	}
	
}
