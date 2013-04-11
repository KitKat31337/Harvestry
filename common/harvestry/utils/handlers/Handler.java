package harvestry.utils.handlers;

import harvestry.utils.Archive;
import harvestry.utils.exeptions.Exeptions;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class Handler {

    private static boolean IsLoaded = false;

    // *******************************Mod State Check*************************

    public static boolean isModLoaded() {
        if (IsLoaded == true){

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

    public static void LoadMod() {
        IsLoaded = true;
    }

    public static void UnLoadMod() {
        IsLoaded = false;
    }

    // ***********************************Log Stuff************************
    private static Logger logger = Logger.getLogger(Archive.id);

    public static void initLog() {

        logger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, Object message) {

        logger.log(logLevel, message.toString());
    }

    public static void print(Object s) {
        System.out.println(s);
    }
}