/**
 */
package arch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recipe Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arch.RecipeImport#getImportURI <em>Import URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see arch.ArchPackage#getRecipeImport()
 * @model
 * @generated
 */
public interface RecipeImport extends EObject
{
  /**
   * Returns the value of the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Import URI</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Import URI</em>' attribute.
   * @see #setImportURI(String)
   * @see arch.ArchPackage#getRecipeImport_ImportURI()
   * @model unique="false"
   * @generated
   */
  String getImportURI();

  /**
   * Sets the value of the '{@link arch.RecipeImport#getImportURI <em>Import URI</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Import URI</em>' attribute.
   * @see #getImportURI()
   * @generated
   */
  void setImportURI(String value);

} // RecipeImport
