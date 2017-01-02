package startrekmod.generation.dimension.mars;

import startrekmod.generation.dimension.STChunkProvider;
import startrekmod.generation.Perlin;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.*;

public class ChunkProviderMars extends STChunkProvider
{
    NoiseGeneratorSimplex ngp1, ngp2, ngp3;

    public ChunkProviderMars (World world)
    {
        super (world);
        ngp1 = new NoiseGeneratorSimplex (rand);
        ngp2 = new NoiseGeneratorSimplex (rand);
        ngp3 = new NoiseGeneratorSimplex (rand);
    }

    int getHeight (int x, int z)
    {
        double xd = x / 128.0;
        double zd = z / 128.0;
        double total = 0;

        total += ngp1.func_151605_a (xd, zd) * 24;
        total += ngp1.func_151605_a (xd * .5, zd * .5) * 12;
        total += ngp1.func_151605_a (xd * .25, zd * .25) * 6;

        return (int) total + 64;
    }

    @Override
    protected BlockMetaArray createChunkBlockArray (int chunkX, int chunkZ)
    {
        short[][][] IDMatrix = new short[16][256][16];
        byte[][][] metaMatrix = new byte[16][256][16];
        int[][] heightMap = new int[16][16];

        for (int x = 0; x < 16; x++)
            for (int z = 0; z < 16; z++)
                heightMap[x][z] = getHeight (chunkX * 16 + x, chunkZ * 16 + z);

        for (int x = 0; x < 16; x++)
            for (int z = 0; z < 16; z++)
                for (int y = 0; y < 256; y++)
                {
                    if (y == 0)
                    {
                        IDMatrix[x][y][z] = (short) Block.getIdFromBlock (Blocks.bedrock);
                        metaMatrix[x][y][z] = 0;
                    }
                    else if (y < heightMap[x][z] - 4)
                    {
                        IDMatrix[x][y][z] = (short) Block.getIdFromBlock (Blocks.stone);
                        metaMatrix[x][y][z] = 0;
                    }
                    else if (y < heightMap[x][z])
                    {
                        IDMatrix[x][y][z] = (short) Block.getIdFromBlock (Blocks.sand);
                        metaMatrix[x][y][z] = 1;
                    }
                    else if (y < 42)
                    {
                        IDMatrix[x][y][z] = (short) Block.getIdFromBlock (Blocks.ice);
                        metaMatrix[x][y][z] = 0;
                    }
                    else
                    {
                        IDMatrix[x][y][z] = (short) Block.getIdFromBlock (Blocks.air);
                        metaMatrix[x][y][z] = 0;
                    }
                }

        return new BlockMetaArray (IDMatrix, metaMatrix);
    }

    @Override
    public String makeString ()
    {
        return "MarsLevelSource";
    }

    @Override
    public void populate (IChunkProvider provider, int chunkX, int chunkZ)
    {
        int iterations = rand.nextInt (3);

        for (int i = 0; i < iterations; i++)
        {
            int x = rand.nextInt (16) + chunkX * 16;
            int z = rand.nextInt (16) + chunkZ * 16;
            int y = world.getTopSolidOrLiquidBlock (x, z);

            if (Block.getIdFromBlock (world.getBlock (x, y - 1, z)) != Block.getIdFromBlock (Blocks.ice))
                world.setBlock (x, y, z, Blocks.stone);
        }

    }
}
