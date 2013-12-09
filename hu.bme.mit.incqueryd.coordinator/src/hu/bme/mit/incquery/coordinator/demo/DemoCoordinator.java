package hu.bme.mit.incquery.coordinator.demo;

import infrastructure.InfrastructurePackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

import arch.ArchPackage;
import arch.Configuration;

public class DemoCoordinator {

    /**
     * take a look at
     *  - http://wiki.eclipse.org/EMF/FAQ#How_do_I_use_EMF_in_standalone_applications_.28such_as_an_ordinary_main.29.3F
     *  - http://wiki.eclipse.org/EMF/FAQ#I_want_to_use_EMF.2C_SDO.2C_or_XSD_in_my_standalone_project.2C_or_include_only_a_working_subset_of_the_code._What_libraries_.28jar_files.29_do_I_need_in_my_CLASSPATH.3F
     *  
     * create runnable JAR from this project as follows:
     * 1) test the project in your Eclipse, create a Java application run configuration for it.
     * 2) using Export | Runnable Jar, launch the export wizard 
     *  2a) select your run configuration at the top
     *  2b) select "package required libraries..."
     * 3) profit :-)
     * 
     * The JARs in lib were created as follows:
     *  emf: copied from a fresh downloadable EMF runtime package, as per EMF FAR instructions
     *  recipes and arch: export | deployable plug-ins and fragments
     * 
     */
    public static void main(String[] args) {
        // initialize extension to factory map
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());
        // initialize package registry
        ArchPackage.eINSTANCE.eClass();
        InfrastructurePackage.eINSTANCE.eClass();
        RecipesPackage.eINSTANCE.eClass();
        
        // load resource
        ResourceSet rs = new ResourceSetImpl();
        Resource res = rs.getResource(URI.createFileURI(args[0]), true);
        
        // traverse model
        EObject o = res.getContents().get(0);
        if (o instanceof Configuration) {
            for (ReteRecipe rc : ((Configuration)o).getReteRecipes()) {
                System.out.println("Processing rete recipe " + rc.toString());
                for (ReteNodeRecipe r : rc.getRecipeNodes()) {
                    System.out.println("\t"+r.getTraceInfo());
                }
            }
        }
    }

}
