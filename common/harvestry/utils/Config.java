package harvestry.utils;

import harvestry.utils.handlers.Handler;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

    private static String gen = "World Generation";

    /*
     * ***************************************************
     * Item IDs
     * ***************************************************
     */
    public static int itemUncookedCakeID;
    public static int itemCakePanID;
    public static int itemBowlID;
    public static int itemCakeBatterID;
    public static int itemUncookedBreadID;
    public static int itemflourID;
    public static int itemBreadPanID;
    public static int itemChocolateChipsID;
    public static int itemCookieSheetID;
    public static int itemDoughID;
    public static int itemPiePanID;
    public static int itemPumpkinMashID;
    public static int itemAluminumFoilID;
    public static int itemAluminumSheetID;
    public static int itemPureAluminumID;
    public static int itemGrindStoneID;
    public static int itemGrindStonesID;
    public static int itemUncookedPotatoID;
    public static int itemCookieDoughID;
    public static int itemChocolateChipCookieDoughID;
    public static int itemPumpkinPieFillingID;
    public static int itemPieCrustID;
    public static int itemChocolatePasteID;
    public static int itemUncookedPumpkinPieID;
    public static int itemUncookedSugarCookiesID;
    public static int itemUncookedChocolateChipCookiesID;
    public static int itemUncookedCookiesID;
    public static int foodCookieID;
    public static int foodSugarCookieID;
    public static int itemSugarCookieDoughID;
    public static int foodChocolateChipCookieID;

    /*
     * ***************************************************
     * Food IDs
     * ***************************************************
     */
    public static int foodPeanutsID;
    public static int foodScrambledEggsID;

    /*
     * ***************************************************
     * Blocks IDs
     * ***************************************************
     */
    public static int oreAluminumID;
    public static int blockGrinderID;
    public static int blockOvenID;

    /*
     * ***************************************************
     * World Generation Stuff (Aluminum)
     * ***************************************************
     */
    public static boolean enableWorldGenAluminum;
    public static int aluMaxHeight;
    public static int aluMinHeight;

    public static int mainItemID;

    /**
     * Initializes the Configuration file.
     * 
     * @param event
     *            The FMLPreInitializationEvent that is used to get the
     *            ModConfigurationDirectory.
     */
    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Archive.modName + ".cfg");

        Configuration config = new Configuration(configFile);

        try{
            Handler.log(Level.INFO, "Loading configuration");
            /**
             * Loads a pre-existing Configuration file.
             */
            config.load();

            configItems(config);

            configOres(config);

            configWorldGen(config);

        }catch(Exception e){
            Handler.log(Level.SEVERE, Archive.modName
                    + " has had a problem loading its configuration");
        }finally{
            if (config.hasChanged()){
                /**
                 * If a pre-existing Configuration file didn't exist it creates
                 * a new one.
                 * If there were changes to the existing Configuration file, It
                 * saves them.
                 */
                config.save();
            }
        }
    }

    /**
     * Loads or creates the Items in the Configuration file.
     * 
     * @param config
     *            The Configuration file that is being edited.
     */
    private static void configItems(Configuration config) {
        Handler.log(Level.INFO, "Loading Item Configs");
        int iID = 8000;
        itemUncookedCakeID = config.getItem(Archive.itemUncookedCake, iID++).getInt();
        itemCakePanID = config.getItem(Archive.itemCakePan, iID++).getInt();
        itemBowlID = config.getItem(Archive.itemBowl, iID++).getInt();
        itemCakeBatterID = config.getItem(Archive.itemCakeBatter, iID++).getInt();
        itemUncookedBreadID = config.getItem(Archive.itemUncookedBread, iID++).getInt();
        itemflourID = config.getItem(Archive.itemFlour, iID++).getInt();
        itemBreadPanID = config.getItem(Archive.itemBreadPan, iID++).getInt();
        itemChocolateChipsID = config.getItem(Archive.itemChocolateChips, iID++).getInt();
        itemCookieSheetID = config.getItem(Archive.itemCookieSheet, iID++).getInt();
        itemDoughID = config.getItem(Archive.itemDough, iID++).getInt();
        itemPiePanID = config.getItem(Archive.itemPiePan, iID++).getInt();
        itemPumpkinMashID = config.getItem(Archive.itemPumpkinMash, iID++).getInt();
        itemPureAluminumID = config.getItem(Archive.itemPureAluminum, iID++).getInt();
        itemAluminumSheetID = config.getItem(Archive.itemAluminumSheet, iID++).getInt();
        itemAluminumFoilID = config.getItem(Archive.itemAluminumFoil, iID++).getInt();
        itemGrindStoneID = config.getItem(Archive.itemGrindStone, iID++).getInt();
        itemGrindStonesID = config.getItem(Archive.itemGrindStones, iID++).getInt();
        itemUncookedPotatoID = config.getItem(Archive.itemUncookedPotato, iID++).getInt();
        itemCookieDoughID = config.getItem(Archive.itemCookieDough, iID++).getInt();
        itemChocolateChipCookieDoughID = config
                .getItem(Archive.itemChocolateChipCookieDough, iID++).getInt();
        itemPumpkinPieFillingID = config.getItem(Archive.itemPumpkinPieFilling, iID++).getInt();
        itemPieCrustID = config.getItem(Archive.itemPieCrust, iID++).getInt();
        itemUncookedPumpkinPieID = config.getItem(Archive.itemUncookedPumpkinPie, iID++).getInt();
        itemUncookedSugarCookiesID = config.getItem(Archive.itemUncookedSugarCookies, iID++)
                .getInt();
        itemUncookedChocolateChipCookiesID = config.getItem(
                Archive.itemUncookedChocolateChipCookies, iID++).getInt();
        itemUncookedCookiesID = config.getItem(Archive.itemUncookedCookies, iID++).getInt();
        foodChocolateChipCookieID = config.getItem(Archive.foodChocolateChipCookie, iID++).getInt();
        foodCookieID = config.getItem(Archive.foodCookie, iID++).getInt();
        foodSugarCookieID = config.getItem(Archive.foodSugarCookie, iID++).getInt();
        itemSugarCookieDoughID = config.getItem(Archive.itemSugarCookieDough, iID++).getInt();
        itemPieCrustID = config.getItem(Archive.itemPieCrust, iID++).getInt();
        itemPieCrustID = config.getItem(Archive.itemPieCrust, iID++).getInt();
        configFood(config, iID++);
    }

    /**
     * Loads or creates the Food Items in the Configuration file.
     * 
     * @param config
     *            The Configuration file that is being edited.
     * @param fID
     *            The Last Item ID, used so that the Items and Foods would never
     *            conflict.
     */
    private static void configFood(Configuration config, int fID) {
        Handler.log(Level.INFO, "Loading Food Configs");
        fID++;
        foodPeanutsID = config.getItem(Archive.foodPeanuts, fID++).getInt();
        foodScrambledEggsID = config.getItem(Archive.foodScrambledEggs, fID++).getInt();
    }

    /**
     * Loads or creates the Ores in the Configuration file.
     * 
     * @param config
     *            The Configuration file that is being edited.
     */
    private static void configOres(Configuration config) {
        Handler.log(Level.INFO, "Loading Ore Configs");
        int oID = 1000;
        oreAluminumID = config.getBlock(Archive.oreAluminum, oID++).getInt();
        // Creates the configurations for Blocks
        configBlocks(config, oID++);
    }

    /**
     * Loads or creates the Blocks in the Configuration file.
     * 
     * @param config
     *            The Configuration file that is being edited.
     * @param bID
     *            The Last Ore ID, used so that the Ores and Blocks would never
     *            conflict.
     */
    private static void configBlocks(Configuration config, int bID) {
        bID++;
        blockGrinderID = config.getBlock(Archive.blockGrinder, bID++).getInt();
        blockOvenID = config.getBlock(Archive.blockOven, bID++).getInt();
    }

    /**
     * Loads or creates the World Generation Section in the Configuration file.
     * 
     * @param config
     *            The Configuration file that is being edited.
     */
    private static void configWorldGen(Configuration config) {
        genAluminum(config);
    }

    /**
     * Loads or creates the Aluminum World Generation in the Configuration file.
     * 
     * @param config
     *            The Configuration file that is being edited.
     */
    private static void genAluminum(Configuration config) {
        Handler.log(Level.INFO, "Loading Aluminum Configs");
        String alu = " of Aluminum";
        enableWorldGenAluminum = config.get(gen + alu, "Enable Generation of Aluminum", true)
                .getBoolean(true);
        aluMaxHeight = config.get(gen + alu, "Maximum Height", 50).getInt();
        aluMinHeight = config.get(gen + alu, "Minimum Height", 25).getInt();
    }

}