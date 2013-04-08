package claycorp.betterfood.utils;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {

    
    public static int CakePanFullID;
    public static int CakePanID;
    public static int ModBucketID;
    public static int CakeBatterID;
    public static int BreadpanwithDoughID;
    public static int PeanutsID;
    public static int flourID;
    public static int BreadPanID;
    public static int ChocolateChipsID;
    public static int CookieSheetID;
    public static int DoughID;
    public static int PiePanID;
    public static int PumpkinMashID;
    public static int AluminumID;
    
    public static void init(FMLPreInitializationEvent event) {

        File configFile = new File(event.getModConfigurationDirectory(), Registry.name + ".cfg");

        Configuration configuration = new Configuration(configFile);

        try{
            configuration.load();

            // *************************Item config's***********************
            flourID = configuration.getItem(Registry.flour + " Item", 9000,
                    Registry.flour + " Item Id:").getInt();
            BreadPanID = configuration.getItem(Registry.BreadPan + " Item", 9001,
                    Registry.BreadPan + " Item Id:").getInt();
            ChocolateChipsID = configuration.getItem(Registry.ChocolateChips + " Item", 9002,
                    Registry.ChocolateChips + " Item Id:").getInt();
            CookieSheetID = configuration.getItem(Registry.CookieSheet + " Item", 9003,
                    Registry.CookieSheet + " Item Id:").getInt();
            DoughID = configuration.getItem(Registry.Dough + " Item", 9004,
                    Registry.Dough + " Item Id:").getInt();
            PiePanID = configuration.getItem(Registry.PiePan + " Item", 9005,
                    Registry.PiePan + " Item Id:").getInt();
            PumpkinMashID = configuration.getItem(Registry.PumpkinMash + " Item", 9006,
                    Registry.PumpkinMash + " Item Id:").getInt();
            AluminumID = configuration.getItem(Registry.Aluminum + " Item", 200,
                    Registry.Aluminum + " Item Id:").getInt();
            PeanutsID = configuration.getItem(Registry.Peanuts + " Item", 9007,
                    Registry.Peanuts + " Item Id:").getInt();
            BreadpanwithDoughID = configuration.getItem(Registry.BreadpanwithDough + " Item", 9008,
                    Registry.BreadpanwithDough + " Item Id:").getInt();
            CakeBatterID = configuration.getItem(Registry.CakeBatter + " Item", 9009,
                    Registry.CakeBatter + " Item Id:").getInt();
            ModBucketID = configuration.getItem(Registry.ModBucket + " Item", 9010,
                    Registry.ModBucket + " Item Id:").getInt();
            CakePanID = configuration.getItem(Registry.CakePan + " Item", 9011,
                    Registry.CakePan + " Item Id:").getInt();
            CakePanFullID = configuration.getItem(Registry.CakePanFull + " Item", 9012,
                    Registry.CakePanFull + " Item Id:").getInt();

        }catch(Exception e){
            FMLLog.log(Level.SEVERE, e, Registry.name
                    + " has had a problem loading its configuration");
        }finally{
            configuration.save();
        }
    }
}