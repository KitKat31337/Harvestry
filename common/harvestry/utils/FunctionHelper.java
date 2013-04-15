package harvestry.utils;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenDesert;

public abstract class FunctionHelper {

    private static final String slot = "slot";

    private FunctionHelper() {}

    /**
     * Reads a Inventory from a NBTTagList.
     * 
     * @param list
     *            The Name of the NBTTagList to read from.
     * @param size
     *            The size of the Inventory.
     * @return The Items on the inventory.
     */
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

    /**
     * Writes a inventory to a NBTTagList.
     * 
     * @param stacks
     *            The stacks in the current inventory to add to the NBTTagList.
     * @return The NBTTagList associated to the inventory.
     */
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

    /**
     * Decreases the {@link ItemStack} size in a slot.
     * 
     * @param slot
     *            The Slot where the {@link ItemStack} can be found.
     * @param amount
     *            The amount to subtract.
     * @param stacks
     *            The {@link ItemStack} to subtract from.
     * @param inventory
     *            The inventory (A class implementing {@link IInventory})
     * @return The new {@link ItemStack}.
     */
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

    /**
     * Checks if the sun is visible.
     * 
     * @param world
     *            The world to check in.
     * @param xCoord
     *            The X coordinate to check in.
     * @param yCoord
     *            The Y coordinate to check in.
     * @param zCoord
     *            The Z coordinate to check in.
     * @return true if the sun is visible. Otherwise false.
     */
    public static boolean isSunVisible(World world, int xCoord, int yCoord, int zCoord) {
        return world.isDaytime()
                && !world.provider.hasNoSky
                && world.canBlockSeeTheSky(xCoord, yCoord, zCoord)
                && ((world.getWorldChunkManager().getBiomeGenAt(xCoord, zCoord) instanceof BiomeGenDesert) || (!world
                        .isRaining() && !world.isThundering()));
    }
}