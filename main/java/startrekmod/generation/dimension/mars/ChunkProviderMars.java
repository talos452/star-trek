package startrekmod.generation.dimension.mars;

import startrekmod.generation.dimension.STChunkProvider;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorSimplex;

public class ChunkProviderMars extends STChunkProvider
{
	public ChunkProviderMars (World world)
	{
		super (world);
	}

	@Override
	protected BlockMetaArray createChunkBlockArray (int chunkX, int chunkZ)
	{
		short[][][] IDMatrix = new short[16][256][16];
		byte[][][] metaMatrix = new byte[16][256][16];
		int[][] heightMap = new int[16][16];
		NoiseGeneratorSimplex noise = new NoiseGeneratorSimplex (rand);

		for (int x = 0; x < 16; x++)
			for (int z = 0; z < 16; z++)
				heightMap[x][z] = (int) (noise.func_151605_a (x, z) * 64) + 64;

		for (int x = 0; x < 16; x++)
			for (int z = 0; z < 16; z++)
				for (int y = 0; y < heightMap[x][z]; y++)
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
					else
					{
						IDMatrix[x][y][z] = (short) Block.getIdFromBlock (Blocks.air);
						metaMatrix[x][y][z] = 1;
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
	{}
}
