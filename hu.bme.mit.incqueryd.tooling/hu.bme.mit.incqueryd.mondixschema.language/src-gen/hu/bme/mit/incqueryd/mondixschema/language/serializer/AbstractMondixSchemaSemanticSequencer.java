package hu.bme.mit.incqueryd.mondixschema.language.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import hu.bme.mit.incqueryd.mondixschema.Column;
import hu.bme.mit.incqueryd.mondixschema.MondixSchemaPackage;
import hu.bme.mit.incqueryd.mondixschema.Relation;
import hu.bme.mit.incqueryd.mondixschema.Schema;
import hu.bme.mit.incqueryd.mondixschema.language.services.MondixSchemaGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;

@SuppressWarnings("all")
public abstract class AbstractMondixSchemaSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MondixSchemaGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == MondixSchemaPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case MondixSchemaPackage.COLUMN:
				if(context == grammarAccess.getColumnRule()) {
					sequence_Column(context, (Column) semanticObject); 
					return; 
				}
				else break;
			case MondixSchemaPackage.RELATION:
				if(context == grammarAccess.getRelationRule()) {
					sequence_Relation(context, (Relation) semanticObject); 
					return; 
				}
				else break;
			case MondixSchemaPackage.SCHEMA:
				if(context == grammarAccess.getSchemaRule()) {
					sequence_Schema(context, (Schema) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID type=ColumnType?)
	 */
	protected void sequence_Column(EObject context, Column semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID columns+=Column*)
	 */
	protected void sequence_Relation(EObject context, Relation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID relations+=Relation*)
	 */
	protected void sequence_Schema(EObject context, Schema semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
