/**
 */
package infrastructure.impl;

import infrastructure.GraphStore;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;
import infrastructure.Storage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Store</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link infrastructure.impl.GraphStoreImpl#getRequiredStorage <em>Required Storage</em>}</li>
 *   <li>{@link infrastructure.impl.GraphStoreImpl#getUsedStorage <em>Used Storage</em>}</li>
 *   <li>{@link infrastructure.impl.GraphStoreImpl#getMaster <em>Master</em>}</li>
 *   <li>{@link infrastructure.impl.GraphStoreImpl#getSlave <em>Slave</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphStoreImpl extends ServiceNodeImpl implements GraphStore
{
  /**
   * The cached value of the '{@link #getRequiredStorage() <em>Required Storage</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredStorage()
   * @generated
   * @ordered
   */
  protected EList<Storage> requiredStorage;

  /**
   * The cached value of the '{@link #getUsedStorage() <em>Used Storage</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUsedStorage()
   * @generated
   * @ordered
   */
  protected EList<Storage> usedStorage;

  /**
   * The cached value of the '{@link #getMaster() <em>Master</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMaster()
   * @generated
   * @ordered
   */
  protected Machine master;

  /**
   * The cached value of the '{@link #getSlave() <em>Slave</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSlave()
   * @generated
   * @ordered
   */
  protected Machine slave;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GraphStoreImpl()
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
    return InfrastructurePackage.Literals.GRAPH_STORE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Storage> getRequiredStorage()
  {
    if (requiredStorage == null)
    {
      requiredStorage = new EObjectResolvingEList<Storage>(Storage.class, this, InfrastructurePackage.GRAPH_STORE__REQUIRED_STORAGE);
    }
    return requiredStorage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Storage> getUsedStorage()
  {
    if (usedStorage == null)
    {
      usedStorage = new EObjectResolvingEList<Storage>(Storage.class, this, InfrastructurePackage.GRAPH_STORE__USED_STORAGE);
    }
    return usedStorage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Machine getMaster()
  {
    if (master != null && master.eIsProxy())
    {
      InternalEObject oldMaster = (InternalEObject)master;
      master = (Machine)eResolveProxy(oldMaster);
      if (master != oldMaster)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, InfrastructurePackage.GRAPH_STORE__MASTER, oldMaster, master));
      }
    }
    return master;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Machine basicGetMaster()
  {
    return master;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMaster(Machine newMaster)
  {
    Machine oldMaster = master;
    master = newMaster;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.GRAPH_STORE__MASTER, oldMaster, master));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Machine getSlave()
  {
    if (slave != null && slave.eIsProxy())
    {
      InternalEObject oldSlave = (InternalEObject)slave;
      slave = (Machine)eResolveProxy(oldSlave);
      if (slave != oldSlave)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, InfrastructurePackage.GRAPH_STORE__SLAVE, oldSlave, slave));
      }
    }
    return slave;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Machine basicGetSlave()
  {
    return slave;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSlave(Machine newSlave)
  {
    Machine oldSlave = slave;
    slave = newSlave;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InfrastructurePackage.GRAPH_STORE__SLAVE, oldSlave, slave));
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
      case InfrastructurePackage.GRAPH_STORE__REQUIRED_STORAGE:
        return getRequiredStorage();
      case InfrastructurePackage.GRAPH_STORE__USED_STORAGE:
        return getUsedStorage();
      case InfrastructurePackage.GRAPH_STORE__MASTER:
        if (resolve) return getMaster();
        return basicGetMaster();
      case InfrastructurePackage.GRAPH_STORE__SLAVE:
        if (resolve) return getSlave();
        return basicGetSlave();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case InfrastructurePackage.GRAPH_STORE__REQUIRED_STORAGE:
        getRequiredStorage().clear();
        getRequiredStorage().addAll((Collection<? extends Storage>)newValue);
        return;
      case InfrastructurePackage.GRAPH_STORE__USED_STORAGE:
        getUsedStorage().clear();
        getUsedStorage().addAll((Collection<? extends Storage>)newValue);
        return;
      case InfrastructurePackage.GRAPH_STORE__MASTER:
        setMaster((Machine)newValue);
        return;
      case InfrastructurePackage.GRAPH_STORE__SLAVE:
        setSlave((Machine)newValue);
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
      case InfrastructurePackage.GRAPH_STORE__REQUIRED_STORAGE:
        getRequiredStorage().clear();
        return;
      case InfrastructurePackage.GRAPH_STORE__USED_STORAGE:
        getUsedStorage().clear();
        return;
      case InfrastructurePackage.GRAPH_STORE__MASTER:
        setMaster((Machine)null);
        return;
      case InfrastructurePackage.GRAPH_STORE__SLAVE:
        setSlave((Machine)null);
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
      case InfrastructurePackage.GRAPH_STORE__REQUIRED_STORAGE:
        return requiredStorage != null && !requiredStorage.isEmpty();
      case InfrastructurePackage.GRAPH_STORE__USED_STORAGE:
        return usedStorage != null && !usedStorage.isEmpty();
      case InfrastructurePackage.GRAPH_STORE__MASTER:
        return master != null;
      case InfrastructurePackage.GRAPH_STORE__SLAVE:
        return slave != null;
    }
    return super.eIsSet(featureID);
  }

} //GraphStoreImpl
