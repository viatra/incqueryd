/**
 */
package hu.bme.mit.incqueryd.mondixschema;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.mondixschema.Column#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends ENamedElement {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link hu.bme.mit.incqueryd.mondixschema.ColumnType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see hu.bme.mit.incqueryd.mondixschema.ColumnType
	 * @see #setType(ColumnType)
	 * @see hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage#getColumn_Type()
	 * @model
	 * @generated
	 */
	ColumnType getType();

	/**
	 * Sets the value of the '{@link hu.bme.mit.incqueryd.mondixschema.Column#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see hu.bme.mit.incqueryd.mondixschema.ColumnType
	 * @see #getType()
	 * @generated
	 */
	void setType(ColumnType value);
} // Column
