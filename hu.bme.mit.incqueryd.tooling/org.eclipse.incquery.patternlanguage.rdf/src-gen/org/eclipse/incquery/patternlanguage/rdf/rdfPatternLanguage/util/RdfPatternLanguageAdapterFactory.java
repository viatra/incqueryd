/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.LiteralValueReference;
import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.*;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage
 * @generated
 */
public class RdfPatternLanguageAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static RdfPatternLanguagePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfPatternLanguageAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = RdfPatternLanguagePackage.eINSTANCE;
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
  protected RdfPatternLanguageSwitch<Adapter> modelSwitch =
    new RdfPatternLanguageSwitch<Adapter>()
    {
      @Override
      public Adapter caseVocabulary(Vocabulary object)
      {
        return createVocabularyAdapter();
      }
      @Override
      public Adapter caseIriPrefix(IriPrefix object)
      {
        return createIriPrefixAdapter();
      }
      @Override
      public Adapter caseIri(Iri object)
      {
        return createIriAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseRdfClassConstraint(RdfClassConstraint object)
      {
        return createRdfClassConstraintAdapter();
      }
      @Override
      public Adapter caseRdfPropertyConstraint(RdfPropertyConstraint object)
      {
        return createRdfPropertyConstraintAdapter();
      }
      @Override
      public Adapter caseRdfCheckConstraint(RdfCheckConstraint object)
      {
        return createRdfCheckConstraintAdapter();
      }
      @Override
      public Adapter caseRdfLiteral(RdfLiteral object)
      {
        return createRdfLiteralAdapter();
      }
      @Override
      public Adapter caseRdfPatternModel(RdfPatternModel object)
      {
        return createRdfPatternModelAdapter();
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
      public Adapter caseValueReference(ValueReference object)
      {
        return createValueReferenceAdapter();
      }
      @Override
      public Adapter caseLiteralValueReference(LiteralValueReference object)
      {
        return createLiteralValueReferenceAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary <em>Vocabulary</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary
   * @generated
   */
  public Adapter createVocabularyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix <em>Iri Prefix</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix
   * @generated
   */
  public Adapter createIriPrefixAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri <em>Iri</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
   * @generated
   */
  public Adapter createIriAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint <em>Rdf Class Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint
   * @generated
   */
  public Adapter createRdfClassConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint <em>Rdf Property Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint
   * @generated
   */
  public Adapter createRdfPropertyConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint <em>Rdf Check Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint
   * @generated
   */
  public Adapter createRdfCheckConstraintAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral <em>Rdf Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral
   * @generated
   */
  public Adapter createRdfLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel <em>Rdf Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
   * @generated
   */
  public Adapter createRdfPatternModelAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference <em>Value Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference
   * @generated
   */
  public Adapter createValueReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.LiteralValueReference <em>Literal Value Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.LiteralValueReference
   * @generated
   */
  public Adapter createLiteralValueReferenceAdapter()
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

} //RdfPatternLanguageAdapterFactory
