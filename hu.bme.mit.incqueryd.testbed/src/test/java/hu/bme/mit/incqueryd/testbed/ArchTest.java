package hu.bme.mit.incqueryd.testbed;

import static org.junit.Assert.assertTrue;
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
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.junit.Test;

import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;

public class ArchTest {

    // file paths
    protected final int size = 1;
    protected final String modelFile = "src/test/resources/testBig_User_" + size + ".faunus-graphson";
    protected final String archFile = "src/test/resources/routeSensor-untouched.arch";
    
    @Test
    public void testApp() {
        assertTrue(true);

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
            
            System.out.println(ips);

        }

    }
}
