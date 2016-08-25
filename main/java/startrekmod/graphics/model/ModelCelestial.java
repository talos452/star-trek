package startrekmod.graphics.model;

import net.minecraft.client.model.ModelRenderer;

public class ModelCelestial extends STModel
{
	public ModelCelestial()
	{
		textureWidth = 256;
		textureHeight = 128;
		ModelRenderer planet = new ModelRenderer(this, 0, 0);

		planet.addBox(-32F, -32F, -32F, 64, 64, 64);
		planet.setRotationPoint(0, 0, 0);
	}
}
