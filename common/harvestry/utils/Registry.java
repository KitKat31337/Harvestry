package harvestry.utils;

import harvestry.Harvestry;
import harvestry.blocks.ModBlocks;
import harvestry.blocks.te.GrinderTE;
import harvestry.items.ModItems;
import harvestry.utils.handlers.GuiHandler;
import harvestry.utils.handlers.Handler;
import harvestry.utils.handlers.RecipeHandler;
import harvestry.utils.worldgen.WorldGenHandler;

import java.util.logging.Level;

import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {

    public static void register() {

        NetworkRegistry.instance().registerGuiHandler(Harvestry.instance, new GuiHandler());

        registerTE();

        registerItems();

        registerBlocks();

        registerWorld();

        oreDictionary();

        RecipeHandler.init();
    }

    private static void registerTE() {
        Handler.log(Level.INFO, "Registering Tile Entities");

        GameRegistry.registerTileEntity(GrinderTE.class, Archive.grinderUnloc);
    }

    private static void registerItems() {
        Handler.log(Level.INFO, "Registering Items");

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

        GameRegistry.registerItem(ModItems.itemRawPotato, Archive.itemRawPotato);

        GameRegistry.registerItem(ModItems.itemCookieDough, Archive.itemCookieDough);

        GameRegistry.registerItem(ModItems.itemChocolateChipCookieDough,
                Archive.itemChocolateChipCookieDough);

        GameRegistry.registerItem(ModItems.itemPumpkinPieFilling, Archive.itemPumpkinPieFilling);

        GameRegistry.registerItem(ModItems.itemPieCrust, Archive.itemPieCrust);
    }

    private static void registerBlocks() {
        Handler.log(Level.INFO, "Registering Blocks");

        GameRegistry.registerBlock(ModBlocks.oreAluminum, Archive.oreAluminum);
        GameRegistry.registerBlock(ModBlocks.blockGrinder, Archive.blockGrinder);
    }

    private static void registerWorld() {
        if (Config.enableWorldGenAluminum){
            Handler.log(Level.INFO, "Registering World Generation for Aluminum");
            final WorldGenHandler worldGenAlu = new WorldGenHandler(Config.oreAluminumID,
                    Config.aMaxHeight, Config.aMinHeight);
            GameRegistry.registerWorldGenerator(worldGenAlu);
        }
    }

    private static void oreDictionary() {
        Handler.log(Level.INFO, "Adding Ore Dictionary Entries");
        OreDictionary.registerOre("dustWheat", ModItems.itemFlour);
        OreDictionary.registerOre("naturalAluminum", ModBlocks.oreAluminum);
        OreDictionary.registerOre("oreNaturalAluminium", ModBlocks.oreAluminum);
    }
}