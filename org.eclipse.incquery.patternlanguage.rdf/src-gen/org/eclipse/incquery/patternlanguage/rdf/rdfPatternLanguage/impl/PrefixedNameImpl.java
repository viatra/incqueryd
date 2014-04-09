/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prefixed Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixedNameImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixedNameImpl#getPostfix <em>Postfix</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrefixedNameImpl extends IriImpl implements PrefixedName
{
  /**
   * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefix()
   * @generated
   * @ordered
   */
  protected Prefix prefix;

  /**
   * The default value of the '{@link #getPostfix() <em>Postfix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfix()
   * @generated
   * @ordered
   */
  protected static final String POSTFIX_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPostfix() <em>Postfix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfix()
   * @generated
   * @ordered
   */
  protected String postfix = POSTFIX_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrefixedNameImpl()
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
    return RdfPatternLanguagePackage.Literals.PREFIXED_NAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Prefix getPrefix()
  {
    if (prefix != null && prefix.eIsProxy())
    {
      InternalEObject oldPrefix = (InternalEObject)prefix;
      prefix = (Prefix)eResolveProxy(oldPrefix);
      if (prefix != oldPrefix)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, RdfPatternLanguagePackage.PREFIXED_NAME__PREFIX, oldPrefix, prefix));
      }
    }
    return prefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Prefix basicGetPrefix()
  {
    return prefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrefix(Prefix newPrefix)
  {
    Prefix oldPrefix = prefix;
    prefix = newPrefix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.PREFIXED_NAME__PREFIX, oldPrefix, prefix));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPostfix()
  {
    return postfix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostfix(String newPostfix)
  {
    String oldPostfix = postfix;
    postfix = newPostfix;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.PREFIXED_NAME__POSTFIX, oldPostfix, postfix));
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
      case RdfPatternLanguagePackage.PREFIXED_NAME__PREFIX:
        if (resolve) return getPrefix();
        return basicGetPrefix();
      case RdfPatternLanguagePackage.PREFIXED_NAME__POSTFIX:
        return getPostfix();
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
      case RdfPatternLanguagePackage.PREFIXED_NAME__PREFIX:
        setPrefix((Prefix)newValue);
        return;
      case RdfPatternLanguagePackage.PREFIXED_NAME__POSTFIX:
        setPostfix((String)newValue);
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
      case RdfPatternLanguagePackage.PREFIXED_NAME__PREFIX:
        setPrefix((Prefix)null);
        return;
      case RdfPatternLanguagePackage.PREFIXED_NAME__POSTFIX:
        setPostfix(POSTFIX_EDEFAULT);
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
      case RdfPatternLanguagePackage.PREFIXED_NAME__PREFIX:
        return prefix != null;
      case RdfPatternLanguagePackage.PREFIXED_NAME__POSTFIX:
        return POSTFIX_EDEFAULT == null ? postfix != null : !POSTFIX_EDEFAULT.equals(postfix);
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
    result.append(" (postfix: ");
    result.append(postfix);
    result.append(')');
    return result.toString();
  }

} //PrefixedNameImpl
