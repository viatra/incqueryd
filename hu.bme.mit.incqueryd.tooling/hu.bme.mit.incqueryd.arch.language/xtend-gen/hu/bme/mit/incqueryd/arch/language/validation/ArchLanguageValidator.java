package hu.bme.mit.incqueryd.arch.language.validation;

import arch.ArchPackage;
import arch.Configuration;
import arch.InfrastructureMapping;
import arch.RecipeImport;
import arch.ReteRole;
import arch.Role;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import hu.bme.mit.incqueryd.arch.language.validation.AbstractArchLanguageValidator;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.incquery.runtime.rete.recipes.RecipesPackage;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.incquery.runtime.rete.recipes.ReteRecipe;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
  public void checkAllNodeRecipesAreMapped(final RecipeImport recipeImport) {
    final ReteRecipe reteRecipe = ArchLanguageValidator.loadRecipe(recipeImport);
    EList<ReteNodeRecipe> _recipeNodes = reteRecipe.getRecipeNodes();
    final Procedure1<ReteNodeRecipe> _function = new Procedure1<ReteNodeRecipe>() {
      public void apply(final ReteNodeRecipe recipeNode) {
        Configuration _containerOfType = EcoreUtil2.<Configuration>getContainerOfType(recipeImport, Configuration.class);
        boolean _isMappedIn = ArchLanguageValidator.isMappedIn(recipeNode, _containerOfType);
        boolean _not = (!_isMappedIn);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Node recipe ");
          QualifiedName _fullyQualifiedName = ArchLanguageValidator.this.qualifiedNameProvider.getFullyQualifiedName(recipeNode);
          _builder.append(_fullyQualifiedName, "");
          _builder.append(" is unmapped");
          EAttribute _recipeImport_ImportURI = ArchPackage.eINSTANCE.getRecipeImport_ImportURI();
          ArchLanguageValidator.this.warning(_builder.toString(), _recipeImport_ImportURI);
        }
      }
    };
    IterableExtensions.<ReteNodeRecipe>forEach(_recipeNodes, _function);
  }
  
  public static ReteRecipe loadRecipe(final RecipeImport recipeImport) {
    ReteRecipe _xblockexpression = null;
    {
      Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("recipe", _xMIResourceFactoryImpl);
      RecipesPackage.eINSTANCE.eClass();
      final ResourceSetImpl resourceSet = new ResourceSetImpl();
      String _importURI = recipeImport.getImportURI();
      URI _createURI = URI.createURI(_importURI);
      Resource _eResource = recipeImport.eResource();
      URI _uRI = _eResource.getURI();
      final URI uri = _createURI.resolve(_uRI);
      final Resource resource = resourceSet.getResource(uri, true);
      EList<EObject> _contents = resource.getContents();
      EObject _get = _contents.get(0);
      _xblockexpression = ((ReteRecipe) _get);
    }
    return _xblockexpression;
  }
  
  public static boolean isMappedIn(final ReteNodeRecipe nodeRecipe, final Configuration configuration) {
    EList<InfrastructureMapping> _mappings = configuration.getMappings();
    final Function1<InfrastructureMapping, Boolean> _function = new Function1<InfrastructureMapping, Boolean>() {
      public Boolean apply(final InfrastructureMapping mapping) {
        EList<Role> _roles = mapping.getRoles();
        Iterable<ReteRole> _filter = Iterables.<ReteRole>filter(_roles, ReteRole.class);
        final Function1<ReteRole, Boolean> _function = new Function1<ReteRole, Boolean>() {
          public Boolean apply(final ReteRole reteRole) {
            ReteNodeRecipe _nodeRecipe = reteRole.getNodeRecipe();
            return Boolean.valueOf(Objects.equal(_nodeRecipe, nodeRecipe));
          }
        };
        return Boolean.valueOf(IterableExtensions.<ReteRole>exists(_filter, _function));
      }
    };
    return IterableExtensions.<InfrastructureMapping>exists(_mappings, _function);
  }
}
