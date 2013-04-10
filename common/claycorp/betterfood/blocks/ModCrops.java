package claycorp.betterfood.blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class ModCrops extends BlockCrops {

    protected ModCrops(int par1) {
        super(par1);
        // TODO Auto-generated constructor stub
    }

    /**
     * Generate a seed ItemStack for this crop.
     */
    @Override
    protected int getSeedItem() {
        return Item.seeds.itemID;
    }

    /**
     * Generate a crop produce ItemStack for this crop.
     */
    @Override
    protected int getCropItem() {
        return Item.wheat.itemID;
    }

}