package startrekmod.generation.dimension;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

import java.util.*;

public abstract class STChunkProvider implements IChunkProvider
{
	protected World world;
	protected Random rand;

	public STChunkProvider (World world)
	{
		this.world = world;
		rand = new Random (world.getSeed ());
	}

	@Override
	public final Chunk provideChunk (int chunkX, int chunkZ)
	{
		Chunk chunk = new Chunk (world, chunkX, chunkZ);
		ExtendedBlockStorage[] ebsList = chunk.getBlockStorageArray ();

		for (int i = 0; i < 16; i++)
			if (ebsList[i] == null)
				ebsList[i] = new ExtendedBlockStorage (i * 16, true);

		BlockMetaArray matrix = createChunkBlockArray (chunkX, chunkZ);

		if (matrix == null)
			for (int e = 0; e < 16; e++)
			{
				ExtendedBlockStorage cube = ebsList[e];

				for (int x = 0; x < 16; x++)
					for (int y = 0; y < 16; y++)
						for (int z = 0; z < 16; z++)
						{
							cube.func_150818_a (x, y, z, Blocks.air);
							cube.setExtBlockMetadata (x, y, z, 0);
						}
			}
		else
			for (int e = 0; e < 16; e++)
			{
				ExtendedBlockStorage cube = ebsList[e];

				for (int x = 0; x < 16; x++)
					for (int y = 0; y < 16; y++)
						for (int z = 0; z < 16; z++)
						{
							cube.func_150818_a (x, y, z, Block.getBlockById (matrix.blockIDs[x][e * 16 + y][z]));
							cube.setExtBlockMetadata (x, y, z, matrix.metas[x][e * 16 + y][z]);

						}
			}

		chunk.generateSkylightMap ();
		return chunk;
	}

	@Override
	public final Chunk loadChunk (int chunkX, int chunkZ)
	{
		return provideChunk (chunkX, chunkZ);
	}

	protected abstract BlockMetaArray createChunkBlockArray (int chunkX, int chunkZ);

	@Override
	public final boolean canSave ()
	{
		return true;
	}

	@Override
	public final boolean chunkExists (int p_73149_1_, int p_73149_2_)
	{
		return true;
	}

	@Override
	public final ChunkPosition func_147416_a (World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_)
	{
		return null;
	}

	@Override
	public final int getLoadedChunkCount ()
	{
		return 0;
	}

	@Override
	public List getPossibleCreatures (EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_)
	{
		return new ArrayList (0);
	}

	@Override
	public final boolean saveChunks (boolean saveAllChunks, IProgressUpdate progress)
	{
		return true;
	}

	@Override
	public final boolean unloadQueuedChunks ()
	{
		return false;
	}

	@Override
	public void recreateStructures (int p_82695_1_, int p_82695_2_)
	{}

	@Override
	public final void saveExtraData ()
	{}

	public class BlockMetaArray
	{
		public short[][][] blockIDs;
		public byte[][][] metas;

		public BlockMetaArray (short[][][] blockIDs, byte[][][] metas)
		{
			this.blockIDs = blockIDs;
			this.metas = metas;
		}
	}
}
