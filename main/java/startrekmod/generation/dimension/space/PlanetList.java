package startrekmod.generation.dimension.space;

import startrekmod.STGeneration;
import startrekmod.entity.EntityPlanet;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

import java.util.*;

public final class PlanetList
{
	public static EntityPlanet earth;
	public static EntityPlanet mars;
	public static List planetList;

	public static void init()
	{
		World space = MinecraftServer.getServer().worldServerForDimension(STGeneration.spaceDimensionID);
		planetList = new ArrayList();

		earth = new EntityPlanet(space, "earth", 0, 0, 32767, 0);
		mars = new EntityPlanet(space, "mars", STGeneration.marsDimensionID, 16, 32767, 0);

		planetList.add(earth);
		planetList.add(mars);
	}
}
