package claycorp.betterfood.utils.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import claycorp.betterfood.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {

    public static void add() {
        Handler.logName("Adding Recipies");

        GameRegistry.addShapedRecipe(new ItemStack(Item.bread), new Object[] { "   ", "%%%", "###",
                '#', Item.bucketWater, '%', ModItems.flour });
    }

    public static void delete() {

        Handler.logName("Overwriting Food Stuffs!");

        List<String> noCraft = new ArrayList<String>();

        // Any IDs to delete do next to the 297
        noCraft = Arrays.asList(new String[] { "297" });

        int id;
        int meta;

        ArrayList<ItemStack> items = new ArrayList<ItemStack>();
        // Decompose list into (item ID, Meta) pairs.
        for (String s : noCraft){
            id = meta = 0;
            String[] tmp = s.split(":");
            if (tmp != null && tmp.length > 0){
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
                for (ItemStack bannedItem : items){
                    // Remove the item if the ID & meta match, OR if the IDs
                    // match, and banned meta is -1.
                    if (result.itemID == bannedItem.itemID
                            && (bannedItem.getItemDamage() == -1 || result.getItemDamage() == bannedItem
                                    .getItemDamage())){
                        minecraftRecipes.remove(i);
                        Handler.logName("Recipes removed for item " + bannedItem.itemID);
                        --i;
                    }
                }
            }
        }
    }
}