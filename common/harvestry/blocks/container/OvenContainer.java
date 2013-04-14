package harvestry.blocks.container;

import harvestry.blocks.te.OvenTE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OvenContainer extends Container {

    private OvenTE oven;

    /**
     * Creates the Container for the Grinders GUI
     * 
     * @param player
     *            The Player looking at the GUI
     * @param grinder
     *            The {@link OvenTE} instance that the player is looking at.
     */
    public OvenContainer(InventoryPlayer player, OvenTE oven) {

        this.oven = oven;
        // Top Slot
        this.addSlotToContainer(new Slot(oven, 0, 80, 21));
        // Bottom Slot
        this.addSlotToContainer(new Slot(oven, 1, 80, 57));
        // Left Hand Slot
        this.addSlotToContainer(new Slot(oven, 2, 53, 39));
        // Right Hand Slot
        this.addSlotToContainer(new Slot(oven, 3, 107, 39));

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex){
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex){
                this.addSlotToContainer(new Slot(player, inventoryColumnIndex
                        + (inventoryRowIndex * 9) + 9, 8 + (inventoryColumnIndex * 18),
                        84 + (inventoryRowIndex * 18)));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex){
            this.addSlotToContainer(new Slot(player, actionBarSlotIndex,
                    8 + (actionBarSlotIndex * 18), 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return oven.isUseableByPlayer(entityplayer);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {
        return null;
    }
}