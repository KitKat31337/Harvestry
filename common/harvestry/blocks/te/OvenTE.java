package harvestry.blocks.te;

import harvestry.utils.Archive;
import harvestry.utils.FunctionHelper;
import net.minecraft.nbt.NBTTagCompound;

public class OvenTE extends BaseTE {

    /**
     * Creates a new {@link OvenTE} Instance.
     */
    public OvenTE() {
        super(4, Archive.ovenUnloc);
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        setInventory(FunctionHelper.readInventoryFromNBT(nbt.getTagList(Archive.inventory), 10));
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setTag(Archive.inventory, FunctionHelper.writeInventoryToNBT(getInventory()));
    }
}