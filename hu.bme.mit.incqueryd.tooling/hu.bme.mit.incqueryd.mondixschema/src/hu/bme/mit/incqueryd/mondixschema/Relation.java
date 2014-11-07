/**
 */
package hu.bme.mit.incqueryd.mondixschema;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.mondixschema.Relation#getColumns <em>Columns</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends ENamedElement {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incqueryd.mondixschema.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage#getRelation_Columns()
	 * @model containment="true"
	 * @generated
	 */
	EList<Column> getColumns();

} // Relation
