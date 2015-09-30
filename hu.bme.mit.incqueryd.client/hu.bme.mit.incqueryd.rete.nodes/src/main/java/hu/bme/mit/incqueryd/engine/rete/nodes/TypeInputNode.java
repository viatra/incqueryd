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
import org.openrdf.model.Resource;
import org.openrdf.model.Value;

import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import eu.mondo.driver.graph.RDFGraphDriverRead;

public class TypeInputNode implements ReteNode {

	public static final String VERTEX = "vertex";
	public static final String EDGE = "edge";
	public static final String ATTRIBUTE = "attribute";

	protected final TypeInputRecipe recipe;

	public TypeInputRecipe getRecipe() {
		return recipe;
	}

	protected Set<Tuple> tuples = new HashSet<>();
	protected final RDFGraphDriverRead driver;

	TypeInputNode(final TypeInputRecipe recipe, RDFGraphDriverRead driver) {
		super();
		this.recipe = recipe;
		this.driver = driver;
	}
	
	public void load() throws IOException {
		String typeName = recipe.getTypeName();

		if (recipe instanceof UnaryInputRecipe) {
			initializeVertex(typeName);
		} else if (recipe instanceof BinaryInputRecipe) {
			String traceInfo = recipe.getTraceInfo();
			if (traceInfo.startsWith(ATTRIBUTE)) {
				initializeProperty(typeName);
			} else if (traceInfo.startsWith(EDGE)) {
				initializeEdge(typeName);
			}
		}
	}
	
	public void update(ChangeSet changeSet) {
		switch(changeSet.getChangeType()) {
			case POSITIVE:
				tuples.addAll(changeSet.getTuples());
				break;
			case NEGATIVE:
				tuples.removeAll(changeSet.getTuples());
				break;
		}
	}
	
	public ChangeSet filter(Predicate<Tuple> predicate) {
		Set<Tuple> remainingTuples = Sets.newHashSet(Sets.filter(tuples, predicate));
		Set<Tuple> removedTuples = Sets.newHashSet(Sets.difference(tuples, remainingTuples));
		tuples = remainingTuples;
		return new ChangeSet(removedTuples, ChangeType.NEGATIVE);
	}

	private void initializeEdge(final String typeName) throws IOException {
		Multimap<Resource, Resource> edges = driver.collectEdges(typeName);

		for (Entry<Resource, Resource> edge : edges.entries()) {
			tuples.add(new Tuple(edge.getKey().stringValue(), edge.getValue().stringValue()));
		}
	}

	private void initializeProperty(final String typeName) throws IOException {
		Multimap<Resource, Value> properties = driver.collectProperties(typeName);

		for (Entry<Resource, Value> property : properties.entries()) {
			tuples.add(new Tuple(property.getKey().stringValue(), property.getValue().stringValue()));
		}
	}

	private void initializeVertex(final String typeName) throws IOException {
		List<Resource> vertices = driver.collectVertices(typeName);
		
		for (Resource vertex : vertices) {
			tuples.add(new Tuple(vertex.stringValue()));
		}
	}

	public Set<Tuple> getTuples() {
		return tuples;
	}
	
	public ChangeSet getChangeSetFromCurrentState() {
		return new ChangeSet(tuples, ChangeType.POSITIVE);
	}

}
