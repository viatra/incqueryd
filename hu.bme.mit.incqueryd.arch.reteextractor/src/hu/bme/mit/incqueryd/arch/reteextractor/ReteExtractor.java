package hu.bme.mit.incqueryd.arch.reteextractor;

import java.io.IOException;
import java.util.logging.Logger;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.rete.boundary.ReteBoundary;
import org.eclipse.incquery.runtime.rete.index.CountNode;
import org.eclipse.incquery.runtime.rete.index.DualInputNode;
import org.eclipse.incquery.runtime.rete.index.ExistenceNode;
import org.eclipse.incquery.runtime.rete.index.GenericProjectionIndexer;
import org.eclipse.incquery.runtime.rete.index.JoinNode;
import org.eclipse.incquery.runtime.rete.index.OuterJoinNode;
import org.eclipse.incquery.runtime.rete.misc.ConstantNode;
import org.eclipse.incquery.runtime.rete.recipes.BetaRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexer;
import org.eclipse.incquery.runtime.rete.recipes.RecipesFactory;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.SingleParentNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;
import org.eclipse.incquery.runtime.rete.single.DefaultProductionNode;
import org.eclipse.incquery.runtime.rete.single.EqualityFilterNode;
import org.eclipse.incquery.runtime.rete.single.InequalityFilterNode;
import org.eclipse.incquery.runtime.rete.single.TrimmerNode;
import org.eclipse.incquery.runtime.rete.single.UniquenessEnforcerNode;
import org.eclipse.incquery.runtime.rete.tuple.TupleMask;
import org.eclipse.incquery.tooling.ui.retevis.views.ZestReteContentProvider;
import org.eclipse.incquery.tooling.ui.retevis.views.ZestReteLabelProvider;

import arch.ArchFactory;
import arch.Configuration;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Utility class to handle Rete extraction.
 * 
 * @author istvanrath
 * 
 */
public class ReteExtractor {

    static Logger log = Logger.getLogger(ReteExtractor.class.getName());
    
    public static void extractReteToFile(ReteBoundary<Pattern> rb, IPath targetPath) {
        // initialize target model
        ResourceSetImpl rs = new ResourceSetImpl();
        Resource res = rs.createResource(URI.createPlatformResourceURI(targetPath.toString(), true));

        // TODO add support for reusing existing containers
        Configuration conf = ArchFactory.eINSTANCE.createConfiguration();
        ReteRecipe cont = RecipesFactory.eINSTANCE.createReteRecipe();
        conf.getReteRecipes().add(cont);
        res.getContents().add(conf);

        ZestReteContentProvider cp = new ZestReteContentProvider();
        ZestReteLabelProvider lp = new ZestReteLabelProvider();
        lp.setRb(rb);
        // extract elements first
        BiMap<Object, Object> mappedReteElements = HashBiMap.create();
        mapReteElements(rb.getHeadContainer(), cp, lp, cont, mappedReteElements);
        // extract connections in the second pass
        for (Object mappedElement : mappedReteElements.keySet()) {
            mapReteConnections(mappedElement, cp, cont, mappedReteElements);
        }

        // save resource
        try {
            res.save(null);
        } catch (IOException e) {
            log.throwing(ReteExtractor.class.getName(), "extractReteToFile" , e);
        }

    }

