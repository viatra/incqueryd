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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_IP", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'clusters'", "':'", "'['", "']'", "'recipes'", "'mappings'", "'{'", "'}'", "'reteMachines'", "'cacheMachines'", "'id'", "'traceInfo'", "'ip'", "'nodes'", "'Production'", "'parents'", "'UniquenessEnforcer'", "'Check'", "'parent'", "'Trimmer'", "'mask'", "'Join'", "'leftParent'", "'rightParent'", "'AntiJoin'", "'sourceArity'", "'sourceIndices'", "'from'", "'to'"
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
            case 26:
                {
                alt1=1;
                }
                break;
            case 28:
                {
                alt1=2;
                }
                break;
            case 29:
                {
                alt1=3;
                }
                break;
            case 31:
                {
                alt1=4;
                }
                break;
            case 33:
                {
                alt1=5;
                }
                break;
            case 36:
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1666:1: rule__Machine__Group__1__Impl : ( 'id' ) ;
    public final void rule__Machine__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1670:1: ( ( 'id' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1671:1: ( 'id' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1671:1: ( 'id' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1672:1: 'id'
            {
             before(grammarAccess.getMachineAccess().getIdKeyword_1()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Machine__Group__1__Impl3321); 
             after(grammarAccess.getMachineAccess().getIdKeyword_1()); 

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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1728:1: rule__Machine__Group__3__Impl : ( ( rule__Machine__NameAssignment_3 ) ) ;
    public final void rule__Machine__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1732:1: ( ( ( rule__Machine__NameAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1733:1: ( ( rule__Machine__NameAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1733:1: ( ( rule__Machine__NameAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1734:1: ( rule__Machine__NameAssignment_3 )
            {
             before(grammarAccess.getMachineAccess().getNameAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1735:1: ( rule__Machine__NameAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1735:2: rule__Machine__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__NameAssignment_3_in_rule__Machine__Group__3__Impl3444);
            rule__Machine__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMachineAccess().getNameAssignment_3()); 

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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1757:1: rule__Machine__Group__4__Impl : ( 'traceInfo' ) ;
    public final void rule__Machine__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1761:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1762:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1762:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1763:1: 'traceInfo'
            {
             before(grammarAccess.getMachineAccess().getTraceInfoKeyword_4()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Machine__Group__4__Impl3505); 
             after(grammarAccess.getMachineAccess().getTraceInfoKeyword_4()); 

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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1819:1: rule__Machine__Group__6__Impl : ( ( rule__Machine__TraceInfoAssignment_6 ) ) ;
    public final void rule__Machine__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1823:1: ( ( ( rule__Machine__TraceInfoAssignment_6 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1824:1: ( ( rule__Machine__TraceInfoAssignment_6 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1824:1: ( ( rule__Machine__TraceInfoAssignment_6 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1825:1: ( rule__Machine__TraceInfoAssignment_6 )
            {
             before(grammarAccess.getMachineAccess().getTraceInfoAssignment_6()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1826:1: ( rule__Machine__TraceInfoAssignment_6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1826:2: rule__Machine__TraceInfoAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__TraceInfoAssignment_6_in_rule__Machine__Group__6__Impl3628);
            rule__Machine__TraceInfoAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getMachineAccess().getTraceInfoAssignment_6()); 

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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1836:1: rule__Machine__Group__7 : rule__Machine__Group__7__Impl rule__Machine__Group__8 ;
    public final void rule__Machine__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1840:1: ( rule__Machine__Group__7__Impl rule__Machine__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1841:2: rule__Machine__Group__7__Impl rule__Machine__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__7__Impl_in_rule__Machine__Group__73658);
            rule__Machine__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__8_in_rule__Machine__Group__73661);
            rule__Machine__Group__8();

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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1848:1: rule__Machine__Group__7__Impl : ( 'ip' ) ;
    public final void rule__Machine__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1852:1: ( ( 'ip' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1853:1: ( 'ip' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1853:1: ( 'ip' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1854:1: 'ip'
            {
             before(grammarAccess.getMachineAccess().getIpKeyword_7()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Machine__Group__7__Impl3689); 
             after(grammarAccess.getMachineAccess().getIpKeyword_7()); 

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


    // $ANTLR start "rule__Machine__Group__8"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1867:1: rule__Machine__Group__8 : rule__Machine__Group__8__Impl rule__Machine__Group__9 ;
    public final void rule__Machine__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1871:1: ( rule__Machine__Group__8__Impl rule__Machine__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1872:2: rule__Machine__Group__8__Impl rule__Machine__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__8__Impl_in_rule__Machine__Group__83720);
            rule__Machine__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__9_in_rule__Machine__Group__83723);
            rule__Machine__Group__9();

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
    // $ANTLR end "rule__Machine__Group__8"


    // $ANTLR start "rule__Machine__Group__8__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1879:1: rule__Machine__Group__8__Impl : ( ':' ) ;
    public final void rule__Machine__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1883:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1884:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1884:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1885:1: ':'
            {
             before(grammarAccess.getMachineAccess().getColonKeyword_8()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Machine__Group__8__Impl3751); 
             after(grammarAccess.getMachineAccess().getColonKeyword_8()); 

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
    // $ANTLR end "rule__Machine__Group__8__Impl"


    // $ANTLR start "rule__Machine__Group__9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1898:1: rule__Machine__Group__9 : rule__Machine__Group__9__Impl rule__Machine__Group__10 ;
    public final void rule__Machine__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1902:1: ( rule__Machine__Group__9__Impl rule__Machine__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1903:2: rule__Machine__Group__9__Impl rule__Machine__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__9__Impl_in_rule__Machine__Group__93782);
            rule__Machine__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__10_in_rule__Machine__Group__93785);
            rule__Machine__Group__10();

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
    // $ANTLR end "rule__Machine__Group__9"


    // $ANTLR start "rule__Machine__Group__9__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1910:1: rule__Machine__Group__9__Impl : ( ( rule__Machine__IpAssignment_9 ) ) ;
    public final void rule__Machine__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1914:1: ( ( ( rule__Machine__IpAssignment_9 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1915:1: ( ( rule__Machine__IpAssignment_9 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1915:1: ( ( rule__Machine__IpAssignment_9 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1916:1: ( rule__Machine__IpAssignment_9 )
            {
             before(grammarAccess.getMachineAccess().getIpAssignment_9()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1917:1: ( rule__Machine__IpAssignment_9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1917:2: rule__Machine__IpAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__IpAssignment_9_in_rule__Machine__Group__9__Impl3812);
            rule__Machine__IpAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getMachineAccess().getIpAssignment_9()); 

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
    // $ANTLR end "rule__Machine__Group__9__Impl"


    // $ANTLR start "rule__Machine__Group__10"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1927:1: rule__Machine__Group__10 : rule__Machine__Group__10__Impl ;
    public final void rule__Machine__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1931:1: ( rule__Machine__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1932:2: rule__Machine__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__Group__10__Impl_in_rule__Machine__Group__103842);
            rule__Machine__Group__10__Impl();

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
    // $ANTLR end "rule__Machine__Group__10"


    // $ANTLR start "rule__Machine__Group__10__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1938:1: rule__Machine__Group__10__Impl : ( '}' ) ;
    public final void rule__Machine__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1942:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1943:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1943:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1944:1: '}'
            {
             before(grammarAccess.getMachineAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Machine__Group__10__Impl3870); 
             after(grammarAccess.getMachineAccess().getRightCurlyBracketKeyword_10()); 

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
    // $ANTLR end "rule__Machine__Group__10__Impl"


    // $ANTLR start "rule__ReteRecipe__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1979:1: rule__ReteRecipe__Group__0 : rule__ReteRecipe__Group__0__Impl rule__ReteRecipe__Group__1 ;
    public final void rule__ReteRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1983:1: ( rule__ReteRecipe__Group__0__Impl rule__ReteRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1984:2: rule__ReteRecipe__Group__0__Impl rule__ReteRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__0__Impl_in_rule__ReteRecipe__Group__03923);
            rule__ReteRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__1_in_rule__ReteRecipe__Group__03926);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1991:1: rule__ReteRecipe__Group__0__Impl : ( () ) ;
    public final void rule__ReteRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1995:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1996:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1996:1: ( () )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1997:1: ()
            {
             before(grammarAccess.getReteRecipeAccess().getReteRecipeAction_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:1998:1: ()
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2000:1: 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2010:1: rule__ReteRecipe__Group__1 : rule__ReteRecipe__Group__1__Impl rule__ReteRecipe__Group__2 ;
    public final void rule__ReteRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2014:1: ( rule__ReteRecipe__Group__1__Impl rule__ReteRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2015:2: rule__ReteRecipe__Group__1__Impl rule__ReteRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__1__Impl_in_rule__ReteRecipe__Group__13984);
            rule__ReteRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__2_in_rule__ReteRecipe__Group__13987);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2022:1: rule__ReteRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__ReteRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2026:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2027:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2027:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2028:1: '{'
            {
             before(grammarAccess.getReteRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__ReteRecipe__Group__1__Impl4015); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2041:1: rule__ReteRecipe__Group__2 : rule__ReteRecipe__Group__2__Impl rule__ReteRecipe__Group__3 ;
    public final void rule__ReteRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2045:1: ( rule__ReteRecipe__Group__2__Impl rule__ReteRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2046:2: rule__ReteRecipe__Group__2__Impl rule__ReteRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__2__Impl_in_rule__ReteRecipe__Group__24046);
            rule__ReteRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__3_in_rule__ReteRecipe__Group__24049);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2053:1: rule__ReteRecipe__Group__2__Impl : ( 'nodes' ) ;
    public final void rule__ReteRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2057:1: ( ( 'nodes' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2058:1: ( 'nodes' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2058:1: ( 'nodes' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2059:1: 'nodes'
            {
             before(grammarAccess.getReteRecipeAccess().getNodesKeyword_2()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__ReteRecipe__Group__2__Impl4077); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2072:1: rule__ReteRecipe__Group__3 : rule__ReteRecipe__Group__3__Impl rule__ReteRecipe__Group__4 ;
    public final void rule__ReteRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2076:1: ( rule__ReteRecipe__Group__3__Impl rule__ReteRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2077:2: rule__ReteRecipe__Group__3__Impl rule__ReteRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__3__Impl_in_rule__ReteRecipe__Group__34108);
            rule__ReteRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__4_in_rule__ReteRecipe__Group__34111);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2084:1: rule__ReteRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__ReteRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2088:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2089:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2089:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2090:1: ':'
            {
             before(grammarAccess.getReteRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ReteRecipe__Group__3__Impl4139); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2103:1: rule__ReteRecipe__Group__4 : rule__ReteRecipe__Group__4__Impl rule__ReteRecipe__Group__5 ;
    public final void rule__ReteRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2107:1: ( rule__ReteRecipe__Group__4__Impl rule__ReteRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2108:2: rule__ReteRecipe__Group__4__Impl rule__ReteRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__4__Impl_in_rule__ReteRecipe__Group__44170);
            rule__ReteRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__5_in_rule__ReteRecipe__Group__44173);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2115:1: rule__ReteRecipe__Group__4__Impl : ( '[' ) ;
    public final void rule__ReteRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2119:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2120:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2120:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2121:1: '['
            {
             before(grammarAccess.getReteRecipeAccess().getLeftSquareBracketKeyword_4()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ReteRecipe__Group__4__Impl4201); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2134:1: rule__ReteRecipe__Group__5 : rule__ReteRecipe__Group__5__Impl rule__ReteRecipe__Group__6 ;
    public final void rule__ReteRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2138:1: ( rule__ReteRecipe__Group__5__Impl rule__ReteRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2139:2: rule__ReteRecipe__Group__5__Impl rule__ReteRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__5__Impl_in_rule__ReteRecipe__Group__54232);
            rule__ReteRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__6_in_rule__ReteRecipe__Group__54235);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2146:1: rule__ReteRecipe__Group__5__Impl : ( ( rule__ReteRecipe__RecipeNodesAssignment_5 )* ) ;
    public final void rule__ReteRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2150:1: ( ( ( rule__ReteRecipe__RecipeNodesAssignment_5 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2151:1: ( ( rule__ReteRecipe__RecipeNodesAssignment_5 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2151:1: ( ( rule__ReteRecipe__RecipeNodesAssignment_5 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2152:1: ( rule__ReteRecipe__RecipeNodesAssignment_5 )*
            {
             before(grammarAccess.getReteRecipeAccess().getRecipeNodesAssignment_5()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2153:1: ( rule__ReteRecipe__RecipeNodesAssignment_5 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==26||(LA12_0>=28 && LA12_0<=29)||LA12_0==31||LA12_0==33||LA12_0==36) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2153:2: rule__ReteRecipe__RecipeNodesAssignment_5
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__RecipeNodesAssignment_5_in_rule__ReteRecipe__Group__5__Impl4262);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2163:1: rule__ReteRecipe__Group__6 : rule__ReteRecipe__Group__6__Impl rule__ReteRecipe__Group__7 ;
    public final void rule__ReteRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2167:1: ( rule__ReteRecipe__Group__6__Impl rule__ReteRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2168:2: rule__ReteRecipe__Group__6__Impl rule__ReteRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__6__Impl_in_rule__ReteRecipe__Group__64293);
            rule__ReteRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__7_in_rule__ReteRecipe__Group__64296);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2175:1: rule__ReteRecipe__Group__6__Impl : ( ']' ) ;
    public final void rule__ReteRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2179:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2180:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2180:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2181:1: ']'
            {
             before(grammarAccess.getReteRecipeAccess().getRightSquareBracketKeyword_6()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__ReteRecipe__Group__6__Impl4324); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2194:1: rule__ReteRecipe__Group__7 : rule__ReteRecipe__Group__7__Impl ;
    public final void rule__ReteRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2198:1: ( rule__ReteRecipe__Group__7__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2199:2: rule__ReteRecipe__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRecipe__Group__7__Impl_in_rule__ReteRecipe__Group__74355);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2205:1: rule__ReteRecipe__Group__7__Impl : ( '}' ) ;
    public final void rule__ReteRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2209:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2210:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2210:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2211:1: '}'
            {
             before(grammarAccess.getReteRecipeAccess().getRightCurlyBracketKeyword_7()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ReteRecipe__Group__7__Impl4383); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2240:1: rule__ProductionRecipe__Group__0 : rule__ProductionRecipe__Group__0__Impl rule__ProductionRecipe__Group__1 ;
    public final void rule__ProductionRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2244:1: ( rule__ProductionRecipe__Group__0__Impl rule__ProductionRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2245:2: rule__ProductionRecipe__Group__0__Impl rule__ProductionRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__0__Impl_in_rule__ProductionRecipe__Group__04430);
            rule__ProductionRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__1_in_rule__ProductionRecipe__Group__04433);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2252:1: rule__ProductionRecipe__Group__0__Impl : ( 'Production' ) ;
    public final void rule__ProductionRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2256:1: ( ( 'Production' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2257:1: ( 'Production' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2257:1: ( 'Production' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2258:1: 'Production'
            {
             before(grammarAccess.getProductionRecipeAccess().getProductionKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__ProductionRecipe__Group__0__Impl4461); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2271:1: rule__ProductionRecipe__Group__1 : rule__ProductionRecipe__Group__1__Impl rule__ProductionRecipe__Group__2 ;
    public final void rule__ProductionRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2275:1: ( rule__ProductionRecipe__Group__1__Impl rule__ProductionRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2276:2: rule__ProductionRecipe__Group__1__Impl rule__ProductionRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__1__Impl_in_rule__ProductionRecipe__Group__14492);
            rule__ProductionRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__2_in_rule__ProductionRecipe__Group__14495);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2283:1: rule__ProductionRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__ProductionRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2287:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2288:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2288:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2289:1: '{'
            {
             before(grammarAccess.getProductionRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__ProductionRecipe__Group__1__Impl4523); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2302:1: rule__ProductionRecipe__Group__2 : rule__ProductionRecipe__Group__2__Impl rule__ProductionRecipe__Group__3 ;
    public final void rule__ProductionRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2306:1: ( rule__ProductionRecipe__Group__2__Impl rule__ProductionRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2307:2: rule__ProductionRecipe__Group__2__Impl rule__ProductionRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__2__Impl_in_rule__ProductionRecipe__Group__24554);
            rule__ProductionRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__3_in_rule__ProductionRecipe__Group__24557);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2314:1: rule__ProductionRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__ProductionRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2318:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2319:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2319:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2320:1: 'traceInfo'
            {
             before(grammarAccess.getProductionRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__ProductionRecipe__Group__2__Impl4585); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2333:1: rule__ProductionRecipe__Group__3 : rule__ProductionRecipe__Group__3__Impl rule__ProductionRecipe__Group__4 ;
    public final void rule__ProductionRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2337:1: ( rule__ProductionRecipe__Group__3__Impl rule__ProductionRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2338:2: rule__ProductionRecipe__Group__3__Impl rule__ProductionRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__3__Impl_in_rule__ProductionRecipe__Group__34616);
            rule__ProductionRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__4_in_rule__ProductionRecipe__Group__34619);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2345:1: rule__ProductionRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__ProductionRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2349:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2350:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2350:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2351:1: ':'
            {
             before(grammarAccess.getProductionRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProductionRecipe__Group__3__Impl4647); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2364:1: rule__ProductionRecipe__Group__4 : rule__ProductionRecipe__Group__4__Impl rule__ProductionRecipe__Group__5 ;
    public final void rule__ProductionRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2368:1: ( rule__ProductionRecipe__Group__4__Impl rule__ProductionRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2369:2: rule__ProductionRecipe__Group__4__Impl rule__ProductionRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__4__Impl_in_rule__ProductionRecipe__Group__44678);
            rule__ProductionRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__5_in_rule__ProductionRecipe__Group__44681);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2376:1: rule__ProductionRecipe__Group__4__Impl : ( ( rule__ProductionRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__ProductionRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2380:1: ( ( ( rule__ProductionRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2381:1: ( ( rule__ProductionRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2381:1: ( ( rule__ProductionRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2382:1: ( rule__ProductionRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getProductionRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2383:1: ( rule__ProductionRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2383:2: rule__ProductionRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__TraceInfoAssignment_4_in_rule__ProductionRecipe__Group__4__Impl4708);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2393:1: rule__ProductionRecipe__Group__5 : rule__ProductionRecipe__Group__5__Impl rule__ProductionRecipe__Group__6 ;
    public final void rule__ProductionRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2397:1: ( rule__ProductionRecipe__Group__5__Impl rule__ProductionRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2398:2: rule__ProductionRecipe__Group__5__Impl rule__ProductionRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__5__Impl_in_rule__ProductionRecipe__Group__54738);
            rule__ProductionRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__6_in_rule__ProductionRecipe__Group__54741);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2405:1: rule__ProductionRecipe__Group__5__Impl : ( 'parents' ) ;
    public final void rule__ProductionRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2409:1: ( ( 'parents' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2410:1: ( 'parents' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2410:1: ( 'parents' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2411:1: 'parents'
            {
             before(grammarAccess.getProductionRecipeAccess().getParentsKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__ProductionRecipe__Group__5__Impl4769); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2424:1: rule__ProductionRecipe__Group__6 : rule__ProductionRecipe__Group__6__Impl rule__ProductionRecipe__Group__7 ;
    public final void rule__ProductionRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2428:1: ( rule__ProductionRecipe__Group__6__Impl rule__ProductionRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2429:2: rule__ProductionRecipe__Group__6__Impl rule__ProductionRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__6__Impl_in_rule__ProductionRecipe__Group__64800);
            rule__ProductionRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__7_in_rule__ProductionRecipe__Group__64803);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2436:1: rule__ProductionRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__ProductionRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2440:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2441:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2441:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2442:1: ':'
            {
             before(grammarAccess.getProductionRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProductionRecipe__Group__6__Impl4831); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2455:1: rule__ProductionRecipe__Group__7 : rule__ProductionRecipe__Group__7__Impl rule__ProductionRecipe__Group__8 ;
    public final void rule__ProductionRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2459:1: ( rule__ProductionRecipe__Group__7__Impl rule__ProductionRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2460:2: rule__ProductionRecipe__Group__7__Impl rule__ProductionRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__7__Impl_in_rule__ProductionRecipe__Group__74862);
            rule__ProductionRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__8_in_rule__ProductionRecipe__Group__74865);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2467:1: rule__ProductionRecipe__Group__7__Impl : ( '[' ) ;
    public final void rule__ProductionRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2471:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2472:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2472:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2473:1: '['
            {
             before(grammarAccess.getProductionRecipeAccess().getLeftSquareBracketKeyword_7()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__ProductionRecipe__Group__7__Impl4893); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2486:1: rule__ProductionRecipe__Group__8 : rule__ProductionRecipe__Group__8__Impl rule__ProductionRecipe__Group__9 ;
    public final void rule__ProductionRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2490:1: ( rule__ProductionRecipe__Group__8__Impl rule__ProductionRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2491:2: rule__ProductionRecipe__Group__8__Impl rule__ProductionRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__8__Impl_in_rule__ProductionRecipe__Group__84924);
            rule__ProductionRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__9_in_rule__ProductionRecipe__Group__84927);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2498:1: rule__ProductionRecipe__Group__8__Impl : ( ( rule__ProductionRecipe__ParentsAssignment_8 )* ) ;
    public final void rule__ProductionRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2502:1: ( ( ( rule__ProductionRecipe__ParentsAssignment_8 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2503:1: ( ( rule__ProductionRecipe__ParentsAssignment_8 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2503:1: ( ( rule__ProductionRecipe__ParentsAssignment_8 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2504:1: ( rule__ProductionRecipe__ParentsAssignment_8 )*
            {
             before(grammarAccess.getProductionRecipeAccess().getParentsAssignment_8()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2505:1: ( rule__ProductionRecipe__ParentsAssignment_8 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2505:2: rule__ProductionRecipe__ParentsAssignment_8
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__ParentsAssignment_8_in_rule__ProductionRecipe__Group__8__Impl4954);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2515:1: rule__ProductionRecipe__Group__9 : rule__ProductionRecipe__Group__9__Impl rule__ProductionRecipe__Group__10 ;
    public final void rule__ProductionRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2519:1: ( rule__ProductionRecipe__Group__9__Impl rule__ProductionRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2520:2: rule__ProductionRecipe__Group__9__Impl rule__ProductionRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__9__Impl_in_rule__ProductionRecipe__Group__94985);
            rule__ProductionRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__10_in_rule__ProductionRecipe__Group__94988);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2527:1: rule__ProductionRecipe__Group__9__Impl : ( ']' ) ;
    public final void rule__ProductionRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2531:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2532:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2532:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2533:1: ']'
            {
             before(grammarAccess.getProductionRecipeAccess().getRightSquareBracketKeyword_9()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__ProductionRecipe__Group__9__Impl5016); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2546:1: rule__ProductionRecipe__Group__10 : rule__ProductionRecipe__Group__10__Impl ;
    public final void rule__ProductionRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2550:1: ( rule__ProductionRecipe__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2551:2: rule__ProductionRecipe__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProductionRecipe__Group__10__Impl_in_rule__ProductionRecipe__Group__105047);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2557:1: rule__ProductionRecipe__Group__10__Impl : ( '}' ) ;
    public final void rule__ProductionRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2561:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2562:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2562:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2563:1: '}'
            {
             before(grammarAccess.getProductionRecipeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ProductionRecipe__Group__10__Impl5075); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2598:1: rule__UniquenessEnforcerRecipe__Group__0 : rule__UniquenessEnforcerRecipe__Group__0__Impl rule__UniquenessEnforcerRecipe__Group__1 ;
    public final void rule__UniquenessEnforcerRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2602:1: ( rule__UniquenessEnforcerRecipe__Group__0__Impl rule__UniquenessEnforcerRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2603:2: rule__UniquenessEnforcerRecipe__Group__0__Impl rule__UniquenessEnforcerRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__0__Impl_in_rule__UniquenessEnforcerRecipe__Group__05128);
            rule__UniquenessEnforcerRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__1_in_rule__UniquenessEnforcerRecipe__Group__05131);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2610:1: rule__UniquenessEnforcerRecipe__Group__0__Impl : ( 'UniquenessEnforcer' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2614:1: ( ( 'UniquenessEnforcer' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2615:1: ( 'UniquenessEnforcer' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2615:1: ( 'UniquenessEnforcer' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2616:1: 'UniquenessEnforcer'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getUniquenessEnforcerKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__UniquenessEnforcerRecipe__Group__0__Impl5159); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2629:1: rule__UniquenessEnforcerRecipe__Group__1 : rule__UniquenessEnforcerRecipe__Group__1__Impl rule__UniquenessEnforcerRecipe__Group__2 ;
    public final void rule__UniquenessEnforcerRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2633:1: ( rule__UniquenessEnforcerRecipe__Group__1__Impl rule__UniquenessEnforcerRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2634:2: rule__UniquenessEnforcerRecipe__Group__1__Impl rule__UniquenessEnforcerRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__1__Impl_in_rule__UniquenessEnforcerRecipe__Group__15190);
            rule__UniquenessEnforcerRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__2_in_rule__UniquenessEnforcerRecipe__Group__15193);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2641:1: rule__UniquenessEnforcerRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2645:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2646:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2646:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2647:1: '{'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__UniquenessEnforcerRecipe__Group__1__Impl5221); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2660:1: rule__UniquenessEnforcerRecipe__Group__2 : rule__UniquenessEnforcerRecipe__Group__2__Impl rule__UniquenessEnforcerRecipe__Group__3 ;
    public final void rule__UniquenessEnforcerRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2664:1: ( rule__UniquenessEnforcerRecipe__Group__2__Impl rule__UniquenessEnforcerRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2665:2: rule__UniquenessEnforcerRecipe__Group__2__Impl rule__UniquenessEnforcerRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__2__Impl_in_rule__UniquenessEnforcerRecipe__Group__25252);
            rule__UniquenessEnforcerRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__3_in_rule__UniquenessEnforcerRecipe__Group__25255);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2672:1: rule__UniquenessEnforcerRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2676:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2677:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2677:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2678:1: 'traceInfo'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__UniquenessEnforcerRecipe__Group__2__Impl5283); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2691:1: rule__UniquenessEnforcerRecipe__Group__3 : rule__UniquenessEnforcerRecipe__Group__3__Impl rule__UniquenessEnforcerRecipe__Group__4 ;
    public final void rule__UniquenessEnforcerRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2695:1: ( rule__UniquenessEnforcerRecipe__Group__3__Impl rule__UniquenessEnforcerRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2696:2: rule__UniquenessEnforcerRecipe__Group__3__Impl rule__UniquenessEnforcerRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__3__Impl_in_rule__UniquenessEnforcerRecipe__Group__35314);
            rule__UniquenessEnforcerRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__4_in_rule__UniquenessEnforcerRecipe__Group__35317);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2703:1: rule__UniquenessEnforcerRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2707:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2708:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2708:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2709:1: ':'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__UniquenessEnforcerRecipe__Group__3__Impl5345); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2722:1: rule__UniquenessEnforcerRecipe__Group__4 : rule__UniquenessEnforcerRecipe__Group__4__Impl rule__UniquenessEnforcerRecipe__Group__5 ;
    public final void rule__UniquenessEnforcerRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2726:1: ( rule__UniquenessEnforcerRecipe__Group__4__Impl rule__UniquenessEnforcerRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2727:2: rule__UniquenessEnforcerRecipe__Group__4__Impl rule__UniquenessEnforcerRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__4__Impl_in_rule__UniquenessEnforcerRecipe__Group__45376);
            rule__UniquenessEnforcerRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__5_in_rule__UniquenessEnforcerRecipe__Group__45379);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2734:1: rule__UniquenessEnforcerRecipe__Group__4__Impl : ( ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2738:1: ( ( ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2739:1: ( ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2739:1: ( ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2740:1: ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2741:1: ( rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2741:2: rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4_in_rule__UniquenessEnforcerRecipe__Group__4__Impl5406);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2751:1: rule__UniquenessEnforcerRecipe__Group__5 : rule__UniquenessEnforcerRecipe__Group__5__Impl rule__UniquenessEnforcerRecipe__Group__6 ;
    public final void rule__UniquenessEnforcerRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2755:1: ( rule__UniquenessEnforcerRecipe__Group__5__Impl rule__UniquenessEnforcerRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2756:2: rule__UniquenessEnforcerRecipe__Group__5__Impl rule__UniquenessEnforcerRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__5__Impl_in_rule__UniquenessEnforcerRecipe__Group__55436);
            rule__UniquenessEnforcerRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__6_in_rule__UniquenessEnforcerRecipe__Group__55439);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2763:1: rule__UniquenessEnforcerRecipe__Group__5__Impl : ( 'parents' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2767:1: ( ( 'parents' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2768:1: ( 'parents' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2768:1: ( 'parents' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2769:1: 'parents'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsKeyword_5()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__UniquenessEnforcerRecipe__Group__5__Impl5467); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2782:1: rule__UniquenessEnforcerRecipe__Group__6 : rule__UniquenessEnforcerRecipe__Group__6__Impl rule__UniquenessEnforcerRecipe__Group__7 ;
    public final void rule__UniquenessEnforcerRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2786:1: ( rule__UniquenessEnforcerRecipe__Group__6__Impl rule__UniquenessEnforcerRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2787:2: rule__UniquenessEnforcerRecipe__Group__6__Impl rule__UniquenessEnforcerRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__6__Impl_in_rule__UniquenessEnforcerRecipe__Group__65498);
            rule__UniquenessEnforcerRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__7_in_rule__UniquenessEnforcerRecipe__Group__65501);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2794:1: rule__UniquenessEnforcerRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2798:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2799:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2799:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2800:1: ':'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__UniquenessEnforcerRecipe__Group__6__Impl5529); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2813:1: rule__UniquenessEnforcerRecipe__Group__7 : rule__UniquenessEnforcerRecipe__Group__7__Impl rule__UniquenessEnforcerRecipe__Group__8 ;
    public final void rule__UniquenessEnforcerRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2817:1: ( rule__UniquenessEnforcerRecipe__Group__7__Impl rule__UniquenessEnforcerRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2818:2: rule__UniquenessEnforcerRecipe__Group__7__Impl rule__UniquenessEnforcerRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__7__Impl_in_rule__UniquenessEnforcerRecipe__Group__75560);
            rule__UniquenessEnforcerRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__8_in_rule__UniquenessEnforcerRecipe__Group__75563);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2825:1: rule__UniquenessEnforcerRecipe__Group__7__Impl : ( '[' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2829:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2830:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2830:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2831:1: '['
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getLeftSquareBracketKeyword_7()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__UniquenessEnforcerRecipe__Group__7__Impl5591); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2844:1: rule__UniquenessEnforcerRecipe__Group__8 : rule__UniquenessEnforcerRecipe__Group__8__Impl rule__UniquenessEnforcerRecipe__Group__9 ;
    public final void rule__UniquenessEnforcerRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2848:1: ( rule__UniquenessEnforcerRecipe__Group__8__Impl rule__UniquenessEnforcerRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2849:2: rule__UniquenessEnforcerRecipe__Group__8__Impl rule__UniquenessEnforcerRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__8__Impl_in_rule__UniquenessEnforcerRecipe__Group__85622);
            rule__UniquenessEnforcerRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__9_in_rule__UniquenessEnforcerRecipe__Group__85625);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2856:1: rule__UniquenessEnforcerRecipe__Group__8__Impl : ( ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )* ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2860:1: ( ( ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2861:1: ( ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2861:1: ( ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2862:1: ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )*
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsAssignment_8()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2863:1: ( rule__UniquenessEnforcerRecipe__ParentsAssignment_8 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2863:2: rule__UniquenessEnforcerRecipe__ParentsAssignment_8
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__ParentsAssignment_8_in_rule__UniquenessEnforcerRecipe__Group__8__Impl5652);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2873:1: rule__UniquenessEnforcerRecipe__Group__9 : rule__UniquenessEnforcerRecipe__Group__9__Impl rule__UniquenessEnforcerRecipe__Group__10 ;
    public final void rule__UniquenessEnforcerRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2877:1: ( rule__UniquenessEnforcerRecipe__Group__9__Impl rule__UniquenessEnforcerRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2878:2: rule__UniquenessEnforcerRecipe__Group__9__Impl rule__UniquenessEnforcerRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__9__Impl_in_rule__UniquenessEnforcerRecipe__Group__95683);
            rule__UniquenessEnforcerRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__10_in_rule__UniquenessEnforcerRecipe__Group__95686);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2885:1: rule__UniquenessEnforcerRecipe__Group__9__Impl : ( ']' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2889:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2890:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2890:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2891:1: ']'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getRightSquareBracketKeyword_9()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__UniquenessEnforcerRecipe__Group__9__Impl5714); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2904:1: rule__UniquenessEnforcerRecipe__Group__10 : rule__UniquenessEnforcerRecipe__Group__10__Impl ;
    public final void rule__UniquenessEnforcerRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2908:1: ( rule__UniquenessEnforcerRecipe__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2909:2: rule__UniquenessEnforcerRecipe__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__UniquenessEnforcerRecipe__Group__10__Impl_in_rule__UniquenessEnforcerRecipe__Group__105745);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2915:1: rule__UniquenessEnforcerRecipe__Group__10__Impl : ( '}' ) ;
    public final void rule__UniquenessEnforcerRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2919:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2920:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2920:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2921:1: '}'
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__UniquenessEnforcerRecipe__Group__10__Impl5773); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2956:1: rule__CheckRecipe__Group__0 : rule__CheckRecipe__Group__0__Impl rule__CheckRecipe__Group__1 ;
    public final void rule__CheckRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2960:1: ( rule__CheckRecipe__Group__0__Impl rule__CheckRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2961:2: rule__CheckRecipe__Group__0__Impl rule__CheckRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__0__Impl_in_rule__CheckRecipe__Group__05826);
            rule__CheckRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__1_in_rule__CheckRecipe__Group__05829);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2968:1: rule__CheckRecipe__Group__0__Impl : ( 'Check' ) ;
    public final void rule__CheckRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2972:1: ( ( 'Check' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2973:1: ( 'Check' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2973:1: ( 'Check' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2974:1: 'Check'
            {
             before(grammarAccess.getCheckRecipeAccess().getCheckKeyword_0()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__CheckRecipe__Group__0__Impl5857); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2987:1: rule__CheckRecipe__Group__1 : rule__CheckRecipe__Group__1__Impl rule__CheckRecipe__Group__2 ;
    public final void rule__CheckRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2991:1: ( rule__CheckRecipe__Group__1__Impl rule__CheckRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2992:2: rule__CheckRecipe__Group__1__Impl rule__CheckRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__1__Impl_in_rule__CheckRecipe__Group__15888);
            rule__CheckRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__2_in_rule__CheckRecipe__Group__15891);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:2999:1: rule__CheckRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__CheckRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3003:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3004:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3004:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3005:1: '{'
            {
             before(grammarAccess.getCheckRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__CheckRecipe__Group__1__Impl5919); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3018:1: rule__CheckRecipe__Group__2 : rule__CheckRecipe__Group__2__Impl rule__CheckRecipe__Group__3 ;
    public final void rule__CheckRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3022:1: ( rule__CheckRecipe__Group__2__Impl rule__CheckRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3023:2: rule__CheckRecipe__Group__2__Impl rule__CheckRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__2__Impl_in_rule__CheckRecipe__Group__25950);
            rule__CheckRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__3_in_rule__CheckRecipe__Group__25953);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3030:1: rule__CheckRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__CheckRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3034:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3035:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3035:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3036:1: 'traceInfo'
            {
             before(grammarAccess.getCheckRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__CheckRecipe__Group__2__Impl5981); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3049:1: rule__CheckRecipe__Group__3 : rule__CheckRecipe__Group__3__Impl rule__CheckRecipe__Group__4 ;
    public final void rule__CheckRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3053:1: ( rule__CheckRecipe__Group__3__Impl rule__CheckRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3054:2: rule__CheckRecipe__Group__3__Impl rule__CheckRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__3__Impl_in_rule__CheckRecipe__Group__36012);
            rule__CheckRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__4_in_rule__CheckRecipe__Group__36015);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3061:1: rule__CheckRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__CheckRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3065:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3066:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3066:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3067:1: ':'
            {
             before(grammarAccess.getCheckRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__CheckRecipe__Group__3__Impl6043); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3080:1: rule__CheckRecipe__Group__4 : rule__CheckRecipe__Group__4__Impl rule__CheckRecipe__Group__5 ;
    public final void rule__CheckRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3084:1: ( rule__CheckRecipe__Group__4__Impl rule__CheckRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3085:2: rule__CheckRecipe__Group__4__Impl rule__CheckRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__4__Impl_in_rule__CheckRecipe__Group__46074);
            rule__CheckRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__5_in_rule__CheckRecipe__Group__46077);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3092:1: rule__CheckRecipe__Group__4__Impl : ( ( rule__CheckRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__CheckRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3096:1: ( ( ( rule__CheckRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3097:1: ( ( rule__CheckRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3097:1: ( ( rule__CheckRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3098:1: ( rule__CheckRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getCheckRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3099:1: ( rule__CheckRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3099:2: rule__CheckRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__TraceInfoAssignment_4_in_rule__CheckRecipe__Group__4__Impl6104);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3109:1: rule__CheckRecipe__Group__5 : rule__CheckRecipe__Group__5__Impl rule__CheckRecipe__Group__6 ;
    public final void rule__CheckRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3113:1: ( rule__CheckRecipe__Group__5__Impl rule__CheckRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3114:2: rule__CheckRecipe__Group__5__Impl rule__CheckRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__5__Impl_in_rule__CheckRecipe__Group__56134);
            rule__CheckRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__6_in_rule__CheckRecipe__Group__56137);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3121:1: rule__CheckRecipe__Group__5__Impl : ( 'parent' ) ;
    public final void rule__CheckRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3125:1: ( ( 'parent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3126:1: ( 'parent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3126:1: ( 'parent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3127:1: 'parent'
            {
             before(grammarAccess.getCheckRecipeAccess().getParentKeyword_5()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__CheckRecipe__Group__5__Impl6165); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3140:1: rule__CheckRecipe__Group__6 : rule__CheckRecipe__Group__6__Impl rule__CheckRecipe__Group__7 ;
    public final void rule__CheckRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3144:1: ( rule__CheckRecipe__Group__6__Impl rule__CheckRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3145:2: rule__CheckRecipe__Group__6__Impl rule__CheckRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__6__Impl_in_rule__CheckRecipe__Group__66196);
            rule__CheckRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__7_in_rule__CheckRecipe__Group__66199);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3152:1: rule__CheckRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__CheckRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3156:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3157:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3157:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3158:1: ':'
            {
             before(grammarAccess.getCheckRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__CheckRecipe__Group__6__Impl6227); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3171:1: rule__CheckRecipe__Group__7 : rule__CheckRecipe__Group__7__Impl rule__CheckRecipe__Group__8 ;
    public final void rule__CheckRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3175:1: ( rule__CheckRecipe__Group__7__Impl rule__CheckRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3176:2: rule__CheckRecipe__Group__7__Impl rule__CheckRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__7__Impl_in_rule__CheckRecipe__Group__76258);
            rule__CheckRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__8_in_rule__CheckRecipe__Group__76261);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3183:1: rule__CheckRecipe__Group__7__Impl : ( ( rule__CheckRecipe__ParentAssignment_7 ) ) ;
    public final void rule__CheckRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3187:1: ( ( ( rule__CheckRecipe__ParentAssignment_7 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3188:1: ( ( rule__CheckRecipe__ParentAssignment_7 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3188:1: ( ( rule__CheckRecipe__ParentAssignment_7 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3189:1: ( rule__CheckRecipe__ParentAssignment_7 )
            {
             before(grammarAccess.getCheckRecipeAccess().getParentAssignment_7()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3190:1: ( rule__CheckRecipe__ParentAssignment_7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3190:2: rule__CheckRecipe__ParentAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__ParentAssignment_7_in_rule__CheckRecipe__Group__7__Impl6288);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3200:1: rule__CheckRecipe__Group__8 : rule__CheckRecipe__Group__8__Impl ;
    public final void rule__CheckRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3204:1: ( rule__CheckRecipe__Group__8__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3205:2: rule__CheckRecipe__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CheckRecipe__Group__8__Impl_in_rule__CheckRecipe__Group__86318);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3211:1: rule__CheckRecipe__Group__8__Impl : ( '}' ) ;
    public final void rule__CheckRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3215:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3216:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3216:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3217:1: '}'
            {
             before(grammarAccess.getCheckRecipeAccess().getRightCurlyBracketKeyword_8()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__CheckRecipe__Group__8__Impl6346); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3248:1: rule__TrimmerRecipe__Group__0 : rule__TrimmerRecipe__Group__0__Impl rule__TrimmerRecipe__Group__1 ;
    public final void rule__TrimmerRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3252:1: ( rule__TrimmerRecipe__Group__0__Impl rule__TrimmerRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3253:2: rule__TrimmerRecipe__Group__0__Impl rule__TrimmerRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__0__Impl_in_rule__TrimmerRecipe__Group__06395);
            rule__TrimmerRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__1_in_rule__TrimmerRecipe__Group__06398);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3260:1: rule__TrimmerRecipe__Group__0__Impl : ( 'Trimmer' ) ;
    public final void rule__TrimmerRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3264:1: ( ( 'Trimmer' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3265:1: ( 'Trimmer' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3265:1: ( 'Trimmer' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3266:1: 'Trimmer'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getTrimmerKeyword_0()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__TrimmerRecipe__Group__0__Impl6426); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3279:1: rule__TrimmerRecipe__Group__1 : rule__TrimmerRecipe__Group__1__Impl rule__TrimmerRecipe__Group__2 ;
    public final void rule__TrimmerRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3283:1: ( rule__TrimmerRecipe__Group__1__Impl rule__TrimmerRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3284:2: rule__TrimmerRecipe__Group__1__Impl rule__TrimmerRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__1__Impl_in_rule__TrimmerRecipe__Group__16457);
            rule__TrimmerRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__2_in_rule__TrimmerRecipe__Group__16460);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3291:1: rule__TrimmerRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__TrimmerRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3295:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3296:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3296:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3297:1: '{'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__TrimmerRecipe__Group__1__Impl6488); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3310:1: rule__TrimmerRecipe__Group__2 : rule__TrimmerRecipe__Group__2__Impl rule__TrimmerRecipe__Group__3 ;
    public final void rule__TrimmerRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3314:1: ( rule__TrimmerRecipe__Group__2__Impl rule__TrimmerRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3315:2: rule__TrimmerRecipe__Group__2__Impl rule__TrimmerRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__2__Impl_in_rule__TrimmerRecipe__Group__26519);
            rule__TrimmerRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__3_in_rule__TrimmerRecipe__Group__26522);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3322:1: rule__TrimmerRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__TrimmerRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3326:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3327:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3327:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3328:1: 'traceInfo'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__TrimmerRecipe__Group__2__Impl6550); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3341:1: rule__TrimmerRecipe__Group__3 : rule__TrimmerRecipe__Group__3__Impl rule__TrimmerRecipe__Group__4 ;
    public final void rule__TrimmerRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3345:1: ( rule__TrimmerRecipe__Group__3__Impl rule__TrimmerRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3346:2: rule__TrimmerRecipe__Group__3__Impl rule__TrimmerRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__3__Impl_in_rule__TrimmerRecipe__Group__36581);
            rule__TrimmerRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__4_in_rule__TrimmerRecipe__Group__36584);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3353:1: rule__TrimmerRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__TrimmerRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3357:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3358:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3358:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3359:1: ':'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__TrimmerRecipe__Group__3__Impl6612); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3372:1: rule__TrimmerRecipe__Group__4 : rule__TrimmerRecipe__Group__4__Impl rule__TrimmerRecipe__Group__5 ;
    public final void rule__TrimmerRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3376:1: ( rule__TrimmerRecipe__Group__4__Impl rule__TrimmerRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3377:2: rule__TrimmerRecipe__Group__4__Impl rule__TrimmerRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__4__Impl_in_rule__TrimmerRecipe__Group__46643);
            rule__TrimmerRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__5_in_rule__TrimmerRecipe__Group__46646);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3384:1: rule__TrimmerRecipe__Group__4__Impl : ( ( rule__TrimmerRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__TrimmerRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3388:1: ( ( ( rule__TrimmerRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3389:1: ( ( rule__TrimmerRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3389:1: ( ( rule__TrimmerRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3390:1: ( rule__TrimmerRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3391:1: ( rule__TrimmerRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3391:2: rule__TrimmerRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__TraceInfoAssignment_4_in_rule__TrimmerRecipe__Group__4__Impl6673);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3401:1: rule__TrimmerRecipe__Group__5 : rule__TrimmerRecipe__Group__5__Impl rule__TrimmerRecipe__Group__6 ;
    public final void rule__TrimmerRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3405:1: ( rule__TrimmerRecipe__Group__5__Impl rule__TrimmerRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3406:2: rule__TrimmerRecipe__Group__5__Impl rule__TrimmerRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__5__Impl_in_rule__TrimmerRecipe__Group__56703);
            rule__TrimmerRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__6_in_rule__TrimmerRecipe__Group__56706);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3413:1: rule__TrimmerRecipe__Group__5__Impl : ( 'mask' ) ;
    public final void rule__TrimmerRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3417:1: ( ( 'mask' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3418:1: ( 'mask' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3418:1: ( 'mask' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3419:1: 'mask'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getMaskKeyword_5()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__TrimmerRecipe__Group__5__Impl6734); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3432:1: rule__TrimmerRecipe__Group__6 : rule__TrimmerRecipe__Group__6__Impl rule__TrimmerRecipe__Group__7 ;
    public final void rule__TrimmerRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3436:1: ( rule__TrimmerRecipe__Group__6__Impl rule__TrimmerRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3437:2: rule__TrimmerRecipe__Group__6__Impl rule__TrimmerRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__6__Impl_in_rule__TrimmerRecipe__Group__66765);
            rule__TrimmerRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__7_in_rule__TrimmerRecipe__Group__66768);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3444:1: rule__TrimmerRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__TrimmerRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3448:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3449:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3449:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3450:1: ':'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__TrimmerRecipe__Group__6__Impl6796); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3463:1: rule__TrimmerRecipe__Group__7 : rule__TrimmerRecipe__Group__7__Impl rule__TrimmerRecipe__Group__8 ;
    public final void rule__TrimmerRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3467:1: ( rule__TrimmerRecipe__Group__7__Impl rule__TrimmerRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3468:2: rule__TrimmerRecipe__Group__7__Impl rule__TrimmerRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__7__Impl_in_rule__TrimmerRecipe__Group__76827);
            rule__TrimmerRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__8_in_rule__TrimmerRecipe__Group__76830);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3475:1: rule__TrimmerRecipe__Group__7__Impl : ( ( rule__TrimmerRecipe__MaskAssignment_7 ) ) ;
    public final void rule__TrimmerRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3479:1: ( ( ( rule__TrimmerRecipe__MaskAssignment_7 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3480:1: ( ( rule__TrimmerRecipe__MaskAssignment_7 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3480:1: ( ( rule__TrimmerRecipe__MaskAssignment_7 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3481:1: ( rule__TrimmerRecipe__MaskAssignment_7 )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getMaskAssignment_7()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3482:1: ( rule__TrimmerRecipe__MaskAssignment_7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3482:2: rule__TrimmerRecipe__MaskAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__MaskAssignment_7_in_rule__TrimmerRecipe__Group__7__Impl6857);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3492:1: rule__TrimmerRecipe__Group__8 : rule__TrimmerRecipe__Group__8__Impl rule__TrimmerRecipe__Group__9 ;
    public final void rule__TrimmerRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3496:1: ( rule__TrimmerRecipe__Group__8__Impl rule__TrimmerRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3497:2: rule__TrimmerRecipe__Group__8__Impl rule__TrimmerRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__8__Impl_in_rule__TrimmerRecipe__Group__86887);
            rule__TrimmerRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__9_in_rule__TrimmerRecipe__Group__86890);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3504:1: rule__TrimmerRecipe__Group__8__Impl : ( 'parent' ) ;
    public final void rule__TrimmerRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3508:1: ( ( 'parent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3509:1: ( 'parent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3509:1: ( 'parent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3510:1: 'parent'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getParentKeyword_8()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TrimmerRecipe__Group__8__Impl6918); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3523:1: rule__TrimmerRecipe__Group__9 : rule__TrimmerRecipe__Group__9__Impl rule__TrimmerRecipe__Group__10 ;
    public final void rule__TrimmerRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3527:1: ( rule__TrimmerRecipe__Group__9__Impl rule__TrimmerRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3528:2: rule__TrimmerRecipe__Group__9__Impl rule__TrimmerRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__9__Impl_in_rule__TrimmerRecipe__Group__96949);
            rule__TrimmerRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__10_in_rule__TrimmerRecipe__Group__96952);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3535:1: rule__TrimmerRecipe__Group__9__Impl : ( ':' ) ;
    public final void rule__TrimmerRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3539:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3540:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3540:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3541:1: ':'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getColonKeyword_9()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__TrimmerRecipe__Group__9__Impl6980); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3554:1: rule__TrimmerRecipe__Group__10 : rule__TrimmerRecipe__Group__10__Impl rule__TrimmerRecipe__Group__11 ;
    public final void rule__TrimmerRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3558:1: ( rule__TrimmerRecipe__Group__10__Impl rule__TrimmerRecipe__Group__11 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3559:2: rule__TrimmerRecipe__Group__10__Impl rule__TrimmerRecipe__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__10__Impl_in_rule__TrimmerRecipe__Group__107011);
            rule__TrimmerRecipe__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__11_in_rule__TrimmerRecipe__Group__107014);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3566:1: rule__TrimmerRecipe__Group__10__Impl : ( ( rule__TrimmerRecipe__ParentAssignment_10 ) ) ;
    public final void rule__TrimmerRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3570:1: ( ( ( rule__TrimmerRecipe__ParentAssignment_10 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3571:1: ( ( rule__TrimmerRecipe__ParentAssignment_10 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3571:1: ( ( rule__TrimmerRecipe__ParentAssignment_10 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3572:1: ( rule__TrimmerRecipe__ParentAssignment_10 )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getParentAssignment_10()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3573:1: ( rule__TrimmerRecipe__ParentAssignment_10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3573:2: rule__TrimmerRecipe__ParentAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__ParentAssignment_10_in_rule__TrimmerRecipe__Group__10__Impl7041);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3583:1: rule__TrimmerRecipe__Group__11 : rule__TrimmerRecipe__Group__11__Impl ;
    public final void rule__TrimmerRecipe__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3587:1: ( rule__TrimmerRecipe__Group__11__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3588:2: rule__TrimmerRecipe__Group__11__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TrimmerRecipe__Group__11__Impl_in_rule__TrimmerRecipe__Group__117071);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3594:1: rule__TrimmerRecipe__Group__11__Impl : ( '}' ) ;
    public final void rule__TrimmerRecipe__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3598:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3599:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3599:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3600:1: '}'
            {
             before(grammarAccess.getTrimmerRecipeAccess().getRightCurlyBracketKeyword_11()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__TrimmerRecipe__Group__11__Impl7099); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3637:1: rule__JoinRecipe__Group__0 : rule__JoinRecipe__Group__0__Impl rule__JoinRecipe__Group__1 ;
    public final void rule__JoinRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3641:1: ( rule__JoinRecipe__Group__0__Impl rule__JoinRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3642:2: rule__JoinRecipe__Group__0__Impl rule__JoinRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__0__Impl_in_rule__JoinRecipe__Group__07154);
            rule__JoinRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__1_in_rule__JoinRecipe__Group__07157);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3649:1: rule__JoinRecipe__Group__0__Impl : ( 'Join' ) ;
    public final void rule__JoinRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3653:1: ( ( 'Join' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3654:1: ( 'Join' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3654:1: ( 'Join' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3655:1: 'Join'
            {
             before(grammarAccess.getJoinRecipeAccess().getJoinKeyword_0()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__JoinRecipe__Group__0__Impl7185); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3668:1: rule__JoinRecipe__Group__1 : rule__JoinRecipe__Group__1__Impl rule__JoinRecipe__Group__2 ;
    public final void rule__JoinRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3672:1: ( rule__JoinRecipe__Group__1__Impl rule__JoinRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3673:2: rule__JoinRecipe__Group__1__Impl rule__JoinRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__1__Impl_in_rule__JoinRecipe__Group__17216);
            rule__JoinRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__2_in_rule__JoinRecipe__Group__17219);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3680:1: rule__JoinRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__JoinRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3684:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3685:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3685:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3686:1: '{'
            {
             before(grammarAccess.getJoinRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__JoinRecipe__Group__1__Impl7247); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3699:1: rule__JoinRecipe__Group__2 : rule__JoinRecipe__Group__2__Impl rule__JoinRecipe__Group__3 ;
    public final void rule__JoinRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3703:1: ( rule__JoinRecipe__Group__2__Impl rule__JoinRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3704:2: rule__JoinRecipe__Group__2__Impl rule__JoinRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__2__Impl_in_rule__JoinRecipe__Group__27278);
            rule__JoinRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__3_in_rule__JoinRecipe__Group__27281);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3711:1: rule__JoinRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__JoinRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3715:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3716:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3716:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3717:1: 'traceInfo'
            {
             before(grammarAccess.getJoinRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__JoinRecipe__Group__2__Impl7309); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3730:1: rule__JoinRecipe__Group__3 : rule__JoinRecipe__Group__3__Impl rule__JoinRecipe__Group__4 ;
    public final void rule__JoinRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3734:1: ( rule__JoinRecipe__Group__3__Impl rule__JoinRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3735:2: rule__JoinRecipe__Group__3__Impl rule__JoinRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__3__Impl_in_rule__JoinRecipe__Group__37340);
            rule__JoinRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__4_in_rule__JoinRecipe__Group__37343);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3742:1: rule__JoinRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__JoinRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3746:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3747:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3747:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3748:1: ':'
            {
             before(grammarAccess.getJoinRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__JoinRecipe__Group__3__Impl7371); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3761:1: rule__JoinRecipe__Group__4 : rule__JoinRecipe__Group__4__Impl rule__JoinRecipe__Group__5 ;
    public final void rule__JoinRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3765:1: ( rule__JoinRecipe__Group__4__Impl rule__JoinRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3766:2: rule__JoinRecipe__Group__4__Impl rule__JoinRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__4__Impl_in_rule__JoinRecipe__Group__47402);
            rule__JoinRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__5_in_rule__JoinRecipe__Group__47405);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3773:1: rule__JoinRecipe__Group__4__Impl : ( ( rule__JoinRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__JoinRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3777:1: ( ( ( rule__JoinRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3778:1: ( ( rule__JoinRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3778:1: ( ( rule__JoinRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3779:1: ( rule__JoinRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getJoinRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3780:1: ( rule__JoinRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3780:2: rule__JoinRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__TraceInfoAssignment_4_in_rule__JoinRecipe__Group__4__Impl7432);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3790:1: rule__JoinRecipe__Group__5 : rule__JoinRecipe__Group__5__Impl rule__JoinRecipe__Group__6 ;
    public final void rule__JoinRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3794:1: ( rule__JoinRecipe__Group__5__Impl rule__JoinRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3795:2: rule__JoinRecipe__Group__5__Impl rule__JoinRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__5__Impl_in_rule__JoinRecipe__Group__57462);
            rule__JoinRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__6_in_rule__JoinRecipe__Group__57465);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3802:1: rule__JoinRecipe__Group__5__Impl : ( 'leftParent' ) ;
    public final void rule__JoinRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3806:1: ( ( 'leftParent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3807:1: ( 'leftParent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3807:1: ( 'leftParent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3808:1: 'leftParent'
            {
             before(grammarAccess.getJoinRecipeAccess().getLeftParentKeyword_5()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__JoinRecipe__Group__5__Impl7493); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3821:1: rule__JoinRecipe__Group__6 : rule__JoinRecipe__Group__6__Impl rule__JoinRecipe__Group__7 ;
    public final void rule__JoinRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3825:1: ( rule__JoinRecipe__Group__6__Impl rule__JoinRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3826:2: rule__JoinRecipe__Group__6__Impl rule__JoinRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__6__Impl_in_rule__JoinRecipe__Group__67524);
            rule__JoinRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__7_in_rule__JoinRecipe__Group__67527);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3833:1: rule__JoinRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__JoinRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3837:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3838:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3838:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3839:1: ':'
            {
             before(grammarAccess.getJoinRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__JoinRecipe__Group__6__Impl7555); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3852:1: rule__JoinRecipe__Group__7 : rule__JoinRecipe__Group__7__Impl rule__JoinRecipe__Group__8 ;
    public final void rule__JoinRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3856:1: ( rule__JoinRecipe__Group__7__Impl rule__JoinRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3857:2: rule__JoinRecipe__Group__7__Impl rule__JoinRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__7__Impl_in_rule__JoinRecipe__Group__77586);
            rule__JoinRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__8_in_rule__JoinRecipe__Group__77589);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3864:1: rule__JoinRecipe__Group__7__Impl : ( ( rule__JoinRecipe__LeftParentAssignment_7 ) ) ;
    public final void rule__JoinRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3868:1: ( ( ( rule__JoinRecipe__LeftParentAssignment_7 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3869:1: ( ( rule__JoinRecipe__LeftParentAssignment_7 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3869:1: ( ( rule__JoinRecipe__LeftParentAssignment_7 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3870:1: ( rule__JoinRecipe__LeftParentAssignment_7 )
            {
             before(grammarAccess.getJoinRecipeAccess().getLeftParentAssignment_7()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3871:1: ( rule__JoinRecipe__LeftParentAssignment_7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3871:2: rule__JoinRecipe__LeftParentAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__LeftParentAssignment_7_in_rule__JoinRecipe__Group__7__Impl7616);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3881:1: rule__JoinRecipe__Group__8 : rule__JoinRecipe__Group__8__Impl rule__JoinRecipe__Group__9 ;
    public final void rule__JoinRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3885:1: ( rule__JoinRecipe__Group__8__Impl rule__JoinRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3886:2: rule__JoinRecipe__Group__8__Impl rule__JoinRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__8__Impl_in_rule__JoinRecipe__Group__87646);
            rule__JoinRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__9_in_rule__JoinRecipe__Group__87649);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3893:1: rule__JoinRecipe__Group__8__Impl : ( 'rightParent' ) ;
    public final void rule__JoinRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3897:1: ( ( 'rightParent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3898:1: ( 'rightParent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3898:1: ( 'rightParent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3899:1: 'rightParent'
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentKeyword_8()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__JoinRecipe__Group__8__Impl7677); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3912:1: rule__JoinRecipe__Group__9 : rule__JoinRecipe__Group__9__Impl rule__JoinRecipe__Group__10 ;
    public final void rule__JoinRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3916:1: ( rule__JoinRecipe__Group__9__Impl rule__JoinRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3917:2: rule__JoinRecipe__Group__9__Impl rule__JoinRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__9__Impl_in_rule__JoinRecipe__Group__97708);
            rule__JoinRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__10_in_rule__JoinRecipe__Group__97711);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3924:1: rule__JoinRecipe__Group__9__Impl : ( ':' ) ;
    public final void rule__JoinRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3928:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3929:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3929:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3930:1: ':'
            {
             before(grammarAccess.getJoinRecipeAccess().getColonKeyword_9()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__JoinRecipe__Group__9__Impl7739); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3943:1: rule__JoinRecipe__Group__10 : rule__JoinRecipe__Group__10__Impl rule__JoinRecipe__Group__11 ;
    public final void rule__JoinRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3947:1: ( rule__JoinRecipe__Group__10__Impl rule__JoinRecipe__Group__11 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3948:2: rule__JoinRecipe__Group__10__Impl rule__JoinRecipe__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__10__Impl_in_rule__JoinRecipe__Group__107770);
            rule__JoinRecipe__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__11_in_rule__JoinRecipe__Group__107773);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3955:1: rule__JoinRecipe__Group__10__Impl : ( ( rule__JoinRecipe__RightParentAssignment_10 ) ) ;
    public final void rule__JoinRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3959:1: ( ( ( rule__JoinRecipe__RightParentAssignment_10 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3960:1: ( ( rule__JoinRecipe__RightParentAssignment_10 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3960:1: ( ( rule__JoinRecipe__RightParentAssignment_10 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3961:1: ( rule__JoinRecipe__RightParentAssignment_10 )
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentAssignment_10()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3962:1: ( rule__JoinRecipe__RightParentAssignment_10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3962:2: rule__JoinRecipe__RightParentAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__RightParentAssignment_10_in_rule__JoinRecipe__Group__10__Impl7800);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3972:1: rule__JoinRecipe__Group__11 : rule__JoinRecipe__Group__11__Impl rule__JoinRecipe__Group__12 ;
    public final void rule__JoinRecipe__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3976:1: ( rule__JoinRecipe__Group__11__Impl rule__JoinRecipe__Group__12 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3977:2: rule__JoinRecipe__Group__11__Impl rule__JoinRecipe__Group__12
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__11__Impl_in_rule__JoinRecipe__Group__117830);
            rule__JoinRecipe__Group__11__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__12_in_rule__JoinRecipe__Group__117833);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3984:1: rule__JoinRecipe__Group__11__Impl : ( ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )? ) ;
    public final void rule__JoinRecipe__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3988:1: ( ( ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )? ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3989:1: ( ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )? )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3989:1: ( ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )? )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3990:1: ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )?
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentComplementaryMaskAssignment_11()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3991:1: ( rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==18) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:3991:2: rule__JoinRecipe__RightParentComplementaryMaskAssignment_11
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__RightParentComplementaryMaskAssignment_11_in_rule__JoinRecipe__Group__11__Impl7860);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4001:1: rule__JoinRecipe__Group__12 : rule__JoinRecipe__Group__12__Impl ;
    public final void rule__JoinRecipe__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4005:1: ( rule__JoinRecipe__Group__12__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4006:2: rule__JoinRecipe__Group__12__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__JoinRecipe__Group__12__Impl_in_rule__JoinRecipe__Group__127891);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4012:1: rule__JoinRecipe__Group__12__Impl : ( '}' ) ;
    public final void rule__JoinRecipe__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4016:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4017:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4017:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4018:1: '}'
            {
             before(grammarAccess.getJoinRecipeAccess().getRightCurlyBracketKeyword_12()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__JoinRecipe__Group__12__Impl7919); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4057:1: rule__AntiJoinRecipe__Group__0 : rule__AntiJoinRecipe__Group__0__Impl rule__AntiJoinRecipe__Group__1 ;
    public final void rule__AntiJoinRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4061:1: ( rule__AntiJoinRecipe__Group__0__Impl rule__AntiJoinRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4062:2: rule__AntiJoinRecipe__Group__0__Impl rule__AntiJoinRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__0__Impl_in_rule__AntiJoinRecipe__Group__07976);
            rule__AntiJoinRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__1_in_rule__AntiJoinRecipe__Group__07979);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4069:1: rule__AntiJoinRecipe__Group__0__Impl : ( 'AntiJoin' ) ;
    public final void rule__AntiJoinRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4073:1: ( ( 'AntiJoin' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4074:1: ( 'AntiJoin' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4074:1: ( 'AntiJoin' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4075:1: 'AntiJoin'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getAntiJoinKeyword_0()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__AntiJoinRecipe__Group__0__Impl8007); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4088:1: rule__AntiJoinRecipe__Group__1 : rule__AntiJoinRecipe__Group__1__Impl rule__AntiJoinRecipe__Group__2 ;
    public final void rule__AntiJoinRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4092:1: ( rule__AntiJoinRecipe__Group__1__Impl rule__AntiJoinRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4093:2: rule__AntiJoinRecipe__Group__1__Impl rule__AntiJoinRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__1__Impl_in_rule__AntiJoinRecipe__Group__18038);
            rule__AntiJoinRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__2_in_rule__AntiJoinRecipe__Group__18041);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4100:1: rule__AntiJoinRecipe__Group__1__Impl : ( '{' ) ;
    public final void rule__AntiJoinRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4104:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4105:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4105:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4106:1: '{'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__AntiJoinRecipe__Group__1__Impl8069); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4119:1: rule__AntiJoinRecipe__Group__2 : rule__AntiJoinRecipe__Group__2__Impl rule__AntiJoinRecipe__Group__3 ;
    public final void rule__AntiJoinRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4123:1: ( rule__AntiJoinRecipe__Group__2__Impl rule__AntiJoinRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4124:2: rule__AntiJoinRecipe__Group__2__Impl rule__AntiJoinRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__2__Impl_in_rule__AntiJoinRecipe__Group__28100);
            rule__AntiJoinRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__3_in_rule__AntiJoinRecipe__Group__28103);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4131:1: rule__AntiJoinRecipe__Group__2__Impl : ( 'traceInfo' ) ;
    public final void rule__AntiJoinRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4135:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4136:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4136:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4137:1: 'traceInfo'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoKeyword_2()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__AntiJoinRecipe__Group__2__Impl8131); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4150:1: rule__AntiJoinRecipe__Group__3 : rule__AntiJoinRecipe__Group__3__Impl rule__AntiJoinRecipe__Group__4 ;
    public final void rule__AntiJoinRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4154:1: ( rule__AntiJoinRecipe__Group__3__Impl rule__AntiJoinRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4155:2: rule__AntiJoinRecipe__Group__3__Impl rule__AntiJoinRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__3__Impl_in_rule__AntiJoinRecipe__Group__38162);
            rule__AntiJoinRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__4_in_rule__AntiJoinRecipe__Group__38165);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4162:1: rule__AntiJoinRecipe__Group__3__Impl : ( ':' ) ;
    public final void rule__AntiJoinRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4166:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4167:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4167:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4168:1: ':'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_3()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__AntiJoinRecipe__Group__3__Impl8193); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4181:1: rule__AntiJoinRecipe__Group__4 : rule__AntiJoinRecipe__Group__4__Impl rule__AntiJoinRecipe__Group__5 ;
    public final void rule__AntiJoinRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4185:1: ( rule__AntiJoinRecipe__Group__4__Impl rule__AntiJoinRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4186:2: rule__AntiJoinRecipe__Group__4__Impl rule__AntiJoinRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__4__Impl_in_rule__AntiJoinRecipe__Group__48224);
            rule__AntiJoinRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__5_in_rule__AntiJoinRecipe__Group__48227);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4193:1: rule__AntiJoinRecipe__Group__4__Impl : ( ( rule__AntiJoinRecipe__TraceInfoAssignment_4 ) ) ;
    public final void rule__AntiJoinRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4197:1: ( ( ( rule__AntiJoinRecipe__TraceInfoAssignment_4 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4198:1: ( ( rule__AntiJoinRecipe__TraceInfoAssignment_4 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4198:1: ( ( rule__AntiJoinRecipe__TraceInfoAssignment_4 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4199:1: ( rule__AntiJoinRecipe__TraceInfoAssignment_4 )
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4200:1: ( rule__AntiJoinRecipe__TraceInfoAssignment_4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4200:2: rule__AntiJoinRecipe__TraceInfoAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__TraceInfoAssignment_4_in_rule__AntiJoinRecipe__Group__4__Impl8254);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4210:1: rule__AntiJoinRecipe__Group__5 : rule__AntiJoinRecipe__Group__5__Impl rule__AntiJoinRecipe__Group__6 ;
    public final void rule__AntiJoinRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4214:1: ( rule__AntiJoinRecipe__Group__5__Impl rule__AntiJoinRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4215:2: rule__AntiJoinRecipe__Group__5__Impl rule__AntiJoinRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__5__Impl_in_rule__AntiJoinRecipe__Group__58284);
            rule__AntiJoinRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__6_in_rule__AntiJoinRecipe__Group__58287);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4222:1: rule__AntiJoinRecipe__Group__5__Impl : ( 'leftParent' ) ;
    public final void rule__AntiJoinRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4226:1: ( ( 'leftParent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4227:1: ( 'leftParent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4227:1: ( 'leftParent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4228:1: 'leftParent'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getLeftParentKeyword_5()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__AntiJoinRecipe__Group__5__Impl8315); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4241:1: rule__AntiJoinRecipe__Group__6 : rule__AntiJoinRecipe__Group__6__Impl rule__AntiJoinRecipe__Group__7 ;
    public final void rule__AntiJoinRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4245:1: ( rule__AntiJoinRecipe__Group__6__Impl rule__AntiJoinRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4246:2: rule__AntiJoinRecipe__Group__6__Impl rule__AntiJoinRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__6__Impl_in_rule__AntiJoinRecipe__Group__68346);
            rule__AntiJoinRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__7_in_rule__AntiJoinRecipe__Group__68349);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4253:1: rule__AntiJoinRecipe__Group__6__Impl : ( ':' ) ;
    public final void rule__AntiJoinRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4257:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4258:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4258:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4259:1: ':'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_6()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__AntiJoinRecipe__Group__6__Impl8377); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4272:1: rule__AntiJoinRecipe__Group__7 : rule__AntiJoinRecipe__Group__7__Impl rule__AntiJoinRecipe__Group__8 ;
    public final void rule__AntiJoinRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4276:1: ( rule__AntiJoinRecipe__Group__7__Impl rule__AntiJoinRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4277:2: rule__AntiJoinRecipe__Group__7__Impl rule__AntiJoinRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__7__Impl_in_rule__AntiJoinRecipe__Group__78408);
            rule__AntiJoinRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__8_in_rule__AntiJoinRecipe__Group__78411);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4284:1: rule__AntiJoinRecipe__Group__7__Impl : ( ( rule__AntiJoinRecipe__LeftParentAssignment_7 ) ) ;
    public final void rule__AntiJoinRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4288:1: ( ( ( rule__AntiJoinRecipe__LeftParentAssignment_7 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4289:1: ( ( rule__AntiJoinRecipe__LeftParentAssignment_7 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4289:1: ( ( rule__AntiJoinRecipe__LeftParentAssignment_7 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4290:1: ( rule__AntiJoinRecipe__LeftParentAssignment_7 )
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getLeftParentAssignment_7()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4291:1: ( rule__AntiJoinRecipe__LeftParentAssignment_7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4291:2: rule__AntiJoinRecipe__LeftParentAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__LeftParentAssignment_7_in_rule__AntiJoinRecipe__Group__7__Impl8438);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4301:1: rule__AntiJoinRecipe__Group__8 : rule__AntiJoinRecipe__Group__8__Impl rule__AntiJoinRecipe__Group__9 ;
    public final void rule__AntiJoinRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4305:1: ( rule__AntiJoinRecipe__Group__8__Impl rule__AntiJoinRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4306:2: rule__AntiJoinRecipe__Group__8__Impl rule__AntiJoinRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__8__Impl_in_rule__AntiJoinRecipe__Group__88468);
            rule__AntiJoinRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__9_in_rule__AntiJoinRecipe__Group__88471);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4313:1: rule__AntiJoinRecipe__Group__8__Impl : ( 'rightParent' ) ;
    public final void rule__AntiJoinRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4317:1: ( ( 'rightParent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4318:1: ( 'rightParent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4318:1: ( 'rightParent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4319:1: 'rightParent'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getRightParentKeyword_8()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__AntiJoinRecipe__Group__8__Impl8499); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4332:1: rule__AntiJoinRecipe__Group__9 : rule__AntiJoinRecipe__Group__9__Impl rule__AntiJoinRecipe__Group__10 ;
    public final void rule__AntiJoinRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4336:1: ( rule__AntiJoinRecipe__Group__9__Impl rule__AntiJoinRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4337:2: rule__AntiJoinRecipe__Group__9__Impl rule__AntiJoinRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__9__Impl_in_rule__AntiJoinRecipe__Group__98530);
            rule__AntiJoinRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__10_in_rule__AntiJoinRecipe__Group__98533);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4344:1: rule__AntiJoinRecipe__Group__9__Impl : ( ':' ) ;
    public final void rule__AntiJoinRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4348:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4349:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4349:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4350:1: ':'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getColonKeyword_9()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__AntiJoinRecipe__Group__9__Impl8561); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4363:1: rule__AntiJoinRecipe__Group__10 : rule__AntiJoinRecipe__Group__10__Impl rule__AntiJoinRecipe__Group__11 ;
    public final void rule__AntiJoinRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4367:1: ( rule__AntiJoinRecipe__Group__10__Impl rule__AntiJoinRecipe__Group__11 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4368:2: rule__AntiJoinRecipe__Group__10__Impl rule__AntiJoinRecipe__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__10__Impl_in_rule__AntiJoinRecipe__Group__108592);
            rule__AntiJoinRecipe__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__11_in_rule__AntiJoinRecipe__Group__108595);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4375:1: rule__AntiJoinRecipe__Group__10__Impl : ( ( rule__AntiJoinRecipe__RightParentAssignment_10 ) ) ;
    public final void rule__AntiJoinRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4379:1: ( ( ( rule__AntiJoinRecipe__RightParentAssignment_10 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4380:1: ( ( rule__AntiJoinRecipe__RightParentAssignment_10 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4380:1: ( ( rule__AntiJoinRecipe__RightParentAssignment_10 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4381:1: ( rule__AntiJoinRecipe__RightParentAssignment_10 )
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getRightParentAssignment_10()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4382:1: ( rule__AntiJoinRecipe__RightParentAssignment_10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4382:2: rule__AntiJoinRecipe__RightParentAssignment_10
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__RightParentAssignment_10_in_rule__AntiJoinRecipe__Group__10__Impl8622);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4392:1: rule__AntiJoinRecipe__Group__11 : rule__AntiJoinRecipe__Group__11__Impl ;
    public final void rule__AntiJoinRecipe__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4396:1: ( rule__AntiJoinRecipe__Group__11__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4397:2: rule__AntiJoinRecipe__Group__11__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AntiJoinRecipe__Group__11__Impl_in_rule__AntiJoinRecipe__Group__118652);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4403:1: rule__AntiJoinRecipe__Group__11__Impl : ( '}' ) ;
    public final void rule__AntiJoinRecipe__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4407:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4408:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4408:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4409:1: '}'
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getRightCurlyBracketKeyword_11()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__AntiJoinRecipe__Group__11__Impl8680); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4446:1: rule__IndexerRecipe__Group__0 : rule__IndexerRecipe__Group__0__Impl rule__IndexerRecipe__Group__1 ;
    public final void rule__IndexerRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4450:1: ( rule__IndexerRecipe__Group__0__Impl rule__IndexerRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4451:2: rule__IndexerRecipe__Group__0__Impl rule__IndexerRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__0__Impl_in_rule__IndexerRecipe__Group__08735);
            rule__IndexerRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__1_in_rule__IndexerRecipe__Group__08738);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4458:1: rule__IndexerRecipe__Group__0__Impl : ( '{' ) ;
    public final void rule__IndexerRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4462:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4463:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4463:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4464:1: '{'
            {
             before(grammarAccess.getIndexerRecipeAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__IndexerRecipe__Group__0__Impl8766); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4477:1: rule__IndexerRecipe__Group__1 : rule__IndexerRecipe__Group__1__Impl rule__IndexerRecipe__Group__2 ;
    public final void rule__IndexerRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4481:1: ( rule__IndexerRecipe__Group__1__Impl rule__IndexerRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4482:2: rule__IndexerRecipe__Group__1__Impl rule__IndexerRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__1__Impl_in_rule__IndexerRecipe__Group__18797);
            rule__IndexerRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__2_in_rule__IndexerRecipe__Group__18800);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4489:1: rule__IndexerRecipe__Group__1__Impl : ( 'traceInfo' ) ;
    public final void rule__IndexerRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4493:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4494:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4494:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4495:1: 'traceInfo'
            {
             before(grammarAccess.getIndexerRecipeAccess().getTraceInfoKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__IndexerRecipe__Group__1__Impl8828); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4508:1: rule__IndexerRecipe__Group__2 : rule__IndexerRecipe__Group__2__Impl rule__IndexerRecipe__Group__3 ;
    public final void rule__IndexerRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4512:1: ( rule__IndexerRecipe__Group__2__Impl rule__IndexerRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4513:2: rule__IndexerRecipe__Group__2__Impl rule__IndexerRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__2__Impl_in_rule__IndexerRecipe__Group__28859);
            rule__IndexerRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__3_in_rule__IndexerRecipe__Group__28862);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4520:1: rule__IndexerRecipe__Group__2__Impl : ( ':' ) ;
    public final void rule__IndexerRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4524:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4525:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4525:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4526:1: ':'
            {
             before(grammarAccess.getIndexerRecipeAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__IndexerRecipe__Group__2__Impl8890); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4539:1: rule__IndexerRecipe__Group__3 : rule__IndexerRecipe__Group__3__Impl rule__IndexerRecipe__Group__4 ;
    public final void rule__IndexerRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4543:1: ( rule__IndexerRecipe__Group__3__Impl rule__IndexerRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4544:2: rule__IndexerRecipe__Group__3__Impl rule__IndexerRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__3__Impl_in_rule__IndexerRecipe__Group__38921);
            rule__IndexerRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__4_in_rule__IndexerRecipe__Group__38924);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4551:1: rule__IndexerRecipe__Group__3__Impl : ( ( rule__IndexerRecipe__TraceInfoAssignment_3 ) ) ;
    public final void rule__IndexerRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4555:1: ( ( ( rule__IndexerRecipe__TraceInfoAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4556:1: ( ( rule__IndexerRecipe__TraceInfoAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4556:1: ( ( rule__IndexerRecipe__TraceInfoAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4557:1: ( rule__IndexerRecipe__TraceInfoAssignment_3 )
            {
             before(grammarAccess.getIndexerRecipeAccess().getTraceInfoAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4558:1: ( rule__IndexerRecipe__TraceInfoAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4558:2: rule__IndexerRecipe__TraceInfoAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__TraceInfoAssignment_3_in_rule__IndexerRecipe__Group__3__Impl8951);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4568:1: rule__IndexerRecipe__Group__4 : rule__IndexerRecipe__Group__4__Impl rule__IndexerRecipe__Group__5 ;
    public final void rule__IndexerRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4572:1: ( rule__IndexerRecipe__Group__4__Impl rule__IndexerRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4573:2: rule__IndexerRecipe__Group__4__Impl rule__IndexerRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__4__Impl_in_rule__IndexerRecipe__Group__48981);
            rule__IndexerRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__5_in_rule__IndexerRecipe__Group__48984);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4580:1: rule__IndexerRecipe__Group__4__Impl : ( 'mask' ) ;
    public final void rule__IndexerRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4584:1: ( ( 'mask' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4585:1: ( 'mask' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4585:1: ( 'mask' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4586:1: 'mask'
            {
             before(grammarAccess.getIndexerRecipeAccess().getMaskKeyword_4()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__IndexerRecipe__Group__4__Impl9012); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4599:1: rule__IndexerRecipe__Group__5 : rule__IndexerRecipe__Group__5__Impl rule__IndexerRecipe__Group__6 ;
    public final void rule__IndexerRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4603:1: ( rule__IndexerRecipe__Group__5__Impl rule__IndexerRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4604:2: rule__IndexerRecipe__Group__5__Impl rule__IndexerRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__5__Impl_in_rule__IndexerRecipe__Group__59043);
            rule__IndexerRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__6_in_rule__IndexerRecipe__Group__59046);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4611:1: rule__IndexerRecipe__Group__5__Impl : ( ':' ) ;
    public final void rule__IndexerRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4615:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4616:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4616:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4617:1: ':'
            {
             before(grammarAccess.getIndexerRecipeAccess().getColonKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__IndexerRecipe__Group__5__Impl9074); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4630:1: rule__IndexerRecipe__Group__6 : rule__IndexerRecipe__Group__6__Impl rule__IndexerRecipe__Group__7 ;
    public final void rule__IndexerRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4634:1: ( rule__IndexerRecipe__Group__6__Impl rule__IndexerRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4635:2: rule__IndexerRecipe__Group__6__Impl rule__IndexerRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__6__Impl_in_rule__IndexerRecipe__Group__69105);
            rule__IndexerRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__7_in_rule__IndexerRecipe__Group__69108);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4642:1: rule__IndexerRecipe__Group__6__Impl : ( ( rule__IndexerRecipe__MaskAssignment_6 ) ) ;
    public final void rule__IndexerRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4646:1: ( ( ( rule__IndexerRecipe__MaskAssignment_6 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4647:1: ( ( rule__IndexerRecipe__MaskAssignment_6 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4647:1: ( ( rule__IndexerRecipe__MaskAssignment_6 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4648:1: ( rule__IndexerRecipe__MaskAssignment_6 )
            {
             before(grammarAccess.getIndexerRecipeAccess().getMaskAssignment_6()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4649:1: ( rule__IndexerRecipe__MaskAssignment_6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4649:2: rule__IndexerRecipe__MaskAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__MaskAssignment_6_in_rule__IndexerRecipe__Group__6__Impl9135);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4659:1: rule__IndexerRecipe__Group__7 : rule__IndexerRecipe__Group__7__Impl rule__IndexerRecipe__Group__8 ;
    public final void rule__IndexerRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4663:1: ( rule__IndexerRecipe__Group__7__Impl rule__IndexerRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4664:2: rule__IndexerRecipe__Group__7__Impl rule__IndexerRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__7__Impl_in_rule__IndexerRecipe__Group__79165);
            rule__IndexerRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__8_in_rule__IndexerRecipe__Group__79168);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4671:1: rule__IndexerRecipe__Group__7__Impl : ( 'parent' ) ;
    public final void rule__IndexerRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4675:1: ( ( 'parent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4676:1: ( 'parent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4676:1: ( 'parent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4677:1: 'parent'
            {
             before(grammarAccess.getIndexerRecipeAccess().getParentKeyword_7()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__IndexerRecipe__Group__7__Impl9196); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4690:1: rule__IndexerRecipe__Group__8 : rule__IndexerRecipe__Group__8__Impl rule__IndexerRecipe__Group__9 ;
    public final void rule__IndexerRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4694:1: ( rule__IndexerRecipe__Group__8__Impl rule__IndexerRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4695:2: rule__IndexerRecipe__Group__8__Impl rule__IndexerRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__8__Impl_in_rule__IndexerRecipe__Group__89227);
            rule__IndexerRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__9_in_rule__IndexerRecipe__Group__89230);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4702:1: rule__IndexerRecipe__Group__8__Impl : ( ':' ) ;
    public final void rule__IndexerRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4706:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4707:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4707:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4708:1: ':'
            {
             before(grammarAccess.getIndexerRecipeAccess().getColonKeyword_8()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__IndexerRecipe__Group__8__Impl9258); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4721:1: rule__IndexerRecipe__Group__9 : rule__IndexerRecipe__Group__9__Impl rule__IndexerRecipe__Group__10 ;
    public final void rule__IndexerRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4725:1: ( rule__IndexerRecipe__Group__9__Impl rule__IndexerRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4726:2: rule__IndexerRecipe__Group__9__Impl rule__IndexerRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__9__Impl_in_rule__IndexerRecipe__Group__99289);
            rule__IndexerRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__10_in_rule__IndexerRecipe__Group__99292);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4733:1: rule__IndexerRecipe__Group__9__Impl : ( ( rule__IndexerRecipe__ParentAssignment_9 ) ) ;
    public final void rule__IndexerRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4737:1: ( ( ( rule__IndexerRecipe__ParentAssignment_9 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4738:1: ( ( rule__IndexerRecipe__ParentAssignment_9 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4738:1: ( ( rule__IndexerRecipe__ParentAssignment_9 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4739:1: ( rule__IndexerRecipe__ParentAssignment_9 )
            {
             before(grammarAccess.getIndexerRecipeAccess().getParentAssignment_9()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4740:1: ( rule__IndexerRecipe__ParentAssignment_9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4740:2: rule__IndexerRecipe__ParentAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__ParentAssignment_9_in_rule__IndexerRecipe__Group__9__Impl9319);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4750:1: rule__IndexerRecipe__Group__10 : rule__IndexerRecipe__Group__10__Impl ;
    public final void rule__IndexerRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4754:1: ( rule__IndexerRecipe__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4755:2: rule__IndexerRecipe__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__IndexerRecipe__Group__10__Impl_in_rule__IndexerRecipe__Group__109349);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4761:1: rule__IndexerRecipe__Group__10__Impl : ( '}' ) ;
    public final void rule__IndexerRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4765:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4766:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4766:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4767:1: '}'
            {
             before(grammarAccess.getIndexerRecipeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__IndexerRecipe__Group__10__Impl9377); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4802:1: rule__ProjectionIndexerRecipe__Group__0 : rule__ProjectionIndexerRecipe__Group__0__Impl rule__ProjectionIndexerRecipe__Group__1 ;
    public final void rule__ProjectionIndexerRecipe__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4806:1: ( rule__ProjectionIndexerRecipe__Group__0__Impl rule__ProjectionIndexerRecipe__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4807:2: rule__ProjectionIndexerRecipe__Group__0__Impl rule__ProjectionIndexerRecipe__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__0__Impl_in_rule__ProjectionIndexerRecipe__Group__09430);
            rule__ProjectionIndexerRecipe__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__1_in_rule__ProjectionIndexerRecipe__Group__09433);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4814:1: rule__ProjectionIndexerRecipe__Group__0__Impl : ( '{' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4818:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4819:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4819:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4820:1: '{'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__ProjectionIndexerRecipe__Group__0__Impl9461); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4833:1: rule__ProjectionIndexerRecipe__Group__1 : rule__ProjectionIndexerRecipe__Group__1__Impl rule__ProjectionIndexerRecipe__Group__2 ;
    public final void rule__ProjectionIndexerRecipe__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4837:1: ( rule__ProjectionIndexerRecipe__Group__1__Impl rule__ProjectionIndexerRecipe__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4838:2: rule__ProjectionIndexerRecipe__Group__1__Impl rule__ProjectionIndexerRecipe__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__1__Impl_in_rule__ProjectionIndexerRecipe__Group__19492);
            rule__ProjectionIndexerRecipe__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__2_in_rule__ProjectionIndexerRecipe__Group__19495);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4845:1: rule__ProjectionIndexerRecipe__Group__1__Impl : ( 'traceInfo' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4849:1: ( ( 'traceInfo' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4850:1: ( 'traceInfo' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4850:1: ( 'traceInfo' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4851:1: 'traceInfo'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoKeyword_1()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__ProjectionIndexerRecipe__Group__1__Impl9523); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4864:1: rule__ProjectionIndexerRecipe__Group__2 : rule__ProjectionIndexerRecipe__Group__2__Impl rule__ProjectionIndexerRecipe__Group__3 ;
    public final void rule__ProjectionIndexerRecipe__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4868:1: ( rule__ProjectionIndexerRecipe__Group__2__Impl rule__ProjectionIndexerRecipe__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4869:2: rule__ProjectionIndexerRecipe__Group__2__Impl rule__ProjectionIndexerRecipe__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__2__Impl_in_rule__ProjectionIndexerRecipe__Group__29554);
            rule__ProjectionIndexerRecipe__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__3_in_rule__ProjectionIndexerRecipe__Group__29557);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4876:1: rule__ProjectionIndexerRecipe__Group__2__Impl : ( ':' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4880:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4881:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4881:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4882:1: ':'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__2__Impl9585); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4895:1: rule__ProjectionIndexerRecipe__Group__3 : rule__ProjectionIndexerRecipe__Group__3__Impl rule__ProjectionIndexerRecipe__Group__4 ;
    public final void rule__ProjectionIndexerRecipe__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4899:1: ( rule__ProjectionIndexerRecipe__Group__3__Impl rule__ProjectionIndexerRecipe__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4900:2: rule__ProjectionIndexerRecipe__Group__3__Impl rule__ProjectionIndexerRecipe__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__3__Impl_in_rule__ProjectionIndexerRecipe__Group__39616);
            rule__ProjectionIndexerRecipe__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__4_in_rule__ProjectionIndexerRecipe__Group__39619);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4907:1: rule__ProjectionIndexerRecipe__Group__3__Impl : ( ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 ) ) ;
    public final void rule__ProjectionIndexerRecipe__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4911:1: ( ( ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4912:1: ( ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4912:1: ( ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4913:1: ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4914:1: ( rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4914:2: rule__ProjectionIndexerRecipe__TraceInfoAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__TraceInfoAssignment_3_in_rule__ProjectionIndexerRecipe__Group__3__Impl9646);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4924:1: rule__ProjectionIndexerRecipe__Group__4 : rule__ProjectionIndexerRecipe__Group__4__Impl rule__ProjectionIndexerRecipe__Group__5 ;
    public final void rule__ProjectionIndexerRecipe__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4928:1: ( rule__ProjectionIndexerRecipe__Group__4__Impl rule__ProjectionIndexerRecipe__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4929:2: rule__ProjectionIndexerRecipe__Group__4__Impl rule__ProjectionIndexerRecipe__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__4__Impl_in_rule__ProjectionIndexerRecipe__Group__49676);
            rule__ProjectionIndexerRecipe__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__5_in_rule__ProjectionIndexerRecipe__Group__49679);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4936:1: rule__ProjectionIndexerRecipe__Group__4__Impl : ( 'mask' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4940:1: ( ( 'mask' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4941:1: ( 'mask' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4941:1: ( 'mask' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4942:1: 'mask'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getMaskKeyword_4()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__ProjectionIndexerRecipe__Group__4__Impl9707); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4955:1: rule__ProjectionIndexerRecipe__Group__5 : rule__ProjectionIndexerRecipe__Group__5__Impl rule__ProjectionIndexerRecipe__Group__6 ;
    public final void rule__ProjectionIndexerRecipe__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4959:1: ( rule__ProjectionIndexerRecipe__Group__5__Impl rule__ProjectionIndexerRecipe__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4960:2: rule__ProjectionIndexerRecipe__Group__5__Impl rule__ProjectionIndexerRecipe__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__5__Impl_in_rule__ProjectionIndexerRecipe__Group__59738);
            rule__ProjectionIndexerRecipe__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__6_in_rule__ProjectionIndexerRecipe__Group__59741);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4967:1: rule__ProjectionIndexerRecipe__Group__5__Impl : ( ':' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4971:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4972:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4972:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4973:1: ':'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_5()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__5__Impl9769); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4986:1: rule__ProjectionIndexerRecipe__Group__6 : rule__ProjectionIndexerRecipe__Group__6__Impl rule__ProjectionIndexerRecipe__Group__7 ;
    public final void rule__ProjectionIndexerRecipe__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4990:1: ( rule__ProjectionIndexerRecipe__Group__6__Impl rule__ProjectionIndexerRecipe__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4991:2: rule__ProjectionIndexerRecipe__Group__6__Impl rule__ProjectionIndexerRecipe__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__6__Impl_in_rule__ProjectionIndexerRecipe__Group__69800);
            rule__ProjectionIndexerRecipe__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__7_in_rule__ProjectionIndexerRecipe__Group__69803);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:4998:1: rule__ProjectionIndexerRecipe__Group__6__Impl : ( ( rule__ProjectionIndexerRecipe__MaskAssignment_6 ) ) ;
    public final void rule__ProjectionIndexerRecipe__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5002:1: ( ( ( rule__ProjectionIndexerRecipe__MaskAssignment_6 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5003:1: ( ( rule__ProjectionIndexerRecipe__MaskAssignment_6 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5003:1: ( ( rule__ProjectionIndexerRecipe__MaskAssignment_6 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5004:1: ( rule__ProjectionIndexerRecipe__MaskAssignment_6 )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getMaskAssignment_6()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5005:1: ( rule__ProjectionIndexerRecipe__MaskAssignment_6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5005:2: rule__ProjectionIndexerRecipe__MaskAssignment_6
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__MaskAssignment_6_in_rule__ProjectionIndexerRecipe__Group__6__Impl9830);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5015:1: rule__ProjectionIndexerRecipe__Group__7 : rule__ProjectionIndexerRecipe__Group__7__Impl rule__ProjectionIndexerRecipe__Group__8 ;
    public final void rule__ProjectionIndexerRecipe__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5019:1: ( rule__ProjectionIndexerRecipe__Group__7__Impl rule__ProjectionIndexerRecipe__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5020:2: rule__ProjectionIndexerRecipe__Group__7__Impl rule__ProjectionIndexerRecipe__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__7__Impl_in_rule__ProjectionIndexerRecipe__Group__79860);
            rule__ProjectionIndexerRecipe__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__8_in_rule__ProjectionIndexerRecipe__Group__79863);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5027:1: rule__ProjectionIndexerRecipe__Group__7__Impl : ( 'parent' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5031:1: ( ( 'parent' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5032:1: ( 'parent' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5032:1: ( 'parent' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5033:1: 'parent'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getParentKeyword_7()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__ProjectionIndexerRecipe__Group__7__Impl9891); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5046:1: rule__ProjectionIndexerRecipe__Group__8 : rule__ProjectionIndexerRecipe__Group__8__Impl rule__ProjectionIndexerRecipe__Group__9 ;
    public final void rule__ProjectionIndexerRecipe__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5050:1: ( rule__ProjectionIndexerRecipe__Group__8__Impl rule__ProjectionIndexerRecipe__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5051:2: rule__ProjectionIndexerRecipe__Group__8__Impl rule__ProjectionIndexerRecipe__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__8__Impl_in_rule__ProjectionIndexerRecipe__Group__89922);
            rule__ProjectionIndexerRecipe__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__9_in_rule__ProjectionIndexerRecipe__Group__89925);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5058:1: rule__ProjectionIndexerRecipe__Group__8__Impl : ( ':' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5062:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5063:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5063:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5064:1: ':'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getColonKeyword_8()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__8__Impl9953); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5077:1: rule__ProjectionIndexerRecipe__Group__9 : rule__ProjectionIndexerRecipe__Group__9__Impl rule__ProjectionIndexerRecipe__Group__10 ;
    public final void rule__ProjectionIndexerRecipe__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5081:1: ( rule__ProjectionIndexerRecipe__Group__9__Impl rule__ProjectionIndexerRecipe__Group__10 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5082:2: rule__ProjectionIndexerRecipe__Group__9__Impl rule__ProjectionIndexerRecipe__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__9__Impl_in_rule__ProjectionIndexerRecipe__Group__99984);
            rule__ProjectionIndexerRecipe__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__10_in_rule__ProjectionIndexerRecipe__Group__99987);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5089:1: rule__ProjectionIndexerRecipe__Group__9__Impl : ( ( rule__ProjectionIndexerRecipe__ParentAssignment_9 ) ) ;
    public final void rule__ProjectionIndexerRecipe__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5093:1: ( ( ( rule__ProjectionIndexerRecipe__ParentAssignment_9 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5094:1: ( ( rule__ProjectionIndexerRecipe__ParentAssignment_9 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5094:1: ( ( rule__ProjectionIndexerRecipe__ParentAssignment_9 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5095:1: ( rule__ProjectionIndexerRecipe__ParentAssignment_9 )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getParentAssignment_9()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5096:1: ( rule__ProjectionIndexerRecipe__ParentAssignment_9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5096:2: rule__ProjectionIndexerRecipe__ParentAssignment_9
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__ParentAssignment_9_in_rule__ProjectionIndexerRecipe__Group__9__Impl10014);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5106:1: rule__ProjectionIndexerRecipe__Group__10 : rule__ProjectionIndexerRecipe__Group__10__Impl ;
    public final void rule__ProjectionIndexerRecipe__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5110:1: ( rule__ProjectionIndexerRecipe__Group__10__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5111:2: rule__ProjectionIndexerRecipe__Group__10__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProjectionIndexerRecipe__Group__10__Impl_in_rule__ProjectionIndexerRecipe__Group__1010044);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5117:1: rule__ProjectionIndexerRecipe__Group__10__Impl : ( '}' ) ;
    public final void rule__ProjectionIndexerRecipe__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5121:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5122:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5122:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5123:1: '}'
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getRightCurlyBracketKeyword_10()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__ProjectionIndexerRecipe__Group__10__Impl10072); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5158:1: rule__Mask__Group__0 : rule__Mask__Group__0__Impl rule__Mask__Group__1 ;
    public final void rule__Mask__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5162:1: ( rule__Mask__Group__0__Impl rule__Mask__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5163:2: rule__Mask__Group__0__Impl rule__Mask__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__0__Impl_in_rule__Mask__Group__010125);
            rule__Mask__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__1_in_rule__Mask__Group__010128);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5170:1: rule__Mask__Group__0__Impl : ( '{' ) ;
    public final void rule__Mask__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5174:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5175:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5175:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5176:1: '{'
            {
             before(grammarAccess.getMaskAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Mask__Group__0__Impl10156); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5189:1: rule__Mask__Group__1 : rule__Mask__Group__1__Impl rule__Mask__Group__2 ;
    public final void rule__Mask__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5193:1: ( rule__Mask__Group__1__Impl rule__Mask__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5194:2: rule__Mask__Group__1__Impl rule__Mask__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__1__Impl_in_rule__Mask__Group__110187);
            rule__Mask__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__2_in_rule__Mask__Group__110190);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5201:1: rule__Mask__Group__1__Impl : ( 'sourceArity' ) ;
    public final void rule__Mask__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5205:1: ( ( 'sourceArity' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5206:1: ( 'sourceArity' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5206:1: ( 'sourceArity' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5207:1: 'sourceArity'
            {
             before(grammarAccess.getMaskAccess().getSourceArityKeyword_1()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__Mask__Group__1__Impl10218); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5220:1: rule__Mask__Group__2 : rule__Mask__Group__2__Impl rule__Mask__Group__3 ;
    public final void rule__Mask__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5224:1: ( rule__Mask__Group__2__Impl rule__Mask__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5225:2: rule__Mask__Group__2__Impl rule__Mask__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__2__Impl_in_rule__Mask__Group__210249);
            rule__Mask__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__3_in_rule__Mask__Group__210252);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5232:1: rule__Mask__Group__2__Impl : ( ':' ) ;
    public final void rule__Mask__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5236:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5237:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5237:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5238:1: ':'
            {
             before(grammarAccess.getMaskAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Mask__Group__2__Impl10280); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5251:1: rule__Mask__Group__3 : rule__Mask__Group__3__Impl rule__Mask__Group__4 ;
    public final void rule__Mask__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5255:1: ( rule__Mask__Group__3__Impl rule__Mask__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5256:2: rule__Mask__Group__3__Impl rule__Mask__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__3__Impl_in_rule__Mask__Group__310311);
            rule__Mask__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__4_in_rule__Mask__Group__310314);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5263:1: rule__Mask__Group__3__Impl : ( ( rule__Mask__SourceArityAssignment_3 ) ) ;
    public final void rule__Mask__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5267:1: ( ( ( rule__Mask__SourceArityAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5268:1: ( ( rule__Mask__SourceArityAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5268:1: ( ( rule__Mask__SourceArityAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5269:1: ( rule__Mask__SourceArityAssignment_3 )
            {
             before(grammarAccess.getMaskAccess().getSourceArityAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5270:1: ( rule__Mask__SourceArityAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5270:2: rule__Mask__SourceArityAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__SourceArityAssignment_3_in_rule__Mask__Group__3__Impl10341);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5280:1: rule__Mask__Group__4 : rule__Mask__Group__4__Impl rule__Mask__Group__5 ;
    public final void rule__Mask__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5284:1: ( rule__Mask__Group__4__Impl rule__Mask__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5285:2: rule__Mask__Group__4__Impl rule__Mask__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__4__Impl_in_rule__Mask__Group__410371);
            rule__Mask__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__5_in_rule__Mask__Group__410374);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5292:1: rule__Mask__Group__4__Impl : ( ( rule__Mask__Group_4__0 )* ) ;
    public final void rule__Mask__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5296:1: ( ( ( rule__Mask__Group_4__0 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5297:1: ( ( rule__Mask__Group_4__0 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5297:1: ( ( rule__Mask__Group_4__0 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5298:1: ( rule__Mask__Group_4__0 )*
            {
             before(grammarAccess.getMaskAccess().getGroup_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5299:1: ( rule__Mask__Group_4__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==38) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5299:2: rule__Mask__Group_4__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__0_in_rule__Mask__Group__4__Impl10401);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5309:1: rule__Mask__Group__5 : rule__Mask__Group__5__Impl ;
    public final void rule__Mask__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5313:1: ( rule__Mask__Group__5__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5314:2: rule__Mask__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group__5__Impl_in_rule__Mask__Group__510432);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5320:1: rule__Mask__Group__5__Impl : ( '}' ) ;
    public final void rule__Mask__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5324:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5325:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5325:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5326:1: '}'
            {
             before(grammarAccess.getMaskAccess().getRightCurlyBracketKeyword_5()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Mask__Group__5__Impl10460); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5351:1: rule__Mask__Group_4__0 : rule__Mask__Group_4__0__Impl rule__Mask__Group_4__1 ;
    public final void rule__Mask__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5355:1: ( rule__Mask__Group_4__0__Impl rule__Mask__Group_4__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5356:2: rule__Mask__Group_4__0__Impl rule__Mask__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__0__Impl_in_rule__Mask__Group_4__010503);
            rule__Mask__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__1_in_rule__Mask__Group_4__010506);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5363:1: rule__Mask__Group_4__0__Impl : ( 'sourceIndices' ) ;
    public final void rule__Mask__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5367:1: ( ( 'sourceIndices' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5368:1: ( 'sourceIndices' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5368:1: ( 'sourceIndices' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5369:1: 'sourceIndices'
            {
             before(grammarAccess.getMaskAccess().getSourceIndicesKeyword_4_0()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__Mask__Group_4__0__Impl10534); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5382:1: rule__Mask__Group_4__1 : rule__Mask__Group_4__1__Impl rule__Mask__Group_4__2 ;
    public final void rule__Mask__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5386:1: ( rule__Mask__Group_4__1__Impl rule__Mask__Group_4__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5387:2: rule__Mask__Group_4__1__Impl rule__Mask__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__1__Impl_in_rule__Mask__Group_4__110565);
            rule__Mask__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__2_in_rule__Mask__Group_4__110568);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5394:1: rule__Mask__Group_4__1__Impl : ( ':' ) ;
    public final void rule__Mask__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5398:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5399:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5399:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5400:1: ':'
            {
             before(grammarAccess.getMaskAccess().getColonKeyword_4_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Mask__Group_4__1__Impl10596); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5413:1: rule__Mask__Group_4__2 : rule__Mask__Group_4__2__Impl rule__Mask__Group_4__3 ;
    public final void rule__Mask__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5417:1: ( rule__Mask__Group_4__2__Impl rule__Mask__Group_4__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5418:2: rule__Mask__Group_4__2__Impl rule__Mask__Group_4__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__2__Impl_in_rule__Mask__Group_4__210627);
            rule__Mask__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__3_in_rule__Mask__Group_4__210630);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5425:1: rule__Mask__Group_4__2__Impl : ( '[' ) ;
    public final void rule__Mask__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5429:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5430:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5430:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5431:1: '['
            {
             before(grammarAccess.getMaskAccess().getLeftSquareBracketKeyword_4_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Mask__Group_4__2__Impl10658); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5444:1: rule__Mask__Group_4__3 : rule__Mask__Group_4__3__Impl rule__Mask__Group_4__4 ;
    public final void rule__Mask__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5448:1: ( rule__Mask__Group_4__3__Impl rule__Mask__Group_4__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5449:2: rule__Mask__Group_4__3__Impl rule__Mask__Group_4__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__3__Impl_in_rule__Mask__Group_4__310689);
            rule__Mask__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__4_in_rule__Mask__Group_4__310692);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5456:1: rule__Mask__Group_4__3__Impl : ( ( rule__Mask__SourceIndicesAssignment_4_3 )* ) ;
    public final void rule__Mask__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5460:1: ( ( ( rule__Mask__SourceIndicesAssignment_4_3 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5461:1: ( ( rule__Mask__SourceIndicesAssignment_4_3 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5461:1: ( ( rule__Mask__SourceIndicesAssignment_4_3 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5462:1: ( rule__Mask__SourceIndicesAssignment_4_3 )*
            {
             before(grammarAccess.getMaskAccess().getSourceIndicesAssignment_4_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5463:1: ( rule__Mask__SourceIndicesAssignment_4_3 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_INT) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5463:2: rule__Mask__SourceIndicesAssignment_4_3
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Mask__SourceIndicesAssignment_4_3_in_rule__Mask__Group_4__3__Impl10719);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5473:1: rule__Mask__Group_4__4 : rule__Mask__Group_4__4__Impl ;
    public final void rule__Mask__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5477:1: ( rule__Mask__Group_4__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5478:2: rule__Mask__Group_4__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mask__Group_4__4__Impl_in_rule__Mask__Group_4__410750);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5484:1: rule__Mask__Group_4__4__Impl : ( ']' ) ;
    public final void rule__Mask__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5488:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5489:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5489:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5490:1: ']'
            {
             before(grammarAccess.getMaskAccess().getRightSquareBracketKeyword_4_4()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Mask__Group_4__4__Impl10778); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5513:1: rule__InfrastructureMapping__Group__0 : rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1 ;
    public final void rule__InfrastructureMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5517:1: ( rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5518:2: rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__0__Impl_in_rule__InfrastructureMapping__Group__010819);
            rule__InfrastructureMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__1_in_rule__InfrastructureMapping__Group__010822);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5525:1: rule__InfrastructureMapping__Group__0__Impl : ( '{' ) ;
    public final void rule__InfrastructureMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5529:1: ( ( '{' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5530:1: ( '{' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5530:1: ( '{' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5531:1: '{'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getLeftCurlyBracketKeyword_0()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__InfrastructureMapping__Group__0__Impl10850); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5544:1: rule__InfrastructureMapping__Group__1 : rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2 ;
    public final void rule__InfrastructureMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5548:1: ( rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5549:2: rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__1__Impl_in_rule__InfrastructureMapping__Group__110881);
            rule__InfrastructureMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__2_in_rule__InfrastructureMapping__Group__110884);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5556:1: rule__InfrastructureMapping__Group__1__Impl : ( 'from' ) ;
    public final void rule__InfrastructureMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5560:1: ( ( 'from' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5561:1: ( 'from' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5561:1: ( 'from' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5562:1: 'from'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getFromKeyword_1()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__InfrastructureMapping__Group__1__Impl10912); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5575:1: rule__InfrastructureMapping__Group__2 : rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3 ;
    public final void rule__InfrastructureMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5579:1: ( rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5580:2: rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__2__Impl_in_rule__InfrastructureMapping__Group__210943);
            rule__InfrastructureMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__3_in_rule__InfrastructureMapping__Group__210946);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5587:1: rule__InfrastructureMapping__Group__2__Impl : ( ':' ) ;
    public final void rule__InfrastructureMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5591:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5592:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5592:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5593:1: ':'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getColonKeyword_2()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__InfrastructureMapping__Group__2__Impl10974); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5606:1: rule__InfrastructureMapping__Group__3 : rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4 ;
    public final void rule__InfrastructureMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5610:1: ( rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5611:2: rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__3__Impl_in_rule__InfrastructureMapping__Group__311005);
            rule__InfrastructureMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__4_in_rule__InfrastructureMapping__Group__311008);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5618:1: rule__InfrastructureMapping__Group__3__Impl : ( '[' ) ;
    public final void rule__InfrastructureMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5622:1: ( ( '[' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5623:1: ( '[' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5623:1: ( '[' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5624:1: '['
            {
             before(grammarAccess.getInfrastructureMappingAccess().getLeftSquareBracketKeyword_3()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__InfrastructureMapping__Group__3__Impl11036); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5637:1: rule__InfrastructureMapping__Group__4 : rule__InfrastructureMapping__Group__4__Impl rule__InfrastructureMapping__Group__5 ;
    public final void rule__InfrastructureMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5641:1: ( rule__InfrastructureMapping__Group__4__Impl rule__InfrastructureMapping__Group__5 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5642:2: rule__InfrastructureMapping__Group__4__Impl rule__InfrastructureMapping__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__4__Impl_in_rule__InfrastructureMapping__Group__411067);
            rule__InfrastructureMapping__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__5_in_rule__InfrastructureMapping__Group__411070);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5649:1: rule__InfrastructureMapping__Group__4__Impl : ( ( rule__InfrastructureMapping__MappedElementsAssignment_4 )* ) ;
    public final void rule__InfrastructureMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5653:1: ( ( ( rule__InfrastructureMapping__MappedElementsAssignment_4 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5654:1: ( ( rule__InfrastructureMapping__MappedElementsAssignment_4 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5654:1: ( ( rule__InfrastructureMapping__MappedElementsAssignment_4 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5655:1: ( rule__InfrastructureMapping__MappedElementsAssignment_4 )*
            {
             before(grammarAccess.getInfrastructureMappingAccess().getMappedElementsAssignment_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5656:1: ( rule__InfrastructureMapping__MappedElementsAssignment_4 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5656:2: rule__InfrastructureMapping__MappedElementsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__MappedElementsAssignment_4_in_rule__InfrastructureMapping__Group__4__Impl11097);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5666:1: rule__InfrastructureMapping__Group__5 : rule__InfrastructureMapping__Group__5__Impl rule__InfrastructureMapping__Group__6 ;
    public final void rule__InfrastructureMapping__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5670:1: ( rule__InfrastructureMapping__Group__5__Impl rule__InfrastructureMapping__Group__6 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5671:2: rule__InfrastructureMapping__Group__5__Impl rule__InfrastructureMapping__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__5__Impl_in_rule__InfrastructureMapping__Group__511128);
            rule__InfrastructureMapping__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__6_in_rule__InfrastructureMapping__Group__511131);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5678:1: rule__InfrastructureMapping__Group__5__Impl : ( ']' ) ;
    public final void rule__InfrastructureMapping__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5682:1: ( ( ']' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5683:1: ( ']' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5683:1: ( ']' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5684:1: ']'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getRightSquareBracketKeyword_5()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__InfrastructureMapping__Group__5__Impl11159); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5697:1: rule__InfrastructureMapping__Group__6 : rule__InfrastructureMapping__Group__6__Impl rule__InfrastructureMapping__Group__7 ;
    public final void rule__InfrastructureMapping__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5701:1: ( rule__InfrastructureMapping__Group__6__Impl rule__InfrastructureMapping__Group__7 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5702:2: rule__InfrastructureMapping__Group__6__Impl rule__InfrastructureMapping__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__6__Impl_in_rule__InfrastructureMapping__Group__611190);
            rule__InfrastructureMapping__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__7_in_rule__InfrastructureMapping__Group__611193);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5709:1: rule__InfrastructureMapping__Group__6__Impl : ( 'to' ) ;
    public final void rule__InfrastructureMapping__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5713:1: ( ( 'to' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5714:1: ( 'to' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5714:1: ( 'to' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5715:1: 'to'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getToKeyword_6()); 
            match(input,40,FollowSets000.FOLLOW_40_in_rule__InfrastructureMapping__Group__6__Impl11221); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5728:1: rule__InfrastructureMapping__Group__7 : rule__InfrastructureMapping__Group__7__Impl rule__InfrastructureMapping__Group__8 ;
    public final void rule__InfrastructureMapping__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5732:1: ( rule__InfrastructureMapping__Group__7__Impl rule__InfrastructureMapping__Group__8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5733:2: rule__InfrastructureMapping__Group__7__Impl rule__InfrastructureMapping__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__7__Impl_in_rule__InfrastructureMapping__Group__711252);
            rule__InfrastructureMapping__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__8_in_rule__InfrastructureMapping__Group__711255);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5740:1: rule__InfrastructureMapping__Group__7__Impl : ( ':' ) ;
    public final void rule__InfrastructureMapping__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5744:1: ( ( ':' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5745:1: ( ':' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5745:1: ( ':' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5746:1: ':'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getColonKeyword_7()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__InfrastructureMapping__Group__7__Impl11283); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5759:1: rule__InfrastructureMapping__Group__8 : rule__InfrastructureMapping__Group__8__Impl rule__InfrastructureMapping__Group__9 ;
    public final void rule__InfrastructureMapping__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5763:1: ( rule__InfrastructureMapping__Group__8__Impl rule__InfrastructureMapping__Group__9 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5764:2: rule__InfrastructureMapping__Group__8__Impl rule__InfrastructureMapping__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__8__Impl_in_rule__InfrastructureMapping__Group__811314);
            rule__InfrastructureMapping__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__9_in_rule__InfrastructureMapping__Group__811317);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5771:1: rule__InfrastructureMapping__Group__8__Impl : ( ( rule__InfrastructureMapping__TargetElementAssignment_8 ) ) ;
    public final void rule__InfrastructureMapping__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5775:1: ( ( ( rule__InfrastructureMapping__TargetElementAssignment_8 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5776:1: ( ( rule__InfrastructureMapping__TargetElementAssignment_8 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5776:1: ( ( rule__InfrastructureMapping__TargetElementAssignment_8 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5777:1: ( rule__InfrastructureMapping__TargetElementAssignment_8 )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getTargetElementAssignment_8()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5778:1: ( rule__InfrastructureMapping__TargetElementAssignment_8 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5778:2: rule__InfrastructureMapping__TargetElementAssignment_8
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__TargetElementAssignment_8_in_rule__InfrastructureMapping__Group__8__Impl11344);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5788:1: rule__InfrastructureMapping__Group__9 : rule__InfrastructureMapping__Group__9__Impl ;
    public final void rule__InfrastructureMapping__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5792:1: ( rule__InfrastructureMapping__Group__9__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5793:2: rule__InfrastructureMapping__Group__9__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__9__Impl_in_rule__InfrastructureMapping__Group__911374);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5799:1: rule__InfrastructureMapping__Group__9__Impl : ( '}' ) ;
    public final void rule__InfrastructureMapping__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5803:1: ( ( '}' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5804:1: ( '}' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5804:1: ( '}' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5805:1: '}'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getRightCurlyBracketKeyword_9()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__InfrastructureMapping__Group__9__Impl11402); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5839:1: rule__Configuration__ClustersAssignment_1_3 : ( ruleCluster ) ;
    public final void rule__Configuration__ClustersAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5843:1: ( ( ruleCluster ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5844:1: ( ruleCluster )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5844:1: ( ruleCluster )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5845:1: ruleCluster
            {
             before(grammarAccess.getConfigurationAccess().getClustersClusterParserRuleCall_1_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleCluster_in_rule__Configuration__ClustersAssignment_1_311458);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5854:1: rule__Configuration__ReteRecipesAssignment_2_3 : ( ruleReteRecipe ) ;
    public final void rule__Configuration__ReteRecipesAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5858:1: ( ( ruleReteRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5859:1: ( ruleReteRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5859:1: ( ruleReteRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5860:1: ruleReteRecipe
            {
             before(grammarAccess.getConfigurationAccess().getReteRecipesReteRecipeParserRuleCall_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteRecipe_in_rule__Configuration__ReteRecipesAssignment_2_311489);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5869:1: rule__Configuration__MappingsAssignment_3_3 : ( ruleInfrastructureMapping ) ;
    public final void rule__Configuration__MappingsAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5873:1: ( ( ruleInfrastructureMapping ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5874:1: ( ruleInfrastructureMapping )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5874:1: ( ruleInfrastructureMapping )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5875:1: ruleInfrastructureMapping
            {
             before(grammarAccess.getConfigurationAccess().getMappingsInfrastructureMappingParserRuleCall_3_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_rule__Configuration__MappingsAssignment_3_311520);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5884:1: rule__Cluster__ReteMachinesAssignment_2_3 : ( ruleMachine ) ;
    public final void rule__Cluster__ReteMachinesAssignment_2_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5888:1: ( ( ruleMachine ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5889:1: ( ruleMachine )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5889:1: ( ruleMachine )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5890:1: ruleMachine
            {
             before(grammarAccess.getClusterAccess().getReteMachinesMachineParserRuleCall_2_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_rule__Cluster__ReteMachinesAssignment_2_311551);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5899:1: rule__Cluster__CacheMachinesAssignment_3_3 : ( ruleMachine ) ;
    public final void rule__Cluster__CacheMachinesAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5903:1: ( ( ruleMachine ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5904:1: ( ruleMachine )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5904:1: ( ruleMachine )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5905:1: ruleMachine
            {
             before(grammarAccess.getClusterAccess().getCacheMachinesMachineParserRuleCall_3_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_rule__Cluster__CacheMachinesAssignment_3_311582);
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


    // $ANTLR start "rule__Machine__NameAssignment_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5914:1: rule__Machine__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__Machine__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5918:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5919:1: ( RULE_ID )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5919:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5920:1: RULE_ID
            {
             before(grammarAccess.getMachineAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Machine__NameAssignment_311613); 
             after(grammarAccess.getMachineAccess().getNameIDTerminalRuleCall_3_0()); 

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
    // $ANTLR end "rule__Machine__NameAssignment_3"


    // $ANTLR start "rule__Machine__TraceInfoAssignment_6"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5929:1: rule__Machine__TraceInfoAssignment_6 : ( RULE_STRING ) ;
    public final void rule__Machine__TraceInfoAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5933:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5934:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5934:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5935:1: RULE_STRING
            {
             before(grammarAccess.getMachineAccess().getTraceInfoSTRINGTerminalRuleCall_6_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__Machine__TraceInfoAssignment_611644); 
             after(grammarAccess.getMachineAccess().getTraceInfoSTRINGTerminalRuleCall_6_0()); 

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
    // $ANTLR end "rule__Machine__TraceInfoAssignment_6"


    // $ANTLR start "rule__Machine__IpAssignment_9"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5944:1: rule__Machine__IpAssignment_9 : ( RULE_IP ) ;
    public final void rule__Machine__IpAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5948:1: ( ( RULE_IP ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5949:1: ( RULE_IP )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5949:1: ( RULE_IP )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5950:1: RULE_IP
            {
             before(grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_9_0()); 
            match(input,RULE_IP,FollowSets000.FOLLOW_RULE_IP_in_rule__Machine__IpAssignment_911675); 
             after(grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_9_0()); 

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
    // $ANTLR end "rule__Machine__IpAssignment_9"


    // $ANTLR start "rule__ReteRecipe__RecipeNodesAssignment_5"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5959:1: rule__ReteRecipe__RecipeNodesAssignment_5 : ( ruleReteNodeRecipe ) ;
    public final void rule__ReteRecipe__RecipeNodesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5963:1: ( ( ruleReteNodeRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5964:1: ( ruleReteNodeRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5964:1: ( ruleReteNodeRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5965:1: ruleReteNodeRecipe
            {
             before(grammarAccess.getReteRecipeAccess().getRecipeNodesReteNodeRecipeParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteNodeRecipe_in_rule__ReteRecipe__RecipeNodesAssignment_511706);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5974:1: rule__ProductionRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__ProductionRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5978:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5979:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5979:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5980:1: RULE_STRING
            {
             before(grammarAccess.getProductionRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ProductionRecipe__TraceInfoAssignment_411737); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5989:1: rule__ProductionRecipe__ParentsAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__ProductionRecipe__ParentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5993:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5994:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5994:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5995:1: ( RULE_ID )
            {
             before(grammarAccess.getProductionRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5996:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:5997:1: RULE_ID
            {
             before(grammarAccess.getProductionRecipeAccess().getParentsReteNodeRecipeIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ProductionRecipe__ParentsAssignment_811772); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6008:1: rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6012:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6013:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6013:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6014:1: RULE_STRING
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__UniquenessEnforcerRecipe__TraceInfoAssignment_411807); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6023:1: rule__UniquenessEnforcerRecipe__ParentsAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__UniquenessEnforcerRecipe__ParentsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6027:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6028:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6028:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6029:1: ( RULE_ID )
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsReteNodeRecipeCrossReference_8_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6030:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6031:1: RULE_ID
            {
             before(grammarAccess.getUniquenessEnforcerRecipeAccess().getParentsReteNodeRecipeIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__UniquenessEnforcerRecipe__ParentsAssignment_811842); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6042:1: rule__CheckRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__CheckRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6046:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6047:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6047:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6048:1: RULE_STRING
            {
             before(grammarAccess.getCheckRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__CheckRecipe__TraceInfoAssignment_411877); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6057:1: rule__CheckRecipe__ParentAssignment_7 : ( ( RULE_ID ) ) ;
    public final void rule__CheckRecipe__ParentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6061:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6062:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6062:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6063:1: ( RULE_ID )
            {
             before(grammarAccess.getCheckRecipeAccess().getParentReteNodeRecipeCrossReference_7_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6064:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6065:1: RULE_ID
            {
             before(grammarAccess.getCheckRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_7_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__CheckRecipe__ParentAssignment_711912); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6076:1: rule__TrimmerRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__TrimmerRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6080:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6081:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6081:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6082:1: RULE_STRING
            {
             before(grammarAccess.getTrimmerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__TrimmerRecipe__TraceInfoAssignment_411947); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6091:1: rule__TrimmerRecipe__MaskAssignment_7 : ( ruleMask ) ;
    public final void rule__TrimmerRecipe__MaskAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6095:1: ( ( ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6096:1: ( ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6096:1: ( ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6097:1: ruleMask
            {
             before(grammarAccess.getTrimmerRecipeAccess().getMaskMaskParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_rule__TrimmerRecipe__MaskAssignment_711978);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6106:1: rule__TrimmerRecipe__ParentAssignment_10 : ( ( RULE_ID ) ) ;
    public final void rule__TrimmerRecipe__ParentAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6110:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6111:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6111:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6112:1: ( RULE_ID )
            {
             before(grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeCrossReference_10_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6113:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6114:1: RULE_ID
            {
             before(grammarAccess.getTrimmerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_10_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__TrimmerRecipe__ParentAssignment_1012013); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6125:1: rule__JoinRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__JoinRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6129:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6130:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6130:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6131:1: RULE_STRING
            {
             before(grammarAccess.getJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__JoinRecipe__TraceInfoAssignment_412048); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6140:1: rule__JoinRecipe__LeftParentAssignment_7 : ( ruleProjectionIndexerRecipe ) ;
    public final void rule__JoinRecipe__LeftParentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6144:1: ( ( ruleProjectionIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6145:1: ( ruleProjectionIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6145:1: ( ruleProjectionIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6146:1: ruleProjectionIndexerRecipe
            {
             before(grammarAccess.getJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleProjectionIndexerRecipe_in_rule__JoinRecipe__LeftParentAssignment_712079);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6155:1: rule__JoinRecipe__RightParentAssignment_10 : ( ruleIndexerRecipe ) ;
    public final void rule__JoinRecipe__RightParentAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6159:1: ( ( ruleIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6160:1: ( ruleIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6160:1: ( ruleIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6161:1: ruleIndexerRecipe
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleIndexerRecipe_in_rule__JoinRecipe__RightParentAssignment_1012110);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6170:1: rule__JoinRecipe__RightParentComplementaryMaskAssignment_11 : ( ruleMask ) ;
    public final void rule__JoinRecipe__RightParentComplementaryMaskAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6174:1: ( ( ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6175:1: ( ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6175:1: ( ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6176:1: ruleMask
            {
             before(grammarAccess.getJoinRecipeAccess().getRightParentComplementaryMaskMaskParserRuleCall_11_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_rule__JoinRecipe__RightParentComplementaryMaskAssignment_1112141);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6185:1: rule__AntiJoinRecipe__TraceInfoAssignment_4 : ( RULE_STRING ) ;
    public final void rule__AntiJoinRecipe__TraceInfoAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6189:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6190:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6190:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6191:1: RULE_STRING
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_4_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__AntiJoinRecipe__TraceInfoAssignment_412172); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6200:1: rule__AntiJoinRecipe__LeftParentAssignment_7 : ( ruleProjectionIndexerRecipe ) ;
    public final void rule__AntiJoinRecipe__LeftParentAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6204:1: ( ( ruleProjectionIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6205:1: ( ruleProjectionIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6205:1: ( ruleProjectionIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6206:1: ruleProjectionIndexerRecipe
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getLeftParentProjectionIndexerRecipeParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleProjectionIndexerRecipe_in_rule__AntiJoinRecipe__LeftParentAssignment_712203);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6215:1: rule__AntiJoinRecipe__RightParentAssignment_10 : ( ruleIndexerRecipe ) ;
    public final void rule__AntiJoinRecipe__RightParentAssignment_10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6219:1: ( ( ruleIndexerRecipe ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6220:1: ( ruleIndexerRecipe )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6220:1: ( ruleIndexerRecipe )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6221:1: ruleIndexerRecipe
            {
             before(grammarAccess.getAntiJoinRecipeAccess().getRightParentIndexerRecipeParserRuleCall_10_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleIndexerRecipe_in_rule__AntiJoinRecipe__RightParentAssignment_1012234);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6230:1: rule__IndexerRecipe__TraceInfoAssignment_3 : ( RULE_STRING ) ;
    public final void rule__IndexerRecipe__TraceInfoAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6234:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6235:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6235:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6236:1: RULE_STRING
            {
             before(grammarAccess.getIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__IndexerRecipe__TraceInfoAssignment_312265); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6245:1: rule__IndexerRecipe__MaskAssignment_6 : ( ruleMask ) ;
    public final void rule__IndexerRecipe__MaskAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6249:1: ( ( ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6250:1: ( ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6250:1: ( ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6251:1: ruleMask
            {
             before(grammarAccess.getIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_rule__IndexerRecipe__MaskAssignment_612296);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6260:1: rule__IndexerRecipe__ParentAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__IndexerRecipe__ParentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6264:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6265:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6265:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6266:1: ( RULE_ID )
            {
             before(grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6267:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6268:1: RULE_ID
            {
             before(grammarAccess.getIndexerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__IndexerRecipe__ParentAssignment_912331); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6279:1: rule__ProjectionIndexerRecipe__TraceInfoAssignment_3 : ( RULE_STRING ) ;
    public final void rule__ProjectionIndexerRecipe__TraceInfoAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6283:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6284:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6284:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6285:1: RULE_STRING
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getTraceInfoSTRINGTerminalRuleCall_3_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__ProjectionIndexerRecipe__TraceInfoAssignment_312366); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6294:1: rule__ProjectionIndexerRecipe__MaskAssignment_6 : ( ruleMask ) ;
    public final void rule__ProjectionIndexerRecipe__MaskAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6298:1: ( ( ruleMask ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6299:1: ( ruleMask )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6299:1: ( ruleMask )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6300:1: ruleMask
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getMaskMaskParserRuleCall_6_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMask_in_rule__ProjectionIndexerRecipe__MaskAssignment_612397);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6309:1: rule__ProjectionIndexerRecipe__ParentAssignment_9 : ( ( RULE_ID ) ) ;
    public final void rule__ProjectionIndexerRecipe__ParentAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6313:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6314:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6314:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6315:1: ( RULE_ID )
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeCrossReference_9_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6316:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6317:1: RULE_ID
            {
             before(grammarAccess.getProjectionIndexerRecipeAccess().getParentReteNodeRecipeIDTerminalRuleCall_9_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ProjectionIndexerRecipe__ParentAssignment_912432); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6328:1: rule__Mask__SourceArityAssignment_3 : ( RULE_INT ) ;
    public final void rule__Mask__SourceArityAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6332:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6333:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6333:1: ( RULE_INT )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6334:1: RULE_INT
            {
             before(grammarAccess.getMaskAccess().getSourceArityINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Mask__SourceArityAssignment_312467); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6343:1: rule__Mask__SourceIndicesAssignment_4_3 : ( RULE_INT ) ;
    public final void rule__Mask__SourceIndicesAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6347:1: ( ( RULE_INT ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6348:1: ( RULE_INT )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6348:1: ( RULE_INT )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6349:1: RULE_INT
            {
             before(grammarAccess.getMaskAccess().getSourceIndicesINTTerminalRuleCall_4_3_0()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__Mask__SourceIndicesAssignment_4_312498); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6358:1: rule__InfrastructureMapping__MappedElementsAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__InfrastructureMapping__MappedElementsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6362:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6363:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6363:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6364:1: ( RULE_ID )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getMappedElementsReteNodeRecipeCrossReference_4_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6365:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6366:1: RULE_ID
            {
             before(grammarAccess.getInfrastructureMappingAccess().getMappedElementsReteNodeRecipeIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__InfrastructureMapping__MappedElementsAssignment_412533); 
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6377:1: rule__InfrastructureMapping__TargetElementAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__InfrastructureMapping__TargetElementAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6381:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6382:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6382:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6383:1: ( RULE_ID )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getTargetElementMachineCrossReference_8_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6384:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:6385:1: RULE_ID
            {
             before(grammarAccess.getInfrastructureMappingAccess().getTargetElementMachineIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__InfrastructureMapping__TargetElementAssignment_812572); 
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
        public static final BitSet FOLLOW_rule__Machine__NameAssignment_3_in_rule__Machine__Group__3__Impl3444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__4__Impl_in_rule__Machine__Group__43474 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Machine__Group__5_in_rule__Machine__Group__43477 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Machine__Group__4__Impl3505 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__5__Impl_in_rule__Machine__Group__53536 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Machine__Group__6_in_rule__Machine__Group__53539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Machine__Group__5__Impl3567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__6__Impl_in_rule__Machine__Group__63598 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Machine__Group__7_in_rule__Machine__Group__63601 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__TraceInfoAssignment_6_in_rule__Machine__Group__6__Impl3628 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__7__Impl_in_rule__Machine__Group__73658 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Machine__Group__8_in_rule__Machine__Group__73661 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Machine__Group__7__Impl3689 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__8__Impl_in_rule__Machine__Group__83720 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__Machine__Group__9_in_rule__Machine__Group__83723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Machine__Group__8__Impl3751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__9__Impl_in_rule__Machine__Group__93782 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Machine__Group__10_in_rule__Machine__Group__93785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__IpAssignment_9_in_rule__Machine__Group__9__Impl3812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__Group__10__Impl_in_rule__Machine__Group__103842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Machine__Group__10__Impl3870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__0__Impl_in_rule__ReteRecipe__Group__03923 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__1_in_rule__ReteRecipe__Group__03926 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__1__Impl_in_rule__ReteRecipe__Group__13984 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__2_in_rule__ReteRecipe__Group__13987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__ReteRecipe__Group__1__Impl4015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__2__Impl_in_rule__ReteRecipe__Group__24046 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__3_in_rule__ReteRecipe__Group__24049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__ReteRecipe__Group__2__Impl4077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__3__Impl_in_rule__ReteRecipe__Group__34108 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__4_in_rule__ReteRecipe__Group__34111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ReteRecipe__Group__3__Impl4139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__4__Impl_in_rule__ReteRecipe__Group__44170 = new BitSet(new long[]{0x00000012B4008000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__5_in_rule__ReteRecipe__Group__44173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ReteRecipe__Group__4__Impl4201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__5__Impl_in_rule__ReteRecipe__Group__54232 = new BitSet(new long[]{0x00000012B4008000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__6_in_rule__ReteRecipe__Group__54235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__RecipeNodesAssignment_5_in_rule__ReteRecipe__Group__5__Impl4262 = new BitSet(new long[]{0x00000012B4000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__6__Impl_in_rule__ReteRecipe__Group__64293 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__7_in_rule__ReteRecipe__Group__64296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__ReteRecipe__Group__6__Impl4324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRecipe__Group__7__Impl_in_rule__ReteRecipe__Group__74355 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ReteRecipe__Group__7__Impl4383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__0__Impl_in_rule__ProductionRecipe__Group__04430 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__1_in_rule__ProductionRecipe__Group__04433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__ProductionRecipe__Group__0__Impl4461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__1__Impl_in_rule__ProductionRecipe__Group__14492 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__2_in_rule__ProductionRecipe__Group__14495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__ProductionRecipe__Group__1__Impl4523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__2__Impl_in_rule__ProductionRecipe__Group__24554 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__3_in_rule__ProductionRecipe__Group__24557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ProductionRecipe__Group__2__Impl4585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__3__Impl_in_rule__ProductionRecipe__Group__34616 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__4_in_rule__ProductionRecipe__Group__34619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProductionRecipe__Group__3__Impl4647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__4__Impl_in_rule__ProductionRecipe__Group__44678 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__5_in_rule__ProductionRecipe__Group__44681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__TraceInfoAssignment_4_in_rule__ProductionRecipe__Group__4__Impl4708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__5__Impl_in_rule__ProductionRecipe__Group__54738 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__6_in_rule__ProductionRecipe__Group__54741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__ProductionRecipe__Group__5__Impl4769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__6__Impl_in_rule__ProductionRecipe__Group__64800 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__7_in_rule__ProductionRecipe__Group__64803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProductionRecipe__Group__6__Impl4831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__7__Impl_in_rule__ProductionRecipe__Group__74862 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__8_in_rule__ProductionRecipe__Group__74865 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__ProductionRecipe__Group__7__Impl4893 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__8__Impl_in_rule__ProductionRecipe__Group__84924 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__9_in_rule__ProductionRecipe__Group__84927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__ParentsAssignment_8_in_rule__ProductionRecipe__Group__8__Impl4954 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__9__Impl_in_rule__ProductionRecipe__Group__94985 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__10_in_rule__ProductionRecipe__Group__94988 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__ProductionRecipe__Group__9__Impl5016 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProductionRecipe__Group__10__Impl_in_rule__ProductionRecipe__Group__105047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ProductionRecipe__Group__10__Impl5075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__0__Impl_in_rule__UniquenessEnforcerRecipe__Group__05128 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__1_in_rule__UniquenessEnforcerRecipe__Group__05131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__UniquenessEnforcerRecipe__Group__0__Impl5159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__1__Impl_in_rule__UniquenessEnforcerRecipe__Group__15190 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__2_in_rule__UniquenessEnforcerRecipe__Group__15193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__UniquenessEnforcerRecipe__Group__1__Impl5221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__2__Impl_in_rule__UniquenessEnforcerRecipe__Group__25252 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__3_in_rule__UniquenessEnforcerRecipe__Group__25255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__UniquenessEnforcerRecipe__Group__2__Impl5283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__3__Impl_in_rule__UniquenessEnforcerRecipe__Group__35314 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__4_in_rule__UniquenessEnforcerRecipe__Group__35317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__UniquenessEnforcerRecipe__Group__3__Impl5345 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__4__Impl_in_rule__UniquenessEnforcerRecipe__Group__45376 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__5_in_rule__UniquenessEnforcerRecipe__Group__45379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__TraceInfoAssignment_4_in_rule__UniquenessEnforcerRecipe__Group__4__Impl5406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__5__Impl_in_rule__UniquenessEnforcerRecipe__Group__55436 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__6_in_rule__UniquenessEnforcerRecipe__Group__55439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__UniquenessEnforcerRecipe__Group__5__Impl5467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__6__Impl_in_rule__UniquenessEnforcerRecipe__Group__65498 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__7_in_rule__UniquenessEnforcerRecipe__Group__65501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__UniquenessEnforcerRecipe__Group__6__Impl5529 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__7__Impl_in_rule__UniquenessEnforcerRecipe__Group__75560 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__8_in_rule__UniquenessEnforcerRecipe__Group__75563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__UniquenessEnforcerRecipe__Group__7__Impl5591 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__8__Impl_in_rule__UniquenessEnforcerRecipe__Group__85622 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__9_in_rule__UniquenessEnforcerRecipe__Group__85625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__ParentsAssignment_8_in_rule__UniquenessEnforcerRecipe__Group__8__Impl5652 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__9__Impl_in_rule__UniquenessEnforcerRecipe__Group__95683 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__10_in_rule__UniquenessEnforcerRecipe__Group__95686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__UniquenessEnforcerRecipe__Group__9__Impl5714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__UniquenessEnforcerRecipe__Group__10__Impl_in_rule__UniquenessEnforcerRecipe__Group__105745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__UniquenessEnforcerRecipe__Group__10__Impl5773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__0__Impl_in_rule__CheckRecipe__Group__05826 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__1_in_rule__CheckRecipe__Group__05829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__CheckRecipe__Group__0__Impl5857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__1__Impl_in_rule__CheckRecipe__Group__15888 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__2_in_rule__CheckRecipe__Group__15891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__CheckRecipe__Group__1__Impl5919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__2__Impl_in_rule__CheckRecipe__Group__25950 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__3_in_rule__CheckRecipe__Group__25953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__CheckRecipe__Group__2__Impl5981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__3__Impl_in_rule__CheckRecipe__Group__36012 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__4_in_rule__CheckRecipe__Group__36015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__CheckRecipe__Group__3__Impl6043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__4__Impl_in_rule__CheckRecipe__Group__46074 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__5_in_rule__CheckRecipe__Group__46077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__TraceInfoAssignment_4_in_rule__CheckRecipe__Group__4__Impl6104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__5__Impl_in_rule__CheckRecipe__Group__56134 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__6_in_rule__CheckRecipe__Group__56137 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__CheckRecipe__Group__5__Impl6165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__6__Impl_in_rule__CheckRecipe__Group__66196 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__7_in_rule__CheckRecipe__Group__66199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__CheckRecipe__Group__6__Impl6227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__7__Impl_in_rule__CheckRecipe__Group__76258 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__8_in_rule__CheckRecipe__Group__76261 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__ParentAssignment_7_in_rule__CheckRecipe__Group__7__Impl6288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CheckRecipe__Group__8__Impl_in_rule__CheckRecipe__Group__86318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__CheckRecipe__Group__8__Impl6346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__0__Impl_in_rule__TrimmerRecipe__Group__06395 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__1_in_rule__TrimmerRecipe__Group__06398 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__TrimmerRecipe__Group__0__Impl6426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__1__Impl_in_rule__TrimmerRecipe__Group__16457 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__2_in_rule__TrimmerRecipe__Group__16460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__TrimmerRecipe__Group__1__Impl6488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__2__Impl_in_rule__TrimmerRecipe__Group__26519 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__3_in_rule__TrimmerRecipe__Group__26522 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__TrimmerRecipe__Group__2__Impl6550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__3__Impl_in_rule__TrimmerRecipe__Group__36581 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__4_in_rule__TrimmerRecipe__Group__36584 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TrimmerRecipe__Group__3__Impl6612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__4__Impl_in_rule__TrimmerRecipe__Group__46643 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__5_in_rule__TrimmerRecipe__Group__46646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__TraceInfoAssignment_4_in_rule__TrimmerRecipe__Group__4__Impl6673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__5__Impl_in_rule__TrimmerRecipe__Group__56703 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__6_in_rule__TrimmerRecipe__Group__56706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__TrimmerRecipe__Group__5__Impl6734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__6__Impl_in_rule__TrimmerRecipe__Group__66765 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__7_in_rule__TrimmerRecipe__Group__66768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TrimmerRecipe__Group__6__Impl6796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__7__Impl_in_rule__TrimmerRecipe__Group__76827 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__8_in_rule__TrimmerRecipe__Group__76830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__MaskAssignment_7_in_rule__TrimmerRecipe__Group__7__Impl6857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__8__Impl_in_rule__TrimmerRecipe__Group__86887 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__9_in_rule__TrimmerRecipe__Group__86890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__TrimmerRecipe__Group__8__Impl6918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__9__Impl_in_rule__TrimmerRecipe__Group__96949 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__10_in_rule__TrimmerRecipe__Group__96952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__TrimmerRecipe__Group__9__Impl6980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__10__Impl_in_rule__TrimmerRecipe__Group__107011 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__11_in_rule__TrimmerRecipe__Group__107014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__ParentAssignment_10_in_rule__TrimmerRecipe__Group__10__Impl7041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TrimmerRecipe__Group__11__Impl_in_rule__TrimmerRecipe__Group__117071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__TrimmerRecipe__Group__11__Impl7099 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__0__Impl_in_rule__JoinRecipe__Group__07154 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__1_in_rule__JoinRecipe__Group__07157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__JoinRecipe__Group__0__Impl7185 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__1__Impl_in_rule__JoinRecipe__Group__17216 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__2_in_rule__JoinRecipe__Group__17219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__JoinRecipe__Group__1__Impl7247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__2__Impl_in_rule__JoinRecipe__Group__27278 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__3_in_rule__JoinRecipe__Group__27281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__JoinRecipe__Group__2__Impl7309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__3__Impl_in_rule__JoinRecipe__Group__37340 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__4_in_rule__JoinRecipe__Group__37343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__JoinRecipe__Group__3__Impl7371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__4__Impl_in_rule__JoinRecipe__Group__47402 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__5_in_rule__JoinRecipe__Group__47405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__TraceInfoAssignment_4_in_rule__JoinRecipe__Group__4__Impl7432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__5__Impl_in_rule__JoinRecipe__Group__57462 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__6_in_rule__JoinRecipe__Group__57465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__JoinRecipe__Group__5__Impl7493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__6__Impl_in_rule__JoinRecipe__Group__67524 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__7_in_rule__JoinRecipe__Group__67527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__JoinRecipe__Group__6__Impl7555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__7__Impl_in_rule__JoinRecipe__Group__77586 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__8_in_rule__JoinRecipe__Group__77589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__LeftParentAssignment_7_in_rule__JoinRecipe__Group__7__Impl7616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__8__Impl_in_rule__JoinRecipe__Group__87646 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__9_in_rule__JoinRecipe__Group__87649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__JoinRecipe__Group__8__Impl7677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__9__Impl_in_rule__JoinRecipe__Group__97708 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__10_in_rule__JoinRecipe__Group__97711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__JoinRecipe__Group__9__Impl7739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__10__Impl_in_rule__JoinRecipe__Group__107770 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__11_in_rule__JoinRecipe__Group__107773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__RightParentAssignment_10_in_rule__JoinRecipe__Group__10__Impl7800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__11__Impl_in_rule__JoinRecipe__Group__117830 = new BitSet(new long[]{0x00000000000C0000L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__12_in_rule__JoinRecipe__Group__117833 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__RightParentComplementaryMaskAssignment_11_in_rule__JoinRecipe__Group__11__Impl7860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__JoinRecipe__Group__12__Impl_in_rule__JoinRecipe__Group__127891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__JoinRecipe__Group__12__Impl7919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__0__Impl_in_rule__AntiJoinRecipe__Group__07976 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__1_in_rule__AntiJoinRecipe__Group__07979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__AntiJoinRecipe__Group__0__Impl8007 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__1__Impl_in_rule__AntiJoinRecipe__Group__18038 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__2_in_rule__AntiJoinRecipe__Group__18041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__AntiJoinRecipe__Group__1__Impl8069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__2__Impl_in_rule__AntiJoinRecipe__Group__28100 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__3_in_rule__AntiJoinRecipe__Group__28103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__AntiJoinRecipe__Group__2__Impl8131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__3__Impl_in_rule__AntiJoinRecipe__Group__38162 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__4_in_rule__AntiJoinRecipe__Group__38165 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AntiJoinRecipe__Group__3__Impl8193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__4__Impl_in_rule__AntiJoinRecipe__Group__48224 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__5_in_rule__AntiJoinRecipe__Group__48227 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__TraceInfoAssignment_4_in_rule__AntiJoinRecipe__Group__4__Impl8254 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__5__Impl_in_rule__AntiJoinRecipe__Group__58284 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__6_in_rule__AntiJoinRecipe__Group__58287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__AntiJoinRecipe__Group__5__Impl8315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__6__Impl_in_rule__AntiJoinRecipe__Group__68346 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__7_in_rule__AntiJoinRecipe__Group__68349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AntiJoinRecipe__Group__6__Impl8377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__7__Impl_in_rule__AntiJoinRecipe__Group__78408 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__8_in_rule__AntiJoinRecipe__Group__78411 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__LeftParentAssignment_7_in_rule__AntiJoinRecipe__Group__7__Impl8438 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__8__Impl_in_rule__AntiJoinRecipe__Group__88468 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__9_in_rule__AntiJoinRecipe__Group__88471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__AntiJoinRecipe__Group__8__Impl8499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__9__Impl_in_rule__AntiJoinRecipe__Group__98530 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__10_in_rule__AntiJoinRecipe__Group__98533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__AntiJoinRecipe__Group__9__Impl8561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__10__Impl_in_rule__AntiJoinRecipe__Group__108592 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__11_in_rule__AntiJoinRecipe__Group__108595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__RightParentAssignment_10_in_rule__AntiJoinRecipe__Group__10__Impl8622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AntiJoinRecipe__Group__11__Impl_in_rule__AntiJoinRecipe__Group__118652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__AntiJoinRecipe__Group__11__Impl8680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__0__Impl_in_rule__IndexerRecipe__Group__08735 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__1_in_rule__IndexerRecipe__Group__08738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__IndexerRecipe__Group__0__Impl8766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__1__Impl_in_rule__IndexerRecipe__Group__18797 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__2_in_rule__IndexerRecipe__Group__18800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__IndexerRecipe__Group__1__Impl8828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__2__Impl_in_rule__IndexerRecipe__Group__28859 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__3_in_rule__IndexerRecipe__Group__28862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__IndexerRecipe__Group__2__Impl8890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__3__Impl_in_rule__IndexerRecipe__Group__38921 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__4_in_rule__IndexerRecipe__Group__38924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__TraceInfoAssignment_3_in_rule__IndexerRecipe__Group__3__Impl8951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__4__Impl_in_rule__IndexerRecipe__Group__48981 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__5_in_rule__IndexerRecipe__Group__48984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__IndexerRecipe__Group__4__Impl9012 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__5__Impl_in_rule__IndexerRecipe__Group__59043 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__6_in_rule__IndexerRecipe__Group__59046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__IndexerRecipe__Group__5__Impl9074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__6__Impl_in_rule__IndexerRecipe__Group__69105 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__7_in_rule__IndexerRecipe__Group__69108 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__MaskAssignment_6_in_rule__IndexerRecipe__Group__6__Impl9135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__7__Impl_in_rule__IndexerRecipe__Group__79165 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__8_in_rule__IndexerRecipe__Group__79168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__IndexerRecipe__Group__7__Impl9196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__8__Impl_in_rule__IndexerRecipe__Group__89227 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__9_in_rule__IndexerRecipe__Group__89230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__IndexerRecipe__Group__8__Impl9258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__9__Impl_in_rule__IndexerRecipe__Group__99289 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__10_in_rule__IndexerRecipe__Group__99292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__ParentAssignment_9_in_rule__IndexerRecipe__Group__9__Impl9319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IndexerRecipe__Group__10__Impl_in_rule__IndexerRecipe__Group__109349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__IndexerRecipe__Group__10__Impl9377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__0__Impl_in_rule__ProjectionIndexerRecipe__Group__09430 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__1_in_rule__ProjectionIndexerRecipe__Group__09433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__ProjectionIndexerRecipe__Group__0__Impl9461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__1__Impl_in_rule__ProjectionIndexerRecipe__Group__19492 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__2_in_rule__ProjectionIndexerRecipe__Group__19495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__ProjectionIndexerRecipe__Group__1__Impl9523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__2__Impl_in_rule__ProjectionIndexerRecipe__Group__29554 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__3_in_rule__ProjectionIndexerRecipe__Group__29557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__2__Impl9585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__3__Impl_in_rule__ProjectionIndexerRecipe__Group__39616 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__4_in_rule__ProjectionIndexerRecipe__Group__39619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__TraceInfoAssignment_3_in_rule__ProjectionIndexerRecipe__Group__3__Impl9646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__4__Impl_in_rule__ProjectionIndexerRecipe__Group__49676 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__5_in_rule__ProjectionIndexerRecipe__Group__49679 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__ProjectionIndexerRecipe__Group__4__Impl9707 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__5__Impl_in_rule__ProjectionIndexerRecipe__Group__59738 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__6_in_rule__ProjectionIndexerRecipe__Group__59741 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__5__Impl9769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__6__Impl_in_rule__ProjectionIndexerRecipe__Group__69800 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__7_in_rule__ProjectionIndexerRecipe__Group__69803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__MaskAssignment_6_in_rule__ProjectionIndexerRecipe__Group__6__Impl9830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__7__Impl_in_rule__ProjectionIndexerRecipe__Group__79860 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__8_in_rule__ProjectionIndexerRecipe__Group__79863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__ProjectionIndexerRecipe__Group__7__Impl9891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__8__Impl_in_rule__ProjectionIndexerRecipe__Group__89922 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__9_in_rule__ProjectionIndexerRecipe__Group__89925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__ProjectionIndexerRecipe__Group__8__Impl9953 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__9__Impl_in_rule__ProjectionIndexerRecipe__Group__99984 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__10_in_rule__ProjectionIndexerRecipe__Group__99987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__ParentAssignment_9_in_rule__ProjectionIndexerRecipe__Group__9__Impl10014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProjectionIndexerRecipe__Group__10__Impl_in_rule__ProjectionIndexerRecipe__Group__1010044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__ProjectionIndexerRecipe__Group__10__Impl10072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__0__Impl_in_rule__Mask__Group__010125 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_rule__Mask__Group__1_in_rule__Mask__Group__010128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Mask__Group__0__Impl10156 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__1__Impl_in_rule__Mask__Group__110187 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Mask__Group__2_in_rule__Mask__Group__110190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__Mask__Group__1__Impl10218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__2__Impl_in_rule__Mask__Group__210249 = new BitSet(new long[]{0x0000000000000080L});
        public static final BitSet FOLLOW_rule__Mask__Group__3_in_rule__Mask__Group__210252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Mask__Group__2__Impl10280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__3__Impl_in_rule__Mask__Group__310311 = new BitSet(new long[]{0x0000004000080000L});
        public static final BitSet FOLLOW_rule__Mask__Group__4_in_rule__Mask__Group__310314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__SourceArityAssignment_3_in_rule__Mask__Group__3__Impl10341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__4__Impl_in_rule__Mask__Group__410371 = new BitSet(new long[]{0x0000004000080000L});
        public static final BitSet FOLLOW_rule__Mask__Group__5_in_rule__Mask__Group__410374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__0_in_rule__Mask__Group__4__Impl10401 = new BitSet(new long[]{0x0000004000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group__5__Impl_in_rule__Mask__Group__510432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Mask__Group__5__Impl10460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__0__Impl_in_rule__Mask__Group_4__010503 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__1_in_rule__Mask__Group_4__010506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__Mask__Group_4__0__Impl10534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__1__Impl_in_rule__Mask__Group_4__110565 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__2_in_rule__Mask__Group_4__110568 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Mask__Group_4__1__Impl10596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__2__Impl_in_rule__Mask__Group_4__210627 = new BitSet(new long[]{0x0000000000008080L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__3_in_rule__Mask__Group_4__210630 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Mask__Group_4__2__Impl10658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__3__Impl_in_rule__Mask__Group_4__310689 = new BitSet(new long[]{0x0000000000008080L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__4_in_rule__Mask__Group_4__310692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mask__SourceIndicesAssignment_4_3_in_rule__Mask__Group_4__3__Impl10719 = new BitSet(new long[]{0x0000000000000082L});
        public static final BitSet FOLLOW_rule__Mask__Group_4__4__Impl_in_rule__Mask__Group_4__410750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Mask__Group_4__4__Impl10778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__0__Impl_in_rule__InfrastructureMapping__Group__010819 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__1_in_rule__InfrastructureMapping__Group__010822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__InfrastructureMapping__Group__0__Impl10850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__1__Impl_in_rule__InfrastructureMapping__Group__110881 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__2_in_rule__InfrastructureMapping__Group__110884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__InfrastructureMapping__Group__1__Impl10912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__2__Impl_in_rule__InfrastructureMapping__Group__210943 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__3_in_rule__InfrastructureMapping__Group__210946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__InfrastructureMapping__Group__2__Impl10974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__3__Impl_in_rule__InfrastructureMapping__Group__311005 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__4_in_rule__InfrastructureMapping__Group__311008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__InfrastructureMapping__Group__3__Impl11036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__4__Impl_in_rule__InfrastructureMapping__Group__411067 = new BitSet(new long[]{0x0000000000008010L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__5_in_rule__InfrastructureMapping__Group__411070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__MappedElementsAssignment_4_in_rule__InfrastructureMapping__Group__4__Impl11097 = new BitSet(new long[]{0x0000000000000012L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__5__Impl_in_rule__InfrastructureMapping__Group__511128 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__6_in_rule__InfrastructureMapping__Group__511131 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__InfrastructureMapping__Group__5__Impl11159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__6__Impl_in_rule__InfrastructureMapping__Group__611190 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__7_in_rule__InfrastructureMapping__Group__611193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_rule__InfrastructureMapping__Group__6__Impl11221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__7__Impl_in_rule__InfrastructureMapping__Group__711252 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__8_in_rule__InfrastructureMapping__Group__711255 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__InfrastructureMapping__Group__7__Impl11283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__8__Impl_in_rule__InfrastructureMapping__Group__811314 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__9_in_rule__InfrastructureMapping__Group__811317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__TargetElementAssignment_8_in_rule__InfrastructureMapping__Group__8__Impl11344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__9__Impl_in_rule__InfrastructureMapping__Group__911374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__InfrastructureMapping__Group__9__Impl11402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCluster_in_rule__Configuration__ClustersAssignment_1_311458 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteRecipe_in_rule__Configuration__ReteRecipesAssignment_2_311489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_rule__Configuration__MappingsAssignment_3_311520 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMachine_in_rule__Cluster__ReteMachinesAssignment_2_311551 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMachine_in_rule__Cluster__CacheMachinesAssignment_3_311582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Machine__NameAssignment_311613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__Machine__TraceInfoAssignment_611644 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_IP_in_rule__Machine__IpAssignment_911675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteNodeRecipe_in_rule__ReteRecipe__RecipeNodesAssignment_511706 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ProductionRecipe__TraceInfoAssignment_411737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ProductionRecipe__ParentsAssignment_811772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__UniquenessEnforcerRecipe__TraceInfoAssignment_411807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__UniquenessEnforcerRecipe__ParentsAssignment_811842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__CheckRecipe__TraceInfoAssignment_411877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__CheckRecipe__ParentAssignment_711912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__TrimmerRecipe__TraceInfoAssignment_411947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_rule__TrimmerRecipe__MaskAssignment_711978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__TrimmerRecipe__ParentAssignment_1012013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__JoinRecipe__TraceInfoAssignment_412048 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProjectionIndexerRecipe_in_rule__JoinRecipe__LeftParentAssignment_712079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexerRecipe_in_rule__JoinRecipe__RightParentAssignment_1012110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_rule__JoinRecipe__RightParentComplementaryMaskAssignment_1112141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__AntiJoinRecipe__TraceInfoAssignment_412172 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProjectionIndexerRecipe_in_rule__AntiJoinRecipe__LeftParentAssignment_712203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIndexerRecipe_in_rule__AntiJoinRecipe__RightParentAssignment_1012234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__IndexerRecipe__TraceInfoAssignment_312265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_rule__IndexerRecipe__MaskAssignment_612296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__IndexerRecipe__ParentAssignment_912331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__ProjectionIndexerRecipe__TraceInfoAssignment_312366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMask_in_rule__ProjectionIndexerRecipe__MaskAssignment_612397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ProjectionIndexerRecipe__ParentAssignment_912432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Mask__SourceArityAssignment_312467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__Mask__SourceIndicesAssignment_4_312498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__InfrastructureMapping__MappedElementsAssignment_412533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__InfrastructureMapping__TargetElementAssignment_812572 = new BitSet(new long[]{0x0000000000000002L});
    }


}