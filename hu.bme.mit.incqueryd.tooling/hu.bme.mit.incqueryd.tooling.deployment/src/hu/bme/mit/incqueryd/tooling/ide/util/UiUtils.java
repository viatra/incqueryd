package hu.bme.mit.incqueryd.tooling.ide.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class UiUtils {

	private UiUtils() {
	}

	/**
	 * Returns the current workbench page.
	 */
	public static IWorkbenchWindow getWorkbenchWindow() {
		WindowFinder pageFinder = new WindowFinder(); // Ensure that we are in the UI thread
		Display.getDefault().syncExec(pageFinder);
		return pageFinder.getWindow();
	}

	private static final class WindowFinder implements Runnable {

		private IWorkbenchWindow window;

		@Override
		public void run() {
			window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		}

		public IWorkbenchWindow getWindow() {
			return window;
		}

	}

}
