package org.eclipse.incquery.patternlanguage.rdf.ui.contentassist

import hu.bme.mit.incqueryd.rdf.RdfUtils
import org.eclipse.emf.ecore.EObject
import org.eclipse.incquery.patternlanguage.rdf.conversion.RawIriValueConverter
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.openrdf.model.Resource

import static extension org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils.*
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.openrdf.model.Model
import org.openrdf.model.URI

class RdfPatternLanguageProposalProvider extends AbstractRdfPatternLanguageProposalProvider {

	private def proposeSubjects(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor, (Resource, Model) => boolean predicate) {
		val patternModel = model.getContainerOfType(RdfPatternModel)
		val vocabulary = model.vocabulary
		val resources = vocabulary.map[subject].filter(URI).filter[subject | predicate.apply(subject, vocabulary)]
		resources.forEach[resource |
			val proposal = if (patternModel.baseIriValue == null) {
				new RawIriValueConverter().toEscapedString(resource.stringValue)
			} else {
				resource.stringValue.replaceFirst(patternModel.baseIriValue, "")
			}
			acceptor.accept(createCompletionProposal(proposal, context))
		]
	}

	override void completeRdfClassConstraint_Type(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		proposeSubjects(model, context, acceptor, [subject, vocabulary |
			RdfUtils.isClass(subject, vocabulary)
		])
	}

	override void completeRdfPropertyConstraint_RefType(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		proposeSubjects(model, context, acceptor, [subject, vocabulary |
			RdfUtils.isProperty(subject, vocabulary)
		])
	}

}
