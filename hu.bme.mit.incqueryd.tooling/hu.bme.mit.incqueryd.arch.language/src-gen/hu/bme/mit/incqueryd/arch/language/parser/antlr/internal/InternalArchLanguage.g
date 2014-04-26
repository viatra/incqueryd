/*
* generated by Xtext
*/
grammar InternalArchLanguage;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package hu.bme.mit.incqueryd.arch.language.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package hu.bme.mit.incqueryd.arch.language.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.incqueryd.arch.language.services.ArchLanguageGrammarAccess;

}

@parser::members {

 	private ArchLanguageGrammarAccess grammarAccess;
 	
    public InternalArchLanguageParser(TokenStream input, ArchLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Configuration";	
   	}
   	
   	@Override
   	protected ArchLanguageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleConfiguration
entryRuleConfiguration returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getConfigurationRule()); }
	 iv_ruleConfiguration=ruleConfiguration 
	 { $current=$iv_ruleConfiguration.current; } 
	 EOF 
;

// Rule Configuration
ruleConfiguration returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getConfigurationAccess().getConfigurationAction_0(),
            $current);
    }
)(	otherlv_1='clusters' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getClustersKeyword_1_0());
    }
	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getConfigurationAccess().getColonKeyword_1_1());
    }
	otherlv_3='[' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_1_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getClustersClusterParserRuleCall_1_3_0()); 
	    }
		lv_clusters_4_0=ruleCluster		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		add(
       			$current, 
       			"clusters",
        		lv_clusters_4_0, 
        		"Cluster");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_5=']' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_1_4());
    }
)?(	otherlv_6='recipes' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getConfigurationAccess().getRecipesKeyword_2_0());
    }
	otherlv_7=':' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getConfigurationAccess().getColonKeyword_2_1());
    }
	otherlv_8='[' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_2_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getReteRecipesReteRecipeParserRuleCall_2_3_0()); 
	    }
		lv_reteRecipes_9_0=ruleReteRecipe		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		add(
       			$current, 
       			"reteRecipes",
        		lv_reteRecipes_9_0, 
        		"ReteRecipe");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_10=']' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_2_4());
    }
)?(	otherlv_11='mappings' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getConfigurationAccess().getMappingsKeyword_3_0());
    }
	otherlv_12=':' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getConfigurationAccess().getColonKeyword_3_1());
    }
	otherlv_13='[' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_3_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getConfigurationAccess().getMappingsInfrastructureMappingParserRuleCall_3_3_0()); 
	    }
		lv_mappings_14_0=ruleInfrastructureMapping		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getConfigurationRule());
	        }
       		add(
       			$current, 
       			"mappings",
        		lv_mappings_14_0, 
        		"InfrastructureMapping");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_15=']' 
    {
    	newLeafNode(otherlv_15, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_3_4());
    }
)?)
;





// Entry rule entryRuleCluster
entryRuleCluster returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getClusterRule()); }
	 iv_ruleCluster=ruleCluster 
	 { $current=$iv_ruleCluster.current; } 
	 EOF 
;

// Rule Cluster
ruleCluster returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getClusterAccess().getClusterAction_0(),
            $current);
    }
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getClusterAccess().getLeftCurlyBracketKeyword_1());
    }
(	otherlv_2='reteMachines' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getClusterAccess().getReteMachinesKeyword_2_0());
    }
	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getClusterAccess().getColonKeyword_2_1());
    }
	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_2_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getClusterAccess().getReteMachinesMachineParserRuleCall_2_3_0()); 
	    }
		lv_reteMachines_5_0=ruleMachine		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClusterRule());
	        }
       		add(
       			$current, 
       			"reteMachines",
        		lv_reteMachines_5_0, 
        		"Machine");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_6=']' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getClusterAccess().getRightSquareBracketKeyword_2_4());
    }
)?(	otherlv_7='cacheMachines' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getClusterAccess().getCacheMachinesKeyword_3_0());
    }
	otherlv_8=':' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getClusterAccess().getColonKeyword_3_1());
    }
	otherlv_9='[' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_3_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getClusterAccess().getCacheMachinesMachineParserRuleCall_3_3_0()); 
	    }
		lv_cacheMachines_10_0=ruleMachine		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getClusterRule());
	        }
       		add(
       			$current, 
       			"cacheMachines",
        		lv_cacheMachines_10_0, 
        		"Machine");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_11=']' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getClusterAccess().getRightSquareBracketKeyword_3_4());
    }
)?	otherlv_12='}' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getClusterAccess().getRightCurlyBracketKeyword_4());
    }
)
;





