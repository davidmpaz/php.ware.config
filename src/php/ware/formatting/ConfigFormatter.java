/*
 * generated by Xtext
 */
package php.ware.formatting;

import java.util.List;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;

import php.ware.services.ConfigGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an
 * example
 */
public class ConfigFormatter extends AbstractDeclarativeFormatter {

    @Override
    protected void configureFormatting(FormattingConfig c) {

        ConfigGrammarAccess f = (ConfigGrammarAccess) getGrammarAccess();
        // It's usually a good idea to activate the following three statements.
        // They will add and preserve newlines around comments
        c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
        c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
        c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());

        c.setLinewrap(1, 2, 3).around(f.getAbstractElementRule());

        // annotate entity statements
        c.setLinewrap(0, 1, 1).before(f.getExtensionRule());
        c.setLinewrap(0, 1, 2).after(f.getExtensionRule());

        // make properties/reference joint together
        c.setLinewrap(1, 1, 1).around(f.getPropertyRule());

        // import statements
        c.setLinewrap(1, 1, 1).around(f.getImportRule());

        // indent content inside curly braces
        List<Pair<Keyword, Keyword>> curlyPairs = f.findKeywordPairs("{", "}");
        for (Pair<Keyword, Keyword> pair : curlyPairs) {
            c.setIndentation(pair.getFirst(), pair.getSecond());
            c.setLinewrap(2).after(pair.getSecond());
            c.setLinewrap(1).after(pair.getSecond());
            c.setLinewrap(2).after(pair.getFirst());
        }
    }
}
