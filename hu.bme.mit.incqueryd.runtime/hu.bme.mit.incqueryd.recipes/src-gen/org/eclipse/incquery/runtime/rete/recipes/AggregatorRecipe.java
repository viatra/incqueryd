/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregator Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a (compound) node that performs an aggregation operation.
 * Parent must be a ProjectionIndexer, which defines how tuples are to be aggregated.
 * Usable only through an Join with an AggregatorIndexer as the right parent
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getAggregatorRecipe()
 * @model abstract="true"
 * @generated
 */
public interface AggregatorRecipe extends ReteNodeRecipe
{
  /**
   * Returns the value of the '<em><b>Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parent</em>' containment reference.
   * @see #setParent(ProjectionIndexerRecipe)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getAggregatorRecipe_Parent()
   * @model containment="true"
   * @generated
   */
  ProjectionIndexerRecipe getParent();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe#getParent <em>Parent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parent</em>' containment reference.
   * @see #getParent()
   * @generated
   */
  void setParent(ProjectionIndexerRecipe value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe%> _this = this;\n<%org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe%> _parent = _this.getParent();\n<%org.eclipse.incquery.runtime.rete.recipes.Mask%> _mask = _parent.getMask();\n<%org.eclipse.emf.common.util.EList%><<%java.lang.Integer%>> _sourceIndices = _mask.getSourceIndices();\nint _length = ((<%java.lang.Object%>[])<%org.eclipse.xtext.xbase.lib.Conversions%>.unwrapArray(_sourceIndices, <%java.lang.Object%>.class)).length;\nint _plus = (1 + _length);\nreturn _plus;'"
   * @generated
   */
  int getArity();

} // AggregatorRecipe
