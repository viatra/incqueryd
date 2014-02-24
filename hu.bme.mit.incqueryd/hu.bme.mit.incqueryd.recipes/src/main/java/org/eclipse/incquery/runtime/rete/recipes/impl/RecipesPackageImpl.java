/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.incquery.runtime.rete.recipes.AggregatorJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.AggregatorRecipe;
import org.eclipse.incquery.runtime.rete.recipes.AlphaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe;
import org.eclipse.incquery.runtime.rete.recipes.CountAggregatorRecipe;
import org.eclipse.incquery.runtime.rete.recipes.EqualityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.EvalRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExpressionEnforcerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.FilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InequalityFilterRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.SemiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TransitiveClosureRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecipesPackageImpl extends EPackageImpl implements RecipesPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reteRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reteNodeRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleParentNodeRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alphaRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiParentNodeRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass uniquenessEnforcerRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass productionRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass projectionIndexerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass betaRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass maskEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringIndexMapEntryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inputRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryInputRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryInputRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitiveClosureRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass filterRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inequalityFilterRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityFilterRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trimmerRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEnforcerRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass checkRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass evalRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aggregatorRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass countAggregatorRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass joinRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass existenceJoinRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass semiJoinRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass antiJoinRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aggregatorJoinRecipeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType indexEDataType = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.incquery.runtime.rete.recipes.RecipesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private RecipesPackageImpl()
  {
    super(eNS_URI, RecipesFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link RecipesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static RecipesPackage init()
  {
    if (isInited) return (RecipesPackage)EPackage.Registry.INSTANCE.getEPackage(RecipesPackage.eNS_URI);

    // Obtain or create and register package
    RecipesPackageImpl theRecipesPackage = (RecipesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RecipesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RecipesPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theRecipesPackage.createPackageContents();

    // Initialize created meta-data
    theRecipesPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theRecipesPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(RecipesPackage.eNS_URI, theRecipesPackage);
    return theRecipesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReteRecipe()
  {
    return reteRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReteRecipe_RecipeNodes()
  {
    return (EReference)reteRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReteNodeRecipe()
  {
    return reteNodeRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReteNodeRecipe_TraceInfo()
  {
    return (EAttribute)reteNodeRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleParentNodeRecipe()
  {
    return singleParentNodeRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleParentNodeRecipe_Parent()
  {
    return (EReference)singleParentNodeRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlphaRecipe()
  {
    return alphaRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiParentNodeRecipe()
  {
    return multiParentNodeRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiParentNodeRecipe_Parents()
  {
    return (EReference)multiParentNodeRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUniquenessEnforcerRecipe()
  {
    return uniquenessEnforcerRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProductionRecipe()
  {
    return productionRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getProductionRecipe_Pattern()
  {
    return (EAttribute)productionRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProjectionIndexer()
  {
    return projectionIndexerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProjectionIndexer_Mask()
  {
    return (EReference)projectionIndexerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBetaRecipe()
  {
    return betaRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBetaRecipe_LeftParent()
  {
    return (EReference)betaRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBetaRecipe_RightParent()
  {
    return (EReference)betaRecipeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMask()
  {
    return maskEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMask_SourceIndices()
  {
    return (EAttribute)maskEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMask_SourceArity()
  {
    return (EAttribute)maskEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringIndexMapEntry()
  {
    return stringIndexMapEntryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringIndexMapEntry_Key()
  {
    return (EAttribute)stringIndexMapEntryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringIndexMapEntry_Value()
  {
    return (EAttribute)stringIndexMapEntryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInputRecipe()
  {
    return inputRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInputRecipe_TypeIdentifier()
  {
    return (EAttribute)inputRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryInputRecipe()
  {
    return unaryInputRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinaryInputRecipe()
  {
    return binaryInputRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantRecipe()
  {
    return constantRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstantRecipe_ConstantValues()
  {
    return (EAttribute)constantRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitiveClosureRecipe()
  {
    return transitiveClosureRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFilterRecipe()
  {
    return filterRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInequalityFilterRecipe()
  {
    return inequalityFilterRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInequalityFilterRecipe_Subject()
  {
    return (EAttribute)inequalityFilterRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInequalityFilterRecipe_Inequals()
  {
    return (EAttribute)inequalityFilterRecipeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityFilterRecipe()
  {
    return equalityFilterRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualityFilterRecipe_Indices()
  {
    return (EAttribute)equalityFilterRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrimmerRecipe()
  {
    return trimmerRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrimmerRecipe_Mask()
  {
    return (EReference)trimmerRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionEnforcerRecipe()
  {
    return expressionEnforcerRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpressionEnforcerRecipe_Expression()
  {
    return (EAttribute)expressionEnforcerRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionEnforcerRecipe_MappedIndices()
  {
    return (EReference)expressionEnforcerRecipeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCheckRecipe()
  {
    return checkRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvalRecipe()
  {
    return evalRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAggregatorRecipe()
  {
    return aggregatorRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCountAggregatorRecipe()
  {
    return countAggregatorRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJoinRecipe()
  {
    return joinRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExistenceJoinRecipe()
  {
    return existenceJoinRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSemiJoinRecipe()
  {
    return semiJoinRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAntiJoinRecipe()
  {
    return antiJoinRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAggregatorJoinRecipe()
  {
    return aggregatorJoinRecipeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAggregatorJoinRecipe_Aggregator()
  {
    return (EReference)aggregatorJoinRecipeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getIndex()
  {
    return indexEDataType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecipesFactory getRecipesFactory()
  {
    return (RecipesFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    reteRecipeEClass = createEClass(RETE_RECIPE);
    createEReference(reteRecipeEClass, RETE_RECIPE__RECIPE_NODES);

    reteNodeRecipeEClass = createEClass(RETE_NODE_RECIPE);
    createEAttribute(reteNodeRecipeEClass, RETE_NODE_RECIPE__TRACE_INFO);

    singleParentNodeRecipeEClass = createEClass(SINGLE_PARENT_NODE_RECIPE);
    createEReference(singleParentNodeRecipeEClass, SINGLE_PARENT_NODE_RECIPE__PARENT);

    alphaRecipeEClass = createEClass(ALPHA_RECIPE);

    multiParentNodeRecipeEClass = createEClass(MULTI_PARENT_NODE_RECIPE);
    createEReference(multiParentNodeRecipeEClass, MULTI_PARENT_NODE_RECIPE__PARENTS);

    uniquenessEnforcerRecipeEClass = createEClass(UNIQUENESS_ENFORCER_RECIPE);

    productionRecipeEClass = createEClass(PRODUCTION_RECIPE);
    createEAttribute(productionRecipeEClass, PRODUCTION_RECIPE__PATTERN);

    projectionIndexerEClass = createEClass(PROJECTION_INDEXER);
    createEReference(projectionIndexerEClass, PROJECTION_INDEXER__MASK);

    betaRecipeEClass = createEClass(BETA_RECIPE);
    createEReference(betaRecipeEClass, BETA_RECIPE__LEFT_PARENT);
    createEReference(betaRecipeEClass, BETA_RECIPE__RIGHT_PARENT);

    maskEClass = createEClass(MASK);
    createEAttribute(maskEClass, MASK__SOURCE_INDICES);
    createEAttribute(maskEClass, MASK__SOURCE_ARITY);

    stringIndexMapEntryEClass = createEClass(STRING_INDEX_MAP_ENTRY);
    createEAttribute(stringIndexMapEntryEClass, STRING_INDEX_MAP_ENTRY__KEY);
    createEAttribute(stringIndexMapEntryEClass, STRING_INDEX_MAP_ENTRY__VALUE);

    inputRecipeEClass = createEClass(INPUT_RECIPE);
    createEAttribute(inputRecipeEClass, INPUT_RECIPE__TYPE_IDENTIFIER);

    unaryInputRecipeEClass = createEClass(UNARY_INPUT_RECIPE);

    binaryInputRecipeEClass = createEClass(BINARY_INPUT_RECIPE);

    constantRecipeEClass = createEClass(CONSTANT_RECIPE);
    createEAttribute(constantRecipeEClass, CONSTANT_RECIPE__CONSTANT_VALUES);

    transitiveClosureRecipeEClass = createEClass(TRANSITIVE_CLOSURE_RECIPE);

    filterRecipeEClass = createEClass(FILTER_RECIPE);

    inequalityFilterRecipeEClass = createEClass(INEQUALITY_FILTER_RECIPE);
    createEAttribute(inequalityFilterRecipeEClass, INEQUALITY_FILTER_RECIPE__SUBJECT);
    createEAttribute(inequalityFilterRecipeEClass, INEQUALITY_FILTER_RECIPE__INEQUALS);

    equalityFilterRecipeEClass = createEClass(EQUALITY_FILTER_RECIPE);
    createEAttribute(equalityFilterRecipeEClass, EQUALITY_FILTER_RECIPE__INDICES);

    trimmerRecipeEClass = createEClass(TRIMMER_RECIPE);
    createEReference(trimmerRecipeEClass, TRIMMER_RECIPE__MASK);

    expressionEnforcerRecipeEClass = createEClass(EXPRESSION_ENFORCER_RECIPE);
    createEAttribute(expressionEnforcerRecipeEClass, EXPRESSION_ENFORCER_RECIPE__EXPRESSION);
    createEReference(expressionEnforcerRecipeEClass, EXPRESSION_ENFORCER_RECIPE__MAPPED_INDICES);

    checkRecipeEClass = createEClass(CHECK_RECIPE);

    evalRecipeEClass = createEClass(EVAL_RECIPE);

    aggregatorRecipeEClass = createEClass(AGGREGATOR_RECIPE);

    countAggregatorRecipeEClass = createEClass(COUNT_AGGREGATOR_RECIPE);

    joinRecipeEClass = createEClass(JOIN_RECIPE);

    existenceJoinRecipeEClass = createEClass(EXISTENCE_JOIN_RECIPE);

    semiJoinRecipeEClass = createEClass(SEMI_JOIN_RECIPE);

    antiJoinRecipeEClass = createEClass(ANTI_JOIN_RECIPE);

    aggregatorJoinRecipeEClass = createEClass(AGGREGATOR_JOIN_RECIPE);
    createEReference(aggregatorJoinRecipeEClass, AGGREGATOR_JOIN_RECIPE__AGGREGATOR);

    // Create data types
    indexEDataType = createEDataType(INDEX);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    singleParentNodeRecipeEClass.getESuperTypes().add(this.getReteNodeRecipe());
    alphaRecipeEClass.getESuperTypes().add(this.getSingleParentNodeRecipe());
    multiParentNodeRecipeEClass.getESuperTypes().add(this.getReteNodeRecipe());
    uniquenessEnforcerRecipeEClass.getESuperTypes().add(this.getMultiParentNodeRecipe());
    productionRecipeEClass.getESuperTypes().add(this.getMultiParentNodeRecipe());
    projectionIndexerEClass.getESuperTypes().add(this.getSingleParentNodeRecipe());
    betaRecipeEClass.getESuperTypes().add(this.getReteNodeRecipe());
    inputRecipeEClass.getESuperTypes().add(this.getReteNodeRecipe());
    unaryInputRecipeEClass.getESuperTypes().add(this.getInputRecipe());
    binaryInputRecipeEClass.getESuperTypes().add(this.getInputRecipe());
    constantRecipeEClass.getESuperTypes().add(this.getReteNodeRecipe());
    transitiveClosureRecipeEClass.getESuperTypes().add(this.getAlphaRecipe());
    filterRecipeEClass.getESuperTypes().add(this.getAlphaRecipe());
    inequalityFilterRecipeEClass.getESuperTypes().add(this.getFilterRecipe());
    equalityFilterRecipeEClass.getESuperTypes().add(this.getFilterRecipe());
    trimmerRecipeEClass.getESuperTypes().add(this.getAlphaRecipe());
    expressionEnforcerRecipeEClass.getESuperTypes().add(this.getAlphaRecipe());
    checkRecipeEClass.getESuperTypes().add(this.getExpressionEnforcerRecipe());
    evalRecipeEClass.getESuperTypes().add(this.getExpressionEnforcerRecipe());
    aggregatorRecipeEClass.getESuperTypes().add(this.getAlphaRecipe());
    countAggregatorRecipeEClass.getESuperTypes().add(this.getAggregatorRecipe());
    joinRecipeEClass.getESuperTypes().add(this.getBetaRecipe());
    existenceJoinRecipeEClass.getESuperTypes().add(this.getBetaRecipe());
    semiJoinRecipeEClass.getESuperTypes().add(this.getExistenceJoinRecipe());
    antiJoinRecipeEClass.getESuperTypes().add(this.getExistenceJoinRecipe());
    aggregatorJoinRecipeEClass.getESuperTypes().add(this.getBetaRecipe());

    // Initialize classes, features, and operations; add parameters
    initEClass(reteRecipeEClass, ReteRecipe.class, "ReteRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReteRecipe_RecipeNodes(), this.getReteNodeRecipe(), null, "recipeNodes", null, 0, -1, ReteRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reteNodeRecipeEClass, ReteNodeRecipe.class, "ReteNodeRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReteNodeRecipe_TraceInfo(), theEcorePackage.getEString(), "traceInfo", null, 0, 1, ReteNodeRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleParentNodeRecipeEClass, SingleParentNodeRecipe.class, "SingleParentNodeRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSingleParentNodeRecipe_Parent(), this.getReteNodeRecipe(), null, "parent", null, 0, 1, SingleParentNodeRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alphaRecipeEClass, AlphaRecipe.class, "AlphaRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(multiParentNodeRecipeEClass, MultiParentNodeRecipe.class, "MultiParentNodeRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiParentNodeRecipe_Parents(), this.getReteNodeRecipe(), null, "parents", null, 0, -1, MultiParentNodeRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(uniquenessEnforcerRecipeEClass, UniquenessEnforcerRecipe.class, "UniquenessEnforcerRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(productionRecipeEClass, ProductionRecipe.class, "ProductionRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProductionRecipe_Pattern(), theEcorePackage.getEJavaObject(), "pattern", null, 0, 1, ProductionRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(projectionIndexerEClass, ProjectionIndexer.class, "ProjectionIndexer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProjectionIndexer_Mask(), this.getMask(), null, "mask", null, 0, 1, ProjectionIndexer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(betaRecipeEClass, BetaRecipe.class, "BetaRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBetaRecipe_LeftParent(), this.getProjectionIndexer(), null, "leftParent", null, 0, 1, BetaRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBetaRecipe_RightParent(), this.getProjectionIndexer(), null, "rightParent", null, 0, 1, BetaRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(maskEClass, Mask.class, "Mask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMask_SourceIndices(), this.getIndex(), "sourceIndices", null, 0, -1, Mask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMask_SourceArity(), theEcorePackage.getEInt(), "sourceArity", null, 0, 1, Mask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringIndexMapEntryEClass, Map.Entry.class, "StringIndexMapEntry", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringIndexMapEntry_Key(), theEcorePackage.getEString(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStringIndexMapEntry_Value(), this.getIndex(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inputRecipeEClass, InputRecipe.class, "InputRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInputRecipe_TypeIdentifier(), theEcorePackage.getEString(), "typeIdentifier", null, 0, 1, InputRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryInputRecipeEClass, UnaryInputRecipe.class, "UnaryInputRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(binaryInputRecipeEClass, BinaryInputRecipe.class, "BinaryInputRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constantRecipeEClass, ConstantRecipe.class, "ConstantRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstantRecipe_ConstantValues(), theEcorePackage.getEJavaObject(), "constantValues", null, 0, -1, ConstantRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitiveClosureRecipeEClass, TransitiveClosureRecipe.class, "TransitiveClosureRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(filterRecipeEClass, FilterRecipe.class, "FilterRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(inequalityFilterRecipeEClass, InequalityFilterRecipe.class, "InequalityFilterRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInequalityFilterRecipe_Subject(), this.getIndex(), "subject", null, 0, 1, InequalityFilterRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInequalityFilterRecipe_Inequals(), this.getIndex(), "inequals", null, 0, -1, InequalityFilterRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equalityFilterRecipeEClass, EqualityFilterRecipe.class, "EqualityFilterRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEqualityFilterRecipe_Indices(), this.getIndex(), "indices", null, 0, -1, EqualityFilterRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trimmerRecipeEClass, TrimmerRecipe.class, "TrimmerRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrimmerRecipe_Mask(), this.getMask(), null, "mask", null, 0, 1, TrimmerRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEnforcerRecipeEClass, ExpressionEnforcerRecipe.class, "ExpressionEnforcerRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExpressionEnforcerRecipe_Expression(), theEcorePackage.getEJavaObject(), "expression", null, 0, 1, ExpressionEnforcerRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpressionEnforcerRecipe_MappedIndices(), this.getStringIndexMapEntry(), null, "mappedIndices", null, 0, -1, ExpressionEnforcerRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(checkRecipeEClass, CheckRecipe.class, "CheckRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(evalRecipeEClass, EvalRecipe.class, "EvalRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(aggregatorRecipeEClass, AggregatorRecipe.class, "AggregatorRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(countAggregatorRecipeEClass, CountAggregatorRecipe.class, "CountAggregatorRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(joinRecipeEClass, JoinRecipe.class, "JoinRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(existenceJoinRecipeEClass, ExistenceJoinRecipe.class, "ExistenceJoinRecipe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(semiJoinRecipeEClass, SemiJoinRecipe.class, "SemiJoinRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(antiJoinRecipeEClass, AntiJoinRecipe.class, "AntiJoinRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(aggregatorJoinRecipeEClass, AggregatorJoinRecipe.class, "AggregatorJoinRecipe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAggregatorJoinRecipe_Aggregator(), this.getAggregatorRecipe(), null, "aggregator", null, 0, 1, AggregatorJoinRecipe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(indexEDataType, Integer.class, "Index", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //RecipesPackageImpl
