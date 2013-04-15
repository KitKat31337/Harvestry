package harvestry.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class OvenRecipes {

    private static final OvenRecipes ovenBase = new OvenRecipes();

    /** The list of Oven results. */
    private Map<Integer, ItemStack> ovenList = new HashMap<Integer, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaOvenList = new HashMap<List<Integer>, ItemStack>();

    /**
     * Used to call methods addOvenRecipe and getOvenResult.
     */
    public static final OvenRecipes oven() {
        return ovenBase;
    }

    private OvenRecipes() {}

    /**
     * Adds a Oven Recipe. It natively supports meta data.
     */
    public void addOvenRecipe(ItemStack input, ItemStack output) {
        if (input.isItemStackDamageable()){
            metaOvenList.put(Arrays.asList(input.itemID, input.getItemDamage()), output);
        }else{
            this.ovenList.put(Integer.valueOf(input.itemID), output);
        }
    }

    /**
     * Adds a Grinding recipe. It natively supports meta data. And passing Items
     * as the first parameter :D
     */
    public void addGrinding(Item input, ItemStack output) {
        ItemStack in = new ItemStack(input);
        if (in.isItemStackDamageable()){
            metaOvenList.put(Arrays.asList(input.itemID, in.getItemDamage()), output);
        }else{
            this.ovenList.put(Integer.valueOf(input.itemID), output);
        }
    }

    public Map<Integer, ItemStack> getOvenList() {
        return this.ovenList;
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * 
     * @param item
     *            The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getOvenResult(ItemStack item) {
        if (item == null){
            return null;
        }
        ItemStack ret = metaOvenList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null){
            return ret;
        }
        return ovenList.get(Integer.valueOf(item.itemID));
    }

    public Map<List<Integer>, ItemStack> getMetaOvenList() {
        return metaOvenList;
    }
}