package harvestry.utils;

import harvestry.Harvestry;
import harvestry.blocks.ModBlocks;
import harvestry.blocks.te.GrinderTE;
import harvestry.blocks.te.OvenTE;
import harvestry.items.ModItems;
import harvestry.utils.handlers.Handler;
import harvestry.utils.handlers.RecipeHandler;
import harvestry.utils.worldgen.WorldGenHandler;

import java.util.logging.Level;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Registry {

    /**
     * Registers everything that needs to be Registered.
     */
    public static void register() {

        // Registers the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(Harvestry.instance, Harvestry.proxy);

        registerTE();

        registerItems();

        registerBlocks();

        registerWorld();

        oreDictionary();

        RecipeHandler.init();
    }

    /**
     * Registers all the {@link TileEntity}s.
     */
    private static void registerTE() {
        Handler.log(Level.INFO, "Registering Tile Entities");

        GameRegistry.registerTileEntity(GrinderTE.class, "te." + Archive.grinderUnloc);
        GameRegistry.registerTileEntity(OvenTE.class, "te." + Archive.ovenUnloc);
    }

    /**
     * Registers all the Items.
     */
    private static void registerItems() {
        Handler.log(Level.INFO, "Registering Items");

        GameRegistry.registerItem(ModItems.itemBreadPan, Archive.itemBreadPan);

        GameRegistry.registerItem(ModItems.itemUncookedBread, Archive.itemUncookedBread);

        GameRegistry.registerItem(ModItems.itemCakeBatter, Archive.itemCakeBatter);

        GameRegistry.registerItem(ModItems.itemCakePan, Archive.itemCakePan);

        GameRegistry.registerItem(ModItems.itemUncookedCake, Archive.itemUncookedCake);

        GameRegistry.registerItem(ModItems.itemChocolateChips, Archive.itemChocolateChips);

        GameRegistry.registerItem(ModItems.itemCookieSheet, Archive.itemCookieSheet);

        GameRegistry.registerItem(ModItems.itemDough, Archive.itemDough);

        GameRegistry.registerItem(ModItems.itemBowl, Archive.itemBowl);

        GameRegistry.registerItem(ModItems.foodPeanuts, Archive.foodPeanuts);

        GameRegistry.registerItem(ModItems.foodScrambledEggs, Archive.foodScrambledEggs);

        GameRegistry.registerItem(ModItems.itemPiePan, Archive.itemPiePan);

        GameRegistry.registerItem(ModItems.itemAluminumSheet, Archive.itemAluminumSheet);

        GameRegistry.registerItem(ModItems.itemAluminumFoil, Archive.itemAluminumFoil);

        GameRegistry.registerItem(ModItems.itemPureAluminum, Archive.itemPureAluminum);

        GameRegistry.registerItem(ModItems.gStone, Archive.itemGrindStone);

        GameRegistry.registerItem(ModItems.itemGrindStones, Archive.itemGrindStones);

        GameRegistry.registerItem(ModItems.itemUncookedPotato, Archive.itemUncookedPotato);

        GameRegistry.registerItem(ModItems.itemCookieDough, Archive.itemCookieDough);

        GameRegistry.registerItem(ModItems.itemChocolateChipCookieDough,
                Archive.itemChocolateChipCookieDough);

        GameRegistry.registerItem(ModItems.itemPumpkinPieFilling, Archive.itemPumpkinPieFilling);

        GameRegistry.registerItem(ModItems.itemChocolatePaste, Archive.itemChocolatePaste);

        GameRegistry.registerItem(ModItems.itemPieCrust, Archive.itemPieCrust);

        GameRegistry.registerItem(ModItems.itemUncookedPumpkinPie, Archive.itemUncookedPumpkinPie);

        GameRegistry.registerItem(ModItems.itemUncookedSugarCookies,
                Archive.itemUncookedSugarCookies);

        GameRegistry.registerItem(ModItems.itemUncookedChocolateChipCookies,
                Archive.itemUncookedChocolateChipCookies);

        GameRegistry.registerItem(ModItems.itemUncookedCookies, Archive.itemUncookedCookies);

        GameRegistry
                .registerItem(ModItems.foodChocolateChipCookie, Archive.foodChocolateChipCookie);

        GameRegistry.registerItem(ModItems.foodCookie, Archive.foodCookie);

        GameRegistry.registerItem(ModItems.foodSugarCookie, Archive.foodSugarCookie);

        GameRegistry.registerItem(ModItems.itemSugarCookieDough, Archive.itemSugarCookieDough);

    }

    /**
     * Registers all the Blocks.
     */
    private static void registerBlocks() {
        Handler.log(Level.INFO, "Registering Blocks");

        GameRegistry.registerBlock(ModBlocks.oreAluminum, Archive.oreAluminum);
        GameRegistry.registerBlock(ModBlocks.blockGrinder, Archive.blockGrinder);
        GameRegistry.registerBlock(ModBlocks.blockOven, Archive.blockOven);
    }

    /**
     * Registers all the World Generation.
     */
    private static void registerWorld() {
        if (Config.enableWorldGenAluminum){
            Handler.log(Level.INFO, "Registering World Generation for Aluminum");
            final WorldGenHandler worldGenAlu = new WorldGenHandler(Config.oreAluminumID,
                    Config.aluMaxHeight, Config.aluMinHeight);
            GameRegistry.registerWorldGenerator(worldGenAlu);
        }
    }

    /**
     * Registers all the Entries to the Ore Dictionary.
     */
    private static void oreDictionary() {
        Handler.log(Level.INFO, "Adding Ore Dictionary Entries");
        OreDictionary.registerOre("dustWheat", ModItems.itemFlour);
        OreDictionary.registerOre("naturalAluminum", ModBlocks.oreAluminum);
        OreDictionary.registerOre("oreNaturalAluminium", ModBlocks.oreAluminum);
    }
}