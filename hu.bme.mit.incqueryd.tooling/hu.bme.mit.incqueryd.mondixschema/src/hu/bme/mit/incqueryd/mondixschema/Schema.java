/**
 */
package hu.bme.mit.incqueryd.mondixschema;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link hu.bme.mit.incqueryd.mondixschema.Schema#getRelations <em>Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @see hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage#getSchema()
 * @model
 * @generated
 */
public interface Schema extends ENamedElement {
	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link hu.bme.mit.incqueryd.mondixschema.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage#getSchema_Relations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Relation> getRelations();

} // Schema
