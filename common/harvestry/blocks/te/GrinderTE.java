package harvestry.blocks.te;

import harvestry.api.GrinderRecipes;
import harvestry.utils.Archive;
import harvestry.utils.FunctionHelper;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class GrinderTE extends BaseTE {

    /** The number of ticks that the grinder will keep grinding */
    public int grindergGrindingTime = 0;

    /** The number of ticks that the current item has been grinding for */
    public int grinderCookTime = 0;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would
     * keep the furnace burning for
     */
    public int currentItemBurnTime = 0;

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

    public void updateEntity() {
        boolean flag = this.grindergGrindingTime > 0;
        boolean flag1 = false;

        if (this.grindergGrindingTime > 0){
            --this.grindergGrindingTime;
        }

        if (!this.worldObj.isRemote){
            if (this.grindergGrindingTime == 0 && this.canGrind()){
                this.currentItemBurnTime = this.grindergGrindingTime = getItemBurnTime(
                        this.inventory[1], this.inventory[2]);

                if (this.grindergGrindingTime > 0){
                    flag1 = true;
                }
            }
        }

        if (this.isBurning() && this.canGrind()){
            ++this.grinderCookTime;

            if (this.grinderCookTime == 200){
                this.grinderCookTime = 0;
                this.grindItem();
                flag1 = true;
            }
        }else{
            this.grinderCookTime = 0;
        }

        if (flag != this.grindergGrindingTime > 0){
            flag1 = true;
        }

        if (flag1){
            this.onInventoryChanged();
        }
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
            if (this.inventory[3] == null)
                return true;
            if (!this.inventory[3].isItemEqual(itemstack))
                return false;
            int result = inventory[3].stackSize + itemstack.stackSize;
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

            if (this.inventory[3] == null){
                this.inventory[3] = itemstack.copy();
            }else if (this.inventory[3].isItemEqual(itemstack)){
                inventory[3].stackSize += itemstack.stackSize;
            }

            --this.inventory[0].stackSize;

            if (this.inventory[0].stackSize <= 0){
                this.inventory[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the
     * furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack != null && itemStack2 != null){
            int result;
            Random rand = new Random();
            EntityPlayer player = null;
            if (rand.nextInt(100) > 51){
                itemStack.damageItem(rand.nextInt(3) + 1, player);
                result = itemStack.getItemDamage();
            }else{
                itemStack2.damageItem(rand.nextInt(3) + 1, player);
                result = itemStack2.getItemDamage();
            }
            return result;
        }else{
            return 0;
        }
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning() {
        return this.grindergGrindingTime > 0;
    }
}