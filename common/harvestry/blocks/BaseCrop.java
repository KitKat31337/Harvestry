package harvestry.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import harvestry.Harvestry;
import harvestry.utils.Archive;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class BaseCrop extends BlockCrops {

    protected BaseCrop(int id) {
        super(id);
        setCreativeTab(Harvestry.tabHarvestry);
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
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}