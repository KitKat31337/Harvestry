package claycorp.betterfood;

import net.minecraft.creativetab.CreativeTabs;
import claycorp.betterfood.blocks.ModBlocks;
import claycorp.betterfood.items.ModItems;
import claycorp.betterfood.utils.Archive;
import claycorp.betterfood.utils.Config;
import claycorp.betterfood.utils.Registry;
import claycorp.betterfood.utils.handlers.Handler;
import claycorp.betterfood.utils.handlers.LanguageHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Archive.id, name = Archive.modName, version = Archive.ver)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class BetterFood {

    @Instance(Archive.id)
    public static BetterFood instance;

    // Declares a new Creative Tab
    public static CreativeTabs tabBetterFood = new BetterFoodTabs(CreativeTabs.getNextID(),
            Archive.tabBetterFood);

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