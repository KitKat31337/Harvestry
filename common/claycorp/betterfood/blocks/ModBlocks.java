package claycorp.betterfood.blocks;

import claycorp.betterfood.utils.Archive;
import claycorp.betterfood.utils.Config;
import net.minecraft.block.Block;

public class ModBlocks {

    public static Block oreAluminum;

    public static  void init(){

    oreAluminum = (Block) new BlockMod(Config.oreAluminumID, null)
            .setUnlocalizedName(Archive.oreAluminum)
            .getBlockTextureFromSide(1);
            
            
        
    }
}