package hu.bme.mit.incqueryd.arch.language.validation;

import com.google.inject.Inject;
import hu.bme.mit.incqueryd.arch.language.validation.AbstractArchLanguageValidator;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class ArchLanguageValidator extends AbstractArchLanguageValidator {
  @Inject
  private IQualifiedNameProvider qualifiedNameProvider;
  
  @Check(CheckType.NORMAL)
  public void checkAllNodeRecipesAreMapped(final /* RecipeImport */Object recipeImport) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field Configuration is undefined for the type ArchLanguageValidator"
      + "\nThe method or field ArchPackage is undefined for the type ArchLanguageValidator"
      + "\nType mismatch: cannot convert from EObject to ReteNodeRecipe"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nloadRecipe cannot be resolved"
      + "\nrecipeNodes cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\ngetContainerOfType cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\nrecipeImport_ImportURI cannot be resolved");
  }
  
  public static ReteRecipe loadRecipe(final /* RecipeImport */Object recipeImport) {
    throw new Error("Unresolved compilation problems:"
      + "\nimportURI cannot be resolved"
      + "\neResource cannot be resolved"
      + "\nURI cannot be resolved");
  }
  
  public static boolean isMappedIn(final ReteNodeRecipe nodeRecipe, final /* Configuration */Object configuration) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method roles is undefined for the type ArchLanguageValidator"
      + "\nThe method or field ReteRole is undefined for the type ArchLanguageValidator"
      + "\nThe method nodeRecipe is undefined for the type ArchLanguageValidator"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nmappings cannot be resolved"
      + "\nexists cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nexists cannot be resolved"
      + "\n== cannot be resolved");
  }
}
