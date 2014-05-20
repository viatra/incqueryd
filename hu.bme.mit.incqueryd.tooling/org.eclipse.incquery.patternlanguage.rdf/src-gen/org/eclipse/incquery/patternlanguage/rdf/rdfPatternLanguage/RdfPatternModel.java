/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.incquery.patternlanguage.patternLanguage.PatternModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rdf Pattern Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getVocabularies <em>Vocabularies</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getBaseIriValue <em>Base Iri Value</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getIriPrefixes <em>Iri Prefixes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPatternModel()
 * @model
 * @generated
 */
public interface RdfPatternModel extends PatternModel
{
  /**
   * Returns the value of the '<em><b>Vocabularies</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Vocabulary}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Vocabularies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Vocabularies</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPatternModel_Vocabularies()
   * @model containment="true"
   * @generated
   */
  EList<Vocabulary> getVocabularies();

  /**
   * Returns the value of the '<em><b>Base Iri Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base Iri Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Iri Value</em>' attribute.
   * @see #setBaseIriValue(String)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPatternModel_BaseIriValue()
   * @model
   * @generated
   */
  String getBaseIriValue();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getBaseIriValue <em>Base Iri Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base Iri Value</em>' attribute.
   * @see #getBaseIriValue()
   * @generated
   */
  void setBaseIriValue(String value);

  /**
   * Returns the value of the '<em><b>Iri Prefixes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.IriPrefix}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Iri Prefixes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Iri Prefixes</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPatternModel_IriPrefixes()
   * @model containment="true"
   * @generated
   */
  EList<IriPrefix> getIriPrefixes();

} // RdfPatternModel
