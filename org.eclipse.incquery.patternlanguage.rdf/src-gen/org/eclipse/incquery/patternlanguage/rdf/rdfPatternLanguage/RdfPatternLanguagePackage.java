/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguageFactory
 * @model kind="package"
 * @generated
 */
public interface RdfPatternLanguagePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "rdfPatternLanguage";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/incquery/patternlanguage/rdf/RdfPatternLanguage";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "rdfPatternLanguage";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RdfPatternLanguagePackage eINSTANCE = org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.BaseImpl <em>Base</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.BaseImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getBase()
   * @generated
   */
  int BASE = 0;

  /**
   * The feature id for the '<em><b>Iri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE__IRI = 0;

  /**
   * The number of structural features of the '<em>Base</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixImpl <em>Prefix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getPrefix()
   * @generated
   */
  int PREFIX = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX__NAME = 0;

  /**
   * The feature id for the '<em><b>Iri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX__IRI = 1;

  /**
   * The number of structural features of the '<em>Prefix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.IriImpl <em>Iri</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.IriImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getIri()
   * @generated
   */
  int IRI = 2;

  /**
   * The number of structural features of the '<em>Iri</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IRI_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.FullIriImpl <em>Full Iri</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.FullIriImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getFullIri()
   * @generated
   */
  int FULL_IRI = 3;

  /**
   * The feature id for the '<em><b>Iri</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FULL_IRI__IRI = IRI_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Full Iri</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FULL_IRI_FEATURE_COUNT = IRI_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixedNameImpl <em>Prefixed Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixedNameImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getPrefixedName()
   * @generated
   */
  int PREFIXED_NAME = 4;

  /**
   * The feature id for the '<em><b>Prefix</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_NAME__PREFIX = IRI_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Postfix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_NAME__POSTFIX = IRI_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Prefixed Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_NAME_FEATURE_COUNT = IRI_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.TypeConstraintImpl <em>Type Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.TypeConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getTypeConstraint()
   * @generated
   */
  int TYPE_CONSTRAINT = 5;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONSTRAINT__TYPE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONSTRAINT__VAR = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl <em>Rdf Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfLiteral()
   * @generated
   */
  int RDF_LITERAL = 6;

  /**
   * The feature id for the '<em><b>Lexical Form</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_LITERAL__LEXICAL_FORM = PatternLanguagePackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_LITERAL__DATATYPE = PatternLanguagePackage.VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_LITERAL__LANGUAGE = PatternLanguagePackage.VALUE_REFERENCE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Rdf Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_LITERAL_FEATURE_COUNT = PatternLanguagePackage.VALUE_REFERENCE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PatternModelImpl <em>Pattern Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PatternModelImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getPatternModel()
   * @generated
   */
  int PATTERN_MODEL = 7;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__PACKAGE_NAME = PatternLanguagePackage.PATTERN_MODEL__PACKAGE_NAME;

  /**
   * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__PATTERNS = PatternLanguagePackage.PATTERN_MODEL__PATTERNS;

  /**
   * The feature id for the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__BASE = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Prefixes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL__PREFIXES = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Pattern Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATTERN_MODEL_FEATURE_COUNT = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.ClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.ClassImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getClass_()
   * @generated
   */
  int CLASS = 8;

  /**
   * The feature id for the '<em><b>Typename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__TYPENAME = PatternLanguagePackage.ENTITY_TYPE__TYPENAME;

  /**
   * The feature id for the '<em><b>Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS__CLASS = PatternLanguagePackage.ENTITY_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_FEATURE_COUNT = PatternLanguagePackage.ENTITY_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PropertyImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 9;

  /**
   * The feature id for the '<em><b>Typename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__TYPENAME = PatternLanguagePackage.RELATION_TYPE__TYPENAME;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__PROPERTY = PatternLanguagePackage.RELATION_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = PatternLanguagePackage.RELATION_TYPE_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base
   * @generated
   */
  EClass getBase();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base#getIri <em>Iri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Iri</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Base#getIri()
   * @see #getBase()
   * @generated
   */
  EAttribute getBase_Iri();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefix</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix
   * @generated
   */
  EClass getPrefix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix#getName()
   * @see #getPrefix()
   * @generated
   */
  EAttribute getPrefix_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix#getIri <em>Iri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Iri</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix#getIri()
   * @see #getPrefix()
   * @generated
   */
  EAttribute getPrefix_Iri();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri <em>Iri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iri</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri
   * @generated
   */
  EClass getIri();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.FullIri <em>Full Iri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Full Iri</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.FullIri
   * @generated
   */
  EClass getFullIri();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.FullIri#getIri <em>Iri</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Iri</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.FullIri#getIri()
   * @see #getFullIri()
   * @generated
   */
  EAttribute getFullIri_Iri();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName <em>Prefixed Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefixed Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName
   * @generated
   */
  EClass getPrefixedName();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Prefix</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName#getPrefix()
   * @see #getPrefixedName()
   * @generated
   */
  EReference getPrefixedName_Prefix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName#getPostfix <em>Postfix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Postfix</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName#getPostfix()
   * @see #getPrefixedName()
   * @generated
   */
  EAttribute getPrefixedName_Postfix();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint <em>Type Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint
   * @generated
   */
  EClass getTypeConstraint();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint#getType()
   * @see #getTypeConstraint()
   * @generated
   */
  EReference getTypeConstraint_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.TypeConstraint#getVar()
   * @see #getTypeConstraint()
   * @generated
   */
  EReference getTypeConstraint_Var();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral <em>Rdf Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rdf Literal</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral
   * @generated
   */
  EClass getRdfLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral#getLexicalForm <em>Lexical Form</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lexical Form</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral#getLexicalForm()
   * @see #getRdfLiteral()
   * @generated
   */
  EAttribute getRdfLiteral_LexicalForm();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral#getDatatype <em>Datatype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Datatype</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral#getDatatype()
   * @see #getRdfLiteral()
   * @generated
   */
  EReference getRdfLiteral_Datatype();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral#getLanguage <em>Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Language</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfLiteral#getLanguage()
   * @see #getRdfLiteral()
   * @generated
   */
  EAttribute getRdfLiteral_Language();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel <em>Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pattern Model</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel
   * @generated
   */
  EClass getPatternModel();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Base</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel#getBase()
   * @see #getPatternModel()
   * @generated
   */
  EReference getPatternModel_Base();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel#getPrefixes <em>Prefixes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Prefixes</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PatternModel#getPrefixes()
   * @see #getPatternModel()
   * @generated
   */
  EReference getPatternModel_Prefixes();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Class <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Class
   * @generated
   */
  EClass getClass_();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Class#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Class</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Class#getClass_()
   * @see #getClass_()
   * @generated
   */
  EReference getClass_Class();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Property#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Property#getProperty()
   * @see #getProperty()
   * @generated
   */
  EReference getProperty_Property();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RdfPatternLanguageFactory getRdfPatternLanguageFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.BaseImpl <em>Base</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.BaseImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getBase()
     * @generated
     */
    EClass BASE = eINSTANCE.getBase();

    /**
     * The meta object literal for the '<em><b>Iri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE__IRI = eINSTANCE.getBase_Iri();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixImpl <em>Prefix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getPrefix()
     * @generated
     */
    EClass PREFIX = eINSTANCE.getPrefix();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREFIX__NAME = eINSTANCE.getPrefix_Name();

    /**
     * The meta object literal for the '<em><b>Iri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREFIX__IRI = eINSTANCE.getPrefix_Iri();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.IriImpl <em>Iri</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.IriImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getIri()
     * @generated
     */
    EClass IRI = eINSTANCE.getIri();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.FullIriImpl <em>Full Iri</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.FullIriImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getFullIri()
     * @generated
     */
    EClass FULL_IRI = eINSTANCE.getFullIri();

    /**
     * The meta object literal for the '<em><b>Iri</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FULL_IRI__IRI = eINSTANCE.getFullIri_Iri();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixedNameImpl <em>Prefixed Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PrefixedNameImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getPrefixedName()
     * @generated
     */
    EClass PREFIXED_NAME = eINSTANCE.getPrefixedName();

    /**
     * The meta object literal for the '<em><b>Prefix</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREFIXED_NAME__PREFIX = eINSTANCE.getPrefixedName_Prefix();

    /**
     * The meta object literal for the '<em><b>Postfix</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREFIXED_NAME__POSTFIX = eINSTANCE.getPrefixedName_Postfix();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.TypeConstraintImpl <em>Type Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.TypeConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getTypeConstraint()
     * @generated
     */
    EClass TYPE_CONSTRAINT = eINSTANCE.getTypeConstraint();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_CONSTRAINT__TYPE = eINSTANCE.getTypeConstraint_Type();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_CONSTRAINT__VAR = eINSTANCE.getTypeConstraint_Var();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl <em>Rdf Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfLiteral()
     * @generated
     */
    EClass RDF_LITERAL = eINSTANCE.getRdfLiteral();

    /**
     * The meta object literal for the '<em><b>Lexical Form</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RDF_LITERAL__LEXICAL_FORM = eINSTANCE.getRdfLiteral_LexicalForm();

    /**
     * The meta object literal for the '<em><b>Datatype</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RDF_LITERAL__DATATYPE = eINSTANCE.getRdfLiteral_Datatype();

    /**
     * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RDF_LITERAL__LANGUAGE = eINSTANCE.getRdfLiteral_Language();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PatternModelImpl <em>Pattern Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PatternModelImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getPatternModel()
     * @generated
     */
    EClass PATTERN_MODEL = eINSTANCE.getPatternModel();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_MODEL__BASE = eINSTANCE.getPatternModel_Base();

    /**
     * The meta object literal for the '<em><b>Prefixes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATTERN_MODEL__PREFIXES = eINSTANCE.getPatternModel_Prefixes();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.ClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.ClassImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getClass_()
     * @generated
     */
    EClass CLASS = eINSTANCE.getClass_();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS__CLASS = eINSTANCE.getClass_Class();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.PropertyImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY__PROPERTY = eINSTANCE.getProperty_Property();

  }

} //RdfPatternLanguagePackage
