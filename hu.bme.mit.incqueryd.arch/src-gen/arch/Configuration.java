/**
 */
package arch;

import infrastructure.ElementWithTraceInfo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arch.Configuration#getConnectionString <em>Connection String</em>}</li>
 *   <li>{@link arch.Configuration#getRecipeImports <em>Recipe Imports</em>}</li>
 *   <li>{@link arch.Configuration#getMappings <em>Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see arch.ArchPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends ElementWithTraceInfo {
	/**
	 * Returns the value of the '<em><b>Connection String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection String</em>' attribute.
	 * @see #setConnectionString(String)
	 * @see arch.ArchPackage#getConfiguration_ConnectionString()
	 * @model unique="false"
	 * @generated
	 */
	String getConnectionString();

	/**
	 * Sets the value of the '{@link arch.Configuration#getConnectionString <em>Connection String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection String</em>' attribute.
	 * @see #getConnectionString()
	 * @generated
	 */
	void setConnectionString(String value);

	/**
	 * Returns the value of the '<em><b>Recipe Imports</b></em>' containment reference list.
	 * The list contents are of type {@link arch.RecipeImport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recipe Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recipe Imports</em>' containment reference list.
	 * @see arch.ArchPackage#getConfiguration_RecipeImports()
	 * @model containment="true"
	 * @generated
	 */
	EList<RecipeImport> getRecipeImports();

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link arch.InfrastructureMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see arch.ArchPackage#getConfiguration_Mappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<InfrastructureMapping> getMappings();

} // Configuration
