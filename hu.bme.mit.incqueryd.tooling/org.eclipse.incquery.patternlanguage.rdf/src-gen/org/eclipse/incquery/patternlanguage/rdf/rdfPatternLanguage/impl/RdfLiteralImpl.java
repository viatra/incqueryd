/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.LiteralValueReferenceImpl;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rdf Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl#getLexicalForm <em>Lexical Form</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl#getDatatype <em>Datatype</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RdfLiteralImpl extends LiteralValueReferenceImpl implements RdfLiteral
{
  /**
   * The default value of the '{@link #getLexicalForm() <em>Lexical Form</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLexicalForm()
   * @generated
   * @ordered
   */
  protected static final String LEXICAL_FORM_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLexicalForm() <em>Lexical Form</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLexicalForm()
   * @generated
   * @ordered
   */
  protected String lexicalForm = LEXICAL_FORM_EDEFAULT;

  /**
   * The cached value of the '{@link #getDatatype() <em>Datatype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDatatype()
   * @generated
   * @ordered
   */
  protected Iri datatype;

  /**
   * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguage()
   * @generated
   * @ordered
   */
  protected static final String LANGUAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLanguage()
   * @generated
   * @ordered
   */
  protected String language = LANGUAGE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RdfLiteralImpl()
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
    return RdfPatternLanguagePackage.Literals.RDF_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLexicalForm()
  {
    return lexicalForm;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLexicalForm(String newLexicalForm)
  {
    String oldLexicalForm = lexicalForm;
    lexicalForm = newLexicalForm;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_LITERAL__LEXICAL_FORM, oldLexicalForm, lexicalForm));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Iri getDatatype()
  {
    return datatype;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDatatype(Iri newDatatype, NotificationChain msgs)
  {
    Iri oldDatatype = datatype;
    datatype = newDatatype;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE, oldDatatype, newDatatype);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDatatype(Iri newDatatype)
  {
    if (newDatatype != datatype)
    {
      NotificationChain msgs = null;
      if (datatype != null)
        msgs = ((InternalEObject)datatype).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE, null, msgs);
      if (newDatatype != null)
        msgs = ((InternalEObject)newDatatype).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE, null, msgs);
      msgs = basicSetDatatype(newDatatype, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE, newDatatype, newDatatype));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLanguage()
  {
    return language;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLanguage(String newLanguage)
  {
    String oldLanguage = language;
    language = newLanguage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_LITERAL__LANGUAGE, oldLanguage, language));
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
      case RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE:
        return basicSetDatatype(null, msgs);
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
      case RdfPatternLanguagePackage.RDF_LITERAL__LEXICAL_FORM:
        return getLexicalForm();
      case RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE:
        return getDatatype();
      case RdfPatternLanguagePackage.RDF_LITERAL__LANGUAGE:
        return getLanguage();
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
      case RdfPatternLanguagePackage.RDF_LITERAL__LEXICAL_FORM:
        setLexicalForm((String)newValue);
        return;
      case RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE:
        setDatatype((Iri)newValue);
        return;
      case RdfPatternLanguagePackage.RDF_LITERAL__LANGUAGE:
        setLanguage((String)newValue);
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
      case RdfPatternLanguagePackage.RDF_LITERAL__LEXICAL_FORM:
        setLexicalForm(LEXICAL_FORM_EDEFAULT);
        return;
      case RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE:
        setDatatype((Iri)null);
        return;
      case RdfPatternLanguagePackage.RDF_LITERAL__LANGUAGE:
        setLanguage(LANGUAGE_EDEFAULT);
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
      case RdfPatternLanguagePackage.RDF_LITERAL__LEXICAL_FORM:
        return LEXICAL_FORM_EDEFAULT == null ? lexicalForm != null : !LEXICAL_FORM_EDEFAULT.equals(lexicalForm);
      case RdfPatternLanguagePackage.RDF_LITERAL__DATATYPE:
        return datatype != null;
      case RdfPatternLanguagePackage.RDF_LITERAL__LANGUAGE:
        return LANGUAGE_EDEFAULT == null ? language != null : !LANGUAGE_EDEFAULT.equals(language);
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
    result.append(" (lexicalForm: ");
    result.append(lexicalForm);
    result.append(", language: ");
    result.append(language);
    result.append(')');
    return result.toString();
  }

} //RdfLiteralImpl
