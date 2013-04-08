package claycorp.betterfood.utils;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

   //Items
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
   //Blocks
    public static int AluminumID;
    
    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Archive.modName + ".cfg");

        Configuration config = new Configuration(configFile);

        try{
            config.load();

          //  configItems(config);

         //   configBlocks(config);

        //    setDefaults();

     //       configGeneral(config);

        }catch(Exception e){
            FMLLog.log(Level.SEVERE, e, Archive.modName
                    + " has had a problem loading its configuration");
        }finally{
            if (config.hasChanged())
                config.save();
        }
    } 
    private satiatic void configItems(Configuration config) {
        itemCakePanFullID = config.getItem("CakePanFull", 9001).getInt(9001);
        itemCakePanID = config.getItem("CakePan", 9002).getInt(9002);
        itemModBucketID = config.getItem("ModBucket", 9003).getInt(9003);
        itemCakeBatterID = config.getItem("CakeBatter", 9004).getInt(9004);
        itemBreadpanwithDoughID = config.getItem("BreadpanwithDough", 9005).getInt(9005);
        itemflourID = config.getItem("flour", 9006).getInt(9006);
        itemBreadPanID = config.getItem("BreadPan", 9007).getInt(9007);
        itemChocolateChipsID = config.getItem("ChocolateChips", 9008).getInt(9008);
        itemCookieSheetID = config.getItem("CookieSheet", 9009).getInt(9009);
        itemDoughID = config.getItem("Dough", 9010).getInt(9010);
        itemPiePanID = config.getItem("PiePan", 9011).getInt(9011);
        itemPumpkinMashID = config.getItem("PumpkinMash", 9012).getInt(9012);


        }
    }
