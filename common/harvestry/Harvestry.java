package harvestry;

import harvestry.blocks.ModBlocks;
import harvestry.items.ModItems;
import harvestry.sided.packet.HandlerClient;
import harvestry.sided.packet.HandlerServer;
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
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;

@Mod(modid = Archive.id, name = Archive.modName, version = Archive.ver)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, 
clientPacketHandlerSpec = @SidedPacketHandler(channels = { Archive.channel }, packetHandler = HandlerClient.class), 
serverPacketHandlerSpec = @SidedPacketHandler(channels = { Archive.channel }, packetHandler = HandlerServer.class))
public class Harvestry {

    @Instance(Archive.id)
    public static Harvestry instance;
    
    @SidedProxy(serverSide = Archive.serverProxy, clientSide = Archive.clientProxy)
    public static CommonProxy   proxy;
    
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
            
            proxy.initCapes();

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