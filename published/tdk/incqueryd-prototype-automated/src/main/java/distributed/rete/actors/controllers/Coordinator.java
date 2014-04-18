package distributed.rete.actors.controllers;

import hu.bme.mit.train.util.BenchmarkResult;
import infrastructure.InfrastructureNode;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;

import akka.actor.ActorPath;
import akka.actor.Address;
import akka.actor.Deploy;
import akka.actor.Props;
import akka.remote.RemoteScope;
import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

import com.thinkaurelius.faunus.tinkerpop.gremlin.FaunusGremlinScriptEngineFactory;
import com.thinkaurelius.faunus.tinkerpop.gremlin.Imports;

import distributed.rete.actors.ExistenceNode;
import distributed.rete.actors.IncQueryDActor;
import distributed.rete.actors.InputNode;
import distributed.rete.actors.NaturalJoinNode;
import distributed.rete.actors.ProductionNode;
import distributed.rete.actors.messages.CoordinatorMessage;
import distributed.rete.actors.messages.EditMessage;
import distributed.rete.actors.messages.NodeMessage;
import distributed.rete.actors.messages.UpdateMessage;
import distributed.rete.configuration.CoordinatorConfiguration;
import distributed.rete.configuration.IncQueryDConfiguration;
import distributed.rete.configuration.JoinNodeConfiguration;
import distributed.rete.configuration.ProductionNodeConfiguration;
import distributed.rete.configuration.UniquenessEnforcerNodeConfiguration;
import distributed.rete.database.DatabaseClientType;
import distributed.rete.datastructure.JoinSide;
import distributed.rete.datastructure.Tuple;
import distributed.rete.datastructure.TupleMask;

public class Coordinator extends IncQueryDActor {

	// constants
	protected final int editCountTotal = 2;

	// variables
	protected Map<String, ActorContainer> actors = new HashMap<>();
	protected ActorContainer route_routeDefinitionActor;
	protected ActorContainer productionNode;
	protected boolean edited = false;
	protected int editCountRemaining = editCountTotal;
	protected DatabaseClientType databaseClientType;
	protected String filename;

	/**
	 * Coordinator constructor. Instantiates the different actors.
	 */
	public Coordinator() {
		super();
		coordinator = getSelf();
	}

	@Override
	public void onReceive(final Object message) throws Exception {
		super.onReceive(message);

		if (message == NodeMessage.INITIALIZED) {
			initialized(getSender().path());
		}

		else if (message == NodeMessage.DONE) {
			done(getSender().path());
		}

		else if (message instanceof UpdateMessage) {
			final UpdateMessage u = (UpdateMessage) message;
			processResult(u.getTuples());
		}
	}

	protected void done(final ActorPath actorPath) {
		logger.info("Actor done: " + actorPath);

		for (final ActorContainer actorContainer : actors.values()) {
			if (actorContainer.actorRef.path().equals(actorPath)) {
				actorContainer.todo = false;
			}
		}

		boolean todo = false;
		for (final ActorContainer actorContainer : actors.values()) {
			todo |= actorContainer.todo;
		}

		if (!todo) {
			if (edited) {
				logger.info("All actors done, edit propagation completed.");
				BenchmarkResult.INSTANCE.addEditTime();
				BenchmarkResult.INSTANCE.startStopper();
				edited = false;
			} else {
				logger.info("All actors done, initialization completed.");
			}

			logger.info("Retrieving result...");
			productionNode.actorRef.tell(NodeMessage.GETRESULT, getSelf());
		}
	}

