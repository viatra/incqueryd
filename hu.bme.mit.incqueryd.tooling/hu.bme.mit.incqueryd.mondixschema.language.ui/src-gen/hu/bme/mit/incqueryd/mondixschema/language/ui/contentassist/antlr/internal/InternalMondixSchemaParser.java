package hu.bme.mit.incqueryd.mondixschema.language.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import hu.bme.mit.incqueryd.mondixschema.language.services.MondixSchemaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMondixSchemaParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'schema'", "'relation'", "'{'", "'}'", "'column'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__15=15;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
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
    public String getGrammarFileName() { return "../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g"; }


     
     	private MondixSchemaGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MondixSchemaGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleSchema"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:60:1: entryRuleSchema : ruleSchema EOF ;
    public final void entryRuleSchema() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:61:1: ( ruleSchema EOF )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:62:1: ruleSchema EOF
            {
             before(grammarAccess.getSchemaRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSchema_in_entryRuleSchema61);
            ruleSchema();

            state._fsp--;

             after(grammarAccess.getSchemaRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSchema68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSchema"


    // $ANTLR start "ruleSchema"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:69:1: ruleSchema : ( ( rule__Schema__Group__0 ) ) ;
    public final void ruleSchema() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:73:2: ( ( ( rule__Schema__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:74:1: ( ( rule__Schema__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:74:1: ( ( rule__Schema__Group__0 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:75:1: ( rule__Schema__Group__0 )
            {
             before(grammarAccess.getSchemaAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:76:1: ( rule__Schema__Group__0 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:76:2: rule__Schema__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__0_in_ruleSchema94);
            rule__Schema__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSchemaAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSchema"


    // $ANTLR start "entryRuleRelation"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:88:1: entryRuleRelation : ruleRelation EOF ;
    public final void entryRuleRelation() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:89:1: ( ruleRelation EOF )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:90:1: ruleRelation EOF
            {
             before(grammarAccess.getRelationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRelation_in_entryRuleRelation121);
            ruleRelation();

            state._fsp--;

             after(grammarAccess.getRelationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRelation128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:97:1: ruleRelation : ( ( rule__Relation__Group__0 ) ) ;
    public final void ruleRelation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:101:2: ( ( ( rule__Relation__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:102:1: ( ( rule__Relation__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:102:1: ( ( rule__Relation__Group__0 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:103:1: ( rule__Relation__Group__0 )
            {
             before(grammarAccess.getRelationAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:104:1: ( rule__Relation__Group__0 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:104:2: rule__Relation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__0_in_ruleRelation154);
            rule__Relation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleColumn"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:116:1: entryRuleColumn : ruleColumn EOF ;
    public final void entryRuleColumn() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:117:1: ( ruleColumn EOF )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:118:1: ruleColumn EOF
            {
             before(grammarAccess.getColumnRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleColumn_in_entryRuleColumn181);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getColumnRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleColumn188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleColumn"


    // $ANTLR start "ruleColumn"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:125:1: ruleColumn : ( ( rule__Column__Group__0 ) ) ;
    public final void ruleColumn() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:129:2: ( ( ( rule__Column__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:130:1: ( ( rule__Column__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:130:1: ( ( rule__Column__Group__0 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:131:1: ( rule__Column__Group__0 )
            {
             before(grammarAccess.getColumnAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:132:1: ( rule__Column__Group__0 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:132:2: rule__Column__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__0_in_ruleColumn214);
            rule__Column__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getColumnAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleColumn"


    // $ANTLR start "rule__Schema__Group__0"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:146:1: rule__Schema__Group__0 : rule__Schema__Group__0__Impl rule__Schema__Group__1 ;
    public final void rule__Schema__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:150:1: ( rule__Schema__Group__0__Impl rule__Schema__Group__1 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:151:2: rule__Schema__Group__0__Impl rule__Schema__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__0__Impl_in_rule__Schema__Group__0248);
            rule__Schema__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__1_in_rule__Schema__Group__0251);
            rule__Schema__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__0"


    // $ANTLR start "rule__Schema__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:158:1: rule__Schema__Group__0__Impl : ( () ) ;
    public final void rule__Schema__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:162:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:163:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:163:1: ( () )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:164:1: ()
            {
             before(grammarAccess.getSchemaAccess().getSchemaAction_0()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:165:1: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:167:1: 
            {
            }

             after(grammarAccess.getSchemaAccess().getSchemaAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__0__Impl"


    // $ANTLR start "rule__Schema__Group__1"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:177:1: rule__Schema__Group__1 : rule__Schema__Group__1__Impl rule__Schema__Group__2 ;
    public final void rule__Schema__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:181:1: ( rule__Schema__Group__1__Impl rule__Schema__Group__2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:182:2: rule__Schema__Group__1__Impl rule__Schema__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__1__Impl_in_rule__Schema__Group__1309);
            rule__Schema__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__2_in_rule__Schema__Group__1312);
            rule__Schema__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__1"


    // $ANTLR start "rule__Schema__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:189:1: rule__Schema__Group__1__Impl : ( 'schema' ) ;
    public final void rule__Schema__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:193:1: ( ( 'schema' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:194:1: ( 'schema' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:194:1: ( 'schema' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:195:1: 'schema'
            {
             before(grammarAccess.getSchemaAccess().getSchemaKeyword_1()); 
            match(input,11,FollowSets000.FOLLOW_11_in_rule__Schema__Group__1__Impl340); 
             after(grammarAccess.getSchemaAccess().getSchemaKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__1__Impl"


    // $ANTLR start "rule__Schema__Group__2"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:208:1: rule__Schema__Group__2 : rule__Schema__Group__2__Impl rule__Schema__Group__3 ;
    public final void rule__Schema__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:212:1: ( rule__Schema__Group__2__Impl rule__Schema__Group__3 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:213:2: rule__Schema__Group__2__Impl rule__Schema__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__2__Impl_in_rule__Schema__Group__2371);
            rule__Schema__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__3_in_rule__Schema__Group__2374);
            rule__Schema__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__2"


    // $ANTLR start "rule__Schema__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:220:1: rule__Schema__Group__2__Impl : ( ( rule__Schema__NameAssignment_2 ) ) ;
    public final void rule__Schema__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:224:1: ( ( ( rule__Schema__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:225:1: ( ( rule__Schema__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:225:1: ( ( rule__Schema__NameAssignment_2 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:226:1: ( rule__Schema__NameAssignment_2 )
            {
             before(grammarAccess.getSchemaAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:227:1: ( rule__Schema__NameAssignment_2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:227:2: rule__Schema__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__NameAssignment_2_in_rule__Schema__Group__2__Impl401);
            rule__Schema__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSchemaAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__2__Impl"


    // $ANTLR start "rule__Schema__Group__3"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:237:1: rule__Schema__Group__3 : rule__Schema__Group__3__Impl ;
    public final void rule__Schema__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:241:1: ( rule__Schema__Group__3__Impl )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:242:2: rule__Schema__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__3__Impl_in_rule__Schema__Group__3431);
            rule__Schema__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__3"


    // $ANTLR start "rule__Schema__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:248:1: rule__Schema__Group__3__Impl : ( ( rule__Schema__RelationsAssignment_3 )* ) ;
    public final void rule__Schema__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:252:1: ( ( ( rule__Schema__RelationsAssignment_3 )* ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:253:1: ( ( rule__Schema__RelationsAssignment_3 )* )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:253:1: ( ( rule__Schema__RelationsAssignment_3 )* )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:254:1: ( rule__Schema__RelationsAssignment_3 )*
            {
             before(grammarAccess.getSchemaAccess().getRelationsAssignment_3()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:255:1: ( rule__Schema__RelationsAssignment_3 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:255:2: rule__Schema__RelationsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Schema__RelationsAssignment_3_in_rule__Schema__Group__3__Impl458);
            	    rule__Schema__RelationsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getSchemaAccess().getRelationsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__3__Impl"


    // $ANTLR start "rule__Relation__Group__0"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:273:1: rule__Relation__Group__0 : rule__Relation__Group__0__Impl rule__Relation__Group__1 ;
    public final void rule__Relation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:277:1: ( rule__Relation__Group__0__Impl rule__Relation__Group__1 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:278:2: rule__Relation__Group__0__Impl rule__Relation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__0__Impl_in_rule__Relation__Group__0497);
            rule__Relation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__1_in_rule__Relation__Group__0500);
            rule__Relation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__0"


    // $ANTLR start "rule__Relation__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:285:1: rule__Relation__Group__0__Impl : ( () ) ;
    public final void rule__Relation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:289:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:290:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:290:1: ( () )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:291:1: ()
            {
             before(grammarAccess.getRelationAccess().getRelationAction_0()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:292:1: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:294:1: 
            {
            }

             after(grammarAccess.getRelationAccess().getRelationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__0__Impl"


    // $ANTLR start "rule__Relation__Group__1"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:304:1: rule__Relation__Group__1 : rule__Relation__Group__1__Impl rule__Relation__Group__2 ;
    public final void rule__Relation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:308:1: ( rule__Relation__Group__1__Impl rule__Relation__Group__2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:309:2: rule__Relation__Group__1__Impl rule__Relation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__1__Impl_in_rule__Relation__Group__1558);
            rule__Relation__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__2_in_rule__Relation__Group__1561);
            rule__Relation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__1"


    // $ANTLR start "rule__Relation__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:316:1: rule__Relation__Group__1__Impl : ( 'relation' ) ;
    public final void rule__Relation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:320:1: ( ( 'relation' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:321:1: ( 'relation' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:321:1: ( 'relation' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:322:1: 'relation'
            {
             before(grammarAccess.getRelationAccess().getRelationKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Relation__Group__1__Impl589); 
             after(grammarAccess.getRelationAccess().getRelationKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__1__Impl"


    // $ANTLR start "rule__Relation__Group__2"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:335:1: rule__Relation__Group__2 : rule__Relation__Group__2__Impl rule__Relation__Group__3 ;
    public final void rule__Relation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:339:1: ( rule__Relation__Group__2__Impl rule__Relation__Group__3 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:340:2: rule__Relation__Group__2__Impl rule__Relation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__2__Impl_in_rule__Relation__Group__2620);
            rule__Relation__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__3_in_rule__Relation__Group__2623);
            rule__Relation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__2"


    // $ANTLR start "rule__Relation__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:347:1: rule__Relation__Group__2__Impl : ( ( rule__Relation__NameAssignment_2 ) ) ;
    public final void rule__Relation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:351:1: ( ( ( rule__Relation__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:352:1: ( ( rule__Relation__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:352:1: ( ( rule__Relation__NameAssignment_2 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:353:1: ( rule__Relation__NameAssignment_2 )
            {
             before(grammarAccess.getRelationAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:354:1: ( rule__Relation__NameAssignment_2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:354:2: rule__Relation__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__NameAssignment_2_in_rule__Relation__Group__2__Impl650);
            rule__Relation__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRelationAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__2__Impl"


    // $ANTLR start "rule__Relation__Group__3"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:364:1: rule__Relation__Group__3 : rule__Relation__Group__3__Impl rule__Relation__Group__4 ;
    public final void rule__Relation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:368:1: ( rule__Relation__Group__3__Impl rule__Relation__Group__4 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:369:2: rule__Relation__Group__3__Impl rule__Relation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__3__Impl_in_rule__Relation__Group__3680);
            rule__Relation__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__4_in_rule__Relation__Group__3683);
            rule__Relation__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__3"


    // $ANTLR start "rule__Relation__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:376:1: rule__Relation__Group__3__Impl : ( '{' ) ;
    public final void rule__Relation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:380:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:381:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:381:1: ( '{' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:382:1: '{'
            {
             before(grammarAccess.getRelationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Relation__Group__3__Impl711); 
             after(grammarAccess.getRelationAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__3__Impl"


    // $ANTLR start "rule__Relation__Group__4"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:395:1: rule__Relation__Group__4 : rule__Relation__Group__4__Impl rule__Relation__Group__5 ;
    public final void rule__Relation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:399:1: ( rule__Relation__Group__4__Impl rule__Relation__Group__5 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:400:2: rule__Relation__Group__4__Impl rule__Relation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__4__Impl_in_rule__Relation__Group__4742);
            rule__Relation__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__5_in_rule__Relation__Group__4745);
            rule__Relation__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__4"


    // $ANTLR start "rule__Relation__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:407:1: rule__Relation__Group__4__Impl : ( ( rule__Relation__ColumnsAssignment_4 )* ) ;
    public final void rule__Relation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:411:1: ( ( ( rule__Relation__ColumnsAssignment_4 )* ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:412:1: ( ( rule__Relation__ColumnsAssignment_4 )* )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:412:1: ( ( rule__Relation__ColumnsAssignment_4 )* )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:413:1: ( rule__Relation__ColumnsAssignment_4 )*
            {
             before(grammarAccess.getRelationAccess().getColumnsAssignment_4()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:414:1: ( rule__Relation__ColumnsAssignment_4 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:414:2: rule__Relation__ColumnsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Relation__ColumnsAssignment_4_in_rule__Relation__Group__4__Impl772);
            	    rule__Relation__ColumnsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getRelationAccess().getColumnsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__4__Impl"


    // $ANTLR start "rule__Relation__Group__5"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:424:1: rule__Relation__Group__5 : rule__Relation__Group__5__Impl ;
    public final void rule__Relation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:428:1: ( rule__Relation__Group__5__Impl )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:429:2: rule__Relation__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__5__Impl_in_rule__Relation__Group__5803);
            rule__Relation__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__5"


    // $ANTLR start "rule__Relation__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:435:1: rule__Relation__Group__5__Impl : ( '}' ) ;
    public final void rule__Relation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:439:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:440:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:440:1: ( '}' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:441:1: '}'
            {
             before(grammarAccess.getRelationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Relation__Group__5__Impl831); 
             after(grammarAccess.getRelationAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__Group__5__Impl"


    // $ANTLR start "rule__Column__Group__0"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:466:1: rule__Column__Group__0 : rule__Column__Group__0__Impl rule__Column__Group__1 ;
    public final void rule__Column__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:470:1: ( rule__Column__Group__0__Impl rule__Column__Group__1 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:471:2: rule__Column__Group__0__Impl rule__Column__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__0__Impl_in_rule__Column__Group__0874);
            rule__Column__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__1_in_rule__Column__Group__0877);
            rule__Column__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__0"


    // $ANTLR start "rule__Column__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:478:1: rule__Column__Group__0__Impl : ( () ) ;
    public final void rule__Column__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:482:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:483:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:483:1: ( () )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:484:1: ()
            {
             before(grammarAccess.getColumnAccess().getColumnAction_0()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:485:1: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:487:1: 
            {
            }

             after(grammarAccess.getColumnAccess().getColumnAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__0__Impl"


    // $ANTLR start "rule__Column__Group__1"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:497:1: rule__Column__Group__1 : rule__Column__Group__1__Impl rule__Column__Group__2 ;
    public final void rule__Column__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:501:1: ( rule__Column__Group__1__Impl rule__Column__Group__2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:502:2: rule__Column__Group__1__Impl rule__Column__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__1__Impl_in_rule__Column__Group__1935);
            rule__Column__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__2_in_rule__Column__Group__1938);
            rule__Column__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__1"


    // $ANTLR start "rule__Column__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:509:1: rule__Column__Group__1__Impl : ( 'column' ) ;
    public final void rule__Column__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:513:1: ( ( 'column' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:514:1: ( 'column' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:514:1: ( 'column' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:515:1: 'column'
            {
             before(grammarAccess.getColumnAccess().getColumnKeyword_1()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Column__Group__1__Impl966); 
             after(grammarAccess.getColumnAccess().getColumnKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__1__Impl"


    // $ANTLR start "rule__Column__Group__2"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:528:1: rule__Column__Group__2 : rule__Column__Group__2__Impl ;
    public final void rule__Column__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:532:1: ( rule__Column__Group__2__Impl )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:533:2: rule__Column__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__2__Impl_in_rule__Column__Group__2997);
            rule__Column__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__2"


    // $ANTLR start "rule__Column__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:539:1: rule__Column__Group__2__Impl : ( ( rule__Column__NameAssignment_2 ) ) ;
    public final void rule__Column__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:543:1: ( ( ( rule__Column__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:544:1: ( ( rule__Column__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:544:1: ( ( rule__Column__NameAssignment_2 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:545:1: ( rule__Column__NameAssignment_2 )
            {
             before(grammarAccess.getColumnAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:546:1: ( rule__Column__NameAssignment_2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:546:2: rule__Column__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__NameAssignment_2_in_rule__Column__Group__2__Impl1024);
            rule__Column__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getColumnAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__Group__2__Impl"


    // $ANTLR start "rule__Schema__NameAssignment_2"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:563:1: rule__Schema__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Schema__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:567:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:568:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:568:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:569:1: RULE_ID
            {
             before(grammarAccess.getSchemaAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Schema__NameAssignment_21065); 
             after(grammarAccess.getSchemaAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__NameAssignment_2"


    // $ANTLR start "rule__Schema__RelationsAssignment_3"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:578:1: rule__Schema__RelationsAssignment_3 : ( ruleRelation ) ;
    public final void rule__Schema__RelationsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:582:1: ( ( ruleRelation ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:583:1: ( ruleRelation )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:583:1: ( ruleRelation )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:584:1: ruleRelation
            {
             before(grammarAccess.getSchemaAccess().getRelationsRelationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleRelation_in_rule__Schema__RelationsAssignment_31096);
            ruleRelation();

            state._fsp--;

             after(grammarAccess.getSchemaAccess().getRelationsRelationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__RelationsAssignment_3"


    // $ANTLR start "rule__Relation__NameAssignment_2"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:593:1: rule__Relation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Relation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:597:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:598:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:598:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:599:1: RULE_ID
            {
             before(grammarAccess.getRelationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Relation__NameAssignment_21127); 
             after(grammarAccess.getRelationAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__NameAssignment_2"


    // $ANTLR start "rule__Relation__ColumnsAssignment_4"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:608:1: rule__Relation__ColumnsAssignment_4 : ( ruleColumn ) ;
    public final void rule__Relation__ColumnsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:612:1: ( ( ruleColumn ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:613:1: ( ruleColumn )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:613:1: ( ruleColumn )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:614:1: ruleColumn
            {
             before(grammarAccess.getRelationAccess().getColumnsColumnParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleColumn_in_rule__Relation__ColumnsAssignment_41158);
            ruleColumn();

            state._fsp--;

             after(grammarAccess.getRelationAccess().getColumnsColumnParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relation__ColumnsAssignment_4"


    // $ANTLR start "rule__Column__NameAssignment_2"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:623:1: rule__Column__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Column__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:627:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:628:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:628:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:629:1: RULE_ID
            {
             before(grammarAccess.getColumnAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Column__NameAssignment_21189); 
             after(grammarAccess.getColumnAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Column__NameAssignment_2"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleSchema_in_entryRuleSchema61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSchema68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__0_in_ruleSchema94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRelation_in_entryRuleRelation121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRelation128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__0_in_ruleRelation154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleColumn_in_entryRuleColumn181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleColumn188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group__0_in_ruleColumn214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__0__Impl_in_rule__Schema__Group__0248 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__Schema__Group__1_in_rule__Schema__Group__0251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__1__Impl_in_rule__Schema__Group__1309 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Schema__Group__2_in_rule__Schema__Group__1312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Schema__Group__1__Impl340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__2__Impl_in_rule__Schema__Group__2371 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Schema__Group__3_in_rule__Schema__Group__2374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__NameAssignment_2_in_rule__Schema__Group__2__Impl401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__3__Impl_in_rule__Schema__Group__3431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__RelationsAssignment_3_in_rule__Schema__Group__3__Impl458 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__Relation__Group__0__Impl_in_rule__Relation__Group__0497 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__Relation__Group__1_in_rule__Relation__Group__0500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__1__Impl_in_rule__Relation__Group__1558 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Relation__Group__2_in_rule__Relation__Group__1561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Relation__Group__1__Impl589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__2__Impl_in_rule__Relation__Group__2620 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Relation__Group__3_in_rule__Relation__Group__2623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__NameAssignment_2_in_rule__Relation__Group__2__Impl650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__3__Impl_in_rule__Relation__Group__3680 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Relation__Group__4_in_rule__Relation__Group__3683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Relation__Group__3__Impl711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__4__Impl_in_rule__Relation__Group__4742 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Relation__Group__5_in_rule__Relation__Group__4745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__ColumnsAssignment_4_in_rule__Relation__Group__4__Impl772 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__Relation__Group__5__Impl_in_rule__Relation__Group__5803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Relation__Group__5__Impl831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group__0__Impl_in_rule__Column__Group__0874 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Column__Group__1_in_rule__Column__Group__0877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group__1__Impl_in_rule__Column__Group__1935 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Column__Group__2_in_rule__Column__Group__1938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Column__Group__1__Impl966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group__2__Impl_in_rule__Column__Group__2997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__NameAssignment_2_in_rule__Column__Group__2__Impl1024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Schema__NameAssignment_21065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRelation_in_rule__Schema__RelationsAssignment_31096 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Relation__NameAssignment_21127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleColumn_in_rule__Relation__ColumnsAssignment_41158 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Column__NameAssignment_21189 = new BitSet(new long[]{0x0000000000000002L});
    }


}