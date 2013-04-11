package harvestry.blocks;

import harvestry.Harvestry;
import harvestry.utils.Archive;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BaseBlock extends Block {

    /**
     * Creates a new Block Instance.
     * 
     * @param id
     *            The Block ID
     */
    public BaseBlock(int id) {
        super(id, Material.ground);
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
    public BaseBlock(int id, Material material) {
        super(id, material);
        this.setCreativeTab(Harvestry.tabHarvestry);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}