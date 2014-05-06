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
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getBase <em>Base</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getPrefixes <em>Prefixes</em>}</li>
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
   * Returns the value of the '<em><b>Base</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base</em>' containment reference.
   * @see #setBase(Base)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPatternModel_Base()
   * @model containment="true"
   * @generated
   */
  Base getBase();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel#getBase <em>Base</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Base</em>' containment reference.
   * @see #getBase()
   * @generated
   */
  void setBase(Base value);

  /**
   * Returns the value of the '<em><b>Prefixes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.Prefix}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prefixes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefixes</em>' containment reference list.
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfPatternModel_Prefixes()
   * @model containment="true"
   * @generated
   */
  EList<Prefix> getPrefixes();

} // RdfPatternModel
