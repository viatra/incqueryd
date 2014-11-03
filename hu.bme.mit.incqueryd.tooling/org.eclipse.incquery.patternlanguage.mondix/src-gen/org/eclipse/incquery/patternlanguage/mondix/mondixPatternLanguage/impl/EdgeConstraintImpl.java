/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage;

import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.ConstraintImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.EdgeConstraintImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.EdgeConstraintImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.EdgeConstraintImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeConstraintImpl extends ConstraintImpl implements EdgeConstraint
{
  /**
   * The default value of the '{@link #getRefType() <em>Ref Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefType()
   * @generated
   * @ordered
   */
  protected static final String REF_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRefType() <em>Ref Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRefType()
   * @generated
   * @ordered
   */
  protected String refType = REF_TYPE_EDEFAULT;

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
  protected EdgeConstraintImpl()
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
    return MondixPatternLanguagePackage.Literals.EDGE_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRefType()
  {
    return refType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRefType(String newRefType)
  {
    String oldRefType = refType;
    refType = newRefType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.EDGE_CONSTRAINT__REF_TYPE, oldRefType, refType));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE, oldSource, newSource);
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
        msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE, null, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE, null, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE, newSource, newSource));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET, oldTarget, newTarget);
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
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET, newTarget, newTarget));
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
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE:
        return basicSetSource(null, msgs);
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET:
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
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__REF_TYPE:
        return getRefType();
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE:
        return getSource();
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET:
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
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__REF_TYPE:
        setRefType((String)newValue);
        return;
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE:
        setSource((VariableReference)newValue);
        return;
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET:
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
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__REF_TYPE:
        setRefType(REF_TYPE_EDEFAULT);
        return;
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE:
        setSource((VariableReference)null);
        return;
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET:
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
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__REF_TYPE:
        return REF_TYPE_EDEFAULT == null ? refType != null : !REF_TYPE_EDEFAULT.equals(refType);
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__SOURCE:
        return source != null;
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT__TARGET:
        return target != null;
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
    result.append(" (refType: ");
    result.append(refType);
    result.append(')');
    return result.toString();
  }

} //EdgeConstraintImpl
