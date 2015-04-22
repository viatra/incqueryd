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

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.PatternModelImpl;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rdf Pattern Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternModelImpl#getVocabularies <em>Vocabularies</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternModelImpl#getBaseIriValue <em>Base Iri Value</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternModelImpl#getIriPrefixes <em>Iri Prefixes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RdfPatternModelImpl extends PatternModelImpl implements RdfPatternModel
{
  /**
   * The cached value of the '{@link #getVocabularies() <em>Vocabularies</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVocabularies()
   * @generated
   * @ordered
   */
  protected EList<Vocabulary> vocabularies;

  /**
   * The default value of the '{@link #getBaseIriValue() <em>Base Iri Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseIriValue()
   * @generated
   * @ordered
   */
  protected static final String BASE_IRI_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBaseIriValue() <em>Base Iri Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBaseIriValue()
   * @generated
   * @ordered
   */
  protected String baseIriValue = BASE_IRI_VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getIriPrefixes() <em>Iri Prefixes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIriPrefixes()
   * @generated
   * @ordered
   */
  protected EList<IriPrefix> iriPrefixes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RdfPatternModelImpl()
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
    return RdfPatternLanguagePackage.Literals.RDF_PATTERN_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Vocabulary> getVocabularies()
  {
    if (vocabularies == null)
    {
      vocabularies = new EObjectContainmentEList<Vocabulary>(Vocabulary.class, this, RdfPatternLanguagePackage.RDF_PATTERN_MODEL__VOCABULARIES);
    }
    return vocabularies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBaseIriValue()
  {
    return baseIriValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBaseIriValue(String newBaseIriValue)
  {
    String oldBaseIriValue = baseIriValue;
    baseIriValue = newBaseIriValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PATTERN_MODEL__BASE_IRI_VALUE, oldBaseIriValue, baseIriValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IriPrefix> getIriPrefixes()
  {
    if (iriPrefixes == null)
    {
      iriPrefixes = new EObjectContainmentEList<IriPrefix>(IriPrefix.class, this, RdfPatternLanguagePackage.RDF_PATTERN_MODEL__IRI_PREFIXES);
    }
    return iriPrefixes;
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
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__VOCABULARIES:
        return ((InternalEList<?>)getVocabularies()).basicRemove(otherEnd, msgs);
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__IRI_PREFIXES:
        return ((InternalEList<?>)getIriPrefixes()).basicRemove(otherEnd, msgs);
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
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__VOCABULARIES:
        return getVocabularies();
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__BASE_IRI_VALUE:
        return getBaseIriValue();
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__IRI_PREFIXES:
        return getIriPrefixes();
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
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__VOCABULARIES:
        getVocabularies().clear();
        getVocabularies().addAll((Collection<? extends Vocabulary>)newValue);
        return;
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__BASE_IRI_VALUE:
        setBaseIriValue((String)newValue);
        return;
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__IRI_PREFIXES:
        getIriPrefixes().clear();
        getIriPrefixes().addAll((Collection<? extends IriPrefix>)newValue);
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
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__VOCABULARIES:
        getVocabularies().clear();
        return;
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__BASE_IRI_VALUE:
        setBaseIriValue(BASE_IRI_VALUE_EDEFAULT);
        return;
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__IRI_PREFIXES:
        getIriPrefixes().clear();
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
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__VOCABULARIES:
        return vocabularies != null && !vocabularies.isEmpty();
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__BASE_IRI_VALUE:
        return BASE_IRI_VALUE_EDEFAULT == null ? baseIriValue != null : !BASE_IRI_VALUE_EDEFAULT.equals(baseIriValue);
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL__IRI_PREFIXES:
        return iriPrefixes != null && !iriPrefixes.isEmpty();
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
    result.append(" (baseIriValue: ");
    result.append(baseIriValue);
    result.append(')');
    return result.toString();
  }

} //RdfPatternModelImpl
