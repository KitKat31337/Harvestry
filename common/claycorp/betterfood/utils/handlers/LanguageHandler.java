package claycorp.betterfood.utils.handlers;

import claycorp.betterfood.utils.LanguageHelper;
import claycorp.betterfood.utils.Registry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHandler {

    public static void loadLanguages() {

        for (String localizationFile : Registry.langFiles){
            LanguageRegistry.instance().loadLocalization(localizationFile,
                    LanguageHelper.getLocaleFromFileName(localizationFile),
                    LanguageHelper.isXMLLanguageFile(localizationFile));
        }
    }
}