package harvestry;

import harvestry.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HarvestryTabs extends CreativeTabs {

    public HarvestryTabs(int id, String name) {
        super(id, name);
    }

    /**
     * Gets the Icon from a Item to display as the Tab's Icon
     */
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack() {
        return new ItemStack(ModItems.foodPeanuts);
    }
}
