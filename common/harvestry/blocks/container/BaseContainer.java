package harvestry.blocks.container;

import harvestry.blocks.te.BaseTE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class BaseContainer extends Container {

    private BaseTE tileEntity;

    public BaseContainer(InventoryPlayer player, BaseTE tileEntity, int xAxis, int playerY,
            int quickY) {
        this.tileEntity = tileEntity;
        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex){
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex){
                this.addSlotToContainer(new Slot(player, inventoryColumnIndex
                        + (inventoryRowIndex * 9) + 9, xAxis + (inventoryColumnIndex * 18), playerY
                        + (inventoryRowIndex * 18)));
            }
        }

        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex){
            this.addSlotToContainer(new Slot(player, actionBarSlotIndex, xAxis
                    + (actionBarSlotIndex * 18), quickY));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return tileEntity.isUseableByPlayer(entityplayer);
    }
}