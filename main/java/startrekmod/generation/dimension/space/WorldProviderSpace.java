package startrekmod.generation.dimension.space;

import startrekmod.STGeneration;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.relauncher.*;

public class WorldProviderSpace extends WorldProvider
{
	@Override
	public boolean canRespawnHere()
	{
		return false;
	}

	@Override
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderSpace(worldObj);
	}

	@Override
	public String getDepartMessage()
	{
		return "Entering planetary atmosphere";
	}

	@Override
	public String getDimensionName()
	{
		return "Space";
	}

	@Override
	public Vec3 getFogColor(float p_76562_1_, float p_76562_2_)
	{
		return Vec3.createVectorHelper(0, 0, 0);
	}

	@Override
	public int getRespawnDimension(EntityPlayerMP player)
	{
		return 0;
	}

	@Override
	public String getSaveFolder()
	{
		return getDimensionName();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
	{
		return Vec3.createVectorHelper(0, 0, 0);
	}

	@Override
	public String getWelcomeMessage()
	{
		return "Departing planetary atmosphere";
	}

	@Override
	public boolean isSurfaceWorld()
	{
		return false;
	}

	@Override
	protected void registerWorldChunkManager()
	{
		worldChunkMgr = new WorldChunkManagerHell(new BiomeGenSpace(), 0F);
		dimensionId = STGeneration.spaceDimensionID;
		hasNoSky = true;
	}

	@Override
	public boolean shouldMapSpin(String entity, double x, double y, double z)
	{
		return false;
	}
}