// Entry rule entryRuleMachine
entryRuleMachine returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMachineRule()); }
	 iv_ruleMachine=ruleMachine 
	 { $current=$iv_ruleMachine.current; } 
	 EOF 
;

// Rule Machine
ruleMachine returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMachineAccess().getLeftCurlyBracketKeyword_0());
    }
	otherlv_1='traceInfo' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMachineAccess().getTraceInfoKeyword_1());
    }
	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMachineAccess().getColonKeyword_2());
    }
(
(
		lv_traceInfo_3_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_3_0, grammarAccess.getMachineAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMachineRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_3_0, 
        		"STRING");
	    }

)
)	otherlv_4='ip' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMachineAccess().getIpKeyword_4());
    }
	otherlv_5=':' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMachineAccess().getColonKeyword_5());
    }
(
(
		lv_ip_6_0=RULE_IP
		{
			newLeafNode(lv_ip_6_0, grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_6_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMachineRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"ip",
        		lv_ip_6_0, 
        		"IP");
	    }

)
)	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getMachineAccess().getRightCurlyBracketKeyword_7());
    }
)
;





// Entry rule entryRuleReteRecipe
entryRuleReteRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getReteRecipeRule()); }
	 iv_ruleReteRecipe=ruleReteRecipe 
	 { $current=$iv_ruleReteRecipe.current; } 
	 EOF 
;

// Rule ReteRecipe
ruleReteRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
    {
        $current = forceCreateModelElement(
            grammarAccess.getReteRecipeAccess().getReteRecipeAction_0(),
            $current);
    }
)	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getReteRecipeAccess().getLeftCurlyBracketKeyword_1());
    }
	otherlv_2='nodes' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getReteRecipeAccess().getNodesKeyword_2());
    }
	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getReteRecipeAccess().getColonKeyword_3());
    }
	otherlv_4='[' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getReteRecipeAccess().getLeftSquareBracketKeyword_4());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getReteRecipeAccess().getRecipeNodesReteNodeRecipeParserRuleCall_5_0()); 
	    }
		lv_recipeNodes_5_0=ruleReteNodeRecipe		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getReteRecipeRule());
	        }
       		add(
       			$current, 
       			"recipeNodes",
        		lv_recipeNodes_5_0, 
        		"ReteNodeRecipe");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_6=']' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getReteRecipeAccess().getRightSquareBracketKeyword_6());
    }
	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getReteRecipeAccess().getRightCurlyBracketKeyword_7());
    }
)
;





// Entry rule entryRuleReteNodeRecipe
entryRuleReteNodeRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getReteNodeRecipeRule()); }
	 iv_ruleReteNodeRecipe=ruleReteNodeRecipe 
	 { $current=$iv_ruleReteNodeRecipe.current; } 
	 EOF 
;

// Rule ReteNodeRecipe
ruleReteNodeRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getProductionRecipeParserRuleCall_0()); 
    }
    this_ProductionRecipe_0=ruleProductionRecipe
    { 
        $current = $this_ProductionRecipe_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getUniquenessEnforcerRecipeParserRuleCall_1()); 
    }
    this_UniquenessEnforcerRecipe_1=ruleUniquenessEnforcerRecipe
    { 
        $current = $this_UniquenessEnforcerRecipe_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getCheckRecipeParserRuleCall_2()); 
    }
    this_CheckRecipe_2=ruleCheckRecipe
    { 
        $current = $this_CheckRecipe_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getTrimmerRecipeParserRuleCall_3()); 
    }
    this_TrimmerRecipe_3=ruleTrimmerRecipe
    { 
        $current = $this_TrimmerRecipe_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getJoinRecipeParserRuleCall_4()); 
    }
    this_JoinRecipe_4=ruleJoinRecipe
    { 
        $current = $this_JoinRecipe_4.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getAntiJoinRecipeParserRuleCall_5()); 
    }
    this_AntiJoinRecipe_5=ruleAntiJoinRecipe
    { 
        $current = $this_AntiJoinRecipe_5.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleProductionRecipe
entryRuleProductionRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getProductionRecipeRule()); }
	 iv_ruleProductionRecipe=ruleProductionRecipe 
	 { $current=$iv_ruleProductionRecipe.current; } 
	 EOF 
