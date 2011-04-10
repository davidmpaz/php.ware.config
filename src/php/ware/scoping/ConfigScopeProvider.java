/*
 * generated by Xtext
 */
package php.ware.scoping;

import static org.eclipse.xtext.scoping.Scopes.scopeFor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

import php.ware.config.AnnonateEntity;
import php.ware.entity.Feature;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping on
 * how and when to use it
 * 
 */
public class ConfigScopeProvider extends AbstractDeclarativeScopeProvider {

    public IScope scope_AnnonateEntity_feature(final AnnonateEntity ref,
            EReference eRef) {
        EList<Feature> features = ref.getElement().getFeatures();
        return scopeFor(features);
    }
}