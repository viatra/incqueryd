/**
 */
package infrastructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link infrastructure.Machine#getIp <em>Ip</em>}</li>
 * </ul>
 * </p>
 *
 * @see infrastructure.InfrastructurePackage#getMachine()
 * @model
 * @generated
 */
public interface Machine extends ElementWithTraceInfo
{
  /**
   * Returns the value of the '<em><b>Ip</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ip</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ip</em>' attribute.
   * @see #setIp(String)
   * @see infrastructure.InfrastructurePackage#getMachine_Ip()
   * @model unique="false"
   * @generated
   */
  String getIp();

  /**
   * Sets the value of the '{@link infrastructure.Machine#getIp <em>Ip</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ip</em>' attribute.
   * @see #getIp()
   * @generated
   */
  void setIp(String value);

} // Machine
