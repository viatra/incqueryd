/**
 */
package arch;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element With Trace Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arch.ElementWithTraceInfo#getTraceInfo <em>Trace Info</em>}</li>
 * </ul>
 * </p>
 *
 * @see arch.ArchPackage#getElementWithTraceInfo()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ElementWithTraceInfo extends EObject
{
  /**
   * Returns the value of the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trace Info</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trace Info</em>' attribute.
   * @see #setTraceInfo(String)
   * @see arch.ArchPackage#getElementWithTraceInfo_TraceInfo()
   * @model unique="false"
   * @generated
   */
  String getTraceInfo();

  /**
   * Sets the value of the '{@link arch.ElementWithTraceInfo#getTraceInfo <em>Trace Info</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trace Info</em>' attribute.
   * @see #getTraceInfo()
   * @generated
   */
  void setTraceInfo(String value);

} // ElementWithTraceInfo