;

// Rule ProductionRecipe
ruleProductionRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Production' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getProductionRecipeAccess().getProductionKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getProductionRecipeAccess().getLeftCurlyBracketKeyword_1());
    }
	otherlv_2='traceInfo' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getProductionRecipeAccess().getTraceInfoKeyword_2());
    }
	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getProductionRecipeAccess().getColonKeyword_3());
    }
(
(
		lv_traceInfo_4_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_4_0, grammarAccess.getProductionRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getProductionRecipeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_4_0, 
        		"STRING");
	    }

)
)	otherlv_5='parents' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getProductionRecipeAccess().getParentsKeyword_5());
    }
	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getProductionRecipeAccess().getColonKeyword_6());
    }
	otherlv_7='[' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getProductionRecipeAccess().getLeftSquareBracketKeyword_7());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getProductionRecipeRule());
	        }
        }
	otherlv_8=RULE_ID
	{
		newLeafNode(otherlv_8, grammarAccess.getProductionRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 
	}

)
)*	otherlv_9=']' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getProductionRecipeAccess().getRightSquareBracketKeyword_9());
    }
	otherlv_10='}' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getProductionRecipeAccess().getRightCurlyBracketKeyword_10());
    }
)
;





// Entry rule entryRuleUniquenessEnforcerRecipe
entryRuleUniquenessEnforcerRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getUniquenessEnforcerRecipeRule()); }
	 iv_ruleUniquenessEnforcerRecipe=ruleUniquenessEnforcerRecipe 
	 { $current=$iv_ruleUniquenessEnforcerRecipe.current; } 
	 EOF 
;

// Rule UniquenessEnforcerRecipe
ruleUniquenessEnforcerRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='UniquenessEnforcer' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getUniquenessEnforcerRecipeAccess().getUniquenessEnforcerKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftCurlyBracketKeyword_1());
    }
	otherlv_2='traceInfo' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoKeyword_2());
    }
	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_3());
    }
(
(
		lv_traceInfo_4_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_4_0, grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getUniquenessEnforcerRecipeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_4_0, 
        		"STRING");
	    }

)
)	otherlv_5='parents' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsKeyword_5());
    }
	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_6());
    }
	otherlv_7='[' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftSquareBracketKeyword_7());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getUniquenessEnforcerRecipeRule());
	        }
        }
	otherlv_8=RULE_ID
	{
		newLeafNode(otherlv_8, grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 
	}

)
)*	otherlv_9=']' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getUniquenessEnforcerRecipeAccess().getRightSquareBracketKeyword_9());
    }
	otherlv_10='}' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getUniquenessEnforcerRecipeAccess().getRightCurlyBracketKeyword_10());
    }
)
;





// Entry rule entryRuleCheckRecipe
entryRuleCheckRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCheckRecipeRule()); }
	 iv_ruleCheckRecipe=ruleCheckRecipe 
	 { $current=$iv_ruleCheckRecipe.current; } 
	 EOF 
;

// Rule CheckRecipe
ruleCheckRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Check' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getCheckRecipeAccess().getCheckKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getCheckRecipeAccess().getLeftCurlyBracketKeyword_1());
    }
	otherlv_2='traceInfo' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getCheckRecipeAccess().getTraceInfoKeyword_2());
    }
	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getCheckRecipeAccess().getColonKeyword_3());
    }
(
(
		lv_traceInfo_4_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_4_0, grammarAccess.getCheckRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getCheckRecipeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_4_0, 
        		"STRING");
	    }

)
)	otherlv_5='parent' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getCheckRecipeAccess().getParentKeyword_5());
    }
	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getCheckRecipeAccess().getColonKeyword_6());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getCheckRecipeRule());
	        }
        }
	otherlv_7=RULE_ID
	{
		newLeafNode(otherlv_7, grammarAccess.getCheckRecipeAccess().getParentReteNodeRecipeCrossReference_7_0()); 
	}

)
)	otherlv_8='}' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getCheckRecipeAccess().getRightCurlyBracketKeyword_8());
    }
)
;





