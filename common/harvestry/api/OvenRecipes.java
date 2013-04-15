package harvestry.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OvenRecipes {

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

    private OvenRecipes() {
        this.addOvenRecipe(Block.oreIron.blockID, new ItemStack(Item.ingotIron));
        this.addOvenRecipe(Block.oreGold.blockID, new ItemStack(Item.ingotGold));
        this.addOvenRecipe(Block.oreDiamond.blockID, new ItemStack(Item.diamond));
        this.addOvenRecipe(Block.sand.blockID, new ItemStack(Block.glass));
        this.addOvenRecipe(Item.porkRaw.itemID, new ItemStack(Item.porkCooked));
        this.addOvenRecipe(Item.beefRaw.itemID, new ItemStack(Item.beefCooked));
        this.addOvenRecipe(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked));
        this.addOvenRecipe(Item.fishRaw.itemID, new ItemStack(Item.fishCooked));
        this.addOvenRecipe(Block.cobblestone.blockID, new ItemStack(Block.stone));
        this.addOvenRecipe(Item.clay.itemID, new ItemStack(Item.brick));
        this.addOvenRecipe(Block.cactus.blockID, new ItemStack(Item.dyePowder, 1, 2));
        this.addOvenRecipe(Block.wood.blockID, new ItemStack(Item.coal, 1, 1));
        this.addOvenRecipe(Block.oreEmerald.blockID, new ItemStack(Item.emerald));
        this.addOvenRecipe(Item.potato.itemID, new ItemStack(Item.bakedPotato));
        this.addOvenRecipe(Block.netherrack.blockID, new ItemStack(Item.netherrackBrick));
        this.addOvenRecipe(Block.oreCoal.blockID, new ItemStack(Item.coal));
        this.addOvenRecipe(Block.oreRedstone.blockID, new ItemStack(Item.redstone));
        this.addOvenRecipe(Block.oreLapis.blockID, new ItemStack(Item.dyePowder, 1, 4));
        this.addOvenRecipe(Block.oreNetherQuartz.blockID, new ItemStack(Item.netherQuartz));
    }

    /**
     * Adds a Oven Recipe.
     */
    public void addOvenRecipe(int par1, ItemStack par2ItemStack) {
        this.ovenList.put(Integer.valueOf(par1), par2ItemStack);
    }

    public Map<Integer, ItemStack> getOvenList() {
        return this.ovenList;
    }

    /**
     * A meta data sensitive version of adding a furnace recipe.
     */
    public void addOvenRecipe(int itemID, int metadata, ItemStack itemstack) {
        metaOvenList.put(Arrays.asList(itemID, metadata), itemstack);
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