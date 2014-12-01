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

package org.eclipse.incquery.patternlanguage.mondix.tests

import com.google.inject.Inject
import eu.mondo.mondix.incquery.test.MyMondixIQTest
import org.eclipse.incquery.patternlanguage.mondix.mondixPatternLanguage.MondixPatternModel
import org.eclipse.incquery.patternlanguage.mondix.psystem.MondixPModel
import org.eclipse.incquery.runtime.api.IQuerySpecification
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.junit4.InjectWith
import org.junit.runner.RunWith
import org.eclipse.incquery.patternlanguage.mondix.MondixPatternLanguageInjectorProvider
import org.eclipse.xtext.junit4.XtextRunner

/**
 * @author Bergmann Gabor
 *
 */
@InjectWith(MondixPatternLanguageInjectorProvider)
@RunWith(XtextRunner)
class ParserRuntimeIntegrationTest {
	@Inject
	ParseHelper<MondixPatternModel> parser

	public static val MY_MONDIX_QUERY_SOURCE = '''
		pattern myMondixQuery(x, y) {
			fooUnary(x);
			fooBinary(x, y);
		}
	'''

	@Test
	def void parserRuntimeTest() {
		val patternModel = parser.parse(MY_MONDIX_QUERY_SOURCE)
		assertTrue(patternModel.eResource.errors.empty)
		IntegrationTestHelper.exerciseTest(patternModel);
	}
	
//	def exerciseTest(MondixPatternModel patternModel) {
//		val pModelXform = new MondixPModel(patternModel)
//		val pQuery = pModelXform.findQueryOf(patternModel.patterns.head)
//		val IQuerySpecification query = new InterpretativeMondixQuery(pQuery)
//		MyMondixIQTest.testQuery(query)
//	}
	
	
}