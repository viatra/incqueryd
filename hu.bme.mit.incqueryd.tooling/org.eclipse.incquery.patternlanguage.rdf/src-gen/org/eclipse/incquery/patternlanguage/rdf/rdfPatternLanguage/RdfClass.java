/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage;

import org.eclipse.incquery.patternlanguage.patternLanguage.EntityType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rdf Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClass#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfClass()
 * @model
 * @generated
 */
public interface RdfClass extends EntityType
{
  /**
   * Returns the value of the '<em><b>Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class</em>' containment reference.
   * @see #setClass(Iri)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getRdfClass_Class()
   * @model containment="true"
   * @generated
   */
  Iri getClass_();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfClass#getClass_ <em>Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Class</em>' containment reference.
   * @see #getClass_()
   * @generated
   */
  void setClass(Iri value);

} // RdfClass
