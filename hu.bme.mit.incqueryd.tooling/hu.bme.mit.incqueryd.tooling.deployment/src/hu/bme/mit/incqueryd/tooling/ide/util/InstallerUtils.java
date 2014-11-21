package hu.bme.mit.incqueryd.tooling.ide.util;

import hu.bme.mit.incqueryd.tooling.ide.Activator;
import hu.bme.mit.incqueryd.tooling.ide.preferences.PreferenceConstants;

import java.io.File;

public class InstallerUtils {

	public static File getActualInstallerRoot() {
		File installerDirectory = new File(Activator.getDefault().getPreferenceStore().getString(PreferenceConstants.RUNTIME_PATH));
		return new File(installerDirectory, "archive");
	}
	
}
