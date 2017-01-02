package startrekmod.generation.dimension.mars;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import startrekmod.STDimension;
import startrekmod.graphics.render.RenderSky;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.*;
import net.minecraft.world.WorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;

public class WorldProviderMars extends WorldProvider
{
    @Override
    protected void registerWorldChunkManager ()
    {
        worldChunkMgr = new WorldChunkManagerHell (new BiomeGenMars (), 0F);
        dimensionId = STDimension.dimensionTable.get ("mars").getDimensionID ();
        hasNoSky = false;
    }

    @Override
    public Vec3 getFogColor (float par1, float p_76562_2_)
    {
        float angle = (float) (getWorldTime () / 24000.0 * Math.PI * 2F);
        float extendedAngle = (float) (Math.PI * .5 - .9 * (Math.PI * .5 - angle));
        float brightness = MathHelper.sin (angle);
        float redFactor = MathHelper.sin (extendedAngle);

        if (brightness < 0)
            brightness = 0;

        if (redFactor < 0)
            redFactor = 0;

        // DO. NOT. PLAY. WITH. THIS. CODE.
        // I will not go rooting through God knows what classes to find
        // the rain dimming algorithm a second time.
        double red = redFactor / (1.0 - worldObj.getRainStrength (1) * .5);
        double green = brightness * .875 / (1.0 - worldObj.getRainStrength (1) * .5);
        double blue = brightness * .875 / (1.0 - worldObj.getRainStrength (1) * .4);

        return Vec3.createVectorHelper (red, green, blue);
    }

    @Override
    public Vec3 getSkyColor (Entity cameraEntity, float partialTicks)
    {
        float angle = (float) (getWorldTime () / 24000.0 * Math.PI * 2F);
        float extendedAngle = (float) (angle * .9F + Math.PI * .4F);
        float brightness = MathHelper.sin (angle);
        float redFactor = MathHelper.sin (extendedAngle);

        if (brightness < 0)
            brightness = 0;

        if (redFactor < 0)
            redFactor = 0;

        double red = redFactor;
        double green = brightness * .875;
        double blue = brightness * .875;

        return Vec3.createVectorHelper (red, green, blue);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer ()
    {
        return new RenderSky ();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderHandler getCloudRenderer ()
    {
        return new IRenderHandler ()
        {
            public void render (float par1, WorldClient par2, Minecraft par3)
            {

            }
        };
    }

    @Override
    public float[] calcSunriseSunsetColors (float par1, float par2)
    {
        return new float[]
        {0, 0, 0, 0};
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
    public String getSaveFolder ()
    {
        return getDimensionName ();
    }

    @Override
    public int getRespawnDimension (EntityPlayerMP player)
    {
        return dimensionId;
    }

    @Override
    public boolean isSurfaceWorld ()
    {
        return true;
    }

    @Override
    public boolean canRespawnHere ()
    {
        return true;
    }

    @Override
    public boolean shouldMapSpin (String entity, double x, double y, double z)
    {
        return false;
    }
}
