/**
 */
package infrastructure;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Storage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link infrastructure.Storage#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link infrastructure.Storage#getUsed <em>Used</em>}</li>
 *   <li>{@link infrastructure.Storage#getFree <em>Free</em>}</li>
 *   <li>{@link infrastructure.Storage#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see infrastructure.InfrastructurePackage#getStorage()
 * @model
 * @generated
 */
public interface Storage extends InfrastructureNode
{
  /**
   * Returns the value of the '<em><b>Maximum</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Maximum</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maximum</em>' attribute.
   * @see #setMaximum(long)
   * @see infrastructure.InfrastructurePackage#getStorage_Maximum()
   * @model unique="false"
   * @generated
   */
  long getMaximum();

  /**
   * Sets the value of the '{@link infrastructure.Storage#getMaximum <em>Maximum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Maximum</em>' attribute.
   * @see #getMaximum()
   * @generated
   */
  void setMaximum(long value);

  /**
   * Returns the value of the '<em><b>Used</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Used</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Used</em>' attribute.
   * @see #setUsed(long)
   * @see infrastructure.InfrastructurePackage#getStorage_Used()
   * @model unique="false"
   * @generated
   */
  long getUsed();

  /**
   * Sets the value of the '{@link infrastructure.Storage#getUsed <em>Used</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Used</em>' attribute.
   * @see #getUsed()
   * @generated
   */
  void setUsed(long value);

  /**
   * Returns the value of the '<em><b>Free</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Free</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Free</em>' attribute.
   * @see #setFree(long)
   * @see infrastructure.InfrastructurePackage#getStorage_Free()
   * @model unique="false"
   * @generated
   */
  long getFree();

  /**
   * Sets the value of the '{@link infrastructure.Storage#getFree <em>Free</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Free</em>' attribute.
   * @see #getFree()
   * @generated
   */
  void setFree(long value);

  /**
   * Returns the value of the '<em><b>Kind</b></em>' attribute.
   * The literals are from the enumeration {@link infrastructure.StorageKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kind</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kind</em>' attribute.
   * @see infrastructure.StorageKind
   * @see #setKind(StorageKind)
   * @see infrastructure.InfrastructurePackage#getStorage_Kind()
   * @model unique="false"
   * @generated
   */
  StorageKind getKind();

  /**
   * Sets the value of the '{@link infrastructure.Storage#getKind <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kind</em>' attribute.
   * @see infrastructure.StorageKind
   * @see #getKind()
   * @generated
   */
  void setKind(StorageKind value);

} // Storage
