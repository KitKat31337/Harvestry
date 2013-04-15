package harvestry.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class GrinderRecipes {

    private static final GrinderRecipes grindingBase = new GrinderRecipes();

    /** The list of grinding results. */
    private Map<Integer, ItemStack> grindingList = new HashMap<Integer, ItemStack>();
    private HashMap<List<Integer>, ItemStack> metaGrindingList = new HashMap<List<Integer>, ItemStack>();

    /**
     * Used to call methods addGrinding and getGrindingResult.
     */
    public static final GrinderRecipes grinding() {
        return grindingBase;
    }

    private GrinderRecipes() {}

    /**
     * Adds a Grinding recipe. It natively supports meta data.
     */
    public void addGrinding(ItemStack input, ItemStack output) {
        if (input.isItemStackDamageable()){
            metaGrindingList.put(Arrays.asList(input.itemID, input.getItemDamage()), output);
        }else{
            this.grindingList.put(Integer.valueOf(input.itemID), output);
        }
    }

    /**
     * Adds a Grinding recipe. It natively supports meta data. And passing Items
     * as the first parameter :D
     */
    public void addGrinding(Item input, ItemStack output) {
        ItemStack in = new ItemStack(input);
        if (in.isItemStackDamageable()){
            metaGrindingList.put(Arrays.asList(input.itemID, in.getItemDamage()), output);
        }else{
            this.grindingList.put(Integer.valueOf(input.itemID), output);
        }
    }

    public Map<Integer, ItemStack> getGrindingList() {
        return this.grindingList;
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * 
     * @param item
     *            The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getGrindingResult(ItemStack item) {
        if (item == null){
            return null;
        }
        ItemStack ret = metaGrindingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null){
            return ret;
        }
        return grindingList.get(Integer.valueOf(item.itemID));
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList() {
        return metaGrindingList;
    }
}