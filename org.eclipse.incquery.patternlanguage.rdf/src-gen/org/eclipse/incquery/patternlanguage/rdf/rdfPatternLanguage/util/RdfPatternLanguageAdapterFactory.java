/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.patternlanguage.patternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.patternLanguage.EntityType;
import org.eclipse.incquery.patternlanguage.patternLanguage.RelationType;
import org.eclipse.incquery.patternlanguage.patternLanguage.Type;
import org.eclipse.incquery.patternlanguage.patternLanguage.ValueReference;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.FullIri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Property;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint;

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
      public Adapter caseBase(Base object)
      {
        return createBaseAdapter();
      }
      @Override
      public Adapter casePrefix(Prefix object)
      {
        return createPrefixAdapter();
      }
      @Override
      public Adapter caseIri(Iri object)
      {
        return createIriAdapter();
      }
      @Override
      public Adapter caseFullIri(FullIri object)
      {
        return createFullIriAdapter();
      }
      @Override
      public Adapter casePrefixedName(PrefixedName object)
      {
        return createPrefixedNameAdapter();
      }
      @Override
      public Adapter caseTypeConstraint(TypeConstraint object)
      {
        return createTypeConstraintAdapter();
      }
      @Override
      public Adapter caseRdfLiteral(RdfLiteral object)
      {
        return createRdfLiteralAdapter();
      }
      @Override
      public Adapter casePatternModel(PatternModel object)
      {
        return createPatternModelAdapter();
      }
      @Override
      public Adapter caseClass(org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Class object)
      {
        return createClassAdapter();
      }
      @Override
      public Adapter caseProperty(Property object)
      {
        return createPropertyAdapter();
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
      public Adapter casePatternLanguage_PatternModel(org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel object)
      {
        return createPatternLanguage_PatternModelAdapter();
      }
      @Override
      public Adapter caseType(Type object)
      {
        return createTypeAdapter();
      }
      @Override
      public Adapter caseEntityType(EntityType object)
      {
        return createEntityTypeAdapter();
      }
      @Override
      public Adapter caseRelationType(RelationType object)
      {
        return createRelationTypeAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base
   * @generated
   */
  public Adapter createBaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix
   * @generated
   */
  public Adapter createPrefixAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.FullIri <em>Full Iri</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.FullIri
   * @generated
   */
  public Adapter createFullIriAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName <em>Prefixed Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName
   * @generated
   */
  public Adapter createPrefixedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint <em>Type Constraint</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint
   * @generated
   */
  public Adapter createTypeConstraintAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel <em>Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel
   * @generated
   */
  public Adapter createPatternModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Class
   * @generated
   */
  public Adapter createClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Property
   * @generated
   */
  public Adapter createPropertyAdapter()
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
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel <em>Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel
   * @generated
   */
  public Adapter createPatternLanguage_PatternModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.Type
   * @generated
   */
  public Adapter createTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.EntityType <em>Entity Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.EntityType
   * @generated
   */
  public Adapter createEntityTypeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipse.incquery.patternlanguage.patternLanguage.RelationType <em>Relation Type</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipse.incquery.patternlanguage.patternLanguage.RelationType
   * @generated
   */
  public Adapter createRelationTypeAdapter()
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
