package startrekmod.graphics.render;

import startrekmod.*;
import startrekmod.entity.EntityCelestial;
import startrekmod.graphics.model.ModelCelestial;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderCelestial extends STRender
{
    public RenderCelestial ()
    {
        super (null);
        model = new ModelCelestial ();
    }

    @Override
    void render (Entity entity, double translationX, double translationY, double translationZ, float yaw, float pitch)
    {
        STCelestialData data = ((EntityCelestial) entity).getCelestialData ();
        GL11.glDisable (GL11.GL_LIGHTING);
        OpenGlHelper.setLightmapTextureCoords (OpenGlHelper.lightmapTexUnit, 240f, 240f);
        GL11.glTranslated (0, data.size / 2.0, 0);
        GL11.glScaled (data.size, data.size, data.size);
        model.render (1 / 64F);
        GL11.glEnable (GL11.GL_LIGHTING);
    }

    @Override
    protected ResourceLocation getEntityTexture (Entity entity)
    {
        EntityCelestial celestial = (EntityCelestial) entity;

        if (celestial.getCelestialData () != null)
            return new ResourceLocation (STGraphics.location
                            + celestial.getCelestialData ().name + ".png");
        else
        {
            return new ResourceLocation (STGraphics.location
                            + "sol.png");
        }
    }
}
