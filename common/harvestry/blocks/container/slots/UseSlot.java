package harvestry.blocks.container.slots;

import harvestry.items.BaseGrindStone;
import harvestry.items.BaseHeatingElements;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class UseSlot extends Slot {

    public UseSlot(IInventory par1iInventory, int par2, int par3, int par4) {
        super(par1iInventory, par2, par3, par4);
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for
     * the armor slots.
     */
    @Override
    public boolean isItemValid(ItemStack item) {
        if (item.getItem() instanceof BaseGrindStone){
            return true;
        }else if (item.getItem() instanceof BaseHeatingElements){
            return true;
        }else{
            return false;
        }
    }
}