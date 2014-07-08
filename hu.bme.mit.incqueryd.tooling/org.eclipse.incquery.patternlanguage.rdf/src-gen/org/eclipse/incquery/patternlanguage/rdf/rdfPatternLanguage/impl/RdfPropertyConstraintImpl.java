/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.ConstraintImpl;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rdf Property Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPropertyConstraintImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPropertyConstraintImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPropertyConstraintImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RdfPropertyConstraintImpl extends ConstraintImpl implements RdfPropertyConstraint
{
  /**
   * The cached value of the '{@link #getRefType() <em>Ref Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefType()
   * @generated
   * @ordered
   */
  protected Iri refType;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected VariableReference source;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected ValueReference target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RdfPropertyConstraintImpl()
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
    return RdfPatternLanguagePackage.Literals.RDF_PROPERTY_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Iri getRefType()
  {
    return refType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetRefType(Iri newRefType, NotificationChain msgs)
  {
    Iri oldRefType = refType;
    refType = newRefType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE, oldRefType, newRefType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefType(Iri newRefType)
  {
    if (newRefType != refType)
    {
      NotificationChain msgs = null;
      if (refType != null)
        msgs = ((InternalEObject)refType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE, null, msgs);
      if (newRefType != null)
        msgs = ((InternalEObject)newRefType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE, null, msgs);
      msgs = basicSetRefType(newRefType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE, newRefType, newRefType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableReference getSource()
  {
    return source;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSource(VariableReference newSource, NotificationChain msgs)
  {
    VariableReference oldSource = source;
    source = newSource;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE, oldSource, newSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSource(VariableReference newSource)
  {
    if (newSource != source)
    {
      NotificationChain msgs = null;
      if (source != null)
        msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE, null, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE, null, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE, newSource, newSource));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueReference getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(ValueReference newTarget, NotificationChain msgs)
  {
    ValueReference oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(ValueReference newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET, newTarget, newTarget));
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
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE:
        return basicSetRefType(null, msgs);
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE:
        return basicSetSource(null, msgs);
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET:
        return basicSetTarget(null, msgs);
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
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE:
        return getRefType();
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE:
        return getSource();
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET:
        return getTarget();
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
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE:
        setRefType((Iri)newValue);
        return;
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE:
        setSource((VariableReference)newValue);
        return;
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET:
        setTarget((ValueReference)newValue);
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
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE:
        setRefType((Iri)null);
        return;
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE:
        setSource((VariableReference)null);
        return;
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET:
        setTarget((ValueReference)null);
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
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__REF_TYPE:
        return refType != null;
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__SOURCE:
        return source != null;
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT__TARGET:
        return target != null;
    }
    return super.eIsSet(featureID);
  }

} //RdfPropertyConstraintImpl
