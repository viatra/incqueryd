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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'ID'", "'STRING'", "'NUMBER'", "'BOOLEAN'", "'schema'", "'relation'", "'{'", "'}'", "'column'", "':'"
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


    // $ANTLR start "ruleColumnType"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:145:1: ruleColumnType : ( ( rule__ColumnType__Alternatives ) ) ;
    public final void ruleColumnType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:149:1: ( ( ( rule__ColumnType__Alternatives ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:150:1: ( ( rule__ColumnType__Alternatives ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:150:1: ( ( rule__ColumnType__Alternatives ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:151:1: ( rule__ColumnType__Alternatives )
            {
             before(grammarAccess.getColumnTypeAccess().getAlternatives()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:152:1: ( rule__ColumnType__Alternatives )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:152:2: rule__ColumnType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ColumnType__Alternatives_in_ruleColumnType251);
            rule__ColumnType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getColumnTypeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleColumnType"


    // $ANTLR start "rule__ColumnType__Alternatives"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:163:1: rule__ColumnType__Alternatives : ( ( ( 'ID' ) ) | ( ( 'STRING' ) ) | ( ( 'NUMBER' ) ) | ( ( 'BOOLEAN' ) ) );
    public final void rule__ColumnType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:167:1: ( ( ( 'ID' ) ) | ( ( 'STRING' ) ) | ( ( 'NUMBER' ) ) | ( ( 'BOOLEAN' ) ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 12:
                {
                alt1=2;
                }
                break;
            case 13:
                {
                alt1=3;
                }
                break;
            case 14:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:168:1: ( ( 'ID' ) )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:168:1: ( ( 'ID' ) )
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:169:1: ( 'ID' )
                    {
                     before(grammarAccess.getColumnTypeAccess().getIdEnumLiteralDeclaration_0()); 
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:170:1: ( 'ID' )
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:170:3: 'ID'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__ColumnType__Alternatives287); 

                    }

                     after(grammarAccess.getColumnTypeAccess().getIdEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:175:6: ( ( 'STRING' ) )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:175:6: ( ( 'STRING' ) )
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:176:1: ( 'STRING' )
                    {
                     before(grammarAccess.getColumnTypeAccess().getStringEnumLiteralDeclaration_1()); 
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:177:1: ( 'STRING' )
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:177:3: 'STRING'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__ColumnType__Alternatives308); 

                    }

                     after(grammarAccess.getColumnTypeAccess().getStringEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:182:6: ( ( 'NUMBER' ) )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:182:6: ( ( 'NUMBER' ) )
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:183:1: ( 'NUMBER' )
                    {
                     before(grammarAccess.getColumnTypeAccess().getNumberEnumLiteralDeclaration_2()); 
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:184:1: ( 'NUMBER' )
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:184:3: 'NUMBER'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__ColumnType__Alternatives329); 

                    }

                     after(grammarAccess.getColumnTypeAccess().getNumberEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:189:6: ( ( 'BOOLEAN' ) )
                    {
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:189:6: ( ( 'BOOLEAN' ) )
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:190:1: ( 'BOOLEAN' )
                    {
                     before(grammarAccess.getColumnTypeAccess().getBooleanEnumLiteralDeclaration_3()); 
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:191:1: ( 'BOOLEAN' )
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:191:3: 'BOOLEAN'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__ColumnType__Alternatives350); 

                    }

                     after(grammarAccess.getColumnTypeAccess().getBooleanEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

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
    // $ANTLR end "rule__ColumnType__Alternatives"


    // $ANTLR start "rule__Schema__Group__0"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:203:1: rule__Schema__Group__0 : rule__Schema__Group__0__Impl rule__Schema__Group__1 ;
    public final void rule__Schema__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:207:1: ( rule__Schema__Group__0__Impl rule__Schema__Group__1 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:208:2: rule__Schema__Group__0__Impl rule__Schema__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__0__Impl_in_rule__Schema__Group__0383);
            rule__Schema__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__1_in_rule__Schema__Group__0386);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:215:1: rule__Schema__Group__0__Impl : ( () ) ;
    public final void rule__Schema__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:219:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:220:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:220:1: ( () )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:221:1: ()
            {
             before(grammarAccess.getSchemaAccess().getSchemaAction_0()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:222:1: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:224:1: 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:234:1: rule__Schema__Group__1 : rule__Schema__Group__1__Impl rule__Schema__Group__2 ;
    public final void rule__Schema__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:238:1: ( rule__Schema__Group__1__Impl rule__Schema__Group__2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:239:2: rule__Schema__Group__1__Impl rule__Schema__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__1__Impl_in_rule__Schema__Group__1444);
            rule__Schema__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__2_in_rule__Schema__Group__1447);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:246:1: rule__Schema__Group__1__Impl : ( 'schema' ) ;
    public final void rule__Schema__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:250:1: ( ( 'schema' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:251:1: ( 'schema' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:251:1: ( 'schema' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:252:1: 'schema'
            {
             before(grammarAccess.getSchemaAccess().getSchemaKeyword_1()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Schema__Group__1__Impl475); 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:265:1: rule__Schema__Group__2 : rule__Schema__Group__2__Impl rule__Schema__Group__3 ;
    public final void rule__Schema__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:269:1: ( rule__Schema__Group__2__Impl rule__Schema__Group__3 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:270:2: rule__Schema__Group__2__Impl rule__Schema__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__2__Impl_in_rule__Schema__Group__2506);
            rule__Schema__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__3_in_rule__Schema__Group__2509);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:277:1: rule__Schema__Group__2__Impl : ( ( rule__Schema__NameAssignment_2 ) ) ;
    public final void rule__Schema__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:281:1: ( ( ( rule__Schema__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:282:1: ( ( rule__Schema__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:282:1: ( ( rule__Schema__NameAssignment_2 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:283:1: ( rule__Schema__NameAssignment_2 )
            {
             before(grammarAccess.getSchemaAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:284:1: ( rule__Schema__NameAssignment_2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:284:2: rule__Schema__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__NameAssignment_2_in_rule__Schema__Group__2__Impl536);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:294:1: rule__Schema__Group__3 : rule__Schema__Group__3__Impl ;
    public final void rule__Schema__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:298:1: ( rule__Schema__Group__3__Impl )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:299:2: rule__Schema__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Schema__Group__3__Impl_in_rule__Schema__Group__3566);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:305:1: rule__Schema__Group__3__Impl : ( ( rule__Schema__RelationsAssignment_3 )* ) ;
    public final void rule__Schema__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:309:1: ( ( ( rule__Schema__RelationsAssignment_3 )* ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:310:1: ( ( rule__Schema__RelationsAssignment_3 )* )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:310:1: ( ( rule__Schema__RelationsAssignment_3 )* )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:311:1: ( rule__Schema__RelationsAssignment_3 )*
            {
             before(grammarAccess.getSchemaAccess().getRelationsAssignment_3()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:312:1: ( rule__Schema__RelationsAssignment_3 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:312:2: rule__Schema__RelationsAssignment_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Schema__RelationsAssignment_3_in_rule__Schema__Group__3__Impl593);
            	    rule__Schema__RelationsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:330:1: rule__Relation__Group__0 : rule__Relation__Group__0__Impl rule__Relation__Group__1 ;
    public final void rule__Relation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:334:1: ( rule__Relation__Group__0__Impl rule__Relation__Group__1 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:335:2: rule__Relation__Group__0__Impl rule__Relation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__0__Impl_in_rule__Relation__Group__0632);
            rule__Relation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__1_in_rule__Relation__Group__0635);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:342:1: rule__Relation__Group__0__Impl : ( () ) ;
    public final void rule__Relation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:346:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:347:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:347:1: ( () )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:348:1: ()
            {
             before(grammarAccess.getRelationAccess().getRelationAction_0()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:349:1: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:351:1: 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:361:1: rule__Relation__Group__1 : rule__Relation__Group__1__Impl rule__Relation__Group__2 ;
    public final void rule__Relation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:365:1: ( rule__Relation__Group__1__Impl rule__Relation__Group__2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:366:2: rule__Relation__Group__1__Impl rule__Relation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__1__Impl_in_rule__Relation__Group__1693);
            rule__Relation__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__2_in_rule__Relation__Group__1696);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:373:1: rule__Relation__Group__1__Impl : ( 'relation' ) ;
    public final void rule__Relation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:377:1: ( ( 'relation' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:378:1: ( 'relation' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:378:1: ( 'relation' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:379:1: 'relation'
            {
             before(grammarAccess.getRelationAccess().getRelationKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Relation__Group__1__Impl724); 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:392:1: rule__Relation__Group__2 : rule__Relation__Group__2__Impl rule__Relation__Group__3 ;
    public final void rule__Relation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:396:1: ( rule__Relation__Group__2__Impl rule__Relation__Group__3 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:397:2: rule__Relation__Group__2__Impl rule__Relation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__2__Impl_in_rule__Relation__Group__2755);
            rule__Relation__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__3_in_rule__Relation__Group__2758);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:404:1: rule__Relation__Group__2__Impl : ( ( rule__Relation__NameAssignment_2 ) ) ;
    public final void rule__Relation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:408:1: ( ( ( rule__Relation__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:409:1: ( ( rule__Relation__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:409:1: ( ( rule__Relation__NameAssignment_2 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:410:1: ( rule__Relation__NameAssignment_2 )
            {
             before(grammarAccess.getRelationAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:411:1: ( rule__Relation__NameAssignment_2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:411:2: rule__Relation__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__NameAssignment_2_in_rule__Relation__Group__2__Impl785);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:421:1: rule__Relation__Group__3 : rule__Relation__Group__3__Impl rule__Relation__Group__4 ;
    public final void rule__Relation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:425:1: ( rule__Relation__Group__3__Impl rule__Relation__Group__4 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:426:2: rule__Relation__Group__3__Impl rule__Relation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__3__Impl_in_rule__Relation__Group__3815);
            rule__Relation__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__4_in_rule__Relation__Group__3818);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:433:1: rule__Relation__Group__3__Impl : ( '{' ) ;
    public final void rule__Relation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:437:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:438:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:438:1: ( '{' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:439:1: '{'
            {
             before(grammarAccess.getRelationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Relation__Group__3__Impl846); 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:452:1: rule__Relation__Group__4 : rule__Relation__Group__4__Impl rule__Relation__Group__5 ;
    public final void rule__Relation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:456:1: ( rule__Relation__Group__4__Impl rule__Relation__Group__5 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:457:2: rule__Relation__Group__4__Impl rule__Relation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__4__Impl_in_rule__Relation__Group__4877);
            rule__Relation__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__5_in_rule__Relation__Group__4880);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:464:1: rule__Relation__Group__4__Impl : ( ( rule__Relation__ColumnsAssignment_4 )* ) ;
    public final void rule__Relation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:468:1: ( ( ( rule__Relation__ColumnsAssignment_4 )* ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:469:1: ( ( rule__Relation__ColumnsAssignment_4 )* )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:469:1: ( ( rule__Relation__ColumnsAssignment_4 )* )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:470:1: ( rule__Relation__ColumnsAssignment_4 )*
            {
             before(grammarAccess.getRelationAccess().getColumnsAssignment_4()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:471:1: ( rule__Relation__ColumnsAssignment_4 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:471:2: rule__Relation__ColumnsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Relation__ColumnsAssignment_4_in_rule__Relation__Group__4__Impl907);
            	    rule__Relation__ColumnsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:481:1: rule__Relation__Group__5 : rule__Relation__Group__5__Impl ;
    public final void rule__Relation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:485:1: ( rule__Relation__Group__5__Impl )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:486:2: rule__Relation__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Relation__Group__5__Impl_in_rule__Relation__Group__5938);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:492:1: rule__Relation__Group__5__Impl : ( '}' ) ;
    public final void rule__Relation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:496:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:497:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:497:1: ( '}' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:498:1: '}'
            {
             before(grammarAccess.getRelationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Relation__Group__5__Impl966); 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:523:1: rule__Column__Group__0 : rule__Column__Group__0__Impl rule__Column__Group__1 ;
    public final void rule__Column__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:527:1: ( rule__Column__Group__0__Impl rule__Column__Group__1 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:528:2: rule__Column__Group__0__Impl rule__Column__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__0__Impl_in_rule__Column__Group__01009);
            rule__Column__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__1_in_rule__Column__Group__01012);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:535:1: rule__Column__Group__0__Impl : ( () ) ;
    public final void rule__Column__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:539:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:540:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:540:1: ( () )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:541:1: ()
            {
             before(grammarAccess.getColumnAccess().getColumnAction_0()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:542:1: ()
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:544:1: 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:554:1: rule__Column__Group__1 : rule__Column__Group__1__Impl rule__Column__Group__2 ;
    public final void rule__Column__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:558:1: ( rule__Column__Group__1__Impl rule__Column__Group__2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:559:2: rule__Column__Group__1__Impl rule__Column__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__1__Impl_in_rule__Column__Group__11070);
            rule__Column__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__2_in_rule__Column__Group__11073);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:566:1: rule__Column__Group__1__Impl : ( 'column' ) ;
    public final void rule__Column__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:570:1: ( ( 'column' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:571:1: ( 'column' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:571:1: ( 'column' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:572:1: 'column'
            {
             before(grammarAccess.getColumnAccess().getColumnKeyword_1()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Column__Group__1__Impl1101); 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:585:1: rule__Column__Group__2 : rule__Column__Group__2__Impl rule__Column__Group__3 ;
    public final void rule__Column__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:589:1: ( rule__Column__Group__2__Impl rule__Column__Group__3 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:590:2: rule__Column__Group__2__Impl rule__Column__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__2__Impl_in_rule__Column__Group__21132);
            rule__Column__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__3_in_rule__Column__Group__21135);
            rule__Column__Group__3();

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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:597:1: rule__Column__Group__2__Impl : ( ( rule__Column__NameAssignment_2 ) ) ;
    public final void rule__Column__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:601:1: ( ( ( rule__Column__NameAssignment_2 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:602:1: ( ( rule__Column__NameAssignment_2 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:602:1: ( ( rule__Column__NameAssignment_2 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:603:1: ( rule__Column__NameAssignment_2 )
            {
             before(grammarAccess.getColumnAccess().getNameAssignment_2()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:604:1: ( rule__Column__NameAssignment_2 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:604:2: rule__Column__NameAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__NameAssignment_2_in_rule__Column__Group__2__Impl1162);
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


    // $ANTLR start "rule__Column__Group__3"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:614:1: rule__Column__Group__3 : rule__Column__Group__3__Impl ;
    public final void rule__Column__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:618:1: ( rule__Column__Group__3__Impl )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:619:2: rule__Column__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group__3__Impl_in_rule__Column__Group__31192);
            rule__Column__Group__3__Impl();

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
    // $ANTLR end "rule__Column__Group__3"


    // $ANTLR start "rule__Column__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:625:1: rule__Column__Group__3__Impl : ( ( rule__Column__Group_3__0 )? ) ;
    public final void rule__Column__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:629:1: ( ( ( rule__Column__Group_3__0 )? ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:630:1: ( ( rule__Column__Group_3__0 )? )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:630:1: ( ( rule__Column__Group_3__0 )? )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:631:1: ( rule__Column__Group_3__0 )?
            {
             before(grammarAccess.getColumnAccess().getGroup_3()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:632:1: ( rule__Column__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==20) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:632:2: rule__Column__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Column__Group_3__0_in_rule__Column__Group__3__Impl1219);
                    rule__Column__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getColumnAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Column__Group__3__Impl"


    // $ANTLR start "rule__Column__Group_3__0"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:650:1: rule__Column__Group_3__0 : rule__Column__Group_3__0__Impl rule__Column__Group_3__1 ;
    public final void rule__Column__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:654:1: ( rule__Column__Group_3__0__Impl rule__Column__Group_3__1 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:655:2: rule__Column__Group_3__0__Impl rule__Column__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group_3__0__Impl_in_rule__Column__Group_3__01258);
            rule__Column__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Column__Group_3__1_in_rule__Column__Group_3__01261);
            rule__Column__Group_3__1();

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
    // $ANTLR end "rule__Column__Group_3__0"


    // $ANTLR start "rule__Column__Group_3__0__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:662:1: rule__Column__Group_3__0__Impl : ( ':' ) ;
    public final void rule__Column__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:666:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:667:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:667:1: ( ':' )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:668:1: ':'
            {
             before(grammarAccess.getColumnAccess().getColonKeyword_3_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Column__Group_3__0__Impl1289); 
             after(grammarAccess.getColumnAccess().getColonKeyword_3_0()); 

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
    // $ANTLR end "rule__Column__Group_3__0__Impl"


    // $ANTLR start "rule__Column__Group_3__1"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:681:1: rule__Column__Group_3__1 : rule__Column__Group_3__1__Impl ;
    public final void rule__Column__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:685:1: ( rule__Column__Group_3__1__Impl )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:686:2: rule__Column__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__Group_3__1__Impl_in_rule__Column__Group_3__11320);
            rule__Column__Group_3__1__Impl();

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
    // $ANTLR end "rule__Column__Group_3__1"


    // $ANTLR start "rule__Column__Group_3__1__Impl"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:692:1: rule__Column__Group_3__1__Impl : ( ( rule__Column__TypeAssignment_3_1 ) ) ;
    public final void rule__Column__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:696:1: ( ( ( rule__Column__TypeAssignment_3_1 ) ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:697:1: ( ( rule__Column__TypeAssignment_3_1 ) )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:697:1: ( ( rule__Column__TypeAssignment_3_1 ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:698:1: ( rule__Column__TypeAssignment_3_1 )
            {
             before(grammarAccess.getColumnAccess().getTypeAssignment_3_1()); 
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:699:1: ( rule__Column__TypeAssignment_3_1 )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:699:2: rule__Column__TypeAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Column__TypeAssignment_3_1_in_rule__Column__Group_3__1__Impl1347);
            rule__Column__TypeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getColumnAccess().getTypeAssignment_3_1()); 

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
    // $ANTLR end "rule__Column__Group_3__1__Impl"


    // $ANTLR start "rule__Schema__NameAssignment_2"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:714:1: rule__Schema__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Schema__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:718:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:719:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:719:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:720:1: RULE_ID
            {
             before(grammarAccess.getSchemaAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Schema__NameAssignment_21386); 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:729:1: rule__Schema__RelationsAssignment_3 : ( ruleRelation ) ;
    public final void rule__Schema__RelationsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:733:1: ( ( ruleRelation ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:734:1: ( ruleRelation )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:734:1: ( ruleRelation )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:735:1: ruleRelation
            {
             before(grammarAccess.getSchemaAccess().getRelationsRelationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleRelation_in_rule__Schema__RelationsAssignment_31417);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:744:1: rule__Relation__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Relation__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:748:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:749:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:749:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:750:1: RULE_ID
            {
             before(grammarAccess.getRelationAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Relation__NameAssignment_21448); 
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:759:1: rule__Relation__ColumnsAssignment_4 : ( ruleColumn ) ;
    public final void rule__Relation__ColumnsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:763:1: ( ( ruleColumn ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:764:1: ( ruleColumn )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:764:1: ( ruleColumn )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:765:1: ruleColumn
            {
             before(grammarAccess.getRelationAccess().getColumnsColumnParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleColumn_in_rule__Relation__ColumnsAssignment_41479);
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
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:774:1: rule__Column__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Column__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:778:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:779:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:779:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:780:1: RULE_ID
            {
             before(grammarAccess.getColumnAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Column__NameAssignment_21510); 
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


    // $ANTLR start "rule__Column__TypeAssignment_3_1"
    // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:789:1: rule__Column__TypeAssignment_3_1 : ( ruleColumnType ) ;
    public final void rule__Column__TypeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:793:1: ( ( ruleColumnType ) )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:794:1: ( ruleColumnType )
            {
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:794:1: ( ruleColumnType )
            // ../hu.bme.mit.incqueryd.mondixschema.language.ui/src-gen/hu/bme/mit/incqueryd/mondixschema/language/ui/contentassist/antlr/internal/InternalMondixSchema.g:795:1: ruleColumnType
            {
             before(grammarAccess.getColumnAccess().getTypeColumnTypeEnumRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleColumnType_in_rule__Column__TypeAssignment_3_11541);
            ruleColumnType();

            state._fsp--;

             after(grammarAccess.getColumnAccess().getTypeColumnTypeEnumRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__Column__TypeAssignment_3_1"

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
        public static final BitSet FOLLOW_rule__ColumnType__Alternatives_in_ruleColumnType251 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__ColumnType__Alternatives287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__ColumnType__Alternatives308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ColumnType__Alternatives329 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ColumnType__Alternatives350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__0__Impl_in_rule__Schema__Group__0383 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Schema__Group__1_in_rule__Schema__Group__0386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__1__Impl_in_rule__Schema__Group__1444 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Schema__Group__2_in_rule__Schema__Group__1447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Schema__Group__1__Impl475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__2__Impl_in_rule__Schema__Group__2506 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Schema__Group__3_in_rule__Schema__Group__2509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__NameAssignment_2_in_rule__Schema__Group__2__Impl536 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__Group__3__Impl_in_rule__Schema__Group__3566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Schema__RelationsAssignment_3_in_rule__Schema__Group__3__Impl593 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_rule__Relation__Group__0__Impl_in_rule__Relation__Group__0632 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_rule__Relation__Group__1_in_rule__Relation__Group__0635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__1__Impl_in_rule__Relation__Group__1693 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Relation__Group__2_in_rule__Relation__Group__1696 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Relation__Group__1__Impl724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__2__Impl_in_rule__Relation__Group__2755 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Relation__Group__3_in_rule__Relation__Group__2758 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__NameAssignment_2_in_rule__Relation__Group__2__Impl785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__3__Impl_in_rule__Relation__Group__3815 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_rule__Relation__Group__4_in_rule__Relation__Group__3818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Relation__Group__3__Impl846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__Group__4__Impl_in_rule__Relation__Group__4877 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_rule__Relation__Group__5_in_rule__Relation__Group__4880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Relation__ColumnsAssignment_4_in_rule__Relation__Group__4__Impl907 = new BitSet(new long[]{0x0000000000080002L});
        public static final BitSet FOLLOW_rule__Relation__Group__5__Impl_in_rule__Relation__Group__5938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Relation__Group__5__Impl966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group__0__Impl_in_rule__Column__Group__01009 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Column__Group__1_in_rule__Column__Group__01012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group__1__Impl_in_rule__Column__Group__11070 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Column__Group__2_in_rule__Column__Group__11073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Column__Group__1__Impl1101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group__2__Impl_in_rule__Column__Group__21132 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__Column__Group__3_in_rule__Column__Group__21135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__NameAssignment_2_in_rule__Column__Group__2__Impl1162 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group__3__Impl_in_rule__Column__Group__31192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group_3__0_in_rule__Column__Group__3__Impl1219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group_3__0__Impl_in_rule__Column__Group_3__01258 = new BitSet(new long[]{0x0000000000007800L});
        public static final BitSet FOLLOW_rule__Column__Group_3__1_in_rule__Column__Group_3__01261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Column__Group_3__0__Impl1289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__Group_3__1__Impl_in_rule__Column__Group_3__11320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Column__TypeAssignment_3_1_in_rule__Column__Group_3__1__Impl1347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Schema__NameAssignment_21386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRelation_in_rule__Schema__RelationsAssignment_31417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Relation__NameAssignment_21448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleColumn_in_rule__Relation__ColumnsAssignment_41479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Column__NameAssignment_21510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleColumnType_in_rule__Column__TypeAssignment_3_11541 = new BitSet(new long[]{0x0000000000000002L});
    }


}