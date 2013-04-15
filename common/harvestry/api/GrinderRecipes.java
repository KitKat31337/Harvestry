package harvestry.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrinderRecipes {

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

    private GrinderRecipes() {
        this.addGrinding(Block.oreIron.blockID, new ItemStack(Item.ingotIron));
        this.addGrinding(Block.oreGold.blockID, new ItemStack(Item.ingotGold));
        this.addGrinding(Block.oreDiamond.blockID, new ItemStack(Item.diamond));
        this.addGrinding(Block.sand.blockID, new ItemStack(Block.glass));
        this.addGrinding(Item.porkRaw.itemID, new ItemStack(Item.porkCooked));
        this.addGrinding(Item.beefRaw.itemID, new ItemStack(Item.beefCooked));
        this.addGrinding(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked));
        this.addGrinding(Item.fishRaw.itemID, new ItemStack(Item.fishCooked));
        this.addGrinding(Block.cobblestone.blockID, new ItemStack(Block.stone));
        this.addGrinding(Item.clay.itemID, new ItemStack(Item.brick));
        this.addGrinding(Block.cactus.blockID, new ItemStack(Item.dyePowder, 1, 2));
        this.addGrinding(Block.wood.blockID, new ItemStack(Item.coal, 1, 1));
        this.addGrinding(Block.oreEmerald.blockID, new ItemStack(Item.emerald));
        this.addGrinding(Item.potato.itemID, new ItemStack(Item.bakedPotato));
        this.addGrinding(Block.netherrack.blockID, new ItemStack(Item.netherrackBrick));
        this.addGrinding(Block.oreCoal.blockID, new ItemStack(Item.coal));
        this.addGrinding(Block.oreRedstone.blockID, new ItemStack(Item.redstone));
        this.addGrinding(Block.oreLapis.blockID, new ItemStack(Item.dyePowder, 1, 4));
        this.addGrinding(Block.oreNetherQuartz.blockID, new ItemStack(Item.netherQuartz));
    }

    /**
     * Adds a Grinding recipe.
     */
    public void addGrinding(int par1, ItemStack par2ItemStack) {
        this.grindingList.put(Integer.valueOf(par1), par2ItemStack);
    }

    public Map<Integer, ItemStack> getGrindingList() {
        return this.grindingList;
    }

    /**
     * A meta data sensitive version of adding a furnace recipe.
     */
    public void addGrinding(int itemID, int metadata, ItemStack itemstack) {
        metaGrindingList.put(Arrays.asList(itemID, metadata), itemstack);
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