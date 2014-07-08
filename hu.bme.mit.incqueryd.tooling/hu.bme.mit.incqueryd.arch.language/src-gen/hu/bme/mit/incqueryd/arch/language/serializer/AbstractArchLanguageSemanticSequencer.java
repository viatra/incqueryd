package hu.bme.mit.incqueryd.arch.language.serializer;

import arch.ArchPackage;
import arch.CacheRole;
import arch.Configuration;
import arch.InfrastructureMapping;
import arch.RecipeImport;
import arch.ReteRole;
import com.google.inject.Inject;
import com.google.inject.Provider;
import hu.bme.mit.incqueryd.arch.language.services.ArchLanguageGrammarAccess;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractArchLanguageSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ArchLanguageGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ArchPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ArchPackage.CACHE_ROLE:
				if(context == grammarAccess.getCacheRoleRule() ||
				   context == grammarAccess.getRoleRule()) {
					sequence_CacheRole(context, (CacheRole) semanticObject); 
					return; 
				}
				else break;
			case ArchPackage.CONFIGURATION:
				if(context == grammarAccess.getConfigurationRule()) {
					sequence_Configuration(context, (Configuration) semanticObject); 
					return; 
				}
				else break;
			case ArchPackage.INFRASTRUCTURE_MAPPING:
				if(context == grammarAccess.getInfrastructureMappingRule()) {
					sequence_InfrastructureMapping(context, (InfrastructureMapping) semanticObject); 
					return; 
				}
				else break;
			case ArchPackage.RECIPE_IMPORT:
				if(context == grammarAccess.getRecipeImportRule()) {
					sequence_RecipeImport(context, (RecipeImport) semanticObject); 
					return; 
				}
				else break;
			case ArchPackage.RETE_ROLE:
				if(context == grammarAccess.getReteRoleRule() ||
				   context == grammarAccess.getRoleRule()) {
					sequence_ReteRole(context, (ReteRole) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == InfrastructurePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case InfrastructurePackage.MACHINE:
				if(context == grammarAccess.getMachineRule()) {
					sequence_Machine(context, (Machine) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     {CacheRole}
	 */
	protected void sequence_CacheRole(EObject context, CacheRole semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (recipeImports+=RecipeImport* mappings+=InfrastructureMapping*)
	 */
	protected void sequence_Configuration(EObject context, Configuration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (machine=Machine roles+=Role roles+=Role*)
	 */
	protected void sequence_InfrastructureMapping(EObject context, InfrastructureMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ip=IP
	 */
	protected void sequence_Machine(EObject context, Machine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     importURI=STRING
	 */
	protected void sequence_RecipeImport(EObject context, RecipeImport semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ArchPackage.Literals.RECIPE_IMPORT__IMPORT_URI) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArchPackage.Literals.RECIPE_IMPORT__IMPORT_URI));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRecipeImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), semanticObject.getImportURI());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     nodeRecipe=[ReteNodeRecipe|ID]
	 */
	protected void sequence_ReteRole(EObject context, ReteRole semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ArchPackage.Literals.RETE_ROLE__NODE_RECIPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ArchPackage.Literals.RETE_ROLE__NODE_RECIPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getReteRoleAccess().getNodeRecipeReteNodeRecipeIDTerminalRuleCall_0_1(), semanticObject.getNodeRecipe());
		feeder.finish();
	}
}
