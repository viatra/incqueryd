package hu.bme.mit.incqueryd.tooling.monitoring.preferences;

import hu.bme.mit.incqueryd.tooling.monitoring.Activator;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

/**
 * This class represents a preference page that is contributed to the
 * Preferences dialog. By subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows us to create a page
 * that is small and knows how to save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They are stored in the
 * preference store that belongs to the main plug-in class. That way,
 * preferences can be accessed directly via the preference store.
 */

public class MonitoringPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public MonitoringPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	/**
	 * Creates the field editors. Field editors are abstractions of the common
	 * GUI blocks needed to manipulate various types of preferences. Each field
	 * editor knows how to save and restore itself.
	 */
	protected void createFieldEditors() {
		addField(new FileFieldEditor(PreferenceConstants.MONITORING_SERVER_JAR, "&Monitoring server JAR:", getFieldEditorParent()));
		addField(new StringFieldEditor(PreferenceConstants.COLLECTOR_INTERFACE, "&Collector interface:", getFieldEditorParent()));
	}

	@Override
	public void init(IWorkbench workbench) {
	}

}