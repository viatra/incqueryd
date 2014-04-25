/**
 */
package arch;

import infrastructure.ElementWithTraceInfo;
import infrastructure.Machine;

import org.eclipse.emf.common.util.EList;

import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link arch.InfrastructureMapping#getMappedElements <em>Mapped Elements</em>}</li>
 *   <li>{@link arch.InfrastructureMapping#getTargetElement <em>Target Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see arch.ArchPackage#getInfrastructureMapping()
 * @model
 * @generated
 */
public interface InfrastructureMapping extends ElementWithTraceInfo
{
  /**
   * Returns the value of the '<em><b>Mapped Elements</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mapped Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mapped Elements</em>' reference list.
   * @see arch.ArchPackage#getInfrastructureMapping_MappedElements()
   * @model
   * @generated
   */
  EList<ReteNodeRecipe> getMappedElements();

  /**
   * Returns the value of the '<em><b>Target Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Element</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Element</em>' reference.
   * @see #setTargetElement(Machine)
   * @see arch.ArchPackage#getInfrastructureMapping_TargetElement()
   * @model
   * @generated
   */
  Machine getTargetElement();

  /**
   * Sets the value of the '{@link arch.InfrastructureMapping#getTargetElement <em>Target Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Element</em>' reference.
   * @see #getTargetElement()
   * @generated
   */
  void setTargetElement(Machine value);

} // InfrastructureMapping
