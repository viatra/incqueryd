/**
 */
package infrastructure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link infrastructure.GraphStore#getRequiredStorage <em>Required Storage</em>}</li>
 *   <li>{@link infrastructure.GraphStore#getUsedStorage <em>Used Storage</em>}</li>
 *   <li>{@link infrastructure.GraphStore#getMaster <em>Master</em>}</li>
 *   <li>{@link infrastructure.GraphStore#getSlave <em>Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @see infrastructure.InfrastructurePackage#getGraphStore()
 * @model
 * @generated
 */
public interface GraphStore extends ServiceNode
{
  /**
   * Returns the value of the '<em><b>Required Storage</b></em>' reference list.
   * The list contents are of type {@link infrastructure.Storage}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Storage</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Storage</em>' reference list.
   * @see infrastructure.InfrastructurePackage#getGraphStore_RequiredStorage()
   * @model
   * @generated
   */
  EList<Storage> getRequiredStorage();

  /**
   * Returns the value of the '<em><b>Used Storage</b></em>' reference list.
   * The list contents are of type {@link infrastructure.Storage}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Used Storage</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Used Storage</em>' reference list.
   * @see infrastructure.InfrastructurePackage#getGraphStore_UsedStorage()
   * @model
   * @generated
   */
  EList<Storage> getUsedStorage();

  /**
   * Returns the value of the '<em><b>Master</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Master</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Master</em>' reference.
   * @see #setMaster(Machine)
   * @see infrastructure.InfrastructurePackage#getGraphStore_Master()
   * @model
   * @generated
   */
  Machine getMaster();

  /**
   * Sets the value of the '{@link infrastructure.GraphStore#getMaster <em>Master</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Master</em>' reference.
   * @see #getMaster()
   * @generated
   */
  void setMaster(Machine value);

  /**
   * Returns the value of the '<em><b>Slave</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Slave</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Slave</em>' reference.
   * @see #setSlave(Machine)
   * @see infrastructure.InfrastructurePackage#getGraphStore_Slave()
   * @model
   * @generated
   */
  Machine getSlave();

  /**
   * Sets the value of the '{@link infrastructure.GraphStore#getSlave <em>Slave</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Slave</em>' reference.
   * @see #getSlave()
   * @generated
   */
  void setSlave(Machine value);

} // GraphStore
