package claycorp.betterfood.blocks;

import net.minecraft.block.Block;
import claycorp.betterfood.utils.Archive;
import claycorp.betterfood.utils.Config;

public class ModBlocks {

    public static Block oreAluminum;

    public static void init() {

        oreAluminum = new BlockMod(Config.oreAluminumID).setUnlocalizedName(Archive.oreAluminum);

    }
}