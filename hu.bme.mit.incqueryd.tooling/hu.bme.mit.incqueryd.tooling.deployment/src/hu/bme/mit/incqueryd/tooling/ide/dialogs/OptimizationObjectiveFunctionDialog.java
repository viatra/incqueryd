package hu.bme.mit.incqueryd.tooling.ide.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class OptimizationObjectiveFunctionDialog extends TitleAreaDialog {

	private boolean forCommunication;

	private Button communicationButton;
	private Button costButton;

	public OptimizationObjectiveFunctionDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	  public void create() {
		super.create();
		setTitle("Choose objective function");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
	    Composite container = new Composite(area, SWT.NONE);
	    container.setLayoutData(new GridData(GridData.FILL_BOTH));
	    GridLayout layout = new GridLayout(2, false);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    container.setLayout(layout);

		communicationButton = new Button(container, SWT.RADIO);
	    communicationButton.setText("Communication");
	    costButton = new Button(container, SWT.RADIO);
	    costButton.setText("Cost");

		return container;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "OK", true);
		createButton(parent, IDialogConstants.CANCEL_ID, "Cancel", true);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	@Override
	protected void okPressed() {
		forCommunication = communicationButton.getSelection();
		super.okPressed();
	}

	public boolean forCommunication() {
		return forCommunication;
	}
}
