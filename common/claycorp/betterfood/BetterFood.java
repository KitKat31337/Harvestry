package claycorp.betterfood;

import net.minecraft.block.Block;
import claycorp.betterfood.items.ModItems;
import claycorp.betterfood.utils.Config;
import claycorp.betterfood.utils.Registry;
import claycorp.betterfood.utils.handlers.Handler;
import claycorp.betterfood.utils.handlers.LanguageHandler;
import claycorp.betterfood.utils.handlers.RecipeHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Registry.id, name = Registry.name, version = Registry.ver)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class BetterFood {

    public static Block oreAluminum;
    
    @Instance(Registry.id)
    public static BetterFood instance;

    @PreInit
    public void preInit(FMLPreInitializationEvent evt) {

        boolean modLoaded = Handler.isModLoaded();

        if (!modLoaded){

            Handler.logName("Loading configuration");
            
            //Loads the Configuration
            Config.init(evt);

            // Initialize Items
            ModItems.init();

            // Load Languages
            LanguageHandler.loadLanguages();
            
            Handler.LoadMod();
        }
    }

    @Init
    public void init(FMLInitializationEvent event) {
        
        RecipeHandler.delete();
        
        RecipeHandler.add();

    }
}