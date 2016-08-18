package startrekmod.graphics.model;

import net.minecraft.client.model.*;

public class ModelPlanet extends ModelBase
{
	ModelRenderer planet;

	public ModelPlanet()
	{
		planet = new ModelRenderer(this, 0, 0);
		planet.addBox(-3, -3, -3, 6, 6, 6);
		planet.setRotationPoint(0, 0, 0);
		planet.setTextureSize(256, 128);
	}

	public void render(float scale)
	{
		planet.render(scale);
	}
}
