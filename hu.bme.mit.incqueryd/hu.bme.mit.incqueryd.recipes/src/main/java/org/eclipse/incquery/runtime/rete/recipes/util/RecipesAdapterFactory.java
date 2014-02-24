/**
 */
package org.eclipse.incquery.runtime.rete.recipes.util;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.runtime.rete.recipes.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage
 * @generated
 */
public class RecipesAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RecipesPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecipesAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = RecipesPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RecipesSwitch<Adapter> modelSwitch =
    new RecipesSwitch<Adapter>()
    {
      @Override
      public Adapter caseReteRecipe(ReteRecipe object)
      {
        return createReteRecipeAdapter();
      }
      @Override
      public Adapter caseReteNodeRecipe(ReteNodeRecipe object)
      {
        return createReteNodeRecipeAdapter();
      }
      @Override
      public Adapter caseSingleParentNodeRecipe(SingleParentNodeRecipe object)
      {
        return createSingleParentNodeRecipeAdapter();
      }
      @Override
      public Adapter caseAlphaRecipe(AlphaRecipe object)
      {
        return createAlphaRecipeAdapter();
      }
      @Override
      public Adapter caseMultiParentNodeRecipe(MultiParentNodeRecipe object)
      {
        return createMultiParentNodeRecipeAdapter();
      }
      @Override
      public Adapter caseUniquenessEnforcerRecipe(UniquenessEnforcerRecipe object)
      {
        return createUniquenessEnforcerRecipeAdapter();
      }
      @Override
      public Adapter caseProductionRecipe(ProductionRecipe object)
      {
        return createProductionRecipeAdapter();
      }
      @Override
      public Adapter caseProjectionIndexer(ProjectionIndexer object)
      {
        return createProjectionIndexerAdapter();
      }
      @Override
      public Adapter caseBetaRecipe(BetaRecipe object)
      {
        return createBetaRecipeAdapter();
      }
      @Override
      public Adapter caseMask(Mask object)
      {
        return createMaskAdapter();
      }
      @Override
      public Adapter caseStringIndexMapEntry(Map.Entry<String, Integer> object)
      {
        return createStringIndexMapEntryAdapter();
      }
      @Override
      public Adapter caseInputRecipe(InputRecipe object)
      {
        return createInputRecipeAdapter();
      }
      @Override
      public Adapter caseUnaryInputRecipe(UnaryInputRecipe object)
      {
        return createUnaryInputRecipeAdapter();
      }
      @Override
      public Adapter caseBinaryInputRecipe(BinaryInputRecipe object)
      {
        return createBinaryInputRecipeAdapter();
      }
      @Override
      public Adapter caseConstantRecipe(ConstantRecipe object)
      {
        return createConstantRecipeAdapter();
      }
      @Override
      public Adapter caseTransitiveClosureRecipe(TransitiveClosureRecipe object)
      {
        return createTransitiveClosureRecipeAdapter();
      }
      @Override
      public Adapter caseFilterRecipe(FilterRecipe object)
      {
        return createFilterRecipeAdapter();
      }
      @Override
      public Adapter caseInequalityFilterRecipe(InequalityFilterRecipe object)
      {
        return createInequalityFilterRecipeAdapter();
      }
      @Override
      public Adapter caseEqualityFilterRecipe(EqualityFilterRecipe object)
      {
        return createEqualityFilterRecipeAdapter();
      }
      @Override
      public Adapter caseTrimmerRecipe(TrimmerRecipe object)
      {
        return createTrimmerRecipeAdapter();
      }
      @Override
      public Adapter caseExpressionEnforcerRecipe(ExpressionEnforcerRecipe object)
      {
        return createExpressionEnforcerRecipeAdapter();
      }
      @Override
      public Adapter caseCheckRecipe(CheckRecipe object)
      {
        return createCheckRecipeAdapter();
      }
      @Override
      public Adapter caseEvalRecipe(EvalRecipe object)
      {
        return createEvalRecipeAdapter();
      }
      @Override
      public Adapter caseAggregatorRecipe(AggregatorRecipe object)
      {
        return createAggregatorRecipeAdapter();
      }
      @Override
      public Adapter caseCountAggregatorRecipe(CountAggregatorRecipe object)
      {
        return createCountAggregatorRecipeAdapter();
      }
      @Override
      public Adapter caseJoinRecipe(JoinRecipe object)
      {
        return createJoinRecipeAdapter();
      }
      @Override
      public Adapter caseExistenceJoinRecipe(ExistenceJoinRecipe object)
      {
        return createExistenceJoinRecipeAdapter();
      }
      @Override
      public Adapter caseSemiJoinRecipe(SemiJoinRecipe object)
      {
        return createSemiJoinRecipeAdapter();
      }
      @Override
      public Adapter caseAntiJoinRecipe(AntiJoinRecipe object)
      {
        return createAntiJoinRecipeAdapter();
      }
      @Override
      public Adapter caseAggregatorJoinRecipe(AggregatorJoinRecipe object)
      {
        return createAggregatorJoinRecipeAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.ReteRecipe <em>Rete Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
   * @generated
   */
  public Adapter createReteRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe <em>Rete Node Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
   * @generated
   */
  public Adapter createReteNodeRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe <em>Single Parent Node Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe
   * @generated
   */
  public Adapter createSingleParentNodeRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe <em>Alpha Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe
   * @generated
   */
  public Adapter createAlphaRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe <em>Multi Parent Node Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe
   * @generated
   */
  public Adapter createMultiParentNodeRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe <em>Uniqueness Enforcer Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe
   * @generated
   */
  public Adapter createUniquenessEnforcerRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe <em>Production Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
   * @generated
   */
  public Adapter createProductionRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer <em>Projection Indexer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer
   * @generated
   */
  public Adapter createProjectionIndexerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.BetaRecipe <em>Beta Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
   * @generated
   */
  public Adapter createBetaRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.Mask <em>Mask</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.Mask
   * @generated
   */
  public Adapter createMaskAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String Index Map Entry</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see java.util.Map.Entry
   * @generated
   */
  public Adapter createStringIndexMapEntryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.InputRecipe <em>Input Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.InputRecipe
   * @generated
   */
  public Adapter createInputRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe <em>Unary Input Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe
   * @generated
   */
  public Adapter createUnaryInputRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe <em>Binary Input Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe
   * @generated
   */
  public Adapter createBinaryInputRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe <em>Constant Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe
   * @generated
   */
  public Adapter createConstantRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.TransitiveClosureRecipe <em>Transitive Closure Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.TransitiveClosureRecipe
   * @generated
   */
  public Adapter createTransitiveClosureRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.FilterRecipe <em>Filter Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.FilterRecipe
   * @generated
   */
  public Adapter createFilterRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe <em>Inequality Filter Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe
   * @generated
   */
  public Adapter createInequalityFilterRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe <em>Equality Filter Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe
   * @generated
   */
  public Adapter createEqualityFilterRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe <em>Trimmer Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe
   * @generated
   */
  public Adapter createTrimmerRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe <em>Expression Enforcer Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe
   * @generated
   */
  public Adapter createExpressionEnforcerRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.CheckRecipe <em>Check Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.CheckRecipe
   * @generated
   */
  public Adapter createCheckRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.EvalRecipe <em>Eval Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.EvalRecipe
   * @generated
   */
  public Adapter createEvalRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe <em>Aggregator Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe
   * @generated
   */
  public Adapter createAggregatorRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.CountAggregatorRecipe <em>Count Aggregator Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.CountAggregatorRecipe
   * @generated
   */
  public Adapter createCountAggregatorRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.JoinRecipe <em>Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.JoinRecipe
   * @generated
   */
  public Adapter createJoinRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe <em>Existence Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe
   * @generated
   */
  public Adapter createExistenceJoinRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.SemiJoinRecipe <em>Semi Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.SemiJoinRecipe
   * @generated
   */
  public Adapter createSemiJoinRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe <em>Anti Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe
   * @generated
   */
  public Adapter createAntiJoinRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe <em>Aggregator Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe
   * @generated
   */
  public Adapter createAggregatorJoinRecipeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //RecipesAdapterFactory
