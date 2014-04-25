/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Existence Join Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ExistenceJoinRecipeImpl extends BetaRecipeImpl implements ExistenceJoinRecipe
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExistenceJoinRecipeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return RecipesPackage.Literals.EXISTENCE_JOIN_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getArity()
  {
    ExistenceJoinRecipe _this = this;
    ProjectionIndexerRecipe _leftParent = _this.getLeftParent();
    int _arity = _leftParent.getArity();
    return _arity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass)
  {
    if (baseClass == ReteNodeRecipe.class)
    {
      switch (baseOperationID)
      {
        case RecipesPackage.RETE_NODE_RECIPE___GET_ARITY: return RecipesPackage.EXISTENCE_JOIN_RECIPE___GET_ARITY;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
  {
    switch (operationID)
    {
      case RecipesPackage.EXISTENCE_JOIN_RECIPE___GET_ARITY:
        return getArity();
    }
    return super.eInvoke(operationID, arguments);
  }

} //ExistenceJoinRecipeImpl
