package claycorp.betterfood.utils.handlers;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;


/**
 * World generator.
 * 
 * @author Telinc1
 */
public class WorldGenHandler implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
        case 0:
            this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;

        }
    }

    private void generateSurface(World world, Random random, int i, int j) {
        // TODO Auto-generated method stub
        
    }

}