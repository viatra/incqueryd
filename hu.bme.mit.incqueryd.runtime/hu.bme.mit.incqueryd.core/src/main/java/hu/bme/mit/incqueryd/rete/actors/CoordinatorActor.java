package hu.bme.mit.incqueryd.rete.actors;

import static akka.pattern.Patterns.ask;
import hu.bme.mit.incqueryd.arch.ArchUtil;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorCommand;
import hu.bme.mit.incqueryd.rete.messages.CoordinatorMessage;
import hu.bme.mit.incqueryd.rete.messages.Transformation;
import hu.bme.mit.incqueryd.rete.messages.YellowPages;
import hu.bme.mit.incqueryd.util.EObjectSerializer;
import hu.bme.mit.incqueryd.util.ReteNodeConfiguration;
import infrastructure.Cluster;
import infrastructure.Machine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
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
import arch.Configuration;
import arch.InfrastructureMapping;

public class CoordinatorActor extends UntypedActor {

	protected final boolean remoting;
	protected final String architectureFile;
	protected final Timeout timeout = new Timeout(Duration.create(14400, "seconds"));
	protected ActorRef productionActorRef;
	protected String query;
	protected boolean debug = false;
	protected Set<Tuple> latestResults;

	public CoordinatorActor(final String architectureFile, final boolean remoting) {
		super();
		this.architectureFile = architectureFile;
		this.remoting = remoting;

		if (architectureFile.contains("poslength")) {
			query = "PosLength";
		}
		if (architectureFile.contains("routesensor")) {
			query = "RouteSensor";
		}
		if (architectureFile.contains("signalneighbor")) {
			query = "SignalNeighbor";
		}
		if (architectureFile.contains("switchsensor")) {
			query = "SwitchSensor";
		}
	}

	public void start() throws Exception {
		final Configuration conf = ArchUtil.loadConfiguration(architectureFile);
		processConfiguration(conf);
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

	private void processConfiguration(final Configuration conf) throws Exception {
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
			final Machine machine = mapping.getTargetElement();

			final EList<ReteNodeRecipe> mappedElements = mapping.getMappedElements();
			for (final ReteNodeRecipe reteNodeRecipe : mappedElements) {
				recipeToIp.put(reteNodeRecipe, machine.getIp());
			}
		}
	}

	private void fillEmfUriToActorRef() {
		for (final Entry<String, ReteNodeRecipe> emfUriAndRecipe : emfUriToRecipe.entrySet()) {
			final String emfUri = emfUriAndRecipe.getKey();
			final ReteNodeRecipe recipe = emfUriAndRecipe.getValue();

			final ActorRef akkaUri = recipeToActorRef.get(recipe);

			emfUriToActorRef.put(emfUri, akkaUri);

			if (debug)
				System.err.println("EMF URI: " + emfUri + ", Akka URI: " + akkaUri + ", traceInfo "
						+ ArchUtil.oneLiner(recipe.getTraceInfo()));
		}

		if (debug)
			System.err.println();
	}

	/**
	 * Phase 1
	 * 
	 * @param conf
	 * @throws Exception
	 */
	private void deployActors(final Configuration conf) throws Exception {
		final Cluster cluster = conf.getClusters().get(0);
		final EList<Machine> cacheMachines = cluster.getCacheMachines();
		
		final Collection<String> cacheMachineIps = new HashSet<>(); 
		for (final Machine machine : cacheMachines) {
			cacheMachineIps.add(machine.getIp());
		}
		
		for (final ReteRecipe rr : conf.getReteRecipes()) {
			for (final ReteNodeRecipe rnr : rr.getRecipeNodes()) {
				if (debug)
					System.err.println("[TestKit] Recipe: " + rnr.getClass().getName());

				final String ipAddress = recipeToIp.get(rnr);
				final String emfUri = EcoreUtil.getURI(rnr).toString();
				if (debug)
					System.err.println("[TestKit] - IP address:  " + ipAddress);
				if (debug)
					System.err.println("[TestKit] - EMF address: " + emfUri);
				emfUriToRecipe.put(emfUri, rnr);

				// create a clone, else we would get a java.util.ConcurrentModificationException
				final ReteNodeRecipe rnrClone = EcoreUtil.copy(rnr);
				final String recipeString = EObjectSerializer.serializeToString(rnrClone);

				final Props props;
				if (remoting) {
					props = new Props(ReteActor.class).withDeploy(new Deploy(new RemoteScope(new Address("akka",
							IncQueryDMicrokernel.ACTOR_SYSTEM_NAME, ipAddress, 2552))));
				} else {
					props = new Props(ReteActor.class);
				}
				final ActorRef actorRef = getContext().actorOf(props);

				configure(actorRef, recipeString, cacheMachineIps);

				actorRefs.add(actorRef);
				recipeToActorRef.put(rnr, actorRef);

				if (rnr instanceof ProductionRecipe) {
					productionActorRef = actorRef;
				}

				if (debug)
					System.err.println("[TestKit] Actor configured.");
				if (debug)
					System.err.println();
			}

		}
		if (debug)
			System.err.println("[ReteActor] All actors deployed and configured.");
		if (debug)
			System.err.println();
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
			Await.result(future, timeout.duration());
		}

