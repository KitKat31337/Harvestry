package harvestry.sided.proxy;

import harvestry.blocks.te.BaseTE;
import harvestry.utils.Archive;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

import com.jadarstudios.api.developercapesapi.DeveloperCapesAPI;

import cpw.mods.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {

    /**
     * Initializes the Capes.
     * Original code that adds capes is found in this Github repository:
     * https://github.com/jadar/DeveloperCapesAPI
     */
    @Override
    public void initCapes() {
        // Link for the file that makes the capes work
        DeveloperCapesAPI.getInstance().init(Archive.capes);
    }

    @Override
    public void handleTileEntityPacket(int x, int y, int z, ForgeDirection orientation,
            short state, String owner, String customName) {

        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld
                .getBlockTileEntity(x, y, z);

        if (tileEntity != null){
            if (tileEntity instanceof BaseTE){
                ((BaseTE) tileEntity).setOrientation(orientation);
                ((BaseTE) tileEntity).setState(state);
                ((BaseTE) tileEntity).setOwner(owner);
                ((BaseTE) tileEntity).setCustomName(customName);
            }
        }
    }
}