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
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.VocabularyImpl <em>Vocabulary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.VocabularyImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getVocabulary()
   * @generated
   */
  int VOCABULARY = 0;

  /**
   * The feature id for the '<em><b>Location</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VOCABULARY__LOCATION = 0;

  /**
   * The number of structural features of the '<em>Vocabulary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VOCABULARY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.IriPrefixImpl <em>Iri Prefix</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.IriPrefixImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getIriPrefix()
   * @generated
   */
  int IRI_PREFIX = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IRI_PREFIX__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IRI_PREFIX__VALUE = 1;

  /**
   * The number of structural features of the '<em>Iri Prefix</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IRI_PREFIX_FEATURE_COUNT = 2;

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
   * The feature id for the '<em><b>Prefix</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IRI__PREFIX = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IRI__VALUE = 1;

  /**
   * The number of structural features of the '<em>Iri</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IRI_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.VariableImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = PatternLanguagePackage.VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = PatternLanguagePackage.VARIABLE__TYPE;

  /**
   * The feature id for the '<em><b>References</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__REFERENCES = PatternLanguagePackage.VARIABLE__REFERENCES;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = PatternLanguagePackage.VARIABLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfClassConstraintImpl <em>Rdf Class Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfClassConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfClassConstraint()
   * @generated
   */
  int RDF_CLASS_CONSTRAINT = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_CLASS_CONSTRAINT__TYPE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_CLASS_CONSTRAINT__VARIABLE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rdf Class Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_CLASS_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPropertyConstraintImpl <em>Rdf Property Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPropertyConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfPropertyConstraint()
   * @generated
   */
  int RDF_PROPERTY_CONSTRAINT = 5;

  /**
   * The feature id for the '<em><b>Ref Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PROPERTY_CONSTRAINT__REF_TYPE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PROPERTY_CONSTRAINT__SOURCE = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PROPERTY_CONSTRAINT__TARGET = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Rdf Property Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PROPERTY_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfCheckConstraintImpl <em>Rdf Check Constraint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfCheckConstraintImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfCheckConstraint()
   * @generated
   */
  int RDF_CHECK_CONSTRAINT = 6;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_CHECK_CONSTRAINT__EXPRESSION = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rdf Check Constraint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_CHECK_CONSTRAINT_FEATURE_COUNT = PatternLanguagePackage.CONSTRAINT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl <em>Rdf Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfLiteralImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfLiteral()
   * @generated
   */
  int RDF_LITERAL = 7;

  /**
   * The feature id for the '<em><b>Lexical Form</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_LITERAL__LEXICAL_FORM = PatternLanguagePackage.LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Datatype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_LITERAL__DATATYPE = PatternLanguagePackage.LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Language</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_LITERAL__LANGUAGE = PatternLanguagePackage.LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Rdf Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_LITERAL_FEATURE_COUNT = PatternLanguagePackage.LITERAL_VALUE_REFERENCE_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternModelImpl <em>Rdf Pattern Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternModelImpl
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfPatternModel()
   * @generated
   */
  int RDF_PATTERN_MODEL = 8;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PATTERN_MODEL__PACKAGE_NAME = PatternLanguagePackage.PATTERN_MODEL__PACKAGE_NAME;

  /**
   * The feature id for the '<em><b>Patterns</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PATTERN_MODEL__PATTERNS = PatternLanguagePackage.PATTERN_MODEL__PATTERNS;

  /**
   * The feature id for the '<em><b>Vocabularies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PATTERN_MODEL__VOCABULARIES = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Base Iri Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PATTERN_MODEL__BASE_IRI_VALUE = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Iri Prefixes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PATTERN_MODEL__IRI_PREFIXES = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Rdf Pattern Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RDF_PATTERN_MODEL_FEATURE_COUNT = PatternLanguagePackage.PATTERN_MODEL_FEATURE_COUNT + 3;


  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary <em>Vocabulary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Vocabulary</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary
   * @generated
   */
  EClass getVocabulary();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary#getLocation <em>Location</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Location</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary#getLocation()
   * @see #getVocabulary()
   * @generated
   */
  EAttribute getVocabulary_Location();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix <em>Iri Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iri Prefix</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix
   * @generated
   */
  EClass getIriPrefix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix#getName()
   * @see #getIriPrefix()
   * @generated
   */
  EAttribute getIriPrefix_Name();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix#getValue()
   * @see #getIriPrefix()
   * @generated
   */
  EAttribute getIriPrefix_Value();

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
   * Returns the meta object for the reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Prefix</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri#getPrefix()
   * @see #getIri()
   * @generated
   */
  EReference getIri_Prefix();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Iri#getValue()
   * @see #getIri()
   * @generated
   */
  EAttribute getIri_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint <em>Rdf Class Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rdf Class Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint
   * @generated
   */
  EClass getRdfClassConstraint();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint#getType()
   * @see #getRdfClassConstraint()
   * @generated
   */
  EReference getRdfClassConstraint_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClassConstraint#getVariable()
   * @see #getRdfClassConstraint()
   * @generated
   */
  EReference getRdfClassConstraint_Variable();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint <em>Rdf Property Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rdf Property Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint
   * @generated
   */
  EClass getRdfPropertyConstraint();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getRefType <em>Ref Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ref Type</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getRefType()
   * @see #getRdfPropertyConstraint()
   * @generated
   */
  EReference getRdfPropertyConstraint_RefType();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getSource()
   * @see #getRdfPropertyConstraint()
   * @generated
   */
  EReference getRdfPropertyConstraint_Source();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPropertyConstraint#getTarget()
   * @see #getRdfPropertyConstraint()
   * @generated
   */
  EReference getRdfPropertyConstraint_Target();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint <em>Rdf Check Constraint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rdf Check Constraint</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint
   * @generated
   */
  EClass getRdfCheckConstraint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfCheckConstraint#getExpression()
   * @see #getRdfCheckConstraint()
   * @generated
   */
  EAttribute getRdfCheckConstraint_Expression();

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
   * Returns the meta object for class '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel <em>Rdf Pattern Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rdf Pattern Model</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
   * @generated
   */
  EClass getRdfPatternModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getVocabularies <em>Vocabularies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vocabularies</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getVocabularies()
   * @see #getRdfPatternModel()
   * @generated
   */
  EReference getRdfPatternModel_Vocabularies();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getBaseIriValue <em>Base Iri Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Base Iri Value</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getBaseIriValue()
   * @see #getRdfPatternModel()
   * @generated
   */
  EAttribute getRdfPatternModel_BaseIriValue();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getIriPrefixes <em>Iri Prefixes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Iri Prefixes</em>'.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getIriPrefixes()
   * @see #getRdfPatternModel()
   * @generated
   */
  EReference getRdfPatternModel_IriPrefixes();

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
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.VocabularyImpl <em>Vocabulary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.VocabularyImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getVocabulary()
     * @generated
     */
    EClass VOCABULARY = eINSTANCE.getVocabulary();

    /**
     * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VOCABULARY__LOCATION = eINSTANCE.getVocabulary_Location();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.IriPrefixImpl <em>Iri Prefix</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.IriPrefixImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getIriPrefix()
     * @generated
     */
    EClass IRI_PREFIX = eINSTANCE.getIriPrefix();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IRI_PREFIX__NAME = eINSTANCE.getIriPrefix_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IRI_PREFIX__VALUE = eINSTANCE.getIriPrefix_Value();

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
     * The meta object literal for the '<em><b>Prefix</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IRI__PREFIX = eINSTANCE.getIri_Prefix();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IRI__VALUE = eINSTANCE.getIri_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.VariableImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfClassConstraintImpl <em>Rdf Class Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfClassConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfClassConstraint()
     * @generated
     */
    EClass RDF_CLASS_CONSTRAINT = eINSTANCE.getRdfClassConstraint();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RDF_CLASS_CONSTRAINT__TYPE = eINSTANCE.getRdfClassConstraint_Type();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RDF_CLASS_CONSTRAINT__VARIABLE = eINSTANCE.getRdfClassConstraint_Variable();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPropertyConstraintImpl <em>Rdf Property Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPropertyConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfPropertyConstraint()
     * @generated
     */
    EClass RDF_PROPERTY_CONSTRAINT = eINSTANCE.getRdfPropertyConstraint();

    /**
     * The meta object literal for the '<em><b>Ref Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RDF_PROPERTY_CONSTRAINT__REF_TYPE = eINSTANCE.getRdfPropertyConstraint_RefType();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RDF_PROPERTY_CONSTRAINT__SOURCE = eINSTANCE.getRdfPropertyConstraint_Source();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RDF_PROPERTY_CONSTRAINT__TARGET = eINSTANCE.getRdfPropertyConstraint_Target();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfCheckConstraintImpl <em>Rdf Check Constraint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfCheckConstraintImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfCheckConstraint()
     * @generated
     */
    EClass RDF_CHECK_CONSTRAINT = eINSTANCE.getRdfCheckConstraint();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RDF_CHECK_CONSTRAINT__EXPRESSION = eINSTANCE.getRdfCheckConstraint_Expression();

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
     * The meta object literal for the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternModelImpl <em>Rdf Pattern Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternModelImpl
     * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.impl.RdfPatternLanguagePackageImpl#getRdfPatternModel()
     * @generated
     */
    EClass RDF_PATTERN_MODEL = eINSTANCE.getRdfPatternModel();

    /**
     * The meta object literal for the '<em><b>Vocabularies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RDF_PATTERN_MODEL__VOCABULARIES = eINSTANCE.getRdfPatternModel_Vocabularies();

    /**
     * The meta object literal for the '<em><b>Base Iri Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RDF_PATTERN_MODEL__BASE_IRI_VALUE = eINSTANCE.getRdfPatternModel_BaseIriValue();

    /**
     * The meta object literal for the '<em><b>Iri Prefixes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RDF_PATTERN_MODEL__IRI_PREFIXES = eINSTANCE.getRdfPatternModel_IriPrefixes();

  }

} //RdfPatternLanguagePackage
