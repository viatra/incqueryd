/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.*;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternLanguagePackage
 * @generated
 */
public class MondixPatternLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MondixPatternLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MondixPatternLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = MondixPatternLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MondixPatternLanguageSwitch<Adapter> modelSwitch =
    new MondixPatternLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseNodeConstraint(NodeConstraint object)
      {
        return createNodeConstraintAdapter();
      }
      @Override
      public Adapter caseEdgeConstraint(EdgeConstraint object)
      {
        return createEdgeConstraintAdapter();
      }
      @Override
      public Adapter caseMondixPatternModel(MondixPatternModel object)
      {
        return createMondixPatternModelAdapter();
      }
      @Override
      public Adapter caseJvmIdentifiableElement(JvmIdentifiableElement object)
      {
        return createJvmIdentifiableElementAdapter();
      }
      @Override
      public Adapter casePatternLanguage_Variable(org.eclipse.incquery.patternlanguage.patternLanguage.Variable object)
      {
        return createPatternLanguage_VariableAdapter();
      }
      @Override
      public Adapter caseConstraint(Constraint object)
      {
        return createConstraintAdapter();
      }
      @Override
      public Adapter casePatternModel(PatternModel object)
      {
        return createPatternModelAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint <em>Node Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.NodeConstraint
   * @generated
   */
  public Adapter createNodeConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint <em>Edge Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.EdgeConstraint
   * @generated
   */
  public Adapter createEdgeConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel <em>Mondix Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel
   * @generated
   */
  public Adapter createMondixPatternModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.xtext.common.types.JvmIdentifiableElement <em>Jvm Identifiable Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.xtext.common.types.JvmIdentifiableElement
   * @generated
   */
  public Adapter createJvmIdentifiableElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Variable
   * @generated
   */
  public Adapter createPatternLanguage_VariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Constraint <em>Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Constraint
   * @generated
   */
  public Adapter createConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel <em>Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel
   * @generated
   */
  public Adapter createPatternModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //MondixPatternLanguageAdapterFactory
