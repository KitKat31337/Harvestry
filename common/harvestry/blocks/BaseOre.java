package harvestry.blocks;

import harvestry.Harvestry;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
}