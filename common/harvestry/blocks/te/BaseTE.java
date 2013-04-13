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

    /**
     * Creates a new {@link BaseTE} Instance.
     */
    public BaseTE() {

        orientation = ForgeDirection.SOUTH;
        state = 0;
        owner = "";
        customName = "";
    }

    /**
     * Gets the {@link TileEntity}'s Orientation.
     * 
     * @return The {@link TileEntity}'s Orientation.
     */
    public ForgeDirection getOrientation() {

        return orientation;
    }

    /**
     * Sets the {@link TileEntity}'s Orientation.
     */
    public void setOrientation(ForgeDirection orientation) {

        this.orientation = orientation;
    }

    /**
     * Sets the {@link TileEntity}'s Orientation to a {@link ForgeDirection}
     * Orientation value.
     * 
     * @param orientation
     *            The {@link ForgeDirection} Orientation value.
     */
    public void setOrientation(int orientation) {

        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    /**
     * Gets the {@link TileEntity}'s State.
     * 
     * @return The {@link TileEntity}'s State.
     */
    public short getState() {

        return state;
    }

    /**
     * Sets the {@link TileEntity}'s State to a {@link short} value.
     * 
     * @param state
     *            The {@link short} State value, that you want the
     *            {@link TileEntity} to have.
     * @return state
     *         The {@link short} State value.
     */
    public void setState(short state) {

        this.state = state;
    }

    /**
     * Gets the {@link TileEntity}'s Owner.
     * 
     * @return The {@link TileEntity}'s Owner.
     */
    public String getOwner() {

        return owner;
    }

    /**
     * Checks if the {@link TileEntity} has a Owner.
     * 
     * @return true if the {@link TileEntity} has a Owner.
     */
    public boolean hasOwner() {

        return (owner != null) && (owner.length() > 0);
    }

    /**
     * Sets the Owner of the {@link TileEntity}.
     * 
     * @param owner
     *            A {@link String} with the Owners Name.
     */
    public void setOwner(String owner) {

        this.owner = owner;
    }

    /**
     * Checks if the {@link TileEntity} has a Custom Name.
     * 
     * @return true if the {@link TileEntity} has a Custom Name.
     */
    public boolean hasCustomName() {

        return (customName != null) && (customName.length() > 0);
    }

    /**
     * Gets the {@link TileEntity}'s Custom Name.
     * 
     * @return the {@link TileEntity}'s Custom Name.
     */
    public String getCustomName() {

        return customName;
    }

    /**
     * Sets the {@link TileEntity}'s Custom Name.
     * 
     * @param customName
     *            A {@link String} with the {@link TileEntity}'s Custom Name.
     */
    public void setCustomName(String customName) {

        this.customName = customName;
    }

    /**
     * Checks if the {@link TileEntity} is Usable By a Player.
     * 
     * @param player
     *            The player that is using the {@link TileEntity}.
     * @return true if the player is within 10 blocks.
     */
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