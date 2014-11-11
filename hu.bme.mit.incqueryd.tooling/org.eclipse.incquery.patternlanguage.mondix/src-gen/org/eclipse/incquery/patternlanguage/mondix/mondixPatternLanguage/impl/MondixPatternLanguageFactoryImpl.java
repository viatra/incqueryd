/**
 */
package org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MondixPatternLanguageFactoryImpl extends EFactoryImpl implements MondixPatternLanguageFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MondixPatternLanguageFactory init()
  {
    try
    {
      MondixPatternLanguageFactory theMondixPatternLanguageFactory = (MondixPatternLanguageFactory)EPackage.Registry.INSTANCE.getEFactory(MondixPatternLanguagePackage.eNS_URI);
      if (theMondixPatternLanguageFactory != null)
      {
        return theMondixPatternLanguageFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MondixPatternLanguageFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MondixPatternLanguageFactoryImpl()
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
      case MondixPatternLanguagePackage.VARIABLE: return createVariable();
      case MondixPatternLanguagePackage.UNARY_RELATION_CONSTRAINT: return createUnaryRelationConstraint();
      case MondixPatternLanguagePackage.BINARY_RELATION_CONSTRAINT: return createBinaryRelationConstraint();
      case MondixPatternLanguagePackage.MONDIX_PATTERN_MODEL: return createMondixPatternModel();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryRelationConstraint createUnaryRelationConstraint()
  {
    UnaryRelationConstraintImpl unaryRelationConstraint = new UnaryRelationConstraintImpl();
    return unaryRelationConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryRelationConstraint createBinaryRelationConstraint()
  {
    BinaryRelationConstraintImpl binaryRelationConstraint = new BinaryRelationConstraintImpl();
    return binaryRelationConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MondixPatternModel createMondixPatternModel()
  {
    MondixPatternModelImpl mondixPatternModel = new MondixPatternModelImpl();
    return mondixPatternModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MondixPatternLanguagePackage getMondixPatternLanguagePackage()
  {
    return (MondixPatternLanguagePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MondixPatternLanguagePackage getPackage()
  {
    return MondixPatternLanguagePackage.eINSTANCE;
  }

} //MondixPatternLanguageFactoryImpl
