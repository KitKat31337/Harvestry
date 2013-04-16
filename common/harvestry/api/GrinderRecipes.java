package harvestry.api;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class GrinderRecipes {

    private static final GrinderRecipes grindingBase = new GrinderRecipes();

    /** The list of grinding results. */
    private HashSet<Recipes> recipes = new HashSet<Recipes>();

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
        recipes.add(new Recipes(input, output));
    }

    /**
     * Adds a Grinding recipe. It natively supports meta data. And passing Items
     * as the first parameter :D
     */
    public void addGrinding(Item input, ItemStack output) {
        ItemStack in = new ItemStack(input);
        recipes.add(new Recipes(in, output));
    }

    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * 
     * @param item
     *            The Source ItemStack
     * @return The result ItemStack
     */
    public Recipes getGrindingResult(ItemStack item) {
        for (Recipes r : recipes)
            if (r.isInput(item))
                return r;
        return null;
    }

    public Set<Recipes> getGrindingList() {
        return this.recipes;
    }
}