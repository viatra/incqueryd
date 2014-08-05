package hu.bme.mit.incqueryd.tooling.monitoring.preferences;

import hu.bme.mit.incqueryd.tooling.monitoring.Activator;
import hu.bme.mit.incqueryd.tooling.monitoring.NetworkAddressHelper;

import java.io.File;
import java.net.UnknownHostException;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		File homeDir = new File(System.getProperty("user.home"));
		File defaultMonitoringServerJar = new File(homeDir, ".m2/repository/hu/bme/mit/incqueryd/monitoringserver/dw-server/0.0.1-SNAPSHOT/dw-server-0.0.1-SNAPSHOT.jar");
		store.setDefault(PreferenceConstants.MONITORING_SERVER_JAR, defaultMonitoringServerJar.getAbsolutePath());
		String hostAddress = "127.0.0.1";
		try {
			hostAddress = NetworkAddressHelper.getLocalHostLANAddress().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO log
		}
		store.setDefault(PreferenceConstants.COLLECTOR_INTERFACE, hostAddress);
	}

}
