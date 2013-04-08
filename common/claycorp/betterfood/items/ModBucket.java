package claycorp.betterfood.items;

import claycorp.betterfood.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModBucket extends Item {
    public ModBucket(int id) {
        super(id);
        maxStackSize = 16;
        setNoRepair();
        setCreativeTab(CreativeTabs.tabFood);
    }

    public boolean doseContainerItemLeaveCrafingGrid(ItemStack par1ItemStack) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
}
