package claycorp.betterfood.ores;

import java.util.ArrayList;

import claycorp.betterfood.BetterFood;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class oreAluminum extends Block {
    public oreAluminum(int ID){
        super(ID,Material.rock); //Parameters: Block ID, Block material
        setHardness(3.0F); //The block hardness
        setResistance(5.0F); //The explosion resistance
        setCreativeTab(BetterFood.tabBetterFood); //The tab it appears in
        }

        public int damageDropped(int i){ //Makes sure pick block works right
        return i;
        }


        public ArrayList<ItemStack> getBlockDropped(World w, int x, int y, int z, int meta, int fortune){ //Specifies the block drop
        ArrayList<ItemStack> list = new ArrayList<ItemStack>(); //The list of items
        return list;

}
}     