	protected void processResult(final Collection<Tuple> collection) {
		final int result = collection.size();
		logger.info("Result size is " + result + ".");

		if (editCountRemaining == 0) {
			logger.info("Edits done.");
			logger.info("Benchmark result is:");
			logger.info(BenchmarkResult.INSTANCE.toString());
			logger.info("Benchmark finished, exiting.");
			try {
				Thread.sleep(500);
			} catch (final InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}

		// initiate edit phase
		BenchmarkResult.INSTANCE.addCheckTime();
		BenchmarkResult.INSTANCE.addInvalid(result);
		BenchmarkResult.INSTANCE.startStopper();

		final EditMessage editMessage = new EditMessage();
		editCountRemaining--;
		logger.info(editCountRemaining + " edits left.");
		route_routeDefinitionActor.todo = true;
		route_routeDefinitionActor.actorRef.tell(editMessage, getSelf());
		edited = true;
	}

	protected void initialized(final ActorPath actorPath) {
		logger.info("Received initialized from " + actorPath);

		final String path1 = actorPath.name();
		final String[] splitted1 = path1.split("/");
		final String actorName1 = splitted1[splitted1.length - 1];

		for (final ActorContainer actorContainer : actors.values()) {
			final String path2 = actorContainer.actorRef.path().name();
			final String[] splitted2 = path2.split("/");
			final String actorName2 = splitted2[splitted2.length - 1];

			// if (actorContainer.actorRef.path().equals(actorPath)) {
			if (actorName1.equals(actorName2)) {
				actorContainer.initialized = true;
			}
		}

		boolean allInitialized = true;
		for (final ActorContainer actorContainer : actors.values()) {
			allInitialized &= actorContainer.initialized;
		}

		if (allInitialized) {
			logger.info("All initialized.");

			for (final ActorContainer actorContainer : actors.values()) {
				if (actorContainer.startSignal) {
					logger.info("Starting actor: " + actorContainer.actorRef);
					actorContainer.todo = true;
					actorContainer.actorRef.tell(CoordinatorMessage.START, getSelf());
				}
			}
		}
	}

	protected void routeSensor() {
		final String recipeFilename = "/home/szarnyasg/routeSensor.arch";
		traverseRecipe(recipeFilename);
		
	}

	protected void deployActors() {
		for (final Map.Entry<String, ActorContainer> actorContainerPair : actors.entrySet()) {

			final String name = actorContainerPair.getKey();
			final ActorContainer actor = actorContainerPair.getValue();

			final String host = actor.host;
			final Class actorClass = actor.actorClass;
			final Address addr = new Address("akka", "ReteNet", host, 2552);
			final Deploy deploy = new Deploy(new RemoteScope(addr));
			logger.info("Deploying " + name + " to " + host);
			// final ActorRef actor = system.actorOf(new Props(actorClass).withDeploy(deploy), name);

			// saving the reference for later use
			actor.actorRef = getContext().actorOf(new Props(actorClass).withDeploy(deploy), name);
		}
	}

	private void configureActors() {
		// telling the configuration object to each actor
		for (final ActorContainer actor : actors.values()) {
			System.out.println("Configuring: " + actor);
			actor.actorRef.tell(actor.configuration, null);
		}
	}

	@Override
	protected void configure(final IncQueryDConfiguration incQueryDConfiguration) {
		final CoordinatorConfiguration conf = (CoordinatorConfiguration) incQueryDConfiguration;

		this.filename = conf.filename;
		this.databaseClientType = conf.databaseClientType;

		// System.out.println("conf: " + filename + ", " + databaseClientType);
		routeSensor();
	}

	public void listHdfs() throws ScriptException {
		System.out.println("<listHdfs>");

		// import everything the Gremlin shell does
		String script = "";
		for (final String importName : Imports.getImports()) {
			script += "import " + importName + ";\n";
		}
		script += ""
				+ "hdfs = FileSystem.get(new Configuration());\n"
				+ "hdfs.ls();\n";

		final FaunusGremlinScriptEngineFactory factory = new FaunusGremlinScriptEngineFactory();
		final ScriptEngine engine = factory.getScriptEngine();

		@SuppressWarnings("unchecked")
		final ArrayList<String> files = (ArrayList<String>) engine.eval(script);

		for (final String file : files) {
			System.out.println(file);
		}
		System.out.println("</listHdfs>");
	}

	protected void traverseRecipe(final String recipeFilename) {

		final Map<ReteNodeRecipe, String> names = new HashMap<>();
		final Map<ReteNodeRecipe, ReteNodeRecipe> children = new HashMap<>();
		final Map<ReteNodeRecipe, JoinSide> childrenSides = new HashMap<>();

		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());
		// initialize package registry
		ArchPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		RecipesPackage.eINSTANCE.eClass();

		// load resource
		final ResourceSet rs = new ResourceSetImpl();
		final Resource res = rs.getResource(URI.createFileURI(recipeFilename), true);

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

			// ------------------------------------------------------------------------------------------------------------------
			// first iteration
			// ------------------------------------------------------------------------------------------------------------------
			for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
				System.out.println("Processing rete recipe " + rc.toString());

				int n = 0;
				for (final ReteNodeRecipe r : rc.getRecipeNodes()) {

					n++;
					final String name = "ReteNode" + n;
					names.put(r, name);

					// System.out.println(r.getTraceInfo());

					final String address = ips.get(r);

					// Beta recipes: natural join and antijoin
					if (r instanceof BetaRecipe) {
						System.out.println("- BetaRecipe");
						System.out.println("# address: " + address);

						if (r instanceof ExistenceJoinRecipe) {
							final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
							System.out.println("  - ExistenceJoinRecipe: " + ejr);

							// joinnode's start signal is set to false
							actors.put(name, new ActorContainer(false, address, ExistenceNode.class));
						}

						if (r instanceof JoinRecipe) {
							final JoinRecipe jr = (JoinRecipe) r;
							System.out.println("  - JoinRecipe: " + jr);

							// joinnode's start signal is set to false
							actors.put(name, new ActorContainer(false, address, NaturalJoinNode.class));
						}

						final BetaRecipe br = (BetaRecipe) r;
						
						final ReteNodeRecipe leftGrandParent = br.getLeftParent().getParent();
						final ReteNodeRecipe rightGrandParent = br.getRightParent().getParent();

						final ReteNodeRecipe leftAncestor = getDistributedAncestor(leftGrandParent);
						final ReteNodeRecipe rightAncestor = getDistributedAncestor(rightGrandParent);

						children.put(leftAncestor, br);
						childrenSides.put(leftAncestor, JoinSide.PRIMARY);
						System.out.println("    LEFT> " + leftAncestor);
						System.out.println("    # address: " + ips.get(leftAncestor));
						children.put(rightAncestor, br);
						childrenSides.put(rightAncestor, JoinSide.SECONDARY);
						System.out.println("    RIGHT> " + rightAncestor);
						System.out.println("    # address: " + ips.get(rightAncestor));
					}

					// Input recipes
					if (r instanceof InputRecipe) {
						final InputRecipe ir = (InputRecipe) r;
						System.out.println("- InputRecipe: " + ir);
						System.out.println("# address: " + address);

						// inputnode's start signal is set to true
						final ActorContainer actor = new ActorContainer(true, address, InputNode.class);
						actors.put(name, actor);

						if (ir.getTypeIdentifier().equals("Route_routeDefinition")) {
							route_routeDefinitionActor = actor;
						}
					}

					// Production recipes
					if (r instanceof ProductionRecipe) {

						if (address != null) {
							final ProductionRecipe pr = (ProductionRecipe) r;
							System.out.println("- ProductionRecipe: " + pr);
							System.out.println("# address: " + address);

							final TrimmerRecipe tr = (TrimmerRecipe) pr.getParents().get(0);
							// final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) tr.getParent();
							// final ReteNodeRecipe ancestor = uer.getParents().get(0);

							children.put(tr.getParent(), r);

							// joinnode's start signal is set to false
							final ActorContainer actor = new ActorContainer(false, address, ProductionNode.class);
							actors.put(name, actor);

							productionNode = actor;
						}
					}

				}

				deployActors();
				System.out.println("### deployed");

			}

