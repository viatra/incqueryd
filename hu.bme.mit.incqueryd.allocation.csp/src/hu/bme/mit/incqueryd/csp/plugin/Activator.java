package hu.bme.mit.incqueryd.csp.plugin;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


public class Activator extends AbstractUIPlugin {

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		try{
			System.loadLibrary("jniortools");
		}catch(UnsatisfiedLinkError e){
			System.err.println(e.getMessage());
			System.out.println("ERROR: Cannot load or-tools native library");
		}
	}
	
}
