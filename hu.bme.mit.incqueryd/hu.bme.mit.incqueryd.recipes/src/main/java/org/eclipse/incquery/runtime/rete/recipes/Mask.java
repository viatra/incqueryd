/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mask</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A mask defines the set of tuple variables that need to be taken into consideration for operations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.Mask#getSourceIndices <em>Source Indices</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.Mask#getSourceArity <em>Source Arity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getMask()
 * @model
 * @generated
 */
public interface Mask extends EObject
{
  /**
   * Returns the value of the '<em><b>Source Indices</b></em>' attribute list.
   * The list contents are of type {@link java.lang.Integer}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The indices that are relevant for tuple operations.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Source Indices</em>' attribute list.
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getMask_SourceIndices()
   * @model unique="false" dataType="org.eclipse.incquery.runtime.rete.recipes.Index"
   * @generated
   */
  EList<Integer> getSourceIndices();

  /**
   * Returns the value of the '<em><b>Source Arity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * The arity of tuples.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Source Arity</em>' attribute.
   * @see #setSourceArity(int)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getMask_SourceArity()
   * @model unique="false"
   * @generated
   */
  int getSourceArity();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.Mask#getSourceArity <em>Source Arity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Arity</em>' attribute.
   * @see #getSourceArity()
   * @generated
   */
  void setSourceArity(int value);

} // Mask
