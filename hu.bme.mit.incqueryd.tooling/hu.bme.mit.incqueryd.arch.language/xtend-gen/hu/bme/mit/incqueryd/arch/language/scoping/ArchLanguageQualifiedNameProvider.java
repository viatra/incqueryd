package hu.bme.mit.incqueryd.arch.language.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

@SuppressWarnings("all")
public class ArchLanguageQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {
  public QualifiedName qualifiedName(final ReteNodeRecipe reteNodeRecipe) {
    QualifiedName _xblockexpression = null;
    {
      EClass _eClass = reteNodeRecipe.eClass();
      final String typeName = _eClass.getName();
      Resource _eResource = reteNodeRecipe.eResource();
      String _uRIFragment = _eResource.getURIFragment(reteNodeRecipe);
      int _hashCode = _uRIFragment.hashCode();
      final String fragmentHash = Integer.toHexString(_hashCode);
      Resource _eResource_1 = reteNodeRecipe.eResource();
      URI _uRI = _eResource_1.getURI();
      int _hashCode_1 = _uRI.hashCode();
      final String resourceHash = Integer.toHexString(_hashCode_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(typeName, "");
      _builder.append("_");
      _builder.append(fragmentHash, "");
      _builder.append("_");
      _builder.append(resourceHash, "");
      _xblockexpression = QualifiedName.create(_builder.toString());
    }
    return _xblockexpression;
  }
}
