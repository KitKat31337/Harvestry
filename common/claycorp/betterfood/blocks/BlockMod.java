package claycorp.betterfood.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import claycorp.betterfood.utils.Archive;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockMod extends Block {

    public BlockMod(int ID, Material Material) {
        super(ID,Material); //Parameters: Block ID, Block material
    }
    public Block blockMaterial(Material Material) {
        return null;
    }
    @SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon(Archive.texture
                + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));


} 
    }
