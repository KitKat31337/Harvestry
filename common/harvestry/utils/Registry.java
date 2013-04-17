package harvestry.utils;

import harvestry.Harvestry;
import harvestry.blocks.ModBlocks;
import harvestry.blocks.te.GrinderTE;
import harvestry.blocks.te.OvenTE;
import harvestry.items.ModItems;
import harvestry.items.enums.EnumBaseItem;
import harvestry.utils.handlers.Handler;
import harvestry.utils.handlers.RecipeHandler;
import harvestry.utils.worldgen.WorldGenHandler;

import java.util.logging.Level;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public final class Registry {

    /**
     * Registers everything that needs to be Registered.
     */
    public static void register() {

        // Registers the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(Harvestry.instance, Harvestry.proxy);

        registerTE();

        // registerItems();

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
            WorldGenHandler worldGenAlu = new WorldGenHandler(Config.oreAluminumID,
                    Config.aluMaxHeight, Config.aluMinHeight);
            GameRegistry.registerWorldGenerator(worldGenAlu);
        }
    }

    /**
     * Registers all the Entries to the Ore Dictionary.
     */
    private static void oreDictionary() {
        Handler.log(Level.INFO, "Adding Ore Dictionary Entries");
        OreDictionary.registerOre("dustWheat", new ItemStack(ModItems.mainItem.itemID, 1,
                EnumBaseItem.itemFlour.ordinal()));
        OreDictionary.registerOre("naturalAluminum", ModBlocks.oreAluminum);
        OreDictionary.registerOre("oreNaturalAluminium", ModBlocks.oreAluminum);
    }
}