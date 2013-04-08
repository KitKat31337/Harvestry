package claycorp.betterfood.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import claycorp.betterfood.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PumpkinMash extends Item {

    public PumpkinMash(int id) {
        super(id);
        maxStackSize = 64;
        setNoRepair();
        setCreativeTab(CreativeTabs.tabFood);
    }

    public boolean doseContainerItemLeaveCrafingGrid(ItemStack par1ItemStack) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}

