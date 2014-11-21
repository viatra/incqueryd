package hu.bme.mit.incqueryd.tooling.ide;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "hu.bme.mit.incqueryd.tooling.deployment";
	
	private static Activator instance;

	public static AbstractUIPlugin getDefault() {
		return instance;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		instance = null;
		super.stop(context);
	}

}
