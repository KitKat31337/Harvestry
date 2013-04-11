package claycorp.betterfood.utils;

import net.minecraftforge.oredict.OreDictionary;
import claycorp.betterfood.blocks.ModBlocks;
import claycorp.betterfood.items.ModItems;
import claycorp.betterfood.utils.handlers.RecipeHandler;
import claycorp.betterfood.utils.handlers.WorldGenHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {

    private static WorldGenHandler worldGen = new WorldGenHandler();

    public static void register() {

        registerItems();
        
        registerBlocks();
        
        registerWorld();
        
        oreDictionary();

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

        GameRegistry.registerItem(ModItems.foodScrambledEggs, Archive.foodScrambledEggs);

        GameRegistry.registerItem(ModItems.itemPiePan, Archive.itemPiePan);

        GameRegistry.registerItem(ModItems.itemAluminumSheet, Archive.itemAluminumSheet);

        GameRegistry.registerItem(ModItems.itemAluminumFoil, Archive.itemAluminumFoil);

        GameRegistry.registerItem(ModItems.itemRawAluminum, Archive.itemRawAluminum);

        GameRegistry.registerItem(ModItems.itemGrindStone, Archive.itemGrindStone);

        GameRegistry.registerItem(ModItems.itemGrindStones, Archive.itemGrindStones);

        // GameRegistry.registerItem(ModItems.itemPoisonousPeanut,
        // Archive.foodPeanuts + "Poison");
    }

    private static void registerWorld() {
        GameRegistry.registerWorldGenerator(worldGen);
    }
    
    private static void oreDictionary() {
        OreDictionary.registerOre("dustWheat", ModItems.itemFlour);
        OreDictionary.registerOre("naturalAluminum", ModBlocks.oreAluminum);
        OreDictionary.registerOre("oreNaturalAluminium", ModBlocks.oreAluminum);
    }
}