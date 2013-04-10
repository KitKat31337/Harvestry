package claycorp.betterfood.utils.handlers;

import claycorp.betterfood.utils.Archive;
import claycorp.betterfood.utils.exeptions.Exeptions;

public class Handler {

    private static boolean IsLoaded = false;

    // *******************************Mod State Check*************************

    public static boolean isModLoaded() {
        if (IsLoaded == true){

            throw new Exeptions(
                    "Why did you install my Mod twice? Remove the second Cooler-Universal-"
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

    public static void log(Object s) {
        System.out.println(s);
    }

    public static void logName(String s) {
        System.out.println("[" + Archive.modName + "]" + " " + s);
    }
}