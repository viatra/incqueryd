package hu.bme.mit.incqueryd.rete.actors;

import static akka.pattern.Patterns.ask;
import hu.bme.mit.incqueryd.arch.ArchUtil;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorCommand;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorMessage;
import hu.bme.mit.incqueryd.rete.messages.Transformation;
import hu.bme.mit.incqueryd.rete.messages.YellowPages;
import hu.bme.mit.incqueryd.util.RecipeSerializer;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;
import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.remote.RemoteScope;
import akka.util.Timeout;
import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

public class CoordinatorActor extends UntypedActor {

	protected final boolean remoting;
	protected final String architectureFile;
	protected final Timeout timeout = new Timeout(Duration.create(5, "seconds"));
	protected ActorRef productionActorRef;

	public CoordinatorActor(final String architectureFile, final boolean remoting) {
		super();
		this.architectureFile = architectureFile;
		this.remoting = remoting;
	}

	public void start() throws Exception {
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

	private void processConfiguration(final ResourceSet resourceSet, final Configuration conf) throws Exception {
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

			System.out.println("EMF URI: " + emfUri + ", Akka URI: " + akkaUri + ", traceInfo "
					+ ArchUtil.oneLiner(recipe.getTraceInfo()));
		}

		System.out.println();
	}

	/**
	 * Phase 1
	 * 
	 * @param conf
	 * @throws Exception
	 */
	private void deployActors(final Configuration conf) throws Exception {
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

				final Props props;
				if (remoting) {
					props = new Props(ReteActor.class).withDeploy(new Deploy(new RemoteScope(new Address("akka",
							IncQueryDMicrokernel.ACTOR_SYSTEM_NAME, ipAddress, 2552))));
				} else {
					props = new Props(ReteActor.class);
				}
				final ActorRef actorRef = getContext().actorOf(props);

				configure(actorRef, recipeString);

				actorRefs.add(actorRef);
				recipeToActorRef.put(rnr, actorRef);

				if (rnr instanceof ProductionRecipe) {
					productionActorRef = actorRef;
				}

				System.out.println("[TestKit] Actor configured.");
				System.out.println();
			}

		}
		System.out.println("[ReteActor] All actors deployed and configured.");
		System.out.println();
	}

	/**
	 * Phase 2
	 * 
	 * @param conf
	 * @throws Exception
	 */
	private void subscribeActors(final Configuration conf) throws Exception {
		final YellowPages yellowPages = new YellowPages(emfUriToActorRef);

		for (final ActorRef actorRef : actorRefs) {
			final Future<Object> future = ask(actorRef, yellowPages, timeout);
			final Object result = Await.result(future, timeout.duration());
		}

		System.out.println();
		System.out.println();

		for (final Entry<String, ActorRef> entry : yellowPages.getEmfUriToActorRef().entrySet()) {
			System.out.println(entry);
		}
	}

	/**
	 * Phase 3: initialize the Rete network.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		final Collection<Future<Object>> futures = new HashSet<>();

		// send an INITIALIZE message to every "input actor"
		// in the current implementation input actors are described by a UniquenessEnforcerRecipe
		for (final Entry<ReteNodeRecipe, ActorRef> entry : recipeToActorRef.entrySet()) {
			final ReteNodeRecipe recipe = entry.getKey();
			if (recipe instanceof UniquenessEnforcerRecipe) {
				final ActorRef actorRef = entry.getValue();
				final Future<Object> future = ask(actorRef, CoordinatorMessage.INITIALIZE, timeout);
				futures.add(future);
			}
		}

		System.out.println("<AWAIT>");
		for (final Future<Object> future : futures) {
			System.out.println("await for " + future);
			final Object result = Await.result(future, timeout.duration());
			System.out.println(result);
		}
		System.out.println("</AWAIT>");

		final Future<Object> queryResultFuture = ask(productionActorRef, CoordinatorMessage.GETQUERYRESULTS, timeout);
		final Set<Tuple> result = (Set<Tuple>) Await.result(queryResultFuture, timeout.duration());

		for (final Entry<ReteNodeRecipe, ActorRef> entry : recipeToActorRef.entrySet()) {
			final ReteNodeRecipe recipe = entry.getKey();
			if (recipe instanceof UniquenessEnforcerRecipe) {
				final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) recipe;

				final ActorRef actorRef = entry.getValue();

				if (architectureFile.contains("routesensor")) {
					if (uer.getTraceInfo().contains("TrackElement_sensor")) {
						final Transformation transformation = new Transformation(result, "RouteSensor");
						final Future<Object> future = ask(actorRef, transformation, timeout);
						Await.result(future, timeout.duration());
					}
				}
				
				if (architectureFile.contains("signalneighbor")) {				
					if (uer.getTraceInfo().contains("Route_exit")) {
						final Transformation transformation = new Transformation(result, "SignalNeighbor");
						final Future<Object> future = ask(actorRef, transformation, timeout);
						Await.result(future, timeout.duration());
					}
				}
				
				if (architectureFile.contains("switchsensor")) {				
					if (uer.getTraceInfo().contains("TrackElement_sensor")) {
						final Transformation transformation = new Transformation(result, "SwitchSensor");
						final Future<Object> future = ask(actorRef, transformation, timeout);
						Await.result(future, timeout.duration());
					}
				}
			}
		}

		System.exit(0);

	}

	private void configure(final ActorRef actorRef, final String recipeString) throws Exception {
		final ReteNodeConfiguration conf = new ReteNodeConfiguration(recipeString);
		final Future<Object> future = ask(actorRef, conf, timeout);
		final Object object = Await.result(future, timeout.duration());
	}

	@Override
	public void onReceive(final Object message) throws Exception {
		if (message == CoordinatorCommand.START) {
			start();
			getSender().tell(CoordinatorMessage.DONE, getSelf());
		}
	}

}
