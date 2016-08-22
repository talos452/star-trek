package startrekmod.graphics.render;

import startrekmod.entity.EntityPlanet;
import startrekmod.graphics.model.ModelPlanet;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPlanet extends STRender
{
	public RenderPlanet()
	{
		super(null);
		model = new ModelPlanet();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		String name = ((EntityPlanet)entity).name;

		if (name == null)
			name = "earth";

		return new ResourceLocation("startrekmod:textures/entity/" + name + ".png");
	}

	@Override
	void render(Entity entity, double translationX, double translationY, double translationZ, float yaw, float pitch)
	{
		GL11.glTranslated(0, -3, 0);
		model.render(.09375F);
	}
}
