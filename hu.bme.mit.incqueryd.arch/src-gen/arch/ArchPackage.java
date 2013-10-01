/**
 */
package arch;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see arch.ArchFactory
 * @model kind="package"
 * @generated
 */
public interface ArchPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "arch";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://incquery.net/arch";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "arch";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ArchPackage eINSTANCE = arch.impl.ArchPackageImpl.init();

  /**
   * The meta object id for the '{@link arch.ElementWithTraceInfo <em>Element With Trace Info</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see arch.ElementWithTraceInfo
   * @see arch.impl.ArchPackageImpl#getElementWithTraceInfo()
   * @generated
   */
  int ELEMENT_WITH_TRACE_INFO = 2;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_WITH_TRACE_INFO__TRACE_INFO = 0;

  /**
   * The number of structural features of the '<em>Element With Trace Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Element With Trace Info</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link arch.impl.ConfigurationImpl <em>Configuration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see arch.impl.ConfigurationImpl
   * @see arch.impl.ArchPackageImpl#getConfiguration()
   * @generated
   */
  int CONFIGURATION = 0;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION__TRACE_INFO = ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Clusters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION__CLUSTERS = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rete Recipes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION__RETE_RECIPES = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION__MAPPINGS = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Configuration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION_FEATURE_COUNT = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 3;

  /**
   * The number of operations of the '<em>Configuration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONFIGURATION_OPERATION_COUNT = ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link arch.impl.InfrastructureMappingImpl <em>Infrastructure Mapping</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see arch.impl.InfrastructureMappingImpl
   * @see arch.impl.ArchPackageImpl#getInfrastructureMapping()
   * @generated
   */
  int INFRASTRUCTURE_MAPPING = 1;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_MAPPING__TRACE_INFO = ELEMENT_WITH_TRACE_INFO__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Mapped Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_MAPPING__MAPPED_ELEMENTS = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_MAPPING__TARGET_ELEMENT = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Infrastructure Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_MAPPING_FEATURE_COUNT = ELEMENT_WITH_TRACE_INFO_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Infrastructure Mapping</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFRASTRUCTURE_MAPPING_OPERATION_COUNT = ELEMENT_WITH_TRACE_INFO_OPERATION_COUNT + 0;


  /**
   * Returns the meta object for class '{@link arch.Configuration <em>Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Configuration</em>'.
   * @see arch.Configuration
   * @generated
   */
  EClass getConfiguration();

  /**
   * Returns the meta object for the containment reference list '{@link arch.Configuration#getClusters <em>Clusters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Clusters</em>'.
   * @see arch.Configuration#getClusters()
   * @see #getConfiguration()
   * @generated
   */
  EReference getConfiguration_Clusters();

  /**
   * Returns the meta object for the containment reference list '{@link arch.Configuration#getReteRecipes <em>Rete Recipes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rete Recipes</em>'.
   * @see arch.Configuration#getReteRecipes()
   * @see #getConfiguration()
   * @generated
   */
  EReference getConfiguration_ReteRecipes();

  /**
   * Returns the meta object for the containment reference list '{@link arch.Configuration#getMappings <em>Mappings</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Mappings</em>'.
   * @see arch.Configuration#getMappings()
   * @see #getConfiguration()
   * @generated
   */
  EReference getConfiguration_Mappings();

  /**
   * Returns the meta object for class '{@link arch.InfrastructureMapping <em>Infrastructure Mapping</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Infrastructure Mapping</em>'.
   * @see arch.InfrastructureMapping
   * @generated
   */
  EClass getInfrastructureMapping();

  /**
   * Returns the meta object for the reference list '{@link arch.InfrastructureMapping#getMappedElements <em>Mapped Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Mapped Elements</em>'.
   * @see arch.InfrastructureMapping#getMappedElements()
   * @see #getInfrastructureMapping()
   * @generated
   */
  EReference getInfrastructureMapping_MappedElements();

  /**
   * Returns the meta object for the reference '{@link arch.InfrastructureMapping#getTargetElement <em>Target Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Element</em>'.
   * @see arch.InfrastructureMapping#getTargetElement()
   * @see #getInfrastructureMapping()
   * @generated
   */
  EReference getInfrastructureMapping_TargetElement();

  /**
   * Returns the meta object for class '{@link arch.ElementWithTraceInfo <em>Element With Trace Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element With Trace Info</em>'.
   * @see arch.ElementWithTraceInfo
   * @generated
   */
  EClass getElementWithTraceInfo();

  /**
   * Returns the meta object for the attribute '{@link arch.ElementWithTraceInfo#getTraceInfo <em>Trace Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace Info</em>'.
   * @see arch.ElementWithTraceInfo#getTraceInfo()
   * @see #getElementWithTraceInfo()
   * @generated
   */
  EAttribute getElementWithTraceInfo_TraceInfo();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ArchFactory getArchFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link arch.impl.ConfigurationImpl <em>Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see arch.impl.ConfigurationImpl
     * @see arch.impl.ArchPackageImpl#getConfiguration()
     * @generated
     */
    EClass CONFIGURATION = eINSTANCE.getConfiguration();

    /**
     * The meta object literal for the '<em><b>Clusters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFIGURATION__CLUSTERS = eINSTANCE.getConfiguration_Clusters();

    /**
     * The meta object literal for the '<em><b>Rete Recipes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFIGURATION__RETE_RECIPES = eINSTANCE.getConfiguration_ReteRecipes();

    /**
     * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONFIGURATION__MAPPINGS = eINSTANCE.getConfiguration_Mappings();

    /**
     * The meta object literal for the '{@link arch.impl.InfrastructureMappingImpl <em>Infrastructure Mapping</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see arch.impl.InfrastructureMappingImpl
     * @see arch.impl.ArchPackageImpl#getInfrastructureMapping()
     * @generated
     */
    EClass INFRASTRUCTURE_MAPPING = eINSTANCE.getInfrastructureMapping();

    /**
     * The meta object literal for the '<em><b>Mapped Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INFRASTRUCTURE_MAPPING__MAPPED_ELEMENTS = eINSTANCE.getInfrastructureMapping_MappedElements();

    /**
     * The meta object literal for the '<em><b>Target Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INFRASTRUCTURE_MAPPING__TARGET_ELEMENT = eINSTANCE.getInfrastructureMapping_TargetElement();

    /**
     * The meta object literal for the '{@link arch.ElementWithTraceInfo <em>Element With Trace Info</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see arch.ElementWithTraceInfo
     * @see arch.impl.ArchPackageImpl#getElementWithTraceInfo()
     * @generated
     */
    EClass ELEMENT_WITH_TRACE_INFO = eINSTANCE.getElementWithTraceInfo();

    /**
     * The meta object literal for the '<em><b>Trace Info</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT_WITH_TRACE_INFO__TRACE_INFO = eINSTANCE.getElementWithTraceInfo_TraceInfo();

  }

} //ArchPackage
