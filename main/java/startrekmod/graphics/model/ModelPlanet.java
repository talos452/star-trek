package startrekmod.graphics.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelPlanet extends STModel
{
	public ModelPlanet()
	{
		ModelRenderer planet = new ModelRenderer(this, 0, 0);

		addRenderers(planet);

		planet.addBox(-3, -3, -3, 6, 6, 6);
		planet.setRotationPoint(0, 0, 0);
		planet.setTextureSize(256, 128);
		planet.mirror = true;
	}
}
