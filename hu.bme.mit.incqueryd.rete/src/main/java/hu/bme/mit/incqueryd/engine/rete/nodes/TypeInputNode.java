/*******************************************************************************
 * Copyright (c) 2010-2014, Gabor Szarnyas, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Gabor Szarnyas - initial API and implementation
 *******************************************************************************/
package hu.bme.mit.incqueryd.engine.rete.nodes;

import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeSet;
import hu.bme.mit.incqueryd.engine.rete.dataunits.ChangeType;
import hu.bme.mit.incqueryd.engine.rete.dataunits.Tuple;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;

import com.google.common.collect.Multimap;

import eu.mondo.driver.file.FileGraphDriverReadOnly;
import eu.mondo.driver.graph.RDFGraphDriverReadOnly;

public class TypeInputNode implements ReteNode {

	protected final TypeInputRecipe recipe;

	protected Set<Tuple> tuples = new HashSet<>();
	protected RDFGraphDriverReadOnly driver;

	TypeInputNode(final TypeInputRecipe recipe) {
		super();
		this.recipe = recipe;
	}

	public void load() throws IOException {
		String connectionString = "rdf://src/test/resources/models/railway-xform-1.ttl";
		try {
			driver = new FileGraphDriverReadOnly(connectionString);
		} catch (RDFParseException | RDFHandlerException e) {
			throw new IOException(e);
		}

		String typeName = recipe.getTypeName();

		if (recipe instanceof UnaryInputRecipe) {
			initializeVertex(typeName);
		} else if (recipe instanceof BinaryInputRecipe) {
			String traceInfo = recipe.getTraceInfo();
			if (traceInfo.startsWith("attribute")) {
				initializeProperty(typeName);
			} else if (traceInfo.startsWith("edge")) {
				initializeEdge(typeName);
			}
		}
	}

	private void initializeEdge(final String typeName) throws IOException {
		Multimap<Long, Long> edges = driver.collectEdge(typeName);

		for (Entry<Long, Long> edge : edges.entries()) {
			tuples.add(new Tuple(edge.getKey(), edge.getValue()));
		}
	}

	private void initializeProperty(final String typeName) throws IOException {
		Map<Long, String> properties = driver.collectProperty(typeName);

		for (Entry<Long, String> property : properties.entrySet()) {
			tuples.add(new Tuple(property.getKey(), property.getValue()));
		}

	}

	private void initializeVertex(final String typeName) throws IOException {
		List<Long> vertices = driver.collectVertex(typeName);
		
		for (Long vertex : vertices) {
			tuples.add(new Tuple(vertex));
		}
	}

	public Set<Tuple> getTuples() {
		return tuples;
	}
	
	public ChangeSet getChangeSet() {
		return new ChangeSet(tuples, ChangeType.POSITIVE);
	}

}
