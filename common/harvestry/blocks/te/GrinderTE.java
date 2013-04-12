package harvestry.blocks.te;

import harvestry.utils.Archive;
import harvestry.utils.FunctionHelper;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GrinderTE extends BaseTE implements IInventory {

    /**
     * The ItemStacks that hold the items currently being used in the Grinder
     */
    private ItemStack[] inventory;

    /**
     * Creates a new {@link GrinderTE} Instance.
     */
    public GrinderTE() {
        inventory = new ItemStack[4];
    }

    /**
     * Reads a tile entity from NBT.
     */
    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        inventory = FunctionHelper.readInventoryFromNBT(nbt.getTagList(Archive.inventory), 10);
    }

    /**
     * Writes a tile entity to NBT.
     */
    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setTag(Archive.inventory, FunctionHelper.writeInventoryToNBT(inventory));
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        return FunctionHelper.decrStackSize(i, j, inventory, this);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        // TODO
    }

    @Override
    public String getInvName() {
        return Archive.grinderUnloc;
    }

    @Override
    public boolean isInvNameLocalized() {
        return this.hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        return true;
    }

    // Useless
    @Override
    public void openChest() {}

    // Useless
    @Override
    public void closeChest() {}
}