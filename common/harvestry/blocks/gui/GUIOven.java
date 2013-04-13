package harvestry.blocks.gui;

import harvestry.blocks.container.OvenContainer;
import harvestry.blocks.te.OvenTE;
import harvestry.utils.Archive;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GUIOven extends GuiContainer {

    private OvenTE oven;

    /**
     * Creates the Oven's GUI
     * 
     * @param player
     *            The Player looking at the GUI
     * @param oven
     *            The {@link OvenTE} instance that the player is looking at.
     */
    public GUIOven(InventoryPlayer player, OvenTE oven) {
        super(new OvenContainer(player, oven));
        this.oven = oven;
    }

    /**
     * Draw the Foreground layer for the GuiContainer (everything in front of
     * the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String containerName;
        if (oven.isInvNameLocalized()){
            containerName = oven.getInvName();
        }else{
            containerName = StatCollector.translateToLocal(oven.getInvName());
        }
        fontRenderer.drawString(containerName,
                (xSize / 2) - (fontRenderer.getStringWidth(containerName) / 2), 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal(Archive.inventory), 9,
                (ySize - 96) + 2, 4210752);
    }

    /**
     * Draw the Background layer for the GuiContainer (everything in back of
     * the items)
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(Archive.ovenGUI);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}