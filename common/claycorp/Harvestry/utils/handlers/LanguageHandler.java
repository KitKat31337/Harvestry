package claycorp.Harvestry.utils.handlers;

import java.util.logging.Level;

import claycorp.Harvestry.utils.Archive;
import claycorp.Harvestry.utils.LanguageHelper;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHandler {

    public static void loadLanguages() {

        Handler.log(Level.INFO, "Loading Languages");
        for (String localizationFile : Archive.langFiles){
            LanguageRegistry.instance().loadLocalization(localizationFile,
                    LanguageHelper.getLocaleFromFileName(localizationFile),
                    LanguageHelper.isXMLLanguageFile(localizationFile));
        }
    }
}