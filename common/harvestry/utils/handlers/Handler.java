package harvestry.utils.handlers;

import harvestry.utils.Archive;
import harvestry.utils.exeptions.Exeptions;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class Handler {

    private static boolean IsLoaded = false;

    /*
     * *******************************************************************
     * Mod State Check
     * *******************************************************************
     */
    /**
     * Checks if the Mod has being loaded before and throws a exception. The
     * default response is false. Other wise you should get a Exception.
     * 
     * @return false if the Mod has not being loaded yet.
     */
    public static boolean isModLoaded() {
        if (IsLoaded){

            throw new Exeptions(
                    "Why did you install my Mod twice? Remove the second "
                            + Archive.modName
                            + "-Universal-"
                            + Archive.ver
                            + ".jar out of your mods-Folder, you need only one of them. And another Question: Why the Hax did Forge not detect that before me?");
        }else{
            return false;
        }
    }

    /**
     * "Loads" the Mod. In respect to {@link isModLoaded()}
     */
    public static void LoadMod() {
        IsLoaded = true;
    }

    /**
     * "UnLoads" the Mod. In respect to {@link isModLoaded()}
     */
    public static void UnLoadMod() {
        IsLoaded = false;
    }

    /*
     * *******************************************************************
     * Log Stuff
     * *******************************************************************
     */
    private static Logger logger = Logger.getLogger(Archive.id);

    /**
     * Initializes the Logger for this Mod.
     */
    public static void initLog() {

        logger.setParent(FMLLog.getLogger());
    }

    /**
     * Logs a Object.
     */
    public static void log(Level logLevel, Object message) {

        logger.log(logLevel, message.toString());
    }

    /**
     * Logs a Object, and a Throwable.
     */
    public static void log(Level level, String msg, Throwable t) {
        logger.log(level, msg, t);
    }
}