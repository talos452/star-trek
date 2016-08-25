package startrekmod.generation.dimension.mars;

import startrekmod.STDimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.*;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.relauncher.*;

public class WorldProviderMars extends WorldProvider
{
	@Override
	public boolean canRespawnHere ()
	{
		return true;
	}

	@Override
	public IChunkProvider createChunkGenerator ()
	{
		return new ChunkProviderMars (worldObj);
	}

	@Override
	public String getDimensionName ()
	{
		return "Mars";
	}

	@Override
	public Vec3 getFogColor (float p_76562_1_, float p_76562_2_)
	{
		double brightnessMultiplier = MathHelper.cos ((float) (p_76562_1_ * Math.PI * 2)) * 2 + 0.5;

		brightnessMultiplier = (brightnessMultiplier < 0) ? 0 : brightnessMultiplier;
		brightnessMultiplier = (brightnessMultiplier > 1) ? 1 : brightnessMultiplier;

		double red = 1 * brightnessMultiplier;
		double green = .625 * brightnessMultiplier;
		double blue = 0;
		return Vec3.createVectorHelper (red, blue, green);
	}

	@Override
	public int getRespawnDimension (EntityPlayerMP player)
	{
		return dimensionId;
	}

	@Override
	public String getSaveFolder ()
	{
		return getDimensionName ();
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Vec3 getSkyColor (Entity cameraEntity, float partialTicks)
	{
		double brightnessMultiplier = MathHelper.cos ((float) (worldObj.getWorldTime () / 24000.0 * Math.PI * 2)) * 2 + 0.5;

		double red = brightnessMultiplier;
		double green = .625 * brightnessMultiplier;
		double blue = 0;

		return Vec3.createVectorHelper (red, green, blue);
	}

	@Override
	public boolean isSurfaceWorld ()
	{
		return true;
	}

	@Override
	protected void registerWorldChunkManager ()
	{
		worldChunkMgr = new WorldChunkManagerHell (new BiomeGenMars (), 0F);
		dimensionId = STDimension.dimensionTable.get ("mars").getDimensionID ();
		hasNoSky = false;
	}

	@Override
	public boolean shouldMapSpin (String entity, double x, double y, double z)
	{
		return false;
	}
}
