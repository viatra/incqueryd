package org.eclipse.incquery.patternlanguage.rdf.ui.contentassist;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import hu.bme.mit.incqueryd.rdf.RdfUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.patternlanguage.rdf.RdfPatternLanguageUtils;
import org.eclipse.incquery.patternlanguage.rdf.conversion.RawIriValueConverter;
import org.eclipse.incquery.patternlanguage.rdf.rdfPatternLanguage.RdfPatternModel;
import org.eclipse.incquery.patternlanguage.rdf.ui.contentassist.AbstractRdfPatternLanguageProposalProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.openrdf.model.Model;
import org.openrdf.model.Resource;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;

@SuppressWarnings("all")
public class RdfPatternLanguageProposalProvider extends AbstractRdfPatternLanguageProposalProvider {
  private void proposeSubjects(final EObject model, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor, final Function2<? super Resource,? super Model,? extends Boolean> predicate) {
    final RdfPatternModel patternModel = EcoreUtil2.<RdfPatternModel>getContainerOfType(model, RdfPatternModel.class);
    final Model vocabulary = RdfPatternLanguageUtils.getVocabulary(model);
    final Function1<Statement,Resource> _function = new Function1<Statement,Resource>() {
      public Resource apply(final Statement it) {
        return it.getSubject();
      }
    };
    Iterable<Resource> _map = IterableExtensions.<Statement, Resource>map(vocabulary, _function);
    Iterable<URI> _filter = Iterables.<URI>filter(_map, URI.class);
    final Function1<URI,Boolean> _function_1 = new Function1<URI,Boolean>() {
      public Boolean apply(final URI subject) {
        return predicate.apply(subject, vocabulary);
      }
    };
    final Iterable<URI> resources = IterableExtensions.<URI>filter(_filter, _function_1);
    final Procedure1<URI> _function_2 = new Procedure1<URI>() {
      public void apply(final URI resource) {
        String _xifexpression = null;
        String _baseIriValue = patternModel.getBaseIriValue();
        boolean _equals = Objects.equal(_baseIriValue, null);
        if (_equals) {
          RawIriValueConverter _rawIriValueConverter = new RawIriValueConverter();
          String _stringValue = resource.stringValue();
          _xifexpression = _rawIriValueConverter.toEscapedString(_stringValue);
        } else {
          String _stringValue_1 = resource.stringValue();
          String _baseIriValue_1 = patternModel.getBaseIriValue();
          _xifexpression = _stringValue_1.replaceFirst(_baseIriValue_1, "");
        }
        final String proposal = _xifexpression;
        ICompletionProposal _createCompletionProposal = RdfPatternLanguageProposalProvider.this.createCompletionProposal(proposal, context);
        acceptor.accept(_createCompletionProposal);
      }
    };
    IterableExtensions.<URI>forEach(resources, _function_2);
  }
  
  public void completeRdfClassConstraint_Type(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Function2<Resource,Model,Boolean> _function = new Function2<Resource,Model,Boolean>() {
      public Boolean apply(final Resource subject, final Model vocabulary) {
        return Boolean.valueOf(RdfUtils.isClass(subject, vocabulary));
      }
    };
    this.proposeSubjects(model, context, acceptor, _function);
  }
  
  public void completeRdfPropertyConstraint_RefType(final EObject model, final Assignment assignment, final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
    final Function2<Resource,Model,Boolean> _function = new Function2<Resource,Model,Boolean>() {
      public Boolean apply(final Resource subject, final Model vocabulary) {
        return Boolean.valueOf(RdfUtils.isProperty(subject, vocabulary));
      }
    };
    this.proposeSubjects(model, context, acceptor, _function);
  }
}
