package harvestry.utils;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public abstract class FunctionHelper {
    private static final String slot = "slot";

    private FunctionHelper() {}

    public static ItemStack[] readInventoryFromNBT(NBTTagList list, int size) {
        ItemStack[] stacks = new ItemStack[size];

        NBTTagCompound compound;
        int index;
        for (int i = 0; i < list.tagCount(); i++){
            compound = (NBTTagCompound) list.tagAt(i);
            index = compound.getInteger(slot);
            stacks[index] = ItemStack.loadItemStackFromNBT(compound);
        }

        return stacks;
    }

    public static NBTTagList writeInventoryToNBT(ItemStack[] stacks) {
        NBTTagCompound stackNBT;
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < stacks.length; i++){
            if (stacks[i] == null){
                continue;
            }

            stackNBT = new NBTTagCompound();
            stackNBT.setInteger(slot, i);
            stacks[i].writeToNBT(stackNBT);
            list.appendTag(stackNBT);
        }

        return list;
    }

    public static ItemStack decrStackSize(int slot, int amount, ItemStack[] stacks,
            IInventory inventory) {
        if (stacks[slot] != null){
            ItemStack itemstack;

            if (stacks[slot].stackSize <= amount){
                itemstack = stacks[slot];
                stacks[slot] = null;
                inventory.onInventoryChanged();
                return itemstack;
            }else{
                itemstack = stacks[slot].splitStack(amount);

                if (stacks[slot].stackSize == 0){
                    stacks[slot] = null;
                }

                inventory.onInventoryChanged();
                return itemstack;
            }
        }else{
            return null;
        }
    }
}