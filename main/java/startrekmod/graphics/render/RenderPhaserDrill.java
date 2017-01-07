package startrekmod.graphics.render;

import startrekmod.graphics.model.ModelPhaserDrill;

import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class RenderPhaserDrill extends STRender
{
    ModelPhaserDrill model;

    public RenderPhaserDrill ()
    {
        super ("phaser_cannon");
        model = new ModelPhaserDrill ();
    }

    @Override
    void render (Entity entity, double translationX, double translationY, double translationZ, float yaw, float pitch)
    {
        GL11.glRotated (180, 0, 0, 1);
        GL11.glTranslated (0, -3, 0);
        model.render (.125F);
    }
}
