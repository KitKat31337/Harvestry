package claycorp.betterfood.utils;

import claycorp.betterfood.items.ModItems;
import claycorp.betterfood.utils.handlers.RecipeHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {
    public static void register() {

        registerBlocks();

        registerItems();

        RecipeHandler.add();
    }

    private static void registerBlocks() {

    //    GameRegistry.registerBlock(ModBlocks.portalObsidian, "Obsidiatal");
    }

    private static void registerItems() {

        GameRegistry.registerItem(ModItems.itemBreadPan, "Boom Stick");

        GameRegistry.registerItem(ModItems.itemBreadpanwithDough, "Phantom Sword");

        GameRegistry.registerItem(ModItems.itemCakeBatter, "Lucidity");

        GameRegistry.registerItem(ModItems.itemCakePan, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.itemCakePanFull, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.itemChocolateChips, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.itemCookieSheet, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.itemDough, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.itemModBucket, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.foodPeanuts, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.itemPiePan, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.itemPumpkinMash, "Sparking Sapling");
        
        GameRegistry.registerItem(ModItems.itemPoisonousPeanut, "Sparking Sapling");
        
     //   GameRegistry.registerItem(ModItems.PoisoousPeanut, "Sparking Sapling");
        
      //  GameRegistry.registerItem(ModItems.PosonousPeanut, "Sparking Sapling");
    }

}
