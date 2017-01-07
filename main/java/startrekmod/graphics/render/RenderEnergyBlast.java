package startrekmod.graphics.render;

import startrekmod.entity.energyblast.EntityEnergyBlast;
import startrekmod.graphics.model.ModelEnergyBlast;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

public class RenderEnergyBlast extends STRender
{
    public RenderEnergyBlast ()
    {
        super ("phaser_blast");
        model = new ModelEnergyBlast ();
    }

    @Override
    void render (Entity entity, double translationX, double translationY, double translationZ, float yaw, float pitch)
    {
        GL11.glDisable (GL11.GL_LIGHTING);
        OpenGlHelper.setLightmapTextureCoords (OpenGlHelper.lightmapTexUnit, 240F, 240F);
        Color beamColour = ((EntityEnergyBlast) entity).getBeamColour ();
        GL11.glColor3f (beamColour.getRed () / 255F, beamColour.getGreen () / 255F, beamColour.getBlue () / 255F);
        model.render (.0625F);
        GL11.glEnable (GL11.GL_LIGHTING);
    }
}
