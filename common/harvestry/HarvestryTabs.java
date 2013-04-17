package harvestry;

import harvestry.items.enums.EnumBaseFood;
import harvestry.utils.handlers.EHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class HarvestryTabs extends CreativeTabs {

    /**
     * Creates a new Creative Tab.
     * 
     * @param id
     *            The Tab ID
     * @param name
     *            The Tab Name
     */
    public HarvestryTabs(int id, String name) {
        super(id, name);
    }

    /**
     * Gets the Icon from a Item to display as the Tab's Icon
     */
    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack() {
        return EHandler.getItem(EnumBaseFood.foodCookie);
    }
}
