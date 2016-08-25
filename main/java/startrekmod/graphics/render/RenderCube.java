package startrekmod.graphics.render;

import startrekmod.graphics.model.ModelCube;

import net.minecraft.entity.Entity;

public class RenderCube extends STRender
{
	public RenderCube ()
	{
		super ("template");
		model = new ModelCube ();
	}

	@Override
	void render (Entity entity, double translationX, double translationY, double translationZ, float yaw, float pitch)
	{
		model.render (.0625F);
	}
}
