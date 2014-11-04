/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.*;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage
 * @generated
 */
public class MondixPatternLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MondixPatternLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MondixPatternLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MondixPatternLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MondixPatternLanguagePackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = casePatternLanguage_Variable(variable);
        if (result == null) result = caseJvmIdentifiableElement(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MondixPatternLanguagePackage.NODE_CONSTRAINT:
      {
        NodeConstraint nodeConstraint = (NodeConstraint)theEObject;
        T result = caseNodeConstraint(nodeConstraint);
        if (result == null) result = caseConstraint(nodeConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MondixPatternLanguagePackage.EDGE_CONSTRAINT:
      {
        EdgeConstraint edgeConstraint = (EdgeConstraint)theEObject;
        T result = caseEdgeConstraint(edgeConstraint);
        if (result == null) result = caseConstraint(edgeConstraint);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MondixPatternLanguagePackage.MONDIX_PATTERN_MODEL:
      {
        MondixPatternModel mondixPatternModel = (MondixPatternModel)theEObject;
        T result = caseMondixPatternModel(mondixPatternModel);
        if (result == null) result = casePatternModel(mondixPatternModel);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Node Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Node Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNodeConstraint(NodeConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Edge Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Edge Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEdgeConstraint(EdgeConstraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mondix Pattern Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mondix Pattern Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMondixPatternModel(MondixPatternModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Jvm Identifiable Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJvmIdentifiableElement(JvmIdentifiableElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternLanguage_Variable(org.eclipse.incquery.patternlanguage.patternLanguage.Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraint(Constraint object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pattern Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePatternModel(PatternModel object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //MondixPatternLanguageSwitch
