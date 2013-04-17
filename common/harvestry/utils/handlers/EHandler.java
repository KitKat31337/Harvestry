package harvestry.utils.handlers;

import harvestry.items.ModItems;
import harvestry.items.enums.EnumBaseFood;
import harvestry.items.enums.EnumBaseItem;
import harvestry.items.enums.EnumNonStack;
import net.minecraft.item.ItemStack;

public final class EHandler {
    
    /**
     * 
     * @param enumBaseItem
     * @return
     */
    public static ItemStack getItem(EnumBaseItem enumBaseItem) {
        return new ItemStack(ModItems.mainItem, 1, enumBaseItem.ordinal());
    }

    /**
     * 
     * @param enumBaseItem
     * @param amount
     * @return
     */
    public static ItemStack getItem(EnumBaseItem enumBaseItem, int amount) {
        return new ItemStack(ModItems.mainItem, amount, enumBaseItem.ordinal());
    }
    
    /**
     * 
     * @param enumNonStack
     * @return
     */
    public static ItemStack getItem(EnumNonStack enumNonStack) {
        return new ItemStack(ModItems.nsItem, 1, enumNonStack.ordinal());
    }
    
    /**
     * 
     * @param enumNonStack
     * @param amount
     * @return
     */
    public static ItemStack getItem(EnumNonStack enumNonStack, int amount) {
        return new ItemStack(ModItems.nsItem, amount, enumNonStack.ordinal());
    }
    
    /**
     * 
     * @param enumBaseFood
     * @return
     */
    public static ItemStack getItem(EnumBaseFood enumBaseFood) {
        return new ItemStack(ModItems.foodItem, 1, enumBaseFood.ordinal());
    }
    
    /**
     * 
     * @param enumBaseFood
     * @param amount
     * @return
     */
    public static ItemStack getItem(EnumBaseFood enumBaseFood, int amount) {
        return new ItemStack(ModItems.foodItem, amount, enumBaseFood.ordinal());
    }
}