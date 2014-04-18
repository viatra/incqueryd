/**
 */
package org.eclipse.incquery.runtime.rete.recipes.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.incquery.runtime.rete.recipes.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecipesFactoryImpl extends EFactoryImpl implements RecipesFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static RecipesFactory init()
  {
    try
    {
      RecipesFactory theRecipesFactory = (RecipesFactory)EPackage.Registry.INSTANCE.getEFactory(RecipesPackage.eNS_URI);
      if (theRecipesFactory != null)
      {
        return theRecipesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new RecipesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecipesFactoryImpl()
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
      case RecipesPackage.RETE_RECIPE: return createReteRecipe();
      case RecipesPackage.UNIQUENESS_ENFORCER_RECIPE: return createUniquenessEnforcerRecipe();
      case RecipesPackage.PRODUCTION_RECIPE: return createProductionRecipe();
      case RecipesPackage.PROJECTION_INDEXER_RECIPE: return createProjectionIndexerRecipe();
      case RecipesPackage.AGGREGATOR_INDEXER_RECIPE: return createAggregatorIndexerRecipe();
      case RecipesPackage.MASK: return createMask();
      case RecipesPackage.STRING_INDEX_MAP_ENTRY: return (EObject)createStringIndexMapEntry();
      case RecipesPackage.UNARY_INPUT_RECIPE: return createUnaryInputRecipe();
      case RecipesPackage.BINARY_INPUT_RECIPE: return createBinaryInputRecipe();
      case RecipesPackage.CONSTANT_RECIPE: return createConstantRecipe();
      case RecipesPackage.TRANSITIVE_CLOSURE_RECIPE: return createTransitiveClosureRecipe();
      case RecipesPackage.INEQUALITY_FILTER_RECIPE: return createInequalityFilterRecipe();
      case RecipesPackage.EQUALITY_FILTER_RECIPE: return createEqualityFilterRecipe();
      case RecipesPackage.TRANSPARENT_RECIPE: return createTransparentRecipe();
      case RecipesPackage.TRIMMER_RECIPE: return createTrimmerRecipe();
      case RecipesPackage.CHECK_RECIPE: return createCheckRecipe();
      case RecipesPackage.EVAL_RECIPE: return createEvalRecipe();
      case RecipesPackage.COUNT_AGGREGATOR_RECIPE: return createCountAggregatorRecipe();
      case RecipesPackage.JOIN_RECIPE: return createJoinRecipe();
      case RecipesPackage.SEMI_JOIN_RECIPE: return createSemiJoinRecipe();
      case RecipesPackage.ANTI_JOIN_RECIPE: return createAntiJoinRecipe();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case RecipesPackage.INDEX:
        return createIndexFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case RecipesPackage.INDEX:
        return convertIndexToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReteRecipe createReteRecipe()
  {
    ReteRecipeImpl reteRecipe = new ReteRecipeImpl();
    return reteRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UniquenessEnforcerRecipe createUniquenessEnforcerRecipe()
  {
    UniquenessEnforcerRecipeImpl uniquenessEnforcerRecipe = new UniquenessEnforcerRecipeImpl();
    return uniquenessEnforcerRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductionRecipe createProductionRecipe()
  {
    ProductionRecipeImpl productionRecipe = new ProductionRecipeImpl();
    return productionRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProjectionIndexerRecipe createProjectionIndexerRecipe()
  {
    ProjectionIndexerRecipeImpl projectionIndexerRecipe = new ProjectionIndexerRecipeImpl();
    return projectionIndexerRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AggregatorIndexerRecipe createAggregatorIndexerRecipe()
  {
    AggregatorIndexerRecipeImpl aggregatorIndexerRecipe = new AggregatorIndexerRecipeImpl();
    return aggregatorIndexerRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mask createMask()
  {
    MaskImpl mask = new MaskImpl();
    return mask;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Map.Entry<String, Integer> createStringIndexMapEntry()
  {
    StringIndexMapEntryImpl stringIndexMapEntry = new StringIndexMapEntryImpl();
    return stringIndexMapEntry;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryInputRecipe createUnaryInputRecipe()
  {
    UnaryInputRecipeImpl unaryInputRecipe = new UnaryInputRecipeImpl();
    return unaryInputRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryInputRecipe createBinaryInputRecipe()
  {
    BinaryInputRecipeImpl binaryInputRecipe = new BinaryInputRecipeImpl();
    return binaryInputRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantRecipe createConstantRecipe()
  {
    ConstantRecipeImpl constantRecipe = new ConstantRecipeImpl();
    return constantRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransitiveClosureRecipe createTransitiveClosureRecipe()
  {
    TransitiveClosureRecipeImpl transitiveClosureRecipe = new TransitiveClosureRecipeImpl();
    return transitiveClosureRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InequalityFilterRecipe createInequalityFilterRecipe()
  {
    InequalityFilterRecipeImpl inequalityFilterRecipe = new InequalityFilterRecipeImpl();
    return inequalityFilterRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityFilterRecipe createEqualityFilterRecipe()
  {
    EqualityFilterRecipeImpl equalityFilterRecipe = new EqualityFilterRecipeImpl();
    return equalityFilterRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransparentRecipe createTransparentRecipe()
  {
    TransparentRecipeImpl transparentRecipe = new TransparentRecipeImpl();
    return transparentRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrimmerRecipe createTrimmerRecipe()
  {
    TrimmerRecipeImpl trimmerRecipe = new TrimmerRecipeImpl();
    return trimmerRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CheckRecipe createCheckRecipe()
  {
    CheckRecipeImpl checkRecipe = new CheckRecipeImpl();
    return checkRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EvalRecipe createEvalRecipe()
  {
    EvalRecipeImpl evalRecipe = new EvalRecipeImpl();
    return evalRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CountAggregatorRecipe createCountAggregatorRecipe()
  {
    CountAggregatorRecipeImpl countAggregatorRecipe = new CountAggregatorRecipeImpl();
    return countAggregatorRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JoinRecipe createJoinRecipe()
  {
    JoinRecipeImpl joinRecipe = new JoinRecipeImpl();
    return joinRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SemiJoinRecipe createSemiJoinRecipe()
  {
    SemiJoinRecipeImpl semiJoinRecipe = new SemiJoinRecipeImpl();
    return semiJoinRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AntiJoinRecipe createAntiJoinRecipe()
  {
    AntiJoinRecipeImpl antiJoinRecipe = new AntiJoinRecipeImpl();
    return antiJoinRecipe;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Integer createIndexFromString(EDataType eDataType, String initialValue)
  {
    return (Integer)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertIndexToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecipesPackage getRecipesPackage()
  {
    return (RecipesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static RecipesPackage getPackage()
  {
    return RecipesPackage.eINSTANCE;
  }

} //RecipesFactoryImpl
