/*******************************************************************************
 * Copyright (c) 2004-2014 Gabor Bergmann and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gabor Bergmann - initial API and implementation
 *******************************************************************************/

package org.eclipse.incquery.patternlanguage.util.psystem;

import org.eclipse.incquery.runtime.api.GenericMatchProcessor;
import org.eclipse.incquery.runtime.api.GenericPatternMatch;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * This is a generic pattern matcher for any IncQuery pattern, with "interpretative" query execution.
 * To use the pattern matcher on a given model, obtain a {@link GenericPQuery} first, then 
 * invoke e.g. {@link GenericPQuery#getMatcher(IncQueryEngine)}.
 * in conjunction with {@link IncQueryEngine#on(org.eclipse.incquery.runtime.api.scope.IncQueryScope)}.
 * 
 * <p>
 * Matches of the pattern will be represented as {@link GenericPatternMatch}.
 * 
 * @author Bergmann Gábor
 * @see GenericPatternMatch
 * @see GenericMatchProcessor
 * @see GenericPQuery
 */
public class GenericPatternMatcher extends org.eclipse.incquery.runtime.api.GenericPatternMatcher {

	protected GenericPatternMatcher(
			IncQueryEngine engine,
			GenericPQuery specification)
			throws IncQueryException {
		super(engine, specification);
	}
	
	public static GenericPatternMatcher instantiate(IncQueryEngine engine, GenericPQuery querySpecification) throws IncQueryException {
		// check if matcher already exists
		GenericPatternMatcher matcher = engine.getExistingMatcher(querySpecification);
        if (matcher == null) {
        	matcher = new GenericPatternMatcher(engine, querySpecification);
        	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
        } 	
        return matcher;
	}

}
