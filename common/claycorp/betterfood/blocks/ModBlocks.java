package claycorp.betterfood.blocks;

import java.util.logging.Level;

import net.minecraft.block.Block;
import claycorp.betterfood.utils.Archive;
import claycorp.betterfood.utils.Config;
import claycorp.betterfood.utils.handlers.Handler;

public class ModBlocks {

    public static Block oreAluminum;

    public static void init() {
        Handler.log(Level.INFO, "Loading Blocks");
        oreAluminum = new BlockMod(Config.oreAluminumID).setUnlocalizedName(Archive.oreAluminum);

    }
}