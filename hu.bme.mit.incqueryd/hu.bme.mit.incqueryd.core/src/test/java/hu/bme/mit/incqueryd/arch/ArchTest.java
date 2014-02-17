package hu.bme.mit.incqueryd.arch;

import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.junit.Test;

import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

public class ArchTest {

	@Test
	public void test() throws IOException {
		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());

		// initialize package registry
		// initialize the RecipesPackage before the others
		RecipesPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		ArchPackage.eINSTANCE.eClass();

		final String architectureFile = "src/test/resources/arch/routeSensor.arch";

		// load resource
		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.getResource(URI.createFileURI(architectureFile), true);

		// traverse model
		final EObject o = resource.getContents().get(0);

		if (o instanceof Configuration) {
			final Configuration conf = (Configuration) o;
			processConfiguration(resourceSet, conf);
		}

	}

	private void processConfiguration(final ResourceSet resourceSet, final Configuration conf) throws IOException {
		// create a ReteNodeRecipe -> ip address mapping
		final Map<ReteNodeRecipe, String> ips = new HashMap<>();

		final EList<InfrastructureMapping> mappings = conf.getMappings();
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

		// final String uriString = "src/test/resources/arch/routeSensor.arch#//@reteRecipes.0/@recipeNodes.2";
		// final EObject eObject = getEObjectFromURI(resourceSet, uriString);
		// System.out.println(eObject);
		// final String ip = ips.get(eObject);
		// System.out.println(ip);

		for (final Entry<ReteNodeRecipe, String> entry : ips.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println("================================================");
			System.out.println(entry.getValue());
			System.out.println();
			System.out.println();
			System.out.println();
		}

		for (final ReteRecipe rr : conf.getReteRecipes()) {
			for (final ReteNodeRecipe rnr : rr.getRecipeNodes()) {
				System.out.println(rnr);

				// create a clone, else we'd get a java.util.ConcurrentModificationException
				final ReteNodeRecipe rnrClone = EcoreUtil.copy(rnr);

				System.out.println("RNR:  " + EcoreUtil.getURI(rnr)       + "      --->     " + ips.get(rnr)     );
//				System.out.println("RNRC: " + EcoreUtil.getURI(rnrClone)  + "           " + ips.get(rnrClone));
				System.out.println();

//				final String serialized = RecipeSerializer.serializeToString(rnrClone);
//				System.out.println(serialized);
//				System.out.println();
//				System.out.println();
//				System.out.println();

				// final EObject deserializeFromString = RecipeDeserializer.deserializeFromString(serialized);
				// System.out.println(deserializeFromString);

				// if (rnr instanceof JoinRecipe) {
				// System.out.println("JoinRecipe found");
				// }
			}
		}

		// //
		// ------------------------------------------------------------------------------------------------------------------
		// // first iteration
		// //
		// ------------------------------------------------------------------------------------------------------------------
		// for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
		// System.out.println("Processing rete recipe " + rc.toString());
		//
		// int n = 0;
		// for (final ReteNodeRecipe r : rc.getRecipeNodes()) {
		//
		// n++;
		// final String name = "ReteNode" + n;
		// names.put(r, name);
		//
		// // System.out.println(r.getTraceInfo());
		//
		// final String address = ips.get(r);
		//
		// // Beta recipes: natural join and antijoin
		// if (r instanceof BetaRecipe) {
		// System.out.println("- BetaRecipe");
		// System.out.println("# address: " + address);
		//
		// if (r instanceof ExistenceJoinRecipe) {
		// final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
		// System.out.println("  - ExistenceJoinRecipe: " + ejr);
		//
		// // joinnode's start signal is set to false
		// actors.put(name, new ActorContainer(false, address, ExistenceNode.class));
		// }
		//
		// if (r instanceof JoinRecipe) {
		// final JoinRecipe jr = (JoinRecipe) r;
		// System.out.println("  - JoinRecipe: " + jr);
		//
		// // joinnode's start signal is set to false
		// actors.put(name, new ActorContainer(false, address, NaturalJoinNode.class));
		// }
		//
		// final BetaRecipe br = (BetaRecipe) r;
		//
		// final ReteNodeRecipe leftGrandParent = br.getLeftParent().getParent();
		// final ReteNodeRecipe rightGrandParent = br.getRightParent().getParent();
		//
		// final ReteNodeRecipe leftAncestor = getDistributedAncestor(leftGrandParent);
		// final ReteNodeRecipe rightAncestor = getDistributedAncestor(rightGrandParent);
		//
		// children.put(leftAncestor, br);
		// childrenSides.put(leftAncestor, JoinSide.PRIMARY);
		// System.out.println("    LEFT> " + leftAncestor);
		// System.out.println("    # address: " + ips.get(leftAncestor));
		// children.put(rightAncestor, br);
		// childrenSides.put(rightAncestor, JoinSide.SECONDARY);
		// System.out.println("    RIGHT> " + rightAncestor);
		// System.out.println("    # address: " + ips.get(rightAncestor));
		// }
		//
		// // Input recipes
		// if (r instanceof InputRecipe) {
		// final InputRecipe ir = (InputRecipe) r;
		// System.out.println("- InputRecipe: " + ir);
		// System.out.println("# address: " + address);
		//
		// // inputnode's start signal is set to true
		// final ActorContainer actor = new ActorContainer(true, address, InputNode.class);
		// actors.put(name, actor);
		//
		// if (ir.getTypeIdentifier().equals("Route_routeDefinition")) {
		// route_routeDefinitionActor = actor;
		// }
		// }
		//
		// // Production recipes
		// if (r instanceof ProductionRecipe) {
		//
		// if (address != null) {
		// final ProductionRecipe pr = (ProductionRecipe) r;
		// System.out.println("- ProductionRecipe: " + pr);
		// System.out.println("# address: " + address);
		//
		// final TrimmerRecipe tr = (TrimmerRecipe) pr.getParents().get(0);
		// // final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) tr.getParent();
		// // final ReteNodeRecipe ancestor = uer.getParents().get(0);
		//
		// children.put(tr.getParent(), r);
		//
		// // joinnode's start signal is set to false
		// final ActorContainer actor = new ActorContainer(false, address, ProductionNode.class);
		// actors.put(name, actor);
		//
		// productionNode = actor;
		// }
		// }
		//
		// }
		//
		// deployActors();
		// System.out.println("### deployed");
		//
		// }
		//
		// // emitting actorContainers
		// for (final Map.Entry<String, ActorContainer> actorEntry : actors.entrySet()) {
		// System.out.println(actorEntry.getKey());
		// System.out.println(actorEntry.getValue());
		// }
		//
		// // emitting children
		// for (final Map.Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
		// final String key = names.get(entry.getKey());
		// final String value = names.get(entry.getValue());
		//
		// System.out.println(key + " --> " + value);
		// }
		//
		// // emitting children with class names
		// for (final Map.Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
		// final String key = names.get(entry.getKey());
		// final String value = names.get(entry.getValue());
		//
		// System.out.println(key + " " + entry.getKey().getClass() + " --> " + value + " " +
		// entry.getValue().getClass());
		// }
		//
		// //
		// ------------------------------------------------------------------------------------------------------------------
		// // second iteration
		// //
		// ------------------------------------------------------------------------------------------------------------------
		// for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
		// System.out.println("Processing rete recipe " + rc.toString());
		//
		// final int n = 0;
		// for (final ReteNodeRecipe r : rc.getRecipeNodes()) {
		//
		// final String address = ips.get(r);
		//
		// // Beta recipes: natural join and antijoin
		// if (r instanceof BetaRecipe) {
		// System.out.println("- BetaRecipe");
		// System.out.println("# address: " + address);
		//
		// final String name = names.get(r);
		// final ReteNodeRecipe childRecipe = children.get(r);
		// final String childName = names.get(childRecipe);
		//
		// //System.out.println("name: " + name + " childrenname : " + childName);
		//
		// final BetaRecipe br = (BetaRecipe) r;
		//
		// final ArrayList<Integer> leftMaskList = extractMask(br.getLeftParent());
		// final ArrayList<Integer> rightMaskList = extractMask(br.getRightParent());
		//
		// System.out.println(leftMaskList);
		// System.out.println(rightMaskList);
		//
		// // JoinNode: JoinNode1
		// final TupleMask leftMask = new TupleMask(leftMaskList, null); // [Sp], Sw
		// final TupleMask rightMask = new TupleMask(rightMaskList, null); // R, [Sp]
		//
		// System.out.println("left mask: " + leftMaskList);
		// System.out.println("right mask: " + rightMaskList);
		//
		// final JoinSide childJoinSide = childrenSides.get(r);
		// System.out.println("child name: " + childName + ", join side: " + childJoinSide);
		//
		// final JoinNodeConfiguration joinNodeConfiguration = new JoinNodeConfiguration(coordinator, leftMask,
		// rightMask,
		// actors.get(childName).actorRef.path().toString(), childJoinSide);
		//
		//
		// actors.get(name).configuration = joinNodeConfiguration;
		// System.out.println("---");
		//
		//
		// //
		// // if (r instanceof ExistenceJoinRecipe) {
		// // final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
		// // System.out.println("  - ExistenceJoinRecipe: " + ejr);
		// //
		// // }
		// //
		// // if (r instanceof JoinRecipe) {
		// // final JoinRecipe jr = (JoinRecipe) r;
		// // System.out.println("  - JoinRecipe: " + jr);
		// //
		// // }
		//
		// }
		//
		// // Input recipes
		// if (r instanceof InputRecipe) {
		// final InputRecipe ir = (InputRecipe) r;
		//
		// final ReteNodeRecipe childRecipe = children.get(ir);
		// final String childName = names.get(childRecipe);
		//
		// final JoinSide childJoinSide = childrenSides.get(r);
		// System.out.println("child name: " + childName + ", join side: " + childJoinSide);
		//
		// final String label = ir.getTypeIdentifier();
		// final UniquenessEnforcerNodeConfiguration config = new UniquenessEnforcerNodeConfiguration(
		// coordinator, actors.get(childName).actorRef.path().toString(),
		// label, childJoinSide, databaseClientType, filename);
		// final String actorName = names.get(ir);
		// actors.get(actorName).configuration = config;
		// }
		//
		// // Production recipes
		// if (r instanceof ProductionRecipe) {
		//
		// if (address != null) {
		// final ProductionRecipe pr = (ProductionRecipe) r;
		//
		// final ProductionNodeConfiguration productionNodeConfiguration = new ProductionNodeConfiguration(coordinator);
		// final String actorName = names.get(pr);
		// actors.get(actorName).configuration = productionNodeConfiguration;
		// }
		// }
		// }
		// }

	}

	private EObject getEObjectFromURI(final ResourceSet resourceSet, final String uriString) {
		final URI uri = URI.createURI(uriString);
		final EObject eObject = resourceSet.getEObject(uri, true);
		return eObject;
	}

}
