package claycorp.betterfood.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import claycorp.betterfood.BetterFood;
import claycorp.betterfood.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMod extends Block {

    /**
     * Creates a new Block Instance.
     * 
     * @param ID
     *            The Block ID
     */
    public BlockMod(int ID) {
        super(ID, Material.ground); // Parameters: Block ID
        this.setCreativeTab(BetterFood.tabBetterFood);
    }

    /**
     * Creates a new Block Instance.
     * 
     * @param ID
     *            The Block ID
     * @param material
     *            The Material
     */
    public BlockMod(int ID, Material material) {
        super(ID, material); // Parameters: Block ID, Block material
        this.setCreativeTab(BetterFood.tabBetterFood);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}