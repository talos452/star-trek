package startrekmod.generation.dimension.space;

import startrekmod.entity.EntityPlanet;
import startrekmod.generation.STChunkProvider;

import net.minecraft.entity.*;
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

	boolean isEntityInChunk(Entity entity, int chunkX, int chunkZ)
	{
		return (entity.posX - chunkX * 16) * (entity.posX - chunkX * 16) < 256 && (entity.posZ - chunkZ * 16) * (entity.posZ - chunkZ * 16) < 16;
	}

	@Override
	public String makeString()
	{
		return "SpaceLevelSource";
	}

	@Override
	public void populate(IChunkProvider provider, int chunkX, int chunkZ)
	{
		if (PlanetList.planetList == null)
			PlanetList.init();

		for (Object object : PlanetList.planetList)
			if (isEntityInChunk((EntityPlanet)object, chunkX, chunkZ))
				world.spawnEntityInWorld((Entity)object);
	}
}
