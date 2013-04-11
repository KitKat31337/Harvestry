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

    public GrinderTE() {
        inventory = new ItemStack[3];
    }
    
    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        inventory = FunctionHelper.readInventoryFromNBT(nbt.getTagList(Archive.inventory), 10);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setTag(Archive.inventory, FunctionHelper.writeInventoryToNBT(inventory));
    }

    @Override
    public int getSizeInventory() {
        // TODO Auto-generated method stub
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        // TODO Auto-generated method stub
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        // TODO Auto-generated method stub
        return FunctionHelper.decrStackSize(i, j, inventory, this);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub

    }

    @Override
    public String getInvName() {
        // TODO Auto-generated method stub
        return Archive.grinderUnloc;
    }

    @Override
    public boolean isInvNameLocalized() {
        // TODO Auto-generated method stub
        return this.hasCustomName();
    }

    @Override
    public int getInventoryStackLimit() {
        // TODO Auto-generated method stub
        return 64;
    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    // Useless
    public void openChest() {}

    @Override
    // Useless
    public void closeChest() {}
}