package claycorp.betterfood.utils;

import claycorp.betterfood.blocks.ModBlocks;
import claycorp.betterfood.items.ModItems;
import claycorp.betterfood.utils.handlers.RecipeHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {
    
    public static void register() {

        registerBlocks();

        registerItems();

        RecipeHandler.init();
    }

    private static void registerBlocks() {
        
        GameRegistry.registerBlock(ModBlocks.oreAluminum, Archive.oreAluminum);
    }

    private static void registerItems() {

        GameRegistry.registerItem(ModItems.itemBreadPan, Archive.itemBreadPan);

        GameRegistry.registerItem(ModItems.itemBreadpanwithDough, Archive.itemBreadpanwithDough);

        GameRegistry.registerItem(ModItems.itemCakeBatter, Archive.itemCakeBatter);

        GameRegistry.registerItem(ModItems.itemCakePan, Archive.itemCakePan);
        
        GameRegistry.registerItem(ModItems.itemCakePanFull, Archive.itemCakePanFull);
        
        GameRegistry.registerItem(ModItems.itemChocolateChips, Archive.itemChocolateChips);
        
        GameRegistry.registerItem(ModItems.itemCookieSheet, Archive.itemCookieSheet);
        
        GameRegistry.registerItem(ModItems.itemDough, Archive.itemDough);
        
        GameRegistry.registerItem(ModItems.itemModBucket, Archive.itemModBucket);
        
        GameRegistry.registerItem(ModItems.foodPeanuts, Archive.foodPeanuts);
        
        GameRegistry.registerItem(ModItems.itemPiePan, Archive.itemPiePan);
        
        GameRegistry.registerItem(ModItems.itemPumpkinMash, Archive.itemPumpkinMash);
        
        //GameRegistry.registerItem(ModItems.itemPoisonousPeanut, Archive.foodPeanuts + "Poison");
    }

}
