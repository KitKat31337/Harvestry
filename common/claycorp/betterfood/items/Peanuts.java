package claycorp.betterfood.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import claycorp.betterfood.BetterFood;
import claycorp.betterfood.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Peanuts extends ItemFood {

    public Peanuts(int id, int healAmount, float saturationModifier) {
        super(id, healAmount, saturationModifier, true);
        this.setCreativeTab(BetterFood.tabBetterFood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
