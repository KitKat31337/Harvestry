package harvestry.blocks.container;

import harvestry.blocks.te.GrinderTE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

public class GrinderContainer extends Container {
    private GrinderTE grinder;

    public GrinderContainer(InventoryPlayer player, GrinderTE grinder) {

        this.grinder = grinder;
        this.addSlotToContainer(new Slot(grinder, 0, -15, 36));
        this.addSlotToContainer(new Slot(grinder, 1, 36, 36));
        this.addSlotToContainer(new Slot(grinder, 2, 79, 36));
        this.addSlotToContainer(new Slot(grinder, 3, 122, 36));

        int i;

        // players inventory
        for (i = 0; i < 3; ++i){
            for (int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 7 + j * 18, 97 + i * 18));
            }
        }

        // players quickBar
        for (i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(player, i, 7 + i * 18, 155));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return grinder.isUseableByPlayer(entityplayer);
    }
}