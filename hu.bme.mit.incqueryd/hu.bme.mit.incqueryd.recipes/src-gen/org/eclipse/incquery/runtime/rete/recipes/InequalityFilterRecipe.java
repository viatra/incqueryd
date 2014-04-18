/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inequality Filter Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe#getInequals <em>Inequals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getInequalityFilterRecipe()
 * @model
 * @generated
 */
public interface InequalityFilterRecipe extends FilterRecipe
{
  /**
   * Returns the value of the '<em><b>Subject</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subject</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subject</em>' attribute.
   * @see #setSubject(Integer)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getInequalityFilterRecipe_Subject()
   * @model unique="false" dataType="org.eclipse.incquery.runtime.rete.recipes.Index"
   * @generated
   */
  Integer getSubject();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe#getSubject <em>Subject</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subject</em>' attribute.
   * @see #getSubject()
   * @generated
   */
  void setSubject(Integer value);

  /**
   * Returns the value of the '<em><b>Inequals</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inequals</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inequals</em>' attribute list.
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getInequalityFilterRecipe_Inequals()
   * @model unique="false" dataType="org.eclipse.incquery.runtime.rete.recipes.Index"
   * @generated
   */
  EList<Integer> getInequals();

} // InequalityFilterRecipe
