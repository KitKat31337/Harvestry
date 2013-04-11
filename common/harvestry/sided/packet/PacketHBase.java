package harvestry.sided.packet;

import harvestry.utils.Archive;
import harvestry.utils.handlers.Handler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class PacketHBase {

    public PacketHBase() {
        // for other constructors.
    }

    /**
     * For reading packets off of the stream.
     * Another constructor is usually good as well.
     * 
     * @param stream
     */
    public PacketHBase(ObjectInputStream stream) throws IOException {
        // to be filled by something else...
    }

    public Packet250CustomPayload getPacket250() {
        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = Archive.channel;
        try{
            ByteArrayOutputStream array = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(array);
            stream.writeInt(this.getID());
            this.writeToStream(stream);
            stream.close();
            array.close();
            packet.data = array.toByteArray();
            packet.length = packet.data.length;

        }catch(Throwable t){
            Handler.log(Level.SEVERE, "Error sending SeaCraft packet! " + this.toString(), t);
        }

        return packet;
    }

    public abstract void writeToStream(ObjectOutputStream stream) throws IOException;

    public abstract int getID();

    @SideOnly(Side.CLIENT)
    public abstract void actionClient(World world, EntityPlayerMP player);

    public abstract void actionServer(World world, EntityPlayerMP player);
}