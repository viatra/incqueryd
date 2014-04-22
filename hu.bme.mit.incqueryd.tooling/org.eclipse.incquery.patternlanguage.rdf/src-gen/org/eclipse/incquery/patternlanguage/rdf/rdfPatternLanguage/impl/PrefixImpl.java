/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prefix</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixImpl#getIri <em>Iri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrefixImpl extends MinimalEObjectImpl.Container implements Prefix
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getIri() <em>Iri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIri()
   * @generated
   * @ordered
   */
  protected static final String IRI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIri() <em>Iri</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIri()
   * @generated
   * @ordered
   */
  protected String iri = IRI_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrefixImpl()
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
    return RdfPatternLanguagePackage.Literals.PREFIX;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.PREFIX__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getIri()
  {
    return iri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIri(String newIri)
  {
    String oldIri = iri;
    iri = newIri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.PREFIX__IRI, oldIri, iri));
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
      case RdfPatternLanguagePackage.PREFIX__NAME:
        return getName();
      case RdfPatternLanguagePackage.PREFIX__IRI:
        return getIri();
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
      case RdfPatternLanguagePackage.PREFIX__NAME:
        setName((String)newValue);
        return;
      case RdfPatternLanguagePackage.PREFIX__IRI:
        setIri((String)newValue);
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
      case RdfPatternLanguagePackage.PREFIX__NAME:
        setName(NAME_EDEFAULT);
        return;
      case RdfPatternLanguagePackage.PREFIX__IRI:
        setIri(IRI_EDEFAULT);
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
      case RdfPatternLanguagePackage.PREFIX__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case RdfPatternLanguagePackage.PREFIX__IRI:
        return IRI_EDEFAULT == null ? iri != null : !IRI_EDEFAULT.equals(iri);
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
    result.append(" (name: ");
    result.append(name);
    result.append(", iri: ");
    result.append(iri);
    result.append(')');
    return result.toString();
  }

} //PrefixImpl
