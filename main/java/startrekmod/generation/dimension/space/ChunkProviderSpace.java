package startrekmod.generation.dimension.space;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;

import java.util.*;

public class ChunkProviderSpace implements IChunkProvider
{
	World world;
	
	public ChunkProviderSpace(World world)
	{
		this.world = world;
	}

	@Override
	public boolean chunkExists(int x, int z)
	{
		return true;
	}

	@Override
	public Chunk provideChunk(int x, int z)
	{
		return loadChunk(x, z);
	}

	@Override
	public Chunk loadChunk(int x, int z)
	{
		Chunk chunk = new Chunk(world, x, z);
		chunk.generateSkylightMap();
		return chunk;
	}

	@Override
	public void populate(IChunkProvider provider, int x, int z) {}

	@Override
	public boolean saveChunks(boolean saveAllChunks, IProgressUpdate progress)
	{
		return true;
	}

	@Override
	public boolean unloadQueuedChunks()
	{
		return false;
	}

	@Override
	public boolean canSave()
	{
		return true;
	}

	@Override
	public String makeString()
	{
		//returns something similar to other over-rides in other subclasses
		return "SpaceLevelSource";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType filter, int x, int y, int z)
	{
		return new ArrayList(0);
	}

	//this method may have something to do with fixed-location structures
	@Override
	public ChunkPosition func_147416_a(World world, String structureID, int x, int y, int z)
	{
		return null;
	}

	@Override
	public int getLoadedChunkCount()
	{
		return 0;
	}

	@Override
	public void recreateStructures(int x, int z) {}

	@Override
	public void saveExtraData() {}

}
