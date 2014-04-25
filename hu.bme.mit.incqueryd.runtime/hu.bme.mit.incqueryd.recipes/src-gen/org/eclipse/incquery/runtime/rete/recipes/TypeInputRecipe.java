/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Input Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents type-based input constraints.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe#getTypeKey <em>Type Key</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getTypeInputRecipe()
 * @model abstract="true"
 * @generated
 */
public interface TypeInputRecipe extends InputRecipe
{
  /**
   * Returns the value of the '<em><b>Type Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The original type of this input.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type Key</em>' attribute.
   * @see #setTypeKey(Object)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getTypeInputRecipe_TypeKey()
   * @model unique="false"
   * @generated
   */
  Object getTypeKey();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe#getTypeKey <em>Type Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Key</em>' attribute.
   * @see #getTypeKey()
   * @generated
   */
  void setTypeKey(Object value);

  /**
   * Returns the value of the '<em><b>Type Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Temporary construct for identifying types over the wire.
   * TODO improve type references
   * <!-- end-model-doc -->
   * @return the value of the '<em>Type Name</em>' attribute.
   * @see #setTypeName(String)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getTypeInputRecipe_TypeName()
   * @model unique="false"
   * @generated
   */
  String getTypeName();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe#getTypeName <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Name</em>' attribute.
   * @see #getTypeName()
   * @generated
   */
  void setTypeName(String value);

} // TypeInputRecipe