			// emitting actorContainers
			for (final Map.Entry<String, ActorContainer> actorEntry : actors.entrySet()) {
				System.out.println(actorEntry.getKey());
				System.out.println(actorEntry.getValue());
			}

			// emitting children
			for (final Map.Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
				final String key = names.get(entry.getKey());
				final String value = names.get(entry.getValue());

				System.out.println(key + " --> " + value);
			}

			// emitting children with class names
			for (final Map.Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
				final String key = names.get(entry.getKey());
				final String value = names.get(entry.getValue());

				System.out.println(key + " " + entry.getKey().getClass() + " --> " + value + " " + entry.getValue().getClass());
			}

			// ------------------------------------------------------------------------------------------------------------------
			// second iteration
			// ------------------------------------------------------------------------------------------------------------------
			for (final ReteRecipe rc : ((Configuration) o).getReteRecipes()) {
				System.out.println("Processing rete recipe " + rc.toString());

				final int n = 0;
				for (final ReteNodeRecipe r : rc.getRecipeNodes()) {

					final String address = ips.get(r);

					// Beta recipes: natural join and antijoin
					if (r instanceof BetaRecipe) {
						System.out.println("- BetaRecipe");
						System.out.println("# address: " + address);

						final String name = names.get(r);
						final ReteNodeRecipe childRecipe = children.get(r);
						final String childName = names.get(childRecipe);

						//System.out.println("name: " + name + " childrenname : " + childName);

						final BetaRecipe br = (BetaRecipe) r;

						final ArrayList<Integer> leftMaskList = extractMask(br.getLeftParent());
						final ArrayList<Integer> rightMaskList = extractMask(br.getRightParent());

						System.out.println(leftMaskList);
						System.out.println(rightMaskList);

						// JoinNode: JoinNode1
						final TupleMask leftMask = new TupleMask(leftMaskList, null); // [Sp], Sw
						final TupleMask rightMask = new TupleMask(rightMaskList, null); // R, [Sp]
						
						System.out.println("left mask: " + leftMaskList);
						System.out.println("right mask: " + rightMaskList);
						
						final JoinSide childJoinSide = childrenSides.get(r);
						System.out.println("child name: " + childName + ", join side: " + childJoinSide);
						
						final JoinNodeConfiguration joinNodeConfiguration = new JoinNodeConfiguration(coordinator, leftMask, rightMask,
								actors.get(childName).actorRef.path().toString(), childJoinSide);
						
						
						actors.get(name).configuration = joinNodeConfiguration;
						System.out.println("---");
						
						
						//
						// if (r instanceof ExistenceJoinRecipe) {
						// final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) r;
						// System.out.println("  - ExistenceJoinRecipe: " + ejr);
						//
						// }
						//
						// if (r instanceof JoinRecipe) {
						// final JoinRecipe jr = (JoinRecipe) r;
						// System.out.println("  - JoinRecipe: " + jr);
						//
						// }

					}

					// Input recipes
					if (r instanceof InputRecipe) {
						final InputRecipe ir = (InputRecipe) r;
						
						final ReteNodeRecipe childRecipe = children.get(ir);
						final String childName = names.get(childRecipe);

						final JoinSide childJoinSide = childrenSides.get(r);
						System.out.println("child name: " + childName + ", join side: " + childJoinSide);
						
						final String label = ir.getTypeIdentifier();
						final UniquenessEnforcerNodeConfiguration config = new UniquenessEnforcerNodeConfiguration(
								coordinator, actors.get(childName).actorRef.path().toString(),
								label, childJoinSide, databaseClientType, filename);
						final String actorName = names.get(ir);
						actors.get(actorName).configuration = config;
					}

					// Production recipes
					if (r instanceof ProductionRecipe) {

						if (address != null) {
							final ProductionRecipe pr = (ProductionRecipe) r;

							final ProductionNodeConfiguration productionNodeConfiguration = new ProductionNodeConfiguration(coordinator);
							final String actorName = names.get(pr);
							actors.get(actorName).configuration = productionNodeConfiguration;
						}
					}
				}
			}

			configureActors();
			System.out.println("### configured");
			
			System.out.println(childrenSides);

		}

	}

	protected ArrayList<Integer> extractMask(final ProjectionIndexer pI) {
		final EList<Integer> eLeftMask = pI.getMask().getSourceIndices();
		final ArrayList<Integer> mask = new ArrayList<>();
		for (final Integer integer : eLeftMask) {
			mask.add(integer);
		}
		return mask;
	}

	protected ReteNodeRecipe getDistributedAncestor(final ReteNodeRecipe recipe) {
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