		if (debug)
			System.err.println();
		if (debug)
			System.err.println();

		for (final Entry<String, ActorRef> entry : yellowPages.getEmfUriToActorRef().entrySet()) {
			if (debug)
				System.err.println(entry);
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

		if (debug)
			System.err.println("<AWAIT>");
		for (final Future<Object> future : futures) {
			if (debug)
				System.err.println("await for " + future);
			final Object result = Await.result(future, timeout.duration());
			if (debug)
				System.err.println(result);
		}
		if (debug)
			System.err.println("</AWAIT>");
	}

	/**
	 * Phase 4: retrieve the results
	 * 
	 * @return
	 * 
	 * @throws Exception
	 */
	public Set<Tuple> check() throws Exception {
		latestResults = getQueryResults();
		if (debug)
			System.err.println("Results: " + latestResults.size());
		return latestResults;
	}

	/**
	 * Phase 5: do the transformation
	 * 
	 * @throws Exception
	 */
	public void transform() throws Exception {
		final long start = System.nanoTime();

		for (final Entry<ReteNodeRecipe, ActorRef> entry : recipeToActorRef.entrySet()) {
			final ReteNodeRecipe recipe = entry.getKey();
			if (recipe instanceof UniquenessEnforcerRecipe) {
				final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) recipe;

				final ActorRef actorRef = entry.getValue();

				switch (query) {
				case "PosLength":
					if (uer.getTraceInfo().contains("Segment")) {
						final Transformation transformation = new Transformation(latestResults, query);
						final Future<Object> future = ask(actorRef, transformation, timeout);
						Await.result(future, timeout.duration());
					}
					break;
				case "RouteSensor":
					if (uer.getTraceInfo().contains("TrackElement_sensor")) {
						final Transformation transformation = new Transformation(latestResults, query);
						final Future<Object> future = ask(actorRef, transformation, timeout);
						Await.result(future, timeout.duration());
					}
					break;
				case "SignalNeighbor":
					if (uer.getTraceInfo().contains("Route_exit")) {
						final Transformation transformation = new Transformation(latestResults, query);
						final Future<Object> future = ask(actorRef, transformation, timeout);
						Await.result(future, timeout.duration());
					}
					break;
				case "SwitchSensor":
					if (uer.getTraceInfo().contains("TrackElement_sensor")) {
						final Transformation transformation = new Transformation(latestResults, query);
						final Future<Object> future = ask(actorRef, transformation, timeout);
						Await.result(future, timeout.duration());
					}
					break;
				}
			}
		}
	}

	private Set<Tuple> getQueryResults() throws Exception {
		final Future<Object> queryResultFuture = ask(productionActorRef, CoordinatorMessage.GETQUERYRESULTS, timeout);
		final Set<Tuple> result = (Set<Tuple>) Await.result(queryResultFuture, timeout.duration());
		return result;
	}

	private void configure(final ActorRef actorRef, final String recipeString, final Collection<String> cacheMachineIps) throws Exception {
		final ReteNodeConfiguration conf = new ReteNodeConfiguration(recipeString, cacheMachineIps);
		final Future<Object> future = ask(actorRef, conf, timeout);
		Await.result(future, timeout.duration());
	}

	@Override
	public void onReceive(final Object message) throws Exception {
		if (message == CoordinatorCommand.START) {
			start();
			getSender().tell(CoordinatorMessage.DONE, getSelf());
		} else if (message == CoordinatorCommand.CHECK) {
			final List<Tuple> results = new ArrayList<>(check());
			getSender().tell(results, getSelf());
		} else if (message == CoordinatorCommand.TRANSFORM) {
			transform();
			getSender().tell(CoordinatorMessage.DONE, getSelf());
		}
	}

}
