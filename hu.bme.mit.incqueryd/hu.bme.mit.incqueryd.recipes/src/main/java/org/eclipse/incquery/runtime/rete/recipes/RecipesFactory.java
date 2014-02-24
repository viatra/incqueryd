/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage
 * @generated
 */
public interface RecipesFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RecipesFactory eINSTANCE = org.eclipse.incquery.runtime.rete.recipes.impl.RecipesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Rete Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rete Recipe</em>'.
   * @generated
   */
  ReteRecipe createReteRecipe();

  /**
   * Returns a new object of class '<em>Uniqueness Enforcer Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Uniqueness Enforcer Recipe</em>'.
   * @generated
   */
  UniquenessEnforcerRecipe createUniquenessEnforcerRecipe();

  /**
   * Returns a new object of class '<em>Production Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Production Recipe</em>'.
   * @generated
   */
  ProductionRecipe createProductionRecipe();

  /**
   * Returns a new object of class '<em>Projection Indexer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Projection Indexer</em>'.
   * @generated
   */
  ProjectionIndexer createProjectionIndexer();

  /**
   * Returns a new object of class '<em>Mask</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mask</em>'.
   * @generated
   */
  Mask createMask();

  /**
   * Returns a new object of class '<em>Unary Input Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Input Recipe</em>'.
   * @generated
   */
  UnaryInputRecipe createUnaryInputRecipe();

  /**
   * Returns a new object of class '<em>Binary Input Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Input Recipe</em>'.
   * @generated
   */
  BinaryInputRecipe createBinaryInputRecipe();

  /**
   * Returns a new object of class '<em>Constant Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Recipe</em>'.
   * @generated
   */
  ConstantRecipe createConstantRecipe();

  /**
   * Returns a new object of class '<em>Transitive Closure Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transitive Closure Recipe</em>'.
   * @generated
   */
  TransitiveClosureRecipe createTransitiveClosureRecipe();

  /**
   * Returns a new object of class '<em>Inequality Filter Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inequality Filter Recipe</em>'.
   * @generated
   */
  InequalityFilterRecipe createInequalityFilterRecipe();

  /**
   * Returns a new object of class '<em>Equality Filter Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Filter Recipe</em>'.
   * @generated
   */
  EqualityFilterRecipe createEqualityFilterRecipe();

  /**
   * Returns a new object of class '<em>Trimmer Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trimmer Recipe</em>'.
   * @generated
   */
  TrimmerRecipe createTrimmerRecipe();

  /**
   * Returns a new object of class '<em>Check Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Check Recipe</em>'.
   * @generated
   */
  CheckRecipe createCheckRecipe();

  /**
   * Returns a new object of class '<em>Eval Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Eval Recipe</em>'.
   * @generated
   */
  EvalRecipe createEvalRecipe();

  /**
   * Returns a new object of class '<em>Count Aggregator Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Count Aggregator Recipe</em>'.
   * @generated
   */
  CountAggregatorRecipe createCountAggregatorRecipe();

  /**
   * Returns a new object of class '<em>Join Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Join Recipe</em>'.
   * @generated
   */
  JoinRecipe createJoinRecipe();

  /**
   * Returns a new object of class '<em>Semi Join Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Semi Join Recipe</em>'.
   * @generated
   */
  SemiJoinRecipe createSemiJoinRecipe();

  /**
   * Returns a new object of class '<em>Anti Join Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anti Join Recipe</em>'.
   * @generated
   */
  AntiJoinRecipe createAntiJoinRecipe();

  /**
   * Returns a new object of class '<em>Aggregator Join Recipe</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Aggregator Join Recipe</em>'.
   * @generated
   */
  AggregatorJoinRecipe createAggregatorJoinRecipe();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  RecipesPackage getRecipesPackage();

} //RecipesFactory
