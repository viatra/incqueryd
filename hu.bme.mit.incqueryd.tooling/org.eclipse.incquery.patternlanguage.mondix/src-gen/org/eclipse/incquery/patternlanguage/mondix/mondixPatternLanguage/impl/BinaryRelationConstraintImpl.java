/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl;

import hu.bme.mit.incqueryd.mondixschema.Relation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.BinaryRelationConstraint;
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage;

import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.ConstraintImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Relation Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.BinaryRelationConstraintImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.BinaryRelationConstraintImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl.BinaryRelationConstraintImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryRelationConstraintImpl extends ConstraintImpl implements BinaryRelationConstraint
{
  /**
   * The cached value of the '{@link #getRelation() <em>Relation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelation()
   * @generated
   * @ordered
   */
  protected Relation relation;

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
  protected BinaryRelationConstraintImpl()
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
    return MondixPatternLanguagePackage.Literals.BINARY_RELATION_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Relation getRelation()
  {
    if (relation != null && relation.eIsProxy())
    {
      InternalEObject oldRelation = (InternalEObject)relation;
      relation = (Relation)eResolveProxy(oldRelation);
      if (relation != oldRelation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__RELATION, oldRelation, relation));
      }
    }
    return relation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Relation basicGetRelation()
  {
    return relation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRelation(Relation newRelation)
  {
    Relation oldRelation = relation;
    relation = newRelation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__RELATION, oldRelation, relation));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE, oldSource, newSource);
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
        msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE, null, msgs);
      if (newSource != null)
        msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE, null, msgs);
      msgs = basicSetSource(newSource, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE, newSource, newSource));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET, oldTarget, newTarget);
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
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET, newTarget, newTarget));
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
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE:
        return basicSetSource(null, msgs);
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET:
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
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__RELATION:
        if (resolve) return getRelation();
        return basicGetRelation();
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE:
        return getSource();
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET:
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
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__RELATION:
        setRelation((Relation)newValue);
        return;
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE:
        setSource((VariableReference)newValue);
        return;
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET:
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
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__RELATION:
        setRelation((Relation)null);
        return;
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE:
        setSource((VariableReference)null);
        return;
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET:
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
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__RELATION:
        return relation != null;
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__SOURCE:
        return source != null;
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT__TARGET:
        return target != null;
    }
    return super.eIsSet(featureID);
  }

} //BinaryRelationConstraintImpl
