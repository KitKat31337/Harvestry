package harvestry.blocks.container.slots;

import harvestry.blocks.te.GrinderTE;
import harvestry.blocks.te.OvenTE;
import harvestry.items.BaseGrindStone;
import harvestry.items.BaseHeatingElements;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class UseSlot extends Slot {

    public UseSlot(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for
     * the armor slots.
     */
    @Override
    public boolean isItemValid(ItemStack item) {
        if (item.getItem() instanceof BaseGrindStone && inventory instanceof GrinderTE){
            return true;
        }else if (item.getItem() instanceof BaseHeatingElements && inventory instanceof OvenTE){
            return true;
        }else{
            return false;
        }
    }
}