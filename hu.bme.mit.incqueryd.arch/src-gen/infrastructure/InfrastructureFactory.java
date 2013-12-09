/**
 */
package infrastructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see infrastructure.InfrastructurePackage
 * @generated
 */
public interface InfrastructureFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  InfrastructureFactory eINSTANCE = infrastructure.impl.InfrastructureFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Cluster</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cluster</em>'.
   * @generated
   */
  Cluster createCluster();

  /**
   * Returns a new object of class '<em>Storage</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Storage</em>'.
   * @generated
   */
  Storage createStorage();

  /**
   * Returns a new object of class '<em>Machine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Machine</em>'.
   * @generated
   */
  Machine createMachine();

  /**
   * Returns a new object of class '<em>Graph Store</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Graph Store</em>'.
   * @generated
   */
  GraphStore createGraphStore();

  /**
   * Returns a new object of class '<em>Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node</em>'.
   * @generated
   */
  InfrastructureNode createInfrastructureNode();

  /**
   * Returns a new object of class '<em>Service Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Node</em>'.
   * @generated
   */
  ServiceNode createServiceNode();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  InfrastructurePackage getInfrastructurePackage();

} //InfrastructureFactory
