package harvestry.blocks.te;

import harvestry.utils.Archive;
import harvestry.utils.FunctionHelper;
import net.minecraft.nbt.NBTTagCompound;

public class OvenTE extends BaseTE {

    private static int invSize = 4;

    /**
     * Creates a new {@link OvenTE} Instance.
     */
    public OvenTE() {
        super(invSize, Archive.ovenUnloc);
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        setInventory(FunctionHelper
                .readInventoryFromNBT(nbt.getTagList(Archive.inventory), invSize));
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