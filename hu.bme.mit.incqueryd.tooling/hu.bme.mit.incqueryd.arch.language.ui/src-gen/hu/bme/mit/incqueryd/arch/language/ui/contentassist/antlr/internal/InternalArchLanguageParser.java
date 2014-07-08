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


    // $ANTLR start "entryRuleRecipeImport"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:88:1: entryRuleRecipeImport : ruleRecipeImport EOF ;
    public final void entryRuleRecipeImport() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:89:1: ( ruleRecipeImport EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:90:1: ruleRecipeImport EOF
            {
             before(grammarAccess.getRecipeImportRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecipeImport_in_entryRuleRecipeImport121);
            ruleRecipeImport();

            state._fsp--;

             after(grammarAccess.getRecipeImportRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRecipeImport128); 

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
    // $ANTLR end "entryRuleRecipeImport"


    // $ANTLR start "ruleRecipeImport"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:97:1: ruleRecipeImport : ( ( rule__RecipeImport__Group__0 ) ) ;
    public final void ruleRecipeImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:101:2: ( ( ( rule__RecipeImport__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:102:1: ( ( rule__RecipeImport__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:102:1: ( ( rule__RecipeImport__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:103:1: ( rule__RecipeImport__Group__0 )
            {
             before(grammarAccess.getRecipeImportAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:104:1: ( rule__RecipeImport__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:104:2: rule__RecipeImport__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecipeImport__Group__0_in_ruleRecipeImport154);
            rule__RecipeImport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRecipeImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRecipeImport"


    // $ANTLR start "entryRuleInfrastructureMapping"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:116:1: entryRuleInfrastructureMapping : ruleInfrastructureMapping EOF ;
    public final void entryRuleInfrastructureMapping() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:117:1: ( ruleInfrastructureMapping EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:118:1: ruleInfrastructureMapping EOF
            {
             before(grammarAccess.getInfrastructureMappingRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_entryRuleInfrastructureMapping181);
            ruleInfrastructureMapping();

            state._fsp--;

             after(grammarAccess.getInfrastructureMappingRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfrastructureMapping188); 

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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:125:1: ruleInfrastructureMapping : ( ( rule__InfrastructureMapping__Group__0 ) ) ;
    public final void ruleInfrastructureMapping() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:129:2: ( ( ( rule__InfrastructureMapping__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:130:1: ( ( rule__InfrastructureMapping__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:130:1: ( ( rule__InfrastructureMapping__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:131:1: ( rule__InfrastructureMapping__Group__0 )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:132:1: ( rule__InfrastructureMapping__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:132:2: rule__InfrastructureMapping__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__0_in_ruleInfrastructureMapping214);
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


    // $ANTLR start "entryRuleMachine"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:144:1: entryRuleMachine : ruleMachine EOF ;
    public final void entryRuleMachine() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:145:1: ( ruleMachine EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:146:1: ruleMachine EOF
            {
             before(grammarAccess.getMachineRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_entryRuleMachine241);
            ruleMachine();

            state._fsp--;

             after(grammarAccess.getMachineRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMachine248); 

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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:153:1: ruleMachine : ( ( rule__Machine__IpAssignment ) ) ;
    public final void ruleMachine() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:157:2: ( ( ( rule__Machine__IpAssignment ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:158:1: ( ( rule__Machine__IpAssignment ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:158:1: ( ( rule__Machine__IpAssignment ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:159:1: ( rule__Machine__IpAssignment )
            {
             before(grammarAccess.getMachineAccess().getIpAssignment()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:160:1: ( rule__Machine__IpAssignment )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:160:2: rule__Machine__IpAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__Machine__IpAssignment_in_ruleMachine274);
            rule__Machine__IpAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMachineAccess().getIpAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleRole"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:172:1: entryRuleRole : ruleRole EOF ;
    public final void entryRuleRole() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:173:1: ( ruleRole EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:174:1: ruleRole EOF
            {
             before(grammarAccess.getRoleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRole_in_entryRuleRole301);
            ruleRole();

            state._fsp--;

             after(grammarAccess.getRoleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRole308); 

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
    // $ANTLR end "entryRuleRole"


    // $ANTLR start "ruleRole"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:181:1: ruleRole : ( ( rule__Role__Alternatives ) ) ;
    public final void ruleRole() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:185:2: ( ( ( rule__Role__Alternatives ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:186:1: ( ( rule__Role__Alternatives ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:186:1: ( ( rule__Role__Alternatives ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:187:1: ( rule__Role__Alternatives )
            {
             before(grammarAccess.getRoleAccess().getAlternatives()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:188:1: ( rule__Role__Alternatives )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:188:2: rule__Role__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Role__Alternatives_in_ruleRole334);
            rule__Role__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRoleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRole"


    // $ANTLR start "entryRuleReteRole"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:200:1: entryRuleReteRole : ruleReteRole EOF ;
    public final void entryRuleReteRole() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:201:1: ( ruleReteRole EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:202:1: ruleReteRole EOF
            {
             before(grammarAccess.getReteRoleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReteRole_in_entryRuleReteRole361);
            ruleReteRole();

            state._fsp--;

             after(grammarAccess.getReteRoleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReteRole368); 

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
    // $ANTLR end "entryRuleReteRole"


    // $ANTLR start "ruleReteRole"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:209:1: ruleReteRole : ( ( rule__ReteRole__NodeRecipeAssignment ) ) ;
    public final void ruleReteRole() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:213:2: ( ( ( rule__ReteRole__NodeRecipeAssignment ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:214:1: ( ( rule__ReteRole__NodeRecipeAssignment ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:214:1: ( ( rule__ReteRole__NodeRecipeAssignment ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:215:1: ( rule__ReteRole__NodeRecipeAssignment )
            {
             before(grammarAccess.getReteRoleAccess().getNodeRecipeAssignment()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:216:1: ( rule__ReteRole__NodeRecipeAssignment )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:216:2: rule__ReteRole__NodeRecipeAssignment
            {
            pushFollow(FollowSets000.FOLLOW_rule__ReteRole__NodeRecipeAssignment_in_ruleReteRole394);
            rule__ReteRole__NodeRecipeAssignment();

            state._fsp--;


            }

             after(grammarAccess.getReteRoleAccess().getNodeRecipeAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReteRole"


    // $ANTLR start "entryRuleCacheRole"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:228:1: entryRuleCacheRole : ruleCacheRole EOF ;
    public final void entryRuleCacheRole() throws RecognitionException {
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:229:1: ( ruleCacheRole EOF )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:230:1: ruleCacheRole EOF
            {
             before(grammarAccess.getCacheRoleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCacheRole_in_entryRuleCacheRole421);
            ruleCacheRole();

            state._fsp--;

             after(grammarAccess.getCacheRoleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCacheRole428); 

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
    // $ANTLR end "entryRuleCacheRole"


    // $ANTLR start "ruleCacheRole"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:237:1: ruleCacheRole : ( ( rule__CacheRole__Group__0 ) ) ;
    public final void ruleCacheRole() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:241:2: ( ( ( rule__CacheRole__Group__0 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:242:1: ( ( rule__CacheRole__Group__0 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:242:1: ( ( rule__CacheRole__Group__0 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:243:1: ( rule__CacheRole__Group__0 )
            {
             before(grammarAccess.getCacheRoleAccess().getGroup()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:244:1: ( rule__CacheRole__Group__0 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:244:2: rule__CacheRole__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__CacheRole__Group__0_in_ruleCacheRole454);
            rule__CacheRole__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCacheRoleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCacheRole"


    // $ANTLR start "rule__Role__Alternatives"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:256:1: rule__Role__Alternatives : ( ( ruleReteRole ) | ( ruleCacheRole ) );
    public final void rule__Role__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:260:1: ( ( ruleReteRole ) | ( ruleCacheRole ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==16) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:261:1: ( ruleReteRole )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:261:1: ( ruleReteRole )
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:262:1: ruleReteRole
                    {
                     before(grammarAccess.getRoleAccess().getReteRoleParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleReteRole_in_rule__Role__Alternatives490);
                    ruleReteRole();

                    state._fsp--;

                     after(grammarAccess.getRoleAccess().getReteRoleParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:267:6: ( ruleCacheRole )
                    {
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:267:6: ( ruleCacheRole )
                    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:268:1: ruleCacheRole
                    {
                     before(grammarAccess.getRoleAccess().getCacheRoleParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleCacheRole_in_rule__Role__Alternatives507);
                    ruleCacheRole();

                    state._fsp--;

                     after(grammarAccess.getRoleAccess().getCacheRoleParserRuleCall_1()); 

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
    // $ANTLR end "rule__Role__Alternatives"


    // $ANTLR start "rule__Configuration__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:280:1: rule__Configuration__Group__0 : rule__Configuration__Group__0__Impl rule__Configuration__Group__1 ;
    public final void rule__Configuration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:284:1: ( rule__Configuration__Group__0__Impl rule__Configuration__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:285:2: rule__Configuration__Group__0__Impl rule__Configuration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__0__Impl_in_rule__Configuration__Group__0537);
            rule__Configuration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__1_in_rule__Configuration__Group__0540);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:292:1: rule__Configuration__Group__0__Impl : ( ( rule__Configuration__RecipeImportsAssignment_0 )* ) ;
    public final void rule__Configuration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:296:1: ( ( ( rule__Configuration__RecipeImportsAssignment_0 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:297:1: ( ( rule__Configuration__RecipeImportsAssignment_0 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:297:1: ( ( rule__Configuration__RecipeImportsAssignment_0 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:298:1: ( rule__Configuration__RecipeImportsAssignment_0 )*
            {
             before(grammarAccess.getConfigurationAccess().getRecipeImportsAssignment_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:299:1: ( rule__Configuration__RecipeImportsAssignment_0 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:299:2: rule__Configuration__RecipeImportsAssignment_0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Configuration__RecipeImportsAssignment_0_in_rule__Configuration__Group__0__Impl567);
            	    rule__Configuration__RecipeImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getRecipeImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__0__Impl"


    // $ANTLR start "rule__Configuration__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:309:1: rule__Configuration__Group__1 : rule__Configuration__Group__1__Impl ;
    public final void rule__Configuration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:313:1: ( rule__Configuration__Group__1__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:314:2: rule__Configuration__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__1__Impl_in_rule__Configuration__Group__1598);
            rule__Configuration__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:320:1: rule__Configuration__Group__1__Impl : ( ( rule__Configuration__MappingsAssignment_1 )* ) ;
    public final void rule__Configuration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:324:1: ( ( ( rule__Configuration__MappingsAssignment_1 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:325:1: ( ( rule__Configuration__MappingsAssignment_1 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:325:1: ( ( rule__Configuration__MappingsAssignment_1 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:326:1: ( rule__Configuration__MappingsAssignment_1 )*
            {
             before(grammarAccess.getConfigurationAccess().getMappingsAssignment_1()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:327:1: ( rule__Configuration__MappingsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:327:2: rule__Configuration__MappingsAssignment_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Configuration__MappingsAssignment_1_in_rule__Configuration__Group__1__Impl625);
            	    rule__Configuration__MappingsAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getMappingsAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__RecipeImport__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:341:1: rule__RecipeImport__Group__0 : rule__RecipeImport__Group__0__Impl rule__RecipeImport__Group__1 ;
    public final void rule__RecipeImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:345:1: ( rule__RecipeImport__Group__0__Impl rule__RecipeImport__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:346:2: rule__RecipeImport__Group__0__Impl rule__RecipeImport__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecipeImport__Group__0__Impl_in_rule__RecipeImport__Group__0660);
            rule__RecipeImport__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__RecipeImport__Group__1_in_rule__RecipeImport__Group__0663);
            rule__RecipeImport__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecipeImport__Group__0"


    // $ANTLR start "rule__RecipeImport__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:353:1: rule__RecipeImport__Group__0__Impl : ( 'recipe' ) ;
    public final void rule__RecipeImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:357:1: ( ( 'recipe' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:358:1: ( 'recipe' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:358:1: ( 'recipe' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:359:1: 'recipe'
            {
             before(grammarAccess.getRecipeImportAccess().getRecipeKeyword_0()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__RecipeImport__Group__0__Impl691); 
             after(grammarAccess.getRecipeImportAccess().getRecipeKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecipeImport__Group__0__Impl"


    // $ANTLR start "rule__RecipeImport__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:372:1: rule__RecipeImport__Group__1 : rule__RecipeImport__Group__1__Impl ;
    public final void rule__RecipeImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:376:1: ( rule__RecipeImport__Group__1__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:377:2: rule__RecipeImport__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecipeImport__Group__1__Impl_in_rule__RecipeImport__Group__1722);
            rule__RecipeImport__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecipeImport__Group__1"


    // $ANTLR start "rule__RecipeImport__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:383:1: rule__RecipeImport__Group__1__Impl : ( ( rule__RecipeImport__ImportURIAssignment_1 ) ) ;
    public final void rule__RecipeImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:387:1: ( ( ( rule__RecipeImport__ImportURIAssignment_1 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:388:1: ( ( rule__RecipeImport__ImportURIAssignment_1 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:388:1: ( ( rule__RecipeImport__ImportURIAssignment_1 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:389:1: ( rule__RecipeImport__ImportURIAssignment_1 )
            {
             before(grammarAccess.getRecipeImportAccess().getImportURIAssignment_1()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:390:1: ( rule__RecipeImport__ImportURIAssignment_1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:390:2: rule__RecipeImport__ImportURIAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__RecipeImport__ImportURIAssignment_1_in_rule__RecipeImport__Group__1__Impl749);
            rule__RecipeImport__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRecipeImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecipeImport__Group__1__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:404:1: rule__InfrastructureMapping__Group__0 : rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1 ;
    public final void rule__InfrastructureMapping__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:408:1: ( rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:409:2: rule__InfrastructureMapping__Group__0__Impl rule__InfrastructureMapping__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__0__Impl_in_rule__InfrastructureMapping__Group__0783);
            rule__InfrastructureMapping__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__1_in_rule__InfrastructureMapping__Group__0786);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:416:1: rule__InfrastructureMapping__Group__0__Impl : ( 'use' ) ;
    public final void rule__InfrastructureMapping__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:420:1: ( ( 'use' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:421:1: ( 'use' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:421:1: ( 'use' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:422:1: 'use'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getUseKeyword_0()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__InfrastructureMapping__Group__0__Impl814); 
             after(grammarAccess.getInfrastructureMappingAccess().getUseKeyword_0()); 

            }


            }

        }
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:435:1: rule__InfrastructureMapping__Group__1 : rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2 ;
    public final void rule__InfrastructureMapping__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:439:1: ( rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:440:2: rule__InfrastructureMapping__Group__1__Impl rule__InfrastructureMapping__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__1__Impl_in_rule__InfrastructureMapping__Group__1845);
            rule__InfrastructureMapping__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__2_in_rule__InfrastructureMapping__Group__1848);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:447:1: rule__InfrastructureMapping__Group__1__Impl : ( ( rule__InfrastructureMapping__MachineAssignment_1 ) ) ;
    public final void rule__InfrastructureMapping__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:451:1: ( ( ( rule__InfrastructureMapping__MachineAssignment_1 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:452:1: ( ( rule__InfrastructureMapping__MachineAssignment_1 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:452:1: ( ( rule__InfrastructureMapping__MachineAssignment_1 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:453:1: ( rule__InfrastructureMapping__MachineAssignment_1 )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getMachineAssignment_1()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:454:1: ( rule__InfrastructureMapping__MachineAssignment_1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:454:2: rule__InfrastructureMapping__MachineAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__MachineAssignment_1_in_rule__InfrastructureMapping__Group__1__Impl875);
            rule__InfrastructureMapping__MachineAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureMappingAccess().getMachineAssignment_1()); 

            }


            }

        }
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:464:1: rule__InfrastructureMapping__Group__2 : rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3 ;
    public final void rule__InfrastructureMapping__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:468:1: ( rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:469:2: rule__InfrastructureMapping__Group__2__Impl rule__InfrastructureMapping__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__2__Impl_in_rule__InfrastructureMapping__Group__2905);
            rule__InfrastructureMapping__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__3_in_rule__InfrastructureMapping__Group__2908);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:476:1: rule__InfrastructureMapping__Group__2__Impl : ( 'for' ) ;
    public final void rule__InfrastructureMapping__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:480:1: ( ( 'for' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:481:1: ( 'for' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:481:1: ( 'for' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:482:1: 'for'
            {
             before(grammarAccess.getInfrastructureMappingAccess().getForKeyword_2()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__InfrastructureMapping__Group__2__Impl936); 
             after(grammarAccess.getInfrastructureMappingAccess().getForKeyword_2()); 

            }


            }

        }
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:495:1: rule__InfrastructureMapping__Group__3 : rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4 ;
    public final void rule__InfrastructureMapping__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:499:1: ( rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:500:2: rule__InfrastructureMapping__Group__3__Impl rule__InfrastructureMapping__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__3__Impl_in_rule__InfrastructureMapping__Group__3967);
            rule__InfrastructureMapping__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__4_in_rule__InfrastructureMapping__Group__3970);
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:507:1: rule__InfrastructureMapping__Group__3__Impl : ( ( rule__InfrastructureMapping__RolesAssignment_3 ) ) ;
    public final void rule__InfrastructureMapping__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:511:1: ( ( ( rule__InfrastructureMapping__RolesAssignment_3 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:512:1: ( ( rule__InfrastructureMapping__RolesAssignment_3 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:512:1: ( ( rule__InfrastructureMapping__RolesAssignment_3 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:513:1: ( rule__InfrastructureMapping__RolesAssignment_3 )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getRolesAssignment_3()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:514:1: ( rule__InfrastructureMapping__RolesAssignment_3 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:514:2: rule__InfrastructureMapping__RolesAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__RolesAssignment_3_in_rule__InfrastructureMapping__Group__3__Impl997);
            rule__InfrastructureMapping__RolesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureMappingAccess().getRolesAssignment_3()); 

            }


            }

        }
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:524:1: rule__InfrastructureMapping__Group__4 : rule__InfrastructureMapping__Group__4__Impl ;
    public final void rule__InfrastructureMapping__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:528:1: ( rule__InfrastructureMapping__Group__4__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:529:2: rule__InfrastructureMapping__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group__4__Impl_in_rule__InfrastructureMapping__Group__41027);
            rule__InfrastructureMapping__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:535:1: rule__InfrastructureMapping__Group__4__Impl : ( ( rule__InfrastructureMapping__Group_4__0 )* ) ;
    public final void rule__InfrastructureMapping__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:539:1: ( ( ( rule__InfrastructureMapping__Group_4__0 )* ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:540:1: ( ( rule__InfrastructureMapping__Group_4__0 )* )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:540:1: ( ( rule__InfrastructureMapping__Group_4__0 )* )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:541:1: ( rule__InfrastructureMapping__Group_4__0 )*
            {
             before(grammarAccess.getInfrastructureMappingAccess().getGroup_4()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:542:1: ( rule__InfrastructureMapping__Group_4__0 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:542:2: rule__InfrastructureMapping__Group_4__0
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group_4__0_in_rule__InfrastructureMapping__Group__4__Impl1054);
            	    rule__InfrastructureMapping__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getInfrastructureMappingAccess().getGroup_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__InfrastructureMapping__Group_4__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:562:1: rule__InfrastructureMapping__Group_4__0 : rule__InfrastructureMapping__Group_4__0__Impl rule__InfrastructureMapping__Group_4__1 ;
    public final void rule__InfrastructureMapping__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:566:1: ( rule__InfrastructureMapping__Group_4__0__Impl rule__InfrastructureMapping__Group_4__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:567:2: rule__InfrastructureMapping__Group_4__0__Impl rule__InfrastructureMapping__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group_4__0__Impl_in_rule__InfrastructureMapping__Group_4__01095);
            rule__InfrastructureMapping__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group_4__1_in_rule__InfrastructureMapping__Group_4__01098);
            rule__InfrastructureMapping__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureMapping__Group_4__0"


    // $ANTLR start "rule__InfrastructureMapping__Group_4__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:574:1: rule__InfrastructureMapping__Group_4__0__Impl : ( ',' ) ;
    public final void rule__InfrastructureMapping__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:578:1: ( ( ',' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:579:1: ( ',' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:579:1: ( ',' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:580:1: ','
            {
             before(grammarAccess.getInfrastructureMappingAccess().getCommaKeyword_4_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__InfrastructureMapping__Group_4__0__Impl1126); 
             after(grammarAccess.getInfrastructureMappingAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureMapping__Group_4__0__Impl"


    // $ANTLR start "rule__InfrastructureMapping__Group_4__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:593:1: rule__InfrastructureMapping__Group_4__1 : rule__InfrastructureMapping__Group_4__1__Impl ;
    public final void rule__InfrastructureMapping__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:597:1: ( rule__InfrastructureMapping__Group_4__1__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:598:2: rule__InfrastructureMapping__Group_4__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__Group_4__1__Impl_in_rule__InfrastructureMapping__Group_4__11157);
            rule__InfrastructureMapping__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureMapping__Group_4__1"


    // $ANTLR start "rule__InfrastructureMapping__Group_4__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:604:1: rule__InfrastructureMapping__Group_4__1__Impl : ( ( rule__InfrastructureMapping__RolesAssignment_4_1 ) ) ;
    public final void rule__InfrastructureMapping__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:608:1: ( ( ( rule__InfrastructureMapping__RolesAssignment_4_1 ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:609:1: ( ( rule__InfrastructureMapping__RolesAssignment_4_1 ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:609:1: ( ( rule__InfrastructureMapping__RolesAssignment_4_1 ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:610:1: ( rule__InfrastructureMapping__RolesAssignment_4_1 )
            {
             before(grammarAccess.getInfrastructureMappingAccess().getRolesAssignment_4_1()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:611:1: ( rule__InfrastructureMapping__RolesAssignment_4_1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:611:2: rule__InfrastructureMapping__RolesAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__InfrastructureMapping__RolesAssignment_4_1_in_rule__InfrastructureMapping__Group_4__1__Impl1184);
            rule__InfrastructureMapping__RolesAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getInfrastructureMappingAccess().getRolesAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureMapping__Group_4__1__Impl"


    // $ANTLR start "rule__CacheRole__Group__0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:625:1: rule__CacheRole__Group__0 : rule__CacheRole__Group__0__Impl rule__CacheRole__Group__1 ;
    public final void rule__CacheRole__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:629:1: ( rule__CacheRole__Group__0__Impl rule__CacheRole__Group__1 )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:630:2: rule__CacheRole__Group__0__Impl rule__CacheRole__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__CacheRole__Group__0__Impl_in_rule__CacheRole__Group__01218);
            rule__CacheRole__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__CacheRole__Group__1_in_rule__CacheRole__Group__01221);
            rule__CacheRole__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CacheRole__Group__0"


    // $ANTLR start "rule__CacheRole__Group__0__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:637:1: rule__CacheRole__Group__0__Impl : ( () ) ;
    public final void rule__CacheRole__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:641:1: ( ( () ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:642:1: ( () )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:642:1: ( () )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:643:1: ()
            {
             before(grammarAccess.getCacheRoleAccess().getCacheRoleAction_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:644:1: ()
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:646:1: 
            {
            }

             after(grammarAccess.getCacheRoleAccess().getCacheRoleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CacheRole__Group__0__Impl"


    // $ANTLR start "rule__CacheRole__Group__1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:656:1: rule__CacheRole__Group__1 : rule__CacheRole__Group__1__Impl ;
    public final void rule__CacheRole__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:660:1: ( rule__CacheRole__Group__1__Impl )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:661:2: rule__CacheRole__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__CacheRole__Group__1__Impl_in_rule__CacheRole__Group__11279);
            rule__CacheRole__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CacheRole__Group__1"


    // $ANTLR start "rule__CacheRole__Group__1__Impl"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:667:1: rule__CacheRole__Group__1__Impl : ( 'cache' ) ;
    public final void rule__CacheRole__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:671:1: ( ( 'cache' ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:672:1: ( 'cache' )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:672:1: ( 'cache' )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:673:1: 'cache'
            {
             before(grammarAccess.getCacheRoleAccess().getCacheKeyword_1()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__CacheRole__Group__1__Impl1307); 
             after(grammarAccess.getCacheRoleAccess().getCacheKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CacheRole__Group__1__Impl"


    // $ANTLR start "rule__Configuration__RecipeImportsAssignment_0"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:691:1: rule__Configuration__RecipeImportsAssignment_0 : ( ruleRecipeImport ) ;
    public final void rule__Configuration__RecipeImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:695:1: ( ( ruleRecipeImport ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:696:1: ( ruleRecipeImport )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:696:1: ( ruleRecipeImport )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:697:1: ruleRecipeImport
            {
             before(grammarAccess.getConfigurationAccess().getRecipeImportsRecipeImportParserRuleCall_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleRecipeImport_in_rule__Configuration__RecipeImportsAssignment_01347);
            ruleRecipeImport();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getRecipeImportsRecipeImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__RecipeImportsAssignment_0"


    // $ANTLR start "rule__Configuration__MappingsAssignment_1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:706:1: rule__Configuration__MappingsAssignment_1 : ( ruleInfrastructureMapping ) ;
    public final void rule__Configuration__MappingsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:710:1: ( ( ruleInfrastructureMapping ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:711:1: ( ruleInfrastructureMapping )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:711:1: ( ruleInfrastructureMapping )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:712:1: ruleInfrastructureMapping
            {
             before(grammarAccess.getConfigurationAccess().getMappingsInfrastructureMappingParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleInfrastructureMapping_in_rule__Configuration__MappingsAssignment_11378);
            ruleInfrastructureMapping();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getMappingsInfrastructureMappingParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__MappingsAssignment_1"


    // $ANTLR start "rule__RecipeImport__ImportURIAssignment_1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:721:1: rule__RecipeImport__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__RecipeImport__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:725:1: ( ( RULE_STRING ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:726:1: ( RULE_STRING )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:726:1: ( RULE_STRING )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:727:1: RULE_STRING
            {
             before(grammarAccess.getRecipeImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__RecipeImport__ImportURIAssignment_11409); 
             after(grammarAccess.getRecipeImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RecipeImport__ImportURIAssignment_1"


    // $ANTLR start "rule__InfrastructureMapping__MachineAssignment_1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:736:1: rule__InfrastructureMapping__MachineAssignment_1 : ( ruleMachine ) ;
    public final void rule__InfrastructureMapping__MachineAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:740:1: ( ( ruleMachine ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:741:1: ( ruleMachine )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:741:1: ( ruleMachine )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:742:1: ruleMachine
            {
             before(grammarAccess.getInfrastructureMappingAccess().getMachineMachineParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMachine_in_rule__InfrastructureMapping__MachineAssignment_11440);
            ruleMachine();

            state._fsp--;

             after(grammarAccess.getInfrastructureMappingAccess().getMachineMachineParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureMapping__MachineAssignment_1"


    // $ANTLR start "rule__InfrastructureMapping__RolesAssignment_3"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:751:1: rule__InfrastructureMapping__RolesAssignment_3 : ( ruleRole ) ;
    public final void rule__InfrastructureMapping__RolesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:755:1: ( ( ruleRole ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:756:1: ( ruleRole )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:756:1: ( ruleRole )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:757:1: ruleRole
            {
             before(grammarAccess.getInfrastructureMappingAccess().getRolesRoleParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleRole_in_rule__InfrastructureMapping__RolesAssignment_31471);
            ruleRole();

            state._fsp--;

             after(grammarAccess.getInfrastructureMappingAccess().getRolesRoleParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureMapping__RolesAssignment_3"


    // $ANTLR start "rule__InfrastructureMapping__RolesAssignment_4_1"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:766:1: rule__InfrastructureMapping__RolesAssignment_4_1 : ( ruleRole ) ;
    public final void rule__InfrastructureMapping__RolesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:770:1: ( ( ruleRole ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:771:1: ( ruleRole )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:771:1: ( ruleRole )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:772:1: ruleRole
            {
             before(grammarAccess.getInfrastructureMappingAccess().getRolesRoleParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleRole_in_rule__InfrastructureMapping__RolesAssignment_4_11502);
            ruleRole();

            state._fsp--;

             after(grammarAccess.getInfrastructureMappingAccess().getRolesRoleParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InfrastructureMapping__RolesAssignment_4_1"


    // $ANTLR start "rule__Machine__IpAssignment"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:781:1: rule__Machine__IpAssignment : ( RULE_IP ) ;
    public final void rule__Machine__IpAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:785:1: ( ( RULE_IP ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:786:1: ( RULE_IP )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:786:1: ( RULE_IP )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:787:1: RULE_IP
            {
             before(grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_0()); 
            match(input,RULE_IP,FollowSets000.FOLLOW_RULE_IP_in_rule__Machine__IpAssignment1533); 
             after(grammarAccess.getMachineAccess().getIpIPTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Machine__IpAssignment"


    // $ANTLR start "rule__ReteRole__NodeRecipeAssignment"
    // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:796:1: rule__ReteRole__NodeRecipeAssignment : ( ( RULE_ID ) ) ;
    public final void rule__ReteRole__NodeRecipeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:800:1: ( ( ( RULE_ID ) ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:801:1: ( ( RULE_ID ) )
            {
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:801:1: ( ( RULE_ID ) )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:802:1: ( RULE_ID )
            {
             before(grammarAccess.getReteRoleAccess().getNodeRecipeReteNodeRecipeCrossReference_0()); 
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:803:1: ( RULE_ID )
            // ../hu.bme.mit.incqueryd.arch.language.ui/src-gen/hu/bme/mit/incqueryd/arch/language/ui/contentassist/antlr/internal/InternalArchLanguage.g:804:1: RULE_ID
            {
             before(grammarAccess.getReteRoleAccess().getNodeRecipeReteNodeRecipeIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__ReteRole__NodeRecipeAssignment1568); 
             after(grammarAccess.getReteRoleAccess().getNodeRecipeReteNodeRecipeIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getReteRoleAccess().getNodeRecipeReteNodeRecipeCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ReteRole__NodeRecipeAssignment"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleConfiguration_in_entryRuleConfiguration61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfiguration68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__0_in_ruleConfiguration94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecipeImport_in_entryRuleRecipeImport121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRecipeImport128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecipeImport__Group__0_in_ruleRecipeImport154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_entryRuleInfrastructureMapping181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfrastructureMapping188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__0_in_ruleInfrastructureMapping214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMachine_in_entryRuleMachine241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMachine248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Machine__IpAssignment_in_ruleMachine274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRole_in_entryRuleRole301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRole308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Role__Alternatives_in_ruleRole334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteRole_in_entryRuleReteRole361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReteRole368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ReteRole__NodeRecipeAssignment_in_ruleReteRole394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCacheRole_in_entryRuleCacheRole421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCacheRole428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CacheRole__Group__0_in_ruleCacheRole454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReteRole_in_rule__Role__Alternatives490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCacheRole_in_rule__Role__Alternatives507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__0__Impl_in_rule__Configuration__Group__0537 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Configuration__Group__1_in_rule__Configuration__Group__0540 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__RecipeImportsAssignment_0_in_rule__Configuration__Group__0__Impl567 = new BitSet(new long[]{0x0000000000001002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__1__Impl_in_rule__Configuration__Group__1598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__MappingsAssignment_1_in_rule__Configuration__Group__1__Impl625 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__RecipeImport__Group__0__Impl_in_rule__RecipeImport__Group__0660 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_rule__RecipeImport__Group__1_in_rule__RecipeImport__Group__0663 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__RecipeImport__Group__0__Impl691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecipeImport__Group__1__Impl_in_rule__RecipeImport__Group__1722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__RecipeImport__ImportURIAssignment_1_in_rule__RecipeImport__Group__1__Impl749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__0__Impl_in_rule__InfrastructureMapping__Group__0783 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__1_in_rule__InfrastructureMapping__Group__0786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__InfrastructureMapping__Group__0__Impl814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__1__Impl_in_rule__InfrastructureMapping__Group__1845 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__2_in_rule__InfrastructureMapping__Group__1848 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__MachineAssignment_1_in_rule__InfrastructureMapping__Group__1__Impl875 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__2__Impl_in_rule__InfrastructureMapping__Group__2905 = new BitSet(new long[]{0x0000000000010040L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__3_in_rule__InfrastructureMapping__Group__2908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__InfrastructureMapping__Group__2__Impl936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__3__Impl_in_rule__InfrastructureMapping__Group__3967 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__4_in_rule__InfrastructureMapping__Group__3970 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__RolesAssignment_3_in_rule__InfrastructureMapping__Group__3__Impl997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group__4__Impl_in_rule__InfrastructureMapping__Group__41027 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group_4__0_in_rule__InfrastructureMapping__Group__4__Impl1054 = new BitSet(new long[]{0x0000000000008002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group_4__0__Impl_in_rule__InfrastructureMapping__Group_4__01095 = new BitSet(new long[]{0x0000000000010040L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group_4__1_in_rule__InfrastructureMapping__Group_4__01098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__InfrastructureMapping__Group_4__0__Impl1126 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__Group_4__1__Impl_in_rule__InfrastructureMapping__Group_4__11157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__InfrastructureMapping__RolesAssignment_4_1_in_rule__InfrastructureMapping__Group_4__1__Impl1184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CacheRole__Group__0__Impl_in_rule__CacheRole__Group__01218 = new BitSet(new long[]{0x0000000000010040L});
        public static final BitSet FOLLOW_rule__CacheRole__Group__1_in_rule__CacheRole__Group__01221 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__CacheRole__Group__1__Impl_in_rule__CacheRole__Group__11279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__CacheRole__Group__1__Impl1307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRecipeImport_in_rule__Configuration__RecipeImportsAssignment_01347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfrastructureMapping_in_rule__Configuration__MappingsAssignment_11378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__RecipeImport__ImportURIAssignment_11409 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMachine_in_rule__InfrastructureMapping__MachineAssignment_11440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRole_in_rule__InfrastructureMapping__RolesAssignment_31471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRole_in_rule__InfrastructureMapping__RolesAssignment_4_11502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_IP_in_rule__Machine__IpAssignment1533 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__ReteRole__NodeRecipeAssignment1568 = new BitSet(new long[]{0x0000000000000002L});
    }


}