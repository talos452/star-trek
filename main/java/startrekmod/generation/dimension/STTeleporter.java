package startrekmod.generation.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.*;

public class STTeleporter extends Teleporter
{
	int dimensionID;

	public STTeleporter (WorldServer world)
	{
		super (world);
		dimensionID = world.provider.dimensionId;
	}

	@Override
	public void placeInPortal (Entity entity, double x, double y, double z, float yaw)
	{
		MinecraftServer mc = MinecraftServer.getServer ();
		ServerConfigurationManager manager = mc.getConfigurationManager ();
		World world = mc.worldServerForDimension (dimensionID);
		int topYCoordinate = world.getTopSolidOrLiquidBlock (0, 0);
		entity.setPosition (x, topYCoordinate, z);
	}
}
