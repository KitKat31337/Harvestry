package harvestry.blocks.te;

import harvestry.api.OvenRecipes;
import harvestry.utils.Archive;
import harvestry.utils.FunctionHelper;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class OvenTE extends BaseTE {

    /** The number of ticks that the grinder will keep grinding */
    public int cookingTime = 0;

    /** The number of ticks that the current item has been grinding for */
    public int cookTime = 0;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would
     * keep the furnace burning for
     */
    public int currentItemCookTime = 0;

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

    @Override
    public void updateEntity() {
        boolean flag = this.cookingTime > 0;
        boolean flag1 = false;

        if (this.cookingTime > 0){
            --this.cookingTime;
        }

        if (!this.worldObj.isRemote){
            if ((this.cookingTime == 0) && this.canCook()){
                this.currentItemCookTime = this.cookingTime = getItemCookTime(this.inventory[1]);

                if (this.cookingTime > 0){
                    flag1 = true;
                }
            }
        }

        if (this.isBurning() && this.canCook()){
            ++this.cookTime;

            if (this.cookTime == 200){
                this.cookTime = 0;
                this.cookItem();
                flag1 = true;
            }
        }else{
            this.cookTime = 0;
        }

        if (flag != (this.cookingTime > 0)){
            flag1 = true;
        }

        if (flag1){
            this.onInventoryChanged();
        }
    }

    private int getItemCookTime(ItemStack itemStack) {
        if (itemStack != null){
            int result;
            Random rand = new Random();
            EntityPlayer player = null;
            if (rand.nextInt(100) > 51){
                itemStack.damageItem(rand.nextInt(3) + 1, player);
                result = itemStack.getItemDamage();
                return result;
            }
        }
        return 0;
    }

    /**
     * Returns true if the oven can cook an item, i.e. has a source item,
     * destination stack isn't full, etc.
     */
    private boolean canCook() {
        if (this.inventory[0] == null){
            return false;
        }else{
            ItemStack itemstack = OvenRecipes.cooking().getCookingResult(this.inventory[0]);
            if (itemstack == null){
                return false;
            }
            if (this.inventory[2] == null){
                return true;
            }
            if (!this.inventory[2].isItemEqual(itemstack)){
                return false;
            }
            int result = inventory[2].stackSize + itemstack.stackSize;
            return ((result <= getInventoryStackLimit()) && (result <= itemstack.getMaxStackSize()));
        }
    }

    /**
     * Turn one item from the oven source stack into the appropriate cooked
     * item in the furnace result stack
     */
    public void cookItem() {
        if (this.canCook()){
            ItemStack itemstack = OvenRecipes.cooking().getCookingResult(this.inventory[0]);

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

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning() {
        return this.cookingTime > 0;
    }
}