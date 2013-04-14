package harvestry;

import harvestry.blocks.ModBlocks;
import harvestry.items.ModItems;
import harvestry.sided.packet.PacketHandler;
import harvestry.sided.proxy.CommonProxy;
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
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Archive.id, name = Archive.modName, version = Archive.ver, useMetadata = true, dependencies = Archive.depend)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class Harvestry {

    @Instance(Archive.id)
    public static Harvestry instance;

    @SidedProxy(serverSide = Archive.serverProxy, clientSide = Archive.clientProxy)
    public static CommonProxy proxy;

    // Declares a new Creative Tab
    public static CreativeTabs tabHarvestry = new HarvestryTabs(CreativeTabs.getNextID(),
            Archive.tabHarvestry);

    @PreInit
    public void preInit(FMLPreInitializationEvent evt) {

        if (!Handler.isModLoaded()){

            Handler.initLog();

            Config.init(evt);

            ModItems.init();

            ModBlocks.init();

            LanguageHandler.loadLanguages();

            Handler.LoadMod();
        }
    }

    @Init
    public void init(FMLInitializationEvent event) {

        Registry.register();

        proxy.initCapes();
    }
}