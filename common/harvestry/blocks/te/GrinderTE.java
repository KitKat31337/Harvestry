package harvestry.blocks.te;

import harvestry.utils.Archive;
import harvestry.utils.FunctionHelper;
import net.minecraft.nbt.NBTTagCompound;

public class GrinderTE extends BaseTE {

    private static int invSize = 4;

    /**
     * Creates a new {@link GrinderTE} Instance.
     */
    public GrinderTE() {
        super(invSize, Archive.grinderUnloc);
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