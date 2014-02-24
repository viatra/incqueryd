/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rete Node Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Abstract base class for model elements that represent "Rete node recipes",
 * that is DTOs that carry information for Rete network construction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe#getTraceInfo <em>Trace Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getReteNodeRecipe()
 * @model abstract="true"
 * @generated
 */
public interface ReteNodeRecipe extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * <!-- begin-model-doc -->
   * Temporary construct for storing traceability information.
   * <!-- end-model-doc -->
   * @return the value of the '<em>Trace Info</em>' attribute.
   * @see #setTraceInfo(String)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getReteNodeRecipe_TraceInfo()
   * @model unique="false"
   * @generated
   */
  String getTraceInfo();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe#getTraceInfo <em>Trace Info</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace Info</em>' attribute.
   * @see #getTraceInfo()
   * @generated
   */
  void setTraceInfo(String value);

} // ReteNodeRecipe
