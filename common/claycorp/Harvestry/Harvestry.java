package claycorp.Harvestry;

import net.minecraft.creativetab.CreativeTabs;
import claycorp.Harvestry.blocks.ModBlocks;
import claycorp.Harvestry.items.ModItems;
import claycorp.Harvestry.utils.Archive;
import claycorp.Harvestry.utils.Config;
import claycorp.Harvestry.utils.Registry;
import claycorp.Harvestry.utils.handlers.Handler;
import claycorp.Harvestry.utils.handlers.LanguageHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Archive.id, name = Archive.modName, version = Archive.ver)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Harvestry {

    @Instance(Archive.id)
    public static Harvestry instance;

    // Declares a new Creative Tab
    public static CreativeTabs tabHarvestry = new HarvestryTabs(CreativeTabs.getNextID(),
            Archive.tabHarvestry);

    @PreInit
    public void preInit(FMLPreInitializationEvent evt) {

        boolean modLoaded = Handler.isModLoaded();

        if (!modLoaded){

            Handler.initLog();

            // Loads the Configuration
            Config.init(evt);

            // Initialize Items
            ModItems.init();

            // Initialize Blocks
            ModBlocks.init();

            // Load Languages
            LanguageHandler.loadLanguages();

            // Loads the Mod
            Handler.LoadMod();
        }
    }

    @Init
    public void init(FMLInitializationEvent event) {
        // Loads Registry stuff
        Registry.register();
    }
}