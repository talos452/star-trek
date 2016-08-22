package startrekmod.graphics.render;

import startrekmod.graphics.model.ModelPhaserDrill;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPhaserDrill extends Render
{
	ModelPhaserDrill model;

	public RenderPhaserDrill()
	{
		super();
		model = new ModelPhaserDrill();
	}

	@Override
	public void doRender(Entity entity, double translationX, double translationY, double translationZ, float p_76986_8_, float p_76986_9_)
	{
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(entity));
		GL11.glTranslated(translationX, translationY + 3, translationZ);
		GL11.glScaled(1, 1, 1);
		GL11.glRotated(entity.rotationYaw, 0, -1, 0);
		GL11.glRotated(180, 0, 0, 1);
		model.render(.125F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_)
	{
		return new ResourceLocation("startrekmod:textures/entity/phaser_cannon.png");
	}
}
