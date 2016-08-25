package startrekmod.entity;

import startrekmod.STCelestialData;
import startrekmod.generation.dimension.STTeleporter;

import net.minecraft.entity.player.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.*;

public class EntityPlanet extends EntityCelestial
{
	public EntityPlanet(World world)
	{
		super(world);
	}

	public EntityPlanet(World world, STCelestialData data)
	{
		super(world, data);
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
	}

	@Override
	public boolean interactFirst(EntityPlayer player)
	{
		if (!(player instanceof EntityPlayerMP))
			return false;

		EntityPlayerMP serverPlayer = (EntityPlayerMP)player;
		MinecraftServer mc = MinecraftServer.getServer();
		ServerConfigurationManager manager = mc.getConfigurationManager();
		WorldServer world = mc.worldServerForDimension(data.dimensionID);
		STTeleporter teleporter = new STTeleporter(world);
		manager.transferPlayerToDimension(serverPlayer, data.dimensionID, teleporter);
		return true;
	}
}
