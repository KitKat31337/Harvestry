package harvestry.utils.handlers;

import harvestry.utils.Archive;
import harvestry.utils.LanguageHelper;

import java.util.logging.Level;

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