package startrekmod;

import startrekmod.generation.*;
import startrekmod.generation.dimension.space.WorldProviderSpace;

import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.common.registry.GameRegistry;

public class STGeneration
{
	public static int spaceDimensionID;

	public static void init()
	{
		GameRegistry.registerWorldGenerator(new GenerateDuranium(), 0);
		GameRegistry.registerWorldGenerator(new GenerateDilithium(), 1);
		GameRegistry.registerWorldGenerator(new GenerateLatinum(), 2);

		spaceDimensionID = DimensionManager.getNextFreeDimId();
		DimensionManager.registerProviderType(spaceDimensionID, WorldProviderSpace.class, false);
		DimensionManager.registerDimension(spaceDimensionID, spaceDimensionID);
	}
}
