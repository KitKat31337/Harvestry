package harvestry.blocks.gui;

import harvestry.blocks.container.GrinderContainer;
import harvestry.blocks.te.GrinderTE;
import harvestry.utils.Archive;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GUIGrinder extends GuiContainer {

    private GrinderTE grinder;

    /**
     * Creates the Grinders GUI
     * 
     * @param player
     *            The Player looking at the GUI
     * @param grinder
     *            The {@link GrinderTE} instance that the player is looking at.
     */
    public GUIGrinder(InventoryPlayer player, GrinderTE grinder) {
        super(new GrinderContainer(player, grinder));
        this.grinder = grinder;
    }

    /**
     * Draw the Foreground layer for the GuiContainer (everything in front of
     * the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {
        String containerName;
        if (grinder.isInvNameLocalized()){
            containerName = grinder.getInvName();
        }else{
            containerName = StatCollector.translateToLocal(grinder.getInvName());
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
        this.mc.renderEngine.bindTexture(Archive.grinderGUI);
        int xStart = (width - xSize) / 2;
        int yStart = (height - ySize) / 2;
        this.drawTexturedModalRect(xStart, yStart, 0, 0, xSize, ySize);
    }
}