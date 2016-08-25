package startrekmod.generation.dimension.space;

import startrekmod.generation.dimension.STChunkProvider;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.*;

public class ChunkProviderSpace extends STChunkProvider
{
	public ChunkProviderSpace (World world)
	{
		super (world);
	}

	@Override
	protected BlockMetaArray createChunkBlockArray (int chunkX, int chunkZ)
	{
		return null;
	}

	@Override
	public List getPossibleCreatures (EnumCreatureType filter, int x, int y, int z)
	{
		return new ArrayList (0);
	}

	@Override
	public String makeString ()
	{
		return "SpaceLevelSource";
	}

	@Override
	public void populate (IChunkProvider provider, int chunkX, int chunkZ)
	{

	}
}
