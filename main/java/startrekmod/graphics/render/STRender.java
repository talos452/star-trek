package startrekmod.graphics.render;

import startrekmod.graphics.model.STModel;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public abstract class STRender extends Render
{
	String location;
	STModel model;

	public STRender(String location)
	{
		this.location = "startrekmod:textures/entity/" + location + ".png";
	}

	@Override
	public void doRender(Entity entity, double translationX, double translationY, double translationZ, float yaw, float pitch)
	{
		GL11.glPushMatrix();
		bindTexture(getEntityTexture(entity));
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glTranslated(translationX, translationY, translationZ);
		GL11.glRotated(entity.rotationYaw, 0, -1, 0);
		GL11.glRotated(entity.rotationPitch + 180, 1, 0, 0);
		render(entity, translationX, translationY, translationZ, entity.rotationYaw, entity.rotationPitch);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(location);
	}

	abstract void render(Entity entity, double translationX, double translationY, double translationZ, float yaw, float pitch);
}
