/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RdfPatternLanguageFactoryImpl extends EFactoryImpl implements RdfPatternLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RdfPatternLanguageFactory init()
  {
    try
    {
      RdfPatternLanguageFactory theRdfPatternLanguageFactory = (RdfPatternLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(RdfPatternLanguagePackage.eNS_URI);
      if (theRdfPatternLanguageFactory != null)
      {
        return theRdfPatternLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RdfPatternLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfPatternLanguageFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case RdfPatternLanguagePackage.VOCABULARY: return createVocabulary();
      case RdfPatternLanguagePackage.IRI_PREFIX: return createIriPrefix();
      case RdfPatternLanguagePackage.IRI: return createIri();
      case RdfPatternLanguagePackage.VARIABLE: return createVariable();
      case RdfPatternLanguagePackage.RDF_CLASS_CONSTRAINT: return createRdfClassConstraint();
      case RdfPatternLanguagePackage.RDF_PROPERTY_CONSTRAINT: return createRdfPropertyConstraint();
      case RdfPatternLanguagePackage.RDF_CHECK_CONSTRAINT: return createRdfCheckConstraint();
      case RdfPatternLanguagePackage.RDF_LITERAL: return createRdfLiteral();
      case RdfPatternLanguagePackage.RDF_PATTERN_MODEL: return createRdfPatternModel();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Vocabulary createVocabulary()
  {
    VocabularyImpl vocabulary = new VocabularyImpl();
    return vocabulary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IriPrefix createIriPrefix()
  {
    IriPrefixImpl iriPrefix = new IriPrefixImpl();
    return iriPrefix;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Iri createIri()
  {
    IriImpl iri = new IriImpl();
    return iri;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfClassConstraint createRdfClassConstraint()
  {
    RdfClassConstraintImpl rdfClassConstraint = new RdfClassConstraintImpl();
    return rdfClassConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfPropertyConstraint createRdfPropertyConstraint()
  {
    RdfPropertyConstraintImpl rdfPropertyConstraint = new RdfPropertyConstraintImpl();
    return rdfPropertyConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfCheckConstraint createRdfCheckConstraint()
  {
    RdfCheckConstraintImpl rdfCheckConstraint = new RdfCheckConstraintImpl();
    return rdfCheckConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfLiteral createRdfLiteral()
  {
    RdfLiteralImpl rdfLiteral = new RdfLiteralImpl();
    return rdfLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfPatternModel createRdfPatternModel()
  {
    RdfPatternModelImpl rdfPatternModel = new RdfPatternModelImpl();
    return rdfPatternModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfPatternLanguagePackage getRdfPatternLanguagePackage()
  {
    return (RdfPatternLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RdfPatternLanguagePackage getPackage()
  {
    return RdfPatternLanguagePackage.eINSTANCE;
  }

} //RdfPatternLanguageFactoryImpl