    static void mapReteElements(Object current, ZestReteContentProvider cp, ZestReteLabelProvider lp, ReteRecipe cont, BiMap<Object, Object> mappedReteElements) {
        if (current != null) {
            ReteNodeRecipe rn = null;
            log.info("Extractor processing " + lp.getText(current));
            if (current instanceof ReteBoundary<?>) {
                // TODO
            }
            /*
            else if (current instanceof Node) {
                //rn = RecipesFactory.eINSTANCE.create();
            }*/
            
            else if (current instanceof TrimmerNode) {
                rn = RecipesFactory.eINSTANCE.createTrimmerRecipe();
                // also map the trimmer's mask
                Mask mask = RecipesFactory.eINSTANCE.createMask();
                TupleMask tm = ((TrimmerNode)current).getMask();
                mask.setSourceArity(tm.indices.length); // TODO this is probably not correct
                for (int i=0; i<tm.indices.length; i++) {
                    mask.getSourceIndices().add(tm.indices[i]);
                }
                ((TrimmerRecipe)rn).setMask(mask);
            }
            
            else if (current instanceof EqualityFilterNode) {
                rn = RecipesFactory.eINSTANCE.createEqualityFilterRecipe();
            }
            else if (current instanceof InequalityFilterNode) {
                rn = RecipesFactory.eINSTANCE.createInequalityFilterRecipe();
            }
            
            else if (current instanceof ConstantNode) {
                rn = RecipesFactory.eINSTANCE.createConstantRecipe();
            }
            
            else if (current instanceof ExistenceNode) {
                rn = RecipesFactory.eINSTANCE.createAntiJoinRecipe();
            }
            else if (current instanceof JoinNode) {
                rn = RecipesFactory.eINSTANCE.createJoinRecipe();
            }
            else if (current instanceof OuterJoinNode) {
                rn = RecipesFactory.eINSTANCE.createSemiJoinRecipe();
            }
            else if (current instanceof CountNode) {
                rn = RecipesFactory.eINSTANCE.createCountAggregatorRecipe();
            }
            
            else if (current instanceof DefaultProductionNode) {
                rn = RecipesFactory.eINSTANCE.createProductionRecipe();
            }
            else if (current instanceof UniquenessEnforcerNode) {
                rn = RecipesFactory.eINSTANCE.createUniquenessEnforcerRecipe();
                // TODO: uniquenessenforcers are (at the moment) input nodes also
                // rn = RecipesFactory.eINSTANCE.createUnaryInputRecipe();
                //rn = RecipesFactory.eINSTANCE.createBinaryInputRecipe();
            }

            else if (current instanceof GenericProjectionIndexer) {
                rn = RecipesFactory.eINSTANCE.createProjectionIndexer();
                // also map the mask
                Mask mask = RecipesFactory.eINSTANCE.createMask();
                TupleMask tm = ((GenericProjectionIndexer)current).getMask();
                mask.setSourceArity(tm.indices.length); // TODO this is probably not correct
                for (int i=0; i<tm.indices.length; i++) {
                    mask.getSourceIndices().add(tm.indices[i]);
                }
                ((ProjectionIndexer)rn).setMask(mask);
            }
            
            else {
                // TODO handle more cases
                log.warning("Encountered unsupported node type: " + current.getClass().getCanonicalName());   
            }
            
            if (rn != null) {
                cont.getRecipeNodes().add(rn);
                rn.setTraceInfo(lp.getText(current));
                mappedReteElements.put(current, rn);
            }
            // traverse further the containment hierarchy
            Object[] initial = cp.getElements(current);
            for (Object _o : initial) {
                mapReteElements(_o, cp, lp, cont, mappedReteElements);
            }
        }
    }

    static void mapReteConnections(Object current, ZestReteContentProvider cp, ReteRecipe cont, BiMap<Object, Object> mappedReteElements) {
        if (current!=null) {
            // traverse along connections
            Object[] targets = cp.getConnectedTo(current);
            if (targets != null) {
                for (Object _t : targets) {
                    // map the connection
                    
                    // Recipes
                    Object curr = mappedReteElements.get(current);
                    Object t = mappedReteElements.get(_t);
                    
                    if (curr!=null && t!=null) {
                        // both exist in the mapped model
                        
                        if (t instanceof ProjectionIndexer && curr instanceof BetaRecipe) {
                            BetaRecipe recipe_beta = (BetaRecipe) curr;
                            ProjectionIndexer recipe_ix = (ProjectionIndexer) t;
                            DualInputNode runtime_beta = (DualInputNode) current;
                            GenericProjectionIndexer runtime_ix = (GenericProjectionIndexer) _t;
                            
                            if (runtime_beta.getPrimarySlot().equals(runtime_ix)) {
                                recipe_beta.setLeftParent(recipe_ix);
                            }
                            else if (runtime_beta.getSecondarySlot().equals(runtime_ix)) {
                                recipe_beta.setRightParent(recipe_ix);
                            }
                            else if (runtime_ix.getParent().equals(runtime_beta)) {
                                recipe_ix.setParent(recipe_beta);
                            }
                            
                            
                        }
                        else if (curr instanceof ProjectionIndexer && t instanceof BetaRecipe) {
                            BetaRecipe recipe_beta = (BetaRecipe) t;
                            ProjectionIndexer recipe_ix = (ProjectionIndexer) curr;
                            DualInputNode runtime_beta = (DualInputNode) _t;
                            GenericProjectionIndexer runtime_ix = (GenericProjectionIndexer) current;
                            
                            if (runtime_beta.getPrimarySlot().equals(runtime_ix)) {
                                recipe_beta.setLeftParent(recipe_ix);
                            }
                            else if (runtime_beta.getSecondarySlot().equals(runtime_ix)) {
                                recipe_beta.setRightParent(recipe_ix);
                            }
                            else if (runtime_ix.getParent().equals(runtime_beta)) {
                                recipe_ix.setParent(recipe_beta);
                            }
                            
                            
                        }
                        
                        else if (t instanceof UniquenessEnforcerRecipe) {
                            ((UniquenessEnforcerRecipe)t).getParents().add( (ReteNodeRecipe) curr);
                        }
                        else if (t instanceof SingleParentNodeRecipe) {
                            ((SingleParentNodeRecipe)t).setParent((ReteNodeRecipe)curr);
                        }
                        else {
                            log.warning("Unsupported edge encountered between " + curr.toString() + " and " + t.toString());
                        }
                    }
                    else {
                        log.warning("Non-mapped node src/trg combo found: " + (curr==null?"src = "+current:"") + "; " + (t==null?"trg = "+_t:""));
                    }
                }
            }
        }
    }
    
}
