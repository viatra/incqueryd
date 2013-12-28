package hu.bme.mit.incqueryd.testbed;

import hu.bme.mit.incqueryd.io.GraphSonLoader;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.rete.dataunits.GraphElement;
import hu.bme.mit.incqueryd.rete.dataunits.ReteNodeSlot;
import hu.bme.mit.incqueryd.rete.dataunits.Tuple;
import hu.bme.mit.incqueryd.rete.dataunits.TupleMask;
import hu.bme.mit.incqueryd.rete.nodes.AlphaNode;
import hu.bme.mit.incqueryd.rete.nodes.AntiJoinNode;
import hu.bme.mit.incqueryd.rete.nodes.BetaNode;
import hu.bme.mit.incqueryd.rete.nodes.InputNode;
import hu.bme.mit.incqueryd.rete.nodes.JoinNode;
import hu.bme.mit.incqueryd.rete.nodes.ReteNode;
import hu.bme.mit.incqueryd.rete.nodes.TrimmerNode;
import infrastructure.InfrastructurePackage;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ExistenceJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.MultiParentNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;
import org.junit.Test;

import arch.ArchPackage;
import arch.Configuration;

/**
 * Testing a pure Java Rete network (without Akka) based on the architecture (arch) descriptor files.
 * 
 * @author szarnyasg
 * 
 */
public class ArchTest {

    private static final ReteNodeRecipe MultiParentNodeRecipe = null;
    // architecture descriptors
    // protected final String archFile = "src/test/resources/switchSensor-quantified.arch";
    protected final String archFile = "src/test/resources/routeSensor-quantified.arch";
    // protected final String archFile = "src/test/resources/routeSensor-quantified-trim-to-route.arch";
    // protected final String archFile = "src/test/resources/routeSensor-vcl.arch";

    // model
    protected final int size = 1;
    protected final String modelFile = "src/test/resources/testBig_User_" + size + ".faunus-graphson";

    // rete node names (for Akka)
    protected final Map<ReteNodeRecipe, String> names = new HashMap<>();

    // vertex type and properties
    protected final Map<String, Collection<String>> vertexTypesAndProperties = new HashMap<>();
    // edge labels
    protected final Collection<String> edgeLabels = new LinkedList<>();

    // the network is defined by parent-children pairs
    protected final Map<ReteNodeRecipe, ReteNodeRecipe> children = new HashMap<>();
    // parent-children's target slot pairs
    protected final Map<ReteNodeRecipe, ReteNodeSlot> childrenSlots = new HashMap<>();

    // rete recipe-rete node pairs
    protected final Map<ReteNodeRecipe, ReteNode> reteNodeForRecipe = new HashMap<>();
    // rete recipe-rete changeset pairs
    protected final Map<ReteNodeRecipe, ChangeSet> reteRecipeChangeSet = new HashMap<>();

    protected Map<String, Set<Tuple>> vertexTuplesMap;
    protected Map<String, Set<Tuple>> edgeTuplesMap;

    @Test
    public void test() throws IOException {
        // initialize extension to factory map
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());
        // initialize package registry
        ArchPackage.eINSTANCE.eClass();
        InfrastructurePackage.eINSTANCE.eClass();
        RecipesPackage.eINSTANCE.eClass();

        // load resource
        final ResourceSet rs = new ResourceSetImpl();
        final Resource res = rs.getResource(URI.createFileURI(archFile), true);

        // traverse model
        final EObject model = res.getContents().get(0);

