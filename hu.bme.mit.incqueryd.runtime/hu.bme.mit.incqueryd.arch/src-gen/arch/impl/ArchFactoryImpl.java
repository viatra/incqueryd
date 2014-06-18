/**
 */
package arch.impl;

import arch.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchFactoryImpl extends EFactoryImpl implements ArchFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ArchFactory init()
  {
    try
    {
      ArchFactory theArchFactory = (ArchFactory)EPackage.Registry.INSTANCE.getEFactory(ArchPackage.eNS_URI);
      if (theArchFactory != null)
      {
        return theArchFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ArchFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArchFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ArchPackage.CONFIGURATION: return createConfiguration();
      case ArchPackage.RECIPE_IMPORT: return createRecipeImport();
      case ArchPackage.INFRASTRUCTURE_MAPPING: return createInfrastructureMapping();
      case ArchPackage.RETE_ROLE: return createReteRole();
      case ArchPackage.CACHE_ROLE: return createCacheRole();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Configuration createConfiguration()
  {
    ConfigurationImpl configuration = new ConfigurationImpl();
    return configuration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecipeImport createRecipeImport()
  {
    RecipeImportImpl recipeImport = new RecipeImportImpl();
    return recipeImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfrastructureMapping createInfrastructureMapping()
  {
    InfrastructureMappingImpl infrastructureMapping = new InfrastructureMappingImpl();
    return infrastructureMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReteRole createReteRole()
  {
    ReteRoleImpl reteRole = new ReteRoleImpl();
    return reteRole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CacheRole createCacheRole()
  {
    CacheRoleImpl cacheRole = new CacheRoleImpl();
    return cacheRole;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArchPackage getArchPackage()
  {
    return (ArchPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ArchPackage getPackage()
  {
    return ArchPackage.eINSTANCE;
  }

} //ArchFactoryImpl
