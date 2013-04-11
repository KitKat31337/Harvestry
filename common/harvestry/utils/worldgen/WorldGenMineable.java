package harvestry.utils.worldgen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMineable extends WorldGenerator {

    private List<Integer> replaceableBlocks;
    private int numberOfBlocks;
    private int minableBlockId;
    private int density;

    private static List<Integer[]> possibleMoves;

    static{
        possibleMoves = new ArrayList<Integer[]>();
        possibleMoves.add(new Integer[] { 1, 0, 0 });
        possibleMoves.add(new Integer[] { 0, 1, 0 });
        possibleMoves.add(new Integer[] { 0, 0, 1 });
        possibleMoves.add(new Integer[] { -1, 0, 0 });
        possibleMoves.add(new Integer[] { 0, -1, 0 });
        possibleMoves.add(new Integer[] { 0, 0, -1 });
        possibleMoves.add(new Integer[] { 1, 1, 0 });
        possibleMoves.add(new Integer[] { -1, 1, 0 });
        possibleMoves.add(new Integer[] { 1, -1, 0 });
        possibleMoves.add(new Integer[] { -1, -1, 0 });
        possibleMoves.add(new Integer[] { 1, 0, 1 });
        possibleMoves.add(new Integer[] { -1, 0, 1 });
        possibleMoves.add(new Integer[] { 1, 0, -1 });
        possibleMoves.add(new Integer[] { -1, 0, -1 });
        possibleMoves.add(new Integer[] { 0, 1, 1 });
        possibleMoves.add(new Integer[] { 0, -1, 1 });
        possibleMoves.add(new Integer[] { 0, 1, -1 });
        possibleMoves.add(new Integer[] { 0, -1, -1 });
    }

    public WorldGenMineable(int id, int size, int density, Object... replacableIDs) {
        minableBlockId = id;
        numberOfBlocks = size;
        this.density = density;
        replaceableBlocks = new ArrayList<Integer>();
        for (Object i : replacableIDs){
            replaceableBlocks.add((Integer) i);
        }
    }

    public boolean spawnOre(World world, Integer[] coords) {
        return spawnOre(world, coords[0], coords[1], coords[2]);
    }

    public boolean spawnOre(World world, int x, int y, int z) {
        int currentID = world.getBlockId(x, y, z);
        if (replaceableBlocks.contains(currentID)){
            world.setBlock(x, y, z, this.minableBlockId);
            return true;
        }

        return false;
    }

    @Override
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5) {
        float f = par2Random.nextFloat() * (float) Math.PI;
        double d0 = par3 + 8 + ((MathHelper.sin(f) * this.numberOfBlocks) / 8.0F);
        double d1 = (par3 + 8) - ((MathHelper.sin(f) * this.numberOfBlocks) / 8.0F);
        double d2 = par5 + 8 + ((MathHelper.cos(f) * this.numberOfBlocks) / 8.0F);
        double d3 = (par5 + 8) - ((MathHelper.cos(f) * this.numberOfBlocks) / 8.0F);
        double d4 = (par4 + par2Random.nextInt(3)) - 2;
        double d5 = (par4 + par2Random.nextInt(3)) - 2;

        for (int l = 0; l <= this.numberOfBlocks; ++l){
            double d6 = d0 + (((d1 - d0) * l) / this.numberOfBlocks);
            double d7 = d4 + (((d5 - d4) * l) / this.numberOfBlocks);
            double d8 = d2 + (((d3 - d2) * l) / this.numberOfBlocks);
            double d9 = (par2Random.nextDouble() * this.numberOfBlocks) / 16.0D;
            double d10 = ((MathHelper.sin((l * (float) Math.PI) / this.numberOfBlocks) + 1.0F) * d9) + 1.0D;
            double d11 = ((MathHelper.sin((l * (float) Math.PI) / this.numberOfBlocks) + 1.0F) * d9) + 1.0D;
            int i1 = MathHelper.floor_double(d6 - (d10 / 2.0D));
            int j1 = MathHelper.floor_double(d7 - (d11 / 2.0D));
            int k1 = MathHelper.floor_double(d8 - (d10 / 2.0D));
            int l1 = MathHelper.floor_double(d6 + (d10 / 2.0D));
            int i2 = MathHelper.floor_double(d7 + (d11 / 2.0D));
            int j2 = MathHelper.floor_double(d8 + (d10 / 2.0D));

            for (int k2 = i1; k2 <= l1; ++k2){
                double d12 = ((k2 + 0.5D) - d6) / (d10 / 2.0D);

                if ((d12 * d12) < 1.0D){
                    for (int l2 = j1; l2 <= i2; ++l2){
                        double d13 = ((l2 + 0.5D) - d7) / (d11 / 2.0D);

                        if (((d12 * d12) + (d13 * d13)) < 1.0D){
                            for (int i3 = k1; i3 <= j2; ++i3){
                                double d14 = ((i3 + 0.5D) - d8) / (d10 / 2.0D);

                                Block block = Block.blocksList[par1World.getBlockId(k2, l2, i3)];
                                if (((d12 * d12) + (d13 * d13) + (d14 * d14)) < 1.0D){
                                    if (block != null){
                                        // System.out.println("Generationg in" +
                                        // block.blockID);
                                        if ((block.blockID == Block.stone.blockID)
                                                || block.isGenMineableReplaceable(par1World, k2,
                                                        l2, i3, Block.stone.blockID)
                                                || (block.blockID == Block.netherrack.blockID)
                                                || (block.blockID == Block.whiteStone.blockID)){
                                            // System.out.println("not null" +
                                            // this.minableBlockId);
                                            par1World.setBlock(k2, l2, i3, this.minableBlockId);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean generate2(World world, Random par2Random, int x, int y, int z) {
        List<Integer[]> spawnedCoords = new ArrayList<Integer[]>();
        // SortedList<Integer[]> spawnedCoords = new SortedList<Integer[]>(new
        // CompareCoordinates());

        spawnOre(world, x, y, z);
        spawnedCoords.add(new Integer[] { x, y, z });

        // int trueSize = 1;
        for (int n = 1; n < this.numberOfBlocks; n++){
            List<Integer[]> cpm = new ArrayList<Integer[]>();
            for (Integer[] i : possibleMoves){
                cpm.add(i);
            }

            int pickedOre = (int) (((par2Random.nextFloat() * par2Random.nextFloat())) * spawnedCoords
                    .size());
            pickedOre = spawnedCoords.size() - 1;
            Integer[] coords = spawnedCoords.get(pickedOre);

            Integer[] finalCoords = { coords[0], coords[1], coords[2] };
            do{
                if (cpm.size() == 0){
                    n--;
                    spawnedCoords.remove(pickedOre);
                    break;
                }
                int pick = (int) (par2Random.nextFloat() * cpm.size());
                Integer[] offset = cpm.get(pick);
                finalCoords = new Integer[] { coords[0] + offset[0], coords[1] + offset[1],
                        coords[2] + offset[2] };
                cpm.remove(pick);
            }while (spawnedCoords.contains(finalCoords));

            if (par2Random.nextInt(100) < density){
                spawnOre(world, finalCoords);
                // trueSize++;
            }
            spawnedCoords.add(finalCoords);
        }

        // System.out.println("Ore vein size = " + trueSize);
        return true;
    }
}