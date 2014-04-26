package hu.bme.mit.incqueryd.arch.language.ui.contentassist.antlr.internal; 

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
import hu.bme.mit.incqueryd.arch.language.services.ArchLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalArchLanguageParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_IP", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'clusters'", "':'", "'['", "']'", "'recipes'", "'mappings'", "'{'", "'}'", "'reteMachines'", "'cacheMachines'", "'traceInfo'", "'ip'", "'nodes'", "'Production'", "'parents'", "'UniquenessEnforcer'", "'Check'", "'parent'", "'Trimmer'", "'mask'", "'Join'", "'leftParent'", "'rightParent'", "'AntiJoin'", "'sourceArity'", "'sourceIndices'", "'from'", "'to'"
    };
    public static final int RULE_ID=6;
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
    public static final int RULE_STRING=4;
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
    public static final int RULE_IP=5;
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
    public String getGrammarFileName() { return "../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g"; }


     
     	private ArchLanguageGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ArchLanguageGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleConfiguration"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:60:1: entryRuleConfiguration : ruleConfiguration EOF ;
    public final void entryRuleConfiguration() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:61:1: ( ruleConfiguration EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:62:1: ruleConfiguration EOF
            {
             before(grammarAccess.getConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_entryRuleConfiguration61);
            ruleConfiguration();

            state._fsp--;

             after(grammarAccess.getConfigurationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConfiguration68); 

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
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:69:1: ruleConfiguration : ( ( rule__Configuration__Group__0 ) ) ;
    public final void ruleConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:73:2: ( ( ( rule__Configuration__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:74:1: ( ( rule__Configuration__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:74:1: ( ( rule__Configuration__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:75:1: ( rule__Configuration__Group__0 )
            {
             before(grammarAccess.getConfigurationAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:76:1: ( rule__Configuration__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:76:2: rule__Configuration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__0_in_ruleConfiguration94);
            rule__Configuration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getGroup()); 

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
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleCluster"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:88:1: entryRuleCluster : ruleCluster EOF ;
    public final void entryRuleCluster() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:89:1: ( ruleCluster EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:90:1: ruleCluster EOF
            {
             before(grammarAccess.getClusterRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCluster_in_entryRuleCluster121);
            ruleCluster();

            state._fsp--;

             after(grammarAccess.getClusterRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCluster128); 

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
    // $ANTLR end "entryRuleCluster"


    // $ANTLR start "ruleCluster"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:97:1: ruleCluster : ( ( rule__Cluster__Group__0 ) ) ;
    public final void ruleCluster() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:101:2: ( ( ( rule__Cluster__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:102:1: ( ( rule__Cluster__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:102:1: ( ( rule__Cluster__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:103:1: ( rule__Cluster__Group__0 )
            {
             before(grammarAccess.getClusterAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:104:1: ( rule__Cluster__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:104:2: rule__Cluster__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__0_in_ruleCluster154);
            rule__Cluster__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getClusterAccess().getGroup()); 

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
    // $ANTLR end "ruleCluster"


    // $ANTLR start "entryRuleMachine"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:116:1: entryRuleMachine : ruleMachine EOF ;
    public final void entryRuleMachine() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:117:1: ( ruleMachine EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:118:1: ruleMachine EOF
            {
             before(grammarAccess.getMachineRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_entryRuleMachine181);
            ruleMachine();

            state._fsp--;

             after(grammarAccess.getMachineRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMachine188); 

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
    // $ANTLR end "entryRuleMachine"


    // $ANTLR start "ruleMachine"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:125:1: ruleMachine : ( ( rule__Machine__Group__0 ) ) ;
    public final void ruleMachine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:129:2: ( ( ( rule__Machine__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:130:1: ( ( rule__Machine__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:130:1: ( ( rule__Machine__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:131:1: ( rule__Machine__Group__0 )
            {
             before(grammarAccess.getMachineAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:132:1: ( rule__Machine__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:132:2: rule__Machine__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__0_in_ruleMachine214);
            rule__Machine__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMachineAccess().getGroup()); 

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
    // $ANTLR end "ruleMachine"


    // $ANTLR start "entryRuleReteRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:144:1: entryRuleReteRecipe : ruleReteRecipe EOF ;
    public final void entryRuleReteRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:145:1: ( ruleReteRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:146:1: ruleReteRecipe EOF
            {
             before(grammarAccess.getReteRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteRecipe_in_entryRuleReteRecipe241);
            ruleReteRecipe();

            state._fsp--;

             after(grammarAccess.getReteRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReteRecipe248); 

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
    // $ANTLR end "entryRuleReteRecipe"


    // $ANTLR start "ruleReteRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:153:1: ruleReteRecipe : ( ( rule__ReteRecipe__Group__0 ) ) ;
    public final void ruleReteRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:157:2: ( ( ( rule__ReteRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:158:1: ( ( rule__ReteRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:158:1: ( ( rule__ReteRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:159:1: ( rule__ReteRecipe__Group__0 )
            {
             before(grammarAccess.getReteRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:160:1: ( rule__ReteRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:160:2: rule__ReteRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__0_in_ruleReteRecipe274);
            rule__ReteRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getReteRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleReteRecipe"


    // $ANTLR start "entryRuleReteNodeRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:172:1: entryRuleReteNodeRecipe : ruleReteNodeRecipe EOF ;
    public final void entryRuleReteNodeRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:173:1: ( ruleReteNodeRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:174:1: ruleReteNodeRecipe EOF
            {
             before(grammarAccess.getReteNodeRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteNodeRecipe_in_entryRuleReteNodeRecipe301);
            ruleReteNodeRecipe();

            state._fsp--;

             after(grammarAccess.getReteNodeRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReteNodeRecipe308); 

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
    // $ANTLR end "entryRuleReteNodeRecipe"


    // $ANTLR start "ruleReteNodeRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:181:1: ruleReteNodeRecipe : ( ( rule__ReteNodeRecipe__Alternatives ) ) ;
    public final void ruleReteNodeRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:185:2: ( ( ( rule__ReteNodeRecipe__Alternatives ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:186:1: ( ( rule__ReteNodeRecipe__Alternatives ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:186:1: ( ( rule__ReteNodeRecipe__Alternatives ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:187:1: ( rule__ReteNodeRecipe__Alternatives )
            {
             before(grammarAccess.getReteNodeRecipeAccess().getAlternatives()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:188:1: ( rule__ReteNodeRecipe__Alternatives )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:188:2: rule__ReteNodeRecipe__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteNodeRecipe__Alternatives_in_ruleReteNodeRecipe334);
            rule__ReteNodeRecipe__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getReteNodeRecipeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleReteNodeRecipe"


    // $ANTLR start "entryRuleProductionRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:200:1: entryRuleProductionRecipe : ruleProductionRecipe EOF ;
    public final void entryRuleProductionRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:201:1: ( ruleProductionRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:202:1: ruleProductionRecipe EOF
            {
             before(grammarAccess.getProductionRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProductionRecipe_in_entryRuleProductionRecipe361);
            ruleProductionRecipe();

            state._fsp--;

             after(grammarAccess.getProductionRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProductionRecipe368); 

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
    // $ANTLR end "entryRuleProductionRecipe"


    // $ANTLR start "ruleProductionRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:209:1: ruleProductionRecipe : ( ( rule__ProductionRecipe__Group__0 ) ) ;
    public final void ruleProductionRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:213:2: ( ( ( rule__ProductionRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:214:1: ( ( rule__ProductionRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:214:1: ( ( rule__ProductionRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:215:1: ( rule__ProductionRecipe__Group__0 )
            {
             before(grammarAccess.getProductionRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:216:1: ( rule__ProductionRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:216:2: rule__ProductionRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__0_in_ruleProductionRecipe394);
            rule__ProductionRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProductionRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleProductionRecipe"


    // $ANTLR start "entryRuleUniquenessEnforcerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:228:1: entryRuleUniquenessEnforcerRecipe : ruleUniquenessEnforcerRecipe EOF ;
    public final void entryRuleUniquenessEnforcerRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:229:1: ( ruleUniquenessEnforcerRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:230:1: ruleUniquenessEnforcerRecipe EOF
            {
             before(grammarAccess.getUniquenessEnforcerRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUniquenessEnforcerRecipe_in_entryRuleUniquenessEnforcerRecipe421);
            ruleUniquenessEnforcerRecipe();

            state._fsp--;

             after(grammarAccess.getUniquenessEnforcerRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUniquenessEnforcerRecipe428); 

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
    // $ANTLR end "entryRuleUniquenessEnforcerRecipe"


    // $ANTLR start "ruleUniquenessEnforcerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:237:1: ruleUniquenessEnforcerRecipe : ( ( rule__UniquenessEnforcerRecipe__Group__0 ) ) ;
    public final void ruleUniquenessEnforcerRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:241:2: ( ( ( rule__UniquenessEnforcerRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:242:1: ( ( rule__UniquenessEnforcerRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:242:1: ( ( rule__UniquenessEnforcerRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:243:1: ( rule__UniquenessEnforcerRecipe__Group__0 )
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:244:1: ( rule__UniquenessEnforcerRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:244:2: rule__UniquenessEnforcerRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__0_in_ruleUniquenessEnforcerRecipe454);
            rule__UniquenessEnforcerRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleUniquenessEnforcerRecipe"


    // $ANTLR start "entryRuleCheckRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:256:1: entryRuleCheckRecipe : ruleCheckRecipe EOF ;
    public final void entryRuleCheckRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:257:1: ( ruleCheckRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:258:1: ruleCheckRecipe EOF
            {
             before(grammarAccess.getCheckRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCheckRecipe_in_entryRuleCheckRecipe481);
            ruleCheckRecipe();

            state._fsp--;

             after(grammarAccess.getCheckRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCheckRecipe488); 

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
    // $ANTLR end "entryRuleCheckRecipe"


    // $ANTLR start "ruleCheckRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:265:1: ruleCheckRecipe : ( ( rule__CheckRecipe__Group__0 ) ) ;
    public final void ruleCheckRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:269:2: ( ( ( rule__CheckRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:270:1: ( ( rule__CheckRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:270:1: ( ( rule__CheckRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:271:1: ( rule__CheckRecipe__Group__0 )
            {
             before(grammarAccess.getCheckRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:272:1: ( rule__CheckRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:272:2: rule__CheckRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__0_in_ruleCheckRecipe514);
            rule__CheckRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCheckRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleCheckRecipe"


    // $ANTLR start "entryRuleTrimmerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:284:1: entryRuleTrimmerRecipe : ruleTrimmerRecipe EOF ;
    public final void entryRuleTrimmerRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:285:1: ( ruleTrimmerRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:286:1: ruleTrimmerRecipe EOF
            {
             before(grammarAccess.getTrimmerRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTrimmerRecipe_in_entryRuleTrimmerRecipe541);
            ruleTrimmerRecipe();

            state._fsp--;

             after(grammarAccess.getTrimmerRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTrimmerRecipe548); 

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
    // $ANTLR end "entryRuleTrimmerRecipe"


    // $ANTLR start "ruleTrimmerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:293:1: ruleTrimmerRecipe : ( ( rule__TrimmerRecipe__Group__0 ) ) ;
    public final void ruleTrimmerRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:297:2: ( ( ( rule__TrimmerRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:298:1: ( ( rule__TrimmerRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:298:1: ( ( rule__TrimmerRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:299:1: ( rule__TrimmerRecipe__Group__0 )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:300:1: ( rule__TrimmerRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:300:2: rule__TrimmerRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__0_in_ruleTrimmerRecipe574);
            rule__TrimmerRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrimmerRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleTrimmerRecipe"


    // $ANTLR start "entryRuleJoinRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:312:1: entryRuleJoinRecipe : ruleJoinRecipe EOF ;
    public final void entryRuleJoinRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:313:1: ( ruleJoinRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:314:1: ruleJoinRecipe EOF
            {
             before(grammarAccess.getJoinRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleJoinRecipe_in_entryRuleJoinRecipe601);
            ruleJoinRecipe();

            state._fsp--;

             after(grammarAccess.getJoinRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJoinRecipe608); 

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
    // $ANTLR end "entryRuleJoinRecipe"


    // $ANTLR start "ruleJoinRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:321:1: ruleJoinRecipe : ( ( rule__JoinRecipe__Group__0 ) ) ;
    public final void ruleJoinRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:325:2: ( ( ( rule__JoinRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:326:1: ( ( rule__JoinRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:326:1: ( ( rule__JoinRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:327:1: ( rule__JoinRecipe__Group__0 )
            {
             before(grammarAccess.getJoinRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:328:1: ( rule__JoinRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:328:2: rule__JoinRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__0_in_ruleJoinRecipe634);
            rule__JoinRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getJoinRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleJoinRecipe"


    // $ANTLR start "entryRuleAntiJoinRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:340:1: entryRuleAntiJoinRecipe : ruleAntiJoinRecipe EOF ;
    public final void entryRuleAntiJoinRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:341:1: ( ruleAntiJoinRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:342:1: ruleAntiJoinRecipe EOF
            {
             before(grammarAccess.getAntiJoinRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAntiJoinRecipe_in_entryRuleAntiJoinRecipe661);
            ruleAntiJoinRecipe();

            state._fsp--;

             after(grammarAccess.getAntiJoinRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAntiJoinRecipe668); 

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
    // $ANTLR end "entryRuleAntiJoinRecipe"


    // $ANTLR start "ruleAntiJoinRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:349:1: ruleAntiJoinRecipe : ( ( rule__AntiJoinRecipe__Group__0 ) ) ;
    public final void ruleAntiJoinRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:353:2: ( ( ( rule__AntiJoinRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:354:1: ( ( rule__AntiJoinRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:354:1: ( ( rule__AntiJoinRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:355:1: ( rule__AntiJoinRecipe__Group__0 )
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:356:1: ( rule__AntiJoinRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:356:2: rule__AntiJoinRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__0_in_ruleAntiJoinRecipe694);
            rule__AntiJoinRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAntiJoinRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleAntiJoinRecipe"


    // $ANTLR start "entryRuleIndexerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:368:1: entryRuleIndexerRecipe : ruleIndexerRecipe EOF ;
    public final void entryRuleIndexerRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:369:1: ( ruleIndexerRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:370:1: ruleIndexerRecipe EOF
            {
             before(grammarAccess.getIndexerRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIndexerRecipe_in_entryRuleIndexerRecipe721);
            ruleIndexerRecipe();

            state._fsp--;

             after(grammarAccess.getIndexerRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIndexerRecipe728); 

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
    // $ANTLR end "entryRuleIndexerRecipe"


    // $ANTLR start "ruleIndexerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:377:1: ruleIndexerRecipe : ( ( rule__IndexerRecipe__Group__0 ) ) ;
    public final void ruleIndexerRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:381:2: ( ( ( rule__IndexerRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:382:1: ( ( rule__IndexerRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:382:1: ( ( rule__IndexerRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:383:1: ( rule__IndexerRecipe__Group__0 )
            {
             before(grammarAccess.getIndexerRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:384:1: ( rule__IndexerRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:384:2: rule__IndexerRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__0_in_ruleIndexerRecipe754);
            rule__IndexerRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIndexerRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleIndexerRecipe"


    // $ANTLR start "entryRuleProjectionIndexerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:396:1: entryRuleProjectionIndexerRecipe : ruleProjectionIndexerRecipe EOF ;
    public final void entryRuleProjectionIndexerRecipe() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:397:1: ( ruleProjectionIndexerRecipe EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:398:1: ruleProjectionIndexerRecipe EOF
            {
             before(grammarAccess.getProjectionIndexerRecipeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProjectionIndexerRecipe_in_entryRuleProjectionIndexerRecipe781);
            ruleProjectionIndexerRecipe();

            state._fsp--;

             after(grammarAccess.getProjectionIndexerRecipeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProjectionIndexerRecipe788); 

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
    // $ANTLR end "entryRuleProjectionIndexerRecipe"


    // $ANTLR start "ruleProjectionIndexerRecipe"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:405:1: ruleProjectionIndexerRecipe : ( ( rule__ProjectionIndexerRecipe__Group__0 ) ) ;
    public final void ruleProjectionIndexerRecipe() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:409:2: ( ( ( rule__ProjectionIndexerRecipe__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:410:1: ( ( rule__ProjectionIndexerRecipe__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:410:1: ( ( rule__ProjectionIndexerRecipe__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:411:1: ( rule__ProjectionIndexerRecipe__Group__0 )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:412:1: ( rule__ProjectionIndexerRecipe__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:412:2: rule__ProjectionIndexerRecipe__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__0_in_ruleProjectionIndexerRecipe814);
            rule__ProjectionIndexerRecipe__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProjectionIndexerRecipeAccess().getGroup()); 

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
    // $ANTLR end "ruleProjectionIndexerRecipe"


    // $ANTLR start "entryRuleMask"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:424:1: entryRuleMask : ruleMask EOF ;
    public final void entryRuleMask() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:425:1: ( ruleMask EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:426:1: ruleMask EOF
            {
             before(grammarAccess.getMaskRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_entryRuleMask841);
            ruleMask();

            state._fsp--;

             after(grammarAccess.getMaskRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMask848); 

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
    // $ANTLR end "entryRuleMask"


    // $ANTLR start "ruleMask"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:433:1: ruleMask : ( ( rule__Mask__Group__0 ) ) ;
    public final void ruleMask() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:437:2: ( ( ( rule__Mask__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:438:1: ( ( rule__Mask__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:438:1: ( ( rule__Mask__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:439:1: ( rule__Mask__Group__0 )
            {
             before(grammarAccess.getMaskAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:440:1: ( rule__Mask__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:440:2: rule__Mask__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__0_in_ruleMask874);
            rule__Mask__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMaskAccess().getGroup()); 

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
    // $ANTLR end "ruleMask"


    // $ANTLR start "entryRuleInfrastructureMapping"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:452:1: entryRuleInfrastructureMapping : ruleInfrastructureMapping EOF ;
    public final void entryRuleInfrastructureMapping() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:453:1: ( ruleInfrastructureMapping EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:454:1: ruleInfrastructureMapping EOF
            {
             before(grammarAccess.getInfrastructureMappingRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_entryRuleInfrastructureMapping901);
            ruleInfrastructureMapping();

            state._fsp--;

             after(grammarAccess.getInfrastructureMappingRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfrastructureMapping908); 

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
    // $ANTLR end "entryRuleInfrastructureMapping"


    // $ANTLR start "ruleInfrastructureMapping"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:461:1: ruleInfrastructureMapping : ( ( rule__InfrastructureMapping__Group__0 ) ) ;
    public final void ruleInfrastructureMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:465:2: ( ( ( rule__InfrastructureMapping__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:466:1: ( ( rule__InfrastructureMapping__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:466:1: ( ( rule__InfrastructureMapping__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:467:1: ( rule__InfrastructureMapping__Group__0 )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:468:1: ( rule__InfrastructureMapping__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:468:2: rule__InfrastructureMapping__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__0_in_ruleInfrastructureMapping934);
            rule__InfrastructureMapping__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureMappingAccess().getGroup()); 

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
    // $ANTLR end "ruleInfrastructureMapping"


    // $ANTLR start "rule__ReteNodeRecipe__Alternatives"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:480:1: rule__ReteNodeRecipe__Alternatives : ( ( ruleProductionRecipe ) | ( ruleUniquenessEnforcerRecipe ) | ( ruleCheckRecipe ) | ( ruleTrimmerRecipe ) | ( ruleJoinRecipe ) | ( ruleAntiJoinRecipe ) );
    public final void rule__ReteNodeRecipe__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:484:1: ( ( ruleProductionRecipe ) | ( ruleUniquenessEnforcerRecipe ) | ( ruleCheckRecipe ) | ( ruleTrimmerRecipe ) | ( ruleJoinRecipe ) | ( ruleAntiJoinRecipe ) )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt1=1;
                }
                break;
            case 27:
                {
                alt1=2;
                }
                break;
            case 28:
                {
                alt1=3;
                }
                break;
            case 30:
                {
                alt1=4;
                }
                break;
            case 32:
                {
                alt1=5;
                }
                break;
            case 35:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:485:1: ( ruleProductionRecipe )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:485:1: ( ruleProductionRecipe )
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:486:1: ruleProductionRecipe
                    {
                     before(grammarAccess.getReteNodeRecipeAccess().getProductionRecipeParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleProductionRecipe_in_rule__ReteNodeRecipe__Alternatives970);
                    ruleProductionRecipe();

                    state._fsp--;

                     after(grammarAccess.getReteNodeRecipeAccess().getProductionRecipeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:491:6: ( ruleUniquenessEnforcerRecipe )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:491:6: ( ruleUniquenessEnforcerRecipe )
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:492:1: ruleUniquenessEnforcerRecipe
                    {
                     before(grammarAccess.getReteNodeRecipeAccess().getUniquenessEnforcerRecipeParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleUniquenessEnforcerRecipe_in_rule__ReteNodeRecipe__Alternatives987);
                    ruleUniquenessEnforcerRecipe();

                    state._fsp--;

                     after(grammarAccess.getReteNodeRecipeAccess().getUniquenessEnforcerRecipeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:497:6: ( ruleCheckRecipe )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:497:6: ( ruleCheckRecipe )
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:498:1: ruleCheckRecipe
                    {
                     before(grammarAccess.getReteNodeRecipeAccess().getCheckRecipeParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCheckRecipe_in_rule__ReteNodeRecipe__Alternatives1004);
                    ruleCheckRecipe();

                    state._fsp--;

                     after(grammarAccess.getReteNodeRecipeAccess().getCheckRecipeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:503:6: ( ruleTrimmerRecipe )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:503:6: ( ruleTrimmerRecipe )
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:504:1: ruleTrimmerRecipe
                    {
                     before(grammarAccess.getReteNodeRecipeAccess().getTrimmerRecipeParserRuleCall_3()); 
                    pushFollow(FollowSets000.FOLLOW_ruleTrimmerRecipe_in_rule__ReteNodeRecipe__Alternatives1021);
                    ruleTrimmerRecipe();

                    state._fsp--;

                     after(grammarAccess.getReteNodeRecipeAccess().getTrimmerRecipeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:509:6: ( ruleJoinRecipe )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:509:6: ( ruleJoinRecipe )
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:510:1: ruleJoinRecipe
                    {
                     before(grammarAccess.getReteNodeRecipeAccess().getJoinRecipeParserRuleCall_4()); 
                    pushFollow(FollowSets000.FOLLOW_ruleJoinRecipe_in_rule__ReteNodeRecipe__Alternatives1038);
                    ruleJoinRecipe();

                    state._fsp--;

                     after(grammarAccess.getReteNodeRecipeAccess().getJoinRecipeParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:515:6: ( ruleAntiJoinRecipe )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:515:6: ( ruleAntiJoinRecipe )
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:516:1: ruleAntiJoinRecipe
                    {
                     before(grammarAccess.getReteNodeRecipeAccess().getAntiJoinRecipeParserRuleCall_5()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAntiJoinRecipe_in_rule__ReteNodeRecipe__Alternatives1055);
                    ruleAntiJoinRecipe();

                    state._fsp--;

                     after(grammarAccess.getReteNodeRecipeAccess().getAntiJoinRecipeParserRuleCall_5()); 

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
    // $ANTLR end "rule__ReteNodeRecipe__Alternatives"


    // $ANTLR start "rule__Configuration__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:528:1: rule__Configuration__Group__0 : rule__Configuration__Group__0__Impl rule__Configuration__Group__1 ;
    public final void rule__Configuration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:532:1: ( rule__Configuration__Group__0__Impl rule__Configuration__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:533:2: rule__Configuration__Group__0__Impl rule__Configuration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__0__Impl_in_rule__Configuration__Group__01085);
            rule__Configuration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__1_in_rule__Configuration__Group__01088);
            rule__Configuration__Group__1();

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
    // $ANTLR end "rule__Configuration__Group__0"


    // $ANTLR start "rule__Configuration__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:540:1: rule__Configuration__Group__0__Impl : ( () ) ;
    public final void rule__Configuration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:544:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:545:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:545:1: ( () )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:546:1: ()
            {
             before(grammarAccess.getConfigurationAccess().getConfigurationAction_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:547:1: ()
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:549:1: 
            {
            }

             after(grammarAccess.getConfigurationAccess().getConfigurationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__0__Impl"


    // $ANTLR start "rule__Configuration__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:559:1: rule__Configuration__Group__1 : rule__Configuration__Group__1__Impl rule__Configuration__Group__2 ;
    public final void rule__Configuration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:563:1: ( rule__Configuration__Group__1__Impl rule__Configuration__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:564:2: rule__Configuration__Group__1__Impl rule__Configuration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__1__Impl_in_rule__Configuration__Group__11146);
            rule__Configuration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__2_in_rule__Configuration__Group__11149);
            rule__Configuration__Group__2();

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
    // $ANTLR end "rule__Configuration__Group__1"


    // $ANTLR start "rule__Configuration__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:571:1: rule__Configuration__Group__1__Impl : ( ( rule__Configuration__Group_1__0 )? ) ;
    public final void rule__Configuration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:575:1: ( ( ( rule__Configuration__Group_1__0 )? ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:576:1: ( ( rule__Configuration__Group_1__0 )? )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:576:1: ( ( rule__Configuration__Group_1__0 )? )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:577:1: ( rule__Configuration__Group_1__0 )?
            {
             before(grammarAccess.getConfigurationAccess().getGroup_1()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:578:1: ( rule__Configuration__Group_1__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:578:2: rule__Configuration__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__0_in_rule__Configuration__Group__1__Impl1176);
                    rule__Configuration__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConfigurationAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Configuration__Group__1__Impl"


    // $ANTLR start "rule__Configuration__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:588:1: rule__Configuration__Group__2 : rule__Configuration__Group__2__Impl rule__Configuration__Group__3 ;
    public final void rule__Configuration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:592:1: ( rule__Configuration__Group__2__Impl rule__Configuration__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:593:2: rule__Configuration__Group__2__Impl rule__Configuration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__2__Impl_in_rule__Configuration__Group__21207);
            rule__Configuration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__3_in_rule__Configuration__Group__21210);
            rule__Configuration__Group__3();

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
    // $ANTLR end "rule__Configuration__Group__2"


    // $ANTLR start "rule__Configuration__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:600:1: rule__Configuration__Group__2__Impl : ( ( rule__Configuration__Group_2__0 )? ) ;
    public final void rule__Configuration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:604:1: ( ( ( rule__Configuration__Group_2__0 )? ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:605:1: ( ( rule__Configuration__Group_2__0 )? )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:605:1: ( ( rule__Configuration__Group_2__0 )? )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:606:1: ( rule__Configuration__Group_2__0 )?
            {
             before(grammarAccess.getConfigurationAccess().getGroup_2()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:607:1: ( rule__Configuration__Group_2__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==16) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:607:2: rule__Configuration__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__0_in_rule__Configuration__Group__2__Impl1237);
                    rule__Configuration__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConfigurationAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Configuration__Group__2__Impl"


    // $ANTLR start "rule__Configuration__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:617:1: rule__Configuration__Group__3 : rule__Configuration__Group__3__Impl ;
    public final void rule__Configuration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:621:1: ( rule__Configuration__Group__3__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:622:2: rule__Configuration__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__3__Impl_in_rule__Configuration__Group__31268);
            rule__Configuration__Group__3__Impl();

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
    // $ANTLR end "rule__Configuration__Group__3"


    // $ANTLR start "rule__Configuration__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:628:1: rule__Configuration__Group__3__Impl : ( ( rule__Configuration__Group_3__0 )? ) ;
    public final void rule__Configuration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:632:1: ( ( ( rule__Configuration__Group_3__0 )? ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:633:1: ( ( rule__Configuration__Group_3__0 )? )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:633:1: ( ( rule__Configuration__Group_3__0 )? )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:634:1: ( rule__Configuration__Group_3__0 )?
            {
             before(grammarAccess.getConfigurationAccess().getGroup_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:635:1: ( rule__Configuration__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:635:2: rule__Configuration__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__0_in_rule__Configuration__Group__3__Impl1295);
                    rule__Configuration__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConfigurationAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Configuration__Group__3__Impl"


    // $ANTLR start "rule__Configuration__Group_1__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:653:1: rule__Configuration__Group_1__0 : rule__Configuration__Group_1__0__Impl rule__Configuration__Group_1__1 ;
    public final void rule__Configuration__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:657:1: ( rule__Configuration__Group_1__0__Impl rule__Configuration__Group_1__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:658:2: rule__Configuration__Group_1__0__Impl rule__Configuration__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__0__Impl_in_rule__Configuration__Group_1__01334);
            rule__Configuration__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__1_in_rule__Configuration__Group_1__01337);
            rule__Configuration__Group_1__1();

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
    // $ANTLR end "rule__Configuration__Group_1__0"


    // $ANTLR start "rule__Configuration__Group_1__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:665:1: rule__Configuration__Group_1__0__Impl : ( 'clusters' ) ;
    public final void rule__Configuration__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:669:1: ( ( 'clusters' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:670:1: ( 'clusters' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:670:1: ( 'clusters' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:671:1: 'clusters'
            {
             before(grammarAccess.getConfigurationAccess().getClustersKeyword_1_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__Configuration__Group_1__0__Impl1365); 
             after(grammarAccess.getConfigurationAccess().getClustersKeyword_1_0()); 

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
    // $ANTLR end "rule__Configuration__Group_1__0__Impl"


    // $ANTLR start "rule__Configuration__Group_1__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:684:1: rule__Configuration__Group_1__1 : rule__Configuration__Group_1__1__Impl rule__Configuration__Group_1__2 ;
    public final void rule__Configuration__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:688:1: ( rule__Configuration__Group_1__1__Impl rule__Configuration__Group_1__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:689:2: rule__Configuration__Group_1__1__Impl rule__Configuration__Group_1__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__1__Impl_in_rule__Configuration__Group_1__11396);
            rule__Configuration__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__2_in_rule__Configuration__Group_1__11399);
            rule__Configuration__Group_1__2();

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
    // $ANTLR end "rule__Configuration__Group_1__1"


    // $ANTLR start "rule__Configuration__Group_1__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:696:1: rule__Configuration__Group_1__1__Impl : ( ':' ) ;
    public final void rule__Configuration__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:700:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:701:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:701:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:702:1: ':'
            {
             before(grammarAccess.getConfigurationAccess().getColonKeyword_1_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Configuration__Group_1__1__Impl1427); 
             after(grammarAccess.getConfigurationAccess().getColonKeyword_1_1()); 

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
    // $ANTLR end "rule__Configuration__Group_1__1__Impl"


    // $ANTLR start "rule__Configuration__Group_1__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:715:1: rule__Configuration__Group_1__2 : rule__Configuration__Group_1__2__Impl rule__Configuration__Group_1__3 ;
    public final void rule__Configuration__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:719:1: ( rule__Configuration__Group_1__2__Impl rule__Configuration__Group_1__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:720:2: rule__Configuration__Group_1__2__Impl rule__Configuration__Group_1__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__2__Impl_in_rule__Configuration__Group_1__21458);
            rule__Configuration__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__3_in_rule__Configuration__Group_1__21461);
            rule__Configuration__Group_1__3();

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
    // $ANTLR end "rule__Configuration__Group_1__2"


    // $ANTLR start "rule__Configuration__Group_1__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:727:1: rule__Configuration__Group_1__2__Impl : ( '[' ) ;
    public final void rule__Configuration__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:731:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:732:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:732:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:733:1: '['
            {
             before(grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_1_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Configuration__Group_1__2__Impl1489); 
             after(grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_1_2()); 

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
    // $ANTLR end "rule__Configuration__Group_1__2__Impl"


    // $ANTLR start "rule__Configuration__Group_1__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:746:1: rule__Configuration__Group_1__3 : rule__Configuration__Group_1__3__Impl rule__Configuration__Group_1__4 ;
    public final void rule__Configuration__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:750:1: ( rule__Configuration__Group_1__3__Impl rule__Configuration__Group_1__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:751:2: rule__Configuration__Group_1__3__Impl rule__Configuration__Group_1__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__3__Impl_in_rule__Configuration__Group_1__31520);
            rule__Configuration__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__4_in_rule__Configuration__Group_1__31523);
            rule__Configuration__Group_1__4();

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
    // $ANTLR end "rule__Configuration__Group_1__3"


    // $ANTLR start "rule__Configuration__Group_1__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:758:1: rule__Configuration__Group_1__3__Impl : ( ( rule__Configuration__ClustersAssignment_1_3 )* ) ;
    public final void rule__Configuration__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:762:1: ( ( ( rule__Configuration__ClustersAssignment_1_3 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:763:1: ( ( rule__Configuration__ClustersAssignment_1_3 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:763:1: ( ( rule__Configuration__ClustersAssignment_1_3 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:764:1: ( rule__Configuration__ClustersAssignment_1_3 )*
            {
             before(grammarAccess.getConfigurationAccess().getClustersAssignment_1_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:765:1: ( rule__Configuration__ClustersAssignment_1_3 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:765:2: rule__Configuration__ClustersAssignment_1_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Configuration__ClustersAssignment_1_3_in_rule__Configuration__Group_1__3__Impl1550);
            	    rule__Configuration__ClustersAssignment_1_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getClustersAssignment_1_3()); 

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
    // $ANTLR end "rule__Configuration__Group_1__3__Impl"


    // $ANTLR start "rule__Configuration__Group_1__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:775:1: rule__Configuration__Group_1__4 : rule__Configuration__Group_1__4__Impl ;
    public final void rule__Configuration__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:779:1: ( rule__Configuration__Group_1__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:780:2: rule__Configuration__Group_1__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_1__4__Impl_in_rule__Configuration__Group_1__41581);
            rule__Configuration__Group_1__4__Impl();

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
    // $ANTLR end "rule__Configuration__Group_1__4"


    // $ANTLR start "rule__Configuration__Group_1__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:786:1: rule__Configuration__Group_1__4__Impl : ( ']' ) ;
    public final void rule__Configuration__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:790:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:791:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:791:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:792:1: ']'
            {
             before(grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_1_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Configuration__Group_1__4__Impl1609); 
             after(grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_1_4()); 

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
    // $ANTLR end "rule__Configuration__Group_1__4__Impl"


    // $ANTLR start "rule__Configuration__Group_2__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:815:1: rule__Configuration__Group_2__0 : rule__Configuration__Group_2__0__Impl rule__Configuration__Group_2__1 ;
    public final void rule__Configuration__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:819:1: ( rule__Configuration__Group_2__0__Impl rule__Configuration__Group_2__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:820:2: rule__Configuration__Group_2__0__Impl rule__Configuration__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__0__Impl_in_rule__Configuration__Group_2__01650);
            rule__Configuration__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__1_in_rule__Configuration__Group_2__01653);
            rule__Configuration__Group_2__1();

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
    // $ANTLR end "rule__Configuration__Group_2__0"


    // $ANTLR start "rule__Configuration__Group_2__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:827:1: rule__Configuration__Group_2__0__Impl : ( 'recipes' ) ;
    public final void rule__Configuration__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:831:1: ( ( 'recipes' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:832:1: ( 'recipes' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:832:1: ( 'recipes' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:833:1: 'recipes'
            {
             before(grammarAccess.getConfigurationAccess().getRecipesKeyword_2_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Configuration__Group_2__0__Impl1681); 
             after(grammarAccess.getConfigurationAccess().getRecipesKeyword_2_0()); 

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
    // $ANTLR end "rule__Configuration__Group_2__0__Impl"


    // $ANTLR start "rule__Configuration__Group_2__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:846:1: rule__Configuration__Group_2__1 : rule__Configuration__Group_2__1__Impl rule__Configuration__Group_2__2 ;
    public final void rule__Configuration__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:850:1: ( rule__Configuration__Group_2__1__Impl rule__Configuration__Group_2__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:851:2: rule__Configuration__Group_2__1__Impl rule__Configuration__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__1__Impl_in_rule__Configuration__Group_2__11712);
            rule__Configuration__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__2_in_rule__Configuration__Group_2__11715);
            rule__Configuration__Group_2__2();

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
    // $ANTLR end "rule__Configuration__Group_2__1"


    // $ANTLR start "rule__Configuration__Group_2__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:858:1: rule__Configuration__Group_2__1__Impl : ( ':' ) ;
    public final void rule__Configuration__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:862:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:863:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:863:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:864:1: ':'
            {
             before(grammarAccess.getConfigurationAccess().getColonKeyword_2_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Configuration__Group_2__1__Impl1743); 
             after(grammarAccess.getConfigurationAccess().getColonKeyword_2_1()); 

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
    // $ANTLR end "rule__Configuration__Group_2__1__Impl"


    // $ANTLR start "rule__Configuration__Group_2__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:877:1: rule__Configuration__Group_2__2 : rule__Configuration__Group_2__2__Impl rule__Configuration__Group_2__3 ;
    public final void rule__Configuration__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:881:1: ( rule__Configuration__Group_2__2__Impl rule__Configuration__Group_2__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:882:2: rule__Configuration__Group_2__2__Impl rule__Configuration__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__2__Impl_in_rule__Configuration__Group_2__21774);
            rule__Configuration__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__3_in_rule__Configuration__Group_2__21777);
            rule__Configuration__Group_2__3();

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
    // $ANTLR end "rule__Configuration__Group_2__2"


    // $ANTLR start "rule__Configuration__Group_2__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:889:1: rule__Configuration__Group_2__2__Impl : ( '[' ) ;
    public final void rule__Configuration__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:893:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:894:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:894:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:895:1: '['
            {
             before(grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_2_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Configuration__Group_2__2__Impl1805); 
             after(grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_2_2()); 

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
    // $ANTLR end "rule__Configuration__Group_2__2__Impl"


    // $ANTLR start "rule__Configuration__Group_2__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:908:1: rule__Configuration__Group_2__3 : rule__Configuration__Group_2__3__Impl rule__Configuration__Group_2__4 ;
    public final void rule__Configuration__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:912:1: ( rule__Configuration__Group_2__3__Impl rule__Configuration__Group_2__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:913:2: rule__Configuration__Group_2__3__Impl rule__Configuration__Group_2__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__3__Impl_in_rule__Configuration__Group_2__31836);
            rule__Configuration__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__4_in_rule__Configuration__Group_2__31839);
            rule__Configuration__Group_2__4();

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
    // $ANTLR end "rule__Configuration__Group_2__3"


    // $ANTLR start "rule__Configuration__Group_2__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:920:1: rule__Configuration__Group_2__3__Impl : ( ( rule__Configuration__ReteRecipesAssignment_2_3 )* ) ;
    public final void rule__Configuration__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:924:1: ( ( ( rule__Configuration__ReteRecipesAssignment_2_3 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:925:1: ( ( rule__Configuration__ReteRecipesAssignment_2_3 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:925:1: ( ( rule__Configuration__ReteRecipesAssignment_2_3 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:926:1: ( rule__Configuration__ReteRecipesAssignment_2_3 )*
            {
             before(grammarAccess.getConfigurationAccess().getReteRecipesAssignment_2_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:927:1: ( rule__Configuration__ReteRecipesAssignment_2_3 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:927:2: rule__Configuration__ReteRecipesAssignment_2_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Configuration__ReteRecipesAssignment_2_3_in_rule__Configuration__Group_2__3__Impl1866);
            	    rule__Configuration__ReteRecipesAssignment_2_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getReteRecipesAssignment_2_3()); 

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
    // $ANTLR end "rule__Configuration__Group_2__3__Impl"


    // $ANTLR start "rule__Configuration__Group_2__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:937:1: rule__Configuration__Group_2__4 : rule__Configuration__Group_2__4__Impl ;
    public final void rule__Configuration__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:941:1: ( rule__Configuration__Group_2__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:942:2: rule__Configuration__Group_2__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_2__4__Impl_in_rule__Configuration__Group_2__41897);
            rule__Configuration__Group_2__4__Impl();

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
    // $ANTLR end "rule__Configuration__Group_2__4"


    // $ANTLR start "rule__Configuration__Group_2__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:948:1: rule__Configuration__Group_2__4__Impl : ( ']' ) ;
    public final void rule__Configuration__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:952:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:953:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:953:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:954:1: ']'
            {
             before(grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_2_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Configuration__Group_2__4__Impl1925); 
             after(grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_2_4()); 

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
    // $ANTLR end "rule__Configuration__Group_2__4__Impl"


    // $ANTLR start "rule__Configuration__Group_3__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:977:1: rule__Configuration__Group_3__0 : rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1 ;
    public final void rule__Configuration__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:981:1: ( rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:982:2: rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__0__Impl_in_rule__Configuration__Group_3__01966);
            rule__Configuration__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__1_in_rule__Configuration__Group_3__01969);
            rule__Configuration__Group_3__1();

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
    // $ANTLR end "rule__Configuration__Group_3__0"


    // $ANTLR start "rule__Configuration__Group_3__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:989:1: rule__Configuration__Group_3__0__Impl : ( 'mappings' ) ;
    public final void rule__Configuration__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:993:1: ( ( 'mappings' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:994:1: ( 'mappings' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:994:1: ( 'mappings' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:995:1: 'mappings'
            {
             before(grammarAccess.getConfigurationAccess().getMappingsKeyword_3_0()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Configuration__Group_3__0__Impl1997); 
             after(grammarAccess.getConfigurationAccess().getMappingsKeyword_3_0()); 

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
    // $ANTLR end "rule__Configuration__Group_3__0__Impl"


    // $ANTLR start "rule__Configuration__Group_3__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1008:1: rule__Configuration__Group_3__1 : rule__Configuration__Group_3__1__Impl rule__Configuration__Group_3__2 ;
    public final void rule__Configuration__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1012:1: ( rule__Configuration__Group_3__1__Impl rule__Configuration__Group_3__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1013:2: rule__Configuration__Group_3__1__Impl rule__Configuration__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__1__Impl_in_rule__Configuration__Group_3__12028);
            rule__Configuration__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__2_in_rule__Configuration__Group_3__12031);
            rule__Configuration__Group_3__2();

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
    // $ANTLR end "rule__Configuration__Group_3__1"


    // $ANTLR start "rule__Configuration__Group_3__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1020:1: rule__Configuration__Group_3__1__Impl : ( ':' ) ;
    public final void rule__Configuration__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1024:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1025:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1025:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1026:1: ':'
            {
             before(grammarAccess.getConfigurationAccess().getColonKeyword_3_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Configuration__Group_3__1__Impl2059); 
             after(grammarAccess.getConfigurationAccess().getColonKeyword_3_1()); 

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
    // $ANTLR end "rule__Configuration__Group_3__1__Impl"


    // $ANTLR start "rule__Configuration__Group_3__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1039:1: rule__Configuration__Group_3__2 : rule__Configuration__Group_3__2__Impl rule__Configuration__Group_3__3 ;
    public final void rule__Configuration__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1043:1: ( rule__Configuration__Group_3__2__Impl rule__Configuration__Group_3__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1044:2: rule__Configuration__Group_3__2__Impl rule__Configuration__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__2__Impl_in_rule__Configuration__Group_3__22090);
            rule__Configuration__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__3_in_rule__Configuration__Group_3__22093);
            rule__Configuration__Group_3__3();

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
    // $ANTLR end "rule__Configuration__Group_3__2"


    // $ANTLR start "rule__Configuration__Group_3__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1051:1: rule__Configuration__Group_3__2__Impl : ( '[' ) ;
    public final void rule__Configuration__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1055:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1056:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1056:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1057:1: '['
            {
             before(grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_3_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Configuration__Group_3__2__Impl2121); 
             after(grammarAccess.getConfigurationAccess().getLeftSquareBracketKeyword_3_2()); 

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
    // $ANTLR end "rule__Configuration__Group_3__2__Impl"


    // $ANTLR start "rule__Configuration__Group_3__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1070:1: rule__Configuration__Group_3__3 : rule__Configuration__Group_3__3__Impl rule__Configuration__Group_3__4 ;
    public final void rule__Configuration__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1074:1: ( rule__Configuration__Group_3__3__Impl rule__Configuration__Group_3__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1075:2: rule__Configuration__Group_3__3__Impl rule__Configuration__Group_3__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__3__Impl_in_rule__Configuration__Group_3__32152);
            rule__Configuration__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__4_in_rule__Configuration__Group_3__32155);
            rule__Configuration__Group_3__4();

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
    // $ANTLR end "rule__Configuration__Group_3__3"


    // $ANTLR start "rule__Configuration__Group_3__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1082:1: rule__Configuration__Group_3__3__Impl : ( ( rule__Configuration__MappingsAssignment_3_3 )* ) ;
    public final void rule__Configuration__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1086:1: ( ( ( rule__Configuration__MappingsAssignment_3_3 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1087:1: ( ( rule__Configuration__MappingsAssignment_3_3 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1087:1: ( ( rule__Configuration__MappingsAssignment_3_3 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1088:1: ( rule__Configuration__MappingsAssignment_3_3 )*
            {
             before(grammarAccess.getConfigurationAccess().getMappingsAssignment_3_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1089:1: ( rule__Configuration__MappingsAssignment_3_3 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1089:2: rule__Configuration__MappingsAssignment_3_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Configuration__MappingsAssignment_3_3_in_rule__Configuration__Group_3__3__Impl2182);
            	    rule__Configuration__MappingsAssignment_3_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getMappingsAssignment_3_3()); 

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
    // $ANTLR end "rule__Configuration__Group_3__3__Impl"


    // $ANTLR start "rule__Configuration__Group_3__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1099:1: rule__Configuration__Group_3__4 : rule__Configuration__Group_3__4__Impl ;
    public final void rule__Configuration__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1103:1: ( rule__Configuration__Group_3__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1104:2: rule__Configuration__Group_3__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__4__Impl_in_rule__Configuration__Group_3__42213);
            rule__Configuration__Group_3__4__Impl();

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
    // $ANTLR end "rule__Configuration__Group_3__4"


    // $ANTLR start "rule__Configuration__Group_3__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1110:1: rule__Configuration__Group_3__4__Impl : ( ']' ) ;
    public final void rule__Configuration__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1114:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1115:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1115:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1116:1: ']'
            {
             before(grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_3_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Configuration__Group_3__4__Impl2241); 
             after(grammarAccess.getConfigurationAccess().getRightSquareBracketKeyword_3_4()); 

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
    // $ANTLR end "rule__Configuration__Group_3__4__Impl"


    // $ANTLR start "rule__Cluster__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1139:1: rule__Cluster__Group__0 : rule__Cluster__Group__0__Impl rule__Cluster__Group__1 ;
    public final void rule__Cluster__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1143:1: ( rule__Cluster__Group__0__Impl rule__Cluster__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1144:2: rule__Cluster__Group__0__Impl rule__Cluster__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__0__Impl_in_rule__Cluster__Group__02282);
            rule__Cluster__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__1_in_rule__Cluster__Group__02285);
            rule__Cluster__Group__1();

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
    // $ANTLR end "rule__Cluster__Group__0"


    // $ANTLR start "rule__Cluster__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1151:1: rule__Cluster__Group__0__Impl : ( () ) ;
    public final void rule__Cluster__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1155:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1156:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1156:1: ( () )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1157:1: ()
            {
             before(grammarAccess.getClusterAccess().getClusterAction_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1158:1: ()
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1160:1: 
            {
            }

             after(grammarAccess.getClusterAccess().getClusterAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Cluster__Group__0__Impl"


    // $ANTLR start "rule__Cluster__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1170:1: rule__Cluster__Group__1 : rule__Cluster__Group__1__Impl rule__Cluster__Group__2 ;
    public final void rule__Cluster__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1174:1: ( rule__Cluster__Group__1__Impl rule__Cluster__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1175:2: rule__Cluster__Group__1__Impl rule__Cluster__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__1__Impl_in_rule__Cluster__Group__12343);
            rule__Cluster__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__2_in_rule__Cluster__Group__12346);
            rule__Cluster__Group__2();

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
    // $ANTLR end "rule__Cluster__Group__1"


    // $ANTLR start "rule__Cluster__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1182:1: rule__Cluster__Group__1__Impl : ( '{' ) ;
    public final void rule__Cluster__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1186:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1187:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1187:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1188:1: '{'
            {
             before(grammarAccess.getClusterAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Cluster__Group__1__Impl2374); 
             after(grammarAccess.getClusterAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__Cluster__Group__1__Impl"


    // $ANTLR start "rule__Cluster__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1201:1: rule__Cluster__Group__2 : rule__Cluster__Group__2__Impl rule__Cluster__Group__3 ;
    public final void rule__Cluster__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1205:1: ( rule__Cluster__Group__2__Impl rule__Cluster__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1206:2: rule__Cluster__Group__2__Impl rule__Cluster__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__2__Impl_in_rule__Cluster__Group__22405);
            rule__Cluster__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__3_in_rule__Cluster__Group__22408);
            rule__Cluster__Group__3();

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
    // $ANTLR end "rule__Cluster__Group__2"


    // $ANTLR start "rule__Cluster__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1213:1: rule__Cluster__Group__2__Impl : ( ( rule__Cluster__Group_2__0 )? ) ;
    public final void rule__Cluster__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1217:1: ( ( ( rule__Cluster__Group_2__0 )? ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1218:1: ( ( rule__Cluster__Group_2__0 )? )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1218:1: ( ( rule__Cluster__Group_2__0 )? )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1219:1: ( rule__Cluster__Group_2__0 )?
            {
             before(grammarAccess.getClusterAccess().getGroup_2()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1220:1: ( rule__Cluster__Group_2__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1220:2: rule__Cluster__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__0_in_rule__Cluster__Group__2__Impl2435);
                    rule__Cluster__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClusterAccess().getGroup_2()); 

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
    // $ANTLR end "rule__Cluster__Group__2__Impl"


    // $ANTLR start "rule__Cluster__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1230:1: rule__Cluster__Group__3 : rule__Cluster__Group__3__Impl rule__Cluster__Group__4 ;
    public final void rule__Cluster__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1234:1: ( rule__Cluster__Group__3__Impl rule__Cluster__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1235:2: rule__Cluster__Group__3__Impl rule__Cluster__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__3__Impl_in_rule__Cluster__Group__32466);
            rule__Cluster__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__4_in_rule__Cluster__Group__32469);
            rule__Cluster__Group__4();

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
    // $ANTLR end "rule__Cluster__Group__3"


    // $ANTLR start "rule__Cluster__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1242:1: rule__Cluster__Group__3__Impl : ( ( rule__Cluster__Group_3__0 )? ) ;
    public final void rule__Cluster__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1246:1: ( ( ( rule__Cluster__Group_3__0 )? ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1247:1: ( ( rule__Cluster__Group_3__0 )? )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1247:1: ( ( rule__Cluster__Group_3__0 )? )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1248:1: ( rule__Cluster__Group_3__0 )?
            {
             before(grammarAccess.getClusterAccess().getGroup_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1249:1: ( rule__Cluster__Group_3__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1249:2: rule__Cluster__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__0_in_rule__Cluster__Group__3__Impl2496);
                    rule__Cluster__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getClusterAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Cluster__Group__3__Impl"


    // $ANTLR start "rule__Cluster__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1259:1: rule__Cluster__Group__4 : rule__Cluster__Group__4__Impl ;
    public final void rule__Cluster__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1263:1: ( rule__Cluster__Group__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1264:2: rule__Cluster__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group__4__Impl_in_rule__Cluster__Group__42527);
            rule__Cluster__Group__4__Impl();

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
    // $ANTLR end "rule__Cluster__Group__4"


    // $ANTLR start "rule__Cluster__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1270:1: rule__Cluster__Group__4__Impl : ( '}' ) ;
    public final void rule__Cluster__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1274:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1275:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1275:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1276:1: '}'
            {
             before(grammarAccess.getClusterAccess().getRightCurlyBracketKeyword_4()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Cluster__Group__4__Impl2555); 
             after(grammarAccess.getClusterAccess().getRightCurlyBracketKeyword_4()); 

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
    // $ANTLR end "rule__Cluster__Group__4__Impl"


    // $ANTLR start "rule__Cluster__Group_2__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1299:1: rule__Cluster__Group_2__0 : rule__Cluster__Group_2__0__Impl rule__Cluster__Group_2__1 ;
    public final void rule__Cluster__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1303:1: ( rule__Cluster__Group_2__0__Impl rule__Cluster__Group_2__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1304:2: rule__Cluster__Group_2__0__Impl rule__Cluster__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__0__Impl_in_rule__Cluster__Group_2__02596);
            rule__Cluster__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__1_in_rule__Cluster__Group_2__02599);
            rule__Cluster__Group_2__1();

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
    // $ANTLR end "rule__Cluster__Group_2__0"


    // $ANTLR start "rule__Cluster__Group_2__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1311:1: rule__Cluster__Group_2__0__Impl : ( 'reteMachines' ) ;
    public final void rule__Cluster__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1315:1: ( ( 'reteMachines' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1316:1: ( 'reteMachines' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1316:1: ( 'reteMachines' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1317:1: 'reteMachines'
            {
             before(grammarAccess.getClusterAccess().getReteMachinesKeyword_2_0()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__Cluster__Group_2__0__Impl2627); 
             after(grammarAccess.getClusterAccess().getReteMachinesKeyword_2_0()); 

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
    // $ANTLR end "rule__Cluster__Group_2__0__Impl"


    // $ANTLR start "rule__Cluster__Group_2__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1330:1: rule__Cluster__Group_2__1 : rule__Cluster__Group_2__1__Impl rule__Cluster__Group_2__2 ;
    public final void rule__Cluster__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1334:1: ( rule__Cluster__Group_2__1__Impl rule__Cluster__Group_2__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1335:2: rule__Cluster__Group_2__1__Impl rule__Cluster__Group_2__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__1__Impl_in_rule__Cluster__Group_2__12658);
            rule__Cluster__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__2_in_rule__Cluster__Group_2__12661);
            rule__Cluster__Group_2__2();

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
    // $ANTLR end "rule__Cluster__Group_2__1"


    // $ANTLR start "rule__Cluster__Group_2__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1342:1: rule__Cluster__Group_2__1__Impl : ( ':' ) ;
    public final void rule__Cluster__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1346:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1347:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1347:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1348:1: ':'
            {
             before(grammarAccess.getClusterAccess().getColonKeyword_2_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Cluster__Group_2__1__Impl2689); 
             after(grammarAccess.getClusterAccess().getColonKeyword_2_1()); 

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
    // $ANTLR end "rule__Cluster__Group_2__1__Impl"


    // $ANTLR start "rule__Cluster__Group_2__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1361:1: rule__Cluster__Group_2__2 : rule__Cluster__Group_2__2__Impl rule__Cluster__Group_2__3 ;
    public final void rule__Cluster__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1365:1: ( rule__Cluster__Group_2__2__Impl rule__Cluster__Group_2__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1366:2: rule__Cluster__Group_2__2__Impl rule__Cluster__Group_2__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__2__Impl_in_rule__Cluster__Group_2__22720);
            rule__Cluster__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__3_in_rule__Cluster__Group_2__22723);
            rule__Cluster__Group_2__3();

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
    // $ANTLR end "rule__Cluster__Group_2__2"


    // $ANTLR start "rule__Cluster__Group_2__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1373:1: rule__Cluster__Group_2__2__Impl : ( '[' ) ;
    public final void rule__Cluster__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1377:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1378:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1378:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1379:1: '['
            {
             before(grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_2_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Cluster__Group_2__2__Impl2751); 
             after(grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_2_2()); 

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
    // $ANTLR end "rule__Cluster__Group_2__2__Impl"


    // $ANTLR start "rule__Cluster__Group_2__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1392:1: rule__Cluster__Group_2__3 : rule__Cluster__Group_2__3__Impl rule__Cluster__Group_2__4 ;
    public final void rule__Cluster__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1396:1: ( rule__Cluster__Group_2__3__Impl rule__Cluster__Group_2__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1397:2: rule__Cluster__Group_2__3__Impl rule__Cluster__Group_2__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__3__Impl_in_rule__Cluster__Group_2__32782);
            rule__Cluster__Group_2__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__4_in_rule__Cluster__Group_2__32785);
            rule__Cluster__Group_2__4();

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
    // $ANTLR end "rule__Cluster__Group_2__3"


    // $ANTLR start "rule__Cluster__Group_2__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1404:1: rule__Cluster__Group_2__3__Impl : ( ( rule__Cluster__ReteMachinesAssignment_2_3 )* ) ;
    public final void rule__Cluster__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1408:1: ( ( ( rule__Cluster__ReteMachinesAssignment_2_3 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1409:1: ( ( rule__Cluster__ReteMachinesAssignment_2_3 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1409:1: ( ( rule__Cluster__ReteMachinesAssignment_2_3 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1410:1: ( rule__Cluster__ReteMachinesAssignment_2_3 )*
            {
             before(grammarAccess.getClusterAccess().getReteMachinesAssignment_2_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1411:1: ( rule__Cluster__ReteMachinesAssignment_2_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==18) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1411:2: rule__Cluster__ReteMachinesAssignment_2_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Cluster__ReteMachinesAssignment_2_3_in_rule__Cluster__Group_2__3__Impl2812);
            	    rule__Cluster__ReteMachinesAssignment_2_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getClusterAccess().getReteMachinesAssignment_2_3()); 

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
    // $ANTLR end "rule__Cluster__Group_2__3__Impl"


    // $ANTLR start "rule__Cluster__Group_2__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1421:1: rule__Cluster__Group_2__4 : rule__Cluster__Group_2__4__Impl ;
    public final void rule__Cluster__Group_2__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1425:1: ( rule__Cluster__Group_2__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1426:2: rule__Cluster__Group_2__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_2__4__Impl_in_rule__Cluster__Group_2__42843);
            rule__Cluster__Group_2__4__Impl();

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
    // $ANTLR end "rule__Cluster__Group_2__4"


    // $ANTLR start "rule__Cluster__Group_2__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1432:1: rule__Cluster__Group_2__4__Impl : ( ']' ) ;
    public final void rule__Cluster__Group_2__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1436:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1437:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1437:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1438:1: ']'
            {
             before(grammarAccess.getClusterAccess().getRightSquareBracketKeyword_2_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Cluster__Group_2__4__Impl2871); 
             after(grammarAccess.getClusterAccess().getRightSquareBracketKeyword_2_4()); 

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
    // $ANTLR end "rule__Cluster__Group_2__4__Impl"


    // $ANTLR start "rule__Cluster__Group_3__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1461:1: rule__Cluster__Group_3__0 : rule__Cluster__Group_3__0__Impl rule__Cluster__Group_3__1 ;
    public final void rule__Cluster__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1465:1: ( rule__Cluster__Group_3__0__Impl rule__Cluster__Group_3__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1466:2: rule__Cluster__Group_3__0__Impl rule__Cluster__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__0__Impl_in_rule__Cluster__Group_3__02912);
            rule__Cluster__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__1_in_rule__Cluster__Group_3__02915);
            rule__Cluster__Group_3__1();

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
    // $ANTLR end "rule__Cluster__Group_3__0"


    // $ANTLR start "rule__Cluster__Group_3__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1473:1: rule__Cluster__Group_3__0__Impl : ( 'cacheMachines' ) ;
    public final void rule__Cluster__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1477:1: ( ( 'cacheMachines' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1478:1: ( 'cacheMachines' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1478:1: ( 'cacheMachines' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1479:1: 'cacheMachines'
            {
             before(grammarAccess.getClusterAccess().getCacheMachinesKeyword_3_0()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__Cluster__Group_3__0__Impl2943); 
             after(grammarAccess.getClusterAccess().getCacheMachinesKeyword_3_0()); 

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
    // $ANTLR end "rule__Cluster__Group_3__0__Impl"


    // $ANTLR start "rule__Cluster__Group_3__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1492:1: rule__Cluster__Group_3__1 : rule__Cluster__Group_3__1__Impl rule__Cluster__Group_3__2 ;
    public final void rule__Cluster__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1496:1: ( rule__Cluster__Group_3__1__Impl rule__Cluster__Group_3__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1497:2: rule__Cluster__Group_3__1__Impl rule__Cluster__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__1__Impl_in_rule__Cluster__Group_3__12974);
            rule__Cluster__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__2_in_rule__Cluster__Group_3__12977);
            rule__Cluster__Group_3__2();

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
    // $ANTLR end "rule__Cluster__Group_3__1"


    // $ANTLR start "rule__Cluster__Group_3__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1504:1: rule__Cluster__Group_3__1__Impl : ( ':' ) ;
    public final void rule__Cluster__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1508:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1509:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1509:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1510:1: ':'
            {
             before(grammarAccess.getClusterAccess().getColonKeyword_3_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Cluster__Group_3__1__Impl3005); 
             after(grammarAccess.getClusterAccess().getColonKeyword_3_1()); 

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
    // $ANTLR end "rule__Cluster__Group_3__1__Impl"


    // $ANTLR start "rule__Cluster__Group_3__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1523:1: rule__Cluster__Group_3__2 : rule__Cluster__Group_3__2__Impl rule__Cluster__Group_3__3 ;
    public final void rule__Cluster__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1527:1: ( rule__Cluster__Group_3__2__Impl rule__Cluster__Group_3__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1528:2: rule__Cluster__Group_3__2__Impl rule__Cluster__Group_3__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__2__Impl_in_rule__Cluster__Group_3__23036);
            rule__Cluster__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__3_in_rule__Cluster__Group_3__23039);
            rule__Cluster__Group_3__3();

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
    // $ANTLR end "rule__Cluster__Group_3__2"


    // $ANTLR start "rule__Cluster__Group_3__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1535:1: rule__Cluster__Group_3__2__Impl : ( '[' ) ;
    public final void rule__Cluster__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1539:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1540:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1540:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1541:1: '['
            {
             before(grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_3_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Cluster__Group_3__2__Impl3067); 
             after(grammarAccess.getClusterAccess().getLeftSquareBracketKeyword_3_2()); 

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
    // $ANTLR end "rule__Cluster__Group_3__2__Impl"


    // $ANTLR start "rule__Cluster__Group_3__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1554:1: rule__Cluster__Group_3__3 : rule__Cluster__Group_3__3__Impl rule__Cluster__Group_3__4 ;
    public final void rule__Cluster__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1558:1: ( rule__Cluster__Group_3__3__Impl rule__Cluster__Group_3__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1559:2: rule__Cluster__Group_3__3__Impl rule__Cluster__Group_3__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__3__Impl_in_rule__Cluster__Group_3__33098);
            rule__Cluster__Group_3__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__4_in_rule__Cluster__Group_3__33101);
            rule__Cluster__Group_3__4();

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
    // $ANTLR end "rule__Cluster__Group_3__3"


    // $ANTLR start "rule__Cluster__Group_3__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1566:1: rule__Cluster__Group_3__3__Impl : ( ( rule__Cluster__CacheMachinesAssignment_3_3 )* ) ;
    public final void rule__Cluster__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1570:1: ( ( ( rule__Cluster__CacheMachinesAssignment_3_3 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1571:1: ( ( rule__Cluster__CacheMachinesAssignment_3_3 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1571:1: ( ( rule__Cluster__CacheMachinesAssignment_3_3 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1572:1: ( rule__Cluster__CacheMachinesAssignment_3_3 )*
            {
             before(grammarAccess.getClusterAccess().getCacheMachinesAssignment_3_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1573:1: ( rule__Cluster__CacheMachinesAssignment_3_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1573:2: rule__Cluster__CacheMachinesAssignment_3_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Cluster__CacheMachinesAssignment_3_3_in_rule__Cluster__Group_3__3__Impl3128);
            	    rule__Cluster__CacheMachinesAssignment_3_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getClusterAccess().getCacheMachinesAssignment_3_3()); 

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
    // $ANTLR end "rule__Cluster__Group_3__3__Impl"


    // $ANTLR start "rule__Cluster__Group_3__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1583:1: rule__Cluster__Group_3__4 : rule__Cluster__Group_3__4__Impl ;
    public final void rule__Cluster__Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1587:1: ( rule__Cluster__Group_3__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1588:2: rule__Cluster__Group_3__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Cluster__Group_3__4__Impl_in_rule__Cluster__Group_3__43159);
            rule__Cluster__Group_3__4__Impl();

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
    // $ANTLR end "rule__Cluster__Group_3__4"


    // $ANTLR start "rule__Cluster__Group_3__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1594:1: rule__Cluster__Group_3__4__Impl : ( ']' ) ;
    public final void rule__Cluster__Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1598:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1599:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1599:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1600:1: ']'
            {
             before(grammarAccess.getClusterAccess().getRightSquareBracketKeyword_3_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Cluster__Group_3__4__Impl3187); 
             after(grammarAccess.getClusterAccess().getRightSquareBracketKeyword_3_4()); 

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
    // $ANTLR end "rule__Cluster__Group_3__4__Impl"


    // $ANTLR start "rule__Machine__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1623:1: rule__Machine__Group__0 : rule__Machine__Group__0__Impl rule__Machine__Group__1 ;
    public final void rule__Machine__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1627:1: ( rule__Machine__Group__0__Impl rule__Machine__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1628:2: rule__Machine__Group__0__Impl rule__Machine__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__0__Impl_in_rule__Machine__Group__03228);
            rule__Machine__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__1_in_rule__Machine__Group__03231);
            rule__Machine__Group__1();

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
    // $ANTLR end "rule__Machine__Group__0"


    // $ANTLR start "rule__Machine__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1635:1: rule__Machine__Group__0__Impl : ( '{' ) ;
    public final void rule__Machine__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1639:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1640:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1640:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1641:1: '{'
            {
             before(grammarAccess.getMachineAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Machine__Group__0__Impl3259); 
             after(grammarAccess.getMachineAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end "rule__Machine__Group__0__Impl"


    // $ANTLR start "rule__Machine__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1654:1: rule__Machine__Group__1 : rule__Machine__Group__1__Impl rule__Machine__Group__2 ;
    public final void rule__Machine__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1658:1: ( rule__Machine__Group__1__Impl rule__Machine__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1659:2: rule__Machine__Group__1__Impl rule__Machine__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__1__Impl_in_rule__Machine__Group__13290);
            rule__Machine__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__2_in_rule__Machine__Group__13293);
            rule__Machine__Group__2();

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
    // $ANTLR end "rule__Machine__Group__1"


    // $ANTLR start "rule__Machine__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1666:1: rule__Machine__Group__1__Impl : ( 'traceInfo' ) ;
    public final void rule__Machine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1670:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1671:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1671:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1672:1: 'traceInfo'
            {
             before(grammarAccess.getMachineAccess().getTraceInfoKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Machine__Group__1__Impl3321); 
             after(grammarAccess.getMachineAccess().getTraceInfoKeyword_1()); 

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
    // $ANTLR end "rule__Machine__Group__1__Impl"


    // $ANTLR start "rule__Machine__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1685:1: rule__Machine__Group__2 : rule__Machine__Group__2__Impl rule__Machine__Group__3 ;
    public final void rule__Machine__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1689:1: ( rule__Machine__Group__2__Impl rule__Machine__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1690:2: rule__Machine__Group__2__Impl rule__Machine__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__2__Impl_in_rule__Machine__Group__23352);
            rule__Machine__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__3_in_rule__Machine__Group__23355);
            rule__Machine__Group__3();

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
    // $ANTLR end "rule__Machine__Group__2"


    // $ANTLR start "rule__Machine__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1697:1: rule__Machine__Group__2__Impl : ( ':' ) ;
    public final void rule__Machine__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1701:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1702:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1702:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1703:1: ':'
            {
             before(grammarAccess.getMachineAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Machine__Group__2__Impl3383); 
             after(grammarAccess.getMachineAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__Machine__Group__2__Impl"


    // $ANTLR start "rule__Machine__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1716:1: rule__Machine__Group__3 : rule__Machine__Group__3__Impl rule__Machine__Group__4 ;
    public final void rule__Machine__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1720:1: ( rule__Machine__Group__3__Impl rule__Machine__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1721:2: rule__Machine__Group__3__Impl rule__Machine__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__3__Impl_in_rule__Machine__Group__33414);
            rule__Machine__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__4_in_rule__Machine__Group__33417);
            rule__Machine__Group__4();

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
    // $ANTLR end "rule__Machine__Group__3"


    // $ANTLR start "rule__Machine__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1728:1: rule__Machine__Group__3__Impl : ( ( rule__Machine__TraceInfoAssignment_3 ) ) ;
    public final void rule__Machine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1732:1: ( ( ( rule__Machine__TraceInfoAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1733:1: ( ( rule__Machine__TraceInfoAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1733:1: ( ( rule__Machine__TraceInfoAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1734:1: ( rule__Machine__TraceInfoAssignment_3 )
            {
             before(grammarAccess.getMachineAccess().getTraceInfoAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1735:1: ( rule__Machine__TraceInfoAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1735:2: rule__Machine__TraceInfoAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__TraceInfoAssignment_3_in_rule__Machine__Group__3__Impl3444);
            rule__Machine__TraceInfoAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMachineAccess().getTraceInfoAssignment_3()); 

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
    // $ANTLR end "rule__Machine__Group__3__Impl"


    // $ANTLR start "rule__Machine__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1745:1: rule__Machine__Group__4 : rule__Machine__Group__4__Impl rule__Machine__Group__5 ;
    public final void rule__Machine__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1749:1: ( rule__Machine__Group__4__Impl rule__Machine__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1750:2: rule__Machine__Group__4__Impl rule__Machine__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__4__Impl_in_rule__Machine__Group__43474);
            rule__Machine__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__5_in_rule__Machine__Group__43477);
            rule__Machine__Group__5();

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
    // $ANTLR end "rule__Machine__Group__4"


    // $ANTLR start "rule__Machine__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1757:1: rule__Machine__Group__4__Impl : ( 'ip' ) ;
    public final void rule__Machine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1761:1: ( ( 'ip' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1762:1: ( 'ip' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1762:1: ( 'ip' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1763:1: 'ip'
            {
             before(grammarAccess.getMachineAccess().getIpKeyword_4()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Machine__Group__4__Impl3505); 
             after(grammarAccess.getMachineAccess().getIpKeyword_4()); 

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
    // $ANTLR end "rule__Machine__Group__4__Impl"


    // $ANTLR start "rule__Machine__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1776:1: rule__Machine__Group__5 : rule__Machine__Group__5__Impl rule__Machine__Group__6 ;
    public final void rule__Machine__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1780:1: ( rule__Machine__Group__5__Impl rule__Machine__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1781:2: rule__Machine__Group__5__Impl rule__Machine__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__5__Impl_in_rule__Machine__Group__53536);
            rule__Machine__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__6_in_rule__Machine__Group__53539);
            rule__Machine__Group__6();

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
    // $ANTLR end "rule__Machine__Group__5"


    // $ANTLR start "rule__Machine__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1788:1: rule__Machine__Group__5__Impl : ( ':' ) ;
    public final void rule__Machine__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1792:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1793:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1793:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1794:1: ':'
            {
             before(grammarAccess.getMachineAccess().getColonKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Machine__Group__5__Impl3567); 
             after(grammarAccess.getMachineAccess().getColonKeyword_5()); 

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
    // $ANTLR end "rule__Machine__Group__5__Impl"


    // $ANTLR start "rule__Machine__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1807:1: rule__Machine__Group__6 : rule__Machine__Group__6__Impl rule__Machine__Group__7 ;
    public final void rule__Machine__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1811:1: ( rule__Machine__Group__6__Impl rule__Machine__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1812:2: rule__Machine__Group__6__Impl rule__Machine__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__6__Impl_in_rule__Machine__Group__63598);
            rule__Machine__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__7_in_rule__Machine__Group__63601);
            rule__Machine__Group__7();

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
    // $ANTLR end "rule__Machine__Group__6"


    // $ANTLR start "rule__Machine__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1819:1: rule__Machine__Group__6__Impl : ( ( rule__Machine__IpAssignment_6 ) ) ;
    public final void rule__Machine__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1823:1: ( ( ( rule__Machine__IpAssignment_6 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1824:1: ( ( rule__Machine__IpAssignment_6 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1824:1: ( ( rule__Machine__IpAssignment_6 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1825:1: ( rule__Machine__IpAssignment_6 )
            {
             before(grammarAccess.getMachineAccess().getIpAssignment_6()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1826:1: ( rule__Machine__IpAssignment_6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1826:2: rule__Machine__IpAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__IpAssignment_6_in_rule__Machine__Group__6__Impl3628);
            rule__Machine__IpAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getMachineAccess().getIpAssignment_6()); 

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
    // $ANTLR end "rule__Machine__Group__6__Impl"


    // $ANTLR start "rule__Machine__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1836:1: rule__Machine__Group__7 : rule__Machine__Group__7__Impl ;
    public final void rule__Machine__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1840:1: ( rule__Machine__Group__7__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1841:2: rule__Machine__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__7__Impl_in_rule__Machine__Group__73658);
            rule__Machine__Group__7__Impl();

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
    // $ANTLR end "rule__Machine__Group__7"


    // $ANTLR start "rule__Machine__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1847:1: rule__Machine__Group__7__Impl : ( '}' ) ;
    public final void rule__Machine__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1851:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1852:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1852:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1853:1: '}'
            {
             before(grammarAccess.getMachineAccess().getRightCurlyBracketKeyword_7()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Machine__Group__7__Impl3686); 
             after(grammarAccess.getMachineAccess().getRightCurlyBracketKeyword_7()); 

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
    // $ANTLR end "rule__Machine__Group__7__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1882:1: rule__ReteRecipe__Group__0 : rule__ReteRecipe__Group__0__Impl rule__ReteRecipe__Group__1 ;
    public final void rule__ReteRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1886:1: ( rule__ReteRecipe__Group__0__Impl rule__ReteRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1887:2: rule__ReteRecipe__Group__0__Impl rule__ReteRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__0__Impl_in_rule__ReteRecipe__Group__03733);
            rule__ReteRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__1_in_rule__ReteRecipe__Group__03736);
            rule__ReteRecipe__Group__1();

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
    // $ANTLR end "rule__ReteRecipe__Group__0"


    // $ANTLR start "rule__ReteRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1894:1: rule__ReteRecipe__Group__0__Impl : ( () ) ;
    public final void rule__ReteRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1898:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1899:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1899:1: ( () )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1900:1: ()
            {
             before(grammarAccess.getReteRecipeAccess().getReteRecipeAction_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1901:1: ()
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1903:1: 
            {
            }

             after(grammarAccess.getReteRecipeAccess().getReteRecipeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReteRecipe__Group__0__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1913:1: rule__ReteRecipe__Group__1 : rule__ReteRecipe__Group__1__Impl rule__ReteRecipe__Group__2 ;
    public final void rule__ReteRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1917:1: ( rule__ReteRecipe__Group__1__Impl rule__ReteRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1918:2: rule__ReteRecipe__Group__1__Impl rule__ReteRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__1__Impl_in_rule__ReteRecipe__Group__13794);
            rule__ReteRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__2_in_rule__ReteRecipe__Group__13797);
            rule__ReteRecipe__Group__2();

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
    // $ANTLR end "rule__ReteRecipe__Group__1"


    // $ANTLR start "rule__ReteRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1925:1: rule__ReteRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__ReteRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1929:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1930:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1930:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1931:1: '{'
            {
             before(grammarAccess.getReteRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__ReteRecipe__Group__1__Impl3825); 
             after(grammarAccess.getReteRecipeAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__ReteRecipe__Group__1__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1944:1: rule__ReteRecipe__Group__2 : rule__ReteRecipe__Group__2__Impl rule__ReteRecipe__Group__3 ;
    public final void rule__ReteRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1948:1: ( rule__ReteRecipe__Group__2__Impl rule__ReteRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1949:2: rule__ReteRecipe__Group__2__Impl rule__ReteRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__2__Impl_in_rule__ReteRecipe__Group__23856);
            rule__ReteRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__3_in_rule__ReteRecipe__Group__23859);
            rule__ReteRecipe__Group__3();

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
    // $ANTLR end "rule__ReteRecipe__Group__2"


    // $ANTLR start "rule__ReteRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1956:1: rule__ReteRecipe__Group__2__Impl : ( 'nodes' ) ;
    public final void rule__ReteRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1960:1: ( ( 'nodes' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1961:1: ( 'nodes' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1961:1: ( 'nodes' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1962:1: 'nodes'
            {
             before(grammarAccess.getReteRecipeAccess().getNodesKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__ReteRecipe__Group__2__Impl3887); 
             after(grammarAccess.getReteRecipeAccess().getNodesKeyword_2()); 

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
    // $ANTLR end "rule__ReteRecipe__Group__2__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1975:1: rule__ReteRecipe__Group__3 : rule__ReteRecipe__Group__3__Impl rule__ReteRecipe__Group__4 ;
    public final void rule__ReteRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1979:1: ( rule__ReteRecipe__Group__3__Impl rule__ReteRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1980:2: rule__ReteRecipe__Group__3__Impl rule__ReteRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__3__Impl_in_rule__ReteRecipe__Group__33918);
            rule__ReteRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__4_in_rule__ReteRecipe__Group__33921);
            rule__ReteRecipe__Group__4();

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
    // $ANTLR end "rule__ReteRecipe__Group__3"


    // $ANTLR start "rule__ReteRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1987:1: rule__ReteRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__ReteRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1991:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1992:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1992:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1993:1: ':'
            {
             before(grammarAccess.getReteRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ReteRecipe__Group__3__Impl3949); 
             after(grammarAccess.getReteRecipeAccess().getColonKeyword_3()); 

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
    // $ANTLR end "rule__ReteRecipe__Group__3__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2006:1: rule__ReteRecipe__Group__4 : rule__ReteRecipe__Group__4__Impl rule__ReteRecipe__Group__5 ;
    public final void rule__ReteRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2010:1: ( rule__ReteRecipe__Group__4__Impl rule__ReteRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2011:2: rule__ReteRecipe__Group__4__Impl rule__ReteRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__4__Impl_in_rule__ReteRecipe__Group__43980);
            rule__ReteRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__5_in_rule__ReteRecipe__Group__43983);
            rule__ReteRecipe__Group__5();

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
    // $ANTLR end "rule__ReteRecipe__Group__4"


    // $ANTLR start "rule__ReteRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2018:1: rule__ReteRecipe__Group__4__Impl : ( '[' ) ;
    public final void rule__ReteRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2022:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2023:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2023:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2024:1: '['
            {
             before(grammarAccess.getReteRecipeAccess().getLeftSquareBracketKeyword_4()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ReteRecipe__Group__4__Impl4011); 
             after(grammarAccess.getReteRecipeAccess().getLeftSquareBracketKeyword_4()); 

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
    // $ANTLR end "rule__ReteRecipe__Group__4__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2037:1: rule__ReteRecipe__Group__5 : rule__ReteRecipe__Group__5__Impl rule__ReteRecipe__Group__6 ;
    public final void rule__ReteRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2041:1: ( rule__ReteRecipe__Group__5__Impl rule__ReteRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2042:2: rule__ReteRecipe__Group__5__Impl rule__ReteRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__5__Impl_in_rule__ReteRecipe__Group__54042);
            rule__ReteRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__6_in_rule__ReteRecipe__Group__54045);
            rule__ReteRecipe__Group__6();

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
    // $ANTLR end "rule__ReteRecipe__Group__5"


    // $ANTLR start "rule__ReteRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2049:1: rule__ReteRecipe__Group__5__Impl : ( ( rule__ReteRecipe__RecipeNodesAssignment_5 )* ) ;
    public final void rule__ReteRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2053:1: ( ( ( rule__ReteRecipe__RecipeNodesAssignment_5 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2054:1: ( ( rule__ReteRecipe__RecipeNodesAssignment_5 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2054:1: ( ( rule__ReteRecipe__RecipeNodesAssignment_5 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2055:1: ( rule__ReteRecipe__RecipeNodesAssignment_5 )*
            {
             before(grammarAccess.getReteRecipeAccess().getRecipeNodesAssignment_5()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2056:1: ( rule__ReteRecipe__RecipeNodesAssignment_5 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25||(LA12_0>=27 && LA12_0<=28)||LA12_0==30||LA12_0==32||LA12_0==35) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2056:2: rule__ReteRecipe__RecipeNodesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__RecipeNodesAssignment_5_in_rule__ReteRecipe__Group__5__Impl4072);
            	    rule__ReteRecipe__RecipeNodesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getReteRecipeAccess().getRecipeNodesAssignment_5()); 

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
    // $ANTLR end "rule__ReteRecipe__Group__5__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2066:1: rule__ReteRecipe__Group__6 : rule__ReteRecipe__Group__6__Impl rule__ReteRecipe__Group__7 ;
    public final void rule__ReteRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2070:1: ( rule__ReteRecipe__Group__6__Impl rule__ReteRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2071:2: rule__ReteRecipe__Group__6__Impl rule__ReteRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__6__Impl_in_rule__ReteRecipe__Group__64103);
            rule__ReteRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__7_in_rule__ReteRecipe__Group__64106);
            rule__ReteRecipe__Group__7();

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
    // $ANTLR end "rule__ReteRecipe__Group__6"


    // $ANTLR start "rule__ReteRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2078:1: rule__ReteRecipe__Group__6__Impl : ( ']' ) ;
    public final void rule__ReteRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2082:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2083:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2083:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2084:1: ']'
            {
             before(grammarAccess.getReteRecipeAccess().getRightSquareBracketKeyword_6()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__ReteRecipe__Group__6__Impl4134); 
             after(grammarAccess.getReteRecipeAccess().getRightSquareBracketKeyword_6()); 

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
    // $ANTLR end "rule__ReteRecipe__Group__6__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2097:1: rule__ReteRecipe__Group__7 : rule__ReteRecipe__Group__7__Impl ;
    public final void rule__ReteRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2101:1: ( rule__ReteRecipe__Group__7__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2102:2: rule__ReteRecipe__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__7__Impl_in_rule__ReteRecipe__Group__74165);
            rule__ReteRecipe__Group__7__Impl();

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
    // $ANTLR end "rule__ReteRecipe__Group__7"


    // $ANTLR start "rule__ReteRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2108:1: rule__ReteRecipe__Group__7__Impl : ( '}' ) ;
    public final void rule__ReteRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2112:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2113:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2113:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2114:1: '}'
            {
             before(grammarAccess.getReteRecipeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ReteRecipe__Group__7__Impl4193); 
             after(grammarAccess.getReteRecipeAccess().getRightCurlyBracketKeyword_7()); 

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
    // $ANTLR end "rule__ReteRecipe__Group__7__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2143:1: rule__ProductionRecipe__Group__0 : rule__ProductionRecipe__Group__0__Impl rule__ProductionRecipe__Group__1 ;
    public final void rule__ProductionRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2147:1: ( rule__ProductionRecipe__Group__0__Impl rule__ProductionRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2148:2: rule__ProductionRecipe__Group__0__Impl rule__ProductionRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__0__Impl_in_rule__ProductionRecipe__Group__04240);
            rule__ProductionRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__1_in_rule__ProductionRecipe__Group__04243);
            rule__ProductionRecipe__Group__1();

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
    // $ANTLR end "rule__ProductionRecipe__Group__0"


    // $ANTLR start "rule__ProductionRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2155:1: rule__ProductionRecipe__Group__0__Impl : ( 'Production' ) ;
    public final void rule__ProductionRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2159:1: ( ( 'Production' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2160:1: ( 'Production' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2160:1: ( 'Production' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2161:1: 'Production'
            {
             before(grammarAccess.getProductionRecipeAccess().getProductionKeyword_0()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ProductionRecipe__Group__0__Impl4271); 
             after(grammarAccess.getProductionRecipeAccess().getProductionKeyword_0()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__0__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2174:1: rule__ProductionRecipe__Group__1 : rule__ProductionRecipe__Group__1__Impl rule__ProductionRecipe__Group__2 ;
    public final void rule__ProductionRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2178:1: ( rule__ProductionRecipe__Group__1__Impl rule__ProductionRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2179:2: rule__ProductionRecipe__Group__1__Impl rule__ProductionRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__1__Impl_in_rule__ProductionRecipe__Group__14302);
            rule__ProductionRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__2_in_rule__ProductionRecipe__Group__14305);
            rule__ProductionRecipe__Group__2();

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
    // $ANTLR end "rule__ProductionRecipe__Group__1"


    // $ANTLR start "rule__ProductionRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2186:1: rule__ProductionRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__ProductionRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2190:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2191:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2191:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2192:1: '{'
            {
             before(grammarAccess.getProductionRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__ProductionRecipe__Group__1__Impl4333); 
             after(grammarAccess.getProductionRecipeAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__1__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2205:1: rule__ProductionRecipe__Group__2 : rule__ProductionRecipe__Group__2__Impl rule__ProductionRecipe__Group__3 ;
    public final void rule__ProductionRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2209:1: ( rule__ProductionRecipe__Group__2__Impl rule__ProductionRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2210:2: rule__ProductionRecipe__Group__2__Impl rule__ProductionRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__2__Impl_in_rule__ProductionRecipe__Group__24364);
            rule__ProductionRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__3_in_rule__ProductionRecipe__Group__24367);
            rule__ProductionRecipe__Group__3();

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
    // $ANTLR end "rule__ProductionRecipe__Group__2"


    // $ANTLR start "rule__ProductionRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2217:1: rule__ProductionRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__ProductionRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2221:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2222:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2222:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2223:1: 'traceInfo'
            {
             before(grammarAccess.getProductionRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__ProductionRecipe__Group__2__Impl4395); 
             after(grammarAccess.getProductionRecipeAccess().getTraceInfoKeyword_2()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__2__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2236:1: rule__ProductionRecipe__Group__3 : rule__ProductionRecipe__Group__3__Impl rule__ProductionRecipe__Group__4 ;
    public final void rule__ProductionRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2240:1: ( rule__ProductionRecipe__Group__3__Impl rule__ProductionRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2241:2: rule__ProductionRecipe__Group__3__Impl rule__ProductionRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__3__Impl_in_rule__ProductionRecipe__Group__34426);
            rule__ProductionRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__4_in_rule__ProductionRecipe__Group__34429);
            rule__ProductionRecipe__Group__4();

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
    // $ANTLR end "rule__ProductionRecipe__Group__3"


    // $ANTLR start "rule__ProductionRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2248:1: rule__ProductionRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__ProductionRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2252:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2253:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2253:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2254:1: ':'
            {
             before(grammarAccess.getProductionRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProductionRecipe__Group__3__Impl4457); 
             after(grammarAccess.getProductionRecipeAccess().getColonKeyword_3()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__3__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2267:1: rule__ProductionRecipe__Group__4 : rule__ProductionRecipe__Group__4__Impl rule__ProductionRecipe__Group__5 ;
    public final void rule__ProductionRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2271:1: ( rule__ProductionRecipe__Group__4__Impl rule__ProductionRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2272:2: rule__ProductionRecipe__Group__4__Impl rule__ProductionRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__4__Impl_in_rule__ProductionRecipe__Group__44488);
            rule__ProductionRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__5_in_rule__ProductionRecipe__Group__44491);
            rule__ProductionRecipe__Group__5();

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
    // $ANTLR end "rule__ProductionRecipe__Group__4"


    // $ANTLR start "rule__ProductionRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2279:1: rule__ProductionRecipe__Group__4__Impl : ( ( rule__ProductionRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__ProductionRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2283:1: ( ( ( rule__ProductionRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2284:1: ( ( rule__ProductionRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2284:1: ( ( rule__ProductionRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2285:1: ( rule__ProductionRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getProductionRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2286:1: ( rule__ProductionRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2286:2: rule__ProductionRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__TraceInfoAssignment_4_in_rule__ProductionRecipe__Group__4__Impl4518);
            rule__ProductionRecipe__TraceInfoAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getProductionRecipeAccess().getTraceInfoAssignment_4()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__4__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2296:1: rule__ProductionRecipe__Group__5 : rule__ProductionRecipe__Group__5__Impl rule__ProductionRecipe__Group__6 ;
    public final void rule__ProductionRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2300:1: ( rule__ProductionRecipe__Group__5__Impl rule__ProductionRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2301:2: rule__ProductionRecipe__Group__5__Impl rule__ProductionRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__5__Impl_in_rule__ProductionRecipe__Group__54548);
            rule__ProductionRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__6_in_rule__ProductionRecipe__Group__54551);
            rule__ProductionRecipe__Group__6();

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
    // $ANTLR end "rule__ProductionRecipe__Group__5"


    // $ANTLR start "rule__ProductionRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2308:1: rule__ProductionRecipe__Group__5__Impl : ( 'parents' ) ;
    public final void rule__ProductionRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2312:1: ( ( 'parents' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2313:1: ( 'parents' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2313:1: ( 'parents' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2314:1: 'parents'
            {
             before(grammarAccess.getProductionRecipeAccess().getParentsKeyword_5()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__ProductionRecipe__Group__5__Impl4579); 
             after(grammarAccess.getProductionRecipeAccess().getParentsKeyword_5()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__5__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2327:1: rule__ProductionRecipe__Group__6 : rule__ProductionRecipe__Group__6__Impl rule__ProductionRecipe__Group__7 ;
    public final void rule__ProductionRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2331:1: ( rule__ProductionRecipe__Group__6__Impl rule__ProductionRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2332:2: rule__ProductionRecipe__Group__6__Impl rule__ProductionRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__6__Impl_in_rule__ProductionRecipe__Group__64610);
            rule__ProductionRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__7_in_rule__ProductionRecipe__Group__64613);
            rule__ProductionRecipe__Group__7();

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
    // $ANTLR end "rule__ProductionRecipe__Group__6"


    // $ANTLR start "rule__ProductionRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2339:1: rule__ProductionRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__ProductionRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2343:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2344:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2344:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2345:1: ':'
            {
             before(grammarAccess.getProductionRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProductionRecipe__Group__6__Impl4641); 
             after(grammarAccess.getProductionRecipeAccess().getColonKeyword_6()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__6__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2358:1: rule__ProductionRecipe__Group__7 : rule__ProductionRecipe__Group__7__Impl rule__ProductionRecipe__Group__8 ;
    public final void rule__ProductionRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2362:1: ( rule__ProductionRecipe__Group__7__Impl rule__ProductionRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2363:2: rule__ProductionRecipe__Group__7__Impl rule__ProductionRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__7__Impl_in_rule__ProductionRecipe__Group__74672);
            rule__ProductionRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__8_in_rule__ProductionRecipe__Group__74675);
            rule__ProductionRecipe__Group__8();

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
    // $ANTLR end "rule__ProductionRecipe__Group__7"


    // $ANTLR start "rule__ProductionRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2370:1: rule__ProductionRecipe__Group__7__Impl : ( '[' ) ;
    public final void rule__ProductionRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2374:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2375:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2375:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2376:1: '['
            {
             before(grammarAccess.getProductionRecipeAccess().getLeftSquareBracketKeyword_7()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ProductionRecipe__Group__7__Impl4703); 
             after(grammarAccess.getProductionRecipeAccess().getLeftSquareBracketKeyword_7()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__7__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2389:1: rule__ProductionRecipe__Group__8 : rule__ProductionRecipe__Group__8__Impl rule__ProductionRecipe__Group__9 ;
    public final void rule__ProductionRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2393:1: ( rule__ProductionRecipe__Group__8__Impl rule__ProductionRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2394:2: rule__ProductionRecipe__Group__8__Impl rule__ProductionRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__8__Impl_in_rule__ProductionRecipe__Group__84734);
            rule__ProductionRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__9_in_rule__ProductionRecipe__Group__84737);
            rule__ProductionRecipe__Group__9();

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
    // $ANTLR end "rule__ProductionRecipe__Group__8"


    // $ANTLR start "rule__ProductionRecipe__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2401:1: rule__ProductionRecipe__Group__8__Impl : ( ( rule__ProductionRecipe__ParentsAssignment_8 )* ) ;
    public final void rule__ProductionRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2405:1: ( ( ( rule__ProductionRecipe__ParentsAssignment_8 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2406:1: ( ( rule__ProductionRecipe__ParentsAssignment_8 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2406:1: ( ( rule__ProductionRecipe__ParentsAssignment_8 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2407:1: ( rule__ProductionRecipe__ParentsAssignment_8 )*
            {
             before(grammarAccess.getProductionRecipeAccess().getParentsAssignment_8()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2408:1: ( rule__ProductionRecipe__ParentsAssignment_8 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2408:2: rule__ProductionRecipe__ParentsAssignment_8
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__ParentsAssignment_8_in_rule__ProductionRecipe__Group__8__Impl4764);
            	    rule__ProductionRecipe__ParentsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getProductionRecipeAccess().getParentsAssignment_8()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__8__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2418:1: rule__ProductionRecipe__Group__9 : rule__ProductionRecipe__Group__9__Impl rule__ProductionRecipe__Group__10 ;
    public final void rule__ProductionRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2422:1: ( rule__ProductionRecipe__Group__9__Impl rule__ProductionRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2423:2: rule__ProductionRecipe__Group__9__Impl rule__ProductionRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__9__Impl_in_rule__ProductionRecipe__Group__94795);
            rule__ProductionRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__10_in_rule__ProductionRecipe__Group__94798);
            rule__ProductionRecipe__Group__10();

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
    // $ANTLR end "rule__ProductionRecipe__Group__9"


    // $ANTLR start "rule__ProductionRecipe__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2430:1: rule__ProductionRecipe__Group__9__Impl : ( ']' ) ;
    public final void rule__ProductionRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2434:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2435:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2435:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2436:1: ']'
            {
             before(grammarAccess.getProductionRecipeAccess().getRightSquareBracketKeyword_9()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__ProductionRecipe__Group__9__Impl4826); 
             after(grammarAccess.getProductionRecipeAccess().getRightSquareBracketKeyword_9()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__9__Impl"


    // $ANTLR start "rule__ProductionRecipe__Group__10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2449:1: rule__ProductionRecipe__Group__10 : rule__ProductionRecipe__Group__10__Impl ;
    public final void rule__ProductionRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2453:1: ( rule__ProductionRecipe__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2454:2: rule__ProductionRecipe__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__10__Impl_in_rule__ProductionRecipe__Group__104857);
            rule__ProductionRecipe__Group__10__Impl();

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
    // $ANTLR end "rule__ProductionRecipe__Group__10"


    // $ANTLR start "rule__ProductionRecipe__Group__10__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2460:1: rule__ProductionRecipe__Group__10__Impl : ( '}' ) ;
    public final void rule__ProductionRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2464:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2465:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2465:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2466:1: '}'
            {
             before(grammarAccess.getProductionRecipeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ProductionRecipe__Group__10__Impl4885); 
             after(grammarAccess.getProductionRecipeAccess().getRightCurlyBracketKeyword_10()); 

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
    // $ANTLR end "rule__ProductionRecipe__Group__10__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2501:1: rule__UniquenessEnforcerRecipe__Group__0 : rule__UniquenessEnforcerRecipe__Group__0__Impl rule__UniquenessEnforcerRecipe__Group__1 ;
    public final void rule__UniquenessEnforcerRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2505:1: ( rule__UniquenessEnforcerRecipe__Group__0__Impl rule__UniquenessEnforcerRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2506:2: rule__UniquenessEnforcerRecipe__Group__0__Impl rule__UniquenessEnforcerRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__0__Impl_in_rule__UniquenessEnforcerRecipe__Group__04938);
            rule__UniquenessEnforcerRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__1_in_rule__UniquenessEnforcerRecipe__Group__04941);
            rule__UniquenessEnforcerRecipe__Group__1();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__0"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2513:1: rule__UniquenessEnforcerRecipe__Group__0__Impl : ( 'UniquenessEnforcer' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2517:1: ( ( 'UniquenessEnforcer' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2518:1: ( 'UniquenessEnforcer' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2518:1: ( 'UniquenessEnforcer' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2519:1: 'UniquenessEnforcer'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getUniquenessEnforcerKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__UniquenessEnforcerRecipe__Group__0__Impl4969); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getUniquenessEnforcerKeyword_0()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__0__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2532:1: rule__UniquenessEnforcerRecipe__Group__1 : rule__UniquenessEnforcerRecipe__Group__1__Impl rule__UniquenessEnforcerRecipe__Group__2 ;
    public final void rule__UniquenessEnforcerRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2536:1: ( rule__UniquenessEnforcerRecipe__Group__1__Impl rule__UniquenessEnforcerRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2537:2: rule__UniquenessEnforcerRecipe__Group__1__Impl rule__UniquenessEnforcerRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__1__Impl_in_rule__UniquenessEnforcerRecipe__Group__15000);
            rule__UniquenessEnforcerRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__2_in_rule__UniquenessEnforcerRecipe__Group__15003);
            rule__UniquenessEnforcerRecipe__Group__2();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__1"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2544:1: rule__UniquenessEnforcerRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2548:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2549:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2549:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2550:1: '{'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__UniquenessEnforcerRecipe__Group__1__Impl5031); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__1__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2563:1: rule__UniquenessEnforcerRecipe__Group__2 : rule__UniquenessEnforcerRecipe__Group__2__Impl rule__UniquenessEnforcerRecipe__Group__3 ;
    public final void rule__UniquenessEnforcerRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2567:1: ( rule__UniquenessEnforcerRecipe__Group__2__Impl rule__UniquenessEnforcerRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2568:2: rule__UniquenessEnforcerRecipe__Group__2__Impl rule__UniquenessEnforcerRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__2__Impl_in_rule__UniquenessEnforcerRecipe__Group__25062);
            rule__UniquenessEnforcerRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__3_in_rule__UniquenessEnforcerRecipe__Group__25065);
            rule__UniquenessEnforcerRecipe__Group__3();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__2"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2575:1: rule__UniquenessEnforcerRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2579:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2580:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2580:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2581:1: 'traceInfo'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__UniquenessEnforcerRecipe__Group__2__Impl5093); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoKeyword_2()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__2__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2594:1: rule__UniquenessEnforcerRecipe__Group__3 : rule__UniquenessEnforcerRecipe__Group__3__Impl rule__UniquenessEnforcerRecipe__Group__4 ;
    public final void rule__UniquenessEnforcerRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2598:1: ( rule__UniquenessEnforcerRecipe__Group__3__Impl rule__UniquenessEnforcerRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2599:2: rule__UniquenessEnforcerRecipe__Group__3__Impl rule__UniquenessEnforcerRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__3__Impl_in_rule__UniquenessEnforcerRecipe__Group__35124);
            rule__UniquenessEnforcerRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__4_in_rule__UniquenessEnforcerRecipe__Group__35127);
            rule__UniquenessEnforcerRecipe__Group__4();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__3"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2606:1: rule__UniquenessEnforcerRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2610:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2611:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2611:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2612:1: ':'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__UniquenessEnforcerRecipe__Group__3__Impl5155); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_3()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__3__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2625:1: rule__UniquenessEnforcerRecipe__Group__4 : rule__UniquenessEnforcerRecipe__Group__4__Impl rule__UniquenessEnforcerRecipe__Group__5 ;
    public final void rule__UniquenessEnforcerRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2629:1: ( rule__UniquenessEnforcerRecipe__Group__4__Impl rule__UniquenessEnforcerRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2630:2: rule__UniquenessEnforcerRecipe__Group__4__Impl rule__UniquenessEnforcerRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__4__Impl_in_rule__UniquenessEnforcerRecipe__Group__45186);
            rule__UniquenessEnforcerRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__5_in_rule__UniquenessEnforcerRecipe__Group__45189);
            rule__UniquenessEnforcerRecipe__Group__5();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__4"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2637:1: rule__UniquenessEnforcerRecipe__Group__4__Impl : ( ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2641:1: ( ( ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2642:1: ( ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2642:1: ( ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2643:1: ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2644:1: ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2644:2: rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4_in_rule__UniquenessEnforcerRecipe__Group__4__Impl5216);
            rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoAssignment_4()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__4__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2654:1: rule__UniquenessEnforcerRecipe__Group__5 : rule__UniquenessEnforcerRecipe__Group__5__Impl rule__UniquenessEnforcerRecipe__Group__6 ;
    public final void rule__UniquenessEnforcerRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2658:1: ( rule__UniquenessEnforcerRecipe__Group__5__Impl rule__UniquenessEnforcerRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2659:2: rule__UniquenessEnforcerRecipe__Group__5__Impl rule__UniquenessEnforcerRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__5__Impl_in_rule__UniquenessEnforcerRecipe__Group__55246);
            rule__UniquenessEnforcerRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__6_in_rule__UniquenessEnforcerRecipe__Group__55249);
            rule__UniquenessEnforcerRecipe__Group__6();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__5"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2666:1: rule__UniquenessEnforcerRecipe__Group__5__Impl : ( 'parents' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2670:1: ( ( 'parents' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2671:1: ( 'parents' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2671:1: ( 'parents' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2672:1: 'parents'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsKeyword_5()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__UniquenessEnforcerRecipe__Group__5__Impl5277); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsKeyword_5()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__5__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2685:1: rule__UniquenessEnforcerRecipe__Group__6 : rule__UniquenessEnforcerRecipe__Group__6__Impl rule__UniquenessEnforcerRecipe__Group__7 ;
    public final void rule__UniquenessEnforcerRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2689:1: ( rule__UniquenessEnforcerRecipe__Group__6__Impl rule__UniquenessEnforcerRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2690:2: rule__UniquenessEnforcerRecipe__Group__6__Impl rule__UniquenessEnforcerRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__6__Impl_in_rule__UniquenessEnforcerRecipe__Group__65308);
            rule__UniquenessEnforcerRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__7_in_rule__UniquenessEnforcerRecipe__Group__65311);
            rule__UniquenessEnforcerRecipe__Group__7();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__6"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2697:1: rule__UniquenessEnforcerRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2701:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2702:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2702:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2703:1: ':'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__UniquenessEnforcerRecipe__Group__6__Impl5339); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_6()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__6__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2716:1: rule__UniquenessEnforcerRecipe__Group__7 : rule__UniquenessEnforcerRecipe__Group__7__Impl rule__UniquenessEnforcerRecipe__Group__8 ;
    public final void rule__UniquenessEnforcerRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2720:1: ( rule__UniquenessEnforcerRecipe__Group__7__Impl rule__UniquenessEnforcerRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2721:2: rule__UniquenessEnforcerRecipe__Group__7__Impl rule__UniquenessEnforcerRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__7__Impl_in_rule__UniquenessEnforcerRecipe__Group__75370);
            rule__UniquenessEnforcerRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__8_in_rule__UniquenessEnforcerRecipe__Group__75373);
            rule__UniquenessEnforcerRecipe__Group__8();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__7"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2728:1: rule__UniquenessEnforcerRecipe__Group__7__Impl : ( '[' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2732:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2733:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2733:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2734:1: '['
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftSquareBracketKeyword_7()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__UniquenessEnforcerRecipe__Group__7__Impl5401); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftSquareBracketKeyword_7()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__7__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2747:1: rule__UniquenessEnforcerRecipe__Group__8 : rule__UniquenessEnforcerRecipe__Group__8__Impl rule__UniquenessEnforcerRecipe__Group__9 ;
    public final void rule__UniquenessEnforcerRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2751:1: ( rule__UniquenessEnforcerRecipe__Group__8__Impl rule__UniquenessEnforcerRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2752:2: rule__UniquenessEnforcerRecipe__Group__8__Impl rule__UniquenessEnforcerRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__8__Impl_in_rule__UniquenessEnforcerRecipe__Group__85432);
            rule__UniquenessEnforcerRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__9_in_rule__UniquenessEnforcerRecipe__Group__85435);
            rule__UniquenessEnforcerRecipe__Group__9();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__8"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2759:1: rule__UniquenessEnforcerRecipe__Group__8__Impl : ( ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )* ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2763:1: ( ( ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2764:1: ( ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2764:1: ( ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2765:1: ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )*
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsAssignment_8()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2766:1: ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2766:2: rule__UniquenessEnforcerRecipe__ParentsAssignment_8
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__ParentsAssignment_8_in_rule__UniquenessEnforcerRecipe__Group__8__Impl5462);
            	    rule__UniquenessEnforcerRecipe__ParentsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsAssignment_8()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__8__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2776:1: rule__UniquenessEnforcerRecipe__Group__9 : rule__UniquenessEnforcerRecipe__Group__9__Impl rule__UniquenessEnforcerRecipe__Group__10 ;
    public final void rule__UniquenessEnforcerRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2780:1: ( rule__UniquenessEnforcerRecipe__Group__9__Impl rule__UniquenessEnforcerRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2781:2: rule__UniquenessEnforcerRecipe__Group__9__Impl rule__UniquenessEnforcerRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__9__Impl_in_rule__UniquenessEnforcerRecipe__Group__95493);
            rule__UniquenessEnforcerRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__10_in_rule__UniquenessEnforcerRecipe__Group__95496);
            rule__UniquenessEnforcerRecipe__Group__10();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__9"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2788:1: rule__UniquenessEnforcerRecipe__Group__9__Impl : ( ']' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2792:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2793:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2793:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2794:1: ']'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getRightSquareBracketKeyword_9()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__UniquenessEnforcerRecipe__Group__9__Impl5524); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getRightSquareBracketKeyword_9()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__9__Impl"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2807:1: rule__UniquenessEnforcerRecipe__Group__10 : rule__UniquenessEnforcerRecipe__Group__10__Impl ;
    public final void rule__UniquenessEnforcerRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2811:1: ( rule__UniquenessEnforcerRecipe__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2812:2: rule__UniquenessEnforcerRecipe__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__10__Impl_in_rule__UniquenessEnforcerRecipe__Group__105555);
            rule__UniquenessEnforcerRecipe__Group__10__Impl();

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__10"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__Group__10__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2818:1: rule__UniquenessEnforcerRecipe__Group__10__Impl : ( '}' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2822:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2823:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2823:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2824:1: '}'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__UniquenessEnforcerRecipe__Group__10__Impl5583); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getRightCurlyBracketKeyword_10()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__Group__10__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2859:1: rule__CheckRecipe__Group__0 : rule__CheckRecipe__Group__0__Impl rule__CheckRecipe__Group__1 ;
    public final void rule__CheckRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2863:1: ( rule__CheckRecipe__Group__0__Impl rule__CheckRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2864:2: rule__CheckRecipe__Group__0__Impl rule__CheckRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__0__Impl_in_rule__CheckRecipe__Group__05636);
            rule__CheckRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__1_in_rule__CheckRecipe__Group__05639);
            rule__CheckRecipe__Group__1();

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
    // $ANTLR end "rule__CheckRecipe__Group__0"


    // $ANTLR start "rule__CheckRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2871:1: rule__CheckRecipe__Group__0__Impl : ( 'Check' ) ;
    public final void rule__CheckRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2875:1: ( ( 'Check' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2876:1: ( 'Check' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2876:1: ( 'Check' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2877:1: 'Check'
            {
             before(grammarAccess.getCheckRecipeAccess().getCheckKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__CheckRecipe__Group__0__Impl5667); 
             after(grammarAccess.getCheckRecipeAccess().getCheckKeyword_0()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__0__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2890:1: rule__CheckRecipe__Group__1 : rule__CheckRecipe__Group__1__Impl rule__CheckRecipe__Group__2 ;
    public final void rule__CheckRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2894:1: ( rule__CheckRecipe__Group__1__Impl rule__CheckRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2895:2: rule__CheckRecipe__Group__1__Impl rule__CheckRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__1__Impl_in_rule__CheckRecipe__Group__15698);
            rule__CheckRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__2_in_rule__CheckRecipe__Group__15701);
            rule__CheckRecipe__Group__2();

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
    // $ANTLR end "rule__CheckRecipe__Group__1"


    // $ANTLR start "rule__CheckRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2902:1: rule__CheckRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__CheckRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2906:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2907:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2907:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2908:1: '{'
            {
             before(grammarAccess.getCheckRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__CheckRecipe__Group__1__Impl5729); 
             after(grammarAccess.getCheckRecipeAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__1__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2921:1: rule__CheckRecipe__Group__2 : rule__CheckRecipe__Group__2__Impl rule__CheckRecipe__Group__3 ;
    public final void rule__CheckRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2925:1: ( rule__CheckRecipe__Group__2__Impl rule__CheckRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2926:2: rule__CheckRecipe__Group__2__Impl rule__CheckRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__2__Impl_in_rule__CheckRecipe__Group__25760);
            rule__CheckRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__3_in_rule__CheckRecipe__Group__25763);
            rule__CheckRecipe__Group__3();

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
    // $ANTLR end "rule__CheckRecipe__Group__2"


    // $ANTLR start "rule__CheckRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2933:1: rule__CheckRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__CheckRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2937:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2938:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2938:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2939:1: 'traceInfo'
            {
             before(grammarAccess.getCheckRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__CheckRecipe__Group__2__Impl5791); 
             after(grammarAccess.getCheckRecipeAccess().getTraceInfoKeyword_2()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__2__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2952:1: rule__CheckRecipe__Group__3 : rule__CheckRecipe__Group__3__Impl rule__CheckRecipe__Group__4 ;
    public final void rule__CheckRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2956:1: ( rule__CheckRecipe__Group__3__Impl rule__CheckRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2957:2: rule__CheckRecipe__Group__3__Impl rule__CheckRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__3__Impl_in_rule__CheckRecipe__Group__35822);
            rule__CheckRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__4_in_rule__CheckRecipe__Group__35825);
            rule__CheckRecipe__Group__4();

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
    // $ANTLR end "rule__CheckRecipe__Group__3"


    // $ANTLR start "rule__CheckRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2964:1: rule__CheckRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__CheckRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2968:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2969:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2969:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2970:1: ':'
            {
             before(grammarAccess.getCheckRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__CheckRecipe__Group__3__Impl5853); 
             after(grammarAccess.getCheckRecipeAccess().getColonKeyword_3()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__3__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2983:1: rule__CheckRecipe__Group__4 : rule__CheckRecipe__Group__4__Impl rule__CheckRecipe__Group__5 ;
    public final void rule__CheckRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2987:1: ( rule__CheckRecipe__Group__4__Impl rule__CheckRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2988:2: rule__CheckRecipe__Group__4__Impl rule__CheckRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__4__Impl_in_rule__CheckRecipe__Group__45884);
            rule__CheckRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__5_in_rule__CheckRecipe__Group__45887);
            rule__CheckRecipe__Group__5();

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
    // $ANTLR end "rule__CheckRecipe__Group__4"


    // $ANTLR start "rule__CheckRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2995:1: rule__CheckRecipe__Group__4__Impl : ( ( rule__CheckRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__CheckRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2999:1: ( ( ( rule__CheckRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3000:1: ( ( rule__CheckRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3000:1: ( ( rule__CheckRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3001:1: ( rule__CheckRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getCheckRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3002:1: ( rule__CheckRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3002:2: rule__CheckRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__TraceInfoAssignment_4_in_rule__CheckRecipe__Group__4__Impl5914);
            rule__CheckRecipe__TraceInfoAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getCheckRecipeAccess().getTraceInfoAssignment_4()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__4__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3012:1: rule__CheckRecipe__Group__5 : rule__CheckRecipe__Group__5__Impl rule__CheckRecipe__Group__6 ;
    public final void rule__CheckRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3016:1: ( rule__CheckRecipe__Group__5__Impl rule__CheckRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3017:2: rule__CheckRecipe__Group__5__Impl rule__CheckRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__5__Impl_in_rule__CheckRecipe__Group__55944);
            rule__CheckRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__6_in_rule__CheckRecipe__Group__55947);
            rule__CheckRecipe__Group__6();

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
    // $ANTLR end "rule__CheckRecipe__Group__5"


    // $ANTLR start "rule__CheckRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3024:1: rule__CheckRecipe__Group__5__Impl : ( 'parent' ) ;
    public final void rule__CheckRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3028:1: ( ( 'parent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3029:1: ( 'parent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3029:1: ( 'parent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3030:1: 'parent'
            {
             before(grammarAccess.getCheckRecipeAccess().getParentKeyword_5()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__CheckRecipe__Group__5__Impl5975); 
             after(grammarAccess.getCheckRecipeAccess().getParentKeyword_5()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__5__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3043:1: rule__CheckRecipe__Group__6 : rule__CheckRecipe__Group__6__Impl rule__CheckRecipe__Group__7 ;
    public final void rule__CheckRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3047:1: ( rule__CheckRecipe__Group__6__Impl rule__CheckRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3048:2: rule__CheckRecipe__Group__6__Impl rule__CheckRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__6__Impl_in_rule__CheckRecipe__Group__66006);
            rule__CheckRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__7_in_rule__CheckRecipe__Group__66009);
            rule__CheckRecipe__Group__7();

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
    // $ANTLR end "rule__CheckRecipe__Group__6"


    // $ANTLR start "rule__CheckRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3055:1: rule__CheckRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__CheckRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3059:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3060:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3060:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3061:1: ':'
            {
             before(grammarAccess.getCheckRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__CheckRecipe__Group__6__Impl6037); 
             after(grammarAccess.getCheckRecipeAccess().getColonKeyword_6()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__6__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3074:1: rule__CheckRecipe__Group__7 : rule__CheckRecipe__Group__7__Impl rule__CheckRecipe__Group__8 ;
    public final void rule__CheckRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3078:1: ( rule__CheckRecipe__Group__7__Impl rule__CheckRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3079:2: rule__CheckRecipe__Group__7__Impl rule__CheckRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__7__Impl_in_rule__CheckRecipe__Group__76068);
            rule__CheckRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__8_in_rule__CheckRecipe__Group__76071);
            rule__CheckRecipe__Group__8();

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
    // $ANTLR end "rule__CheckRecipe__Group__7"


    // $ANTLR start "rule__CheckRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3086:1: rule__CheckRecipe__Group__7__Impl : ( ( rule__CheckRecipe__ParentAssignment_7 ) ) ;
    public final void rule__CheckRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3090:1: ( ( ( rule__CheckRecipe__ParentAssignment_7 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3091:1: ( ( rule__CheckRecipe__ParentAssignment_7 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3091:1: ( ( rule__CheckRecipe__ParentAssignment_7 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3092:1: ( rule__CheckRecipe__ParentAssignment_7 )
            {
             before(grammarAccess.getCheckRecipeAccess().getParentAssignment_7()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3093:1: ( rule__CheckRecipe__ParentAssignment_7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3093:2: rule__CheckRecipe__ParentAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__ParentAssignment_7_in_rule__CheckRecipe__Group__7__Impl6098);
            rule__CheckRecipe__ParentAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getCheckRecipeAccess().getParentAssignment_7()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__7__Impl"


    // $ANTLR start "rule__CheckRecipe__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3103:1: rule__CheckRecipe__Group__8 : rule__CheckRecipe__Group__8__Impl ;
    public final void rule__CheckRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3107:1: ( rule__CheckRecipe__Group__8__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3108:2: rule__CheckRecipe__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__8__Impl_in_rule__CheckRecipe__Group__86128);
            rule__CheckRecipe__Group__8__Impl();

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
    // $ANTLR end "rule__CheckRecipe__Group__8"


    // $ANTLR start "rule__CheckRecipe__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3114:1: rule__CheckRecipe__Group__8__Impl : ( '}' ) ;
    public final void rule__CheckRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3118:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3119:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3119:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3120:1: '}'
            {
             before(grammarAccess.getCheckRecipeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__CheckRecipe__Group__8__Impl6156); 
             after(grammarAccess.getCheckRecipeAccess().getRightCurlyBracketKeyword_8()); 

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
    // $ANTLR end "rule__CheckRecipe__Group__8__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3151:1: rule__TrimmerRecipe__Group__0 : rule__TrimmerRecipe__Group__0__Impl rule__TrimmerRecipe__Group__1 ;
    public final void rule__TrimmerRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3155:1: ( rule__TrimmerRecipe__Group__0__Impl rule__TrimmerRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3156:2: rule__TrimmerRecipe__Group__0__Impl rule__TrimmerRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__0__Impl_in_rule__TrimmerRecipe__Group__06205);
            rule__TrimmerRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__1_in_rule__TrimmerRecipe__Group__06208);
            rule__TrimmerRecipe__Group__1();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__0"


    // $ANTLR start "rule__TrimmerRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3163:1: rule__TrimmerRecipe__Group__0__Impl : ( 'Trimmer' ) ;
    public final void rule__TrimmerRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3167:1: ( ( 'Trimmer' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3168:1: ( 'Trimmer' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3168:1: ( 'Trimmer' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3169:1: 'Trimmer'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getTrimmerKeyword_0()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TrimmerRecipe__Group__0__Impl6236); 
             after(grammarAccess.getTrimmerRecipeAccess().getTrimmerKeyword_0()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__0__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3182:1: rule__TrimmerRecipe__Group__1 : rule__TrimmerRecipe__Group__1__Impl rule__TrimmerRecipe__Group__2 ;
    public final void rule__TrimmerRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3186:1: ( rule__TrimmerRecipe__Group__1__Impl rule__TrimmerRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3187:2: rule__TrimmerRecipe__Group__1__Impl rule__TrimmerRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__1__Impl_in_rule__TrimmerRecipe__Group__16267);
            rule__TrimmerRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__2_in_rule__TrimmerRecipe__Group__16270);
            rule__TrimmerRecipe__Group__2();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__1"


    // $ANTLR start "rule__TrimmerRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3194:1: rule__TrimmerRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__TrimmerRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3198:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3199:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3199:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3200:1: '{'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__TrimmerRecipe__Group__1__Impl6298); 
             after(grammarAccess.getTrimmerRecipeAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__1__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3213:1: rule__TrimmerRecipe__Group__2 : rule__TrimmerRecipe__Group__2__Impl rule__TrimmerRecipe__Group__3 ;
    public final void rule__TrimmerRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3217:1: ( rule__TrimmerRecipe__Group__2__Impl rule__TrimmerRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3218:2: rule__TrimmerRecipe__Group__2__Impl rule__TrimmerRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__2__Impl_in_rule__TrimmerRecipe__Group__26329);
            rule__TrimmerRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__3_in_rule__TrimmerRecipe__Group__26332);
            rule__TrimmerRecipe__Group__3();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__2"


    // $ANTLR start "rule__TrimmerRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3225:1: rule__TrimmerRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__TrimmerRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3229:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3230:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3230:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3231:1: 'traceInfo'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__TrimmerRecipe__Group__2__Impl6360); 
             after(grammarAccess.getTrimmerRecipeAccess().getTraceInfoKeyword_2()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__2__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3244:1: rule__TrimmerRecipe__Group__3 : rule__TrimmerRecipe__Group__3__Impl rule__TrimmerRecipe__Group__4 ;
    public final void rule__TrimmerRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3248:1: ( rule__TrimmerRecipe__Group__3__Impl rule__TrimmerRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3249:2: rule__TrimmerRecipe__Group__3__Impl rule__TrimmerRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__3__Impl_in_rule__TrimmerRecipe__Group__36391);
            rule__TrimmerRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__4_in_rule__TrimmerRecipe__Group__36394);
            rule__TrimmerRecipe__Group__4();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__3"


    // $ANTLR start "rule__TrimmerRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3256:1: rule__TrimmerRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__TrimmerRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3260:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3261:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3261:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3262:1: ':'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__TrimmerRecipe__Group__3__Impl6422); 
             after(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_3()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__3__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3275:1: rule__TrimmerRecipe__Group__4 : rule__TrimmerRecipe__Group__4__Impl rule__TrimmerRecipe__Group__5 ;
    public final void rule__TrimmerRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3279:1: ( rule__TrimmerRecipe__Group__4__Impl rule__TrimmerRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3280:2: rule__TrimmerRecipe__Group__4__Impl rule__TrimmerRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__4__Impl_in_rule__TrimmerRecipe__Group__46453);
            rule__TrimmerRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__5_in_rule__TrimmerRecipe__Group__46456);
            rule__TrimmerRecipe__Group__5();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__4"


    // $ANTLR start "rule__TrimmerRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3287:1: rule__TrimmerRecipe__Group__4__Impl : ( ( rule__TrimmerRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__TrimmerRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3291:1: ( ( ( rule__TrimmerRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3292:1: ( ( rule__TrimmerRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3292:1: ( ( rule__TrimmerRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3293:1: ( rule__TrimmerRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3294:1: ( rule__TrimmerRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3294:2: rule__TrimmerRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__TraceInfoAssignment_4_in_rule__TrimmerRecipe__Group__4__Impl6483);
            rule__TrimmerRecipe__TraceInfoAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTrimmerRecipeAccess().getTraceInfoAssignment_4()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__4__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3304:1: rule__TrimmerRecipe__Group__5 : rule__TrimmerRecipe__Group__5__Impl rule__TrimmerRecipe__Group__6 ;
    public final void rule__TrimmerRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3308:1: ( rule__TrimmerRecipe__Group__5__Impl rule__TrimmerRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3309:2: rule__TrimmerRecipe__Group__5__Impl rule__TrimmerRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__5__Impl_in_rule__TrimmerRecipe__Group__56513);
            rule__TrimmerRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__6_in_rule__TrimmerRecipe__Group__56516);
            rule__TrimmerRecipe__Group__6();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__5"


    // $ANTLR start "rule__TrimmerRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3316:1: rule__TrimmerRecipe__Group__5__Impl : ( 'mask' ) ;
    public final void rule__TrimmerRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3320:1: ( ( 'mask' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3321:1: ( 'mask' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3321:1: ( 'mask' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3322:1: 'mask'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getMaskKeyword_5()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__TrimmerRecipe__Group__5__Impl6544); 
             after(grammarAccess.getTrimmerRecipeAccess().getMaskKeyword_5()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__5__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3335:1: rule__TrimmerRecipe__Group__6 : rule__TrimmerRecipe__Group__6__Impl rule__TrimmerRecipe__Group__7 ;
    public final void rule__TrimmerRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3339:1: ( rule__TrimmerRecipe__Group__6__Impl rule__TrimmerRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3340:2: rule__TrimmerRecipe__Group__6__Impl rule__TrimmerRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__6__Impl_in_rule__TrimmerRecipe__Group__66575);
            rule__TrimmerRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__7_in_rule__TrimmerRecipe__Group__66578);
            rule__TrimmerRecipe__Group__7();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__6"


    // $ANTLR start "rule__TrimmerRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3347:1: rule__TrimmerRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__TrimmerRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3351:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3352:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3352:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3353:1: ':'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__TrimmerRecipe__Group__6__Impl6606); 
             after(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_6()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__6__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3366:1: rule__TrimmerRecipe__Group__7 : rule__TrimmerRecipe__Group__7__Impl rule__TrimmerRecipe__Group__8 ;
    public final void rule__TrimmerRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3370:1: ( rule__TrimmerRecipe__Group__7__Impl rule__TrimmerRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3371:2: rule__TrimmerRecipe__Group__7__Impl rule__TrimmerRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__7__Impl_in_rule__TrimmerRecipe__Group__76637);
            rule__TrimmerRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__8_in_rule__TrimmerRecipe__Group__76640);
            rule__TrimmerRecipe__Group__8();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__7"


    // $ANTLR start "rule__TrimmerRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3378:1: rule__TrimmerRecipe__Group__7__Impl : ( ( rule__TrimmerRecipe__MaskAssignment_7 ) ) ;
    public final void rule__TrimmerRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3382:1: ( ( ( rule__TrimmerRecipe__MaskAssignment_7 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3383:1: ( ( rule__TrimmerRecipe__MaskAssignment_7 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3383:1: ( ( rule__TrimmerRecipe__MaskAssignment_7 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3384:1: ( rule__TrimmerRecipe__MaskAssignment_7 )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getMaskAssignment_7()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3385:1: ( rule__TrimmerRecipe__MaskAssignment_7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3385:2: rule__TrimmerRecipe__MaskAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__MaskAssignment_7_in_rule__TrimmerRecipe__Group__7__Impl6667);
            rule__TrimmerRecipe__MaskAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getTrimmerRecipeAccess().getMaskAssignment_7()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__7__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3395:1: rule__TrimmerRecipe__Group__8 : rule__TrimmerRecipe__Group__8__Impl rule__TrimmerRecipe__Group__9 ;
    public final void rule__TrimmerRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3399:1: ( rule__TrimmerRecipe__Group__8__Impl rule__TrimmerRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3400:2: rule__TrimmerRecipe__Group__8__Impl rule__TrimmerRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__8__Impl_in_rule__TrimmerRecipe__Group__86697);
            rule__TrimmerRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__9_in_rule__TrimmerRecipe__Group__86700);
            rule__TrimmerRecipe__Group__9();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__8"


    // $ANTLR start "rule__TrimmerRecipe__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3407:1: rule__TrimmerRecipe__Group__8__Impl : ( 'parent' ) ;
    public final void rule__TrimmerRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3411:1: ( ( 'parent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3412:1: ( 'parent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3412:1: ( 'parent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3413:1: 'parent'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getParentKeyword_8()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__TrimmerRecipe__Group__8__Impl6728); 
             after(grammarAccess.getTrimmerRecipeAccess().getParentKeyword_8()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__8__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3426:1: rule__TrimmerRecipe__Group__9 : rule__TrimmerRecipe__Group__9__Impl rule__TrimmerRecipe__Group__10 ;
    public final void rule__TrimmerRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3430:1: ( rule__TrimmerRecipe__Group__9__Impl rule__TrimmerRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3431:2: rule__TrimmerRecipe__Group__9__Impl rule__TrimmerRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__9__Impl_in_rule__TrimmerRecipe__Group__96759);
            rule__TrimmerRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__10_in_rule__TrimmerRecipe__Group__96762);
            rule__TrimmerRecipe__Group__10();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__9"


    // $ANTLR start "rule__TrimmerRecipe__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3438:1: rule__TrimmerRecipe__Group__9__Impl : ( ':' ) ;
    public final void rule__TrimmerRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3442:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3443:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3443:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3444:1: ':'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_9()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__TrimmerRecipe__Group__9__Impl6790); 
             after(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_9()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__9__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3457:1: rule__TrimmerRecipe__Group__10 : rule__TrimmerRecipe__Group__10__Impl rule__TrimmerRecipe__Group__11 ;
    public final void rule__TrimmerRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3461:1: ( rule__TrimmerRecipe__Group__10__Impl rule__TrimmerRecipe__Group__11 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3462:2: rule__TrimmerRecipe__Group__10__Impl rule__TrimmerRecipe__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__10__Impl_in_rule__TrimmerRecipe__Group__106821);
            rule__TrimmerRecipe__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__11_in_rule__TrimmerRecipe__Group__106824);
            rule__TrimmerRecipe__Group__11();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__10"


    // $ANTLR start "rule__TrimmerRecipe__Group__10__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3469:1: rule__TrimmerRecipe__Group__10__Impl : ( ( rule__TrimmerRecipe__ParentAssignment_10 ) ) ;
    public final void rule__TrimmerRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3473:1: ( ( ( rule__TrimmerRecipe__ParentAssignment_10 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3474:1: ( ( rule__TrimmerRecipe__ParentAssignment_10 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3474:1: ( ( rule__TrimmerRecipe__ParentAssignment_10 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3475:1: ( rule__TrimmerRecipe__ParentAssignment_10 )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getParentAssignment_10()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3476:1: ( rule__TrimmerRecipe__ParentAssignment_10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3476:2: rule__TrimmerRecipe__ParentAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__ParentAssignment_10_in_rule__TrimmerRecipe__Group__10__Impl6851);
            rule__TrimmerRecipe__ParentAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getTrimmerRecipeAccess().getParentAssignment_10()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__10__Impl"


    // $ANTLR start "rule__TrimmerRecipe__Group__11"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3486:1: rule__TrimmerRecipe__Group__11 : rule__TrimmerRecipe__Group__11__Impl ;
    public final void rule__TrimmerRecipe__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3490:1: ( rule__TrimmerRecipe__Group__11__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3491:2: rule__TrimmerRecipe__Group__11__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__11__Impl_in_rule__TrimmerRecipe__Group__116881);
            rule__TrimmerRecipe__Group__11__Impl();

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
    // $ANTLR end "rule__TrimmerRecipe__Group__11"


    // $ANTLR start "rule__TrimmerRecipe__Group__11__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3497:1: rule__TrimmerRecipe__Group__11__Impl : ( '}' ) ;
    public final void rule__TrimmerRecipe__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3501:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3502:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3502:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3503:1: '}'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getRightCurlyBracketKeyword_11()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__TrimmerRecipe__Group__11__Impl6909); 
             after(grammarAccess.getTrimmerRecipeAccess().getRightCurlyBracketKeyword_11()); 

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
    // $ANTLR end "rule__TrimmerRecipe__Group__11__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3540:1: rule__JoinRecipe__Group__0 : rule__JoinRecipe__Group__0__Impl rule__JoinRecipe__Group__1 ;
    public final void rule__JoinRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3544:1: ( rule__JoinRecipe__Group__0__Impl rule__JoinRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3545:2: rule__JoinRecipe__Group__0__Impl rule__JoinRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__0__Impl_in_rule__JoinRecipe__Group__06964);
            rule__JoinRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__1_in_rule__JoinRecipe__Group__06967);
            rule__JoinRecipe__Group__1();

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
    // $ANTLR end "rule__JoinRecipe__Group__0"


    // $ANTLR start "rule__JoinRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3552:1: rule__JoinRecipe__Group__0__Impl : ( 'Join' ) ;
    public final void rule__JoinRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3556:1: ( ( 'Join' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3557:1: ( 'Join' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3557:1: ( 'Join' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3558:1: 'Join'
            {
             before(grammarAccess.getJoinRecipeAccess().getJoinKeyword_0()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__JoinRecipe__Group__0__Impl6995); 
             after(grammarAccess.getJoinRecipeAccess().getJoinKeyword_0()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__0__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3571:1: rule__JoinRecipe__Group__1 : rule__JoinRecipe__Group__1__Impl rule__JoinRecipe__Group__2 ;
    public final void rule__JoinRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3575:1: ( rule__JoinRecipe__Group__1__Impl rule__JoinRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3576:2: rule__JoinRecipe__Group__1__Impl rule__JoinRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__1__Impl_in_rule__JoinRecipe__Group__17026);
            rule__JoinRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__2_in_rule__JoinRecipe__Group__17029);
            rule__JoinRecipe__Group__2();

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
    // $ANTLR end "rule__JoinRecipe__Group__1"


    // $ANTLR start "rule__JoinRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3583:1: rule__JoinRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__JoinRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3587:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3588:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3588:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3589:1: '{'
            {
             before(grammarAccess.getJoinRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__JoinRecipe__Group__1__Impl7057); 
             after(grammarAccess.getJoinRecipeAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__1__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3602:1: rule__JoinRecipe__Group__2 : rule__JoinRecipe__Group__2__Impl rule__JoinRecipe__Group__3 ;
    public final void rule__JoinRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3606:1: ( rule__JoinRecipe__Group__2__Impl rule__JoinRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3607:2: rule__JoinRecipe__Group__2__Impl rule__JoinRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__2__Impl_in_rule__JoinRecipe__Group__27088);
            rule__JoinRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__3_in_rule__JoinRecipe__Group__27091);
            rule__JoinRecipe__Group__3();

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
    // $ANTLR end "rule__JoinRecipe__Group__2"


    // $ANTLR start "rule__JoinRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3614:1: rule__JoinRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__JoinRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3618:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3619:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3619:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3620:1: 'traceInfo'
            {
             before(grammarAccess.getJoinRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__JoinRecipe__Group__2__Impl7119); 
             after(grammarAccess.getJoinRecipeAccess().getTraceInfoKeyword_2()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__2__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3633:1: rule__JoinRecipe__Group__3 : rule__JoinRecipe__Group__3__Impl rule__JoinRecipe__Group__4 ;
    public final void rule__JoinRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3637:1: ( rule__JoinRecipe__Group__3__Impl rule__JoinRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3638:2: rule__JoinRecipe__Group__3__Impl rule__JoinRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__3__Impl_in_rule__JoinRecipe__Group__37150);
            rule__JoinRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__4_in_rule__JoinRecipe__Group__37153);
            rule__JoinRecipe__Group__4();

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
    // $ANTLR end "rule__JoinRecipe__Group__3"


    // $ANTLR start "rule__JoinRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3645:1: rule__JoinRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__JoinRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3649:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3650:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3650:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3651:1: ':'
            {
             before(grammarAccess.getJoinRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__JoinRecipe__Group__3__Impl7181); 
             after(grammarAccess.getJoinRecipeAccess().getColonKeyword_3()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__3__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3664:1: rule__JoinRecipe__Group__4 : rule__JoinRecipe__Group__4__Impl rule__JoinRecipe__Group__5 ;
    public final void rule__JoinRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3668:1: ( rule__JoinRecipe__Group__4__Impl rule__JoinRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3669:2: rule__JoinRecipe__Group__4__Impl rule__JoinRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__4__Impl_in_rule__JoinRecipe__Group__47212);
            rule__JoinRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__5_in_rule__JoinRecipe__Group__47215);
            rule__JoinRecipe__Group__5();

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
    // $ANTLR end "rule__JoinRecipe__Group__4"


    // $ANTLR start "rule__JoinRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3676:1: rule__JoinRecipe__Group__4__Impl : ( ( rule__JoinRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__JoinRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3680:1: ( ( ( rule__JoinRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3681:1: ( ( rule__JoinRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3681:1: ( ( rule__JoinRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3682:1: ( rule__JoinRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getJoinRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3683:1: ( rule__JoinRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3683:2: rule__JoinRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__TraceInfoAssignment_4_in_rule__JoinRecipe__Group__4__Impl7242);
            rule__JoinRecipe__TraceInfoAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getJoinRecipeAccess().getTraceInfoAssignment_4()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__4__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3693:1: rule__JoinRecipe__Group__5 : rule__JoinRecipe__Group__5__Impl rule__JoinRecipe__Group__6 ;
    public final void rule__JoinRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3697:1: ( rule__JoinRecipe__Group__5__Impl rule__JoinRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3698:2: rule__JoinRecipe__Group__5__Impl rule__JoinRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__5__Impl_in_rule__JoinRecipe__Group__57272);
            rule__JoinRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__6_in_rule__JoinRecipe__Group__57275);
            rule__JoinRecipe__Group__6();

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
    // $ANTLR end "rule__JoinRecipe__Group__5"


    // $ANTLR start "rule__JoinRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3705:1: rule__JoinRecipe__Group__5__Impl : ( 'leftParent' ) ;
    public final void rule__JoinRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3709:1: ( ( 'leftParent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3710:1: ( 'leftParent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3710:1: ( 'leftParent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3711:1: 'leftParent'
            {
             before(grammarAccess.getJoinRecipeAccess().getLeftParentKeyword_5()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__JoinRecipe__Group__5__Impl7303); 
             after(grammarAccess.getJoinRecipeAccess().getLeftParentKeyword_5()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__5__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3724:1: rule__JoinRecipe__Group__6 : rule__JoinRecipe__Group__6__Impl rule__JoinRecipe__Group__7 ;
    public final void rule__JoinRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3728:1: ( rule__JoinRecipe__Group__6__Impl rule__JoinRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3729:2: rule__JoinRecipe__Group__6__Impl rule__JoinRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__6__Impl_in_rule__JoinRecipe__Group__67334);
            rule__JoinRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__7_in_rule__JoinRecipe__Group__67337);
            rule__JoinRecipe__Group__7();

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
    // $ANTLR end "rule__JoinRecipe__Group__6"


    // $ANTLR start "rule__JoinRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3736:1: rule__JoinRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__JoinRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3740:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3741:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3741:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3742:1: ':'
            {
             before(grammarAccess.getJoinRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__JoinRecipe__Group__6__Impl7365); 
             after(grammarAccess.getJoinRecipeAccess().getColonKeyword_6()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__6__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3755:1: rule__JoinRecipe__Group__7 : rule__JoinRecipe__Group__7__Impl rule__JoinRecipe__Group__8 ;
    public final void rule__JoinRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3759:1: ( rule__JoinRecipe__Group__7__Impl rule__JoinRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3760:2: rule__JoinRecipe__Group__7__Impl rule__JoinRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__7__Impl_in_rule__JoinRecipe__Group__77396);
            rule__JoinRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__8_in_rule__JoinRecipe__Group__77399);
            rule__JoinRecipe__Group__8();

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
    // $ANTLR end "rule__JoinRecipe__Group__7"


    // $ANTLR start "rule__JoinRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3767:1: rule__JoinRecipe__Group__7__Impl : ( ( rule__JoinRecipe__LeftParentAssignment_7 ) ) ;
    public final void rule__JoinRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3771:1: ( ( ( rule__JoinRecipe__LeftParentAssignment_7 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3772:1: ( ( rule__JoinRecipe__LeftParentAssignment_7 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3772:1: ( ( rule__JoinRecipe__LeftParentAssignment_7 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3773:1: ( rule__JoinRecipe__LeftParentAssignment_7 )
            {
             before(grammarAccess.getJoinRecipeAccess().getLeftParentAssignment_7()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3774:1: ( rule__JoinRecipe__LeftParentAssignment_7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3774:2: rule__JoinRecipe__LeftParentAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__LeftParentAssignment_7_in_rule__JoinRecipe__Group__7__Impl7426);
            rule__JoinRecipe__LeftParentAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getJoinRecipeAccess().getLeftParentAssignment_7()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__7__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3784:1: rule__JoinRecipe__Group__8 : rule__JoinRecipe__Group__8__Impl rule__JoinRecipe__Group__9 ;
    public final void rule__JoinRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3788:1: ( rule__JoinRecipe__Group__8__Impl rule__JoinRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3789:2: rule__JoinRecipe__Group__8__Impl rule__JoinRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__8__Impl_in_rule__JoinRecipe__Group__87456);
            rule__JoinRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__9_in_rule__JoinRecipe__Group__87459);
            rule__JoinRecipe__Group__9();

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
    // $ANTLR end "rule__JoinRecipe__Group__8"


    // $ANTLR start "rule__JoinRecipe__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3796:1: rule__JoinRecipe__Group__8__Impl : ( 'rightParent' ) ;
    public final void rule__JoinRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3800:1: ( ( 'rightParent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3801:1: ( 'rightParent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3801:1: ( 'rightParent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3802:1: 'rightParent'
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentKeyword_8()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__JoinRecipe__Group__8__Impl7487); 
             after(grammarAccess.getJoinRecipeAccess().getRightParentKeyword_8()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__8__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3815:1: rule__JoinRecipe__Group__9 : rule__JoinRecipe__Group__9__Impl rule__JoinRecipe__Group__10 ;
    public final void rule__JoinRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3819:1: ( rule__JoinRecipe__Group__9__Impl rule__JoinRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3820:2: rule__JoinRecipe__Group__9__Impl rule__JoinRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__9__Impl_in_rule__JoinRecipe__Group__97518);
            rule__JoinRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__10_in_rule__JoinRecipe__Group__97521);
            rule__JoinRecipe__Group__10();

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
    // $ANTLR end "rule__JoinRecipe__Group__9"


    // $ANTLR start "rule__JoinRecipe__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3827:1: rule__JoinRecipe__Group__9__Impl : ( ':' ) ;
    public final void rule__JoinRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3831:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3832:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3832:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3833:1: ':'
            {
             before(grammarAccess.getJoinRecipeAccess().getColonKeyword_9()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__JoinRecipe__Group__9__Impl7549); 
             after(grammarAccess.getJoinRecipeAccess().getColonKeyword_9()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__9__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3846:1: rule__JoinRecipe__Group__10 : rule__JoinRecipe__Group__10__Impl rule__JoinRecipe__Group__11 ;
    public final void rule__JoinRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3850:1: ( rule__JoinRecipe__Group__10__Impl rule__JoinRecipe__Group__11 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3851:2: rule__JoinRecipe__Group__10__Impl rule__JoinRecipe__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__10__Impl_in_rule__JoinRecipe__Group__107580);
            rule__JoinRecipe__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__11_in_rule__JoinRecipe__Group__107583);
            rule__JoinRecipe__Group__11();

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
    // $ANTLR end "rule__JoinRecipe__Group__10"


    // $ANTLR start "rule__JoinRecipe__Group__10__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3858:1: rule__JoinRecipe__Group__10__Impl : ( ( rule__JoinRecipe__RightParentAssignment_10 ) ) ;
    public final void rule__JoinRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3862:1: ( ( ( rule__JoinRecipe__RightParentAssignment_10 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3863:1: ( ( rule__JoinRecipe__RightParentAssignment_10 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3863:1: ( ( rule__JoinRecipe__RightParentAssignment_10 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3864:1: ( rule__JoinRecipe__RightParentAssignment_10 )
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentAssignment_10()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3865:1: ( rule__JoinRecipe__RightParentAssignment_10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3865:2: rule__JoinRecipe__RightParentAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__RightParentAssignment_10_in_rule__JoinRecipe__Group__10__Impl7610);
            rule__JoinRecipe__RightParentAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getJoinRecipeAccess().getRightParentAssignment_10()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__10__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__11"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3875:1: rule__JoinRecipe__Group__11 : rule__JoinRecipe__Group__11__Impl rule__JoinRecipe__Group__12 ;
    public final void rule__JoinRecipe__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3879:1: ( rule__JoinRecipe__Group__11__Impl rule__JoinRecipe__Group__12 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3880:2: rule__JoinRecipe__Group__11__Impl rule__JoinRecipe__Group__12
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__11__Impl_in_rule__JoinRecipe__Group__117640);
            rule__JoinRecipe__Group__11__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__12_in_rule__JoinRecipe__Group__117643);
            rule__JoinRecipe__Group__12();

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
    // $ANTLR end "rule__JoinRecipe__Group__11"


    // $ANTLR start "rule__JoinRecipe__Group__11__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3887:1: rule__JoinRecipe__Group__11__Impl : ( ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )? ) ;
    public final void rule__JoinRecipe__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3891:1: ( ( ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )? ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3892:1: ( ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )? )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3892:1: ( ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )? )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3893:1: ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )?
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentComplementaryMaskAssignment_11()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3894:1: ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3894:2: rule__JoinRecipe__RightParentComplementaryMaskAssignment_11
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__RightParentComplementaryMaskAssignment_11_in_rule__JoinRecipe__Group__11__Impl7670);
                    rule__JoinRecipe__RightParentComplementaryMaskAssignment_11();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getJoinRecipeAccess().getRightParentComplementaryMaskAssignment_11()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__11__Impl"


    // $ANTLR start "rule__JoinRecipe__Group__12"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3904:1: rule__JoinRecipe__Group__12 : rule__JoinRecipe__Group__12__Impl ;
    public final void rule__JoinRecipe__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3908:1: ( rule__JoinRecipe__Group__12__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3909:2: rule__JoinRecipe__Group__12__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__12__Impl_in_rule__JoinRecipe__Group__127701);
            rule__JoinRecipe__Group__12__Impl();

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
    // $ANTLR end "rule__JoinRecipe__Group__12"


    // $ANTLR start "rule__JoinRecipe__Group__12__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3915:1: rule__JoinRecipe__Group__12__Impl : ( '}' ) ;
    public final void rule__JoinRecipe__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3919:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3920:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3920:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3921:1: '}'
            {
             before(grammarAccess.getJoinRecipeAccess().getRightCurlyBracketKeyword_12()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__JoinRecipe__Group__12__Impl7729); 
             after(grammarAccess.getJoinRecipeAccess().getRightCurlyBracketKeyword_12()); 

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
    // $ANTLR end "rule__JoinRecipe__Group__12__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3960:1: rule__AntiJoinRecipe__Group__0 : rule__AntiJoinRecipe__Group__0__Impl rule__AntiJoinRecipe__Group__1 ;
    public final void rule__AntiJoinRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3964:1: ( rule__AntiJoinRecipe__Group__0__Impl rule__AntiJoinRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3965:2: rule__AntiJoinRecipe__Group__0__Impl rule__AntiJoinRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__0__Impl_in_rule__AntiJoinRecipe__Group__07786);
            rule__AntiJoinRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__1_in_rule__AntiJoinRecipe__Group__07789);
            rule__AntiJoinRecipe__Group__1();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__0"


    // $ANTLR start "rule__AntiJoinRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3972:1: rule__AntiJoinRecipe__Group__0__Impl : ( 'AntiJoin' ) ;
    public final void rule__AntiJoinRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3976:1: ( ( 'AntiJoin' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3977:1: ( 'AntiJoin' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3977:1: ( 'AntiJoin' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3978:1: 'AntiJoin'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getAntiJoinKeyword_0()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__AntiJoinRecipe__Group__0__Impl7817); 
             after(grammarAccess.getAntiJoinRecipeAccess().getAntiJoinKeyword_0()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__0__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3991:1: rule__AntiJoinRecipe__Group__1 : rule__AntiJoinRecipe__Group__1__Impl rule__AntiJoinRecipe__Group__2 ;
    public final void rule__AntiJoinRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3995:1: ( rule__AntiJoinRecipe__Group__1__Impl rule__AntiJoinRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3996:2: rule__AntiJoinRecipe__Group__1__Impl rule__AntiJoinRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__1__Impl_in_rule__AntiJoinRecipe__Group__17848);
            rule__AntiJoinRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__2_in_rule__AntiJoinRecipe__Group__17851);
            rule__AntiJoinRecipe__Group__2();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__1"


    // $ANTLR start "rule__AntiJoinRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4003:1: rule__AntiJoinRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__AntiJoinRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4007:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4008:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4008:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4009:1: '{'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__AntiJoinRecipe__Group__1__Impl7879); 
             after(grammarAccess.getAntiJoinRecipeAccess().getLeftCurlyBracketKeyword_1()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__1__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4022:1: rule__AntiJoinRecipe__Group__2 : rule__AntiJoinRecipe__Group__2__Impl rule__AntiJoinRecipe__Group__3 ;
    public final void rule__AntiJoinRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4026:1: ( rule__AntiJoinRecipe__Group__2__Impl rule__AntiJoinRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4027:2: rule__AntiJoinRecipe__Group__2__Impl rule__AntiJoinRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__2__Impl_in_rule__AntiJoinRecipe__Group__27910);
            rule__AntiJoinRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__3_in_rule__AntiJoinRecipe__Group__27913);
            rule__AntiJoinRecipe__Group__3();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__2"


    // $ANTLR start "rule__AntiJoinRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4034:1: rule__AntiJoinRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__AntiJoinRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4038:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4039:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4039:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4040:1: 'traceInfo'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__AntiJoinRecipe__Group__2__Impl7941); 
             after(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoKeyword_2()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__2__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4053:1: rule__AntiJoinRecipe__Group__3 : rule__AntiJoinRecipe__Group__3__Impl rule__AntiJoinRecipe__Group__4 ;
    public final void rule__AntiJoinRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4057:1: ( rule__AntiJoinRecipe__Group__3__Impl rule__AntiJoinRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4058:2: rule__AntiJoinRecipe__Group__3__Impl rule__AntiJoinRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__3__Impl_in_rule__AntiJoinRecipe__Group__37972);
            rule__AntiJoinRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__4_in_rule__AntiJoinRecipe__Group__37975);
            rule__AntiJoinRecipe__Group__4();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__3"


    // $ANTLR start "rule__AntiJoinRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4065:1: rule__AntiJoinRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__AntiJoinRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4069:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4070:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4070:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4071:1: ':'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__AntiJoinRecipe__Group__3__Impl8003); 
             after(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_3()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__3__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4084:1: rule__AntiJoinRecipe__Group__4 : rule__AntiJoinRecipe__Group__4__Impl rule__AntiJoinRecipe__Group__5 ;
    public final void rule__AntiJoinRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4088:1: ( rule__AntiJoinRecipe__Group__4__Impl rule__AntiJoinRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4089:2: rule__AntiJoinRecipe__Group__4__Impl rule__AntiJoinRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__4__Impl_in_rule__AntiJoinRecipe__Group__48034);
            rule__AntiJoinRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__5_in_rule__AntiJoinRecipe__Group__48037);
            rule__AntiJoinRecipe__Group__5();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__4"


    // $ANTLR start "rule__AntiJoinRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4096:1: rule__AntiJoinRecipe__Group__4__Impl : ( ( rule__AntiJoinRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__AntiJoinRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4100:1: ( ( ( rule__AntiJoinRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4101:1: ( ( rule__AntiJoinRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4101:1: ( ( rule__AntiJoinRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4102:1: ( rule__AntiJoinRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4103:1: ( rule__AntiJoinRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4103:2: rule__AntiJoinRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__TraceInfoAssignment_4_in_rule__AntiJoinRecipe__Group__4__Impl8064);
            rule__AntiJoinRecipe__TraceInfoAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoAssignment_4()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__4__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4113:1: rule__AntiJoinRecipe__Group__5 : rule__AntiJoinRecipe__Group__5__Impl rule__AntiJoinRecipe__Group__6 ;
    public final void rule__AntiJoinRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4117:1: ( rule__AntiJoinRecipe__Group__5__Impl rule__AntiJoinRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4118:2: rule__AntiJoinRecipe__Group__5__Impl rule__AntiJoinRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__5__Impl_in_rule__AntiJoinRecipe__Group__58094);
            rule__AntiJoinRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__6_in_rule__AntiJoinRecipe__Group__58097);
            rule__AntiJoinRecipe__Group__6();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__5"


    // $ANTLR start "rule__AntiJoinRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4125:1: rule__AntiJoinRecipe__Group__5__Impl : ( 'leftParent' ) ;
    public final void rule__AntiJoinRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4129:1: ( ( 'leftParent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4130:1: ( 'leftParent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4130:1: ( 'leftParent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4131:1: 'leftParent'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getLeftParentKeyword_5()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__AntiJoinRecipe__Group__5__Impl8125); 
             after(grammarAccess.getAntiJoinRecipeAccess().getLeftParentKeyword_5()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__5__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4144:1: rule__AntiJoinRecipe__Group__6 : rule__AntiJoinRecipe__Group__6__Impl rule__AntiJoinRecipe__Group__7 ;
    public final void rule__AntiJoinRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4148:1: ( rule__AntiJoinRecipe__Group__6__Impl rule__AntiJoinRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4149:2: rule__AntiJoinRecipe__Group__6__Impl rule__AntiJoinRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__6__Impl_in_rule__AntiJoinRecipe__Group__68156);
            rule__AntiJoinRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__7_in_rule__AntiJoinRecipe__Group__68159);
            rule__AntiJoinRecipe__Group__7();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__6"


    // $ANTLR start "rule__AntiJoinRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4156:1: rule__AntiJoinRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__AntiJoinRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4160:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4161:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4161:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4162:1: ':'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__AntiJoinRecipe__Group__6__Impl8187); 
             after(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_6()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__6__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4175:1: rule__AntiJoinRecipe__Group__7 : rule__AntiJoinRecipe__Group__7__Impl rule__AntiJoinRecipe__Group__8 ;
    public final void rule__AntiJoinRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4179:1: ( rule__AntiJoinRecipe__Group__7__Impl rule__AntiJoinRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4180:2: rule__AntiJoinRecipe__Group__7__Impl rule__AntiJoinRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__7__Impl_in_rule__AntiJoinRecipe__Group__78218);
            rule__AntiJoinRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__8_in_rule__AntiJoinRecipe__Group__78221);
            rule__AntiJoinRecipe__Group__8();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__7"


    // $ANTLR start "rule__AntiJoinRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4187:1: rule__AntiJoinRecipe__Group__7__Impl : ( ( rule__AntiJoinRecipe__LeftParentAssignment_7 ) ) ;
    public final void rule__AntiJoinRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4191:1: ( ( ( rule__AntiJoinRecipe__LeftParentAssignment_7 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4192:1: ( ( rule__AntiJoinRecipe__LeftParentAssignment_7 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4192:1: ( ( rule__AntiJoinRecipe__LeftParentAssignment_7 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4193:1: ( rule__AntiJoinRecipe__LeftParentAssignment_7 )
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getLeftParentAssignment_7()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4194:1: ( rule__AntiJoinRecipe__LeftParentAssignment_7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4194:2: rule__AntiJoinRecipe__LeftParentAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__LeftParentAssignment_7_in_rule__AntiJoinRecipe__Group__7__Impl8248);
            rule__AntiJoinRecipe__LeftParentAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAntiJoinRecipeAccess().getLeftParentAssignment_7()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__7__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4204:1: rule__AntiJoinRecipe__Group__8 : rule__AntiJoinRecipe__Group__8__Impl rule__AntiJoinRecipe__Group__9 ;
    public final void rule__AntiJoinRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4208:1: ( rule__AntiJoinRecipe__Group__8__Impl rule__AntiJoinRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4209:2: rule__AntiJoinRecipe__Group__8__Impl rule__AntiJoinRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__8__Impl_in_rule__AntiJoinRecipe__Group__88278);
            rule__AntiJoinRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__9_in_rule__AntiJoinRecipe__Group__88281);
            rule__AntiJoinRecipe__Group__9();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__8"


    // $ANTLR start "rule__AntiJoinRecipe__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4216:1: rule__AntiJoinRecipe__Group__8__Impl : ( 'rightParent' ) ;
    public final void rule__AntiJoinRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4220:1: ( ( 'rightParent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4221:1: ( 'rightParent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4221:1: ( 'rightParent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4222:1: 'rightParent'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getRightParentKeyword_8()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__AntiJoinRecipe__Group__8__Impl8309); 
             after(grammarAccess.getAntiJoinRecipeAccess().getRightParentKeyword_8()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__8__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4235:1: rule__AntiJoinRecipe__Group__9 : rule__AntiJoinRecipe__Group__9__Impl rule__AntiJoinRecipe__Group__10 ;
    public final void rule__AntiJoinRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4239:1: ( rule__AntiJoinRecipe__Group__9__Impl rule__AntiJoinRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4240:2: rule__AntiJoinRecipe__Group__9__Impl rule__AntiJoinRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__9__Impl_in_rule__AntiJoinRecipe__Group__98340);
            rule__AntiJoinRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__10_in_rule__AntiJoinRecipe__Group__98343);
            rule__AntiJoinRecipe__Group__10();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__9"


    // $ANTLR start "rule__AntiJoinRecipe__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4247:1: rule__AntiJoinRecipe__Group__9__Impl : ( ':' ) ;
    public final void rule__AntiJoinRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4251:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4252:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4252:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4253:1: ':'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_9()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__AntiJoinRecipe__Group__9__Impl8371); 
             after(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_9()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__9__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4266:1: rule__AntiJoinRecipe__Group__10 : rule__AntiJoinRecipe__Group__10__Impl rule__AntiJoinRecipe__Group__11 ;
    public final void rule__AntiJoinRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4270:1: ( rule__AntiJoinRecipe__Group__10__Impl rule__AntiJoinRecipe__Group__11 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4271:2: rule__AntiJoinRecipe__Group__10__Impl rule__AntiJoinRecipe__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__10__Impl_in_rule__AntiJoinRecipe__Group__108402);
            rule__AntiJoinRecipe__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__11_in_rule__AntiJoinRecipe__Group__108405);
            rule__AntiJoinRecipe__Group__11();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__10"


    // $ANTLR start "rule__AntiJoinRecipe__Group__10__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4278:1: rule__AntiJoinRecipe__Group__10__Impl : ( ( rule__AntiJoinRecipe__RightParentAssignment_10 ) ) ;
    public final void rule__AntiJoinRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4282:1: ( ( ( rule__AntiJoinRecipe__RightParentAssignment_10 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4283:1: ( ( rule__AntiJoinRecipe__RightParentAssignment_10 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4283:1: ( ( rule__AntiJoinRecipe__RightParentAssignment_10 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4284:1: ( rule__AntiJoinRecipe__RightParentAssignment_10 )
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getRightParentAssignment_10()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4285:1: ( rule__AntiJoinRecipe__RightParentAssignment_10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4285:2: rule__AntiJoinRecipe__RightParentAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__RightParentAssignment_10_in_rule__AntiJoinRecipe__Group__10__Impl8432);
            rule__AntiJoinRecipe__RightParentAssignment_10();

            state._fsp--;


            }

             after(grammarAccess.getAntiJoinRecipeAccess().getRightParentAssignment_10()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__10__Impl"


    // $ANTLR start "rule__AntiJoinRecipe__Group__11"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4295:1: rule__AntiJoinRecipe__Group__11 : rule__AntiJoinRecipe__Group__11__Impl ;
    public final void rule__AntiJoinRecipe__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4299:1: ( rule__AntiJoinRecipe__Group__11__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4300:2: rule__AntiJoinRecipe__Group__11__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__11__Impl_in_rule__AntiJoinRecipe__Group__118462);
            rule__AntiJoinRecipe__Group__11__Impl();

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__11"


    // $ANTLR start "rule__AntiJoinRecipe__Group__11__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4306:1: rule__AntiJoinRecipe__Group__11__Impl : ( '}' ) ;
    public final void rule__AntiJoinRecipe__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4310:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4311:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4311:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4312:1: '}'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getRightCurlyBracketKeyword_11()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__AntiJoinRecipe__Group__11__Impl8490); 
             after(grammarAccess.getAntiJoinRecipeAccess().getRightCurlyBracketKeyword_11()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__Group__11__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4349:1: rule__IndexerRecipe__Group__0 : rule__IndexerRecipe__Group__0__Impl rule__IndexerRecipe__Group__1 ;
    public final void rule__IndexerRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4353:1: ( rule__IndexerRecipe__Group__0__Impl rule__IndexerRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4354:2: rule__IndexerRecipe__Group__0__Impl rule__IndexerRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__0__Impl_in_rule__IndexerRecipe__Group__08545);
            rule__IndexerRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__1_in_rule__IndexerRecipe__Group__08548);
            rule__IndexerRecipe__Group__1();

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
    // $ANTLR end "rule__IndexerRecipe__Group__0"


    // $ANTLR start "rule__IndexerRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4361:1: rule__IndexerRecipe__Group__0__Impl : ( '{' ) ;
    public final void rule__IndexerRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4365:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4366:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4366:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4367:1: '{'
            {
             before(grammarAccess.getIndexerRecipeAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__IndexerRecipe__Group__0__Impl8576); 
             after(grammarAccess.getIndexerRecipeAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__0__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4380:1: rule__IndexerRecipe__Group__1 : rule__IndexerRecipe__Group__1__Impl rule__IndexerRecipe__Group__2 ;
    public final void rule__IndexerRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4384:1: ( rule__IndexerRecipe__Group__1__Impl rule__IndexerRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4385:2: rule__IndexerRecipe__Group__1__Impl rule__IndexerRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__1__Impl_in_rule__IndexerRecipe__Group__18607);
            rule__IndexerRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__2_in_rule__IndexerRecipe__Group__18610);
            rule__IndexerRecipe__Group__2();

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
    // $ANTLR end "rule__IndexerRecipe__Group__1"


    // $ANTLR start "rule__IndexerRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4392:1: rule__IndexerRecipe__Group__1__Impl : ( 'traceInfo' ) ;
    public final void rule__IndexerRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4396:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4397:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4397:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4398:1: 'traceInfo'
            {
             before(grammarAccess.getIndexerRecipeAccess().getTraceInfoKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__IndexerRecipe__Group__1__Impl8638); 
             after(grammarAccess.getIndexerRecipeAccess().getTraceInfoKeyword_1()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__1__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4411:1: rule__IndexerRecipe__Group__2 : rule__IndexerRecipe__Group__2__Impl rule__IndexerRecipe__Group__3 ;
    public final void rule__IndexerRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4415:1: ( rule__IndexerRecipe__Group__2__Impl rule__IndexerRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4416:2: rule__IndexerRecipe__Group__2__Impl rule__IndexerRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__2__Impl_in_rule__IndexerRecipe__Group__28669);
            rule__IndexerRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__3_in_rule__IndexerRecipe__Group__28672);
            rule__IndexerRecipe__Group__3();

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
    // $ANTLR end "rule__IndexerRecipe__Group__2"


    // $ANTLR start "rule__IndexerRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4423:1: rule__IndexerRecipe__Group__2__Impl : ( ':' ) ;
    public final void rule__IndexerRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4427:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4428:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4428:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4429:1: ':'
            {
             before(grammarAccess.getIndexerRecipeAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__IndexerRecipe__Group__2__Impl8700); 
             after(grammarAccess.getIndexerRecipeAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__2__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4442:1: rule__IndexerRecipe__Group__3 : rule__IndexerRecipe__Group__3__Impl rule__IndexerRecipe__Group__4 ;
    public final void rule__IndexerRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4446:1: ( rule__IndexerRecipe__Group__3__Impl rule__IndexerRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4447:2: rule__IndexerRecipe__Group__3__Impl rule__IndexerRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__3__Impl_in_rule__IndexerRecipe__Group__38731);
            rule__IndexerRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__4_in_rule__IndexerRecipe__Group__38734);
            rule__IndexerRecipe__Group__4();

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
    // $ANTLR end "rule__IndexerRecipe__Group__3"


    // $ANTLR start "rule__IndexerRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4454:1: rule__IndexerRecipe__Group__3__Impl : ( ( rule__IndexerRecipe__TraceInfoAssignment_3 ) ) ;
    public final void rule__IndexerRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4458:1: ( ( ( rule__IndexerRecipe__TraceInfoAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4459:1: ( ( rule__IndexerRecipe__TraceInfoAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4459:1: ( ( rule__IndexerRecipe__TraceInfoAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4460:1: ( rule__IndexerRecipe__TraceInfoAssignment_3 )
            {
             before(grammarAccess.getIndexerRecipeAccess().getTraceInfoAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4461:1: ( rule__IndexerRecipe__TraceInfoAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4461:2: rule__IndexerRecipe__TraceInfoAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__TraceInfoAssignment_3_in_rule__IndexerRecipe__Group__3__Impl8761);
            rule__IndexerRecipe__TraceInfoAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIndexerRecipeAccess().getTraceInfoAssignment_3()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__3__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4471:1: rule__IndexerRecipe__Group__4 : rule__IndexerRecipe__Group__4__Impl rule__IndexerRecipe__Group__5 ;
    public final void rule__IndexerRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4475:1: ( rule__IndexerRecipe__Group__4__Impl rule__IndexerRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4476:2: rule__IndexerRecipe__Group__4__Impl rule__IndexerRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__4__Impl_in_rule__IndexerRecipe__Group__48791);
            rule__IndexerRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__5_in_rule__IndexerRecipe__Group__48794);
            rule__IndexerRecipe__Group__5();

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
    // $ANTLR end "rule__IndexerRecipe__Group__4"


    // $ANTLR start "rule__IndexerRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4483:1: rule__IndexerRecipe__Group__4__Impl : ( 'mask' ) ;
    public final void rule__IndexerRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4487:1: ( ( 'mask' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4488:1: ( 'mask' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4488:1: ( 'mask' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4489:1: 'mask'
            {
             before(grammarAccess.getIndexerRecipeAccess().getMaskKeyword_4()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__IndexerRecipe__Group__4__Impl8822); 
             after(grammarAccess.getIndexerRecipeAccess().getMaskKeyword_4()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__4__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4502:1: rule__IndexerRecipe__Group__5 : rule__IndexerRecipe__Group__5__Impl rule__IndexerRecipe__Group__6 ;
    public final void rule__IndexerRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4506:1: ( rule__IndexerRecipe__Group__5__Impl rule__IndexerRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4507:2: rule__IndexerRecipe__Group__5__Impl rule__IndexerRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__5__Impl_in_rule__IndexerRecipe__Group__58853);
            rule__IndexerRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__6_in_rule__IndexerRecipe__Group__58856);
            rule__IndexerRecipe__Group__6();

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
    // $ANTLR end "rule__IndexerRecipe__Group__5"


    // $ANTLR start "rule__IndexerRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4514:1: rule__IndexerRecipe__Group__5__Impl : ( ':' ) ;
    public final void rule__IndexerRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4518:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4519:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4519:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4520:1: ':'
            {
             before(grammarAccess.getIndexerRecipeAccess().getColonKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__IndexerRecipe__Group__5__Impl8884); 
             after(grammarAccess.getIndexerRecipeAccess().getColonKeyword_5()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__5__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4533:1: rule__IndexerRecipe__Group__6 : rule__IndexerRecipe__Group__6__Impl rule__IndexerRecipe__Group__7 ;
    public final void rule__IndexerRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4537:1: ( rule__IndexerRecipe__Group__6__Impl rule__IndexerRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4538:2: rule__IndexerRecipe__Group__6__Impl rule__IndexerRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__6__Impl_in_rule__IndexerRecipe__Group__68915);
            rule__IndexerRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__7_in_rule__IndexerRecipe__Group__68918);
            rule__IndexerRecipe__Group__7();

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
    // $ANTLR end "rule__IndexerRecipe__Group__6"


    // $ANTLR start "rule__IndexerRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4545:1: rule__IndexerRecipe__Group__6__Impl : ( ( rule__IndexerRecipe__MaskAssignment_6 ) ) ;
    public final void rule__IndexerRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4549:1: ( ( ( rule__IndexerRecipe__MaskAssignment_6 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4550:1: ( ( rule__IndexerRecipe__MaskAssignment_6 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4550:1: ( ( rule__IndexerRecipe__MaskAssignment_6 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4551:1: ( rule__IndexerRecipe__MaskAssignment_6 )
            {
             before(grammarAccess.getIndexerRecipeAccess().getMaskAssignment_6()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4552:1: ( rule__IndexerRecipe__MaskAssignment_6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4552:2: rule__IndexerRecipe__MaskAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__MaskAssignment_6_in_rule__IndexerRecipe__Group__6__Impl8945);
            rule__IndexerRecipe__MaskAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getIndexerRecipeAccess().getMaskAssignment_6()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__6__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4562:1: rule__IndexerRecipe__Group__7 : rule__IndexerRecipe__Group__7__Impl rule__IndexerRecipe__Group__8 ;
    public final void rule__IndexerRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4566:1: ( rule__IndexerRecipe__Group__7__Impl rule__IndexerRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4567:2: rule__IndexerRecipe__Group__7__Impl rule__IndexerRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__7__Impl_in_rule__IndexerRecipe__Group__78975);
            rule__IndexerRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__8_in_rule__IndexerRecipe__Group__78978);
            rule__IndexerRecipe__Group__8();

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
    // $ANTLR end "rule__IndexerRecipe__Group__7"


    // $ANTLR start "rule__IndexerRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4574:1: rule__IndexerRecipe__Group__7__Impl : ( 'parent' ) ;
    public final void rule__IndexerRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4578:1: ( ( 'parent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4579:1: ( 'parent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4579:1: ( 'parent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4580:1: 'parent'
            {
             before(grammarAccess.getIndexerRecipeAccess().getParentKeyword_7()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__IndexerRecipe__Group__7__Impl9006); 
             after(grammarAccess.getIndexerRecipeAccess().getParentKeyword_7()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__7__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4593:1: rule__IndexerRecipe__Group__8 : rule__IndexerRecipe__Group__8__Impl rule__IndexerRecipe__Group__9 ;
    public final void rule__IndexerRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4597:1: ( rule__IndexerRecipe__Group__8__Impl rule__IndexerRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4598:2: rule__IndexerRecipe__Group__8__Impl rule__IndexerRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__8__Impl_in_rule__IndexerRecipe__Group__89037);
            rule__IndexerRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__9_in_rule__IndexerRecipe__Group__89040);
            rule__IndexerRecipe__Group__9();

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
    // $ANTLR end "rule__IndexerRecipe__Group__8"


    // $ANTLR start "rule__IndexerRecipe__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4605:1: rule__IndexerRecipe__Group__8__Impl : ( ':' ) ;
    public final void rule__IndexerRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4609:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4610:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4610:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4611:1: ':'
            {
             before(grammarAccess.getIndexerRecipeAccess().getColonKeyword_8()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__IndexerRecipe__Group__8__Impl9068); 
             after(grammarAccess.getIndexerRecipeAccess().getColonKeyword_8()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__8__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4624:1: rule__IndexerRecipe__Group__9 : rule__IndexerRecipe__Group__9__Impl rule__IndexerRecipe__Group__10 ;
    public final void rule__IndexerRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4628:1: ( rule__IndexerRecipe__Group__9__Impl rule__IndexerRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4629:2: rule__IndexerRecipe__Group__9__Impl rule__IndexerRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__9__Impl_in_rule__IndexerRecipe__Group__99099);
            rule__IndexerRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__10_in_rule__IndexerRecipe__Group__99102);
            rule__IndexerRecipe__Group__10();

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
    // $ANTLR end "rule__IndexerRecipe__Group__9"


    // $ANTLR start "rule__IndexerRecipe__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4636:1: rule__IndexerRecipe__Group__9__Impl : ( ( rule__IndexerRecipe__ParentAssignment_9 ) ) ;
    public final void rule__IndexerRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4640:1: ( ( ( rule__IndexerRecipe__ParentAssignment_9 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4641:1: ( ( rule__IndexerRecipe__ParentAssignment_9 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4641:1: ( ( rule__IndexerRecipe__ParentAssignment_9 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4642:1: ( rule__IndexerRecipe__ParentAssignment_9 )
            {
             before(grammarAccess.getIndexerRecipeAccess().getParentAssignment_9()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4643:1: ( rule__IndexerRecipe__ParentAssignment_9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4643:2: rule__IndexerRecipe__ParentAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__ParentAssignment_9_in_rule__IndexerRecipe__Group__9__Impl9129);
            rule__IndexerRecipe__ParentAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getIndexerRecipeAccess().getParentAssignment_9()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__9__Impl"


    // $ANTLR start "rule__IndexerRecipe__Group__10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4653:1: rule__IndexerRecipe__Group__10 : rule__IndexerRecipe__Group__10__Impl ;
    public final void rule__IndexerRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4657:1: ( rule__IndexerRecipe__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4658:2: rule__IndexerRecipe__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__10__Impl_in_rule__IndexerRecipe__Group__109159);
            rule__IndexerRecipe__Group__10__Impl();

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
    // $ANTLR end "rule__IndexerRecipe__Group__10"


    // $ANTLR start "rule__IndexerRecipe__Group__10__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4664:1: rule__IndexerRecipe__Group__10__Impl : ( '}' ) ;
    public final void rule__IndexerRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4668:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4669:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4669:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4670:1: '}'
            {
             before(grammarAccess.getIndexerRecipeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__IndexerRecipe__Group__10__Impl9187); 
             after(grammarAccess.getIndexerRecipeAccess().getRightCurlyBracketKeyword_10()); 

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
    // $ANTLR end "rule__IndexerRecipe__Group__10__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4705:1: rule__ProjectionIndexerRecipe__Group__0 : rule__ProjectionIndexerRecipe__Group__0__Impl rule__ProjectionIndexerRecipe__Group__1 ;
    public final void rule__ProjectionIndexerRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4709:1: ( rule__ProjectionIndexerRecipe__Group__0__Impl rule__ProjectionIndexerRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4710:2: rule__ProjectionIndexerRecipe__Group__0__Impl rule__ProjectionIndexerRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__0__Impl_in_rule__ProjectionIndexerRecipe__Group__09240);
            rule__ProjectionIndexerRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__1_in_rule__ProjectionIndexerRecipe__Group__09243);
            rule__ProjectionIndexerRecipe__Group__1();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__0"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4717:1: rule__ProjectionIndexerRecipe__Group__0__Impl : ( '{' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4721:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4722:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4722:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4723:1: '{'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__ProjectionIndexerRecipe__Group__0__Impl9271); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__0__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4736:1: rule__ProjectionIndexerRecipe__Group__1 : rule__ProjectionIndexerRecipe__Group__1__Impl rule__ProjectionIndexerRecipe__Group__2 ;
    public final void rule__ProjectionIndexerRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4740:1: ( rule__ProjectionIndexerRecipe__Group__1__Impl rule__ProjectionIndexerRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4741:2: rule__ProjectionIndexerRecipe__Group__1__Impl rule__ProjectionIndexerRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__1__Impl_in_rule__ProjectionIndexerRecipe__Group__19302);
            rule__ProjectionIndexerRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__2_in_rule__ProjectionIndexerRecipe__Group__19305);
            rule__ProjectionIndexerRecipe__Group__2();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__1"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4748:1: rule__ProjectionIndexerRecipe__Group__1__Impl : ( 'traceInfo' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4752:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4753:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4753:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4754:1: 'traceInfo'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__ProjectionIndexerRecipe__Group__1__Impl9333); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoKeyword_1()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__1__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4767:1: rule__ProjectionIndexerRecipe__Group__2 : rule__ProjectionIndexerRecipe__Group__2__Impl rule__ProjectionIndexerRecipe__Group__3 ;
    public final void rule__ProjectionIndexerRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4771:1: ( rule__ProjectionIndexerRecipe__Group__2__Impl rule__ProjectionIndexerRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4772:2: rule__ProjectionIndexerRecipe__Group__2__Impl rule__ProjectionIndexerRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__2__Impl_in_rule__ProjectionIndexerRecipe__Group__29364);
            rule__ProjectionIndexerRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__3_in_rule__ProjectionIndexerRecipe__Group__29367);
            rule__ProjectionIndexerRecipe__Group__3();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__2"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4779:1: rule__ProjectionIndexerRecipe__Group__2__Impl : ( ':' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4783:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4784:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4784:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4785:1: ':'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__2__Impl9395); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__2__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4798:1: rule__ProjectionIndexerRecipe__Group__3 : rule__ProjectionIndexerRecipe__Group__3__Impl rule__ProjectionIndexerRecipe__Group__4 ;
    public final void rule__ProjectionIndexerRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4802:1: ( rule__ProjectionIndexerRecipe__Group__3__Impl rule__ProjectionIndexerRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4803:2: rule__ProjectionIndexerRecipe__Group__3__Impl rule__ProjectionIndexerRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__3__Impl_in_rule__ProjectionIndexerRecipe__Group__39426);
            rule__ProjectionIndexerRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__4_in_rule__ProjectionIndexerRecipe__Group__39429);
            rule__ProjectionIndexerRecipe__Group__4();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__3"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4810:1: rule__ProjectionIndexerRecipe__Group__3__Impl : ( ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 ) ) ;
    public final void rule__ProjectionIndexerRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4814:1: ( ( ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4815:1: ( ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4815:1: ( ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4816:1: ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4817:1: ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4817:2: rule__ProjectionIndexerRecipe__TraceInfoAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__TraceInfoAssignment_3_in_rule__ProjectionIndexerRecipe__Group__3__Impl9456);
            rule__ProjectionIndexerRecipe__TraceInfoAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoAssignment_3()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__3__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4827:1: rule__ProjectionIndexerRecipe__Group__4 : rule__ProjectionIndexerRecipe__Group__4__Impl rule__ProjectionIndexerRecipe__Group__5 ;
    public final void rule__ProjectionIndexerRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4831:1: ( rule__ProjectionIndexerRecipe__Group__4__Impl rule__ProjectionIndexerRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4832:2: rule__ProjectionIndexerRecipe__Group__4__Impl rule__ProjectionIndexerRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__4__Impl_in_rule__ProjectionIndexerRecipe__Group__49486);
            rule__ProjectionIndexerRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__5_in_rule__ProjectionIndexerRecipe__Group__49489);
            rule__ProjectionIndexerRecipe__Group__5();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__4"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4839:1: rule__ProjectionIndexerRecipe__Group__4__Impl : ( 'mask' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4843:1: ( ( 'mask' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4844:1: ( 'mask' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4844:1: ( 'mask' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4845:1: 'mask'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getMaskKeyword_4()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__ProjectionIndexerRecipe__Group__4__Impl9517); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getMaskKeyword_4()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__4__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4858:1: rule__ProjectionIndexerRecipe__Group__5 : rule__ProjectionIndexerRecipe__Group__5__Impl rule__ProjectionIndexerRecipe__Group__6 ;
    public final void rule__ProjectionIndexerRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4862:1: ( rule__ProjectionIndexerRecipe__Group__5__Impl rule__ProjectionIndexerRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4863:2: rule__ProjectionIndexerRecipe__Group__5__Impl rule__ProjectionIndexerRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__5__Impl_in_rule__ProjectionIndexerRecipe__Group__59548);
            rule__ProjectionIndexerRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__6_in_rule__ProjectionIndexerRecipe__Group__59551);
            rule__ProjectionIndexerRecipe__Group__6();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__5"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4870:1: rule__ProjectionIndexerRecipe__Group__5__Impl : ( ':' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4874:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4875:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4875:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4876:1: ':'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__5__Impl9579); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_5()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__5__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4889:1: rule__ProjectionIndexerRecipe__Group__6 : rule__ProjectionIndexerRecipe__Group__6__Impl rule__ProjectionIndexerRecipe__Group__7 ;
    public final void rule__ProjectionIndexerRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4893:1: ( rule__ProjectionIndexerRecipe__Group__6__Impl rule__ProjectionIndexerRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4894:2: rule__ProjectionIndexerRecipe__Group__6__Impl rule__ProjectionIndexerRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__6__Impl_in_rule__ProjectionIndexerRecipe__Group__69610);
            rule__ProjectionIndexerRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__7_in_rule__ProjectionIndexerRecipe__Group__69613);
            rule__ProjectionIndexerRecipe__Group__7();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__6"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4901:1: rule__ProjectionIndexerRecipe__Group__6__Impl : ( ( rule__ProjectionIndexerRecipe__MaskAssignment_6 ) ) ;
    public final void rule__ProjectionIndexerRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4905:1: ( ( ( rule__ProjectionIndexerRecipe__MaskAssignment_6 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4906:1: ( ( rule__ProjectionIndexerRecipe__MaskAssignment_6 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4906:1: ( ( rule__ProjectionIndexerRecipe__MaskAssignment_6 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4907:1: ( rule__ProjectionIndexerRecipe__MaskAssignment_6 )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getMaskAssignment_6()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4908:1: ( rule__ProjectionIndexerRecipe__MaskAssignment_6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4908:2: rule__ProjectionIndexerRecipe__MaskAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__MaskAssignment_6_in_rule__ProjectionIndexerRecipe__Group__6__Impl9640);
            rule__ProjectionIndexerRecipe__MaskAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getProjectionIndexerRecipeAccess().getMaskAssignment_6()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__6__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4918:1: rule__ProjectionIndexerRecipe__Group__7 : rule__ProjectionIndexerRecipe__Group__7__Impl rule__ProjectionIndexerRecipe__Group__8 ;
    public final void rule__ProjectionIndexerRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4922:1: ( rule__ProjectionIndexerRecipe__Group__7__Impl rule__ProjectionIndexerRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4923:2: rule__ProjectionIndexerRecipe__Group__7__Impl rule__ProjectionIndexerRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__7__Impl_in_rule__ProjectionIndexerRecipe__Group__79670);
            rule__ProjectionIndexerRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__8_in_rule__ProjectionIndexerRecipe__Group__79673);
            rule__ProjectionIndexerRecipe__Group__8();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__7"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4930:1: rule__ProjectionIndexerRecipe__Group__7__Impl : ( 'parent' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4934:1: ( ( 'parent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4935:1: ( 'parent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4935:1: ( 'parent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4936:1: 'parent'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getParentKeyword_7()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__ProjectionIndexerRecipe__Group__7__Impl9701); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getParentKeyword_7()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__7__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4949:1: rule__ProjectionIndexerRecipe__Group__8 : rule__ProjectionIndexerRecipe__Group__8__Impl rule__ProjectionIndexerRecipe__Group__9 ;
    public final void rule__ProjectionIndexerRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4953:1: ( rule__ProjectionIndexerRecipe__Group__8__Impl rule__ProjectionIndexerRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4954:2: rule__ProjectionIndexerRecipe__Group__8__Impl rule__ProjectionIndexerRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__8__Impl_in_rule__ProjectionIndexerRecipe__Group__89732);
            rule__ProjectionIndexerRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__9_in_rule__ProjectionIndexerRecipe__Group__89735);
            rule__ProjectionIndexerRecipe__Group__9();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__8"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4961:1: rule__ProjectionIndexerRecipe__Group__8__Impl : ( ':' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4965:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4966:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4966:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4967:1: ':'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_8()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__8__Impl9763); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_8()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__8__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4980:1: rule__ProjectionIndexerRecipe__Group__9 : rule__ProjectionIndexerRecipe__Group__9__Impl rule__ProjectionIndexerRecipe__Group__10 ;
    public final void rule__ProjectionIndexerRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4984:1: ( rule__ProjectionIndexerRecipe__Group__9__Impl rule__ProjectionIndexerRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4985:2: rule__ProjectionIndexerRecipe__Group__9__Impl rule__ProjectionIndexerRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__9__Impl_in_rule__ProjectionIndexerRecipe__Group__99794);
            rule__ProjectionIndexerRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__10_in_rule__ProjectionIndexerRecipe__Group__99797);
            rule__ProjectionIndexerRecipe__Group__10();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__9"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4992:1: rule__ProjectionIndexerRecipe__Group__9__Impl : ( ( rule__ProjectionIndexerRecipe__ParentAssignment_9 ) ) ;
    public final void rule__ProjectionIndexerRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4996:1: ( ( ( rule__ProjectionIndexerRecipe__ParentAssignment_9 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4997:1: ( ( rule__ProjectionIndexerRecipe__ParentAssignment_9 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4997:1: ( ( rule__ProjectionIndexerRecipe__ParentAssignment_9 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4998:1: ( rule__ProjectionIndexerRecipe__ParentAssignment_9 )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getParentAssignment_9()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4999:1: ( rule__ProjectionIndexerRecipe__ParentAssignment_9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4999:2: rule__ProjectionIndexerRecipe__ParentAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__ParentAssignment_9_in_rule__ProjectionIndexerRecipe__Group__9__Impl9824);
            rule__ProjectionIndexerRecipe__ParentAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getProjectionIndexerRecipeAccess().getParentAssignment_9()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__9__Impl"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5009:1: rule__ProjectionIndexerRecipe__Group__10 : rule__ProjectionIndexerRecipe__Group__10__Impl ;
    public final void rule__ProjectionIndexerRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5013:1: ( rule__ProjectionIndexerRecipe__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5014:2: rule__ProjectionIndexerRecipe__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__10__Impl_in_rule__ProjectionIndexerRecipe__Group__109854);
            rule__ProjectionIndexerRecipe__Group__10__Impl();

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__10"


    // $ANTLR start "rule__ProjectionIndexerRecipe__Group__10__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5020:1: rule__ProjectionIndexerRecipe__Group__10__Impl : ( '}' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5024:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5025:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5025:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5026:1: '}'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ProjectionIndexerRecipe__Group__10__Impl9882); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getRightCurlyBracketKeyword_10()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__Group__10__Impl"


    // $ANTLR start "rule__Mask__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5061:1: rule__Mask__Group__0 : rule__Mask__Group__0__Impl rule__Mask__Group__1 ;
    public final void rule__Mask__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5065:1: ( rule__Mask__Group__0__Impl rule__Mask__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5066:2: rule__Mask__Group__0__Impl rule__Mask__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__0__Impl_in_rule__Mask__Group__09935);
            rule__Mask__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__1_in_rule__Mask__Group__09938);
            rule__Mask__Group__1();

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
    // $ANTLR end "rule__Mask__Group__0"


    // $ANTLR start "rule__Mask__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5073:1: rule__Mask__Group__0__Impl : ( '{' ) ;
    public final void rule__Mask__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5077:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5078:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5078:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5079:1: '{'
            {
             before(grammarAccess.getMaskAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Mask__Group__0__Impl9966); 
             after(grammarAccess.getMaskAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end "rule__Mask__Group__0__Impl"


    // $ANTLR start "rule__Mask__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5092:1: rule__Mask__Group__1 : rule__Mask__Group__1__Impl rule__Mask__Group__2 ;
    public final void rule__Mask__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5096:1: ( rule__Mask__Group__1__Impl rule__Mask__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5097:2: rule__Mask__Group__1__Impl rule__Mask__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__1__Impl_in_rule__Mask__Group__19997);
            rule__Mask__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__2_in_rule__Mask__Group__110000);
            rule__Mask__Group__2();

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
    // $ANTLR end "rule__Mask__Group__1"


    // $ANTLR start "rule__Mask__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5104:1: rule__Mask__Group__1__Impl : ( 'sourceArity' ) ;
    public final void rule__Mask__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5108:1: ( ( 'sourceArity' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5109:1: ( 'sourceArity' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5109:1: ( 'sourceArity' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5110:1: 'sourceArity'
            {
             before(grammarAccess.getMaskAccess().getSourceArityKeyword_1()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__Mask__Group__1__Impl10028); 
             after(grammarAccess.getMaskAccess().getSourceArityKeyword_1()); 

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
    // $ANTLR end "rule__Mask__Group__1__Impl"


    // $ANTLR start "rule__Mask__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5123:1: rule__Mask__Group__2 : rule__Mask__Group__2__Impl rule__Mask__Group__3 ;
    public final void rule__Mask__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5127:1: ( rule__Mask__Group__2__Impl rule__Mask__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5128:2: rule__Mask__Group__2__Impl rule__Mask__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__2__Impl_in_rule__Mask__Group__210059);
            rule__Mask__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__3_in_rule__Mask__Group__210062);
            rule__Mask__Group__3();

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
    // $ANTLR end "rule__Mask__Group__2"


    // $ANTLR start "rule__Mask__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5135:1: rule__Mask__Group__2__Impl : ( ':' ) ;
    public final void rule__Mask__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5139:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5140:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5140:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5141:1: ':'
            {
             before(grammarAccess.getMaskAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Mask__Group__2__Impl10090); 
             after(grammarAccess.getMaskAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__Mask__Group__2__Impl"


    // $ANTLR start "rule__Mask__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5154:1: rule__Mask__Group__3 : rule__Mask__Group__3__Impl rule__Mask__Group__4 ;
    public final void rule__Mask__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5158:1: ( rule__Mask__Group__3__Impl rule__Mask__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5159:2: rule__Mask__Group__3__Impl rule__Mask__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__3__Impl_in_rule__Mask__Group__310121);
            rule__Mask__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__4_in_rule__Mask__Group__310124);
            rule__Mask__Group__4();

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
    // $ANTLR end "rule__Mask__Group__3"


    // $ANTLR start "rule__Mask__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5166:1: rule__Mask__Group__3__Impl : ( ( rule__Mask__SourceArityAssignment_3 ) ) ;
    public final void rule__Mask__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5170:1: ( ( ( rule__Mask__SourceArityAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5171:1: ( ( rule__Mask__SourceArityAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5171:1: ( ( rule__Mask__SourceArityAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5172:1: ( rule__Mask__SourceArityAssignment_3 )
            {
             before(grammarAccess.getMaskAccess().getSourceArityAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5173:1: ( rule__Mask__SourceArityAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5173:2: rule__Mask__SourceArityAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__SourceArityAssignment_3_in_rule__Mask__Group__3__Impl10151);
            rule__Mask__SourceArityAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMaskAccess().getSourceArityAssignment_3()); 

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
    // $ANTLR end "rule__Mask__Group__3__Impl"


    // $ANTLR start "rule__Mask__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5183:1: rule__Mask__Group__4 : rule__Mask__Group__4__Impl rule__Mask__Group__5 ;
    public final void rule__Mask__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5187:1: ( rule__Mask__Group__4__Impl rule__Mask__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5188:2: rule__Mask__Group__4__Impl rule__Mask__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__4__Impl_in_rule__Mask__Group__410181);
            rule__Mask__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__5_in_rule__Mask__Group__410184);
            rule__Mask__Group__5();

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
    // $ANTLR end "rule__Mask__Group__4"


    // $ANTLR start "rule__Mask__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5195:1: rule__Mask__Group__4__Impl : ( ( rule__Mask__Group_4__0 )* ) ;
    public final void rule__Mask__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5199:1: ( ( ( rule__Mask__Group_4__0 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5200:1: ( ( rule__Mask__Group_4__0 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5200:1: ( ( rule__Mask__Group_4__0 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5201:1: ( rule__Mask__Group_4__0 )*
            {
             before(grammarAccess.getMaskAccess().getGroup_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5202:1: ( rule__Mask__Group_4__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==37) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5202:2: rule__Mask__Group_4__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__0_in_rule__Mask__Group__4__Impl10211);
            	    rule__Mask__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getMaskAccess().getGroup_4()); 

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
    // $ANTLR end "rule__Mask__Group__4__Impl"


    // $ANTLR start "rule__Mask__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5212:1: rule__Mask__Group__5 : rule__Mask__Group__5__Impl ;
    public final void rule__Mask__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5216:1: ( rule__Mask__Group__5__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5217:2: rule__Mask__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__5__Impl_in_rule__Mask__Group__510242);
            rule__Mask__Group__5__Impl();

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
    // $ANTLR end "rule__Mask__Group__5"


    // $ANTLR start "rule__Mask__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5223:1: rule__Mask__Group__5__Impl : ( '}' ) ;
    public final void rule__Mask__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5227:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5228:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5228:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5229:1: '}'
            {
             before(grammarAccess.getMaskAccess().getRightCurlyBracketKeyword_5()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Mask__Group__5__Impl10270); 
             after(grammarAccess.getMaskAccess().getRightCurlyBracketKeyword_5()); 

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
    // $ANTLR end "rule__Mask__Group__5__Impl"


    // $ANTLR start "rule__Mask__Group_4__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5254:1: rule__Mask__Group_4__0 : rule__Mask__Group_4__0__Impl rule__Mask__Group_4__1 ;
    public final void rule__Mask__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5258:1: ( rule__Mask__Group_4__0__Impl rule__Mask__Group_4__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5259:2: rule__Mask__Group_4__0__Impl rule__Mask__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__0__Impl_in_rule__Mask__Group_4__010313);
            rule__Mask__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__1_in_rule__Mask__Group_4__010316);
            rule__Mask__Group_4__1();

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
    // $ANTLR end "rule__Mask__Group_4__0"


    // $ANTLR start "rule__Mask__Group_4__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5266:1: rule__Mask__Group_4__0__Impl : ( 'sourceIndices' ) ;
    public final void rule__Mask__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5270:1: ( ( 'sourceIndices' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5271:1: ( 'sourceIndices' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5271:1: ( 'sourceIndices' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5272:1: 'sourceIndices'
            {
             before(grammarAccess.getMaskAccess().getSourceIndicesKeyword_4_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__Mask__Group_4__0__Impl10344); 
             after(grammarAccess.getMaskAccess().getSourceIndicesKeyword_4_0()); 

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
    // $ANTLR end "rule__Mask__Group_4__0__Impl"


    // $ANTLR start "rule__Mask__Group_4__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5285:1: rule__Mask__Group_4__1 : rule__Mask__Group_4__1__Impl rule__Mask__Group_4__2 ;
    public final void rule__Mask__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5289:1: ( rule__Mask__Group_4__1__Impl rule__Mask__Group_4__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5290:2: rule__Mask__Group_4__1__Impl rule__Mask__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__1__Impl_in_rule__Mask__Group_4__110375);
            rule__Mask__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__2_in_rule__Mask__Group_4__110378);
            rule__Mask__Group_4__2();

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
    // $ANTLR end "rule__Mask__Group_4__1"


    // $ANTLR start "rule__Mask__Group_4__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5297:1: rule__Mask__Group_4__1__Impl : ( ':' ) ;
    public final void rule__Mask__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5301:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5302:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5302:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5303:1: ':'
            {
             before(grammarAccess.getMaskAccess().getColonKeyword_4_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Mask__Group_4__1__Impl10406); 
             after(grammarAccess.getMaskAccess().getColonKeyword_4_1()); 

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
    // $ANTLR end "rule__Mask__Group_4__1__Impl"


    // $ANTLR start "rule__Mask__Group_4__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5316:1: rule__Mask__Group_4__2 : rule__Mask__Group_4__2__Impl rule__Mask__Group_4__3 ;
    public final void rule__Mask__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5320:1: ( rule__Mask__Group_4__2__Impl rule__Mask__Group_4__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5321:2: rule__Mask__Group_4__2__Impl rule__Mask__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__2__Impl_in_rule__Mask__Group_4__210437);
            rule__Mask__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__3_in_rule__Mask__Group_4__210440);
            rule__Mask__Group_4__3();

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
    // $ANTLR end "rule__Mask__Group_4__2"


    // $ANTLR start "rule__Mask__Group_4__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5328:1: rule__Mask__Group_4__2__Impl : ( '[' ) ;
    public final void rule__Mask__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5332:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5333:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5333:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5334:1: '['
            {
             before(grammarAccess.getMaskAccess().getLeftSquareBracketKeyword_4_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Mask__Group_4__2__Impl10468); 
             after(grammarAccess.getMaskAccess().getLeftSquareBracketKeyword_4_2()); 

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
    // $ANTLR end "rule__Mask__Group_4__2__Impl"


    // $ANTLR start "rule__Mask__Group_4__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5347:1: rule__Mask__Group_4__3 : rule__Mask__Group_4__3__Impl rule__Mask__Group_4__4 ;
    public final void rule__Mask__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5351:1: ( rule__Mask__Group_4__3__Impl rule__Mask__Group_4__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5352:2: rule__Mask__Group_4__3__Impl rule__Mask__Group_4__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__3__Impl_in_rule__Mask__Group_4__310499);
            rule__Mask__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__4_in_rule__Mask__Group_4__310502);
            rule__Mask__Group_4__4();

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
    // $ANTLR end "rule__Mask__Group_4__3"


    // $ANTLR start "rule__Mask__Group_4__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5359:1: rule__Mask__Group_4__3__Impl : ( ( rule__Mask__SourceIndicesAssignment_4_3 )* ) ;
    public final void rule__Mask__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5363:1: ( ( ( rule__Mask__SourceIndicesAssignment_4_3 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5364:1: ( ( rule__Mask__SourceIndicesAssignment_4_3 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5364:1: ( ( rule__Mask__SourceIndicesAssignment_4_3 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5365:1: ( rule__Mask__SourceIndicesAssignment_4_3 )*
            {
             before(grammarAccess.getMaskAccess().getSourceIndicesAssignment_4_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5366:1: ( rule__Mask__SourceIndicesAssignment_4_3 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_INT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5366:2: rule__Mask__SourceIndicesAssignment_4_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Mask__SourceIndicesAssignment_4_3_in_rule__Mask__Group_4__3__Impl10529);
            	    rule__Mask__SourceIndicesAssignment_4_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getMaskAccess().getSourceIndicesAssignment_4_3()); 

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
    // $ANTLR end "rule__Mask__Group_4__3__Impl"


    // $ANTLR start "rule__Mask__Group_4__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5376:1: rule__Mask__Group_4__4 : rule__Mask__Group_4__4__Impl ;
    public final void rule__Mask__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5380:1: ( rule__Mask__Group_4__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5381:2: rule__Mask__Group_4__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__4__Impl_in_rule__Mask__Group_4__410560);
            rule__Mask__Group_4__4__Impl();

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
    // $ANTLR end "rule__Mask__Group_4__4"


    // $ANTLR start "rule__Mask__Group_4__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5387:1: rule__Mask__Group_4__4__Impl : ( ']' ) ;
    public final void rule__Mask__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5391:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5392:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5392:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5393:1: ']'
            {
             before(grammarAccess.getMaskAccess().getRightSquareBracketKeyword_4_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Mask__Group_4__4__Impl10588); 
             after(grammarAccess.getMaskAccess().getRightSquareBracketKeyword_4_4()); 

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
    // $ANTLR end "rule__Mask__Group_4__4__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5416:1: rule__InfrastructureMapping__Group__0 : rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1 ;
    public final void rule__InfrastructureMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5420:1: ( rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5421:2: rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__0__Impl_in_rule__InfrastructureMapping__Group__010629);
            rule__InfrastructureMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__1_in_rule__InfrastructureMapping__Group__010632);
            rule__InfrastructureMapping__Group__1();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__0"


    // $ANTLR start "rule__InfrastructureMapping__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5428:1: rule__InfrastructureMapping__Group__0__Impl : ( '{' ) ;
    public final void rule__InfrastructureMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5432:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5433:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5433:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5434:1: '{'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__InfrastructureMapping__Group__0__Impl10660); 
             after(grammarAccess.getInfrastructureMappingAccess().getLeftCurlyBracketKeyword_0()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__0__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5447:1: rule__InfrastructureMapping__Group__1 : rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2 ;
    public final void rule__InfrastructureMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5451:1: ( rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5452:2: rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__1__Impl_in_rule__InfrastructureMapping__Group__110691);
            rule__InfrastructureMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__2_in_rule__InfrastructureMapping__Group__110694);
            rule__InfrastructureMapping__Group__2();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__1"


    // $ANTLR start "rule__InfrastructureMapping__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5459:1: rule__InfrastructureMapping__Group__1__Impl : ( 'from' ) ;
    public final void rule__InfrastructureMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5463:1: ( ( 'from' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5464:1: ( 'from' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5464:1: ( 'from' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5465:1: 'from'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getFromKeyword_1()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__InfrastructureMapping__Group__1__Impl10722); 
             after(grammarAccess.getInfrastructureMappingAccess().getFromKeyword_1()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__1__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__2"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5478:1: rule__InfrastructureMapping__Group__2 : rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3 ;
    public final void rule__InfrastructureMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5482:1: ( rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5483:2: rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__2__Impl_in_rule__InfrastructureMapping__Group__210753);
            rule__InfrastructureMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__3_in_rule__InfrastructureMapping__Group__210756);
            rule__InfrastructureMapping__Group__3();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__2"


    // $ANTLR start "rule__InfrastructureMapping__Group__2__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5490:1: rule__InfrastructureMapping__Group__2__Impl : ( ':' ) ;
    public final void rule__InfrastructureMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5494:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5495:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5495:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5496:1: ':'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__InfrastructureMapping__Group__2__Impl10784); 
             after(grammarAccess.getInfrastructureMappingAccess().getColonKeyword_2()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__2__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5509:1: rule__InfrastructureMapping__Group__3 : rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4 ;
    public final void rule__InfrastructureMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5513:1: ( rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5514:2: rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__3__Impl_in_rule__InfrastructureMapping__Group__310815);
            rule__InfrastructureMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__4_in_rule__InfrastructureMapping__Group__310818);
            rule__InfrastructureMapping__Group__4();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__3"


    // $ANTLR start "rule__InfrastructureMapping__Group__3__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5521:1: rule__InfrastructureMapping__Group__3__Impl : ( '[' ) ;
    public final void rule__InfrastructureMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5525:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5526:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5526:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5527:1: '['
            {
             before(grammarAccess.getInfrastructureMappingAccess().getLeftSquareBracketKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__InfrastructureMapping__Group__3__Impl10846); 
             after(grammarAccess.getInfrastructureMappingAccess().getLeftSquareBracketKeyword_3()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__3__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5540:1: rule__InfrastructureMapping__Group__4 : rule__InfrastructureMapping__Group__4__Impl rule__InfrastructureMapping__Group__5 ;
    public final void rule__InfrastructureMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5544:1: ( rule__InfrastructureMapping__Group__4__Impl rule__InfrastructureMapping__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5545:2: rule__InfrastructureMapping__Group__4__Impl rule__InfrastructureMapping__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__4__Impl_in_rule__InfrastructureMapping__Group__410877);
            rule__InfrastructureMapping__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__5_in_rule__InfrastructureMapping__Group__410880);
            rule__InfrastructureMapping__Group__5();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__4"


    // $ANTLR start "rule__InfrastructureMapping__Group__4__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5552:1: rule__InfrastructureMapping__Group__4__Impl : ( ( rule__InfrastructureMapping__MappedElementsAssignment_4 )* ) ;
    public final void rule__InfrastructureMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5556:1: ( ( ( rule__InfrastructureMapping__MappedElementsAssignment_4 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5557:1: ( ( rule__InfrastructureMapping__MappedElementsAssignment_4 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5557:1: ( ( rule__InfrastructureMapping__MappedElementsAssignment_4 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5558:1: ( rule__InfrastructureMapping__MappedElementsAssignment_4 )*
            {
             before(grammarAccess.getInfrastructureMappingAccess().getMappedElementsAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5559:1: ( rule__InfrastructureMapping__MappedElementsAssignment_4 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5559:2: rule__InfrastructureMapping__MappedElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__MappedElementsAssignment_4_in_rule__InfrastructureMapping__Group__4__Impl10907);
            	    rule__InfrastructureMapping__MappedElementsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getInfrastructureMappingAccess().getMappedElementsAssignment_4()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__4__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5569:1: rule__InfrastructureMapping__Group__5 : rule__InfrastructureMapping__Group__5__Impl rule__InfrastructureMapping__Group__6 ;
    public final void rule__InfrastructureMapping__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5573:1: ( rule__InfrastructureMapping__Group__5__Impl rule__InfrastructureMapping__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5574:2: rule__InfrastructureMapping__Group__5__Impl rule__InfrastructureMapping__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__5__Impl_in_rule__InfrastructureMapping__Group__510938);
            rule__InfrastructureMapping__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__6_in_rule__InfrastructureMapping__Group__510941);
            rule__InfrastructureMapping__Group__6();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__5"


    // $ANTLR start "rule__InfrastructureMapping__Group__5__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5581:1: rule__InfrastructureMapping__Group__5__Impl : ( ']' ) ;
    public final void rule__InfrastructureMapping__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5585:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5586:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5586:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5587:1: ']'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getRightSquareBracketKeyword_5()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__InfrastructureMapping__Group__5__Impl10969); 
             after(grammarAccess.getInfrastructureMappingAccess().getRightSquareBracketKeyword_5()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__5__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5600:1: rule__InfrastructureMapping__Group__6 : rule__InfrastructureMapping__Group__6__Impl rule__InfrastructureMapping__Group__7 ;
    public final void rule__InfrastructureMapping__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5604:1: ( rule__InfrastructureMapping__Group__6__Impl rule__InfrastructureMapping__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5605:2: rule__InfrastructureMapping__Group__6__Impl rule__InfrastructureMapping__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__6__Impl_in_rule__InfrastructureMapping__Group__611000);
            rule__InfrastructureMapping__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__7_in_rule__InfrastructureMapping__Group__611003);
            rule__InfrastructureMapping__Group__7();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__6"


    // $ANTLR start "rule__InfrastructureMapping__Group__6__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5612:1: rule__InfrastructureMapping__Group__6__Impl : ( 'to' ) ;
    public final void rule__InfrastructureMapping__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5616:1: ( ( 'to' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5617:1: ( 'to' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5617:1: ( 'to' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5618:1: 'to'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getToKeyword_6()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__InfrastructureMapping__Group__6__Impl11031); 
             after(grammarAccess.getInfrastructureMappingAccess().getToKeyword_6()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__6__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5631:1: rule__InfrastructureMapping__Group__7 : rule__InfrastructureMapping__Group__7__Impl rule__InfrastructureMapping__Group__8 ;
    public final void rule__InfrastructureMapping__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5635:1: ( rule__InfrastructureMapping__Group__7__Impl rule__InfrastructureMapping__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5636:2: rule__InfrastructureMapping__Group__7__Impl rule__InfrastructureMapping__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__7__Impl_in_rule__InfrastructureMapping__Group__711062);
            rule__InfrastructureMapping__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__8_in_rule__InfrastructureMapping__Group__711065);
            rule__InfrastructureMapping__Group__8();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__7"


    // $ANTLR start "rule__InfrastructureMapping__Group__7__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5643:1: rule__InfrastructureMapping__Group__7__Impl : ( ':' ) ;
    public final void rule__InfrastructureMapping__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5647:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5648:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5648:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5649:1: ':'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getColonKeyword_7()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__InfrastructureMapping__Group__7__Impl11093); 
             after(grammarAccess.getInfrastructureMappingAccess().getColonKeyword_7()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__7__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5662:1: rule__InfrastructureMapping__Group__8 : rule__InfrastructureMapping__Group__8__Impl rule__InfrastructureMapping__Group__9 ;
    public final void rule__InfrastructureMapping__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5666:1: ( rule__InfrastructureMapping__Group__8__Impl rule__InfrastructureMapping__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5667:2: rule__InfrastructureMapping__Group__8__Impl rule__InfrastructureMapping__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__8__Impl_in_rule__InfrastructureMapping__Group__811124);
            rule__InfrastructureMapping__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__9_in_rule__InfrastructureMapping__Group__811127);
            rule__InfrastructureMapping__Group__9();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__8"


    // $ANTLR start "rule__InfrastructureMapping__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5674:1: rule__InfrastructureMapping__Group__8__Impl : ( ( rule__InfrastructureMapping__TargetElementAssignment_8 ) ) ;
    public final void rule__InfrastructureMapping__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5678:1: ( ( ( rule__InfrastructureMapping__TargetElementAssignment_8 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5679:1: ( ( rule__InfrastructureMapping__TargetElementAssignment_8 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5679:1: ( ( rule__InfrastructureMapping__TargetElementAssignment_8 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5680:1: ( rule__InfrastructureMapping__TargetElementAssignment_8 )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getTargetElementAssignment_8()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5681:1: ( rule__InfrastructureMapping__TargetElementAssignment_8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5681:2: rule__InfrastructureMapping__TargetElementAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__TargetElementAssignment_8_in_rule__InfrastructureMapping__Group__8__Impl11154);
            rule__InfrastructureMapping__TargetElementAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureMappingAccess().getTargetElementAssignment_8()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__8__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5691:1: rule__InfrastructureMapping__Group__9 : rule__InfrastructureMapping__Group__9__Impl ;
    public final void rule__InfrastructureMapping__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5695:1: ( rule__InfrastructureMapping__Group__9__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5696:2: rule__InfrastructureMapping__Group__9__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__9__Impl_in_rule__InfrastructureMapping__Group__911184);
            rule__InfrastructureMapping__Group__9__Impl();

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
    // $ANTLR end "rule__InfrastructureMapping__Group__9"


    // $ANTLR start "rule__InfrastructureMapping__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5702:1: rule__InfrastructureMapping__Group__9__Impl : ( '}' ) ;
    public final void rule__InfrastructureMapping__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5706:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5707:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5707:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5708:1: '}'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getRightCurlyBracketKeyword_9()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__InfrastructureMapping__Group__9__Impl11212); 
             after(grammarAccess.getInfrastructureMappingAccess().getRightCurlyBracketKeyword_9()); 

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
    // $ANTLR end "rule__InfrastructureMapping__Group__9__Impl"


    // $ANTLR start "rule__Configuration__ClustersAssignment_1_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5742:1: rule__Configuration__ClustersAssignment_1_3 : ( ruleCluster ) ;
    public final void rule__Configuration__ClustersAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5746:1: ( ( ruleCluster ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5747:1: ( ruleCluster )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5747:1: ( ruleCluster )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5748:1: ruleCluster
            {
             before(grammarAccess.getConfigurationAccess().getClustersClusterParserRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCluster_in_rule__Configuration__ClustersAssignment_1_311268);
            ruleCluster();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getClustersClusterParserRuleCall_1_3_0()); 

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
    // $ANTLR end "rule__Configuration__ClustersAssignment_1_3"


    // $ANTLR start "rule__Configuration__ReteRecipesAssignment_2_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5757:1: rule__Configuration__ReteRecipesAssignment_2_3 : ( ruleReteRecipe ) ;
    public final void rule__Configuration__ReteRecipesAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5761:1: ( ( ruleReteRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5762:1: ( ruleReteRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5762:1: ( ruleReteRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5763:1: ruleReteRecipe
            {
             before(grammarAccess.getConfigurationAccess().getReteRecipesReteRecipeParserRuleCall_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteRecipe_in_rule__Configuration__ReteRecipesAssignment_2_311299);
            ruleReteRecipe();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getReteRecipesReteRecipeParserRuleCall_2_3_0()); 

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
    // $ANTLR end "rule__Configuration__ReteRecipesAssignment_2_3"


    // $ANTLR start "rule__Configuration__MappingsAssignment_3_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5772:1: rule__Configuration__MappingsAssignment_3_3 : ( ruleInfrastructureMapping ) ;
    public final void rule__Configuration__MappingsAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5776:1: ( ( ruleInfrastructureMapping ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5777:1: ( ruleInfrastructureMapping )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5777:1: ( ruleInfrastructureMapping )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5778:1: ruleInfrastructureMapping
            {
             before(grammarAccess.getConfigurationAccess().getMappingsInfrastructureMappingParserRuleCall_3_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_rule__Configuration__MappingsAssignment_3_311330);
            ruleInfrastructureMapping();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getMappingsInfrastructureMappingParserRuleCall_3_3_0()); 

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
    // $ANTLR end "rule__Configuration__MappingsAssignment_3_3"


    // $ANTLR start "rule__Cluster__ReteMachinesAssignment_2_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5787:1: rule__Cluster__ReteMachinesAssignment_2_3 : ( ruleMachine ) ;
    public final void rule__Cluster__ReteMachinesAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5791:1: ( ( ruleMachine ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5792:1: ( ruleMachine )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5792:1: ( ruleMachine )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5793:1: ruleMachine
            {
             before(grammarAccess.getClusterAccess().getReteMachinesMachineParserRuleCall_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_rule__Cluster__ReteMachinesAssignment_2_311361);
            ruleMachine();

            state._fsp--;

             after(grammarAccess.getClusterAccess().getReteMachinesMachineParserRuleCall_2_3_0()); 

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
    // $ANTLR end "rule__Cluster__ReteMachinesAssignment_2_3"


    // $ANTLR start "rule__Cluster__CacheMachinesAssignment_3_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5802:1: rule__Cluster__CacheMachinesAssignment_3_3 : ( ruleMachine ) ;
    public final void rule__Cluster__CacheMachinesAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5806:1: ( ( ruleMachine ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5807:1: ( ruleMachine )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5807:1: ( ruleMachine )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5808:1: ruleMachine
            {
             before(grammarAccess.getClusterAccess().getCacheMachinesMachineParserRuleCall_3_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_rule__Cluster__CacheMachinesAssignment_3_311392);
            ruleMachine();

            state._fsp--;

             after(grammarAccess.getClusterAccess().getCacheMachinesMachineParserRuleCall_3_3_0()); 

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
    // $ANTLR end "rule__Cluster__CacheMachinesAssignment_3_3"


    // $ANTLR start "rule__Machine__TraceInfoAssignment_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5817:1: rule__Machine__TraceInfoAssignment_3 : ( RULE_STRING ) ;
    public final void rule__Machine__TraceInfoAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5821:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5822:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5822:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5823:1: RULE_STRING
            {
             before(grammarAccess.getMachineAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Machine__TraceInfoAssignment_311423); 
             after(grammarAccess.getMachineAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__Machine__TraceInfoAssignment_3"


    // $ANTLR start "rule__Machine__IpAssignment_6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5832:1: rule__Machine__IpAssignment_6 : ( RULE_IP ) ;
    public final void rule__Machine__IpAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5836:1: ( ( RULE_IP ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5837:1: ( RULE_IP )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5837:1: ( RULE_IP )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5838:1: RULE_IP
            {
             before(grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_6_0()); 
            match(input,RULE_IP,FollowSets000.FOLLOW_RULE_IP_in_rule__Machine__IpAssignment_611454); 
             after(grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_6_0()); 

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
    // $ANTLR end "rule__Machine__IpAssignment_6"


    // $ANTLR start "rule__ReteRecipe__RecipeNodesAssignment_5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5847:1: rule__ReteRecipe__RecipeNodesAssignment_5 : ( ruleReteNodeRecipe ) ;
    public final void rule__ReteRecipe__RecipeNodesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5851:1: ( ( ruleReteNodeRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5852:1: ( ruleReteNodeRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5852:1: ( ruleReteNodeRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5853:1: ruleReteNodeRecipe
            {
             before(grammarAccess.getReteRecipeAccess().getRecipeNodesReteNodeRecipeParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteNodeRecipe_in_rule__ReteRecipe__RecipeNodesAssignment_511485);
            ruleReteNodeRecipe();

            state._fsp--;

             after(grammarAccess.getReteRecipeAccess().getRecipeNodesReteNodeRecipeParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__ReteRecipe__RecipeNodesAssignment_5"


    // $ANTLR start "rule__ProductionRecipe__TraceInfoAssignment_4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5862:1: rule__ProductionRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ProductionRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5866:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5867:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5867:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5868:1: RULE_STRING
            {
             before(grammarAccess.getProductionRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ProductionRecipe__TraceInfoAssignment_411516); 
             after(grammarAccess.getProductionRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__ProductionRecipe__TraceInfoAssignment_4"


    // $ANTLR start "rule__ProductionRecipe__ParentsAssignment_8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5877:1: rule__ProductionRecipe__ParentsAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__ProductionRecipe__ParentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5881:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5882:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5882:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5883:1: ( RULE_ID )
            {
             before(grammarAccess.getProductionRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5884:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5885:1: RULE_ID
            {
             before(grammarAccess.getProductionRecipeAccess().getParentsReteNodeRecipeIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ProductionRecipe__ParentsAssignment_811551); 
             after(grammarAccess.getProductionRecipeAccess().getParentsReteNodeRecipeIDTerminalRuleCall_8_0_1()); 

            }

             after(grammarAccess.getProductionRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 

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
    // $ANTLR end "rule__ProductionRecipe__ParentsAssignment_8"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5896:1: rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5900:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5901:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5901:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5902:1: RULE_STRING
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__UniquenessEnforcerRecipe__TraceInfoAssignment_411586); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4"


    // $ANTLR start "rule__UniquenessEnforcerRecipe__ParentsAssignment_8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5911:1: rule__UniquenessEnforcerRecipe__ParentsAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__UniquenessEnforcerRecipe__ParentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5915:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5916:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5916:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5917:1: ( RULE_ID )
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5918:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5919:1: RULE_ID
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsReteNodeRecipeIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__UniquenessEnforcerRecipe__ParentsAssignment_811621); 
             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsReteNodeRecipeIDTerminalRuleCall_8_0_1()); 

            }

             after(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 

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
    // $ANTLR end "rule__UniquenessEnforcerRecipe__ParentsAssignment_8"


    // $ANTLR start "rule__CheckRecipe__TraceInfoAssignment_4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5930:1: rule__CheckRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__CheckRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5934:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5935:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5935:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5936:1: RULE_STRING
            {
             before(grammarAccess.getCheckRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__CheckRecipe__TraceInfoAssignment_411656); 
             after(grammarAccess.getCheckRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__CheckRecipe__TraceInfoAssignment_4"


    // $ANTLR start "rule__CheckRecipe__ParentAssignment_7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5945:1: rule__CheckRecipe__ParentAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__CheckRecipe__ParentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5949:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5950:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5950:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5951:1: ( RULE_ID )
            {
             before(grammarAccess.getCheckRecipeAccess().getParentReteNodeRecipeCrossReference_7_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5952:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5953:1: RULE_ID
            {
             before(grammarAccess.getCheckRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__CheckRecipe__ParentAssignment_711691); 
             after(grammarAccess.getCheckRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_7_0_1()); 

            }

             after(grammarAccess.getCheckRecipeAccess().getParentReteNodeRecipeCrossReference_7_0()); 

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
    // $ANTLR end "rule__CheckRecipe__ParentAssignment_7"


    // $ANTLR start "rule__TrimmerRecipe__TraceInfoAssignment_4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5964:1: rule__TrimmerRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__TrimmerRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5968:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5969:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5969:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5970:1: RULE_STRING
            {
             before(grammarAccess.getTrimmerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__TrimmerRecipe__TraceInfoAssignment_411726); 
             after(grammarAccess.getTrimmerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__TrimmerRecipe__TraceInfoAssignment_4"


    // $ANTLR start "rule__TrimmerRecipe__MaskAssignment_7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5979:1: rule__TrimmerRecipe__MaskAssignment_7 : ( ruleMask ) ;
    public final void rule__TrimmerRecipe__MaskAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5983:1: ( ( ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5984:1: ( ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5984:1: ( ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5985:1: ruleMask
            {
             before(grammarAccess.getTrimmerRecipeAccess().getMaskMaskParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_rule__TrimmerRecipe__MaskAssignment_711757);
            ruleMask();

            state._fsp--;

             after(grammarAccess.getTrimmerRecipeAccess().getMaskMaskParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__TrimmerRecipe__MaskAssignment_7"


    // $ANTLR start "rule__TrimmerRecipe__ParentAssignment_10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5994:1: rule__TrimmerRecipe__ParentAssignment_10 : ( ( RULE_ID ) ) ;
    public final void rule__TrimmerRecipe__ParentAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5998:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5999:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5999:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6000:1: ( RULE_ID )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeCrossReference_10_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6001:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6002:1: RULE_ID
            {
             before(grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_10_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TrimmerRecipe__ParentAssignment_1011792); 
             after(grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_10_0_1()); 

            }

             after(grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeCrossReference_10_0()); 

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
    // $ANTLR end "rule__TrimmerRecipe__ParentAssignment_10"


    // $ANTLR start "rule__JoinRecipe__TraceInfoAssignment_4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6013:1: rule__JoinRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__JoinRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6017:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6018:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6018:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6019:1: RULE_STRING
            {
             before(grammarAccess.getJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__JoinRecipe__TraceInfoAssignment_411827); 
             after(grammarAccess.getJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__JoinRecipe__TraceInfoAssignment_4"


    // $ANTLR start "rule__JoinRecipe__LeftParentAssignment_7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6028:1: rule__JoinRecipe__LeftParentAssignment_7 : ( ruleProjectionIndexerRecipe ) ;
    public final void rule__JoinRecipe__LeftParentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6032:1: ( ( ruleProjectionIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6033:1: ( ruleProjectionIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6033:1: ( ruleProjectionIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6034:1: ruleProjectionIndexerRecipe
            {
             before(grammarAccess.getJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleProjectionIndexerRecipe_in_rule__JoinRecipe__LeftParentAssignment_711858);
            ruleProjectionIndexerRecipe();

            state._fsp--;

             after(grammarAccess.getJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__JoinRecipe__LeftParentAssignment_7"


    // $ANTLR start "rule__JoinRecipe__RightParentAssignment_10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6043:1: rule__JoinRecipe__RightParentAssignment_10 : ( ruleIndexerRecipe ) ;
    public final void rule__JoinRecipe__RightParentAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6047:1: ( ( ruleIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6048:1: ( ruleIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6048:1: ( ruleIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6049:1: ruleIndexerRecipe
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleIndexerRecipe_in_rule__JoinRecipe__RightParentAssignment_1011889);
            ruleIndexerRecipe();

            state._fsp--;

             after(grammarAccess.getJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 

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
    // $ANTLR end "rule__JoinRecipe__RightParentAssignment_10"


    // $ANTLR start "rule__JoinRecipe__RightParentComplementaryMaskAssignment_11"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6058:1: rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 : ( ruleMask ) ;
    public final void rule__JoinRecipe__RightParentComplementaryMaskAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6062:1: ( ( ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6063:1: ( ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6063:1: ( ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6064:1: ruleMask
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentComplementaryMaskMaskParserRuleCall_11_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_rule__JoinRecipe__RightParentComplementaryMaskAssignment_1111920);
            ruleMask();

            state._fsp--;

             after(grammarAccess.getJoinRecipeAccess().getRightParentComplementaryMaskMaskParserRuleCall_11_0()); 

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
    // $ANTLR end "rule__JoinRecipe__RightParentComplementaryMaskAssignment_11"


    // $ANTLR start "rule__AntiJoinRecipe__TraceInfoAssignment_4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6073:1: rule__AntiJoinRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__AntiJoinRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6077:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6078:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6078:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6079:1: RULE_STRING
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__AntiJoinRecipe__TraceInfoAssignment_411951); 
             after(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__TraceInfoAssignment_4"


    // $ANTLR start "rule__AntiJoinRecipe__LeftParentAssignment_7"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6088:1: rule__AntiJoinRecipe__LeftParentAssignment_7 : ( ruleProjectionIndexerRecipe ) ;
    public final void rule__AntiJoinRecipe__LeftParentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6092:1: ( ( ruleProjectionIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6093:1: ( ruleProjectionIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6093:1: ( ruleProjectionIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6094:1: ruleProjectionIndexerRecipe
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleProjectionIndexerRecipe_in_rule__AntiJoinRecipe__LeftParentAssignment_711982);
            ruleProjectionIndexerRecipe();

            state._fsp--;

             after(grammarAccess.getAntiJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__LeftParentAssignment_7"


    // $ANTLR start "rule__AntiJoinRecipe__RightParentAssignment_10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6103:1: rule__AntiJoinRecipe__RightParentAssignment_10 : ( ruleIndexerRecipe ) ;
    public final void rule__AntiJoinRecipe__RightParentAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6107:1: ( ( ruleIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6108:1: ( ruleIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6108:1: ( ruleIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6109:1: ruleIndexerRecipe
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleIndexerRecipe_in_rule__AntiJoinRecipe__RightParentAssignment_1012013);
            ruleIndexerRecipe();

            state._fsp--;

             after(grammarAccess.getAntiJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 

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
    // $ANTLR end "rule__AntiJoinRecipe__RightParentAssignment_10"


    // $ANTLR start "rule__IndexerRecipe__TraceInfoAssignment_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6118:1: rule__IndexerRecipe__TraceInfoAssignment_3 : ( RULE_STRING ) ;
    public final void rule__IndexerRecipe__TraceInfoAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6122:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6123:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6123:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6124:1: RULE_STRING
            {
             before(grammarAccess.getIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__IndexerRecipe__TraceInfoAssignment_312044); 
             after(grammarAccess.getIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__IndexerRecipe__TraceInfoAssignment_3"


    // $ANTLR start "rule__IndexerRecipe__MaskAssignment_6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6133:1: rule__IndexerRecipe__MaskAssignment_6 : ( ruleMask ) ;
    public final void rule__IndexerRecipe__MaskAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6137:1: ( ( ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6138:1: ( ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6138:1: ( ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6139:1: ruleMask
            {
             before(grammarAccess.getIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_rule__IndexerRecipe__MaskAssignment_612075);
            ruleMask();

            state._fsp--;

             after(grammarAccess.getIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__IndexerRecipe__MaskAssignment_6"


    // $ANTLR start "rule__IndexerRecipe__ParentAssignment_9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6148:1: rule__IndexerRecipe__ParentAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__IndexerRecipe__ParentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6152:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6153:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6153:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6154:1: ( RULE_ID )
            {
             before(grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6155:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6156:1: RULE_ID
            {
             before(grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__IndexerRecipe__ParentAssignment_912110); 
             after(grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_9_0_1()); 

            }

             after(grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 

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
    // $ANTLR end "rule__IndexerRecipe__ParentAssignment_9"


    // $ANTLR start "rule__ProjectionIndexerRecipe__TraceInfoAssignment_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6167:1: rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ProjectionIndexerRecipe__TraceInfoAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6171:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6172:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6172:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6173:1: RULE_STRING
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ProjectionIndexerRecipe__TraceInfoAssignment_312145); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__TraceInfoAssignment_3"


    // $ANTLR start "rule__ProjectionIndexerRecipe__MaskAssignment_6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6182:1: rule__ProjectionIndexerRecipe__MaskAssignment_6 : ( ruleMask ) ;
    public final void rule__ProjectionIndexerRecipe__MaskAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6186:1: ( ( ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6187:1: ( ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6187:1: ( ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6188:1: ruleMask
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_rule__ProjectionIndexerRecipe__MaskAssignment_612176);
            ruleMask();

            state._fsp--;

             after(grammarAccess.getProjectionIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__MaskAssignment_6"


    // $ANTLR start "rule__ProjectionIndexerRecipe__ParentAssignment_9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6197:1: rule__ProjectionIndexerRecipe__ParentAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__ProjectionIndexerRecipe__ParentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6201:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6202:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6202:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6203:1: ( RULE_ID )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6204:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6205:1: RULE_ID
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ProjectionIndexerRecipe__ParentAssignment_912211); 
             after(grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_9_0_1()); 

            }

             after(grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 

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
    // $ANTLR end "rule__ProjectionIndexerRecipe__ParentAssignment_9"


    // $ANTLR start "rule__Mask__SourceArityAssignment_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6216:1: rule__Mask__SourceArityAssignment_3 : ( RULE_INT ) ;
    public final void rule__Mask__SourceArityAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6220:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6221:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6221:1: ( RULE_INT )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6222:1: RULE_INT
            {
             before(grammarAccess.getMaskAccess().getSourceArityINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Mask__SourceArityAssignment_312246); 
             after(grammarAccess.getMaskAccess().getSourceArityINTTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__Mask__SourceArityAssignment_3"


    // $ANTLR start "rule__Mask__SourceIndicesAssignment_4_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6231:1: rule__Mask__SourceIndicesAssignment_4_3 : ( RULE_INT ) ;
    public final void rule__Mask__SourceIndicesAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6235:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6236:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6236:1: ( RULE_INT )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6237:1: RULE_INT
            {
             before(grammarAccess.getMaskAccess().getSourceIndicesINTTerminalRuleCall_4_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Mask__SourceIndicesAssignment_4_312277); 
             after(grammarAccess.getMaskAccess().getSourceIndicesINTTerminalRuleCall_4_3_0()); 

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
    // $ANTLR end "rule__Mask__SourceIndicesAssignment_4_3"


    // $ANTLR start "rule__InfrastructureMapping__MappedElementsAssignment_4"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6246:1: rule__InfrastructureMapping__MappedElementsAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__InfrastructureMapping__MappedElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6250:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6251:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6251:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6252:1: ( RULE_ID )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getMappedElementsReteNodeRecipeCrossReference_4_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6253:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6254:1: RULE_ID
            {
             before(grammarAccess.getInfrastructureMappingAccess().getMappedElementsReteNodeRecipeIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__InfrastructureMapping__MappedElementsAssignment_412312); 
             after(grammarAccess.getInfrastructureMappingAccess().getMappedElementsReteNodeRecipeIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getInfrastructureMappingAccess().getMappedElementsReteNodeRecipeCrossReference_4_0()); 

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
    // $ANTLR end "rule__InfrastructureMapping__MappedElementsAssignment_4"


    // $ANTLR start "rule__InfrastructureMapping__TargetElementAssignment_8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6265:1: rule__InfrastructureMapping__TargetElementAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__InfrastructureMapping__TargetElementAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6269:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6270:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6270:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6271:1: ( RULE_ID )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getTargetElementMachineCrossReference_8_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6272:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6273:1: RULE_ID
            {
             before(grammarAccess.getInfrastructureMappingAccess().getTargetElementMachineIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__InfrastructureMapping__TargetElementAssignment_812351); 
             after(grammarAccess.getInfrastructureMappingAccess().getTargetElementMachineIDTerminalRuleCall_8_0_1()); 

            }

             after(grammarAccess.getInfrastructureMappingAccess().getTargetElementMachineCrossReference_8_0()); 

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
    // $ANTLR end "rule__InfrastructureMapping__TargetElementAssignment_8"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleConfiguration_in_entryRuleConfiguration61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfiguration68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__0_in_ruleConfiguration94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCluster_in_entryRuleCluster121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCluster128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group__0_in_ruleCluster154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMachine_in_entryRuleMachine181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMachine188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__0_in_ruleMachine214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteRecipe_in_entryRuleReteRecipe241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReteRecipe248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__0_in_ruleReteRecipe274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteNodeRecipe_in_entryRuleReteNodeRecipe301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReteNodeRecipe308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteNodeRecipe__Alternatives_in_ruleReteNodeRecipe334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProductionRecipe_in_entryRuleProductionRecipe361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProductionRecipe368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__0_in_ruleProductionRecipe394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUniquenessEnforcerRecipe_in_entryRuleUniquenessEnforcerRecipe421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUniquenessEnforcerRecipe428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__0_in_ruleUniquenessEnforcerRecipe454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheckRecipe_in_entryRuleCheckRecipe481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCheckRecipe488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__0_in_ruleCheckRecipe514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrimmerRecipe_in_entryRuleTrimmerRecipe541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTrimmerRecipe548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__0_in_ruleTrimmerRecipe574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJoinRecipe_in_entryRuleJoinRecipe601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJoinRecipe608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__0_in_ruleJoinRecipe634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAntiJoinRecipe_in_entryRuleAntiJoinRecipe661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAntiJoinRecipe668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__0_in_ruleAntiJoinRecipe694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexerRecipe_in_entryRuleIndexerRecipe721 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIndexerRecipe728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__0_in_ruleIndexerRecipe754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProjectionIndexerRecipe_in_entryRuleProjectionIndexerRecipe781 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProjectionIndexerRecipe788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__0_in_ruleProjectionIndexerRecipe814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_entryRuleMask841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMask848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__0_in_ruleMask874 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_entryRuleInfrastructureMapping901 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfrastructureMapping908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__0_in_ruleInfrastructureMapping934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProductionRecipe_in_rule__ReteNodeRecipe__Alternatives970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUniquenessEnforcerRecipe_in_rule__ReteNodeRecipe__Alternatives987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCheckRecipe_in_rule__ReteNodeRecipe__Alternatives1004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTrimmerRecipe_in_rule__ReteNodeRecipe__Alternatives1021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJoinRecipe_in_rule__ReteNodeRecipe__Alternatives1038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAntiJoinRecipe_in_rule__ReteNodeRecipe__Alternatives1055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__0__Impl_in_rule__Configuration__Group__01085 = new BitSet(new long[]{0x0000000000031000L});
        public static final BitSet FOLLOW_rule__Configuration__Group__1_in_rule__Configuration__Group__01088 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__1__Impl_in_rule__Configuration__Group__11146 = new BitSet(new long[]{0x0000000000031000L});
        public static final BitSet FOLLOW_rule__Configuration__Group__2_in_rule__Configuration__Group__11149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__0_in_rule__Configuration__Group__1__Impl1176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__2__Impl_in_rule__Configuration__Group__21207 = new BitSet(new long[]{0x0000000000031000L});
        public static final BitSet FOLLOW_rule__Configuration__Group__3_in_rule__Configuration__Group__21210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__0_in_rule__Configuration__Group__2__Impl1237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__3__Impl_in_rule__Configuration__Group__31268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__0_in_rule__Configuration__Group__3__Impl1295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__0__Impl_in_rule__Configuration__Group_1__01334 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__1_in_rule__Configuration__Group_1__01337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Configuration__Group_1__0__Impl1365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__1__Impl_in_rule__Configuration__Group_1__11396 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__2_in_rule__Configuration__Group_1__11399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Configuration__Group_1__1__Impl1427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__2__Impl_in_rule__Configuration__Group_1__21458 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__3_in_rule__Configuration__Group_1__21461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Configuration__Group_1__2__Impl1489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__3__Impl_in_rule__Configuration__Group_1__31520 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__4_in_rule__Configuration__Group_1__31523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__ClustersAssignment_1_3_in_rule__Configuration__Group_1__3__Impl1550 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_1__4__Impl_in_rule__Configuration__Group_1__41581 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Configuration__Group_1__4__Impl1609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__0__Impl_in_rule__Configuration__Group_2__01650 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__1_in_rule__Configuration__Group_2__01653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Configuration__Group_2__0__Impl1681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__1__Impl_in_rule__Configuration__Group_2__11712 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__2_in_rule__Configuration__Group_2__11715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Configuration__Group_2__1__Impl1743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__2__Impl_in_rule__Configuration__Group_2__21774 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__3_in_rule__Configuration__Group_2__21777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Configuration__Group_2__2__Impl1805 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__3__Impl_in_rule__Configuration__Group_2__31836 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__4_in_rule__Configuration__Group_2__31839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__ReteRecipesAssignment_2_3_in_rule__Configuration__Group_2__3__Impl1866 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_2__4__Impl_in_rule__Configuration__Group_2__41897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Configuration__Group_2__4__Impl1925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__0__Impl_in_rule__Configuration__Group_3__01966 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__1_in_rule__Configuration__Group_3__01969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Configuration__Group_3__0__Impl1997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__1__Impl_in_rule__Configuration__Group_3__12028 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__2_in_rule__Configuration__Group_3__12031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Configuration__Group_3__1__Impl2059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__2__Impl_in_rule__Configuration__Group_3__22090 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__3_in_rule__Configuration__Group_3__22093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Configuration__Group_3__2__Impl2121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__3__Impl_in_rule__Configuration__Group_3__32152 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__4_in_rule__Configuration__Group_3__32155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__MappingsAssignment_3_3_in_rule__Configuration__Group_3__3__Impl2182 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__4__Impl_in_rule__Configuration__Group_3__42213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Configuration__Group_3__4__Impl2241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group__0__Impl_in_rule__Cluster__Group__02282 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__Cluster__Group__1_in_rule__Cluster__Group__02285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group__1__Impl_in_rule__Cluster__Group__12343 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_rule__Cluster__Group__2_in_rule__Cluster__Group__12346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Cluster__Group__1__Impl2374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group__2__Impl_in_rule__Cluster__Group__22405 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_rule__Cluster__Group__3_in_rule__Cluster__Group__22408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__0_in_rule__Cluster__Group__2__Impl2435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group__3__Impl_in_rule__Cluster__Group__32466 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_rule__Cluster__Group__4_in_rule__Cluster__Group__32469 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__0_in_rule__Cluster__Group__3__Impl2496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group__4__Impl_in_rule__Cluster__Group__42527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Cluster__Group__4__Impl2555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__0__Impl_in_rule__Cluster__Group_2__02596 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__1_in_rule__Cluster__Group_2__02599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Cluster__Group_2__0__Impl2627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__1__Impl_in_rule__Cluster__Group_2__12658 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__2_in_rule__Cluster__Group_2__12661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Cluster__Group_2__1__Impl2689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__2__Impl_in_rule__Cluster__Group_2__22720 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__3_in_rule__Cluster__Group_2__22723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Cluster__Group_2__2__Impl2751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__3__Impl_in_rule__Cluster__Group_2__32782 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__4_in_rule__Cluster__Group_2__32785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__ReteMachinesAssignment_2_3_in_rule__Cluster__Group_2__3__Impl2812 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_2__4__Impl_in_rule__Cluster__Group_2__42843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Cluster__Group_2__4__Impl2871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__0__Impl_in_rule__Cluster__Group_3__02912 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__1_in_rule__Cluster__Group_3__02915 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Cluster__Group_3__0__Impl2943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__1__Impl_in_rule__Cluster__Group_3__12974 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__2_in_rule__Cluster__Group_3__12977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Cluster__Group_3__1__Impl3005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__2__Impl_in_rule__Cluster__Group_3__23036 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__3_in_rule__Cluster__Group_3__23039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Cluster__Group_3__2__Impl3067 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__3__Impl_in_rule__Cluster__Group_3__33098 = new BitSet(new long[]{0x0000000000048000L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__4_in_rule__Cluster__Group_3__33101 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Cluster__CacheMachinesAssignment_3_3_in_rule__Cluster__Group_3__3__Impl3128 = new BitSet(new long[]{0x0000000000040002L});
        public static final BitSet FOLLOW_rule__Cluster__Group_3__4__Impl_in_rule__Cluster__Group_3__43159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Cluster__Group_3__4__Impl3187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__0__Impl_in_rule__Machine__Group__03228 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Machine__Group__1_in_rule__Machine__Group__03231 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Machine__Group__0__Impl3259 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__1__Impl_in_rule__Machine__Group__13290 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Machine__Group__2_in_rule__Machine__Group__13293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Machine__Group__1__Impl3321 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__2__Impl_in_rule__Machine__Group__23352 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__Machine__Group__3_in_rule__Machine__Group__23355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Machine__Group__2__Impl3383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__3__Impl_in_rule__Machine__Group__33414 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Machine__Group__4_in_rule__Machine__Group__33417 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__TraceInfoAssignment_3_in_rule__Machine__Group__3__Impl3444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__4__Impl_in_rule__Machine__Group__43474 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Machine__Group__5_in_rule__Machine__Group__43477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Machine__Group__4__Impl3505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__5__Impl_in_rule__Machine__Group__53536 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Machine__Group__6_in_rule__Machine__Group__53539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Machine__Group__5__Impl3567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__6__Impl_in_rule__Machine__Group__63598 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Machine__Group__7_in_rule__Machine__Group__63601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__IpAssignment_6_in_rule__Machine__Group__6__Impl3628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__7__Impl_in_rule__Machine__Group__73658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Machine__Group__7__Impl3686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__0__Impl_in_rule__ReteRecipe__Group__03733 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__1_in_rule__ReteRecipe__Group__03736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__1__Impl_in_rule__ReteRecipe__Group__13794 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__2_in_rule__ReteRecipe__Group__13797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__ReteRecipe__Group__1__Impl3825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__2__Impl_in_rule__ReteRecipe__Group__23856 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__3_in_rule__ReteRecipe__Group__23859 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__ReteRecipe__Group__2__Impl3887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__3__Impl_in_rule__ReteRecipe__Group__33918 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__4_in_rule__ReteRecipe__Group__33921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ReteRecipe__Group__3__Impl3949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__4__Impl_in_rule__ReteRecipe__Group__43980 = new BitSet(new long[]{0x000000095A008000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__5_in_rule__ReteRecipe__Group__43983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ReteRecipe__Group__4__Impl4011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__5__Impl_in_rule__ReteRecipe__Group__54042 = new BitSet(new long[]{0x000000095A008000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__6_in_rule__ReteRecipe__Group__54045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__RecipeNodesAssignment_5_in_rule__ReteRecipe__Group__5__Impl4072 = new BitSet(new long[]{0x000000095A000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__6__Impl_in_rule__ReteRecipe__Group__64103 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__7_in_rule__ReteRecipe__Group__64106 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__ReteRecipe__Group__6__Impl4134 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__7__Impl_in_rule__ReteRecipe__Group__74165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ReteRecipe__Group__7__Impl4193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__0__Impl_in_rule__ProductionRecipe__Group__04240 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__1_in_rule__ProductionRecipe__Group__04243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ProductionRecipe__Group__0__Impl4271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__1__Impl_in_rule__ProductionRecipe__Group__14302 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__2_in_rule__ProductionRecipe__Group__14305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__ProductionRecipe__Group__1__Impl4333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__2__Impl_in_rule__ProductionRecipe__Group__24364 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__3_in_rule__ProductionRecipe__Group__24367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__ProductionRecipe__Group__2__Impl4395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__3__Impl_in_rule__ProductionRecipe__Group__34426 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__4_in_rule__ProductionRecipe__Group__34429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProductionRecipe__Group__3__Impl4457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__4__Impl_in_rule__ProductionRecipe__Group__44488 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__5_in_rule__ProductionRecipe__Group__44491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__TraceInfoAssignment_4_in_rule__ProductionRecipe__Group__4__Impl4518 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__5__Impl_in_rule__ProductionRecipe__Group__54548 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__6_in_rule__ProductionRecipe__Group__54551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ProductionRecipe__Group__5__Impl4579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__6__Impl_in_rule__ProductionRecipe__Group__64610 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__7_in_rule__ProductionRecipe__Group__64613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProductionRecipe__Group__6__Impl4641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__7__Impl_in_rule__ProductionRecipe__Group__74672 = new BitSet(new long[]{0x0000000000008040L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__8_in_rule__ProductionRecipe__Group__74675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ProductionRecipe__Group__7__Impl4703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__8__Impl_in_rule__ProductionRecipe__Group__84734 = new BitSet(new long[]{0x0000000000008040L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__9_in_rule__ProductionRecipe__Group__84737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__ParentsAssignment_8_in_rule__ProductionRecipe__Group__8__Impl4764 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__9__Impl_in_rule__ProductionRecipe__Group__94795 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__10_in_rule__ProductionRecipe__Group__94798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__ProductionRecipe__Group__9__Impl4826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__10__Impl_in_rule__ProductionRecipe__Group__104857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ProductionRecipe__Group__10__Impl4885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__0__Impl_in_rule__UniquenessEnforcerRecipe__Group__04938 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__1_in_rule__UniquenessEnforcerRecipe__Group__04941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__UniquenessEnforcerRecipe__Group__0__Impl4969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__1__Impl_in_rule__UniquenessEnforcerRecipe__Group__15000 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__2_in_rule__UniquenessEnforcerRecipe__Group__15003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__UniquenessEnforcerRecipe__Group__1__Impl5031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__2__Impl_in_rule__UniquenessEnforcerRecipe__Group__25062 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__3_in_rule__UniquenessEnforcerRecipe__Group__25065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__UniquenessEnforcerRecipe__Group__2__Impl5093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__3__Impl_in_rule__UniquenessEnforcerRecipe__Group__35124 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__4_in_rule__UniquenessEnforcerRecipe__Group__35127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__UniquenessEnforcerRecipe__Group__3__Impl5155 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__4__Impl_in_rule__UniquenessEnforcerRecipe__Group__45186 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__5_in_rule__UniquenessEnforcerRecipe__Group__45189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4_in_rule__UniquenessEnforcerRecipe__Group__4__Impl5216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__5__Impl_in_rule__UniquenessEnforcerRecipe__Group__55246 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__6_in_rule__UniquenessEnforcerRecipe__Group__55249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__UniquenessEnforcerRecipe__Group__5__Impl5277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__6__Impl_in_rule__UniquenessEnforcerRecipe__Group__65308 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__7_in_rule__UniquenessEnforcerRecipe__Group__65311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__UniquenessEnforcerRecipe__Group__6__Impl5339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__7__Impl_in_rule__UniquenessEnforcerRecipe__Group__75370 = new BitSet(new long[]{0x0000000000008040L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__8_in_rule__UniquenessEnforcerRecipe__Group__75373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__UniquenessEnforcerRecipe__Group__7__Impl5401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__8__Impl_in_rule__UniquenessEnforcerRecipe__Group__85432 = new BitSet(new long[]{0x0000000000008040L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__9_in_rule__UniquenessEnforcerRecipe__Group__85435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__ParentsAssignment_8_in_rule__UniquenessEnforcerRecipe__Group__8__Impl5462 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__9__Impl_in_rule__UniquenessEnforcerRecipe__Group__95493 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__10_in_rule__UniquenessEnforcerRecipe__Group__95496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__UniquenessEnforcerRecipe__Group__9__Impl5524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__10__Impl_in_rule__UniquenessEnforcerRecipe__Group__105555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__UniquenessEnforcerRecipe__Group__10__Impl5583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__0__Impl_in_rule__CheckRecipe__Group__05636 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__1_in_rule__CheckRecipe__Group__05639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__CheckRecipe__Group__0__Impl5667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__1__Impl_in_rule__CheckRecipe__Group__15698 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__2_in_rule__CheckRecipe__Group__15701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__CheckRecipe__Group__1__Impl5729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__2__Impl_in_rule__CheckRecipe__Group__25760 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__3_in_rule__CheckRecipe__Group__25763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__CheckRecipe__Group__2__Impl5791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__3__Impl_in_rule__CheckRecipe__Group__35822 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__4_in_rule__CheckRecipe__Group__35825 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__CheckRecipe__Group__3__Impl5853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__4__Impl_in_rule__CheckRecipe__Group__45884 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__5_in_rule__CheckRecipe__Group__45887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__TraceInfoAssignment_4_in_rule__CheckRecipe__Group__4__Impl5914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__5__Impl_in_rule__CheckRecipe__Group__55944 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__6_in_rule__CheckRecipe__Group__55947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__CheckRecipe__Group__5__Impl5975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__6__Impl_in_rule__CheckRecipe__Group__66006 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__7_in_rule__CheckRecipe__Group__66009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__CheckRecipe__Group__6__Impl6037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__7__Impl_in_rule__CheckRecipe__Group__76068 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__8_in_rule__CheckRecipe__Group__76071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__ParentAssignment_7_in_rule__CheckRecipe__Group__7__Impl6098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__8__Impl_in_rule__CheckRecipe__Group__86128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__CheckRecipe__Group__8__Impl6156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__0__Impl_in_rule__TrimmerRecipe__Group__06205 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__1_in_rule__TrimmerRecipe__Group__06208 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__TrimmerRecipe__Group__0__Impl6236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__1__Impl_in_rule__TrimmerRecipe__Group__16267 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__2_in_rule__TrimmerRecipe__Group__16270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__TrimmerRecipe__Group__1__Impl6298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__2__Impl_in_rule__TrimmerRecipe__Group__26329 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__3_in_rule__TrimmerRecipe__Group__26332 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__TrimmerRecipe__Group__2__Impl6360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__3__Impl_in_rule__TrimmerRecipe__Group__36391 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__4_in_rule__TrimmerRecipe__Group__36394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TrimmerRecipe__Group__3__Impl6422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__4__Impl_in_rule__TrimmerRecipe__Group__46453 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__5_in_rule__TrimmerRecipe__Group__46456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__TraceInfoAssignment_4_in_rule__TrimmerRecipe__Group__4__Impl6483 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__5__Impl_in_rule__TrimmerRecipe__Group__56513 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__6_in_rule__TrimmerRecipe__Group__56516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__TrimmerRecipe__Group__5__Impl6544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__6__Impl_in_rule__TrimmerRecipe__Group__66575 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__7_in_rule__TrimmerRecipe__Group__66578 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TrimmerRecipe__Group__6__Impl6606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__7__Impl_in_rule__TrimmerRecipe__Group__76637 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__8_in_rule__TrimmerRecipe__Group__76640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__MaskAssignment_7_in_rule__TrimmerRecipe__Group__7__Impl6667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__8__Impl_in_rule__TrimmerRecipe__Group__86697 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__9_in_rule__TrimmerRecipe__Group__86700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__TrimmerRecipe__Group__8__Impl6728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__9__Impl_in_rule__TrimmerRecipe__Group__96759 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__10_in_rule__TrimmerRecipe__Group__96762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TrimmerRecipe__Group__9__Impl6790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__10__Impl_in_rule__TrimmerRecipe__Group__106821 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__11_in_rule__TrimmerRecipe__Group__106824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__ParentAssignment_10_in_rule__TrimmerRecipe__Group__10__Impl6851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__11__Impl_in_rule__TrimmerRecipe__Group__116881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__TrimmerRecipe__Group__11__Impl6909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__0__Impl_in_rule__JoinRecipe__Group__06964 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__1_in_rule__JoinRecipe__Group__06967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__JoinRecipe__Group__0__Impl6995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__1__Impl_in_rule__JoinRecipe__Group__17026 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__2_in_rule__JoinRecipe__Group__17029 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__JoinRecipe__Group__1__Impl7057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__2__Impl_in_rule__JoinRecipe__Group__27088 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__3_in_rule__JoinRecipe__Group__27091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__JoinRecipe__Group__2__Impl7119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__3__Impl_in_rule__JoinRecipe__Group__37150 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__4_in_rule__JoinRecipe__Group__37153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__JoinRecipe__Group__3__Impl7181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__4__Impl_in_rule__JoinRecipe__Group__47212 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__5_in_rule__JoinRecipe__Group__47215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__TraceInfoAssignment_4_in_rule__JoinRecipe__Group__4__Impl7242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__5__Impl_in_rule__JoinRecipe__Group__57272 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__6_in_rule__JoinRecipe__Group__57275 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__JoinRecipe__Group__5__Impl7303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__6__Impl_in_rule__JoinRecipe__Group__67334 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__7_in_rule__JoinRecipe__Group__67337 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__JoinRecipe__Group__6__Impl7365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__7__Impl_in_rule__JoinRecipe__Group__77396 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__8_in_rule__JoinRecipe__Group__77399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__LeftParentAssignment_7_in_rule__JoinRecipe__Group__7__Impl7426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__8__Impl_in_rule__JoinRecipe__Group__87456 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__9_in_rule__JoinRecipe__Group__87459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__JoinRecipe__Group__8__Impl7487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__9__Impl_in_rule__JoinRecipe__Group__97518 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__10_in_rule__JoinRecipe__Group__97521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__JoinRecipe__Group__9__Impl7549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__10__Impl_in_rule__JoinRecipe__Group__107580 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__11_in_rule__JoinRecipe__Group__107583 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__RightParentAssignment_10_in_rule__JoinRecipe__Group__10__Impl7610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__11__Impl_in_rule__JoinRecipe__Group__117640 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__12_in_rule__JoinRecipe__Group__117643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__RightParentComplementaryMaskAssignment_11_in_rule__JoinRecipe__Group__11__Impl7670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__12__Impl_in_rule__JoinRecipe__Group__127701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__JoinRecipe__Group__12__Impl7729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__0__Impl_in_rule__AntiJoinRecipe__Group__07786 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__1_in_rule__AntiJoinRecipe__Group__07789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__AntiJoinRecipe__Group__0__Impl7817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__1__Impl_in_rule__AntiJoinRecipe__Group__17848 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__2_in_rule__AntiJoinRecipe__Group__17851 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__AntiJoinRecipe__Group__1__Impl7879 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__2__Impl_in_rule__AntiJoinRecipe__Group__27910 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__3_in_rule__AntiJoinRecipe__Group__27913 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__AntiJoinRecipe__Group__2__Impl7941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__3__Impl_in_rule__AntiJoinRecipe__Group__37972 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__4_in_rule__AntiJoinRecipe__Group__37975 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AntiJoinRecipe__Group__3__Impl8003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__4__Impl_in_rule__AntiJoinRecipe__Group__48034 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__5_in_rule__AntiJoinRecipe__Group__48037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__TraceInfoAssignment_4_in_rule__AntiJoinRecipe__Group__4__Impl8064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__5__Impl_in_rule__AntiJoinRecipe__Group__58094 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__6_in_rule__AntiJoinRecipe__Group__58097 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__AntiJoinRecipe__Group__5__Impl8125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__6__Impl_in_rule__AntiJoinRecipe__Group__68156 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__7_in_rule__AntiJoinRecipe__Group__68159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AntiJoinRecipe__Group__6__Impl8187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__7__Impl_in_rule__AntiJoinRecipe__Group__78218 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__8_in_rule__AntiJoinRecipe__Group__78221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__LeftParentAssignment_7_in_rule__AntiJoinRecipe__Group__7__Impl8248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__8__Impl_in_rule__AntiJoinRecipe__Group__88278 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__9_in_rule__AntiJoinRecipe__Group__88281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__AntiJoinRecipe__Group__8__Impl8309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__9__Impl_in_rule__AntiJoinRecipe__Group__98340 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__10_in_rule__AntiJoinRecipe__Group__98343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AntiJoinRecipe__Group__9__Impl8371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__10__Impl_in_rule__AntiJoinRecipe__Group__108402 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__11_in_rule__AntiJoinRecipe__Group__108405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__RightParentAssignment_10_in_rule__AntiJoinRecipe__Group__10__Impl8432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__11__Impl_in_rule__AntiJoinRecipe__Group__118462 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__AntiJoinRecipe__Group__11__Impl8490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__0__Impl_in_rule__IndexerRecipe__Group__08545 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__1_in_rule__IndexerRecipe__Group__08548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__IndexerRecipe__Group__0__Impl8576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__1__Impl_in_rule__IndexerRecipe__Group__18607 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__2_in_rule__IndexerRecipe__Group__18610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__IndexerRecipe__Group__1__Impl8638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__2__Impl_in_rule__IndexerRecipe__Group__28669 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__3_in_rule__IndexerRecipe__Group__28672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__IndexerRecipe__Group__2__Impl8700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__3__Impl_in_rule__IndexerRecipe__Group__38731 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__4_in_rule__IndexerRecipe__Group__38734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__TraceInfoAssignment_3_in_rule__IndexerRecipe__Group__3__Impl8761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__4__Impl_in_rule__IndexerRecipe__Group__48791 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__5_in_rule__IndexerRecipe__Group__48794 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__IndexerRecipe__Group__4__Impl8822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__5__Impl_in_rule__IndexerRecipe__Group__58853 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__6_in_rule__IndexerRecipe__Group__58856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__IndexerRecipe__Group__5__Impl8884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__6__Impl_in_rule__IndexerRecipe__Group__68915 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__7_in_rule__IndexerRecipe__Group__68918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__MaskAssignment_6_in_rule__IndexerRecipe__Group__6__Impl8945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__7__Impl_in_rule__IndexerRecipe__Group__78975 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__8_in_rule__IndexerRecipe__Group__78978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__IndexerRecipe__Group__7__Impl9006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__8__Impl_in_rule__IndexerRecipe__Group__89037 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__9_in_rule__IndexerRecipe__Group__89040 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__IndexerRecipe__Group__8__Impl9068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__9__Impl_in_rule__IndexerRecipe__Group__99099 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__10_in_rule__IndexerRecipe__Group__99102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__ParentAssignment_9_in_rule__IndexerRecipe__Group__9__Impl9129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__10__Impl_in_rule__IndexerRecipe__Group__109159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__IndexerRecipe__Group__10__Impl9187 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__0__Impl_in_rule__ProjectionIndexerRecipe__Group__09240 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__1_in_rule__ProjectionIndexerRecipe__Group__09243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__ProjectionIndexerRecipe__Group__0__Impl9271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__1__Impl_in_rule__ProjectionIndexerRecipe__Group__19302 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__2_in_rule__ProjectionIndexerRecipe__Group__19305 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__ProjectionIndexerRecipe__Group__1__Impl9333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__2__Impl_in_rule__ProjectionIndexerRecipe__Group__29364 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__3_in_rule__ProjectionIndexerRecipe__Group__29367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__2__Impl9395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__3__Impl_in_rule__ProjectionIndexerRecipe__Group__39426 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__4_in_rule__ProjectionIndexerRecipe__Group__39429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__TraceInfoAssignment_3_in_rule__ProjectionIndexerRecipe__Group__3__Impl9456 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__4__Impl_in_rule__ProjectionIndexerRecipe__Group__49486 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__5_in_rule__ProjectionIndexerRecipe__Group__49489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__ProjectionIndexerRecipe__Group__4__Impl9517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__5__Impl_in_rule__ProjectionIndexerRecipe__Group__59548 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__6_in_rule__ProjectionIndexerRecipe__Group__59551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__5__Impl9579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__6__Impl_in_rule__ProjectionIndexerRecipe__Group__69610 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__7_in_rule__ProjectionIndexerRecipe__Group__69613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__MaskAssignment_6_in_rule__ProjectionIndexerRecipe__Group__6__Impl9640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__7__Impl_in_rule__ProjectionIndexerRecipe__Group__79670 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__8_in_rule__ProjectionIndexerRecipe__Group__79673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ProjectionIndexerRecipe__Group__7__Impl9701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__8__Impl_in_rule__ProjectionIndexerRecipe__Group__89732 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__9_in_rule__ProjectionIndexerRecipe__Group__89735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__8__Impl9763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__9__Impl_in_rule__ProjectionIndexerRecipe__Group__99794 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__10_in_rule__ProjectionIndexerRecipe__Group__99797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__ParentAssignment_9_in_rule__ProjectionIndexerRecipe__Group__9__Impl9824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__10__Impl_in_rule__ProjectionIndexerRecipe__Group__109854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ProjectionIndexerRecipe__Group__10__Impl9882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__0__Impl_in_rule__Mask__Group__09935 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_rule__Mask__Group__1_in_rule__Mask__Group__09938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Mask__Group__0__Impl9966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__1__Impl_in_rule__Mask__Group__19997 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Mask__Group__2_in_rule__Mask__Group__110000 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__Mask__Group__1__Impl10028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__2__Impl_in_rule__Mask__Group__210059 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__Mask__Group__3_in_rule__Mask__Group__210062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Mask__Group__2__Impl10090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__3__Impl_in_rule__Mask__Group__310121 = new BitSet(new long[]{0x0000002000080000L});
        public static final BitSet FOLLOW_rule__Mask__Group__4_in_rule__Mask__Group__310124 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__SourceArityAssignment_3_in_rule__Mask__Group__3__Impl10151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__4__Impl_in_rule__Mask__Group__410181 = new BitSet(new long[]{0x0000002000080000L});
        public static final BitSet FOLLOW_rule__Mask__Group__5_in_rule__Mask__Group__410184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__0_in_rule__Mask__Group__4__Impl10211 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__5__Impl_in_rule__Mask__Group__510242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Mask__Group__5__Impl10270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__0__Impl_in_rule__Mask__Group_4__010313 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__1_in_rule__Mask__Group_4__010316 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__Mask__Group_4__0__Impl10344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__1__Impl_in_rule__Mask__Group_4__110375 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__2_in_rule__Mask__Group_4__110378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Mask__Group_4__1__Impl10406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__2__Impl_in_rule__Mask__Group_4__210437 = new BitSet(new long[]{0x0000000000008080L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__3_in_rule__Mask__Group_4__210440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Mask__Group_4__2__Impl10468 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__3__Impl_in_rule__Mask__Group_4__310499 = new BitSet(new long[]{0x0000000000008080L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__4_in_rule__Mask__Group_4__310502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__SourceIndicesAssignment_4_3_in_rule__Mask__Group_4__3__Impl10529 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__4__Impl_in_rule__Mask__Group_4__410560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Mask__Group_4__4__Impl10588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__0__Impl_in_rule__InfrastructureMapping__Group__010629 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__1_in_rule__InfrastructureMapping__Group__010632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__InfrastructureMapping__Group__0__Impl10660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__1__Impl_in_rule__InfrastructureMapping__Group__110691 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__2_in_rule__InfrastructureMapping__Group__110694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__InfrastructureMapping__Group__1__Impl10722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__2__Impl_in_rule__InfrastructureMapping__Group__210753 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__3_in_rule__InfrastructureMapping__Group__210756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__InfrastructureMapping__Group__2__Impl10784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__3__Impl_in_rule__InfrastructureMapping__Group__310815 = new BitSet(new long[]{0x0000000000008040L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__4_in_rule__InfrastructureMapping__Group__310818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__InfrastructureMapping__Group__3__Impl10846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__4__Impl_in_rule__InfrastructureMapping__Group__410877 = new BitSet(new long[]{0x0000000000008040L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__5_in_rule__InfrastructureMapping__Group__410880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__MappedElementsAssignment_4_in_rule__InfrastructureMapping__Group__4__Impl10907 = new BitSet(new long[]{0x0000000000000042L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__5__Impl_in_rule__InfrastructureMapping__Group__510938 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__6_in_rule__InfrastructureMapping__Group__510941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__InfrastructureMapping__Group__5__Impl10969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__6__Impl_in_rule__InfrastructureMapping__Group__611000 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__7_in_rule__InfrastructureMapping__Group__611003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__InfrastructureMapping__Group__6__Impl11031 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__7__Impl_in_rule__InfrastructureMapping__Group__711062 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__8_in_rule__InfrastructureMapping__Group__711065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__InfrastructureMapping__Group__7__Impl11093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__8__Impl_in_rule__InfrastructureMapping__Group__811124 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__9_in_rule__InfrastructureMapping__Group__811127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__TargetElementAssignment_8_in_rule__InfrastructureMapping__Group__8__Impl11154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__9__Impl_in_rule__InfrastructureMapping__Group__911184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__InfrastructureMapping__Group__9__Impl11212 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCluster_in_rule__Configuration__ClustersAssignment_1_311268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteRecipe_in_rule__Configuration__ReteRecipesAssignment_2_311299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_rule__Configuration__MappingsAssignment_3_311330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMachine_in_rule__Cluster__ReteMachinesAssignment_2_311361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMachine_in_rule__Cluster__CacheMachinesAssignment_3_311392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Machine__TraceInfoAssignment_311423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_IP_in_rule__Machine__IpAssignment_611454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteNodeRecipe_in_rule__ReteRecipe__RecipeNodesAssignment_511485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ProductionRecipe__TraceInfoAssignment_411516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ProductionRecipe__ParentsAssignment_811551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__UniquenessEnforcerRecipe__TraceInfoAssignment_411586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__UniquenessEnforcerRecipe__ParentsAssignment_811621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__CheckRecipe__TraceInfoAssignment_411656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__CheckRecipe__ParentAssignment_711691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__TrimmerRecipe__TraceInfoAssignment_411726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_rule__TrimmerRecipe__MaskAssignment_711757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TrimmerRecipe__ParentAssignment_1011792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__JoinRecipe__TraceInfoAssignment_411827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProjectionIndexerRecipe_in_rule__JoinRecipe__LeftParentAssignment_711858 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexerRecipe_in_rule__JoinRecipe__RightParentAssignment_1011889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_rule__JoinRecipe__RightParentComplementaryMaskAssignment_1111920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__AntiJoinRecipe__TraceInfoAssignment_411951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProjectionIndexerRecipe_in_rule__AntiJoinRecipe__LeftParentAssignment_711982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexerRecipe_in_rule__AntiJoinRecipe__RightParentAssignment_1012013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__IndexerRecipe__TraceInfoAssignment_312044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_rule__IndexerRecipe__MaskAssignment_612075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__IndexerRecipe__ParentAssignment_912110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ProjectionIndexerRecipe__TraceInfoAssignment_312145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_rule__ProjectionIndexerRecipe__MaskAssignment_612176 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ProjectionIndexerRecipe__ParentAssignment_912211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Mask__SourceArityAssignment_312246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Mask__SourceIndicesAssignment_4_312277 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__InfrastructureMapping__MappedElementsAssignment_412312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__InfrastructureMapping__TargetElementAssignment_812351 = new BitSet(new long[]{0x0000000000000002L});
    }


}