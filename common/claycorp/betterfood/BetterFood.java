package claycorp.betterfood;

import claycorp.betterfood.utils.RecipeHandler;
import claycorp.betterfood.utils.Registry;
import claycorp.betterfood.items.ModItems;
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

    @Instance(Registry.id)
    public static BetterFood instance;

    @PreInit
    public void preInit(FMLPreInitializationEvent evt) {
        ModItems.init();
        
    }

    @Init
    public void init(FMLInitializationEvent event) {
        RecipeHandler.add();
    }

}
