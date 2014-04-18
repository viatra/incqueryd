/**
 */
package org.eclipse.incquery.runtime.rete.recipes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Join Recipe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The most basic beta operation, the join node performs a join operation over two input tuple sets.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.JoinRecipe#getRightParentComplementaryMask <em>Right Parent Complementary Mask</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getJoinRecipe()
 * @model
 * @generated
 */
public interface JoinRecipe extends BetaRecipe
{
  /**
   * Returns the value of the '<em><b>Right Parent Complementary Mask</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Parent Complementary Mask</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Parent Complementary Mask</em>' containment reference.
   * @see #setRightParentComplementaryMask(Mask)
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#getJoinRecipe_RightParentComplementaryMask()
   * @model containment="true"
   * @generated
   */
  Mask getRightParentComplementaryMask();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.runtime.rete.recipes.JoinRecipe#getRightParentComplementaryMask <em>Right Parent Complementary Mask</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Parent Complementary Mask</em>' containment reference.
   * @see #getRightParentComplementaryMask()
   * @generated
   */
  void setRightParentComplementaryMask(Mask value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" unique="false"
   *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.incquery.runtime.rete.recipes.JoinRecipe%> _this = this;\n<%org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe%> _leftParent = _this.getLeftParent();\nint _arity = _leftParent.getArity();\n<%org.eclipse.incquery.runtime.rete.recipes.JoinRecipe%> _this_1 = this;\n<%org.eclipse.incquery.runtime.rete.recipes.IndexerRecipe%> _rightParent = _this_1.getRightParent();\nint _arity_1 = _rightParent.getArity();\nint _plus = (_arity + _arity_1);\n<%org.eclipse.incquery.runtime.rete.recipes.JoinRecipe%> _this_2 = this;\n<%org.eclipse.incquery.runtime.rete.recipes.IndexerRecipe%> _rightParent_1 = _this_2.getRightParent();\n<%org.eclipse.incquery.runtime.rete.recipes.Mask%> _mask = _rightParent_1.getMask();\n<%org.eclipse.emf.common.util.EList%><<%java.lang.Integer%>> _sourceIndices = _mask.getSourceIndices();\nint _length = ((<%java.lang.Object%>[])<%org.eclipse.xtext.xbase.lib.Conversions%>.unwrapArray(_sourceIndices, <%java.lang.Object%>.class)).length;\nint _minus = (_plus - _length);\nreturn _minus;'"
   * @generated
   */
  int getArity();

} // JoinRecipe
