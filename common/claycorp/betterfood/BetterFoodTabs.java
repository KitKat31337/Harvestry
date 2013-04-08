package claycorp.betterfood;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import claycorp.betterfood.items.ModItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BetterFoodTabs extends CreativeTabs {

    public BetterFoodTabs(int id, String name) {
        super(id, name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getIconItemStack() {
        return new ItemStack(ModItems.foodPeanuts);
    }
}
