package hu.bme.mit.incqueryd.rete.actors.testkits;

import hu.bme.mit.incqueryd.arch.ArchUtil;
import hu.bme.mit.incqueryd.rete.actors.ReteActor;
import hu.bme.mit.incqueryd.rete.messages.ActorReply;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorMessage;
import hu.bme.mit.incqueryd.rete.messages.YellowPages;
import hu.bme.mit.incqueryd.util.RecipeSerializer;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;
import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.JavaTestKit;
import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

public class ArchTestKit extends JavaTestKit {

	protected final ActorSystem system;
	protected final String architectureFile;
	protected final JavaTestKit coordinatorActor;
	protected final JavaTestKit targetActor;

	public ArchTestKit(final ActorSystem system, final String architectureFile) throws IOException {
		super(system);
		this.system = system;
		this.architectureFile = architectureFile;

		coordinatorActor = new JavaTestKit(system);
		targetActor = new JavaTestKit(system);
	}

	public void test() throws IOException {
		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());

		// initialize package registry
		// initialize the RecipesPackage before the others
		RecipesPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		ArchPackage.eINSTANCE.eClass();

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

	// Rete recipe <-> IP address mapping
	final Map<ReteNodeRecipe, String> recipeToIp = new HashMap<>();
	// Rete recipe <-> ActorRef
	final Map<ReteNodeRecipe, ActorRef> recipeToActorRef = new HashMap<>();
	// EMF URI <-> Rete recipe
	final Map<String, ReteNodeRecipe> emfUriToRecipe = new HashMap<>();
	// EMF URI <-> ActorRef
	final Map<String, ActorRef> emfUriToActorRef = new HashMap<>();
	// collection of ActorRefs
	final Collection<ActorRef> actorRefs = new HashSet<>();

	private void processConfiguration(final ResourceSet resourceSet, final Configuration conf) throws IOException {
		// mapping
		fillRecipeToIp(conf);
		
		// phase 1
		deployActors(conf);
		// create mapping based on the results of phase one mapping
		fillEmfUriToActorRef();
		
		// phase 2
		subscribeActors(conf);
		
		// phase 3
		initialize();
	}

	private void fillRecipeToIp(final Configuration conf) {
		final EList<InfrastructureMapping> mappings = conf.getMappings();
		for (final InfrastructureMapping mapping : mappings) {
			final InfrastructureNode targetElement = mapping.getTargetElement();

			final EList<ReteNodeRecipe> mappedElements = mapping.getMappedElements();
			for (final ReteNodeRecipe reteNodeRecipe : mappedElements) {
				if (targetElement instanceof Machine) {
					final Machine machine = (Machine) targetElement;
					recipeToIp.put(reteNodeRecipe, machine.getIp());
				}
			}
		}
	}

	private void fillEmfUriToActorRef() {
		for (final Entry<String, ReteNodeRecipe> emfUriAndRecipe : emfUriToRecipe.entrySet()) {
			final String emfUri = emfUriAndRecipe.getKey();
			final ReteNodeRecipe recipe = emfUriAndRecipe.getValue();

			final ActorRef akkaUri = recipeToActorRef.get(recipe);

			emfUriToActorRef.put(emfUri, akkaUri);
			
			System.out.println("EMF URI: " + emfUri + ", Akka URI: " + akkaUri + ", traceInfo " + ArchUtil.justFirstLine(recipe.getTraceInfo()));
		}
		
		System.out.println();
	}

	/**
	 * Phase 1
	 * @param conf
	 * @throws IOException
	 */
	private void deployActors(final Configuration conf) throws IOException {
		for (final ReteRecipe rr : conf.getReteRecipes()) {
			for (final ReteNodeRecipe rnr : rr.getRecipeNodes()) {
				System.out.println("[TestKit] Recipe: " + rnr.getClass().getName());

				final String ipAddress = recipeToIp.get(rnr);
				final String emfUri = EcoreUtil.getURI(rnr).toString();
				System.out.println("[TestKit] - IP address:  " + ipAddress);
				System.out.println("[TestKit] - EMF address: " + emfUri);
				emfUriToRecipe.put(emfUri, rnr);

				// create a clone, else we would get a java.util.ConcurrentModificationException
				final ReteNodeRecipe rnrClone = EcoreUtil.copy(rnr);
				final String recipeString = RecipeSerializer.serializeToString(rnrClone);

				// TODO programmatic remote deployment goes here
				final Props props = new Props(ReteActor.class);
				final ActorRef actorRef = system.actorOf(props);
				configure(actorRef, recipeString);

				actorRefs.add(actorRef);
				recipeToActorRef.put(rnr, actorRef);
				System.out.println("[TestKit] Actor configured.");

				// System.out.println(serialized);
				// final EObject deserializeFromString = RecipeDeserializer.deserializeFromString(serialized);
				// System.out.println(deserializeFromString);

				System.out.println();
			}

		}
		System.out.println("[ReteActor] All actors deployed and configured.");
		System.out.println();
	}

	/**
	 * Phase 2
	 * @param conf
	 */
	private void subscribeActors(final Configuration conf) {
		final YellowPages yellowPages = new YellowPages(emfUriToActorRef);
		
		for (final ActorRef actorRef : actorRefs) {
			actorRef.tell(yellowPages, coordinatorActor.getRef());
			coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.YELLOWPAGES_RECEIVED);
		}
		System.out.println();
		System.out.println();
		
		for (final Entry<String, ActorRef> entry : yellowPages.getEmfUriToActorRef().entrySet()) {
			System.out.println(entry);
		}
	}
	
	/**
	 * Phase 3: initialize the Rete network.
	 */
	private void initialize() {
		// send an INITIALIZE message to every "input actor"
		// in the current implementation input actors are described by a UniquenessEnforcerRecipe
		for (final Entry<ReteNodeRecipe, ActorRef> entry : recipeToActorRef.entrySet()) {
			final ReteNodeRecipe recipe = entry.getKey();
			if (recipe instanceof UniquenessEnforcerRecipe) {
				final ActorRef actor = entry.getValue();
				actor.tell(CoordinatorMessage.INITIALIZE, coordinatorActor.getRef());
			}
		}
		
		try {
			Thread.sleep(5000);
		} catch (final Exception e) {
			e.printStackTrace();
		};
		
	}

	
	
	
	
	
	private void configure(final ActorRef actor, final String recipeString) {
		final ReteNodeConfiguration conf = new ReteNodeConfiguration(recipeString);
		actor.tell(conf, coordinatorActor.getRef());
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);
	}

	// @formatter:off
	/**
	 * 
	 *  (coordinatorActor) <--------------> (reteActor)
     *                          (A) >
     *                          (B) <
     * 
     *  (A) ! ReteNodeConfiguration
     *  (B) ? CONFIGURATION_RECEIVED
	 */
	// @formatter:on
	public void configure(final ActorRef testedActor, final ReteNodeConfiguration conf) {
		// Act
		// message (A)
		testedActor.tell(conf, coordinatorActor.getRef());
		// Assert
		// message (B)
		coordinatorActor.expectMsgEquals(duration("1 second"), ActorReply.CONFIGURATION_RECEIVED);
	}
	
}