        if (model instanceof Configuration) {
            final Configuration configuration = (Configuration) model;

            for (final ReteRecipe reteRecipe : configuration.getReteRecipes()) {
                processRecipe(reteRecipe);
            }
        }
    }

    private void processRecipe(final ReteRecipe reteRecipe) throws IOException {
        System.out.println("Processing Rete network recipe " + reteRecipe.toString());

        processRecipeFirst(reteRecipe);

        // loading the graph (based on the UniquenessEnforcerNodes)
        processRecipeLoad();

        System.out.println();
        System.out.println("Topological sort");
        System.out.println("----------------");
        final List<ReteNodeRecipe> sortedReteRecipe = Algorithms.topologicalSort(names.keySet(), children);
        for (final ReteNodeRecipe reteNodeRecipe : sortedReteRecipe) {
            System.out.println(reteNodeRecipe);
        }

        processRecipeSecond(sortedReteRecipe);
    }

    private void processRecipeSecond(final List<ReteNodeRecipe> sortedRecipes) {
        System.out.println();
        System.out.println("Second iteration on the sorted list");
        System.out.println("-----------------------------------");
        for (final ReteNodeRecipe recipe : sortedRecipes) {

            if (recipe instanceof MultiParentNodeRecipe) {
                if (recipe instanceof UniquenessEnforcerRecipe) {
                    final InputNode in = (InputNode) reteNodeForRecipe.get(recipe);
                    System.out.println("in: " + in);

                    Set<Tuple> graphElements = null;

                    switch (in.getGraphElement()) {
                    case NODE:
                        graphElements = vertexTuplesMap.get(in.getType());
                        break;
                    case EDGE:
                        graphElements = edgeTuplesMap.get(in.getType());
                        break;
                    }

                    final ChangeSet changeSet = new ChangeSet(graphElements, ChangeType.POSITIVE);
                    reteRecipeChangeSet.put(recipe, changeSet);

                    System.out.println("edgeLabel: " + changeSet);
                }
            }

            if (recipe instanceof SingleParentNodeRecipe) {
                operateSingleParentNode((SingleParentNodeRecipe) recipe);
            }

            if (recipe instanceof BetaRecipe) {
                operateBetaNode((BetaRecipe) recipe);
            }
        }
    }

    private void processRecipeLoad() throws IOException {
        final GraphSonLoader graphSonLoader = new GraphSonLoader(modelFile, vertexTypesAndProperties, edgeLabels);

        vertexTuplesMap = graphSonLoader.getVertexTuplesMap();
        edgeTuplesMap = graphSonLoader.getEdgeTuplesMap();

        System.out.println("vertex tuples");
        for (final Entry<String, Set<Tuple>> entry : vertexTuplesMap.entrySet()) {
            System.out.println(entry);
        }

        System.out.println("edge tuples");
        for (final Entry<String, Set<Tuple>> entry : edgeTuplesMap.entrySet()) {
            System.out.println(entry);
        }

        for (final Entry<ReteNodeRecipe, ReteNodeRecipe> entry : children.entrySet()) {
            final ReteNodeRecipe key = entry.getKey();
            final ReteNodeRecipe value = entry.getValue();
            System.out.println(key.getClass().getSimpleName() + " ---> " + value.getClass().getSimpleName());
        }

        System.out.println(vertexTypesAndProperties);
        System.out.println(edgeLabels);
    }

    private void processRecipeFirst(final ReteRecipe reteRecipe) {
        System.out.println();
        System.out.println("First iteration");
        System.out.println("---------------");
        // iterating through the Rete network
        int n = 0;
        for (final ReteNodeRecipe reteNodeRecipe : reteRecipe.getRecipeNodes()) {
            // processing the recipe
            // currently only support some recipes
            ReteNode reteNode = null;

            if (reteNodeRecipe instanceof BetaRecipe) {
                reteNode = processBetaRecipe((BetaRecipe) reteNodeRecipe);
            }
            if (reteNodeRecipe instanceof MultiParentNodeRecipe) {
                reteNode = processMultiParentNodeRecipe((MultiParentNodeRecipe) reteNodeRecipe);
            }
            if (reteNodeRecipe instanceof SingleParentNodeRecipe) {
                reteNode = processSingleParentNodeRecipe((SingleParentNodeRecipe) reteNodeRecipe);
            }

            // is the recipe was supported, the reteNode will point to a not null reference
            if (reteNode != null) {
                n++;
                final String name = "ReteNode" + n;
                names.put(reteNodeRecipe, name);

                reteNodeForRecipe.put(reteNodeRecipe, reteNode);
            }
        }
    }

    // methods for Rete node operation
    // -------------------------------
    private void operateSingleParentNode(final SingleParentNodeRecipe spnr) {
        final AlphaNode an = (AlphaNode) reteNodeForRecipe.get(spnr);
        System.out.println("an: " + an);

        final ReteNodeRecipe parent = spnr.getParent();
        final ChangeSet parentChangeSet = reteRecipeChangeSet.get(parent);

        System.out.println("parent's changeset: " + parentChangeSet);

        final ChangeSet resultChangeSet = an.update(parentChangeSet);
        reteRecipeChangeSet.put(spnr, resultChangeSet);

        System.out.println("result changeset: " + resultChangeSet);
    }

    private void operateBetaNode(final BetaRecipe recipe) {
        final BetaRecipe br = recipe;
        final BetaNode bn = (BetaNode) reteNodeForRecipe.get(recipe);
        System.out.println("bn: " + bn);

        final ReteNodeRecipe primaryParentRecipe = br.getLeftParent().getParent();
        final ReteNodeRecipe secondaryParentRecipe = br.getRightParent().getParent();

        final ChangeSet primaryParentChangeSet = reteRecipeChangeSet.get(primaryParentRecipe);
        final ChangeSet secondaryParentChangeSet = reteRecipeChangeSet.get(secondaryParentRecipe);

        bn.update(secondaryParentChangeSet, ReteNodeSlot.SECONDARY);
        final ChangeSet changeSet = bn.update(primaryParentChangeSet, ReteNodeSlot.PRIMARY);

        System.out.println("result changeset: " + changeSet);
        reteRecipeChangeSet.put(br, changeSet);
    }

    // methods for Rete recipe processing
    // ----------------------------------
    private ReteNode processSingleParentNodeRecipe(final SingleParentNodeRecipe recipe) {
        ReteNode reteNode = null;

        // adding reverse reference to the children
        children.put(recipe.getParent(), recipe);

        // Trimmer recipes
        if (recipe instanceof TrimmerRecipe) {
            System.out.println("- Trimmer recipe");

            final TrimmerRecipe tr = (TrimmerRecipe) recipe;
            final EList<Integer> projectionMask = tr.getMask().getSourceIndices();
            System.out.println("Mask: " + projectionMask);

            final TupleMask tupleMask = new TupleMask(projectionMask);
            reteNode = new TrimmerNode(tupleMask);
        }
        return reteNode;
    }

    private ReteNode processMultiParentNodeRecipe(final MultiParentNodeRecipe recipe) {
        ReteNode reteNode = null;

        // adding reverse reference to the children
        // not adding inverse reference in this implementation
        // UniquenessEnforcer recipes
        if (recipe instanceof UniquenessEnforcerRecipe) {
            System.out.println("- UniquenessEnforcer recipe");

            final UniquenessEnforcerRecipe uer = (UniquenessEnforcerRecipe) recipe;

            // traceInfo looks something like "UniquenessEnforcerNode : Route_routeDefinition :  [0]"
            final String traceInfo = uer.getTraceInfo();
            // extracting the type information from the traceInfo
            // TODO add a separate field for this to the architecture's Xcore file
            final String patternString = ": (\\w*) :";

            final Pattern pattern = Pattern.compile(patternString);
            final Matcher m = pattern.matcher(traceInfo);
            String edgeLabel;
            if (m.find()) {
                edgeLabel = m.group(1);
            } else {
                throw new RuntimeException("Invalid UniquenessEnforcerRecipe");
            }

            edgeLabels.add(edgeLabel);
            reteNode = new InputNode(edgeLabel, GraphElement.EDGE);
        }

        return reteNode;
    }

    private ReteNode processBetaRecipe(final BetaRecipe recipe) {
        ReteNode reteNode = null;

        System.out.println("- Beta recipe");

        // extract indexer masks
        final TupleMask primaryMask = new TupleMask(recipe.getLeftParent().getMask().getSourceIndices());
        final TupleMask secondaryMask = new TupleMask(recipe.getRightParent().getMask().getSourceIndices());
        System.out.println("  primary mask: " + primaryMask.getMask() + ", secondary mask: " + secondaryMask.getMask());

        // Rete node parents
        final ReteNodeRecipe primaryParent = recipe.getLeftParent().getParent();
        final ReteNodeRecipe secondaryParent = recipe.getRightParent().getParent();

        // adding reverse references to the children
        children.put(primaryParent, recipe);
        childrenSlots.put(primaryParent, ReteNodeSlot.PRIMARY);

        children.put(secondaryParent, recipe);
        childrenSlots.put(secondaryParent, ReteNodeSlot.SECONDARY);

        // join
        if (recipe instanceof JoinRecipe) {
            final JoinRecipe jr = (JoinRecipe) recipe;
            System.out.println("  - Join recipe");

            reteNode = new JoinNode(primaryMask, secondaryMask);
        }

        // antijoin
        if (recipe instanceof ExistenceJoinRecipe) {
            final ExistenceJoinRecipe ejr = (ExistenceJoinRecipe) recipe;
            System.out.println("  - ExistenceJoin recipe");

            reteNode = new AntiJoinNode(primaryMask, secondaryMask);
        }
        return reteNode;
    }

    // protected ArrayList<Integer> extractMask(final ProjectionIndexer pI) {
    // final EList<Integer> eLeftMask = pI.getMask().getSourceIndices();
    // final ArrayList<Integer> mask = new ArrayList<>();
    // for (final Integer integer : eLeftMask) {
    // mask.add(integer);
    // }
    // return mask;
    // }

    // protected void deployActors() {
    // for (final Map.Entry<String, ActorContainer> actorContainerPair : actors.entrySet()) {
    //
    // final String name = actorContainerPair.getKey();
    // final ActorContainer actor = actorContainerPair.getValue();
    //
    // final String host = actor.host;
    // final Class actorClass = actor.actorClass;
    // final Address addr = new Address("akka", "ReteNet", host, 2552);
    // final Deploy deploy = new Deploy(new RemoteScope(addr));
    // // logger.info("Deploying " + name + " to " + host);
    // // final ActorRef actor = system.actorOf(new Props(actorClass).withDeploy(deploy), name);
    //
    // // saving the reference for later use
    // // actor.actorRef = getContext().actorOf(new Props(actorClass).withDeploy(deploy), name);
    // // TODO fix this
    // }
    // }

    // private void configureActors() {
    // // telling the configuration object to each actor
    // for (final ActorContainer actor : actors.values()) {
    // System.out.println("Configuring: " + actor);
    // actor.actorRef.tell(actor.configuration, null);
    // }
    // }

}
