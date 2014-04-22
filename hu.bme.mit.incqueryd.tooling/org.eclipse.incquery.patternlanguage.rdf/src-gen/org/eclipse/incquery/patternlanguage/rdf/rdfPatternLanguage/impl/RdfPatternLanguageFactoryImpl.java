/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Constraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Property;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPathExpressionConstraint;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguageFactory;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint;

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
      case RdfPatternLanguagePackage.BASE: return createBase();
      case RdfPatternLanguagePackage.PREFIX: return createPrefix();
      case RdfPatternLanguagePackage.IRI: return createIri();
      case RdfPatternLanguagePackage.CONSTRAINT: return createConstraint();
      case RdfPatternLanguagePackage.RDF_PATH_EXPRESSION_CONSTRAINT: return createRdfPathExpressionConstraint();
      case RdfPatternLanguagePackage.TYPE_CONSTRAINT: return createTypeConstraint();
      case RdfPatternLanguagePackage.RDF_LITERAL: return createRdfLiteral();
      case RdfPatternLanguagePackage.PATTERN_MODEL: return createPatternModel();
      case RdfPatternLanguagePackage.RDF_CHECK_CONSTRAINT: return createRdfCheckConstraint();
      case RdfPatternLanguagePackage.CLASS: return createClass();
      case RdfPatternLanguagePackage.PROPERTY: return createProperty();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Base createBase()
  {
    BaseImpl base = new BaseImpl();
    return base;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Prefix createPrefix()
  {
    PrefixImpl prefix = new PrefixImpl();
    return prefix;
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
  public Constraint createConstraint()
  {
    ConstraintImpl constraint = new ConstraintImpl();
    return constraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RdfPathExpressionConstraint createRdfPathExpressionConstraint()
  {
    RdfPathExpressionConstraintImpl rdfPathExpressionConstraint = new RdfPathExpressionConstraintImpl();
    return rdfPathExpressionConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeConstraint createTypeConstraint()
  {
    TypeConstraintImpl typeConstraint = new TypeConstraintImpl();
    return typeConstraint;
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
  public PatternModel createPatternModel()
  {
    PatternModelImpl patternModel = new PatternModelImpl();
    return patternModel;
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
  public org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Class createClass()
  {
    ClassImpl class_ = new ClassImpl();
    return class_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createProperty()
  {
    PropertyImpl property = new PropertyImpl();
    return property;
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
