package hu.bme.mit.incqueryd.arch.util;

import infrastructure.InfrastructurePackage;
import inventory.Inventory;
import inventory.InventoryPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;

import arch.ArchPackage;
import arch.Configuration;

public class ArchUtil {

	/**
	 * Extract the type name from the trace info.
	 * 
	 * @param traceInfo
	 * @return
	 */
	public static String extractType(final String traceInfo) {
		final Pattern pattern = Pattern.compile(".*: (.*?) :.*");
		final Matcher matcher = pattern.matcher(traceInfo);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "";
		}
	}

	public static boolean hasAttribute(final String traceInfo) {
		final Pattern pattern = Pattern.compile(".* \\[(.*?)\\].*");
		final Matcher matcher = pattern.matcher(traceInfo);
		return matcher.find();
	}

	public static String extractAttribute(final String traceInfo) {
		final Pattern pattern = Pattern.compile(".* \\[(.*?)\\].*");
		final Matcher matcher = pattern.matcher(traceInfo);
		if (matcher.find()) {
			return matcher.group(1);
		} else {
			return "";
		}
	}

	/**
	 * Cut the proxy's name from the EMF URI.
	 * 
	 * @param emfUri
	 * @return
	 */
	public static String cutProxyName(final String emfUri) {
		final Pattern pattern = Pattern.compile(".*json#(.*)");
		final Matcher matcher = pattern.matcher(emfUri);
		if (matcher.matches()) {
			// for relative URIs
			return matcher.group(1);
		} else {
			// for absoluti URIs
			return emfUri;
		}
	}

	public static String getJsonEObjectUri(final EObject eObject) {
		final URI uri = EcoreUtil.getURI(eObject);
		return cutProxyName(uri.toString());
	}

	public static Configuration loadConfiguration(final File architectureFile) throws IOException {
		final Resource resource = loadModel(architectureFile);

		final EObject o = resource.getContents().get(0);
		return (Configuration) o;
	}

	public static Inventory loadInventory(final File inventoryFile) throws IOException {
		final Resource resource = loadModel(inventoryFile);

		final EObject o = resource.getContents().get(0);
		return (Inventory) o;
	}

	public static ReteRecipe loadRecipe(final String recipeFile) throws IOException {
		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("recipe", new XMIResourceFactoryImpl());

		// initialize package registry
		// initialize the RecipesPackage before the others
		RecipesPackage.eINSTANCE.eClass();

		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.getResource(URI.createFileURI(recipeFile), true);
		EcoreUtil.resolveAll(resource);

		final EObject o = resource.getContents().get(0);
		return (ReteRecipe) o;
	}

	public static List<String> getRecipePaths(final File architectureFile) {
		final Resource resource = loadModel(architectureFile);

		final List<String> paths = new ArrayList<>();
		final EList<Resource> resources = resource.getResourceSet().getResources();
		for (final Resource res : resources) {
			final String path = res.getURI().path();
			if (path.toLowerCase().endsWith(".recipe")) {
				paths.add(path);
			}
		}
		return paths;
	}

	protected static Resource loadModel(final File architectureFile) {
		// initialize extension to factory map
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("arch", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("recipe", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("inventory", new XMIResourceFactoryImpl());

		// initialize package registry
		// initialize the RecipesPackage before the others
		RecipesPackage.eINSTANCE.eClass();
		InfrastructurePackage.eINSTANCE.eClass();
		ArchPackage.eINSTANCE.eClass();
		InventoryPackage.eINSTANCE.eClass();

		final ResourceSet resourceSet = new ResourceSetImpl();
		final Resource resource = resourceSet.getResource(URI.createFileURI(architectureFile.getAbsolutePath()), true);
		EcoreUtil.resolveAll(resource);
		return resource;
	}

}
