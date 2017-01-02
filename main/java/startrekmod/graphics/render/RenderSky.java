package startrekmod.graphics.render;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;

//Disclaimer: this class is full of crap and it's mostly copy-pasta.
public class RenderSky extends IRenderHandler
{
    boolean renderSun;
    boolean renderMoon;
    boolean renderStars;

    int starGLCallList;
    int glSkyList;
    int glSkyList2;

    public RenderSky ()
    {
        this (true, false, true);
    }

    public RenderSky (boolean renderSun, boolean renderMoon, boolean renderStars)
    {
        this.renderSun = renderSun;
        this.renderMoon = renderMoon;
        this.renderStars = renderStars;

        starGLCallList = GLAllocation.generateDisplayLists (3);
        glSkyList = starGLCallList + 1;
        glSkyList2 = starGLCallList + 2;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void render (float partialTicks, WorldClient world, Minecraft mc)
    {
        GL11.glPushMatrix ();
        GL11.glNewList (starGLCallList, GL11.GL_COMPILE);
        Random random = new Random (10842L);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads ();

        for (int i = 0; i < 1500; ++i)
        {
            double d0 = (double) (random.nextFloat () * 2.0F - 1.0F);
            double d1 = (double) (random.nextFloat () * 2.0F - 1.0F);
            double d2 = (double) (random.nextFloat () * 2.0F - 1.0F);
            double d3 = (double) (0.15F + random.nextFloat () * 0.1F);
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;

            if (d4 < 1.0D && d4 > 0.01D)
            {
                d4 = 1.0D / Math.sqrt (d4);
                d0 *= d4;
                d1 *= d4;
                d2 *= d4;
                double d5 = d0 * 100.0D;
                double d6 = d1 * 100.0D;
                double d7 = d2 * 100.0D;
                double d8 = Math.atan2 (d0, d2);
                double d9 = Math.sin (d8);
                double d10 = Math.cos (d8);
                double d11 = Math.atan2 (Math.sqrt (d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin (d11);
                double d13 = Math.cos (d11);
                double d14 = random.nextDouble () * Math.PI * 2.0D;
                double d15 = Math.sin (d14);
                double d16 = Math.cos (d14);

                for (int j = 0; j < 4; ++j)
                {
                    double d17 = 0.0D;
                    double d18 = (double) ( (j & 2) - 1) * d3;
                    double d19 = (double) ( (j + 1 & 2) - 1) * d3;
                    double d20 = d18 * d16 - d19 * d15;
                    double d21 = d19 * d16 + d18 * d15;
                    double d22 = d20 * d12 + d17 * d13;
                    double d23 = d17 * d12 - d20 * d13;
                    double d24 = d23 * d9 - d21 * d10;
                    double d25 = d21 * d9 + d23 * d10;
                    tessellator.addVertex (d5 + d24, d6 + d22, d7 + d25);
                }
            }
        }

        tessellator.draw ();
        GL11.glEndList ();
        GL11.glPopMatrix ();

        renderSun (partialTicks, world, mc);
    }

    @SideOnly(Side.CLIENT)
    void renderSun (float partialTicks, WorldClient world, Minecraft mc)
    {
        ResourceLocation locationSunPng = new ResourceLocation ("textures/environment/sun.png");

        GL11.glDisable (GL11.GL_TEXTURE_2D);
        Vec3 skyColour = world.getSkyColor (mc.renderViewEntity, partialTicks);

        GL11.glColor3d (skyColour.xCoord, skyColour.yCoord, skyColour.zCoord);
        Tessellator tesselator = Tessellator.instance;
        GL11.glDepthMask (false);
        GL11.glDisable (GL11.GL_ALPHA_TEST);
        GL11.glEnable (GL11.GL_BLEND);
        OpenGlHelper.glBlendFunc (770, 771, 1, 0);
        RenderHelper.disableStandardItemLighting ();
        float f7;
        float f8;
        float f9;
        float sunSize;

        GL11.glEnable (GL11.GL_TEXTURE_2D);
        OpenGlHelper.glBlendFunc (770, 1, 1, 0);
        GL11.glPushMatrix ();
        GL11.glTranslatef (0F, 0F, 0F);
        GL11.glRotatef (-90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef (world.getCelestialAngle (partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
        sunSize = 5.0F;
        mc.getTextureManager ().bindTexture (locationSunPng);
        tesselator.startDrawingQuads ();
        tesselator.addVertexWithUV ((double) (-sunSize), 100.0D, (double) (-sunSize), 0.0D, 0.0D);
        tesselator.addVertexWithUV ((double) sunSize, 100.0D, (double) (-sunSize), 1.0D, 0.0D);
        tesselator.addVertexWithUV ((double) sunSize, 100.0D, (double) sunSize, 1.0D, 1.0D);
        tesselator.addVertexWithUV ((double) (-sunSize), 100.0D, (double) sunSize, 0.0D, 1.0D);
        tesselator.draw ();
        sunSize = 20.0F;
        GL11.glDisable (GL11.GL_TEXTURE_2D);
        float f18 = world.getStarBrightness (partialTicks);

        if (f18 > 0.0F)
        {
            GL11.glColor4f (f18, f18, f18, f18);
            GL11.glCallList (starGLCallList);
        }

        GL11.glColor4f (1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable (GL11.GL_BLEND);
        GL11.glEnable (GL11.GL_ALPHA_TEST);
        GL11.glEnable (GL11.GL_FOG);
        GL11.glPopMatrix ();
        GL11.glDisable (GL11.GL_TEXTURE_2D);
        GL11.glColor3f (0.0F, 0.0F, 0.0F);
        double d0 = mc.thePlayer.getPosition (partialTicks).yCoord - world.getHorizon ();

        if (d0 < 0.0D)
        {
            GL11.glPushMatrix ();
            GL11.glTranslatef (0.0F, 12.0F, 0.0F);
            GL11.glCallList (glSkyList2);
            GL11.glPopMatrix ();
            f8 = 1.0F;
            f9 = - ((float) (d0 + 65.0D));
            sunSize = -f8;
            tesselator.startDrawingQuads ();
            tesselator.setColorRGBA_I (0, 255);
            tesselator.addVertex ((double) (-f8), (double) f9, (double) f8);
            tesselator.addVertex ((double) f8, (double) f9, (double) f8);
            tesselator.addVertex ((double) f8, (double) sunSize, (double) f8);
            tesselator.addVertex ((double) (-f8), (double) sunSize, (double) f8);
            tesselator.addVertex ((double) (-f8), (double) sunSize, (double) (-f8));
            tesselator.addVertex ((double) f8, (double) sunSize, (double) (-f8));
            tesselator.addVertex ((double) f8, (double) f9, (double) (-f8));
            tesselator.addVertex ((double) (-f8), (double) f9, (double) (-f8));
            tesselator.addVertex ((double) f8, (double) sunSize, (double) (-f8));
            tesselator.addVertex ((double) f8, (double) sunSize, (double) f8);
            tesselator.addVertex ((double) f8, (double) f9, (double) f8);
            tesselator.addVertex ((double) f8, (double) f9, (double) (-f8));
            tesselator.addVertex ((double) (-f8), (double) f9, (double) (-f8));
            tesselator.addVertex ((double) (-f8), (double) f9, (double) f8);
            tesselator.addVertex ((double) (-f8), (double) sunSize, (double) f8);
            tesselator.addVertex ((double) (-f8), (double) sunSize, (double) (-f8));
            tesselator.addVertex ((double) (-f8), (double) sunSize, (double) (-f8));
            tesselator.addVertex ((double) (-f8), (double) sunSize, (double) f8);
            tesselator.addVertex ((double) f8, (double) sunSize, (double) f8);
            tesselator.addVertex ((double) f8, (double) sunSize, (double) (-f8));
            tesselator.draw ();
        }

        if (world.provider.isSkyColored ())
        {
            GL11.glColor3d (skyColour.xCoord * 0.2F + 0.04F, skyColour.yCoord * 0.2F + 0.04F,
                            skyColour.zCoord * 0.6F + 0.1F);
        }
        else
        {
            GL11.glColor3d (skyColour.xCoord, skyColour.yCoord, skyColour.zCoord);
        }

        GL11.glPushMatrix ();
        GL11.glTranslatef (0.0F, - ((float) (d0 - 16.0D)), 0.0F);
        GL11.glCallList (glSkyList2);
        GL11.glPopMatrix ();
        GL11.glEnable (GL11.GL_TEXTURE_2D);
        GL11.glDepthMask (true);
    }
}
