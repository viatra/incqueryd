/**
 */
package infrastructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link infrastructure.Machine#getStorage <em>Storage</em>}</li>
 *   <li>{@link infrastructure.Machine#getHost <em>Host</em>}</li>
 *   <li>{@link infrastructure.Machine#getIp <em>Ip</em>}</li>
 * </ul>
 * </p>
 *
 * @see infrastructure.InfrastructurePackage#getMachine()
 * @model
 * @generated
 */
public interface Machine extends InfrastructureNode
{
  /**
   * Returns the value of the '<em><b>Storage</b></em>' reference list.
   * The list contents are of type {@link infrastructure.Storage}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Storage</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Storage</em>' reference list.
   * @see infrastructure.InfrastructurePackage#getMachine_Storage()
   * @model
   * @generated
   */
  EList<Storage> getStorage();

  /**
   * Returns the value of the '<em><b>Host</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Host</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Host</em>' attribute.
   * @see #setHost(String)
   * @see infrastructure.InfrastructurePackage#getMachine_Host()
   * @model unique="false"
   * @generated
   */
  String getHost();

  /**
   * Sets the value of the '{@link infrastructure.Machine#getHost <em>Host</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Host</em>' attribute.
   * @see #getHost()
   * @generated
   */
  void setHost(String value);

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
