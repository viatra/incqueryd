/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Parent Node Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.MultiParentNodeRecipeImpl#getParents <em>Parents</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MultiParentNodeRecipeImpl extends ReteNodeRecipeImpl implements MultiParentNodeRecipe
{
  /**
   * The cached value of the '{@link #getParents() <em>Parents</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParents()
   * @generated
   * @ordered
   */
  protected EList<ReteNodeRecipe> parents;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MultiParentNodeRecipeImpl()
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
    return RecipesPackage.Literals.MULTI_PARENT_NODE_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReteNodeRecipe> getParents()
  {
    if (parents == null)
    {
      parents = new EObjectResolvingEList<ReteNodeRecipe>(ReteNodeRecipe.class, this, RecipesPackage.MULTI_PARENT_NODE_RECIPE__PARENTS);
    }
    return parents;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case RecipesPackage.MULTI_PARENT_NODE_RECIPE__PARENTS:
        return getParents();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RecipesPackage.MULTI_PARENT_NODE_RECIPE__PARENTS:
        getParents().clear();
        getParents().addAll((Collection<? extends ReteNodeRecipe>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case RecipesPackage.MULTI_PARENT_NODE_RECIPE__PARENTS:
        getParents().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case RecipesPackage.MULTI_PARENT_NODE_RECIPE__PARENTS:
        return parents != null && !parents.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MultiParentNodeRecipeImpl
