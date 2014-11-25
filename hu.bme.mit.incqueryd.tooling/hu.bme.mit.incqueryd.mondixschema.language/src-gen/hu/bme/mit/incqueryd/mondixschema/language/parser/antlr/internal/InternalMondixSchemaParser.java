package hu.bme.mit.incqueryd.mondixschema.language.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import hu.bme.mit.incqueryd.mondixschema.language.services.MondixSchemaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMondixSchemaParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'schema'", "'relation'", "'{'", "'}'", "'column'", "':'", "'ID'", "'STRING'", "'NUMBER'", "'BOOLEAN'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalMondixSchemaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMondixSchemaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMondixSchemaParser.tokenNames; }
    public String getGrammarFileName() { return "../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g"; }



     	private MondixSchemaGrammarAccess grammarAccess;
     	
        public InternalMondixSchemaParser(TokenStream input, MondixSchemaGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Schema";	
       	}
       	
       	@Override
       	protected MondixSchemaGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSchema"
    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:68:1: entryRuleSchema returns [EObject current=null] : iv_ruleSchema= ruleSchema EOF ;
    public final EObject entryRuleSchema() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSchema = null;


        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:69:2: (iv_ruleSchema= ruleSchema EOF )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:70:2: iv_ruleSchema= ruleSchema EOF
            {
             newCompositeNode(grammarAccess.getSchemaRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSchema_in_entryRuleSchema75);
            iv_ruleSchema=ruleSchema();

            state._fsp--;

             current =iv_ruleSchema; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSchema85); 

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
    // $ANTLR end "entryRuleSchema"


    // $ANTLR start "ruleSchema"
    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:77:1: ruleSchema returns [EObject current=null] : ( () otherlv_1= 'schema' ( (lv_name_2_0= RULE_ID ) ) ( (lv_relations_3_0= ruleRelation ) )* ) ;
    public final EObject ruleSchema() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_relations_3_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:80:28: ( ( () otherlv_1= 'schema' ( (lv_name_2_0= RULE_ID ) ) ( (lv_relations_3_0= ruleRelation ) )* ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:81:1: ( () otherlv_1= 'schema' ( (lv_name_2_0= RULE_ID ) ) ( (lv_relations_3_0= ruleRelation ) )* )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:81:1: ( () otherlv_1= 'schema' ( (lv_name_2_0= RULE_ID ) ) ( (lv_relations_3_0= ruleRelation ) )* )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:81:2: () otherlv_1= 'schema' ( (lv_name_2_0= RULE_ID ) ) ( (lv_relations_3_0= ruleRelation ) )*
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:81:2: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:82:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSchemaAccess().getSchemaAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSchema131); 

                	newLeafNode(otherlv_1, grammarAccess.getSchemaAccess().getSchemaKeyword_1());
                
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:91:1: ( (lv_name_2_0= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:92:1: (lv_name_2_0= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:92:1: (lv_name_2_0= RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:93:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSchema148); 

            			newLeafNode(lv_name_2_0, grammarAccess.getSchemaAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSchemaRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:109:2: ( (lv_relations_3_0= ruleRelation ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:110:1: (lv_relations_3_0= ruleRelation )
            	    {
            	    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:110:1: (lv_relations_3_0= ruleRelation )
            	    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:111:3: lv_relations_3_0= ruleRelation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSchemaAccess().getRelationsRelationParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleRelation_in_ruleSchema174);
            	    lv_relations_3_0=ruleRelation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSchemaRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"relations",
            	            		lv_relations_3_0, 
            	            		"Relation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "ruleSchema"


    // $ANTLR start "entryRuleRelation"
    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:135:1: entryRuleRelation returns [EObject current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final EObject entryRuleRelation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelation = null;


        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:136:2: (iv_ruleRelation= ruleRelation EOF )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:137:2: iv_ruleRelation= ruleRelation EOF
            {
             newCompositeNode(grammarAccess.getRelationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRelation_in_entryRuleRelation211);
            iv_ruleRelation=ruleRelation();

            state._fsp--;

             current =iv_ruleRelation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRelation221); 

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
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:144:1: ruleRelation returns [EObject current=null] : ( () otherlv_1= 'relation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_columns_4_0= ruleColumn ) )* otherlv_5= '}' ) ;
    public final EObject ruleRelation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_columns_4_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:147:28: ( ( () otherlv_1= 'relation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_columns_4_0= ruleColumn ) )* otherlv_5= '}' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:148:1: ( () otherlv_1= 'relation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_columns_4_0= ruleColumn ) )* otherlv_5= '}' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:148:1: ( () otherlv_1= 'relation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_columns_4_0= ruleColumn ) )* otherlv_5= '}' )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:148:2: () otherlv_1= 'relation' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_columns_4_0= ruleColumn ) )* otherlv_5= '}'
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:148:2: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:149:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRelationAccess().getRelationAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleRelation267); 

                	newLeafNode(otherlv_1, grammarAccess.getRelationAccess().getRelationKeyword_1());
                
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:158:1: ( (lv_name_2_0= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:159:1: (lv_name_2_0= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:159:1: (lv_name_2_0= RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:160:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRelation284); 

            			newLeafNode(lv_name_2_0, grammarAccess.getRelationAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRelationRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRelation301); 

                	newLeafNode(otherlv_3, grammarAccess.getRelationAccess().getLeftCurlyBracketKeyword_3());
                
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:180:1: ( (lv_columns_4_0= ruleColumn ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:181:1: (lv_columns_4_0= ruleColumn )
            	    {
            	    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:181:1: (lv_columns_4_0= ruleColumn )
            	    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:182:3: lv_columns_4_0= ruleColumn
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRelationAccess().getColumnsColumnParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleColumn_in_ruleRelation322);
            	    lv_columns_4_0=ruleColumn();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRelationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"columns",
            	            		lv_columns_4_0, 
            	            		"Column");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRelation335); 

                	newLeafNode(otherlv_5, grammarAccess.getRelationAccess().getRightCurlyBracketKeyword_5());
                

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
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleColumn"
    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:210:1: entryRuleColumn returns [EObject current=null] : iv_ruleColumn= ruleColumn EOF ;
    public final EObject entryRuleColumn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleColumn = null;


        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:211:2: (iv_ruleColumn= ruleColumn EOF )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:212:2: iv_ruleColumn= ruleColumn EOF
            {
             newCompositeNode(grammarAccess.getColumnRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleColumn_in_entryRuleColumn371);
            iv_ruleColumn=ruleColumn();

            state._fsp--;

             current =iv_ruleColumn; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleColumn381); 

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
    // $ANTLR end "entryRuleColumn"


    // $ANTLR start "ruleColumn"
    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:219:1: ruleColumn returns [EObject current=null] : ( () otherlv_1= 'column' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_type_4_0= ruleColumnType ) ) )? ) ;
    public final EObject ruleColumn() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Enumerator lv_type_4_0 = null;


         enterRule(); 
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:222:28: ( ( () otherlv_1= 'column' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_type_4_0= ruleColumnType ) ) )? ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:223:1: ( () otherlv_1= 'column' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_type_4_0= ruleColumnType ) ) )? )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:223:1: ( () otherlv_1= 'column' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_type_4_0= ruleColumnType ) ) )? )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:223:2: () otherlv_1= 'column' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= ':' ( (lv_type_4_0= ruleColumnType ) ) )?
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:223:2: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:224:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getColumnAccess().getColumnAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleColumn427); 

                	newLeafNode(otherlv_1, grammarAccess.getColumnAccess().getColumnKeyword_1());
                
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:233:1: ( (lv_name_2_0= RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:234:1: (lv_name_2_0= RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:234:1: (lv_name_2_0= RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:235:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleColumn444); 

            			newLeafNode(lv_name_2_0, grammarAccess.getColumnAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getColumnRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:251:2: (otherlv_3= ':' ( (lv_type_4_0= ruleColumnType ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:251:4: otherlv_3= ':' ( (lv_type_4_0= ruleColumnType ) )
                    {
                    otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleColumn462); 

                        	newLeafNode(otherlv_3, grammarAccess.getColumnAccess().getColonKeyword_3_0());
                        
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:255:1: ( (lv_type_4_0= ruleColumnType ) )
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:256:1: (lv_type_4_0= ruleColumnType )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:256:1: (lv_type_4_0= ruleColumnType )
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:257:3: lv_type_4_0= ruleColumnType
                    {
                     
                    	        newCompositeNode(grammarAccess.getColumnAccess().getTypeColumnTypeEnumRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleColumnType_in_ruleColumn483);
                    lv_type_4_0=ruleColumnType();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getColumnRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_4_0, 
                            		"ColumnType");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


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
    // $ANTLR end "ruleColumn"


    // $ANTLR start "ruleColumnType"
    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:281:1: ruleColumnType returns [Enumerator current=null] : ( (enumLiteral_0= 'ID' ) | (enumLiteral_1= 'STRING' ) | (enumLiteral_2= 'NUMBER' ) | (enumLiteral_3= 'BOOLEAN' ) ) ;
    public final Enumerator ruleColumnType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:283:28: ( ( (enumLiteral_0= 'ID' ) | (enumLiteral_1= 'STRING' ) | (enumLiteral_2= 'NUMBER' ) | (enumLiteral_3= 'BOOLEAN' ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:284:1: ( (enumLiteral_0= 'ID' ) | (enumLiteral_1= 'STRING' ) | (enumLiteral_2= 'NUMBER' ) | (enumLiteral_3= 'BOOLEAN' ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:284:1: ( (enumLiteral_0= 'ID' ) | (enumLiteral_1= 'STRING' ) | (enumLiteral_2= 'NUMBER' ) | (enumLiteral_3= 'BOOLEAN' ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt4=1;
                }
                break;
            case 18:
                {
                alt4=2;
                }
                break;
            case 19:
                {
                alt4=3;
                }
                break;
            case 20:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:284:2: (enumLiteral_0= 'ID' )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:284:2: (enumLiteral_0= 'ID' )
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:284:4: enumLiteral_0= 'ID'
                    {
                    enumLiteral_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleColumnType535); 

                            current = grammarAccess.getColumnTypeAccess().getIdEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getColumnTypeAccess().getIdEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:290:6: (enumLiteral_1= 'STRING' )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:290:6: (enumLiteral_1= 'STRING' )
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:290:8: enumLiteral_1= 'STRING'
                    {
                    enumLiteral_1=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleColumnType552); 

                            current = grammarAccess.getColumnTypeAccess().getStringEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getColumnTypeAccess().getStringEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:296:6: (enumLiteral_2= 'NUMBER' )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:296:6: (enumLiteral_2= 'NUMBER' )
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:296:8: enumLiteral_2= 'NUMBER'
                    {
                    enumLiteral_2=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleColumnType569); 

                            current = grammarAccess.getColumnTypeAccess().getNumberEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getColumnTypeAccess().getNumberEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:302:6: (enumLiteral_3= 'BOOLEAN' )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:302:6: (enumLiteral_3= 'BOOLEAN' )
                    // ../hu.bme.mit.incqueryd.mondixschema.language/src-gen/hu/bme/mit/incqueryd/mondixschema/language/parser/antlr/internal/InternalMondixSchema.g:302:8: enumLiteral_3= 'BOOLEAN'
                    {
                    enumLiteral_3=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleColumnType586); 

                            current = grammarAccess.getColumnTypeAccess().getBooleanEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getColumnTypeAccess().getBooleanEnumLiteralDeclaration_3()); 
                        

                    }


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
    // $ANTLR end "ruleColumnType"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSchema_in_entryRuleSchema75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSchema85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSchema131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSchema148 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleRelation_in_ruleSchema174 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_ruleRelation_in_entryRuleRelation211 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRelation221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_ruleRelation267 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRelation284 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleRelation301 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_ruleColumn_in_ruleRelation322 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_14_in_ruleRelation335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleColumn_in_entryRuleColumn371 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleColumn381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_ruleColumn427 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleColumn444 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleColumn462 = new BitSet(new long[]{0x00000000001E0000L});
        public static final BitSet FOLLOW_ruleColumnType_in_ruleColumn483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleColumnType535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_ruleColumnType552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleColumnType569 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleColumnType586 = new BitSet(new long[]{0x0000000000000002L});
    }


}