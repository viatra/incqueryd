/**
 */
package arch;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see arch.ArchPackage
 * @generated
 */
public interface ArchFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ArchFactory eINSTANCE = arch.impl.ArchFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Recipe Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recipe Import</em>'.
	 * @generated
	 */
	RecipeImport createRecipeImport();

	/**
	 * Returns a new object of class '<em>Infrastructure Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infrastructure Mapping</em>'.
	 * @generated
	 */
	InfrastructureMapping createInfrastructureMapping();

	/**
	 * Returns a new object of class '<em>Rete Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rete Role</em>'.
	 * @generated
	 */
	ReteRole createReteRole();

	/**
	 * Returns a new object of class '<em>Cache Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cache Role</em>'.
	 * @generated
	 */
	CacheRole createCacheRole();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ArchPackage getArchPackage();

} //ArchFactory
