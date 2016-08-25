package startrekmod.generation.dimension.space;

import startrekmod.STCelestialData;
import startrekmod.generation.dimension.STChunkProvider;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.*;

public class ChunkProviderSpace extends STChunkProvider
{
	public ChunkProviderSpace(World world)
	{
		super(world);
	}

	@Override
	protected BlockMetaArray createChunkBlockArray(int chunkX, int chunkZ)
	{
		return null;
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType filter, int x, int y, int z)
	{
		return new ArrayList(0);
	}

	@Override
	public String makeString()
	{
		return "SpaceLevelSource";
	}

	@Override
	public void populate(IChunkProvider provider, int chunkX, int chunkZ)
	{
		for (STCelestialData celestial : STCelestialData.bodyList)
			if (celestial.posX >= chunkX * 16 && celestial.posX < (chunkX + 1) * 16)
				if (celestial.posZ >= chunkZ * 16 && celestial.posZ < (chunkZ + 1) * 16)
					world.spawnEntityInWorld(STCelestialData.createEntityForCelestial(celestial, world));

		return;
	}
}
