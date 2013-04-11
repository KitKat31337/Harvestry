package claycorp.betterfood.blocks;

import claycorp.betterfood.utils.Archive;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ModContainer extends BlockContainer {

    TileEntity tileEntity;

    public ModContainer(int id, TileEntity te) {
        super(id, Material.ground);
        tileEntity = te;
    }

    public ModContainer(int id, Material material, TileEntity te) {
        super(id, material);
        tileEntity = te;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        return tileEntity;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}