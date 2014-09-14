/**
 */
package inventory.impl;

import inventory.InventoryPackage;
import inventory.MachineTemplate;
import inventory.TemplateSet;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link inventory.impl.TemplateSetImpl#getMachineTemplates <em>Machine Templates</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TemplateSetImpl extends MachineSetImpl implements TemplateSet {
	/**
	 * The cached value of the '{@link #getMachineTemplates() <em>Machine Templates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMachineTemplates()
	 * @generated
	 * @ordered
	 */
	protected EList<MachineTemplate> machineTemplates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InventoryPackage.Literals.TEMPLATE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MachineTemplate> getMachineTemplates() {
		if (machineTemplates == null) {
			machineTemplates = new EObjectContainmentEList<MachineTemplate>(MachineTemplate.class, this, InventoryPackage.TEMPLATE_SET__MACHINE_TEMPLATES);
		}
		return machineTemplates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InventoryPackage.TEMPLATE_SET__MACHINE_TEMPLATES:
				return ((InternalEList<?>)getMachineTemplates()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case InventoryPackage.TEMPLATE_SET__MACHINE_TEMPLATES:
				return getMachineTemplates();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case InventoryPackage.TEMPLATE_SET__MACHINE_TEMPLATES:
				getMachineTemplates().clear();
				getMachineTemplates().addAll((Collection<? extends MachineTemplate>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case InventoryPackage.TEMPLATE_SET__MACHINE_TEMPLATES:
				getMachineTemplates().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case InventoryPackage.TEMPLATE_SET__MACHINE_TEMPLATES:
				return machineTemplates != null && !machineTemplates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TemplateSetImpl
