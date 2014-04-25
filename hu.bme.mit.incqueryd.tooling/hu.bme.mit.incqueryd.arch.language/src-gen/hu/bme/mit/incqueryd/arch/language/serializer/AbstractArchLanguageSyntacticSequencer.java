package hu.bme.mit.incqueryd.arch.language.serializer;

import com.google.inject.Inject;
import hu.bme.mit.incqueryd.arch.language.services.ArchLanguageGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractArchLanguageSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ArchLanguageGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Cluster___CacheMachinesKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q;
	protected AbstractElementAlias match_Cluster___ReteMachinesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q;
	protected AbstractElementAlias match_Configuration___ClustersKeyword_1_0_ColonKeyword_1_1_LeftSquareBracketKeyword_1_2_RightSquareBracketKeyword_1_4__q;
	protected AbstractElementAlias match_Configuration___MappingsKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q;
	protected AbstractElementAlias match_Configuration___RecipesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q;
	protected AbstractElementAlias match_Mask___RightSquareBracketKeyword_4_4_SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2__a;
	protected AbstractElementAlias match_Mask___SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2_RightSquareBracketKeyword_4_4__a;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ArchLanguageGrammarAccess) access;
		match_Cluster___CacheMachinesKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getClusterAccess().getCacheMachinesKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getClusterAccess().getColonKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_3_2()), new TokenAlias(false, false, grammarAccess.getClusterAccess().getRightSquareBracketKeyword_3_4()));
		match_Cluster___ReteMachinesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getClusterAccess().getReteMachinesKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getClusterAccess().getColonKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_2_2()), new TokenAlias(false, false, grammarAccess.getClusterAccess().getRightSquareBracketKeyword_2_4()));
		match_Configuration___ClustersKeyword_1_0_ColonKeyword_1_1_LeftSquareBracketKeyword_1_2_RightSquareBracketKeyword_1_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getClustersKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getColonKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_1_2()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_1_4()));
		match_Configuration___MappingsKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getMappingsKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getColonKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_3_2()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_3_4()));
		match_Configuration___RecipesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getRecipesKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getColonKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_2_2()), new TokenAlias(false, false, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_2_4()));
		match_Mask___RightSquareBracketKeyword_4_4_SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getMaskAccess().getRightSquareBracketKeyword_4_4()), new TokenAlias(false, false, grammarAccess.getMaskAccess().getSourceIndicesKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getMaskAccess().getColonKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getMaskAccess().getLeftSquareBracketKeyword_4_2()));
		match_Mask___SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2_RightSquareBracketKeyword_4_4__a = new GroupAlias(true, true, new TokenAlias(false, false, grammarAccess.getMaskAccess().getSourceIndicesKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getMaskAccess().getColonKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getMaskAccess().getLeftSquareBracketKeyword_4_2()), new TokenAlias(false, false, grammarAccess.getMaskAccess().getRightSquareBracketKeyword_4_4()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Cluster___CacheMachinesKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q.equals(syntax))
				emit_Cluster___CacheMachinesKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Cluster___ReteMachinesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q.equals(syntax))
				emit_Cluster___ReteMachinesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Configuration___ClustersKeyword_1_0_ColonKeyword_1_1_LeftSquareBracketKeyword_1_2_RightSquareBracketKeyword_1_4__q.equals(syntax))
				emit_Configuration___ClustersKeyword_1_0_ColonKeyword_1_1_LeftSquareBracketKeyword_1_2_RightSquareBracketKeyword_1_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Configuration___MappingsKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q.equals(syntax))
				emit_Configuration___MappingsKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Configuration___RecipesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q.equals(syntax))
				emit_Configuration___RecipesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Mask___RightSquareBracketKeyword_4_4_SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2__a.equals(syntax))
				emit_Mask___RightSquareBracketKeyword_4_4_SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Mask___SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2_RightSquareBracketKeyword_4_4__a.equals(syntax))
				emit_Mask___SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2_RightSquareBracketKeyword_4_4__a(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('cacheMachines' ':' '[' ']')?
	 */
	protected void emit_Cluster___CacheMachinesKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('reteMachines' ':' '[' ']')?
	 */
	protected void emit_Cluster___ReteMachinesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('clusters' ':' '[' ']')?
	 */
	protected void emit_Configuration___ClustersKeyword_1_0_ColonKeyword_1_1_LeftSquareBracketKeyword_1_2_RightSquareBracketKeyword_1_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('mappings' ':' '[' ']')?
	 */
	protected void emit_Configuration___MappingsKeyword_3_0_ColonKeyword_3_1_LeftSquareBracketKeyword_3_2_RightSquareBracketKeyword_3_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('recipes' ':' '[' ']')?
	 */
	protected void emit_Configuration___RecipesKeyword_2_0_ColonKeyword_2_1_LeftSquareBracketKeyword_2_2_RightSquareBracketKeyword_2_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (']' 'sourceIndices' ':' '[')*
	 */
	protected void emit_Mask___RightSquareBracketKeyword_4_4_SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('sourceIndices' ':' '[' ']')*
	 */
	protected void emit_Mask___SourceIndicesKeyword_4_0_ColonKeyword_4_1_LeftSquareBracketKeyword_4_2_RightSquareBracketKeyword_4_4__a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
