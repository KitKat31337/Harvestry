package harvestry.blocks.container;

import harvestry.blocks.te.OvenTE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OvenContainer extends BaseContainer {

    /**
     * Creates the Container for the Grinders GUI
     * 
     * @param player
     *            The Player looking at the GUI
     * @param grinder
     *            The {@link OvenTE} instance that the player is looking at.
     */
    public OvenContainer(InventoryPlayer player, OvenTE oven) {
        super(player, oven, 8, 84, 142);
        // Top Slot
        this.addSlotToContainer(new Slot(oven, 0, 80, 21));
        // Bottom Slot
        this.addSlotToContainer(new Slot(oven, 1, 80, 57));
        // Left Hand Slot
        this.addSlotToContainer(new Slot(oven, 2, 53, 39));
        // Right Hand Slot
        this.addSlotToContainer(new Slot(oven, 3, 107, 39));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        return null;
    }
}