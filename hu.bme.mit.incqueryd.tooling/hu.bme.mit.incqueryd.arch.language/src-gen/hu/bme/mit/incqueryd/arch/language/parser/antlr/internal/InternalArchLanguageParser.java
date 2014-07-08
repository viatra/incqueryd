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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_IP", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'recipe'", "'use'", "'for'", "','", "'cache'"
    };
    public static final int RULE_ID=6;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_IP=5;
    public static final int RULE_INT=7;
    public static final int RULE_WS=10;
    public static final int RULE_SL_COMMENT=9;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=8;

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
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:76:1: ruleConfiguration returns [EObject current=null] : ( ( (lv_recipeImports_0_0= ruleRecipeImport ) )* ( (lv_mappings_1_0= ruleInfrastructureMapping ) )* ) ;
    public final EObject ruleConfiguration() throws RecognitionException {
        EObject current = null;

        EObject lv_recipeImports_0_0 = null;

        EObject lv_mappings_1_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:79:28: ( ( ( (lv_recipeImports_0_0= ruleRecipeImport ) )* ( (lv_mappings_1_0= ruleInfrastructureMapping ) )* ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:80:1: ( ( (lv_recipeImports_0_0= ruleRecipeImport ) )* ( (lv_mappings_1_0= ruleInfrastructureMapping ) )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:80:1: ( ( (lv_recipeImports_0_0= ruleRecipeImport ) )* ( (lv_mappings_1_0= ruleInfrastructureMapping ) )* )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:80:2: ( (lv_recipeImports_0_0= ruleRecipeImport ) )* ( (lv_mappings_1_0= ruleInfrastructureMapping ) )*
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:80:2: ( (lv_recipeImports_0_0= ruleRecipeImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:81:1: (lv_recipeImports_0_0= ruleRecipeImport )
            	    {
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:81:1: (lv_recipeImports_0_0= ruleRecipeImport )
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:82:3: lv_recipeImports_0_0= ruleRecipeImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigurationAccess().getRecipeImportsRecipeImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRecipeImport_in_ruleConfiguration131);
            	    lv_recipeImports_0_0=ruleRecipeImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"recipeImports",
            	            		lv_recipeImports_0_0, 
            	            		"RecipeImport");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:98:3: ( (lv_mappings_1_0= ruleInfrastructureMapping ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:99:1: (lv_mappings_1_0= ruleInfrastructureMapping )
            	    {
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:99:1: (lv_mappings_1_0= ruleInfrastructureMapping )
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:100:3: lv_mappings_1_0= ruleInfrastructureMapping
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConfigurationAccess().getMappingsInfrastructureMappingParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_ruleConfiguration153);
            	    lv_mappings_1_0=ruleInfrastructureMapping();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConfigurationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"mappings",
            	            		lv_mappings_1_0, 
            	            		"InfrastructureMapping");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


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


    // $ANTLR start "entryRuleRecipeImport"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:124:1: entryRuleRecipeImport returns [EObject current=null] : iv_ruleRecipeImport= ruleRecipeImport EOF ;
    public final EObject entryRuleRecipeImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecipeImport = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:125:2: (iv_ruleRecipeImport= ruleRecipeImport EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:126:2: iv_ruleRecipeImport= ruleRecipeImport EOF
            {
             newCompositeNode(grammarAccess.getRecipeImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecipeImport_in_entryRuleRecipeImport190);
            iv_ruleRecipeImport=ruleRecipeImport();

            state._fsp--;

             current =iv_ruleRecipeImport; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecipeImport200); 

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
    // $ANTLR end "entryRuleRecipeImport"


    // $ANTLR start "ruleRecipeImport"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:133:1: ruleRecipeImport returns [EObject current=null] : (otherlv_0= 'recipe' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleRecipeImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:136:28: ( (otherlv_0= 'recipe' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:137:1: (otherlv_0= 'recipe' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:137:1: (otherlv_0= 'recipe' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:137:3: otherlv_0= 'recipe' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRecipeImport237); 

                	newLeafNode(otherlv_0, grammarAccess.getRecipeImportAccess().getRecipeKeyword_0());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:141:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:142:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:142:1: (lv_importURI_1_0= RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:143:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleRecipeImport254); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getRecipeImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRecipeImportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"STRING");
            	    

            }


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
    // $ANTLR end "ruleRecipeImport"


    // $ANTLR start "entryRuleInfrastructureMapping"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:167:1: entryRuleInfrastructureMapping returns [EObject current=null] : iv_ruleInfrastructureMapping= ruleInfrastructureMapping EOF ;
    public final EObject entryRuleInfrastructureMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureMapping = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:168:2: (iv_ruleInfrastructureMapping= ruleInfrastructureMapping EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:169:2: iv_ruleInfrastructureMapping= ruleInfrastructureMapping EOF
            {
             newCompositeNode(grammarAccess.getInfrastructureMappingRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_entryRuleInfrastructureMapping295);
            iv_ruleInfrastructureMapping=ruleInfrastructureMapping();

            state._fsp--;

             current =iv_ruleInfrastructureMapping; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfrastructureMapping305); 

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
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:176:1: ruleInfrastructureMapping returns [EObject current=null] : (otherlv_0= 'use' ( (lv_machine_1_0= ruleMachine ) ) otherlv_2= 'for' ( (lv_roles_3_0= ruleRole ) ) (otherlv_4= ',' ( (lv_roles_5_0= ruleRole ) ) )* ) ;
    public final EObject ruleInfrastructureMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_machine_1_0 = null;

        EObject lv_roles_3_0 = null;

        EObject lv_roles_5_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:179:28: ( (otherlv_0= 'use' ( (lv_machine_1_0= ruleMachine ) ) otherlv_2= 'for' ( (lv_roles_3_0= ruleRole ) ) (otherlv_4= ',' ( (lv_roles_5_0= ruleRole ) ) )* ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:180:1: (otherlv_0= 'use' ( (lv_machine_1_0= ruleMachine ) ) otherlv_2= 'for' ( (lv_roles_3_0= ruleRole ) ) (otherlv_4= ',' ( (lv_roles_5_0= ruleRole ) ) )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:180:1: (otherlv_0= 'use' ( (lv_machine_1_0= ruleMachine ) ) otherlv_2= 'for' ( (lv_roles_3_0= ruleRole ) ) (otherlv_4= ',' ( (lv_roles_5_0= ruleRole ) ) )* )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:180:3: otherlv_0= 'use' ( (lv_machine_1_0= ruleMachine ) ) otherlv_2= 'for' ( (lv_roles_3_0= ruleRole ) ) (otherlv_4= ',' ( (lv_roles_5_0= ruleRole ) ) )*
            {
            otherlv_0=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleInfrastructureMapping342); 

                	newLeafNode(otherlv_0, grammarAccess.getInfrastructureMappingAccess().getUseKeyword_0());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:184:1: ( (lv_machine_1_0= ruleMachine ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:185:1: (lv_machine_1_0= ruleMachine )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:185:1: (lv_machine_1_0= ruleMachine )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:186:3: lv_machine_1_0= ruleMachine
            {
             
            	        newCompositeNode(grammarAccess.getInfrastructureMappingAccess().getMachineMachineParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_ruleInfrastructureMapping363);
            lv_machine_1_0=ruleMachine();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInfrastructureMappingRule());
            	        }
                   		set(
                   			current, 
                   			"machine",
                    		lv_machine_1_0, 
                    		"Machine");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleInfrastructureMapping375); 

                	newLeafNode(otherlv_2, grammarAccess.getInfrastructureMappingAccess().getForKeyword_2());
                
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:206:1: ( (lv_roles_3_0= ruleRole ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:207:1: (lv_roles_3_0= ruleRole )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:207:1: (lv_roles_3_0= ruleRole )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:208:3: lv_roles_3_0= ruleRole
            {
             
            	        newCompositeNode(grammarAccess.getInfrastructureMappingAccess().getRolesRoleParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleRole_in_ruleInfrastructureMapping396);
            lv_roles_3_0=ruleRole();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getInfrastructureMappingRule());
            	        }
                   		add(
                   			current, 
                   			"roles",
                    		lv_roles_3_0, 
                    		"Role");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:224:2: (otherlv_4= ',' ( (lv_roles_5_0= ruleRole ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:224:4: otherlv_4= ',' ( (lv_roles_5_0= ruleRole ) )
            	    {
            	    otherlv_4=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleInfrastructureMapping409); 

            	        	newLeafNode(otherlv_4, grammarAccess.getInfrastructureMappingAccess().getCommaKeyword_4_0());
            	        
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:228:1: ( (lv_roles_5_0= ruleRole ) )
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:229:1: (lv_roles_5_0= ruleRole )
            	    {
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:229:1: (lv_roles_5_0= ruleRole )
            	    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:230:3: lv_roles_5_0= ruleRole
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getInfrastructureMappingAccess().getRolesRoleParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRole_in_ruleInfrastructureMapping430);
            	    lv_roles_5_0=ruleRole();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getInfrastructureMappingRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"roles",
            	            		lv_roles_5_0, 
            	            		"Role");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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


    // $ANTLR start "entryRuleMachine"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:254:1: entryRuleMachine returns [EObject current=null] : iv_ruleMachine= ruleMachine EOF ;
    public final EObject entryRuleMachine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMachine = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:255:2: (iv_ruleMachine= ruleMachine EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:256:2: iv_ruleMachine= ruleMachine EOF
            {
             newCompositeNode(grammarAccess.getMachineRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_entryRuleMachine468);
            iv_ruleMachine=ruleMachine();

            state._fsp--;

             current =iv_ruleMachine; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMachine478); 

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
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:263:1: ruleMachine returns [EObject current=null] : ( (lv_ip_0_0= RULE_IP ) ) ;
    public final EObject ruleMachine() throws RecognitionException {
        EObject current = null;

        Token lv_ip_0_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:266:28: ( ( (lv_ip_0_0= RULE_IP ) ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:267:1: ( (lv_ip_0_0= RULE_IP ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:267:1: ( (lv_ip_0_0= RULE_IP ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:268:1: (lv_ip_0_0= RULE_IP )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:268:1: (lv_ip_0_0= RULE_IP )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:269:3: lv_ip_0_0= RULE_IP
            {
            lv_ip_0_0=(Token)match(input,RULE_IP,FollowSets000.FOLLOW_RULE_IP_in_ruleMachine519); 

            			newLeafNode(lv_ip_0_0, grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getMachineRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"ip",
                    		lv_ip_0_0, 
                    		"IP");
            	    

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
    // $ANTLR end "ruleMachine"


    // $ANTLR start "entryRuleRole"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:293:1: entryRuleRole returns [EObject current=null] : iv_ruleRole= ruleRole EOF ;
    public final EObject entryRuleRole() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRole = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:294:2: (iv_ruleRole= ruleRole EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:295:2: iv_ruleRole= ruleRole EOF
            {
             newCompositeNode(grammarAccess.getRoleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRole_in_entryRuleRole559);
            iv_ruleRole=ruleRole();

            state._fsp--;

             current =iv_ruleRole; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRole569); 

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
    // $ANTLR end "entryRuleRole"


    // $ANTLR start "ruleRole"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:302:1: ruleRole returns [EObject current=null] : (this_ReteRole_0= ruleReteRole | this_CacheRole_1= ruleCacheRole ) ;
    public final EObject ruleRole() throws RecognitionException {
        EObject current = null;

        EObject this_ReteRole_0 = null;

        EObject this_CacheRole_1 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:305:28: ( (this_ReteRole_0= ruleReteRole | this_CacheRole_1= ruleCacheRole ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:306:1: (this_ReteRole_0= ruleReteRole | this_CacheRole_1= ruleCacheRole )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:306:1: (this_ReteRole_0= ruleReteRole | this_CacheRole_1= ruleCacheRole )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==16) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:307:5: this_ReteRole_0= ruleReteRole
                    {
                     
                            newCompositeNode(grammarAccess.getRoleAccess().getReteRoleParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReteRole_in_ruleRole616);
                    this_ReteRole_0=ruleReteRole();

                    state._fsp--;

                     
                            current = this_ReteRole_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:317:5: this_CacheRole_1= ruleCacheRole
                    {
                     
                            newCompositeNode(grammarAccess.getRoleAccess().getCacheRoleParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCacheRole_in_ruleRole643);
                    this_CacheRole_1=ruleCacheRole();

                    state._fsp--;

                     
                            current = this_CacheRole_1; 
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
    // $ANTLR end "ruleRole"


    // $ANTLR start "entryRuleReteRole"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:333:1: entryRuleReteRole returns [EObject current=null] : iv_ruleReteRole= ruleReteRole EOF ;
    public final EObject entryRuleReteRole() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReteRole = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:334:2: (iv_ruleReteRole= ruleReteRole EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:335:2: iv_ruleReteRole= ruleReteRole EOF
            {
             newCompositeNode(grammarAccess.getReteRoleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteRole_in_entryRuleReteRole678);
            iv_ruleReteRole=ruleReteRole();

            state._fsp--;

             current =iv_ruleReteRole; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReteRole688); 

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
    // $ANTLR end "entryRuleReteRole"


    // $ANTLR start "ruleReteRole"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:342:1: ruleReteRole returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleReteRole() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:345:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:346:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:346:1: ( (otherlv_0= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:347:1: (otherlv_0= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:347:1: (otherlv_0= RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:348:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReteRoleRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReteRole732); 

            		newLeafNode(otherlv_0, grammarAccess.getReteRoleAccess().getNodeRecipeReteNodeRecipeCrossReference_0()); 
            	

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
    // $ANTLR end "ruleReteRole"


    // $ANTLR start "entryRuleCacheRole"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:367:1: entryRuleCacheRole returns [EObject current=null] : iv_ruleCacheRole= ruleCacheRole EOF ;
    public final EObject entryRuleCacheRole() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCacheRole = null;


        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:368:2: (iv_ruleCacheRole= ruleCacheRole EOF )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:369:2: iv_ruleCacheRole= ruleCacheRole EOF
            {
             newCompositeNode(grammarAccess.getCacheRoleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCacheRole_in_entryRuleCacheRole767);
            iv_ruleCacheRole=ruleCacheRole();

            state._fsp--;

             current =iv_ruleCacheRole; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCacheRole777); 

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
    // $ANTLR end "entryRuleCacheRole"


    // $ANTLR start "ruleCacheRole"
    // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:376:1: ruleCacheRole returns [EObject current=null] : ( () otherlv_1= 'cache' ) ;
    public final EObject ruleCacheRole() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:379:28: ( ( () otherlv_1= 'cache' ) )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:380:1: ( () otherlv_1= 'cache' )
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:380:1: ( () otherlv_1= 'cache' )
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:380:2: () otherlv_1= 'cache'
            {
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:380:2: ()
            // ../hu.bme.mit.incqueryd.arch.language/src-gen/hu/bme/mit/incqueryd/arch/language/parser/antlr/internal/InternalArchLanguage.g:381:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCacheRoleAccess().getCacheRoleAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleCacheRole823); 

                	newLeafNode(otherlv_1, grammarAccess.getCacheRoleAccess().getCacheKeyword_1());
                

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
    // $ANTLR end "ruleCacheRole"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleConfiguration_in_entryRuleConfiguration75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfiguration85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecipeImport_in_ruleConfiguration131 = new BitSet(new long[]{0x0000000000003002L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_ruleConfiguration153 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_ruleRecipeImport_in_entryRuleRecipeImport190 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecipeImport200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleRecipeImport237 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleRecipeImport254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_entryRuleInfrastructureMapping295 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfrastructureMapping305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_ruleInfrastructureMapping342 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_ruleMachine_in_ruleInfrastructureMapping363 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleInfrastructureMapping375 = new BitSet(new long[]{0x0000000000010040L});
        public static final BitSet FOLLOW_ruleRole_in_ruleInfrastructureMapping396 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_15_in_ruleInfrastructureMapping409 = new BitSet(new long[]{0x0000000000010040L});
        public static final BitSet FOLLOW_ruleRole_in_ruleInfrastructureMapping430 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_ruleMachine_in_entryRuleMachine468 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMachine478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_IP_in_ruleMachine519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRole_in_entryRuleRole559 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRole569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteRole_in_ruleRole616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCacheRole_in_ruleRole643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteRole_in_entryRuleReteRole678 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReteRole688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReteRole732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCacheRole_in_entryRuleCacheRole767 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCacheRole777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_ruleCacheRole823 = new BitSet(new long[]{0x0000000000000002L});
    }


}