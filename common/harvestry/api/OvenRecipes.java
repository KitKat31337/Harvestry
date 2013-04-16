package harvestry.api;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class OvenRecipes {

    private static final OvenRecipes cookBase = new OvenRecipes();

    /** The list of Oven results. */
    private HashSet<Recipes> recipes = new HashSet<Recipes>();

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
        recipes.add(new Recipes(input, output));
    }

    /**
     * Adds a Grinding recipe. It natively supports meta data, and passing Items
     * as the first parameter :D
     */
    public void addCookingRecipe(Item input, ItemStack output) {
        ItemStack in = new ItemStack(input);
        recipes.add(new Recipes(in, output));
    }

    /**
     * Adds a Oven Recipe. It natively supports meta data, and a Second Return.
     */
    public void addCookingRecipe(ItemStack input, ItemStack output, ItemStack output2) {
        recipes.add(new Recipes(input, output, output2));
    }

    /**
     * Adds a Grinding recipe. It natively supports meta data, a Second Return,
     * and passing Items
     * as the first parameter :D
     */
    public void addCookingRecipe(Item input, ItemStack output, ItemStack output2) {
        ItemStack in = new ItemStack(input);
        recipes.add(new Recipes(in, output, output2));
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * 
     * @param item
     *            The Source ItemStack
     * @return The result ItemStack
     */
    public Recipes getCookingResult(ItemStack item) {
        for (Recipes r : recipes)
            if (r.isInput(item))
                return r;
        return null;
    }

    public Set<Recipes> getOvenList() {
        return this.recipes;
    }
}