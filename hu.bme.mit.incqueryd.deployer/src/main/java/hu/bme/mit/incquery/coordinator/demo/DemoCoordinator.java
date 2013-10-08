package hu.bme.mit.incquery.coordinator.demo;

import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ConstantRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

public class DemoCoordinator {

	/**
	 * take a look at -
	 * http://wiki.eclipse.org/EMF/FAQ#How_do_I_use_EMF_in_standalone_applications_.28such_as_an_ordinary_main.29.3F -
	 * http://wiki.eclipse.org/EMF/FAQ#I_want_to_use_EMF.2C_SDO.2C_or_XSD_in_my_standalone_project.2
	 * C_or_include_only_a_working_subset_of_the_code._What_libraries_.28jar_files.29_do_I_need_in_my_CLASSPATH.3F
	 * 
	 * create runnable JAR from this project as follows: 1) test the project in your Eclipse, create a Java application
	 * run configuration for it. 2) using Export | Runnable Jar, launch the export wizard 2a) select your run
	 * configuration at the top 2b) select "package required libraries..." 3) profit :-)
	 * 
	 * The JARs in lib were created as follows: emf: copied from a fresh downloadable EMF runtime package, as per EMF
	 * FAR instructions recipes and arch: export | deployable plug-ins and fragments
	 * 
	 */
	public static void main(final String[] args) {
		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());
		// initialize package registry
		ArchPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		RecipesPackage.eINSTANCE.eClass();

		// load resource
		final ResourceSet rs = new ResourceSetImpl();
		final Resource res = rs.getResource(URI.createFileURI(args[0]), true);

		// traverse model
		final EObject o = res.getContents().get(0);

		if (o instanceof Configuration) {

			// reference
			final Map<ReteNodeRecipe, String> ips = new HashMap<>();

			final EList<InfrastructureMapping> mappings = ((Configuration) o).getMappings();
			for (final InfrastructureMapping mapping : mappings) {
				final InfrastructureNode targetElement = mapping.getTargetElement();

				final EList<ReteNodeRecipe> mappedElements = mapping.getMappedElements();
				for (final ReteNodeRecipe reteNodeRecipe : mappedElements) {
					if (targetElement instanceof Machine) {
						final Machine machine = (Machine) targetElement;
						ips.put(reteNodeRecipe, machine.getIp());
					}
				}
			}

			// System.out.println(inverseMapping.size());
			// for (final Map.Entry<ReteNodeRecipe, InfrastructureNode> inverseMappingEntry : inverseMapping.entrySet())
			// {
			// System.out.println(">>> " + inverseMappingEntry);
			// }
			// if (true) return;

			for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
				System.out.println("Processing rete recipe " + rc.toString());

				for (final ReteNodeRecipe r : rc.getRecipeNodes()) {
					// System.out.println(r.getTraceInfo());

					if (r instanceof BetaRecipe) {
						System.out.println("- BetaRecipe");
						System.out.println("# address: " + ips.get(r));
						
						if (r instanceof ExistenceJoinRecipe) {
							final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
							System.out.println("  - ExistenceJoinRecipe: " + ejr);
						}

						if (r instanceof JoinRecipe) {
							final JoinRecipe jr = (JoinRecipe) r;
							System.out.println("  - JoinRecipe: " + jr);
						}

						final BetaRecipe br = (BetaRecipe) r;
						final ReteNodeRecipe leftGrandParent = br.getLeftParent().getParent();
						final ReteNodeRecipe rightGrandParent = br.getRightParent().getParent();
						
						final ReteNodeRecipe leftAncestor = getDistributedAncestor(leftGrandParent);
						final ReteNodeRecipe rightAncestor = getDistributedAncestor(rightGrandParent);

						System.out.println("    LEFT> " + leftAncestor);
						System.out.println("    # address: " + ips.get(leftAncestor));
						System.out.println("    RIGHT> " + rightAncestor);
						System.out.println("    # address: " + ips.get(rightAncestor));

					}

					if (r instanceof ConstantRecipe) {
						final ConstantRecipe cr = (ConstantRecipe) r;
						System.out.println("- ConstantRecipe: " + cr);
					}

					if (r instanceof InputRecipe) {
						final InputRecipe ir = (InputRecipe) r;
						System.out.println("- InputRecipe: " + ir);
						System.out.println("# address: " + ips.get(r));
					}

//					if (r instanceof TrimmerRecipe) {
//						final TrimmerRecipe tr = (TrimmerRecipe) r;
//						System.out.println("- TrimmerRecipe: " + tr);
//					}

					// if (r instanceof UniquenessEnforcerRecipe) {
					// final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) r;
					// System.out.println("- UniquenessEnforcerRecipe: " + uer);
					// final EList<ReteNodeRecipe> parents = uer.getParents();
					// for (final ReteNodeRecipe parent : parents) {
					// System.out.println("  - " + parent);
					// }
					// }

					if (r instanceof ProductionRecipe) {
						final ProductionRecipe pr = (ProductionRecipe) r;
						System.out.println("- ProductionRecipe: " + pr);
					}

					System.out.println();
				}
			}
		}
	}

	private static ReteNodeRecipe getDistributedAncestor(final ReteNodeRecipe recipe) {
		if (recipe instanceof UniquenessEnforcerRecipe) {
			final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) recipe;
			final ReteNodeRecipe ancestor = uer.getParents().get(0);
			return getDistributedAncestor(ancestor);
		}
		
		if (recipe instanceof ProductionRecipe) {
			final ProductionRecipe pr = (ProductionRecipe) recipe;
			final ReteNodeRecipe ancestor = pr.getParents().get(0);
			return getDistributedAncestor(ancestor);
		}

		if (recipe instanceof TrimmerRecipe) {
			final TrimmerRecipe tr = (TrimmerRecipe) recipe;
			final ReteNodeRecipe ancestor = tr.getParent();
			return getDistributedAncestor(ancestor);
		}
		
		return recipe;
	}
}
