package claycorp.betterfood.utils;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import claycorp.betterfood.utils.handlers.Handler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

    private static String gen = "World Generation";

    // Items
    public static int itemCakePanFullID;
    public static int itemCakePanID;
    public static int itemModBucketID;
    public static int itemCakeBatterID;
    public static int itemBreadpanwithDoughID;
    public static int itemflourID;
    public static int itemBreadPanID;
    public static int itemChocolateChipsID;
    public static int itemCookieSheetID;
    public static int itemDoughID;
    public static int itemPiePanID;
    public static int itemPumpkinMashID;
    public static int itemAluminumFoilID;
    public static int itemAluminumSheetID;
    public static int itemRawAluminumID;
    public static int itemGrindStoneID;
    public static int itemGrindStonesID;

    // Food
    public static int foodPeanutsID;
    public static int foodScrambledEggsID;

    // Ores
    public static int oreAluminumID;

    // World Generation Stuff (Aluminum)
    public static boolean enableWorldGenAluminum;
    public static int aMaxHeight;
    public static int aMinHeight;

    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Archive.modName + ".cfg");

        Configuration config = new Configuration(configFile);

        try{
            Handler.log(Level.INFO, "Loading configuration");
            config.load();

            // Creates the configurations for Items
            configItems(config);

            // Creates the configurations for Ores
            configOres(config);

            // Creates the configurations for other Stuff
            configWorldGen(config);

        }catch(Exception e){
            Handler.log(Level.SEVERE, Archive.modName
                    + " has had a problem loading its configuration");
        }finally{
            if (config.hasChanged()){
                config.save();
            }
        }
    }

    private static void configItems(Configuration config) {
        Handler.log(Level.INFO, "Loading Item Configs");
        int iID = 8000;
        itemCakePanFullID = config.getItem(Archive.itemCakePanFull, iID++).getInt();
        itemCakePanID = config.getItem(Archive.itemCakePan, iID++).getInt();
        itemModBucketID = config.getItem(Archive.itemModBucket, iID++).getInt();
        itemCakeBatterID = config.getItem(Archive.itemCakeBatter, iID++).getInt();
        itemBreadpanwithDoughID = config.getItem(Archive.itemBreadpanwithDough, iID++).getInt();
        itemflourID = config.getItem(Archive.itemFlour, iID++).getInt();
        itemBreadPanID = config.getItem(Archive.itemBreadPan, iID++).getInt();
        itemChocolateChipsID = config.getItem(Archive.itemChocolateChips, iID++).getInt();
        itemCookieSheetID = config.getItem(Archive.itemCookieSheet, iID++).getInt();
        itemDoughID = config.getItem(Archive.itemDough, iID++).getInt();
        itemPiePanID = config.getItem(Archive.itemPiePan, iID++).getInt();
        itemPumpkinMashID = config.getItem(Archive.itemPumpkinMash, iID++).getInt();
        itemRawAluminumID = config.getItem(Archive.itemRawAluminum, iID++).getInt();
        itemAluminumSheetID = config.getItem(Archive.itemAluminumSheet, iID++).getInt();
        itemAluminumFoilID = config.getItem(Archive.itemAluminumFoil, iID++).getInt();
        itemGrindStoneID = config.getItem(Archive.itemGrindStone, iID++).getInt();
        itemGrindStonesID = config.getItem(Archive.itemGrindStones, iID++).getInt();
        // Creates the configurations for Food
        configFood(config, iID++);
    }

    private static void configFood(Configuration config, int fID) {
        Handler.log(Level.INFO, "Loading Food Configs");
        fID++;
        foodPeanutsID = config.getItem(Archive.foodPeanuts, fID++).getInt();
        foodScrambledEggsID = config.getItem(Archive.foodScrambledEggs, fID++).getInt();
    }

    private static void configOres(Configuration config) {
        Handler.log(Level.INFO, "Loading Ore Configs");
        int oID = 1000;
        oreAluminumID = config.getBlock(Archive.oreAluminum, oID++).getInt();
        // Creates the configurations for Blocks
        configBlocks(config, oID++);
    }

    private static void configBlocks(Configuration config, int bID) {}

    private static void configWorldGen(Configuration config) {
        genAluminum(config);
    }

    private static void genAluminum(Configuration config) {
        Handler.log(Level.INFO, "Loading Aluminum Configs");
        String alu = " of Aluminum";
        enableWorldGenAluminum = config.get(gen + alu, "Enable Generation of Aluminum", true)
                .getBoolean(true);
        aMaxHeight = config.get(gen + alu, "Maximum Height", 50).getInt();
        aMinHeight = config.get(gen + alu, "Minimum Height", 25).getInt();
    }

}