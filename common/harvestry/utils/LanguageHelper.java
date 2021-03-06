package harvestry.utils;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class LanguageHelper {

    /***
     * Simple test to determine if a specified file name represents a XML file
     * or not
     * 
     * @param fileName
     *            String representing the file name of the file in question
     * @return True if the file name represents a XML file, false otherwise
     */
    public static boolean isXMLLanguageFile(String fileName) {

        return fileName.endsWith(".xml");
    }

    /***
     * Returns the locale from the file name.
     * 
     * @param fileName
     *            String representing the file name of the file in question.
     * @return {@link String} representation of the locale took from the file
     *         name.
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