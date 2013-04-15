package harvestry.blocks.container;

import harvestry.blocks.container.slots.OutputSlot;
import harvestry.blocks.container.slots.UseSlot;
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
        // Left Hand Slot (Input)
        this.addSlotToContainer(new Slot(grinder, 0, 53, 39));
        // Top Slot (Grinding)
        this.addSlotToContainer(new UseSlot(grinder, 1, 80, 21));
        // Bottom Slot (Grinding)
        this.addSlotToContainer(new UseSlot(grinder, 2, 80, 57));
        // Right Hand Slot (Output)
        this.addSlotToContainer(new OutputSlot(grinder, 3, 107, 39));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        return null;
    }
}