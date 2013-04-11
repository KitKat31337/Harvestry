package claycorp.Harvestry.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import claycorp.Harvestry.Harvestry;
import claycorp.Harvestry.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMod extends Block {

    /**
     * Creates a new Block Instance.
     * 
     * @param id
     *            The Block ID
     */
    public BlockMod(int id) {
        super(id, Material.ground); // Parameters: Block ID
        this.setCreativeTab(Harvestry.tabHarvestry);
    }

    /**
     * Creates a new Block Instance.
     * 
     * @param id
     *            The Block ID
     * @param material
     *            The Material
     */
    public BlockMod(int id, Material material) {
        super(id, material); // Parameters: Block ID, Block material
        this.setCreativeTab(Harvestry.tabHarvestry);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}