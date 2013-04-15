package harvestry.blocks.container;

import harvestry.blocks.container.slots.OutputSlot;
import harvestry.blocks.container.slots.UseSlot;
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
        // Left Hand Slot (Input)
        this.addSlotToContainer(new Slot(oven, 0, 53, 39));
        // Bottom Slot (Heating)
        this.addSlotToContainer(new UseSlot(oven, 1, 53, 57));
        // Top Slot (Output 1)
        this.addSlotToContainer(new OutputSlot(oven, 2, 107, 21));
        // Right Hand Slot (Output 2)
        this.addSlotToContainer(new OutputSlot(oven, 3, 107, 39));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        return null;
    }
}