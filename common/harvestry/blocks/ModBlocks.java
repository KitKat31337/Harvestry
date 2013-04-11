package harvestry.blocks;

import harvestry.utils.Archive;
import harvestry.utils.Config;
import harvestry.utils.handlers.Handler;

import java.util.logging.Level;

import net.minecraft.block.Block;

public class ModBlocks {

    public static Block oreAluminum;
    public static Block blockGrinder;

    public static void init() {
        Handler.log(Level.INFO, "Loading Blocks");
        oreAluminum = new BlockMod(Config.oreAluminumID).setUnlocalizedName(Archive.oreAluminum);
        // blockGrinder = new ModContainer(Config.blockGrinderID, new
        // GrinderTE()).setUnlocalizedName(Archive.blockGrinder);
    }
}