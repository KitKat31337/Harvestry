package harvestry.sided.packet;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class HandlerServer extends HandlerBase {

    @Override
    protected void doAction(EntityPlayerMP player, PacketHBase packet) {
        World world = player.worldObj;

        packet.actionServer(world, player);

    }
}