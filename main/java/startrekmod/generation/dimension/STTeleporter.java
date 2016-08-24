package startrekmod.generation.dimension;

import startrekmod.STGeneration;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.*;

public class STTeleporter extends Teleporter
{
	int dimensionID;

	public STTeleporter(WorldServer world)
	{
		super(world);
		dimensionID = world.provider.dimensionId;
	}

	int getTopBlock(World world)
	{
		int y = 255;

		for (; y > 0; y--)
			if (!(world.getBlock(0, y, 0) == Blocks.air))
				break;

		return y;
	}

	@Override
	public void placeInPortal(Entity entity, double x, double y, double z, float yaw)
	{
		if (dimensionID == STGeneration.spaceDimensionID)
		{
			entity.setLocationAndAngles(0, 32767, 0, yaw, entity.rotationPitch);
			((EntityPlayer)entity).isAirBorne = true;
		}
		else
			entity.setLocationAndAngles(0, getTopBlock(MinecraftServer.getServer().worldServerForDimension(dimensionID)) + 1, 0, yaw, entity.rotationPitch);
	}
}
