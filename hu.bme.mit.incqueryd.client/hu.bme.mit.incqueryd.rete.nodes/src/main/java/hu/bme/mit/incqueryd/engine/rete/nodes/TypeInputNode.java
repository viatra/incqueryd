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
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.incquery.runtime.rete.recipes.BinaryInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TypeInputRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UnaryInputRecipe;
import org.openrdf.rio.RDFHandlerException;
import org.openrdf.rio.RDFParseException;

import com.google.common.collect.Multimap;

import eu.mondo.driver.file.FileGraphDriverRead;
import eu.mondo.driver.graph.RDFGraphDriverRead;

public class TypeInputNode implements ReteNode {

	final String connectionString = getClass().getClassLoader().getResource("models/railway-xform-1.ttl").toString();

	protected final TypeInputRecipe recipe;

	protected Set<Tuple> tuples = new HashSet<>();
	protected RDFGraphDriverRead driver;

	TypeInputNode(final TypeInputRecipe recipe) {
		super();
		this.recipe = recipe;
	}

	public void load() throws IOException {
		try {
			driver = new FileGraphDriverRead(connectionString);
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
		Multimap<Long, Long> edges = driver.collectEdges(typeName);

		for (Entry<Long, Long> edge : edges.entries()) {
			tuples.add(new Tuple(edge.getKey(), edge.getValue()));
		}
	}

	private void initializeProperty(final String typeName) throws IOException {
		Multimap<Long, Object> properties = driver.collectProperties(typeName);

		for (Entry<Long, Object> property : properties.entries()) {

			Object attribute = property.getValue();
			
			tuples.add(new Tuple(property.getKey(), attribute));
		}
	}

	private void initializeVertex(final String typeName) throws IOException {
		List<Long> vertices = driver.collectVertices(typeName);
		
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