// Entry rule entryRuleTrimmerRecipe
entryRuleTrimmerRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getTrimmerRecipeRule()); }
	 iv_ruleTrimmerRecipe=ruleTrimmerRecipe 
	 { $current=$iv_ruleTrimmerRecipe.current; } 
	 EOF 
;

// Rule TrimmerRecipe
ruleTrimmerRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Trimmer' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getTrimmerRecipeAccess().getTrimmerKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getTrimmerRecipeAccess().getLeftCurlyBracketKeyword_1());
    }
	otherlv_2='traceInfo' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getTrimmerRecipeAccess().getTraceInfoKeyword_2());
    }
	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getTrimmerRecipeAccess().getColonKeyword_3());
    }
(
(
		lv_traceInfo_4_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_4_0, grammarAccess.getTrimmerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getTrimmerRecipeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_4_0, 
        		"STRING");
	    }

)
)	otherlv_5='mask' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getTrimmerRecipeAccess().getMaskKeyword_5());
    }
	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getTrimmerRecipeAccess().getColonKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getTrimmerRecipeAccess().getMaskMaskParserRuleCall_7_0()); 
	    }
		lv_mask_7_0=ruleMask		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getTrimmerRecipeRule());
	        }
       		set(
       			$current, 
       			"mask",
        		lv_mask_7_0, 
        		"Mask");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_8='parent' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getTrimmerRecipeAccess().getParentKeyword_8());
    }
	otherlv_9=':' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getTrimmerRecipeAccess().getColonKeyword_9());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getTrimmerRecipeRule());
	        }
        }
	otherlv_10=RULE_ID
	{
		newLeafNode(otherlv_10, grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeCrossReference_10_0()); 
	}

)
)	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getTrimmerRecipeAccess().getRightCurlyBracketKeyword_11());
    }
)
;





// Entry rule entryRuleJoinRecipe
entryRuleJoinRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getJoinRecipeRule()); }
	 iv_ruleJoinRecipe=ruleJoinRecipe 
	 { $current=$iv_ruleJoinRecipe.current; } 
	 EOF 
;

// Rule JoinRecipe
ruleJoinRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Join' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getJoinRecipeAccess().getJoinKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getJoinRecipeAccess().getLeftCurlyBracketKeyword_1());
    }
	otherlv_2='traceInfo' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getJoinRecipeAccess().getTraceInfoKeyword_2());
    }
	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getJoinRecipeAccess().getColonKeyword_3());
    }
(
(
		lv_traceInfo_4_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_4_0, grammarAccess.getJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getJoinRecipeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_4_0, 
        		"STRING");
	    }

)
)	otherlv_5='leftParent' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getJoinRecipeAccess().getLeftParentKeyword_5());
    }
	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getJoinRecipeAccess().getColonKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 
	    }
		lv_leftParent_7_0=ruleProjectionIndexerRecipe		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getJoinRecipeRule());
	        }
       		set(
       			$current, 
       			"leftParent",
        		lv_leftParent_7_0, 
        		"ProjectionIndexerRecipe");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_8='rightParent' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getJoinRecipeAccess().getRightParentKeyword_8());
    }
	otherlv_9=':' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getJoinRecipeAccess().getColonKeyword_9());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 
	    }
		lv_rightParent_10_0=ruleIndexerRecipe		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getJoinRecipeRule());
	        }
       		set(
       			$current, 
       			"rightParent",
        		lv_rightParent_10_0, 
        		"IndexerRecipe");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getJoinRecipeAccess().getRightParentComplementaryMaskMaskParserRuleCall_11_0()); 
	    }
		lv_rightParentComplementaryMask_11_0=ruleMask		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getJoinRecipeRule());
	        }
       		set(
       			$current, 
       			"rightParentComplementaryMask",
        		lv_rightParentComplementaryMask_11_0, 
        		"Mask");
	        afterParserOrEnumRuleCall();
	    }

)
)?	otherlv_12='}' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getJoinRecipeAccess().getRightCurlyBracketKeyword_12());
    }
)
;





// Entry rule entryRuleAntiJoinRecipe
entryRuleAntiJoinRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAntiJoinRecipeRule()); }
	 iv_ruleAntiJoinRecipe=ruleAntiJoinRecipe 
	 { $current=$iv_ruleAntiJoinRecipe.current; } 
	 EOF 
