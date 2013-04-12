package harvestry.utils.handlers;

import harvestry.items.ModItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {

    private static ItemStack grindStones = new ItemStack(ModItems.itemGrindStones, 1,
            OreDictionary.WILDCARD_VALUE);

    /**
     * Initializes all the methods that handle Recipes.
     */
    public static void init() {

        addShapeless();

        addShaped();

        delete();
    }

    /**
     * Adds all Shapeless the recipes in the Mod.
     */
    private static void addShapeless() {

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemDough), new Object[] {
                Item.bucketWater, ModItems.itemFlour, ModItems.itemFlour, ModItems.itemFlour });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemBreadpanwithDough),
                new Object[] { ModItems.itemBreadPan, ModItems.itemDough });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCakeBatter), new Object[] {
                ModItems.itemModBucket, ModItems.itemFlour, ModItems.itemFlour, ModItems.itemFlour,
                Item.sugar, Item.egg, Item.bucketMilk });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCakePanFull), new Object[] {
                ModItems.itemCakeBatter, ModItems.itemCakePan });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemGrindStones), new Object[] {
                ModItems.itemGrindStone, ModItems.itemGrindStone });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemFlour), new Object[] {
                Item.wheat, grindStones });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemRawPotato), new Object[] {
                ModItems.itemAluminumFoil, Item.potato });

        GameRegistry.addShapelessRecipe(new ItemStack(Item.sugar), new Object[] { Item.reed,
                grindStones });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCookieDough), new Object[] {
                Item.sugar, ModItems.itemFlour, ModItems.itemFlour, Item.bucketMilk, Item.egg,
                ModItems.itemModBucket });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemChocolateChipCookieDough),
                new Object[] { ModItems.itemCookieDough, ModItems.itemChocolateChips });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemPumpkinPieFilling),
                new Object[] { ModItems.itemPumpkinMash, Item.bucketMilk, Item.sugar,
                        ModItems.itemPumpkinMash });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemPieCrust), new Object[] {
                ModItems.itemPiePan, ModItems.itemDough });
    }

    /**
     * Adds all Shaped the recipes in the Mod.
     */
    private static void addShaped() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemBreadPan), new Object[] { "T   T",
                "T T", "TTT", 'T', ModItems.itemAluminumSheet });

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemCakePan), new Object[] { "   ",
                "T T", "TTT", 'T', ModItems.itemAluminumSheet });

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemGrindStone), new Object[] { "SSS",
                "SLS", "SSS", 'S', Block.stone, 'L', Block.wood });
    }

    /**
     * Deletes any recipes that have to be deleted because of Game play choices.
     */
    private static void delete() {

        Handler.log(Level.INFO, "Overwriting Food Stuffs!");

        List<String> noCraft = new ArrayList<String>();

        // Any IDs to delete do next to the 297
        noCraft = Arrays.asList(new String[] { "297", "354", "357", "400", "353" });

        int id;
        int meta;

        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        // Decompose list into (item ID, Meta) pairs.
        for (String s : noCraft){
            id = meta = 0;
            String[] tmp = s.split(":");
            if ((tmp != null) && (tmp.length > 0)){
                try{
                    id = Integer.parseInt(tmp[0]);
                    if (tmp.length > 1){
                        try{
                            meta = Integer.parseInt(tmp[1]);
                        }catch(Exception ex){
                            meta = 0;
                        }
                    }
                }catch(Exception ex){
                    id = 0;
                }
            }

            if (id != 0){
                items.add(new ItemStack(id, 1, meta));
            }
        }

        /*
         * Iterate over recipe list, and remove a recipe when its output matches
         * one of our ItemStacks.
         */
        @SuppressWarnings("unchecked")
        List<IRecipe> minecraftRecipes = CraftingManager.getInstance().getRecipeList();
        ItemStack result;
        for (int i = 0; i < minecraftRecipes.size(); ++i){
            IRecipe tmp = minecraftRecipes.get(i);
            result = tmp.getRecipeOutput();

            if (result != null){
                for (ItemStack removedItem : items){
                    /*
                     * Remove the item if the ID & meta match, OR if the IDs
                     * match, and banned meta is -1.
                     */
                    if ((result.itemID == removedItem.itemID)
                            && ((removedItem.getItemDamage() == -1) || (result.getItemDamage() == removedItem
                                    .getItemDamage()))){
                        minecraftRecipes.remove(i);
                        Handler.log(Level.INFO, "Recipes removed for item " + removedItem.itemID);
                        --i;
                    }
                }
            }
        }
    }
}