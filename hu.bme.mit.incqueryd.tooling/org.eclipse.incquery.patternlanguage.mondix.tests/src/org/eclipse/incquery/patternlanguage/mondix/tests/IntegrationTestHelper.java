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

package org.eclipse.incquery.patternlanguage.mondix.tests;

import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel;
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPModel;
import org.eclipse.incquery.patternlanguage.util.psystem.GenericPQuery;
import org.eclipse.incquery.runtime.exception.IncQueryException;

import eu.mondo.mondix.incquery.test.MyMondixIQTest;

/**
 * @author Bergmann Gabor
 *
 */
public class IntegrationTestHelper {
	
	public static void exerciseTest(MondixPatternModel patternModel) throws IncQueryException {
		MondixPModel pModelXform = new MondixPModel(patternModel);
		GenericPQuery pQuery = pModelXform.findQueryOf(patternModel.getPatterns().get(0));
		MyMondixIQTest.testQuery(pQuery);
	}

}
