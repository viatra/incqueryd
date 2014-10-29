package hu.bme.mit.incqueryd.tooling.ide.util;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class UiUtils {

	private UiUtils() {
	}

	/**
	 * Returns the current workbench page.
	 */
	public static IWorkbenchPage getWorkbenchPage() {
		PageFinder pageFinder = new PageFinder(); // Ensure that we are in the UI thread
		Display.getDefault().syncExec(pageFinder);
		return pageFinder.getPage();
	}

	private static final class PageFinder implements Runnable {

		private IWorkbenchPage page;

		@Override
		public void run() {
			page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		}

		public IWorkbenchPage getPage() {
			return page;
		}

	}

}
