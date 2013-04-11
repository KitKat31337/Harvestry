package claycorp.Harvestry.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import claycorp.Harvestry.Harvestry;
import claycorp.Harvestry.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FoodMod extends ItemFood {

    public FoodMod(int id, int healAmount, float saturationModifier) {
        super(id - 256, healAmount, saturationModifier, true);
        this.setCreativeTab(Harvestry.tabHarvestry);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
