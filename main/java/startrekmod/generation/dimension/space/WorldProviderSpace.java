package startrekmod.generation.dimension.space;

import startrekmod.STDimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderSpace extends WorldProvider
{
    @Override
    protected void registerWorldChunkManager ()
    {
        worldChunkMgr = new WorldChunkManagerHell (new BiomeGenSpace (), 0F);
        dimensionId = STDimension.dimensionTable.get ("space").getDimensionID ();
        hasNoSky = true;
    }

    @Override
    public Vec3 getFogColor (float p_76562_1_, float p_76562_2_)
    {
        return Vec3.createVectorHelper (0, 0, 0);
    }

    @Override
    public Vec3 getSkyColor (Entity cameraEntity, float partialTicks)
    {
        return Vec3.createVectorHelper (0, 0, 0);
    }

    @Override
    public IChunkProvider createChunkGenerator ()
    {
        return new ChunkProviderSpace (worldObj);
    }

    @Override
    public String getDimensionName ()
    {
        return "Space";
    }

    @Override
    public String getSaveFolder ()
    {
        return getDimensionName ();
    }

    @Override
    public int getRespawnDimension (EntityPlayerMP player)
    {
        return 0;
    }

    @Override
    public boolean isSurfaceWorld ()
    {
        return false;
    }

    @Override
    public boolean canRespawnHere ()
    {
        return false;
    }

    @Override
    public boolean shouldMapSpin (String entity, double x, double y, double z)
    {
        return false;
    }
}
