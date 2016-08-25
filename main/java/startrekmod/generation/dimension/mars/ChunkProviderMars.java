package startrekmod.generation.dimension.mars;

import startrekmod.generation.dimension.STChunkProvider;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.*;

public class ChunkProviderMars extends STChunkProvider
{
	public ChunkProviderMars(World world)
	{
		super (world);
	}

	@Override
	protected BlockMetaArray createChunkBlockArray(int chunkX, int chunkZ)
	{
		short[][][] IDMatrix = new short[16][256][16];
		byte[][][] metaMatrix = new byte[16][256][16];

		for (int x = 0; x < 16; x++)
			for (int y = 0; y < 256; y++)
				for (int z = 0; z < 16; z++)
				{
					if (y == 0)
					{
						IDMatrix[x][y][z] = (short) Block.getIdFromBlock (Blocks.bedrock);
						metaMatrix[x][y][z] = 0;
					}
					else if (y < 60)
					{
						IDMatrix[x][y][z] = (short) Block.getIdFromBlock (Blocks.stone);
						metaMatrix[x][y][z] = 0;
					}
					else if (y < 64)
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
	public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_)
	{
		return new ArrayList (0);
	}

	@Override
	public String makeString()
	{
		return "MarsLevelSource";
	}

	@Override
	public void populate(IChunkProvider provider, int chunkX, int chunkZ)
	{}

	@Override
	public void recreateStructures(int p_82695_1_, int p_82695_2_)
	{}
}
