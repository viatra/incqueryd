/**
 */
package inventory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see inventory.InventoryFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel editDirectory='/hu.bme.mit.incqueryd.inventory.edit/src' editorDirectory='/hu.bme.mit.incqueryd.inventory.editor/src'"
 * @generated
 */
public interface InventoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "inventory";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://incquery.net/inventory";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "inventory";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InventoryPackage eINSTANCE = inventory.impl.InventoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link inventory.impl.InventoryImpl <em>Inventory</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see inventory.impl.InventoryImpl
	 * @see inventory.impl.InventoryPackageImpl#getInventory()
	 * @generated
	 */
	int INVENTORY = 0;

	/**
	 * The feature id for the '<em><b>Connection String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY__CONNECTION_STRING = 0;

	/**
	 * The feature id for the '<em><b>Machine Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY__MACHINE_SET = 1;

	/**
	 * The feature id for the '<em><b>Master</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY__MASTER = 2;

	/**
	 * The number of structural features of the '<em>Inventory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Inventory</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVENTORY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link inventory.impl.MachineSetImpl <em>Machine Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see inventory.impl.MachineSetImpl
	 * @see inventory.impl.InventoryPackageImpl#getMachineSet()
	 * @generated
	 */
	int MACHINE_SET = 1;

	/**
	 * The number of structural features of the '<em>Machine Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_SET_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Machine Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link inventory.impl.InstanceSetImpl <em>Instance Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see inventory.impl.InstanceSetImpl
	 * @see inventory.impl.InventoryPackageImpl#getInstanceSet()
	 * @generated
	 */
	int INSTANCE_SET = 2;

	/**
	 * The feature id for the '<em><b>Machine Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SET__MACHINE_INSTANCES = MACHINE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Instance Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SET_FEATURE_COUNT = MACHINE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Instance Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_SET_OPERATION_COUNT = MACHINE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link inventory.impl.TemplateSetImpl <em>Template Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see inventory.impl.TemplateSetImpl
	 * @see inventory.impl.InventoryPackageImpl#getTemplateSet()
	 * @generated
	 */
	int TEMPLATE_SET = 3;

	/**
	 * The feature id for the '<em><b>Machine Templates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SET__MACHINE_TEMPLATES = MACHINE_SET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Template Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SET_FEATURE_COUNT = MACHINE_SET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Template Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_SET_OPERATION_COUNT = MACHINE_SET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link inventory.impl.MachineImpl <em>Machine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see inventory.impl.MachineImpl
	 * @see inventory.impl.InventoryPackageImpl#getMachine()
	 * @generated
	 */
	int MACHINE = 4;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__IDENTIFIER = 0;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__COST = 1;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__MEMORY_SIZE = 2;

	/**
	 * The feature id for the '<em><b>Memory Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__MEMORY_UNIT = 3;

	/**
	 * The feature id for the '<em><b>CP Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__CP_US = 4;

	/**
	 * The feature id for the '<em><b>Overheads</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE__OVERHEADS = 5;

	/**
	 * The number of structural features of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Machine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link inventory.impl.MachineInstanceImpl <em>Machine Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see inventory.impl.MachineInstanceImpl
	 * @see inventory.impl.InventoryPackageImpl#getMachineInstance()
	 * @generated
	 */
	int MACHINE_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE__IDENTIFIER = MACHINE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE__COST = MACHINE__COST;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE__MEMORY_SIZE = MACHINE__MEMORY_SIZE;

	/**
	 * The feature id for the '<em><b>Memory Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE__MEMORY_UNIT = MACHINE__MEMORY_UNIT;

	/**
	 * The feature id for the '<em><b>CP Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE__CP_US = MACHINE__CP_US;

	/**
	 * The feature id for the '<em><b>Overheads</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE__OVERHEADS = MACHINE__OVERHEADS;

	/**
	 * The feature id for the '<em><b>Ip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE__IP = MACHINE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Machine Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE_FEATURE_COUNT = MACHINE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Machine Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_INSTANCE_OPERATION_COUNT = MACHINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link inventory.impl.MachineTemplateImpl <em>Machine Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see inventory.impl.MachineTemplateImpl
	 * @see inventory.impl.InventoryPackageImpl#getMachineTemplate()
	 * @generated
	 */
	int MACHINE_TEMPLATE = 6;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TEMPLATE__IDENTIFIER = MACHINE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TEMPLATE__COST = MACHINE__COST;

	/**
	 * The feature id for the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TEMPLATE__MEMORY_SIZE = MACHINE__MEMORY_SIZE;

	/**
	 * The feature id for the '<em><b>Memory Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TEMPLATE__MEMORY_UNIT = MACHINE__MEMORY_UNIT;

	/**
	 * The feature id for the '<em><b>CP Us</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TEMPLATE__CP_US = MACHINE__CP_US;

	/**
	 * The feature id for the '<em><b>Overheads</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TEMPLATE__OVERHEADS = MACHINE__OVERHEADS;

	/**
	 * The number of structural features of the '<em>Machine Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TEMPLATE_FEATURE_COUNT = MACHINE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Machine Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_TEMPLATE_OPERATION_COUNT = MACHINE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link inventory.MemoryUnit <em>Memory Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see inventory.MemoryUnit
	 * @see inventory.impl.InventoryPackageImpl#getMemoryUnit()
	 * @generated
	 */
	int MEMORY_UNIT = 7;


	/**
	 * Returns the meta object for class '{@link inventory.Inventory <em>Inventory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inventory</em>'.
	 * @see inventory.Inventory
	 * @generated
	 */
	EClass getInventory();

	/**
	 * Returns the meta object for the attribute '{@link inventory.Inventory#getConnectionString <em>Connection String</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection String</em>'.
	 * @see inventory.Inventory#getConnectionString()
	 * @see #getInventory()
	 * @generated
	 */
	EAttribute getInventory_ConnectionString();

	/**
	 * Returns the meta object for the containment reference '{@link inventory.Inventory#getMachineSet <em>Machine Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Machine Set</em>'.
	 * @see inventory.Inventory#getMachineSet()
	 * @see #getInventory()
	 * @generated
	 */
	EReference getInventory_MachineSet();

	/**
	 * Returns the meta object for the reference '{@link inventory.Inventory#getMaster <em>Master</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Master</em>'.
	 * @see inventory.Inventory#getMaster()
	 * @see #getInventory()
	 * @generated
	 */
	EReference getInventory_Master();

	/**
	 * Returns the meta object for class '{@link inventory.MachineSet <em>Machine Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Set</em>'.
	 * @see inventory.MachineSet
	 * @generated
	 */
	EClass getMachineSet();

	/**
	 * Returns the meta object for class '{@link inventory.InstanceSet <em>Instance Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Set</em>'.
	 * @see inventory.InstanceSet
	 * @generated
	 */
	EClass getInstanceSet();

	/**
	 * Returns the meta object for the containment reference list '{@link inventory.InstanceSet#getMachineInstances <em>Machine Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine Instances</em>'.
	 * @see inventory.InstanceSet#getMachineInstances()
	 * @see #getInstanceSet()
	 * @generated
	 */
	EReference getInstanceSet_MachineInstances();

	/**
	 * Returns the meta object for class '{@link inventory.TemplateSet <em>Template Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Set</em>'.
	 * @see inventory.TemplateSet
	 * @generated
	 */
	EClass getTemplateSet();

	/**
	 * Returns the meta object for the containment reference list '{@link inventory.TemplateSet#getMachineTemplates <em>Machine Templates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Machine Templates</em>'.
	 * @see inventory.TemplateSet#getMachineTemplates()
	 * @see #getTemplateSet()
	 * @generated
	 */
	EReference getTemplateSet_MachineTemplates();

	/**
	 * Returns the meta object for class '{@link inventory.Machine <em>Machine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine</em>'.
	 * @see inventory.Machine
	 * @generated
	 */
	EClass getMachine();

	/**
	 * Returns the meta object for the attribute '{@link inventory.Machine#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see inventory.Machine#getIdentifier()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link inventory.Machine#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see inventory.Machine#getCost()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Cost();

	/**
	 * Returns the meta object for the attribute '{@link inventory.Machine#getMemorySize <em>Memory Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Size</em>'.
	 * @see inventory.Machine#getMemorySize()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_MemorySize();

	/**
	 * Returns the meta object for the attribute '{@link inventory.Machine#getMemoryUnit <em>Memory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Memory Unit</em>'.
	 * @see inventory.Machine#getMemoryUnit()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_MemoryUnit();

	/**
	 * Returns the meta object for the attribute '{@link inventory.Machine#getCPUs <em>CP Us</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>CP Us</em>'.
	 * @see inventory.Machine#getCPUs()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_CPUs();

	/**
	 * Returns the meta object for the attribute list '{@link inventory.Machine#getOverheads <em>Overheads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Overheads</em>'.
	 * @see inventory.Machine#getOverheads()
	 * @see #getMachine()
	 * @generated
	 */
	EAttribute getMachine_Overheads();

	/**
	 * Returns the meta object for class '{@link inventory.MachineInstance <em>Machine Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Instance</em>'.
	 * @see inventory.MachineInstance
	 * @generated
	 */
	EClass getMachineInstance();

	/**
	 * Returns the meta object for the attribute '{@link inventory.MachineInstance#getIp <em>Ip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip</em>'.
	 * @see inventory.MachineInstance#getIp()
	 * @see #getMachineInstance()
	 * @generated
	 */
	EAttribute getMachineInstance_Ip();

	/**
	 * Returns the meta object for class '{@link inventory.MachineTemplate <em>Machine Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Template</em>'.
	 * @see inventory.MachineTemplate
	 * @generated
	 */
	EClass getMachineTemplate();

	/**
	 * Returns the meta object for enum '{@link inventory.MemoryUnit <em>Memory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Memory Unit</em>'.
	 * @see inventory.MemoryUnit
	 * @generated
	 */
	EEnum getMemoryUnit();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InventoryFactory getInventoryFactory();

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
	interface Literals {
		/**
		 * The meta object literal for the '{@link inventory.impl.InventoryImpl <em>Inventory</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see inventory.impl.InventoryImpl
		 * @see inventory.impl.InventoryPackageImpl#getInventory()
		 * @generated
		 */
		EClass INVENTORY = eINSTANCE.getInventory();

		/**
		 * The meta object literal for the '<em><b>Connection String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVENTORY__CONNECTION_STRING = eINSTANCE.getInventory_ConnectionString();

		/**
		 * The meta object literal for the '<em><b>Machine Set</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVENTORY__MACHINE_SET = eINSTANCE.getInventory_MachineSet();

		/**
		 * The meta object literal for the '<em><b>Master</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVENTORY__MASTER = eINSTANCE.getInventory_Master();

		/**
		 * The meta object literal for the '{@link inventory.impl.MachineSetImpl <em>Machine Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see inventory.impl.MachineSetImpl
		 * @see inventory.impl.InventoryPackageImpl#getMachineSet()
		 * @generated
		 */
		EClass MACHINE_SET = eINSTANCE.getMachineSet();

		/**
		 * The meta object literal for the '{@link inventory.impl.InstanceSetImpl <em>Instance Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see inventory.impl.InstanceSetImpl
		 * @see inventory.impl.InventoryPackageImpl#getInstanceSet()
		 * @generated
		 */
		EClass INSTANCE_SET = eINSTANCE.getInstanceSet();

		/**
		 * The meta object literal for the '<em><b>Machine Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_SET__MACHINE_INSTANCES = eINSTANCE.getInstanceSet_MachineInstances();

		/**
		 * The meta object literal for the '{@link inventory.impl.TemplateSetImpl <em>Template Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see inventory.impl.TemplateSetImpl
		 * @see inventory.impl.InventoryPackageImpl#getTemplateSet()
		 * @generated
		 */
		EClass TEMPLATE_SET = eINSTANCE.getTemplateSet();

		/**
		 * The meta object literal for the '<em><b>Machine Templates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE_SET__MACHINE_TEMPLATES = eINSTANCE.getTemplateSet_MachineTemplates();

		/**
		 * The meta object literal for the '{@link inventory.impl.MachineImpl <em>Machine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see inventory.impl.MachineImpl
		 * @see inventory.impl.InventoryPackageImpl#getMachine()
		 * @generated
		 */
		EClass MACHINE = eINSTANCE.getMachine();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__IDENTIFIER = eINSTANCE.getMachine_Identifier();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__COST = eINSTANCE.getMachine_Cost();

		/**
		 * The meta object literal for the '<em><b>Memory Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__MEMORY_SIZE = eINSTANCE.getMachine_MemorySize();

		/**
		 * The meta object literal for the '<em><b>Memory Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__MEMORY_UNIT = eINSTANCE.getMachine_MemoryUnit();

		/**
		 * The meta object literal for the '<em><b>CP Us</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__CP_US = eINSTANCE.getMachine_CPUs();

		/**
		 * The meta object literal for the '<em><b>Overheads</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE__OVERHEADS = eINSTANCE.getMachine_Overheads();

		/**
		 * The meta object literal for the '{@link inventory.impl.MachineInstanceImpl <em>Machine Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see inventory.impl.MachineInstanceImpl
		 * @see inventory.impl.InventoryPackageImpl#getMachineInstance()
		 * @generated
		 */
		EClass MACHINE_INSTANCE = eINSTANCE.getMachineInstance();

		/**
		 * The meta object literal for the '<em><b>Ip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_INSTANCE__IP = eINSTANCE.getMachineInstance_Ip();

		/**
		 * The meta object literal for the '{@link inventory.impl.MachineTemplateImpl <em>Machine Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see inventory.impl.MachineTemplateImpl
		 * @see inventory.impl.InventoryPackageImpl#getMachineTemplate()
		 * @generated
		 */
		EClass MACHINE_TEMPLATE = eINSTANCE.getMachineTemplate();

		/**
		 * The meta object literal for the '{@link inventory.MemoryUnit <em>Memory Unit</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see inventory.MemoryUnit
		 * @see inventory.impl.InventoryPackageImpl#getMemoryUnit()
		 * @generated
		 */
		EEnum MEMORY_UNIT = eINSTANCE.getMemoryUnit();

	}

} //InventoryPackage
