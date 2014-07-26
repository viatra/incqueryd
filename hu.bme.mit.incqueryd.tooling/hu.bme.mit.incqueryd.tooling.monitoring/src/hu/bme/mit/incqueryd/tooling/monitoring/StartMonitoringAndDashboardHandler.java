package hu.bme.mit.incqueryd.tooling.monitoring;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;

public class StartMonitoringAndDashboardHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			final IWebBrowser browser = PlatformUI.getWorkbench().getBrowserSupport().createBrowser("IncQuery-D Dashboard");
			browser.openURL(new URL("http://localhost"));
		} catch (MalformedURLException | PartInitException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

}
