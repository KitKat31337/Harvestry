package harvestry.api;

import java.util.HashSet;

import net.minecraft.item.ItemStack;

public class FuelRegistry {

    /**
     * Grinder Recipes
     */
    private static HashSet<ItemStack> grinderList = new HashSet<ItemStack>();

    /**
     * Registers a new Grind Stone.
     * 
     * @param stack
     *            The Grind Stone to add.
     */
    public static void registerGrinderFuel(ItemStack stack) {
        grinderList.add(stack);
    }

    /**
     * Checks if a item is a Grind Stone.
     * 
     * @param stack
     *            The stack to check if it is a Grind Stone.
     * @return true if it is found in the Grinding List.
     */
    public static boolean isGrinderFuel(ItemStack stack) {
        for (ItemStack i : grinderList){
            if (i.isItemEqual(stack)){
                return true;
            }
        }

        return false;
    }

    /**
     * Oven Recipes
     */
    private static HashSet<ItemStack> ovenList = new HashSet<ItemStack>();

    /**
     * Registers a new Heating Element.
     * 
     * @param stack
     *            The Heating Element to add.
     */
    public static void registerOvenFuel(ItemStack stack) {
        ovenList.add(stack);
    }

    /**
     * Checks if a item is a Heating Element.
     * 
     * @param stack
     *            The stack to check if it is a Heating Element.
     * @return true if it is found in the Oven's List.
     */
    public static boolean isOvenFuel(ItemStack stack) {
        for (ItemStack i : ovenList){
            if (i.isItemEqual(stack)){
                return true;
            }
        }

        return false;
    }
}
