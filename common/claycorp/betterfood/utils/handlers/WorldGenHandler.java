package claycorp.betterfood.utils.handlers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import claycorp.betterfood.blocks.ModBlocks;
import claycorp.betterfood.utils.Config;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        /*int sealevel = world.provider.getAverageGroundLevel() + 1 + Config.oreDepthModifier;
        if ((Config.enableWorldGenAluminum) && (ModBlocks.oreAluminum != null)){
            double oreDepthMultiplier = (15 * sealevel) / 64;
            int scale = (int) Math.round((random.nextGaussian() * Math.sqrt(oreDepthMultiplier))
                    + oreDepthMultiplier);

            for (int x = 0; x < (scale / 2); x++){
                int a = (chunkX * 16) + random.nextInt(22);
                int b = random.nextInt((40 * sealevel) / 64) + random.nextInt((22 * sealevel) / 64)
                        + ((12 * sealevel) / 64);
                int c = (chunkZ * 16) + random.nextInt(22);
                new WorldGenMinable(ModBlocks.oreAluminum.blockID, 4 + Config.oreDensityModifier,
                        Block.stone.blockID).generate(world, random, a, b, c);
            }
        }*/
    }
}