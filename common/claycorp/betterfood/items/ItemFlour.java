package claycorp.betterfood.items;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import claycorp.betterfood.utils.Registry;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;

public class ItemFlour extends Item {

    public ItemFlour(int par1) {
        super(par1);
        maxStackSize = 64;
        setNoRepair();
        setCreativeTab(CreativeTabs.tabFood);
        }

    public boolean doseContainerItemLeaveCrafingGrid(
            ItemStack par1ItemStack) {
        return true;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister
                .registerIcon(Registry.texture
                        + this.getUnlocalizedName()
                                .substring(
                                        this.getUnlocalizedName()
                                                .indexOf(
                                                        ".") + 1));
    }
}