;

// Rule AntiJoinRecipe
ruleAntiJoinRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='AntiJoin' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getAntiJoinRecipeAccess().getAntiJoinKeyword_0());
    }
	otherlv_1='{' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAntiJoinRecipeAccess().getLeftCurlyBracketKeyword_1());
    }
	otherlv_2='traceInfo' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getAntiJoinRecipeAccess().getTraceInfoKeyword_2());
    }
	otherlv_3=':' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_3());
    }
(
(
		lv_traceInfo_4_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_4_0, grammarAccess.getAntiJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAntiJoinRecipeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_4_0, 
        		"STRING");
	    }

)
)	otherlv_5='leftParent' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getAntiJoinRecipeAccess().getLeftParentKeyword_5());
    }
	otherlv_6=':' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_6());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAntiJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 
	    }
		lv_leftParent_7_0=ruleProjectionIndexerRecipe		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAntiJoinRecipeRule());
	        }
       		set(
       			$current, 
       			"leftParent",
        		lv_leftParent_7_0, 
        		"ProjectionIndexerRecipe");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_8='rightParent' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getAntiJoinRecipeAccess().getRightParentKeyword_8());
    }
	otherlv_9=':' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_9());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getAntiJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 
	    }
		lv_rightParent_10_0=ruleIndexerRecipe		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getAntiJoinRecipeRule());
	        }
       		set(
       			$current, 
       			"rightParent",
        		lv_rightParent_10_0, 
        		"IndexerRecipe");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getAntiJoinRecipeAccess().getRightCurlyBracketKeyword_11());
    }
)
;





// Entry rule entryRuleIndexerRecipe
entryRuleIndexerRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getIndexerRecipeRule()); }
	 iv_ruleIndexerRecipe=ruleIndexerRecipe 
	 { $current=$iv_ruleIndexerRecipe.current; } 
	 EOF 
;

// Rule IndexerRecipe
ruleIndexerRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getIndexerRecipeAccess().getLeftCurlyBracketKeyword_0());
    }
	otherlv_1='traceInfo' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getIndexerRecipeAccess().getTraceInfoKeyword_1());
    }
	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getIndexerRecipeAccess().getColonKeyword_2());
    }
(
(
		lv_traceInfo_3_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_3_0, grammarAccess.getIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getIndexerRecipeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_3_0, 
        		"STRING");
	    }

)
)	otherlv_4='mask' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getIndexerRecipeAccess().getMaskKeyword_4());
    }
	otherlv_5=':' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getIndexerRecipeAccess().getColonKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 
	    }
		lv_mask_6_0=ruleMask		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getIndexerRecipeRule());
	        }
       		set(
       			$current, 
       			"mask",
        		lv_mask_6_0, 
        		"Mask");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7='parent' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getIndexerRecipeAccess().getParentKeyword_7());
    }
	otherlv_8=':' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getIndexerRecipeAccess().getColonKeyword_8());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getIndexerRecipeRule());
	        }
        }
	otherlv_9=RULE_ID
	{
		newLeafNode(otherlv_9, grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 
	}

)
)	otherlv_10='}' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getIndexerRecipeAccess().getRightCurlyBracketKeyword_10());
    }
)
;





// Entry rule entryRuleProjectionIndexerRecipe
entryRuleProjectionIndexerRecipe returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getProjectionIndexerRecipeRule()); }
	 iv_ruleProjectionIndexerRecipe=ruleProjectionIndexerRecipe 
	 { $current=$iv_ruleProjectionIndexerRecipe.current; } 
	 EOF 
;

// Rule ProjectionIndexerRecipe
ruleProjectionIndexerRecipe returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getProjectionIndexerRecipeAccess().getLeftCurlyBracketKeyword_0());
    }
	otherlv_1='traceInfo' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoKeyword_1());
    }
	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_2());
    }
