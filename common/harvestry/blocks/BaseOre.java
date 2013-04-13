package harvestry.blocks;

import harvestry.Harvestry;
import harvestry.utils.Archive;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BaseOre extends Block {

    /**
     * Creates a new Block instance capable of being a Ore
     * 
     * @param id
     *            Block Id
     */
    public BaseOre(int id) {
        super(id, Material.rock);
        // The tab it appears in
        setCreativeTab(Harvestry.tabHarvestry);
    }

    @Override
    // Makes sure pick block works right
    public int damageDropped(int id) {
        return id;
    }

    @Override
    // Specifies the block drop
    public ArrayList<ItemStack> getBlockDropped(World w, int x, int y, int z, int meta, int fortune) {
        // The list of items
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();
        return list;
    }
    
    /**
     * Registers the Icon for the Block
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Archive.texture + this.getUnlocalizedName2());
    }
}