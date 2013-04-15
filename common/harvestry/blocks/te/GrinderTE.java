package harvestry.blocks.te;

import harvestry.api.GrinderRecipes;
import harvestry.utils.Archive;
import harvestry.utils.FunctionHelper;
import net.minecraft.item.ItemStack;
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

    /**
     * Returns true if the grinder can grind an item, i.e. has a source item,
     * destination stack isn't full, etc.
     */
    private boolean canGrind() {
        if (this.inventory[0] == null){
            return false;
        }else{
            ItemStack itemstack = GrinderRecipes.grinding().getGrindingResult(this.inventory[0]);
            if (itemstack == null)
                return false;
            if (this.inventory[2] == null)
                return true;
            if (!this.inventory[2].isItemEqual(itemstack))
                return false;
            int result = inventory[2].stackSize + itemstack.stackSize;
            return (result <= getInventoryStackLimit() && result <= itemstack.getMaxStackSize());
        }
    }

    /**
     * Turn one item from the grinder source stack into the appropriate ground
     * item in the furnace result stack
     */
    public void grindItem() {
        if (this.canGrind()){
            ItemStack itemstack = GrinderRecipes.grinding().getGrindingResult(this.inventory[0]);

            if (this.inventory[2] == null){
                this.inventory[2] = itemstack.copy();
            }else if (this.inventory[2].isItemEqual(itemstack)){
                inventory[2].stackSize += itemstack.stackSize;
            }

            --this.inventory[0].stackSize;

            if (this.inventory[0].stackSize <= 0){
                this.inventory[0] = null;
            }
        }
    }
}