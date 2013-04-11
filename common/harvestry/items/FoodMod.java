package harvestry.items;

import harvestry.Harvestry;
import harvestry.utils.Archive;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FoodMod extends ItemFood {

    public FoodMod(int id, int healAmount, float saturationModifier) {
        super(id - 256, healAmount, saturationModifier, true);
        this.setCreativeTab(Harvestry.tabHarvestry);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}