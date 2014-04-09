/**
 */
package org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prefixed Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName#getPostfix <em>Postfix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getPrefixedName()
 * @model
 * @generated
 */
public interface PrefixedName extends Iri
{
  /**
   * Returns the value of the '<em><b>Prefix</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prefix</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix</em>' reference.
   * @see #setPrefix(Prefix)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getPrefixedName_Prefix()
   * @model
   * @generated
   */
  Prefix getPrefix();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName#getPrefix <em>Prefix</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix</em>' reference.
   * @see #getPrefix()
   * @generated
   */
  void setPrefix(Prefix value);

  /**
   * Returns the value of the '<em><b>Postfix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postfix</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postfix</em>' attribute.
   * @see #setPostfix(String)
   * @see org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternLanguagePackage#getPrefixedName_Postfix()
   * @model
   * @generated
   */
  String getPostfix();

  /**
   * Sets the value of the '{@link org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.PrefixedName#getPostfix <em>Postfix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postfix</em>' attribute.
   * @see #getPostfix()
   * @generated
   */
  void setPostfix(String value);

} // PrefixedName
