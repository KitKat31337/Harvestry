package harvestry.utils.handlers;

import harvestry.blocks.container.GrinderContainer;
import harvestry.blocks.gui.GUIGrinder;
import harvestry.blocks.te.GrinderTE;
import harvestry.utils.Archive;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case Archive.grinderGUID:
                GrinderTE grinder = (GrinderTE) world.getBlockTileEntity(x, y, z);
                return new GrinderContainer(player.inventory, grinder);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case Archive.grinderGUID:
                GrinderTE grinder = (GrinderTE) world.getBlockTileEntity(x, y, z);
                return new GUIGrinder(player.inventory, grinder);
            default:
                return null;
        }
    }
}