package hu.bme.mit.incqueryd.core.rete.nodes;
///*******************************************************************************
// * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// * Gabor Szarnyas - initial API and implementation
// *******************************************************************************/
//package hu.bme.mit.incqueryd.core.rete.nodes;
//
//import hu.bme.mit.bigmodel.fourstore.FourStoreDriverTrainBenchmark;
//import hu.bme.mit.bigmodel.rdf.RDFHelper;
//import hu.bme.mit.incqueryd.core.rete.dataunits.ChangeSet;
//import hu.bme.mit.incqueryd.core.rete.dataunits.Tuple;
//
//import java.io.IOException;
//import java.lang.management.ManagementFactory;
//import java.lang.management.MemoryMXBean;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map.Entry;
//import java.util.Set;
//
//import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
//import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;
//import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
//
//import com.google.common.collect.Multimap;
//
//public class InputNode implements AlphaNode {
//
//	/**
//	 * Input node implementation.
//	 */
//	InputNode(final TypeInputRecipe recipe) {
//		super();
//		typeName = recipe.getTypeName().split("#")[1];
//	}
//
//	protected final Set<Tuple> tuples = new HashSet<>();
//	protected final String typeName;
//
//	public double getMemoryConsumption() {
//		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
//		return memoryMXBean.getHeapMemoryUsage().getUsed() / (1024 * 1024);
//	}
//
//	public Set<Tuple> getTuples() {
//		return tuples;
//	}
//
//	public String getTypeName() {
//		return typeName;
//	}
//
//	@Override
//	public ChangeSet update(final ChangeSet changeSet) {
//		final Set<Tuple> incomingTuples = changeSet.getTuples();
//		switch (changeSet.getChangeType()) {
//		case POSITIVE:
//			tuples.addAll(incomingTuples);
//			break;
//		case NEGATIVE:
//			tuples.removeAll(incomingTuples);
//			break;
//		default:
//			break;
//		}
//
//		return changeSet;
//	}
//
//	// def initializeEdge(databaseDriver: FourStoreDriverTrainBenchmark, recipe: BinaryInputRecipe, tuples:
//	// java.util.Set[Tuple]) = {
//	// val typeName = RDFHelper.brackets(recipe.getTypeName)
//	// val edges = databaseDriver.collectEdges(typeName)
//	//
//	// edges.entries.foreach(edge => {
//	// tuples += new Tuple(edge.getKey, edge.getValue)
//	// })
//	// }
//	//
//	// def initializeVertex(databaseDriver: FourStoreDriverTrainBenchmark, recipe: UnaryInputRecipe, tuples:
//	// java.util.Set[Tuple]) = {
//	// val vertices = databaseDriver.collectVertices(RDFHelper.brackets(recipe.getTypeName))
//	// vertices.foreach(vertex => tuples += new Tuple(vertex))
//	// }
//	//
//	// def initializeAttribute(databaseDriver: FourStoreDriverTrainBenchmark, recipe: BinaryInputRecipe, tuples:
//	// java.util.Set[Tuple]) = {
//	// val typeName = RDFHelper.brackets(recipe.getTypeName)
//	// val attributes = databaseDriver.collectVerticesWithProperty(typeName)
//	//
//	// attributes.foreach(attribute => {
//	// val key = attribute._1
//	// val value = attribute._2
//	//
//	// val regex = "\"(.*?)\"\\^\\^<http://www.w3.org/2001/XMLSchema#int>".r
//	// val intValue = regex.findFirstMatchIn(value).get.group(1)
//	// tuples += new Tuple(key, intValue)
//	// })
//	// }
//
//	void initializeEdge(FourStoreDriverTrainBenchmark driver, BinaryInputRecipe recipe) throws IOException {
//		Multimap<Long, Long> edges = driver.collectEdges(RDFHelper.brackets(recipe.getTypeName()));
//		for (Entry<Long, Long> edge : edges.entries()) {
//			tuples.add(new Tuple(edge.getKey(), edge.getValue()));
//		}
//	}
//
//	void initializeVertex(FourStoreDriverTrainBenchmark driver, UnaryInputRecipe recipe) throws IOException {
//		List<Long> vertices = driver.collectVertices(RDFHelper.brackets(recipe.getTypeName()));
//		for (Long vertex : vertices) {
//			tuples.add(new Tuple(vertex));
//		}
//	}
//
//}
