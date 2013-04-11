package claycorp.betterfood.utils.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator {

    private int oreID;
    private int maxHeight;
    private int minHeight;

    public WorldGenHandler(int id, int max, int min) {
        oreID = id;
        maxHeight = max;
        minHeight = min;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int veinCount = random.nextInt(10);
        for (int n = 0; n < veinCount; n++){
            int randPosX = (chunkX * 16) + random.nextInt(16);
            int randPosY = random.nextInt(maxHeight - minHeight) + minHeight;
            int randPosZ = (chunkZ * 16) + random.nextInt(16);

            new WorldGenMineable(oreID, random.nextInt(8), random.nextInt(120), Block.stone.blockID)
                    .generate(world, random, randPosX, randPosY, randPosZ);
        }
    }
}