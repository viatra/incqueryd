/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PatternModelImpl#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PatternModelImpl#getPrefixes <em>Prefixes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternModelImpl extends org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternModelImpl implements PatternModel
{
  /**
   * The cached value of the '{@link #getBase() <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBase()
   * @generated
   * @ordered
   */
  protected Base base;

  /**
   * The cached value of the '{@link #getPrefixes() <em>Prefixes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefixes()
   * @generated
   * @ordered
   */
  protected EList<Prefix> prefixes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PatternModelImpl()
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
    return RdfPatternLanguagePackage.Literals.PATTERN_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Base getBase()
  {
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBase(Base newBase, NotificationChain msgs)
  {
    Base oldBase = base;
    base = newBase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.PATTERN_MODEL__BASE, oldBase, newBase);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBase(Base newBase)
  {
    if (newBase != base)
    {
      NotificationChain msgs = null;
      if (base != null)
        msgs = ((InternalEObject)base).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.PATTERN_MODEL__BASE, null, msgs);
      if (newBase != null)
        msgs = ((InternalEObject)newBase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.PATTERN_MODEL__BASE, null, msgs);
      msgs = basicSetBase(newBase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.PATTERN_MODEL__BASE, newBase, newBase));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Prefix> getPrefixes()
  {
    if (prefixes == null)
    {
      prefixes = new EObjectContainmentEList<Prefix>(Prefix.class, this, RdfPatternLanguagePackage.PATTERN_MODEL__PREFIXES);
    }
    return prefixes;
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
      case RdfPatternLanguagePackage.PATTERN_MODEL__BASE:
        return basicSetBase(null, msgs);
      case RdfPatternLanguagePackage.PATTERN_MODEL__PREFIXES:
        return ((InternalEList<?>)getPrefixes()).basicRemove(otherEnd, msgs);
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
      case RdfPatternLanguagePackage.PATTERN_MODEL__BASE:
        return getBase();
      case RdfPatternLanguagePackage.PATTERN_MODEL__PREFIXES:
        return getPrefixes();
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
      case RdfPatternLanguagePackage.PATTERN_MODEL__BASE:
        setBase((Base)newValue);
        return;
      case RdfPatternLanguagePackage.PATTERN_MODEL__PREFIXES:
        getPrefixes().clear();
        getPrefixes().addAll((Collection<? extends Prefix>)newValue);
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
      case RdfPatternLanguagePackage.PATTERN_MODEL__BASE:
        setBase((Base)null);
        return;
      case RdfPatternLanguagePackage.PATTERN_MODEL__PREFIXES:
        getPrefixes().clear();
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
      case RdfPatternLanguagePackage.PATTERN_MODEL__BASE:
        return base != null;
      case RdfPatternLanguagePackage.PATTERN_MODEL__PREFIXES:
        return prefixes != null && !prefixes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //PatternModelImpl
