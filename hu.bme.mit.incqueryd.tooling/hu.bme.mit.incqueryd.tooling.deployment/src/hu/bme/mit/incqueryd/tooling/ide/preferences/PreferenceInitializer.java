package hu.bme.mit.incqueryd.tooling.ide.preferences;

import hu.bme.mit.incqueryd.tooling.ide.Activator;

import java.io.File;

import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		File defaultDirectory = new File(System.getProperty("user.home"), ".incqueryd");
		try {
			defaultDirectory.mkdirs();
		} catch (RuntimeException e) {
			Activator.getDefault().getLog().log(new Status(Status.ERROR, Activator.PLUGIN_ID, "Can't create default IncQuery-D runtime installer directory", e));
		}
		store.setDefault(PreferenceConstants.RUNTIME_PATH, defaultDirectory.getAbsolutePath());
	}

}
