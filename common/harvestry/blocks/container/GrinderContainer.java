package harvestry.blocks.container;

import harvestry.blocks.te.GrinderTE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class GrinderContainer extends BaseContainer {

    /**
     * Creates the Container for the Grinders GUI
     * 
     * @param player
     *            The Player looking at the GUI
     * @param grinder
     *            The {@link GrinderTE} instance that the player is looking at.
     */
    public GrinderContainer(InventoryPlayer player, GrinderTE grinder) {
        super(player, grinder, 8, 84, 142);
        // Top Slot
        this.addSlotToContainer(new Slot(grinder, 0, 80, 21));
        // Bottom Slot
        this.addSlotToContainer(new Slot(grinder, 1, 80, 57));
        // Left Hand Slot
        this.addSlotToContainer(new Slot(grinder, 2, 53, 39));
        // Right Hand Slot
        this.addSlotToContainer(new Slot(grinder, 3, 107, 39));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        return null;
    }
}