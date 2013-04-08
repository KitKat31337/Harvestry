package claycorp.betterfood.utils;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

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
    public static int foodPeanutsID;
    // Blocks
    public static int AluminumID;

    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Archive.modName + ".cfg");

        Configuration config = new Configuration(configFile);

        try{
            config.load();

            configItems(config);

            configBlocks(config);

            configGeneral(config);

        }catch(Exception e){
            FMLLog.log(Level.SEVERE, e, Archive.modName
                    + " has had a problem loading its configuration");
        }finally{
            if (config.hasChanged())
                config.save();
        }
    }

    private static void configItems(Configuration config) {
        int iID = 9000;
        itemCakePanFullID = config.getItem(Archive.itemCakePanFull, iID++).getInt();
        itemCakePanID = config.getItem(Archive.itemCakePan, iID++).getInt();
        itemModBucketID = config.getItem(Archive.itemModBucket, iID++).getInt();
        itemCakeBatterID = config.getItem(Archive.itemCakeBatter, iID++).getInt();
        itemBreadpanwithDoughID = config.getItem(Archive.itemBreadpanwithDough, iID++).getInt();
        itemflourID = config.getItem(Archive.itemflour, iID++).getInt();
        itemBreadPanID = config.getItem(Archive.itemBreadPan, iID++).getInt();
        itemChocolateChipsID = config.getItem(Archive.itemChocolateChips, iID++).getInt();
        itemCookieSheetID = config.getItem(Archive.itemCookieSheet, iID++).getInt();
        itemDoughID = config.getItem(Archive.itemDough, iID++).getInt();
        itemPiePanID = config.getItem(Archive.itemPiePan, iID++).getInt();
        itemPumpkinMashID = config.getItem(Archive.itemPumpkinMash, iID++).getInt();
        foodPeanutsID = config.getItem(Archive.foodPeanuts, iID++).getInt();
    }

    private static void configBlocks(Configuration config) {}

    private static void configGeneral(Configuration config) {}

}