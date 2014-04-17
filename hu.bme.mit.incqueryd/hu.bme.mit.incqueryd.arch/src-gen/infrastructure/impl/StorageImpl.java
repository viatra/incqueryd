/**
 */
package infrastructure.impl;

import infrastructure.InfrastructurePackage;
import infrastructure.Storage;
import infrastructure.StorageKind;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Storage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link infrastructure.impl.StorageImpl#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link infrastructure.impl.StorageImpl#getUsed <em>Used</em>}</li>
 *   <li>{@link infrastructure.impl.StorageImpl#getFree <em>Free</em>}</li>
 *   <li>{@link infrastructure.impl.StorageImpl#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StorageImpl extends InfrastructureNodeImpl implements Storage
{
  /**
   * The default value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaximum()
   * @generated
   * @ordered
   */
  protected static final long MAXIMUM_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getMaximum() <em>Maximum</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaximum()
   * @generated
   * @ordered
   */
  protected long maximum = MAXIMUM_EDEFAULT;

  /**
   * The default value of the '{@link #getUsed() <em>Used</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsed()
   * @generated
   * @ordered
   */
  protected static final long USED_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getUsed() <em>Used</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsed()
   * @generated
   * @ordered
   */
  protected long used = USED_EDEFAULT;

  /**
   * The default value of the '{@link #getFree() <em>Free</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFree()
   * @generated
   * @ordered
   */
  protected static final long FREE_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getFree() <em>Free</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFree()
   * @generated
   * @ordered
   */
  protected long free = FREE_EDEFAULT;

  /**
   * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected static final StorageKind KIND_EDEFAULT = StorageKind.MEMORY;

  /**
   * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKind()
   * @generated
   * @ordered
   */
  protected StorageKind kind = KIND_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StorageImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return InfrastructurePackage.Literals.STORAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getMaximum()
  {
    return maximum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaximum(long newMaximum)
  {
    long oldMaximum = maximum;
    maximum = newMaximum;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.STORAGE__MAXIMUM, oldMaximum, maximum));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getUsed()
  {
    return used;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUsed(long newUsed)
  {
    long oldUsed = used;
    used = newUsed;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.STORAGE__USED, oldUsed, used));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getFree()
  {
    return free;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFree(long newFree)
  {
    long oldFree = free;
    free = newFree;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.STORAGE__FREE, oldFree, free));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StorageKind getKind()
  {
    return kind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKind(StorageKind newKind)
  {
    StorageKind oldKind = kind;
    kind = newKind == null ? KIND_EDEFAULT : newKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.STORAGE__KIND, oldKind, kind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case InfrastructurePackage.STORAGE__MAXIMUM:
        return getMaximum();
      case InfrastructurePackage.STORAGE__USED:
        return getUsed();
      case InfrastructurePackage.STORAGE__FREE:
        return getFree();
      case InfrastructurePackage.STORAGE__KIND:
        return getKind();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case InfrastructurePackage.STORAGE__MAXIMUM:
        setMaximum((Long)newValue);
        return;
      case InfrastructurePackage.STORAGE__USED:
        setUsed((Long)newValue);
        return;
      case InfrastructurePackage.STORAGE__FREE:
        setFree((Long)newValue);
        return;
      case InfrastructurePackage.STORAGE__KIND:
        setKind((StorageKind)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case InfrastructurePackage.STORAGE__MAXIMUM:
        setMaximum(MAXIMUM_EDEFAULT);
        return;
      case InfrastructurePackage.STORAGE__USED:
        setUsed(USED_EDEFAULT);
        return;
      case InfrastructurePackage.STORAGE__FREE:
        setFree(FREE_EDEFAULT);
        return;
      case InfrastructurePackage.STORAGE__KIND:
        setKind(KIND_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case InfrastructurePackage.STORAGE__MAXIMUM:
        return maximum != MAXIMUM_EDEFAULT;
      case InfrastructurePackage.STORAGE__USED:
        return used != USED_EDEFAULT;
      case InfrastructurePackage.STORAGE__FREE:
        return free != FREE_EDEFAULT;
      case InfrastructurePackage.STORAGE__KIND:
        return kind != KIND_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (maximum: ");
    result.append(maximum);
    result.append(", used: ");
    result.append(used);
    result.append(", free: ");
    result.append(free);
    result.append(", kind: ");
    result.append(kind);
    result.append(')');
    return result.toString();
  }

} //StorageImpl
