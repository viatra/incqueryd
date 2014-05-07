package hu.bme.mit.incqueryd.arch.language.serializer;

import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;
import com.google.inject.Inject;
import com.google.inject.Provider;
import hu.bme.mit.incqueryd.arch.language.services.ArchLanguageGrammarAccess;
import infrastructure.Cluster;
import infrastructure.InfrastructurePackage;
import infrastructure.Machine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.rete.recipes.AntiJoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.CheckRecipe;
import org.eclipse.incquery.runtime.rete.recipes.IndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.JoinRecipe;
import org.eclipse.incquery.runtime.rete.recipes.Mask;
import org.eclipse.incquery.runtime.rete.recipes.ProductionRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ProjectionIndexerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.incquery.runtime.rete.recipes.TrimmerRecipe;
import org.eclipse.incquery.runtime.rete.recipes.UniquenessEnforcerRecipe;
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
			}
		else if(semanticObject.eClass().getEPackage() == InfrastructurePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case InfrastructurePackage.CLUSTER:
				if(context == grammarAccess.getClusterRule()) {
					sequence_Cluster(context, (Cluster) semanticObject); 
					return; 
				}
				else break;
			case InfrastructurePackage.MACHINE:
				if(context == grammarAccess.getMachineRule()) {
					sequence_Machine(context, (Machine) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == RecipesPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case RecipesPackage.ANTI_JOIN_RECIPE:
				if(context == grammarAccess.getAntiJoinRecipeRule() ||
				   context == grammarAccess.getReteNodeRecipeRule()) {
					sequence_AntiJoinRecipe(context, (AntiJoinRecipe) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.CHECK_RECIPE:
				if(context == grammarAccess.getCheckRecipeRule() ||
				   context == grammarAccess.getReteNodeRecipeRule()) {
					sequence_CheckRecipe(context, (CheckRecipe) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.INDEXER_RECIPE:
				if(context == grammarAccess.getIndexerRecipeRule()) {
					sequence_IndexerRecipe(context, (IndexerRecipe) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.JOIN_RECIPE:
				if(context == grammarAccess.getJoinRecipeRule() ||
				   context == grammarAccess.getReteNodeRecipeRule()) {
					sequence_JoinRecipe(context, (JoinRecipe) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.MASK:
				if(context == grammarAccess.getMaskRule()) {
					sequence_Mask(context, (Mask) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.PRODUCTION_RECIPE:
				if(context == grammarAccess.getProductionRecipeRule() ||
				   context == grammarAccess.getReteNodeRecipeRule()) {
					sequence_ProductionRecipe(context, (ProductionRecipe) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.PROJECTION_INDEXER_RECIPE:
				if(context == grammarAccess.getProjectionIndexerRecipeRule()) {
					sequence_ProjectionIndexerRecipe(context, (ProjectionIndexerRecipe) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.RETE_RECIPE:
				if(context == grammarAccess.getReteRecipeRule()) {
					sequence_ReteRecipe(context, (ReteRecipe) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.TRIMMER_RECIPE:
				if(context == grammarAccess.getReteNodeRecipeRule() ||
				   context == grammarAccess.getTrimmerRecipeRule()) {
					sequence_TrimmerRecipe(context, (TrimmerRecipe) semanticObject); 
					return; 
				}
				else break;
			case RecipesPackage.UNIQUENESS_ENFORCER_RECIPE:
				if(context == grammarAccess.getReteNodeRecipeRule() ||
				   context == grammarAccess.getUniquenessEnforcerRecipeRule()) {
					sequence_UniquenessEnforcerRecipe(context, (UniquenessEnforcerRecipe) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (traceInfo=STRING leftParent=ProjectionIndexerRecipe rightParent=IndexerRecipe)
	 */
	protected void sequence_AntiJoinRecipe(EObject context, AntiJoinRecipe semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.RETE_NODE_RECIPE__TRACE_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.RETE_NODE_RECIPE__TRACE_INFO));
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.BETA_RECIPE__LEFT_PARENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.BETA_RECIPE__LEFT_PARENT));
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.BETA_RECIPE__RIGHT_PARENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.BETA_RECIPE__RIGHT_PARENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0(), semanticObject.getTraceInfo());
		feeder.accept(grammarAccess.getAntiJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0(), semanticObject.getLeftParent());
		feeder.accept(grammarAccess.getAntiJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0(), semanticObject.getRightParent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (traceInfo=STRING parent=[ReteNodeRecipe|ID])
	 */
	protected void sequence_CheckRecipe(EObject context, CheckRecipe semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (reteMachines+=Machine* cacheMachines+=Machine*)
	 */
	protected void sequence_Cluster(EObject context, Cluster semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (clusters+=Cluster* reteRecipes+=ReteRecipe* mappings+=InfrastructureMapping*)
	 */
	protected void sequence_Configuration(EObject context, Configuration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (traceInfo=STRING mask=Mask parent=[ReteNodeRecipe|ID])
	 */
	protected void sequence_IndexerRecipe(EObject context, IndexerRecipe semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.RETE_NODE_RECIPE__TRACE_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.RETE_NODE_RECIPE__TRACE_INFO));
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.SINGLE_PARENT_NODE_RECIPE__PARENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.SINGLE_PARENT_NODE_RECIPE__PARENT));
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.INDEXER_RECIPE__MASK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.INDEXER_RECIPE__MASK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0(), semanticObject.getTraceInfo());
		feeder.accept(grammarAccess.getIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0(), semanticObject.getMask());
		feeder.accept(grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_9_0_1(), semanticObject.getParent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (mappedElements+=[ReteNodeRecipe|ID]* targetElement=[Machine|ID])
	 */
	protected void sequence_InfrastructureMapping(EObject context, InfrastructureMapping semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (traceInfo=STRING leftParent=ProjectionIndexerRecipe rightParent=IndexerRecipe rightParentComplementaryMask=Mask?)
	 */
	protected void sequence_JoinRecipe(EObject context, JoinRecipe semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID traceInfo=STRING ip=IP)
	 */
	protected void sequence_Machine(EObject context, Machine semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, InfrastructurePackage.Literals.ELEMENT_WITH_TRACE_INFO__TRACE_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, InfrastructurePackage.Literals.ELEMENT_WITH_TRACE_INFO__TRACE_INFO));
			if(transientValues.isValueTransient(semanticObject, InfrastructurePackage.Literals.MACHINE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, InfrastructurePackage.Literals.MACHINE__NAME));
			if(transientValues.isValueTransient(semanticObject, InfrastructurePackage.Literals.MACHINE__IP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, InfrastructurePackage.Literals.MACHINE__IP));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMachineAccess().getNameIDTerminalRuleCall_3_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getMachineAccess().getTraceInfoSTRINGTerminalRuleCall_6_0(), semanticObject.getTraceInfo());
		feeder.accept(grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_9_0(), semanticObject.getIp());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (sourceArity=INT sourceIndices+=INT*)
	 */
	protected void sequence_Mask(EObject context, Mask semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (traceInfo=STRING parents+=[ReteNodeRecipe|ID]*)
	 */
	protected void sequence_ProductionRecipe(EObject context, ProductionRecipe semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (traceInfo=STRING mask=Mask parent=[ReteNodeRecipe|ID])
	 */
	protected void sequence_ProjectionIndexerRecipe(EObject context, ProjectionIndexerRecipe semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.RETE_NODE_RECIPE__TRACE_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.RETE_NODE_RECIPE__TRACE_INFO));
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.SINGLE_PARENT_NODE_RECIPE__PARENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.SINGLE_PARENT_NODE_RECIPE__PARENT));
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.INDEXER_RECIPE__MASK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.INDEXER_RECIPE__MASK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0(), semanticObject.getTraceInfo());
		feeder.accept(grammarAccess.getProjectionIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0(), semanticObject.getMask());
		feeder.accept(grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_9_0_1(), semanticObject.getParent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (recipeNodes+=ReteNodeRecipe*)
	 */
	protected void sequence_ReteRecipe(EObject context, ReteRecipe semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (traceInfo=STRING mask=Mask parent=[ReteNodeRecipe|ID])
	 */
	protected void sequence_TrimmerRecipe(EObject context, TrimmerRecipe semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.RETE_NODE_RECIPE__TRACE_INFO) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.RETE_NODE_RECIPE__TRACE_INFO));
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.SINGLE_PARENT_NODE_RECIPE__PARENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.SINGLE_PARENT_NODE_RECIPE__PARENT));
			if(transientValues.isValueTransient(semanticObject, RecipesPackage.Literals.TRIMMER_RECIPE__MASK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RecipesPackage.Literals.TRIMMER_RECIPE__MASK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTrimmerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0(), semanticObject.getTraceInfo());
		feeder.accept(grammarAccess.getTrimmerRecipeAccess().getMaskMaskParserRuleCall_7_0(), semanticObject.getMask());
		feeder.accept(grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_10_0_1(), semanticObject.getParent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (traceInfo=STRING parents+=[ReteNodeRecipe|ID]*)
	 */
	protected void sequence_UniquenessEnforcerRecipe(EObject context, UniquenessEnforcerRecipe semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