(
(
		lv_traceInfo_3_0=RULE_STRING
		{
			newLeafNode(lv_traceInfo_3_0, grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getProjectionIndexerRecipeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"traceInfo",
        		lv_traceInfo_3_0, 
        		"STRING");
	    }

)
)	otherlv_4='mask' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getProjectionIndexerRecipeAccess().getMaskKeyword_4());
    }
	otherlv_5=':' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getProjectionIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 
	    }
		lv_mask_6_0=ruleMask		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getProjectionIndexerRecipeRule());
	        }
       		set(
       			$current, 
       			"mask",
        		lv_mask_6_0, 
        		"Mask");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_7='parent' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getProjectionIndexerRecipeAccess().getParentKeyword_7());
    }
	otherlv_8=':' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_8());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getProjectionIndexerRecipeRule());
	        }
        }
	otherlv_9=RULE_ID
	{
		newLeafNode(otherlv_9, grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 
	}

)
)	otherlv_10='}' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getProjectionIndexerRecipeAccess().getRightCurlyBracketKeyword_10());
    }
)
;





// Entry rule entryRuleMask
entryRuleMask returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMaskRule()); }
	 iv_ruleMask=ruleMask 
	 { $current=$iv_ruleMask.current; } 
	 EOF 
;

// Rule Mask
ruleMask returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMaskAccess().getLeftCurlyBracketKeyword_0());
    }
	otherlv_1='sourceArity' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getMaskAccess().getSourceArityKeyword_1());
    }
	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getMaskAccess().getColonKeyword_2());
    }
(
(
		lv_sourceArity_3_0=RULE_INT
		{
			newLeafNode(lv_sourceArity_3_0, grammarAccess.getMaskAccess().getSourceArityINTTerminalRuleCall_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMaskRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"sourceArity",
        		lv_sourceArity_3_0, 
        		"INT");
	    }

)
)(	otherlv_4='sourceIndices' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getMaskAccess().getSourceIndicesKeyword_4_0());
    }
	otherlv_5=':' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getMaskAccess().getColonKeyword_4_1());
    }
	otherlv_6='[' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getMaskAccess().getLeftSquareBracketKeyword_4_2());
    }
(
(
		lv_sourceIndices_7_0=RULE_INT
		{
			newLeafNode(lv_sourceIndices_7_0, grammarAccess.getMaskAccess().getSourceIndicesINTTerminalRuleCall_4_3_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMaskRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"sourceIndices",
        		lv_sourceIndices_7_0, 
        		"INT");
	    }

)
)*	otherlv_8=']' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getMaskAccess().getRightSquareBracketKeyword_4_4());
    }
)*	otherlv_9='}' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getMaskAccess().getRightCurlyBracketKeyword_5());
    }
)
;





// Entry rule entryRuleInfrastructureMapping
entryRuleInfrastructureMapping returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getInfrastructureMappingRule()); }
	 iv_ruleInfrastructureMapping=ruleInfrastructureMapping 
	 { $current=$iv_ruleInfrastructureMapping.current; } 
	 EOF 
;

// Rule InfrastructureMapping
ruleInfrastructureMapping returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='{' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getInfrastructureMappingAccess().getLeftCurlyBracketKeyword_0());
    }
	otherlv_1='from' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getInfrastructureMappingAccess().getFromKeyword_1());
    }
	otherlv_2=':' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getInfrastructureMappingAccess().getColonKeyword_2());
    }
	otherlv_3='[' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getInfrastructureMappingAccess().getLeftSquareBracketKeyword_3());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getInfrastructureMappingRule());
	        }
        }
	otherlv_4=RULE_ID
	{
		newLeafNode(otherlv_4, grammarAccess.getInfrastructureMappingAccess().getMappedElementsReteNodeRecipeCrossReference_4_0()); 
	}

)
)*	otherlv_5=']' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getInfrastructureMappingAccess().getRightSquareBracketKeyword_5());
    }
	otherlv_6='to' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getInfrastructureMappingAccess().getToKeyword_6());
    }
	otherlv_7=':' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getInfrastructureMappingAccess().getColonKeyword_7());
    }
(
(
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getInfrastructureMappingRule());
	        }
        }
	otherlv_8=RULE_ID
	{
		newLeafNode(otherlv_8, grammarAccess.getInfrastructureMappingAccess().getTargetElementMachineCrossReference_8_0()); 
	}

)
)	otherlv_9='}' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getInfrastructureMappingAccess().getRightCurlyBracketKeyword_9());
    }
)
;





RULE_IP : RULE_INT '.' RULE_INT '.' RULE_INT '.' RULE_INT;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


