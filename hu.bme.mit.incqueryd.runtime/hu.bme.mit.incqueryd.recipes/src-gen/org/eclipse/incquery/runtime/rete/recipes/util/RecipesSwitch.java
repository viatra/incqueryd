/**
 */
package org.eclipse.incquery.runtime.rete.recipes.util;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.incquery.runtime.rete.recipes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage
 * @generated
 */
public class RecipesSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RecipesPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecipesSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = RecipesPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case RecipesPackage.RETE_RECIPE:
      {
        ReteRecipe reteRecipe = (ReteRecipe)theEObject;
        T result = caseReteRecipe(reteRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.RETE_NODE_RECIPE:
      {
        ReteNodeRecipe reteNodeRecipe = (ReteNodeRecipe)theEObject;
        T result = caseReteNodeRecipe(reteNodeRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.SINGLE_PARENT_NODE_RECIPE:
      {
        SingleParentNodeRecipe singleParentNodeRecipe = (SingleParentNodeRecipe)theEObject;
        T result = caseSingleParentNodeRecipe(singleParentNodeRecipe);
        if (result == null) result = caseReteNodeRecipe(singleParentNodeRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.ALPHA_RECIPE:
      {
        AlphaRecipe alphaRecipe = (AlphaRecipe)theEObject;
        T result = caseAlphaRecipe(alphaRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(alphaRecipe);
        if (result == null) result = caseReteNodeRecipe(alphaRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.MULTI_PARENT_NODE_RECIPE:
      {
        MultiParentNodeRecipe multiParentNodeRecipe = (MultiParentNodeRecipe)theEObject;
        T result = caseMultiParentNodeRecipe(multiParentNodeRecipe);
        if (result == null) result = caseReteNodeRecipe(multiParentNodeRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.UNIQUENESS_ENFORCER_RECIPE:
      {
        UniquenessEnforcerRecipe uniquenessEnforcerRecipe = (UniquenessEnforcerRecipe)theEObject;
        T result = caseUniquenessEnforcerRecipe(uniquenessEnforcerRecipe);
        if (result == null) result = caseMultiParentNodeRecipe(uniquenessEnforcerRecipe);
        if (result == null) result = caseReteNodeRecipe(uniquenessEnforcerRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.PRODUCTION_RECIPE:
      {
        ProductionRecipe productionRecipe = (ProductionRecipe)theEObject;
        T result = caseProductionRecipe(productionRecipe);
        if (result == null) result = caseMultiParentNodeRecipe(productionRecipe);
        if (result == null) result = caseReteNodeRecipe(productionRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.INDEXER_RECIPE:
      {
        IndexerRecipe indexerRecipe = (IndexerRecipe)theEObject;
        T result = caseIndexerRecipe(indexerRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(indexerRecipe);
        if (result == null) result = caseReteNodeRecipe(indexerRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.PROJECTION_INDEXER_RECIPE:
      {
        ProjectionIndexerRecipe projectionIndexerRecipe = (ProjectionIndexerRecipe)theEObject;
        T result = caseProjectionIndexerRecipe(projectionIndexerRecipe);
        if (result == null) result = caseIndexerRecipe(projectionIndexerRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(projectionIndexerRecipe);
        if (result == null) result = caseReteNodeRecipe(projectionIndexerRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.AGGREGATOR_INDEXER_RECIPE:
      {
        AggregatorIndexerRecipe aggregatorIndexerRecipe = (AggregatorIndexerRecipe)theEObject;
        T result = caseAggregatorIndexerRecipe(aggregatorIndexerRecipe);
        if (result == null) result = caseIndexerRecipe(aggregatorIndexerRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(aggregatorIndexerRecipe);
        if (result == null) result = caseReteNodeRecipe(aggregatorIndexerRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.BETA_RECIPE:
      {
        BetaRecipe betaRecipe = (BetaRecipe)theEObject;
        T result = caseBetaRecipe(betaRecipe);
        if (result == null) result = caseReteNodeRecipe(betaRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.MASK:
      {
        Mask mask = (Mask)theEObject;
        T result = caseMask(mask);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.STRING_INDEX_MAP_ENTRY:
      {
        @SuppressWarnings("unchecked") Map.Entry<String, Integer> stringIndexMapEntry = (Map.Entry<String, Integer>)theEObject;
        T result = caseStringIndexMapEntry(stringIndexMapEntry);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.INPUT_RECIPE:
      {
        InputRecipe inputRecipe = (InputRecipe)theEObject;
        T result = caseInputRecipe(inputRecipe);
        if (result == null) result = caseReteNodeRecipe(inputRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.TYPE_INPUT_RECIPE:
      {
        TypeInputRecipe typeInputRecipe = (TypeInputRecipe)theEObject;
        T result = caseTypeInputRecipe(typeInputRecipe);
        if (result == null) result = caseInputRecipe(typeInputRecipe);
        if (result == null) result = caseReteNodeRecipe(typeInputRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.UNARY_INPUT_RECIPE:
      {
        UnaryInputRecipe unaryInputRecipe = (UnaryInputRecipe)theEObject;
        T result = caseUnaryInputRecipe(unaryInputRecipe);
        if (result == null) result = caseTypeInputRecipe(unaryInputRecipe);
        if (result == null) result = caseInputRecipe(unaryInputRecipe);
        if (result == null) result = caseReteNodeRecipe(unaryInputRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.BINARY_INPUT_RECIPE:
      {
        BinaryInputRecipe binaryInputRecipe = (BinaryInputRecipe)theEObject;
        T result = caseBinaryInputRecipe(binaryInputRecipe);
        if (result == null) result = caseTypeInputRecipe(binaryInputRecipe);
        if (result == null) result = caseInputRecipe(binaryInputRecipe);
        if (result == null) result = caseReteNodeRecipe(binaryInputRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.CONSTANT_RECIPE:
      {
        ConstantRecipe constantRecipe = (ConstantRecipe)theEObject;
        T result = caseConstantRecipe(constantRecipe);
        if (result == null) result = caseReteNodeRecipe(constantRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.TRANSITIVE_CLOSURE_RECIPE:
      {
        TransitiveClosureRecipe transitiveClosureRecipe = (TransitiveClosureRecipe)theEObject;
        T result = caseTransitiveClosureRecipe(transitiveClosureRecipe);
        if (result == null) result = caseAlphaRecipe(transitiveClosureRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(transitiveClosureRecipe);
        if (result == null) result = caseReteNodeRecipe(transitiveClosureRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.FILTER_RECIPE:
      {
        FilterRecipe filterRecipe = (FilterRecipe)theEObject;
        T result = caseFilterRecipe(filterRecipe);
        if (result == null) result = caseAlphaRecipe(filterRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(filterRecipe);
        if (result == null) result = caseReteNodeRecipe(filterRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.INEQUALITY_FILTER_RECIPE:
      {
        InequalityFilterRecipe inequalityFilterRecipe = (InequalityFilterRecipe)theEObject;
        T result = caseInequalityFilterRecipe(inequalityFilterRecipe);
        if (result == null) result = caseFilterRecipe(inequalityFilterRecipe);
        if (result == null) result = caseAlphaRecipe(inequalityFilterRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(inequalityFilterRecipe);
        if (result == null) result = caseReteNodeRecipe(inequalityFilterRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.EQUALITY_FILTER_RECIPE:
      {
        EqualityFilterRecipe equalityFilterRecipe = (EqualityFilterRecipe)theEObject;
        T result = caseEqualityFilterRecipe(equalityFilterRecipe);
        if (result == null) result = caseFilterRecipe(equalityFilterRecipe);
        if (result == null) result = caseAlphaRecipe(equalityFilterRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(equalityFilterRecipe);
        if (result == null) result = caseReteNodeRecipe(equalityFilterRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.TRANSPARENT_RECIPE:
      {
        TransparentRecipe transparentRecipe = (TransparentRecipe)theEObject;
        T result = caseTransparentRecipe(transparentRecipe);
        if (result == null) result = caseFilterRecipe(transparentRecipe);
        if (result == null) result = caseAlphaRecipe(transparentRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(transparentRecipe);
        if (result == null) result = caseReteNodeRecipe(transparentRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.TRIMMER_RECIPE:
      {
        TrimmerRecipe trimmerRecipe = (TrimmerRecipe)theEObject;
        T result = caseTrimmerRecipe(trimmerRecipe);
        if (result == null) result = caseAlphaRecipe(trimmerRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(trimmerRecipe);
        if (result == null) result = caseReteNodeRecipe(trimmerRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.EXPRESSION_DEFINITION:
      {
        ExpressionDefinition expressionDefinition = (ExpressionDefinition)theEObject;
        T result = caseExpressionDefinition(expressionDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.EXPRESSION_ENFORCER_RECIPE:
      {
        ExpressionEnforcerRecipe expressionEnforcerRecipe = (ExpressionEnforcerRecipe)theEObject;
        T result = caseExpressionEnforcerRecipe(expressionEnforcerRecipe);
        if (result == null) result = caseAlphaRecipe(expressionEnforcerRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(expressionEnforcerRecipe);
        if (result == null) result = caseReteNodeRecipe(expressionEnforcerRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.CHECK_RECIPE:
      {
        CheckRecipe checkRecipe = (CheckRecipe)theEObject;
        T result = caseCheckRecipe(checkRecipe);
        if (result == null) result = caseExpressionEnforcerRecipe(checkRecipe);
        if (result == null) result = caseAlphaRecipe(checkRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(checkRecipe);
        if (result == null) result = caseReteNodeRecipe(checkRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.EVAL_RECIPE:
      {
        EvalRecipe evalRecipe = (EvalRecipe)theEObject;
        T result = caseEvalRecipe(evalRecipe);
        if (result == null) result = caseExpressionEnforcerRecipe(evalRecipe);
        if (result == null) result = caseAlphaRecipe(evalRecipe);
        if (result == null) result = caseSingleParentNodeRecipe(evalRecipe);
        if (result == null) result = caseReteNodeRecipe(evalRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.AGGREGATOR_RECIPE:
      {
        AggregatorRecipe aggregatorRecipe = (AggregatorRecipe)theEObject;
        T result = caseAggregatorRecipe(aggregatorRecipe);
        if (result == null) result = caseReteNodeRecipe(aggregatorRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.COUNT_AGGREGATOR_RECIPE:
      {
        CountAggregatorRecipe countAggregatorRecipe = (CountAggregatorRecipe)theEObject;
        T result = caseCountAggregatorRecipe(countAggregatorRecipe);
        if (result == null) result = caseAggregatorRecipe(countAggregatorRecipe);
        if (result == null) result = caseReteNodeRecipe(countAggregatorRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.JOIN_RECIPE:
      {
        JoinRecipe joinRecipe = (JoinRecipe)theEObject;
        T result = caseJoinRecipe(joinRecipe);
        if (result == null) result = caseBetaRecipe(joinRecipe);
        if (result == null) result = caseReteNodeRecipe(joinRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.EXISTENCE_JOIN_RECIPE:
      {
        ExistenceJoinRecipe existenceJoinRecipe = (ExistenceJoinRecipe)theEObject;
        T result = caseExistenceJoinRecipe(existenceJoinRecipe);
        if (result == null) result = caseBetaRecipe(existenceJoinRecipe);
        if (result == null) result = caseReteNodeRecipe(existenceJoinRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.SEMI_JOIN_RECIPE:
      {
        SemiJoinRecipe semiJoinRecipe = (SemiJoinRecipe)theEObject;
        T result = caseSemiJoinRecipe(semiJoinRecipe);
        if (result == null) result = caseExistenceJoinRecipe(semiJoinRecipe);
        if (result == null) result = caseBetaRecipe(semiJoinRecipe);
        if (result == null) result = caseReteNodeRecipe(semiJoinRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case RecipesPackage.ANTI_JOIN_RECIPE:
      {
        AntiJoinRecipe antiJoinRecipe = (AntiJoinRecipe)theEObject;
        T result = caseAntiJoinRecipe(antiJoinRecipe);
        if (result == null) result = caseExistenceJoinRecipe(antiJoinRecipe);
        if (result == null) result = caseBetaRecipe(antiJoinRecipe);
        if (result == null) result = caseReteNodeRecipe(antiJoinRecipe);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rete Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rete Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReteRecipe(ReteRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rete Node Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rete Node Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReteNodeRecipe(ReteNodeRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Parent Node Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Parent Node Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleParentNodeRecipe(SingleParentNodeRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Alpha Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Alpha Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlphaRecipe(AlphaRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multi Parent Node Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multi Parent Node Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiParentNodeRecipe(MultiParentNodeRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Uniqueness Enforcer Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Uniqueness Enforcer Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUniquenessEnforcerRecipe(UniquenessEnforcerRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Production Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Production Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProductionRecipe(ProductionRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Indexer Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Indexer Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndexerRecipe(IndexerRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Projection Indexer Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Projection Indexer Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProjectionIndexerRecipe(ProjectionIndexerRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Aggregator Indexer Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Aggregator Indexer Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAggregatorIndexerRecipe(AggregatorIndexerRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Beta Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Beta Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBetaRecipe(BetaRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mask</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mask</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMask(Mask object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Index Map Entry</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Index Map Entry</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringIndexMapEntry(Map.Entry<String, Integer> object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Input Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Input Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInputRecipe(InputRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Input Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Input Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeInputRecipe(TypeInputRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Input Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Input Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryInputRecipe(UnaryInputRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Input Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Input Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryInputRecipe(BinaryInputRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantRecipe(ConstantRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transitive Closure Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transitive Closure Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransitiveClosureRecipe(TransitiveClosureRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Filter Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Filter Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFilterRecipe(FilterRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inequality Filter Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inequality Filter Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInequalityFilterRecipe(InequalityFilterRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Filter Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Filter Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityFilterRecipe(EqualityFilterRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transparent Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transparent Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransparentRecipe(TransparentRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trimmer Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trimmer Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrimmerRecipe(TrimmerRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionDefinition(ExpressionDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Enforcer Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Enforcer Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionEnforcerRecipe(ExpressionEnforcerRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Check Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Check Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCheckRecipe(CheckRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Eval Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Eval Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvalRecipe(EvalRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Aggregator Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Aggregator Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAggregatorRecipe(AggregatorRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Count Aggregator Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Count Aggregator Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCountAggregatorRecipe(CountAggregatorRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Join Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Join Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJoinRecipe(JoinRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Existence Join Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Existence Join Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExistenceJoinRecipe(ExistenceJoinRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Semi Join Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Semi Join Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSemiJoinRecipe(SemiJoinRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anti Join Recipe</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anti Join Recipe</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAntiJoinRecipe(AntiJoinRecipe object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //RecipesSwitch
