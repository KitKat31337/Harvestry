package harvestry.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHelper {

    /**
     * Checks if the file ends with '.xml'
     * 
     * @param fileName
     *            The name of the file that you are checking.
     * @return true of the file ends with '.xml'
     */
    public static boolean isXMLLanguageFile(String fileName) {

        return fileName.endsWith(".xml");
    }

    /**
     * Gets the localization from a file.
     * 
     * @param fileName
     *            The file to get the localization from.
     * @return the Localization.
     */
    public static String getLocaleFromFileName(String fileName) {

        return fileName.substring(fileName.lastIndexOf('/') + 1, fileName.lastIndexOf('.'));
    }

    /**
     * Gets the localized String.
     * 
     * @param key
     *            The Key to the Localized String.
     * @return The localized String.
     */
    public static String getLocalizedString(String key) {

        return LanguageRegistry.instance().getStringLocalization(key);
    }
}