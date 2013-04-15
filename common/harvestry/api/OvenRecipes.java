package harvestry.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class OvenRecipes {

    private static final OvenRecipes cookBase = new OvenRecipes();

    /** The list of Oven results. */
    private Map<Integer, ItemStack> cookList = new HashMap<Integer, ItemStack>();
    private Map<Integer, ItemStack> cookList2 = new HashMap<Integer, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaCookList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaCookList2 = new HashMap<List<Integer>, ItemStack>();

    /**
     * Used to call methods addOvenRecipe and getOvenResult.
     */
    public static final OvenRecipes cooking() {
        return cookBase;
    }

    private OvenRecipes() {}

    /**
     * Adds a Oven Recipe. It natively supports meta data.
     */
    public void addCookingRecipe(ItemStack input, ItemStack output) {
        if (input.isItemStackDamageable()){
            metaCookList.put(Arrays.asList(input.itemID, input.getItemDamage()), output);
        }else{
            this.cookList.put(Integer.valueOf(input.itemID), output);
        }
    }

    /**
     * Adds a Grinding recipe. It natively supports meta data, and passing Items
     * as the first parameter :D
     */
    public void addCookingRecipe(Item input, ItemStack output) {
        ItemStack in = new ItemStack(input);
        if (in.isItemStackDamageable()){
            metaCookList.put(Arrays.asList(input.itemID, in.getItemDamage()), output);
        }else{
            this.cookList.put(Integer.valueOf(input.itemID), output);
        }
    }

    /**
     * Adds a Oven Recipe. It natively supports meta data, and a Second Return.
     */
    public void addCookingRecipe(ItemStack input, ItemStack output, ItemStack output2) {
        if (input.isItemStackDamageable()){
            metaCookList.put(Arrays.asList(input.itemID, input.getItemDamage()), output);
            metaCookList2.put(Arrays.asList(input.itemID, input.getItemDamage()), output2);
        }else{
            this.cookList.put(Integer.valueOf(input.itemID), output);
            this.cookList2.put(Integer.valueOf(input.itemID), output2);
        }
    }

    /**
     * Adds a Grinding recipe. It natively supports meta data, a Second Return,
     * and passing Items
     * as the first parameter :D
     */
    public void addCookingRecipe(Item input, ItemStack output, ItemStack output2) {
        ItemStack in = new ItemStack(input);
        if (in.isItemStackDamageable()){
            metaCookList.put(Arrays.asList(input.itemID, in.getItemDamage()), output);
            metaCookList2.put(Arrays.asList(input.itemID, in.getItemDamage()), output2);
        }else{
            this.cookList.put(Integer.valueOf(input.itemID), output);
            this.cookList2.put(Integer.valueOf(input.itemID), output2);
        }
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * 
     * @param item
     *            The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getCookingResult(ItemStack item) {
        if (item != null){
            ItemStack ret = metaCookList.get(Arrays.asList(item.itemID, item.getItemDamage()));
            if (ret != null){
                return ret;
            }else{
                return cookList.get(Integer.valueOf(item.itemID));
            }
        }else{
            return null;
        }
    }

    /**
     * Used to get the resulting Second ItemStack form a source ItemStack
     * 
     * @param item
     *            The Source ItemStack
     * @return The resulting Second ItemStack
     */
    public ItemStack getCookingResult2(ItemStack item) {
        if (item != null){
            ItemStack ret = metaCookList2.get(Arrays.asList(item.itemID, item.getItemDamage()));
            if (ret != null){
                return ret;
            }else{
                return cookList2.get(Integer.valueOf(item.itemID));
            }
        }else{
            return null;
        }
    }

    public Map<Integer, ItemStack> getOvenList() {
        return this.cookList;
    }

    public Map<Integer, ItemStack> getOvenList2() {
        return this.cookList2;
    }

    public Map<List<Integer>, ItemStack> getMetaOvenList() {
        return metaCookList;
    }

    public Map<List<Integer>, ItemStack> getMetaOvenList2() {
        return metaCookList2;
    }
}