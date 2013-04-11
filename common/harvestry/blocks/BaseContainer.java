package harvestry.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import harvestry.Harvestry;
import harvestry.utils.Archive;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BaseContainer extends BlockContainer {

    TileEntity tileEntity;

    protected BaseContainer(int id, TileEntity te) {
        super(id, Material.ground);
        setCreativeTab(Harvestry.tabHarvestry);
        tileEntity = te;
    }

    protected BaseContainer(int id, Material material, TileEntity te) {
        super(id, material);
        tileEntity = te;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        if (tileEntity != null){
            return tileEntity;
        }
        return null;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}