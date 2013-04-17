package harvestry.utils.handlers;

import harvestry.api.GrinderRecipes;
import harvestry.api.OvenRecipes;
import harvestry.items.ModItems;
import harvestry.items.enums.EnumBaseFood;
import harvestry.items.enums.EnumBaseItem;
import harvestry.items.enums.EnumNonStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public final class RecipeHandler {

    private static ItemStack grindStones = new ItemStack(ModItems.itemGrindStones, 1,
            OreDictionary.WILDCARD_VALUE);

    /**
     * Initializes all the methods that handle Recipes.
     */
    public static void init() {

        crafting();

        modRecipes();
    }

    /**
     * Adds all the crafting related recipes in the Mod.
     */
    private static void crafting() {

        addShapeless();

        addShaped();

        delete();
    }

    /**
     * Adds all Shapeless the recipes in the Mod.
     */
    private static void addShapeless() {

        GameRegistry.addShapelessRecipe(BaseItemEnum(EnumBaseItem.itemDough),
                new Object[] { Item.bucketWater, BaseItemEnum(EnumBaseItem.itemFlour),
            BaseItemEnum(EnumBaseItem.itemFlour), BaseItemEnum(EnumBaseItem.itemFlour) });

        GameRegistry.addShapelessRecipe(
                BaseItemEnum(EnumBaseItem.itemUncookedBread),
                new Object[] { BaseItemEnum(EnumBaseItem.itemBreadPan),
                        BaseItemEnum(EnumBaseItem.itemDough) });

        GameRegistry.addShapelessRecipe(BaseItemEnum(EnumBaseItem.itemCakeBatter),
                new Object[] { BaseItemEnum(EnumBaseItem.itemBowl), BaseItemEnum(EnumBaseItem.itemFlour),
            BaseItemEnum(EnumBaseItem.itemFlour), BaseItemEnum(EnumBaseItem.itemFlour),
                        Item.sugar, Item.egg, Item.bucketMilk });

        GameRegistry.addShapelessRecipe(
                new ItemStack(EnumBaseItem.itemUncookedCake),
                new Object[] { EnumBaseItem.itemCakeBatter),
                        EnumBaseItem.itemCakePan) });

        GameRegistry.addShapelessRecipe(new ItemStack(EnumBaseItem.itemGrindStones.),
                new Object[] { EnumBaseItem.gStone), EnumBaseItem.gStone) });

        GameRegistry.addShapelessRecipe(new ItemStack(EnumBaseItem.itemFlour)),
                new Object[] { Item.wheat, grindStones });

        GameRegistry.addShapelessRecipe(new ItemStack(EnumBaseItem.itemUncookedPotato)),
                new Object[] { EnumBaseItem.itemAluminumFoil., Item.potato });

        GameRegistry.addShapelessRecipe(new ItemStack(Item.sugar), new Object[] { Item.reed,
                grindStones });

        GameRegistry.addShapelessRecipe(
                BaseItemEnum(EnumBaseItem.itemCookieDough),
                new Object[] { Item.sugar, BaseItemEnum(EnumBaseItem.itemFlour),
                BaseItemEnum(EnumBaseItem.itemFlour), Item.bucketMilk, Item.egg,
                        BaseItemEnum(EnumBaseItem.itemBowl) });

        GameRegistry.addShapelessRecipe(BaseItemEnum(EnumBaseItem.itemChocolateChipCookieDough),
                new Object[] { EnumBaseItem.itemCookieDough, EnumBaseItem.itemChocolateChips,
                        Item.sugar });

        GameRegistry.addShapelessRecipe(BaseItemEnum(EnumBaseItem.itemPumpkinPieFilling),
                new Object[] { EnumBaseItem.itemPumpkinMash, Item.bucketMilk, Item.sugar,
                        EnumBaseItem.itemPumpkinMash });

        GameRegistry.addShapelessRecipe(BaseItemEnum(EnumBaseItem.itemPieCrust), new Object[] {
            BaseItemEnum(EnumBaseItem.itemPiePan), EnumBaseItem.itemDough });

        GameRegistry.addShapelessRecipe(new ItemStack(EnumBaseItem.itemSugarCookieDough),
                new Object[] { EnumBaseItem.itemCookieDough, Item.sugar });

        GameRegistry.addShapelessRecipe(new ItemStack(EnumBaseItem.itemChocolateChips),
                new Object[] { EnumBaseItem.itemChocolatePaste, Item.sugar });
    }

    /**
     * Adds all Shaped the recipes in the Mod.
     */
    private static void addShaped() {
        GameRegistry.addShapedRecipe(new ItemStack(EnumBaseItem.itemBreadPan), new Object[] {
                "T   T", "T T", "TTT", 'T', EnumBaseItem.itemAluminumSheet });

        GameRegistry.addShapedRecipe(new ItemStack(EnumBaseItem.itemCakePan), new Object[] { "   ",
                "T T", "TTT", 'T', EnumBaseItem.itemAluminumSheet });

        GameRegistry.addShapedRecipe(new ItemStack(EnumBaseItem.gStone), new Object[] { "SSS",
                "SLS", "SSS", 'S', Block.stone, 'L', Block.wood });

        GameRegistry.addShapedRecipe(new ItemStack(EnumBaseItem.itemCookieSheet), new Object[] {
                "   ", "TTT", "TTT", 'T', EnumBaseItem.itemAluminumSheet });
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

    /**
     * Adds all the non Crafting related recipes in the Mod.
     */
    private static void modRecipes() {
        addGrinder();

        addOven();
    }

    private static void addGrinder() {
        GrinderRecipes.grinding().addGrinding(Item.wheat, new ItemStack(EnumBaseItem.itemFlour));

        GrinderRecipes.grinding().addGrinding(new ItemStack(Item.dyePowder, 1, 4),
                BaseItemEnum(EnumBaseItem.itemChocolatePaste));

        GrinderRecipes.grinding().addGrinding(Item.reed, new ItemStack(Item.sugar));
    }

    private static void addOven() {
        OvenRecipes.cooking().addCookingRecipe(EnumBaseItem.itemUncookedBread,
                new ItemStack(Item.bread), new ItemStack(EnumBaseItem.itemBreadPan));

        OvenRecipes.cooking().addCookingRecipe(EnumBaseItem.itemUncookedPotato,
                new ItemStack(Item.bakedPotato));

        OvenRecipes.cooking().addCookingRecipe(BaseItemEnum(EnumBaseItem.itemUncookedCake),
                new ItemStack(Item.cake), BaseItemEnum(EnumBaseItem.itemCakePan));

        OvenRecipes.cooking().addCookingRecipe(BaseItemEnum(EnumBaseItem.itemUncookedCookies),
                new ItemStack(Item.cookie, 16), BaseItemEnum(EnumBaseItem.itemCookieSheet));

        OvenRecipes.cooking().addCookingRecipe(BaseItemEnum(EnumBaseItem.itemUncookedPumpkinPie),
                new ItemStack(Item.pumpkinPie), BaseItemEnum(EnumBaseItem.itemPiePan));

        OvenRecipes.cooking().addCookingRecipe(BaseItemEnum(EnumBaseItem.itemUncookedSugarCookies),
                BaseFoodEnum(EnumBaseItem.foodSugarCookie, 16),
                BaseItemEnum(EnumBaseItem.itemCookieSheet));

        OvenRecipes.cooking().addCookingRecipe(BaseItemEnum(EnumBaseItem.itemUncookedChocolateChipCookies),
                BaseFoodEnum(EnumBaseItem.foodChocolateChipCookie, 16),
                BaseItemEnum(EnumBaseItem.itemCookieSheet);

        OvenRecipes.cooking().addCookingRecipe(BaseItemEnum(EnumBaseItem.itemPumpkinMash),
                new ItemStack(Block.pumpkin));
    }
}