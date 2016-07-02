package com.vulcanforge.startrekmod.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderSpace extends WorldProvider
{
	@Override
	public String getDimensionName() 
	{
		return "Space";
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerSpace();
		this.dimensionId = SpaceDimension.spaceDimId;
	}
	
	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderSpace(worldObj);
	}
}
