///*******************************************************************************
// * Copyright (c) 2004-2014 Gabor Bergmann and Daniel Varro
// * All rights reserved. This program and the accompanying materials
// * are made available under the terms of the Eclipse Public License v1.0
// * which accompanies this distribution, and is available at
// * http://www.eclipse.org/legal/epl-v10.html
// *
// * Contributors:
// *    Gabor Bergmann - initial API and implementation
// *******************************************************************************/
//
//package org.eclipse.incquery.patternlanguage.mondix.psystem;
//
//import java.util.List;
//import java.util.Set;
//
//import org.eclipse.incquery.runtime.exception.IncQueryException;
//import org.eclipse.incquery.runtime.matchers.psystem.PBody;
//import org.eclipse.incquery.runtime.matchers.psystem.queries.PDisjunction;
//import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
//import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
//
//import eu.mondo.mondix.incquery.runtime.MondixQuery;
//
///**
// * @author Bergmann Gabor
// *
// */
//public class InterpretativeMondixQuery extends MondixQuery {
//	
//	PQuery wrappedQuery;
//	public InterpretativeMondixQuery(PQuery wrappedQuery) {
//		super();
//		this.wrappedQuery = wrappedQuery;
//		
//		ensureInitialized();
//	}
//
//	@Override
//	public String getFullyQualifiedName() {
//		return wrappedQuery.getFullyQualifiedName();
//	}
//
//	@Override
//	public List<PParameter> getParameters() {
//		return wrappedQuery.getParameters();
//	}
//
//	@Override
//	protected Set<PBody> doGetContainedBodies() throws IncQueryException {
//		// TODO illegal copy
//		return wrappedQuery.getDisjunctBodies().getBodies();
//	}
//	
//	@Override
//	public PDisjunction getDisjunctBodies() {
//		return wrappedQuery.getDisjunctBodies();
//	}
//
//}
