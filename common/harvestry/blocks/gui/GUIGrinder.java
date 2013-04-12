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

    public GUIGrinder(InventoryPlayer player, GrinderTE grinder) {
        super(new GrinderContainer(player, grinder));
        this.grinder = grinder;
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of
     * the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String s = StatCollector.translateToLocal(this.grinder.getInvName());
        this.fontRenderer.drawString(s, (this.xSize / 2)
                - (this.fontRenderer.getStringWidth(s) / 2), 0, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8,
                (this.ySize - 83) + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(Archive.grinderGUI);
        int startX = ((this.width - this.xSize) / 2) - ((this.width - this.xSize) / 6);
        int startY = ((this.height - this.ySize) / 2) - ((this.height - this.ySize) / 6);

        int x = (int) (this.xSize * (256 / 176.0));
        int y = (int) (this.ySize * (191 / 165.0));

        this.drawTexturedModalRect(startX, startY, 0, 0, x, y);
    }
}