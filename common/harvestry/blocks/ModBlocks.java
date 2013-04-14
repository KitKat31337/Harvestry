package harvestry.blocks;

import harvestry.utils.Archive;
import harvestry.utils.Config;
import harvestry.utils.handlers.Handler;

import java.util.logging.Level;

import net.minecraft.block.Block;

public class ModBlocks {

    public static Block oreAluminum;
    public static Block blockGrinder;
    public static Block blockOven;

    /**
     * Creates all the Block Objects in the Mod.
     */
    public static void init() {
        Handler.log(Level.INFO, "Loading Blocks");

        oreAluminum = new BaseOre(Config.oreAluminumID).setUnlocalizedName(Archive.oreAluminum)
                .setHardness(3.0F).setResistance(5.0F);

        blockGrinder = new BaseContainerBlock(Config.blockGrinderID, Archive.grinderGUID)
                .setUnlocalizedName(Archive.blockGrinder);

        blockOven = new BaseContainerBlock(Config.blockOvenID, Archive.ovenGUID).setUnlocalizedName(Archive.blockOven);
    }
}