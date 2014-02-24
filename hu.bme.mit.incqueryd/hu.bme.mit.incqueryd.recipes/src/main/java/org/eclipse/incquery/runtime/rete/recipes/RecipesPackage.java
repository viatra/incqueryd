/**
 */
package org.eclipse.incquery.runtime.rete.recipes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.incquery.runtime.rete.recipes.RecipesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/GenModel basePackage='org.eclipse.incquery.runtime.rete'"
 * @generated
 */
public interface RecipesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "recipes";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/incquery/rete/recipes";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "recipes";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RecipesPackage eINSTANCE = org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ReteRecipeImpl <em>Rete Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.ReteRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getReteRecipe()
   * @generated
   */
  int RETE_RECIPE = 0;

  /**
   * The feature id for the '<em><b>Recipe Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETE_RECIPE__RECIPE_NODES = 0;

  /**
   * The number of structural features of the '<em>Rete Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETE_RECIPE_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Rete Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETE_RECIPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ReteNodeRecipeImpl <em>Rete Node Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.ReteNodeRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getReteNodeRecipe()
   * @generated
   */
  int RETE_NODE_RECIPE = 1;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETE_NODE_RECIPE__TRACE_INFO = 0;

  /**
   * The number of structural features of the '<em>Rete Node Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETE_NODE_RECIPE_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Rete Node Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETE_NODE_RECIPE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.SingleParentNodeRecipeImpl <em>Single Parent Node Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.SingleParentNodeRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getSingleParentNodeRecipe()
   * @generated
   */
  int SINGLE_PARENT_NODE_RECIPE = 2;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARENT_NODE_RECIPE__TRACE_INFO = RETE_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARENT_NODE_RECIPE__PARENT = RETE_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Single Parent Node Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARENT_NODE_RECIPE_FEATURE_COUNT = RETE_NODE_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Single Parent Node Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_PARENT_NODE_RECIPE_OPERATION_COUNT = RETE_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.AlphaRecipeImpl <em>Alpha Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.AlphaRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getAlphaRecipe()
   * @generated
   */
  int ALPHA_RECIPE = 3;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHA_RECIPE__TRACE_INFO = SINGLE_PARENT_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHA_RECIPE__PARENT = SINGLE_PARENT_NODE_RECIPE__PARENT;

  /**
   * The number of structural features of the '<em>Alpha Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHA_RECIPE_FEATURE_COUNT = SINGLE_PARENT_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Alpha Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALPHA_RECIPE_OPERATION_COUNT = SINGLE_PARENT_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.MultiParentNodeRecipeImpl <em>Multi Parent Node Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.MultiParentNodeRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getMultiParentNodeRecipe()
   * @generated
   */
  int MULTI_PARENT_NODE_RECIPE = 4;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_PARENT_NODE_RECIPE__TRACE_INFO = RETE_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parents</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_PARENT_NODE_RECIPE__PARENTS = RETE_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Multi Parent Node Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_PARENT_NODE_RECIPE_FEATURE_COUNT = RETE_NODE_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Multi Parent Node Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_PARENT_NODE_RECIPE_OPERATION_COUNT = RETE_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.UniquenessEnforcerRecipeImpl <em>Uniqueness Enforcer Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.UniquenessEnforcerRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getUniquenessEnforcerRecipe()
   * @generated
   */
  int UNIQUENESS_ENFORCER_RECIPE = 5;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIQUENESS_ENFORCER_RECIPE__TRACE_INFO = MULTI_PARENT_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parents</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIQUENESS_ENFORCER_RECIPE__PARENTS = MULTI_PARENT_NODE_RECIPE__PARENTS;

  /**
   * The number of structural features of the '<em>Uniqueness Enforcer Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIQUENESS_ENFORCER_RECIPE_FEATURE_COUNT = MULTI_PARENT_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Uniqueness Enforcer Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIQUENESS_ENFORCER_RECIPE_OPERATION_COUNT = MULTI_PARENT_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ProductionRecipeImpl <em>Production Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.ProductionRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getProductionRecipe()
   * @generated
   */
  int PRODUCTION_RECIPE = 6;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_RECIPE__TRACE_INFO = MULTI_PARENT_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parents</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_RECIPE__PARENTS = MULTI_PARENT_NODE_RECIPE__PARENTS;

  /**
   * The feature id for the '<em><b>Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_RECIPE__PATTERN = MULTI_PARENT_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Production Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_RECIPE_FEATURE_COUNT = MULTI_PARENT_NODE_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Production Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRODUCTION_RECIPE_OPERATION_COUNT = MULTI_PARENT_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ProjectionIndexerImpl <em>Projection Indexer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.ProjectionIndexerImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getProjectionIndexer()
   * @generated
   */
  int PROJECTION_INDEXER = 7;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECTION_INDEXER__TRACE_INFO = SINGLE_PARENT_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECTION_INDEXER__PARENT = SINGLE_PARENT_NODE_RECIPE__PARENT;

  /**
   * The feature id for the '<em><b>Mask</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECTION_INDEXER__MASK = SINGLE_PARENT_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Projection Indexer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECTION_INDEXER_FEATURE_COUNT = SINGLE_PARENT_NODE_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Projection Indexer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROJECTION_INDEXER_OPERATION_COUNT = SINGLE_PARENT_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.BetaRecipeImpl <em>Beta Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.BetaRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getBetaRecipe()
   * @generated
   */
  int BETA_RECIPE = 8;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BETA_RECIPE__TRACE_INFO = RETE_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Left Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BETA_RECIPE__LEFT_PARENT = RETE_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BETA_RECIPE__RIGHT_PARENT = RETE_NODE_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Beta Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BETA_RECIPE_FEATURE_COUNT = RETE_NODE_RECIPE_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Beta Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BETA_RECIPE_OPERATION_COUNT = RETE_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.MaskImpl <em>Mask</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.MaskImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getMask()
   * @generated
   */
  int MASK = 9;

  /**
   * The feature id for the '<em><b>Source Indices</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASK__SOURCE_INDICES = 0;

  /**
   * The feature id for the '<em><b>Source Arity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASK__SOURCE_ARITY = 1;

  /**
   * The number of structural features of the '<em>Mask</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASK_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Mask</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MASK_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.StringIndexMapEntryImpl <em>String Index Map Entry</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.StringIndexMapEntryImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getStringIndexMapEntry()
   * @generated
   */
  int STRING_INDEX_MAP_ENTRY = 10;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_INDEX_MAP_ENTRY__KEY = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_INDEX_MAP_ENTRY__VALUE = 1;

  /**
   * The number of structural features of the '<em>String Index Map Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_INDEX_MAP_ENTRY_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>String Index Map Entry</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_INDEX_MAP_ENTRY_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.InputRecipeImpl <em>Input Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.InputRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getInputRecipe()
   * @generated
   */
  int INPUT_RECIPE = 11;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_RECIPE__TRACE_INFO = RETE_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Type Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_RECIPE__TYPE_IDENTIFIER = RETE_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Input Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_RECIPE_FEATURE_COUNT = RETE_NODE_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Input Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INPUT_RECIPE_OPERATION_COUNT = RETE_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.UnaryInputRecipeImpl <em>Unary Input Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.UnaryInputRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getUnaryInputRecipe()
   * @generated
   */
  int UNARY_INPUT_RECIPE = 12;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_INPUT_RECIPE__TRACE_INFO = INPUT_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Type Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_INPUT_RECIPE__TYPE_IDENTIFIER = INPUT_RECIPE__TYPE_IDENTIFIER;

  /**
   * The number of structural features of the '<em>Unary Input Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_INPUT_RECIPE_FEATURE_COUNT = INPUT_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Unary Input Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_INPUT_RECIPE_OPERATION_COUNT = INPUT_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.BinaryInputRecipeImpl <em>Binary Input Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.BinaryInputRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getBinaryInputRecipe()
   * @generated
   */
  int BINARY_INPUT_RECIPE = 13;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_INPUT_RECIPE__TRACE_INFO = INPUT_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Type Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_INPUT_RECIPE__TYPE_IDENTIFIER = INPUT_RECIPE__TYPE_IDENTIFIER;

  /**
   * The number of structural features of the '<em>Binary Input Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_INPUT_RECIPE_FEATURE_COUNT = INPUT_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Binary Input Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_INPUT_RECIPE_OPERATION_COUNT = INPUT_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ConstantRecipeImpl <em>Constant Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.ConstantRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getConstantRecipe()
   * @generated
   */
  int CONSTANT_RECIPE = 14;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_RECIPE__TRACE_INFO = RETE_NODE_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Constant Values</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_RECIPE__CONSTANT_VALUES = RETE_NODE_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Constant Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_RECIPE_FEATURE_COUNT = RETE_NODE_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Constant Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_RECIPE_OPERATION_COUNT = RETE_NODE_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.TransitiveClosureRecipeImpl <em>Transitive Closure Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.TransitiveClosureRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getTransitiveClosureRecipe()
   * @generated
   */
  int TRANSITIVE_CLOSURE_RECIPE = 15;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITIVE_CLOSURE_RECIPE__TRACE_INFO = ALPHA_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITIVE_CLOSURE_RECIPE__PARENT = ALPHA_RECIPE__PARENT;

  /**
   * The number of structural features of the '<em>Transitive Closure Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITIVE_CLOSURE_RECIPE_FEATURE_COUNT = ALPHA_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Transitive Closure Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITIVE_CLOSURE_RECIPE_OPERATION_COUNT = ALPHA_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.FilterRecipeImpl <em>Filter Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.FilterRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getFilterRecipe()
   * @generated
   */
  int FILTER_RECIPE = 16;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILTER_RECIPE__TRACE_INFO = ALPHA_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILTER_RECIPE__PARENT = ALPHA_RECIPE__PARENT;

  /**
   * The number of structural features of the '<em>Filter Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILTER_RECIPE_FEATURE_COUNT = ALPHA_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Filter Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FILTER_RECIPE_OPERATION_COUNT = ALPHA_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.InequalityFilterRecipeImpl <em>Inequality Filter Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.InequalityFilterRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getInequalityFilterRecipe()
   * @generated
   */
  int INEQUALITY_FILTER_RECIPE = 17;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INEQUALITY_FILTER_RECIPE__TRACE_INFO = FILTER_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INEQUALITY_FILTER_RECIPE__PARENT = FILTER_RECIPE__PARENT;

  /**
   * The feature id for the '<em><b>Subject</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INEQUALITY_FILTER_RECIPE__SUBJECT = FILTER_RECIPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Inequals</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INEQUALITY_FILTER_RECIPE__INEQUALS = FILTER_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Inequality Filter Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INEQUALITY_FILTER_RECIPE_FEATURE_COUNT = FILTER_RECIPE_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Inequality Filter Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INEQUALITY_FILTER_RECIPE_OPERATION_COUNT = FILTER_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.EqualityFilterRecipeImpl <em>Equality Filter Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.EqualityFilterRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getEqualityFilterRecipe()
   * @generated
   */
  int EQUALITY_FILTER_RECIPE = 18;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_FILTER_RECIPE__TRACE_INFO = FILTER_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_FILTER_RECIPE__PARENT = FILTER_RECIPE__PARENT;

  /**
   * The feature id for the '<em><b>Indices</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_FILTER_RECIPE__INDICES = FILTER_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Equality Filter Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_FILTER_RECIPE_FEATURE_COUNT = FILTER_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Equality Filter Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_FILTER_RECIPE_OPERATION_COUNT = FILTER_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.TrimmerRecipeImpl <em>Trimmer Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.TrimmerRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getTrimmerRecipe()
   * @generated
   */
  int TRIMMER_RECIPE = 19;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIMMER_RECIPE__TRACE_INFO = ALPHA_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIMMER_RECIPE__PARENT = ALPHA_RECIPE__PARENT;

  /**
   * The feature id for the '<em><b>Mask</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIMMER_RECIPE__MASK = ALPHA_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Trimmer Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIMMER_RECIPE_FEATURE_COUNT = ALPHA_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Trimmer Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRIMMER_RECIPE_OPERATION_COUNT = ALPHA_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ExpressionEnforcerRecipeImpl <em>Expression Enforcer Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.ExpressionEnforcerRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getExpressionEnforcerRecipe()
   * @generated
   */
  int EXPRESSION_ENFORCER_RECIPE = 20;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ENFORCER_RECIPE__TRACE_INFO = ALPHA_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ENFORCER_RECIPE__PARENT = ALPHA_RECIPE__PARENT;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ENFORCER_RECIPE__EXPRESSION = ALPHA_RECIPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Mapped Indices</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES = ALPHA_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expression Enforcer Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ENFORCER_RECIPE_FEATURE_COUNT = ALPHA_RECIPE_FEATURE_COUNT + 2;

  /**
   * The number of operations of the '<em>Expression Enforcer Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_ENFORCER_RECIPE_OPERATION_COUNT = ALPHA_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.CheckRecipeImpl <em>Check Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.CheckRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getCheckRecipe()
   * @generated
   */
  int CHECK_RECIPE = 21;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RECIPE__TRACE_INFO = EXPRESSION_ENFORCER_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RECIPE__PARENT = EXPRESSION_ENFORCER_RECIPE__PARENT;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RECIPE__EXPRESSION = EXPRESSION_ENFORCER_RECIPE__EXPRESSION;

  /**
   * The feature id for the '<em><b>Mapped Indices</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RECIPE__MAPPED_INDICES = EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES;

  /**
   * The number of structural features of the '<em>Check Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RECIPE_FEATURE_COUNT = EXPRESSION_ENFORCER_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Check Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_RECIPE_OPERATION_COUNT = EXPRESSION_ENFORCER_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.EvalRecipeImpl <em>Eval Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.EvalRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getEvalRecipe()
   * @generated
   */
  int EVAL_RECIPE = 22;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL_RECIPE__TRACE_INFO = EXPRESSION_ENFORCER_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL_RECIPE__PARENT = EXPRESSION_ENFORCER_RECIPE__PARENT;

  /**
   * The feature id for the '<em><b>Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL_RECIPE__EXPRESSION = EXPRESSION_ENFORCER_RECIPE__EXPRESSION;

  /**
   * The feature id for the '<em><b>Mapped Indices</b></em>' map.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL_RECIPE__MAPPED_INDICES = EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES;

  /**
   * The number of structural features of the '<em>Eval Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL_RECIPE_FEATURE_COUNT = EXPRESSION_ENFORCER_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Eval Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVAL_RECIPE_OPERATION_COUNT = EXPRESSION_ENFORCER_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorRecipeImpl <em>Aggregator Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getAggregatorRecipe()
   * @generated
   */
  int AGGREGATOR_RECIPE = 23;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_RECIPE__TRACE_INFO = ALPHA_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_RECIPE__PARENT = ALPHA_RECIPE__PARENT;

  /**
   * The number of structural features of the '<em>Aggregator Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_RECIPE_FEATURE_COUNT = ALPHA_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Aggregator Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_RECIPE_OPERATION_COUNT = ALPHA_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.CountAggregatorRecipeImpl <em>Count Aggregator Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.CountAggregatorRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getCountAggregatorRecipe()
   * @generated
   */
  int COUNT_AGGREGATOR_RECIPE = 24;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COUNT_AGGREGATOR_RECIPE__TRACE_INFO = AGGREGATOR_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Parent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COUNT_AGGREGATOR_RECIPE__PARENT = AGGREGATOR_RECIPE__PARENT;

  /**
   * The number of structural features of the '<em>Count Aggregator Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COUNT_AGGREGATOR_RECIPE_FEATURE_COUNT = AGGREGATOR_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Count Aggregator Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COUNT_AGGREGATOR_RECIPE_OPERATION_COUNT = AGGREGATOR_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.JoinRecipeImpl <em>Join Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.JoinRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getJoinRecipe()
   * @generated
   */
  int JOIN_RECIPE = 25;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_RECIPE__TRACE_INFO = BETA_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Left Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_RECIPE__LEFT_PARENT = BETA_RECIPE__LEFT_PARENT;

  /**
   * The feature id for the '<em><b>Right Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_RECIPE__RIGHT_PARENT = BETA_RECIPE__RIGHT_PARENT;

  /**
   * The number of structural features of the '<em>Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_RECIPE_FEATURE_COUNT = BETA_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JOIN_RECIPE_OPERATION_COUNT = BETA_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ExistenceJoinRecipeImpl <em>Existence Join Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.ExistenceJoinRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getExistenceJoinRecipe()
   * @generated
   */
  int EXISTENCE_JOIN_RECIPE = 26;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTENCE_JOIN_RECIPE__TRACE_INFO = BETA_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Left Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTENCE_JOIN_RECIPE__LEFT_PARENT = BETA_RECIPE__LEFT_PARENT;

  /**
   * The feature id for the '<em><b>Right Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTENCE_JOIN_RECIPE__RIGHT_PARENT = BETA_RECIPE__RIGHT_PARENT;

  /**
   * The number of structural features of the '<em>Existence Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTENCE_JOIN_RECIPE_FEATURE_COUNT = BETA_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Existence Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTENCE_JOIN_RECIPE_OPERATION_COUNT = BETA_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.SemiJoinRecipeImpl <em>Semi Join Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.SemiJoinRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getSemiJoinRecipe()
   * @generated
   */
  int SEMI_JOIN_RECIPE = 27;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEMI_JOIN_RECIPE__TRACE_INFO = EXISTENCE_JOIN_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Left Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEMI_JOIN_RECIPE__LEFT_PARENT = EXISTENCE_JOIN_RECIPE__LEFT_PARENT;

  /**
   * The feature id for the '<em><b>Right Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEMI_JOIN_RECIPE__RIGHT_PARENT = EXISTENCE_JOIN_RECIPE__RIGHT_PARENT;

  /**
   * The number of structural features of the '<em>Semi Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEMI_JOIN_RECIPE_FEATURE_COUNT = EXISTENCE_JOIN_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Semi Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SEMI_JOIN_RECIPE_OPERATION_COUNT = EXISTENCE_JOIN_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.AntiJoinRecipeImpl <em>Anti Join Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.AntiJoinRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getAntiJoinRecipe()
   * @generated
   */
  int ANTI_JOIN_RECIPE = 28;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTI_JOIN_RECIPE__TRACE_INFO = EXISTENCE_JOIN_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Left Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTI_JOIN_RECIPE__LEFT_PARENT = EXISTENCE_JOIN_RECIPE__LEFT_PARENT;

  /**
   * The feature id for the '<em><b>Right Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTI_JOIN_RECIPE__RIGHT_PARENT = EXISTENCE_JOIN_RECIPE__RIGHT_PARENT;

  /**
   * The number of structural features of the '<em>Anti Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTI_JOIN_RECIPE_FEATURE_COUNT = EXISTENCE_JOIN_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Anti Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANTI_JOIN_RECIPE_OPERATION_COUNT = EXISTENCE_JOIN_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorJoinRecipeImpl <em>Aggregator Join Recipe</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorJoinRecipeImpl
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getAggregatorJoinRecipe()
   * @generated
   */
  int AGGREGATOR_JOIN_RECIPE = 29;

  /**
   * The feature id for the '<em><b>Trace Info</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_JOIN_RECIPE__TRACE_INFO = BETA_RECIPE__TRACE_INFO;

  /**
   * The feature id for the '<em><b>Left Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_JOIN_RECIPE__LEFT_PARENT = BETA_RECIPE__LEFT_PARENT;

  /**
   * The feature id for the '<em><b>Right Parent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_JOIN_RECIPE__RIGHT_PARENT = BETA_RECIPE__RIGHT_PARENT;

  /**
   * The feature id for the '<em><b>Aggregator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_JOIN_RECIPE__AGGREGATOR = BETA_RECIPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Aggregator Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_JOIN_RECIPE_FEATURE_COUNT = BETA_RECIPE_FEATURE_COUNT + 1;

  /**
   * The number of operations of the '<em>Aggregator Join Recipe</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AGGREGATOR_JOIN_RECIPE_OPERATION_COUNT = BETA_RECIPE_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '<em>Index</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see java.lang.Integer
   * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getIndex()
   * @generated
   */
  int INDEX = 30;


  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.ReteRecipe <em>Rete Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rete Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ReteRecipe
   * @generated
   */
  EClass getReteRecipe();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.incquery.runtime.rete.recipes.ReteRecipe#getRecipeNodes <em>Recipe Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Recipe Nodes</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ReteRecipe#getRecipeNodes()
   * @see #getReteRecipe()
   * @generated
   */
  EReference getReteRecipe_RecipeNodes();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe <em>Rete Node Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rete Node Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe
   * @generated
   */
  EClass getReteNodeRecipe();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe#getTraceInfo <em>Trace Info</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace Info</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe#getTraceInfo()
   * @see #getReteNodeRecipe()
   * @generated
   */
  EAttribute getReteNodeRecipe_TraceInfo();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe <em>Single Parent Node Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Parent Node Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe
   * @generated
   */
  EClass getSingleParentNodeRecipe();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Parent</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe#getParent()
   * @see #getSingleParentNodeRecipe()
   * @generated
   */
  EReference getSingleParentNodeRecipe_Parent();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe <em>Alpha Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Alpha Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe
   * @generated
   */
  EClass getAlphaRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe <em>Multi Parent Node Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi Parent Node Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe
   * @generated
   */
  EClass getMultiParentNodeRecipe();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe#getParents <em>Parents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Parents</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe#getParents()
   * @see #getMultiParentNodeRecipe()
   * @generated
   */
  EReference getMultiParentNodeRecipe_Parents();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe <em>Uniqueness Enforcer Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uniqueness Enforcer Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe
   * @generated
   */
  EClass getUniquenessEnforcerRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe <em>Production Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Production Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe
   * @generated
   */
  EClass getProductionRecipe();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe#getPattern <em>Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Pattern</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe#getPattern()
   * @see #getProductionRecipe()
   * @generated
   */
  EAttribute getProductionRecipe_Pattern();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer <em>Projection Indexer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Projection Indexer</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer
   * @generated
   */
  EClass getProjectionIndexer();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer#getMask <em>Mask</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mask</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer#getMask()
   * @see #getProjectionIndexer()
   * @generated
   */
  EReference getProjectionIndexer_Mask();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.BetaRecipe <em>Beta Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Beta Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.BetaRecipe
   * @generated
   */
  EClass getBetaRecipe();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.runtime.rete.recipes.BetaRecipe#getLeftParent <em>Left Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Parent</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.BetaRecipe#getLeftParent()
   * @see #getBetaRecipe()
   * @generated
   */
  EReference getBetaRecipe_LeftParent();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.runtime.rete.recipes.BetaRecipe#getRightParent <em>Right Parent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Parent</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.BetaRecipe#getRightParent()
   * @see #getBetaRecipe()
   * @generated
   */
  EReference getBetaRecipe_RightParent();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.Mask <em>Mask</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mask</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.Mask
   * @generated
   */
  EClass getMask();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.incquery.runtime.rete.recipes.Mask#getSourceIndices <em>Source Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Source Indices</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.Mask#getSourceIndices()
   * @see #getMask()
   * @generated
   */
  EAttribute getMask_SourceIndices();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.runtime.rete.recipes.Mask#getSourceArity <em>Source Arity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Source Arity</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.Mask#getSourceArity()
   * @see #getMask()
   * @generated
   */
  EAttribute getMask_SourceArity();

  /**
   * Returns the meta object for class '{@link java.util.Map.Entry <em>String Index Map Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Index Map Entry</em>'.
   * @see java.util.Map.Entry
   * @model keyUnique="false" keyDataType="org.eclipse.emf.ecore.EString"
   *        valueUnique="false" valueDataType="org.eclipse.incquery.runtime.rete.recipes.Index"
   * @generated
   */
  EClass getStringIndexMapEntry();

  /**
   * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see java.util.Map.Entry
   * @see #getStringIndexMapEntry()
   * @generated
   */
  EAttribute getStringIndexMapEntry_Key();

  /**
   * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see java.util.Map.Entry
   * @see #getStringIndexMapEntry()
   * @generated
   */
  EAttribute getStringIndexMapEntry_Value();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.InputRecipe <em>Input Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Input Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.InputRecipe
   * @generated
   */
  EClass getInputRecipe();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.runtime.rete.recipes.InputRecipe#getTypeIdentifier <em>Type Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Identifier</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.InputRecipe#getTypeIdentifier()
   * @see #getInputRecipe()
   * @generated
   */
  EAttribute getInputRecipe_TypeIdentifier();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe <em>Unary Input Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Input Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe
   * @generated
   */
  EClass getUnaryInputRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe <em>Binary Input Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Input Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe
   * @generated
   */
  EClass getBinaryInputRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe <em>Constant Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe
   * @generated
   */
  EClass getConstantRecipe();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe#getConstantValues <em>Constant Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Constant Values</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe#getConstantValues()
   * @see #getConstantRecipe()
   * @generated
   */
  EAttribute getConstantRecipe_ConstantValues();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.TransitiveClosureRecipe <em>Transitive Closure Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transitive Closure Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.TransitiveClosureRecipe
   * @generated
   */
  EClass getTransitiveClosureRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.FilterRecipe <em>Filter Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Filter Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.FilterRecipe
   * @generated
   */
  EClass getFilterRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe <em>Inequality Filter Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inequality Filter Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe
   * @generated
   */
  EClass getInequalityFilterRecipe();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe#getSubject <em>Subject</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Subject</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe#getSubject()
   * @see #getInequalityFilterRecipe()
   * @generated
   */
  EAttribute getInequalityFilterRecipe_Subject();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe#getInequals <em>Inequals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Inequals</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe#getInequals()
   * @see #getInequalityFilterRecipe()
   * @generated
   */
  EAttribute getInequalityFilterRecipe_Inequals();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe <em>Equality Filter Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Filter Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe
   * @generated
   */
  EClass getEqualityFilterRecipe();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe#getIndices <em>Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Indices</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe#getIndices()
   * @see #getEqualityFilterRecipe()
   * @generated
   */
  EAttribute getEqualityFilterRecipe_Indices();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe <em>Trimmer Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trimmer Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe
   * @generated
   */
  EClass getTrimmerRecipe();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe#getMask <em>Mask</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Mask</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe#getMask()
   * @see #getTrimmerRecipe()
   * @generated
   */
  EReference getTrimmerRecipe_Mask();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe <em>Expression Enforcer Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Enforcer Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe
   * @generated
   */
  EClass getExpressionEnforcerRecipe();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expression</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe#getExpression()
   * @see #getExpressionEnforcerRecipe()
   * @generated
   */
  EAttribute getExpressionEnforcerRecipe_Expression();

  /**
   * Returns the meta object for the map '{@link org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe#getMappedIndices <em>Mapped Indices</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the map '<em>Mapped Indices</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe#getMappedIndices()
   * @see #getExpressionEnforcerRecipe()
   * @generated
   */
  EReference getExpressionEnforcerRecipe_MappedIndices();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.CheckRecipe <em>Check Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Check Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.CheckRecipe
   * @generated
   */
  EClass getCheckRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.EvalRecipe <em>Eval Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Eval Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.EvalRecipe
   * @generated
   */
  EClass getEvalRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe <em>Aggregator Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregator Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe
   * @generated
   */
  EClass getAggregatorRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.CountAggregatorRecipe <em>Count Aggregator Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Count Aggregator Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.CountAggregatorRecipe
   * @generated
   */
  EClass getCountAggregatorRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.JoinRecipe <em>Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Join Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.JoinRecipe
   * @generated
   */
  EClass getJoinRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe <em>Existence Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Existence Join Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe
   * @generated
   */
  EClass getExistenceJoinRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.SemiJoinRecipe <em>Semi Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Semi Join Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.SemiJoinRecipe
   * @generated
   */
  EClass getSemiJoinRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe <em>Anti Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anti Join Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe
   * @generated
   */
  EClass getAntiJoinRecipe();

  /**
   * Returns the meta object for class '{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe <em>Aggregator Join Recipe</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Aggregator Join Recipe</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe
   * @generated
   */
  EClass getAggregatorJoinRecipe();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe#getAggregator <em>Aggregator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Aggregator</em>'.
   * @see org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe#getAggregator()
   * @see #getAggregatorJoinRecipe()
   * @generated
   */
  EReference getAggregatorJoinRecipe_Aggregator();

  /**
   * Returns the meta object for data type '{@link java.lang.Integer <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Index</em>'.
   * @see java.lang.Integer
   * @model instanceClass="java.lang.Integer"
   * @generated
   */
  EDataType getIndex();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  RecipesFactory getRecipesFactory();

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
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ReteRecipeImpl <em>Rete Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.ReteRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getReteRecipe()
     * @generated
     */
    EClass RETE_RECIPE = eINSTANCE.getReteRecipe();

    /**
     * The meta object literal for the '<em><b>Recipe Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RETE_RECIPE__RECIPE_NODES = eINSTANCE.getReteRecipe_RecipeNodes();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ReteNodeRecipeImpl <em>Rete Node Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.ReteNodeRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getReteNodeRecipe()
     * @generated
     */
    EClass RETE_NODE_RECIPE = eINSTANCE.getReteNodeRecipe();

    /**
     * The meta object literal for the '<em><b>Trace Info</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RETE_NODE_RECIPE__TRACE_INFO = eINSTANCE.getReteNodeRecipe_TraceInfo();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.SingleParentNodeRecipeImpl <em>Single Parent Node Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.SingleParentNodeRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getSingleParentNodeRecipe()
     * @generated
     */
    EClass SINGLE_PARENT_NODE_RECIPE = eINSTANCE.getSingleParentNodeRecipe();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SINGLE_PARENT_NODE_RECIPE__PARENT = eINSTANCE.getSingleParentNodeRecipe_Parent();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.AlphaRecipeImpl <em>Alpha Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.AlphaRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getAlphaRecipe()
     * @generated
     */
    EClass ALPHA_RECIPE = eINSTANCE.getAlphaRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.MultiParentNodeRecipeImpl <em>Multi Parent Node Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.MultiParentNodeRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getMultiParentNodeRecipe()
     * @generated
     */
    EClass MULTI_PARENT_NODE_RECIPE = eINSTANCE.getMultiParentNodeRecipe();

    /**
     * The meta object literal for the '<em><b>Parents</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI_PARENT_NODE_RECIPE__PARENTS = eINSTANCE.getMultiParentNodeRecipe_Parents();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.UniquenessEnforcerRecipeImpl <em>Uniqueness Enforcer Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.UniquenessEnforcerRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getUniquenessEnforcerRecipe()
     * @generated
     */
    EClass UNIQUENESS_ENFORCER_RECIPE = eINSTANCE.getUniquenessEnforcerRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ProductionRecipeImpl <em>Production Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.ProductionRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getProductionRecipe()
     * @generated
     */
    EClass PRODUCTION_RECIPE = eINSTANCE.getProductionRecipe();

    /**
     * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRODUCTION_RECIPE__PATTERN = eINSTANCE.getProductionRecipe_Pattern();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ProjectionIndexerImpl <em>Projection Indexer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.ProjectionIndexerImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getProjectionIndexer()
     * @generated
     */
    EClass PROJECTION_INDEXER = eINSTANCE.getProjectionIndexer();

    /**
     * The meta object literal for the '<em><b>Mask</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROJECTION_INDEXER__MASK = eINSTANCE.getProjectionIndexer_Mask();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.BetaRecipeImpl <em>Beta Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.BetaRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getBetaRecipe()
     * @generated
     */
    EClass BETA_RECIPE = eINSTANCE.getBetaRecipe();

    /**
     * The meta object literal for the '<em><b>Left Parent</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BETA_RECIPE__LEFT_PARENT = eINSTANCE.getBetaRecipe_LeftParent();

    /**
     * The meta object literal for the '<em><b>Right Parent</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BETA_RECIPE__RIGHT_PARENT = eINSTANCE.getBetaRecipe_RightParent();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.MaskImpl <em>Mask</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.MaskImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getMask()
     * @generated
     */
    EClass MASK = eINSTANCE.getMask();

    /**
     * The meta object literal for the '<em><b>Source Indices</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASK__SOURCE_INDICES = eINSTANCE.getMask_SourceIndices();

    /**
     * The meta object literal for the '<em><b>Source Arity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MASK__SOURCE_ARITY = eINSTANCE.getMask_SourceArity();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.StringIndexMapEntryImpl <em>String Index Map Entry</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.StringIndexMapEntryImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getStringIndexMapEntry()
     * @generated
     */
    EClass STRING_INDEX_MAP_ENTRY = eINSTANCE.getStringIndexMapEntry();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_INDEX_MAP_ENTRY__KEY = eINSTANCE.getStringIndexMapEntry_Key();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_INDEX_MAP_ENTRY__VALUE = eINSTANCE.getStringIndexMapEntry_Value();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.InputRecipeImpl <em>Input Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.InputRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getInputRecipe()
     * @generated
     */
    EClass INPUT_RECIPE = eINSTANCE.getInputRecipe();

    /**
     * The meta object literal for the '<em><b>Type Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INPUT_RECIPE__TYPE_IDENTIFIER = eINSTANCE.getInputRecipe_TypeIdentifier();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.UnaryInputRecipeImpl <em>Unary Input Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.UnaryInputRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getUnaryInputRecipe()
     * @generated
     */
    EClass UNARY_INPUT_RECIPE = eINSTANCE.getUnaryInputRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.BinaryInputRecipeImpl <em>Binary Input Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.BinaryInputRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getBinaryInputRecipe()
     * @generated
     */
    EClass BINARY_INPUT_RECIPE = eINSTANCE.getBinaryInputRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ConstantRecipeImpl <em>Constant Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.ConstantRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getConstantRecipe()
     * @generated
     */
    EClass CONSTANT_RECIPE = eINSTANCE.getConstantRecipe();

    /**
     * The meta object literal for the '<em><b>Constant Values</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT_RECIPE__CONSTANT_VALUES = eINSTANCE.getConstantRecipe_ConstantValues();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.TransitiveClosureRecipeImpl <em>Transitive Closure Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.TransitiveClosureRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getTransitiveClosureRecipe()
     * @generated
     */
    EClass TRANSITIVE_CLOSURE_RECIPE = eINSTANCE.getTransitiveClosureRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.FilterRecipeImpl <em>Filter Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.FilterRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getFilterRecipe()
     * @generated
     */
    EClass FILTER_RECIPE = eINSTANCE.getFilterRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.InequalityFilterRecipeImpl <em>Inequality Filter Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.InequalityFilterRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getInequalityFilterRecipe()
     * @generated
     */
    EClass INEQUALITY_FILTER_RECIPE = eINSTANCE.getInequalityFilterRecipe();

    /**
     * The meta object literal for the '<em><b>Subject</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INEQUALITY_FILTER_RECIPE__SUBJECT = eINSTANCE.getInequalityFilterRecipe_Subject();

    /**
     * The meta object literal for the '<em><b>Inequals</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INEQUALITY_FILTER_RECIPE__INEQUALS = eINSTANCE.getInequalityFilterRecipe_Inequals();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.EqualityFilterRecipeImpl <em>Equality Filter Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.EqualityFilterRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getEqualityFilterRecipe()
     * @generated
     */
    EClass EQUALITY_FILTER_RECIPE = eINSTANCE.getEqualityFilterRecipe();

    /**
     * The meta object literal for the '<em><b>Indices</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EQUALITY_FILTER_RECIPE__INDICES = eINSTANCE.getEqualityFilterRecipe_Indices();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.TrimmerRecipeImpl <em>Trimmer Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.TrimmerRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getTrimmerRecipe()
     * @generated
     */
    EClass TRIMMER_RECIPE = eINSTANCE.getTrimmerRecipe();

    /**
     * The meta object literal for the '<em><b>Mask</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRIMMER_RECIPE__MASK = eINSTANCE.getTrimmerRecipe_Mask();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ExpressionEnforcerRecipeImpl <em>Expression Enforcer Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.ExpressionEnforcerRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getExpressionEnforcerRecipe()
     * @generated
     */
    EClass EXPRESSION_ENFORCER_RECIPE = eINSTANCE.getExpressionEnforcerRecipe();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPRESSION_ENFORCER_RECIPE__EXPRESSION = eINSTANCE.getExpressionEnforcerRecipe_Expression();

    /**
     * The meta object literal for the '<em><b>Mapped Indices</b></em>' map feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES = eINSTANCE.getExpressionEnforcerRecipe_MappedIndices();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.CheckRecipeImpl <em>Check Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.CheckRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getCheckRecipe()
     * @generated
     */
    EClass CHECK_RECIPE = eINSTANCE.getCheckRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.EvalRecipeImpl <em>Eval Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.EvalRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getEvalRecipe()
     * @generated
     */
    EClass EVAL_RECIPE = eINSTANCE.getEvalRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorRecipeImpl <em>Aggregator Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getAggregatorRecipe()
     * @generated
     */
    EClass AGGREGATOR_RECIPE = eINSTANCE.getAggregatorRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.CountAggregatorRecipeImpl <em>Count Aggregator Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.CountAggregatorRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getCountAggregatorRecipe()
     * @generated
     */
    EClass COUNT_AGGREGATOR_RECIPE = eINSTANCE.getCountAggregatorRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.JoinRecipeImpl <em>Join Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.JoinRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getJoinRecipe()
     * @generated
     */
    EClass JOIN_RECIPE = eINSTANCE.getJoinRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.ExistenceJoinRecipeImpl <em>Existence Join Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.ExistenceJoinRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getExistenceJoinRecipe()
     * @generated
     */
    EClass EXISTENCE_JOIN_RECIPE = eINSTANCE.getExistenceJoinRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.SemiJoinRecipeImpl <em>Semi Join Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.SemiJoinRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getSemiJoinRecipe()
     * @generated
     */
    EClass SEMI_JOIN_RECIPE = eINSTANCE.getSemiJoinRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.AntiJoinRecipeImpl <em>Anti Join Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.AntiJoinRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getAntiJoinRecipe()
     * @generated
     */
    EClass ANTI_JOIN_RECIPE = eINSTANCE.getAntiJoinRecipe();

    /**
     * The meta object literal for the '{@link org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorJoinRecipeImpl <em>Aggregator Join Recipe</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.AggregatorJoinRecipeImpl
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getAggregatorJoinRecipe()
     * @generated
     */
    EClass AGGREGATOR_JOIN_RECIPE = eINSTANCE.getAggregatorJoinRecipe();

    /**
     * The meta object literal for the '<em><b>Aggregator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AGGREGATOR_JOIN_RECIPE__AGGREGATOR = eINSTANCE.getAggregatorJoinRecipe_Aggregator();

    /**
     * The meta object literal for the '<em>Index</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Integer
     * @see org.eclipse.incquery.runtime.rete.recipes.impl.RecipesPackageImpl#getIndex()
     * @generated
     */
    EDataType INDEX = eINSTANCE.getIndex();

  }

} //RecipesPackage
