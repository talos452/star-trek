package startrekmod.graphics.render;

import startrekmod.graphics.model.STModel;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public abstract class STRender extends Render
{
	String location;
	STModel model;

	public STRender(String location)
	{
		this.location = "startrekmod:textures/entity/" + location + ".png";
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return new ResourceLocation(location);
	}
}
