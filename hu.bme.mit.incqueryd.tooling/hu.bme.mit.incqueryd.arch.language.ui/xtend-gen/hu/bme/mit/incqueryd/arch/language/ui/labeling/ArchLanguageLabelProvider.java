package hu.bme.mit.incqueryd.arch.language.ui.labeling;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.incquery.runtime.rete.recipes.ReteNodeRecipe;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#labelProvider
 */
@SuppressWarnings("all")
public class ArchLanguageLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public ArchLanguageLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public String text(final ReteNodeRecipe nodeRecipe) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("URI: ");
    Resource _eResource = nodeRecipe.eResource();
    URI _uRI = _eResource.getURI();
    _builder.append(_uRI, "");
    Resource _eResource_1 = nodeRecipe.eResource();
    String _uRIFragment = _eResource_1.getURIFragment(nodeRecipe);
    _builder.append(_uRIFragment, "");
    _builder.newLineIfNotEmpty();
    _builder.append("traceInfo: ");
    String _traceInfo = nodeRecipe.getTraceInfo();
    _builder.append(_traceInfo, "");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
