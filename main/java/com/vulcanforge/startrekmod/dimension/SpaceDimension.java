package com.vulcanforge.startrekmod.dimension;

import net.minecraftforge.common.DimensionManager;

public class SpaceDimension 
{
	public static int spaceDimId = DimensionManager.getNextFreeDimId();
	
	public static void init()
	{
		DimensionManager.registerProviderType(spaceDimId, WorldProviderSpace.class, false);
		DimensionManager.registerDimension(spaceDimId, spaceDimId);
	}
}
