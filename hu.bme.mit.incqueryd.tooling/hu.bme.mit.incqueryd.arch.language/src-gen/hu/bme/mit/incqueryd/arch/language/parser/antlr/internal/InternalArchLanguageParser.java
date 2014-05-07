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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArchLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_IP", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'clusters'", "':'", "'['", "']'", "'recipes'", "'mappings'", "'{'", "'reteMachines'", "'cacheMachines'", "'}'", "'id'", "'traceInfo'", "'ip'", "'nodes'", "'Production'", "'parents'", "'UniquenessEnforcer'", "'Check'", "'parent'", "'Trimmer'", "'mask'", "'Join'", "'leftParent'", "'rightParent'", "'AntiJoin'", "'sourceArity'", "'sourceIndices'", "'from'", "'to'"
    };
    public static final int RULE_ID=4;
    public static final int T__40=40;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_IP=6;
    public static final int RULE_INT=7;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalArchLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalArchLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalArchLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g"; }



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



    // $ANTLR start "entryRuleConfiguration"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:67:1: entryRuleConfiguration returns [EObject current=null] : iv_ruleConfiguration= ruleConfiguration EOF ;
    public final EObject entryRuleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConfiguration = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:68:2: (iv_ruleConfiguration= ruleConfiguration EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:69:2: iv_ruleConfiguration= ruleConfiguration EOF
            {
             newCompositeNode(grammarAccess.getConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_entryRuleConfiguration75);
            iv_ruleConfiguration=ruleConfiguration();

            state._fsp--;

             current =iv_ruleConfiguration; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConfiguration85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:76:1: ruleConfiguration returns [EObject current=null] : ( () (otherlv_1= 'clusters' otherlv_2= ':' otherlv_3= '[' ( (lv_clusters_4_0= ruleCluster ) )* otherlv_5= ']' )? (otherlv_6= 'recipes' otherlv_7= ':' otherlv_8= '[' ( (lv_reteRecipes_9_0= ruleReteRecipe ) )* otherlv_10= ']' )? (otherlv_11= 'mappings' otherlv_12= ':' otherlv_13= '[' ( (lv_mappings_14_0= ruleInfrastructureMapping ) )* otherlv_15= ']' )? ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_clusters_4_0 = null;

        EObject lv_reteRecipes_9_0 = null;

        EObject lv_mappings_14_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:79:28: ( ( () (otherlv_1= 'clusters' otherlv_2= ':' otherlv_3= '[' ( (lv_clusters_4_0= ruleCluster ) )* otherlv_5= ']' )? (otherlv_6= 'recipes' otherlv_7= ':' otherlv_8= '[' ( (lv_reteRecipes_9_0= ruleReteRecipe ) )* otherlv_10= ']' )? (otherlv_11= 'mappings' otherlv_12= ':' otherlv_13= '[' ( (lv_mappings_14_0= ruleInfrastructureMapping ) )* otherlv_15= ']' )? ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:80:1: ( () (otherlv_1= 'clusters' otherlv_2= ':' otherlv_3= '[' ( (lv_clusters_4_0= ruleCluster ) )* otherlv_5= ']' )? (otherlv_6= 'recipes' otherlv_7= ':' otherlv_8= '[' ( (lv_reteRecipes_9_0= ruleReteRecipe ) )* otherlv_10= ']' )? (otherlv_11= 'mappings' otherlv_12= ':' otherlv_13= '[' ( (lv_mappings_14_0= ruleInfrastructureMapping ) )* otherlv_15= ']' )? )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:80:1: ( () (otherlv_1= 'clusters' otherlv_2= ':' otherlv_3= '[' ( (lv_clusters_4_0= ruleCluster ) )* otherlv_5= ']' )? (otherlv_6= 'recipes' otherlv_7= ':' otherlv_8= '[' ( (lv_reteRecipes_9_0= ruleReteRecipe ) )* otherlv_10= ']' )? (otherlv_11= 'mappings' otherlv_12= ':' otherlv_13= '[' ( (lv_mappings_14_0= ruleInfrastructureMapping ) )* otherlv_15= ']' )? )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:80:2: () (otherlv_1= 'clusters' otherlv_2= ':' otherlv_3= '[' ( (lv_clusters_4_0= ruleCluster ) )* otherlv_5= ']' )? (otherlv_6= 'recipes' otherlv_7= ':' otherlv_8= '[' ( (lv_reteRecipes_9_0= ruleReteRecipe ) )* otherlv_10= ']' )? (otherlv_11= 'mappings' otherlv_12= ':' otherlv_13= '[' ( (lv_mappings_14_0= ruleInfrastructureMapping ) )* otherlv_15= ']' )?
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:80:2: ()
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getConfigurationAccess().getConfigurationAction_0(),
                        current);
                

            }

            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:86:2: (otherlv_1= 'clusters' otherlv_2= ':' otherlv_3= '[' ( (lv_clusters_4_0= ruleCluster ) )* otherlv_5= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:86:4: otherlv_1= 'clusters' otherlv_2= ':' otherlv_3= '[' ( (lv_clusters_4_0= ruleCluster ) )* otherlv_5= ']'
                    {
                    otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleConfiguration132); 

                        	newLeafNode(otherlv_1, grammarAccess.getConfigurationAccess().getClustersKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleConfiguration144); 

                        	newLeafNode(otherlv_2, grammarAccess.getConfigurationAccess().getColonKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleConfiguration156); 

                        	newLeafNode(otherlv_3, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_1_2());
                        
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:98:1: ( (lv_clusters_4_0= ruleCluster ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==18) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:99:1: (lv_clusters_4_0= ruleCluster )
                    	    {
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:99:1: (lv_clusters_4_0= ruleCluster )
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:100:3: lv_clusters_4_0= ruleCluster
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConfigurationAccess().getClustersClusterParserRuleCall_1_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleCluster_in_ruleConfiguration177);
                    	    lv_clusters_4_0=ruleCluster();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"clusters",
                    	            		lv_clusters_4_0, 
                    	            		"Cluster");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleConfiguration190); 

                        	newLeafNode(otherlv_5, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_1_4());
                        

                    }
                    break;

            }

            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:120:3: (otherlv_6= 'recipes' otherlv_7= ':' otherlv_8= '[' ( (lv_reteRecipes_9_0= ruleReteRecipe ) )* otherlv_10= ']' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:120:5: otherlv_6= 'recipes' otherlv_7= ':' otherlv_8= '[' ( (lv_reteRecipes_9_0= ruleReteRecipe ) )* otherlv_10= ']'
                    {
                    otherlv_6=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleConfiguration205); 

                        	newLeafNode(otherlv_6, grammarAccess.getConfigurationAccess().getRecipesKeyword_2_0());
                        
                    otherlv_7=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleConfiguration217); 

                        	newLeafNode(otherlv_7, grammarAccess.getConfigurationAccess().getColonKeyword_2_1());
                        
                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleConfiguration229); 

                        	newLeafNode(otherlv_8, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_2_2());
                        
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:132:1: ( (lv_reteRecipes_9_0= ruleReteRecipe ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==18) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:133:1: (lv_reteRecipes_9_0= ruleReteRecipe )
                    	    {
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:133:1: (lv_reteRecipes_9_0= ruleReteRecipe )
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:134:3: lv_reteRecipes_9_0= ruleReteRecipe
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConfigurationAccess().getReteRecipesReteRecipeParserRuleCall_2_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleReteRecipe_in_ruleConfiguration250);
                    	    lv_reteRecipes_9_0=ruleReteRecipe();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"reteRecipes",
                    	            		lv_reteRecipes_9_0, 
                    	            		"ReteRecipe");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleConfiguration263); 

                        	newLeafNode(otherlv_10, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_2_4());
                        

                    }
                    break;

            }

            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:154:3: (otherlv_11= 'mappings' otherlv_12= ':' otherlv_13= '[' ( (lv_mappings_14_0= ruleInfrastructureMapping ) )* otherlv_15= ']' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:154:5: otherlv_11= 'mappings' otherlv_12= ':' otherlv_13= '[' ( (lv_mappings_14_0= ruleInfrastructureMapping ) )* otherlv_15= ']'
                    {
                    otherlv_11=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleConfiguration278); 

                        	newLeafNode(otherlv_11, grammarAccess.getConfigurationAccess().getMappingsKeyword_3_0());
                        
                    otherlv_12=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleConfiguration290); 

                        	newLeafNode(otherlv_12, grammarAccess.getConfigurationAccess().getColonKeyword_3_1());
                        
                    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleConfiguration302); 

                        	newLeafNode(otherlv_13, grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_3_2());
                        
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:166:1: ( (lv_mappings_14_0= ruleInfrastructureMapping ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==18) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:167:1: (lv_mappings_14_0= ruleInfrastructureMapping )
                    	    {
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:167:1: (lv_mappings_14_0= ruleInfrastructureMapping )
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:168:3: lv_mappings_14_0= ruleInfrastructureMapping
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConfigurationAccess().getMappingsInfrastructureMappingParserRuleCall_3_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_ruleConfiguration323);
                    	    lv_mappings_14_0=ruleInfrastructureMapping();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"mappings",
                    	            		lv_mappings_14_0, 
                    	            		"InfrastructureMapping");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleConfiguration336); 

                        	newLeafNode(otherlv_15, grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_3_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleCluster"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:196:1: entryRuleCluster returns [EObject current=null] : iv_ruleCluster= ruleCluster EOF ;
    public final EObject entryRuleCluster() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCluster = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:197:2: (iv_ruleCluster= ruleCluster EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:198:2: iv_ruleCluster= ruleCluster EOF
            {
             newCompositeNode(grammarAccess.getClusterRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCluster_in_entryRuleCluster374);
            iv_ruleCluster=ruleCluster();

            state._fsp--;

             current =iv_ruleCluster; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCluster384); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCluster"


    // $ANTLR start "ruleCluster"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:205:1: ruleCluster returns [EObject current=null] : ( () otherlv_1= '{' (otherlv_2= 'reteMachines' otherlv_3= ':' otherlv_4= '[' ( (lv_reteMachines_5_0= ruleMachine ) )* otherlv_6= ']' )? (otherlv_7= 'cacheMachines' otherlv_8= ':' otherlv_9= '[' ( (lv_cacheMachines_10_0= ruleMachine ) )* otherlv_11= ']' )? otherlv_12= '}' ) ;
    public final EObject ruleCluster() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_reteMachines_5_0 = null;

        EObject lv_cacheMachines_10_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:208:28: ( ( () otherlv_1= '{' (otherlv_2= 'reteMachines' otherlv_3= ':' otherlv_4= '[' ( (lv_reteMachines_5_0= ruleMachine ) )* otherlv_6= ']' )? (otherlv_7= 'cacheMachines' otherlv_8= ':' otherlv_9= '[' ( (lv_cacheMachines_10_0= ruleMachine ) )* otherlv_11= ']' )? otherlv_12= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:209:1: ( () otherlv_1= '{' (otherlv_2= 'reteMachines' otherlv_3= ':' otherlv_4= '[' ( (lv_reteMachines_5_0= ruleMachine ) )* otherlv_6= ']' )? (otherlv_7= 'cacheMachines' otherlv_8= ':' otherlv_9= '[' ( (lv_cacheMachines_10_0= ruleMachine ) )* otherlv_11= ']' )? otherlv_12= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:209:1: ( () otherlv_1= '{' (otherlv_2= 'reteMachines' otherlv_3= ':' otherlv_4= '[' ( (lv_reteMachines_5_0= ruleMachine ) )* otherlv_6= ']' )? (otherlv_7= 'cacheMachines' otherlv_8= ':' otherlv_9= '[' ( (lv_cacheMachines_10_0= ruleMachine ) )* otherlv_11= ']' )? otherlv_12= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:209:2: () otherlv_1= '{' (otherlv_2= 'reteMachines' otherlv_3= ':' otherlv_4= '[' ( (lv_reteMachines_5_0= ruleMachine ) )* otherlv_6= ']' )? (otherlv_7= 'cacheMachines' otherlv_8= ':' otherlv_9= '[' ( (lv_cacheMachines_10_0= ruleMachine ) )* otherlv_11= ']' )? otherlv_12= '}'
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:209:2: ()
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:210:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getClusterAccess().getClusterAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCluster430); 

                	newLeafNode(otherlv_1, grammarAccess.getClusterAccess().getLeftCurlyBracketKeyword_1());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:219:1: (otherlv_2= 'reteMachines' otherlv_3= ':' otherlv_4= '[' ( (lv_reteMachines_5_0= ruleMachine ) )* otherlv_6= ']' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:219:3: otherlv_2= 'reteMachines' otherlv_3= ':' otherlv_4= '[' ( (lv_reteMachines_5_0= ruleMachine ) )* otherlv_6= ']'
                    {
                    otherlv_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleCluster443); 

                        	newLeafNode(otherlv_2, grammarAccess.getClusterAccess().getReteMachinesKeyword_2_0());
                        
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCluster455); 

                        	newLeafNode(otherlv_3, grammarAccess.getClusterAccess().getColonKeyword_2_1());
                        
                    otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCluster467); 

                        	newLeafNode(otherlv_4, grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_2_2());
                        
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:231:1: ( (lv_reteMachines_5_0= ruleMachine ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==18) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:232:1: (lv_reteMachines_5_0= ruleMachine )
                    	    {
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:232:1: (lv_reteMachines_5_0= ruleMachine )
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:233:3: lv_reteMachines_5_0= ruleMachine
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getClusterAccess().getReteMachinesMachineParserRuleCall_2_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMachine_in_ruleCluster488);
                    	    lv_reteMachines_5_0=ruleMachine();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getClusterRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"reteMachines",
                    	            		lv_reteMachines_5_0, 
                    	            		"Machine");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleCluster501); 

                        	newLeafNode(otherlv_6, grammarAccess.getClusterAccess().getRightSquareBracketKeyword_2_4());
                        

                    }
                    break;

            }

            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:253:3: (otherlv_7= 'cacheMachines' otherlv_8= ':' otherlv_9= '[' ( (lv_cacheMachines_10_0= ruleMachine ) )* otherlv_11= ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:253:5: otherlv_7= 'cacheMachines' otherlv_8= ':' otherlv_9= '[' ( (lv_cacheMachines_10_0= ruleMachine ) )* otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleCluster516); 

                        	newLeafNode(otherlv_7, grammarAccess.getClusterAccess().getCacheMachinesKeyword_3_0());
                        
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCluster528); 

                        	newLeafNode(otherlv_8, grammarAccess.getClusterAccess().getColonKeyword_3_1());
                        
                    otherlv_9=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCluster540); 

                        	newLeafNode(otherlv_9, grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_3_2());
                        
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:265:1: ( (lv_cacheMachines_10_0= ruleMachine ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==18) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:266:1: (lv_cacheMachines_10_0= ruleMachine )
                    	    {
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:266:1: (lv_cacheMachines_10_0= ruleMachine )
                    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:267:3: lv_cacheMachines_10_0= ruleMachine
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getClusterAccess().getCacheMachinesMachineParserRuleCall_3_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMachine_in_ruleCluster561);
                    	    lv_cacheMachines_10_0=ruleMachine();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getClusterRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"cacheMachines",
                    	            		lv_cacheMachines_10_0, 
                    	            		"Machine");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleCluster574); 

                        	newLeafNode(otherlv_11, grammarAccess.getClusterAccess().getRightSquareBracketKeyword_3_4());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleCluster588); 

                	newLeafNode(otherlv_12, grammarAccess.getClusterAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCluster"


    // $ANTLR start "entryRuleMachine"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:299:1: entryRuleMachine returns [EObject current=null] : iv_ruleMachine= ruleMachine EOF ;
    public final EObject entryRuleMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMachine = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:300:2: (iv_ruleMachine= ruleMachine EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:301:2: iv_ruleMachine= ruleMachine EOF
            {
             newCompositeNode(grammarAccess.getMachineRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_entryRuleMachine624);
            iv_ruleMachine=ruleMachine();

            state._fsp--;

             current =iv_ruleMachine; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMachine634); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMachine"


    // $ANTLR start "ruleMachine"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:308:1: ruleMachine returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'id' otherlv_2= ':' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'traceInfo' otherlv_5= ':' ( (lv_traceInfo_6_0= RULE_STRING ) ) otherlv_7= 'ip' otherlv_8= ':' ( (lv_ip_9_0= RULE_IP ) ) otherlv_10= '}' ) ;
    public final EObject ruleMachine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_traceInfo_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_ip_9_0=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:311:28: ( (otherlv_0= '{' otherlv_1= 'id' otherlv_2= ':' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'traceInfo' otherlv_5= ':' ( (lv_traceInfo_6_0= RULE_STRING ) ) otherlv_7= 'ip' otherlv_8= ':' ( (lv_ip_9_0= RULE_IP ) ) otherlv_10= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:312:1: (otherlv_0= '{' otherlv_1= 'id' otherlv_2= ':' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'traceInfo' otherlv_5= ':' ( (lv_traceInfo_6_0= RULE_STRING ) ) otherlv_7= 'ip' otherlv_8= ':' ( (lv_ip_9_0= RULE_IP ) ) otherlv_10= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:312:1: (otherlv_0= '{' otherlv_1= 'id' otherlv_2= ':' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'traceInfo' otherlv_5= ':' ( (lv_traceInfo_6_0= RULE_STRING ) ) otherlv_7= 'ip' otherlv_8= ':' ( (lv_ip_9_0= RULE_IP ) ) otherlv_10= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:312:3: otherlv_0= '{' otherlv_1= 'id' otherlv_2= ':' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'traceInfo' otherlv_5= ':' ( (lv_traceInfo_6_0= RULE_STRING ) ) otherlv_7= 'ip' otherlv_8= ':' ( (lv_ip_9_0= RULE_IP ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMachine671); 

                	newLeafNode(otherlv_0, grammarAccess.getMachineAccess().getLeftCurlyBracketKeyword_0());
                
            otherlv_1=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleMachine683); 

                	newLeafNode(otherlv_1, grammarAccess.getMachineAccess().getIdKeyword_1());
                
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMachine695); 

                	newLeafNode(otherlv_2, grammarAccess.getMachineAccess().getColonKeyword_2());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:324:1: ( (lv_name_3_0= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:325:1: (lv_name_3_0= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:325:1: (lv_name_3_0= RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:326:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMachine712); 

            			newLeafNode(lv_name_3_0, grammarAccess.getMachineAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMachineRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleMachine729); 

                	newLeafNode(otherlv_4, grammarAccess.getMachineAccess().getTraceInfoKeyword_4());
                
            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMachine741); 

                	newLeafNode(otherlv_5, grammarAccess.getMachineAccess().getColonKeyword_5());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:350:1: ( (lv_traceInfo_6_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:351:1: (lv_traceInfo_6_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:351:1: (lv_traceInfo_6_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:352:3: lv_traceInfo_6_0= RULE_STRING
            {
            lv_traceInfo_6_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleMachine758); 

            			newLeafNode(lv_traceInfo_6_0, grammarAccess.getMachineAccess().getTraceInfoSTRINGTerminalRuleCall_6_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMachineRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_6_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_7=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleMachine775); 

                	newLeafNode(otherlv_7, grammarAccess.getMachineAccess().getIpKeyword_7());
                
            otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMachine787); 

                	newLeafNode(otherlv_8, grammarAccess.getMachineAccess().getColonKeyword_8());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:376:1: ( (lv_ip_9_0= RULE_IP ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:377:1: (lv_ip_9_0= RULE_IP )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:377:1: (lv_ip_9_0= RULE_IP )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:378:3: lv_ip_9_0= RULE_IP
            {
            lv_ip_9_0=(Token)match(input,RULE_IP,FollowSets000.FOLLOW_RULE_IP_in_ruleMachine804); 

            			newLeafNode(lv_ip_9_0, grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_9_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMachineRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ip",
                    		lv_ip_9_0, 
                    		"IP");
            	    

            }


            }

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMachine821); 

                	newLeafNode(otherlv_10, grammarAccess.getMachineAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMachine"


    // $ANTLR start "entryRuleReteRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:406:1: entryRuleReteRecipe returns [EObject current=null] : iv_ruleReteRecipe= ruleReteRecipe EOF ;
    public final EObject entryRuleReteRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReteRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:407:2: (iv_ruleReteRecipe= ruleReteRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:408:2: iv_ruleReteRecipe= ruleReteRecipe EOF
            {
             newCompositeNode(grammarAccess.getReteRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteRecipe_in_entryRuleReteRecipe857);
            iv_ruleReteRecipe=ruleReteRecipe();

            state._fsp--;

             current =iv_ruleReteRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReteRecipe867); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReteRecipe"


    // $ANTLR start "ruleReteRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:415:1: ruleReteRecipe returns [EObject current=null] : ( () otherlv_1= '{' otherlv_2= 'nodes' otherlv_3= ':' otherlv_4= '[' ( (lv_recipeNodes_5_0= ruleReteNodeRecipe ) )* otherlv_6= ']' otherlv_7= '}' ) ;
    public final EObject ruleReteRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_recipeNodes_5_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:418:28: ( ( () otherlv_1= '{' otherlv_2= 'nodes' otherlv_3= ':' otherlv_4= '[' ( (lv_recipeNodes_5_0= ruleReteNodeRecipe ) )* otherlv_6= ']' otherlv_7= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:419:1: ( () otherlv_1= '{' otherlv_2= 'nodes' otherlv_3= ':' otherlv_4= '[' ( (lv_recipeNodes_5_0= ruleReteNodeRecipe ) )* otherlv_6= ']' otherlv_7= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:419:1: ( () otherlv_1= '{' otherlv_2= 'nodes' otherlv_3= ':' otherlv_4= '[' ( (lv_recipeNodes_5_0= ruleReteNodeRecipe ) )* otherlv_6= ']' otherlv_7= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:419:2: () otherlv_1= '{' otherlv_2= 'nodes' otherlv_3= ':' otherlv_4= '[' ( (lv_recipeNodes_5_0= ruleReteNodeRecipe ) )* otherlv_6= ']' otherlv_7= '}'
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:419:2: ()
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:420:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReteRecipeAccess().getReteRecipeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleReteRecipe913); 

                	newLeafNode(otherlv_1, grammarAccess.getReteRecipeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleReteRecipe925); 

                	newLeafNode(otherlv_2, grammarAccess.getReteRecipeAccess().getNodesKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleReteRecipe937); 

                	newLeafNode(otherlv_3, grammarAccess.getReteRecipeAccess().getColonKeyword_3());
                
            otherlv_4=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleReteRecipe949); 

                	newLeafNode(otherlv_4, grammarAccess.getReteRecipeAccess().getLeftSquareBracketKeyword_4());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:441:1: ( (lv_recipeNodes_5_0= ruleReteNodeRecipe ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26||(LA11_0>=28 && LA11_0<=29)||LA11_0==31||LA11_0==33||LA11_0==36) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:442:1: (lv_recipeNodes_5_0= ruleReteNodeRecipe )
            	    {
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:442:1: (lv_recipeNodes_5_0= ruleReteNodeRecipe )
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:443:3: lv_recipeNodes_5_0= ruleReteNodeRecipe
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getReteRecipeAccess().getRecipeNodesReteNodeRecipeParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleReteNodeRecipe_in_ruleReteRecipe970);
            	    lv_recipeNodes_5_0=ruleReteNodeRecipe();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getReteRecipeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"recipeNodes",
            	            		lv_recipeNodes_5_0, 
            	            		"ReteNodeRecipe");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleReteRecipe983); 

                	newLeafNode(otherlv_6, grammarAccess.getReteRecipeAccess().getRightSquareBracketKeyword_6());
                
            otherlv_7=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleReteRecipe995); 

                	newLeafNode(otherlv_7, grammarAccess.getReteRecipeAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReteRecipe"


    // $ANTLR start "entryRuleReteNodeRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:475:1: entryRuleReteNodeRecipe returns [EObject current=null] : iv_ruleReteNodeRecipe= ruleReteNodeRecipe EOF ;
    public final EObject entryRuleReteNodeRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReteNodeRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:476:2: (iv_ruleReteNodeRecipe= ruleReteNodeRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:477:2: iv_ruleReteNodeRecipe= ruleReteNodeRecipe EOF
            {
             newCompositeNode(grammarAccess.getReteNodeRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteNodeRecipe_in_entryRuleReteNodeRecipe1031);
            iv_ruleReteNodeRecipe=ruleReteNodeRecipe();

            state._fsp--;

             current =iv_ruleReteNodeRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReteNodeRecipe1041); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReteNodeRecipe"


    // $ANTLR start "ruleReteNodeRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:484:1: ruleReteNodeRecipe returns [EObject current=null] : (this_ProductionRecipe_0= ruleProductionRecipe | this_UniquenessEnforcerRecipe_1= ruleUniquenessEnforcerRecipe | this_CheckRecipe_2= ruleCheckRecipe | this_TrimmerRecipe_3= ruleTrimmerRecipe | this_JoinRecipe_4= ruleJoinRecipe | this_AntiJoinRecipe_5= ruleAntiJoinRecipe ) ;
    public final EObject ruleReteNodeRecipe() throws RecognitionException {
        EObject current = null;

        EObject this_ProductionRecipe_0 = null;

        EObject this_UniquenessEnforcerRecipe_1 = null;

        EObject this_CheckRecipe_2 = null;

        EObject this_TrimmerRecipe_3 = null;

        EObject this_JoinRecipe_4 = null;

        EObject this_AntiJoinRecipe_5 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:487:28: ( (this_ProductionRecipe_0= ruleProductionRecipe | this_UniquenessEnforcerRecipe_1= ruleUniquenessEnforcerRecipe | this_CheckRecipe_2= ruleCheckRecipe | this_TrimmerRecipe_3= ruleTrimmerRecipe | this_JoinRecipe_4= ruleJoinRecipe | this_AntiJoinRecipe_5= ruleAntiJoinRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:488:1: (this_ProductionRecipe_0= ruleProductionRecipe | this_UniquenessEnforcerRecipe_1= ruleUniquenessEnforcerRecipe | this_CheckRecipe_2= ruleCheckRecipe | this_TrimmerRecipe_3= ruleTrimmerRecipe | this_JoinRecipe_4= ruleJoinRecipe | this_AntiJoinRecipe_5= ruleAntiJoinRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:488:1: (this_ProductionRecipe_0= ruleProductionRecipe | this_UniquenessEnforcerRecipe_1= ruleUniquenessEnforcerRecipe | this_CheckRecipe_2= ruleCheckRecipe | this_TrimmerRecipe_3= ruleTrimmerRecipe | this_JoinRecipe_4= ruleJoinRecipe | this_AntiJoinRecipe_5= ruleAntiJoinRecipe )
            int alt12=6;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt12=1;
                }
                break;
            case 28:
                {
                alt12=2;
                }
                break;
            case 29:
                {
                alt12=3;
                }
                break;
            case 31:
                {
                alt12=4;
                }
                break;
            case 33:
                {
                alt12=5;
                }
                break;
            case 36:
                {
                alt12=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:489:5: this_ProductionRecipe_0= ruleProductionRecipe
                    {
                     
                            newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getProductionRecipeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleProductionRecipe_in_ruleReteNodeRecipe1088);
                    this_ProductionRecipe_0=ruleProductionRecipe();

                    state._fsp--;

                     
                            current = this_ProductionRecipe_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:499:5: this_UniquenessEnforcerRecipe_1= ruleUniquenessEnforcerRecipe
                    {
                     
                            newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getUniquenessEnforcerRecipeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUniquenessEnforcerRecipe_in_ruleReteNodeRecipe1115);
                    this_UniquenessEnforcerRecipe_1=ruleUniquenessEnforcerRecipe();

                    state._fsp--;

                     
                            current = this_UniquenessEnforcerRecipe_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:509:5: this_CheckRecipe_2= ruleCheckRecipe
                    {
                     
                            newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getCheckRecipeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCheckRecipe_in_ruleReteNodeRecipe1142);
                    this_CheckRecipe_2=ruleCheckRecipe();

                    state._fsp--;

                     
                            current = this_CheckRecipe_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:519:5: this_TrimmerRecipe_3= ruleTrimmerRecipe
                    {
                     
                            newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getTrimmerRecipeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleTrimmerRecipe_in_ruleReteNodeRecipe1169);
                    this_TrimmerRecipe_3=ruleTrimmerRecipe();

                    state._fsp--;

                     
                            current = this_TrimmerRecipe_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:529:5: this_JoinRecipe_4= ruleJoinRecipe
                    {
                     
                            newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getJoinRecipeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleJoinRecipe_in_ruleReteNodeRecipe1196);
                    this_JoinRecipe_4=ruleJoinRecipe();

                    state._fsp--;

                     
                            current = this_JoinRecipe_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:539:5: this_AntiJoinRecipe_5= ruleAntiJoinRecipe
                    {
                     
                            newCompositeNode(grammarAccess.getReteNodeRecipeAccess().getAntiJoinRecipeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAntiJoinRecipe_in_ruleReteNodeRecipe1223);
                    this_AntiJoinRecipe_5=ruleAntiJoinRecipe();

                    state._fsp--;

                     
                            current = this_AntiJoinRecipe_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReteNodeRecipe"


    // $ANTLR start "entryRuleProductionRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:555:1: entryRuleProductionRecipe returns [EObject current=null] : iv_ruleProductionRecipe= ruleProductionRecipe EOF ;
    public final EObject entryRuleProductionRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductionRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:556:2: (iv_ruleProductionRecipe= ruleProductionRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:557:2: iv_ruleProductionRecipe= ruleProductionRecipe EOF
            {
             newCompositeNode(grammarAccess.getProductionRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProductionRecipe_in_entryRuleProductionRecipe1258);
            iv_ruleProductionRecipe=ruleProductionRecipe();

            state._fsp--;

             current =iv_ruleProductionRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProductionRecipe1268); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProductionRecipe"


    // $ANTLR start "ruleProductionRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:564:1: ruleProductionRecipe returns [EObject current=null] : (otherlv_0= 'Production' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}' ) ;
    public final EObject ruleProductionRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_traceInfo_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:567:28: ( (otherlv_0= 'Production' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:568:1: (otherlv_0= 'Production' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:568:1: (otherlv_0= 'Production' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:568:3: otherlv_0= 'Production' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleProductionRecipe1305); 

                	newLeafNode(otherlv_0, grammarAccess.getProductionRecipeAccess().getProductionKeyword_0());
                
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleProductionRecipe1317); 

                	newLeafNode(otherlv_1, grammarAccess.getProductionRecipeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleProductionRecipe1329); 

                	newLeafNode(otherlv_2, grammarAccess.getProductionRecipeAccess().getTraceInfoKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleProductionRecipe1341); 

                	newLeafNode(otherlv_3, grammarAccess.getProductionRecipeAccess().getColonKeyword_3());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:584:1: ( (lv_traceInfo_4_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:585:1: (lv_traceInfo_4_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:585:1: (lv_traceInfo_4_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:586:3: lv_traceInfo_4_0= RULE_STRING
            {
            lv_traceInfo_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleProductionRecipe1358); 

            			newLeafNode(lv_traceInfo_4_0, grammarAccess.getProductionRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProductionRecipeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_4_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleProductionRecipe1375); 

                	newLeafNode(otherlv_5, grammarAccess.getProductionRecipeAccess().getParentsKeyword_5());
                
            otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleProductionRecipe1387); 

                	newLeafNode(otherlv_6, grammarAccess.getProductionRecipeAccess().getColonKeyword_6());
                
            otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleProductionRecipe1399); 

                	newLeafNode(otherlv_7, grammarAccess.getProductionRecipeAccess().getLeftSquareBracketKeyword_7());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:614:1: ( (otherlv_8= RULE_ID ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:615:1: (otherlv_8= RULE_ID )
            	    {
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:615:1: (otherlv_8= RULE_ID )
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:616:3: otherlv_8= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getProductionRecipeRule());
            	    	        }
            	            
            	    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProductionRecipe1419); 

            	    		newLeafNode(otherlv_8, grammarAccess.getProductionRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleProductionRecipe1432); 

                	newLeafNode(otherlv_9, grammarAccess.getProductionRecipeAccess().getRightSquareBracketKeyword_9());
                
            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleProductionRecipe1444); 

                	newLeafNode(otherlv_10, grammarAccess.getProductionRecipeAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProductionRecipe"


    // $ANTLR start "entryRuleUniquenessEnforcerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:643:1: entryRuleUniquenessEnforcerRecipe returns [EObject current=null] : iv_ruleUniquenessEnforcerRecipe= ruleUniquenessEnforcerRecipe EOF ;
    public final EObject entryRuleUniquenessEnforcerRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUniquenessEnforcerRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:644:2: (iv_ruleUniquenessEnforcerRecipe= ruleUniquenessEnforcerRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:645:2: iv_ruleUniquenessEnforcerRecipe= ruleUniquenessEnforcerRecipe EOF
            {
             newCompositeNode(grammarAccess.getUniquenessEnforcerRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUniquenessEnforcerRecipe_in_entryRuleUniquenessEnforcerRecipe1480);
            iv_ruleUniquenessEnforcerRecipe=ruleUniquenessEnforcerRecipe();

            state._fsp--;

             current =iv_ruleUniquenessEnforcerRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUniquenessEnforcerRecipe1490); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUniquenessEnforcerRecipe"


    // $ANTLR start "ruleUniquenessEnforcerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:652:1: ruleUniquenessEnforcerRecipe returns [EObject current=null] : (otherlv_0= 'UniquenessEnforcer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}' ) ;
    public final EObject ruleUniquenessEnforcerRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_traceInfo_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:655:28: ( (otherlv_0= 'UniquenessEnforcer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:656:1: (otherlv_0= 'UniquenessEnforcer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:656:1: (otherlv_0= 'UniquenessEnforcer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:656:3: otherlv_0= 'UniquenessEnforcer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parents' otherlv_6= ':' otherlv_7= '[' ( (otherlv_8= RULE_ID ) )* otherlv_9= ']' otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleUniquenessEnforcerRecipe1527); 

                	newLeafNode(otherlv_0, grammarAccess.getUniquenessEnforcerRecipeAccess().getUniquenessEnforcerKeyword_0());
                
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleUniquenessEnforcerRecipe1539); 

                	newLeafNode(otherlv_1, grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleUniquenessEnforcerRecipe1551); 

                	newLeafNode(otherlv_2, grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleUniquenessEnforcerRecipe1563); 

                	newLeafNode(otherlv_3, grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_3());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:672:1: ( (lv_traceInfo_4_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:673:1: (lv_traceInfo_4_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:673:1: (lv_traceInfo_4_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:674:3: lv_traceInfo_4_0= RULE_STRING
            {
            lv_traceInfo_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleUniquenessEnforcerRecipe1580); 

            			newLeafNode(lv_traceInfo_4_0, grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUniquenessEnforcerRecipeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_4_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleUniquenessEnforcerRecipe1597); 

                	newLeafNode(otherlv_5, grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsKeyword_5());
                
            otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleUniquenessEnforcerRecipe1609); 

                	newLeafNode(otherlv_6, grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_6());
                
            otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleUniquenessEnforcerRecipe1621); 

                	newLeafNode(otherlv_7, grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftSquareBracketKeyword_7());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:702:1: ( (otherlv_8= RULE_ID ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:703:1: (otherlv_8= RULE_ID )
            	    {
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:703:1: (otherlv_8= RULE_ID )
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:704:3: otherlv_8= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getUniquenessEnforcerRecipeRule());
            	    	        }
            	            
            	    otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleUniquenessEnforcerRecipe1641); 

            	    		newLeafNode(otherlv_8, grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_9=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleUniquenessEnforcerRecipe1654); 

                	newLeafNode(otherlv_9, grammarAccess.getUniquenessEnforcerRecipeAccess().getRightSquareBracketKeyword_9());
                
            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleUniquenessEnforcerRecipe1666); 

                	newLeafNode(otherlv_10, grammarAccess.getUniquenessEnforcerRecipeAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUniquenessEnforcerRecipe"


    // $ANTLR start "entryRuleCheckRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:731:1: entryRuleCheckRecipe returns [EObject current=null] : iv_ruleCheckRecipe= ruleCheckRecipe EOF ;
    public final EObject entryRuleCheckRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:732:2: (iv_ruleCheckRecipe= ruleCheckRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:733:2: iv_ruleCheckRecipe= ruleCheckRecipe EOF
            {
             newCompositeNode(grammarAccess.getCheckRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCheckRecipe_in_entryRuleCheckRecipe1702);
            iv_ruleCheckRecipe=ruleCheckRecipe();

            state._fsp--;

             current =iv_ruleCheckRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCheckRecipe1712); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCheckRecipe"


    // $ANTLR start "ruleCheckRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:740:1: ruleCheckRecipe returns [EObject current=null] : (otherlv_0= 'Check' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parent' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' ) ;
    public final EObject ruleCheckRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_traceInfo_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:743:28: ( (otherlv_0= 'Check' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parent' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:744:1: (otherlv_0= 'Check' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parent' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:744:1: (otherlv_0= 'Check' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parent' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:744:3: otherlv_0= 'Check' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'parent' otherlv_6= ':' ( (otherlv_7= RULE_ID ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCheckRecipe1749); 

                	newLeafNode(otherlv_0, grammarAccess.getCheckRecipeAccess().getCheckKeyword_0());
                
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleCheckRecipe1761); 

                	newLeafNode(otherlv_1, grammarAccess.getCheckRecipeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleCheckRecipe1773); 

                	newLeafNode(otherlv_2, grammarAccess.getCheckRecipeAccess().getTraceInfoKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCheckRecipe1785); 

                	newLeafNode(otherlv_3, grammarAccess.getCheckRecipeAccess().getColonKeyword_3());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:760:1: ( (lv_traceInfo_4_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:761:1: (lv_traceInfo_4_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:761:1: (lv_traceInfo_4_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:762:3: lv_traceInfo_4_0= RULE_STRING
            {
            lv_traceInfo_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleCheckRecipe1802); 

            			newLeafNode(lv_traceInfo_4_0, grammarAccess.getCheckRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCheckRecipeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_4_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_5=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCheckRecipe1819); 

                	newLeafNode(otherlv_5, grammarAccess.getCheckRecipeAccess().getParentKeyword_5());
                
            otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCheckRecipe1831); 

                	newLeafNode(otherlv_6, grammarAccess.getCheckRecipeAccess().getColonKeyword_6());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:786:1: ( (otherlv_7= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:787:1: (otherlv_7= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:787:1: (otherlv_7= RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:788:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCheckRecipeRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCheckRecipe1851); 

            		newLeafNode(otherlv_7, grammarAccess.getCheckRecipeAccess().getParentReteNodeRecipeCrossReference_7_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleCheckRecipe1863); 

                	newLeafNode(otherlv_8, grammarAccess.getCheckRecipeAccess().getRightCurlyBracketKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCheckRecipe"


    // $ANTLR start "entryRuleTrimmerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:811:1: entryRuleTrimmerRecipe returns [EObject current=null] : iv_ruleTrimmerRecipe= ruleTrimmerRecipe EOF ;
    public final EObject entryRuleTrimmerRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrimmerRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:812:2: (iv_ruleTrimmerRecipe= ruleTrimmerRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:813:2: iv_ruleTrimmerRecipe= ruleTrimmerRecipe EOF
            {
             newCompositeNode(grammarAccess.getTrimmerRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTrimmerRecipe_in_entryRuleTrimmerRecipe1899);
            iv_ruleTrimmerRecipe=ruleTrimmerRecipe();

            state._fsp--;

             current =iv_ruleTrimmerRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrimmerRecipe1909); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrimmerRecipe"


    // $ANTLR start "ruleTrimmerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:820:1: ruleTrimmerRecipe returns [EObject current=null] : (otherlv_0= 'Trimmer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'mask' otherlv_6= ':' ( (lv_mask_7_0= ruleMask ) ) otherlv_8= 'parent' otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}' ) ;
    public final EObject ruleTrimmerRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_traceInfo_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        EObject lv_mask_7_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:823:28: ( (otherlv_0= 'Trimmer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'mask' otherlv_6= ':' ( (lv_mask_7_0= ruleMask ) ) otherlv_8= 'parent' otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:824:1: (otherlv_0= 'Trimmer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'mask' otherlv_6= ':' ( (lv_mask_7_0= ruleMask ) ) otherlv_8= 'parent' otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:824:1: (otherlv_0= 'Trimmer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'mask' otherlv_6= ':' ( (lv_mask_7_0= ruleMask ) ) otherlv_8= 'parent' otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:824:3: otherlv_0= 'Trimmer' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'mask' otherlv_6= ':' ( (lv_mask_7_0= ruleMask ) ) otherlv_8= 'parent' otherlv_9= ':' ( (otherlv_10= RULE_ID ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleTrimmerRecipe1946); 

                	newLeafNode(otherlv_0, grammarAccess.getTrimmerRecipeAccess().getTrimmerKeyword_0());
                
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleTrimmerRecipe1958); 

                	newLeafNode(otherlv_1, grammarAccess.getTrimmerRecipeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleTrimmerRecipe1970); 

                	newLeafNode(otherlv_2, grammarAccess.getTrimmerRecipeAccess().getTraceInfoKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTrimmerRecipe1982); 

                	newLeafNode(otherlv_3, grammarAccess.getTrimmerRecipeAccess().getColonKeyword_3());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:840:1: ( (lv_traceInfo_4_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:841:1: (lv_traceInfo_4_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:841:1: (lv_traceInfo_4_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:842:3: lv_traceInfo_4_0= RULE_STRING
            {
            lv_traceInfo_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTrimmerRecipe1999); 

            			newLeafNode(lv_traceInfo_4_0, grammarAccess.getTrimmerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTrimmerRecipeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_4_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_5=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTrimmerRecipe2016); 

                	newLeafNode(otherlv_5, grammarAccess.getTrimmerRecipeAccess().getMaskKeyword_5());
                
            otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTrimmerRecipe2028); 

                	newLeafNode(otherlv_6, grammarAccess.getTrimmerRecipeAccess().getColonKeyword_6());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:866:1: ( (lv_mask_7_0= ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:867:1: (lv_mask_7_0= ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:867:1: (lv_mask_7_0= ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:868:3: lv_mask_7_0= ruleMask
            {
             
            	        newCompositeNode(grammarAccess.getTrimmerRecipeAccess().getMaskMaskParserRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_ruleTrimmerRecipe2049);
            lv_mask_7_0=ruleMask();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrimmerRecipeRule());
            	        }
                   		set(
                   			current, 
                   			"mask",
                    		lv_mask_7_0, 
                    		"Mask");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTrimmerRecipe2061); 

                	newLeafNode(otherlv_8, grammarAccess.getTrimmerRecipeAccess().getParentKeyword_8());
                
            otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleTrimmerRecipe2073); 

                	newLeafNode(otherlv_9, grammarAccess.getTrimmerRecipeAccess().getColonKeyword_9());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:892:1: ( (otherlv_10= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:893:1: (otherlv_10= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:893:1: (otherlv_10= RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:894:3: otherlv_10= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTrimmerRecipeRule());
            	        }
                    
            otherlv_10=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleTrimmerRecipe2093); 

            		newLeafNode(otherlv_10, grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeCrossReference_10_0()); 
            	

            }


            }

            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleTrimmerRecipe2105); 

                	newLeafNode(otherlv_11, grammarAccess.getTrimmerRecipeAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrimmerRecipe"


    // $ANTLR start "entryRuleJoinRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:917:1: entryRuleJoinRecipe returns [EObject current=null] : iv_ruleJoinRecipe= ruleJoinRecipe EOF ;
    public final EObject entryRuleJoinRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJoinRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:918:2: (iv_ruleJoinRecipe= ruleJoinRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:919:2: iv_ruleJoinRecipe= ruleJoinRecipe EOF
            {
             newCompositeNode(grammarAccess.getJoinRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleJoinRecipe_in_entryRuleJoinRecipe2141);
            iv_ruleJoinRecipe=ruleJoinRecipe();

            state._fsp--;

             current =iv_ruleJoinRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJoinRecipe2151); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleJoinRecipe"


    // $ANTLR start "ruleJoinRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:926:1: ruleJoinRecipe returns [EObject current=null] : (otherlv_0= 'Join' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) ( (lv_rightParentComplementaryMask_11_0= ruleMask ) )? otherlv_12= '}' ) ;
    public final EObject ruleJoinRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_traceInfo_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        EObject lv_leftParent_7_0 = null;

        EObject lv_rightParent_10_0 = null;

        EObject lv_rightParentComplementaryMask_11_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:929:28: ( (otherlv_0= 'Join' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) ( (lv_rightParentComplementaryMask_11_0= ruleMask ) )? otherlv_12= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:930:1: (otherlv_0= 'Join' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) ( (lv_rightParentComplementaryMask_11_0= ruleMask ) )? otherlv_12= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:930:1: (otherlv_0= 'Join' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) ( (lv_rightParentComplementaryMask_11_0= ruleMask ) )? otherlv_12= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:930:3: otherlv_0= 'Join' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) ( (lv_rightParentComplementaryMask_11_0= ruleMask ) )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleJoinRecipe2188); 

                	newLeafNode(otherlv_0, grammarAccess.getJoinRecipeAccess().getJoinKeyword_0());
                
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleJoinRecipe2200); 

                	newLeafNode(otherlv_1, grammarAccess.getJoinRecipeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleJoinRecipe2212); 

                	newLeafNode(otherlv_2, grammarAccess.getJoinRecipeAccess().getTraceInfoKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleJoinRecipe2224); 

                	newLeafNode(otherlv_3, grammarAccess.getJoinRecipeAccess().getColonKeyword_3());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:946:1: ( (lv_traceInfo_4_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:947:1: (lv_traceInfo_4_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:947:1: (lv_traceInfo_4_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:948:3: lv_traceInfo_4_0= RULE_STRING
            {
            lv_traceInfo_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJoinRecipe2241); 

            			newLeafNode(lv_traceInfo_4_0, grammarAccess.getJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getJoinRecipeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_4_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleJoinRecipe2258); 

                	newLeafNode(otherlv_5, grammarAccess.getJoinRecipeAccess().getLeftParentKeyword_5());
                
            otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleJoinRecipe2270); 

                	newLeafNode(otherlv_6, grammarAccess.getJoinRecipeAccess().getColonKeyword_6());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:972:1: ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:973:1: (lv_leftParent_7_0= ruleProjectionIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:973:1: (lv_leftParent_7_0= ruleProjectionIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:974:3: lv_leftParent_7_0= ruleProjectionIndexerRecipe
            {
             
            	        newCompositeNode(grammarAccess.getJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleProjectionIndexerRecipe_in_ruleJoinRecipe2291);
            lv_leftParent_7_0=ruleProjectionIndexerRecipe();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJoinRecipeRule());
            	        }
                   		set(
                   			current, 
                   			"leftParent",
                    		lv_leftParent_7_0, 
                    		"ProjectionIndexerRecipe");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleJoinRecipe2303); 

                	newLeafNode(otherlv_8, grammarAccess.getJoinRecipeAccess().getRightParentKeyword_8());
                
            otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleJoinRecipe2315); 

                	newLeafNode(otherlv_9, grammarAccess.getJoinRecipeAccess().getColonKeyword_9());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:998:1: ( (lv_rightParent_10_0= ruleIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:999:1: (lv_rightParent_10_0= ruleIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:999:1: (lv_rightParent_10_0= ruleIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1000:3: lv_rightParent_10_0= ruleIndexerRecipe
            {
             
            	        newCompositeNode(grammarAccess.getJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleIndexerRecipe_in_ruleJoinRecipe2336);
            lv_rightParent_10_0=ruleIndexerRecipe();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJoinRecipeRule());
            	        }
                   		set(
                   			current, 
                   			"rightParent",
                    		lv_rightParent_10_0, 
                    		"IndexerRecipe");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1016:2: ( (lv_rightParentComplementaryMask_11_0= ruleMask ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1017:1: (lv_rightParentComplementaryMask_11_0= ruleMask )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1017:1: (lv_rightParentComplementaryMask_11_0= ruleMask )
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1018:3: lv_rightParentComplementaryMask_11_0= ruleMask
                    {
                     
                    	        newCompositeNode(grammarAccess.getJoinRecipeAccess().getRightParentComplementaryMaskMaskParserRuleCall_11_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMask_in_ruleJoinRecipe2357);
                    lv_rightParentComplementaryMask_11_0=ruleMask();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getJoinRecipeRule());
                    	        }
                           		set(
                           			current, 
                           			"rightParentComplementaryMask",
                            		lv_rightParentComplementaryMask_11_0, 
                            		"Mask");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleJoinRecipe2370); 

                	newLeafNode(otherlv_12, grammarAccess.getJoinRecipeAccess().getRightCurlyBracketKeyword_12());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleJoinRecipe"


    // $ANTLR start "entryRuleAntiJoinRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1046:1: entryRuleAntiJoinRecipe returns [EObject current=null] : iv_ruleAntiJoinRecipe= ruleAntiJoinRecipe EOF ;
    public final EObject entryRuleAntiJoinRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAntiJoinRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1047:2: (iv_ruleAntiJoinRecipe= ruleAntiJoinRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1048:2: iv_ruleAntiJoinRecipe= ruleAntiJoinRecipe EOF
            {
             newCompositeNode(grammarAccess.getAntiJoinRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAntiJoinRecipe_in_entryRuleAntiJoinRecipe2406);
            iv_ruleAntiJoinRecipe=ruleAntiJoinRecipe();

            state._fsp--;

             current =iv_ruleAntiJoinRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAntiJoinRecipe2416); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAntiJoinRecipe"


    // $ANTLR start "ruleAntiJoinRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1055:1: ruleAntiJoinRecipe returns [EObject current=null] : (otherlv_0= 'AntiJoin' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) otherlv_11= '}' ) ;
    public final EObject ruleAntiJoinRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_traceInfo_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_leftParent_7_0 = null;

        EObject lv_rightParent_10_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1058:28: ( (otherlv_0= 'AntiJoin' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) otherlv_11= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1059:1: (otherlv_0= 'AntiJoin' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) otherlv_11= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1059:1: (otherlv_0= 'AntiJoin' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) otherlv_11= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1059:3: otherlv_0= 'AntiJoin' otherlv_1= '{' otherlv_2= 'traceInfo' otherlv_3= ':' ( (lv_traceInfo_4_0= RULE_STRING ) ) otherlv_5= 'leftParent' otherlv_6= ':' ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) ) otherlv_8= 'rightParent' otherlv_9= ':' ( (lv_rightParent_10_0= ruleIndexerRecipe ) ) otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleAntiJoinRecipe2453); 

                	newLeafNode(otherlv_0, grammarAccess.getAntiJoinRecipeAccess().getAntiJoinKeyword_0());
                
            otherlv_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleAntiJoinRecipe2465); 

                	newLeafNode(otherlv_1, grammarAccess.getAntiJoinRecipeAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleAntiJoinRecipe2477); 

                	newLeafNode(otherlv_2, grammarAccess.getAntiJoinRecipeAccess().getTraceInfoKeyword_2());
                
            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAntiJoinRecipe2489); 

                	newLeafNode(otherlv_3, grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_3());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1075:1: ( (lv_traceInfo_4_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1076:1: (lv_traceInfo_4_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1076:1: (lv_traceInfo_4_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1077:3: lv_traceInfo_4_0= RULE_STRING
            {
            lv_traceInfo_4_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleAntiJoinRecipe2506); 

            			newLeafNode(lv_traceInfo_4_0, grammarAccess.getAntiJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAntiJoinRecipeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_4_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAntiJoinRecipe2523); 

                	newLeafNode(otherlv_5, grammarAccess.getAntiJoinRecipeAccess().getLeftParentKeyword_5());
                
            otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAntiJoinRecipe2535); 

                	newLeafNode(otherlv_6, grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_6());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1101:1: ( (lv_leftParent_7_0= ruleProjectionIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1102:1: (lv_leftParent_7_0= ruleProjectionIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1102:1: (lv_leftParent_7_0= ruleProjectionIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1103:3: lv_leftParent_7_0= ruleProjectionIndexerRecipe
            {
             
            	        newCompositeNode(grammarAccess.getAntiJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleProjectionIndexerRecipe_in_ruleAntiJoinRecipe2556);
            lv_leftParent_7_0=ruleProjectionIndexerRecipe();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAntiJoinRecipeRule());
            	        }
                   		set(
                   			current, 
                   			"leftParent",
                    		lv_leftParent_7_0, 
                    		"ProjectionIndexerRecipe");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleAntiJoinRecipe2568); 

                	newLeafNode(otherlv_8, grammarAccess.getAntiJoinRecipeAccess().getRightParentKeyword_8());
                
            otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleAntiJoinRecipe2580); 

                	newLeafNode(otherlv_9, grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_9());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1127:1: ( (lv_rightParent_10_0= ruleIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1128:1: (lv_rightParent_10_0= ruleIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1128:1: (lv_rightParent_10_0= ruleIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1129:3: lv_rightParent_10_0= ruleIndexerRecipe
            {
             
            	        newCompositeNode(grammarAccess.getAntiJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleIndexerRecipe_in_ruleAntiJoinRecipe2601);
            lv_rightParent_10_0=ruleIndexerRecipe();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAntiJoinRecipeRule());
            	        }
                   		set(
                   			current, 
                   			"rightParent",
                    		lv_rightParent_10_0, 
                    		"IndexerRecipe");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_11=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAntiJoinRecipe2613); 

                	newLeafNode(otherlv_11, grammarAccess.getAntiJoinRecipeAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAntiJoinRecipe"


    // $ANTLR start "entryRuleIndexerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1157:1: entryRuleIndexerRecipe returns [EObject current=null] : iv_ruleIndexerRecipe= ruleIndexerRecipe EOF ;
    public final EObject entryRuleIndexerRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndexerRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1158:2: (iv_ruleIndexerRecipe= ruleIndexerRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1159:2: iv_ruleIndexerRecipe= ruleIndexerRecipe EOF
            {
             newCompositeNode(grammarAccess.getIndexerRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIndexerRecipe_in_entryRuleIndexerRecipe2649);
            iv_ruleIndexerRecipe=ruleIndexerRecipe();

            state._fsp--;

             current =iv_ruleIndexerRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIndexerRecipe2659); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndexerRecipe"


    // $ANTLR start "ruleIndexerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1166:1: ruleIndexerRecipe returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}' ) ;
    public final EObject ruleIndexerRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_traceInfo_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_mask_6_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1169:28: ( (otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1170:1: (otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1170:1: (otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1170:3: otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleIndexerRecipe2696); 

                	newLeafNode(otherlv_0, grammarAccess.getIndexerRecipeAccess().getLeftCurlyBracketKeyword_0());
                
            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleIndexerRecipe2708); 

                	newLeafNode(otherlv_1, grammarAccess.getIndexerRecipeAccess().getTraceInfoKeyword_1());
                
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleIndexerRecipe2720); 

                	newLeafNode(otherlv_2, grammarAccess.getIndexerRecipeAccess().getColonKeyword_2());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1182:1: ( (lv_traceInfo_3_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1183:1: (lv_traceInfo_3_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1183:1: (lv_traceInfo_3_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1184:3: lv_traceInfo_3_0= RULE_STRING
            {
            lv_traceInfo_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleIndexerRecipe2737); 

            			newLeafNode(lv_traceInfo_3_0, grammarAccess.getIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIndexerRecipeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleIndexerRecipe2754); 

                	newLeafNode(otherlv_4, grammarAccess.getIndexerRecipeAccess().getMaskKeyword_4());
                
            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleIndexerRecipe2766); 

                	newLeafNode(otherlv_5, grammarAccess.getIndexerRecipeAccess().getColonKeyword_5());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1208:1: ( (lv_mask_6_0= ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1209:1: (lv_mask_6_0= ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1209:1: (lv_mask_6_0= ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1210:3: lv_mask_6_0= ruleMask
            {
             
            	        newCompositeNode(grammarAccess.getIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_ruleIndexerRecipe2787);
            lv_mask_6_0=ruleMask();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIndexerRecipeRule());
            	        }
                   		set(
                   			current, 
                   			"mask",
                    		lv_mask_6_0, 
                    		"Mask");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleIndexerRecipe2799); 

                	newLeafNode(otherlv_7, grammarAccess.getIndexerRecipeAccess().getParentKeyword_7());
                
            otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleIndexerRecipe2811); 

                	newLeafNode(otherlv_8, grammarAccess.getIndexerRecipeAccess().getColonKeyword_8());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1234:1: ( (otherlv_9= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1235:1: (otherlv_9= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1235:1: (otherlv_9= RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1236:3: otherlv_9= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getIndexerRecipeRule());
            	        }
                    
            otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleIndexerRecipe2831); 

            		newLeafNode(otherlv_9, grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 
            	

            }


            }

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleIndexerRecipe2843); 

                	newLeafNode(otherlv_10, grammarAccess.getIndexerRecipeAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndexerRecipe"


    // $ANTLR start "entryRuleProjectionIndexerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1259:1: entryRuleProjectionIndexerRecipe returns [EObject current=null] : iv_ruleProjectionIndexerRecipe= ruleProjectionIndexerRecipe EOF ;
    public final EObject entryRuleProjectionIndexerRecipe() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProjectionIndexerRecipe = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1260:2: (iv_ruleProjectionIndexerRecipe= ruleProjectionIndexerRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1261:2: iv_ruleProjectionIndexerRecipe= ruleProjectionIndexerRecipe EOF
            {
             newCompositeNode(grammarAccess.getProjectionIndexerRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProjectionIndexerRecipe_in_entryRuleProjectionIndexerRecipe2879);
            iv_ruleProjectionIndexerRecipe=ruleProjectionIndexerRecipe();

            state._fsp--;

             current =iv_ruleProjectionIndexerRecipe; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProjectionIndexerRecipe2889); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProjectionIndexerRecipe"


    // $ANTLR start "ruleProjectionIndexerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1268:1: ruleProjectionIndexerRecipe returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}' ) ;
    public final EObject ruleProjectionIndexerRecipe() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_traceInfo_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_mask_6_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1271:28: ( (otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1272:1: (otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1272:1: (otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1272:3: otherlv_0= '{' otherlv_1= 'traceInfo' otherlv_2= ':' ( (lv_traceInfo_3_0= RULE_STRING ) ) otherlv_4= 'mask' otherlv_5= ':' ( (lv_mask_6_0= ruleMask ) ) otherlv_7= 'parent' otherlv_8= ':' ( (otherlv_9= RULE_ID ) ) otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleProjectionIndexerRecipe2926); 

                	newLeafNode(otherlv_0, grammarAccess.getProjectionIndexerRecipeAccess().getLeftCurlyBracketKeyword_0());
                
            otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleProjectionIndexerRecipe2938); 

                	newLeafNode(otherlv_1, grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoKeyword_1());
                
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleProjectionIndexerRecipe2950); 

                	newLeafNode(otherlv_2, grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_2());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1284:1: ( (lv_traceInfo_3_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1285:1: (lv_traceInfo_3_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1285:1: (lv_traceInfo_3_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1286:3: lv_traceInfo_3_0= RULE_STRING
            {
            lv_traceInfo_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleProjectionIndexerRecipe2967); 

            			newLeafNode(lv_traceInfo_3_0, grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getProjectionIndexerRecipeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"traceInfo",
                    		lv_traceInfo_3_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleProjectionIndexerRecipe2984); 

                	newLeafNode(otherlv_4, grammarAccess.getProjectionIndexerRecipeAccess().getMaskKeyword_4());
                
            otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleProjectionIndexerRecipe2996); 

                	newLeafNode(otherlv_5, grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_5());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1310:1: ( (lv_mask_6_0= ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1311:1: (lv_mask_6_0= ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1311:1: (lv_mask_6_0= ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1312:3: lv_mask_6_0= ruleMask
            {
             
            	        newCompositeNode(grammarAccess.getProjectionIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_ruleProjectionIndexerRecipe3017);
            lv_mask_6_0=ruleMask();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProjectionIndexerRecipeRule());
            	        }
                   		set(
                   			current, 
                   			"mask",
                    		lv_mask_6_0, 
                    		"Mask");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleProjectionIndexerRecipe3029); 

                	newLeafNode(otherlv_7, grammarAccess.getProjectionIndexerRecipeAccess().getParentKeyword_7());
                
            otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleProjectionIndexerRecipe3041); 

                	newLeafNode(otherlv_8, grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_8());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1336:1: ( (otherlv_9= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1337:1: (otherlv_9= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1337:1: (otherlv_9= RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1338:3: otherlv_9= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getProjectionIndexerRecipeRule());
            	        }
                    
            otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleProjectionIndexerRecipe3061); 

            		newLeafNode(otherlv_9, grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 
            	

            }


            }

            otherlv_10=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleProjectionIndexerRecipe3073); 

                	newLeafNode(otherlv_10, grammarAccess.getProjectionIndexerRecipeAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProjectionIndexerRecipe"


    // $ANTLR start "entryRuleMask"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1361:1: entryRuleMask returns [EObject current=null] : iv_ruleMask= ruleMask EOF ;
    public final EObject entryRuleMask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMask = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1362:2: (iv_ruleMask= ruleMask EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1363:2: iv_ruleMask= ruleMask EOF
            {
             newCompositeNode(grammarAccess.getMaskRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_entryRuleMask3109);
            iv_ruleMask=ruleMask();

            state._fsp--;

             current =iv_ruleMask; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMask3119); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMask"


    // $ANTLR start "ruleMask"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1370:1: ruleMask returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'sourceArity' otherlv_2= ':' ( (lv_sourceArity_3_0= RULE_INT ) ) (otherlv_4= 'sourceIndices' otherlv_5= ':' otherlv_6= '[' ( (lv_sourceIndices_7_0= RULE_INT ) )* otherlv_8= ']' )* otherlv_9= '}' ) ;
    public final EObject ruleMask() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_sourceArity_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_sourceIndices_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1373:28: ( (otherlv_0= '{' otherlv_1= 'sourceArity' otherlv_2= ':' ( (lv_sourceArity_3_0= RULE_INT ) ) (otherlv_4= 'sourceIndices' otherlv_5= ':' otherlv_6= '[' ( (lv_sourceIndices_7_0= RULE_INT ) )* otherlv_8= ']' )* otherlv_9= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1374:1: (otherlv_0= '{' otherlv_1= 'sourceArity' otherlv_2= ':' ( (lv_sourceArity_3_0= RULE_INT ) ) (otherlv_4= 'sourceIndices' otherlv_5= ':' otherlv_6= '[' ( (lv_sourceIndices_7_0= RULE_INT ) )* otherlv_8= ']' )* otherlv_9= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1374:1: (otherlv_0= '{' otherlv_1= 'sourceArity' otherlv_2= ':' ( (lv_sourceArity_3_0= RULE_INT ) ) (otherlv_4= 'sourceIndices' otherlv_5= ':' otherlv_6= '[' ( (lv_sourceIndices_7_0= RULE_INT ) )* otherlv_8= ']' )* otherlv_9= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1374:3: otherlv_0= '{' otherlv_1= 'sourceArity' otherlv_2= ':' ( (lv_sourceArity_3_0= RULE_INT ) ) (otherlv_4= 'sourceIndices' otherlv_5= ':' otherlv_6= '[' ( (lv_sourceIndices_7_0= RULE_INT ) )* otherlv_8= ']' )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleMask3156); 

                	newLeafNode(otherlv_0, grammarAccess.getMaskAccess().getLeftCurlyBracketKeyword_0());
                
            otherlv_1=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleMask3168); 

                	newLeafNode(otherlv_1, grammarAccess.getMaskAccess().getSourceArityKeyword_1());
                
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMask3180); 

                	newLeafNode(otherlv_2, grammarAccess.getMaskAccess().getColonKeyword_2());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1386:1: ( (lv_sourceArity_3_0= RULE_INT ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1387:1: (lv_sourceArity_3_0= RULE_INT )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1387:1: (lv_sourceArity_3_0= RULE_INT )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1388:3: lv_sourceArity_3_0= RULE_INT
            {
            lv_sourceArity_3_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMask3197); 

            			newLeafNode(lv_sourceArity_3_0, grammarAccess.getMaskAccess().getSourceArityINTTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMaskRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"sourceArity",
                    		lv_sourceArity_3_0, 
                    		"INT");
            	    

            }


            }

            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1404:2: (otherlv_4= 'sourceIndices' otherlv_5= ':' otherlv_6= '[' ( (lv_sourceIndices_7_0= RULE_INT ) )* otherlv_8= ']' )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==38) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1404:4: otherlv_4= 'sourceIndices' otherlv_5= ':' otherlv_6= '[' ( (lv_sourceIndices_7_0= RULE_INT ) )* otherlv_8= ']'
            	    {
            	    otherlv_4=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMask3215); 

            	        	newLeafNode(otherlv_4, grammarAccess.getMaskAccess().getSourceIndicesKeyword_4_0());
            	        
            	    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMask3227); 

            	        	newLeafNode(otherlv_5, grammarAccess.getMaskAccess().getColonKeyword_4_1());
            	        
            	    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMask3239); 

            	        	newLeafNode(otherlv_6, grammarAccess.getMaskAccess().getLeftSquareBracketKeyword_4_2());
            	        
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1416:1: ( (lv_sourceIndices_7_0= RULE_INT ) )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==RULE_INT) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1417:1: (lv_sourceIndices_7_0= RULE_INT )
            	    	    {
            	    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1417:1: (lv_sourceIndices_7_0= RULE_INT )
            	    	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1418:3: lv_sourceIndices_7_0= RULE_INT
            	    	    {
            	    	    lv_sourceIndices_7_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMask3256); 

            	    	    			newLeafNode(lv_sourceIndices_7_0, grammarAccess.getMaskAccess().getSourceIndicesINTTerminalRuleCall_4_3_0()); 
            	    	    		

            	    	    	        if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getMaskRule());
            	    	    	        }
            	    	           		addWithLastConsumed(
            	    	           			current, 
            	    	           			"sourceIndices",
            	    	            		lv_sourceIndices_7_0, 
            	    	            		"INT");
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop16;
            	        }
            	    } while (true);

            	    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMask3274); 

            	        	newLeafNode(otherlv_8, grammarAccess.getMaskAccess().getRightSquareBracketKeyword_4_4());
            	        

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleMask3288); 

                	newLeafNode(otherlv_9, grammarAccess.getMaskAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMask"


    // $ANTLR start "entryRuleInfrastructureMapping"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1450:1: entryRuleInfrastructureMapping returns [EObject current=null] : iv_ruleInfrastructureMapping= ruleInfrastructureMapping EOF ;
    public final EObject entryRuleInfrastructureMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureMapping = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1451:2: (iv_ruleInfrastructureMapping= ruleInfrastructureMapping EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1452:2: iv_ruleInfrastructureMapping= ruleInfrastructureMapping EOF
            {
             newCompositeNode(grammarAccess.getInfrastructureMappingRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_entryRuleInfrastructureMapping3324);
            iv_ruleInfrastructureMapping=ruleInfrastructureMapping();

            state._fsp--;

             current =iv_ruleInfrastructureMapping; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfrastructureMapping3334); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfrastructureMapping"


    // $ANTLR start "ruleInfrastructureMapping"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1459:1: ruleInfrastructureMapping returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'from' otherlv_2= ':' otherlv_3= '[' ( (otherlv_4= RULE_ID ) )* otherlv_5= ']' otherlv_6= 'to' otherlv_7= ':' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' ) ;
    public final EObject ruleInfrastructureMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1462:28: ( (otherlv_0= '{' otherlv_1= 'from' otherlv_2= ':' otherlv_3= '[' ( (otherlv_4= RULE_ID ) )* otherlv_5= ']' otherlv_6= 'to' otherlv_7= ':' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1463:1: (otherlv_0= '{' otherlv_1= 'from' otherlv_2= ':' otherlv_3= '[' ( (otherlv_4= RULE_ID ) )* otherlv_5= ']' otherlv_6= 'to' otherlv_7= ':' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1463:1: (otherlv_0= '{' otherlv_1= 'from' otherlv_2= ':' otherlv_3= '[' ( (otherlv_4= RULE_ID ) )* otherlv_5= ']' otherlv_6= 'to' otherlv_7= ':' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1463:3: otherlv_0= '{' otherlv_1= 'from' otherlv_2= ':' otherlv_3= '[' ( (otherlv_4= RULE_ID ) )* otherlv_5= ']' otherlv_6= 'to' otherlv_7= ':' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleInfrastructureMapping3371); 

                	newLeafNode(otherlv_0, grammarAccess.getInfrastructureMappingAccess().getLeftCurlyBracketKeyword_0());
                
            otherlv_1=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleInfrastructureMapping3383); 

                	newLeafNode(otherlv_1, grammarAccess.getInfrastructureMappingAccess().getFromKeyword_1());
                
            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleInfrastructureMapping3395); 

                	newLeafNode(otherlv_2, grammarAccess.getInfrastructureMappingAccess().getColonKeyword_2());
                
            otherlv_3=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInfrastructureMapping3407); 

                	newLeafNode(otherlv_3, grammarAccess.getInfrastructureMappingAccess().getLeftSquareBracketKeyword_3());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1479:1: ( (otherlv_4= RULE_ID ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1480:1: (otherlv_4= RULE_ID )
            	    {
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1480:1: (otherlv_4= RULE_ID )
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1481:3: otherlv_4= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getInfrastructureMappingRule());
            	    	        }
            	            
            	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleInfrastructureMapping3427); 

            	    		newLeafNode(otherlv_4, grammarAccess.getInfrastructureMappingAccess().getMappedElementsReteNodeRecipeCrossReference_4_0()); 
            	    	

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInfrastructureMapping3440); 

                	newLeafNode(otherlv_5, grammarAccess.getInfrastructureMappingAccess().getRightSquareBracketKeyword_5());
                
            otherlv_6=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleInfrastructureMapping3452); 

                	newLeafNode(otherlv_6, grammarAccess.getInfrastructureMappingAccess().getToKeyword_6());
                
            otherlv_7=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleInfrastructureMapping3464); 

                	newLeafNode(otherlv_7, grammarAccess.getInfrastructureMappingAccess().getColonKeyword_7());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1504:1: ( (otherlv_8= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1505:1: (otherlv_8= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1505:1: (otherlv_8= RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:1506:3: otherlv_8= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInfrastructureMappingRule());
            	        }
                    
            otherlv_8=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleInfrastructureMapping3484); 

            		newLeafNode(otherlv_8, grammarAccess.getInfrastructureMappingAccess().getTargetElementMachineCrossReference_8_0()); 
            	

            }


            }

            otherlv_9=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleInfrastructureMapping3496); 

                	newLeafNode(otherlv_9, grammarAccess.getInfrastructureMappingAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfrastructureMapping"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleConfiguration_in_entryRuleConfiguration75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfiguration85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleConfiguration132 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleConfiguration144 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleConfiguration156 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_ruleCluster_in_ruleConfiguration177 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_15_in_ruleConfiguration190 = new BitSet(new long[]{0x0000000000030002L});
        public static final BitSet FOLLOW_16_in_ruleConfiguration205 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleConfiguration217 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleConfiguration229 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_ruleReteRecipe_in_ruleConfiguration250 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_15_in_ruleConfiguration263 = new BitSet(new long[]{0x0000000000020002L});
        public static final BitSet FOLLOW_17_in_ruleConfiguration278 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleConfiguration290 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleConfiguration302 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_ruleConfiguration323 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_15_in_ruleConfiguration336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCluster_in_entryRuleCluster374 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCluster384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleCluster430 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_19_in_ruleCluster443 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCluster455 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCluster467 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_ruleMachine_in_ruleCluster488 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_15_in_ruleCluster501 = new BitSet(new long[]{0x0000000000300000L});
        public static final BitSet FOLLOW_20_in_ruleCluster516 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCluster528 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCluster540 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_ruleMachine_in_ruleCluster561 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_15_in_ruleCluster574 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleCluster588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMachine_in_entryRuleMachine624 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMachine634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMachine671 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleMachine683 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMachine695 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMachine712 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleMachine729 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMachine741 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleMachine758 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleMachine775 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMachine787 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_IP_in_ruleMachine804 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleMachine821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteRecipe_in_entryRuleReteRecipe857 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReteRecipe867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleReteRecipe913 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleReteRecipe925 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleReteRecipe937 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleReteRecipe949 = new BitSet(new long[]{0x00000012B4008000L});
        public static final BitSet FOLLOW_ruleReteNodeRecipe_in_ruleReteRecipe970 = new BitSet(new long[]{0x00000012B4008000L});
        public static final BitSet FOLLOW_15_in_ruleReteRecipe983 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleReteRecipe995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteNodeRecipe_in_entryRuleReteNodeRecipe1031 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReteNodeRecipe1041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProductionRecipe_in_ruleReteNodeRecipe1088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUniquenessEnforcerRecipe_in_ruleReteNodeRecipe1115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheckRecipe_in_ruleReteNodeRecipe1142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrimmerRecipe_in_ruleReteNodeRecipe1169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJoinRecipe_in_ruleReteNodeRecipe1196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAntiJoinRecipe_in_ruleReteNodeRecipe1223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProductionRecipe_in_entryRuleProductionRecipe1258 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProductionRecipe1268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleProductionRecipe1305 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleProductionRecipe1317 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleProductionRecipe1329 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleProductionRecipe1341 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleProductionRecipe1358 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleProductionRecipe1375 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleProductionRecipe1387 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleProductionRecipe1399 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProductionRecipe1419 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleProductionRecipe1432 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleProductionRecipe1444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUniquenessEnforcerRecipe_in_entryRuleUniquenessEnforcerRecipe1480 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUniquenessEnforcerRecipe1490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleUniquenessEnforcerRecipe1527 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleUniquenessEnforcerRecipe1539 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleUniquenessEnforcerRecipe1551 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleUniquenessEnforcerRecipe1563 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleUniquenessEnforcerRecipe1580 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleUniquenessEnforcerRecipe1597 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleUniquenessEnforcerRecipe1609 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleUniquenessEnforcerRecipe1621 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleUniquenessEnforcerRecipe1641 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleUniquenessEnforcerRecipe1654 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleUniquenessEnforcerRecipe1666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheckRecipe_in_entryRuleCheckRecipe1702 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCheckRecipe1712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleCheckRecipe1749 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleCheckRecipe1761 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleCheckRecipe1773 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCheckRecipe1785 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleCheckRecipe1802 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleCheckRecipe1819 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCheckRecipe1831 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCheckRecipe1851 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleCheckRecipe1863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrimmerRecipe_in_entryRuleTrimmerRecipe1899 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrimmerRecipe1909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleTrimmerRecipe1946 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleTrimmerRecipe1958 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTrimmerRecipe1970 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleTrimmerRecipe1982 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTrimmerRecipe1999 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleTrimmerRecipe2016 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleTrimmerRecipe2028 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleMask_in_ruleTrimmerRecipe2049 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleTrimmerRecipe2061 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleTrimmerRecipe2073 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleTrimmerRecipe2093 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleTrimmerRecipe2105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJoinRecipe_in_entryRuleJoinRecipe2141 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJoinRecipe2151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleJoinRecipe2188 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleJoinRecipe2200 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleJoinRecipe2212 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleJoinRecipe2224 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJoinRecipe2241 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleJoinRecipe2258 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleJoinRecipe2270 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleProjectionIndexerRecipe_in_ruleJoinRecipe2291 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleJoinRecipe2303 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleJoinRecipe2315 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleIndexerRecipe_in_ruleJoinRecipe2336 = new BitSet(new long[]{0x0000000000240000L});
        public static final BitSet FOLLOW_ruleMask_in_ruleJoinRecipe2357 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleJoinRecipe2370 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAntiJoinRecipe_in_entryRuleAntiJoinRecipe2406 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAntiJoinRecipe2416 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleAntiJoinRecipe2453 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAntiJoinRecipe2465 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleAntiJoinRecipe2477 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleAntiJoinRecipe2489 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleAntiJoinRecipe2506 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAntiJoinRecipe2523 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleAntiJoinRecipe2535 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleProjectionIndexerRecipe_in_ruleAntiJoinRecipe2556 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleAntiJoinRecipe2568 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleAntiJoinRecipe2580 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleIndexerRecipe_in_ruleAntiJoinRecipe2601 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleAntiJoinRecipe2613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexerRecipe_in_entryRuleIndexerRecipe2649 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIndexerRecipe2659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleIndexerRecipe2696 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleIndexerRecipe2708 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleIndexerRecipe2720 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleIndexerRecipe2737 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleIndexerRecipe2754 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleIndexerRecipe2766 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleMask_in_ruleIndexerRecipe2787 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleIndexerRecipe2799 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleIndexerRecipe2811 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleIndexerRecipe2831 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleIndexerRecipe2843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProjectionIndexerRecipe_in_entryRuleProjectionIndexerRecipe2879 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProjectionIndexerRecipe2889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleProjectionIndexerRecipe2926 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleProjectionIndexerRecipe2938 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleProjectionIndexerRecipe2950 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleProjectionIndexerRecipe2967 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleProjectionIndexerRecipe2984 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleProjectionIndexerRecipe2996 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_ruleMask_in_ruleProjectionIndexerRecipe3017 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleProjectionIndexerRecipe3029 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleProjectionIndexerRecipe3041 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleProjectionIndexerRecipe3061 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleProjectionIndexerRecipe3073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_entryRuleMask3109 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMask3119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleMask3156 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_37_in_ruleMask3168 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMask3180 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMask3197 = new BitSet(new long[]{0x0000004000200000L});
        public static final BitSet FOLLOW_38_in_ruleMask3215 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMask3227 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleMask3239 = new BitSet(new long[]{0x0000000000008080L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMask3256 = new BitSet(new long[]{0x0000000000008080L});
        public static final BitSet FOLLOW_15_in_ruleMask3274 = new BitSet(new long[]{0x0000004000200000L});
        public static final BitSet FOLLOW_21_in_ruleMask3288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_entryRuleInfrastructureMapping3324 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfrastructureMapping3334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleInfrastructureMapping3371 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_39_in_ruleInfrastructureMapping3383 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleInfrastructureMapping3395 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleInfrastructureMapping3407 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleInfrastructureMapping3427 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_15_in_ruleInfrastructureMapping3440 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleInfrastructureMapping3452 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleInfrastructureMapping3464 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleInfrastructureMapping3484 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleInfrastructureMapping3496 = new BitSet(new long[]{0x0000000000000002L});
    }


}