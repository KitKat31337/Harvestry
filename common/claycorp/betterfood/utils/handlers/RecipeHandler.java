package claycorp.betterfood.utils.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.OreDictionary;
import claycorp.betterfood.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {

    public static void init() {
        // Adds Recipes
        add();
        // Deletes Recipes
        delete();
    }

    private static ItemStack grindStones = new ItemStack(ModItems.itemGrindStones, 1,
            OreDictionary.WILDCARD_VALUE);

    private static void add() {
        Handler.logName("Adding Recipies");

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemDough), new Object[] {
                Item.bucketWater, ModItems.itemflour, ModItems.itemflour, ModItems.itemflour });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemBreadpanwithDough),
                new Object[] { ModItems.itemBreadPan, ModItems.itemDough });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCakeBatter), new Object[] {
                (ModItems.itemModBucket), ModItems.itemflour, ModItems.itemflour,
                ModItems.itemflour, Item.sugar, Item.egg });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemCakePanFull), new Object[] {
                ModItems.itemCakeBatter, ModItems.itemCakePan });

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemBreadPan), new Object[] { "T   T",
                "T T", "TTT", 'T', ModItems.itemAluminumSheet });

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemCakePan), new Object[] { "   ",
                "T T", "TTT", 'T', ModItems.itemAluminumSheet });

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.itemGrindStone), new Object[] { "SSS",
                "SLS", "SSS", 'S', Block.stone, 'L', Block.wood });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemGrindStones), new Object[] {
                ModItems.itemGrindStone, ModItems.itemGrindStone });

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemflour), new Object[] {
                Item.wheat, grindStones });

    }

    private static void delete() {

        Handler.logName("Overwriting Food Stuffs!");

        List<String> noCraft = new ArrayList<String>();

        // Any IDs to delete do next to the 297
        noCraft = Arrays.asList(new String[] { "297", "354", "357", "400" });

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

        // Iterate over recipe list, and remove a recipe when its output matches
        // one of our ItemStacks.
        @SuppressWarnings("unchecked")
        List<IRecipe> minecraftRecipes = CraftingManager.getInstance().getRecipeList();
        ItemStack result;
        for (int i = 0; i < minecraftRecipes.size(); ++i){
            IRecipe tmp = minecraftRecipes.get(i);
            result = tmp.getRecipeOutput();

            if (result != null){
                for (ItemStack removedItem : items){
                    // Remove the item if the ID & meta match, OR if the IDs
                    // match, and banned meta is -1.
                    if ((result.itemID == removedItem.itemID)
                            && ((removedItem.getItemDamage() == -1) || (result.getItemDamage() == removedItem
                                    .getItemDamage()))){
                        minecraftRecipes.remove(i);
                        Handler.logName("Recipes removed for item " + removedItem.itemID);
                        --i;
                    }
                }
            }
        }
    }
}