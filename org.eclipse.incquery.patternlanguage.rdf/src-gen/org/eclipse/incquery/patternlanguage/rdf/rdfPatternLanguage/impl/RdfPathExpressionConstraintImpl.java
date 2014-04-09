/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.incquery.patternlanguage.patternLanguage.PathExpressionElement;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.VariableReference;

import org.eclipse.incquery.patternlanguage.patternLanguage.impl.ConstraintImpl;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPathExpressionConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rdf Path Expression Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPathExpressionConstraintImpl#getPathExpression <em>Path Expression</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPathExpressionConstraintImpl#getSrc <em>Src</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPathExpressionConstraintImpl#getDst <em>Dst</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RdfPathExpressionConstraintImpl extends ConstraintImpl implements RdfPathExpressionConstraint
{
  /**
   * The cached value of the '{@link #getPathExpression() <em>Path Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPathExpression()
   * @generated
   * @ordered
   */
  protected PathExpressionElement pathExpression;

  /**
   * The cached value of the '{@link #getSrc() <em>Src</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSrc()
   * @generated
   * @ordered
   */
  protected VariableReference src;

  /**
   * The cached value of the '{@link #getDst() <em>Dst</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDst()
   * @generated
   * @ordered
   */
  protected ValueReference dst;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RdfPathExpressionConstraintImpl()
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
    return RdfPatternLanguagePackage.Literals.RDF_PATH_EXPRESSION_CONSTRAINT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathExpressionElement getPathExpression()
  {
    return pathExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPathExpression(PathExpressionElement newPathExpression, NotificationChain msgs)
  {
    PathExpressionElement oldPathExpression = pathExpression;
    pathExpression = newPathExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION, oldPathExpression, newPathExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPathExpression(PathExpressionElement newPathExpression)
  {
    if (newPathExpression != pathExpression)
    {
      NotificationChain msgs = null;
      if (pathExpression != null)
        msgs = ((InternalEObject)pathExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION, null, msgs);
      if (newPathExpression != null)
        msgs = ((InternalEObject)newPathExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION, null, msgs);
      msgs = basicSetPathExpression(newPathExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION, newPathExpression, newPathExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableReference getSrc()
  {
    return src;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSrc(VariableReference newSrc, NotificationChain msgs)
  {
    VariableReference oldSrc = src;
    src = newSrc;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC, oldSrc, newSrc);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSrc(VariableReference newSrc)
  {
    if (newSrc != src)
    {
      NotificationChain msgs = null;
      if (src != null)
        msgs = ((InternalEObject)src).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC, null, msgs);
      if (newSrc != null)
        msgs = ((InternalEObject)newSrc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC, null, msgs);
      msgs = basicSetSrc(newSrc, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC, newSrc, newSrc));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueReference getDst()
  {
    return dst;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDst(ValueReference newDst, NotificationChain msgs)
  {
    ValueReference oldDst = dst;
    dst = newDst;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST, oldDst, newDst);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDst(ValueReference newDst)
  {
    if (newDst != dst)
    {
      NotificationChain msgs = null;
      if (dst != null)
        msgs = ((InternalEObject)dst).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST, null, msgs);
      if (newDst != null)
        msgs = ((InternalEObject)newDst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST, null, msgs);
      msgs = basicSetDst(newDst, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST, newDst, newDst));
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
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION:
        return basicSetPathExpression(null, msgs);
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC:
        return basicSetSrc(null, msgs);
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST:
        return basicSetDst(null, msgs);
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
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION:
        return getPathExpression();
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC:
        return getSrc();
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST:
        return getDst();
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
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION:
        setPathExpression((PathExpressionElement)newValue);
        return;
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC:
        setSrc((VariableReference)newValue);
        return;
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST:
        setDst((ValueReference)newValue);
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
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION:
        setPathExpression((PathExpressionElement)null);
        return;
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC:
        setSrc((VariableReference)null);
        return;
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST:
        setDst((ValueReference)null);
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
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__PATH_EXPRESSION:
        return pathExpression != null;
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__SRC:
        return src != null;
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT__DST:
        return dst != null;
    }
    return super.eIsSet(featureID);
  }

} //RdfPathExpressionConstraintImpl
