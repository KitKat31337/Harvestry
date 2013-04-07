package claycorp.betterfood.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import claycorp.betterfood.items.ModItems;
import net.minecraft.item.crafting.CraftingManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.item.crafting.IRecipe;

public class RecipeHandler {

    public static void add() {
        Handler.logName("Overwriting foodstuffs!");
  
        List<IRecipe> minecraftRecipes = CraftingManager.getInstance().getRecipeList();
        ItemStack result;

           
 GameRegistry.addShapedRecipe(new ItemStack(Item.bread), new Object[] {"   ", "%%%", "###", 
            '#', Item.bucketWater, '%', ModItems.flour });
    }
}
