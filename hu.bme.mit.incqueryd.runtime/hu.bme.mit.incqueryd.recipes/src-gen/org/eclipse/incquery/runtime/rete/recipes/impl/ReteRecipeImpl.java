/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rete Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.ReteRecipeImpl#getRecipeNodes <em>Recipe Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReteRecipeImpl extends MinimalEObjectImpl.Container implements ReteRecipe
{
  /**
   * The cached value of the '{@link #getRecipeNodes() <em>Recipe Nodes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecipeNodes()
   * @generated
   * @ordered
   */
  protected EList<ReteNodeRecipe> recipeNodes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReteRecipeImpl()
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
    return RecipesPackage.Literals.RETE_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ReteNodeRecipe> getRecipeNodes()
  {
    if (recipeNodes == null)
    {
      recipeNodes = new EObjectContainmentEList<ReteNodeRecipe>(ReteNodeRecipe.class, this, RecipesPackage.RETE_RECIPE__RECIPE_NODES);
    }
    return recipeNodes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case RecipesPackage.RETE_RECIPE__RECIPE_NODES:
        return ((InternalEList<?>)getRecipeNodes()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case RecipesPackage.RETE_RECIPE__RECIPE_NODES:
        return getRecipeNodes();
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
      case RecipesPackage.RETE_RECIPE__RECIPE_NODES:
        getRecipeNodes().clear();
        getRecipeNodes().addAll((Collection<? extends ReteNodeRecipe>)newValue);
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
      case RecipesPackage.RETE_RECIPE__RECIPE_NODES:
        getRecipeNodes().clear();
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
      case RecipesPackage.RETE_RECIPE__RECIPE_NODES:
        return recipeNodes != null && !recipeNodes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ReteRecipeImpl
