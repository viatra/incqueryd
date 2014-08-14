package hu.bme.mit.incqueryd.tooling.ide.dialogs;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MonitoringServerAddressDialog extends Dialog {

	private Text ipAddressField;
	private String msIPAddress = "";

	public MonitoringServerAddressDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(2, false);
		layout.marginRight = 5;
		layout.marginLeft = 10;
		container.setLayout(layout);

		Label lblUser = new Label(container, SWT.NONE);
		lblUser.setText("Monitoring server IP:");

		ipAddressField = new Text(container, SWT.BORDER);
		ipAddressField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		ipAddressField.setText(msIPAddress);

		return container;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "OK", true);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	@Override
	protected void okPressed() {
		msIPAddress = ipAddressField.getText();
		super.okPressed();
	}
	
	public String getMsIPAddress() {
		return msIPAddress;
	}

}
