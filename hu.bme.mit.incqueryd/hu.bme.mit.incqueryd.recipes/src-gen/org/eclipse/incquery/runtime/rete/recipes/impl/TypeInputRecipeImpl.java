/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Input Recipe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.TypeInputRecipeImpl#getTypeKey <em>Type Key</em>}</li>
 *   <li>{@link org.eclipse.incquery.runtime.rete.recipes.impl.TypeInputRecipeImpl#getTypeName <em>Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypeInputRecipeImpl extends InputRecipeImpl implements TypeInputRecipe
{
  /**
   * The default value of the '{@link #getTypeKey() <em>Type Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeKey()
   * @generated
   * @ordered
   */
  protected static final Object TYPE_KEY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeKey() <em>Type Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeKey()
   * @generated
   * @ordered
   */
  protected Object typeKey = TYPE_KEY_EDEFAULT;

  /**
   * The default value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected static final String TYPE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTypeName() <em>Type Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeName()
   * @generated
   * @ordered
   */
  protected String typeName = TYPE_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeInputRecipeImpl()
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
    return RecipesPackage.Literals.TYPE_INPUT_RECIPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object getTypeKey()
  {
    return typeKey;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeKey(Object newTypeKey)
  {
    Object oldTypeKey = typeKey;
    typeKey = newTypeKey;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.TYPE_INPUT_RECIPE__TYPE_KEY, oldTypeKey, typeKey));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTypeName()
  {
    return typeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeName(String newTypeName)
  {
    String oldTypeName = typeName;
    typeName = newTypeName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RecipesPackage.TYPE_INPUT_RECIPE__TYPE_NAME, oldTypeName, typeName));
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
      case RecipesPackage.TYPE_INPUT_RECIPE__TYPE_KEY:
        return getTypeKey();
      case RecipesPackage.TYPE_INPUT_RECIPE__TYPE_NAME:
        return getTypeName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case RecipesPackage.TYPE_INPUT_RECIPE__TYPE_KEY:
        setTypeKey(newValue);
        return;
      case RecipesPackage.TYPE_INPUT_RECIPE__TYPE_NAME:
        setTypeName((String)newValue);
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
      case RecipesPackage.TYPE_INPUT_RECIPE__TYPE_KEY:
        setTypeKey(TYPE_KEY_EDEFAULT);
        return;
      case RecipesPackage.TYPE_INPUT_RECIPE__TYPE_NAME:
        setTypeName(TYPE_NAME_EDEFAULT);
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
      case RecipesPackage.TYPE_INPUT_RECIPE__TYPE_KEY:
        return TYPE_KEY_EDEFAULT == null ? typeKey != null : !TYPE_KEY_EDEFAULT.equals(typeKey);
      case RecipesPackage.TYPE_INPUT_RECIPE__TYPE_NAME:
        return TYPE_NAME_EDEFAULT == null ? typeName != null : !TYPE_NAME_EDEFAULT.equals(typeName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (typeKey: ");
    result.append(typeKey);
    result.append(", typeName: ");
    result.append(typeName);
    result.append(')');
    return result.toString();
  }

} //TypeInputRecipeImpl
