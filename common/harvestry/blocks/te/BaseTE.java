package harvestry.blocks.te;

import harvestry.utils.Archive;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;

public class BaseTE extends TileEntity {

    private ForgeDirection orientation;
    private short state;
    private String owner;
    private String customName;

    public BaseTE() {

        orientation = ForgeDirection.SOUTH;
        state = 0;
        owner = "";
        customName = "";
    }

    public ForgeDirection getOrientation() {

        return orientation;
    }

    public void setOrientation(ForgeDirection orientation) {

        this.orientation = orientation;
    }

    public void setOrientation(int orientation) {

        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState() {

        return state;
    }

    public void setState(short state) {

        this.state = state;
    }

    public String getOwner() {

        return owner;
    }

    public boolean hasOwner() {

        return (owner != null) && (owner.length() > 0);
    }

    public void setOwner(String owner) {

        this.owner = owner;
    }

    public boolean hasCustomName() {

        return (customName != null) && (customName.length() > 0);
    }

    public String getCustomName() {

        return customName;
    }

    public void setCustomName(String customName) {

        this.customName = customName;
    }

    public boolean isUseableByPlayer(EntityPlayer player) {

        return player.getDistance(xCoord, yCoord, zCoord) <= 10;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {

        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(Archive.NBT_TE_Direction)){
            orientation = ForgeDirection.getOrientation(nbtTagCompound
                    .getByte(Archive.NBT_TE_Direction));
        }

        if (nbtTagCompound.hasKey(Archive.NBT_TE_State)){
            state = nbtTagCompound.getShort(Archive.NBT_TE_State);
        }

        if (nbtTagCompound.hasKey(Archive.NBT_TE_Owner)){
            owner = nbtTagCompound.getString(Archive.NBT_TE_Owner);
        }

        if (nbtTagCompound.hasKey(Archive.NBT_TE_Custom_Name)){
            customName = nbtTagCompound.getString(Archive.NBT_TE_Custom_Name);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {

        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte(Archive.NBT_TE_Direction, (byte) orientation.ordinal());
        nbtTagCompound.setShort(Archive.NBT_TE_State, state);

        if (hasOwner()){
            nbtTagCompound.setString(Archive.NBT_TE_Owner, owner);
        }

        if (this.hasCustomName()){
            nbtTagCompound.setString(Archive.NBT_TE_Custom_Name, customName);
        }
    }

    /*
     * @Override
     * public Packet getDescriptionPacket() {
     * return PacketTypeHandler.populatePacket(new PacketTileUpdate(xCoord,
     * yCoord, zCoord, orientation, state, owner, customName));
     * }
     */

}