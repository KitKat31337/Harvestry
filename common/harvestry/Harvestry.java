package harvestry;

import harvestry.blocks.ModBlocks;
import harvestry.items.ModItems;
import harvestry.utils.Archive;
import harvestry.utils.Config;
import harvestry.utils.Registry;
import harvestry.utils.handlers.Handler;
import harvestry.utils.handlers.LanguageHandler;
import net.minecraft.creativetab.CreativeTabs;
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