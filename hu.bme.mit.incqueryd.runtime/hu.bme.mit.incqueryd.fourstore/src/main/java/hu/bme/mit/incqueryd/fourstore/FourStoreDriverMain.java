package hu.bme.mit.incqueryd.fourstore;

import hu.bme.mit.bigmodel.fourstore.FourStoreClient;
import hu.bme.mit.incqueryd.arch.util.ArchUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.InputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;

import arch.Configuration;
import arch.InfrastructureMapping;
import arch.ReteRole;
import arch.Role;

import com.google.common.collect.Multimap;

public class FourStoreDriverMain {
	public static void main(final String[] args) throws IOException {
		final String architectureDirectory = "/home/szarnyasg/git/incqueryd/hu.bme.mit.incqueryd.queries/arch/";
		
		load(architectureDirectory + "posLength.arch");
		load(architectureDirectory + "routeSensor.arch");
	}

	private static void load(final String architectureFile) throws IOException {
		final Configuration conf = ArchUtil.loadConfiguration(architectureFile);
		
		System.out.println(conf);
		
		final String connectionString = conf.getConnectionString();
		final String[] connectionStringSplit = connectionString.split("://");
		final String clusterName = connectionStringSplit[1];
		
		System.out.println("Cluster name: " + clusterName);
		final EList<InfrastructureMapping> mappings = conf.getMappings();
		
		final String ontologyIri = "http://www.semanticweb.org/ontologies/2011/1/TrainRequirementOntology.owl";
		final FourStoreClient client = new FourStoreClient(clusterName, ontologyIri); 
		
		for (final InfrastructureMapping mapping : mappings) {
			final EList<Role> roles = mapping.getRoles();
			for (final Role role : roles) {
				if (role instanceof ReteRole) {
					final ReteRole reteRole = (ReteRole) role;
					final ReteNodeRecipe reteNodeRecipe = reteRole.getNodeRecipe();
					
					if (reteNodeRecipe instanceof InputRecipe) {
						final InputRecipe inputRecipe = (InputRecipe) reteNodeRecipe;
						System.out.println(inputRecipe);
						
						final int arity = inputRecipe.getArity();
						System.out.println(arity);

						if (inputRecipe instanceof TypeInputRecipe) {
							final TypeInputRecipe typeInputRecipe = (TypeInputRecipe) inputRecipe;
							
							final String typeName = typeInputRecipe.getTypeName();
							System.out.println(typeName);

							final String[] typeNameSplitted= typeName.split("#");
							final String typeNameSuffix = typeNameSplitted[1];
							System.out.println(typeNameSuffix);
							
							if (typeInputRecipe instanceof UnaryInputRecipe) {
								final UnaryInputRecipe unaryInputRecipe = (UnaryInputRecipe) typeInputRecipe;
								System.out.println("unary input recipe");
								
								final List<Long> vertices = client.collectVertices(typeNameSuffix);								
								System.out.println(vertices);
							}

							if (typeInputRecipe instanceof BinaryInputRecipe) {
								final BinaryInputRecipe binaryInputRecipe = (BinaryInputRecipe) typeInputRecipe;
								System.out.println("binary input recipe");
								
								switch (binaryInputRecipe.getTraceInfo()) {
								case "attribute": 
									System.out.println("attribute");
									
									final Map<Long, Integer> attributes = client.collectVerticesWithProperty(typeNameSuffix);								
									System.out.println(attributes);

									break;
								case "edge":
									System.out.println("edge");
									
									final Multimap<Long, Long> edges = client.collectEdges(typeNameSuffix);								
									System.out.println(edges);
									break;
								default:
									throw new UnsupportedOperationException("No traceinfo provided.");
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println();
	}
}
