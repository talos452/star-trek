package startrekmod.graphics.render;

import startrekmod.entity.EntityPlanet;
import startrekmod.graphics.model.ModelPlanet;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPlanet extends Render
{
	ModelPlanet model;

	public RenderPlanet()
	{
		model = new ModelPlanet();
	}

	@Override
	public void doRender(Entity entity, double translationX, double translationY, double translationZ, float p_76986_8_, float p_76986_9_)
	{
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(entity));
		GL11.glTranslated(translationX, translationY, translationZ);
		GL11.glScaled(1, 1, 1);
		GL11.glRotated(entity.rotationYaw, 0, -1, 0);
		model.render(1F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation("startrekmod:textures/entity/" + ((EntityPlanet)entity).name + ".png");
	}
}
