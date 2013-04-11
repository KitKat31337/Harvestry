package claycorp.Harvestry.blocks;

import java.util.logging.Level;

import net.minecraft.block.Block;
import claycorp.Harvestry.utils.Archive;
import claycorp.Harvestry.utils.Config;
import claycorp.Harvestry.utils.handlers.Handler;

public class ModBlocks {

    public static Block oreAluminum;

    public static void init() {
        Handler.log(Level.INFO, "Loading Blocks");
        oreAluminum = new BlockMod(Config.oreAluminumID).setUnlocalizedName(Archive.oreAluminum);

    }
}